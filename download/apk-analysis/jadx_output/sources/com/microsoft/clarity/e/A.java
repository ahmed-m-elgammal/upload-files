package com.microsoft.clarity.e;

import com.microsoft.clarity.models.ICopyable;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.blobs.TextBlobRun;
import com.microsoft.clarity.models.display.commands.DisplayCommand;
import com.microsoft.clarity.models.display.commands.DrawImageBase;
import com.microsoft.clarity.models.display.commands.DrawPath;
import com.microsoft.clarity.models.display.commands.DrawTextBlob;
import com.microsoft.clarity.models.display.commands.DrawVertices;
import com.microsoft.clarity.models.display.commands.DrawViewContentEndAnnotation;
import com.microsoft.clarity.models.display.commands.DrawViewContentStartAnnotation;
import com.microsoft.clarity.models.display.commands.FillViewContentCommandsAnnotation;
import com.microsoft.clarity.models.display.commands.PaintableCommand;
import com.microsoft.clarity.models.display.commands.Restore;
import com.microsoft.clarity.models.display.commands.Save;
import com.microsoft.clarity.models.display.commands.SetMatrix;
import com.microsoft.clarity.models.display.commands.SetMatrix44;
import com.microsoft.clarity.models.display.common.Vertices;
import com.microsoft.clarity.models.display.images.Image;
import com.microsoft.clarity.models.display.paints.Paint;
import com.microsoft.clarity.models.display.paints.shaders.ImageShader;
import com.microsoft.clarity.models.display.paints.shaders.LocalMatrixShader;
import com.microsoft.clarity.models.display.paths.Path;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final Object f57a = new Object();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final LinkedHashMap d = new LinkedHashMap();
    public final LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final LinkedHashMap g = new LinkedHashMap();
    public final LinkedHashMap h = new LinkedHashMap();

    public final void a(DisplayFrame frame, boolean z) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        synchronized (this.f57a) {
            if (z) {
                try {
                    this.b.clear();
                    this.c.clear();
                    this.d.clear();
                    this.e.clear();
                    this.f.clear();
                    this.g.clear();
                    this.h.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            ArrayList arrayList = new ArrayList();
            int size = frame.getCommands().size();
            Integer num = null;
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                DisplayCommand displayCommand = frame.getCommands().get(i2);
                if (displayCommand instanceof DrawViewContentStartAnnotation) {
                    int id = ((DrawViewContentStartAnnotation) displayCommand).getId();
                    num = Integer.valueOf(id);
                    a(id);
                    this.b.put(num, new ArrayList());
                    i = 0;
                } else {
                    if (displayCommand instanceof DrawViewContentEndAnnotation) {
                        Intrinsics.checkNotNull(num);
                        num.getClass();
                        if (i != 0) {
                            for (int i3 = 0; i3 < i; i3++) {
                                Object obj = this.b.get(num);
                                Intrinsics.checkNotNull(obj);
                                ((List) obj).add(new Restore());
                            }
                        }
                        num = null;
                    } else if (displayCommand instanceof FillViewContentCommandsAnnotation) {
                        a(((FillViewContentCommandsAnnotation) displayCommand).getId(), frame, arrayList);
                    } else if (num == null || (!(displayCommand instanceof SetMatrix) && !(displayCommand instanceof SetMatrix44))) {
                        arrayList.add(displayCommand);
                    }
                    if (num != null) {
                        if (displayCommand instanceof Save) {
                            i++;
                        } else if (displayCommand instanceof Restore) {
                            i--;
                        }
                        a(num.intValue(), displayCommand, frame);
                    }
                }
            }
            frame.setCommands(arrayList);
            Iterator<T> it = frame.getViewHierarchy().getStaleRenderNodeIds().iterator();
            while (it.hasNext()) {
                a((int) ((Number) it.next()).longValue());
            }
            frame.getScreenMetadata().getActivityHashCode();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(int i, DisplayFrame displayFrame, ArrayList arrayList) {
        Image image;
        List list = (List) this.b.get(Integer.valueOf(i));
        if (list == null) {
            com.microsoft.clarity.m.h.c("Trying to fetch missing view commands from the cache " + i + '.');
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DisplayCommand copy2 = ((DisplayCommand) it.next()).copy2();
            if (copy2 instanceof PaintableCommand) {
                PaintableCommand paintableCommand = (PaintableCommand) copy2;
                Paint paint = (Paint) this.g.get(Integer.valueOf(paintableCommand.getPaintIndex()));
                if (paint != null) {
                    paintableCommand.setPaintIndex(a((ICopyable) paint, (List) displayFrame.getPaints(), false));
                    ImageShader a2 = a(displayFrame.getPaints().get(paintableCommand.getPaintIndex()));
                    if ((a2 != null ? a2.getImageIndex() : null) != null) {
                        LinkedHashMap linkedHashMap = this.d;
                        Integer imageIndex = a2.getImageIndex();
                        Intrinsics.checkNotNull(imageIndex);
                        Image image2 = (Image) linkedHashMap.get(imageIndex);
                        if (image2 != null) {
                            a2.setImageIndex(Integer.valueOf(a((ICopyable) image2, (List) displayFrame.getImages(), true)));
                        }
                    }
                }
            }
            if (copy2 instanceof DrawPath) {
                DrawPath drawPath = (DrawPath) copy2;
                Path path = (Path) this.h.get(Integer.valueOf(drawPath.getPathIndex()));
                if (path != null) {
                    drawPath.setPathIndex(a((ICopyable) path, (List) displayFrame.getPaths(), false));
                }
            } else if (copy2 instanceof DrawImageBase) {
                DrawImageBase drawImageBase = (DrawImageBase) copy2;
                Integer imageIndex2 = drawImageBase.getImageIndex();
                if (imageIndex2 != null && (image = (Image) this.d.get(imageIndex2)) != null) {
                    drawImageBase.setImageIndex(Integer.valueOf(a((ICopyable) image, (List) displayFrame.getImages(), true)));
                }
            } else if (copy2 instanceof DrawTextBlob) {
                DrawTextBlob drawTextBlob = (DrawTextBlob) copy2;
                TextBlob textBlob = (TextBlob) this.e.get(Integer.valueOf(drawTextBlob.getBlobIndex()));
                if (textBlob != null) {
                    drawTextBlob.setBlobIndex(a((ICopyable) textBlob, (List) displayFrame.getTextBlobs(), false));
                    List<TextBlobRun> runs = displayFrame.getTextBlobs().get(drawTextBlob.getBlobIndex()).getRuns();
                    if (runs != null) {
                        for (TextBlobRun textBlobRun : runs) {
                            if (textBlobRun.getTypefaceIndex() != null) {
                                LinkedHashMap linkedHashMap2 = this.c;
                                Integer typefaceIndex = textBlobRun.getTypefaceIndex();
                                Intrinsics.checkNotNull(typefaceIndex);
                                Typeface typeface = (Typeface) linkedHashMap2.get(typefaceIndex);
                                if (typeface != null) {
                                    textBlobRun.setTypefaceIndex(Integer.valueOf(a((ICopyable) typeface, (List) displayFrame.getTypefaces(), true)));
                                }
                            }
                        }
                    }
                }
            } else if (copy2 instanceof DrawVertices) {
                DrawVertices drawVertices = (DrawVertices) copy2;
                Vertices vertices = (Vertices) this.f.get(Integer.valueOf(drawVertices.getVerticesIndex()));
                if (vertices != null) {
                    drawVertices.setVerticesIndex(a((ICopyable) vertices, (List) displayFrame.getVertices(), false));
                }
            }
            arrayList.add(copy2);
        }
    }

    public final void a(int i, DisplayCommand displayCommand, DisplayFrame displayFrame) {
        List<TextBlobRun> runs;
        int intValue;
        DisplayCommand copy2 = displayCommand.copy2();
        if (copy2 instanceof PaintableCommand) {
            PaintableCommand paintableCommand = (PaintableCommand) copy2;
            if (paintableCommand.getPaintIndex() >= 0) {
                paintableCommand.setPaintIndex(a((ICopyable) displayFrame.getPaints().get(paintableCommand.getPaintIndex()), (Map) this.g, false));
                Object obj = this.g.get(Integer.valueOf(paintableCommand.getPaintIndex()));
                Intrinsics.checkNotNull(obj);
                ImageShader a2 = a((Paint) obj);
                if ((a2 != null ? a2.getImageIndex() : null) != null) {
                    Integer imageIndex = a2.getImageIndex();
                    Intrinsics.checkNotNull(imageIndex);
                    if (imageIndex.intValue() >= 0) {
                        List<Image> images = displayFrame.getImages();
                        Integer imageIndex2 = a2.getImageIndex();
                        Intrinsics.checkNotNull(imageIndex2);
                        a2.setImageIndex(Integer.valueOf(a((ICopyable) images.get(imageIndex2.intValue()), (Map) this.d, true)));
                    }
                }
            }
        }
        if (copy2 instanceof DrawPath) {
            DrawPath drawPath = (DrawPath) copy2;
            if (drawPath.getPathIndex() >= 0) {
                drawPath.setPathIndex(a((ICopyable) displayFrame.getPaths().get(drawPath.getPathIndex()), (Map) this.h, false));
            }
        } else if (copy2 instanceof DrawImageBase) {
            DrawImageBase drawImageBase = (DrawImageBase) copy2;
            Integer imageIndex3 = drawImageBase.getImageIndex();
            if (imageIndex3 != null && (intValue = imageIndex3.intValue()) >= 0) {
                drawImageBase.setImageIndex(Integer.valueOf(a((ICopyable) displayFrame.getImages().get(intValue), (Map) this.d, true)));
            }
        } else if (copy2 instanceof DrawTextBlob) {
            DrawTextBlob drawTextBlob = (DrawTextBlob) copy2;
            if (drawTextBlob.getBlobIndex() >= 0) {
                drawTextBlob.setBlobIndex(a((ICopyable) displayFrame.getTextBlobs().get(drawTextBlob.getBlobIndex()), (Map) this.e, false));
                TextBlob textBlob = (TextBlob) this.e.get(Integer.valueOf(drawTextBlob.getBlobIndex()));
                if (textBlob != null && (runs = textBlob.getRuns()) != null) {
                    for (TextBlobRun textBlobRun : runs) {
                        if (textBlobRun.getTypefaceIndex() != null) {
                            IntRange indices = CollectionsKt.getIndices(displayFrame.getTypefaces());
                            Integer typefaceIndex = textBlobRun.getTypefaceIndex();
                            if (typefaceIndex != null && indices.contains(typefaceIndex.intValue())) {
                                Integer typefaceIndex2 = textBlobRun.getTypefaceIndex();
                                Intrinsics.checkNotNull(typefaceIndex2);
                                if (typefaceIndex2.intValue() >= 0) {
                                    List<Typeface> typefaces = displayFrame.getTypefaces();
                                    Integer typefaceIndex3 = textBlobRun.getTypefaceIndex();
                                    Intrinsics.checkNotNull(typefaceIndex3);
                                    textBlobRun.setTypefaceIndex(Integer.valueOf(a((ICopyable) typefaces.get(typefaceIndex3.intValue()), (Map) this.c, true)));
                                }
                            }
                        }
                    }
                }
            }
        } else if (copy2 instanceof DrawVertices) {
            DrawVertices drawVertices = (DrawVertices) copy2;
            if (drawVertices.getVerticesIndex() >= 0) {
                drawVertices.setVerticesIndex(a((ICopyable) displayFrame.getVertices().get(drawVertices.getVerticesIndex()), (Map) this.f, false));
            }
        }
        Object obj2 = this.b.get(Integer.valueOf(i));
        Intrinsics.checkNotNull(obj2);
        ((List) obj2).add(copy2);
    }

    public static int a(ICopyable iCopyable, Map map, boolean z) {
        Integer num;
        Iterator it = map.keySet().iterator();
        if (it.hasNext()) {
            Integer valueOf = Integer.valueOf(((Number) it.next()).intValue());
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(((Number) it.next()).intValue());
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        } else {
            num = null;
        }
        int intValue = (num != null ? num.intValue() : 0) + 1;
        map.put(Integer.valueOf(intValue), (ICopyable) (!z ? iCopyable.copy2() : iCopyable.copyWithNullData()));
        return intValue;
    }

    public static int a(ICopyable iCopyable, List list, boolean z) {
        list.add((ICopyable) (!z ? iCopyable.copy2() : iCopyable.copyWithNullData()));
        return CollectionsKt.getLastIndex(list);
    }

    public static ImageShader a(Paint paint) {
        if (paint.getShader() instanceof ImageShader) {
            return (ImageShader) paint.getShader();
        }
        if ((paint.getShader() instanceof LocalMatrixShader) && (((LocalMatrixShader) paint.getShader()).getShader() instanceof ImageShader)) {
            return (ImageShader) ((LocalMatrixShader) paint.getShader()).getShader();
        }
        return null;
    }

    public final void a(int i) {
        List<DisplayCommand> list = (List) this.b.get(Integer.valueOf(i));
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        for (DisplayCommand displayCommand : list) {
            if (displayCommand instanceof PaintableCommand) {
                PaintableCommand paintableCommand = (PaintableCommand) displayCommand;
                Paint paint = (Paint) this.g.get(Integer.valueOf(paintableCommand.getPaintIndex()));
                if (paint != null) {
                    ImageShader a2 = a(paint);
                    if ((a2 != null ? a2.getImageIndex() : null) != null) {
                        LinkedHashMap linkedHashMap = this.d;
                        Integer imageIndex = a2.getImageIndex();
                        Intrinsics.checkNotNull(imageIndex);
                        linkedHashMap.remove(imageIndex);
                    }
                }
            }
            if (displayCommand instanceof DrawPath) {
                this.h.remove(Integer.valueOf(((DrawPath) displayCommand).getPathIndex()));
            } else if (displayCommand instanceof DrawImageBase) {
                Integer imageIndex2 = ((DrawImageBase) displayCommand).getImageIndex();
                if (imageIndex2 != null) {
                }
            } else if (displayCommand instanceof DrawTextBlob) {
                DrawTextBlob drawTextBlob = (DrawTextBlob) displayCommand;
                TextBlob textBlob = (TextBlob) this.e.get(Integer.valueOf(drawTextBlob.getBlobIndex()));
                if (textBlob != null) {
                    if (textBlob.getRuns() != null) {
                        for (TextBlobRun textBlobRun : textBlob.getRuns()) {
                            if (textBlobRun.getTypefaceIndex() != null) {
                                LinkedHashMap linkedHashMap2 = this.c;
                                Integer typefaceIndex = textBlobRun.getTypefaceIndex();
                                Intrinsics.checkNotNull(typefaceIndex);
                                linkedHashMap2.remove(typefaceIndex);
                            }
                        }
                    }
                    this.e.remove(Integer.valueOf(drawTextBlob.getBlobIndex()));
                }
            } else if (displayCommand instanceof DrawVertices) {
                this.f.remove(Integer.valueOf(((DrawVertices) displayCommand).getVerticesIndex()));
            }
        }
        this.b.remove(Integer.valueOf(i));
    }
}
