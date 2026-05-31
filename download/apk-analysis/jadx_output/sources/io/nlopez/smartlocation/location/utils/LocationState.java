package io.nlopez.smartlocation.location.utils;

import android.content.Context;
import android.location.LocationManager;
import android.provider.Settings;
import io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

/* loaded from: classes6.dex */
public class LocationState {
    private static LocationState instance;
    private Context context;
    private LocationManager locationManager;

    private LocationState(Context context) {
        this.context = context;
        this.locationManager = (LocationManager) context.getSystemService(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
    }

    public static LocationState with(Context context) {
        if (instance == null) {
            instance = new LocationState(context.getApplicationContext());
        }
        return instance;
    }

    public boolean locationServicesEnabled() {
        int i;
        try {
            i = Settings.Secure.getInt(this.context.getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        return i != 0;
    }

    public boolean isAnyProviderAvailable() {
        return isGpsAvailable() || isNetworkAvailable();
    }

    public boolean isGpsAvailable() {
        return this.locationManager.isProviderEnabled("gps");
    }

    public boolean isNetworkAvailable() {
        return this.locationManager.isProviderEnabled("network");
    }

    public boolean isPassiveAvailable() {
        return this.locationManager.isProviderEnabled("passive");
    }

    @Deprecated
    public boolean isMockSettingEnabled() {
        return !"0".equals(Settings.Secure.getString(this.context.getContentResolver(), "mock_location"));
    }
}
