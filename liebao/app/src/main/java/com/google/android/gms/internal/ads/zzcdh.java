package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcdh implements Runnable {
    private final zzcdz zzgge;

    private zzcdh(zzcdz zzcdzVar) {
        this.zzgge = zzcdzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zza(zzcdz zzcdzVar) {
        return new zzcdh(zzcdzVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgge.zzaof();
    }
}
