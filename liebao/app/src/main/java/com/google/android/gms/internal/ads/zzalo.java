package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzalo implements Runnable {
    private final zzakv zzdlb;

    private zzalo(zzakv zzakvVar) {
        this.zzdlb = zzakvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zzb(zzakv zzakvVar) {
        return new zzalo(zzakvVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdlb.destroy();
    }
}
