package services;

import auth.Keys;
import models.User;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;

import javax.inject.Inject;

public class JwtBuilderServiceImpl implements JwtBuilderService{

    private final Keys keys;

    @Inject
    public JwtBuilderServiceImpl(Keys keys) {
        this.keys = keys;
    }

    @Override
    public String createJwt(User user) throws JoseException {

        JwtClaims claims = new JwtClaims();

        claims.setSubject(user.getEmail());
        claims.setExpirationTimeMinutesInTheFuture(30);//TODO: make this YAML config
        claims.setIssuedAtToNow();
        claims.setClaim("email", user.getEmail());
        claims.setClaim("role", user.getRole());


        JsonWebSignature jws = new JsonWebSignature();

        jws.setPayload(claims.toJson());
        jws.setKey(keys.getSignatureKey());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setHeader("typ", "JWT");

        String jwt = jws.getCompactSerialization();
        return jwt;
    }
}
