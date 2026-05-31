package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProcessAnnotatedType<X> {
    AnnotatedType<X> getAnnotatedType();

    void setAnnotatedType(AnnotatedType<X> annotatedType);

    void veto();
}
