package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProcessProducer<T, X> {
    void addDefinitionError(Throwable th);

    AnnotatedMember<T> getAnnotatedMember();

    Producer<X> getProducer();

    void setProducer(Producer<X> producer);
}
