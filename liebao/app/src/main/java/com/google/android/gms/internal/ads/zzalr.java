package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzalr implements zzbbi<zzakv> {
    private final /* synthetic */ zzale zzdlf;
    private final /* synthetic */ zzalz zzdlh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalr(zzale zzaleVar, zzalz zzalzVar) {
        this.zzdlf = zzaleVar;
        this.zzdlh = zzalzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbi
    public final /* synthetic */ void zzg(zzakv zzakvVar) {
        Object obj;
        zzalz zzalzVar;
        zzalz zzalzVar2;
        zzalz zzalzVar3;
        obj = this.zzdlf.lock;
        synchronized (obj) {
            this.zzdlf.status = 0;
            zzalzVar = this.zzdlf.zzdku;
            if (zzalzVar != null) {
                zzalz zzalzVar4 = this.zzdlh;
                zzalzVar2 = this.zzdlf.zzdku;
                if (zzalzVar4 != zzalzVar2) {
                    com.google.android.gms.ads.internal.util.zzd.zzed("New JS engine is loaded, marking previous one as destroyable.");
                    zzalzVar3 = this.zzdlf.zzdku;
                    zzalzVar3.zzuy();
                }
            }
            this.zzdlf.zzdku = this.zzdlh;
        }
    }
}
