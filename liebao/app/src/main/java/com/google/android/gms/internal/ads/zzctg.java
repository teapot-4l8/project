package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzctg implements zzcsz<zzbmz> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzbmt zzgvo;
    private final zzail zzgvp;
    private final boolean zzgvq = ((Boolean) zzww.zzra().zzd(zzabq.zzdbr)).booleanValue();

    public zzctg(zzbmt zzbmtVar, Context context, Executor executor, zzcja zzcjaVar, zzdpm zzdpmVar, zzbar zzbarVar, zzail zzailVar) {
        this.context = context;
        this.zzgvo = zzbmtVar;
        this.zzfur = executor;
        this.zzgix = zzcjaVar;
        this.zzfzg = zzdpmVar;
        this.zzbpj = zzbarVar;
        this.zzgvp = zzailVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (zzdotVar.zzhmh == null || zzdotVar.zzhmh.zzdui == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<zzbmz> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        zzcjq zzcjqVar = new zzcjq();
        zzebt<zzbmz> zzb = zzebh.zzb(zzebh.zzag(null), new zzear(this, zzdotVar, zzdpiVar, zzcjqVar) { // from class: com.google.android.gms.internal.ads.zzctj
            private final zzctg zzgvs;
            private final zzdot zzgvt;
            private final zzdpi zzgvu;
            private final zzcjq zzgvv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgvs = this;
                this.zzgvt = zzdotVar;
                this.zzgvu = zzdpiVar;
                this.zzgvv = zzcjqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgvs.zza(this.zzgvt, this.zzgvu, this.zzgvv, obj);
            }
        }, this.zzfur);
        zzcjqVar.getClass();
        zzb.addListener(zzcti.zza(zzcjqVar), this.zzfur);
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(final zzdot zzdotVar, zzdpi zzdpiVar, zzcjq zzcjqVar, Object obj) {
        final zzbfi zza = this.zzgix.zza(this.zzfzg.zzbpy, zzdotVar, zzdpiVar.zzhnt.zzeuy);
        zza.zzbb(zzdotVar.zzdyj);
        zzcjqVar.zzc(this.context, zza.getView());
        zzbbe zzbbeVar = new zzbbe();
        final zzbmr zza2 = this.zzgvo.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzcak(new zzctm(this.zzbpj, zzbbeVar, zzdotVar, zza, this.zzfzg, this.zzgvq, this.zzgvp), zza), new zzbmq(zzdotVar.zzfvw));
        zza2.zzahy().zza(zza, false, (zzaii) (this.zzgvq ? this.zzgvp : null));
        zzbbeVar.set(zza2);
        zza2.zzahk().zza(new zzbtq(zza) { // from class: com.google.android.gms.internal.ads.zzctl
            private final zzbfi zzewn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzewn = zza;
            }

            @Override // com.google.android.gms.internal.ads.zzbtq
            public final void onAdImpression() {
                zzbfi zzbfiVar = this.zzewn;
                if (zzbfiVar.zzaef() != null) {
                    zzbfiVar.zzaef().zzads();
                }
            }
        }, zzbat.zzekj);
        zza2.zzahy();
        return zzebh.zzb(zzcjc.zza(zza, zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui), new zzdxw(this, zza, zzdotVar, zza2) { // from class: com.google.android.gms.internal.ads.zzctk
            private final zzdot zzfxi;
            private final zzbfi zzgji;
            private final zzctg zzgvs;
            private final zzbmr zzgvw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgvs = this;
                this.zzgji = zza;
                this.zzfxi = zzdotVar;
                this.zzgvw = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj2) {
                zzbfi zzbfiVar = this.zzgji;
                zzdot zzdotVar2 = this.zzfxi;
                zzbmr zzbmrVar = this.zzgvw;
                if (zzdotVar2.zzead) {
                    zzbfiVar.zzaes();
                }
                zzbfiVar.zzadz();
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpo)).booleanValue()) {
                    zzbfiVar.onPause();
                }
                return zzbmrVar.zzahx();
            }
        }, this.zzfur);
    }
}
