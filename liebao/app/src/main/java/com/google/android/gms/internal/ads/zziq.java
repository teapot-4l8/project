package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zziq implements Runnable {
    private final /* synthetic */ zzik zzajr;
    private final /* synthetic */ int zzajx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziq(zzik zzikVar, int i) {
        this.zzajr = zzikVar;
        this.zzajx = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajr.zzajn;
        zzilVar.zzaa(this.zzajx);
    }
}
