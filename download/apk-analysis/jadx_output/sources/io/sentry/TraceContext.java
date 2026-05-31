package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public final class TraceContext implements JsonUnknown, JsonSerializable {
    private final String environment;
    private final String publicKey;
    private final String release;
    private final SentryId replayId;
    private final String sampleRate;
    private final String sampled;
    private final SentryId traceId;
    private final String transaction;
    private Map<String, Object> unknown;
    private final String userId;
    private final String userSegment;

    public static final class JsonKeys {
        public static final String ENVIRONMENT = "environment";
        public static final String PUBLIC_KEY = "public_key";
        public static final String RELEASE = "release";
        public static final String REPLAY_ID = "replay_id";
        public static final String SAMPLED = "sampled";
        public static final String SAMPLE_RATE = "sample_rate";
        public static final String TRACE_ID = "trace_id";
        public static final String TRANSACTION = "transaction";
        public static final String USER = "user";
        public static final String USER_ID = "user_id";
        public static final String USER_SEGMENT = "user_segment";
    }

    TraceContext(SentryId sentryId, String str) {
        this(sentryId, str, null, null, null, null, null, null, null);
    }

    TraceContext(SentryId sentryId, String str, String str2, String str3, String str4, String str5, String str6, String str7, SentryId sentryId2) {
        this(sentryId, str, str2, str3, str4, null, str5, str6, str7, sentryId2);
    }

    @Deprecated
    TraceContext(SentryId sentryId, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, SentryId sentryId2) {
        this.traceId = sentryId;
        this.publicKey = str;
        this.release = str2;
        this.environment = str3;
        this.userId = str4;
        this.userSegment = str5;
        this.transaction = str6;
        this.sampleRate = str7;
        this.sampled = str8;
        this.replayId = sentryId2;
    }

    private static String getUserId(SentryOptions sentryOptions, User user) {
        if (!sentryOptions.isSendDefaultPii() || user == null) {
            return null;
        }
        return user.getId();
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getRelease() {
        return this.release;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getUserId() {
        return this.userId;
    }

    @Deprecated
    public String getUserSegment() {
        return this.userSegment;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public String getSampleRate() {
        return this.sampleRate;
    }

    public String getSampled() {
        return this.sampled;
    }

    public SentryId getReplayId() {
        return this.replayId;
    }

    @Deprecated
    private static final class TraceContextUser implements JsonUnknown {
        private String id;
        private String segment;
        private Map<String, Object> unknown;

        public static final class JsonKeys {
            public static final String ID = "id";
            public static final String SEGMENT = "segment";
        }

        private TraceContextUser(String str, String str2) {
            this.id = str;
            this.segment = str2;
        }

        public String getId() {
            return this.id;
        }

        @Deprecated
        public String getSegment() {
            return this.segment;
        }

        @Override // io.sentry.JsonUnknown
        public Map<String, Object> getUnknown() {
            return this.unknown;
        }

        @Override // io.sentry.JsonUnknown
        public void setUnknown(Map<String, Object> map) {
            this.unknown = map;
        }

        public static final class Deserializer implements JsonDeserializer<TraceContextUser> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.sentry.JsonDeserializer
            public TraceContextUser deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
                objectReader.beginObject();
                String str = null;
                String str2 = null;
                ConcurrentHashMap concurrentHashMap = null;
                while (objectReader.peek() == JsonToken.NAME) {
                    String nextName = objectReader.nextName();
                    nextName.hashCode();
                    if (nextName.equals("id")) {
                        str = objectReader.nextStringOrNull();
                    } else if (nextName.equals("segment")) {
                        str2 = objectReader.nextStringOrNull();
                    } else {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                    }
                }
                TraceContextUser traceContextUser = new TraceContextUser(str, str2);
                traceContextUser.setUnknown(concurrentHashMap);
                objectReader.endObject();
                return traceContextUser;
            }
        }
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("trace_id").value(iLogger, this.traceId);
        objectWriter.name(JsonKeys.PUBLIC_KEY).value(this.publicKey);
        if (this.release != null) {
            objectWriter.name("release").value(this.release);
        }
        if (this.environment != null) {
            objectWriter.name("environment").value(this.environment);
        }
        if (this.userId != null) {
            objectWriter.name("user_id").value(this.userId);
        }
        if (this.userSegment != null) {
            objectWriter.name(JsonKeys.USER_SEGMENT).value(this.userSegment);
        }
        if (this.transaction != null) {
            objectWriter.name("transaction").value(this.transaction);
        }
        if (this.sampleRate != null) {
            objectWriter.name(JsonKeys.SAMPLE_RATE).value(this.sampleRate);
        }
        if (this.sampled != null) {
            objectWriter.name(JsonKeys.SAMPLED).value(this.sampled);
        }
        if (this.replayId != null) {
            objectWriter.name("replay_id").value(iLogger, this.replayId);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<TraceContext> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public TraceContext deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            String str;
            String str2;
            String nextName;
            objectReader.beginObject();
            TraceContextUser traceContextUser = null;
            String str3 = null;
            SentryId sentryId = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            SentryId sentryId2 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (true) {
                SentryId sentryId3 = sentryId2;
                String str11 = str10;
                if (objectReader.peek() != JsonToken.NAME) {
                    if (sentryId == null) {
                        throw missingRequiredFieldException("trace_id", iLogger);
                    }
                    if (str5 == null) {
                        throw missingRequiredFieldException(JsonKeys.PUBLIC_KEY, iLogger);
                    }
                    if (traceContextUser != null) {
                        if (str3 == null) {
                            str3 = traceContextUser.getId();
                        }
                        if (str4 == null) {
                            str2 = traceContextUser.getSegment();
                            str = str3;
                            TraceContext traceContext = new TraceContext(sentryId, str5, str6, str7, str, str2, str8, str9, str11, sentryId3);
                            traceContext.setUnknown(concurrentHashMap);
                            objectReader.endObject();
                            return traceContext;
                        }
                    }
                    str = str3;
                    str2 = str4;
                    TraceContext traceContext2 = new TraceContext(sentryId, str5, str6, str7, str, str2, str8, str9, str11, sentryId3);
                    traceContext2.setUnknown(concurrentHashMap);
                    objectReader.endObject();
                    return traceContext2;
                }
                nextName = objectReader.nextName();
                nextName.hashCode();
                switch (nextName) {
                    case "user_segment":
                        str4 = objectReader.nextStringOrNull();
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "replay_id":
                        sentryId2 = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                        str10 = str11;
                        break;
                    case "user_id":
                        str3 = objectReader.nextStringOrNull();
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "environment":
                        str7 = objectReader.nextStringOrNull();
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "user":
                        traceContextUser = (TraceContextUser) objectReader.nextOrNull(iLogger, new TraceContextUser.Deserializer());
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "sample_rate":
                        str9 = objectReader.nextStringOrNull();
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "release":
                        str6 = objectReader.nextStringOrNull();
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "trace_id":
                        sentryId = new SentryId.Deserializer().deserialize(objectReader, iLogger);
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "sampled":
                        str10 = objectReader.nextStringOrNull();
                        sentryId2 = sentryId3;
                        break;
                    case "public_key":
                        str5 = objectReader.nextString();
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    case "transaction":
                        str8 = objectReader.nextStringOrNull();
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        sentryId2 = sentryId3;
                        str10 = str11;
                        break;
                }
            }
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, illegalStateException);
            return illegalStateException;
        }
    }
}
