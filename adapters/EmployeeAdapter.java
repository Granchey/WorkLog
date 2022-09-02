package adapters;

import dto.EmployeeDto;
import models.Employee;

import javax.inject.Inject;

public class EmployeeAdapter {

    @Inject
    public EmployeeAdapter() {
    }

    public EmployeeDto convertToDto(Employee employee) {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.id = employee.getEmployeeId();

        employeeDto.firstName = employee.getFirstName();

        employeeDto.lastName = employee.getLastName();

        employeeDto.email = employee.getEmail();

        return employeeDto;
    }

    //This method is not used in the current version of the project but it might in the future
    public Employee convertToEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setEmployeeId(employeeDto.id);

        employee.setFirstName(employeeDto.firstName);

        employee.setLastName(employeeDto.lastName);

        employee.setEmail(employeeDto.email);

        return employee;
    }

}
