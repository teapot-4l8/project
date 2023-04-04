package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdao implements zzdav<zzbpc> {
    private final /* synthetic */ zzdap zzhbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdao(zzdap zzdapVar) {
        this.zzhbs = zzdapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final void zzatg() {
        synchronized (this.zzhbs) {
            this.zzhbs.zzafk = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final /* synthetic */ void onSuccess(zzbpc zzbpcVar) {
        zzbpc zzbpcVar2 = zzbpcVar;
        synchronized (this.zzhbs) {
            this.zzhbs.zzafk = false;
            this.zzhbs.zzaec = zzbpcVar2.zzall();
            zzbpcVar2.zzakv();
        }
    }
}
