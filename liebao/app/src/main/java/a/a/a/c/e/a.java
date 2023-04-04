package a.a.a.c.e;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IndexBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private String f69b = "*";

    /* renamed from: c  reason: collision with root package name */
    private String f70c = "*";

    public void a(String str) {
        this.f69b = str;
    }

    public void b(String str) {
        this.f70c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "测速地址" : "address", this.f69b);
            this.f39a.put(b() ? "请求时间" : "time", this.f70c);
        } catch (JSONException unused) {
        }
        return super.a();
    }
}
