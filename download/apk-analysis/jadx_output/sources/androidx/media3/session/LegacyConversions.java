package androidx.media3.session;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.HeartRating;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PercentageRating;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.StarRating;
import androidx.media3.common.ThumbRating;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.CommandButton;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.SessionCommands;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
class LegacyConversions {
    private static final String TAG = "LegacyConversions";
    public static final MediaBrowserServiceCompat.BrowserRoot defaultBrowserRoot = new MediaBrowserServiceCompat.BrowserRoot(MediaLibraryService.SERVICE_INTERFACE, null);
    public static final ImmutableSet<String> KNOWN_METADATA_COMPAT_KEYS = ImmutableSet.of(MediaMetadataCompat.METADATA_KEY_TITLE, MediaMetadataCompat.METADATA_KEY_ARTIST, MediaMetadataCompat.METADATA_KEY_DURATION, MediaMetadataCompat.METADATA_KEY_ALBUM, MediaMetadataCompat.METADATA_KEY_AUTHOR, MediaMetadataCompat.METADATA_KEY_WRITER, MediaMetadataCompat.METADATA_KEY_COMPOSER, MediaMetadataCompat.METADATA_KEY_COMPILATION, MediaMetadataCompat.METADATA_KEY_DATE, MediaMetadataCompat.METADATA_KEY_YEAR, MediaMetadataCompat.METADATA_KEY_GENRE, MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER, MediaMetadataCompat.METADATA_KEY_NUM_TRACKS, MediaMetadataCompat.METADATA_KEY_DISC_NUMBER, MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, MediaMetadataCompat.METADATA_KEY_ART, MediaMetadataCompat.METADATA_KEY_ART_URI, MediaMetadataCompat.METADATA_KEY_ALBUM_ART, MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, MediaMetadataCompat.METADATA_KEY_USER_RATING, MediaMetadataCompat.METADATA_KEY_RATING, MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION, MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, MediaMetadataCompat.METADATA_KEY_MEDIA_ID, MediaMetadataCompat.METADATA_KEY_MEDIA_URI, MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE, "android.media.metadata.ADVERTISEMENT", MediaMetadataCompat.METADATA_KEY_DOWNLOAD_STATUS, MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT);

    private static int convertToFolderType(long j) {
        if (j == 0) {
            return 0;
        }
        if (j == 1) {
            return 1;
        }
        if (j == 2) {
            return 2;
        }
        if (j == 3) {
            return 3;
        }
        if (j == 4) {
            return 4;
        }
        if (j == 5) {
            return 5;
        }
        return j == 6 ? 6 : 0;
    }

    public static int convertToPlaybackStateCompatShuffleMode(boolean z) {
        return z ? 1 : 0;
    }

    public static long convertToQueueItemId(int i) {
        if (i == -1) {
            return -1L;
        }
        return i;
    }

    private static boolean hasAction(long j, long j2) {
        return (j & j2) != 0;
    }

    public static class ConversionException extends Exception {
        private ConversionException(String str) {
            super(str);
        }

        private ConversionException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static PlaybackException convertToPlaybackException(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null || playbackStateCompat.getState() != 7) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(playbackStateCompat.getErrorMessage())) {
            sb.append(playbackStateCompat.getErrorMessage().toString());
            sb.append(", ");
        }
        sb.append("code=");
        sb.append(playbackStateCompat.getErrorCode());
        return new PlaybackException(sb.toString(), null, 1001);
    }

    public static MediaBrowserCompat.MediaItem convertToBrowserItem(MediaItem mediaItem, Bitmap bitmap) {
        MediaDescriptionCompat convertToMediaDescriptionCompat = convertToMediaDescriptionCompat(mediaItem, bitmap);
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        int i = (mediaMetadata.isBrowsable == null || !mediaMetadata.isBrowsable.booleanValue()) ? 0 : 1;
        if (mediaMetadata.isPlayable != null && mediaMetadata.isPlayable.booleanValue()) {
            i |= 2;
        }
        return new MediaBrowserCompat.MediaItem(convertToMediaDescriptionCompat, i);
    }

    public static MediaItem convertToMediaItem(MediaBrowserCompat.MediaItem mediaItem) {
        return convertToMediaItem(mediaItem.getDescription(), mediaItem.isBrowsable(), mediaItem.isPlayable());
    }

    public static MediaItem convertToMediaItem(MediaSessionCompat.QueueItem queueItem) {
        return convertToMediaItem(queueItem.getDescription());
    }

    public static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Assertions.checkNotNull(mediaDescriptionCompat);
        return convertToMediaItem(mediaDescriptionCompat, false, true);
    }

    public static MediaItem convertToMediaItem(MediaMetadataCompat mediaMetadataCompat, int i) {
        return convertToMediaItem(mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID), mediaMetadataCompat, i);
    }

    public static MediaItem convertToMediaItem(String str, MediaMetadataCompat mediaMetadataCompat, int i) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str != null) {
            builder.setMediaId(str);
        }
        String string = mediaMetadataCompat.getString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI);
        if (string != null) {
            builder.setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(Uri.parse(string)).build());
        }
        builder.setMediaMetadata(convertToMediaMetadata(mediaMetadataCompat, i));
        return builder.build();
    }

    private static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat, boolean z, boolean z2) {
        String mediaId = mediaDescriptionCompat.getMediaId();
        MediaItem.Builder builder = new MediaItem.Builder();
        if (mediaId == null) {
            mediaId = "";
        }
        return builder.setMediaId(mediaId).setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(mediaDescriptionCompat.getMediaUri()).build()).setMediaMetadata(convertToMediaMetadata(mediaDescriptionCompat, 0, z, z2)).build();
    }

    public static ImmutableList<MediaItem> convertBrowserItemListToMediaItemList(List<MediaBrowserCompat.MediaItem> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add((ImmutableList.Builder) convertToMediaItem(list.get(i)));
        }
        return builder.build();
    }

    public static List<MediaItem> convertToMediaItemList(Timeline timeline) {
        ArrayList arrayList = new ArrayList();
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < timeline.getWindowCount(); i++) {
            arrayList.add(timeline.getWindow(i, window).mediaItem);
        }
        return arrayList;
    }

    public static MediaSessionCompat.QueueItem convertToQueueItem(MediaItem mediaItem, int i, Bitmap bitmap) {
        return new MediaSessionCompat.QueueItem(convertToMediaDescriptionCompat(mediaItem, bitmap), convertToQueueItemId(i));
    }

    public static Timeline.Window convertToWindow(MediaItem mediaItem, int i) {
        Timeline.Window window = new Timeline.Window();
        window.set(0, mediaItem, null, 0L, 0L, 0L, true, false, null, 0L, -9223372036854775807L, i, i, 0L);
        return window;
    }

    public static Timeline.Period convertToPeriod(int i) {
        Timeline.Period period = new Timeline.Period();
        period.set(null, null, i, -9223372036854775807L, 0L, AdPlaybackState.NONE, true);
        return period;
    }

    public static MediaDescriptionCompat convertToMediaDescriptionCompat(MediaItem mediaItem, Bitmap bitmap) {
        MediaDescriptionCompat.Builder mediaId = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.mediaId.equals("") ? null : mediaItem.mediaId);
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        if (bitmap != null) {
            mediaId.setIconBitmap(bitmap);
        }
        Bundle bundle = mediaMetadata.extras;
        boolean z = (mediaMetadata.folderType == null || mediaMetadata.folderType.intValue() == -1) ? false : true;
        boolean z2 = mediaMetadata.mediaType != null;
        if (z || z2) {
            if (bundle == null) {
                bundle = new Bundle();
            } else {
                bundle = new Bundle(bundle);
            }
            if (z) {
                bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, convertToExtraBtFolderType(((Integer) Assertions.checkNotNull(mediaMetadata.folderType)).intValue()));
            }
            if (z2) {
                bundle.putLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT, ((Integer) Assertions.checkNotNull(mediaMetadata.mediaType)).intValue());
            }
        }
        return mediaId.setTitle(mediaMetadata.title).setSubtitle(mediaMetadata.artist != null ? mediaMetadata.artist : mediaMetadata.subtitle).setDescription(mediaMetadata.description).setIconUri(mediaMetadata.artworkUri).setMediaUri(mediaItem.requestMetadata.mediaUri).setExtras(bundle).build();
    }

    public static MediaMetadata convertToMediaMetadata(CharSequence charSequence) {
        if (charSequence == null) {
            return MediaMetadata.EMPTY;
        }
        return new MediaMetadata.Builder().setTitle(charSequence).build();
    }

    public static MediaMetadata convertToMediaMetadata(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        return convertToMediaMetadata(mediaDescriptionCompat, i, false, true);
    }

    private static MediaMetadata convertToMediaMetadata(MediaDescriptionCompat mediaDescriptionCompat, int i, boolean z, boolean z2) {
        byte[] bArr;
        if (mediaDescriptionCompat == null) {
            return MediaMetadata.EMPTY;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.setTitle(mediaDescriptionCompat.getTitle()).setSubtitle(mediaDescriptionCompat.getSubtitle()).setDescription(mediaDescriptionCompat.getDescription()).setArtworkUri(mediaDescriptionCompat.getIconUri()).setUserRating(convertToRating(RatingCompat.newUnratedRating(i)));
        Bitmap iconBitmap = mediaDescriptionCompat.getIconBitmap();
        if (iconBitmap != null) {
            try {
                bArr = convertToByteArray(iconBitmap);
            } catch (IOException e) {
                Log.w(TAG, "Failed to convert iconBitmap to artworkData", e);
                bArr = null;
            }
            builder.setArtworkData(bArr, 3);
        }
        Bundle extras = mediaDescriptionCompat.getExtras();
        Bundle bundle = extras != null ? new Bundle(extras) : null;
        if (bundle != null && bundle.containsKey(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE)) {
            builder.setFolderType(Integer.valueOf(convertToFolderType(bundle.getLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE))));
            bundle.remove(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE);
        }
        builder.setIsBrowsable(Boolean.valueOf(z));
        if (bundle != null && bundle.containsKey(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)) {
            builder.setMediaType(Integer.valueOf((int) bundle.getLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)));
            bundle.remove(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT);
        }
        if (bundle != null && !bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        builder.setIsPlayable(Boolean.valueOf(z2));
        return builder.build();
    }

    public static MediaMetadata convertToMediaMetadata(MediaMetadataCompat mediaMetadataCompat, int i) {
        if (mediaMetadataCompat == null) {
            return MediaMetadata.EMPTY;
        }
        MediaMetadata.Builder builder = new MediaMetadata.Builder();
        builder.setTitle(getFirstText(mediaMetadataCompat, MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, MediaMetadataCompat.METADATA_KEY_TITLE)).setSubtitle(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE)).setDescription(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION)).setArtist(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ARTIST)).setAlbumTitle(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ALBUM)).setAlbumArtist(mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)).setOverallRating(convertToRating(mediaMetadataCompat.getRating(MediaMetadataCompat.METADATA_KEY_RATING)));
        Rating convertToRating = convertToRating(mediaMetadataCompat.getRating(MediaMetadataCompat.METADATA_KEY_USER_RATING));
        if (convertToRating != null) {
            builder.setUserRating(convertToRating);
        } else {
            builder.setUserRating(convertToRating(RatingCompat.newUnratedRating(i)));
        }
        if (mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR)) {
            builder.setRecordingYear(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_YEAR)));
        }
        String firstString = getFirstString(mediaMetadataCompat, MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI);
        if (firstString != null) {
            builder.setArtworkUri(Uri.parse(firstString));
        }
        Bitmap firstBitmap = getFirstBitmap(mediaMetadataCompat, MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
        if (firstBitmap != null) {
            try {
                builder.setArtworkData(convertToByteArray(firstBitmap), 3);
            } catch (IOException e) {
                Log.w(TAG, "Failed to convert artworkBitmap to artworkData", e);
            }
        }
        boolean containsKey = mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE);
        builder.setIsBrowsable(Boolean.valueOf(containsKey));
        if (containsKey) {
            builder.setFolderType(Integer.valueOf(convertToFolderType(mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE))));
        }
        if (mediaMetadataCompat.containsKey(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)) {
            builder.setMediaType(Integer.valueOf((int) mediaMetadataCompat.getLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT)));
        }
        builder.setIsPlayable(true);
        Bundle bundle = mediaMetadataCompat.getBundle();
        UnmodifiableIterator<String> it = KNOWN_METADATA_COMPAT_KEYS.iterator();
        while (it.hasNext()) {
            bundle.remove(it.next());
        }
        if (!bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        return builder.build();
    }

    private static Bitmap getFirstBitmap(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getBitmap(str);
            }
        }
        return null;
    }

    private static String getFirstString(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getString(str);
            }
        }
        return null;
    }

    private static CharSequence getFirstText(MediaMetadataCompat mediaMetadataCompat, String... strArr) {
        for (String str : strArr) {
            if (mediaMetadataCompat.containsKey(str)) {
                return mediaMetadataCompat.getText(str);
            }
        }
        return null;
    }

    public static MediaMetadataCompat convertToMediaMetadataCompat(MediaMetadata mediaMetadata, String str, Uri uri, long j, Bitmap bitmap) {
        MediaMetadataCompat.Builder putString = new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, str);
        if (mediaMetadata.title != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_TITLE, mediaMetadata.title);
            putString.putText(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, mediaMetadata.title);
        }
        if (mediaMetadata.subtitle != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, mediaMetadata.subtitle);
        }
        if (mediaMetadata.description != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_DISPLAY_DESCRIPTION, mediaMetadata.description);
        }
        if (mediaMetadata.artist != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_ARTIST, mediaMetadata.artist);
        }
        if (mediaMetadata.albumTitle != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_ALBUM, mediaMetadata.albumTitle);
        }
        if (mediaMetadata.albumArtist != null) {
            putString.putText(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST, mediaMetadata.albumArtist);
        }
        if (mediaMetadata.recordingYear != null) {
            putString.putLong(MediaMetadataCompat.METADATA_KEY_YEAR, mediaMetadata.recordingYear.intValue());
        }
        if (uri != null) {
            putString.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_URI, uri.toString());
        }
        if (mediaMetadata.artworkUri != null) {
            putString.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON_URI, mediaMetadata.artworkUri.toString());
            putString.putString(MediaMetadataCompat.METADATA_KEY_ALBUM_ART_URI, mediaMetadata.artworkUri.toString());
        }
        if (bitmap != null) {
            putString.putBitmap(MediaMetadataCompat.METADATA_KEY_DISPLAY_ICON, bitmap);
            putString.putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, bitmap);
        }
        if (mediaMetadata.folderType != null && mediaMetadata.folderType.intValue() != -1) {
            putString.putLong(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE, convertToExtraBtFolderType(mediaMetadata.folderType.intValue()));
        }
        if (j != -9223372036854775807L) {
            putString.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, j);
        }
        RatingCompat convertToRatingCompat = convertToRatingCompat(mediaMetadata.userRating);
        if (convertToRatingCompat != null) {
            putString.putRating(MediaMetadataCompat.METADATA_KEY_USER_RATING, convertToRatingCompat);
        }
        RatingCompat convertToRatingCompat2 = convertToRatingCompat(mediaMetadata.overallRating);
        if (convertToRatingCompat2 != null) {
            putString.putRating(MediaMetadataCompat.METADATA_KEY_RATING, convertToRatingCompat2);
        }
        if (mediaMetadata.mediaType != null) {
            putString.putLong(MediaConstants.EXTRAS_KEY_MEDIA_TYPE_COMPAT, mediaMetadata.mediaType.intValue());
        }
        if (mediaMetadata.extras != null) {
            for (String str2 : mediaMetadata.extras.keySet()) {
                Object obj = mediaMetadata.extras.get(str2);
                if (obj == null || (obj instanceof CharSequence)) {
                    putString.putText(str2, (CharSequence) obj);
                } else if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
                    putString.putLong(str2, ((Number) obj).longValue());
                }
            }
        }
        return putString.build();
    }

    private static long convertToExtraBtFolderType(int i) {
        switch (i) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 3L;
            case 4:
                return 4L;
            case 5:
                return 5L;
            case 6:
                return 6L;
            default:
                throw new IllegalArgumentException("Unrecognized FolderType: " + i);
        }
    }

    public static Rating convertToRating(RatingCompat ratingCompat) {
        if (ratingCompat == null) {
            return null;
        }
        switch (ratingCompat.getRatingStyle()) {
            case 1:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 2:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 3:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 4:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 5:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
            case 6:
                if (!ratingCompat.isRated()) {
                    break;
                } else {
                    break;
                }
        }
        return null;
    }

    public static RatingCompat convertToRatingCompat(Rating rating) {
        if (rating == null) {
            return null;
        }
        int ratingCompatStyle = getRatingCompatStyle(rating);
        if (!rating.isRated()) {
            return RatingCompat.newUnratedRating(ratingCompatStyle);
        }
        switch (ratingCompatStyle) {
            case 1:
                return RatingCompat.newHeartRating(((HeartRating) rating).isHeart());
            case 2:
                return RatingCompat.newThumbRating(((ThumbRating) rating).isThumbsUp());
            case 3:
            case 4:
            case 5:
                return RatingCompat.newStarRating(ratingCompatStyle, ((StarRating) rating).getStarRating());
            case 6:
                return RatingCompat.newPercentageRating(((PercentageRating) rating).getPercent());
            default:
                return null;
        }
    }

    public static int convertToPlaybackStateCompatState(Player player, boolean z) {
        if (player.getPlayerError() != null) {
            return 7;
        }
        int playbackState = player.getPlaybackState();
        boolean shouldShowPlayButton = Util.shouldShowPlayButton(player, z);
        if (playbackState == 1) {
            return 0;
        }
        if (playbackState == 2) {
            return shouldShowPlayButton ? 2 : 6;
        }
        if (playbackState == 3) {
            return shouldShowPlayButton ? 2 : 3;
        }
        if (playbackState == 4) {
            return 1;
        }
        throw new IllegalArgumentException("Unrecognized State: " + playbackState);
    }

    public static PlaybackParameters convertToPlaybackParameters(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return PlaybackParameters.DEFAULT;
        }
        return new PlaybackParameters(playbackStateCompat.getPlaybackSpeed());
    }

    public static boolean convertToPlayWhenReady(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return false;
        }
        switch (playbackStateCompat.getState()) {
        }
        return false;
    }

    public static int convertToPlaybackState(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) throws ConversionException {
        if (playbackStateCompat == null) {
            return 1;
        }
        switch (playbackStateCompat.getState()) {
            case 0:
            case 1:
            case 7:
            case 8:
                return 1;
            case 2:
                long convertToDurationMs = convertToDurationMs(mediaMetadataCompat);
                return (convertToDurationMs != -9223372036854775807L && convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j) >= convertToDurationMs) ? 4 : 3;
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
                return 2;
            default:
                throw new ConversionException("Invalid state of PlaybackStateCompat: " + playbackStateCompat.getState());
        }
    }

    public static boolean convertToIsPlaying(PlaybackStateCompat playbackStateCompat) {
        return playbackStateCompat != null && playbackStateCompat.getState() == 3;
    }

    public static boolean convertToIsPlayingAd(MediaMetadataCompat mediaMetadataCompat) {
        return (mediaMetadataCompat == null || mediaMetadataCompat.getLong("android.media.metadata.ADVERTISEMENT") == 0) ? false : true;
    }

    public static long convertToCurrentPositionMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        long position;
        if (playbackStateCompat == null) {
            return 0L;
        }
        if (playbackStateCompat.getState() == 3) {
            position = getCurrentPosition(playbackStateCompat, j);
        } else {
            position = playbackStateCompat.getPosition();
        }
        long j2 = position;
        long convertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        if (convertToDurationMs == -9223372036854775807L) {
            return Math.max(0L, j2);
        }
        return Util.constrainValue(j2, 0L, convertToDurationMs);
    }

    private static long getCurrentPosition(PlaybackStateCompat playbackStateCompat, long j) {
        return playbackStateCompat.getCurrentPosition(j == -9223372036854775807L ? null : Long.valueOf(j));
    }

    public static long convertToDurationMs(MediaMetadataCompat mediaMetadataCompat) {
        if (mediaMetadataCompat == null || !mediaMetadataCompat.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
            return -9223372036854775807L;
        }
        long j = mediaMetadataCompat.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
        if (j <= 0) {
            return -9223372036854775807L;
        }
        return j;
    }

    public static long convertToBufferedPositionMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        long bufferedPosition = playbackStateCompat == null ? 0L : playbackStateCompat.getBufferedPosition();
        long convertToCurrentPositionMs = convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j);
        long convertToDurationMs = convertToDurationMs(mediaMetadataCompat);
        if (convertToDurationMs == -9223372036854775807L) {
            return Math.max(convertToCurrentPositionMs, bufferedPosition);
        }
        return Util.constrainValue(bufferedPosition, convertToCurrentPositionMs, convertToDurationMs);
    }

    public static long convertToTotalBufferedDurationMs(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        return convertToBufferedPositionMs(playbackStateCompat, mediaMetadataCompat, j) - convertToCurrentPositionMs(playbackStateCompat, mediaMetadataCompat, j);
    }

    public static int convertToBufferedPercentage(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, long j) {
        return MediaUtils.calculateBufferedPercentage(convertToBufferedPositionMs(playbackStateCompat, mediaMetadataCompat, j), convertToDurationMs(mediaMetadataCompat));
    }

    public static int getRatingCompatStyle(Rating rating) {
        if (rating instanceof HeartRating) {
            return 1;
        }
        if (rating instanceof ThumbRating) {
            return 2;
        }
        if (!(rating instanceof StarRating)) {
            return rating instanceof PercentageRating ? 6 : 0;
        }
        int maxStars = ((StarRating) rating).getMaxStars();
        int i = 3;
        if (maxStars != 3) {
            i = 4;
            if (maxStars != 4) {
                i = 5;
                if (maxStars != 5) {
                    return 0;
                }
            }
        }
        return i;
    }

    public static int convertToRepeatMode(int i) {
        if (i == -1 || i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                Log.w(TAG, "Unrecognized PlaybackStateCompat.RepeatMode: " + i + " was converted to `Player.REPEAT_MODE_OFF`");
                return 0;
            }
        }
        return i2;
    }

    public static int convertToPlaybackStateCompatRepeatMode(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                Log.w(TAG, "Unrecognized RepeatMode: " + i + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
                return 0;
            }
        }
        return i2;
    }

    public static boolean convertToShuffleModeEnabled(int i) {
        if (i == -1 || i == 0) {
            return false;
        }
        if (i == 1 || i == 2) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized ShuffleMode: " + i);
    }

    public static MediaLibraryService.LibraryParams convertToLibraryParams(Context context, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        try {
            bundle.setClassLoader(context.getClassLoader());
            int i = bundle.getInt(androidx.media.utils.MediaConstants.BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_SUPPORTED_FLAGS, -1);
            if (i >= 0) {
                bundle.remove(androidx.media.utils.MediaConstants.BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_SUPPORTED_FLAGS);
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                bundle.putBoolean(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY, z);
            }
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).setRecent(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT)).setOffline(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE)).setSuggested(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED)).build();
        } catch (Exception unused) {
            return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).build();
        }
    }

    public static Bundle convertToRootHints(MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams == null) {
            return null;
        }
        Bundle bundle = new Bundle(libraryParams.extras);
        if (libraryParams.extras.containsKey(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY)) {
            boolean z = libraryParams.extras.getBoolean(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY, false);
            bundle.remove(MediaConstants.EXTRA_KEY_ROOT_CHILDREN_BROWSABLE_ONLY);
            bundle.putInt(androidx.media.utils.MediaConstants.BROWSER_ROOT_HINTS_KEY_ROOT_CHILDREN_SUPPORTED_FLAGS, z ? 1 : 3);
        }
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT, libraryParams.isRecent);
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE, libraryParams.isOffline);
        bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED, libraryParams.isSuggested);
        return bundle;
    }

    public static Player.Commands convertToPlayerCommands(PlaybackStateCompat playbackStateCompat, int i, long j, boolean z) {
        Player.Commands.Builder builder = new Player.Commands.Builder();
        long actions = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
        if ((hasAction(actions, 4L) && hasAction(actions, 2L)) || hasAction(actions, 512L)) {
            builder.add(1);
        }
        if (hasAction(actions, 16384L)) {
            builder.add(2);
        }
        if ((hasAction(actions, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) && hasAction(actions, 1024L)) || ((hasAction(actions, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) && hasAction(actions, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)) || (hasAction(actions, PlaybackStateCompat.ACTION_PREPARE_FROM_URI) && hasAction(actions, PlaybackStateCompat.ACTION_PLAY_FROM_URI)))) {
            builder.addAll(31, 2);
        }
        if (hasAction(actions, 8L)) {
            builder.add(11);
        }
        if (hasAction(actions, 64L)) {
            builder.add(12);
        }
        if (hasAction(actions, 256L)) {
            builder.addAll(5, 4);
        }
        if (hasAction(actions, 32L)) {
            builder.addAll(9, 8);
        }
        if (hasAction(actions, 16L)) {
            builder.addAll(7, 6);
        }
        if (hasAction(actions, PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED)) {
            builder.add(13);
        }
        if (hasAction(actions, 1L)) {
            builder.add(3);
        }
        if (i == 1) {
            builder.addAll(26, 34);
        } else if (i == 2) {
            builder.addAll(26, 34, 25, 33);
        }
        builder.addAll(23, 17, 18, 16, 21, 32);
        if ((j & 4) != 0) {
            builder.add(20);
            if (hasAction(actions, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) {
                builder.add(10);
            }
        }
        if (z) {
            if (hasAction(actions, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
                builder.add(15);
            }
            if (hasAction(actions, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE)) {
                builder.add(14);
            }
        }
        return builder.build();
    }

    public static SessionCommands convertToSessionCommands(PlaybackStateCompat playbackStateCompat, boolean z) {
        SessionCommands.Builder builder = new SessionCommands.Builder();
        builder.addAllSessionCommands();
        if (!z) {
            builder.remove(SessionCommand.COMMAND_CODE_SESSION_SET_RATING);
        }
        if (playbackStateCompat != null && playbackStateCompat.getCustomActions() != null) {
            for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.getCustomActions()) {
                String action = customAction.getAction();
                Bundle extras = customAction.getExtras();
                if (extras == null) {
                    extras = Bundle.EMPTY;
                }
                builder.add(new SessionCommand(action, extras));
            }
        }
        return builder.build();
    }

    public static ImmutableList<CommandButton> convertToCustomLayout(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return ImmutableList.of();
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.getCustomActions()) {
            String action = customAction.getAction();
            Bundle extras = customAction.getExtras();
            CommandButton.Builder builder2 = new CommandButton.Builder();
            if (extras == null) {
                extras = Bundle.EMPTY;
            }
            builder.add((ImmutableList.Builder) builder2.setSessionCommand(new SessionCommand(action, extras)).setDisplayName(customAction.getName()).setEnabled(true).setIconResId(customAction.getIcon()).build());
        }
        return builder.build();
    }

    public static AudioAttributes convertToAudioAttributes(AudioAttributesCompat audioAttributesCompat) {
        if (audioAttributesCompat == null) {
            return AudioAttributes.DEFAULT;
        }
        return new AudioAttributes.Builder().setContentType(audioAttributesCompat.getContentType()).setFlags(audioAttributesCompat.getFlags()).setUsage(audioAttributesCompat.getUsage()).build();
    }

    public static AudioAttributes convertToAudioAttributes(MediaControllerCompat.PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            return AudioAttributes.DEFAULT;
        }
        return convertToAudioAttributes(playbackInfo.getAudioAttributes());
    }

    public static AudioAttributesCompat convertToAudioAttributesCompat(AudioAttributes audioAttributes) {
        return new AudioAttributesCompat.Builder().setContentType(audioAttributes.contentType).setFlags(audioAttributes.flags).setUsage(audioAttributes.usage).build();
    }

    public static int getLegacyStreamType(AudioAttributes audioAttributes) {
        int legacyStreamType = convertToAudioAttributesCompat(audioAttributes).getLegacyStreamType();
        if (legacyStreamType == Integer.MIN_VALUE) {
            return 3;
        }
        return legacyStreamType;
    }

    public static <T> T getFutureResult(Future<T> future, long j) throws ExecutionException, TimeoutException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        while (true) {
            try {
                try {
                    return future.get(j2, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    z = true;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    if (elapsedRealtime2 >= j) {
                        throw new TimeoutException();
                    }
                    j2 = j - elapsedRealtime2;
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static DeviceInfo convertToDeviceInfo(MediaControllerCompat.PlaybackInfo playbackInfo, String str) {
        if (playbackInfo == null) {
            return DeviceInfo.UNKNOWN;
        }
        return new DeviceInfo.Builder(playbackInfo.getPlaybackType() == 2 ? 1 : 0).setMaxVolume(playbackInfo.getMaxVolume()).setRoutingControllerId(str).build();
    }

    public static int convertToDeviceVolume(MediaControllerCompat.PlaybackInfo playbackInfo) {
        if (playbackInfo == null) {
            return 0;
        }
        return playbackInfo.getCurrentVolume();
    }

    public static boolean convertToIsDeviceMuted(MediaControllerCompat.PlaybackInfo playbackInfo) {
        return playbackInfo != null && playbackInfo.getCurrentVolume() == 0;
    }

    private static byte[] convertToByteArray(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private LegacyConversions() {
    }
}
