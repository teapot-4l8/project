package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbru implements zzesa<zzdxw<zzdot, com.google.android.gms.ads.internal.util.zzad>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzdpm> zzfxn;

    public zzbru(zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzdpm> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzfsw = zzesnVar2;
        this.zzfxn = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzdxw) zzesg.zzbd(new zzdxw(this.zzeyq.get(), this.zzfsw.get(), this.zzfxn.get()) { // from class: com.google.android.gms.internal.ads.zzbrv
            private final Context zzdbt;
            private final zzbar zzfxh;
            private final zzdpm zzgaf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbt = r1;
                this.zzfxh = r2;
                this.zzgaf = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                Context context = this.zzdbt;
                zzbar zzbarVar = this.zzfxh;
                zzdpm zzdpmVar = this.zzgaf;
                zzdot zzdotVar = (zzdot) obj;
                com.google.android.gms.ads.internal.util.zzad zzadVar = new com.google.android.gms.ads.internal.util.zzad(context);
                zzadVar.zzeo(zzdotVar.zzdxn);
                zzadVar.zzep(zzdotVar.zzhmm.toString());
                zzadVar.zzu(zzbarVar.zzbrz);
                zzadVar.setAdUnitId(zzdpmVar.zzhny);
                return zzadVar;
            }
        });
    }
}
