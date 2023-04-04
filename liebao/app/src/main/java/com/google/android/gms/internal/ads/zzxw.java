package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzxw extends zzgy implements zzxt {
    public zzxw() {
        super("com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    public static zzxt zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
        if (queryLocalInterface instanceof zzxt) {
            return (zzxt) queryLocalInterface;
        }
        return new zzxv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            onAdMetadataChanged();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
