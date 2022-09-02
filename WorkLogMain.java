import auth.JwtAuthFilter;
import auth.Keys;
import core.WLConfiguration;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import models.User;
import modules.DaggerMainComponent;
import modules.JdbiModule;
import modules.MainComponent;
import modules.MainModule;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;


public class WorkLogMain extends Application<WLConfiguration> {


    public static void main(String[] args) throws Exception {
        new WorkLogMain().run(args);
    }

    @Override
    public void run(WLConfiguration wlConfiguration, Environment environment) throws Exception {

        Keys keys = createKeys(wlConfiguration);

        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(wlConfiguration, keys)).jdbiModule(new JdbiModule(WLConfiguration.getDataSourceFactory(), environment)).build();
        environment.jersey().register(component.provideEmployeeResource());
        environment.jersey().register(component.provideEmployeeWorkLogResource());
        environment.jersey().register(component.provideLoginResource());
        environment.jersey().register(component.provideUserResource());

        registerAuthentication(environment, component,keys,wlConfiguration);
  }

    @Override
    public void initialize(Bootstrap<WLConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<WLConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(WLConfiguration configuration) {
                return WLConfiguration.getDataSourceFactory();
            }
        });
    }

    public HmacKey secretKey(String signatureSecret) {
        return new HmacKey(signatureSecret.getBytes());
    }

    public Keys createKeys(WLConfiguration configuration) {
        Keys keys = new Keys();
        HmacKey signatureKey = secretKey(configuration.getJwtSecretSignature());
        keys.setSignatureKey(signatureKey);
        return keys;
    }

    private void registerAuthentication(
            Environment env,
            MainComponent component,
            Keys keys,
            WLConfiguration configuration) {

        final JwtConsumer consumer =
                new JwtConsumerBuilder()
                        .setRequireExpirationTime()
                        .setAllowedClockSkewInSeconds(30)
                        .setRequireSubject()
                        .setVerificationKey(keys.getSignatureKey())
                        .setRelaxVerificationKeyValidation()
                        .build();

        env.jersey().register(RolesAllowedDynamicFeature.class);
        final JwtAuthFilter<User> tokenAuthFilter =
                new JwtAuthFilter.Builder<User>()
                        .setJwtConsumer(consumer)
                        .setRealm("realm")
                        .setPrefix("Bearer")
                        .setAuthorizer(component.provideUserRoleAuthorizer())
                        .setAuthenticator(component.provideWlAuthenticator())
                        .buildAuthFilter();

        env.jersey().register(new AuthDynamicFeature(tokenAuthFilter));
        env.jersey().register(new AuthValueFactoryProvider.Binder<User>(User.class));
    }
}
