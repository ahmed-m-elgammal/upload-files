package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.GeneratedMessageLite;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.microsoft.clarity.protomodels.mutationpayload.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0122k extends GeneratedMessageLite.Builder implements InterfaceC0123l {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0122k() {
        /*
            r1 = this;
            com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayFrame r0 = com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayFrame.m1909$$Nest$sfgetDEFAULT_INSTANCE()
            r1.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.protomodels.mutationpayload.C0122k.<init>():void");
    }

    public final C0122k a(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllCommands(arrayList);
        return this;
    }

    public final C0122k b(ArrayList arrayList) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllTypefaces(arrayList);
        return this;
    }

    public final C0122k c(List list) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllPaths(list);
        return this;
    }

    public final C0122k d(List list) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllSubPictures(list);
        return this;
    }

    public final C0122k e(List list) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllTextBlobs(list);
        return this;
    }

    public final C0122k f(List list) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllVertices(list);
        return this;
    }

    public final C0122k a(List list) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllImages(list);
        return this;
    }

    public final C0122k b(List list) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).addAllPaints(list);
        return this;
    }

    public final C0122k c(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setScreenHeight(i);
        return this;
    }

    public final C0122k d(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setScreenWidth(i);
        return this;
    }

    public final C0122k e(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setSystemBackgroundColor(i);
        return this;
    }

    public final C0122k a(MutationPayload$ViewHierarchy mutationPayload$ViewHierarchy) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setViewHierarchy(mutationPayload$ViewHierarchy);
        return this;
    }

    public final C0122k b(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setKeyboardHeight(i);
        return this;
    }

    public final C0122k a(double d) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setTimestamp(d);
        return this;
    }

    public final C0122k a(String str) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setActivityName(str);
        return this;
    }

    public final C0122k a(int i) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setActivityId(i);
        return this;
    }

    public final C0122k a(float f) {
        copyOnWrite();
        ((MutationPayload$DisplayFrame) this.instance).setDensity(f);
        return this;
    }
}
