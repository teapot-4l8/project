package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdan implements zzdav<zzcaj> {
    private final /* synthetic */ zzdak zzhbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdan(zzdak zzdakVar) {
        this.zzhbr = zzdakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final void zzatg() {
        synchronized (this.zzhbr) {
            this.zzhbr.zzhbj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final /* synthetic */ void onSuccess(zzcaj zzcajVar) {
        zzcaj zzcajVar2;
        zzcaj zzcajVar3 = zzcajVar;
        synchronized (this.zzhbr) {
            this.zzhbr.zzhbj = zzcajVar3;
            zzcajVar2 = this.zzhbr.zzhbj;
            zzcajVar2.zzakv();
        }
    }
}
