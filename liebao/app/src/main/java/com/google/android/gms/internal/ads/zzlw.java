package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzlw {
    private final String mimeType;
    public final String name;
    public final boolean zzama;
    public final boolean zzbdb;
    public final boolean zzbdc;
    private final MediaCodecInfo.CodecCapabilities zzbdd;

    public static zzlw zzay(String str) {
        return new zzlw(str, null, null, false, false);
    }

    public static zzlw zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzlw(str, str2, codecCapabilities, z, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
        if ((com.google.android.gms.internal.ads.zzpt.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzlw(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        this.name = (String) zzpg.checkNotNull(str);
        this.mimeType = str2;
        this.zzbdd = codecCapabilities;
        boolean z5 = true;
        if (!z && codecCapabilities != null) {
            if (zzpt.SDK_INT >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                z3 = true;
                this.zzbdb = z3;
                if (codecCapabilities != null) {
                    if (zzpt.SDK_INT >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                        z4 = true;
                        this.zzama = z4;
                        if (!z2) {
                            if (codecCapabilities != null) {
                            }
                            z5 = false;
                        }
                        this.zzbdc = z5;
                    }
                }
                z4 = false;
                this.zzama = z4;
                if (!z2) {
                }
                this.zzbdc = z5;
            }
        }
        z3 = false;
        this.zzbdb = z3;
        if (codecCapabilities != null) {
        }
        z4 = false;
        this.zzama = z4;
        if (!z2) {
        }
        this.zzbdc = z5;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzhm() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbdd;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.zzbdd.profileLevels;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzaz(String str) {
        String str2;
        MediaCodecInfo.CodecProfileLevel[] zzhm;
        if (str == null || this.mimeType == null) {
            return true;
        }
        if (str != null) {
            String trim = str.trim();
            if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
                str2 = "video/avc";
            } else if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
                str2 = "video/hevc";
            } else if (trim.startsWith("vp9")) {
                str2 = "video/x-vnd.on2.vp9";
            } else if (trim.startsWith("vp8")) {
                str2 = "video/x-vnd.on2.vp8";
            } else if (trim.startsWith("mp4a")) {
                str2 = "audio/mp4a-latm";
            } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
                str2 = "audio/ac3";
            } else if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
                str2 = "audio/eac3";
            } else if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
                str2 = "audio/vnd.dts";
            } else if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
                str2 = "audio/vnd.dts.hd";
            } else if (trim.startsWith("opus")) {
                str2 = "audio/opus";
            } else if (trim.startsWith("vorbis")) {
                str2 = "audio/vorbis";
            }
            if (str2 != null) {
                return true;
            }
            if (!this.mimeType.equals(str2)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(str2).length());
                sb.append("codec.mime ");
                sb.append(str);
                sb.append(", ");
                sb.append(str2);
                zzba(sb.toString());
                return false;
            }
            Pair<Integer, Integer> zzbb = zzlz.zzbb(str);
            if (zzbb == null) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzhm()) {
                if (codecProfileLevel.profile == ((Integer) zzbb.first).intValue() && codecProfileLevel.level >= ((Integer) zzbb.second).intValue()) {
                    return true;
                }
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str2).length());
            sb2.append("codec.profileLevel, ");
            sb2.append(str);
            sb2.append(", ");
            sb2.append(str2);
            zzba(sb2.toString());
            return false;
        }
        str2 = null;
        if (str2 != null) {
        }
    }

    public final boolean zza(int i, int i2, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbdd;
        if (codecCapabilities == null) {
            zzba("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzba("sizeAndRate.vCaps");
            return false;
        } else if (zza(videoCapabilities, i, i2, d2)) {
            return true;
        } else {
            if (i >= i2 || !zza(videoCapabilities, i2, i, d2)) {
                StringBuilder sb = new StringBuilder(69);
                sb.append("sizeAndRate.support, ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                sb.append("x");
                sb.append(d2);
                zzba(sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.rotated, ");
            sb2.append(i);
            sb2.append("x");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(d2);
            String sb3 = sb2.toString();
            String str = this.name;
            String str2 = this.mimeType;
            String str3 = zzpt.zzbkx;
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 25 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
            sb4.append("AssumedSupport [");
            sb4.append(sb3);
            sb4.append("] [");
            sb4.append(str);
            sb4.append(", ");
            sb4.append(str2);
            sb4.append("] [");
            sb4.append(str3);
            sb4.append("]");
            Log.d("MediaCodecInfo", sb4.toString());
            return true;
        }
    }

    public final Point zzf(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbdd;
        if (codecCapabilities == null) {
            zzba("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzba("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzpt.zzh(i, widthAlignment) * widthAlignment, zzpt.zzh(i2, heightAlignment) * heightAlignment);
    }

    public final boolean zzaz(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbdd;
        if (codecCapabilities == null) {
            zzba("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzba("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("sampleRate.support, ");
            sb.append(i);
            zzba(sb.toString());
            return false;
        }
    }

    public final boolean zzba(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbdd;
        if (codecCapabilities == null) {
            zzba("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzba("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() < i) {
            StringBuilder sb = new StringBuilder(33);
            sb.append("channelCount.support, ");
            sb.append(i);
            zzba(sb.toString());
            return false;
        } else {
            return true;
        }
    }

    private final void zzba(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzpt.zzbkx;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    private static boolean zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        if (d2 == -1.0d || d2 <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i2, d2);
    }
}
