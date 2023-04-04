package cn.jiguang.ab;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.just.agentweb.DefaultWebClient;
import com.tencent.bugly.CrashModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3662a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, Looper looper) {
        super(looper);
        this.f3662a = fVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        LocationManager locationManager;
        String str2;
        LocationListener locationListener;
        String str3;
        String str4;
        String str5;
        String str6;
        LocationManager locationManager2;
        String str7;
        LocationListener locationListener2;
        String str8;
        String str9;
        int i = message.what;
        int i2 = DefaultWebClient.DERECT_OPEN_OTHER_PAGE;
        switch (i) {
            case DefaultWebClient.DERECT_OPEN_OTHER_PAGE /* 1001 */:
                try {
                    str4 = this.f3662a.g;
                    if (str4 != null) {
                        str6 = this.f3662a.g;
                        if (str6.equals("network")) {
                            cn.jiguang.ad.a.d("JLocationGps", "get gps with network time out ");
                            this.f3662a.g = "gps";
                            this.f3662a.f();
                            locationManager2 = this.f3662a.f3659c;
                            str7 = this.f3662a.g;
                            locationListener2 = this.f3662a.i;
                            locationManager2.requestLocationUpdates(str7, 2000L, 0.0f, locationListener2);
                            StringBuilder sb = new StringBuilder("request ");
                            str8 = this.f3662a.g;
                            sb.append(str8);
                            sb.append(" location");
                            cn.jiguang.ad.a.a("JLocationGps", sb.toString());
                            this.f3662a.f3657a.sendEmptyMessageDelayed(DefaultWebClient.DERECT_OPEN_OTHER_PAGE, 10000L);
                            return;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder("get ");
                    str5 = this.f3662a.g;
                    sb2.append(str5);
                    sb2.append(" time out ");
                    cn.jiguang.ad.a.d("JLocationGps", sb2.toString());
                    f.b(this.f3662a);
                    return;
                } catch (Throwable th) {
                    str = "when location time out " + th.getMessage();
                    break;
                }
            case 1002:
            default:
                return;
            case 1003:
                try {
                    locationManager = this.f3662a.f3659c;
                    str2 = this.f3662a.g;
                    locationListener = this.f3662a.i;
                    locationManager.requestLocationUpdates(str2, 2000L, 0.0f, locationListener);
                    StringBuilder sb3 = new StringBuilder("request ");
                    str3 = this.f3662a.g;
                    sb3.append(str3);
                    sb3.append(" location");
                    cn.jiguang.ad.a.a("JLocationGps", sb3.toString());
                    this.f3662a.f3657a.sendEmptyMessageDelayed(i2, 20000L);
                    return;
                } catch (SecurityException unused) {
                    str = "No suitable permission when get last known location!";
                    break;
                } catch (Throwable unused2) {
                    cn.jiguang.ad.a.d("JLocationGps", "The provider is illegal argument!");
                    f.b(this.f3662a);
                    return;
                }
            case CrashModule.MODULE_ID /* 1004 */:
                cn.jiguang.ad.a.a("JLocationGps", "LOAD_GPS_ACTION_REQUEST_ONLY_NETWORK");
                i2 = 1005;
                locationManager = this.f3662a.f3659c;
                str2 = this.f3662a.g;
                locationListener = this.f3662a.i;
                locationManager.requestLocationUpdates(str2, 2000L, 0.0f, locationListener);
                StringBuilder sb32 = new StringBuilder("request ");
                str3 = this.f3662a.g;
                sb32.append(str3);
                sb32.append(" location");
                cn.jiguang.ad.a.a("JLocationGps", sb32.toString());
                this.f3662a.f3657a.sendEmptyMessageDelayed(i2, 20000L);
                return;
            case 1005:
                StringBuilder sb4 = new StringBuilder("get only network ");
                str9 = this.f3662a.g;
                sb4.append(str9);
                sb4.append(" time out ");
                str = sb4.toString();
                cn.jiguang.ad.a.d("JLocationGps", str);
                f.b(this.f3662a);
                return;
        }
    }
}
