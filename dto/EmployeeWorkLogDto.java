package dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class EmployeeWorkLogDto  {
    @NotNull
    public Integer employeeWorkLogId;

    @NotNull
    public Integer employeeId;

    @NotNull
    public LocalDateTime createdOn;

    @NotNull
    public LocalDateTime updatedOn;

    @NotNull
    public String description;

    @NotNull
    public Integer minutesWorked;


    public EmployeeWorkLogDto() {

    }

    public EmployeeWorkLogDto(Integer employeeWorkLogId, Integer employeeId, LocalDateTime createdOn, LocalDateTime updatedOn, String description, Integer minutesWorked) {
        this.employeeWorkLogId = employeeWorkLogId;
        this.employeeId = employeeId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.description = description;
        this.minutesWorked = minutesWorked;
    }
}
