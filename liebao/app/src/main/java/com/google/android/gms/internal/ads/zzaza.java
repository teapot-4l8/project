package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzaza extends zzgy implements zzazb {
    public zzaza() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzj(parcel.readString(), parcel.readString());
        } else if (i == 2) {
            onError(parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zza(parcel.readString(), parcel.readString(), (Bundle) zzgx.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
