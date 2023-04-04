package androidx.e.a.a;

import android.database.sqlite.SQLiteProgram;

/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
class d implements androidx.e.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f1822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SQLiteProgram sQLiteProgram) {
        this.f1822a = sQLiteProgram;
    }

    @Override // androidx.e.a.d
    public void a(int i) {
        this.f1822a.bindNull(i);
    }

    @Override // androidx.e.a.d
    public void a(int i, long j) {
        this.f1822a.bindLong(i, j);
    }

    @Override // androidx.e.a.d
    public void a(int i, double d2) {
        this.f1822a.bindDouble(i, d2);
    }

    @Override // androidx.e.a.d
    public void a(int i, String str) {
        this.f1822a.bindString(i, str);
    }

    @Override // androidx.e.a.d
    public void a(int i, byte[] bArr) {
        this.f1822a.bindBlob(i, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1822a.close();
    }
}
