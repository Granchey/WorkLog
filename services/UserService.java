package services;

import dao.UserDao;
import dto.UserDto;

public interface UserService {

    UserDto addUser(UserDto userDto);
}
