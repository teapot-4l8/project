package android.support.v4.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.a.a;

/* compiled from: ResultReceiver.java */
/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: android.support.v4.a.b.1
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
    final boolean f406a = false;

    /* renamed from: b  reason: collision with root package name */
    final Handler f407b = null;

    /* renamed from: c  reason: collision with root package name */
    android.support.v4.a.a f408c;

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: android.support.v4.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0010b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f410a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f411b;

        RunnableC0010b(int i, Bundle bundle) {
            this.f410a = i;
            this.f411b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f410a, this.f411b);
        }
    }

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    class a extends a.AbstractBinderC0008a {
        a() {
        }

        @Override // android.support.v4.a.a
        public void a(int i, Bundle bundle) {
            if (b.this.f407b != null) {
                b.this.f407b.post(new RunnableC0010b(i, bundle));
            } else {
                b.this.a(i, bundle);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f408c == null) {
                this.f408c = new a();
            }
            parcel.writeStrongBinder(this.f408c.asBinder());
        }
    }

    b(Parcel parcel) {
        this.f408c = a.AbstractBinderC0008a.a(parcel.readStrongBinder());
    }
}
