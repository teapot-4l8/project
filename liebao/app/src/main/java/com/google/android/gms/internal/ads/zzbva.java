package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbva extends zzbxq<zzbvb> implements zzbtq, zzbus {
    private final zzdot zzftr;
    private AtomicBoolean zzgbw;

    public zzbva(Set<zzbzl<zzbvb>> set, zzdot zzdotVar) {
        super(set);
        this.zzgbw = new AtomicBoolean();
        this.zzftr = zzdotVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        if (this.zzftr.zzhlz == 2 || this.zzftr.zzhlz == 5 || this.zzftr.zzhlz == 4 || this.zzftr.zzhlz == 6) {
            zzaml();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzamk() {
        if (this.zzftr.zzhlz == 1) {
            zzaml();
        }
    }

    private final void zzaml() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdae)).booleanValue() && this.zzgbw.compareAndSet(false, true) && this.zzftr.zzhmw != null && this.zzftr.zzhmw.type == 3) {
            zza(new zzbxs(this) { // from class: com.google.android.gms.internal.ads.zzbuz
                private final zzbva zzgbv;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgbv = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbxs
                public final void zzo(Object obj) {
                    this.zzgbv.zza((zzbvb) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbvb zzbvbVar) {
        zzbvbVar.zzb(this.zzftr.zzhmw);
    }
}
