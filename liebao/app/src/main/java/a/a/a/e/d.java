package a.a.a.e;

import androidx.recyclerview.widget.l;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/* compiled from: Host.java */
/* loaded from: classes.dex */
public class d {
    public static a.a.a.c.c.a a() {
        a.a.a.c.c.a aVar = new a.a.a.c.c.a();
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/system/etc/hosts"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList.add(readLine);
            }
            bufferedReader.close();
            aVar.b(l.a.DEFAULT_DRAG_ANIMATION_DURATION);
        } catch (Exception e2) {
            aVar.b(-1);
            e2.printStackTrace();
        }
        aVar.a(arrayList);
        return aVar;
    }
}
