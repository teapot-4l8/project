package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdrs implements zzebi<zzdrj<AdT>> {
    private final /* synthetic */ zzdrr zzhrz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdrs(zzdrr zzdrrVar) {
        this.zzhrz = zzdrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzdru zzdruVar;
        zzecb zzecbVar;
        synchronized (this.zzhrz) {
            zzdruVar = this.zzhrz.zzhrw;
            zzdruVar.zzb(th);
            zzecbVar = this.zzhrz.zzhrt;
            zzecbVar.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(Object obj) {
        zzdru zzdruVar;
        int i;
        int i2;
        zzecb zzecbVar;
        zzdrx zzdrxVar;
        zzdqz zzdqzVar;
        zzdrx zzdrxVar2;
        zzdrj<?> zzdrjVar = (zzdrj) obj;
        synchronized (this.zzhrz) {
            zzdruVar = this.zzhrz.zzhrw;
            zzdruVar.zza(zzdrjVar);
            i = this.zzhrz.zzhrv;
            if (i != zzdrw.zzhsc) {
                zzdqzVar = this.zzhrz.zzhkm;
                zzdrxVar2 = this.zzhrz.zzhrs;
                zzdqzVar.zza(zzdrxVar2.zzavp(), zzdrjVar);
            }
            i2 = this.zzhrz.zzhrv;
            if (i2 == zzdrw.zzhsb) {
                zzdrr zzdrrVar = this.zzhrz;
                zzdrxVar = this.zzhrz.zzhrs;
                zzdrrVar.zzd(zzdrxVar);
            }
            this.zzhrz.zzhrv = zzdrw.zzhsb;
            zzecbVar = this.zzhrz.zzhrt;
            zzecbVar.set(zzdrjVar);
        }
    }
}
