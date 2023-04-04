package a.a.a.c.f;

import a.a.a.c.c;
import a.a.a.c.d;
import a.a.a.e.f;
import a.a.a.e.h;
import a.a.a.e.i;
import androidx.recyclerview.widget.l;
import java.util.Collections;
import java.util.List;

/* compiled from: MtuHelper.java */
/* loaded from: classes.dex */
public class b {
    public static void a() {
        long a2 = h.a();
        i iVar = new i(a.a.a.e.a.a());
        List<Integer> b2 = iVar.b();
        a aVar = new a();
        if (b2.size() == 0) {
            aVar.b(-1);
        } else {
            aVar.b(l.a.DEFAULT_DRAG_ANIMATION_DURATION);
            Collections.sort(b2);
            aVar.c(b2.get(b2.size() - 1).intValue() + 28);
        }
        iVar.a();
        aVar.a(h.a(a2));
        f.a("MtuScan is end");
        d.a(c.MTU_SCAN, aVar.a());
    }
}
