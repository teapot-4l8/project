package cn.jiguang.l;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.f.i;
import cn.jiguang.o.f;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.analytics.pro.ak;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends cn.jiguang.o.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f4131c;

    /* renamed from: a  reason: collision with root package name */
    private Context f4132a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f4133b;

    /* renamed from: d  reason: collision with root package name */
    private String f4134d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4135e;

    public static b a() {
        if (f4131c == null) {
            synchronized (b.class) {
                f4131c = new b();
            }
        }
        return f4131c;
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<cn.jiguang.m.a> list) {
        try {
            if (this.f4133b == null) {
                this.f4133b = new JSONObject();
            }
            this.f4133b.put("ssid", str);
            this.f4133b.put("bssid", str2);
            this.f4133b.put(ak.S, str3);
            this.f4133b.put("local_mac", str4);
            this.f4133b.put("netmask", str5);
            this.f4133b.put("gateway", str8);
            this.f4133b.put("dhcp", str9);
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str6)) {
                jSONArray.put(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONArray.put(str7);
            }
            this.f4133b.put("dns", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cn.jiguang.m.a aVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", aVar.f4136a);
                jSONObject.put("mac", aVar.f4139d);
                jSONArray2.put(jSONObject);
            }
            this.f4133b.put(JThirdPlatFormInterface.KEY_DATA, jSONArray2);
        } catch (JSONException e2) {
            cn.jiguang.ad.a.d("JArp", "packageJson exception: " + e2.getMessage());
        }
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4132a = context;
        return "JArp";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        String str2;
        String str3;
        if (!cn.jiguang.f.a.c(context, "android.permission.ACCESS_WIFI_STATE")) {
            cn.jiguang.ad.a.d("JArp", "collect arp failed because has no permission Manifest.permission.ACCESS_WIFI_STATE");
        } else if (!cn.jiguang.f.a.j(context).toUpperCase().startsWith("WIFI")) {
            cn.jiguang.ad.a.d("JArp", "collect arp failed because networkType is not wifi");
        } else if (TextUtils.isEmpty(cn.jiguang.d.a.b(context))) {
            cn.jiguang.ad.a.d("JArp", "collect arp failed because can't get registerId");
        } else {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                cn.jiguang.ad.a.a("JArp", "collect arp failed because get wifiManager failed");
                return;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                str3 = i.b(connectionInfo.getSSID());
                str2 = connectionInfo.getBSSID();
            } else {
                str2 = "";
                str3 = str2;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            this.f4134d = TextUtils.isEmpty(str2) ? str3 : str2;
            if (f.c(context) && f.m(context, this.f4134d)) {
                cn.jiguang.ad.a.d("JArp", "collect arp failed because this wifi 【" + this.f4134d + "】 can't report twice");
                return;
            }
            boolean d2 = d(context, "JArp");
            if (!this.f4135e && !d2) {
                cn.jiguang.ad.a.d("JArp", "collect arp failed because this wifi 【" + this.f4134d + "】 is not in report time");
                return;
            }
            this.f4135e = false;
            DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
            if (dhcpInfo == null) {
                return;
            }
            long j = dhcpInfo.ipAddress;
            byte[] bArr = {(byte) (j & 255), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
            String a2 = cn.jiguang.n.a.a(dhcpInfo.ipAddress);
            if (TextUtils.equals(a2, "0.0.0.0")) {
                a2 = "";
            }
            String f = cn.jiguang.f.a.f(context, "");
            String a3 = cn.jiguang.n.a.a(dhcpInfo.netmask);
            String str4 = TextUtils.equals(a3, "0.0.0.0") ? "" : a3;
            String a4 = cn.jiguang.n.a.a(dhcpInfo.dns1);
            String str5 = TextUtils.equals(a4, "0.0.0.0") ? "" : a4;
            String a5 = cn.jiguang.n.a.a(dhcpInfo.dns2);
            String str6 = TextUtils.equals(a5, "0.0.0.0") ? "" : a5;
            String a6 = cn.jiguang.n.a.a(dhcpInfo.gateway);
            String str7 = TextUtils.equals(a6, "0.0.0.0") ? "" : a6;
            String a7 = cn.jiguang.n.a.a(dhcpInfo.serverAddress);
            String str8 = TextUtils.equals(a7, "0.0.0.0") ? "" : a7;
            cn.jiguang.n.a.a(str8, bArr);
            List<cn.jiguang.m.a> a8 = cn.jiguang.n.a.a(str8);
            if (a8 == null || a8.isEmpty()) {
                cn.jiguang.ad.a.d("JArp", "collect arp failed because can't get arp info");
                return;
            }
            cn.jiguang.ad.a.a("JArp", "collect arp success");
            a(str3, str2, a2, f, str4, str5, str6, str7, str8, a8);
        }
    }

    @Override // cn.jiguang.o.a
    protected final void a(JSONObject jSONObject) {
        this.f4135e = true;
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        boolean z = !optJSONObject.optBoolean("disable");
        f.a(this.f4132a, "JArp", z);
        if (z) {
            long optLong = optJSONObject.optLong("frequency", 0L) * 1000;
            if (optLong == 0) {
                f.a(this.f4132a, true);
                return;
            }
            f.a(this.f4132a, false);
            f.b(this.f4132a, "JArp", optLong);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        JSONObject jSONObject = this.f4133b;
        if (jSONObject == null) {
            cn.jiguang.ad.a.a("JArp", "there are no data to report");
            return;
        }
        cn.jiguang.d.a.a(context, jSONObject, "mac_list");
        cn.jiguang.o.i.a(context, this.f4133b, new a(this.f4134d, context, "JArp", str));
        this.f4133b = null;
    }

    @Override // cn.jiguang.o.a
    protected final boolean c() {
        return f.h(this.f4132a, "JArp");
    }

    @Override // cn.jiguang.o.a
    protected final boolean c(Context context, String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean d(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.f4134d)) {
            this.f4134d = "";
        }
        StringBuilder sb = new StringBuilder("JArp");
        sb.append(this.f4134d);
        return currentTimeMillis - f.f(context, sb.toString()) > f.g(context, "JArp");
    }
}
