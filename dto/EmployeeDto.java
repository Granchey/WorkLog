package dto;

import javax.validation.constraints.NotNull;

public class EmployeeDto {
    @NotNull
    public Integer id;

    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public String email;

    public EmployeeDto() {

    }

    public EmployeeDto(Integer id, String firstname, String lastName, String email) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;

    }
}
