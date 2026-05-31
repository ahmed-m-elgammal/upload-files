package javax.enterprise.context.spi;

import java.lang.annotation.Annotation;

/* loaded from: classes6.dex */
public interface Context {
    <T> T get(Contextual<T> contextual);

    <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext);

    Class<? extends Annotation> getScope();

    boolean isActive();
}
