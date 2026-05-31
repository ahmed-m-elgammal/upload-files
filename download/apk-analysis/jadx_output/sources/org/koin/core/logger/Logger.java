package org.koin.core.logger;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Logger.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0086\bJ\u001c\u0010\r\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\n\u001a\u00060\u000bj\u0002`\fH&J\u0015\u0010\u000e\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0086\bJ\u0015\u0010\u000f\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0086\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014H\u0086\bø\u0001\u0000J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0086\bJ\u0015\u0010\u0015\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0086\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"Lorg/koin/core/logger/Logger;", "", "level", "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "getLevel", "()Lorg/koin/core/logger/Level;", "setLevel", "debug", "", "msg", "", "Lorg/koin/core/logger/MESSAGE;", "display", "error", "info", "isAt", "", "lvl", "log", "Lkotlin/Function0;", "warn", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class Logger {
    private Level level;

    /* JADX WARN: Multi-variable type inference failed */
    public Logger() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract void display(Level level, String msg);

    public Logger(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.level = level;
    }

    public /* synthetic */ Logger(Level level, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Level.INFO : level);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void setLevel(Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    public final void debug(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Level level = Level.DEBUG;
        if (isAt(level)) {
            display(level, msg);
        }
    }

    public final void info(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Level level = Level.INFO;
        if (isAt(level)) {
            display(level, msg);
        }
    }

    public final void warn(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Level level = Level.WARNING;
        if (isAt(level)) {
            display(level, msg);
        }
    }

    public final void error(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Level level = Level.ERROR;
        if (isAt(level)) {
            display(level, msg);
        }
    }

    public final boolean isAt(Level lvl) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        return this.level.compareTo(lvl) <= 0;
    }

    public final void log(Level lvl, String msg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isAt(lvl)) {
            display(lvl, msg);
        }
    }

    public final void log(Level lvl, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isAt(lvl)) {
            display(lvl, msg.invoke());
        }
    }
}
