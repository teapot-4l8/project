package a.a.a.c.i;

import a.a.a.c.c;
import a.a.a.c.d;
import a.a.a.c.i.a;
import a.a.a.e.f;
import a.a.a.e.h;
import a.a.a.e.n;
import androidx.recyclerview.widget.l;
import java.net.UnknownHostException;
import java.util.ArrayList;

/* compiled from: PortHelper.java */
/* loaded from: classes.dex */
public class b {
    public static void a() {
        long a2 = h.a();
        final a aVar = new a();
        aVar.a(a.a.a.a.a().e());
        final ArrayList arrayList = new ArrayList();
        try {
            n.a(a.a.a.e.a.a()).a().b().a(new n.a() { // from class: a.a.a.c.i.b.1
                @Override // a.a.a.e.n.a
                public void a(a.C0002a c0002a) {
                    if (c0002a.c()) {
                        arrayList.add(c0002a.a());
                    }
                }

                @Override // a.a.a.e.n.a
                public void a(ArrayList<Integer> arrayList2) {
                    aVar.a(l.a.DEFAULT_DRAG_ANIMATION_DURATION);
                    aVar.a(arrayList);
                }
            });
        } catch (UnknownHostException e2) {
            aVar.a(-1);
            e2.printStackTrace();
        }
        aVar.b(h.a(a2));
        f.a("PortScan is end");
        d.a(c.PORT_SCAN, aVar.a());
    }
}
