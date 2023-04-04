package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzctw implements Runnable {
    private final zzbfi zzewn;

    private zzctw(zzbfi zzbfiVar) {
        this.zzewn = zzbfiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zze(zzbfi zzbfiVar) {
        return new zzctw(zzbfiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzewn.zzaes();
    }
}
