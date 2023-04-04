package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zziu extends zziv {
    private final AudioTimestamp zzamd;
    private long zzame;
    private long zzamf;
    private long zzamg;

    public zziu() {
        super(null);
        this.zzamd = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzame = 0L;
        this.zzamf = 0L;
        this.zzamg = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final boolean zzgc() {
        boolean timestamp = this.zzakm.getTimestamp(this.zzamd);
        if (timestamp) {
            long j = this.zzamd.framePosition;
            if (this.zzamf > j) {
                this.zzame++;
            }
            this.zzamf = j;
            this.zzamg = j + (this.zzame << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final long zzgd() {
        return this.zzamd.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.zziv
    public final long zzge() {
        return this.zzamg;
    }
}
