package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzbce implements Runnable {
    private final zzbbz zzemq;

    private zzbce(zzbbz zzbbzVar) {
        this.zzemq = zzbbzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zza(zzbbz zzbbzVar) {
        return new zzbce(zzbbzVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzemq.stop();
    }
}
