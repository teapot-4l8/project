package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzauc extends zzgy implements zzaud {
    public zzauc() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((ParcelFileDescriptor) zzgx.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zza((com.google.android.gms.ads.internal.util.zzaq) zzgx.zza(parcel, com.google.android.gms.ads.internal.util.zzaq.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
