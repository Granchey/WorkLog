package services;


import dto.LoginUserDto;

import javax.ws.rs.core.Response;

public interface LoginService {
    Response login(LoginUserDto logInUserDto);

}
