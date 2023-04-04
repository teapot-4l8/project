package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcaq implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzdot> zzfvi;
    private final zzesn<zzdpm> zzfxn;
    private final zzcak zzgdr;

    private zzcaq(zzcak zzcakVar, zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzdpm> zzesnVar4) {
        this.zzgdr = zzcakVar;
        this.zzeyq = zzesnVar;
        this.zzfsw = zzesnVar2;
        this.zzfvi = zzesnVar3;
        this.zzfxn = zzesnVar4;
    }

    public static zzcaq zza(zzcak zzcakVar, zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzdpm> zzesnVar4) {
        return new zzcaq(zzcakVar, zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        final Context context = this.zzeyq.get();
        final zzbar zzbarVar = this.zzfsw.get();
        final zzdot zzdotVar = this.zzfvi.get();
        final zzdpm zzdpmVar = this.zzfxn.get();
        return (zzbzl) zzesg.zzbd(new zzbzl(new zzbuj(context, zzbarVar, zzdotVar, zzdpmVar) { // from class: com.google.android.gms.internal.ads.zzcan
            private final Context zzdbt;
            private final zzbar zzfxh;
            private final zzdot zzfxi;
            private final zzdpm zzfxj;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbt = context;
                this.zzfxh = zzbarVar;
                this.zzfxi = zzdotVar;
                this.zzfxj = zzdpmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbuj
            public final void onAdLoaded() {
                com.google.android.gms.ads.internal.zzr.zzlf().zzb(this.zzdbt, this.zzfxh.zzbrz, this.zzfxi.zzhmm.toString(), this.zzfxj.zzhny);
            }
        }, zzbat.zzekj));
    }
}
