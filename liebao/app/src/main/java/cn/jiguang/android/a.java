package cn.jiguang.android;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements IDataShare {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f3765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(IBinder iBinder) {
        this.f3765a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3765a;
    }

    @Override // cn.jiguang.android.IDataShare
    public final String bind(IDataShare iDataShare, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.jiguang.android.IDataShare");
            obtain.writeStrongBinder(iDataShare != null ? iDataShare.asBinder() : null);
            obtain.writeString(str);
            this.f3765a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // cn.jiguang.android.IDataShare
    public final Bundle execute(String str, String str2, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.jiguang.android.IDataShare");
            obtain.writeString(str);
            obtain.writeString(str2);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3765a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // cn.jiguang.android.IDataShare
    public final IBinder getBinderByType(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.jiguang.android.IDataShare");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f3765a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // cn.jiguang.android.IDataShare
    public final void onAction(String str, String str2, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.jiguang.android.IDataShare");
            obtain.writeString(str);
            obtain.writeString(str2);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3765a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
