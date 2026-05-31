package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProcessInjectionPoint<T, X> {
    void addDefinitionError(Throwable th);

    InjectionPoint getInjectionPoint();

    void setInjectionPoint(InjectionPoint injectionPoint);
}
