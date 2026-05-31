package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.RNSVGUseManagerInterface;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class RNSVGUseManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & RNSVGUseManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSVGUseManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1267206133:
                if (str.equals(ViewProps.OPACITY)) {
                    c = 0;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 1;
                    break;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    c = 2;
                    break;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    c = 3;
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c = 4;
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c = 5;
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    c = 6;
                    break;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    c = 7;
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c = '\b';
                    break;
                }
                break;
            case -293492298:
                if (str.equals(ViewProps.POINTER_EVENTS)) {
                    c = '\t';
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c = '\n';
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    c = 11;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c = '\f';
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c = 14;
                    break;
                }
                break;
            case 3211051:
                if (str.equals("href")) {
                    c = 15;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c = 16;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c = 17;
                    break;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    c = 18;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c = 19;
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = 20;
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c = 21;
                    break;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c = 22;
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c = 23;
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c = 24;
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c = 25;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c = 26;
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c = 27;
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c = 28;
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c = 29;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mViewManager.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 1:
                ((RNSVGUseManagerInterface) this.mViewManager).setHeight(t, new DynamicFromObject(obj));
                break;
            case 2:
                ((RNSVGUseManagerInterface) this.mViewManager).setMatrix(t, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGUseManagerInterface) this.mViewManager).setPropList(t, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGUseManagerInterface) this.mViewManager).setMarkerEnd(t, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGUseManagerInterface) this.mViewManager).setMarkerMid(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGUseManagerInterface) this.mViewManager).setStroke(t, (ReadableMap) obj);
                break;
            case 7:
                ((RNSVGUseManagerInterface) this.mViewManager).setFillRule(t, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case '\b':
                ((RNSVGUseManagerInterface) this.mViewManager).setStrokeOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case '\t':
                ((RNSVGUseManagerInterface) this.mViewManager).setPointerEvents(t, obj != null ? (String) obj : null);
                break;
            case '\n':
                ((RNSVGUseManagerInterface) this.mViewManager).setFillOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGUseManagerInterface) this.mViewManager).setStrokeDashoffset(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case '\f':
                ((RNSVGUseManagerInterface) this.mViewManager).setX(t, new DynamicFromObject(obj));
                break;
            case '\r':
                ((RNSVGUseManagerInterface) this.mViewManager).setY(t, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGUseManagerInterface) this.mViewManager).setFill(t, (ReadableMap) obj);
                break;
            case 15:
                ((RNSVGUseManagerInterface) this.mViewManager).setHref(t, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGUseManagerInterface) this.mViewManager).setMask(t, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGUseManagerInterface) this.mViewManager).setName(t, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGUseManagerInterface) this.mViewManager).setStrokeMiterlimit(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 19:
                ((RNSVGUseManagerInterface) this.mViewManager).setVectorEffect(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 20:
                ((RNSVGUseManagerInterface) this.mViewManager).setWidth(t, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGUseManagerInterface) this.mViewManager).setMarkerStart(t, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSVGUseManagerInterface) this.mViewManager).setStrokeDasharray(t, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGUseManagerInterface) this.mViewManager).setClipPath(t, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSVGUseManagerInterface) this.mViewManager).setClipRule(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 25:
                ((RNSVGUseManagerInterface) this.mViewManager).setStrokeLinecap(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 26:
                ((RNSVGUseManagerInterface) this.mViewManager).setDisplay(t, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGUseManagerInterface) this.mViewManager).setStrokeLinejoin(t, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGUseManagerInterface) this.mViewManager).setResponsible(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNSVGUseManagerInterface) this.mViewManager).setStrokeWidth(t, new DynamicFromObject(obj));
                break;
            default:
                super.setProperty(t, str, obj);
                break;
        }
    }
}
