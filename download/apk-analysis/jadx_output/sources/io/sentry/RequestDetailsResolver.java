package io.sentry;

import io.sentry.util.Objects;
import java.net.URI;
import java.util.HashMap;

/* loaded from: classes6.dex */
final class RequestDetailsResolver {
    private static final String SENTRY_AUTH = "X-Sentry-Auth";
    private static final String USER_AGENT = "User-Agent";
    private final SentryOptions options;

    public RequestDetailsResolver(SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "options is required");
    }

    RequestDetails resolve() {
        String str;
        Dsn retrieveParsedDsn = this.options.retrieveParsedDsn();
        URI sentryUri = retrieveParsedDsn.getSentryUri();
        String uri = sentryUri.resolve(sentryUri.getPath() + "/envelope/").toString();
        String publicKey = retrieveParsedDsn.getPublicKey();
        String secretKey = retrieveParsedDsn.getSecretKey();
        StringBuilder sb = new StringBuilder("Sentry sentry_version=7,sentry_client=");
        sb.append(this.options.getSentryClientName());
        sb.append(",sentry_key=");
        sb.append(publicKey);
        if (secretKey == null || secretKey.length() <= 0) {
            str = "";
        } else {
            str = ",sentry_secret=" + secretKey;
        }
        sb.append(str);
        String sb2 = sb.toString();
        String sentryClientName = this.options.getSentryClientName();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", sentryClientName);
        hashMap.put(SENTRY_AUTH, sb2);
        return new RequestDetails(uri, hashMap);
    }
}
