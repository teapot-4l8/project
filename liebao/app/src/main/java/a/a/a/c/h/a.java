package a.a.a.c.h;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PingBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private String f79b = "*";

    /* renamed from: c  reason: collision with root package name */
    private String f80c = "*";

    /* renamed from: d  reason: collision with root package name */
    private float f81d;

    /* renamed from: e  reason: collision with root package name */
    private int f82e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;

    public void a(String str) {
        this.f79b = str;
    }

    public void a(int i) {
        this.m = i;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c(int i) {
        this.l = i;
    }

    public void b(String str) {
        this.f80c = str;
    }

    public void a(float f) {
        this.f81d = f;
    }

    public void d(int i) {
        this.f82e = i;
    }

    public void b(float f) {
        this.f = f;
    }

    public void c(float f) {
        this.g = f;
    }

    public void d(float f) {
        this.h = f;
    }

    public void e(float f) {
        this.i = f;
    }

    public void e(int i) {
        this.j = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "网址" : "address", this.f79b);
            this.f39a.put(b() ? "执行结果" : "status", this.k);
            this.f39a.put(b() ? "IP地址" : "ip", this.f80c);
            this.f39a.put(b() ? "生存时间" : "ttl", this.j);
            this.f39a.put(b() ? "发送包" : "transmitted", this.l);
            this.f39a.put(b() ? "接收包" : "receive", this.f82e);
            JSONObject jSONObject = this.f39a;
            String str = b() ? "丢包率" : "lossRate";
            jSONObject.put(str, this.f81d + "%");
            JSONObject jSONObject2 = this.f39a;
            String str2 = b() ? "最小RTT" : "rttMin";
            jSONObject2.put(str2, this.i + "ms");
            JSONObject jSONObject3 = this.f39a;
            String str3 = b() ? "平均RTT" : "rttAvg";
            jSONObject3.put(str3, this.f + "ms");
            JSONObject jSONObject4 = this.f39a;
            String str4 = b() ? "最大RTT" : "rttMax";
            jSONObject4.put(str4, this.h + "ms");
            JSONObject jSONObject5 = this.f39a;
            String str5 = b() ? "算术平均偏差RTT" : "rttMDev";
            jSONObject5.put(str5, this.g + "ms");
            JSONObject jSONObject6 = this.f39a;
            String str6 = b() ? "总消耗时间" : "allTime";
            jSONObject6.put(str6, this.m + "ms");
        } catch (JSONException unused) {
        }
        return super.a();
    }
}
