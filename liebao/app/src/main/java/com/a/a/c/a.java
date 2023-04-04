package com.a.a.c;

import android.content.Intent;
import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DefaultsFactory.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<?>, com.a.a.a.b.b.c<?>> f4547a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(Bundle.class, new com.a.a.a.b.b.a());
        hashMap.put(Intent.class, new com.a.a.a.b.b.b());
        f4547a = Collections.unmodifiableMap(hashMap);
    }

    public static com.a.a.a.b.a.b a() {
        return new com.a.a.a.b.a.a();
    }

    public static com.a.a.a.b.d.b b() {
        return new com.a.a.a.b.d.a();
    }

    public static com.a.a.a.b.c.b c() {
        return new com.a.a.a.b.c.a();
    }

    public static com.a.a.a.d.b d() {
        return new com.a.a.a.d.a();
    }

    public static com.a.a.a.c.b e() {
        return new com.a.a.a.c.a();
    }

    public static com.a.a.a.a.a f() {
        return new com.a.a.a.a.b();
    }

    public static Map<Class<?>, com.a.a.a.b.b.c<?>> g() {
        return f4547a;
    }
}
