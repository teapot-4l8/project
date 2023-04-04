package com.speed.speed_library;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IWireGuardServiceCallback.java */
/* loaded from: classes2.dex */
public interface b extends IInterface {
    void a(int i, String str);

    void a(long j, long j2);

    /* compiled from: IWireGuardServiceCallback.java */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.speed.speed_library.IWireGuardServiceCallback");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.speed.speed_library.IWireGuardServiceCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0135a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.speed.speed_library.IWireGuardServiceCallback");
                a(parcel.readInt(), parcel.readString());
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.speed.speed_library.IWireGuardServiceCallback");
                a(parcel.readLong(), parcel.readLong());
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString("com.speed.speed_library.IWireGuardServiceCallback");
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IWireGuardServiceCallback.java */
        /* renamed from: com.speed.speed_library.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0135a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static b f5590a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f5591b;

            C0135a(IBinder iBinder) {
                this.f5591b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5591b;
            }

            @Override // com.speed.speed_library.b
            public void a(int i, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.speed.speed_library.IWireGuardServiceCallback");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.f5591b.transact(1, obtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(i, str);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.speed.speed_library.b
            public void a(long j, long j2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.speed.speed_library.IWireGuardServiceCallback");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    if (this.f5591b.transact(2, obtain, null, 1) || a.a() == null) {
                        return;
                    }
                    a.a().a(j, j2);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static b a() {
            return C0135a.f5590a;
        }
    }
}
