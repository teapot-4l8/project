package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzafz extends zzgw implements zzafx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(zzafk zzafkVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzafkVar);
        zzb(1, zzdp);
    }
}
