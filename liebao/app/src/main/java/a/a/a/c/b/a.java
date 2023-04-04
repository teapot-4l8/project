package a.a.a.c.b;

import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DnsBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private List<JSONObject> f40b;

    /* renamed from: c  reason: collision with root package name */
    private List<JSONObject> f41c;

    /* renamed from: d  reason: collision with root package name */
    private int f42d;

    /* renamed from: e  reason: collision with root package name */
    private int f43e;

    public void a(List<JSONObject> list) {
        this.f41c = list;
    }

    public void b(List<JSONObject> list) {
        this.f40b = list;
    }

    public void a(int i) {
        this.f42d = i;
    }

    public void b(int i) {
        this.f43e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            JSONObject jSONObject = this.f39a;
            String str = b() ? "总消耗时间" : "totalTime";
            jSONObject.put(str, this.f42d + "ms");
            this.f39a.put(b() ? "执行结果" : "status", this.f43e);
            this.f39a.put(b() ? "本地DNS服务器" : "localDns", new JSONArray((Collection) this.f40b));
            this.f39a.put(b() ? "解析策略" : "strategy", new JSONArray((Collection) this.f41c));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.a();
    }

    /* compiled from: DnsBean.java */
    /* loaded from: classes.dex */
    public static class b extends a.a.a.c.a.a {

        /* renamed from: b  reason: collision with root package name */
        private String f48b;

        /* renamed from: c  reason: collision with root package name */
        private String f49c;

        public void a(String str) {
            this.f48b = str;
        }

        public void b(String str) {
            this.f49c = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a.a.a.c.a.a
        public JSONObject a() {
            try {
                this.f39a.put(b() ? "具体IP" : "ip", this.f48b);
                this.f39a.put(b() ? "归属地" : "param", this.f49c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.a();
        }
    }

    /* compiled from: DnsBean.java */
    /* renamed from: a.a.a.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0001a extends a.a.a.c.a.a {

        /* renamed from: b  reason: collision with root package name */
        private String f44b = "*";

        /* renamed from: c  reason: collision with root package name */
        private String f45c = "*";

        /* renamed from: d  reason: collision with root package name */
        private int f46d;

        /* renamed from: e  reason: collision with root package name */
        private int f47e;
        private List<JSONObject> f;

        public void a(String str) {
            this.f44b = str;
        }

        public void b(String str) {
            this.f45c = str;
        }

        public void a(int i) {
            this.f46d = i;
        }

        public void b(int i) {
            this.f47e = i;
        }

        public void a(List<JSONObject> list) {
            this.f = list;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a.a.a.c.a.a
        public JSONObject a() {
            try {
                this.f39a.put(b() ? "策略内容" : "strategyParam", this.f44b);
                this.f39a.put(b() ? "域名" : "strategyAddress", this.f45c);
                this.f39a.put(b() ? "结果" : "strategyStatus", this.f46d);
                JSONObject jSONObject = this.f39a;
                String str = b() ? "用时" : "strategyTime";
                jSONObject.put(str, this.f47e + "ms");
                this.f39a.put(b() ? "IP地址" : "strategyIp", new JSONArray((Collection) this.f));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.a();
        }
    }
}
