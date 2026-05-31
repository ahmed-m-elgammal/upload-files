package javax.portlet;

/* loaded from: classes6.dex */
public class WindowStateException extends PortletException {
    private static final long serialVersionUID = 1;
    private transient WindowState _state;

    public WindowStateException(String str, WindowState windowState) {
        super(str);
        this._state = windowState;
    }

    public WindowStateException(String str, Throwable th, WindowState windowState) {
        super(str, th);
        this._state = windowState;
    }

    public WindowStateException(Throwable th, WindowState windowState) {
        super(th);
        this._state = windowState;
    }

    public WindowState getState() {
        return this._state;
    }
}
