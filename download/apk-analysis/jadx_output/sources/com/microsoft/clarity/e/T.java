package com.microsoft.clarity.e;

import androidx.media3.common.PlaybackException;
import com.microsoft.clarity.i.C0107a;
import com.microsoft.clarity.models.display.blobs.TextBlobRun;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
public final class T {
    public static final List b = CollectionsKt.listOf((Object[]) new Byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) 0});
    public static final List c = CollectionsKt.listOf((Object[]) new Byte[]{(byte) 79, (byte) 84, (byte) 84, (byte) 79});
    public static final List d = CollectionsKt.listOf((Object[]) new Byte[]{(byte) 116, (byte) 116, (byte) 99, (byte) 102});
    public static final List e;
    public static final Set f;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f75a = new LinkedHashMap();

    static {
        List listOf = CollectionsKt.listOf((Object[]) new IntRange[]{new IntRange(48, 57), new IntRange(1632, 1641), new IntRange(1776, 1785), new IntRange(1984, 1993), new IntRange(2406, 2415), new IntRange(2534, 2543), new IntRange(2662, 2671), new IntRange(2790, 2799), new IntRange(2918, 2927), new IntRange(3046, 3055), new IntRange(3174, 3183), new IntRange(3302, 3311), new IntRange(3430, 3439), new IntRange(3558, 3567), new IntRange(3664, 3673), new IntRange(3792, 3801), new IntRange(3872, 3881), new IntRange(4160, 4169), new IntRange(4240, 4249), new IntRange(6112, 6121), new IntRange(6160, 6169), new IntRange(6470, 6479), new IntRange(6608, 6617), new IntRange(6784, 6793), new IntRange(6800, 6809), new IntRange(6992, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED), new IntRange(7088, 7097), new IntRange(7232, 7241), new IntRange(7248, 7257), new IntRange(42528, 42537), new IntRange(43216, 43225), new IntRange(43264, 43273), new IntRange(43472, 43481), new IntRange(43504, 43513), new IntRange(43600, 43609), new IntRange(44016, 44025), new IntRange(65296, 65305), new IntRange(66720, 66729), new IntRange(68912, 68921), new IntRange(69734, 69743), new IntRange(69872, 69881), new IntRange(69942, 69951), new IntRange(70096, 70105), new IntRange(70384, 70393), new IntRange(70736, 70745), new IntRange(70864, 70873), new IntRange(71248, 71257), new IntRange(71360, 71369), new IntRange(71472, 71481), new IntRange(71904, 71913), new IntRange(72016, 72025), new IntRange(72784, 72793), new IntRange(73040, 73049), new IntRange(73120, 73129), new IntRange(73552, 73561), new IntRange(92768, 92777), new IntRange(92864, 92873), new IntRange(93008, 93017), new IntRange(120782, 120791), new IntRange(120792, 120801), new IntRange(120802, 120811), new IntRange(120812, 120821), new IntRange(120822, 120831), new IntRange(123200, 123209), new IntRange(123632, 123641), new IntRange(124144, 124153), new IntRange(125264, 125273), new IntRange(130032, 130041)});
        e = listOf;
        f = CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends int>) CollectionsKt.plus((Collection<? extends int>) CollectionsKt.plus((Collection<? extends int>) CollectionsKt.flatten(listOf), 32), 64), 8226));
    }

    public static final void a(Set set, Set set2, Set set3, Ref.LongRef longRef, com.microsoft.clarity.d.c cVar) {
        com.microsoft.clarity.d.b[] bVarArr = cVar.f;
        Intrinsics.checkNotNullExpressionValue(bVarArr, "cmap.cmaps");
        ArrayList arrayList = new ArrayList();
        for (com.microsoft.clarity.d.b bVar : bVarArr) {
            int i = bVar.f51a;
            if (i == 0 || i == 3) {
                arrayList.add(bVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.microsoft.clarity.d.b bVar2 = (com.microsoft.clarity.d.b) it.next();
            for (IntRange intRange : e) {
                int first = intRange.getFirst();
                int last = intRange.getLast();
                if (first <= last) {
                    while (true) {
                        set.add(Long.valueOf(((Integer) bVar2.c.get(Integer.valueOf(first))) == null ? 0 : r5.intValue()));
                        if (first != last) {
                            first++;
                        }
                    }
                }
            }
            set2.add(Long.valueOf(((Integer) bVar2.c.get(32)) == null ? 0 : r1.intValue()));
            set3.add(Long.valueOf(((Integer) bVar2.c.get(64)) == null ? 0 : r1.intValue()));
            if (longRef.element == 0) {
                longRef.element = ((Integer) bVar2.c.get(8226)) == null ? 0 : r0.intValue();
            }
        }
    }

    public final S b(Typeface typeface) {
        String dataHash = typeface.getDataHash();
        Intrinsics.checkNotNull(dataHash);
        if (!this.f75a.containsKey(dataHash)) {
            if (typeface.getData() == null) {
                throw new IllegalArgumentException("Provided typeface data is null!");
            }
            this.f75a.put(dataHash, a(typeface));
        }
        Object obj = this.f75a.get(dataHash);
        Intrinsics.checkNotNull(obj);
        return (S) obj;
    }

    public static final void a(T t, TextBlobRun textBlobRun, S s, int i, int i2) {
        t.getClass();
        IntProgression fromClosedRange = IntProgression.INSTANCE.fromClosedRange(i, i2, i > i2 ? -1 : 1);
        int first = fromClosedRange.getFirst();
        int last = fromClosedRange.getLast();
        int step = fromClosedRange.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            if (first >= 0) {
                List<Long> glyphs = textBlobRun.getGlyphs();
                Intrinsics.checkNotNull(glyphs);
                if (first < glyphs.size()) {
                    List<Long> glyphs2 = textBlobRun.getGlyphs();
                    Intrinsics.checkNotNull(glyphs2);
                    if (s.b.contains(Long.valueOf(glyphs2.get(first).longValue()))) {
                        return;
                    }
                    List<Long> glyphs3 = textBlobRun.getGlyphs();
                    Intrinsics.checkNotNull(glyphs3);
                    glyphs3.set(first, Long.valueOf(s.d));
                }
            }
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    public final S a(Typeface typeface) {
        int i;
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        final LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        final LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        final Ref.LongRef longRef = new Ref.LongRef();
        C0107a data = typeface.getData();
        Intrinsics.checkNotNull(data);
        byte[] bArr = data.f169a;
        int i2 = data.b;
        List<Byte> list = ArraysKt.toList(ArraysKt.copyOfRange(bArr, i2, i2 + 4));
        if (a(list, b)) {
            i = 1;
        } else if (a(list, c)) {
            i = 2;
        } else {
            if (!a(list, d)) {
                StringBuilder sb = new StringBuilder("Cannot parse this typeface file with header ");
                String arrays = Arrays.toString(CollectionsKt.toByteArray(list));
                Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                sb.append(arrays);
                sb.append('!');
                throw new UnsupportedOperationException(sb.toString());
            }
            i = 3;
        }
        int a2 = AbstractC0082z.a(i);
        if (a2 == 0 || a2 == 1) {
            com.microsoft.clarity.d.c cVar = (com.microsoft.clarity.d.c) com.microsoft.clarity.d.h.a(new com.microsoft.clarity.d.e(typeface.getData()), f).a("cmap");
            Intrinsics.checkNotNullExpressionValue(cVar, "ttfParser.parse(typeface…edCharacterUnicodes).cmap");
            a(linkedHashSet, linkedHashSet2, linkedHashSet3, longRef, cVar);
        } else if (a2 == 2) {
            com.microsoft.clarity.d.k kVar = new com.microsoft.clarity.d.k(typeface.getData(), f);
            com.microsoft.clarity.d.j jVar = new com.microsoft.clarity.d.j() { // from class: com.microsoft.clarity.e.T$$ExternalSyntheticLambda0
                @Override // com.microsoft.clarity.d.j
                public final void a(com.microsoft.clarity.d.l lVar) {
                    T.a(linkedHashSet, linkedHashSet2, linkedHashSet3, longRef, lVar);
                }
            };
            for (int i3 = 0; i3 < kVar.b; i3++) {
                kVar.f55a.a(kVar.c[i3]);
                jVar.a(com.microsoft.clarity.d.h.a(new com.microsoft.clarity.d.f(kVar.f55a), kVar.d));
            }
        }
        linkedHashSet.remove(0L);
        return new S(linkedHashSet, linkedHashSet2, linkedHashSet3, longRef.element);
    }

    public static final void a(Set digitGlyphIds, Set spaceGlyphIds, Set atSignGlyphIds, Ref.LongRef piiPlaceholderGlyphId, com.microsoft.clarity.d.l lVar) {
        Intrinsics.checkNotNullParameter(digitGlyphIds, "$digitGlyphIds");
        Intrinsics.checkNotNullParameter(spaceGlyphIds, "$spaceGlyphIds");
        Intrinsics.checkNotNullParameter(atSignGlyphIds, "$atSignGlyphIds");
        Intrinsics.checkNotNullParameter(piiPlaceholderGlyphId, "$piiPlaceholderGlyphId");
        com.microsoft.clarity.d.c cVar = (com.microsoft.clarity.d.c) lVar.a("cmap");
        Intrinsics.checkNotNullExpressionValue(cVar, "it.cmap");
        a(digitGlyphIds, spaceGlyphIds, atSignGlyphIds, piiPlaceholderGlyphId, cVar);
    }

    public static boolean a(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!Intrinsics.areEqual(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
