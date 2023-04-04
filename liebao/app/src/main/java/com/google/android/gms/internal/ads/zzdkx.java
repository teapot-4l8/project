package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdkx implements zzdav<zzbmz> {
    private final /* synthetic */ zzdkt zzhjf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkx(zzdkt zzdktVar) {
        this.zzhjf = zzdktVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final void zzatg() {
        synchronized (this.zzhjf) {
            this.zzhjf.zzhjd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final /* synthetic */ void onSuccess(zzbmz zzbmzVar) {
        zzdkd zzdkdVar;
        zzdkd zzdkdVar2;
        zzbmz zzbmzVar2 = zzbmzVar;
        synchronized (this.zzhjf) {
            if (this.zzhjf.zzhjd != null) {
                this.zzhjf.zzhjd.destroy();
            }
            this.zzhjf.zzhjd = zzbmzVar2;
            this.zzhjf.zza(zzbmzVar2);
            zzdkdVar = this.zzhjf.zzhia;
            zzdkt zzdktVar = this.zzhjf;
            zzdkdVar2 = this.zzhjf.zzhia;
            zzdkdVar.zzb(new zzbmy(zzbmzVar2, zzdktVar, zzdkdVar2));
            zzbmzVar2.zzakv();
        }
    }
}
