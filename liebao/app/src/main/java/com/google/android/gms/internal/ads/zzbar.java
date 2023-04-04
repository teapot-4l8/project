package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbar> CREATOR = new zzbau();
    public String zzbrz;
    public int zzeka;
    public int zzekb;
    public boolean zzekc;
    public boolean zzekd;

    public zzbar(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzbar(int i, int i2, boolean z, boolean z2) {
        this(204890000, i2, true, false, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private zzbar(int i, int i2, boolean z, boolean z2, boolean z3) {
        this(r0.toString(), i, i2, z, false);
        String str = z ? "0" : "1";
        StringBuilder sb = new StringBuilder(str.length() + 36);
        sb.append("afma-sdk-a-v");
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbar(String str, int i, int i2, boolean z, boolean z2) {
        this.zzbrz = str;
        this.zzeka = i;
        this.zzekb = i2;
        this.zzekc = z;
        this.zzekd = z2;
    }

    public static zzbar zzaau() {
        return new zzbar(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbrz, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzeka);
        SafeParcelWriter.writeInt(parcel, 4, this.zzekb);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzekc);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzekd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
