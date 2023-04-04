package cn.jiguang.ar;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    final h f3811a;

    /* renamed from: b  reason: collision with root package name */
    int f3812b;

    /* renamed from: c  reason: collision with root package name */
    long f3813c;

    /* renamed from: d  reason: collision with root package name */
    long f3814d;

    /* renamed from: e  reason: collision with root package name */
    int f3815e;

    public d(h hVar) {
        this.f3811a = hVar;
    }

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d(new h(jSONObject.getString("ip"), jSONObject.getInt("port")));
            dVar.f3812b = jSONObject.optInt("status");
            dVar.f3813c = jSONObject.optLong("fetch_time");
            dVar.f3814d = jSONObject.optLong("cost");
            dVar.f3815e = jSONObject.optInt("prefer");
            return dVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", this.f3811a.f3820a);
            jSONObject.put("port", this.f3811a.f3821b);
            jSONObject.put("status", this.f3812b);
            jSONObject.put("fetch_time", this.f3813c);
            jSONObject.put("cost", this.f3814d);
            jSONObject.put("prefer", this.f3815e);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f3812b == dVar.f3812b && this.f3813c == dVar.f3813c && this.f3814d == dVar.f3814d && this.f3815e == dVar.f3815e) {
                h hVar = this.f3811a;
                h hVar2 = dVar.f3811a;
                return hVar != null ? hVar.equals(hVar2) : hVar2 == null;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        h hVar = this.f3811a;
        int hashCode = hVar != null ? hVar.hashCode() : 0;
        long j = this.f3813c;
        long j2 = this.f3814d;
        return (((((((hashCode * 31) + this.f3812b) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f3815e;
    }

    public final String toString() {
        return "IpInfo{ipPort=" + this.f3811a + ", status=" + this.f3812b + ", fetchTime=" + this.f3813c + ", cost=" + this.f3814d + ", prefer=" + this.f3815e + '}';
    }
}
