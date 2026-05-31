package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProcessBeanAttributes<T> {
    void addDefinitionError(Throwable th);

    Annotated getAnnotated();

    BeanAttributes<T> getBeanAttributes();

    void setBeanAttributes(BeanAttributes<T> beanAttributes);

    void veto();
}
