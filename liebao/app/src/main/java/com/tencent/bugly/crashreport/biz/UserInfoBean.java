package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i) {
            return new UserInfoBean[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public long f5975a;

    /* renamed from: b  reason: collision with root package name */
    public int f5976b;

    /* renamed from: c  reason: collision with root package name */
    public String f5977c;

    /* renamed from: d  reason: collision with root package name */
    public String f5978d;

    /* renamed from: e  reason: collision with root package name */
    public long f5979e;
    public long f;
    public long g;
    public long h;
    public long i;
    public String j;
    public long k;
    public boolean l;
    public String m;
    public String n;
    public int o;
    public int p;

    /* renamed from: q  reason: collision with root package name */
    public int f5980q;
    public Map<String, String> r;
    public Map<String, String> s;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserInfoBean() {
        this.k = 0L;
        this.l = false;
        this.m = "unknown";
        this.p = -1;
        this.f5980q = -1;
        this.r = null;
        this.s = null;
    }

    public UserInfoBean(Parcel parcel) {
        this.k = 0L;
        this.l = false;
        this.m = "unknown";
        this.p = -1;
        this.f5980q = -1;
        this.r = null;
        this.s = null;
        this.f5976b = parcel.readInt();
        this.f5977c = parcel.readString();
        this.f5978d = parcel.readString();
        this.f5979e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        this.h = parcel.readLong();
        this.i = parcel.readLong();
        this.j = parcel.readString();
        this.k = parcel.readLong();
        this.l = parcel.readByte() == 1;
        this.m = parcel.readString();
        this.p = parcel.readInt();
        this.f5980q = parcel.readInt();
        this.r = z.b(parcel);
        this.s = z.b(parcel);
        this.n = parcel.readString();
        this.o = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5976b);
        parcel.writeString(this.f5977c);
        parcel.writeString(this.f5978d);
        parcel.writeLong(this.f5979e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
        parcel.writeLong(this.i);
        parcel.writeString(this.j);
        parcel.writeLong(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.f5980q);
        z.b(parcel, this.r);
        z.b(parcel, this.s);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
    }
}
