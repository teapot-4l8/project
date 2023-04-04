package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcki implements zzesa<zztz> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzuh.zza.EnumC0120zza> zzfvk;
    private final zzesn<String> zzgaw;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<String> zzgnd;

    private zzcki(zzesn<Context> zzesnVar, zzesn<String> zzesnVar2, zzesn<zzbar> zzesnVar3, zzesn<zzuh.zza.EnumC0120zza> zzesnVar4, zzesn<String> zzesnVar5) {
        this.zzeyq = zzesnVar;
        this.zzgaw = zzesnVar2;
        this.zzgbl = zzesnVar3;
        this.zzfvk = zzesnVar4;
        this.zzgnd = zzesnVar5;
    }

    public static zzcki zze(zzesn<Context> zzesnVar, zzesn<String> zzesnVar2, zzesn<zzbar> zzesnVar3, zzesn<zzuh.zza.EnumC0120zza> zzesnVar4, zzesn<String> zzesnVar5) {
        return new zzcki(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        String str = this.zzgaw.get();
        zzbar zzbarVar = this.zzgbl.get();
        zzuh.zza.EnumC0120zza enumC0120zza = this.zzfvk.get();
        String str2 = this.zzgnd.get();
        zztz zztzVar = new zztz(new zzue(this.zzeyq.get()));
        zztzVar.zza(new zzty(enumC0120zza, str, (zzuh.zzu) ((zzena) zzuh.zzu.zzpt().zzcq(zzbarVar.zzeka).zzcr(zzbarVar.zzekb).zzcs(zzbarVar.zzekc ? 0 : 2).zzbjv()), str2) { // from class: com.google.android.gms.internal.ads.zzckj
            private final String zzdkl;
            private final zzuh.zza.EnumC0120zza zzgne;
            private final zzuh.zzu zzgnf;
            private final String zzgng;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgne = enumC0120zza;
                this.zzdkl = str;
                this.zzgnf = r3;
                this.zzgng = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzty
            public final void zza(zzuh.zzi.zza zzaVar) {
                zzuh.zza.EnumC0120zza enumC0120zza2 = this.zzgne;
                String str3 = this.zzdkl;
                zzuh.zzu zzuVar = this.zzgnf;
                zzaVar.zza(zzaVar.zzok().zzbji().zzb(enumC0120zza2)).zza(zzaVar.zzoj().zzbji().zzbv(str3).zza(zzuVar)).zzbx(this.zzgng);
            }
        });
        return (zztz) zzesg.zzbd(zztzVar);
    }
}
