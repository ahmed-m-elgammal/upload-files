package com.RNAppleAuthentication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.RNAppleAuthentication.webview.SignInWebViewDialogFragment;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import io.sentry.rrweb.RRWebVideoEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SignInWithAppleService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\rR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService;", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragmentTag", "", "configuration", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "callback", "Lcom/RNAppleAuthentication/SignInWithAppleCallback;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;Lcom/RNAppleAuthentication/SignInWithAppleCallback;)V", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;Lkotlin/jvm/functions/Function1;)V", "show", "AuthenticationAttempt", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SignInWithAppleService {
    private final Function1<SignInWithAppleResult, Unit> callback;
    private final SignInWithAppleConfiguration configuration;
    private final FragmentManager fragmentManager;
    private final String fragmentTag;

    /* JADX WARN: Multi-variable type inference failed */
    public SignInWithAppleService(FragmentManager fragmentManager, String fragmentTag, SignInWithAppleConfiguration configuration, Function1<? super SignInWithAppleResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.fragmentManager = fragmentManager;
        this.fragmentTag = fragmentTag;
        this.configuration = configuration;
        this.callback = callback;
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(fragmentTag);
        SignInWebViewDialogFragment signInWebViewDialogFragment = findFragmentByTag instanceof SignInWebViewDialogFragment ? (SignInWebViewDialogFragment) findFragmentByTag : null;
        if (signInWebViewDialogFragment != null) {
            signInWebViewDialogFragment.configure(callback);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignInWithAppleService(FragmentManager fragmentManager, String fragmentTag, SignInWithAppleConfiguration configuration, SignInWithAppleCallback callback) {
        this(fragmentManager, fragmentTag, configuration, SignInWithAppleCallbackKt.toFunction(callback));
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* compiled from: SignInWithAppleService.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "authenticationUri", "", "redirectUri", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthenticationUri", "()Ljava/lang/String;", "getRedirectUri", "getState", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "writeToParcel", "", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "CREATOR", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AuthenticationAttempt implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String authenticationUri;
        private final String redirectUri;
        private final String state;

        public static /* synthetic */ AuthenticationAttempt copy$default(AuthenticationAttempt authenticationAttempt, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = authenticationAttempt.authenticationUri;
            }
            if ((i & 2) != 0) {
                str2 = authenticationAttempt.redirectUri;
            }
            if ((i & 4) != 0) {
                str3 = authenticationAttempt.state;
            }
            return authenticationAttempt.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAuthenticationUri() {
            return this.authenticationUri;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRedirectUri() {
            return this.redirectUri;
        }

        /* renamed from: component3, reason: from getter */
        public final String getState() {
            return this.state;
        }

        public final AuthenticationAttempt copy(String authenticationUri, String redirectUri, String state) {
            Intrinsics.checkNotNullParameter(authenticationUri, "authenticationUri");
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Intrinsics.checkNotNullParameter(state, "state");
            return new AuthenticationAttempt(authenticationUri, redirectUri, state);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthenticationAttempt)) {
                return false;
            }
            AuthenticationAttempt authenticationAttempt = (AuthenticationAttempt) other;
            return Intrinsics.areEqual(this.authenticationUri, authenticationAttempt.authenticationUri) && Intrinsics.areEqual(this.redirectUri, authenticationAttempt.redirectUri) && Intrinsics.areEqual(this.state, authenticationAttempt.state);
        }

        public int hashCode() {
            return (((this.authenticationUri.hashCode() * 31) + this.redirectUri.hashCode()) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "AuthenticationAttempt(authenticationUri=" + this.authenticationUri + ", redirectUri=" + this.redirectUri + ", state=" + this.state + ")";
        }

        public AuthenticationAttempt(String authenticationUri, String redirectUri, String state) {
            Intrinsics.checkNotNullParameter(authenticationUri, "authenticationUri");
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Intrinsics.checkNotNullParameter(state, "state");
            this.authenticationUri = authenticationUri;
            this.redirectUri = redirectUri;
            this.state = state;
        }

        public final String getAuthenticationUri() {
            return this.authenticationUri;
        }

        public final String getRedirectUri() {
            return this.redirectUri;
        }

        public final String getState() {
            return this.state;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public AuthenticationAttempt(android.os.Parcel r4) {
            /*
                r3 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = r4.readString()
                java.lang.String r1 = "invalid"
                if (r0 != 0) goto Le
                r0 = r1
            Le:
                java.lang.String r2 = r4.readString()
                if (r2 != 0) goto L15
                r2 = r1
            L15:
                java.lang.String r4 = r4.readString()
                if (r4 != 0) goto L1c
                goto L1d
            L1c:
                r1 = r4
            L1d:
                r3.<init>(r0, r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.RNAppleAuthentication.SignInWithAppleService.AuthenticationAttempt.<init>(android.os.Parcel):void");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.authenticationUri);
            parcel.writeString(this.redirectUri);
            parcel.writeString(this.state);
        }

        /* compiled from: SignInWithAppleService.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "()V", "create", "configuration", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", RRWebVideoEvent.JsonKeys.SIZE, "", "(I)[Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.RNAppleAuthentication.SignInWithAppleService$AuthenticationAttempt$CREATOR, reason: from kotlin metadata */
        public static final class Companion implements Parcelable.Creator<AuthenticationAttempt> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AuthenticationAttempt createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AuthenticationAttempt(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AuthenticationAttempt[] newArray(int size) {
                return new AuthenticationAttempt[size];
            }

            public final AuthenticationAttempt create(SignInWithAppleConfiguration configuration) {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Uri.Builder buildUpon = Uri.parse("https://appleid.apple.com/auth/authorize").buildUpon();
                buildUpon.appendQueryParameter("client_id", configuration.getClientId());
                buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, configuration.getRedirectUri());
                buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, configuration.getResponseType());
                buildUpon.appendQueryParameter("scope", configuration.getScope());
                buildUpon.appendQueryParameter("response_mode", "form_post");
                buildUpon.appendQueryParameter("state", configuration.getState());
                if (!StringsKt.isBlank(configuration.getNonce())) {
                    buildUpon.appendQueryParameter("nonce", configuration.getNonce());
                }
                String uri = buildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                return new AuthenticationAttempt(uri, configuration.getRedirectUri(), configuration.getState());
            }
        }
    }

    public final void show() {
        SignInWebViewDialogFragment newInstance = SignInWebViewDialogFragment.INSTANCE.newInstance(AuthenticationAttempt.INSTANCE.create(this.configuration));
        newInstance.configure(this.callback);
        newInstance.show(this.fragmentManager, this.fragmentTag);
    }
}
