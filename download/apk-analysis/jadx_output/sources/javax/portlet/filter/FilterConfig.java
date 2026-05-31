package javax.portlet.filter;

import java.util.Enumeration;
import javax.portlet.PortletContext;

/* loaded from: classes6.dex */
public interface FilterConfig {
    String getFilterName();

    String getInitParameter(String str);

    Enumeration<String> getInitParameterNames();

    PortletContext getPortletContext();
}
