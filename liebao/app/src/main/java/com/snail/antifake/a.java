package com.snail.antifake;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: IEmulatorCheck.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {
    boolean a();

    void b();

    /* compiled from: IEmulatorCheck.java */
    /* renamed from: com.snail.antifake.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0130a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0130a() {
            attachInterface(this, "com.snail.antifake.IEmulatorCheck");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.snail.antifake.IEmulatorCheck");
                boolean a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
                return true;
            } else if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString("com.snail.antifake.IEmulatorCheck");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface("com.snail.antifake.IEmulatorCheck");
                b();
                parcel2.writeNoException();
                return true;
            }
        }
    }
}
