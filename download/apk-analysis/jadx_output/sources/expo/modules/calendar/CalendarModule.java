package expo.modules.calendar;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.tracing.Trace;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.uimanager.ViewProps;
import com.henninghall.date_picker.props.DateProp;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;
import io.sentry.protocol.Request;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import org.apache.commons.lang3.time.TimeZones;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: CalendarModule.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001KB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J3\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0011H\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u0011H\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u001cH\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J,\u0010)\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J!\u0010-\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0004\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/H\u0082\bJ\u0018\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0011H\u0002J\u001a\u00104\u001a\u0004\u0018\u00010\u00112\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0011H\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u001a\u00109\u001a\u00020\u00142\u0006\u00106\u001a\u0002072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010:\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0002J\u0010\u0010;\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0002J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020$0=2\u0006\u0010\u001a\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0002J\u0016\u0010@\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010A\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0002J\u0010\u0010B\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0002J\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0006\u00101\u001a\u000202H\u0002J\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020$0\u001c2\u0006\u00101\u001a\u000202H\u0002J\u0018\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020+H\u0002J\u0018\u0010I\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0011H\u0002J\u001f\u0010J\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190/H\u0082\bR\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lexpo/modules/calendar/CalendarModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "contentResolver", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "getContentResolver", "()Landroid/content/ContentResolver;", "moduleCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "sdf", "Ljava/text/SimpleDateFormat;", "checkPermissions", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "createRecurrenceRule", "", "recurrence", "interval", "", "endDate", "occurrence", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "createRemindersForEvent", "", "eventID", "reminders", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "deleteAttendee", "attendeeID", "deleteCalendar", "calendarId", "findAttendeesByEventId", "Landroid/os/Bundle;", "findCalendarById", "calendarID", "findCalendars", "findEventById", "findEvents", "startDate", "", "calendars", "launchAsyncWithModuleScope", "block", "Lkotlin/Function0;", "optIntFromCursor", "cursor", "Landroid/database/Cursor;", "columnName", "optStringFromCursor", "removeEvent", ErrorBundle.DETAIL_ENTRY, "Lexpo/modules/core/arguments/ReadableArguments;", "removeRemindersForEvent", "saveAttendeeForEvent", "saveCalendar", "saveEvent", "serializeAlarms", "Ljava/util/ArrayList;", "", "serializeAttendee", "serializeAttendees", "serializeEvent", "serializeEventCalendar", "serializeEventCalendars", "serializeEvents", "setDateInCalendar", "calendar", "Ljava/util/Calendar;", DateProp.name, "stringFromCursor", "withPermissions", "Companion", "expo-calendar_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CalendarModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "CalendarModule";
    private final CoroutineScope moduleCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    private final SimpleDateFormat sdf;

    public CalendarModule() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        this.sdf = simpleDateFormat;
    }

    private final ContentResolver getContentResolver() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext.getContentResolver();
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        AsyncFunctionComponent asyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        CalendarModule calendarModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (calendarModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(calendarModule);
            moduleDefinitionBuilder.Name("ExpoCalendar");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$OnDestroy$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    try {
                        CoroutineScopeKt.cancel(CalendarModule.this.moduleCoroutineScope, new ModuleDestroyedException());
                    } catch (IllegalStateException unused) {
                        Log.e(CalendarModule.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("getCalendarsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (CalendarModule.this.checkPermissions(promise)) {
                        if (str == null || !Intrinsics.areEqual(str, NotificationCompat.CATEGORY_REMINDER)) {
                            BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$4$lambda$3$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, promise), 3, null);
                        } else {
                            promise.reject("E_CALENDARS_NOT_FOUND", "Calendars of type `reminder` are not supported on Android", null);
                        }
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getCalendarsAsync", asyncFunctionWithPromiseComponent4);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent5 = asyncFunctionWithPromiseComponent4;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent6 = new AsyncFunctionWithPromiseComponent("saveCalendarAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$4
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    ReadableArguments readableArguments = (ReadableArguments) objArr[0];
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$7$lambda$6$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, readableArguments, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("saveCalendarAsync", asyncFunctionWithPromiseComponent6);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent7 = asyncFunctionWithPromiseComponent6;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent8 = new AsyncFunctionWithPromiseComponent("deleteCalendarAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$6
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$10$lambda$9$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, str, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteCalendarAsync", asyncFunctionWithPromiseComponent8);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent9 = asyncFunctionWithPromiseComponent8;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent10 = new AsyncFunctionWithPromiseComponent("getEventsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Object.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Object.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Object.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Object.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$10
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    List list = (List) objArr[2];
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$13$lambda$12$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, obj, obj2, list, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getEventsAsync", asyncFunctionWithPromiseComponent10);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent11 = asyncFunctionWithPromiseComponent10;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent12 = new AsyncFunctionWithPromiseComponent("getEventByIdAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$12
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$16$lambda$15$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, str, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getEventByIdAsync", asyncFunctionWithPromiseComponent12);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent13 = asyncFunctionWithPromiseComponent12;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent14 = new AsyncFunctionWithPromiseComponent("saveEventAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$15
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) obj;
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$19$lambda$18$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, readableArguments, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("saveEventAsync", asyncFunctionWithPromiseComponent14);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent15 = asyncFunctionWithPromiseComponent14;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent16 = new AsyncFunctionWithPromiseComponent("deleteEventAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), true, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableArguments.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$18
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    ReadableArguments readableArguments = (ReadableArguments) obj;
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$22$lambda$21$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, readableArguments, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteEventAsync", asyncFunctionWithPromiseComponent16);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent17 = asyncFunctionWithPromiseComponent16;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent18 = new AsyncFunctionWithPromiseComponent("getAttendeesForEventAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$20
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$25$lambda$24$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, str, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getAttendeesForEventAsync", asyncFunctionWithPromiseComponent18);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent19 = asyncFunctionWithPromiseComponent18;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent20 = new AsyncFunctionWithPromiseComponent("saveAttendeeForEventAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$23
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    ReadableArguments readableArguments = (ReadableArguments) obj;
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$28$lambda$27$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, readableArguments, str, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("saveAttendeeForEventAsync", asyncFunctionWithPromiseComponent20);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent21 = asyncFunctionWithPromiseComponent20;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent22 = new AsyncFunctionWithPromiseComponent("deleteAttendeeAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunctionWithPromise$25
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) objArr[0];
                    if (CalendarModule.this.checkPermissions(promise)) {
                        BuildersKt__Builders_commonKt.launch$default(CalendarModule.this.moduleCoroutineScope, null, null, new CalendarModule$definition$lambda$35$lambda$31$lambda$30$$inlined$launchAsyncWithModuleScope$1(promise, null, CalendarModule.this, str, promise), 3, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteAttendeeAsync", asyncFunctionWithPromiseComponent22);
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent23 = asyncFunctionWithPromiseComponent22;
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Integer.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("openEventInCalendar", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        int intValue = ((Integer) promise).intValue();
                        Context reactContext = CalendarModule.this.getAppContext().getReactContext();
                        if (reactContext == null) {
                            throw new Exceptions.ReactContextLost();
                        }
                        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, intValue);
                        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                        Intent data = new Intent("android.intent.action.VIEW").addFlags(268435456).setData(withAppendedId);
                        Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
                        if (data.resolveActivity(reactContext.getPackageManager()) != null) {
                            reactContext.startActivity(data);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }))};
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        int intValue = ((Number) objArr[0]).intValue();
                        Context reactContext = CalendarModule.this.getAppContext().getReactContext();
                        if (reactContext == null) {
                            throw new Exceptions.ReactContextLost();
                        }
                        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, intValue);
                        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                        Intent data = new Intent("android.intent.action.VIEW").addFlags(268435456).setData(withAppendedId);
                        Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
                        if (data.resolveActivity(reactContext.getPackageManager()) != null) {
                            reactContext.startActivity(data);
                        }
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent = new StringAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                                } else {
                                    asyncFunctionComponent = new AsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                                }
                            } else {
                                asyncFunctionComponent = new FloatAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                            }
                        } else {
                            asyncFunctionComponent = new DoubleAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                        }
                    } else {
                        asyncFunctionComponent = new BoolAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                    }
                } else {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("openEventInCalendar", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = asyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("openEventInCalendar", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("requestCalendarPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.CC.askForPermissionsWithPermissionsManager(CalendarModule.this.getAppContext().getPermissions(), promise, "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function12 = new Function1<Object[], Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.CC.askForPermissionsWithPermissionsManager(CalendarModule.this.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function12);
                                } else {
                                    asyncFunctionComponent2 = new AsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function12);
                                }
                            } else {
                                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function12);
                            }
                        } else {
                            asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function12);
                        }
                    } else {
                        asyncFunctionComponent2 = new BoolAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function12);
                    }
                } else {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("requestCalendarPermissionsAsync", anyTypeArr2, function12);
                }
                asyncFunctionWithPromiseComponent2 = asyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("requestCalendarPermissionsAsync", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent("getCalendarPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$7
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.CC.getPermissionsWithPermissionsManager(CalendarModule.this.getAppContext().getPermissions(), promise, "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))};
                Function1<Object[], Unit> function13 = new Function1<Object[], Unit>() { // from class: expo.modules.calendar.CalendarModule$definition$lambda$35$$inlined$AsyncFunction$9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
                        Permissions.CC.getPermissionsWithPermissionsManager(CalendarModule.this.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR");
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function13);
                                } else {
                                    asyncFunctionComponent3 = new AsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function13);
                                }
                            } else {
                                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function13);
                            }
                        } else {
                            asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function13);
                        }
                    } else {
                        asyncFunctionComponent3 = new BoolAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function13);
                    }
                } else {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("getCalendarPermissionsAsync", anyTypeArr3, function13);
                }
                asyncFunctionWithPromiseComponent3 = asyncFunctionComponent3;
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("getCalendarPermissionsAsync", asyncFunctionWithPromiseComponent3);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    private final void launchAsyncWithModuleScope(Promise promise, Function0<Unit> block) {
        BuildersKt__Builders_commonKt.launch$default(this.moduleCoroutineScope, null, null, new CalendarModule$launchAsyncWithModuleScope$1(block, promise, null), 3, null);
    }

    private final void withPermissions(Promise promise, Function0<Unit> block) {
        if (checkPermissions(promise)) {
            block.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Bundle> findCalendars() throws SecurityException {
        Cursor query = getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, ConstantsKt.getFindCalendarsQueryParameters(), null, null, null);
        if (query == null) {
            throw new IllegalArgumentException("Cursor shouldn't be null".toString());
        }
        Cursor cursor = query;
        try {
            List<Bundle> serializeEventCalendars = serializeEventCalendars(cursor);
            CloseableKt.closeFinally(cursor, null);
            return serializeEventCalendars;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Bundle> findEvents(Object startDate, Object endDate, List<String> calendars) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        try {
            Intrinsics.checkNotNull(calendar);
            setDateInCalendar(calendar, startDate);
            Intrinsics.checkNotNull(calendar2);
            setDateInCalendar(calendar2, endDate);
        } catch (ParseException e) {
            Log.e(TAG, "error parsing", e);
        } catch (Exception e2) {
            Log.e(TAG, "misc error parsing", e2);
        }
        Uri.Builder buildUpon = CalendarContract.Instances.CONTENT_URI.buildUpon();
        ContentUris.appendId(buildUpon, calendar.getTimeInMillis());
        ContentUris.appendId(buildUpon, calendar2.getTimeInMillis());
        Uri build = buildUpon.build();
        String str = "((begin >= " + calendar.getTimeInMillis() + ") AND (end <= " + calendar2.getTimeInMillis() + ") AND (visible = 1) ";
        if (!calendars.isEmpty()) {
            int size = calendars.size();
            String str2 = "AND (";
            for (int i = 0; i < size; i++) {
                str2 = str2 + "calendar_id = '" + ((Object) calendars.get(i)) + "'";
                if (i != calendars.size() - 1) {
                    str2 = str2 + " OR ";
                }
            }
            str = str + (str2 + ")");
        }
        Cursor query = getContentResolver().query(build, ConstantsKt.getFindEventsQueryParameters(), str + ")", null, null);
        if (query == null) {
            throw new IllegalArgumentException("Cursor shouldn't be null".toString());
        }
        Cursor cursor = query;
        try {
            List<Bundle> serializeEvents = serializeEvents(cursor);
            CloseableKt.closeFinally(cursor, null);
            return serializeEvents;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle findEventById(String eventID) {
        Bundle bundle;
        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, Integer.parseInt(eventID));
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
        Cursor query = getContentResolver().query(withAppendedId, ConstantsKt.getFindEventByIdQueryParameters(), "((deleted != 1))", null, null);
        if (query == null) {
            throw new IllegalArgumentException("Cursor shouldn't be null".toString());
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            if (query.getCount() > 0) {
                query.moveToFirst();
                bundle = serializeEvent(query);
            } else {
                bundle = null;
            }
            CloseableKt.closeFinally(cursor, null);
            return bundle;
        } finally {
        }
    }

    private final Bundle findCalendarById(String calendarID) {
        Bundle bundle;
        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, Integer.parseInt(calendarID));
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
        Cursor query = getContentResolver().query(withAppendedId, ConstantsKt.getFindCalendarByIdQueryFields(), null, null, null);
        if (query == null) {
            throw new IllegalArgumentException("Cursor shouldn't be null".toString());
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.getCount() > 0) {
                cursor2.moveToFirst();
                bundle = serializeEventCalendar(cursor2);
            } else {
                bundle = null;
            }
            CloseableKt.closeFinally(cursor, null);
            return bundle;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Bundle> findAttendeesByEventId(String eventID) {
        Cursor query = CalendarContract.Attendees.query(getContentResolver(), Long.parseLong(eventID), ConstantsKt.getFindAttendeesByEventIdQueryParameters());
        try {
            List<Bundle> serializeAttendees = serializeAttendees(query);
            CloseableKt.closeFinally(query, null);
            return serializeAttendees;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int saveCalendar(ReadableArguments details) throws Exception {
        String string;
        CalendarEventBuilder calendarEventBuilder = new CalendarEventBuilder(details);
        calendarEventBuilder.putEventString("name", "name").putEventString("calendar_displayName", "title").putEventBoolean(ViewProps.VISIBLE, "isVisible").putEventBoolean("sync_events", "isSynced");
        if (details.containsKey("id")) {
            String string2 = details.getString("id");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int parseInt = Integer.parseInt(string2);
            Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, parseInt);
            Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
            getContentResolver().update(withAppendedId, calendarEventBuilder.getEventValues(), null, null);
            return parseInt;
        }
        calendarEventBuilder.checkIfContainsRequiredKeys("name", "title", "source", "color", "accessLevel", "ownerAccount");
        ReadableArguments arguments = details.getArguments("source");
        if (!arguments.containsKey("name")) {
            throw new Exception("new calendars require a `source` object with a `name`");
        }
        boolean z = arguments.containsKey("isLocalAccount") ? arguments.getBoolean("isLocalAccount") : false;
        if (!arguments.containsKey("type") && !z) {
            throw new Exception("new calendars require a `source` object with a `type`, or `isLocalAccount`: true");
        }
        String string3 = arguments.getString("name");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CalendarEventBuilder put = calendarEventBuilder.put("account_name", string3);
        String str = "LOCAL";
        if (!z) {
            string = arguments.getString("type");
        } else {
            string = "LOCAL";
        }
        Intrinsics.checkNotNull(string);
        CalendarEventBuilder put2 = put.put("account_type", string).put("calendar_color", details.getInt("color"));
        String string4 = details.getString("accessLevel");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CalendarEventBuilder put3 = put2.put("calendar_access_level", JsValuesMappersKt.calAccessConstantMatchingString(string4));
        String string5 = details.getString("ownerAccount");
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        put3.put("ownerAccount", string5).putEventTimeZone("calendar_timezone", "timeZone").putEventDetailsList("allowedReminders", "allowedReminders", new Function1<Object, Integer>() { // from class: expo.modules.calendar.CalendarModule$saveCalendar$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Object obj) {
                return Integer.valueOf(JsValuesMappersKt.reminderConstantMatchingString((String) obj));
            }
        }).putEventDetailsList("allowedAvailability", "allowedAvailabilities", new Function1<Object, Integer>() { // from class: expo.modules.calendar.CalendarModule$saveCalendar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                return Integer.valueOf(JsValuesMappersKt.availabilityConstantMatchingString((String) obj));
            }
        }).putEventDetailsList("allowedAttendeeTypes", "allowedAttendeeTypes", new Function1<Object, Integer>() { // from class: expo.modules.calendar.CalendarModule$saveCalendar$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                return Integer.valueOf(JsValuesMappersKt.attendeeTypeConstantMatchingString((String) obj));
            }
        });
        Uri.Builder appendQueryParameter = CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).appendQueryParameter("account_name", arguments.getString("name"));
        if (!z) {
            str = arguments.getString("type");
        }
        Uri insert = getContentResolver().insert(appendQueryParameter.appendQueryParameter("account_type", str).build(), calendarEventBuilder.getEventValues());
        Intrinsics.checkNotNull(insert);
        String lastPathSegment = insert.getLastPathSegment();
        Intrinsics.checkNotNull(lastPathSegment);
        return Integer.parseInt(lastPathSegment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean deleteCalendar(String calendarId) throws SecurityException {
        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, Integer.parseInt(calendarId));
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
        return getContentResolver().delete(withAppendedId, null, null) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012b A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int saveEvent(expo.modules.core.arguments.ReadableArguments r14) throws expo.modules.calendar.EventNotSavedException, java.text.ParseException, java.lang.SecurityException, expo.modules.core.errors.InvalidArgumentException {
        /*
            Method dump skipped, instructions count: 643
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.calendar.CalendarModule.saveEvent(expo.modules.core.arguments.ReadableArguments):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeEvent(ReadableArguments details) throws ParseException, SecurityException {
        String string = details.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int parseInt = Integer.parseInt(string);
        if (!details.containsKey("instanceStartDate")) {
            Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, parseInt);
            Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
            return getContentResolver().delete(withAppendedId, null, null) > 0;
        }
        ContentValues contentValues = new ContentValues();
        Calendar calendar = Calendar.getInstance();
        Object obj = details.get("instanceStartDate");
        try {
            if (obj instanceof String) {
                Date parse = this.sdf.parse((String) obj);
                if (parse != null) {
                    calendar.setTime(parse);
                    contentValues.put("originalInstanceTime", Long.valueOf(calendar.getTimeInMillis()));
                } else {
                    Log.e(TAG, "Parsed date is null");
                }
            } else if (obj instanceof Number) {
                contentValues.put("originalInstanceTime", Long.valueOf(((Number) obj).longValue()));
            }
            contentValues.put("eventStatus", (Integer) 2);
            Uri withAppendedId2 = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_EXCEPTION_URI, parseInt);
            Intrinsics.checkNotNullExpressionValue(withAppendedId2, "withAppendedId(...)");
            getContentResolver().insert(withAppendedId2, contentValues);
            return true;
        } catch (ParseException e) {
            Log.e(TAG, "error", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int saveAttendeeForEvent(ReadableArguments details, String eventID) throws Exception, SecurityException {
        boolean containsKey = details.containsKey("id");
        boolean z = !containsKey;
        AttendeeBuilder putString = new AttendeeBuilder(details).putString("name", "attendeeName").putString("email", "attendeeEmail", z).putString(ViewProps.ROLE, "attendeeRelationship", Boolean.valueOf(z), CalendarModule$saveAttendeeForEvent$attendeeBuilder$1.INSTANCE).putString("type", "attendeeType", Boolean.valueOf(z), CalendarModule$saveAttendeeForEvent$attendeeBuilder$2.INSTANCE).putString("status", "attendeeStatus", Boolean.valueOf(z), CalendarModule$saveAttendeeForEvent$attendeeBuilder$3.INSTANCE);
        if (!containsKey) {
            putString.put("event_id", eventID != null ? Integer.valueOf(Integer.parseInt(eventID)) : null);
            Uri insert = getContentResolver().insert(CalendarContract.Attendees.CONTENT_URI, putString.getAttendeeValues());
            Intrinsics.checkNotNull(insert);
            String lastPathSegment = insert.getLastPathSegment();
            Intrinsics.checkNotNull(lastPathSegment);
            return Integer.parseInt(lastPathSegment);
        }
        String string = details.getString("id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int parseInt = Integer.parseInt(string);
        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Attendees.CONTENT_URI, parseInt);
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
        getContentResolver().update(withAppendedId, putString.getAttendeeValues(), null, null);
        return parseInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean deleteAttendee(String attendeeID) throws SecurityException {
        Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Attendees.CONTENT_URI, Integer.parseInt(attendeeID));
        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
        return getContentResolver().delete(withAppendedId, null, null) > 0;
    }

    private final void createRemindersForEvent(int eventID, List<?> reminders) throws SecurityException {
        int i;
        int size = reminders.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = reminders.get(i2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            Map map = (Map) obj;
            Object obj2 = map.get("relativeOffset");
            if (obj2 instanceof Number) {
                int i3 = -((Number) obj2).intValue();
                ContentValues contentValues = new ContentValues();
                if (map.containsKey(Request.JsonKeys.METHOD)) {
                    Object obj3 = map.get(Request.JsonKeys.METHOD);
                    i = JsValuesMappersKt.reminderConstantMatchingString(obj3 instanceof String ? (String) obj3 : null);
                } else {
                    i = 0;
                }
                contentValues.put("event_id", Integer.valueOf(eventID));
                contentValues.put("minutes", Integer.valueOf(i3));
                contentValues.put(Request.JsonKeys.METHOD, Integer.valueOf(i));
                getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues);
            }
        }
    }

    private final void removeRemindersForEvent(int eventID) throws SecurityException {
        Cursor query = CalendarContract.Reminders.query(getContentResolver(), eventID, new String[]{"_id"});
        while (query.moveToNext()) {
            Uri withAppendedId = ContentUris.withAppendedId(CalendarContract.Reminders.CONTENT_URI, query.getLong(0));
            Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
            getContentResolver().delete(withAppendedId, null, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final String createRecurrenceRule(String recurrence, Integer interval, String endDate, Integer occurrence) {
        String str;
        switch (recurrence.hashCode()) {
            case -791707519:
                if (recurrence.equals("weekly")) {
                    str = "FREQ=WEEKLY";
                    break;
                }
                str = "";
                break;
            case -734561654:
                if (recurrence.equals("yearly")) {
                    str = "FREQ=YEARLY";
                    break;
                }
                str = "";
                break;
            case 95346201:
                if (recurrence.equals("daily")) {
                    str = "FREQ=DAILY";
                    break;
                }
                str = "";
                break;
            case 1236635661:
                if (recurrence.equals("monthly")) {
                    str = "FREQ=MONTHLY";
                    break;
                }
                str = "";
                break;
            default:
                str = "";
                break;
        }
        if (interval != null) {
            str = str + ";INTERVAL=" + interval;
        }
        if (endDate != null) {
            return str + ";UNTIL=" + endDate;
        }
        if (occurrence == null) {
            return str;
        }
        return str + ";COUNT=" + occurrence;
    }

    private final List<Bundle> serializeEvents(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(serializeEvent(cursor));
        }
        return arrayList;
    }

    private final Bundle serializeEvent(Cursor cursor) {
        String str;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        String string = cursor.getString(3);
        String str2 = "";
        if (string != null) {
            calendar.setTimeInMillis(Long.parseLong(string));
            String format = this.sdf.format(calendar.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str = format;
        } else {
            str = "";
        }
        String string2 = cursor.getString(4);
        if (string2 != null) {
            calendar2.setTimeInMillis(Long.parseLong(string2));
            str2 = this.sdf.format(calendar2.getTime());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        }
        String optStringFromCursor = optStringFromCursor(cursor, "rrule");
        Bundle bundle = null;
        if (optStringFromCursor != null) {
            Bundle bundle2 = new Bundle();
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) optStringFromCursor, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            String str3 = ((String[]) StringsKt.split$default((CharSequence) strArr[0], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]))[1];
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str3.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            bundle2.putString("frequency", lowerCase);
            if (strArr.length >= 2 && Intrinsics.areEqual(((String[]) StringsKt.split$default((CharSequence) strArr[1], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]))[0], "INTERVAL")) {
                bundle2.putInt("interval", Integer.parseInt(((String[]) StringsKt.split$default((CharSequence) strArr[1], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]))[1]));
            }
            if (strArr.length >= 3) {
                String[] strArr2 = (String[]) StringsKt.split$default((CharSequence) strArr[2], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (strArr2.length >= 2) {
                    if (Intrinsics.areEqual(strArr2[0], "UNTIL")) {
                        try {
                            Date parse = this.sdf.parse(strArr2[1]);
                            bundle2.putString("endDate", parse != null ? parse.toString() : null);
                        } catch (NullPointerException e) {
                            Log.e(TAG, "endDate is null", e);
                        } catch (ParseException e2) {
                            Log.e(TAG, "Couldn't parse the `endDate` property.", e2);
                        }
                    } else if (Intrinsics.areEqual(strArr2[0], AdwHomeBadger.COUNT)) {
                        bundle2.putInt("occurrence", Integer.parseInt(((String[]) StringsKt.split$default((CharSequence) strArr[2], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]))[1]));
                    }
                }
                Log.e(TAG, "Couldn't parse termination rules: '" + strArr[2] + "'.", null);
            }
            bundle = bundle2;
        }
        Bundle bundle3 = new Bundle();
        if (bundle != null) {
            bundle3.putBundle("recurrenceRule", bundle);
        }
        bundle3.putString("id", cursor.getString(0));
        bundle3.putString("calendarId", optStringFromCursor(cursor, "calendar_id"));
        bundle3.putString("title", optStringFromCursor(cursor, "title"));
        bundle3.putString("notes", optStringFromCursor(cursor, "description"));
        bundle3.putString("startDate", str);
        bundle3.putString("endDate", str2);
        bundle3.putBoolean("allDay", optIntFromCursor(cursor, "allDay") != 0);
        bundle3.putString(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID, optStringFromCursor(cursor, "eventLocation"));
        bundle3.putString("availability", JsValuesMappersKt.availabilityStringMatchingConstant(optIntFromCursor(cursor, "availability")));
        bundle3.putParcelableArrayList("alarms", serializeAlarms(cursor.getLong(0)));
        bundle3.putString("organizerEmail", optStringFromCursor(cursor, "organizer"));
        bundle3.putString("timeZone", optStringFromCursor(cursor, "eventTimezone"));
        bundle3.putString("endTimeZone", optStringFromCursor(cursor, "eventEndTimezone"));
        bundle3.putString("accessLevel", JsValuesMappersKt.accessStringMatchingConstant(optIntFromCursor(cursor, "accessLevel")));
        bundle3.putBoolean("guestsCanModify", optIntFromCursor(cursor, "guestsCanModify") != 0);
        bundle3.putBoolean("guestsCanInviteOthers", optIntFromCursor(cursor, "guestsCanInviteOthers") != 0);
        bundle3.putBoolean("guestsCanSeeGuests", optIntFromCursor(cursor, "guestsCanSeeGuests") != 0);
        bundle3.putString("originalId", optStringFromCursor(cursor, "original_id"));
        if (cursor.getColumnCount() > 18) {
            bundle3.putString("instanceId", cursor.getString(18));
        }
        return bundle3;
    }

    private final ArrayList<Bundle> serializeAlarms(long eventID) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Cursor query = CalendarContract.Reminders.query(getContentResolver(), eventID, new String[]{"minutes", Request.JsonKeys.METHOD});
        while (query.moveToNext()) {
            Bundle bundle = new Bundle();
            bundle.putInt("relativeOffset", -query.getInt(0));
            bundle.putString(Request.JsonKeys.METHOD, JsValuesMappersKt.reminderStringMatchingConstant(query.getInt(1)));
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private final List<Bundle> serializeEventCalendars(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(serializeEventCalendar(cursor));
        }
        return arrayList;
    }

    private final Bundle serializeEventCalendar(Cursor cursor) {
        Bundle bundle = new Bundle();
        bundle.putString("id", optStringFromCursor(cursor, "_id"));
        bundle.putString("title", optStringFromCursor(cursor, "calendar_displayName"));
        bundle.putBoolean("isPrimary", optStringFromCursor(cursor, "isPrimary") == "1");
        bundle.putStringArrayList("allowedAvailabilities", JsValuesMappersKt.calendarAllowedAvailabilitiesFromDBString(stringFromCursor(cursor, "allowedAvailability")));
        bundle.putString("name", optStringFromCursor(cursor, "name"));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(optIntFromCursor(cursor, "calendar_color") & ViewCompat.MEASURED_SIZE_MASK)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        bundle.putString("color", format);
        bundle.putString("ownerAccount", optStringFromCursor(cursor, "ownerAccount"));
        bundle.putString("timeZone", optStringFromCursor(cursor, "calendar_timezone"));
        bundle.putStringArrayList("allowedReminders", JsValuesMappersKt.calendarAllowedRemindersFromDBString(stringFromCursor(cursor, "allowedReminders")));
        bundle.putStringArrayList("allowedAttendeeTypes", JsValuesMappersKt.calendarAllowedAttendeeTypesFromDBString(stringFromCursor(cursor, "allowedAttendeeTypes")));
        bundle.putBoolean("isVisible", optIntFromCursor(cursor, ViewProps.VISIBLE) != 0);
        bundle.putBoolean("isSynced", optIntFromCursor(cursor, "sync_events") != 0);
        int optIntFromCursor = optIntFromCursor(cursor, "calendar_access_level");
        bundle.putString("accessLevel", JsValuesMappersKt.calAccessStringMatchingConstant(optIntFromCursor));
        bundle.putBoolean("allowsModifications", optIntFromCursor == 800 || optIntFromCursor == 700 || optIntFromCursor == 600 || optIntFromCursor == 500);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", optStringFromCursor(cursor, "account_name"));
        String optStringFromCursor = optStringFromCursor(cursor, "account_type");
        bundle2.putString("type", optStringFromCursor);
        bundle2.putBoolean("isLocalAccount", Intrinsics.areEqual(optStringFromCursor, "LOCAL"));
        bundle.putBundle("source", bundle2);
        return bundle;
    }

    private final List<Bundle> serializeAttendees(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(serializeAttendee(cursor));
        }
        return arrayList;
    }

    private final Bundle serializeAttendee(Cursor cursor) {
        Bundle bundle = new Bundle();
        bundle.putString("id", optStringFromCursor(cursor, "_id"));
        bundle.putString("name", optStringFromCursor(cursor, "attendeeName"));
        bundle.putString("email", optStringFromCursor(cursor, "attendeeEmail"));
        bundle.putString(ViewProps.ROLE, JsValuesMappersKt.attendeeRelationshipStringMatchingConstant(optIntFromCursor(cursor, "attendeeRelationship")));
        bundle.putString("type", JsValuesMappersKt.attendeeTypeStringMatchingConstant(optIntFromCursor(cursor, "attendeeType")));
        bundle.putString("status", JsValuesMappersKt.attendeeStatusStringMatchingConstant(optIntFromCursor(cursor, "attendeeStatus")));
        return bundle;
    }

    private final String optStringFromCursor(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex == -1) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    private final String stringFromCursor(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex == -1) {
            throw new Exception("String not found");
        }
        String string = cursor.getString(columnIndex);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final int optIntFromCursor(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        if (columnIndex == -1) {
            return 0;
        }
        return cursor.getInt(columnIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkPermissions(Promise promise) {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null && permissions.hasGrantedPermissions("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR")) {
            return true;
        }
        promise.reject("E_MISSING_PERMISSIONS", "CALENDAR permission is required to do this operation.", null);
        return false;
    }

    private final void setDateInCalendar(Calendar calendar, Object date) {
        if (date instanceof String) {
            Date parse = this.sdf.parse((String) date);
            if (parse != null) {
                calendar.setTime(parse);
                return;
            } else {
                Log.e(TAG, "Parsed date is null");
                return;
            }
        }
        if (date instanceof Number) {
            calendar.setTimeInMillis(((Number) date).longValue());
        } else {
            Log.e(TAG, "date has unsupported type");
        }
    }

    /* compiled from: CalendarModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/calendar/CalendarModule$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$expo_calendar_release", "()Ljava/lang/String;", "expo-calendar_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_calendar_release() {
            return CalendarModule.TAG;
        }
    }
}
