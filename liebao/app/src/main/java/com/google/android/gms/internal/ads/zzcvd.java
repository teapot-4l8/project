package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvd implements zzcbr {
    private final Context context;
    private final zzbar zzbpj;
    private final zzdpm zzfzg;
    private final zzdot zzghi;
    private final zzail zzgvp;
    private final boolean zzgvq;
    private final zzebt<zzcal> zzgvx;
    private final zzbfi zzgvy;

    private zzcvd(Context context, zzbar zzbarVar, zzebt<zzcal> zzebtVar, zzdot zzdotVar, zzbfi zzbfiVar, zzdpm zzdpmVar, boolean z, zzail zzailVar) {
        this.context = context;
        this.zzbpj = zzbarVar;
        this.zzgvx = zzebtVar;
        this.zzghi = zzdotVar;
        this.zzgvy = zzbfiVar;
        this.zzfzg = zzdpmVar;
        this.zzgvp = zzailVar;
        this.zzgvq = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zza(boolean z, Context context) {
        zzcal zzcalVar = (zzcal) zzebh.zzb(this.zzgvx);
        this.zzgvy.zzbe(true);
        boolean zzad = this.zzgvq ? this.zzgvp.zzad(false) : false;
        com.google.android.gms.ads.internal.zzr.zzkv();
        com.google.android.gms.ads.internal.zzk zzkVar = new com.google.android.gms.ads.internal.zzk(zzad, com.google.android.gms.ads.internal.util.zzj.zzba(this.context), this.zzgvq ? this.zzgvp.zzui() : false, this.zzgvq ? this.zzgvp.zzuj() : 0.0f, -1, z, this.zzghi.zzfvy, false);
        com.google.android.gms.ads.internal.zzr.zzku();
        com.google.android.gms.ads.internal.overlay.zzo.zza(context, new AdOverlayInfoParcel((zzve) null, zzcalVar.zzahz(), (com.google.android.gms.ads.internal.overlay.zzx) null, this.zzgvy, this.zzghi.zzhmq, this.zzbpj, this.zzghi.zzdxn, zzkVar, this.zzghi.zzhmh.zzdug, this.zzghi.zzhmh.zzdui, this.zzfzg.zzhny), true);
    }
}
