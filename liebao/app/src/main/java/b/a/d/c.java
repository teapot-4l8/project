package b.a.d;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import b.a.k.e;
import com.umeng.analytics.pro.ak;
import java.io.File;

/* loaded from: classes.dex */
public class c {
    private static c f;
    private static final Object g = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final int f3125a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final int f3126b = 3;

    /* renamed from: c  reason: collision with root package name */
    private final int f3127c = 5;

    /* renamed from: d  reason: collision with root package name */
    private final int f3128d = 5;

    /* renamed from: e  reason: collision with root package name */
    private e f3129e = e.a("EmulatorChecker");

    private c() {
    }

    private int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.split("package:").length;
    }

    public static c a() {
        synchronized (g) {
            if (f == null) {
                f = new c();
            }
        }
        return f;
    }

    private String b(String str) {
        String a2 = a.a().a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return a2;
    }

    public boolean a(Context context) {
        String b2 = b(b.a.k.b.a("Z3NtLnZlcnNpb24uYmFzZWJhbmQ="));
        int i = (b2 == null || b2.contains("1.0.0.0")) ? 1 : 0;
        String b3 = b(b.a.k.b.a("cm8uYnVpbGQuZmxhdm9y"));
        if (b3 == null || b3.contains("vbox") || b3.contains("sdk_gphone") || b3.contains("sdk_phone")) {
            i++;
        }
        String b4 = b(b.a.k.b.a("cm8ucHJvZHVjdC5ib2FyZA=="));
        if (b4 == null || b4.contains("android") || b4.contains("goldfish")) {
            i++;
        }
        String b5 = b(b.a.k.b.a("cm8uYm9hcmQucGxhdGZvcm0="));
        if (b5 == null || b5.contains("android")) {
            i++;
        }
        String b6 = b(b.a.k.b.a("cm8uaGFyZHdhcmU="));
        if (b6 == null) {
            i++;
        } else if (b6.toLowerCase().contains("ttvm") || b6.toLowerCase().contains("nox")) {
            i += 5;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = {"L3N5c3RlbS9iaW4vZHJvaWQ0eC1wcm9w", "L3N5c3RlbS9saWIvbGlibm94ZC5zbw==", "L3N5c3RlbS9iaW4vdHRWTS1wcm9w", "L3N5c3RlbS9iaW4vYnN0c2h1dGRvd24=", "L3N5c3RlbS9iaW4vbWljcm92aXJ0LXByb3A=", "L3N5c3RlbS9iaW4vbmVtdVZNLXByb3A=", "L3N5c3RlbS9iaW4vYW5kcm9WTS1wcm9w", "L3N5c3RlbS9iaW4vZ2VueW1vdGlvbi12Ym94LXNm"};
        boolean z = false;
        for (int i2 = 0; i2 < 8; i2++) {
            String a2 = b.a.k.b.a(strArr[i2]);
            if (new File(a2).exists()) {
                sb.append(a2);
                sb.append(";");
                z = true;
            }
        }
        if (z) {
            i += 5;
        }
        if (new File(b.a.k.b.a("L3N5c3RlbS9ldGMvZXhjbHVkZWQtaW5wdXQtZGV2aWNlcy54bWw=")).exists()) {
            i = Build.VERSION.SDK_INT < 26 ? i + 3 : i + 1;
        }
        if (!context.getPackageManager().hasSystemFeature(b.a.k.b.a("YW5kcm9pZC5oYXJkd2FyZS5ibHVldG9vdGg="))) {
            i += 3;
        }
        if (!context.getPackageManager().hasSystemFeature(b.a.k.b.a("YW5kcm9pZC5oYXJkd2FyZS5jYW1lcmEuZmxhc2g="))) {
            i += 3;
        }
        if (((SensorManager) context.getSystemService(ak.ac)).getSensorList(-1).size() < 9) {
            i++;
        }
        if (a(a.a().b(b.a.k.b.a("cG0gbGlzdCBwYWNrYWdlIC0z"))) < 5) {
            i++;
        }
        return i >= 5;
    }
}
