package org.bouncycastle.pqc.crypto.lms;

/* loaded from: classes7.dex */
public interface LMSContextBasedVerifier {
    LMSContext generateLMSContext(byte[] bArr);

    boolean verify(LMSContext lMSContext);
}
