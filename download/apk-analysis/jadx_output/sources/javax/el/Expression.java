package javax.el;

import java.io.Serializable;

/* loaded from: classes6.dex */
public abstract class Expression implements Serializable {
    public abstract boolean equals(Object obj);

    public abstract String getExpressionString();

    public abstract int hashCode();

    public abstract boolean isLiteralText();
}
