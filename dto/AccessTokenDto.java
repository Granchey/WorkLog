package dto;

import auth.Role;

public class AccessTokenDto {

    private String authToken;

    private Role role = Role.REGULAR;

    public AccessTokenDto(String authToken, Role role) {
        this.authToken = authToken;
        this.role = role;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
