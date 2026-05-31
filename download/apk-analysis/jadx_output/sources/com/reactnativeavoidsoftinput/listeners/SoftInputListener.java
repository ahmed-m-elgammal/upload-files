package com.reactnativeavoidsoftinput.listeners;

import com.google.firebase.messaging.Constants;
import com.reactnativeavoidsoftinput.AvoidSoftInputView;
import kotlin.Metadata;

/* compiled from: SoftInputListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/reactnativeavoidsoftinput/listeners/SoftInputListener;", "", AvoidSoftInputView.ON_SOFT_INPUT_HEIGHT_CHANGE, "", Constants.MessagePayloadKeys.FROM, "", "to", "isOrientationChanged", "", AvoidSoftInputView.ON_SOFT_INPUT_HIDDEN, AvoidSoftInputView.ON_SOFT_INPUT_SHOWN, "react-native-avoid-softinput_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SoftInputListener {
    void onSoftInputHeightChange(int from, int to, boolean isOrientationChanged);

    void onSoftInputHidden(int from, int to);

    void onSoftInputShown(int from, int to);
}
