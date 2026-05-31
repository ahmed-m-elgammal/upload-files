package javax.portlet.filter;

import javax.portlet.PortletException;

/* loaded from: classes6.dex */
public interface PortletFilter {
    void destroy();

    void init(FilterConfig filterConfig) throws PortletException;
}
