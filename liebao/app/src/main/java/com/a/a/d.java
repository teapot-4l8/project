package com.a.a;

import com.a.a.c;

/* compiled from: XLog.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static a f4557a;

    /* renamed from: b  reason: collision with root package name */
    static com.a.a.d.b f4558b;

    /* renamed from: c  reason: collision with root package name */
    static boolean f4559c;

    /* renamed from: d  reason: collision with root package name */
    private static c f4560d;

    private d() {
    }

    public static void a(a aVar, com.a.a.d.b... bVarArr) {
        if (f4559c) {
            com.a.a.c.b.a().a("XLog is already initialized, do not initialize again");
        }
        f4559c = true;
        if (aVar == null) {
            throw new IllegalArgumentException("Please specify a LogConfiguration");
        }
        f4557a = aVar;
        com.a.a.d.c cVar = new com.a.a.d.c(bVarArr);
        f4558b = cVar;
        f4560d = new c(f4557a, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        if (!f4559c) {
            throw new IllegalStateException("Do you forget to initialize XLog?");
        }
    }

    public static c.a a(String str) {
        return new c.a().a(str);
    }

    public static void b(String str) {
        a();
        f4560d.a(str);
    }

    public static void a(String str, Throwable th) {
        a();
        f4560d.a(str, th);
    }

    public static void c(String str) {
        a();
        f4560d.b(str);
    }

    public static void d(String str) {
        a();
        f4560d.c(str);
    }
}
