package com.microsoft.clarity.models.display;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.protobuf.GeneratedMessageLite;
import com.microsoft.clarity.models.IProtoPageEventModel;
import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.commands.DisplayCommand;
import com.microsoft.clarity.models.display.common.Vertices;
import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paths.Path;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import com.microsoft.clarity.models.observers.ScreenMetadata;
import com.microsoft.clarity.models.viewhierarchy.ViewHierarchy;
import com.microsoft.clarity.protomodels.mutationpayload.C0122k;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayFrame;
import io.sentry.protocol.DebugMeta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\"\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BÝ\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001b\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001b\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001b¢\u0006\u0004\b*\u0010+Bw\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010,\u001a\u00020\u0011\u0012\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b*\u00100J\u0017\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b:\u0010;J\u0010\u0010<\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b<\u0010;J\u0010\u0010=\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b=\u0010;J\u0010\u0010>\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b>\u0010;J\u0010\u0010?\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\bA\u0010BJ\u001e\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\bE\u0010BJ\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0003¢\u0006\u0004\bF\u0010GJ\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bHÆ\u0003¢\u0006\u0004\bH\u0010GJ\u0016\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001bHÆ\u0003¢\u0006\u0004\bI\u0010GJ\u0016\u0010J\u001a\b\u0012\u0004\u0012\u00020 0\u001bHÆ\u0003¢\u0006\u0004\bJ\u0010GJ\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\"0\u001bHÆ\u0003¢\u0006\u0004\bK\u0010GJ\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020$0\u001bHÆ\u0003¢\u0006\u0004\bL\u0010GJ\u0016\u0010M\u001a\b\u0012\u0004\u0012\u00020&0\u001bHÆ\u0003¢\u0006\u0004\bM\u0010GJ\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020(0\u001bHÆ\u0003¢\u0006\u0004\bN\u0010GJ\u008c\u0002\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00112\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001b2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001b2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001b2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001b2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001bHÆ\u0001¢\u0006\u0004\bO\u0010PJ\u0010\u0010Q\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\bQ\u0010RJ\u0010\u0010S\u001a\u00020\nHÖ\u0001¢\u0006\u0004\bS\u0010;J\u001a\u0010V\u001a\u00020\u00112\b\u0010U\u001a\u0004\u0018\u00010THÖ\u0003¢\u0006\u0004\bV\u0010WR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010X\u001a\u0004\bY\u00105R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010Z\u001a\u0004\b[\u00107R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\\\u001a\u0004\b]\u00109R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010^\u001a\u0004\b_\u0010;R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010^\u001a\u0004\b`\u0010;R\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010^\u001a\u0004\ba\u0010;R\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010^\u001a\u0004\bb\u0010;R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010c\u001a\u0004\bd\u0010@R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010e\u001a\u0004\b\u0012\u0010BR%\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0016\u0010f\u001a\u0004\bg\u0010DR\u0017\u0010\u0017\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0017\u0010e\u001a\u0004\b\u0017\u0010BR(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010h\u001a\u0004\bi\u0010G\"\u0004\bj\u0010kR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010h\u001a\u0004\bl\u0010G\"\u0004\bm\u0010kR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010h\u001a\u0004\bn\u0010G\"\u0004\bo\u0010kR(\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010h\u001a\u0004\bp\u0010G\"\u0004\bq\u0010kR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8\u0006¢\u0006\f\n\u0004\b#\u0010h\u001a\u0004\br\u0010GR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u001b8\u0006¢\u0006\f\n\u0004\b%\u0010h\u001a\u0004\bs\u0010GR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001b8\u0006¢\u0006\f\n\u0004\b'\u0010h\u001a\u0004\bt\u0010GR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001b8\u0006¢\u0006\f\n\u0004\b)\u0010h\u001a\u0004\bu\u0010G¨\u0006v"}, d2 = {"Lcom/microsoft/clarity/models/display/DisplayFrame;", "Lcom/microsoft/clarity/models/IProtoPageEventModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayFrame;", "Lcom/microsoft/clarity/models/display/IDisplayFrame;", "", "timestamp", "Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "viewHierarchy", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "screenMetadata", "", "screenWidth", "screenHeight", "keyboardHeight", "systemBackgroundColor", "", "density", "", "isForceStartNewSessionFirstFrame", "Lkotlin/Function1;", "", "", "forceStartNewSessionCallback", "isNewPageFirstFrame", "", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "commands", "", "Lcom/microsoft/clarity/models/display/typefaces/Typeface;", "typefaces", "Lcom/microsoft/clarity/models/display/images/Image;", DebugMeta.JsonKeys.IMAGES, "Lcom/microsoft/clarity/models/display/blobs/TextBlob;", "textBlobs", "Lcom/microsoft/clarity/models/display/common/Vertices;", "vertices", "Lcom/microsoft/clarity/models/display/paints/Paint;", "paints", "Lcom/microsoft/clarity/models/display/paths/Path;", "paths", "Lcom/microsoft/clarity/models/display/SubDisplayFrame;", "subDisplayFrames", "<init>", "(JLcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;Lcom/microsoft/clarity/models/observers/ScreenMetadata;IIIIFZLkotlin/jvm/functions/Function1;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "newSessionFirstFrame", "startNewSessionCallback", "Lcom/microsoft/clarity/i/d;", "parseResult", "(JLcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;Lcom/microsoft/clarity/models/observers/ScreenMetadata;IIIIFZLkotlin/jvm/functions/Function1;ZLcom/microsoft/clarity/i/d;)V", "pageTimestamp", "toProtobufInstance", "(J)Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayFrame;", "component1", "()J", "component2", "()Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "component3", "()Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "component4", "()I", "component5", "component6", "component7", "component8", "()F", "component9", "()Z", "component10", "()Lkotlin/jvm/functions/Function1;", "component11", "component12", "()Ljava/util/List;", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(JLcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;Lcom/microsoft/clarity/models/observers/ScreenMetadata;IIIIFZLkotlin/jvm/functions/Function1;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/microsoft/clarity/models/display/DisplayFrame;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getTimestamp", "Lcom/microsoft/clarity/models/viewhierarchy/ViewHierarchy;", "getViewHierarchy", "Lcom/microsoft/clarity/models/observers/ScreenMetadata;", "getScreenMetadata", "I", "getScreenWidth", "getScreenHeight", "getKeyboardHeight", "getSystemBackgroundColor", "F", "getDensity", "Z", "Lkotlin/jvm/functions/Function1;", "getForceStartNewSessionCallback", "Ljava/util/List;", "getCommands", "setCommands", "(Ljava/util/List;)V", "getTypefaces", "setTypefaces", "getImages", "setImages", "getTextBlobs", "setTextBlobs", "getVertices", "getPaints", "getPaths", "getSubDisplayFrames", "sdk_prodRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DisplayFrame implements IProtoPageEventModel<MutationPayload$DisplayFrame>, IDisplayFrame {
    private List<? extends DisplayCommand> commands;
    private final float density;
    private final Function1<String, Unit> forceStartNewSessionCallback;
    private List<Image> images;
    private final boolean isForceStartNewSessionFirstFrame;
    private final boolean isNewPageFirstFrame;
    private final int keyboardHeight;
    private final List<Paint> paints;
    private final List<Path> paths;
    private final int screenHeight;
    private final ScreenMetadata screenMetadata;
    private final int screenWidth;
    private final List<SubDisplayFrame> subDisplayFrames;
    private final int systemBackgroundColor;
    private List<TextBlob> textBlobs;
    private final long timestamp;
    private List<Typeface> typefaces;
    private final List<Vertices> vertices;
    private final ViewHierarchy viewHierarchy;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DisplayFrame(long r24, com.microsoft.clarity.models.viewhierarchy.ViewHierarchy r26, com.microsoft.clarity.models.observers.ScreenMetadata r27, int r28, int r29, int r30, int r31, float r32, boolean r33, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r34, boolean r35, com.microsoft.clarity.i.C0110d r36) {
        /*
            r23 = this;
            r0 = r36
            java.lang.String r1 = "viewHierarchy"
            r5 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r1 = "screenMetadata"
            r6 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "parseResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.List r15 = r0.f172a
            java.util.ArrayList r1 = r0.b
            java.util.ArrayList r14 = r0.c
            java.util.ArrayList r13 = r0.d
            java.util.ArrayList r12 = r0.e
            java.util.ArrayList r11 = r0.f
            java.util.ArrayList r10 = r0.g
            java.util.ArrayList r0 = r0.h
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L34:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L49
            java.lang.Object r3 = r0.next()
            com.microsoft.clarity.i.d r3 = (com.microsoft.clarity.i.C0110d) r3
            com.microsoft.clarity.models.display.SubDisplayFrame r4 = new com.microsoft.clarity.models.display.SubDisplayFrame
            r4.<init>(r3)
            r2.add(r4)
            goto L34
        L49:
            java.util.List r22 = kotlin.collections.CollectionsKt.toMutableList(r2)
            r2 = r23
            r3 = r24
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r0 = r10
            r10 = r31
            r20 = r11
            r11 = r32
            r19 = r12
            r12 = r33
            r18 = r13
            r13 = r34
            r17 = r14
            r14 = r35
            r16 = r1
            r21 = r0
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.models.display.DisplayFrame.<init>(long, com.microsoft.clarity.models.viewhierarchy.ViewHierarchy, com.microsoft.clarity.models.observers.ScreenMetadata, int, int, int, int, float, boolean, kotlin.jvm.functions.Function1, boolean, com.microsoft.clarity.i.d):void");
    }

    public final long component1() {
        return getTimestamp();
    }

    public final Function1<String, Unit> component10() {
        return this.forceStartNewSessionCallback;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsNewPageFirstFrame() {
        return this.isNewPageFirstFrame;
    }

    public final List<DisplayCommand> component12() {
        return this.commands;
    }

    public final List<Typeface> component13() {
        return this.typefaces;
    }

    public final List<Image> component14() {
        return this.images;
    }

    public final List<TextBlob> component15() {
        return this.textBlobs;
    }

    public final List<Vertices> component16() {
        return this.vertices;
    }

    public final List<Paint> component17() {
        return this.paints;
    }

    public final List<Path> component18() {
        return this.paths;
    }

    public final List<SubDisplayFrame> component19() {
        return this.subDisplayFrames;
    }

    /* renamed from: component2, reason: from getter */
    public final ViewHierarchy getViewHierarchy() {
        return this.viewHierarchy;
    }

    public final ScreenMetadata component3() {
        return getScreenMetadata();
    }

    /* renamed from: component4, reason: from getter */
    public final int getScreenWidth() {
        return this.screenWidth;
    }

    /* renamed from: component5, reason: from getter */
    public final int getScreenHeight() {
        return this.screenHeight;
    }

    /* renamed from: component6, reason: from getter */
    public final int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSystemBackgroundColor() {
        return this.systemBackgroundColor;
    }

    /* renamed from: component8, reason: from getter */
    public final float getDensity() {
        return this.density;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsForceStartNewSessionFirstFrame() {
        return this.isForceStartNewSessionFirstFrame;
    }

    public final DisplayFrame copy(long timestamp, ViewHierarchy viewHierarchy, ScreenMetadata screenMetadata, int screenWidth, int screenHeight, int keyboardHeight, int systemBackgroundColor, float density, boolean isForceStartNewSessionFirstFrame, Function1<? super String, Unit> forceStartNewSessionCallback, boolean isNewPageFirstFrame, List<? extends DisplayCommand> commands, List<Typeface> typefaces, List<Image> images, List<TextBlob> textBlobs, List<Vertices> vertices, List<Paint> paints, List<Path> paths, List<SubDisplayFrame> subDisplayFrames) {
        Intrinsics.checkNotNullParameter(viewHierarchy, "viewHierarchy");
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(typefaces, "typefaces");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(textBlobs, "textBlobs");
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(subDisplayFrames, "subDisplayFrames");
        return new DisplayFrame(timestamp, viewHierarchy, screenMetadata, screenWidth, screenHeight, keyboardHeight, systemBackgroundColor, density, isForceStartNewSessionFirstFrame, forceStartNewSessionCallback, isNewPageFirstFrame, commands, typefaces, images, textBlobs, vertices, paints, paths, subDisplayFrames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayFrame)) {
            return false;
        }
        DisplayFrame displayFrame = (DisplayFrame) other;
        return getTimestamp() == displayFrame.getTimestamp() && Intrinsics.areEqual(this.viewHierarchy, displayFrame.viewHierarchy) && Intrinsics.areEqual(getScreenMetadata(), displayFrame.getScreenMetadata()) && this.screenWidth == displayFrame.screenWidth && this.screenHeight == displayFrame.screenHeight && this.keyboardHeight == displayFrame.keyboardHeight && this.systemBackgroundColor == displayFrame.systemBackgroundColor && Float.compare(this.density, displayFrame.density) == 0 && this.isForceStartNewSessionFirstFrame == displayFrame.isForceStartNewSessionFirstFrame && Intrinsics.areEqual(this.forceStartNewSessionCallback, displayFrame.forceStartNewSessionCallback) && this.isNewPageFirstFrame == displayFrame.isNewPageFirstFrame && Intrinsics.areEqual(this.commands, displayFrame.commands) && Intrinsics.areEqual(this.typefaces, displayFrame.typefaces) && Intrinsics.areEqual(this.images, displayFrame.images) && Intrinsics.areEqual(this.textBlobs, displayFrame.textBlobs) && Intrinsics.areEqual(this.vertices, displayFrame.vertices) && Intrinsics.areEqual(this.paints, displayFrame.paints) && Intrinsics.areEqual(this.paths, displayFrame.paths) && Intrinsics.areEqual(this.subDisplayFrames, displayFrame.subDisplayFrames);
    }

    public final List<DisplayCommand> getCommands() {
        return this.commands;
    }

    public final float getDensity() {
        return this.density;
    }

    public final Function1<String, Unit> getForceStartNewSessionCallback() {
        return this.forceStartNewSessionCallback;
    }

    public final List<Image> getImages() {
        return this.images;
    }

    public final int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public final List<Paint> getPaints() {
        return this.paints;
    }

    public final List<Path> getPaths() {
        return this.paths;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    @Override // com.microsoft.clarity.models.display.IDisplayFrame
    public ScreenMetadata getScreenMetadata() {
        return this.screenMetadata;
    }

    public final int getScreenWidth() {
        return this.screenWidth;
    }

    public final List<SubDisplayFrame> getSubDisplayFrames() {
        return this.subDisplayFrames;
    }

    public final int getSystemBackgroundColor() {
        return this.systemBackgroundColor;
    }

    public final List<TextBlob> getTextBlobs() {
        return this.textBlobs;
    }

    @Override // com.microsoft.clarity.models.display.IDisplayFrame
    public long getTimestamp() {
        return this.timestamp;
    }

    public final List<Typeface> getTypefaces() {
        return this.typefaces;
    }

    public final List<Vertices> getVertices() {
        return this.vertices;
    }

    public final ViewHierarchy getViewHierarchy() {
        return this.viewHierarchy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = (Float.floatToIntBits(this.density) + ((this.systemBackgroundColor + ((this.keyboardHeight + ((this.screenHeight + ((this.screenWidth + ((getScreenMetadata().hashCode() + ((this.viewHierarchy.hashCode() + (UByte$$ExternalSyntheticBackport0.m(getTimestamp()) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.isForceStartNewSessionFirstFrame;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (floatToIntBits + i) * 31;
        Function1<String, Unit> function1 = this.forceStartNewSessionCallback;
        int hashCode = (i2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        boolean z2 = this.isNewPageFirstFrame;
        return this.subDisplayFrames.hashCode() + ((this.paths.hashCode() + ((this.paints.hashCode() + ((this.vertices.hashCode() + ((this.textBlobs.hashCode() + ((this.images.hashCode() + ((this.typefaces.hashCode() + ((this.commands.hashCode() + ((hashCode + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final boolean isForceStartNewSessionFirstFrame() {
        return this.isForceStartNewSessionFirstFrame;
    }

    public final boolean isNewPageFirstFrame() {
        return this.isNewPageFirstFrame;
    }

    public final void setCommands(List<? extends DisplayCommand> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.commands = list;
    }

    public final void setImages(List<Image> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.images = list;
    }

    public final void setTextBlobs(List<TextBlob> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.textBlobs = list;
    }

    public final void setTypefaces(List<Typeface> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.typefaces = list;
    }

    public String toString() {
        return "DisplayFrame(timestamp=" + getTimestamp() + ", viewHierarchy=" + this.viewHierarchy + ", screenMetadata=" + getScreenMetadata() + ", screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", keyboardHeight=" + this.keyboardHeight + ", systemBackgroundColor=" + this.systemBackgroundColor + ", density=" + this.density + ", isForceStartNewSessionFirstFrame=" + this.isForceStartNewSessionFirstFrame + ", forceStartNewSessionCallback=" + this.forceStartNewSessionCallback + ", isNewPageFirstFrame=" + this.isNewPageFirstFrame + ", commands=" + this.commands + ", typefaces=" + this.typefaces + ", images=" + this.images + ", textBlobs=" + this.textBlobs + ", vertices=" + this.vertices + ", paints=" + this.paints + ", paths=" + this.paths + ", subDisplayFrames=" + this.subDisplayFrames + ')';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoPageEventModel
    public MutationPayload$DisplayFrame toProtobufInstance(long pageTimestamp) {
        C0122k a2 = MutationPayload$DisplayFrame.newBuilder().a(getTimestamp() - pageTimestamp).a(this.viewHierarchy.toProtobufInstance()).a(getScreenMetadata().getName()).a(getScreenMetadata().getActivityHashCode()).c(this.screenHeight).d(this.screenWidth).b(this.keyboardHeight).e(this.systemBackgroundColor).a(this.density);
        List<? extends DisplayCommand> list = this.commands;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((DisplayCommand) it.next()).toProtobufInstance());
        }
        C0122k a3 = a2.a(arrayList);
        List<Typeface> list2 = this.typefaces;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Typeface) it2.next()).toProtobufInstance());
        }
        C0122k b = a3.b(arrayList2);
        List<Image> list3 = this.images;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Image) it3.next()).toProtobufInstance());
        }
        C0122k a4 = b.a((List) arrayList3);
        List<TextBlob> list4 = this.textBlobs;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it4 = list4.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((TextBlob) it4.next()).toProtobufInstance());
        }
        C0122k e = a4.e(arrayList4);
        List<Vertices> list5 = this.vertices;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        Iterator<T> it5 = list5.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((Vertices) it5.next()).toProtobufInstance());
        }
        C0122k f = e.f(arrayList5);
        List<Paint> list6 = this.paints;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
        Iterator<T> it6 = list6.iterator();
        while (it6.hasNext()) {
            arrayList6.add(((Paint) it6.next()).toProtobufInstance());
        }
        C0122k b2 = f.b((List) arrayList6);
        List<Path> list7 = this.paths;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
        Iterator<T> it7 = list7.iterator();
        while (it7.hasNext()) {
            arrayList7.add(((Path) it7.next()).toProtobufInstance());
        }
        C0122k c = b2.c(arrayList7);
        List<SubDisplayFrame> list8 = this.subDisplayFrames;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
        Iterator<T> it8 = list8.iterator();
        while (it8.hasNext()) {
            arrayList8.add(((SubDisplayFrame) it8.next()).toProtobufInstance());
        }
        GeneratedMessageLite build = c.d(arrayList8).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …) })\n            .build()");
        return (MutationPayload$DisplayFrame) build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DisplayFrame(long j, ViewHierarchy viewHierarchy, ScreenMetadata screenMetadata, int i, int i2, int i3, int i4, float f, boolean z, Function1<? super String, Unit> function1, boolean z2, List<? extends DisplayCommand> commands, List<Typeface> typefaces, List<Image> images, List<TextBlob> textBlobs, List<Vertices> vertices, List<Paint> paints, List<Path> paths, List<SubDisplayFrame> subDisplayFrames) {
        Intrinsics.checkNotNullParameter(viewHierarchy, "viewHierarchy");
        Intrinsics.checkNotNullParameter(screenMetadata, "screenMetadata");
        Intrinsics.checkNotNullParameter(commands, "commands");
        Intrinsics.checkNotNullParameter(typefaces, "typefaces");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(textBlobs, "textBlobs");
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(subDisplayFrames, "subDisplayFrames");
        this.timestamp = j;
        this.viewHierarchy = viewHierarchy;
        this.screenMetadata = screenMetadata;
        this.screenWidth = i;
        this.screenHeight = i2;
        this.keyboardHeight = i3;
        this.systemBackgroundColor = i4;
        this.density = f;
        this.isForceStartNewSessionFirstFrame = z;
        this.forceStartNewSessionCallback = function1;
        this.isNewPageFirstFrame = z2;
        this.commands = commands;
        this.typefaces = typefaces;
        this.images = images;
        this.textBlobs = textBlobs;
        this.vertices = vertices;
        this.paints = paints;
        this.paths = paths;
        this.subDisplayFrames = subDisplayFrames;
    }
}
