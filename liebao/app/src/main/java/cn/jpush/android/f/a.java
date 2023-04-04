package cn.jpush.android.f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<b, cn.jpush.android.e.a> f4324a = new ConcurrentHashMap();

    public static cn.jpush.android.e.a a(b bVar) {
        return f4324a.get(bVar);
    }

    public static void a(b bVar, cn.jpush.android.e.a aVar) {
        if (aVar != null) {
            f4324a.put(bVar, aVar);
        }
    }

    public static void b(b bVar) {
        f4324a.remove(bVar);
    }
}
