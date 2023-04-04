package cn.jiguang.dy;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.aj.c;
import cn.jiguang.an.d;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f4052a;

    /* renamed from: b  reason: collision with root package name */
    private static Map<Integer, String> f4053b = new ConcurrentHashMap();

    private b() {
        cn.jiguang.am.b.a();
    }

    public static b a() {
        if (f4052a == null) {
            synchronized (b.class) {
                if (f4052a == null) {
                    f4052a = new b();
                }
            }
        }
        return f4052a;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x00ac
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.lang.Object a(android.content.Context r17, int r18, int r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.dy.b.a(android.content.Context, int, int, java.lang.Object):java.lang.Object");
    }

    private static String a(Context context, cn.jiguang.ak.a aVar) {
        String str;
        File a2 = cn.jiguang.aj.a.a(context, aVar, true);
        if (a2 != null) {
            str = a2.getAbsolutePath();
            d.b("JDB", "p:" + str);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                if (f4053b.get(Integer.valueOf(aVar.k)) != null) {
                    String str2 = f4053b.get(Integer.valueOf(aVar.k));
                    if (new File(str2).exists()) {
                        return str2;
                    }
                }
            } catch (Throwable unused) {
            }
            File a3 = cn.jiguang.aj.b.a(context, new File(str));
            if (a3 == null || !a3.exists()) {
                d.b("JDB", "d failed,clear p");
                cn.jiguang.aj.a.a(context, aVar);
                str = "";
            } else {
                str = a3.getAbsolutePath();
                try {
                    f4053b.put(Integer.valueOf(aVar.k), str);
                } catch (Throwable unused2) {
                }
            }
        }
        d.b("JDB", "end p:" + str);
        return str;
    }

    public static void a(Context context, int i, String str) {
        c.a().a(context, i, str);
    }

    public static boolean a(Context context, int i) {
        try {
        } catch (Throwable th) {
            d.a("JDB", "lP:", th);
        }
        if (context == null) {
            d.h("JDB", "context is null");
            return false;
        }
        Protocol.mContext = context;
        Protocol.e(i);
        return false;
    }

    private static boolean a(Context context, cn.jiguang.ak.a aVar, int i) {
        String a2 = cn.jiguang.aj.a.a(i, 4);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(a2);
            d.b("JDB", "p c vc:" + parseInt + ",p vc:" + aVar.m);
            if (parseInt >= aVar.m) {
                cn.jiguang.aj.a.a(context, aVar);
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static Map<String, String> b(Context context, int i) {
        cn.jiguang.ak.a b2 = cn.jiguang.aj.a.b(context, i);
        if (b2 != null && a(context, b2, i)) {
            String a2 = a(context, b2);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String absolutePath = cn.jiguang.aj.b.c(context, b2.f3722q, b2.k, b2.m).getAbsolutePath();
            d.b("JDB", "o:" + absolutePath);
            String absolutePath2 = cn.jiguang.aj.b.b(context, b2.f3722q, b2.k, b2.m).getAbsolutePath();
            d.b("JDB", "l:" + absolutePath2);
            HashMap hashMap = new HashMap();
            hashMap.put(ak.ax, a2);
            hashMap.put("o", absolutePath);
            hashMap.put("l", absolutePath2);
            return hashMap;
        }
        return null;
    }
}
