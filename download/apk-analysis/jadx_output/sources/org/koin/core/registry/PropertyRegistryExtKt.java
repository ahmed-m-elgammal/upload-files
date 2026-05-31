package org.koin.core.registry;

import com.facebook.common.util.UriUtil;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.koin.core.Koin;
import org.koin.core.error.NoPropertyFileFoundException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;

/* compiled from: PropertyRegistryExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003\u001a\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001¨\u0006\u000b"}, d2 = {"readDataFromFile", "Ljava/util/Properties;", UriUtil.LOCAL_CONTENT_SCHEME, "", "loadEnvironmentProperties", "", "Lorg/koin/core/registry/PropertyRegistry;", "loadPropertiesFromFile", "fileName", "saveProperties", "properties", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PropertyRegistryExtKt {
    public static final void saveProperties(PropertyRegistry propertyRegistry, Properties properties) {
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Logger logger = propertyRegistry.get_koin().getLogger();
        String str = "load " + properties.size() + " properties";
        Level level = Level.DEBUG;
        if (logger.isAt(level)) {
            logger.display(level, str);
        }
        Map map = MapsKt.toMap(properties);
        Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        for (Map.Entry entry : map.entrySet()) {
            propertyRegistry.saveProperty$koin_core((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static final void loadPropertiesFromFile(PropertyRegistry propertyRegistry, String fileName) {
        String str;
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Logger logger = propertyRegistry.get_koin().getLogger();
        String str2 = "load properties from " + fileName;
        Level level = Level.DEBUG;
        if (logger.isAt(level)) {
            logger.display(level, str2);
        }
        URL resource = Koin.class.getResource(fileName);
        if (resource != null) {
            str = new String(TextStreamsKt.readBytes(resource), Charsets.UTF_8);
        } else {
            str = null;
        }
        if (str != null) {
            Logger logger2 = propertyRegistry.get_koin().getLogger();
            String str3 = "loaded properties from file:'" + fileName + '\'';
            Level level2 = Level.INFO;
            if (logger2.isAt(level2)) {
                logger2.display(level2, str3);
            }
            saveProperties(propertyRegistry, readDataFromFile(str));
            return;
        }
        throw new NoPropertyFileFoundException("No properties found for file '" + fileName + '\'');
    }

    private static final Properties readDataFromFile(String str) {
        Properties properties = new Properties();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        properties.load(new ByteArrayInputStream(bytes));
        return properties;
    }

    public static final void loadEnvironmentProperties(PropertyRegistry propertyRegistry) {
        Intrinsics.checkNotNullParameter(propertyRegistry, "<this>");
        Logger logger = propertyRegistry.get_koin().getLogger();
        Level level = Level.DEBUG;
        if (logger.isAt(level)) {
            logger.display(level, "load properties from environment");
        }
        Properties sysProperties = System.getProperties();
        Intrinsics.checkNotNullExpressionValue(sysProperties, "sysProperties");
        saveProperties(propertyRegistry, sysProperties);
        Map<String, String> map = System.getenv();
        Intrinsics.checkNotNullExpressionValue(map, "getenv()");
        Properties properties = new Properties();
        properties.putAll(map);
        saveProperties(propertyRegistry, properties);
    }
}
