package expo.modules.devlauncher.helpers;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherInstallationIDHelper.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/devlauncher/helpers/DevLauncherInstallationIDHelper;", "", "()V", "installationID", "", "getInstallationID", "context", "Landroid/content/Context;", "getInstallationIDFile", "Ljava/io/File;", "getInstallationIDFile$expo_dev_launcher_release", "getOrCreateInstallationID", "setInstallationID", "", "newID", "Companion", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherInstallationIDHelper {
    public static final String INSTALLATION_ID_FILENAME = "expo-dev-launcher-installation-id.txt";
    private String installationID;
    private static final String TAG = "DevLauncherInstallationIDHelper";

    public final String getOrCreateInstallationID(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String installationID = getInstallationID(context);
        if (installationID != null) {
            return installationID;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        setInstallationID(uuid, context);
        return uuid;
    }

    private final String getInstallationID(Context context) {
        String str = this.installationID;
        if (str != null) {
            return str;
        }
        File installationIDFile$expo_dev_launcher_release = getInstallationIDFile$expo_dev_launcher_release(context);
        try {
            if (installationIDFile$expo_dev_launcher_release.exists()) {
                BufferedReader fileReader = new FileReader(installationIDFile$expo_dev_launcher_release);
                try {
                    fileReader = new BufferedReader(fileReader);
                    try {
                        this.installationID = fileReader.readLine();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileReader, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileReader, null);
                    } finally {
                    }
                } finally {
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to read stored installation ID", e);
        }
        return this.installationID;
    }

    private final void setInstallationID(String newID, Context context) {
        this.installationID = newID;
        try {
            FileWriter fileWriter = new FileWriter(getInstallationIDFile$expo_dev_launcher_release(context));
            try {
                fileWriter.write(this.installationID);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileWriter, null);
            } finally {
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to write or set resource values to installation ID file", e);
        }
    }

    public final File getInstallationIDFile$expo_dev_launcher_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new File(context.getNoBackupFilesDir(), INSTALLATION_ID_FILENAME);
    }
}
