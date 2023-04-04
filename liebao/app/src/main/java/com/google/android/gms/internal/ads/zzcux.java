package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcux implements zzcsz<zzcaj> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzail zzgvp;
    private final boolean zzgvq = ((Boolean) zzww.zzra().zzd(zzabq.zzdbr)).booleanValue();
    private final zzcbj zzgwq;

    public zzcux(Context context, zzbar zzbarVar, zzdpm zzdpmVar, Executor executor, zzcbj zzcbjVar, zzcja zzcjaVar, zzail zzailVar) {
        this.context = context;
        this.zzfzg = zzdpmVar;
        this.zzgwq = zzcbjVar;
        this.zzfur = executor;
        this.zzbpj = zzbarVar;
        this.zzgix = zzcjaVar;
        this.zzgvp = zzailVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (zzdotVar.zzhmh == null || zzdotVar.zzhmh.zzdui == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<zzcaj> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        zzcjq zzcjqVar = new zzcjq();
        zzebt<zzcaj> zzb = zzebh.zzb(zzebh.zzag(null), new zzear(this, zzdotVar, zzdpiVar, zzcjqVar) { // from class: com.google.android.gms.internal.ads.zzcuw
            private final zzdot zzgvt;
            private final zzdpi zzgvu;
            private final zzcjq zzgvv;
            private final zzcux zzgxd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxd = this;
                this.zzgvt = zzdotVar;
                this.zzgvu = zzdpiVar;
                this.zzgvv = zzcjqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgxd.zzb(this.zzgvt, this.zzgvu, this.zzgvv, obj);
            }
        }, this.zzfur);
        zzcjqVar.getClass();
        zzb.addListener(zzcuz.zza(zzcjqVar), this.zzfur);
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzb(final zzdot zzdotVar, zzdpi zzdpiVar, zzcjq zzcjqVar, Object obj) {
        final zzbfi zza = this.zzgix.zza(this.zzfzg.zzbpy, zzdotVar, zzdpiVar.zzhnt.zzeuy);
        zza.zzbb(zzdotVar.zzdyj);
        zzcjqVar.zzc(this.context, zza.getView());
        zzbbe zzbbeVar = new zzbbe();
        final zzcal zza2 = this.zzgwq.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzcak(new zzcvd(this.context, this.zzbpj, zzbbeVar, zzdotVar, zza, this.zzfzg, this.zzgvq, this.zzgvp), zza));
        zzbbeVar.set(zza2);
        zza2.zzahk().zza(new zzbtq(zza) { // from class: com.google.android.gms.internal.ads.zzcuy
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
        zza2.zzahy().zza(zza, true, (zzaii) (this.zzgvq ? this.zzgvp : null));
        zza2.zzahy();
        return zzebh.zzb(zzcjc.zza(zza, zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui), new zzdxw(this, zza, zzdotVar, zza2) { // from class: com.google.android.gms.internal.ads.zzcvb
            private final zzdot zzfxi;
            private final zzbfi zzgji;
            private final zzcux zzgxd;
            private final zzcal zzgxe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxd = this;
                this.zzgji = zza;
                this.zzfxi = zzdotVar;
                this.zzgxe = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj2) {
                zzbfi zzbfiVar = this.zzgji;
                zzdot zzdotVar2 = this.zzfxi;
                zzcal zzcalVar = this.zzgxe;
                if (zzdotVar2.zzead) {
                    zzbfiVar.zzaes();
                }
                zzbfiVar.zzadz();
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpo)).booleanValue()) {
                    zzbfiVar.onPause();
                }
                return zzcalVar.zzait();
            }
        }, this.zzfur);
    }
}
