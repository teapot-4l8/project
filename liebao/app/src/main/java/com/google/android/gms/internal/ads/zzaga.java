package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaga extends zzgw implements zzafy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaga(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zza(zzafo zzafoVar, String str) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzafoVar);
        zzdp.writeString(str);
        zzb(1, zzdp);
    }
}
