package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazd extends zzgw implements zzazb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void zzj(String str, String str2) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void onError(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void zza(String str, String str2, Bundle bundle) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzgx.zza(zzdp, bundle);
        zzb(3, zzdp);
    }
}
