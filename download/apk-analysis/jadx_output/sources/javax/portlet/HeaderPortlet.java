package javax.portlet;

import java.io.IOException;

/* loaded from: classes6.dex */
public interface HeaderPortlet {
    void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse) throws PortletException, IOException;
}
