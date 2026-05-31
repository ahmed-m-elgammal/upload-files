package androidx.media3.session;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.List;

/* loaded from: classes.dex */
public final class CommandButton implements Bundleable {
    public final CharSequence displayName;
    public final Bundle extras;
    public final int iconResId;
    public final Uri iconUri;
    public final boolean isEnabled;
    public final int playerCommand;
    public final SessionCommand sessionCommand;
    private static final String FIELD_SESSION_COMMAND = Util.intToStringMaxRadix(0);
    private static final String FIELD_PLAYER_COMMAND = Util.intToStringMaxRadix(1);
    private static final String FIELD_ICON_RES_ID = Util.intToStringMaxRadix(2);
    private static final String FIELD_DISPLAY_NAME = Util.intToStringMaxRadix(3);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(4);
    private static final String FIELD_ENABLED = Util.intToStringMaxRadix(5);
    private static final String FIELD_ICON_URI = Util.intToStringMaxRadix(6);

    @Deprecated
    public static final Bundleable.Creator<CommandButton> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.CommandButton$$ExternalSyntheticLambda0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return CommandButton.fromBundle(bundle);
        }
    };

    public static final class Builder {
        private boolean enabled;
        private int iconResId;
        private Uri iconUri;
        private SessionCommand sessionCommand;
        private CharSequence displayName = "";
        private Bundle extras = Bundle.EMPTY;
        private int playerCommand = -1;

        public Builder setSessionCommand(SessionCommand sessionCommand) {
            Assertions.checkNotNull(sessionCommand, "sessionCommand should not be null.");
            Assertions.checkArgument(this.playerCommand == -1, "playerCommands is already set. Only one of sessionCommand and playerCommand should be set.");
            this.sessionCommand = sessionCommand;
            return this;
        }

        public Builder setPlayerCommand(int i) {
            Assertions.checkArgument(this.sessionCommand == null, "sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.");
            this.playerCommand = i;
            return this;
        }

        public Builder setIconResId(int i) {
            this.iconResId = i;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.iconUri = uri;
            return this;
        }

        public Builder setDisplayName(CharSequence charSequence) {
            this.displayName = charSequence;
            return this;
        }

        public Builder setEnabled(boolean z) {
            this.enabled = z;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = new Bundle(bundle);
            return this;
        }

        public CommandButton build() {
            Assertions.checkState((this.sessionCommand == null) != (this.playerCommand == -1), "Exactly one of sessionCommand and playerCommand should be set");
            return new CommandButton(this.sessionCommand, this.playerCommand, this.iconResId, this.iconUri, this.displayName, this.extras, this.enabled);
        }
    }

    private CommandButton(SessionCommand sessionCommand, int i, int i2, Uri uri, CharSequence charSequence, Bundle bundle, boolean z) {
        this.sessionCommand = sessionCommand;
        this.playerCommand = i;
        this.iconResId = i2;
        this.iconUri = uri;
        this.displayName = charSequence;
        this.extras = new Bundle(bundle);
        this.isEnabled = z;
    }

    @CheckReturnValue
    CommandButton copyWithIsEnabled(boolean z) {
        return this.isEnabled == z ? this : new CommandButton(this.sessionCommand, this.playerCommand, this.iconResId, this.iconUri, this.displayName, new Bundle(this.extras), z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandButton)) {
            return false;
        }
        CommandButton commandButton = (CommandButton) obj;
        return Objects.equal(this.sessionCommand, commandButton.sessionCommand) && this.playerCommand == commandButton.playerCommand && this.iconResId == commandButton.iconResId && Objects.equal(this.iconUri, commandButton.iconUri) && TextUtils.equals(this.displayName, commandButton.displayName) && this.isEnabled == commandButton.isEnabled;
    }

    public int hashCode() {
        return Objects.hashCode(this.sessionCommand, Integer.valueOf(this.playerCommand), Integer.valueOf(this.iconResId), this.displayName, Boolean.valueOf(this.isEnabled), this.iconUri);
    }

    static ImmutableList<CommandButton> getEnabledCommandButtons(List<CommandButton> list, SessionCommands sessionCommands, Player.Commands commands) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < list.size(); i++) {
            CommandButton commandButton = list.get(i);
            builder.add((ImmutableList.Builder) commandButton.copyWithIsEnabled(isEnabled(commandButton, sessionCommands, commands)));
        }
        return builder.build();
    }

    static boolean isEnabled(CommandButton commandButton, SessionCommands sessionCommands, Player.Commands commands) {
        int i;
        SessionCommand sessionCommand = commandButton.sessionCommand;
        return (sessionCommand != null && sessionCommands.contains(sessionCommand)) || ((i = commandButton.playerCommand) != -1 && commands.contains(i));
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        SessionCommand sessionCommand = this.sessionCommand;
        if (sessionCommand != null) {
            bundle.putBundle(FIELD_SESSION_COMMAND, sessionCommand.toBundle());
        }
        bundle.putInt(FIELD_PLAYER_COMMAND, this.playerCommand);
        bundle.putInt(FIELD_ICON_RES_ID, this.iconResId);
        bundle.putCharSequence(FIELD_DISPLAY_NAME, this.displayName);
        bundle.putBundle(FIELD_EXTRAS, this.extras);
        bundle.putParcelable(FIELD_ICON_URI, this.iconUri);
        bundle.putBoolean(FIELD_ENABLED, this.isEnabled);
        return bundle;
    }

    public static CommandButton fromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_COMMAND);
        SessionCommand fromBundle = bundle2 == null ? null : SessionCommand.fromBundle(bundle2);
        int i = bundle.getInt(FIELD_PLAYER_COMMAND, -1);
        int i2 = bundle.getInt(FIELD_ICON_RES_ID, 0);
        CharSequence charSequence = bundle.getCharSequence(FIELD_DISPLAY_NAME, "");
        Bundle bundle3 = bundle.getBundle(FIELD_EXTRAS);
        boolean z = bundle.getBoolean(FIELD_ENABLED, false);
        Uri uri = (Uri) bundle.getParcelable(FIELD_ICON_URI);
        Builder builder = new Builder();
        if (fromBundle != null) {
            builder.setSessionCommand(fromBundle);
        }
        if (i != -1) {
            builder.setPlayerCommand(i);
        }
        if (uri != null) {
            builder.setIconUri(uri);
        }
        Builder displayName = builder.setIconResId(i2).setDisplayName(charSequence);
        if (bundle3 == null) {
            bundle3 = Bundle.EMPTY;
        }
        return displayName.setExtras(bundle3).setEnabled(z).build();
    }
}
