package androidx.e.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Pair;
import androidx.e.a.f;
import java.util.List;

/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
class a implements androidx.e.a.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f1811a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f1812b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteDatabase f1813c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SQLiteDatabase sQLiteDatabase) {
        this.f1813c = sQLiteDatabase;
    }

    @Override // androidx.e.a.b
    public f a(String str) {
        return new e(this.f1813c.compileStatement(str));
    }

    @Override // androidx.e.a.b
    public void a() {
        this.f1813c.beginTransaction();
    }

    @Override // androidx.e.a.b
    public void b() {
        this.f1813c.endTransaction();
    }

    @Override // androidx.e.a.b
    public void c() {
        this.f1813c.setTransactionSuccessful();
    }

    @Override // androidx.e.a.b
    public boolean d() {
        return this.f1813c.inTransaction();
    }

    @Override // androidx.e.a.b
    public Cursor b(String str) {
        return a(new androidx.e.a.a(str));
    }

    @Override // androidx.e.a.b
    public Cursor a(final androidx.e.a.e eVar) {
        return this.f1813c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.e.a.a.a.1
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                eVar.a(new d(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b(), f1812b, null);
    }

    @Override // androidx.e.a.b
    public void c(String str) {
        this.f1813c.execSQL(str);
    }

    @Override // androidx.e.a.b
    public boolean e() {
        return this.f1813c.isOpen();
    }

    @Override // androidx.e.a.b
    public String f() {
        return this.f1813c.getPath();
    }

    @Override // androidx.e.a.b
    public List<Pair<String, String>> g() {
        return this.f1813c.getAttachedDbs();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1813c.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f1813c == sQLiteDatabase;
    }
}
