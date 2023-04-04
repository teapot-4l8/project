package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczn implements zzdav<zzbne> {
    private final /* synthetic */ zzczk zzhbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzczn(zzczk zzczkVar) {
        this.zzhbc = zzczkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final void zzatg() {
        synchronized (this.zzhbc) {
            this.zzhbc.zzhah = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final /* synthetic */ void onSuccess(zzbne zzbneVar) {
        zzbne zzbneVar2;
        zzbne zzbneVar3;
        zzbne zzbneVar4;
        zzbne zzbneVar5 = zzbneVar;
        synchronized (this.zzhbc) {
            zzbneVar2 = this.zzhbc.zzhah;
            if (zzbneVar2 != null) {
                zzbneVar4 = this.zzhbc.zzhah;
                zzbneVar4.destroy();
            }
            this.zzhbc.zzhah = zzbneVar5;
            zzbneVar3 = this.zzhbc.zzhah;
            zzbneVar3.zzakv();
        }
    }
}
