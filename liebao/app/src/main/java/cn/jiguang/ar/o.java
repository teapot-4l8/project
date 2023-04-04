package cn.jiguang.ar;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.analytics.pro.ak;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public String f3846a;

    /* renamed from: b  reason: collision with root package name */
    public int f3847b;

    /* renamed from: c  reason: collision with root package name */
    public h f3848c;

    /* renamed from: d  reason: collision with root package name */
    public long f3849d;

    /* renamed from: e  reason: collision with root package name */
    public long f3850e;
    public long f;
    public int g;
    public double h;
    public double i;
    public long j;
    public int k;

    private static o a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                o oVar = new o();
                oVar.f3846a = jSONObject.optString("appkey");
                oVar.f3847b = jSONObject.getInt(com.umeng.analytics.pro.d.y);
                oVar.f3848c = h.a(jSONObject.getString("addr"));
                oVar.f3850e = jSONObject.getLong("rtime");
                oVar.f = jSONObject.getLong(ak.aT);
                oVar.g = jSONObject.getInt("net");
                oVar.k = jSONObject.getInt(JThirdPlatFormInterface.KEY_CODE);
                oVar.f3849d = jSONObject.optLong("uid");
                oVar.h = jSONObject.optDouble(com.umeng.analytics.pro.d.C);
                oVar.i = jSONObject.optDouble(com.umeng.analytics.pro.d.D);
                oVar.j = jSONObject.optLong("ltime");
                return oVar;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static LinkedList<o> a(String str) {
        LinkedList<o> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(a(jSONArray.getJSONObject(i)));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedList;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f3846a)) {
                jSONObject.put("appkey", this.f3846a);
            }
            jSONObject.put(com.umeng.analytics.pro.d.y, this.f3847b);
            jSONObject.put("addr", this.f3848c.toString());
            jSONObject.put("rtime", this.f3850e);
            jSONObject.put(ak.aT, this.f);
            jSONObject.put("net", this.g);
            jSONObject.put(JThirdPlatFormInterface.KEY_CODE, this.k);
            if (this.f3849d != 0) {
                jSONObject.put("uid", this.f3849d);
            }
            double d2 = this.h;
            double d3 = this.i;
            if (d2 > -90.0d && d2 < 90.0d && d3 > -180.0d && d3 < 180.0d) {
                jSONObject.put(com.umeng.analytics.pro.d.C, this.h);
                jSONObject.put(com.umeng.analytics.pro.d.D, this.i);
                jSONObject.put("ltime", this.j);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
