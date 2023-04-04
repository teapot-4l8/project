package cn.jiguang.aj;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, Bundle> f3710a = new ConcurrentHashMap();

    static {
        a();
    }

    public static File a(Context context, int i) {
        try {
            return a(context, b(context, i), true);
        } catch (Throwable th) {
            cn.jiguang.an.d.f("PH", "getIIf error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(Context context, cn.jiguang.ak.a aVar, boolean z) {
        File a2;
        boolean z2;
        String str;
        if (aVar == null) {
            return null;
        }
        try {
            a2 = b.a(context, aVar.f3722q, aVar.k, aVar.m);
            cn.jiguang.an.d.b("PH", "pF:" + a2);
            z2 = false;
        } catch (Throwable th) {
            cn.jiguang.an.d.b("PH", "gIF error:" + th.getMessage());
        }
        if (a2.exists() && a2.canRead()) {
            if (TextUtils.isEmpty(aVar.f3722q)) {
                str = "p M error.";
            } else {
                String a3 = cn.jiguang.al.a.a(a2.getAbsolutePath());
                if (TextUtils.isEmpty(a3)) {
                    str = "g p M f.";
                } else if (aVar.f3722q.equalsIgnoreCase(a3)) {
                    z2 = true;
                    if (z2) {
                        return a2;
                    }
                    return null;
                } else {
                    a2.delete();
                    str = "p M not m, c m: " + aVar.f3722q + ", b f m:" + a3;
                }
            }
            cn.jiguang.an.d.h("PIU", str);
            if (z2) {
            }
        }
        str = "p :" + a2.getAbsolutePath() + " not.";
        cn.jiguang.an.d.h("PIU", str);
        if (z2) {
        }
    }

    public static String a(int i, int i2) {
        String str;
        if (i2 == 0) {
            str = "ic";
        } else if (i2 == 1) {
            str = "if";
        } else if (i2 == 2) {
            str = "iff";
        } else if (i2 == 3) {
            str = "dc";
        } else if (i2 != 4) {
            cn.jiguang.an.d.f("PH", "unkown type:" + i2);
            return "";
        } else {
            str = JThirdPlatFormInterface.KEY_CODE;
        }
        return f3710a.containsKey(Integer.valueOf(i)) ? f3710a.get(Integer.valueOf(i)).getString(str) : "";
    }

    private static void a() {
        try {
            f3710a.putAll(ActionManager.getInstance().loadPInfo());
            Bundle bundle = new Bundle();
            bundle.putInt("pid", 1);
            StringBuilder sb = new StringBuilder();
            sb.append(JConstants.SDK_VERSION_INT);
            bundle.putString(JThirdPlatFormInterface.KEY_CODE, sb.toString());
            bundle.putString("ic", cn.jiguang.al.d.a("Y24ucC5qaWd1YW5nLkpDb3JlSGVscGVy"));
            Class<?> cls = Class.forName(cn.jiguang.al.d.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUludGVybmFsSGVscGVy"));
            bundle.putString("if", cls.getCanonicalName());
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Field field = declaredFields[i];
                Class<?> type = field.getType();
                if (type.getCanonicalName().equals(cn.jiguang.al.d.a("Y24uamlndWFuZy5pbnRlcm5hbC5KQ29yZUhlbHBlckFjdGlvbg"))) {
                    cn.jiguang.an.d.b("PH", "find filed name:" + field.getName());
                    bundle.putString("iff", field.getName());
                    break;
                }
                i++;
            }
            bundle.putString("dc", cn.jiguang.al.d.a("Y24ucC5qaWd1YW5nLkpDb3JlQ2xhc3NMb2FkZXI"));
            f3710a.put(1, bundle);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i, String str) {
        cn.jiguang.al.c.a(context, i, "use", str);
    }

    public static void a(Context context, cn.jiguang.ak.a aVar) {
        try {
            cn.jiguang.an.d.b("PH", "clearPlugin...");
            cn.jiguang.al.c.a(context, aVar.k, "use", "");
            File a2 = b.a(context, aVar.f3722q, aVar.k, aVar.m);
            if (a2.exists()) {
                a2.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public static cn.jiguang.ak.a b(Context context, int i) {
        return cn.jiguang.ak.a.a(cn.jiguang.al.c.a(context, i, "use"));
    }
}
