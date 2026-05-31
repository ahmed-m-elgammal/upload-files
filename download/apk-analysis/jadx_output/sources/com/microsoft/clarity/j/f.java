package com.microsoft.clarity.j;

import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.PayloadMetadata;
import com.microsoft.clarity.models.repositories.RepositoryAssetMetadata;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* loaded from: classes5.dex */
public final class f implements b {
    public static final List g = CollectionsKt.listOf((Object[]) new AssetType[]{AssetType.Image, AssetType.Typeface, AssetType.Web});

    /* renamed from: a, reason: collision with root package name */
    public final a f181a;
    public final com.microsoft.clarity.l.c b;
    public final com.microsoft.clarity.l.c c;
    public final com.microsoft.clarity.l.c d;
    public final com.microsoft.clarity.l.c e;
    public final com.microsoft.clarity.l.c f;

    public f(a metadataRepository, com.microsoft.clarity.l.c frameStore, com.microsoft.clarity.l.c analyticsStore, com.microsoft.clarity.l.c imageStore, com.microsoft.clarity.l.c typefaceStore, com.microsoft.clarity.l.c webStore) {
        Intrinsics.checkNotNullParameter(metadataRepository, "metadataRepository");
        Intrinsics.checkNotNullParameter(frameStore, "frameStore");
        Intrinsics.checkNotNullParameter(analyticsStore, "analyticsStore");
        Intrinsics.checkNotNullParameter(imageStore, "imageStore");
        Intrinsics.checkNotNullParameter(typefaceStore, "typefaceStore");
        Intrinsics.checkNotNullParameter(webStore, "webStore");
        this.f181a = metadataRepository;
        this.b = frameStore;
        this.c = analyticsStore;
        this.d = imageStore;
        this.e = typefaceStore;
        this.f = webStore;
    }

    public static String b(PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        return payloadMetadata.getSessionId() + IOUtils.DIR_SEPARATOR_UNIX + payloadMetadata.getPageNum() + "_" + payloadMetadata.getSequence();
    }

    public final void a(PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        LogLevel logLevel = h.f192a;
        h.b("Delete session payload " + payloadMetadata + '.');
        String filename = b(payloadMetadata);
        com.microsoft.clarity.l.c cVar = this.b;
        Intrinsics.checkNotNullParameter(filename, "filename");
        new File(cVar.a(filename)).delete();
        com.microsoft.clarity.l.c cVar2 = this.c;
        Intrinsics.checkNotNullParameter(filename, "filename");
        new File(cVar2.a(filename)).delete();
    }

    public final List a(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        List<AssetType> list = g;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AssetType type : list) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(type, "type");
            List a2 = com.microsoft.clarity.l.c.a(a(type), sessionId + IOUtils.DIR_SEPARATOR_UNIX, false, 2);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                String path = ((File) it.next()).getPath();
                Intrinsics.checkNotNullExpressionValue(path, "file.path");
                arrayList2.add(new RepositoryAssetMetadata(type, StringsKt.substringAfter$default(path, sessionId + IOUtils.DIR_SEPARATOR_UNIX, (String) null, 2, (Object) null)));
            }
            arrayList.add(arrayList2);
        }
        return CollectionsKt.flatten(arrayList);
    }

    public static void a(com.microsoft.clarity.l.c eventStore, PayloadMetadata payloadMetadata, String serializedEvent) {
        Intrinsics.checkNotNullParameter(eventStore, "eventStore");
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        Intrinsics.checkNotNullParameter(serializedEvent, "serializedEvent");
        eventStore.a(b(payloadMetadata), serializedEvent + '\n', com.microsoft.clarity.l.d.APPEND);
    }

    public static List a(com.microsoft.clarity.l.c store, PayloadMetadata payloadMetadata) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(payloadMetadata, "payloadMetadata");
        List split$default = StringsKt.split$default((CharSequence) store.b(b(payloadMetadata)), new String[]{"\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split$default) {
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) obj).toString(), "")) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public final com.microsoft.clarity.l.c a(AssetType assetType) {
        int i = e.f180a[assetType.ordinal()];
        if (i == 1) {
            return this.d;
        }
        if (i == 2) {
            return this.e;
        }
        if (i == 3) {
            return this.f;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("Unexpected asset type");
    }

    public static String a(String sessionId, String filename) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(filename, "filename");
        String[] paths = {sessionId, filename};
        Intrinsics.checkNotNullParameter(paths, "paths");
        return ArraysKt.joinToString$default(paths, String.valueOf(File.separatorChar), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
