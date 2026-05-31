package com.microsoft.clarity.models.display.commands;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "paintIndex", "", "(I)V", "getPaintIndex", "()I", "setPaintIndex", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PaintableCommand extends DisplayCommand {
    private int paintIndex;

    public PaintableCommand(int i) {
        this.paintIndex = i;
    }

    public final int getPaintIndex() {
        return this.paintIndex;
    }

    public final void setPaintIndex(int i) {
        this.paintIndex = i;
    }
}
