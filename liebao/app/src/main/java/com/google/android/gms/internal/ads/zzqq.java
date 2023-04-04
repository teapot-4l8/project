package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqq implements Runnable {
    private final /* synthetic */ zzqj zzbnk;
    private final /* synthetic */ int zzbno;
    private final /* synthetic */ int zzbnp;
    private final /* synthetic */ int zzbnq;
    private final /* synthetic */ float zzbnr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqq(zzqj zzqjVar, int i, int i2, int i3, float f) {
        this.zzbnk = zzqjVar;
        this.zzbno = i;
        this.zzbnp = i2;
        this.zzbnq = i3;
        this.zzbnr = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbnk.zzbnj;
        zzqkVar.zzb(this.zzbno, this.zzbnp, this.zzbnq, this.zzbnr);
    }
}
