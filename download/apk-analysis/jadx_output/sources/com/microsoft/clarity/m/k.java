package com.microsoft.clarity.m;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public abstract class k {
    public static String a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string, "\\", "\\\\", false, 4, (Object) null), "\"", "\\\"", false, 4, (Object) null), IOUtils.LINE_SEPARATOR_WINDOWS, " ", false, 4, (Object) null), "\n", " ", false, 4, (Object) null);
    }

    public static Set a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                linkedHashSet.add(string);
            }
            return linkedHashSet;
        }
        return SetsKt.emptySet();
    }
}
