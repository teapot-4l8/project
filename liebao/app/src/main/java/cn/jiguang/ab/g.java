package cn.jiguang.ab;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3661a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3661a = fVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        String str;
        try {
            StringBuilder sb = new StringBuilder("onLocationChanged:");
            sb.append(location);
            sb.append(",provider:");
            str = this.f3661a.g;
            sb.append(str);
            cn.jiguang.ad.a.a("JLocationGps", sb.toString());
            this.f3661a.a(location);
            f.b(this.f3661a);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JLocationGps", "onLocationChanged failed:" + th.getMessage());
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        cn.jiguang.ad.a.a("JLocationGps", "onProviderDisabled:" + str);
        f.b(this.f3661a);
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        cn.jiguang.ad.a.a("JLocationGps", "onProviderEnabled:" + str);
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
        cn.jiguang.ad.a.a("JLocationGps", "onStatusChanged status:" + i);
        if (i == 0) {
            f.b(this.f3661a);
        }
    }
}
