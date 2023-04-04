package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcuu extends zzavx implements zzbug {
    private zzavu zzgxa;
    private zzbuf zzgxb;
    private zzbzy zzgxc;

    public final synchronized void zza(zzavu zzavuVar) {
        this.zzgxa = zzavuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbug
    public final synchronized void zza(zzbuf zzbufVar) {
        this.zzgxb = zzbufVar;
    }

    public final synchronized void zza(zzbzy zzbzyVar) {
        this.zzgxc = zzbzyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzag(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzag(iObjectWrapper);
        }
        if (this.zzgxc != null) {
            this.zzgxc.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzgxa != null) {
            this.zzgxa.zzd(iObjectWrapper, i);
        }
        if (this.zzgxc != null) {
            this.zzgxc.zzeg(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzaj(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzavy zzavyVar) {
        if (this.zzgxa != null) {
            this.zzgxa.zza(iObjectWrapper, zzavyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzal(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzal(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzak(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzak(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzgxa != null) {
            this.zzgxa.zze(iObjectWrapper, i);
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzam(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzam(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzan(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzan(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzai(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzai(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzah(IObjectWrapper iObjectWrapper) {
        if (this.zzgxa != null) {
            this.zzgxa.zzah(iObjectWrapper);
        }
        if (this.zzgxb != null) {
            this.zzgxb.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final synchronized void zzb(Bundle bundle) {
        if (this.zzgxa != null) {
            this.zzgxa.zzb(bundle);
        }
    }
}
