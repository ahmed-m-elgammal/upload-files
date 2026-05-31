package com.microsoft.clarity.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.i.C0109c;
import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.models.display.common.ImageSize;
import com.microsoft.clarity.models.ingest.AssetMetadata;
import com.microsoft.clarity.models.repositories.RepositoryAsset;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.zip.GZIPOutputStream;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class G extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ H f63a;
    public final /* synthetic */ SessionMetadata b;
    public final /* synthetic */ RepositoryAsset c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(H h, SessionMetadata sessionMetadata, RepositoryAsset repositoryAsset) {
        super(0);
        this.f63a = h;
        this.b = sessionMetadata;
        this.c = repositoryAsset;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z;
        H h = this.f63a;
        SessionMetadata sessionMetadata = this.b;
        RepositoryAsset repositoryAsset = this.c;
        h.getClass();
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        Intrinsics.checkNotNullParameter(repositoryAsset, "repositoryAsset");
        int i = F.f62a[repositoryAsset.getType().ordinal()];
        if (i == 1) {
            com.microsoft.clarity.k.a aVar = h.e;
            String ingestUrl = sessionMetadata.getIngestUrl();
            String projectId = sessionMetadata.getProjectId();
            String path = repositoryAsset.getId();
            byte[] asset = repositoryAsset.getData();
            com.microsoft.clarity.k.b bVar = (com.microsoft.clarity.k.b) aVar;
            bVar.getClass();
            Intrinsics.checkNotNullParameter(ingestUrl, "ingestUrl");
            Intrinsics.checkNotNullParameter(projectId, "projectId");
            Intrinsics.checkNotNullParameter("all", "version");
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(asset, "asset");
            String uri = Uri.parse(ingestUrl).buildUpon().appendPath(projectId).appendPath("upload-web-asset").appendPath("all").build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "parse(ingestUrl)\n       …)\n            .toString()");
            HttpURLConnection a2 = com.microsoft.clarity.m.g.a(uri, "POST", MapsKt.mapOf(TuplesKt.to("Content-Type", "application/octet-stream"), TuplesKt.to("Content-Path", path)));
            try {
                com.microsoft.clarity.m.g.a(a2, asset);
                a2.connect();
                boolean b = com.microsoft.clarity.m.g.b(a2);
                if (b) {
                    bVar.a("Clarity_UploadWebAssetBytes", asset.length);
                    bVar.d.a(asset.length);
                }
                a2.disconnect();
                z = b;
            } catch (Throwable th) {
                a2.disconnect();
                throw th;
            }
        } else if (i == 2) {
            Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
            Intrinsics.checkNotNullParameter(repositoryAsset, "repositoryAsset");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            byte[] data = repositoryAsset.getData();
            Intrinsics.checkNotNullParameter(data, "<this>");
            int length = data.length;
            C0107a imageBytes = new C0107a(data, 0, length);
            Intrinsics.checkNotNullParameter(imageBytes, "imageBytes");
            C0109c c0109c = new C0109c(data, 0, length);
            c0109c.d = 16;
            ImageSize imageSize = new ImageSize(c0109c.a(), c0109c.a(), null);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(repositoryAsset.getData(), 0, repositoryAsset.getData().length, options);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] compressedBytes = byteArrayOutputStream.toByteArray();
            decodeByteArray.recycle();
            com.microsoft.clarity.k.a aVar2 = h.e;
            String id = repositoryAsset.getId();
            Intrinsics.checkNotNullExpressionValue(compressedBytes, "compressedBytes");
            z = ((com.microsoft.clarity.k.b) aVar2).a(sessionMetadata, id, compressedBytes, new AssetMetadata(AssetType.Image, Integer.valueOf(imageSize.getWidth()), Integer.valueOf(imageSize.getHeight())));
        } else if (i != 3) {
            z = ((com.microsoft.clarity.k.b) h.e).a(sessionMetadata, repositoryAsset.getId(), repositoryAsset.getData(), new AssetMetadata(repositoryAsset.getType(), null, null, 6, null));
        } else {
            com.microsoft.clarity.k.a aVar3 = h.e;
            String id2 = repositoryAsset.getId();
            MessageDigest messageDigest = com.microsoft.clarity.m.b.f189a;
            byte[] content = repositoryAsset.getData();
            Intrinsics.checkNotNullParameter(content, "content");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                try {
                    gZIPOutputStream.write(content);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "byteArrayOutputStream.toByteArray()");
                    CloseableKt.closeFinally(byteArrayOutputStream2, null);
                    z = ((com.microsoft.clarity.k.b) aVar3).a(sessionMetadata, id2, byteArray, new AssetMetadata(repositoryAsset.getType(), null, null, 6, null));
                } finally {
                }
            } finally {
            }
        }
        return Boolean.valueOf(z);
    }
}
