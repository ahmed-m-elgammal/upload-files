package io.jsonwebtoken;

/* loaded from: classes6.dex */
public interface Jws<B> extends Jwt<JwsHeader, B> {
    String getSignature();
}
