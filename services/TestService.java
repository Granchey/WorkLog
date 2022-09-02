package services;

import dto.UserDto;
import models.User;

public interface TestService {

    User getUserByEmail(String email);

}
