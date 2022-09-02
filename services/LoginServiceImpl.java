package services;

import auth.Keys;
import auth.Role;
import dao.UserDao;
import dto.AccessTokenDto;
import dto.LoginUserDto;
import models.User;
import org.jose4j.lang.JoseException;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;

public class LoginServiceImpl implements LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);


    private final UserDao userDao;

    private final JwtBuilderService jwtBuilderService;

    private final Keys keys;

    @Inject
    public LoginServiceImpl(UserDao userDao, JwtBuilderService jwtBuilderService, Keys keys) {
        this.userDao = userDao;
        this.jwtBuilderService = jwtBuilderService;
        this.keys = keys;
    }

    @Override
    public Response login(LoginUserDto logInUserDto) {
        if(logInUserDto == null){
            throw new BadRequestException("Missing Credentials");
        }

        User retUser = userDao.findUserByEmail(logInUserDto.getEmail());
        if(retUser == null){
            LOG.warn("User not found");
            throw new NotFoundException("Invalid username or password");
        }

        String authToken;
        try {
            authToken = jwtBuilderService.createJwt(retUser);
        } catch (JoseException e) {
            LOG.error("Unable to create authToken", e);
            throw new InternalServerErrorException("unable to issue authToken");
        }


            AccessTokenDto accessTokenDto = new AccessTokenDto(authToken, Role.valueOf(retUser.getRole()));
            return Response.ok().entity(accessTokenDto).build();

    }
}
