package android.support.v4.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IResultReceiver.java */
/* loaded from: classes.dex */
public interface a extends IInterface {
    void a(int i, Bundle bundle);

    /* compiled from: IResultReceiver.java */
    /* renamed from: android.support.v4.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0008a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0008a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0009a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IResultReceiver.java */
        /* renamed from: android.support.v4.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0009a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f404a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f405b;

            C0009a(IBinder iBinder) {
                this.f405b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f405b;
            }

            @Override // android.support.v4.a.a
            public void a(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f405b.transact(1, obtain, null, 1) || AbstractBinderC0008a.a() == null) {
                        return;
                    }
                    AbstractBinderC0008a.a().a(i, bundle);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static a a() {
            return C0009a.f404a;
        }
    }
}
