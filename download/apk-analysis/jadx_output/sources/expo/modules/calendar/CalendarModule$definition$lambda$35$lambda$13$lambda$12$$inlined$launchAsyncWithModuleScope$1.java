package expo.modules.calendar;

import expo.modules.kotlin.Promise;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CalendarModule.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "expo/modules/calendar/CalendarModule$launchAsyncWithModuleScope$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.calendar.CalendarModule$definition$lambda$35$lambda$13$lambda$12$$inlined$launchAsyncWithModuleScope$1", f = "CalendarModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class CalendarModule$definition$lambda$35$lambda$13$lambda$12$$inlined$launchAsyncWithModuleScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $calendars$inlined;
    final /* synthetic */ Object $endDate$inlined;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Promise $promise$inlined;
    final /* synthetic */ Object $startDate$inlined;
    int label;
    final /* synthetic */ CalendarModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarModule$definition$lambda$35$lambda$13$lambda$12$$inlined$launchAsyncWithModuleScope$1(Promise promise, Continuation continuation, CalendarModule calendarModule, Object obj, Object obj2, List list, Promise promise2) {
        super(2, continuation);
        this.$promise = promise;
        this.this$0 = calendarModule;
        this.$startDate$inlined = obj;
        this.$endDate$inlined = obj2;
        this.$calendars$inlined = list;
        this.$promise$inlined = promise2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CalendarModule$definition$lambda$35$lambda$13$lambda$12$$inlined$launchAsyncWithModuleScope$1(this.$promise, continuation, this.this$0, this.$startDate$inlined, this.$endDate$inlined, this.$calendars$inlined, this.$promise$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CalendarModule$definition$lambda$35$lambda$13$lambda$12$$inlined$launchAsyncWithModuleScope$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List findEvents;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                try {
                    findEvents = this.this$0.findEvents(this.$startDate$inlined, this.$endDate$inlined, this.$calendars$inlined);
                    this.$promise$inlined.resolve(findEvents);
                } catch (Exception e) {
                    this.$promise$inlined.reject("E_EVENTS_NOT_FOUND", "Events could not be found", e);
                }
            } catch (ModuleDestroyedException unused) {
                this.$promise.reject("E_CALENDAR_MODULE_DESTROYED", "Module destroyed, promise canceled", null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
