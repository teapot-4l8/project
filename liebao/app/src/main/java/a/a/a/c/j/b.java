package a.a.a.c.j;

import a.a.a.c.c;
import a.a.a.c.d;
import a.a.a.c.j.a;
import a.a.a.e.f;
import a.a.a.e.h;
import a.a.a.e.l;
import a.a.a.e.s;
import android.text.TextUtils;
import androidx.recyclerview.widget.l;
import java.util.ArrayList;

/* compiled from: TraceRouteHelper.java */
/* loaded from: classes.dex */
public class b {
    public static void a() {
        long a2 = h.a();
        final a aVar = new a();
        final ArrayList arrayList = new ArrayList();
        s.a().a(a.a.a.e.a.a(), new s.b() { // from class: a.a.a.c.j.b.1
            @Override // a.a.a.e.s.b
            public void a(a.C0003a c0003a) {
                try {
                    b.b(c0003a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                arrayList.add(c0003a.a());
            }

            @Override // a.a.a.e.s.b
            public void a(boolean z) {
                aVar.a(z ? l.a.DEFAULT_DRAG_ANIMATION_DURATION : -1);
                aVar.a(arrayList);
            }
        });
        aVar.b(h.a(a2));
        f.a("TraceRoute is end");
        d.a(c.TRACE_ROUTE, aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a.C0003a c0003a) {
        String c2 = c0003a.c();
        if (TextUtils.isEmpty(c2) || "*".equals(c2)) {
            c0003a.c("未知");
        } else if (c2.startsWith("192.168")) {
            c0003a.c("私网地址");
        } else {
            if (c2.contains("(") && c2.contains(")")) {
                c2 = c2.substring(c2.indexOf("(") + 1, c2.indexOf(")"));
            }
            a.a.a.e.l.a(new l.a<String>() { // from class: a.a.a.c.j.b.2
                @Override // a.a.a.e.l.a
                public void a(String str) {
                    a.C0003a.this.c(str);
                }

                @Override // a.a.a.e.l.a
                public void a(Exception exc) {
                    a.C0003a.this.c("未知");
                }
            }, c2);
        }
    }
}
