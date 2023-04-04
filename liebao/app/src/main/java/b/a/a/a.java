package b.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import b.a.k.d;
import b.a.k.e;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final e f3088a = e.a("AdvertisingIdClient");

    /* renamed from: b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0064a {

        /* renamed from: a  reason: collision with root package name */
        private final String f3089a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3090b;

        C0064a(String str, boolean z) {
            this.f3089a = str;
            this.f3090b = z;
        }

        public String a() {
            return this.f3090b ? "" : this.f3089a;
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f3091a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue f3092b;

        private b() {
            this.f3091a = false;
            this.f3092b = new LinkedBlockingQueue(1);
        }

        public IBinder a() {
            if (this.f3091a) {
                throw new IllegalStateException();
            }
            this.f3091a = true;
            return (IBinder) this.f3092b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3092b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f3093a;

        public c(IBinder iBinder) {
            this.f3093a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3093a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f3093a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f3093a;
        }
    }

    public static C0064a a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                c cVar = new c(bVar.a());
                return new C0064a(cVar.a(), cVar.a(true));
            } catch (Exception e3) {
                e3.printStackTrace();
            } finally {
                context.unbindService(bVar);
            }
        }
        if (d.f3261a) {
            d.a("Google Play connection failed", new Object[0]);
        }
        return null;
    }
}
