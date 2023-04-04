package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzmq implements Parcelable.Creator<zzmn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmn[] newArray(int i) {
        return new zzmn[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzmn createFromParcel(Parcel parcel) {
        return new zzmn(parcel);
    }
}
