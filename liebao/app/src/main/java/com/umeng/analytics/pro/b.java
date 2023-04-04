package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IDeviceIdService.java */
/* loaded from: classes2.dex */
public interface b extends IInterface {
    String a();

    String a(String str);

    String b(String str);

    /* compiled from: IDeviceIdService.java */
    /* loaded from: classes2.dex */
    public static abstract class a extends Binder implements b {

        /* renamed from: a  reason: collision with root package name */
        static final int f6408a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f6409b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f6410c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final String f6411d = "com.samsung.android.deviceidservice.IDeviceIdService";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, f6411d);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f6411d);
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0162a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(f6411d);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(f6411d);
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            } else if (i != 3) {
                if (i == 1598968902) {
                    parcel2.writeString(f6411d);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface(f6411d);
                String b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            }
        }

        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.umeng.analytics.pro.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0162a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6412a;

            public String b() {
                return a.f6411d;
            }

            C0162a(IBinder iBinder) {
                this.f6412a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6412a;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f6411d);
                    this.f6412a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f6411d);
                    obtain.writeString(str);
                    this.f6412a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f6411d);
                    obtain.writeString(str);
                    this.f6412a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
