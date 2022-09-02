package services;

import dto.EmployeeWorkLogDto;

public interface EmployeeWorkLogService {
    void updateEmployeeWorkLog(EmployeeWorkLogDto employeeWorkLogDto);

    void deleteEmployeeWorkLog(Integer employeeWorkLogId);

    EmployeeWorkLogDto addEmployeeWorkLog(EmployeeWorkLogDto employeeWorkLogDto);

    EmployeeWorkLogDto findEmployeeWorkLogById(Integer employeeWorkLogId);
}
