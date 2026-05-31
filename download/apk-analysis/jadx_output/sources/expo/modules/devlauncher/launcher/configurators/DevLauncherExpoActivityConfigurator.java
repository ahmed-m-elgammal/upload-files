package expo.modules.devlauncher.launcher.configurators;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.facebook.react.ReactActivity;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.devlauncher.helpers.DevLauncherColorsHelperKt;
import expo.modules.devlauncher.launcher.manifest.DevLauncherNavigationBarVisibility;
import expo.modules.devlauncher.launcher.manifest.DevLauncherOrientation;
import expo.modules.manifests.core.Manifest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DevLauncherExpoActivityConfigurator.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u000eH\u0003J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\u000eH\u0003J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u000eH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/devlauncher/launcher/configurators/DevLauncherExpoActivityConfigurator;", "", "manifest", "Lexpo/modules/manifests/core/Manifest;", "context", "Landroid/content/Context;", "(Lexpo/modules/manifests/core/Manifest;Landroid/content/Context;)V", "applyNavigationBarConfiguration", "", "activity", "Lcom/facebook/react/ReactActivity;", "applyOrientation", "applyStatusBarConfiguration", "applyTaskDescription", "Landroid/app/Activity;", "setColor", "color", "", "setHidden", ViewProps.HIDDEN, "", "setStyle", "", "style", "setTranslucent", "translucent", "Companion", "expo-dev-launcher_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevLauncherExpoActivityConfigurator {
    private static final String TAG = "DevLauncherExpoActivityConfigurator";
    private final Context context;
    private Manifest manifest;

    public DevLauncherExpoActivityConfigurator(Manifest manifest, Context context) {
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(context, "context");
        this.manifest = manifest;
        this.context = context;
    }

    public final void applyTaskDescription(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (DevLauncherColorsHelperKt.isValidColor(this.manifest.getPrimaryColor())) {
            int parseColor = Color.parseColor(this.manifest.getPrimaryColor());
            activity.setTaskDescription(new ActivityManager.TaskDescription(this.manifest.getName(), BitmapFactory.decodeResource(this.context.getResources(), this.context.getApplicationInfo().icon), parseColor));
        }
    }

    public final void applyOrientation(ReactActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String orientation = this.manifest.getOrientation();
        if (orientation != null) {
            int hashCode = orientation.hashCode();
            if (hashCode != 729267099) {
                if (hashCode != 1430647483) {
                    if (hashCode == 1544803905 && orientation.equals("default")) {
                        activity.setRequestedOrientation(-1);
                        return;
                    }
                } else if (orientation.equals(DevLauncherOrientation.LANDSCAPE)) {
                    activity.setRequestedOrientation(0);
                    return;
                }
            } else if (orientation.equals(DevLauncherOrientation.PORTRAIT)) {
                activity.setRequestedOrientation(1);
                return;
            }
        }
        activity.setRequestedOrientation(-1);
    }

    public final void applyStatusBarConfiguration(final ReactActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        JSONObject androidStatusBarOptions = this.manifest.getAndroidStatusBarOptions();
        final String optString = androidStatusBarOptions != null ? androidStatusBarOptions.optString("barStyle") : null;
        final String optString2 = androidStatusBarOptions != null ? androidStatusBarOptions.optString("backgroundColor") : null;
        final boolean z = androidStatusBarOptions == null || androidStatusBarOptions.optBoolean("translucent", true);
        final boolean z2 = androidStatusBarOptions != null && androidStatusBarOptions.optBoolean(ViewProps.HIDDEN, false);
        activity.runOnUiThread(new Runnable() { // from class: expo.modules.devlauncher.launcher.configurators.DevLauncherExpoActivityConfigurator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DevLauncherExpoActivityConfigurator.applyStatusBarConfiguration$lambda$0(ReactActivity.this, this, z2, z, optString, optString2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyStatusBarConfiguration$lambda$0(ReactActivity activity, DevLauncherExpoActivityConfigurator this$0, boolean z, boolean z2, String str, String str2) {
        int parseColor;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        activity.getWindow().clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        ReactActivity reactActivity = activity;
        this$0.setHidden(z, reactActivity);
        this$0.setTranslucent(z2, reactActivity);
        String style = this$0.setStyle(str, reactActivity);
        String RGBAtoARGB = DevLauncherColorsHelperKt.RGBAtoARGB(str2);
        if (RGBAtoARGB == null || !DevLauncherColorsHelperKt.isValidColor(RGBAtoARGB)) {
            parseColor = Intrinsics.areEqual(style, "light-content") ? Color.parseColor("#88000000") : 0;
        } else {
            parseColor = Color.parseColor(RGBAtoARGB);
        }
        this$0.setColor(parseColor, reactActivity);
    }

    private final String setStyle(String style, Activity activity) {
        int i;
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        int systemUiVisibility = decorView.getSystemUiVisibility();
        String str = "light-content";
        if (Intrinsics.areEqual(style, "light-content")) {
            i = systemUiVisibility & (-8193);
        } else {
            str = "dark-content";
            Intrinsics.areEqual(style, "dark-content");
            i = systemUiVisibility | 8192;
        }
        decorView.setSystemUiVisibility(i);
        return str;
    }

    private final void setHidden(boolean hidden, Activity activity) {
        if (hidden) {
            activity.getWindow().addFlags(1024);
            activity.getWindow().clearFlags(2048);
        } else {
            activity.getWindow().addFlags(2048);
            activity.getWindow().clearFlags(1024);
        }
    }

    private final void setTranslucent(boolean translucent, Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (translucent) {
            decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: expo.modules.devlauncher.launcher.configurators.DevLauncherExpoActivityConfigurator$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    WindowInsets translucent$lambda$1;
                    translucent$lambda$1 = DevLauncherExpoActivityConfigurator.setTranslucent$lambda$1(view, windowInsets);
                    return translucent$lambda$1;
                }
            });
        } else {
            decorView.setOnApplyWindowInsetsListener(null);
        }
        ViewCompat.requestApplyInsets(decorView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets setTranslucent$lambda$1(View v, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(v, "v");
        WindowInsets onApplyWindowInsets = v.onApplyWindowInsets(windowInsets);
        return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
    }

    public final void setColor(int color, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().setStatusBarColor(color);
    }

    public final void applyNavigationBarConfiguration(ReactActivity activity) {
        int i;
        Intrinsics.checkNotNullParameter(activity, "activity");
        JSONObject androidNavigationBarOptions = this.manifest.getAndroidNavigationBarOptions();
        if (androidNavigationBarOptions == null) {
            return;
        }
        String optString = androidNavigationBarOptions.optString("backgroundColor");
        if (DevLauncherColorsHelperKt.isValidColor(optString)) {
            try {
                activity.getWindow().clearFlags(134217728);
                activity.getWindow().setNavigationBarColor(Color.parseColor(optString));
            } catch (Throwable th) {
                Log.e(TAG, "Failed to configure androidNavigationBar.backgroundColor", th);
            }
        }
        String optString2 = androidNavigationBarOptions.optString("barStyle");
        if (!Intrinsics.areEqual(optString2, "") && Build.VERSION.SDK_INT >= 26) {
            try {
                activity.getWindow().clearFlags(134217728);
                activity.getWindow().addFlags(Integer.MIN_VALUE);
                if (Intrinsics.areEqual(optString2, "dark-content")) {
                    View decorView = activity.getWindow().getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
                }
            } catch (Throwable th2) {
                Log.e(TAG, "Failed to configure androidNavigationBar.barStyle", th2);
            }
        }
        String optString3 = androidNavigationBarOptions.optString(ViewProps.VISIBLE);
        if (Intrinsics.areEqual(optString3, "")) {
            return;
        }
        View decorView2 = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView2, "getDecorView(...)");
        int systemUiVisibility = decorView2.getSystemUiVisibility();
        if (optString3 != null) {
            int hashCode = optString3.hashCode();
            if (hashCode != -1197068329) {
                if (hashCode != 1137617595) {
                    if (hashCode == 1570144589 && optString3.equals(DevLauncherNavigationBarVisibility.LEANBACK)) {
                        i = 6;
                    }
                } else if (optString3.equals(DevLauncherNavigationBarVisibility.IMMERSIVE)) {
                    i = 2054;
                }
            } else if (optString3.equals(DevLauncherNavigationBarVisibility.STICKY_IMMERSIVE)) {
                i = 4102;
            }
            decorView2.setSystemUiVisibility(i | systemUiVisibility);
        }
        i = 0;
        decorView2.setSystemUiVisibility(i | systemUiVisibility);
    }
}
