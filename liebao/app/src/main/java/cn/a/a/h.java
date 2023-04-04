package cn.a.a;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements d {

    /* renamed from: a  reason: collision with root package name */
    public static d f3591a;

    /* renamed from: b  reason: collision with root package name */
    private IBinder f3592b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(IBinder iBinder) {
        this.f3592b = iBinder;
    }

    @Override // cn.a.a.d
    public final void a(a aVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            if (aVar != null) {
                obtain.writeInt(1);
                aVar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (this.f3592b.transact(1, obtain, obtain2, 0) || e.a() == null) {
                obtain2.readException();
            } else {
                e.a().a(aVar);
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // cn.a.a.d
    public final void a(a aVar, b bVar) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("cn.asus.push.IAIDLInvoke");
            if (aVar != null) {
                obtain.writeInt(1);
                aVar.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            if (this.f3592b.transact(2, obtain, null, 1) || e.a() == null) {
                return;
            }
            e.a().a(aVar, bVar);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3592b;
    }
}
