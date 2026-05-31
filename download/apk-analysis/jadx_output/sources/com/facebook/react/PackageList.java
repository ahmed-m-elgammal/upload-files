package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.RNAppleAuthentication.AppleAuthenticationAndroidPackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.audiowaveform.AudioWaveformPackage;
import com.dooboolab.rniap.RNIapPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.henninghall.date_picker.DatePickerPackage;
import com.horcrux.svg.SvgPackage;
import com.imagepicker.ImagePickerPackage;
import com.microsoft.clarity.reactnative.ClarityPackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactnative.ivpusic.imagepicker.PickerPackage;
import com.reactnativeavoidsoftinput.AvoidSoftInputPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.blurview.BlurViewPackage;
import com.reactnativecommunity.clipboard.ClipboardPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.picker.RNCPickerPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativegooglesignin.RNGoogleSigninPackage;
import com.reactnativemmkv.MmkvPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.reactnativerestart.RestartPackage;
import com.rnfs.RNFSPackage;
import com.shopify.reactnative.flash_list.ReactNativeFlashListPackage;
import com.shopify.reactnative.skia.RNSkiaPackage;
import com.sslpublickeypinning.SslPublicKeyPinningPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.tron.ReactNativeWheelPickerPackage;
import com.vinzscam.reactnativefileviewer.RNFileViewerPackage;
import com.zaguiini.RNPureJwt.RNPureJwtPackage;
import expo.modules.ExpoModulesPackage;
import fr.greweb.reactnativeviewshot.RNViewShotPackage;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.firestore.ReactNativeFirebaseFirestorePackage;
import io.invertase.firebase.messaging.ReactNativeFirebaseMessagingPackage;
import io.sentry.react.RNSentryPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.reactnative.maskedview.RNCMaskedViewPackage;
import org.wonday.pdf.RNPDFPackage;

/* loaded from: classes3.dex */
public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost) {
        this(reactNativeHost, (MainPackageConfig) null);
    }

    public PackageList(Application application) {
        this(application, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost = this.reactNativeHost;
        return reactNativeHost == null ? this.application : reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new MainReactPackage(this.mConfig), new AppleAuthenticationAndroidPackage(), new ClarityPackage(), new AsyncStoragePackage(), new ClipboardPackage(), new BlurViewPackage(), new RNDateTimePickerPackage(), new NetInfoPackage(), new ReactSliderPackage(), new ReactNativeFirebaseAppPackage(), new ReactNativeFirebaseFirestorePackage(), new ReactNativeFirebaseMessagingPackage(), new RNGoogleSigninPackage(), new RNCMaskedViewPackage(), new RNCPickerPackage(), new RNSentryPackage(), new ReactNativeFlashListPackage(), new RNSkiaPackage(), new AudioWaveformPackage(), new ExpoModulesPackage(), new AvoidSoftInputPackage(), new ReactNativeBlobUtilPackage(), new DatePickerPackage(), new FBSDKPackage(), new RNFileViewerPackage(), new RNFSPackage(), new RNGestureHandlerPackage(), new RNIapPackage(), new PickerPackage(), new ImagePickerPackage(), new MmkvPackage(), new PagerViewPackage(), new RNPDFPackage(), new RNPureJwtPackage(), new ReanimatedPackage(), new RestartPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new SslPublicKeyPinningPackage(), new SvgPackage(), new RNViewShotPackage(), new RNCWebViewPackage(), new ReactNativeWheelPickerPackage()));
    }
}
