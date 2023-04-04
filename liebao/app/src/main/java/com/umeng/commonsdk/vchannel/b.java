package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Event.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private String f6966b;

    /* renamed from: a  reason: collision with root package name */
    private String f6965a = "_$unknown";

    /* renamed from: c  reason: collision with root package name */
    private long f6967c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f6968d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f6969e = a.j;
    private Map<String, Object> f = null;

    public String a() {
        return this.f6965a;
    }

    public void a(String str) {
        this.f6965a = str;
    }

    public long b() {
        return this.f6967c;
    }

    public void a(long j) {
        this.f6967c = j;
    }

    public Map<String, Object> c() {
        return this.f;
    }

    public void a(Map<String, Object> map) {
        this.f = map;
    }

    public b(Context context) {
        this.f6966b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f6965a + ",");
        sb.append("pn:" + this.f6966b + ",");
        sb.append("ts:" + this.f6967c + ",");
        Map<String, Object> map = this.f;
        if (map != null && map.size() > 0) {
            for (String str : this.f.keySet()) {
                sb.append(this.f.get(str) == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f6968d + "]");
        return sb.toString();
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f6965a);
            jSONObject.put("pn", this.f6966b);
            jSONObject.put("ds", this.f6968d);
            jSONObject.put("ts", this.f6967c);
            if (this.f != null && this.f.size() > 0) {
                for (String str : this.f.keySet()) {
                    jSONObject.put(str, this.f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f6969e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }
}
