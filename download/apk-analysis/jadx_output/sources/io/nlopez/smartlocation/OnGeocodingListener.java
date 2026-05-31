package io.nlopez.smartlocation;

import io.nlopez.smartlocation.geocoding.utils.LocationAddress;
import java.util.List;

/* loaded from: classes6.dex */
public interface OnGeocodingListener {
    void onLocationResolved(String str, List<LocationAddress> list);
}
