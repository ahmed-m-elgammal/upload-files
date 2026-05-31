package io.invertase.firebase.firestore;

import android.util.Base64;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SnapshotMetadata;
import io.invertase.firebase.common.RCTConvertFirebase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class ReactNativeFirebaseFirestoreSerialize {
    private static final String CHANGE_ADDED = "a";
    private static final String CHANGE_MODIFIED = "m";
    private static final String CHANGE_REMOVED = "r";
    private static final int INT_ARRAY = 10;
    private static final int INT_BLOB = 14;
    private static final int INT_BOOLEAN_FALSE = 6;
    private static final int INT_BOOLEAN_TRUE = 5;
    private static final int INT_DOCUMENTID = 4;
    private static final int INT_DOUBLE = 7;
    private static final int INT_FIELDVALUE = 15;
    private static final int INT_GEOPOINT = 12;
    private static final int INT_INTEGER = 17;
    private static final int INT_NAN = 0;
    private static final int INT_NEGATIVE_INFINITY = 1;
    private static final int INT_NEGATIVE_ZERO = 18;
    private static final int INT_NULL = 3;
    private static final int INT_OBJECT = 16;
    private static final int INT_POSITIVE_INFINITY = 2;
    private static final int INT_REFERENCE = 11;
    private static final int INT_STRING = 8;
    private static final int INT_STRING_EMPTY = 9;
    private static final int INT_TIMESTAMP = 13;
    private static final int INT_UNKNOWN = -999;
    private static final String KEY_CHANGES = "changes";
    private static final String KEY_DATA = "data";
    private static final String KEY_DOCUMENTS = "documents";
    private static final String KEY_DOC_CHANGE_DOCUMENT = "doc";
    private static final String KEY_DOC_CHANGE_NEW_INDEX = "ni";
    private static final String KEY_DOC_CHANGE_OLD_INDEX = "oi";
    private static final String KEY_DOC_CHANGE_TYPE = "type";
    private static final String KEY_EXISTS = "exists";
    private static final String KEY_META = "metadata";
    private static final String KEY_OPTIONS = "options";
    private static final String KEY_PATH = "path";
    private static final String TAG = "FirestoreSerialize";
    private static final String TYPE = "type";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap snapshotToWritableMap(String str, String str2, DocumentSnapshot documentSnapshot) {
        WritableArray createArray = Arguments.createArray();
        WritableMap createMap = Arguments.createMap();
        SnapshotMetadata metadata = documentSnapshot.getMetadata();
        createArray.pushBoolean(metadata.isFromCache());
        createArray.pushBoolean(metadata.hasPendingWrites());
        createMap.putArray("metadata", createArray);
        createMap.putString("path", documentSnapshot.getReference().getPath());
        createMap.putBoolean(KEY_EXISTS, documentSnapshot.exists());
        DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior = ReactNativeFirebaseFirestoreCommon.getServerTimestampBehavior(str, str2);
        if (documentSnapshot.exists() && documentSnapshot.getData(serverTimestampBehavior) != null) {
            createMap.putMap("data", objectMapToWritable(documentSnapshot.getData(serverTimestampBehavior)));
        }
        return createMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WritableMap snapshotToWritableMap(String str, String str2, String str3, QuerySnapshot querySnapshot, @Nullable MetadataChanges metadataChanges) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("source", str3);
        WritableArray createArray = Arguments.createArray();
        WritableArray createArray2 = Arguments.createArray();
        List<DocumentChange> documentChanges = querySnapshot.getDocumentChanges();
        if (metadataChanges == null || metadataChanges == MetadataChanges.EXCLUDE) {
            createMap.putBoolean("excludesMetadataChanges", true);
            createMap.putArray(KEY_CHANGES, documentChangesToWritableArray(str, str2, documentChanges, null));
        } else {
            createMap.putBoolean("excludesMetadataChanges", false);
            createMap.putArray(KEY_CHANGES, documentChangesToWritableArray(str, str2, querySnapshot.getDocumentChanges(MetadataChanges.INCLUDE), documentChanges));
        }
        SnapshotMetadata metadata = querySnapshot.getMetadata();
        Iterator<DocumentSnapshot> it = querySnapshot.getDocuments().iterator();
        while (it.hasNext()) {
            createArray2.pushMap(snapshotToWritableMap(str, str2, it.next()));
        }
        createMap.putArray(KEY_DOCUMENTS, createArray2);
        createArray.pushBoolean(metadata.isFromCache());
        createArray.pushBoolean(metadata.hasPendingWrites());
        createMap.putArray("metadata", createArray);
        return createMap;
    }

    private static WritableArray documentChangesToWritableArray(String str, String str2, List<DocumentChange> list, @Nullable List<DocumentChange> list2) {
        boolean z;
        WritableArray createArray = Arguments.createArray();
        boolean z2 = list2 != null;
        for (DocumentChange documentChange : list) {
            if (z2) {
                int hashCode = documentChange.hashCode();
                DocumentChange documentChange2 = null;
                for (DocumentChange documentChange3 : list2) {
                    if (documentChange3.hashCode() == hashCode) {
                        documentChange2 = documentChange3;
                    }
                }
                if (documentChange2 == null) {
                    z = true;
                    createArray.pushMap(documentChangeToWritableMap(str, str2, documentChange, z));
                }
            }
            z = false;
            createArray.pushMap(documentChangeToWritableMap(str, str2, documentChange, z));
        }
        return createArray;
    }

    private static WritableMap documentChangeToWritableMap(String str, String str2, DocumentChange documentChange, boolean z) {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("isMetadataChange", z);
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$DocumentChange$Type[documentChange.getType().ordinal()];
        if (i == 1) {
            createMap.putString("type", "a");
        } else if (i == 2) {
            createMap.putString("type", CHANGE_MODIFIED);
        } else if (i == 3) {
            createMap.putString("type", CHANGE_REMOVED);
        }
        createMap.putMap(KEY_DOC_CHANGE_DOCUMENT, snapshotToWritableMap(str, str2, documentChange.getDocument()));
        createMap.putInt(KEY_DOC_CHANGE_NEW_INDEX, documentChange.getNewIndex());
        createMap.putInt(KEY_DOC_CHANGE_OLD_INDEX, documentChange.getOldIndex());
        return createMap;
    }

    /* renamed from: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreSerialize$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$DocumentChange$Type;

        static {
            int[] iArr = new int[DocumentChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$DocumentChange$Type = iArr;
            try {
                iArr[DocumentChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[DocumentChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$DocumentChange$Type[DocumentChange.Type.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static WritableMap objectMapToWritable(Map<String, Object> map) {
        WritableMap createMap = Arguments.createMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            createMap.putArray(entry.getKey(), buildTypeMap(entry.getValue()));
        }
        return createMap;
    }

    private static WritableArray objectArrayToWritable(Object[] objArr) {
        WritableArray createArray = Arguments.createArray();
        for (Object obj : objArr) {
            createArray.pushArray(buildTypeMap(obj));
        }
        return createArray;
    }

    private static WritableArray buildTypeMap(Object obj) {
        WritableArray createArray = Arguments.createArray();
        if (obj == null) {
            createArray.pushInt(3);
            return createArray;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                createArray.pushInt(5);
            } else {
                createArray.pushInt(6);
            }
            return createArray;
        }
        if (obj instanceof Integer) {
            createArray.pushInt(7);
            createArray.pushDouble(((Integer) obj).doubleValue());
            return createArray;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (Double.isInfinite(d.doubleValue())) {
                if (d.equals(Double.valueOf(Double.NEGATIVE_INFINITY))) {
                    createArray.pushInt(1);
                    return createArray;
                }
                if (d.equals(Double.valueOf(Double.POSITIVE_INFINITY))) {
                    createArray.pushInt(2);
                    return createArray;
                }
            }
            if (Double.isNaN(d.doubleValue())) {
                createArray.pushInt(0);
                return createArray;
            }
            createArray.pushInt(7);
            createArray.pushDouble(d.doubleValue());
            return createArray;
        }
        if (obj instanceof Float) {
            createArray.pushInt(7);
            createArray.pushDouble(((Float) obj).doubleValue());
            return createArray;
        }
        if (obj instanceof Long) {
            createArray.pushInt(7);
            createArray.pushDouble(((Long) obj).doubleValue());
            return createArray;
        }
        if (obj instanceof String) {
            if (obj == "") {
                createArray.pushInt(9);
            } else {
                createArray.pushInt(8);
                createArray.pushString((String) obj);
            }
            return createArray;
        }
        if (Map.class.isAssignableFrom(obj.getClass())) {
            createArray.pushInt(16);
            createArray.pushMap(objectMapToWritable((Map) obj));
            return createArray;
        }
        if (List.class.isAssignableFrom(obj.getClass())) {
            createArray.pushInt(10);
            List list = (List) obj;
            createArray.pushArray(objectArrayToWritable(list.toArray(new Object[list.size()])));
            return createArray;
        }
        if (obj instanceof DocumentReference) {
            createArray.pushInt(11);
            createArray.pushString(((DocumentReference) obj).getPath());
            return createArray;
        }
        if (obj instanceof Timestamp) {
            createArray.pushInt(13);
            WritableArray createArray2 = Arguments.createArray();
            createArray2.pushDouble(r6.getSeconds());
            createArray2.pushInt(((Timestamp) obj).getNanoseconds());
            createArray.pushArray(createArray2);
            return createArray;
        }
        if (obj instanceof GeoPoint) {
            createArray.pushInt(12);
            WritableArray createArray3 = Arguments.createArray();
            GeoPoint geoPoint = (GeoPoint) obj;
            createArray3.pushDouble(geoPoint.getLatitude());
            createArray3.pushDouble(geoPoint.getLongitude());
            createArray.pushArray(createArray3);
            return createArray;
        }
        if (obj instanceof Blob) {
            createArray.pushInt(14);
            createArray.pushString(Base64.encodeToString(((Blob) obj).toBytes(), 2));
            return createArray;
        }
        Log.w(TAG, "Unknown object of type " + obj.getClass());
        createArray.pushInt(INT_UNKNOWN);
        return createArray;
    }

    public static Map<String, Object> parseReadableMap(FirebaseFirestore firebaseFirestore, @Nullable ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        if (readableMap == null) {
            return hashMap;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, parseTypeMap(firebaseFirestore, readableMap.getArray(nextKey)));
        }
        return hashMap;
    }

    static List<Object> parseReadableArray(FirebaseFirestore firebaseFirestore, @Nullable ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        if (readableArray == null) {
            return arrayList;
        }
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(parseTypeMap(firebaseFirestore, readableArray.getArray(i)));
        }
        return arrayList;
    }

    static Object parseTypeMap(FirebaseFirestore firebaseFirestore, ReadableArray readableArray) {
        switch (readableArray.getInt(0)) {
            case 0:
                return Double.valueOf(Double.NaN);
            case 1:
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            case 2:
                return Double.valueOf(Double.POSITIVE_INFINITY);
            case 3:
            default:
                return null;
            case 4:
                return FieldPath.documentId();
            case 5:
                return true;
            case 6:
                return false;
            case 7:
                return Double.valueOf(readableArray.getDouble(1));
            case 8:
                return readableArray.getString(1);
            case 9:
                return "";
            case 10:
                return parseReadableArray(firebaseFirestore, readableArray.getArray(1));
            case 11:
                return firebaseFirestore.document((String) Objects.requireNonNull(readableArray.getString(1)));
            case 12:
                ReadableArray array = readableArray.getArray(1);
                return new GeoPoint(((ReadableArray) Objects.requireNonNull(array)).getDouble(0), array.getDouble(1));
            case 13:
                ReadableArray array2 = readableArray.getArray(1);
                return new Timestamp((long) ((ReadableArray) Objects.requireNonNull(array2)).getDouble(0), array2.getInt(1));
            case 14:
                return Blob.fromBytes(Base64.decode(readableArray.getString(1), 2));
            case 15:
                ReadableArray array3 = readableArray.getArray(1);
                String string = ((ReadableArray) Objects.requireNonNull(array3)).getString(0);
                if (((String) Objects.requireNonNull(string)).equals("timestamp")) {
                    return FieldValue.serverTimestamp();
                }
                if (((String) Objects.requireNonNull(string)).equals("increment")) {
                    return FieldValue.increment(array3.getDouble(1));
                }
                if (((String) Objects.requireNonNull(string)).equals("delete")) {
                    return FieldValue.delete();
                }
                if (((String) Objects.requireNonNull(string)).equals("array_union")) {
                    return FieldValue.arrayUnion(parseReadableArray(firebaseFirestore, array3.getArray(1)).toArray());
                }
                if (((String) Objects.requireNonNull(string)).equals("array_remove")) {
                    return FieldValue.arrayRemove(parseReadableArray(firebaseFirestore, array3.getArray(1)).toArray());
                }
                break;
            case 16:
                break;
            case 17:
                return Long.valueOf((long) readableArray.getDouble(1));
            case 18:
                return Double.valueOf(-0.0d);
        }
        return parseReadableMap(firebaseFirestore, readableArray.getMap(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Object> parseDocumentBatches(FirebaseFirestore firebaseFirestore, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            HashMap hashMap = new HashMap();
            ReadableMap map = readableArray.getMap(i);
            hashMap.put("type", map.getString("type"));
            hashMap.put("path", map.getString("path"));
            if (map.hasKey("data")) {
                hashMap.put("data", parseReadableMap(firebaseFirestore, map.getMap("data")));
            }
            if (map.hasKey("options")) {
                hashMap.put("options", RCTConvertFirebase.toHashMap(map.getMap("options")));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }
}
