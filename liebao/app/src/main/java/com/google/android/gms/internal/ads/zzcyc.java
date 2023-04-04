package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyc implements zzcsz<zzbne> {
    private final zzdtg zzfzh;
    private final zzboa zzgwe;
    private final zzebs zzgzd;
    private final Context zzgzj;
    private final zzacm zzgzk;

    public zzcyc(Context context, zzboa zzboaVar, zzdtg zzdtgVar, zzebs zzebsVar, zzacm zzacmVar) {
        this.zzgzj = context;
        this.zzgwe = zzboaVar;
        this.zzfzh = zzdtgVar;
        this.zzgzd = zzebsVar;
        this.zzgzk = zzacmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (this.zzgzk == null || zzdotVar.zzhmh == null || zzdotVar.zzhmh.zzdui == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<zzbne> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        zzbnh zza = this.zzgwe.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzcyh(this, new View(this.zzgzj), null, zzcyf.zzgzo, zzdotVar.zzhmj.get(0)));
        return this.zzfzh.zzt(zzdth.CUSTOM_RENDER_SYN).zza(new zzdsq(this, new zzacj(zza.zzaik(), zzdotVar.zzhmh.zzdug, zzdotVar.zzhmh.zzdui)) { // from class: com.google.android.gms.internal.ads.zzcye
            private final zzcyc zzgzm;
            private final zzacj zzgzn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzm = this;
                this.zzgzn = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzdsq
            public final void run() {
                this.zzgzm.zza(this.zzgzn);
            }
        }, this.zzgzd).zzv(zzdth.CUSTOM_RENDER_ACK).zze(zzebh.zzag(zza.zzaii())).zzayi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzacj zzacjVar) {
        this.zzgzk.zza(zzacjVar);
    }
}
