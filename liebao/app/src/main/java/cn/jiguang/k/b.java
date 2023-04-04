package cn.jiguang.k;

import android.text.TextUtils;
import cn.jiguang.v.f;
import cn.jpush.android.service.WakedResultReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f4126a = Pattern.compile("^zygote[0-9]*$");

    private static int a(LinkedList<String> linkedList, String str, int i) {
        int indexOf = linkedList.indexOf(str);
        if (indexOf == -1) {
            indexOf = linkedList.indexOf(str.toLowerCase(Locale.ENGLISH));
        }
        return indexOf == -1 ? i : indexOf;
    }

    private static cn.jiguang.j.b a(String str, Map<String, Integer> map) {
        String[] split;
        int length;
        String str2;
        if (!TextUtils.isEmpty(str) && (length = (split = str.split("\\s+")).length) >= 3) {
            try {
                cn.jiguang.j.b bVar = new cn.jiguang.j.b();
                if (map != null && !map.isEmpty()) {
                    bVar.f4121a = split[map.get("USER").intValue()];
                    bVar.f4122b = split[map.get("PID").intValue()];
                    bVar.f4123c = split[map.get("PPID").intValue()];
                    str2 = split[map.get("NAME").intValue()];
                    bVar.f4124d = str2;
                    return bVar;
                }
                bVar.f4121a = split[0];
                bVar.f4122b = split[1];
                bVar.f4123c = split[2];
                str2 = split[length - 1];
                bVar.f4124d = str2;
                return bVar;
            } catch (Throwable th) {
                cn.jiguang.ad.a.d("JProcessHelper", "parseCommandResult throwable:" + th.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0077 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:3:0x0008, B:5:0x0013, B:8:0x001b, B:17:0x006d, B:18:0x0071, B:20:0x0077, B:24:0x0086, B:26:0x0090, B:28:0x0098, B:34:0x00a6, B:36:0x00b4, B:37:0x00ba, B:39:0x00c2, B:41:0x00c8, B:43:0x00ce, B:45:0x00d6, B:46:0x00db, B:48:0x00e1, B:50:0x00ef, B:11:0x0033, B:54:0x0100), top: B:59:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<cn.jiguang.j.b> a(int i) {
        HashMap hashMap;
        boolean z;
        boolean z2;
        try {
            List<String> a2 = f.a(new String[]{"ps"}, 1);
            if (a2 != null && !a2.isEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                String remove = a2.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    LinkedList linkedList = new LinkedList();
                    Collections.addAll(linkedList, remove.split("\\s+"));
                    int size = linkedList.size() - 1;
                    hashMap = new HashMap();
                    int a3 = a(linkedList, "USER", 0);
                    int a4 = a(linkedList, "PID", 1);
                    int a5 = a(linkedList, "PPID", 2);
                    int a6 = a(linkedList, "NAME", size);
                    if (a3 == 0 && a4 == 1 && a5 == 2 && a6 == size) {
                    }
                    for (String str : a2) {
                        cn.jiguang.j.b a7 = a(str, hashMap);
                        if (a7 != null) {
                            if (i != 3) {
                                String str2 = a7.f4123c;
                                if (!str2.equals("0") && !str2.equals("1") && !str2.equals(WakedResultReceiver.WAKE_TYPE_KEY)) {
                                    z2 = false;
                                    if (!z2) {
                                        if (f4126a.matcher(a7.f4124d).matches()) {
                                            hashSet.add(a7.f4122b);
                                        }
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                }
                            }
                            if (!"ps".equals(a7.f4124d)) {
                                arrayList.add(a7);
                            }
                        }
                    }
                    if (i != 1 && !hashSet.isEmpty()) {
                        ArrayList arrayList2 = new ArrayList();
                        for (boolean z3 = false; !z3; z3 = z) {
                            Iterator it = arrayList.iterator();
                            z = true;
                            while (it.hasNext()) {
                                cn.jiguang.j.b bVar = (cn.jiguang.j.b) it.next();
                                if (hashSet.contains(bVar.f4123c)) {
                                    arrayList2.add(bVar);
                                    hashSet.add(bVar.f4122b);
                                    it.remove();
                                    z = false;
                                }
                            }
                        }
                        return arrayList2;
                    }
                }
                hashMap = null;
                while (r5.hasNext()) {
                }
                return i != 1 ? arrayList : arrayList;
            }
            cn.jiguang.ad.a.a("JProcessHelper", "execute command failed");
            return null;
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JProcessHelper", "getRunningProcessInfo throwable:" + th.getMessage());
            return null;
        }
    }
}
