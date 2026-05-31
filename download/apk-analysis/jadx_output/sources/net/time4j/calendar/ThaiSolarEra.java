package net.time4j.calendar;

import java.util.Locale;
import net.time4j.PlainDate;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.EpochDays;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

/* loaded from: classes6.dex */
public enum ThaiSolarEra implements CalendarEra {
    RATTANAKOSIN,
    BUDDHIST;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("buddhist", locale).getEras(textWidth).print(this);
    }

    public int getYear(CalendarDate calendarDate) {
        int i;
        PlainDate of = PlainDate.of(calendarDate.getDaysSinceEpochUTC(), EpochDays.UTC);
        if (this == RATTANAKOSIN) {
            int year = of.getYear();
            i = year - 1781;
            if (of.getMonth() < 4) {
                i = year - 1782;
            }
        } else {
            int year2 = of.getYear();
            i = year2 + 543;
            if (i < 2484 && of.getMonth() < 4) {
                i = year2 + 542;
            }
        }
        if (i >= 1) {
            return i;
        }
        throw new IllegalArgumentException("Out of range: " + calendarDate);
    }

    int toIsoYear(int i, int i2) {
        if (i < 1) {
            throw new IllegalArgumentException("Out of bounds: " + i);
        }
        if (this == RATTANAKOSIN) {
            int safeAdd = MathUtils.safeAdd(i, 1781);
            return i2 < 4 ? MathUtils.safeAdd(safeAdd, 1) : safeAdd;
        }
        int safeSubtract = MathUtils.safeSubtract(i, 543);
        if (i2 >= 4) {
            return safeSubtract;
        }
        if (safeSubtract != 1940) {
            return safeSubtract < 1940 ? MathUtils.safeAdd(safeSubtract, 1) : safeSubtract;
        }
        throw new IllegalArgumentException("Buddhist year 2483 does not know month: " + i2);
    }
}
