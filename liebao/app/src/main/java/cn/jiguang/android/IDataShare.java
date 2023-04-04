package cn.jiguang.android;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IDataShare extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements IDataShare {
        private static final String DESCRIPTOR = "cn.jiguang.android.IDataShare";
        static final int TRANSACTION_bind = 4;
        static final int TRANSACTION_execute = 3;
        static final int TRANSACTION_getBinderByType = 1;
        static final int TRANSACTION_onAction = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDataShare asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDataShare)) ? new a(iBinder) : (IDataShare) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                IBinder binderByType = getBinderByType(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(binderByType);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAction(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                Bundle execute = execute(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (execute != null) {
                    parcel2.writeInt(1);
                    execute.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 4) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                String bind = bind(asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(bind);
                return true;
            }
        }
    }

    String bind(IDataShare iDataShare, String str);

    Bundle execute(String str, String str2, Bundle bundle);

    IBinder getBinderByType(String str, String str2);

    void onAction(String str, String str2, Bundle bundle);
}
