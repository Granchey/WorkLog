package adapters;

import dto.UserDto;
import models.User;

import javax.inject.Inject;

public class UserAdapter {

    @Inject
    public UserAdapter(){

    }

    public UserDto convertToDto(User user){

        UserDto userDto = new UserDto();

        userDto.id = user.getId();

     //   userDto.firstName = user.getFirstName();

        userDto.lastName = user.getLastName();

        userDto.email = user.getEmail();

        userDto.password = user.getPassword();

        userDto.role =user.getRole();

        return userDto;
    }

    public User convertToUser(UserDto userDto){

        User user = new User();

       user.setId(userDto.id);

       user.setFirstName(userDto.firstName);

       user.setLastName(userDto.email);

       user.setEmail(userDto.email);

       user.setPassword(user.getPassword());

       user.setRole(user.getRole());

        return user;
    }
}
