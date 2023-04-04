package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingId.java */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0169a {

        /* renamed from: a  reason: collision with root package name */
        private final String f6829a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6830b;

        C0169a(String str, boolean z) {
            this.f6829a = str;
            this.f6830b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f6829a;
        }

        public boolean a() {
            return this.f6830b;
        }
    }

    public static String a(Context context) {
        try {
            C0169a c2 = c(context);
            if (c2 != null && !c2.a()) {
                return c2.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0169a c2 = c(context);
            if (c2 == null) {
                return null;
            }
            return c2.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0169a c(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    try {
                        c cVar = new c(bVar.a());
                        boolean a2 = cVar.a(true);
                        return new C0169a(a2 ? "" : cVar.a(), a2);
                    } finally {
                        context.unbindService(bVar);
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e3) {
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* loaded from: classes2.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f6831a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f6832b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
            this.f6831a = false;
            this.f6832b = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f6832b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder a() {
            if (this.f6831a) {
                throw new IllegalStateException();
            }
            this.f6831a = true;
            return this.f6832b.take();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdvertisingId.java */
    /* loaded from: classes2.dex */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f6833a;

        public c(IBinder iBinder) {
            this.f6833a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6833a;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f6833a.transact(1, obtain, obtain2, 0);
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
                this.f6833a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
