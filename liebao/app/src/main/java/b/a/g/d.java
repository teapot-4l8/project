package b.a.g;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f3197b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f3198c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private e f3199a;

    private d(Context context) {
        this.f3199a = Build.VERSION.SDK_INT >= 29 ? new b(context) : new c(context);
    }

    public static d a(Context context) {
        synchronized (f3198c) {
            if (f3197b == null) {
                f3197b = new d(context.getApplicationContext());
            }
        }
        return f3197b;
    }

    public String a(String str) {
        return this.f3199a.a(str);
    }

    public void a(String str, String str2) {
        this.f3199a.a(str, str2);
    }

    public void b(String str, String str2) {
        String a2 = a(str);
        if (a2 == null || !a2.equals(str2)) {
            a(str, str2);
        }
    }
}
