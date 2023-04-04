package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzza extends zzgy implements zzyx {
    public zzza() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzyx zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzyx) {
            return (zzyx) queryLocalInterface;
        }
        return new zzyz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zza((zzvv) zzgx.zza(parcel, zzvv.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
