package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzagf extends zzgw implements zzagd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final void zza(zzafo zzafoVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzafoVar);
        zzb(1, zzdp);
    }
}
