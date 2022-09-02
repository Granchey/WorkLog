package modules;

import auth.Keys;
import core.WLConfiguration;
import dagger.Module;
import dagger.Provides;
import org.checkerframework.checker.signature.qual.PrimitiveType;
import services.*;
//import services.LoginService;
//import services.LoginServiceImpl;

import javax.inject.Singleton;
import java.util.Objects;

@Module
public class MainModule {

    private final WLConfiguration config;

    private final Keys keys;

    public MainModule(WLConfiguration config, Keys keys) {
        this.config = Objects.requireNonNull(config);
        this.keys = keys;
    }

    @Singleton
    @Provides
    EmployeeService provideEmployeeService(EmployeeServiceImpl employeeService) {
        return employeeService;
    }

    @Singleton
    @Provides
    EmployeeWorkLogService provideEmployeeWorkLogService(EmployeeWorkLogServiceImpl employeeWorkLogService) {
        return employeeWorkLogService;
    }

    @Singleton
    @Provides
    JwtBuilderService provideJwtBuilderService(JwtBuilderServiceImpl jwtBuilderService){
        return jwtBuilderService;
    }

    @Singleton
    @Provides
    JwtReaderService provideJwtReaderService(JwtReaderServiceImpl jwtReaderService){
        return jwtReaderService;
    }

    @Provides
    @Singleton
    LoginService provideLoginService(LoginServiceImpl loginService){
        return loginService;
    }

    @Provides
    Keys provideKeys() {
        return keys;
    }

    @Singleton
    @Provides
    UserService provideUserService(UserServiceImpl userService){
        return userService;
    }

    @Provides
    @Singleton
    TestService provideTestService(TestServiceImpl testService){
        return testService;
    }

}