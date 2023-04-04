package a.a.a.c.c;

import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HostBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private int f56b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f57c;

    /* renamed from: d  reason: collision with root package name */
    private int f58d;

    public void a(int i) {
        this.f58d = i;
    }

    public void b(int i) {
        this.f56b = i;
    }

    public void a(List<String> list) {
        this.f57c = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "执行结果" : "status", this.f56b);
            this.f39a.put(b() ? "详细信息" : "param", new JSONArray((Collection) this.f57c));
            JSONObject jSONObject = this.f39a;
            String str = b() ? "总消耗时间" : "totalTime";
            jSONObject.put(str, this.f58d + "ms");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.a();
    }
}
