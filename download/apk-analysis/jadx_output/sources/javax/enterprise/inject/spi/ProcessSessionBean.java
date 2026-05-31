package javax.enterprise.inject.spi;

/* loaded from: classes6.dex */
public interface ProcessSessionBean<X> extends ProcessManagedBean<Object> {
    String getEjbName();

    SessionBeanType getSessionBeanType();
}
