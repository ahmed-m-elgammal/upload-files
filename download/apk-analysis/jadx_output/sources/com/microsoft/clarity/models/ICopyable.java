package com.microsoft.clarity.models;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/microsoft/clarity/models/ICopyable;", ExifInterface.GPS_DIRECTION_TRUE, "", "copy", "()Ljava/lang/Object;", "copyWithNullData", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ICopyable<T> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T> T copyWithNullData(ICopyable<T> iCopyable) {
            return iCopyable.copy();
        }
    }

    T copy();

    T copyWithNullData();
}
