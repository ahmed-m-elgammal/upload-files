package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface InjectionTargetFactory<T> {
    InjectionTarget<T> createInjectionTarget(Bean<T> bean);
}
