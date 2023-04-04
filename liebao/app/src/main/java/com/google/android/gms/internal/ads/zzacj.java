package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzacj extends zzack {
    private final com.google.android.gms.ads.internal.zzg zzdcq;
    private final String zzdcr;
    private final String zzdcs;

    public zzacj(com.google.android.gms.ads.internal.zzg zzgVar, String str, String str2) {
        this.zzdcq = zzgVar;
        this.zzdcr = str;
        this.zzdcs = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final String zzsy() {
        return this.zzdcr;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final String getContent() {
        return this.zzdcs;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.zzdcq.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void recordClick() {
        this.zzdcq.zzkg();
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void recordImpression() {
        this.zzdcq.zzkh();
    }
}
