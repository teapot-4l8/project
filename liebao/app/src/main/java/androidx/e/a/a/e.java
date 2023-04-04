package androidx.e.a.a;

import android.database.sqlite.SQLiteStatement;
import androidx.e.a.f;

/* compiled from: FrameworkSQLiteStatement.java */
/* loaded from: classes.dex */
class e extends d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteStatement f1823a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f1823a = sQLiteStatement;
    }

    @Override // androidx.e.a.f
    public int a() {
        return this.f1823a.executeUpdateDelete();
    }

    @Override // androidx.e.a.f
    public long b() {
        return this.f1823a.executeInsert();
    }
}
