package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchb {
    private final Executor zzfur;
    private final zzbzk zzget;
    private final zzblv zzgky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzchb(Executor executor, zzblv zzblvVar, zzbzk zzbzkVar) {
        this.zzfur = executor;
        this.zzget = zzbzkVar;
        this.zzgky = zzblvVar;
    }

    public final void zzi(final zzbfi zzbfiVar) {
        if (zzbfiVar == null) {
            return;
        }
        this.zzget.zzv(zzbfiVar.getView());
        this.zzget.zza(new zzqw(zzbfiVar) { // from class: com.google.android.gms.internal.ads.zzcha
            private final zzbfi zzewn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzewn = zzbfiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqw
            public final void zza(zzqx zzqxVar) {
                this.zzewn.zzaef().zza(zzqxVar.zzbsh.left, zzqxVar.zzbsh.top, false);
            }
        }, this.zzfur);
        this.zzget.zza(new zzqw(zzbfiVar) { // from class: com.google.android.gms.internal.ads.zzchd
            private final zzbfi zzewn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzewn = zzbfiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqw
            public final void zza(zzqx zzqxVar) {
                zzbfi zzbfiVar2 = this.zzewn;
                HashMap hashMap = new HashMap();
                hashMap.put("isVisible", zzqxVar.zzbrt ? "1" : "0");
                zzbfiVar2.zza("onAdVisibilityChanged", hashMap);
            }
        }, this.zzfur);
        this.zzget.zza(this.zzgky, this.zzfur);
        this.zzgky.zzd(zzbfiVar);
        zzbfiVar.zza("/trackActiveViewUnit", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzchc
            private final zzchb zzgkz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkz = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgkz.zzg((zzbfi) obj, map);
            }
        });
        zzbfiVar.zza("/untrackActiveViewUnit", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzchf
            private final zzchb zzgkz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkz = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgkz.zzf((zzbfi) obj, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbfi zzbfiVar, Map map) {
        this.zzgky.disable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzbfi zzbfiVar, Map map) {
        this.zzgky.enable();
    }
}
