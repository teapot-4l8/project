package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzajs extends zzgy implements zzajt {
    public zzajs() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzajt zzaa(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzajt) {
            return (zzajt) queryLocalInterface;
        }
        return new zzajv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zze(parcel.createTypedArrayList(zzajm.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
