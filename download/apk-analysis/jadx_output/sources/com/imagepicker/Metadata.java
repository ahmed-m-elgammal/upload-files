package com.imagepicker;

import android.util.Log;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes5.dex */
abstract class Metadata {
    protected String datetime;
    protected int height;
    protected int width;

    public abstract String getDateTime();

    public abstract int getHeight();

    public abstract int getWidth();

    Metadata() {
    }

    protected String getDateTimeInUTC(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat(str2, Locale.US).parse(str);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(StdDateFormat.DATE_FORMAT_STR_ISO8601, Locale.US);
            if (parse != null) {
                return simpleDateFormat.format(parse);
            }
            return null;
        } catch (Exception e) {
            Log.e("RNIP", "Could not parse image datetime to UTC: " + e.getMessage());
            return null;
        }
    }
}
