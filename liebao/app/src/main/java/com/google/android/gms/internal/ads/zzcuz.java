package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcuz implements Runnable {
    private final zzcjq zzgvr;

    private zzcuz(zzcjq zzcjqVar) {
        this.zzgvr = zzcjqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zza(zzcjq zzcjqVar) {
        return new zzcuz(zzcjqVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgvr.zzaql();
    }
}
