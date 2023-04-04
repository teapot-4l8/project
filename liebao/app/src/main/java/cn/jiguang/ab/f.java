package cn.jiguang.ab;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.just.agentweb.DefaultWebClient;
import com.tencent.bugly.CrashModule;

/* loaded from: classes.dex */
final class f {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f3656e = new Object();
    private static f h = null;

    /* renamed from: a  reason: collision with root package name */
    protected Handler f3657a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3658b;

    /* renamed from: c  reason: collision with root package name */
    private LocationManager f3659c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jiguang.ac.b f3660d;
    private boolean f;
    private String g;
    private LocationListener i = new g(this);

    private f(Context context) {
        this.f3658b = context;
        this.f3659c = (LocationManager) context.getSystemService("location");
    }

    public static f a(Context context) {
        if (h == null) {
            synchronized (f3656e) {
                if (h == null) {
                    h = new f(context);
                }
            }
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (location == null) {
            this.f3660d = null;
            return;
        }
        cn.jiguang.ad.a.a("JLocationGps", "updateGpsInfo location time:" + location.getTime());
        if (this.f3660d == null) {
            this.f3660d = new cn.jiguang.ac.b();
        }
        this.f3660d.f3670a = cn.jiguang.d.b.a(this.f3658b, location.getTime());
        this.f3660d.f3671b = location.getProvider();
        this.f3660d.f3672c = location.getLatitude();
        this.f3660d.f3673d = location.getLongitude();
        this.f3660d.f = location.getBearing();
        this.f3660d.g = location.getAccuracy();
    }

    private boolean a(Location location, Location location2) {
        if (location == null) {
            return false;
        }
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        String provider = location.getProvider();
        String provider2 = location2.getProvider();
        boolean equals = provider == null ? provider2 == null : provider.equals(provider2);
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && equals;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(f fVar) {
        cn.jiguang.ad.a.a("JLocationGps", "gps will done");
        fVar.f = true;
        fVar.f();
        Handler handler = fVar.f3657a;
        if (handler == null) {
            cn.jiguang.ad.a.e("JLocationGps", "cellLocationManager is null,please check it");
            return;
        }
        if (handler.hasMessages(CrashModule.MODULE_ID)) {
            fVar.f3657a.removeMessages(CrashModule.MODULE_ID);
        }
        if (fVar.f3657a.hasMessages(1003)) {
            fVar.f3657a.removeMessages(1003);
        }
        if (fVar.f3657a.hasMessages(DefaultWebClient.DERECT_OPEN_OTHER_PAGE)) {
            fVar.f3657a.removeMessages(DefaultWebClient.DERECT_OPEN_OTHER_PAGE);
        }
        if (fVar.f3657a.hasMessages(1005)) {
            fVar.f3657a.removeMessages(1005);
        }
        try {
            fVar.f3657a.getLooper().quit();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (this.i == null) {
                cn.jiguang.ad.a.d("JLocationGps", "Location listener is null , do nothing!");
            } else if (this.f3659c != null) {
                this.f3659c.removeUpdates(this.i);
            } else {
                cn.jiguang.ad.a.d("JLocationGps", "locationManager is null , do nothing!");
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JLocationGps", "remove location listener failed  e:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final cn.jiguang.ac.b a() {
        return this.f3660d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.f = false;
        this.f3660d = null;
        if (this.f3659c == null) {
            cn.jiguang.ad.a.d("JLocationGps", "get locationManager failed");
            this.f = true;
            return;
        }
        try {
            if (this.f3657a == null) {
                HandlerThread handlerThread = new HandlerThread("location");
                handlerThread.start();
                this.f3657a = new h(this, handlerThread.getLooper());
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.f("JLocationGps", "start load loc-info failed - error:" + th);
        }
        if (this.f3657a == null) {
            cn.jiguang.ad.a.d("JLocationGps", " mAsyncHandler is empty");
            this.f = true;
        } else if (this.f3659c.isProviderEnabled("network")) {
            this.g = "network";
            this.f3657a.sendEmptyMessage(1003);
        } else if (this.f3659c.isProviderEnabled("gps")) {
            this.g = "gps";
            this.f3657a.sendEmptyMessage(1003);
        } else {
            this.g = "network";
            this.f3657a.sendEmptyMessage(CrashModule.MODULE_ID);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:3:0x0002, B:5:0x0020, B:13:0x0032, B:15:0x0041, B:8:0x0027), top: B:21:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final cn.jiguang.ac.b d() {
        try {
            Location lastKnownLocation = this.f3659c.getLastKnownLocation("gps");
            Location lastKnownLocation2 = this.f3659c.getLastKnownLocation("network");
            Location lastKnownLocation3 = this.f3659c.getLastKnownLocation("passive");
            if (a(lastKnownLocation, lastKnownLocation2)) {
                if (a(lastKnownLocation, lastKnownLocation3)) {
                    if (lastKnownLocation == null && System.currentTimeMillis() - lastKnownLocation.getTime() < 30000) {
                        a(lastKnownLocation);
                        cn.jiguang.ad.a.a("JLocationGps", "bestLocation:" + this.f3660d + ",curTime:" + System.currentTimeMillis());
                        return this.f3660d;
                    }
                }
                lastKnownLocation = lastKnownLocation3;
                return lastKnownLocation == null ? null : null;
            }
            if (a(lastKnownLocation2, lastKnownLocation3)) {
                lastKnownLocation = lastKnownLocation2;
                if (lastKnownLocation == null) {
                }
            }
            lastKnownLocation = lastKnownLocation3;
            if (lastKnownLocation == null) {
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JLocationGps", "loadLastGpsInfo failed: " + th.getMessage());
            return null;
        }
    }

    public final boolean e() {
        String str;
        try {
            if (this.f3659c != null) {
                if (this.f3659c.isProviderEnabled("gps") || this.f3659c.isProviderEnabled("network")) {
                    return true;
                }
                return this.f3659c.isProviderEnabled("passive");
            }
            return false;
        } catch (IllegalArgumentException unused) {
            str = "The provider [gps] is illegal argument!";
            cn.jiguang.ad.a.d("JLocationGps", str);
            return false;
        } catch (SecurityException unused2) {
            str = "No suitable permission is present when get GPS_PROVIDER!";
            cn.jiguang.ad.a.d("JLocationGps", str);
            return false;
        } catch (Exception unused3) {
            str = "The ILocationManager is null!";
            cn.jiguang.ad.a.d("JLocationGps", str);
            return false;
        }
    }
}
