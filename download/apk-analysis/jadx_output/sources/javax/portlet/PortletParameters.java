package javax.portlet;

import java.util.Set;

/* loaded from: classes6.dex */
public interface PortletParameters {
    /* renamed from: clone */
    MutablePortletParameters mo2561clone();

    Set<String> getNames();

    String getValue(String str);

    String[] getValues(String str);

    boolean isEmpty();

    int size();
}
