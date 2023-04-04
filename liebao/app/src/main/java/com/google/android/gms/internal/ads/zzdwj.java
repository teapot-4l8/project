package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdwj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdwj> CREATOR = new zzdwi();
    private final int versionCode;
    private zzcf.zza zzhxc = null;
    private byte[] zzhxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdwj(int i, byte[] bArr) {
        this.versionCode = i;
        this.zzhxd = bArr;
        zzazi();
    }

    public final zzcf.zza zzazh() {
        if (!(this.zzhxc != null)) {
            try {
                this.zzhxc = zzcf.zza.zza(this.zzhxd, zzemn.zzbiv());
                this.zzhxd = null;
            } catch (zzenn | NullPointerException e2) {
                throw new IllegalStateException(e2);
            }
        }
        zzazi();
        return this.zzhxc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        byte[] bArr = this.zzhxd;
        if (bArr == null) {
            bArr = this.zzhxc.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final void zzazi() {
        if (this.zzhxc != null || this.zzhxd == null) {
            if (this.zzhxc == null || this.zzhxd != null) {
                if (this.zzhxc != null && this.zzhxd != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.zzhxc == null && this.zzhxd == null) {
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Impossible");
            }
        }
    }
}
