package a.a.a.c.g;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private boolean f74b;

    /* renamed from: c  reason: collision with root package name */
    private String f75c;

    /* renamed from: d  reason: collision with root package name */
    private int f76d;

    /* renamed from: e  reason: collision with root package name */
    private String f77e = "*";
    private String f = "*";
    private String g = "*";
    private String h = "*";
    private String i = "*";
    private String j = "*";
    private boolean k;
    private int l;
    private int m;
    private int n;
    private String o;
    private int p;

    /* renamed from: q  reason: collision with root package name */
    private String f78q;
    private String r;
    private int s;

    public void a(int i) {
        this.s = i;
    }

    public void a(String str) {
        this.j = str;
    }

    public void b(String str) {
        this.r = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.o = str;
    }

    public void b(int i) {
        this.p = i;
    }

    public void e(String str) {
        this.f78q = str;
    }

    public void a(boolean z) {
        this.f74b = z;
    }

    public void f(String str) {
        this.f75c = str;
    }

    public void c(int i) {
        this.f76d = i;
    }

    public void g(String str) {
        this.f77e = str;
    }

    public void h(String str) {
        this.f = str;
    }

    public void i(String str) {
        this.h = str;
    }

    public void j(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void d(int i) {
        this.l = i;
    }

    public void e(int i) {
        this.m = i;
    }

    public void f(int i) {
        this.n = i;
    }

    public int c() {
        return this.f76d;
    }

    public int d() {
        return this.n;
    }

    public int e() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "网络状态" : "isNetworkAvailable", this.f74b);
            this.f39a.put(b() ? "网络类型" : "netWorkType", this.f75c);
            this.f39a.put(b() ? "网络制式" : "mobileType", this.r);
            this.f39a.put(b() ? "WIFI状态" : "isWifiOpen", "WIFI".equals(this.f75c));
            this.f39a.put(b() ? "WIFI信号强度" : "wifiRssi", this.f76d);
            this.f39a.put(b() ? "WIFI信号等级" : "wifiLevel", this.p);
            this.f39a.put(b() ? "WIFI信号评定" : "wifiLevelValue", this.f78q);
            this.f39a.put(b() ? "本地IP" : "ip", this.f77e);
            this.f39a.put(b() ? "出口IP" : "outputIp", this.f);
            this.f39a.put(b() ? "出口IP归属地" : "outputIpCountry", this.g);
            this.f39a.put(b() ? "本地DNS" : "dns", this.h);
            this.f39a.put(b() ? "出口DNS" : "outputDns", this.i);
            this.f39a.put(b() ? "出口DNS归属地" : "outputDnsCountry", this.j);
            this.f39a.put(b() ? "漫游状态" : "isRoaming", this.k);
            this.f39a.put(b() ? "手机信号电平值" : "mobAsu", this.m);
            this.f39a.put(b() ? "手机信号强度" : "mobDbm", this.l);
            this.f39a.put(b() ? "手机信号等级" : "mobLevel", this.n);
            this.f39a.put(b() ? "手机信号评定" : "mobLevelValue", this.o);
            JSONObject jSONObject = this.f39a;
            String str = b() ? "总消耗时间" : "totalTime";
            jSONObject.put(str, this.s + "ms");
        } catch (JSONException unused) {
        }
        return super.a();
    }
}
