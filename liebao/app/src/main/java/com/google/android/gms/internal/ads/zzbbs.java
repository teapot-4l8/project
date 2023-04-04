package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbbs implements Runnable {
    private final /* synthetic */ zzbbq zzelq;
    private final /* synthetic */ MediaPlayer zzelr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbs(zzbbq zzbbqVar, MediaPlayer mediaPlayer) {
        this.zzelq = zzbbqVar;
        this.zzelr = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbca zzbcaVar;
        zzbca zzbcaVar2;
        this.zzelq.zza(this.zzelr);
        zzbcaVar = this.zzelq.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar2 = this.zzelq.zzelo;
            zzbcaVar2.zzff();
        }
    }
}
