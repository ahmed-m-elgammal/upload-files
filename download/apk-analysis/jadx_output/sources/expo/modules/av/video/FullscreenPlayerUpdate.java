package expo.modules.av.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FullscreenPlayerUpdate.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/av/video/FullscreenPlayerUpdate;", "", "jsValue", "", "(Ljava/lang/String;II)V", "getJsValue", "()I", "FULLSCREEN_PLAYER_WILL_PRESENT", "FULLSCREEN_PLAYER_DID_PRESENT", "FULLSCREEN_PLAYER_WILL_DISMISS", "FULLSCREEN_PLAYER_DID_DISMISS", "expo-av_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FullscreenPlayerUpdate {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FullscreenPlayerUpdate[] $VALUES;
    private final int jsValue;
    public static final FullscreenPlayerUpdate FULLSCREEN_PLAYER_WILL_PRESENT = new FullscreenPlayerUpdate("FULLSCREEN_PLAYER_WILL_PRESENT", 0, 0);
    public static final FullscreenPlayerUpdate FULLSCREEN_PLAYER_DID_PRESENT = new FullscreenPlayerUpdate("FULLSCREEN_PLAYER_DID_PRESENT", 1, 1);
    public static final FullscreenPlayerUpdate FULLSCREEN_PLAYER_WILL_DISMISS = new FullscreenPlayerUpdate("FULLSCREEN_PLAYER_WILL_DISMISS", 2, 2);
    public static final FullscreenPlayerUpdate FULLSCREEN_PLAYER_DID_DISMISS = new FullscreenPlayerUpdate("FULLSCREEN_PLAYER_DID_DISMISS", 3, 3);

    private static final /* synthetic */ FullscreenPlayerUpdate[] $values() {
        return new FullscreenPlayerUpdate[]{FULLSCREEN_PLAYER_WILL_PRESENT, FULLSCREEN_PLAYER_DID_PRESENT, FULLSCREEN_PLAYER_WILL_DISMISS, FULLSCREEN_PLAYER_DID_DISMISS};
    }

    public static EnumEntries<FullscreenPlayerUpdate> getEntries() {
        return $ENTRIES;
    }

    public static FullscreenPlayerUpdate valueOf(String str) {
        return (FullscreenPlayerUpdate) Enum.valueOf(FullscreenPlayerUpdate.class, str);
    }

    public static FullscreenPlayerUpdate[] values() {
        return (FullscreenPlayerUpdate[]) $VALUES.clone();
    }

    private FullscreenPlayerUpdate(String str, int i, int i2) {
        this.jsValue = i2;
    }

    public final int getJsValue() {
        return this.jsValue;
    }

    static {
        FullscreenPlayerUpdate[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
