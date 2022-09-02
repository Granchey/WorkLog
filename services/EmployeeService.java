package services;

import dto.EmployeeDto;

public interface EmployeeService {

    void updateEmployee(EmployeeDto employeeDto);

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    void deleteEmployee(Integer employeeId);

    EmployeeDto findEmployeeById(Integer employeeId);
}