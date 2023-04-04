package cn.jpush.android.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.u.g;
import com.just.agentweb.DefaultWebClient;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: d  reason: collision with root package name */
    private long f4280d;

    /* renamed from: e  reason: collision with root package name */
    private LocationManager f4281e;
    private Handler f;
    private long g;
    private long h;
    private String i;
    private boolean j;
    private LocationListener k;
    private final AtomicBoolean l;

    public a(Context context) {
        super(context);
        this.g = 900000L;
        this.h = 20000L;
        this.j = false;
        this.k = new LocationListener() { // from class: cn.jpush.android.b.a.1
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                a.this.f4281e.removeUpdates(this);
                a.this.l.set(false);
                a.this.a(location);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };
        this.l = new AtomicBoolean();
        this.f4281e = (LocationManager) context.getSystemService("location");
        this.g = cn.jpush.android.cache.a.c(context, 900000L);
        this.f4280d = cn.jpush.android.cache.a.c(context, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        Logger.dd("CustomGeofenAction", "current location:" + location);
        Handler handler = this.f;
        if (handler != null && handler.hasMessages(DefaultWebClient.DERECT_OPEN_OTHER_PAGE)) {
            this.f.removeMessages(DefaultWebClient.DERECT_OPEN_OTHER_PAGE);
        }
        if (location == null) {
            return;
        }
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        boolean z = false;
        Iterator<Map.Entry<String, b>> it = this.f4292b.entrySet().iterator();
        while (it.hasNext()) {
            b value = it.next().getValue();
            if (value.f4289e * 1000 <= System.currentTimeMillis()) {
                Logger.dd("CustomGeofenAction", "Out of date geofence " + value.f4285a);
                it.remove();
                b(value);
            } else {
                double d2 = latitude;
                double a2 = g.a(longitude, latitude, value.f, value.g);
                Logger.dd("CustomGeofenAction", value.f4285a + " distance to center:" + a2);
                String str = a2 <= ((double) value.f4286b) ? "in" : "out";
                double d3 = value.f4286b;
                Double.isNaN(d3);
                if (Math.abs(a2 - d3) < 1000.0d) {
                    z = true;
                }
                Logger.d("CustomGeofenAction", "lastStatus:" + value.h + ",currentStatus:" + str);
                if (!str.equals(value.h)) {
                    if (value.h != null && str.equals(value.f4287c) && f(value)) {
                        e(value);
                        d(value);
                        if (!value.f4288d) {
                            Logger.dd("CustomGeofenAction", "No repeat geofence " + value.f4285a);
                            this.f4292b.remove(value.f4285a);
                            c();
                            b(value);
                        }
                    }
                    value.h = str;
                }
                latitude = d2;
            }
        }
        if (this.f4280d == -1) {
            this.g = z ? 180000L : 900000L;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        Logger.dd("CustomGeofenAction", "Scan geofence after " + j + "ms");
        Handler handler = this.f;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f.removeMessages(1000);
        }
        this.f.sendEmptyMessageDelayed(1000, j);
    }

    private void d() {
        try {
            HandlerThread handlerThread = new HandlerThread("CustomGeofenAction") { // from class: cn.jpush.android.b.a.2
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e2) {
                        Logger.e("CustomGeofenAction", "handler thread run e:" + e2 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.f = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.b.a.3
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    String str;
                    switch (message.what) {
                        case 1000:
                            Logger.d("CustomGeofenAction", "period task tid " + Thread.currentThread().getId());
                            a aVar = a.this;
                            aVar.b(aVar.g);
                            break;
                        case DefaultWebClient.DERECT_OPEN_OTHER_PAGE /* 1001 */:
                            a.this.e();
                            try {
                                if (a.this.i == null || !a.this.i.equals("gps")) {
                                    str = "Network provider time out!";
                                } else {
                                    Logger.dd("CustomGeofenAction", "GPS provider time out!");
                                    a.this.i = "network";
                                    if (a.this.f4281e.isProviderEnabled(a.this.i)) {
                                        a.this.f4281e.requestLocationUpdates(a.this.i, 2000L, 0.0f, a.this.k);
                                        a.this.f.sendEmptyMessageDelayed(DefaultWebClient.DERECT_OPEN_OTHER_PAGE, a.this.h / 2);
                                        return;
                                    }
                                    str = "Network provider is disabled";
                                }
                                Logger.dd("CustomGeofenAction", str);
                            } catch (Throwable th) {
                                Logger.dd("CustomGeofenAction", "request location error#" + th);
                            }
                            a.this.l.set(false);
                            return;
                        case 1002:
                            break;
                        default:
                            return;
                    }
                    a.this.f();
                }
            };
        } catch (Throwable th) {
            Logger.ww("CustomGeofenAction", "init geofence handler failed:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str;
        try {
            if (this.k == null) {
                str = "Location listener is null , do nothing!";
            } else if (this.f4281e != null) {
                this.f4281e.removeUpdates(this.k);
            } else {
                str = "locationManager is null , do nothing!";
            }
            Logger.w("CustomGeofenAction", str);
        } catch (Throwable th) {
            Logger.w("CustomGeofenAction", "remove location listener failed  e:" + th.getMessage());
        }
    }

    private void e(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        bVar.o = currentTimeMillis;
        Date date = new Date(currentTimeMillis);
        String format = g.a("yyyy-DDD").format(date);
        if (format.equals(bVar.r)) {
            bVar.s++;
        } else {
            bVar.r = format;
            bVar.s = 1;
        }
        String format2 = g.a("yyyy-ww").format(date);
        if (format2.equals(bVar.p)) {
            bVar.f4290q++;
            return;
        }
        bVar.p = format2;
        bVar.f4290q = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Logger.d("CustomGeofenAction", "try locate...");
        if (!cn.jpush.android.u.a.a(this.f4291a, "android.permission.ACCESS_FINE_LOCATION")) {
            Logger.w("CustomGeofenAction", "Require the permissionandroid.permission.ACCESS_FINE_LOCATION");
            Logger.dd("CustomGeofenAction", "No location permission!");
            return;
        }
        Logger.d("CustomGeofenAction", "sdk int:" + Build.VERSION.SDK_INT + ",targetSdkVersion:" + this.f4291a.getApplicationInfo().targetSdkVersion);
        if (JPushConstants.canGetLbsInBackGround(this.f4291a)) {
            if (!h()) {
                Logger.dd("CustomGeofenAction", "No enabled provider");
            } else if (this.f4292b.size() <= 0) {
                a();
            } else if (this.l.get()) {
                Logger.d("CustomGeofenAction", "isLocating...");
            } else {
                g();
            }
        }
    }

    private boolean f(b bVar) {
        StringBuilder sb;
        int i;
        String sb2;
        if (bVar.o <= 0) {
            return true;
        }
        if (bVar.f4288d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (bVar.n <= 0 || bVar.o <= 0 || currentTimeMillis >= bVar.o + (bVar.n * 1000)) {
                if (bVar.m > 0 && !TextUtils.isEmpty(bVar.r)) {
                    if (bVar.r.equals(g.a("yyyy-DDD").format(new Date(currentTimeMillis))) && bVar.s >= bVar.m) {
                        sb = new StringBuilder();
                        sb.append("today already repeat enough:");
                        sb.append(bVar.s);
                        sb.append("/");
                        i = bVar.m;
                        sb.append(i);
                    }
                }
                if (bVar.l > 0 && !TextUtils.isEmpty(bVar.p)) {
                    if (bVar.p.equals(g.a("yyyy-ww").format(new Date(currentTimeMillis))) && bVar.f4290q >= bVar.l) {
                        sb = new StringBuilder();
                        sb.append("this week already repeat enough:");
                        sb.append(bVar.f4290q);
                        sb.append("/");
                        i = bVar.l;
                        sb.append(i);
                    }
                }
                return true;
            }
            sb = new StringBuilder();
            sb.append("in ");
            sb.append(bVar.n);
            sb.append("s, can't repeat geofence");
            sb2 = sb.toString();
        } else {
            sb2 = "can't repeat geofence";
        }
        Logger.d("CustomGeofenAction", sb2);
        return false;
    }

    private void g() {
        String str;
        try {
            if (this.f4281e == null) {
                Logger.ww("CustomGeofenAction", "locationManager is null");
                return;
            }
            Location lastKnownLocation = this.f4281e.getLastKnownLocation("gps");
            Location lastKnownLocation2 = this.f4281e.getLastKnownLocation("network");
            Location lastKnownLocation3 = this.f4281e.getLastKnownLocation("passive");
            Logger.v("CustomGeofenAction", "gpsLocation:" + lastKnownLocation);
            Logger.v("CustomGeofenAction", "netLocation:" + lastKnownLocation2);
            Logger.v("CustomGeofenAction", "passLocation:" + lastKnownLocation3);
            long time = lastKnownLocation == null ? 0L : lastKnownLocation.getTime();
            long time2 = lastKnownLocation2 == null ? 0L : lastKnownLocation2.getTime();
            long time3 = lastKnownLocation3 == null ? 0L : lastKnownLocation3.getTime();
            if (time > time2) {
                if (time > time3) {
                }
                lastKnownLocation = lastKnownLocation3;
            } else {
                if (time2 > time3) {
                    lastKnownLocation = lastKnownLocation2;
                }
                lastKnownLocation = lastKnownLocation3;
            }
            if (System.currentTimeMillis() - (lastKnownLocation != null ? lastKnownLocation.getTime() : 0L) < 30000) {
                StringBuilder sb = new StringBuilder();
                sb.append("need not restart gpslocation,the time with last:");
                sb.append(System.currentTimeMillis() - (lastKnownLocation != null ? lastKnownLocation.getTime() : 0L));
                Logger.dd("CustomGeofenAction", sb.toString());
                a(lastKnownLocation);
                return;
            }
            this.i = null;
            if (this.f4281e.isProviderEnabled("gps")) {
                this.i = "gps";
            } else if (this.f4281e.isProviderEnabled("network")) {
                this.i = "network";
            }
            Logger.d("CustomGeofenAction", "provider " + this.i);
            if (TextUtils.isEmpty(this.i)) {
                Logger.dd("CustomGeofenAction", "not gps nor network provider,stop scan geofence");
                return;
            }
            this.l.set(true);
            this.f4281e.requestLocationUpdates(this.i, 2000L, 0.0f, this.k);
            this.f.sendEmptyMessageDelayed(DefaultWebClient.DERECT_OPEN_OTHER_PAGE, this.h);
        } catch (SecurityException unused) {
            str = "No suitable permission when get last known location!";
            Logger.ww("CustomGeofenAction", str);
        } catch (Throwable th) {
            str = "The provider is illegal argument!" + th;
            Logger.ww("CustomGeofenAction", str);
        }
    }

    private boolean h() {
        String str;
        try {
            if (this.f4281e != null) {
                if (!this.f4281e.isProviderEnabled("gps") && !this.f4281e.isProviderEnabled("network")) {
                    if (!this.f4281e.isProviderEnabled("passive")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
            str = "The provider [gps] is illegal argument!";
            Logger.ww("CustomGeofenAction", str);
            return false;
        } catch (SecurityException unused2) {
            str = "No suitable permission is present when get GPS_PROVIDER!";
            Logger.ww("CustomGeofenAction", str);
            return false;
        } catch (Throwable th) {
            str = "Check GPS enable failed:" + th;
            Logger.ww("CustomGeofenAction", str);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jpush.android.b.c
    public synchronized void a() {
        Logger.dd("CustomGeofenAction", "geofence size:" + this.f4292b.size());
        Logger.dd("CustomGeofenAction", "stop listen geofence");
        if (this.j) {
            if (this.f != null) {
                this.f.removeMessages(1000);
            }
            this.j = false;
        }
    }

    @Override // cn.jpush.android.b.c
    public void a(long j) {
        Logger.dd("CustomGeofenAction", "Set geofence interval " + j);
        this.g = j;
        this.f4280d = j;
        cn.jpush.android.cache.a.b(this.f4291a, j);
    }

    @Override // cn.jpush.android.b.c
    protected void a(b bVar) {
        Handler handler;
        Logger.dd("CustomGeofenAction", "Geofence create success, id=" + bVar.f4285a);
        if (!this.j || (handler = this.f) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    protected void a(b bVar, b bVar2) {
        Handler handler;
        Logger.dd("CustomGeofenAction", "Geofence update success, id=" + bVar.f4285a);
        if (!this.j || (handler = this.f) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    public synchronized void b() {
        Logger.dd("CustomGeofenAction", "start listen geofence");
        if (!cn.jpush.android.cache.a.j(this.f4291a)) {
            Logger.ww("CustomGeofenAction", "lbs is disable!");
        } else if (this.j) {
            Logger.ii("CustomGeofenAction", "geofence is running!");
        } else if (this.f4292b.size() == 0) {
            Logger.dd("CustomGeofenAction", "No geofence,not need listen");
        } else {
            if (this.f == null) {
                d();
            }
            b(0L);
            this.j = true;
        }
    }

    @Override // cn.jpush.android.b.c
    protected void b(b bVar) {
        Logger.dd("CustomGeofenAction", "Geofence delete success, id=" + bVar.f4285a);
    }
}
