package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcio implements Runnable {
    private final zzbfi zzewn;

    private zzcio(zzbfi zzbfiVar) {
        this.zzewn = zzbfiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zze(zzbfi zzbfiVar) {
        return new zzcio(zzbfiVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzewn.destroy();
    }
}
