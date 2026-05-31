package javax.enterprise.inject.spi;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public interface AnnotatedMethod<X> extends AnnotatedCallable<X> {
    @Override // javax.enterprise.inject.spi.AnnotatedMember
    Method getJavaMember();
}
