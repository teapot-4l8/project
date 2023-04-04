package b.a.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f3108a;

    /* renamed from: b  reason: collision with root package name */
    private String f3109b;

    /* renamed from: c  reason: collision with root package name */
    private int f3110c;

    public static String a(c cVar) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (cVar == null) {
            i = 0;
        } else {
            try {
                jSONObject.put("pbText", cVar.f3108a);
                jSONObject.put("pbHtml", cVar.f3109b);
                i = cVar.f3110c;
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("pbType", i);
        return jSONObject.toString();
    }

    public static c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("pbText")) {
                cVar.a(jSONObject.optString("pbText"));
            }
            if (jSONObject.has("pbHtml")) {
                cVar.b(jSONObject.optString("pbHtml"));
            }
            if (jSONObject.has("pbType")) {
                cVar.a(jSONObject.optInt("pbType"));
            }
            return cVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String a() {
        return this.f3108a;
    }

    public void a(int i) {
        this.f3110c = i;
    }

    public void a(String str) {
        this.f3108a = str;
    }

    public String b() {
        return this.f3109b;
    }

    public void b(int i) {
        this.f3110c = i | this.f3110c;
    }

    public void b(String str) {
        this.f3109b = str;
    }

    public int c() {
        return this.f3110c;
    }

    public boolean c(int i) {
        return (i & this.f3110c) != 0;
    }
}
