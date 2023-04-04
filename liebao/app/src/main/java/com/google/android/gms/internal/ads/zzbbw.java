package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbbw implements Runnable {
    private final /* synthetic */ zzbbq zzelq;
    private final /* synthetic */ int zzelu;
    private final /* synthetic */ int zzelv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbw(zzbbq zzbbqVar, int i, int i2) {
        this.zzelq = zzbbqVar;
        this.zzelu = i;
        this.zzelv = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbca zzbcaVar;
        zzbca zzbcaVar2;
        zzbcaVar = this.zzelq.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar2 = this.zzelq.zzelo;
            zzbcaVar2.zzm(this.zzelu, this.zzelv);
        }
    }
}
