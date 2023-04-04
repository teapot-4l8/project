package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzalk implements Runnable {
    private final zzakv zzdlb;

    private zzalk(zzakv zzakvVar) {
        this.zzdlb = zzakvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zzb(zzakv zzakvVar) {
        return new zzalk(zzakvVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdlb.destroy();
    }
}
