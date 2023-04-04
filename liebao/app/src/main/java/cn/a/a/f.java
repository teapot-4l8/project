package cn.a.a;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
final class f implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        return new a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ a[] newArray(int i) {
        return new a[i];
    }
}
