package io.grpc.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface ReadableBuffer extends Closeable {

    /* renamed from: io.grpc.internal.ReadableBuffer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$touch(ReadableBuffer _this) {
        }
    }

    byte[] array();

    int arrayOffset();

    boolean byteBufferSupported();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Nullable
    ByteBuffer getByteBuffer();

    boolean hasArray();

    void mark();

    boolean markSupported();

    ReadableBuffer readBytes(int i);

    void readBytes(OutputStream outputStream, int i) throws IOException;

    void readBytes(ByteBuffer byteBuffer);

    void readBytes(byte[] bArr, int i, int i2);

    int readInt();

    int readUnsignedByte();

    int readableBytes();

    void reset();

    void skipBytes(int i);

    void touch();
}
