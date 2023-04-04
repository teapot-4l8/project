package a.a.a.c.b;

import a.a.a.c.b.a;
import a.a.a.c.d;
import a.a.a.d.ap;
import a.a.a.d.bx;
import a.a.a.d.cn;
import a.a.a.e.c;
import a.a.a.e.f;
import a.a.a.e.h;
import a.a.a.e.l;
import android.text.TextUtils;
import androidx.recyclerview.widget.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: DnsHelper.java */
/* loaded from: classes.dex */
public class b {
    public static void a() {
        long a2 = h.a();
        a aVar = new a();
        List asList = Arrays.asList(c.a(a.a.a.a.a().d()));
        aVar.b(asList.size() == 0 ? -1 : l.a.DEFAULT_DRAG_ANIMATION_DURATION);
        aVar.b(b(asList));
        aVar.a(a(asList));
        aVar.a(h.a(a2));
        f.a("NsLookup is end");
        d.a(a.a.a.c.c.NSLOOKUP, aVar.a());
    }

    private static List<JSONObject> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a("默认策略", c.a(a.a.a.e.a.a())));
        for (String str : list) {
            ArrayList arrayList2 = new ArrayList();
            try {
                ap apVar = new ap(a.a.a.e.a.a());
                apVar.a(new cn(str));
                apVar.d();
                if (apVar.f() == 0) {
                    for (bx bxVar : apVar.e()) {
                        arrayList2.add(bxVar.i());
                    }
                } else {
                    f.b(apVar.g());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            arrayList.add(a("指定DNS" + str, arrayList2));
        }
        return arrayList;
    }

    private static JSONObject a(String str, List<String> list) {
        long a2 = h.a();
        a.C0001a c0001a = new a.C0001a();
        c0001a.a(list.size() == 0 ? -1 : l.a.DEFAULT_DRAG_ANIMATION_DURATION);
        c0001a.b(a.a.a.e.a.a());
        c0001a.a(str);
        c0001a.a(b(list));
        c0001a.b(h.a(a2));
        return c0001a.a();
    }

    private static List<JSONObject> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            final a.b bVar = new a.b();
            if (TextUtils.isEmpty(str) || "*".equals(str)) {
                bVar.a("*");
                bVar.b("未知");
            } else if (str.startsWith("192.168")) {
                bVar.a(str);
                bVar.b("私网地址");
            } else {
                if (str.contains("(") && str.contains(")")) {
                    str = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
                }
                bVar.a(str);
                a.a.a.e.l.a(new l.a<String>() { // from class: a.a.a.c.b.b.1
                    @Override // a.a.a.e.l.a
                    public void a(String str2) {
                        a.b.this.b(str2);
                    }

                    @Override // a.a.a.e.l.a
                    public void a(Exception exc) {
                        a.b.this.b("未知");
                    }
                }, str);
            }
            arrayList.add(bVar.a());
        }
        return arrayList;
    }
}
