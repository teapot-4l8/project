package cn.a.a;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements b {

    /* renamed from: a  reason: collision with root package name */
    public static b f3589a;

    /* renamed from: b  reason: collision with root package name */
    private IBinder f3590b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IBinder iBinder) {
        this.f3590b = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3590b;
    }

    @Override // cn.a.a.b
    public final void call(a aVar) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLCallback");
            if (aVar != null) {
                obtain.writeInt(1);
                aVar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (this.f3590b.transact(1, obtain, null, 1) || c.getDefaultImpl() == null) {
                return;
            }
            c.getDefaultImpl().call(aVar);
        } finally {
            obtain.recycle();
        }
    }
}
