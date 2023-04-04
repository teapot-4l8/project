package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f6002a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6003b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6004c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f6002a = str;
        this.f6003b = str2;
        this.f6004c = str3;
    }

    public String toString() {
        return "plid:" + this.f6002a + " plV:" + this.f6003b + " plUUID:" + this.f6004c;
    }

    public PlugInBean(Parcel parcel) {
        this.f6002a = parcel.readString();
        this.f6003b = parcel.readString();
        this.f6004c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6002a);
        parcel.writeString(this.f6003b);
        parcel.writeString(this.f6004c);
    }
}
