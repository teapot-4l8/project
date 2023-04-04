package androidx.e.a.a;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.e.a.c;

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class b implements androidx.e.a.c {

    /* renamed from: a  reason: collision with root package name */
    private final a f1816a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, c.a aVar) {
        this.f1816a = a(context, str, aVar);
    }

    private a a(Context context, String str, c.a aVar) {
        return new a(context, str, new androidx.e.a.a.a[1], aVar);
    }

    @Override // androidx.e.a.c
    public void a(boolean z) {
        this.f1816a.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.e.a.c
    public androidx.e.a.b a() {
        return this.f1816a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final androidx.e.a.a.a[] f1817a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f1818b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1819c;

        a(Context context, String str, final androidx.e.a.a.a[] aVarArr, final c.a aVar) {
            super(context, str, null, aVar.f1824a, new DatabaseErrorHandler() { // from class: androidx.e.a.a.b.a.1
                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    c.a.this.d(a.a(aVarArr, sQLiteDatabase));
                }
            });
            this.f1818b = aVar;
            this.f1817a = aVarArr;
        }

        synchronized androidx.e.a.b a() {
            this.f1819c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f1819c) {
                close();
                return a();
            }
            return a(writableDatabase);
        }

        androidx.e.a.a.a a(SQLiteDatabase sQLiteDatabase) {
            return a(this.f1817a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f1818b.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f1819c = true;
            this.f1818b.a(a(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f1818b.a(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f1819c = true;
            this.f1818b.b(a(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f1819c) {
                return;
            }
            this.f1818b.c(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f1817a[0] = null;
        }

        static androidx.e.a.a.a a(androidx.e.a.a.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            androidx.e.a.a.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new androidx.e.a.a.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }
    }
}
