package org.bouncycastle.crypto.agreement.jpake;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes7.dex */
public class JPAKERound2Payload {

    /* renamed from: a, reason: collision with root package name */
    private final BigInteger f229a;
    private final BigInteger[] knowledgeProofForX2s;
    private final String participantId;

    public JPAKERound2Payload(String str, BigInteger bigInteger, BigInteger[] bigIntegerArr) {
        JPAKEUtil.validateNotNull(str, "participantId");
        JPAKEUtil.validateNotNull(bigInteger, CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY);
        JPAKEUtil.validateNotNull(bigIntegerArr, "knowledgeProofForX2s");
        this.participantId = str;
        this.f229a = bigInteger;
        this.knowledgeProofForX2s = Arrays.copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public BigInteger getA() {
        return this.f229a;
    }

    public BigInteger[] getKnowledgeProofForX2s() {
        BigInteger[] bigIntegerArr = this.knowledgeProofForX2s;
        return Arrays.copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
