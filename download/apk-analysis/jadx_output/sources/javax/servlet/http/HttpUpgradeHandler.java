package javax.servlet.http;

/* loaded from: classes6.dex */
public interface HttpUpgradeHandler {
    void destroy();

    void init(WebConnection webConnection);
}
