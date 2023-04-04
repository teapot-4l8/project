package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzafu extends zzgw implements zzafs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final void zza(zzafg zzafgVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzafgVar);
        zzb(1, zzdp);
    }
}
