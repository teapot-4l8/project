package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdoq implements zzdav<zzcip> {
    private final /* synthetic */ zzdon zzhlw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdoq(zzdon zzdonVar) {
        this.zzhlw = zzdonVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final void zzatg() {
        synchronized (this.zzhlw) {
            this.zzhlw.zzhls = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final /* synthetic */ void onSuccess(zzcip zzcipVar) {
        zzcip zzcipVar2;
        zzcip zzcipVar3 = zzcipVar;
        synchronized (this.zzhlw) {
            this.zzhlw.zzhls = zzcipVar3;
            zzcipVar2 = this.zzhlw.zzhls;
            zzcipVar2.zzakv();
        }
    }
}
