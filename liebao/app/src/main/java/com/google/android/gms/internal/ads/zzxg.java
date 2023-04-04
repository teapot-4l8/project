package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzxg extends zzgy implements zzxd {
    public zzxg() {
        super("com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            onAdLoaded();
        } else if (i != 2) {
            return false;
        } else {
            zzd((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
