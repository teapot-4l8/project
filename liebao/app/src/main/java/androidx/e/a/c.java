package androidx.e.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* compiled from: SupportSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: androidx.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044c {
        c a(b bVar);
    }

    androidx.e.a.b a();

    void a(boolean z);

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f1824a;

        public void a(androidx.e.a.b bVar) {
        }

        public abstract void a(androidx.e.a.b bVar, int i, int i2);

        public abstract void b(androidx.e.a.b bVar);

        public void c(androidx.e.a.b bVar) {
        }

        public a(int i) {
            this.f1824a = i;
        }

        public void b(androidx.e.a.b bVar, int i, int i2) {
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        public void d(androidx.e.a.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.f());
            if (!bVar.e()) {
                a(bVar.f());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = bVar.g();
                } finally {
                    if (list != null) {
                        for (Pair<String, String> next : list) {
                            a((String) next.second);
                        }
                    } else {
                        a(bVar.f());
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                bVar.close();
            } catch (IOException unused2) {
            }
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.e("SupportSQLite", "Could not delete the database file " + str);
                        }
                    } catch (Exception e2) {
                        Log.e("SupportSQLite", "error while deleting corrupted database file", e2);
                    }
                }
            } catch (Exception e3) {
                Log.w("SupportSQLite", "delete failed: ", e3);
            }
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f1825a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1826b;

        /* renamed from: c  reason: collision with root package name */
        public final a f1827c;

        b(Context context, String str, a aVar) {
            this.f1825a = context;
            this.f1826b = str;
            this.f1827c = aVar;
        }

        public static a a(Context context) {
            return new a(context);
        }

        /* compiled from: SupportSQLiteOpenHelper.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            Context f1828a;

            /* renamed from: b  reason: collision with root package name */
            String f1829b;

            /* renamed from: c  reason: collision with root package name */
            a f1830c;

            public b a() {
                a aVar = this.f1830c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                Context context = this.f1828a;
                if (context == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                return new b(context, this.f1829b, aVar);
            }

            a(Context context) {
                this.f1828a = context;
            }

            public a a(String str) {
                this.f1829b = str;
                return this;
            }

            public a a(a aVar) {
                this.f1830c = aVar;
                return this;
            }
        }
    }
}
