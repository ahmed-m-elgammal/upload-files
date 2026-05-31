package javax.enterprise.context.spi;

/* loaded from: classes6.dex */
public interface CreationalContext<T> {
    void push(T t);

    void release();
}
