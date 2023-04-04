package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwm {
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzcjw zzgmx;
    private final zzdpz zzgnx;

    public zzcwm(zzdpz zzdpzVar, zzcjw zzcjwVar, zzcmb zzcmbVar, zzdtw zzdtwVar) {
        this.zzgnx = zzdpzVar;
        this.zzgmx = zzcjwVar;
        this.zzdje = zzcmbVar;
        this.zzdjf = zzdtwVar;
    }

    public final void zza(zzdoy zzdoyVar, zzdot zzdotVar, int i, @Nullable zzctd zzctdVar, long j) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzdtx zzw = zzdtx.zzgy("adapter_status").zzb(zzdoyVar).zzg(zzdotVar).zzw("adapter_l", String.valueOf(j)).zzw("sc", Integer.toString(i));
            if (zzctdVar != null) {
                zzw.zzw("arec", Integer.toString(zzctdVar.zzasv().errorCode));
                String zzgu = this.zzgnx.zzgu(zzctdVar.getMessage());
                if (zzgu != null) {
                    zzw.zzw("areec", zzgu);
                }
            }
            zzcjx zzi = this.zzgmx.zzi(zzdotVar.zzhmi);
            if (zzi != null) {
                zzw.zzw("ancn", zzi.zzdka);
                if (zzi.zzgmu != null) {
                    zzw.zzw("adapter_v", zzi.zzgmu.toString());
                }
                if (zzi.zzgmv != null) {
                    zzw.zzw("adapter_sv", zzi.zzgmv.toString());
                }
            }
            this.zzdjf.zzb(zzw);
            return;
        }
        zzcma zzs = this.zzdje.zzarp().zza(zzdoyVar).zzc(zzdotVar).zzs("action", "adapter_status").zzs("adapter_l", String.valueOf(j));
        zzs.zzs("sc", Integer.toString(i));
        if (zzctdVar != null) {
            zzs.zzs("arec", Integer.toString(zzctdVar.zzasv().errorCode));
            String zzgu2 = this.zzgnx.zzgu(zzctdVar.getMessage());
            if (zzgu2 != null) {
                zzs.zzs("areec", zzgu2);
            }
        }
        zzcjx zzi2 = this.zzgmx.zzi(zzdotVar.zzhmi);
        if (zzi2 != null) {
            zzs.zzs("ancn", zzi2.zzdka);
            if (zzi2.zzgmu != null) {
                zzs.zzs("adapter_v", zzi2.zzgmu.toString());
            }
            if (zzi2.zzgmv != null) {
                zzs.zzs("adapter_sv", zzi2.zzgmv.toString());
            }
        }
        zzs.zzarm();
    }
}
