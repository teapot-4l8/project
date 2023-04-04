package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CollectController.java */
/* loaded from: classes2.dex */
public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Boolean> f6708a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Object f6709b = new Object();

    private b() {
    }

    public void a() {
        synchronized (f6709b) {
            f6708a.clear();
        }
    }

    /* compiled from: CollectController.java */
    /* loaded from: classes2.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f6710a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f6710a;
    }

    public static boolean a(String str) {
        if (d.a(str)) {
            synchronized (f6709b) {
                if (f6708a.containsKey(str)) {
                    return f6708a.get(str).booleanValue();
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f6709b) {
                if (f6708a != null) {
                    f6708a.put(str, bool);
                }
            }
        }
    }
}
