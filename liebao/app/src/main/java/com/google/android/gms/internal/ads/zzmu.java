package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzmu implements Runnable {
    private final /* synthetic */ zzms zzbdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmu(zzms zzmsVar) {
        this.zzbdv = zzmsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zznb zznbVar;
        z = this.zzbdv.zzagd;
        if (z) {
            return;
        }
        zznbVar = this.zzbdv.zzbei;
        zznbVar.zza((zznb) this.zzbdv);
    }
}
