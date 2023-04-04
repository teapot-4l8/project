package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import cn.jiguang.internal.JConstants;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a  reason: collision with root package name */
    private static m f641a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f642b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationManager f643c;

    /* renamed from: d  reason: collision with root package name */
    private final a f644d = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Context context) {
        if (f641a == null) {
            Context applicationContext = context.getApplicationContext();
            f641a = new m(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f641a;
    }

    m(Context context, LocationManager locationManager) {
        this.f642b = context;
        this.f643c = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.f644d;
        if (c()) {
            return aVar.f645a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f645a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location b() {
        Location a2 = androidx.core.content.c.a(this.f642b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location a3 = androidx.core.content.c.a(this.f642b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (a3 == null || a2 == null) ? a3 != null ? a3 : a2 : a3.getTime() > a2.getTime() ? a3 : a2;
    }

    private Location a(String str) {
        try {
            if (this.f643c.isProviderEnabled(str)) {
                return this.f643c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean c() {
        return this.f644d.f > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        a aVar = this.f644d;
        long currentTimeMillis = System.currentTimeMillis();
        l a2 = l.a();
        a2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.f638a;
        a2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.f640c == 1;
        long j3 = a2.f639b;
        long j4 = a2.f638a;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a2.f639b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + JConstants.MIN;
        }
        aVar.f645a = z2;
        aVar.f646b = j2;
        aVar.f647c = j3;
        aVar.f648d = j4;
        aVar.f649e = j5;
        aVar.f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TwilightManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f645a;

        /* renamed from: b  reason: collision with root package name */
        long f646b;

        /* renamed from: c  reason: collision with root package name */
        long f647c;

        /* renamed from: d  reason: collision with root package name */
        long f648d;

        /* renamed from: e  reason: collision with root package name */
        long f649e;
        long f;

        a() {
        }
    }
}
