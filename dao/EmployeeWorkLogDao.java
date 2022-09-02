package dao;

import models.EmployeeWorkLog;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;


public interface EmployeeWorkLogDao {

    @SqlUpdate("INSERT INTO employee_work_log (employee_work_log_id, employee_id) VALUES (:employeeWorkLogId, :employeeId)")
    Integer insert(@Bind("employeeWorkLogId") Integer employeeWorkLogId, @Bind("employeeId") Integer employeeId);

    @SqlQuery("UPDATE employee_work_log SET description = :description, minutes_worked = :minutesWorked where employee_work_log_id = :employeeWorkLogId")
    @RegisterConstructorMapper(EmployeeWorkLog.class)
    EmployeeWorkLog updateEmployeeWorkLogById(@Bind("employeeWorkLogId") Integer employeeWorkLogId, @Bind("description") String description, @Bind("minutesWorked") Integer minutesWorked);

    @SqlQuery("SELECT * FROM employee_work_log WHERE employee_work_log_id = :employeeWorkLogId")
    @RegisterConstructorMapper(EmployeeWorkLog.class)
    EmployeeWorkLog findEmployeeWorkLogById(@Bind("employeeWorkLogId") Integer employeeWorkLogId);

    @SqlUpdate("DELETE FROM employee_work_log WHERE employee_work_log_id = :employeeWorkLogId")
    void deleteEmployeeWorkLog(@Bind("employeeWorkLogId") Integer employeeWorkLogId);
}
