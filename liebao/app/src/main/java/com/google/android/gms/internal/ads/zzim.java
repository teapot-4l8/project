package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzim implements Runnable {
    private final /* synthetic */ String zzajo;
    private final /* synthetic */ long zzajp;
    private final /* synthetic */ long zzajq;
    private final /* synthetic */ zzik zzajr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzim(zzik zzikVar, String str, long j, long j2) {
        this.zzajr = zzikVar;
        this.zzajo = str;
        this.zzajp = j;
        this.zzajq = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajr.zzajn;
        zzilVar.zzb(this.zzajo, this.zzajp, this.zzajq);
    }
}
