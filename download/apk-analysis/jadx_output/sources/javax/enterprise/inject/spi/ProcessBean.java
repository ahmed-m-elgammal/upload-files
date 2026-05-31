package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProcessBean<X> {
    void addDefinitionError(Throwable th);

    Annotated getAnnotated();

    Bean<X> getBean();
}
