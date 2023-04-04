package cn.jiguang.ao;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.internal.ActionManager;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f3776a;

    /* renamed from: b  reason: collision with root package name */
    private static String f3777b;

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<File, Boolean> f3778c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicBoolean f3779d = new AtomicBoolean(false);

    public static File a(Context context, String str, JSONObject jSONObject, boolean z) {
        File file = new File(e(context) + str + File.separator + UUID.randomUUID().toString());
        if (z) {
            b(file);
        }
        cn.jiguang.f.e.a(file, jSONObject.toString());
        return file;
    }

    public static void a(Context context) {
        cn.jiguang.f.f fVar = new cn.jiguang.f.f(false, true, "jpush_stat_history", 1);
        String a2 = cn.jiguang.am.a.a(context);
        File[] a3 = cn.jiguang.f.e.a(context.getFilesDir(), fVar, new e());
        if (a3 != null) {
            for (File file : a3) {
                try {
                    cn.jiguang.f.e.c(new File(file, "nowrap"));
                    File file2 = new File(file.getParent() + File.separator + a2 + File.separator + file.getName());
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file.renameTo(file2);
                } catch (Throwable th) {
                    cn.jiguang.an.d.b("updateByAppKey", "e=" + th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Context context, File file) {
        cn.jiguang.an.d.b("ReportHistory", "upload space=" + e(file));
        c(context, file);
        d(file);
        b(context, file);
        c(file);
    }

    public static void a(Context context, String... strArr) {
        FileFilter[] fileFilterArr = new FileFilter[2];
        for (int i = 0; i <= 0; i++) {
            fileFilterArr[1] = cn.jiguang.f.f.a(strArr[0]);
        }
        fileFilterArr[0] = new cn.jiguang.f.f(false, true, "jpush_stat_history", 1);
        File[] a2 = cn.jiguang.f.e.a(context.getFilesDir(), fileFilterArr);
        if (a2 != null) {
            for (File file : a2) {
                cn.jiguang.f.e.c(file);
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            f3778c.remove(file);
        }
    }

    private static Set<String> b() {
        HashSet hashSet = new HashSet();
        hashSet.add("uid");
        hashSet.add("app_key");
        hashSet.add("sdk_ver");
        hashSet.add("channel");
        hashSet.add("app_version");
        JSONObject jSONObject = new JSONObject();
        ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    public static void b(Context context) {
        if (f3779d.get()) {
            cn.jiguang.an.d.b("ReportHistory", "isRunning, no need report");
        } else {
            cn.jiguang.ba.a.a("REPORT_HISTORY", new f(context));
        }
    }

    private static void b(Context context, File file) {
        if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.c())).longValue() == 0) {
            cn.jiguang.an.d.b("ReportHistory", "can't get uid, skip upload history");
            return;
        }
        File[] a2 = cn.jiguang.f.e.a(file, cn.jiguang.f.f.f4072a);
        if (a2 == null || a2.length == 0) {
            return;
        }
        LinkedList<File> linkedList = new LinkedList();
        for (File file2 : a2) {
            if (!Boolean.TRUE.equals(f3778c.get(file2))) {
                linkedList.add(file2);
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        cn.jiguang.an.d.b("ReportHistory", "process space=" + e(file) + " history[" + linkedList.size() + "]");
        Collections.sort(linkedList, new g());
        for (File file3 : linkedList) {
            try {
                JSONObject a3 = c.a(file3);
                if (a3 == null) {
                    cn.jiguang.f.e.a(file3);
                } else {
                    b(file3);
                    Set<String> a4 = k.a(a3);
                    cn.jiguang.an.d.b("ReportHistory", "report history types=" + a4);
                    if (k.a(context, a4, a3, file3, null) == -2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.an.d.f("ReportHistory", "upload e:" + th);
            }
        }
    }

    private static void b(File file) {
        if (file != null) {
            f3778c.put(file, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:3:0x0002, B:5:0x000a, B:12:0x0017, B:14:0x002a, B:17:0x002e, B:18:0x005e, B:20:0x0061, B:24:0x006c, B:27:0x0073, B:29:0x0078), top: B:34:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #0 {all -> 0x007d, blocks: (B:3:0x0002, B:5:0x000a, B:12:0x0017, B:14:0x002a, B:17:0x002e, B:18:0x005e, B:20:0x0061, B:24:0x006c, B:27:0x0073, B:29:0x0078), top: B:34:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(Context context, File file) {
        boolean z;
        File[] a2;
        c a3;
        try {
            JSONObject a4 = k.a(context);
            if (a4 != null && a4.length() != 0) {
                z = false;
                if (z && (a2 = cn.jiguang.f.e.a(new File(file, "nowrap"), cn.jiguang.f.f.f4072a)) != null && a2.length != 0) {
                    cn.jiguang.an.d.b("ReportHistory", "process space=" + e(file) + " nowrap[" + a2.length + "]");
                    File file2 = new File(file, "tmp");
                    a3 = c.a(a2[0], a4);
                    for (int i = 1; i < a2.length; i++) {
                        c a5 = c.a(a2[i], a4);
                        if (a5 != null) {
                            if (a3 != null && a3.a(a5, file2)) {
                            }
                            a3 = a5;
                        }
                    }
                    if (a3 == null) {
                        a3.a((c) null, file2);
                        return;
                    }
                    return;
                }
                return;
            }
            z = true;
            if (z) {
                return;
            }
            cn.jiguang.an.d.b("ReportHistory", "process space=" + e(file) + " nowrap[" + a2.length + "]");
            File file22 = new File(file, "tmp");
            a3 = c.a(a2[0], a4);
            while (i < a2.length) {
            }
            if (a3 == null) {
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("ReportHistory", "processNowrap e:" + th);
        }
    }

    private static void c(File file) {
        int i = 0;
        File[] a2 = cn.jiguang.f.e.a(file, cn.jiguang.f.f.f4072a);
        if (a2 == null || a2.length <= 1) {
            return;
        }
        List<File> asList = Arrays.asList(a2);
        Collections.sort(asList, new h());
        for (File file2 : asList) {
            i = (int) (i + file2.length());
            if (i > 1048576) {
                cn.jiguang.f.e.a(file2);
            }
        }
        if (asList.size() < a2.length) {
            cn.jiguang.an.d.b("ReportHistory", "trim space history=" + e(file) + "," + a2.length + " to " + asList.size());
        }
    }

    private static synchronized String d(Context context) {
        String str;
        String replaceFirst;
        synchronized (d.class) {
            if (!TextUtils.isEmpty(f3777b)) {
                return f3777b;
            }
            if (f3776a == null) {
                String a2 = cn.jiguang.f.a.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.equals(context.getPackageName())) {
                        replaceFirst = "";
                    } else {
                        replaceFirst = a2.replaceFirst(context.getPackageName() + ":", "_");
                    }
                    f3776a = replaceFirst;
                }
            }
            if (f3776a != null) {
                str = "jpush_stat_history" + f3776a;
            } else {
                str = "jpush_stat_history";
            }
            File a3 = cn.jiguang.f.e.a(context, str);
            if (a3 != null) {
                String absolutePath = a3.getAbsolutePath();
                f3777b = absolutePath;
                return absolutePath;
            }
            return "jpush_stat_history" + f3776a;
        }
    }

    private static void d(File file) {
        try {
            File[] a2 = cn.jiguang.f.e.a(new File(file, "tmp"), cn.jiguang.f.f.f4072a);
            if (a2 != null && a2.length != 0) {
                LinkedList<File> linkedList = new LinkedList();
                for (File file2 : a2) {
                    if (!Boolean.TRUE.equals(f3778c.get(file2))) {
                        linkedList.add(file2);
                    }
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                cn.jiguang.an.d.b("ReportHistory", "process space=" + e(file) + " tmp[" + linkedList.size() + "]");
                Set<String> b2 = b();
                HashMap hashMap = new HashMap();
                c a3 = c.a(cn.jiguang.f.e.a(cn.jiguang.f.e.a(file, cn.jiguang.f.f.f4072a)), b2);
                if (a3 != null) {
                    hashMap.put(String.valueOf(a3.f3772b), a3);
                }
                for (File file3 : linkedList) {
                    c a4 = c.a(file3, b2);
                    if (a4 != null) {
                        String valueOf = String.valueOf(a4.f3772b);
                        c cVar = (c) hashMap.get(valueOf);
                        if (cVar != null && cVar.a(a4, file)) {
                        }
                        hashMap.put(valueOf, a4);
                    }
                }
                for (c cVar2 : hashMap.values()) {
                    cVar2.a((c) null, file);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("ReportHistory", "processTmp e:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context) {
        String a2 = cn.jiguang.am.a.a(context);
        if (TextUtils.isEmpty(a2)) {
            a2 = "0";
        }
        return d(context) + File.separator + a2;
    }

    private static String e(File file) {
        try {
            File parentFile = file.getParentFile();
            return parentFile.getParentFile().getName() + File.separator + parentFile.getName() + File.separator + file.getName();
        } catch (Throwable unused) {
            return file.getAbsolutePath();
        }
    }
}
