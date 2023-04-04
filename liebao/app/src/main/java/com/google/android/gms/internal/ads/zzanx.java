package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzanx extends zzgy implements zzanu {
    public zzanx() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public static zzanu zzae(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
        if (queryLocalInterface instanceof zzanu) {
            return (zzanu) queryLocalInterface;
        }
        return new zzanw(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            IObjectWrapper zzve = zzve();
            parcel2.writeNoException();
            zzgx.zza(parcel2, zzve);
        } else if (i != 2) {
            return false;
        } else {
            boolean shouldDelegateInterscrollerEffect = shouldDelegateInterscrollerEffect();
            parcel2.writeNoException();
            zzgx.writeBoolean(parcel2, shouldDelegateInterscrollerEffect);
        }
        return true;
    }
}
