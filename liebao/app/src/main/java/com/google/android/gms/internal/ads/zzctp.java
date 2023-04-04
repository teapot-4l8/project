package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzctp implements zzcsz<zzbmp> {
    private final Context context;
    private final Executor zzfur;
    private final zzcja zzgix;
    private final zzbmg zzgwc;

    public zzctp(zzbmg zzbmgVar, Context context, Executor executor, zzcja zzcjaVar) {
        this.context = context;
        this.zzgwc = zzbmgVar;
        this.zzfur = executor;
        this.zzgix = zzcjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (zzdotVar.zzhmh == null || zzdotVar.zzhmh.zzdui == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<zzbmp> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        return zzebh.zzb(zzebh.zzag(null), new zzear(this, zzdpiVar, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcto
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzctp zzgwb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwb = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgwb.zza(this.zzgjy, this.zzfxi, obj);
            }
        }, this.zzfur);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzdpi zzdpiVar, zzdot zzdotVar, Object obj) {
        zzvt zzb = zzdpr.zzb(this.context, zzdotVar.zzhmj);
        zzbfi zza = this.zzgix.zza(zzb, zzdotVar, zzdpiVar.zzhnt.zzeuy);
        zzbly zza2 = this.zzgwc.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzbmb(zza.getView(), zza, zzdpr.zzh(zzb), zzdotVar.zzfvw, zzdotVar.zzfvx, zzdotVar.zzfvy));
        zza2.zzahy().zza(zza, false, (zzaii) null);
        zza2.zzahk().zza(new zzbtq(zza) { // from class: com.google.android.gms.internal.ads.zzctr
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
        return zzebh.zzb(zzcjc.zza(zza, zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui), new zzdxw(zza2) { // from class: com.google.android.gms.internal.ads.zzctq
            private final zzbly zzgwd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwd = zza2;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj2) {
                return this.zzgwd.zzaid();
            }
        }, zzbat.zzekj);
    }
}
