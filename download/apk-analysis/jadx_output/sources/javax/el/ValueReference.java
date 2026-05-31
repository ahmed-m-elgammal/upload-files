package javax.el;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class ValueReference implements Serializable {
    private Object base;
    private Object property;

    public ValueReference(Object obj, Object obj2) {
        this.base = obj;
        this.property = obj2;
    }

    public Object getBase() {
        return this.base;
    }

    public Object getProperty() {
        return this.property;
    }
}
