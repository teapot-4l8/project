package androidx.room.b;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import androidx.e.a.e;
import androidx.room.j;
import java.util.ArrayList;

/* compiled from: DBUtil.java */
/* loaded from: classes.dex */
public class b {
    public static Cursor a(j jVar, e eVar, boolean z) {
        Cursor a2 = jVar.a(eVar);
        if (z && (a2 instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) a2;
            int count = abstractWindowedCursor.getCount();
            return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? a.a(abstractWindowedCursor) : a2;
        }
        return a2;
    }

    public static void a(androidx.e.a.b bVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor b2 = bVar.b("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (b2.moveToNext()) {
            try {
                arrayList.add(b2.getString(0));
            } catch (Throwable th) {
                b2.close();
                throw th;
            }
        }
        b2.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.c("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }
}
