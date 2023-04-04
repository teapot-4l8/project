package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentState.java */
/* loaded from: classes.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new Parcelable.Creator<o>() { // from class: androidx.fragment.app.o.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public o[] newArray(int i) {
            return new o[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final String f1917a;

    /* renamed from: b  reason: collision with root package name */
    final String f1918b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f1919c;

    /* renamed from: d  reason: collision with root package name */
    final int f1920d;

    /* renamed from: e  reason: collision with root package name */
    final int f1921e;
    final String f;
    final boolean g;
    final boolean h;
    final boolean i;
    final Bundle j;
    final boolean k;
    final int l;
    Bundle m;
    d n;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(d dVar) {
        this.f1917a = dVar.getClass().getName();
        this.f1918b = dVar.mWho;
        this.f1919c = dVar.mFromLayout;
        this.f1920d = dVar.mFragmentId;
        this.f1921e = dVar.mContainerId;
        this.f = dVar.mTag;
        this.g = dVar.mRetainInstance;
        this.h = dVar.mRemoving;
        this.i = dVar.mDetached;
        this.j = dVar.mArguments;
        this.k = dVar.mHidden;
        this.l = dVar.mMaxState.ordinal();
    }

    o(Parcel parcel) {
        this.f1917a = parcel.readString();
        this.f1918b = parcel.readString();
        this.f1919c = parcel.readInt() != 0;
        this.f1920d = parcel.readInt();
        this.f1921e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readBundle();
        this.k = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }

    public d a(ClassLoader classLoader, h hVar) {
        if (this.n == null) {
            Bundle bundle = this.j;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            d c2 = hVar.c(classLoader, this.f1917a);
            this.n = c2;
            c2.setArguments(this.j);
            Bundle bundle2 = this.m;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.n.mSavedFragmentState = this.m;
            } else {
                this.n.mSavedFragmentState = new Bundle();
            }
            this.n.mWho = this.f1918b;
            this.n.mFromLayout = this.f1919c;
            this.n.mRestored = true;
            this.n.mFragmentId = this.f1920d;
            this.n.mContainerId = this.f1921e;
            this.n.mTag = this.f;
            this.n.mRetainInstance = this.g;
            this.n.mRemoving = this.h;
            this.n.mDetached = this.i;
            this.n.mHidden = this.k;
            this.n.mMaxState = h.b.values()[this.l];
            if (k.f1866b) {
                Log.v("FragmentManager", "Instantiated fragment " + this.n);
            }
        }
        return this.n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1917a);
        sb.append(" (");
        sb.append(this.f1918b);
        sb.append(")}:");
        if (this.f1919c) {
            sb.append(" fromLayout");
        }
        if (this.f1921e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1921e));
        }
        String str = this.f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f);
        }
        if (this.g) {
            sb.append(" retainInstance");
        }
        if (this.h) {
            sb.append(" removing");
        }
        if (this.i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1917a);
        parcel.writeString(this.f1918b);
        parcel.writeInt(this.f1919c ? 1 : 0);
        parcel.writeInt(this.f1920d);
        parcel.writeInt(this.f1921e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeBundle(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }
}
