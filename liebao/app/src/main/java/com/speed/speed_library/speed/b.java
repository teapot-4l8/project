package com.speed.speed_library.speed;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: WireGuardConfig.kt */
/* loaded from: classes2.dex */
public final class b implements Parcelable {
    public static final a CREATOR = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private C0155b f5848a;

    /* renamed from: b  reason: collision with root package name */
    private int f5849b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f5850c;

    /* renamed from: d  reason: collision with root package name */
    private String f5851d;

    /* renamed from: e  reason: collision with root package name */
    private String f5852e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private int k;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b() {
        this.f5848a = new C0155b();
        this.f5849b = 1;
        this.f5850c = new ArrayList<>();
        this.f5851d = "";
        this.f5852e = "cidr.txt";
        this.f = "cn.txt";
        this.g = "";
        this.h = "";
    }

    public final C0155b a() {
        return this.f5848a;
    }

    public final void a(C0155b c0155b) {
        i.b(c0155b, "<set-?>");
        this.f5848a = c0155b;
    }

    public final void a(int i) {
        this.f5849b = i;
    }

    public final int b() {
        return this.f5849b;
    }

    public final void a(ArrayList<String> arrayList) {
        i.b(arrayList, "<set-?>");
        this.f5850c = arrayList;
    }

    public final ArrayList<String> c() {
        return this.f5850c;
    }

    public final String d() {
        return this.f5852e;
    }

    public final String e() {
        return this.f;
    }

    public final void a(String str) {
        i.b(str, "<set-?>");
        this.h = str;
    }

    public final String f() {
        return this.h;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final int g() {
        return this.i;
    }

    public final void c(int i) {
        this.j = i;
    }

    public final int h() {
        return this.j;
    }

    public final void d(int i) {
        this.k = i;
    }

    public final int i() {
        return this.k;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Parcel parcel) {
        this();
        i.b(parcel, "parcel");
        C0155b c0155b = (C0155b) parcel.readParcelable(C0155b.class.getClassLoader());
        this.f5848a = c0155b == null ? new C0155b() : c0155b;
        this.f5849b = parcel.readInt();
        String readString = parcel.readString();
        this.f5851d = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.f5852e = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.f = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.g = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.h = readString5 != null ? readString5 : "";
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        this.f5850c = createStringArrayList == null ? new ArrayList<>() : createStringArrayList;
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
    }

    /* compiled from: WireGuardConfig.kt */
    /* renamed from: com.speed.speed_library.speed.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0155b implements Parcelable {
        public static final a CREATOR = new a(null);

        /* renamed from: a  reason: collision with root package name */
        private long f5853a;

        /* renamed from: b  reason: collision with root package name */
        private String f5854b;

        /* renamed from: c  reason: collision with root package name */
        private String f5855c;

        /* renamed from: d  reason: collision with root package name */
        private String f5856d;

        /* renamed from: e  reason: collision with root package name */
        private String f5857e;
        private String f;
        private String g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public C0155b() {
            this.f5853a = -1L;
            this.f5854b = "";
            this.f5855c = "";
            this.f5856d = "";
            this.f5857e = "";
            this.f = "";
            this.g = "";
            this.j = 10;
            this.k = 32;
            this.l = 45998;
            this.m = 8;
        }

        public final long a() {
            return this.f5853a;
        }

        public final String b() {
            return this.f5854b;
        }

        public final String c() {
            return this.f5855c;
        }

        public final String d() {
            return this.f5856d;
        }

        public final String e() {
            return this.f5857e;
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final int h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final int j() {
            return this.j;
        }

        public final int k() {
            return this.k;
        }

        public final int l() {
            return this.l;
        }

        public final int m() {
            return this.m;
        }

        public /* synthetic */ C0155b(long j, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, int i4, int i5, int i6, int i7, g gVar) {
            this(j, str, str2, str3, str4, str5, str6, i, i2, i3, (i7 & 1024) != 0 ? 32 : i4, (i7 & 2048) != 0 ? 45998 : i5, (i7 & 4096) != 0 ? 8 : i6);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C0155b(long j, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, int i4, int i5, int i6) {
            this();
            i.b(str, "type_name");
            i.b(str2, "theirPublicKey");
            i.b(str3, "endpoint");
            i.b(str4, "allowIp");
            i.b(str5, "keys");
            i.b(str6, "sign");
            this.f5853a = j;
            this.f5854b = str;
            this.f5855c = str2;
            this.f5856d = str3;
            this.f5857e = str4;
            this.f = str5;
            this.g = str6;
            this.h = i;
            this.i = i2;
            this.j = i3;
            this.k = i4;
            this.l = i5;
            this.m = i6;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C0155b(Parcel parcel) {
            this();
            i.b(parcel, "parcel");
            this.f5853a = parcel.readLong();
            String readString = parcel.readString();
            this.f5854b = readString == null ? "" : readString;
            String readString2 = parcel.readString();
            this.f5855c = readString2 == null ? "" : readString2;
            String readString3 = parcel.readString();
            this.f5856d = readString3 == null ? "" : readString3;
            String readString4 = parcel.readString();
            this.f5857e = readString4 == null ? "" : readString4;
            String readString5 = parcel.readString();
            this.f = readString5 == null ? "" : readString5;
            String readString6 = parcel.readString();
            this.g = readString6 != null ? readString6 : "";
            this.h = parcel.readInt();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.m = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            i.b(parcel, "parcel");
            parcel.writeLong(this.f5853a);
            parcel.writeString(this.f5854b);
            parcel.writeString(this.f5855c);
            parcel.writeString(this.f5856d);
            parcel.writeString(this.f5857e);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
            parcel.writeInt(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeInt(this.m);
        }

        /* compiled from: WireGuardConfig.kt */
        /* renamed from: com.speed.speed_library.speed.b$b$a */
        /* loaded from: classes2.dex */
        public static final class a implements Parcelable.Creator<C0155b> {
            private a() {
            }

            public /* synthetic */ a(g gVar) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public C0155b createFromParcel(Parcel parcel) {
                i.b(parcel, "parcel");
                return new C0155b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public C0155b[] newArray(int i) {
                return new C0155b[i];
            }
        }

        public String toString() {
            return "\n                ts = " + this.f5853a + ",\n                theirPublicKey = " + this.f5854b + ",\n                theirPublicKey = " + this.f5855c + ",\n                endpoint = " + this.f5856d + ",\n                allowIp = " + this.f5857e + ",\n                keys = " + this.f + ",\n                sign = " + this.g + ",\n                is_client_add_peer = " + this.h + ",\n                is_speed_disallow_self_app = " + this.i + ",\n                interval_time = " + this.j + ",\n                mask = " + this.k + ",\n                listenPort = " + this.l + ",\n                addressPrefixLength = " + this.m + "\n                ";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        i.b(parcel, "parcel");
        parcel.writeParcelable(this.f5848a, i);
        parcel.writeInt(this.f5849b);
        parcel.writeString(this.f5851d);
        parcel.writeString(this.f5852e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeStringList(this.f5850c);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
    }

    /* compiled from: WireGuardConfig.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Parcelable.Creator<b> {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            i.b(parcel, "parcel");
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public String toString() {
        return "\n            server = " + this.f5848a + ",\n            smartRoute = " + this.f5849b + ",\n            smartRouteRemoteUrl = " + this.f5851d + ",\n            smartRouteLocalFilename = " + this.f5852e + ",\n            toChinaRouteFileName = " + this.f + ",\n            checkPrivateKeyUrl = " + this.g + "\n            btReportUrl = " + this.h + "\n            disconnectSwitch = " + this.i + "\n            useMusicForBackgroud = " + this.j + "\n            appAgentSwitch = " + this.k + "\n            ";
    }
}
