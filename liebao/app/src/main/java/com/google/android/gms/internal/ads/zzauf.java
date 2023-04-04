package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzauf extends zzgw implements zzaud {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzauf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, parcelFileDescriptor);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final void zza(com.google.android.gms.ads.internal.util.zzaq zzaqVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaqVar);
        zzb(2, zzdp);
    }
}
