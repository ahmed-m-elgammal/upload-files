package expo.modules.adapters.react.views;

/* loaded from: classes5.dex */
public class ViewManagerAdapterUtils {
    public static String normalizeEventName(String str) {
        if (!str.startsWith("on")) {
            return str;
        }
        return "top" + str.substring(2);
    }
}
