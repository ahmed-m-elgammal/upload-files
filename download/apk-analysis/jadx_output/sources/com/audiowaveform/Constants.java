package com.audiowaveform;

import kotlin.Metadata;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/audiowaveform/Constants;", "", "()V", "LOG_TAG", "", "aac_adts", "", "aac_eld", "acc", "amr_nb", "amr_wb", Constants.bitRate, Constants.currentDecibel, Constants.currentDuration, Constants.durationType, "fileNameFormat", Constants.finishMode, Constants.finishType, "he_aac", "mpeg4", "mpeg_2_ts", Constants.noOfSamples, "ogg", Constants.onCurrentExtractedWaveformData, Constants.onCurrentRecordingWaveformData, "opus", "path", Constants.playerKey, "progress", Constants.sampleRate, Constants.speed, "three_gpp", Constants.updateFrequency, Constants.volume, "vorbis", Constants.waveformData, "webm", "simform_solutions_react-native-audio-waveform_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Constants {
    public static final Constants INSTANCE = new Constants();
    public static final String LOG_TAG = "AudioWaveforms";
    public static final int aac_adts = 8;
    public static final int aac_eld = 2;
    public static final int acc = 1;
    public static final int amr_nb = 4;
    public static final int amr_wb = 5;
    public static final String bitRate = "bitRate";
    public static final String currentDecibel = "currentDecibel";
    public static final String currentDuration = "currentDuration";
    public static final String durationType = "durationType";
    public static final String fileNameFormat = "dd-MM-yy-hh-mm-ss";
    public static final String finishMode = "finishMode";
    public static final String finishType = "finishType";
    public static final int he_aac = 3;
    public static final int mpeg4 = 1;
    public static final int mpeg_2_ts = 7;
    public static final String noOfSamples = "noOfSamples";
    public static final int ogg = 3;
    public static final String onCurrentExtractedWaveformData = "onCurrentExtractedWaveformData";
    public static final String onCurrentRecordingWaveformData = "onCurrentRecordingWaveformData";
    public static final int opus = 6;
    public static final String path = "path";
    public static final String playerKey = "playerKey";
    public static final String progress = "progress";
    public static final String sampleRate = "sampleRate";
    public static final String speed = "speed";
    public static final int three_gpp = 2;
    public static final String updateFrequency = "updateFrequency";
    public static final String volume = "volume";
    public static final int vorbis = 7;
    public static final String waveformData = "waveformData";
    public static final int webm = 6;

    private Constants() {
    }
}
