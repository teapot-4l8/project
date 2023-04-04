package a.a.a.c.i;

import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PortBean.java */
/* loaded from: classes.dex */
public class a extends a.a.a.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private String f83b = "*";

    /* renamed from: c  reason: collision with root package name */
    private List<JSONObject> f84c;

    /* renamed from: d  reason: collision with root package name */
    private int f85d;

    /* renamed from: e  reason: collision with root package name */
    private int f86e;

    public void a(String str) {
        this.f83b = str;
    }

    public void a(List<JSONObject> list) {
        this.f84c = list;
    }

    public void a(int i) {
        this.f85d = i;
    }

    public void b(int i) {
        this.f86e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.a.a.c.a.a
    public JSONObject a() {
        try {
            this.f39a.put(b() ? "网址" : "address", this.f83b);
            this.f39a.put(b() ? "执行结果" : "status", this.f85d);
            JSONObject jSONObject = this.f39a;
            String str = b() ? "总消耗时间" : "totalTime";
            jSONObject.put(str, this.f86e + "ms");
            this.f39a.put(b() ? "具体信息" : "portNet", new JSONArray((Collection) this.f84c));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return super.a();
    }

    /* compiled from: PortBean.java */
    /* renamed from: a.a.a.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002a extends a.a.a.c.a.a {

        /* renamed from: b  reason: collision with root package name */
        private long f87b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f88c;

        /* renamed from: d  reason: collision with root package name */
        private int f89d;

        public void a(long j) {
            this.f87b = j;
        }

        public boolean c() {
            return this.f88c;
        }

        public void a(boolean z) {
            this.f88c = z;
        }

        public int d() {
            return this.f89d;
        }

        public void a(int i) {
            this.f89d = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a.a.a.c.a.a
        public JSONObject a() {
            try {
                JSONObject jSONObject = this.f39a;
                String str = b() ? "扫描时间" : "delay";
                jSONObject.put(str, this.f87b + "ms");
                this.f39a.put(b() ? "是否开放" : "isConnected", this.f88c);
                this.f39a.put(b() ? "端口号" : "port", this.f89d);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return super.a();
        }
    }
}
