package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbxr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdax implements zzdat<zzbpc> {
    private final zzbhh zzgxu;
    private final Context zzham;
    private final zzdpo zzhan;
    private final zzdar zzhca;
    private zzbpn zzhcb;

    public zzdax(zzbhh zzbhhVar, Context context, zzdar zzdarVar, zzdpo zzdpoVar) {
        this.zzgxu = zzbhhVar;
        this.zzham = context;
        this.zzhca = zzdarVar;
        this.zzhan = zzdpoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean isLoading() {
        zzbpn zzbpnVar = this.zzhcb;
        return zzbpnVar != null && zzbpnVar.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzdat
    public final boolean zza(zzvq zzvqVar, String str, zzdas zzdasVar, zzdav<? super zzbpc> zzdavVar) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzbc(this.zzham) && zzvqVar.zzcip == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Failed to load the ad because app ID is missing.");
            this.zzgxu.zzafv().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdaw
                private final zzdax zzhbz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhbz = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhbz.zzatp();
                }
            });
            return false;
        } else if (str == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Ad unit ID should not be null for NativeAdLoader.");
            this.zzgxu.zzafv().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdaz
                private final zzdax zzhbz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhbz = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhbz.zzato();
                }
            });
            return false;
        } else {
            zzdqa.zze(this.zzham, zzvqVar.zzcid);
            zzccf zzahf = this.zzgxu.zzagj().zza(new zzbsj.zza().zzci(this.zzham).zza(this.zzhan.zzh(zzvqVar).zzem(zzdasVar instanceof zzdau ? ((zzdau) zzdasVar).zzhby : 1).zzawg()).zzami()).zza(new zzbxr.zza().zzanf()).zza(this.zzhca.zzatk()).zza(new zzbnd(null)).zzahf();
            this.zzgxu.zzagp().ensureSize(1);
            zzbpn zzbpnVar = new zzbpn(this.zzgxu.zzafx(), this.zzgxu.zzafw(), zzahf.zzahd().zzalv());
            this.zzhcb = zzbpnVar;
            zzbpnVar.zza(new zzday(this, zzdavVar, zzahf));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzato() {
        this.zzhca.zzatn().zzd(zzdqh.zza(zzdqj.INVALID_AD_UNIT_ID, null, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzatp() {
        this.zzhca.zzatn().zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, null, null));
    }
}
