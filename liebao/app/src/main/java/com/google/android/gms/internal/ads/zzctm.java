package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzctm implements zzcbr {
    private final zzbar zzbpj;
    private final zzdpm zzfzg;
    private final zzdot zzghi;
    private final zzail zzgvp;
    private final boolean zzgvq;
    private final zzebt<zzbmr> zzgvx;
    private final zzbfi zzgvy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzctm(zzbar zzbarVar, zzebt<zzbmr> zzebtVar, zzdot zzdotVar, zzbfi zzbfiVar, zzdpm zzdpmVar, boolean z, zzail zzailVar) {
        this.zzbpj = zzbarVar;
        this.zzgvx = zzebtVar;
        this.zzghi = zzdotVar;
        this.zzgvy = zzbfiVar;
        this.zzfzg = zzdpmVar;
        this.zzgvq = z;
        this.zzgvp = zzailVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zza(boolean z, Context context) {
        int i;
        int i2;
        zzbmr zzbmrVar = (zzbmr) zzebh.zzb(this.zzgvx);
        this.zzgvy.zzbe(true);
        com.google.android.gms.ads.internal.zzk zzkVar = new com.google.android.gms.ads.internal.zzk(this.zzgvq ? this.zzgvp.zzad(true) : true, true, this.zzgvq ? this.zzgvp.zzui() : false, this.zzgvq ? this.zzgvp.zzuj() : 0.0f, -1, z, this.zzghi.zzfvy, false);
        com.google.android.gms.ads.internal.zzr.zzku();
        zzcbh zzahz = zzbmrVar.zzahz();
        zzbfi zzbfiVar = this.zzgvy;
        if (this.zzghi.zzhmq != -1) {
            i = this.zzghi.zzhmq;
        } else {
            if (this.zzfzg.zzhob != null) {
                if (this.zzfzg.zzhob.orientation == 1) {
                    i2 = 7;
                } else if (this.zzfzg.zzhob.orientation == 2) {
                    i2 = 6;
                }
                com.google.android.gms.ads.internal.overlay.zzo.zza(context, new AdOverlayInfoParcel((zzve) null, zzahz, (com.google.android.gms.ads.internal.overlay.zzx) null, zzbfiVar, i2, this.zzbpj, this.zzghi.zzdxn, zzkVar, this.zzghi.zzhmh.zzdug, this.zzghi.zzhmh.zzdui, this.zzfzg.zzhny), true);
            }
            com.google.android.gms.ads.internal.util.zzd.zzdz("Error setting app open orientation; no targeting orientation available.");
            i = this.zzghi.zzhmq;
        }
        i2 = i;
        com.google.android.gms.ads.internal.overlay.zzo.zza(context, new AdOverlayInfoParcel((zzve) null, zzahz, (com.google.android.gms.ads.internal.overlay.zzx) null, zzbfiVar, i2, this.zzbpj, this.zzghi.zzdxn, zzkVar, this.zzghi.zzhmh.zzdug, this.zzghi.zzhmh.zzdui, this.zzfzg.zzhny), true);
    }
}
