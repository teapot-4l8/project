package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzly extends Exception {
    private final String mimeType;
    private final boolean zzbdf;
    private final String zzbdg;
    private final String zzbdh;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzly(zzht zzhtVar, Throwable th, boolean z, int i) {
        super(r1.toString(), th);
        String valueOf = String.valueOf(zzhtVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(valueOf);
        this.mimeType = zzhtVar.zzaho;
        this.zzbdf = false;
        this.zzbdg = null;
        String str = i < 0 ? "neg_" : "";
        int abs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(str.length() + 64);
        sb2.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
        sb2.append(str);
        sb2.append(abs);
        this.zzbdh = sb2.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzly(zzht zzhtVar, Throwable th, boolean z, String str) {
        super(r1.toString(), th);
        String valueOf = String.valueOf(zzhtVar);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(valueOf).length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(valueOf);
        this.mimeType = zzhtVar.zzaho;
        this.zzbdf = false;
        this.zzbdg = str;
        String str2 = null;
        if (zzpt.SDK_INT >= 21 && (th instanceof MediaCodec.CodecException)) {
            str2 = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.zzbdh = str2;
    }
}
