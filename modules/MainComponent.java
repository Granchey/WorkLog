package modules;

import Resources.*;
import adapters.EmployeeAdapter;
import adapters.EmployeeWorkLogAdapter;
import adapters.UserAdapter;
import auth.UserRoleAuthorizer;
import auth.WlAuthenticator;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {JdbiModule.class, MainModule.class})
public interface MainComponent {
    EmployeeResource provideEmployeeResource();

    EmployeeWorkLogResource provideEmployeeWorkLogResource();

    EmployeeAdapter provideEmployeeAdapter();

    EmployeeWorkLogAdapter provideEmployeeWorkLogAdapter();

    UserAdapter provideUserAdapter();

    LoginResource provideLoginResource();

    WlAuthenticator provideWlAuthenticator();

    UserRoleAuthorizer provideUserRoleAuthorizer();

    UserResource provideUserResource();



}