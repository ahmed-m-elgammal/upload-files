package javax.servlet;

import java.util.EventObject;

/* loaded from: classes6.dex */
public class ServletRequestEvent extends EventObject {
    private static final long serialVersionUID = -7467864054698729101L;
    private final transient ServletRequest request;

    public ServletRequestEvent(ServletContext servletContext, ServletRequest servletRequest) {
        super(servletContext);
        this.request = servletRequest;
    }

    public ServletRequest getServletRequest() {
        return this.request;
    }

    public ServletContext getServletContext() {
        return (ServletContext) super.getSource();
    }
}
