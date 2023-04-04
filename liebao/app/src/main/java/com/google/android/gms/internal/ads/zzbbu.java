package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbbu implements Runnable {
    private final /* synthetic */ zzbbq zzelq;
    private final /* synthetic */ String zzels;
    private final /* synthetic */ String zzelt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbu(zzbbq zzbbqVar, String str, String str2) {
        this.zzelq = zzbbqVar;
        this.zzels = str;
        this.zzelt = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbca zzbcaVar;
        zzbca zzbcaVar2;
        zzbcaVar = this.zzelq.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar2 = this.zzelq.zzelo;
            zzbcaVar2.zzl(this.zzels, this.zzelt);
        }
    }
}
