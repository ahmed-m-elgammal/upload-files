package net.time4j.calendar.bahai;

import androidx.media3.exoplayer.upstream.CmcdData;

/* loaded from: classes7.dex */
public enum FormattedContent {
    TRANSCRIPTION { // from class: net.time4j.calendar.bahai.FormattedContent.1
        @Override // net.time4j.calendar.bahai.FormattedContent
        String variant() {
            return "t";
        }
    },
    MEANING { // from class: net.time4j.calendar.bahai.FormattedContent.2
        @Override // net.time4j.calendar.bahai.FormattedContent
        String variant() {
            return "m";
        }
    },
    HTML { // from class: net.time4j.calendar.bahai.FormattedContent.3
        @Override // net.time4j.calendar.bahai.FormattedContent
        String variant() {
            return CmcdData.Factory.STREAMING_FORMAT_HLS;
        }
    };

    abstract String variant();
}
