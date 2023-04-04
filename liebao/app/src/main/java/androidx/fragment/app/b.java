package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.p;
import androidx.lifecycle.h;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackState.java */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: androidx.fragment.app.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f1835a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f1836b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f1837c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f1838d;

    /* renamed from: e  reason: collision with root package name */
    final int f1839e;
    final int f;
    final String g;
    final int h;
    final int i;
    final CharSequence j;
    final int k;
    final CharSequence l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b(a aVar) {
        int size = aVar.f1922d.size();
        this.f1835a = new int[size * 5];
        if (!aVar.k) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1836b = new ArrayList<>(size);
        this.f1837c = new int[size];
        this.f1838d = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            p.a aVar2 = aVar.f1922d.get(i);
            int i3 = i2 + 1;
            this.f1835a[i2] = aVar2.f1925a;
            this.f1836b.add(aVar2.f1926b != null ? aVar2.f1926b.mWho : null);
            int i4 = i3 + 1;
            this.f1835a[i3] = aVar2.f1927c;
            int i5 = i4 + 1;
            this.f1835a[i4] = aVar2.f1928d;
            int i6 = i5 + 1;
            this.f1835a[i5] = aVar2.f1929e;
            this.f1835a[i6] = aVar2.f;
            this.f1837c[i] = aVar2.g.ordinal();
            this.f1838d[i] = aVar2.h.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.f1839e = aVar.i;
        this.f = aVar.j;
        this.g = aVar.m;
        this.h = aVar.f1834c;
        this.i = aVar.n;
        this.j = aVar.o;
        this.k = aVar.p;
        this.l = aVar.f1924q;
        this.m = aVar.r;
        this.n = aVar.s;
        this.o = aVar.t;
    }

    public b(Parcel parcel) {
        this.f1835a = parcel.createIntArray();
        this.f1836b = parcel.createStringArrayList();
        this.f1837c = parcel.createIntArray();
        this.f1838d = parcel.createIntArray();
        this.f1839e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public a a(k kVar) {
        a aVar = new a(kVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f1835a.length) {
            p.a aVar2 = new p.a();
            int i3 = i + 1;
            aVar2.f1925a = this.f1835a[i];
            if (k.f1866b) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f1835a[i3]);
            }
            String str = this.f1836b.get(i2);
            if (str != null) {
                aVar2.f1926b = kVar.g.get(str);
            } else {
                aVar2.f1926b = null;
            }
            aVar2.g = h.b.values()[this.f1837c[i2]];
            aVar2.h = h.b.values()[this.f1838d[i2]];
            int i4 = i3 + 1;
            aVar2.f1927c = this.f1835a[i3];
            int i5 = i4 + 1;
            aVar2.f1928d = this.f1835a[i4];
            int i6 = i5 + 1;
            aVar2.f1929e = this.f1835a[i5];
            aVar2.f = this.f1835a[i6];
            aVar.f1923e = aVar2.f1927c;
            aVar.f = aVar2.f1928d;
            aVar.g = aVar2.f1929e;
            aVar.h = aVar2.f;
            aVar.a(aVar2);
            i2++;
            i = i6 + 1;
        }
        aVar.i = this.f1839e;
        aVar.j = this.f;
        aVar.m = this.g;
        aVar.f1834c = this.h;
        aVar.k = true;
        aVar.n = this.i;
        aVar.o = this.j;
        aVar.p = this.k;
        aVar.f1924q = this.l;
        aVar.r = this.m;
        aVar.s = this.n;
        aVar.t = this.o;
        aVar.a(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1835a);
        parcel.writeStringList(this.f1836b);
        parcel.writeIntArray(this.f1837c);
        parcel.writeIntArray(this.f1838d);
        parcel.writeInt(this.f1839e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
