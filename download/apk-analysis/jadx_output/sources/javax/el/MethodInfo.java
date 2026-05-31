package javax.el;

/* loaded from: classes6.dex */
public class MethodInfo {
    private String name;
    private Class<?>[] paramTypes;
    private Class<?> returnType;

    public MethodInfo(String str, Class<?> cls, Class<?>[] clsArr) {
        this.name = str;
        this.returnType = cls;
        this.paramTypes = clsArr;
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getReturnType() {
        return this.returnType;
    }

    public Class<?>[] getParamTypes() {
        return this.paramTypes;
    }
}
