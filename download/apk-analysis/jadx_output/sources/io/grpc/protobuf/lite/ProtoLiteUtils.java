package io.grpc.protobuf.lite;

import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;

/* loaded from: classes6.dex */
public final class ProtoLiteUtils {
    private static final int BUF_SIZE = 8192;
    static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
    static volatile ExtensionRegistryLite globalRegistry = ExtensionRegistryLite.getEmptyRegistry();

    public static void setExtensionRegistry(ExtensionRegistryLite extensionRegistryLite) {
        globalRegistry = (ExtensionRegistryLite) Preconditions.checkNotNull(extensionRegistryLite, "newRegistry");
    }

    public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshaller(T t) {
        return new MessageMarshaller(t, -1);
    }

    public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshallerWithRecursionLimit(T t, int i) {
        return new MessageMarshaller(t, i);
    }

    public static <T extends MessageLite> Metadata.BinaryMarshaller<T> metadataMarshaller(T t) {
        return new MetadataMarshaller(t);
    }

    static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream, "inputStream cannot be null!");
        Preconditions.checkNotNull(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    private ProtoLiteUtils() {
    }

    private static final class MessageMarshaller<T extends MessageLite> implements MethodDescriptor.PrototypeMarshaller<T> {
        private static final ThreadLocal<Reference<byte[]>> bufs = new ThreadLocal<>();
        private final T defaultInstance;
        private final Parser<T> parser;
        private final int recursionLimit;

        MessageMarshaller(T t, int i) {
            this.defaultInstance = (T) Preconditions.checkNotNull(t, "defaultInstance cannot be null");
            this.parser = (Parser<T>) t.getParserForType();
            this.recursionLimit = i;
        }

        @Override // io.grpc.MethodDescriptor.ReflectableMarshaller
        public Class<T> getMessageClass() {
            return (Class<T>) this.defaultInstance.getClass();
        }

        @Override // io.grpc.MethodDescriptor.PrototypeMarshaller
        public T getMessagePrototype() {
            return this.defaultInstance;
        }

        @Override // io.grpc.MethodDescriptor.Marshaller
        public InputStream stream(T t) {
            return new ProtoInputStream(t, this.parser);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
        @Override // io.grpc.MethodDescriptor.Marshaller
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public T parse(java.io.InputStream r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof io.grpc.protobuf.lite.ProtoInputStream
                if (r0 == 0) goto L17
                r0 = r6
                io.grpc.protobuf.lite.ProtoInputStream r0 = (io.grpc.protobuf.lite.ProtoInputStream) r0
                com.google.protobuf.Parser r0 = r0.parser()
                com.google.protobuf.Parser<T extends com.google.protobuf.MessageLite> r1 = r5.parser
                if (r0 != r1) goto L17
                r0 = r6
                io.grpc.protobuf.lite.ProtoInputStream r0 = (io.grpc.protobuf.lite.ProtoInputStream) r0     // Catch: java.lang.IllegalStateException -> L17
                com.google.protobuf.MessageLite r6 = r0.message()     // Catch: java.lang.IllegalStateException -> L17
                return r6
            L17:
                boolean r0 = r6 instanceof io.grpc.KnownLength     // Catch: java.io.IOException -> Lac
                if (r0 == 0) goto L81
                int r0 = r6.available()     // Catch: java.io.IOException -> Lac
                if (r0 <= 0) goto L7c
                r1 = 4194304(0x400000, float:5.877472E-39)
                if (r0 > r1) goto L7c
                java.lang.ThreadLocal<java.lang.ref.Reference<byte[]>> r1 = io.grpc.protobuf.lite.ProtoLiteUtils.MessageMarshaller.bufs     // Catch: java.io.IOException -> Lac
                java.lang.Object r2 = r1.get()     // Catch: java.io.IOException -> Lac
                java.lang.ref.Reference r2 = (java.lang.ref.Reference) r2     // Catch: java.io.IOException -> Lac
                if (r2 == 0) goto L3a
                java.lang.Object r2 = r2.get()     // Catch: java.io.IOException -> Lac
                byte[] r2 = (byte[]) r2     // Catch: java.io.IOException -> Lac
                if (r2 == 0) goto L3a
                int r3 = r2.length     // Catch: java.io.IOException -> Lac
                if (r3 >= r0) goto L44
            L3a:
                byte[] r2 = new byte[r0]     // Catch: java.io.IOException -> Lac
                java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch: java.io.IOException -> Lac
                r3.<init>(r2)     // Catch: java.io.IOException -> Lac
                r1.set(r3)     // Catch: java.io.IOException -> Lac
            L44:
                r1 = r0
            L45:
                if (r1 <= 0) goto L53
                int r3 = r0 - r1
                int r3 = r6.read(r2, r3, r1)     // Catch: java.io.IOException -> Lac
                r4 = -1
                if (r3 != r4) goto L51
                goto L53
            L51:
                int r1 = r1 - r3
                goto L45
            L53:
                if (r1 != 0) goto L5b
                r1 = 0
                com.google.protobuf.CodedInputStream r0 = com.google.protobuf.CodedInputStream.newInstance(r2, r1, r0)     // Catch: java.io.IOException -> Lac
                goto L82
            L5b:
                int r6 = r0 - r1
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.io.IOException -> Lac
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lac
                r2.<init>()     // Catch: java.io.IOException -> Lac
                java.lang.String r3 = "size inaccurate: "
                r2.append(r3)     // Catch: java.io.IOException -> Lac
                r2.append(r0)     // Catch: java.io.IOException -> Lac
                java.lang.String r0 = " != "
                r2.append(r0)     // Catch: java.io.IOException -> Lac
                r2.append(r6)     // Catch: java.io.IOException -> Lac
                java.lang.String r6 = r2.toString()     // Catch: java.io.IOException -> Lac
                r1.<init>(r6)     // Catch: java.io.IOException -> Lac
                throw r1     // Catch: java.io.IOException -> Lac
            L7c:
                if (r0 != 0) goto L81
                T extends com.google.protobuf.MessageLite r6 = r5.defaultInstance     // Catch: java.io.IOException -> Lac
                return r6
            L81:
                r0 = 0
            L82:
                if (r0 != 0) goto L88
                com.google.protobuf.CodedInputStream r0 = com.google.protobuf.CodedInputStream.newInstance(r6)
            L88:
                r6 = 2147483647(0x7fffffff, float:NaN)
                r0.setSizeLimit(r6)
                int r6 = r5.recursionLimit
                if (r6 < 0) goto L95
                r0.setRecursionLimit(r6)
            L95:
                com.google.protobuf.MessageLite r6 = r5.parseFrom(r0)     // Catch: com.google.protobuf.InvalidProtocolBufferException -> L9a
                return r6
            L9a:
                r6 = move-exception
                io.grpc.Status r0 = io.grpc.Status.INTERNAL
                java.lang.String r1 = "Invalid protobuf byte sequence"
                io.grpc.Status r0 = r0.withDescription(r1)
                io.grpc.Status r6 = r0.withCause(r6)
                io.grpc.StatusRuntimeException r6 = r6.asRuntimeException()
                throw r6
            Lac:
                r6 = move-exception
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r0.<init>(r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.protobuf.lite.ProtoLiteUtils.MessageMarshaller.parse(java.io.InputStream):com.google.protobuf.MessageLite");
        }

        private T parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
            T parseFrom = this.parser.parseFrom(codedInputStream, ProtoLiteUtils.globalRegistry);
            try {
                codedInputStream.checkLastTagWas(0);
                return parseFrom;
            } catch (InvalidProtocolBufferException e) {
                e.setUnfinishedMessage(parseFrom);
                throw e;
            }
        }
    }

    private static final class MetadataMarshaller<T extends MessageLite> implements Metadata.BinaryMarshaller<T> {
        private final T defaultInstance;

        MetadataMarshaller(T t) {
            this.defaultInstance = t;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(T t) {
            return t.toByteArray();
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public T parseBytes(byte[] bArr) {
            try {
                return (T) this.defaultInstance.getParserForType().parseFrom(bArr, ProtoLiteUtils.globalRegistry);
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
