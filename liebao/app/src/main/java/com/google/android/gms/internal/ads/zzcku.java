package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcku implements zzbsz, zzbtq, zzbuj, zzbvm, zzbxn, zzve {
    private final zztz zzgnj;
    private boolean zzgnk = false;

    public zzcku(zztz zztzVar, @Nullable zzdmp zzdmpVar) {
        this.zzgnj = zztzVar;
        zztzVar.zza(zzub.zza.zzb.AD_REQUEST);
        if (zzdmpVar != null) {
            zztzVar.zza(zzub.zza.zzb.REQUEST_IS_PREFETCH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(final zzdpi zzdpiVar) {
        this.zzgnj.zza(new zzty(zzdpiVar) { // from class: com.google.android.gms.internal.ads.zzckx
            private final zzdpi zzgbz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbz = zzdpiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzty
            public final void zza(zzuh.zzi.zza zzaVar) {
                zzaVar.zza(zzaVar.zzok().zzbji().zza(zzaVar.zzok().zzno().zzbji().zzbt(this.zzgbz.zzhnt.zzeuy.zzbwe)));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        this.zzgnj.zza(zzub.zza.zzb.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        switch (zzvhVar.errorCode) {
            case 1:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zzgnj.zza(zzub.zza.zzb.AD_FAILED_TO_LOAD);
                return;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final synchronized void onAdImpression() {
        this.zzgnj.zza(zzub.zza.zzb.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final synchronized void onAdClicked() {
        if (!this.zzgnk) {
            this.zzgnj.zza(zzub.zza.zzb.AD_FIRST_CLICK);
            this.zzgnk = true;
            return;
        }
        this.zzgnj.zza(zzub.zza.zzb.AD_SUBSEQUENT_CLICK);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void zzc(final zzuh.zzb zzbVar) {
        this.zzgnj.zza(new zzty(zzbVar) { // from class: com.google.android.gms.internal.ads.zzckw
            private final zzuh.zzb zzgck;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgck = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzty
            public final void zza(zzuh.zzi.zza zzaVar) {
                zzaVar.zza(this.zzgck);
            }
        });
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_LOADED_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void zzd(final zzuh.zzb zzbVar) {
        this.zzgnj.zza(new zzty(zzbVar) { // from class: com.google.android.gms.internal.ads.zzckz
            private final zzuh.zzb zzgck;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgck = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzty
            public final void zza(zzuh.zzi.zza zzaVar) {
                zzaVar.zza(this.zzgck);
            }
        });
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_SAVED_TO_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void zze(final zzuh.zzb zzbVar) {
        this.zzgnj.zza(new zzty(zzbVar) { // from class: com.google.android.gms.internal.ads.zzcky
            private final zzuh.zzb zzgck;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgck = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzty
            public final void zza(zzuh.zzi.zza zzaVar) {
                zzaVar.zza(this.zzgck);
            }
        });
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_PREFETCH_INTERCEPTED);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void zzbj(boolean z) {
        zzub.zza.zzb zzbVar;
        zztz zztzVar = this.zzgnj;
        if (z) {
            zzbVar = zzub.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zzbVar = zzub.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zztzVar.zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void zzbk(boolean z) {
        zzub.zza.zzb zzbVar;
        zztz zztzVar = this.zzgnj;
        if (z) {
            zzbVar = zzub.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zzbVar = zzub.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zztzVar.zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void zzamr() {
        this.zzgnj.zza(zzub.zza.zzb.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }
}
