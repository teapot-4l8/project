package cn.jiguang.az;

import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f4027d;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, g> f4024a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, JAction> f4025b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, JActionExtra> f4026c = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f4028e = new Object();

    private a() {
    }

    public static JAction a(String str) {
        if (f4025b.containsKey(str)) {
            return f4025b.get(str);
        }
        return null;
    }

    public static a a() {
        if (f4027d == null) {
            synchronized (f4028e) {
                if (f4027d == null) {
                    f4027d = new a();
                }
            }
        }
        return f4027d;
    }

    public static void a(String str, String str2) {
        d.a("DispacthManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f4024a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f4024a.put(str, gVar);
        }
        if (f4025b.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JAction) {
                f4025b.put(str, (JAction) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public static JActionExtra b(String str) {
        if (f4026c.containsKey(str)) {
            return f4026c.get(str);
        }
        return null;
    }

    public static void b(String str, String str2) {
        d.a("DispacthManager", "addActionExtra type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (!f4024a.containsKey(str)) {
            g gVar = new g();
            JCoreManager.addDispatchAction(str, g.class.getCanonicalName());
            f4024a.put(str, gVar);
        }
        if (f4026c.containsKey(str)) {
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JActionExtra) {
                f4026c.put(str, (JActionExtra) newInstance);
            }
        } catch (Throwable th) {
            d.d("DispacthManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }
}
