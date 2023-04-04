package org.b.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.b.a.a.a.a;

/* compiled from: OpenIDHelper.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public org.b.a.a.a.a f7764a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f7765b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f7766c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f7767d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f7768e = new a();

    /* compiled from: OpenIDHelper.java */
    /* loaded from: classes2.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f7764a = a.AbstractBinderC0188a.a(iBinder);
            synchronized (b.this.f7767d) {
                b.this.f7767d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f7764a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OpenIDHelper.java */
    /* renamed from: org.b.a.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0190b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f7770a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
    }

    public boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f7765b)) {
            this.f7765b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f7766c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f7765b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
            this.f7766c = str2;
        }
        String a2 = ((a.AbstractBinderC0188a.C0189a) this.f7764a).a(this.f7765b, this.f7766c, str);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    public synchronized String a(Context context, String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.f7764a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.f7768e, 1)) {
                    synchronized (this.f7767d) {
                        try {
                            this.f7767d.wait(3000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (this.f7764a == null) {
                    return "";
                }
                try {
                    return b(context, str);
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
            try {
                return b(context, str);
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return "";
            }
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }
}
