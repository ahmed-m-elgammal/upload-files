package com.RNAppleAuthentication;

import com.RNAppleAuthentication.SignInWithAppleResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInWithAppleCallback.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toFunction", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "Lcom/RNAppleAuthentication/SignInWithAppleCallback;", "invertase_react-native-apple-authentication_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SignInWithAppleCallbackKt {
    public static final Function1<SignInWithAppleResult, Unit> toFunction(final SignInWithAppleCallback signInWithAppleCallback) {
        Intrinsics.checkNotNullParameter(signInWithAppleCallback, "<this>");
        return new Function1<SignInWithAppleResult, Unit>() { // from class: com.RNAppleAuthentication.SignInWithAppleCallbackKt$toFunction$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SignInWithAppleResult signInWithAppleResult) {
                invoke2(signInWithAppleResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SignInWithAppleResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result instanceof SignInWithAppleResult.Success) {
                    SignInWithAppleResult.Success success = (SignInWithAppleResult.Success) result;
                    SignInWithAppleCallback.this.onSignInWithAppleSuccess(success.getCode(), success.getId_token(), success.getState(), success.getUser());
                } else if (result instanceof SignInWithAppleResult.Failure) {
                    SignInWithAppleCallback.this.onSignInWithAppleFailure(((SignInWithAppleResult.Failure) result).getError());
                } else if (result instanceof SignInWithAppleResult.Cancel) {
                    SignInWithAppleCallback.this.onSignInWithAppleCancel();
                }
            }
        };
    }
}
