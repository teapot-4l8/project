package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzio implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ int zzajt;
    private final /* synthetic */ long zzaju;
    private final /* synthetic */ long zzajv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(zzik zzikVar, int i, long j, long j2) {
        this.zzajr = zzikVar;
        this.zzajt = i;
        this.zzaju = j;
        this.zzajv = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajr.zzajn;
        zzilVar.zzb(this.zzajt, this.zzaju, this.zzajv);
    }
}
