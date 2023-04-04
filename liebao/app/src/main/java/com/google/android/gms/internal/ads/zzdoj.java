package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdoj implements zzdav<zzcip> {
    private final /* synthetic */ zzdoh zzhlt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdoj(zzdoh zzdohVar) {
        this.zzhlt = zzdohVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final void zzatg() {
        synchronized (this.zzhlt) {
            this.zzhlt.zzhls = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final /* synthetic */ void onSuccess(zzcip zzcipVar) {
        zzcip zzcipVar2;
        zzcip zzcipVar3 = zzcipVar;
        synchronized (this.zzhlt) {
            this.zzhlt.zzhls = zzcipVar3;
            zzcipVar2 = this.zzhlt.zzhls;
            zzcipVar2.zzakv();
        }
    }
}
