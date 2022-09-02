package services;

import adapters.EmployeeWorkLogAdapter;
import dao.EmployeeWorkLogDao;
import dto.EmployeeWorkLogDto;
import models.EmployeeWorkLog;

import javax.inject.Inject;

public class EmployeeWorkLogServiceImpl implements EmployeeWorkLogService {
    private EmployeeWorkLogDao employeeWorkLogDao;
    private EmployeeWorkLogAdapter employeeWorkLogAdapter;

    @Inject
    public EmployeeWorkLogServiceImpl(EmployeeWorkLogDao employeeWorkLogDao, EmployeeWorkLogAdapter employeeWorkLogAdapter) {
        this.employeeWorkLogDao = employeeWorkLogDao;
        this.employeeWorkLogAdapter = employeeWorkLogAdapter;
    }

    @Override
    public void updateEmployeeWorkLog(EmployeeWorkLogDto employeeWorkLogDto) {
        employeeWorkLogDao.updateEmployeeWorkLogById(employeeWorkLogDto.employeeWorkLogId, employeeWorkLogDto.description, employeeWorkLogDto.minutesWorked);

    }

    @Override
    public void deleteEmployeeWorkLog(Integer employeeWorkLogId) {
        employeeWorkLogDao.deleteEmployeeWorkLog(employeeWorkLogId);
    }

    @Override
    public EmployeeWorkLogDto addEmployeeWorkLog(EmployeeWorkLogDto employeeWorkLogDto) {
        employeeWorkLogDto.employeeWorkLogId = employeeWorkLogDao.insert(employeeWorkLogDto.employeeWorkLogId, employeeWorkLogDto.employeeId);
        return employeeWorkLogDto;
    }

    @Override
    public EmployeeWorkLogDto findEmployeeWorkLogById(Integer employeeWorkLogId) {
        EmployeeWorkLog employeeWorkLog = employeeWorkLogDao.findEmployeeWorkLogById(employeeWorkLogId);
        EmployeeWorkLogDto employeeWorkLogDto = employeeWorkLogAdapter.convertToDto(employeeWorkLog);
        return employeeWorkLogDto;
    }
}
