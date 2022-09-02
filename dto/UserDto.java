package dto;

import javax.validation.constraints.NotNull;

public class UserDto{

    @NotNull
    public Integer id;

    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public String email;

    @NotNull
    public String password;

    @NotNull
    public String role;

    public UserDto(Integer id, String firstName, String lastName, String email, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserDto() {
    }
}
