package b.a.h.a;

import cn.jpush.android.api.JThirdPlatFormInterface;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f3209a;

    /* renamed from: b  reason: collision with root package name */
    private int f3210b;

    /* renamed from: c  reason: collision with root package name */
    private String f3211c;

    /* renamed from: d  reason: collision with root package name */
    private String f3212d;

    /* renamed from: e  reason: collision with root package name */
    private String f3213e;

    /* loaded from: classes.dex */
    public enum a {
        SUCCESS,
        FAIL,
        ERROR
    }

    public b() {
    }

    public b(a aVar, int i) {
        this.f3209a = aVar;
        this.f3210b = i;
    }

    public static b a(String str) {
        String str2;
        b bVar = new b();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("config") && !jSONObject.isNull("config")) {
            bVar.d(jSONObject.optString("config"));
        }
        int optInt = jSONObject.optInt(JThirdPlatFormInterface.KEY_CODE, -2);
        if (optInt == 0) {
            bVar.a(a.SUCCESS);
            bVar.a(0);
            if (jSONObject.has("body") && !jSONObject.isNull("body")) {
                bVar.c(jSONObject.optString("body"));
            }
            if (jSONObject.has(JThirdPlatFormInterface.KEY_MSG) && !jSONObject.isNull(JThirdPlatFormInterface.KEY_MSG)) {
                str2 = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG);
            }
            return bVar;
        }
        bVar.a(a.ERROR);
        bVar.a(-2);
        str2 = optInt + " : " + jSONObject.optString(JThirdPlatFormInterface.KEY_MSG);
        bVar.b(str2);
        return bVar;
    }

    public a a() {
        return this.f3209a;
    }

    public void a(int i) {
        this.f3210b = i;
    }

    public void a(a aVar) {
        this.f3209a = aVar;
    }

    public int b() {
        return this.f3210b;
    }

    public void b(String str) {
        this.f3212d = str;
    }

    public String c() {
        return this.f3212d;
    }

    public void c(String str) {
        this.f3211c = str;
    }

    public String d() {
        return this.f3211c;
    }

    public void d(String str) {
        this.f3213e = str;
    }

    public String e() {
        return this.f3213e;
    }
}
