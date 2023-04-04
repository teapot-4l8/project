package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzapx extends zzgy implements zzapu {
    public zzapx() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zza(zzaog.zzaf(parcel.readStrongBinder()));
        } else if (i == 2) {
            zzdm(parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zzg((zzvh) zzgx.zza(parcel, zzvh.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
