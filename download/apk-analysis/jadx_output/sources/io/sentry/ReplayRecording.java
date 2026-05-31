package io.sentry;

import io.sentry.rrweb.RRWebBreadcrumbEvent;
import io.sentry.rrweb.RRWebEvent;
import io.sentry.rrweb.RRWebEventType;
import io.sentry.rrweb.RRWebIncrementalSnapshotEvent;
import io.sentry.rrweb.RRWebInteractionEvent;
import io.sentry.rrweb.RRWebInteractionMoveEvent;
import io.sentry.rrweb.RRWebMetaEvent;
import io.sentry.rrweb.RRWebSpanEvent;
import io.sentry.rrweb.RRWebVideoEvent;
import io.sentry.util.MapObjectReader;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class ReplayRecording implements JsonUnknown, JsonSerializable {
    private List<? extends RRWebEvent> payload;
    private Integer segmentId;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String SEGMENT_ID = "segment_id";
    }

    public Integer getSegmentId() {
        return this.segmentId;
    }

    public void setSegmentId(Integer num) {
        this.segmentId = num;
    }

    public List<? extends RRWebEvent> getPayload() {
        return this.payload;
    }

    public void setPayload(List<? extends RRWebEvent> list) {
        this.payload = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReplayRecording replayRecording = (ReplayRecording) obj;
        return Objects.equals(this.segmentId, replayRecording.segmentId) && Objects.equals(this.payload, replayRecording.payload);
    }

    public int hashCode() {
        return Objects.hash(this.segmentId, this.payload);
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.segmentId != null) {
            objectWriter.name("segment_id").value(this.segmentId);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
        objectWriter.setLenient(true);
        if (this.segmentId != null) {
            objectWriter.jsonValue("\n");
        }
        List<? extends RRWebEvent> list = this.payload;
        if (list != null) {
            objectWriter.value(iLogger, list);
        }
        objectWriter.setLenient(false);
    }

    @Override // io.sentry.JsonUnknown
    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    @Override // io.sentry.JsonUnknown
    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<ReplayRecording> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.sentry.JsonDeserializer
        public ReplayRecording deserialize(ObjectReader objectReader, ILogger iLogger) throws Exception {
            ReplayRecording replayRecording = new ReplayRecording();
            objectReader.beginObject();
            ArrayList arrayList = null;
            HashMap hashMap = null;
            Integer num = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String nextName = objectReader.nextName();
                nextName.hashCode();
                if (nextName.equals("segment_id")) {
                    num = objectReader.nextIntegerOrNull();
                } else {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    objectReader.nextUnknown(iLogger, hashMap, nextName);
                }
            }
            objectReader.endObject();
            objectReader.setLenient(true);
            List list = (List) objectReader.nextObjectOrNull();
            objectReader.setLenient(false);
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        MapObjectReader mapObjectReader = new MapObjectReader(map);
                        for (Map.Entry entry : map.entrySet()) {
                            String str = (String) entry.getKey();
                            Object value = entry.getValue();
                            if (str.equals("type")) {
                                RRWebEventType rRWebEventType = RRWebEventType.values()[((Integer) value).intValue()];
                                int i = AnonymousClass1.$SwitchMap$io$sentry$rrweb$RRWebEventType[rRWebEventType.ordinal()];
                                if (i == 1) {
                                    Map map2 = (Map) map.get("data");
                                    if (map2 == null) {
                                        map2 = Collections.emptyMap();
                                    }
                                    Integer num2 = (Integer) map2.get("source");
                                    if (num2 != null) {
                                        RRWebIncrementalSnapshotEvent.IncrementalSource incrementalSource = RRWebIncrementalSnapshotEvent.IncrementalSource.values()[num2.intValue()];
                                        int i2 = AnonymousClass1.$SwitchMap$io$sentry$rrweb$RRWebIncrementalSnapshotEvent$IncrementalSource[incrementalSource.ordinal()];
                                        if (i2 == 1) {
                                            arrayList.add(new RRWebInteractionEvent.Deserializer().deserialize((ObjectReader) mapObjectReader, iLogger));
                                        } else if (i2 == 2) {
                                            arrayList.add(new RRWebInteractionMoveEvent.Deserializer().deserialize((ObjectReader) mapObjectReader, iLogger));
                                        } else {
                                            iLogger.log(SentryLevel.DEBUG, "Unsupported rrweb incremental snapshot type %s", incrementalSource);
                                        }
                                    }
                                } else if (i == 2) {
                                    arrayList.add(new RRWebMetaEvent.Deserializer().deserialize((ObjectReader) mapObjectReader, iLogger));
                                } else if (i == 3) {
                                    Map map3 = (Map) map.get("data");
                                    if (map3 == null) {
                                        map3 = Collections.emptyMap();
                                    }
                                    String str2 = (String) map3.get("tag");
                                    if (str2 != null) {
                                        str2.hashCode();
                                        switch (str2) {
                                            case "performanceSpan":
                                                arrayList.add(new RRWebSpanEvent.Deserializer().deserialize((ObjectReader) mapObjectReader, iLogger));
                                                break;
                                            case "video":
                                                arrayList.add(new RRWebVideoEvent.Deserializer().deserialize((ObjectReader) mapObjectReader, iLogger));
                                                break;
                                            case "breadcrumb":
                                                arrayList.add(new RRWebBreadcrumbEvent.Deserializer().deserialize((ObjectReader) mapObjectReader, iLogger));
                                                break;
                                            default:
                                                iLogger.log(SentryLevel.DEBUG, "Unsupported rrweb event type %s", rRWebEventType);
                                                break;
                                        }
                                    }
                                } else {
                                    iLogger.log(SentryLevel.DEBUG, "Unsupported rrweb event type %s", rRWebEventType);
                                }
                            }
                        }
                    }
                }
            }
            replayRecording.setSegmentId(num);
            replayRecording.setPayload(arrayList);
            replayRecording.setUnknown(hashMap);
            return replayRecording;
        }
    }

    /* renamed from: io.sentry.ReplayRecording$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$rrweb$RRWebEventType;
        static final /* synthetic */ int[] $SwitchMap$io$sentry$rrweb$RRWebIncrementalSnapshotEvent$IncrementalSource;

        static {
            int[] iArr = new int[RRWebEventType.values().length];
            $SwitchMap$io$sentry$rrweb$RRWebEventType = iArr;
            try {
                iArr[RRWebEventType.IncrementalSnapshot.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$rrweb$RRWebEventType[RRWebEventType.Meta.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$sentry$rrweb$RRWebEventType[RRWebEventType.Custom.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[RRWebIncrementalSnapshotEvent.IncrementalSource.values().length];
            $SwitchMap$io$sentry$rrweb$RRWebIncrementalSnapshotEvent$IncrementalSource = iArr2;
            try {
                iArr2[RRWebIncrementalSnapshotEvent.IncrementalSource.MouseInteraction.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$sentry$rrweb$RRWebIncrementalSnapshotEvent$IncrementalSource[RRWebIncrementalSnapshotEvent.IncrementalSource.TouchMove.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
