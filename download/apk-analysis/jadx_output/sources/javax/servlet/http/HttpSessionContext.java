package javax.servlet.http;

import java.util.Enumeration;

@Deprecated
/* loaded from: classes6.dex */
public interface HttpSessionContext {
    @Deprecated
    Enumeration<String> getIds();

    @Deprecated
    HttpSession getSession(String str);
}
