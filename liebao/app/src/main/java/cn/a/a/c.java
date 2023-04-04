package cn.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class c extends Binder implements b {
    private static final String DESCRIPTOR = "cn.asus.push.IAIDLCallback";
    static final int TRANSACTION_call = 1;

    public c() {
        attachInterface(this, DESCRIPTOR);
    }

    public static b asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new g(iBinder) : (b) queryLocalInterface;
    }

    public static b getDefaultImpl() {
        return g.f3589a;
    }

    public static boolean setDefaultImpl(b bVar) {
        if (g.f3589a != null || bVar == null) {
            return false;
        }
        g.f3589a = bVar;
        return true;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            call(parcel.readInt() != 0 ? a.CREATOR.createFromParcel(parcel) : null);
            return true;
        } else if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }
}
