package io.jsonwebtoken;

/* loaded from: classes6.dex */
public interface CompressionCodecResolver {
    CompressionCodec resolveCompressionCodec(Header header) throws CompressionException;
}
