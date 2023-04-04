package a.a.a.c;

import a.a.a.e.f;
import a.a.a.e.h;
import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Input.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f59a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private static JSONObject f60b;

    /* renamed from: c  reason: collision with root package name */
    private static int f61c;

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void a(final c cVar, final JSONObject jSONObject) {
        if (a()) {
            a.a.a.a.a().f().a(cVar, jSONObject);
            c(cVar, jSONObject);
            return;
        }
        f59a.post(new Runnable() { // from class: a.a.a.c.d.1
            @Override // java.lang.Runnable
            public void run() {
                a.a.a.a.a().f().a(c.this, jSONObject);
                d.c(c.this, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(c cVar, JSONObject jSONObject) {
        if (f60b == null) {
            f60b = new JSONObject();
        }
        f61c++;
        try {
            f60b.put(cVar.a(), jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (f61c == a.a.a.a.a().i()) {
            try {
                f60b.put("totalTime", h.a(a.a.a.a.a().g()) + "ms");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            a.a.a.a.a().f().a(f60b);
            f60b = null;
            f61c = 0;
        }
    }

    public static void a(final String str) {
        f.b(str);
        if (a()) {
            a.a.a.a.a().f().a(str);
        } else {
            f59a.post(new Runnable() { // from class: a.a.a.c.d.2
                @Override // java.lang.Runnable
                public void run() {
                    a.a.a.a.a().f().a(str);
                }
            });
        }
    }
}
