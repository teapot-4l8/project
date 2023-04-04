package com.speed.speed_library;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.speed.speed_library.b;

/* compiled from: IWireGuardService.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {
    int a();

    void a(b bVar);

    void b();

    void b(b bVar);

    /* compiled from: IWireGuardService.java */
    /* renamed from: com.speed.speed_library.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0132a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0132a() {
            attachInterface(this, "com.speed.speed_library.IWireGuardService");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.speed.speed_library.IWireGuardService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0133a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.speed.speed_library.IWireGuardService");
                int a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.speed.speed_library.IWireGuardService");
                b();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.speed.speed_library.IWireGuardService");
                a(b.a.a(parcel.readStrongBinder()));
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.speed.speed_library.IWireGuardService");
                b(b.a.a(parcel.readStrongBinder()));
                return true;
            } else if (i == 1598968902) {
                parcel2.writeString("com.speed.speed_library.IWireGuardService");
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IWireGuardService.java */
        /* renamed from: com.speed.speed_library.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0133a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f5542a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f5543b;

            C0133a(IBinder iBinder) {
                this.f5543b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f5543b;
            }

            @Override // com.speed.speed_library.a
            public int a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.speed.speed_library.IWireGuardService");
                    if (!this.f5543b.transact(1, obtain, obtain2, 0) && AbstractBinderC0132a.c() != null) {
                        return AbstractBinderC0132a.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.speed.speed_library.a
            public void b() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.speed.speed_library.IWireGuardService");
                    if (this.f5543b.transact(2, obtain, null, 1) || AbstractBinderC0132a.c() == null) {
                        return;
                    }
                    AbstractBinderC0132a.c().b();
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.speed.speed_library.a
            public void a(b bVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.speed.speed_library.IWireGuardService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.f5543b.transact(3, obtain, null, 1) || AbstractBinderC0132a.c() == null) {
                        return;
                    }
                    AbstractBinderC0132a.c().a(bVar);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.speed.speed_library.a
            public void b(b bVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.speed.speed_library.IWireGuardService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.f5543b.transact(4, obtain, null, 1) || AbstractBinderC0132a.c() == null) {
                        return;
                    }
                    AbstractBinderC0132a.c().b(bVar);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static a c() {
            return C0133a.f5542a;
        }
    }
}
