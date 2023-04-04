package a.a.a.e;

import a.a.a.b.f;
import com.umeng.analytics.pro.ak;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Output.java */
/* loaded from: classes.dex */
public class l {

    /* compiled from: Output.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(Exception exc);

        void a(T t);
    }

    public static void a(final a<String> aVar, String str) {
        a.a.a.b.f c2 = a.a.a.a.a().c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", str);
            jSONObject.put("ver", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c2.a(new a.a.a.b.b("https://huatuo.qq.com/Report/GetIsp", a.a.a.b.h.POST, new a.a.a.b.g(jSONObject)));
        c2.a(new f.a<String>() { // from class: a.a.a.e.l.1
            @Override // a.a.a.b.f.a
            public void a(String str2) {
                f.a("outputIp info success:" + str2);
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    a aVar2 = a.this;
                    aVar2.a((a) (jSONObject2.getString(ak.O) + jSONObject2.getString("province") + jSONObject2.getString("isp")));
                } catch (JSONException e3) {
                    a.this.a((Exception) e3);
                }
            }

            @Override // a.a.a.b.f.a
            public void a(Exception exc) {
                f.b("outputIp info fail:" + exc.toString());
                a.this.a(exc);
            }
        });
    }
}
