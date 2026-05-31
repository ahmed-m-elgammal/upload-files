package expo.modules.devmenu;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyValueCachedProperty.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/devmenu/KeyValueCachedPropertyProxy;", "TKey", "TValue", "", "loader", "Lkotlin/Function1;", "container", "Ljava/util/WeakHashMap;", "(Lkotlin/jvm/functions/Function1;Ljava/util/WeakHashMap;)V", "get", SDKConstants.PARAM_KEY, "(Ljava/lang/Object;)Ljava/lang/Object;", "expo-dev-menu_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KeyValueCachedPropertyProxy<TKey, TValue> {
    private final WeakHashMap<TKey, TValue> container;
    private Function1<? super TKey, ? extends TValue> loader;

    public KeyValueCachedPropertyProxy(Function1<? super TKey, ? extends TValue> loader, WeakHashMap<TKey, TValue> container) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        Intrinsics.checkNotNullParameter(container, "container");
        this.loader = loader;
        this.container = container;
    }

    public final TValue get(TKey key) {
        if (!this.container.containsKey(key)) {
            this.container.put(key, this.loader.invoke(key));
        }
        TValue tvalue = this.container.get(key);
        Intrinsics.checkNotNull(tvalue);
        return tvalue;
    }
}
