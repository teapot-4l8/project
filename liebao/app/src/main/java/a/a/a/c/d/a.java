package a.a.a.c.d;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HttpBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private String f65b;

    /* renamed from: c  reason: collision with root package name */
    private int f66c;

    /* renamed from: d  reason: collision with root package name */
    private int f67d;

    /* renamed from: e  reason: collision with root package name */
    private int f68e;
    private int f;
    private double g;
    private String h = "*";
    private String i = "*";
    private boolean j;
    private List<Map<Object, String>> k;
    private int l;

    public void a(int i) {
        this.f = i;
    }

    public String c() {
        return this.f65b;
    }

    public void a(String str) {
        this.f65b = str;
    }

    public void b(int i) {
        this.f66c = i;
    }

    public void c(int i) {
        this.f67d = i;
    }

    public void d(int i) {
        this.f68e = i;
    }

    public void a(double d2) {
        this.g = d2;
    }

    public void b(String str) {
        this.h = str;
    }

    public void c(String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void a(List<Map<Object, String>> list) {
        this.k = list;
    }

    public void e(int i) {
        this.l = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "执行结果" : "status", this.l);
            this.f39a.put(b() ? "网址" : "address", this.f65b);
            JSONObject jSONObject = this.f39a;
            String str = b() ? "用时" : "time";
            jSONObject.put(str, this.f + "ms");
            JSONObject jSONObject2 = this.f39a;
            String str2 = b() ? "总消耗时间" : "totalTime";
            jSONObject2.put(str2, this.f66c + "ms");
            JSONObject jSONObject3 = this.f39a;
            String str3 = b() ? "速度" : "speed";
            jSONObject3.put(str3, this.f67d + "kbps");
            this.f39a.put(b() ? "请求状态" : "responseCode", this.f68e);
            this.f39a.put(b() ? "下载大小" : "size", String.format("%.1fKB", new BigDecimal(this.g)));
            this.f39a.put(b() ? "服务器" : "headerServer", this.h);
            this.f39a.put(b() ? "校验服务器" : "checkHeaderServer", this.i);
            this.f39a.put(b() ? "跳转" : "isJump", this.j);
            this.f39a.put(b() ? "返回header" : "header", new JSONArray((Collection) this.k));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.a();
    }
}
