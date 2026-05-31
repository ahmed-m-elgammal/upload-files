package com.microsoft.clarity.models.display.commands;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b \u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawViewAnnotation;", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "id", "", "name", "", "isClipRectSource", "", "(ILjava/lang/String;Z)V", "getId", "()I", "()Z", "getName", "()Ljava/lang/String;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DrawViewAnnotation extends DisplayCommand {
    private final int id;
    private final boolean isClipRectSource;
    private final String name;

    public /* synthetic */ DrawViewAnnotation(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? true : z);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* renamed from: isClipRectSource, reason: from getter */
    public final boolean getIsClipRectSource() {
        return this.isClipRectSource;
    }

    public DrawViewAnnotation(int i, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.isClipRectSource = z;
    }
}
