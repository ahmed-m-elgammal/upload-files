package javax.portlet.filter;

import javax.portlet.PortletMode;
import javax.portlet.RenderParameters;
import javax.portlet.RenderState;
import javax.portlet.WindowState;

/* loaded from: classes6.dex */
public class RenderStateWrapper implements RenderState {
    protected RenderState wrapped;

    public RenderStateWrapper(RenderState renderState) {
        if (renderState == null) {
            throw new IllegalArgumentException("Object to wrap is null");
        }
        this.wrapped = renderState;
    }

    public RenderState getWrapped() {
        return this.wrapped;
    }

    public void setWrapped(RenderState renderState) {
        if (renderState == null) {
            throw new IllegalArgumentException("Object to wrap is null");
        }
        this.wrapped = renderState;
    }

    @Override // javax.portlet.RenderState
    public RenderParameters getRenderParameters() {
        return this.wrapped.getRenderParameters();
    }

    @Override // javax.portlet.RenderState
    public PortletMode getPortletMode() {
        return this.wrapped.getPortletMode();
    }

    @Override // javax.portlet.RenderState
    public WindowState getWindowState() {
        return this.wrapped.getWindowState();
    }
}
