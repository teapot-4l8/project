package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.debug.UMRTLog;

/* compiled from: CacheDBHelper.java */
/* loaded from: classes2.dex */
public class am extends SQLiteOpenHelper {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f6382b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static am f6383c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f6384d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";

    /* renamed from: e  reason: collision with root package name */
    private static final String f6385e = "DROP TABLE IF EXISTS stf";
    private static final String f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";

    /* renamed from: a  reason: collision with root package name */
    private final Context f6386a;

    public static final int a() {
        return 1;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static am a(Context context) {
        am amVar;
        synchronized (f6382b) {
            if (f6383c == null) {
                f6383c = new am(context, ao.f6393b, null, 1);
            }
            amVar = f6383c;
        }
        return amVar;
    }

    private am(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f6386a = context;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f6385e);
            sQLiteDatabase.execSQL(f6384d);
        } catch (SQLException unused) {
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(f6384d);
        } catch (SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    public void b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public void a(String str, String str2, String[] strArr) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    private void d() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f);
                if (writableDatabase == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public an a(String str) {
        Cursor cursor;
        an anVar;
        an anVar2;
        try {
            Cursor a2 = a(str, new String[]{ao.i, ao.f6396e, ao.f, ao.g, ao.j, ao.k}, null, null, null, null, null, "1");
            if (a2 != null) {
                try {
                    if (a2.moveToFirst()) {
                        an anVar3 = new an();
                        try {
                            anVar3.f6387a = a2.getString(0);
                            anVar3.f6388b = a2.getString(1);
                            String string = a2.getString(2);
                            String string2 = a2.getString(3);
                            anVar3.f6389c = i.a(this.f6386a).d(string);
                            anVar3.f6390d = i.a(this.f6386a).d(string2);
                            anVar3.f6391e = a2.getString(4);
                            anVar3.f = a2.getString(5);
                            anVar2 = anVar3;
                            if (a2 == null) {
                                a2.close();
                                return anVar2;
                            }
                            return anVar2;
                        } catch (Throwable unused) {
                            cursor = a2;
                            anVar = anVar3;
                            try {
                                d();
                                if (cursor != null) {
                                }
                                return anVar;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    cursor = a2;
                    anVar = null;
                    d();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return anVar;
                }
            }
            anVar2 = null;
            if (a2 == null) {
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    public void a(String str, String str2) {
        a(str, "_uuid=?", new String[]{str2});
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean b(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.isOpen()) {
                        cursor = sQLiteDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (Throwable unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return false;
                    }
                    sQLiteDatabase.close();
                    return false;
                }
            }
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return true;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase == null) {
                return false;
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        sQLiteDatabase.close();
        return false;
    }

    public boolean c() {
        return !b(ao.f6394c);
    }
}
