package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProducerFactory<X> {
    <T> Producer<T> createProducer(Bean<T> bean);
}
