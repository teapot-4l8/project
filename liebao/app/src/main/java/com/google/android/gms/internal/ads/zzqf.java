package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzqf implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzqe zzbmr;

    private zzqf(zzqe zzqeVar, MediaCodec mediaCodec) {
        this.zzbmr = zzqeVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this != this.zzbmr.zzbmo) {
            return;
        }
        this.zzbmr.zzjo();
    }
}
