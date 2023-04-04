package b.a.h;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f3222a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f3223b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f3224c = "";

    public static b d(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("market")) {
            bVar.a(jSONObject.optString("market"));
        }
        if (jSONObject.has("channelCode")) {
            bVar.b(jSONObject.optString("channelCode"));
        }
        if (jSONObject.has("bind")) {
            bVar.c(jSONObject.optString("bind"));
        }
        return bVar;
    }

    public String a() {
        return this.f3223b;
    }

    public void a(String str) {
        this.f3222a = str;
    }

    public String b() {
        return this.f3224c;
    }

    public void b(String str) {
        this.f3223b = str;
    }

    public void c(String str) {
        this.f3224c = str;
    }
}
