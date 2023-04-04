package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzir implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ zzjm zzajy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzir(zzik zzikVar, zzjm zzjmVar) {
        this.zzajr = zzikVar;
        this.zzajy = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        this.zzajy.zzgr();
        zzilVar = this.zzajr.zzajn;
        zzilVar.zzd(this.zzajy);
    }
}
