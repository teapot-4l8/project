package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzin implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ zzjm zzajs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzin(zzik zzikVar, zzjm zzjmVar) {
        this.zzajr = zzikVar;
        this.zzajs = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajr.zzajn;
        zzilVar.zzc(this.zzajs);
    }
}
