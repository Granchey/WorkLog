package auth;

import dao.UserDao;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import models.User;
import org.apache.commons.lang3.StringUtils;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.JwtReaderService;


import javax.inject.Inject;
import java.util.Optional;

public class WlAuthenticator implements Authenticator<JwtContext, User> {

    private static final Logger LOG = LoggerFactory.getLogger(WlAuthenticator.class);

    UserDao userDao;

    JwtReaderService jwtReaderService;

    @Inject
    public WlAuthenticator(UserDao userDao, JwtReaderService jwtReaderService) {
        this.userDao = userDao;
        this.jwtReaderService = jwtReaderService;
    }

    @Override
    public Optional<User> authenticate(JwtContext context) throws AuthenticationException {
      String email = "";
      try{
          email = jwtReaderService.getEmailFromJwt(context.getJwt());
          if(StringUtils.isBlank(email)){
              LOG.error("Username is black");
              return Optional.empty();
          }
          else {
              User user = userDao.findUserByEmail(email);
              return Optional.ofNullable(user);
          }
      } catch (InvalidJwtException e) {
          throw new RuntimeException(e);
      }

    }
}
