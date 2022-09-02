package auth;

import io.dropwizard.auth.Authorizer;
import models.User;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;

public class UserRoleAuthorizer implements Authorizer<User> {

    private static final Logger LOG = LoggerFactory.getLogger(UserRoleAuthorizer.class);

    @Inject
    public UserRoleAuthorizer() {
    }

    @Override
    public boolean authorize(User user, String role) {
        if(user == null){
            LOG.error("User is blank");
            return false;
        } else if(user.getRole() == null){
            LOG.error("Unable to authorize since role is null");
            return false;
        } else if (StringUtils.isBlank(role)) {
            LOG.error("Unable to authorize since role is blank");
            return false;
        }

        Role roleToEnum = null;
        try {
            roleToEnum = Role.valueOf(role);

        }catch (IllegalArgumentException iae){
            LOG.error("Unable to authorize since role " + role + "is not a valid role");
            return false;
        }
        return user.getRole().equals(role);
    }
}
