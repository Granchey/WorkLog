package models;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class EmployeeWorkLog {
    private Integer employeeWorkLogId;
    private Integer employeeId;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
    private String description;
    private Integer minutesWorked;

    @ConstructorProperties({"EMPLOYEE_WORK_LOG_ID", "EMPLOYEE_ID", "CREATED_ON", "UPDATED_ON","DESCRIPTION", "MINUTES_WORKED"})
    public EmployeeWorkLog(Integer employeeWorkLogId, Integer employeeId, LocalDateTime createdOn, LocalDateTime updateOn, String description, Integer minutesWorked) {
        this.employeeWorkLogId = employeeWorkLogId;
        this.employeeId = employeeId;
        this.createdOn = createdOn;
        this.updateOn = updateOn;
        this.description = description;
        this.minutesWorked = minutesWorked;
    }

    public EmployeeWorkLog(){

    }

    public Integer getEmployeeWorkLogId() {
        return employeeWorkLogId;
    }

    public void setEmployeeWorkLogId(Integer employeeWorkLogId) {
        this.employeeWorkLogId = employeeWorkLogId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(LocalDateTime updateOn) {
        this.updateOn = updateOn;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Integer getMinutesWorked() {
        return minutesWorked;
    }

    public void setMinutesWorked(Integer minutesWorked) {
        this.minutesWorked = minutesWorked;
    }
}
