package cn.jpush.android.n;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class e extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f4408a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f4409b;

    /* renamed from: c  reason: collision with root package name */
    private volatile SQLiteDatabase f4410c;

    /* renamed from: d  reason: collision with root package name */
    private volatile SQLiteDatabase f4411d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4412e;
    private final Object f;
    private final Context g;
    private final String h;
    private final int i;
    private final SQLiteDatabase.CursorFactory j;

    public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f4408a = 0;
        this.f4409b = 0;
        this.f4412e = new Object();
        this.f = new Object();
        this.g = context;
        this.h = str;
        this.i = i;
        this.j = cursorFactory;
    }

    public boolean a(boolean z) {
        try {
            if (z) {
                synchronized (this.f4412e) {
                    getWritableDatabase();
                    this.f4409b++;
                }
                return true;
            }
            synchronized (this.f) {
                getReadableDatabase();
                this.f4408a++;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b(boolean z) {
        boolean z2 = true;
        if (z) {
            synchronized (this.f4412e) {
                if (this.f4411d != null && this.f4411d.isOpen()) {
                    int i = this.f4409b - 1;
                    this.f4409b = i;
                    if (i > 0) {
                        z2 = false;
                    }
                }
                if (z2) {
                    this.f4409b = 0;
                    if (this.f4411d != null) {
                        this.f4411d.close();
                    }
                    this.f4411d = null;
                }
            }
            return;
        }
        synchronized (this.f) {
            if (this.f4410c != null && this.f4410c.isOpen()) {
                int i2 = this.f4408a - 1;
                this.f4408a = i2;
                if (i2 > 0) {
                    z2 = false;
                }
            }
            if (z2) {
                this.f4408a = 0;
                if (this.f4410c != null) {
                    this.f4410c.close();
                }
                this.f4410c = null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (this.f4410c == null || !this.f4410c.isOpen()) {
            synchronized (this.f) {
                if (this.f4410c == null || !this.f4410c.isOpen()) {
                    try {
                        getWritableDatabase();
                    } catch (SQLiteException unused) {
                    }
                    String path = this.g.getDatabasePath(this.h).getPath();
                    this.f4410c = SQLiteDatabase.openDatabase(path, this.j, 1);
                    if (this.f4410c.getVersion() != this.i) {
                        throw new SQLiteException("Can't upgrade read-only database from version " + this.f4410c.getVersion() + " to " + this.i + ": " + path);
                    }
                    this.f4408a = 0;
                    onOpen(this.f4410c);
                }
            }
        }
        return this.f4410c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (this.f4411d == null || !this.f4411d.isOpen()) {
            synchronized (this.f4412e) {
                if (this.f4411d == null || !this.f4411d.isOpen()) {
                    this.f4409b = 0;
                    this.f4411d = super.getWritableDatabase();
                    if (Build.VERSION.SDK_INT >= 11) {
                        this.f4411d.enableWriteAheadLogging();
                    }
                }
            }
        }
        return this.f4411d;
    }
}
