package androidx.e.a;

import android.database.Cursor;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: SupportSQLiteDatabase.java */
/* loaded from: classes.dex */
public interface b extends Closeable {
    Cursor a(e eVar);

    f a(String str);

    void a();

    Cursor b(String str);

    void b();

    void c();

    void c(String str);

    boolean d();

    boolean e();

    String f();

    List<Pair<String, String>> g();
}
