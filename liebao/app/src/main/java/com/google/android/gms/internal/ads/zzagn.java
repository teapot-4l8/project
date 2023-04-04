package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzagn extends zzgw implements zzagl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagl
    public final void zza(zzags zzagsVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzagsVar);
        zzb(1, zzdp);
    }
}
