package com.microsoft.clarity.models.display;

import com.microsoft.clarity.models.observers.ObservedEvent;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/microsoft/clarity/models/display/DisallowedScreenDisplayFrame;", "Lcom/microsoft/clarity/models/observers/ObservedEvent;", "Lcom/microsoft/clarity/models/display/IDisplayFrame;", "timestamp", "", "screenMetadata", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "(JLcom/microsoft/clarity/models/observers/ScreenMetadata;)V", "getScreenMetadata", "()Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DisallowedScreenDisplayFrame extends ObservedEvent implements IDisplayFrame {
    private final ScreenMetadata screenMetadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisallowedScreenDisplayFrame(long j, ScreenMetadata screenMetadata) {
        super(j);
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        this.screenMetadata = screenMetadata;
    }

    @Override // com.microsoft.clarity.models.display.IDisplayFrame
    public ScreenMetadata getScreenMetadata() {
        return this.screenMetadata;
    }
}
