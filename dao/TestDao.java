package dao;


import models.User;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import javax.inject.Singleton;

public interface TestDao {

    @SqlQuery("SELECT * FROM USERS WHERE email=:email")
    @RegisterConstructorMapper(User.class)
    User getUser(@Bind("email") String email);
}
