package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzack extends zzgy implements zzacl {
    public zzack() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String zzsy = zzsy();
            parcel2.writeNoException();
            parcel2.writeString(zzsy);
        } else if (i == 2) {
            String content = getContent();
            parcel2.writeNoException();
            parcel2.writeString(content);
        } else if (i == 3) {
            zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i == 4) {
            recordClick();
            parcel2.writeNoException();
        } else if (i != 5) {
            return false;
        } else {
            recordImpression();
            parcel2.writeNoException();
        }
        return true;
    }
}
