package a.a.a.c.j;

import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TraceRouteBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private int f92b;

    /* renamed from: c  reason: collision with root package name */
    private int f93c;

    /* renamed from: d  reason: collision with root package name */
    private List<JSONObject> f94d;

    public void a(int i) {
        this.f92b = i;
    }

    public void b(int i) {
        this.f93c = i;
    }

    public void a(List<JSONObject> list) {
        this.f94d = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "执行结果" : "status", this.f92b);
            JSONObject jSONObject = this.f39a;
            String str = b() ? "总消耗时间" : "totalTime";
            jSONObject.put(str, this.f93c + "ms");
            this.f39a.put(b() ? "扫描结果" : "traceRoute", new JSONArray((Collection) this.f94d));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.a();
    }

    /* compiled from: TraceRouteBean.java */
    /* renamed from: a.a.a.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a extends a.a.a.c.a.a {

        /* renamed from: b  reason: collision with root package name */
        private int f95b;

        /* renamed from: c  reason: collision with root package name */
        private String f96c = "*";

        /* renamed from: d  reason: collision with root package name */
        private String f97d = "*";

        /* renamed from: e  reason: collision with root package name */
        private String f98e = "*";

        public void a(int i) {
            this.f95b = i;
        }

        public String c() {
            return this.f96c;
        }

        public void a(String str) {
            this.f96c = str;
        }

        public void b(String str) {
            this.f97d = str;
        }

        public void c(String str) {
            this.f98e = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a.a.a.c.a.a
        public JSONObject a() {
            try {
                this.f39a.put(b() ? "生存时间" : "ttl", this.f95b);
                this.f39a.put(b() ? "IP地址" : "ip", this.f96c);
                this.f39a.put(b() ? "扫描时间" : "time", this.f97d.replace(" ", ""));
                this.f39a.put(b() ? "IP归属地" : "address", this.f98e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.a();
        }
    }
}
