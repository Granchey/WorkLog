package services;

import auth.Keys;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;

import javax.inject.Inject;

public class JwtReaderServiceImpl implements JwtReaderService{

    private final Keys keys;

    @Inject
    public JwtReaderServiceImpl(Keys keys) {
        this.keys = keys;
    }

    @Override
    public String getEmailFromJwt(String token) throws InvalidJwtException {
        JwtConsumer jwtConsumer =  new JwtConsumerBuilder()
                .setEvaluationTime(NumericDate.now())
                .setVerificationKey(keys.getSignatureKey())
                .build();

        JwtClaims jwtClaims = jwtConsumer.processToClaims(token);

        return (String) jwtClaims.getClaimValue("email");

    }
}
