package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzmh implements Parcelable {
    public static final Parcelable.Creator<zzmh> CREATOR = new zzmg();
    private final zza[] zzbdr;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public interface zza extends Parcelable {
    }

    public zzmh(List<? extends zza> list) {
        zza[] zzaVarArr = new zza[list.size()];
        this.zzbdr = zzaVarArr;
        list.toArray(zzaVarArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmh(Parcel parcel) {
        this.zzbdr = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaVarArr = this.zzbdr;
            if (i >= zzaVarArr.length) {
                return;
            }
            zzaVarArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
            i++;
        }
    }

    public final int length() {
        return this.zzbdr.length;
    }

    public final zza zzbb(int i) {
        return this.zzbdr[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbdr, ((zzmh) obj).zzbdr);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzbdr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbdr.length);
        for (zza zzaVar : this.zzbdr) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }
}
