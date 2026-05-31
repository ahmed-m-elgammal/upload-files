package com.microsoft.clarity.models.project;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/microsoft/clarity/models/project/UrlFilterType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "IsExactly", "StartsWith", "EndsWith", "Contains", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum UrlFilterType {
    Unknown(0),
    IsExactly(1),
    StartsWith(2),
    EndsWith(3),
    Contains(4);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/project/UrlFilterType$Companion;", "", "()V", "fromInt", "Lcom/microsoft/clarity/models/project/UrlFilterType;", "value", "", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UrlFilterType fromInt(int value) {
            UrlFilterType urlFilterType;
            UrlFilterType[] values = UrlFilterType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    urlFilterType = null;
                    break;
                }
                urlFilterType = values[i];
                if (urlFilterType.getValue() == value) {
                    break;
                }
                i++;
            }
            return urlFilterType == null ? UrlFilterType.Unknown : urlFilterType;
        }

        private Companion() {
        }
    }

    UrlFilterType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
