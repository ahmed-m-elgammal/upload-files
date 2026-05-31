package com.fasterxml.jackson.core;

import expo.modules.updates.codesigning.CodeSigningAlgorithmKt;

/* loaded from: classes3.dex */
public abstract class JsonStreamContext {
    protected static final int TYPE_ARRAY = 1;
    protected static final int TYPE_OBJECT = 2;
    protected static final int TYPE_ROOT = 0;
    protected int _index;
    protected int _type;

    public abstract String getCurrentName();

    public Object getCurrentValue() {
        return null;
    }

    public abstract JsonStreamContext getParent();

    public void setCurrentValue(Object obj) {
    }

    protected JsonStreamContext() {
    }

    public final boolean inArray() {
        return this._type == 1;
    }

    public final boolean inRoot() {
        return this._type == 0;
    }

    public final boolean inObject() {
        return this._type == 2;
    }

    @Deprecated
    public final String getTypeDesc() {
        int i = this._type;
        if (i == 0) {
            return "ROOT";
        }
        if (i == 1) {
            return "ARRAY";
        }
        if (i == 2) {
            return "OBJECT";
        }
        return "?";
    }

    public String typeDesc() {
        int i = this._type;
        if (i == 0) {
            return CodeSigningAlgorithmKt.CODE_SIGNING_METADATA_DEFAULT_KEY_ID;
        }
        if (i == 1) {
            return "Array";
        }
        if (i == 2) {
            return "Object";
        }
        return "?";
    }

    public final int getEntryCount() {
        return this._index + 1;
    }

    public final int getCurrentIndex() {
        int i = this._index;
        if (i < 0) {
            return 0;
        }
        return i;
    }
}
