package cn.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class e extends Binder implements d {
    public static d a() {
        return h.f3591a;
    }

    public static d a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("cn.asus.push.IAIDLInvoke");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new h(iBinder) : (d) queryLocalInterface;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("cn.asus.push.IAIDLInvoke");
            a(parcel.readInt() != 0 ? a.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        } else if (i == 2) {
            parcel.enforceInterface("cn.asus.push.IAIDLInvoke");
            a(parcel.readInt() != 0 ? a.CREATOR.createFromParcel(parcel) : null, c.asInterface(parcel.readStrongBinder()));
            return true;
        } else if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel2.writeString("cn.asus.push.IAIDLInvoke");
            return true;
        }
    }
}
