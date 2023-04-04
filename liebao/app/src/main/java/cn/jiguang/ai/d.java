package cn.jiguang.ai;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {
    public static List<cn.jiguang.ah.b> a(String str, String str2, String str3, int i) {
        List<cn.jiguang.ah.b> list;
        cn.jiguang.ah.b bVar = new cn.jiguang.ah.b();
        bVar.f3701a = str2;
        bVar.f3702b = str3;
        if (str == null || TextUtils.isEmpty(str)) {
            list = null;
        } else {
            list = c.a(str);
            cn.jiguang.ad.a.a("JWakePackageHelper", "cache cmd wakeTargets:" + list);
        }
        if (list != null && !list.isEmpty()) {
            int size = list.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (list.get(size).f3701a.equals(str2) && list.get(size).f3702b.equals(str3)) {
                        list.remove(size);
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (i == 1) {
            list.add(bVar);
        }
        return list;
    }
}
