package auth;

import org.jose4j.keys.HmacKey;

import javax.inject.Inject;

public class Keys {

    private HmacKey signatureKey;

    @Inject
    public Keys() {
    }

    public HmacKey getSignatureKey() {
        return signatureKey;
    }

    public void setSignatureKey(HmacKey signatureKey) {
        this.signatureKey = signatureKey;
    }
}
