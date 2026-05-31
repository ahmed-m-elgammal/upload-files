package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCAndroidDropdownPickerManagerInterface;

/* loaded from: classes3.dex */
public class RNCAndroidDropdownPickerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCAndroidDropdownPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCAndroidDropdownPickerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "dropdownIconColor":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setDropdownIconColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "dropdownIconRippleColor":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setDropdownIconRippleColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "numberOfLines":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setNumberOfLines(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "prompt":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setPrompt(t, obj == null ? null : (String) obj);
                break;
            case "color":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "items":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setItems(t, (ReadableArray) obj);
                break;
            case "selected":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "backgroundColor":
                ((BaseViewManager) this.mViewManager).setBackgroundColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        switch (str) {
            case "blur":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).blur(t);
                break;
            case "focus":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).focus(t);
                break;
            case "setNativeSelected":
                ((RNCAndroidDropdownPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setNativeSelected(t, readableArray.getInt(0));
                break;
        }
    }
}
