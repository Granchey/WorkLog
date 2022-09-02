package dao;

import dto.UserDto;
import models.User;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface UserDao {

    @SqlQuery("SELECT * FROM users WHERE email = :email")
    @RegisterConstructorMapper(User.class)
    User findUserByEmail(@Bind("email") String email);

    @SqlUpdate("INSERT INTO USERS (ID , FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, ROLE) VALUES (:id, :first_name, :last_name, :email, :password, :role")
    Integer insert(@Bind("id") Integer id, @Bind("first_name") String first_name,@Bind("last_name") String last_name, @Bind("email") String email, @Bind("password")String password, @Bind("role")String role);

}
