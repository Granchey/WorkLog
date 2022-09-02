package services;

import dao.UserDao;
import dto.UserDto;

import javax.inject.Inject;

public class UserServiceImpl implements UserService{

    UserDao userDao;

    @Inject
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        Integer user = userDao.insert(userDto.id,userDto.firstName,userDto.lastName,userDto.email,userDto.password,userDto.role );
        userDto.id = user;
        return userDto;
    }
}
