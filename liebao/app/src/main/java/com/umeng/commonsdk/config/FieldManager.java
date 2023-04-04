package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class FieldManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6703a = "cfgfd";

    /* renamed from: b  reason: collision with root package name */
    private static b f6704b = b.b();

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6705c = false;

    /* renamed from: d  reason: collision with root package name */
    private static Object f6706d = new Object();

    private FieldManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final FieldManager f6707a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.f6707a;
    }

    public static boolean allow(String str) {
        synchronized (f6706d) {
            if (f6705c) {
                return b.a(str);
            }
            return false;
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (f6706d) {
            z = f6705c;
        }
        return z;
    }

    public void a(Context context) {
        String str;
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0166d.class.getName()};
        String str2 = "1001@3758096383,2147483647,262143,2047";
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3758096383,2147483647,262143,2047");
        synchronized (f6706d) {
            Pair<Long, String> a2 = a(imprintProperty);
            if (((Long) a2.first).longValue() > 1000 && (str = (String) a2.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i = 0; i < length; i++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i)).a(split[i], f6704b, d.b(strArr[i]));
                }
            }
            f6705c = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
        if (r12.length() > 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, String str) {
        String str2;
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0166d.class.getName()};
        synchronized (f6706d) {
            f6704b.a();
            if (str != null) {
                Pair<Long, String> a2 = a(str);
                if (((Long) a2.first).longValue() > 1000) {
                    str2 = (String) a2.second;
                    if (str2 != null) {
                    }
                }
            }
            str2 = "1001@3758096383,2147483647,262143,2047";
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i = 0; i < length; i++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i)).a(split[i], f6704b, d.b(strArr[i]));
                }
            }
            f6705c = true;
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
