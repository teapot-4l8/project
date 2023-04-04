package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.z;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i) {
            return new CrashDetailBean[i];
        }
    };
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public String I;
    public String J;
    public String K;
    public String L;
    public long M;
    public boolean N;
    public Map<String, String> O;
    public int P;
    public int Q;
    public Map<String, String> R;
    public Map<String, String> S;
    public byte[] T;
    public String U;
    public String V;
    private String W;

    /* renamed from: a  reason: collision with root package name */
    public long f6035a;

    /* renamed from: b  reason: collision with root package name */
    public int f6036b;

    /* renamed from: c  reason: collision with root package name */
    public String f6037c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6038d;

    /* renamed from: e  reason: collision with root package name */
    public String f6039e;
    public String f;
    public String g;
    public Map<String, PlugInBean> h;
    public Map<String, PlugInBean> i;
    public boolean j;
    public boolean k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;

    /* renamed from: q  reason: collision with root package name */
    public String f6040q;
    public long r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public byte[] y;
    public Map<String, String> z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 != null) {
            long j = this.r - crashDetailBean2.r;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
            }
            return 1;
        }
        return 1;
    }

    public CrashDetailBean() {
        this.f6035a = -1L;
        this.f6036b = 0;
        this.f6037c = UUID.randomUUID().toString();
        this.f6038d = false;
        this.f6039e = "";
        this.f = "";
        this.g = "";
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.f6040q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.W = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = -1;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
    }

    public CrashDetailBean(Parcel parcel) {
        this.f6035a = -1L;
        this.f6036b = 0;
        this.f6037c = UUID.randomUUID().toString();
        this.f6038d = false;
        this.f6039e = "";
        this.f = "";
        this.g = "";
        this.h = null;
        this.i = null;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.f6040q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.W = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = -1;
        this.Q = -1;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.f6036b = parcel.readInt();
        this.f6037c = parcel.readString();
        this.f6038d = parcel.readByte() == 1;
        this.f6039e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.j = parcel.readByte() == 1;
        this.k = parcel.readByte() == 1;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.f6040q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.z = z.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.W = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readLong();
        this.N = parcel.readByte() == 1;
        this.O = z.b(parcel);
        this.h = z.a(parcel);
        this.i = z.a(parcel);
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = z.b(parcel);
        this.S = z.b(parcel);
        this.T = parcel.createByteArray();
        this.y = parcel.createByteArray();
        this.U = parcel.readString();
        this.V = parcel.readString();
        this.x = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6036b);
        parcel.writeString(this.f6037c);
        parcel.writeByte(this.f6038d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6039e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.f6040q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        z.b(parcel, this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.W);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeLong(this.M);
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        z.b(parcel, this.O);
        z.a(parcel, this.h);
        z.a(parcel, this.i);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        z.b(parcel, this.R);
        z.b(parcel, this.S);
        parcel.writeByteArray(this.T);
        parcel.writeByteArray(this.y);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeString(this.x);
    }
}
