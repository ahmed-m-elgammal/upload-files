package io.invertase.firebase.firestore;

import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes6.dex */
public class UniversalFirebaseFirestoreException extends Exception {
    private final String code;
    private final String message;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    UniversalFirebaseFirestoreException(FirebaseFirestoreException firebaseFirestoreException, Throwable th) {
        super(firebaseFirestoreException != null ? firebaseFirestoreException.getMessage() : "", th);
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (th == null || th.getMessage() == null) {
            str = "permission-denied";
        } else {
            str = "permission-denied";
            if (th.getMessage().contains(":")) {
                Matcher matcher = Pattern.compile("([A-Z_]{3,25}):\\s(.*)").matcher(th.getMessage());
                if (matcher.find()) {
                    String trim = matcher.group(1).trim();
                    str2 = "Operation was attempted past the valid range.";
                    String trim2 = matcher.group(2).trim();
                    trim.hashCode();
                    char c = 65535;
                    switch (trim.hashCode()) {
                        case -1842427240:
                            if (trim.equals("DATA_LOSS")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1711692763:
                            if (trim.equals("INVALID_ARGUMENT")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1416305653:
                            if (trim.equals("PERMISSION_DENIED")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1031784143:
                            if (trim.equals("CANCELLED")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -1025686472:
                            if (trim.equals("RESOURCE_EXHAUSTED")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -849706474:
                            if (trim.equals("UNAUTHENTICATED")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -476794961:
                            if (trim.equals("ABORTED")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -376214182:
                            if (trim.equals("DEADLINE_EXCEEDED")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 433141802:
                            if (trim.equals("UNKNOWN")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 695165606:
                            if (trim.equals("OUT_OF_RANGE")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 979228314:
                            if (trim.equals("FAILED_PRECONDITION")) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 1023286998:
                            if (trim.equals("NOT_FOUND")) {
                                c = 11;
                                break;
                            }
                            break;
                        case 1353037501:
                            if (trim.equals("INTERNAL")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 1487498288:
                            if (trim.equals("UNAVAILABLE")) {
                                c = CharUtils.CR;
                                break;
                            }
                            break;
                        case 1661336131:
                            if (trim.equals("ALREADY_EXISTS")) {
                                c = 14;
                                break;
                            }
                            break;
                        case 1854913705:
                            if (trim.equals("UNIMPLEMENTED")) {
                                c = 15;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            str4 = "Unrecoverable data loss or corruption.";
                            str3 = "data-loss";
                            break;
                        case 1:
                            str4 = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name).";
                            str3 = "invalid-argument";
                            break;
                        case 2:
                            str4 = "The caller does not have permission to execute the specified operation.";
                            str3 = str;
                            break;
                        case 3:
                            str4 = "The operation was cancelled (typically by the caller).";
                            str3 = AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED;
                            break;
                        case 4:
                            str3 = "resource-exhausted";
                            str4 = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.";
                            break;
                        case 5:
                            str3 = "unauthenticated";
                            str4 = "The request does not have valid authentication credentials for the operation.";
                            break;
                        case 6:
                            str4 = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.";
                            str3 = "aborted";
                            break;
                        case 7:
                            str4 = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire.";
                            str3 = "deadline-exceeded";
                            break;
                        case '\b':
                            str4 = "Unknown error or an error from a different error domain.";
                            str3 = "unknown";
                            break;
                        case '\t':
                            str3 = "out-of-range";
                            str4 = str2;
                            break;
                        case '\n':
                            str4 = trim2.contains("query requires an index") ? trim2 : "Operation was rejected because the system is not in a state required for the operation's execution. Ensure your query has been indexed via the Firebase console.";
                            str3 = "failed-precondition";
                            break;
                        case 11:
                            str4 = "Some requested document was not found.";
                            str3 = "not-found";
                            break;
                        case '\f':
                            str4 = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken.";
                            str3 = "internal";
                            break;
                        case '\r':
                            str3 = "unavailable";
                            str4 = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff.";
                            break;
                        case 14:
                            str4 = "Some document that we attempted to create already exists.";
                            str3 = "already-exists";
                            break;
                        case 15:
                            str3 = "unimplemented";
                            str4 = "Operation is not implemented or not supported/enabled.";
                            break;
                        default:
                            str3 = null;
                            str4 = "An unknown error occurred";
                            break;
                    }
                    if (str3 != null && firebaseFirestoreException != null) {
                        switch (AnonymousClass1.$SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[firebaseFirestoreException.getCode().ordinal()]) {
                            case 1:
                                str5 = "The operation was aborted, typically due to a concurrency issue like transaction aborts, etc.";
                                str6 = "aborted";
                                break;
                            case 2:
                                str5 = "Some document that we attempted to create already exists.";
                                str6 = "already-exists";
                                break;
                            case 3:
                                str5 = "The operation was cancelled (typically by the caller).";
                                str6 = AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED;
                                break;
                            case 4:
                                str5 = "Unrecoverable data loss or corruption.";
                                str6 = "data-loss";
                                break;
                            case 5:
                                str5 = "Deadline expired before operation could complete. For operations that change the state of the system, this error may be returned even if the operation has completed successfully. For example, a successful response from a server could have been delayed long enough for the deadline to expire.";
                                str6 = "deadline-exceeded";
                                break;
                            case 6:
                                if (firebaseFirestoreException.getMessage() != null && firebaseFirestoreException.getMessage().contains("query requires an index")) {
                                    str5 = firebaseFirestoreException.getMessage();
                                } else {
                                    str5 = "Operation was rejected because the system is not in a state required for the operation's execution. Ensure your query has been indexed via the Firebase console.";
                                }
                                str6 = "failed-precondition";
                                break;
                            case 7:
                                str5 = "Internal errors. Means some invariants expected by underlying system has been broken. If you see one of these errors, something is very broken.";
                                str6 = "internal";
                                break;
                            case 8:
                                str5 = "Client specified an invalid argument. Note that this differs from failed-precondition. invalid-argument indicates arguments that are problematic regardless of the state of the system (e.g., an invalid field name).";
                                str6 = "invalid-argument";
                                break;
                            case 9:
                                str5 = "Some requested document was not found.";
                                str6 = "not-found";
                                break;
                            case 10:
                                str6 = "out-of-range";
                                str5 = str2;
                                break;
                            case 11:
                                str5 = "The caller does not have permission to execute the specified operation.";
                                str6 = str;
                                break;
                            case 12:
                                str6 = "resource-exhausted";
                                str5 = "Some resource has been exhausted, perhaps a per-user quota, or perhaps the entire file system is out of space.";
                                break;
                            case 13:
                                str6 = "unauthenticated";
                                str5 = "The request does not have valid authentication credentials for the operation.";
                                break;
                            case 14:
                                str6 = "unavailable";
                                str5 = "The service is currently unavailable. This is a most likely a transient condition and may be corrected by retrying with a backoff.";
                                break;
                            case 15:
                                str6 = "unimplemented";
                                str5 = "Operation is not implemented or not supported/enabled.";
                                break;
                            case 16:
                                str5 = "Unknown error or an error from a different error domain.";
                                str6 = "unknown";
                                break;
                            default:
                                str5 = "An unknown error occurred";
                                str6 = "unknown";
                                break;
                        }
                    } else {
                        str5 = str4;
                        str6 = str3;
                    }
                    this.code = str6;
                    this.message = str5;
                }
            }
        }
        str2 = "Operation was attempted past the valid range.";
        str3 = null;
        str4 = "An unknown error occurred";
        if (str3 != null) {
        }
        str5 = str4;
        str6 = str3;
        this.code = str6;
        this.message = str5;
    }

    /* renamed from: io.invertase.firebase.firestore.UniversalFirebaseFirestoreException$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code;

        static {
            int[] iArr = new int[FirebaseFirestoreException.Code.values().length];
            $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code = iArr;
            try {
                iArr[FirebaseFirestoreException.Code.ABORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.ALREADY_EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DATA_LOSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.DEADLINE_EXCEEDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.FAILED_PRECONDITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INTERNAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.INVALID_ARGUMENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.NOT_FOUND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.OUT_OF_RANGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.PERMISSION_DENIED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.RESOURCE_EXHAUSTED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAUTHENTICATED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNAVAILABLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNIMPLEMENTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$FirebaseFirestoreException$Code[FirebaseFirestoreException.Code.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
