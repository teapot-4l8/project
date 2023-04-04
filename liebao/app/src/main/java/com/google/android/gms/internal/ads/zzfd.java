package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfd implements Runnable {
    private final /* synthetic */ int zzzr;
    private final /* synthetic */ boolean zzzs;
    private final /* synthetic */ zzfc zzzt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzfc zzfcVar, int i, boolean z) {
        this.zzzt = zzfcVar;
        this.zzzr = i;
        this.zzzs = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zza;
        zzcf.zza zzb = this.zzzt.zzb(this.zzzr, this.zzzs);
        this.zzzt.zzzk = zzb;
        zza = zzfc.zza(this.zzzr, zzb);
        if (zza) {
            this.zzzt.zza(this.zzzr + 1, this.zzzs);
        }
    }
}
