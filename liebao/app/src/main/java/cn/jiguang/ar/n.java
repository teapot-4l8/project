package cn.jiguang.ar;

import android.text.TextUtils;
import java.util.LinkedHashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    LinkedHashSet<h> f3841a;

    /* renamed from: b  reason: collision with root package name */
    LinkedHashSet<h> f3842b;

    /* renamed from: c  reason: collision with root package name */
    LinkedHashSet<h> f3843c;

    /* renamed from: d  reason: collision with root package name */
    LinkedHashSet<h> f3844d;

    /* renamed from: e  reason: collision with root package name */
    LinkedHashSet<h> f3845e;
    JSONObject f;
    transient h g;
    boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f3841a = a(jSONObject, "ips");
            this.f3842b = a(jSONObject, "ssl_ips");
            this.f3843c = a(jSONObject, "http_report");
            this.f3844d = a(jSONObject, "https_report");
            this.f3845e = a(jSONObject, "sis_ips");
            this.h = jSONObject.optBoolean("data_report");
            this.f = jSONObject.optJSONObject("tcp_report");
            cn.jiguang.an.d.b("sis", "get sis=" + jSONObject.toString(2));
        } catch (Throwable unused) {
        }
    }

    private static LinkedHashSet<h> a(JSONObject jSONObject, String str) {
        LinkedHashSet<h> linkedHashSet = new LinkedHashSet<>();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    h a2 = h.a(optJSONArray.optString(i, null));
                    if (a2 != null && a2.a()) {
                        linkedHashSet.add(a2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return linkedHashSet;
    }

    public final boolean a() {
        LinkedHashSet<h> linkedHashSet = this.f3841a;
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            LinkedHashSet<h> linkedHashSet2 = this.f3842b;
            return linkedHashSet2 == null || linkedHashSet2.isEmpty();
        }
        return false;
    }
}
