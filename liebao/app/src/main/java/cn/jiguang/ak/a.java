package cn.jiguang.ak;

import android.text.TextUtils;
import cn.jiguang.al.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3717a = d.a("cGx1Z2luSWQ=");

    /* renamed from: b  reason: collision with root package name */
    public static final String f3718b = d.a("cGx1Z2luTmFtZQ==");

    /* renamed from: c  reason: collision with root package name */
    public static final String f3719c = d.a("dmVyc2lvbg==");

    /* renamed from: d  reason: collision with root package name */
    public static final String f3720d = d.a("dmVyc2lvbk5hbWU=");

    /* renamed from: e  reason: collision with root package name */
    public static final String f3721e = d.a("bWQ1");
    public static final String f = d.a("ZG93bmxvYWRVcmw=");
    public static final String g = d.a("ZmlsZU5hbWU=");
    public static final String h = d.a("ZmlsZVNpemU=");
    public static final String i = d.a("ZGVzYw==");
    public static final String j = d.a("c3RhdHVz");
    public int m;
    public int o;
    public int t;
    public String v;
    public int k = 0;
    public String l = "";
    public String n = "";
    public String p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f3722q = "";
    public String r = "";
    public String s = "";
    public String u = "";

    private a(String str) {
        this.v = "";
        this.v = str;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.an.d.f("pif", "p i is empty.");
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            cn.jiguang.an.d.h("pif", "p j i is empty.");
            return null;
        }
        a aVar = new a(jSONObject.toString());
        aVar.k = jSONObject.optInt(f3717a);
        aVar.l = jSONObject.optString(f3718b);
        aVar.s = jSONObject.optString(g);
        aVar.f3722q = jSONObject.optString(f3721e);
        aVar.m = jSONObject.optInt(f3719c, 0);
        aVar.n = jSONObject.optString(f3720d, "");
        aVar.o = jSONObject.optInt(j);
        aVar.p = jSONObject.optString(f);
        aVar.r = jSONObject.optString(i);
        aVar.t = jSONObject.optInt(h);
        return aVar;
    }

    public final String toString() {
        return "P{pid=" + this.k + ", pName='" + this.l + "', vcode=" + this.m + ", vname='" + this.n + "', status=" + this.o + ", dU='" + this.p + "', m='" + this.f3722q + "', desc='" + this.r + "', fileName='" + this.s + "', fileSize=" + this.t + ", pkgname='" + this.u + "'}";
    }
}
