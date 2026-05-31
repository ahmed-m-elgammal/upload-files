package org.bouncycastle.crypto.engines;

/* loaded from: classes7.dex */
public class AESWrapPadEngine extends RFC5649WrapEngine {
    public AESWrapPadEngine() {
        super(new AESEngine());
    }
}
