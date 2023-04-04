package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcts implements zzcsz<zzbne> {
    private final Context context;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcja zzgix;
    private final zzboa zzgwe;
    private final zzdxw<zzdot, com.google.android.gms.ads.internal.util.zzad> zzgwf;

    public zzcts(zzboa zzboaVar, Context context, Executor executor, zzcja zzcjaVar, zzdpm zzdpmVar, zzdxw<zzdot, com.google.android.gms.ads.internal.util.zzad> zzdxwVar) {
        this.context = context;
        this.zzgwe = zzboaVar;
        this.zzfur = executor;
        this.zzgix = zzcjaVar;
        this.zzfzg = zzdpmVar;
        this.zzgwf = zzdxwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (zzdotVar.zzhmh == null || zzdotVar.zzhmh.zzdui == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<zzbne> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        return zzebh.zzb(zzebh.zzag(null), new zzear(this, zzdpiVar, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzctv
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzcts zzgwg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwg = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgwg.zzb(this.zzgjy, this.zzfxi, obj);
            }
        }, this.zzfur);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzbfi zzbfiVar) {
        zzbfiVar.zzadz();
        zzbgc zzabv = zzbfiVar.zzabv();
        if (this.zzfzg.zzhnw == null || zzabv == null) {
            return;
        }
        zzabv.zzb(this.zzfzg.zzhnw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzb(zzdpi zzdpiVar, zzdot zzdotVar, Object obj) {
        View zzcjrVar;
        zzvt zzb = zzdpr.zzb(this.context, zzdotVar.zzhmj);
        zzbfi zza = this.zzgix.zza(zzb, zzdotVar, zzdpiVar.zzhnt.zzeuy);
        zza.zzbb(zzdotVar.zzdyj);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdaf)).booleanValue() && zzdotVar.zzadh) {
            zzcjrVar = zzbos.zza(this.context, zza.getView(), zzdotVar);
        } else {
            zzcjrVar = new zzcjr(this.context, zza.getView(), this.zzgwf.apply(zzdotVar));
        }
        zzboa zzboaVar = this.zzgwe;
        zzbps zzbpsVar = new zzbps(zzdpiVar, zzdotVar, null);
        zza.getClass();
        zzbnh zza2 = zzboaVar.zza(zzbpsVar, new zzbnl(zzcjrVar, zza, zzctu.zzm(zza), zzdpr.zzh(zzb)));
        zza2.zzahy().zza(zza, false, (zzaii) null);
        zza2.zzahk().zza(new zzbtq(zza) { // from class: com.google.android.gms.internal.ads.zzctx
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
        zzebt<?> zza3 = zzcjc.zza(zza, zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui);
        if (zzdotVar.zzead) {
            zza.getClass();
            zza3.addListener(zzctw.zze(zza), this.zzfur);
        }
        zza3.addListener(new Runnable(this, zza) { // from class: com.google.android.gms.internal.ads.zzctz
            private final zzbfi zzgji;
            private final zzcts zzgwg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwg = this;
                this.zzgji = zza;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgwg.zzl(this.zzgji);
            }
        }, this.zzfur);
        return zzebh.zzb(zza3, new zzdxw(zza2) { // from class: com.google.android.gms.internal.ads.zzcty
            private final zzbnh zzgwh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwh = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj2) {
                return this.zzgwh.zzaii();
            }
        }, zzbat.zzekj);
    }
}
