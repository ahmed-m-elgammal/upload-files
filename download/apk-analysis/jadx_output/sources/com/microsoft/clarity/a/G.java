package com.microsoft.clarity.a;

import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.images.Image;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class G {

    /* renamed from: a, reason: collision with root package name */
    public static final Image f19a;
    public static final TextBlob b;

    static {
        new PageMetadata(new SessionMetadata("DUMMY", "DUMMY", "DUMMY", "DUMMY", 0L, 1, false, "https://www.clarity.ms/eus2/", null, 256, null), 0);
        byte[] bArr = new byte[0];
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        f19a = new Image(null, new C0107a(bArr, 0, 0), null, null);
        b = new TextBlob(null, CollectionsKt.emptyList());
    }
}
