package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProcessProducerField<T, X> extends ProcessBean<X> {
    AnnotatedParameter<T> getAnnotatedDisposedParameter();

    AnnotatedField<T> getAnnotatedProducerField();
}
