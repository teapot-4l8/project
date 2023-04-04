package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxc implements zzcsz<zzcip> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzail zzgvp;
    private final boolean zzgvq = ((Boolean) zzww.zzra().zzd(zzabq.zzdbr)).booleanValue();
    private final zzcis zzgyj;

    public zzcxc(Context context, zzbar zzbarVar, zzdpm zzdpmVar, Executor executor, zzcis zzcisVar, zzcja zzcjaVar, zzail zzailVar) {
        this.context = context;
        this.zzfzg = zzdpmVar;
        this.zzgyj = zzcisVar;
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
    public final zzebt<zzcip> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        zzcjq zzcjqVar = new zzcjq();
        zzebt<zzcip> zzb = zzebh.zzb(zzebh.zzag(null), new zzear(this, zzdotVar, zzdpiVar, zzcjqVar) { // from class: com.google.android.gms.internal.ads.zzcxf
            private final zzdot zzgvt;
            private final zzdpi zzgvu;
            private final zzcjq zzgvv;
            private final zzcxc zzgyn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgyn = this;
                this.zzgvt = zzdotVar;
                this.zzgvu = zzdpiVar;
                this.zzgvv = zzcjqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgyn.zzc(this.zzgvt, this.zzgvu, this.zzgvv, obj);
            }
        }, this.zzfur);
        zzcjqVar.getClass();
        zzb.addListener(zzcxe.zza(zzcjqVar), this.zzfur);
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzc(final zzdot zzdotVar, zzdpi zzdpiVar, zzcjq zzcjqVar, Object obj) {
        final zzbfi zza = this.zzgix.zza(this.zzfzg.zzbpy, zzdotVar, zzdpiVar.zzhnt.zzeuy);
        zza.zzbb(zzdotVar.zzdyj);
        zzcjqVar.zzc(this.context, zza.getView());
        zzbbe zzbbeVar = new zzbbe();
        final zzcir zza2 = this.zzgyj.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzciq(new zzcxi(this.context, this.zzgix, this.zzfzg, this.zzbpj, zzdotVar, zzbbeVar, zza, this.zzgvp, this.zzgvq), zza));
        zzbbeVar.set(zza2);
        zzaix.zza(zza, zza2.zzajb());
        zza2.zzahk().zza(new zzbtq(zza) { // from class: com.google.android.gms.internal.ads.zzcxh
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
        return zzebh.zzb(zzcjc.zza(zza, zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui), new zzdxw(this, zza, zzdotVar, zza2) { // from class: com.google.android.gms.internal.ads.zzcxg
            private final zzdot zzfxi;
            private final zzbfi zzgji;
            private final zzcxc zzgyn;
            private final zzcir zzgyo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgyn = this;
                this.zzgji = zza;
                this.zzfxi = zzdotVar;
                this.zzgyo = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj2) {
                zzbfi zzbfiVar = this.zzgji;
                zzdot zzdotVar2 = this.zzfxi;
                zzcir zzcirVar = this.zzgyo;
                if (zzdotVar2.zzead) {
                    zzbfiVar.zzaes();
                }
                zzbfiVar.zzadz();
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcpo)).booleanValue()) {
                    zzbfiVar.onPause();
                }
                return zzcirVar.zzaja();
            }
        }, this.zzfur);
    }
}
