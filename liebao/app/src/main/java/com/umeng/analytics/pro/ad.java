package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: HuaweiDeviceIdSupplier.java */
/* loaded from: classes2.dex */
class ad implements z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6350a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";

    /* renamed from: b  reason: collision with root package name */
    private static final int f6351b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6352c = 2;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }

    /* compiled from: HuaweiDeviceIdSupplier.java */
    /* loaded from: classes2.dex */
    private static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f6353a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f6354b;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f6353a = false;
            this.f6354b = new LinkedBlockingQueue<>();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f6354b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public IBinder a() {
            if (this.f6353a) {
                throw new IllegalStateException();
            }
            this.f6353a = true;
            return this.f6354b.poll(5L, TimeUnit.SECONDS);
        }
    }

    /* compiled from: HuaweiDeviceIdSupplier.java */
    /* loaded from: classes2.dex */
    private static final class b implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f6355a;

        public b(IBinder iBinder) {
            this.f6355a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f6355a;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ad.f6350a);
                this.f6355a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ad.f6350a);
                this.f6355a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
