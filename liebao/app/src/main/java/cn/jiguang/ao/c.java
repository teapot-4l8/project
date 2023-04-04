package cn.jiguang.ao;

import android.text.TextUtils;
import java.io.File;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public long f3771a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f3772b;

    /* renamed from: c  reason: collision with root package name */
    private File f3773c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f3774d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3775e;
    private boolean f;

    private c(File file, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        this.f3773c = file;
        this.f3774d = jSONObject;
        this.f3772b = jSONObject2;
        this.f3771a = file.length();
        this.f = z;
        this.f3775e = z;
    }

    public static c a(File file, Set<String> set) {
        JSONObject a2 = a(file);
        if (a2 != null) {
            return new c(file, a2, cn.jiguang.f.g.a(a2, set), false);
        }
        cn.jiguang.f.e.a(file);
        return null;
    }

    public static c a(File file, JSONObject jSONObject) {
        JSONObject a2 = a(file);
        if (a2 != null) {
            return new c(file, a2, jSONObject, true);
        }
        cn.jiguang.f.e.a(file);
        return null;
    }

    public static JSONObject a(File file) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        try {
            String b2 = cn.jiguang.f.e.b(file);
            if (TextUtils.isEmpty(b2) || (optJSONArray = (jSONObject = new JSONObject(b2)).optJSONArray("content")) == null) {
                return null;
            }
            if (optJSONArray.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final boolean a(c cVar, File file) {
        boolean z = true;
        if (cVar != null) {
            try {
                if (this.f3771a + cVar.f3771a <= 40960) {
                    JSONArray jSONArray = this.f3774d.getJSONArray("content");
                    JSONArray jSONArray2 = cVar.f3774d.getJSONArray("content");
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        jSONArray.put(jSONArray2.getJSONObject(i));
                    }
                    this.f3771a += cVar.f3771a;
                    this.f3775e = true;
                    cn.jiguang.f.e.a(cVar.f3773c);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, this.f3773c.getName());
        if (this.f) {
            cn.jiguang.f.g.a(this.f3774d, this.f3772b);
        }
        if (this.f3773c.equals(file2)) {
            z = false;
        }
        if (this.f3775e || z) {
            cn.jiguang.f.e.a(file2, this.f3774d.toString());
        }
        if (z) {
            cn.jiguang.f.e.a(this.f3773c);
        }
        return false;
    }
}
