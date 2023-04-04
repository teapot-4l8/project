package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzyn extends zzgy implements zzyo {
    public zzyn() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    public static zzyo zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdListener");
        if (queryLocalInterface instanceof zzyo) {
            return (zzyo) queryLocalInterface;
        }
        return new zzyq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            onAdMuted();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
