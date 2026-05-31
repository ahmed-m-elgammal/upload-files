package io.grpc;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import io.grpc.NameResolver;
import io.grpc.ServiceProviders;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public final class NameResolverRegistry {
    private static final String UNKNOWN_SCHEME = "unknown";
    private static NameResolverRegistry instance;
    private static final Logger logger = Logger.getLogger(NameResolverRegistry.class.getName());
    private final NameResolver.Factory factory = new NameResolverFactory();
    private String defaultScheme = "unknown";
    private final LinkedHashSet<NameResolverProvider> allProviders = new LinkedHashSet<>();
    private ImmutableMap<String, NameResolverProvider> effectiveProviders = ImmutableMap.of();

    public synchronized String getDefaultScheme() {
        return this.defaultScheme;
    }

    public NameResolverProvider getProviderForScheme(String str) {
        if (str == null) {
            return null;
        }
        return providers().get(str.toLowerCase(Locale.US));
    }

    public synchronized void register(NameResolverProvider nameResolverProvider) {
        addProvider(nameResolverProvider);
        refreshProviders();
    }

    private synchronized void addProvider(NameResolverProvider nameResolverProvider) {
        Preconditions.checkArgument(nameResolverProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(nameResolverProvider);
    }

    public synchronized void deregister(NameResolverProvider nameResolverProvider) {
        this.allProviders.remove(nameResolverProvider);
        refreshProviders();
    }

    private synchronized void refreshProviders() {
        HashMap hashMap = new HashMap();
        String str = "unknown";
        Iterator<NameResolverProvider> it = this.allProviders.iterator();
        int i = Integer.MIN_VALUE;
        while (it.hasNext()) {
            NameResolverProvider next = it.next();
            String scheme = next.getScheme();
            NameResolverProvider nameResolverProvider = (NameResolverProvider) hashMap.get(scheme);
            if (nameResolverProvider == null || nameResolverProvider.priority() < next.priority()) {
                hashMap.put(scheme, next);
            }
            if (i < next.priority()) {
                i = next.priority();
                str = next.getScheme();
            }
        }
        this.effectiveProviders = ImmutableMap.copyOf((Map) hashMap);
        this.defaultScheme = str;
    }

    public static synchronized NameResolverRegistry getDefaultRegistry() {
        NameResolverRegistry nameResolverRegistry;
        synchronized (NameResolverRegistry.class) {
            if (instance == null) {
                List<NameResolverProvider> loadAll = ServiceProviders.loadAll(NameResolverProvider.class, getHardCodedClasses(), NameResolverProvider.class.getClassLoader(), new NameResolverPriorityAccessor());
                if (loadAll.isEmpty()) {
                    logger.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                instance = new NameResolverRegistry();
                for (NameResolverProvider nameResolverProvider : loadAll) {
                    logger.fine("Service loader found " + nameResolverProvider);
                    instance.addProvider(nameResolverProvider);
                }
                instance.refreshProviders();
            }
            nameResolverRegistry = instance;
        }
        return nameResolverRegistry;
    }

    synchronized Map<String, NameResolverProvider> providers() {
        return this.effectiveProviders;
    }

    public NameResolver.Factory asFactory() {
        return this.factory;
    }

    static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.internal.DnsNameResolverProvider"));
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private final class NameResolverFactory extends NameResolver.Factory {
        private NameResolverFactory() {
        }

        @Override // io.grpc.NameResolver.Factory
        @Nullable
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            NameResolverProvider providerForScheme = NameResolverRegistry.this.getProviderForScheme(uri.getScheme());
            if (providerForScheme == null) {
                return null;
            }
            return providerForScheme.newNameResolver(uri, args);
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            return NameResolverRegistry.this.getDefaultScheme();
        }
    }

    private static final class NameResolverPriorityAccessor implements ServiceProviders.PriorityAccessor<NameResolverProvider> {
        private NameResolverPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.isAvailable();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.priority();
        }
    }
}
