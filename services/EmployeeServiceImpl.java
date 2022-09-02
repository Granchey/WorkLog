package services;

import adapters.EmployeeAdapter;
import dao.EmployeeDao;
import dto.EmployeeDto;
import models.Employee;

import javax.inject.Inject;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployeeAdapter employeeAdapter;


    @Inject
    public EmployeeServiceImpl(EmployeeDao employeeDao, EmployeeAdapter employeeAdapter) {
        this.employeeDao = employeeDao;
        this.employeeAdapter = employeeAdapter;
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        employeeDao.updateEmployeeById(employeeDto.id, employeeDto.firstName, employeeDto.lastName, employeeDto.email);
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Integer employeeId = employeeDao.insert(employeeDto.id, employeeDto.firstName, employeeDto.lastName, employeeDto.email);
        employeeDto.id = employeeId;
        return employeeDto;
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteEmployeeById(employeeId);
    }

    @Override
    public EmployeeDto findEmployeeById(Integer employeeId) {
        Employee employee = employeeDao.findEmployeeById(employeeId);
        EmployeeDto employeeDto = employeeAdapter.convertToDto(employee);
        return employeeDto;
    }
}