package cn.jiguang.i;

import android.content.Context;
import cn.jiguang.o.f;
import cn.jiguang.o.i;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends cn.jiguang.o.a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile e f4098d;

    /* renamed from: a  reason: collision with root package name */
    private Context f4099a;

    /* renamed from: b  reason: collision with root package name */
    private List<cn.jiguang.j.a> f4100b;

    /* renamed from: c  reason: collision with root package name */
    private List<cn.jiguang.j.b> f4101c;

    public static e a() {
        if (f4098d == null) {
            synchronized (e.class) {
                f4098d = new e();
            }
        }
        return f4098d;
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4099a = context;
        return "JAppRunning";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        int a2 = f.a(context);
        int b2 = f.b(context);
        if (a2 > 0) {
            this.f4100b = cn.jiguang.k.a.a(context);
        } else {
            cn.jiguang.ad.a.d("JAppRunning", "can't collect runningApp because reportRunningAppType:" + a2);
        }
        if (b2 > 0) {
            this.f4101c = cn.jiguang.k.b.a(b2);
        } else {
            cn.jiguang.ad.a.d("JAppRunning", "can't collect runningProcess because reportRunningProcessType:" + b2);
        }
        List<cn.jiguang.j.a> list = this.f4100b;
        if (list != null && !list.isEmpty()) {
            cn.jiguang.ad.a.a("JAppRunning", "collect runningAppList success");
        }
        List<cn.jiguang.j.b> list2 = this.f4101c;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        cn.jiguang.ad.a.a("JAppRunning", "collect runningProcessList success");
    }

    @Override // cn.jiguang.o.a
    protected final void a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        try {
            long j = optJSONObject.getLong(ak.aT);
            if (j == -1) {
                f.a(this.f4099a, "JAppRunning", false);
            } else if (j == 0) {
                f.a(this.f4099a, "JAppRunning", true);
            } else {
                int optInt = optJSONObject.optInt("app_type", 0);
                int optInt2 = optJSONObject.optInt("process_type", 0);
                f.a(this.f4099a, "JAppRunning", true);
                f.a(this.f4099a, optInt);
                f.b(this.f4099a, optInt2);
                if (j > 0) {
                    f.b(this.f4099a, "JAppRunning", j);
                }
            }
        } catch (JSONException e2) {
            cn.jiguang.ad.a.d("JAppRunning", "parse interval exception:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // cn.jiguang.o.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(Context context, String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        boolean z;
        List<cn.jiguang.j.a> list = this.f4100b;
        JSONObject jSONObject2 = null;
        if (list == null || list.isEmpty()) {
            cn.jiguang.ad.a.d("JAppRunning", "there are no running app to report");
            jSONArray = null;
        } else {
            jSONArray = new JSONArray();
            for (cn.jiguang.j.a aVar : this.f4100b) {
                JSONObject a2 = aVar.a(128);
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
        }
        List<cn.jiguang.j.b> list2 = this.f4101c;
        if (list2 == null || list2.isEmpty()) {
            cn.jiguang.ad.a.d("JAppRunning", "there are no running process to report");
            jSONArray2 = null;
        } else {
            jSONArray2 = new JSONArray();
            for (cn.jiguang.j.b bVar : this.f4101c) {
                JSONObject a3 = bVar.a(128);
                if (a3 != null) {
                    jSONArray2.put(a3);
                }
            }
        }
        this.f4100b = null;
        this.f4101c = null;
        boolean z2 = false;
        try {
            jSONObject = new JSONObject();
            z = true;
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        jSONObject.put("app", jSONArray);
                        z2 = true;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                    cn.jiguang.ad.a.d("JAppRunning", "package json exception:" + e.getMessage());
                    jSONObject = jSONObject2;
                    z = z2;
                    if (z) {
                    }
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
        if (jSONArray2 != null && jSONArray2.length() > 0) {
            jSONObject.put(UMModuleRegister.PROCESS, jSONArray2);
            if (z) {
                cn.jiguang.d.a.a(context, jSONObject, "app_running");
                i.a(context, (Object) jSONObject);
                super.b(context, str);
                return;
            }
            return;
        }
        z = z2;
        if (z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean b() {
        cn.jiguang.ad.a.a("JAppRunning", "for googlePlay:false");
        return true;
    }

    @Override // cn.jiguang.o.a
    protected final boolean c() {
        return f.h(this.f4099a, "JAppRunning");
    }
}
