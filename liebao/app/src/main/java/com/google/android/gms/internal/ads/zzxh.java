package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzxh extends zzgy implements zzxi {
    public zzxh() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((zzvq) zzgx.zza(parcel, zzvq.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i == 3) {
            boolean isLoading = isLoading();
            parcel2.writeNoException();
            zzgx.writeBoolean(parcel2, isLoading);
        } else if (i == 4) {
            String zzkl = zzkl();
            parcel2.writeNoException();
            parcel2.writeString(zzkl);
        } else if (i != 5) {
            return false;
        } else {
            zza((zzvq) zzgx.zza(parcel, zzvq.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
