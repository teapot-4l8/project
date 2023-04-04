package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzmk implements Parcelable.Creator<zzmi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmi[] newArray(int i) {
        return new zzmi[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmi createFromParcel(Parcel parcel) {
        return new zzmi(parcel);
    }
}
