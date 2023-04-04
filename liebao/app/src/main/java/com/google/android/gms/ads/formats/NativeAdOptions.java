package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzbob;
    private final int zzboc;
    private final int zzbod;
    private final boolean zzboe;
    private final int zzbof;
    private final VideoOptions zzbog;
    private final boolean zzboh;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public @interface NativeMediaAspectRatio {
    }

    private NativeAdOptions(Builder builder) {
        this.zzbob = builder.zzbob;
        this.zzboc = builder.zzboc;
        this.zzbod = builder.zzbod;
        this.zzboe = builder.zzboe;
        this.zzbof = builder.zzbof;
        this.zzbog = builder.zzbog;
        this.zzboh = builder.zzboh;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private VideoOptions zzbog;
        private boolean zzbob = false;
        private int zzboc = -1;
        private int zzbod = 0;
        private boolean zzboe = false;
        private int zzbof = 1;
        private boolean zzboh = false;

        public final Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzbob = z;
            return this;
        }

        @Deprecated
        public final Builder setImageOrientation(int i) {
            this.zzboc = i;
            return this;
        }

        public final Builder setMediaAspectRatio(int i) {
            this.zzbod = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean z) {
            this.zzboe = z;
            return this;
        }

        public final Builder setAdChoicesPlacement(int i) {
            this.zzbof = i;
            return this;
        }

        public final Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzbog = videoOptions;
            return this;
        }

        public final Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzboh = z;
            return this;
        }

        public final NativeAdOptions build() {
            return new NativeAdOptions(this);
        }
    }

    public final boolean shouldReturnUrlsForImageAssets() {
        return this.zzbob;
    }

    @Deprecated
    public final int getImageOrientation() {
        return this.zzboc;
    }

    public final int getMediaAspectRatio() {
        return this.zzbod;
    }

    public final boolean shouldRequestMultipleImages() {
        return this.zzboe;
    }

    public final int getAdChoicesPlacement() {
        return this.zzbof;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbog;
    }

    public final boolean zzjx() {
        return this.zzboh;
    }
}
