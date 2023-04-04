package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavt> CREATOR = new zzavs();
    public final String zzbvf;
    public final zzvq zzdvn;

    public zzavt(zzvq zzvqVar, String str) {
        this.zzdvn = zzvqVar;
        this.zzbvf = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdvn, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbvf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
