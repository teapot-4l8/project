package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IMultiInstanceInvalidationCallback.java */
/* loaded from: classes.dex */
public interface d extends IInterface {
    void a(String[] strArr);

    /* compiled from: IMultiInstanceInvalidationCallback.java */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements d {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0055a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                a(parcel.createStringArray());
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: IMultiInstanceInvalidationCallback.java */
        /* renamed from: androidx.room.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0055a implements d {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f2419a;

            C0055a(IBinder iBinder) {
                this.f2419a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f2419a;
            }

            @Override // androidx.room.d
            public void a(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    this.f2419a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
