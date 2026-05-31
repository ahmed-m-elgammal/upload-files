package expo.modules.devlauncher.helpers;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherMetadataHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lexpo/modules/devlauncher/helpers/DevLauncherMetadataHelper;", "", "()V", "getMetadataValue", "", "context", "Landroid/content/Context;", SDKConstants.PARAM_KEY, "defaultValue", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherMetadataHelper {
    public static final DevLauncherMetadataHelper INSTANCE = new DevLauncherMetadataHelper();

    private DevLauncherMetadataHelper() {
    }

    public static /* synthetic */ String getMetadataValue$default(DevLauncherMetadataHelper devLauncherMetadataHelper, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return devLauncherMetadataHelper.getMetadataValue(context, str, str2);
    }

    public final String getMetadataValue(Context context, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
        if (applicationInfo.metaData != null) {
            defaultValue = applicationInfo.metaData.getString(key, defaultValue);
        }
        Intrinsics.checkNotNull(defaultValue);
        return defaultValue;
    }
}
