package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i) {
            return new StrategyBean[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static String f6016a = "http://rqd.uu.qq.com/rqd/sync";

    /* renamed from: b  reason: collision with root package name */
    public static String f6017b = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: c  reason: collision with root package name */
    public static String f6018c = "http://android.bugly.qq.com/rqd/async";

    /* renamed from: d  reason: collision with root package name */
    public static String f6019d;

    /* renamed from: e  reason: collision with root package name */
    public long f6020e;
    public long f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public long p;

    /* renamed from: q  reason: collision with root package name */
    public long f6021q;
    public String r;
    public String s;
    public String t;
    public String u;
    public Map<String, String> v;
    public int w;
    public long x;
    public long y;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.f6020e = -1L;
        this.f = -1L;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.f6021q = 30000L;
        this.r = f6017b;
        this.s = f6018c;
        this.t = f6016a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        this.f = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L");
        sb.append("@)");
        f6019d = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K");
        sb.append("@!");
        this.u = sb.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.f6020e = -1L;
        this.f = -1L;
        boolean z = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = true;
        this.f6021q = 30000L;
        this.r = f6017b;
        this.s = f6018c;
        this.t = f6016a;
        this.w = 10;
        this.x = 300000L;
        this.y = -1L;
        try {
            f6019d = "S(@L@L@)";
            this.f = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readByte() == 1;
            this.i = parcel.readByte() == 1;
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.u = parcel.readString();
            this.v = z.b(parcel);
            this.j = parcel.readByte() == 1;
            this.k = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.o = parcel.readByte() == 1;
            this.f6021q = parcel.readLong();
            this.l = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.m = z;
            this.p = parcel.readLong();
            this.w = parcel.readInt();
            this.x = parcel.readLong();
            this.y = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.u);
        z.b(parcel, this.v);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f6021q);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeInt(this.w);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
    }
}
