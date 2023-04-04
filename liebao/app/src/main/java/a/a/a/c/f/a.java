package a.a.a.c.f;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MtuBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private int f71b;

    /* renamed from: c  reason: collision with root package name */
    private int f72c;

    /* renamed from: d  reason: collision with root package name */
    private int f73d;

    public void a(int i) {
        this.f73d = i;
    }

    public void b(int i) {
        this.f71b = i;
    }

    public void c(int i) {
        this.f72c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "执行结果" : "status", this.f71b);
            JSONObject jSONObject = this.f39a;
            String str = b() ? "传输单元" : "mtu";
            jSONObject.put(str, this.f72c + "bytes");
            JSONObject jSONObject2 = this.f39a;
            String str2 = b() ? "总消耗时间" : "totalTime";
            jSONObject2.put(str2, this.f73d + "ms");
        } catch (JSONException unused) {
        }
        return super.a();
    }
}
