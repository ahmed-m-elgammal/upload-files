package com.microsoft.clarity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.microsoft.clarity.a.A;
import com.microsoft.clarity.a.B;
import com.microsoft.clarity.a.C;
import com.microsoft.clarity.a.C0055f;
import com.microsoft.clarity.a.C0056g;
import com.microsoft.clarity.a.D;
import com.microsoft.clarity.a.E;
import com.microsoft.clarity.a.F;
import com.microsoft.clarity.a.j;
import com.microsoft.clarity.a.k;
import com.microsoft.clarity.a.l;
import com.microsoft.clarity.a.m;
import com.microsoft.clarity.a.n;
import com.microsoft.clarity.a.p;
import com.microsoft.clarity.a.q;
import com.microsoft.clarity.a.r;
import com.microsoft.clarity.a.u;
import com.microsoft.clarity.a.x;
import com.microsoft.clarity.a.y;
import com.microsoft.clarity.a.z;
import com.microsoft.clarity.f.o;
import com.microsoft.clarity.f.s;
import com.microsoft.clarity.f.t;
import com.microsoft.clarity.m.f;
import com.microsoft.clarity.m.h;
import com.microsoft.clarity.models.LogLevel;
import com.microsoft.clarity.models.PageMetadata;
import com.microsoft.clarity.models.SessionMetadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public class Clarity {
    public static String getCurrentSessionId() {
        s sVar = F.f18a;
        s sVar2 = F.f18a;
        if (sVar2 == null) {
            h.e("Clarity has not started yet.");
            return null;
        }
        String a2 = t.a(sVar2.b);
        if (a2 != null) {
            return a2;
        }
        h.e("No Clarity session has started yet.");
        return a2;
    }

    public static String getCurrentSessionUrl() {
        String a2;
        String userId;
        SessionMetadata sessionMetadata;
        s sVar = F.f18a;
        s sVar2 = F.f18a;
        if (sVar2 == null) {
            h.e("Clarity has not started yet.");
            a2 = null;
        } else {
            a2 = t.a(sVar2.b);
            if (a2 == null) {
                h.e("No Clarity session has started yet.");
            }
        }
        if (a2 == null) {
            return null;
        }
        s sVar3 = F.f18a;
        if (sVar3 == null) {
            h.e("Clarity has not started yet.");
            userId = null;
        } else {
            PageMetadata c = sVar3.b.c();
            userId = (c == null || (sessionMetadata = c.getSessionMetadata()) == null) ? null : sessionMetadata.getUserId();
            if (userId == null) {
                h.e("No Clarity session has started yet.");
            }
        }
        if (userId == null) {
            return null;
        }
        ClarityConfig clarityConfig = F.d;
        String projectId = clarityConfig != null ? clarityConfig.getProjectId() : null;
        if (projectId == null) {
            h.e("Clarity has not started yet.");
        }
        if (projectId == null) {
            return null;
        }
        return Uri.parse("https://clarity.microsoft.com/player/").buildUpon().appendPath(projectId).appendPath(userId).appendPath(a2).build().toString();
    }

    public static Boolean initialize(Context context, ClarityConfig config) {
        if (context == null || config == null) {
            h.c("context and config parameters cannot be null.");
            return Boolean.FALSE;
        }
        s sVar = F.f18a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        return Boolean.valueOf(f.a(new C0055f(null, context, config), C0056g.f27a, (o) null, 26));
    }

    public static Boolean isPaused() {
        boolean z;
        s sVar = F.f18a;
        synchronized (F.p) {
            z = F.o;
        }
        return Boolean.valueOf(z);
    }

    public static Boolean maskView(View view) {
        if (view == null) {
            h.c("View cannot be null.");
            return Boolean.FALSE;
        }
        s sVar = F.f18a;
        Intrinsics.checkNotNullParameter(view, "view");
        LogLevel logLevel = h.f192a;
        h.d("Mask view " + view + '.');
        return Boolean.valueOf(f.a(new j(view), k.f31a, (o) null, 26));
    }

    public static Boolean pause() {
        s sVar = F.f18a;
        return Boolean.valueOf(f.a(l.f32a, m.f33a, (o) null, 26));
    }

    public static Boolean resume() {
        s sVar = F.f18a;
        return Boolean.valueOf(f.a(n.f34a, com.microsoft.clarity.a.o.f35a, (o) null, 26));
    }

    public static boolean sendCustomEvent(String value) {
        if (value == null) {
            h.c("Custom event value cannot be null.");
            return false;
        }
        s sVar = F.f18a;
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(value)) {
            h.c("Custom event value cannot be blank.");
            return false;
        }
        if (value.length() < 254) {
            return f.a(new p(value), q.f37a, (o) null, 26);
        }
        h.c("Custom event value length should be less than 254 characters.");
        return false;
    }

    public static Boolean setCurrentScreenName(String str) {
        s sVar = F.f18a;
        boolean z = false;
        if (str != null && StringsKt.isBlank(str)) {
            h.c("Current screen name cannot be blank.");
        } else if (str == null || str.length() < 255) {
            z = f.a(new z(str), A.f13a, (o) null, 26);
        } else {
            h.c("Current screen name length should be less than 255 characters.");
        }
        return Boolean.valueOf(z);
    }

    public static Boolean setCustomSessionId(String customSessionId) {
        if (customSessionId == null) {
            h.c("Custom session id cannot be null.");
            return Boolean.FALSE;
        }
        s sVar = F.f18a;
        Intrinsics.checkNotNullParameter(customSessionId, "customSessionId");
        LogLevel logLevel = h.f192a;
        h.d("Setting custom session id to " + customSessionId + '.');
        boolean z = false;
        if (StringsKt.isBlank(customSessionId)) {
            h.c("Custom session id cannot be blank.");
        } else if (customSessionId.length() > 255) {
            h.c("Custom session id length cannot exceed 255 characters.");
        } else {
            z = f.a(new r(customSessionId), com.microsoft.clarity.a.s.f39a, (o) null, 26);
        }
        return Boolean.valueOf(z);
    }

    public static boolean setCustomTag(String key, String value) {
        if (key == null || value == null) {
            h.c("Custom tag key and value cannot be null.");
            return false;
        }
        s sVar = F.f18a;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(key) || StringsKt.isBlank(value)) {
            h.c("Custom tag key and value cannot be blank.");
            return false;
        }
        if (key.length() < 255 && value.length() < 255) {
            return f.a(new com.microsoft.clarity.a.t(key, value), u.f41a, (o) null, 26);
        }
        h.c("Custom tag key and value length should be less than 255 characters.");
        return false;
    }

    public static Boolean setCustomUserId(String str) {
        if (str == null) {
            h.c("Custom user id cannot be null.");
            return Boolean.FALSE;
        }
        s sVar = F.f18a;
        return Boolean.valueOf(F.a(str));
    }

    public static Boolean setOnSessionStartedCallback(Function1<String, Unit> callback) {
        if (callback == null) {
            h.c("Callback function cannot be null.");
            return Boolean.FALSE;
        }
        s sVar = F.f18a;
        Intrinsics.checkNotNullParameter(callback, "callback");
        return Boolean.valueOf(f.a(new x(callback), y.f45a, (o) null, 26));
    }

    public static Boolean startNewSession(Function1<String, Unit> function1) {
        s sVar = F.f18a;
        return Boolean.valueOf(f.a(new B(function1), C.f15a, (o) null, 26));
    }

    public static Boolean unmaskView(View view) {
        if (view == null) {
            h.c("View cannot be null.");
            return Boolean.FALSE;
        }
        s sVar = F.f18a;
        Intrinsics.checkNotNullParameter(view, "view");
        LogLevel logLevel = h.f192a;
        h.d("Unmask view " + view + '.');
        return Boolean.valueOf(f.a(new D(view), E.f17a, (o) null, 26));
    }

    public static Boolean initialize(Activity activity, ClarityConfig config) {
        if (activity != null && config != null) {
            s sVar = F.f18a;
            Context context = activity.getApplicationContext();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            return Boolean.valueOf(f.a(new C0055f(activity, context, config), C0056g.f27a, (o) null, 26));
        }
        h.c("activity and config parameters cannot be null.");
        return Boolean.FALSE;
    }
}
