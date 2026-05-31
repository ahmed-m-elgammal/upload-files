package com.google.firebase.firestore;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.MemoryEagerGcSettings;
import com.google.firebase.firestore.MemoryLruGcSettings;
import com.google.firebase.firestore.PersistentCacheSettings;
import io.sentry.Session;
import io.sentry.protocol.App;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Firestore.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u001a\u001f\u0010\f\u001a\u00020\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u001a\u001f\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u001a\u001f\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u001a\u001f\u0010\u0015\u001a\u00020\u00162\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\u001a+\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001a0\u0019\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001b*\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086\b\u001a/\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u001f0\u0019\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001b*\u00020 2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086\b\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\"\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010#\u001a\u00020$\u001a$\u0010%\u001a\u0004\u0018\u0001H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020&2\u0006\u0010'\u001a\u00020(H\u0086\b¢\u0006\u0002\u0010)\u001a,\u0010%\u001a\u0004\u0018\u0001H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0086\b¢\u0006\u0002\u0010,\u001a$\u0010%\u001a\u0004\u0018\u0001H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020&2\u0006\u0010-\u001a\u00020$H\u0086\b¢\u0006\u0002\u0010.\u001a,\u0010%\u001a\u0004\u0018\u0001H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020&2\u0006\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0086\b¢\u0006\u0002\u0010/\u001a\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020&0\u0019*\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u001a\u001a\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0019*\u00020 2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u001a\u001c\u00102\u001a\u0004\u0018\u0001H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020&H\u0086\b¢\u0006\u0002\u00103\u001a$\u00102\u001a\u0004\u0018\u0001H\u001a\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020&2\u0006\u0010*\u001a\u00020+H\u0086\b¢\u0006\u0002\u00104\u001a\u001e\u00102\u001a\u0002H\u001a\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001b*\u000205H\u0086\b¢\u0006\u0002\u00106\u001a&\u00102\u001a\u0002H\u001a\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001b*\u0002052\u0006\u0010*\u001a\u00020+H\u0086\b¢\u0006\u0002\u00107\u001a\u001f\u00108\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001f\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001b*\u000201H\u0086\b\u001a'\u00108\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001f\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020\u001b*\u0002012\u0006\u0010*\u001a\u00020+H\u0086\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u00069"}, d2 = {"firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "Lcom/google/firebase/Firebase;", "getFirestore", "(Lcom/google/firebase/Firebase;)Lcom/google/firebase/firestore/FirebaseFirestore;", "firestoreSettings", "Lcom/google/firebase/firestore/FirebaseFirestoreSettings;", Session.JsonKeys.INIT, "Lkotlin/Function1;", "Lcom/google/firebase/firestore/FirebaseFirestoreSettings$Builder;", "", "Lkotlin/ExtensionFunctionType;", "memoryCacheSettings", "Lcom/google/firebase/firestore/MemoryCacheSettings;", "Lcom/google/firebase/firestore/MemoryCacheSettings$Builder;", "memoryEagerGcSettings", "Lcom/google/firebase/firestore/MemoryEagerGcSettings;", "Lcom/google/firebase/firestore/MemoryEagerGcSettings$Builder;", "memoryLruGcSettings", "Lcom/google/firebase/firestore/MemoryLruGcSettings;", "Lcom/google/firebase/firestore/MemoryLruGcSettings$Builder;", "persistentCacheSettings", "Lcom/google/firebase/firestore/PersistentCacheSettings;", "Lcom/google/firebase/firestore/PersistentCacheSettings$Builder;", "dataObjects", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/google/firebase/firestore/DocumentReference;", "metadataChanges", "Lcom/google/firebase/firestore/MetadataChanges;", "", "Lcom/google/firebase/firestore/Query;", App.TYPE, "Lcom/google/firebase/FirebaseApp;", "database", "", "getField", "Lcom/google/firebase/firestore/DocumentSnapshot;", "fieldPath", "Lcom/google/firebase/firestore/FieldPath;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/FieldPath;)Ljava/lang/Object;", "serverTimestampBehavior", "Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/FieldPath;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "field", "(Lcom/google/firebase/firestore/DocumentSnapshot;Ljava/lang/String;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Ljava/lang/String;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "snapshots", "Lcom/google/firebase/firestore/QuerySnapshot;", "toObject", "(Lcom/google/firebase/firestore/DocumentSnapshot;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/DocumentSnapshot;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "Lcom/google/firebase/firestore/QueryDocumentSnapshot;", "(Lcom/google/firebase/firestore/QueryDocumentSnapshot;)Ljava/lang/Object;", "(Lcom/google/firebase/firestore/QueryDocumentSnapshot;Lcom/google/firebase/firestore/DocumentSnapshot$ServerTimestampBehavior;)Ljava/lang/Object;", "toObjects", "com.google.firebase-firebase-firestore"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FirestoreKt {
    public static final FirebaseFirestore getFirestore(Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance()");
        return firebaseFirestore;
    }

    public static final FirebaseFirestore firestore(Firebase firebase2, FirebaseApp app) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app, "app");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app);
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance(app)");
        return firebaseFirestore;
    }

    public static final FirebaseFirestore firestore(Firebase firebase2, FirebaseApp app, String database) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(app, database);
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance(app, database)");
        return firebaseFirestore;
    }

    public static final FirebaseFirestore firestore(Firebase firebase2, String database) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(database, "database");
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance(database);
        Intrinsics.checkNotNullExpressionValue(firebaseFirestore, "getInstance(database)");
        return firebaseFirestore;
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) documentSnapshot.toObject(Object.class);
    }

    public static final /* synthetic */ <T> T toObject(DocumentSnapshot documentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) documentSnapshot.toObject(Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) documentSnapshot.get(field, Object.class);
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, String field, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) documentSnapshot.get(field, Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(fieldPath, "fieldPath");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) documentSnapshot.get(fieldPath, Object.class);
    }

    public static final /* synthetic */ <T> T getField(DocumentSnapshot documentSnapshot, FieldPath fieldPath, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(documentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(fieldPath, "fieldPath");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) documentSnapshot.get(fieldPath, Object.class, serverTimestampBehavior);
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot) {
        Intrinsics.checkNotNullParameter(queryDocumentSnapshot, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) queryDocumentSnapshot.toObject(Object.class);
        Intrinsics.checkNotNullExpressionValue(t, "toObject(T::class.java)");
        return t;
    }

    public static final /* synthetic */ <T> T toObject(QueryDocumentSnapshot queryDocumentSnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(queryDocumentSnapshot, "<this>");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t = (T) queryDocumentSnapshot.toObject(Object.class, serverTimestampBehavior);
        Intrinsics.checkNotNullExpressionValue(t, "toObject(T::class.java, serverTimestampBehavior)");
        return t;
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot) {
        Intrinsics.checkNotNullParameter(querySnapshot, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        List<T> objects = querySnapshot.toObjects(Object.class);
        Intrinsics.checkNotNullExpressionValue(objects, "toObjects(T::class.java)");
        return objects;
    }

    public static final /* synthetic */ <T> List<T> toObjects(QuerySnapshot querySnapshot, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        Intrinsics.checkNotNullParameter(querySnapshot, "<this>");
        Intrinsics.checkNotNullParameter(serverTimestampBehavior, "serverTimestampBehavior");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        List<T> objects = querySnapshot.toObjects(Object.class, serverTimestampBehavior);
        Intrinsics.checkNotNullExpressionValue(objects, "toObjects(T::class.java, serverTimestampBehavior)");
        return objects;
    }

    public static final FirebaseFirestoreSettings firestoreSettings(Function1<? super FirebaseFirestoreSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        init.invoke(builder);
        FirebaseFirestoreSettings build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final MemoryCacheSettings memoryCacheSettings(Function1<? super MemoryCacheSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        MemoryCacheSettings.Builder newBuilder = MemoryCacheSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        MemoryCacheSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final MemoryEagerGcSettings memoryEagerGcSettings(Function1<? super MemoryEagerGcSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        MemoryEagerGcSettings.Builder newBuilder = MemoryEagerGcSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        MemoryEagerGcSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final MemoryLruGcSettings memoryLruGcSettings(Function1<? super MemoryLruGcSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        MemoryLruGcSettings.Builder newBuilder = MemoryLruGcSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        MemoryLruGcSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static final PersistentCacheSettings persistentCacheSettings(Function1<? super PersistentCacheSettings.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        PersistentCacheSettings.Builder newBuilder = PersistentCacheSettings.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        init.invoke(newBuilder);
        PersistentCacheSettings build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public static /* synthetic */ Flow snapshots$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i, Object obj) {
        if ((i & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(documentReference, metadataChanges);
    }

    public static final Flow<DocumentSnapshot> snapshots(DocumentReference documentReference, MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(documentReference, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        return FlowKt.callbackFlow(new FirestoreKt$snapshots$1(documentReference, metadataChanges, null));
    }

    public static /* synthetic */ Flow snapshots$default(Query query, MetadataChanges metadataChanges, int i, Object obj) {
        if ((i & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        return snapshots(query, metadataChanges);
    }

    public static final Flow<QuerySnapshot> snapshots(Query query, MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(query, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        return FlowKt.callbackFlow(new FirestoreKt$snapshots$2(query, metadataChanges, null));
    }

    public static /* synthetic */ Flow dataObjects$default(Query query, MetadataChanges metadataChanges, int i, Object obj) {
        if ((i & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        Intrinsics.checkNotNullParameter(query, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<QuerySnapshot> snapshots = snapshots(query, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$1(snapshots);
    }

    public static final /* synthetic */ <T> Flow<List<T>> dataObjects(Query query, MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(query, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<QuerySnapshot> snapshots = snapshots(query, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$1(snapshots);
    }

    public static /* synthetic */ Flow dataObjects$default(DocumentReference documentReference, MetadataChanges metadataChanges, int i, Object obj) {
        if ((i & 1) != 0) {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        Intrinsics.checkNotNullParameter(documentReference, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<DocumentSnapshot> snapshots = snapshots(documentReference, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$2(snapshots);
    }

    public static final /* synthetic */ <T> Flow<T> dataObjects(DocumentReference documentReference, MetadataChanges metadataChanges) {
        Intrinsics.checkNotNullParameter(documentReference, "<this>");
        Intrinsics.checkNotNullParameter(metadataChanges, "metadataChanges");
        Flow<DocumentSnapshot> snapshots = snapshots(documentReference, metadataChanges);
        Intrinsics.needClassReification();
        return new FirestoreKt$dataObjects$$inlined$map$2(snapshots);
    }
}
