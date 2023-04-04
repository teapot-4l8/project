package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzdod implements Runnable {
    private final zzdnb zzhlm;

    private zzdod(zzdnb zzdnbVar) {
        this.zzhlm = zzdnbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zzb(zzdnb zzdnbVar) {
        return new zzdod(zzdnbVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhlm.onAdLoaded();
    }
}
