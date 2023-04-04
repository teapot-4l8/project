package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzip implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ zzht zzajw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzip(zzik zzikVar, zzht zzhtVar) {
        this.zzajr = zzikVar;
        this.zzajw = zzhtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajr.zzajn;
        zzilVar.zzc(this.zzajw);
    }
}
