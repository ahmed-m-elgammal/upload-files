package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.BundleCompat;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.BundleUtil;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaSession;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ConnectionState implements Bundleable {
    public final ImmutableList<CommandButton> customLayout;
    public final int libraryVersion;
    public final Player.Commands playerCommandsFromPlayer;
    public final Player.Commands playerCommandsFromSession;
    public final PlayerInfo playerInfo;
    public final PendingIntent sessionActivity;
    public final IMediaSession sessionBinder;
    public final SessionCommands sessionCommands;
    public final Bundle sessionExtras;
    public final int sessionInterfaceVersion;
    public final Bundle tokenExtras;
    private static final String FIELD_LIBRARY_VERSION = Util.intToStringMaxRadix(0);
    private static final String FIELD_SESSION_BINDER = Util.intToStringMaxRadix(1);
    private static final String FIELD_SESSION_ACTIVITY = Util.intToStringMaxRadix(2);
    private static final String FIELD_CUSTOM_LAYOUT = Util.intToStringMaxRadix(9);
    private static final String FIELD_SESSION_COMMANDS = Util.intToStringMaxRadix(3);
    private static final String FIELD_PLAYER_COMMANDS_FROM_SESSION = Util.intToStringMaxRadix(4);
    private static final String FIELD_PLAYER_COMMANDS_FROM_PLAYER = Util.intToStringMaxRadix(5);
    private static final String FIELD_TOKEN_EXTRAS = Util.intToStringMaxRadix(6);
    private static final String FIELD_SESSION_EXTRAS = Util.intToStringMaxRadix(11);
    private static final String FIELD_PLAYER_INFO = Util.intToStringMaxRadix(7);
    private static final String FIELD_SESSION_INTERFACE_VERSION = Util.intToStringMaxRadix(8);
    private static final String FIELD_IN_PROCESS_BINDER = Util.intToStringMaxRadix(10);

    @Deprecated
    public static final Bundleable.Creator<ConnectionState> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.ConnectionState$$ExternalSyntheticLambda0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return ConnectionState.fromBundle(bundle);
        }
    };

    public ConnectionState(int i, int i2, IMediaSession iMediaSession, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, SessionCommands sessionCommands, Player.Commands commands, Player.Commands commands2, Bundle bundle, Bundle bundle2, PlayerInfo playerInfo) {
        this.libraryVersion = i;
        this.sessionInterfaceVersion = i2;
        this.sessionBinder = iMediaSession;
        this.sessionActivity = pendingIntent;
        this.customLayout = immutableList;
        this.sessionCommands = sessionCommands;
        this.playerCommandsFromSession = commands;
        this.playerCommandsFromPlayer = commands2;
        this.tokenExtras = bundle;
        this.sessionExtras = bundle2;
        this.playerInfo = playerInfo;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        return toBundleForRemoteProcess(Integer.MAX_VALUE);
    }

    public Bundle toBundleForRemoteProcess(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        BundleCompat.putBinder(bundle, FIELD_SESSION_BINDER, this.sessionBinder.asBinder());
        bundle.putParcelable(FIELD_SESSION_ACTIVITY, this.sessionActivity);
        if (!this.customLayout.isEmpty()) {
            bundle.putParcelableArrayList(FIELD_CUSTOM_LAYOUT, BundleCollectionUtil.toBundleArrayList(this.customLayout, new ConnectionState$$ExternalSyntheticLambda2()));
        }
        bundle.putBundle(FIELD_SESSION_COMMANDS, this.sessionCommands.toBundle());
        bundle.putBundle(FIELD_PLAYER_COMMANDS_FROM_SESSION, this.playerCommandsFromSession.toBundle());
        bundle.putBundle(FIELD_PLAYER_COMMANDS_FROM_PLAYER, this.playerCommandsFromPlayer.toBundle());
        bundle.putBundle(FIELD_TOKEN_EXTRAS, this.tokenExtras);
        bundle.putBundle(FIELD_SESSION_EXTRAS, this.sessionExtras);
        bundle.putBundle(FIELD_PLAYER_INFO, this.playerInfo.filterByAvailableCommands(MediaUtils.intersect(this.playerCommandsFromSession, this.playerCommandsFromPlayer), false, false).toBundleForRemoteProcess(i));
        bundle.putInt(FIELD_SESSION_INTERFACE_VERSION, this.sessionInterfaceVersion);
        return bundle;
    }

    public Bundle toBundleInProcess() {
        Bundle bundle = new Bundle();
        BundleUtil.putBinder(bundle, FIELD_IN_PROCESS_BINDER, new InProcessBinder());
        return bundle;
    }

    public static ConnectionState fromBundle(Bundle bundle) {
        ImmutableList of;
        SessionCommands fromBundle;
        Player.Commands fromBundle2;
        Player.Commands fromBundle3;
        IBinder binder = BundleUtil.getBinder(bundle, FIELD_IN_PROCESS_BINDER);
        if (binder instanceof InProcessBinder) {
            return ((InProcessBinder) binder).getConnectionState();
        }
        int i = bundle.getInt(FIELD_LIBRARY_VERSION, 0);
        int i2 = bundle.getInt(FIELD_SESSION_INTERFACE_VERSION, 0);
        IBinder iBinder = (IBinder) Assertions.checkNotNull(BundleCompat.getBinder(bundle, FIELD_SESSION_BINDER));
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(FIELD_SESSION_ACTIVITY);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_CUSTOM_LAYOUT);
        if (parcelableArrayList != null) {
            of = BundleCollectionUtil.fromBundleList(new ConnectionState$$ExternalSyntheticLambda1(), parcelableArrayList);
        } else {
            of = ImmutableList.of();
        }
        ImmutableList immutableList = of;
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_COMMANDS);
        if (bundle2 == null) {
            fromBundle = SessionCommands.EMPTY;
        } else {
            fromBundle = SessionCommands.fromBundle(bundle2);
        }
        SessionCommands sessionCommands = fromBundle;
        Bundle bundle3 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_PLAYER);
        if (bundle3 == null) {
            fromBundle2 = Player.Commands.EMPTY;
        } else {
            fromBundle2 = Player.Commands.fromBundle(bundle3);
        }
        Player.Commands commands = fromBundle2;
        Bundle bundle4 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_SESSION);
        if (bundle4 == null) {
            fromBundle3 = Player.Commands.EMPTY;
        } else {
            fromBundle3 = Player.Commands.fromBundle(bundle4);
        }
        Player.Commands commands2 = fromBundle3;
        Bundle bundle5 = bundle.getBundle(FIELD_TOKEN_EXTRAS);
        Bundle bundle6 = bundle.getBundle(FIELD_SESSION_EXTRAS);
        Bundle bundle7 = bundle.getBundle(FIELD_PLAYER_INFO);
        return new ConnectionState(i, i2, IMediaSession.Stub.asInterface(iBinder), pendingIntent, immutableList, sessionCommands, commands2, commands, bundle5 == null ? Bundle.EMPTY : bundle5, bundle6 == null ? Bundle.EMPTY : bundle6, bundle7 == null ? PlayerInfo.DEFAULT : PlayerInfo.fromBundle(bundle7));
    }

    private final class InProcessBinder extends Binder {
        private InProcessBinder() {
        }

        public ConnectionState getConnectionState() {
            return ConnectionState.this;
        }
    }
}
