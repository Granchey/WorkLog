package adapters;

import dto.EmployeeWorkLogDto;
import models.EmployeeWorkLog;

import javax.inject.Inject;

public class EmployeeWorkLogAdapter {

    @Inject
    public EmployeeWorkLogAdapter() {
    }

    public EmployeeWorkLogDto convertToDto(EmployeeWorkLog employeeWorkLog) {

        EmployeeWorkLogDto employeeWorkLogDto = new EmployeeWorkLogDto();

        employeeWorkLogDto.employeeWorkLogId = employeeWorkLog.getEmployeeWorkLogId();

        employeeWorkLogDto.employeeId = employeeWorkLog.getEmployeeId();

        employeeWorkLogDto.createdOn = employeeWorkLog.getCreatedOn();

        employeeWorkLogDto.updatedOn = employeeWorkLog.getUpdateOn();

        employeeWorkLogDto.description = employeeWorkLog.getDescription();

        employeeWorkLogDto.minutesWorked = employeeWorkLog.getMinutesWorked();

        return employeeWorkLogDto;
    }

    //This method is not used in the current version of the project but it might in the future
    public EmployeeWorkLog convertToEmployeeWorkLog(EmployeeWorkLogDto employeeWorkLogDto) {

        EmployeeWorkLog employeeWorkLog = new EmployeeWorkLog();

        employeeWorkLog.setEmployeeWorkLogId(employeeWorkLogDto.employeeWorkLogId);

        employeeWorkLog.setEmployeeId(employeeWorkLogDto.employeeId);

        employeeWorkLog.setCreatedOn(employeeWorkLogDto.updatedOn);

        employeeWorkLog.setUpdateOn(employeeWorkLogDto.createdOn);

        employeeWorkLog.setDescription(employeeWorkLogDto.description);

        employeeWorkLog.setMinutesWorked(employeeWorkLogDto.minutesWorked);

        return employeeWorkLog;
    }
}
