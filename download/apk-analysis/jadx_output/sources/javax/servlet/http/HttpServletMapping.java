package javax.servlet.http;

/* loaded from: classes6.dex */
public interface HttpServletMapping {
    MappingMatch getMappingMatch();

    String getMatchValue();

    String getPattern();

    String getServletName();
}
