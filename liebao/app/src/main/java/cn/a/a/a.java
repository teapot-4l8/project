package cn.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    public String f3587a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f3588b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Parcel parcel) {
        this.f3587a = parcel.readString();
        this.f3588b = parcel.readBundle();
    }

    public a(String str, Bundle bundle) {
        this.f3587a = str;
        this.f3588b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3587a);
        parcel.writeBundle(this.f3588b);
    }
}
