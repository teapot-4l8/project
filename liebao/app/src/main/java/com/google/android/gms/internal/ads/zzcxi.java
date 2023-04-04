package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxi implements zzcbr {
    private final Context context;
    private final zzbar zzbpj;
    private final zzdot zzeux;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzail zzgvp;
    private final boolean zzgvq;
    private final zzebt<zzcir> zzgvx;
    private final zzbfi zzgyp;

    private zzcxi(Context context, zzcja zzcjaVar, zzdpm zzdpmVar, zzbar zzbarVar, zzdot zzdotVar, zzebt<zzcir> zzebtVar, zzbfi zzbfiVar, zzail zzailVar, boolean z) {
        this.context = context;
        this.zzgix = zzcjaVar;
        this.zzfzg = zzdpmVar;
        this.zzbpj = zzbarVar;
        this.zzeux = zzdotVar;
        this.zzgvx = zzebtVar;
        this.zzgyp = zzbfiVar;
        this.zzgvp = zzailVar;
        this.zzgvq = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    @Override // com.google.android.gms.internal.ads.zzcbr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(boolean z, Context context) {
        zzbfi zzbfiVar;
        zzbfi zzbfiVar2;
        zzcir zzcirVar = (zzcir) zzebh.zzb(this.zzgvx);
        try {
            zzdot zzdotVar = this.zzeux;
            if (!this.zzgyp.zzaeu()) {
                zzbfiVar2 = this.zzgyp;
            } else {
                if (!((Boolean) zzww.zzra().zzd(zzabq.zzcps)).booleanValue()) {
                    zzbfiVar2 = this.zzgyp;
                } else {
                    zzbfi zze = this.zzgix.zze(this.zzfzg.zzbpy);
                    zzaix.zza(zze, zzcirVar.zzajb());
                    zzcjq zzcjqVar = new zzcjq();
                    zzcjqVar.zzc(this.context, zze.getView());
                    zzcirVar.zzahy().zza(zze, true, (zzaii) (this.zzgvq ? this.zzgvp : null));
                    zze.zzaef().zza(new zzbgt(zzcjqVar, zze) { // from class: com.google.android.gms.internal.ads.zzcxl
                        private final zzbfi zzgji;
                        private final zzcjq zzgvr;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgvr = zzcjqVar;
                            this.zzgji = zze;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbgt
                        public final void zzam(boolean z2) {
                            zzcjq zzcjqVar2 = this.zzgvr;
                            zzbfi zzbfiVar3 = this.zzgji;
                            zzcjqVar2.zzaql();
                            zzbfiVar3.zzadz();
                            zzbfiVar3.zzaef().zzads();
                        }
                    });
                    zzbgu zzaef = zze.zzaef();
                    zze.getClass();
                    zzaef.zza(zzcxk.zzn(zze));
                    zze.zzb(zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui, null);
                    zzbfiVar = zze;
                    zzbfiVar.zzbe(true);
                    boolean zzad = !this.zzgvq ? this.zzgvp.zzad(false) : false;
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    com.google.android.gms.ads.internal.zzk zzkVar = new com.google.android.gms.ads.internal.zzk(zzad, com.google.android.gms.ads.internal.util.zzj.zzba(this.context), !this.zzgvq ? this.zzgvp.zzui() : false, !this.zzgvq ? this.zzgvp.zzuj() : 0.0f, -1, z, this.zzeux.zzfvy, this.zzeux.zzbpw);
                    com.google.android.gms.ads.internal.zzr.zzku();
                    com.google.android.gms.ads.internal.overlay.zzo.zza(context, new AdOverlayInfoParcel((zzve) null, zzcirVar.zzahz(), (com.google.android.gms.ads.internal.overlay.zzx) null, zzbfiVar, this.zzeux.zzhmq, this.zzbpj, this.zzeux.zzdxn, zzkVar, this.zzeux.zzhmh.zzdug, this.zzeux.zzhmh.zzdui, this.zzfzg.zzhny), true);
                }
            }
            zzbfiVar = zzbfiVar2;
            zzbfiVar.zzbe(true);
            if (!this.zzgvq) {
            }
            com.google.android.gms.ads.internal.zzr.zzkv();
            com.google.android.gms.ads.internal.zzk zzkVar2 = new com.google.android.gms.ads.internal.zzk(zzad, com.google.android.gms.ads.internal.util.zzj.zzba(this.context), !this.zzgvq ? this.zzgvp.zzui() : false, !this.zzgvq ? this.zzgvp.zzuj() : 0.0f, -1, z, this.zzeux.zzfvy, this.zzeux.zzbpw);
            com.google.android.gms.ads.internal.zzr.zzku();
            com.google.android.gms.ads.internal.overlay.zzo.zza(context, new AdOverlayInfoParcel((zzve) null, zzcirVar.zzahz(), (com.google.android.gms.ads.internal.overlay.zzx) null, zzbfiVar, this.zzeux.zzhmq, this.zzbpj, this.zzeux.zzdxn, zzkVar2, this.zzeux.zzhmh.zzdug, this.zzeux.zzhmh.zzdui, this.zzfzg.zzhny), true);
        } catch (zzbfu e2) {
            zzbao.zzc("", e2);
        }
    }
}
