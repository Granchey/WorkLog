package services;

import models.User;
import org.jose4j.lang.JoseException;

public interface JwtBuilderService {

    String createJwt(User user) throws JoseException;
}
