package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaco extends zzgw implements zzacm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zza(zzacl zzaclVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaclVar);
        zzb(1, zzdp);
    }
}
