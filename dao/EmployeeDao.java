package dao;

import models.Employee;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface EmployeeDao {

    @SqlUpdate("INSERT INTO employee (employee_id,first_name , last_name, email) VALUES (:id,:first_name, :last_name, :email)")
    Integer insert(@Bind("id") int id, @Bind("first_name") String first_name, @Bind("last_name") String last_name, @Bind("email") String email);

    @SqlQuery("UPDATE employee SET  first_name= :first_name,last_name= :last_name,email= :email where employee_id=:id")
    @RegisterConstructorMapper(Employee.class)
    Employee updateEmployeeById(@Bind("id") Integer id, @Bind("first_name") String first_name, @Bind("last_name") String last_name, @Bind("email") String email);

    @SqlQuery("SELECT * FROM employee WHERE employee_id = :employeeId")
    @RegisterConstructorMapper(Employee.class)
    Employee findEmployeeById(@Bind("employeeId") Integer employeeId);

    @SqlUpdate("DELETE FROM employee WHERE employee_id = :employee_id")
    void deleteEmployeeById(@Bind("employee_id") Integer employeeId);
}