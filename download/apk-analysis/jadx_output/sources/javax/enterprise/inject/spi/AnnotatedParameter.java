package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface AnnotatedParameter<X> extends Annotated {
    AnnotatedCallable<X> getDeclaringCallable();

    int getPosition();
}
