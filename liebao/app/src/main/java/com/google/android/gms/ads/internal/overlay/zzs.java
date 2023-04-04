package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzs extends zze {
    public zzs(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zze, com.google.android.gms.internal.ads.zzash
    public final void onCreate(Bundle bundle) {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzdtk = zzl.OTHER;
        this.zzaax.finish();
    }
}
