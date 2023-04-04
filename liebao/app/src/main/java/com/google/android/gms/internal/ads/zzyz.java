package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzyz extends zzgw implements zzyx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    public final void zza(zzvv zzvvVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzvvVar);
        zzb(1, zzdp);
    }
}
