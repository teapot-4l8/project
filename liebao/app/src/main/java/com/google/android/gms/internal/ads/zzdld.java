package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzdld implements Runnable {
    private final zzczm zzhbu;

    private zzdld(zzczm zzczmVar) {
        this.zzhbu = zzczmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zzb(zzczm zzczmVar) {
        return new zzdld(zzczmVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhbu.onAdLoaded();
    }
}
