package com.reactnativegooglesignin;

import android.util.Log;
import com.facebook.react.bridge.Promise;

/* loaded from: classes5.dex */
public class PromiseWrapper {
    public static final String ASYNC_OP_IN_PROGRESS = "ASYNC_OP_IN_PROGRESS";
    private final String MODULE_NAME;
    private String nameOfCallInProgress;
    private Promise promise;

    public PromiseWrapper(String str) {
        this.MODULE_NAME = str;
    }

    public void setPromiseWithInProgressCheck(Promise promise, String str) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            rejectPreviousPromiseBecauseNewOneIsInProgress(promise2, str);
        }
        this.promise = promise;
        this.nameOfCallInProgress = str;
    }

    public void resolve(Object obj) {
        Promise promise = this.promise;
        if (promise == null) {
            Log.e(this.MODULE_NAME, "cannot resolve promise because it's null");
        } else {
            resetMembers();
            promise.resolve(obj);
        }
    }

    public void reject(String str) {
        reject(this.nameOfCallInProgress, str);
    }

    public void reject(String str, String str2) {
        Promise promise = this.promise;
        if (promise == null) {
            Log.e(this.MODULE_NAME, "cannot reject promise because it's null");
        } else {
            resetMembers();
            promise.reject(str, str2);
        }
    }

    public void reject(Exception exc) {
        Promise promise = this.promise;
        String str = this.nameOfCallInProgress;
        if (promise == null) {
            Log.e(this.MODULE_NAME, "cannot reject promise because it's null");
            return;
        }
        ErrorDto errorDto = new ErrorDto(exc, str);
        resetMembers();
        promise.reject(errorDto.getCode(), errorDto.getMessage(), exc);
    }

    public String getNameOfCallInProgress() {
        return this.nameOfCallInProgress;
    }

    private void resetMembers() {
        this.nameOfCallInProgress = null;
        this.promise = null;
    }

    private void rejectPreviousPromiseBecauseNewOneIsInProgress(Promise promise, String str) {
        promise.reject(ASYNC_OP_IN_PROGRESS, "Warning: previous promise did not settle and was overwritten. You've called \"" + str + "\" while \"" + getNameOfCallInProgress() + "\" was already in progress and has not completed yet.");
    }
}
