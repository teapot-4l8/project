package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzalq implements zzbbg {
    private final /* synthetic */ zzale zzdlf;
    private final /* synthetic */ zzalz zzdlh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalq(zzale zzaleVar, zzalz zzalzVar) {
        this.zzdlf = zzaleVar;
        this.zzdlh = zzalzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbg
    public final void run() {
        Object obj;
        obj = this.zzdlf.lock;
        synchronized (obj) {
            this.zzdlf.status = 1;
            com.google.android.gms.ads.internal.util.zzd.zzed("Failed loading new engine. Marking new engine destroyable.");
            this.zzdlh.zzuy();
        }
    }
}
