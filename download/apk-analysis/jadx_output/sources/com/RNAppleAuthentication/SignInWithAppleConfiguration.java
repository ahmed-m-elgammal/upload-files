package com.RNAppleAuthentication;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* compiled from: SignInWithAppleConfiguration.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003!\"#B?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "", "clientId", "", "redirectUri", "scope", "responseType", "state", "rawNonce", "nonce", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getNonce", "getRawNonce", "getRedirectUri", "getResponseType", "getScope", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Builder", "ResponseType", "Scope", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SignInWithAppleConfiguration {
    private final String clientId;
    private final String nonce;
    private final String rawNonce;
    private final String redirectUri;
    private final String responseType;
    private final String scope;
    private final String state;

    public /* synthetic */ SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7);
    }

    public static /* synthetic */ SignInWithAppleConfiguration copy$default(SignInWithAppleConfiguration signInWithAppleConfiguration, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signInWithAppleConfiguration.clientId;
        }
        if ((i & 2) != 0) {
            str2 = signInWithAppleConfiguration.redirectUri;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = signInWithAppleConfiguration.scope;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = signInWithAppleConfiguration.responseType;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = signInWithAppleConfiguration.state;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = signInWithAppleConfiguration.rawNonce;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = signInWithAppleConfiguration.nonce;
        }
        return signInWithAppleConfiguration.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    /* renamed from: component3, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* renamed from: component4, reason: from getter */
    public final String getResponseType() {
        return this.responseType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRawNonce() {
        return this.rawNonce;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public final SignInWithAppleConfiguration copy(String clientId, String redirectUri, String scope, String responseType, String state, String rawNonce, String nonce) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(rawNonce, "rawNonce");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        return new SignInWithAppleConfiguration(clientId, redirectUri, scope, responseType, state, rawNonce, nonce);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignInWithAppleConfiguration)) {
            return false;
        }
        SignInWithAppleConfiguration signInWithAppleConfiguration = (SignInWithAppleConfiguration) other;
        return Intrinsics.areEqual(this.clientId, signInWithAppleConfiguration.clientId) && Intrinsics.areEqual(this.redirectUri, signInWithAppleConfiguration.redirectUri) && Intrinsics.areEqual(this.scope, signInWithAppleConfiguration.scope) && Intrinsics.areEqual(this.responseType, signInWithAppleConfiguration.responseType) && Intrinsics.areEqual(this.state, signInWithAppleConfiguration.state) && Intrinsics.areEqual(this.rawNonce, signInWithAppleConfiguration.rawNonce) && Intrinsics.areEqual(this.nonce, signInWithAppleConfiguration.nonce);
    }

    public int hashCode() {
        return (((((((((((this.clientId.hashCode() * 31) + this.redirectUri.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.responseType.hashCode()) * 31) + this.state.hashCode()) * 31) + this.rawNonce.hashCode()) * 31) + this.nonce.hashCode();
    }

    public String toString() {
        return "SignInWithAppleConfiguration(clientId=" + this.clientId + ", redirectUri=" + this.redirectUri + ", scope=" + this.scope + ", responseType=" + this.responseType + ", state=" + this.state + ", rawNonce=" + this.rawNonce + ", nonce=" + this.nonce + ")";
    }

    private SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.clientId = str;
        this.redirectUri = str2;
        this.scope = str3;
        this.responseType = str4;
        this.state = str5;
        this.rawNonce = str6;
        this.nonce = str7;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getState() {
        return this.state;
    }

    public final String getRawNonce() {
        return this.rawNonce;
    }

    public final String getNonce() {
        return this.nonce;
    }

    /* compiled from: SignInWithAppleConfiguration.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Builder;", "", "()V", "clientId", "", "nonce", "rawNonce", "redirectUri", "responseType", "scope", "state", "build", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "type", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private String clientId;
        private String nonce;
        private String rawNonce;
        private String redirectUri;
        private String responseType;
        private String scope;
        private String state;

        public final Builder clientId(String clientId) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            this.clientId = clientId;
            return this;
        }

        public final Builder redirectUri(String redirectUri) {
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            this.redirectUri = redirectUri;
            return this;
        }

        public final Builder scope(Scope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.scope = scope.signal();
            return this;
        }

        public final Builder responseType(ResponseType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.responseType = type.signal();
            return this;
        }

        public final Builder state(String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            return this;
        }

        public final Builder rawNonce(String rawNonce) {
            Intrinsics.checkNotNullParameter(rawNonce, "rawNonce");
            this.rawNonce = rawNonce;
            return this;
        }

        public final Builder nonce(String nonce) {
            Intrinsics.checkNotNullParameter(nonce, "nonce");
            this.nonce = nonce;
            return this;
        }

        public final SignInWithAppleConfiguration build() {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8 = this.clientId;
            if (str8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clientId");
                str = null;
            } else {
                str = str8;
            }
            String str9 = this.redirectUri;
            if (str9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redirectUri");
                str2 = null;
            } else {
                str2 = str9;
            }
            String str10 = this.scope;
            if (str10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scope");
                str3 = null;
            } else {
                str3 = str10;
            }
            String str11 = this.responseType;
            if (str11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("responseType");
                str4 = null;
            } else {
                str4 = str11;
            }
            String str12 = this.state;
            if (str12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("state");
                str5 = null;
            } else {
                str5 = str12;
            }
            String str13 = this.rawNonce;
            if (str13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rawNonce");
                str6 = null;
            } else {
                str6 = str13;
            }
            String str14 = this.nonce;
            if (str14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonce");
                str7 = null;
            } else {
                str7 = str14;
            }
            return new SignInWithAppleConfiguration(str, str2, str3, str4, str5, str6, str7, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SignInWithAppleConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "", "(Ljava/lang/String;I)V", "signal", "", "CODE", "ID_TOKEN", Rule.ALL, "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResponseType[] $VALUES;
        public static final ResponseType CODE = new CODE("CODE", 0);
        public static final ResponseType ID_TOKEN = new ID_TOKEN("ID_TOKEN", 1);
        public static final ResponseType ALL = new ALL(Rule.ALL, 2);

        private static final /* synthetic */ ResponseType[] $values() {
            return new ResponseType[]{CODE, ID_TOKEN, ALL};
        }

        public /* synthetic */ ResponseType(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static EnumEntries<ResponseType> getEntries() {
            return $ENTRIES;
        }

        public static ResponseType valueOf(String str) {
            return (ResponseType) Enum.valueOf(ResponseType.class, str);
        }

        public static ResponseType[] values() {
            return (ResponseType[]) $VALUES.clone();
        }

        public abstract String signal();

        /* compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$CODE;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        static final class CODE extends ResponseType {
            CODE(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "code";
            }
        }

        private ResponseType(String str, int i) {
        }

        static {
            ResponseType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        /* compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$ID_TOKEN;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        static final class ID_TOKEN extends ResponseType {
            ID_TOKEN(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "id_token";
            }
        }

        /* compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$ALL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        static final class ALL extends ResponseType {
            ALL(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "code id_token";
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SignInWithAppleConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "", "(Ljava/lang/String;I)V", "signal", "", "NAME", "EMAIL", Rule.ALL, "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Scope {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Scope[] $VALUES;
        public static final Scope NAME = new NAME("NAME", 0);
        public static final Scope EMAIL = new EMAIL("EMAIL", 1);
        public static final Scope ALL = new ALL(Rule.ALL, 2);

        private static final /* synthetic */ Scope[] $values() {
            return new Scope[]{NAME, EMAIL, ALL};
        }

        public /* synthetic */ Scope(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static EnumEntries<Scope> getEntries() {
            return $ENTRIES;
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }

        public abstract String signal();

        /* compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$NAME;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        static final class NAME extends Scope {
            NAME(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "name";
            }
        }

        private Scope(String str, int i) {
        }

        static {
            Scope[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        /* compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$EMAIL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        static final class EMAIL extends Scope {
            EMAIL(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "email";
            }
        }

        /* compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$ALL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        static final class ALL extends Scope {
            ALL(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "name email";
            }
        }
    }
}
