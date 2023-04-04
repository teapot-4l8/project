package cn.jiguang.ar;

import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public int f3851a;

    /* renamed from: b  reason: collision with root package name */
    public String f3852b;

    /* renamed from: c  reason: collision with root package name */
    public String f3853c;

    /* renamed from: d  reason: collision with root package name */
    public long f3854d;

    /* renamed from: e  reason: collision with root package name */
    public String f3855e;
    public double f;
    public double g;
    public long h;
    private int i = 0;
    private int j = 0;

    public p(int i, String str, String str2, long j, String str3, double d2, double d3, long j2) {
        this.f3851a = i;
        this.f3852b = str;
        this.f3853c = str2;
        this.f3854d = j;
        this.f3855e = str3;
        this.f = d2;
        this.g = d3;
        this.h = j2;
    }

    public final JSONObject a(Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.umeng.analytics.pro.d.y, this.f3851a);
            jSONObject.put("appkey", this.f3852b);
            jSONObject.put("sdkver", this.f3853c);
            boolean z = false;
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, 0);
            if (this.f3854d != 0) {
                jSONObject.put("uid", this.f3854d);
            }
            if (this.f3855e != null) {
                jSONObject.put("opera", this.f3855e);
            }
            double d2 = this.f;
            double d3 = this.g;
            if (d2 > -90.0d && d2 < 90.0d && d3 > -180.0d && d3 < 180.0d) {
                z = true;
            }
            if (z) {
                jSONObject.put(com.umeng.analytics.pro.d.C, this.f);
                jSONObject.put(com.umeng.analytics.pro.d.D, this.g);
                jSONObject.put("time", this.h);
            }
            if (set != null && !set.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str : set) {
                    jSONArray.put(str);
                }
                jSONObject.put("fail_ips", jSONArray);
            }
            if (this.i != 0) {
                jSONObject.put("ips_flag", this.i);
            }
            if (this.j != 0) {
                jSONObject.put("report_flag", this.j);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
