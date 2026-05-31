package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNCAndroidDialogPickerManagerInterface;

/* loaded from: classes3.dex */
public class RNCAndroidDialogPickerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNCAndroidDialogPickerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNCAndroidDialogPickerManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "dropdownIconColor":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setDropdownIconColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "dropdownIconRippleColor":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setDropdownIconRippleColor(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "enabled":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "numberOfLines":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setNumberOfLines(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case "prompt":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setPrompt(t, obj == null ? null : (String) obj);
                break;
            case "color":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "items":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setItems(t, (ReadableArray) obj);
                break;
            case "selected":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
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
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).blur(t);
                break;
            case "focus":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).focus(t);
                break;
            case "setNativeSelected":
                ((RNCAndroidDialogPickerManagerInterface) ((BaseViewManager) this.mViewManager)).setNativeSelected(t, readableArray.getInt(0));
                break;
        }
    }
}
