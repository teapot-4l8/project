package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f4295a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4296b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private c f4297c;

    private d(Context context) {
        b(context);
    }

    public static d a(Context context) {
        if (f4295a == null) {
            synchronized (f4296b) {
                if (f4295a == null) {
                    f4295a = new d(context);
                }
            }
        }
        return f4295a;
    }

    private void b(Context context) {
        if (context == null) {
            Logger.dd("GeofenceManager", "context is null,init failed");
        } else {
            this.f4297c = new a(context);
        }
    }

    public void a() {
        this.f4297c.b();
    }

    public void a(int i) {
        this.f4297c.a(i);
    }

    public void a(long j) {
        this.f4297c.a(j);
    }

    public void a(b bVar) {
        Logger.dd("GeofenceManager", "recv geofence...");
        this.f4297c.c(bVar);
    }

    public void a(String str) {
        this.f4297c.a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
        if (r3 == 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
        if (r3 == 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
        cn.jpush.android.helper.Logger.w("GeofenceManager", "operation " + r1 + " not supported");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        r8.f4297c.a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        r8.f4297c.a(r2, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                return;
            }
            String optString = jSONObject2.optString("op");
            String optString2 = jSONObject2.optString("geofenceid");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != 96417) {
                    if (hashCode != 99339) {
                        if (hashCode == 116009 && optString.equals("upd")) {
                            c2 = 1;
                        }
                    } else if (optString.equals("del")) {
                        c2 = 2;
                    }
                } else if (optString.equals("add")) {
                    c2 = 0;
                }
                this.f4297c.c(b.a(jSONObject2));
                return;
            }
            Logger.w("GeofenceManager", "json error: required key not found");
        } catch (Throwable th) {
            Logger.w("GeofenceManager", "json error:" + th);
        }
    }

    public void b() {
        this.f4297c.a();
    }
}
