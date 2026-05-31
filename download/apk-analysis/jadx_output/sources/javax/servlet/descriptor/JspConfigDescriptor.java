package javax.servlet.descriptor;

import java.util.Collection;

/* loaded from: classes6.dex */
public interface JspConfigDescriptor {
    Collection<JspPropertyGroupDescriptor> getJspPropertyGroups();

    Collection<TaglibDescriptor> getTaglibs();
}
