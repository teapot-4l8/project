package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzawm extends zzgy implements zzawn {
    public zzawm() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            onRewardedAdLoaded();
        } else if (i == 2) {
            onRewardedAdFailedToLoad(parcel.readInt());
        } else if (i != 3) {
            return false;
        } else {
            zzj((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
