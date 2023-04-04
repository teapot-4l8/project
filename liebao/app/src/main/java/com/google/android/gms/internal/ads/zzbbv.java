package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbbv implements Runnable {
    private final /* synthetic */ zzbbq zzelq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbv(zzbbq zzbbqVar) {
        this.zzelq = zzbbqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbca zzbcaVar;
        zzbca zzbcaVar2;
        zzbca zzbcaVar3;
        zzbcaVar = this.zzelq.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar2 = this.zzelq.zzelo;
            zzbcaVar2.onPaused();
            zzbcaVar3 = this.zzelq.zzelo;
            zzbcaVar3.zzabg();
        }
    }
}
