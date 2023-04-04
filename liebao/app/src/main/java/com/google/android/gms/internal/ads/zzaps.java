package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzaps extends zzgy implements zzapt {
    public zzaps() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzvy();
        } else if (i == 3) {
            zzdm(parcel.readString());
        } else if (i != 4) {
            return false;
        } else {
            zzg((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
