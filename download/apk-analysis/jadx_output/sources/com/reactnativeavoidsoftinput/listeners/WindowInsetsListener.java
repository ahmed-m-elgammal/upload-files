package com.reactnativeavoidsoftinput.listeners;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: WindowInsetsListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/reactnativeavoidsoftinput/listeners/WindowInsetsListener;", "", "registerWindowInsetsListener", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "setSoftInputListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/reactnativeavoidsoftinput/listeners/SoftInputListener;", "unregisterWindowInsetsListener", "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface WindowInsetsListener {
    void registerWindowInsetsListener(View view);

    void setSoftInputListener(SoftInputListener listener);

    void unregisterWindowInsetsListener(View view);
}
