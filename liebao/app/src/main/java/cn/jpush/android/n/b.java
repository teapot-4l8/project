package cn.jpush.android.n;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.helper.Logger;
import com.umeng.analytics.pro.ao;

/* loaded from: classes.dex */
public class b extends e {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f4401b;

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f4400a = {ao.f6395d, "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4402c = new Object();

    private b(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public static b a(Context context) {
        if (f4401b == null) {
            synchronized (f4402c) {
                if (f4401b == null) {
                    f4401b = new b(context.getApplicationContext());
                }
            }
        }
        return f4401b;
    }

    public static c a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            Logger.d("LocalNotificationDb", "cursor is null");
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(cursor.getLong(1));
            cVar.a(cursor.getInt(2));
            cVar.b(cursor.getInt(3));
            cVar.c(cursor.getInt(4));
            cVar.a(cursor.getString(5));
            cVar.c(cursor.getLong(6));
            cVar.b(cursor.getLong(7));
            Logger.i("LocalNotificationDb", cVar.toString());
            return cVar;
        } catch (Exception e2) {
            e2.getStackTrace();
            Logger.w("LocalNotificationDb", "initLocalNotificationDBData exception:" + e2.getMessage());
            return null;
        }
    }

    public int a(long j) {
        if (a(true)) {
            try {
                return getWritableDatabase().delete("t_localnotification", "ln_id=" + j, null);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            } finally {
                b(true);
            }
        }
        return 0;
    }

    public long a(long j, int i, int i2, int i3, String str, long j2, long j3) {
        try {
            if (a(true)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(i));
                contentValues.put("ln_remove", Integer.valueOf(i2));
                contentValues.put("ln_type", Integer.valueOf(i3));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                return getWritableDatabase().insert("t_localnotification", null, contentValues);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            b(true);
        }
        return 0L;
    }

    public Cursor a(int i, long j) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f4400a, "ln_count=" + i + " and ln_trigger_time<" + j, null, null, null, null, null);
        } catch (Exception e2) {
            Logger.w("LocalNotificationDb", "getOutDatas exception:" + e2.getMessage());
            return null;
        }
    }

    public Cursor a(long j, long j2) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f4400a, "ln_count>0 and ln_trigger_time<" + (j2 + j) + " and ln_trigger_time>" + j, null, null, null, null, null);
        } catch (Exception e2) {
            Logger.w("LocalNotificationDb", "getRtcDatas exception:" + e2.getMessage());
            return null;
        }
    }

    public c a(long j, int i) {
        if (a(false)) {
            Cursor cursor = null;
            try {
                cursor = getReadableDatabase().query(true, "t_localnotification", f4400a, "ln_id=" + j + " and ln_type=" + i, null, null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                }
                return a(cursor);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                b(false);
            }
        }
        throw new Exception("open database failed");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] a() {
        int[] iArr;
        boolean z;
        boolean z2;
        Cursor cursor = null;
        r11 = null;
        r11 = null;
        int[] iArr2 = null;
        cursor = null;
        if (!a(false)) {
            return null;
        }
        try {
            Cursor query = getReadableDatabase().query(true, "t_localnotification", new String[]{"ln_id"}, "1", null, null, null, null, null);
            if (query != null) {
                try {
                    try {
                        if (query.getCount() > 0) {
                            iArr = new int[query.getCount()];
                            try {
                                query.moveToFirst();
                                int i = 0;
                                do {
                                    iArr[i] = query.getInt(0);
                                    i++;
                                } while (query.moveToNext());
                                iArr2 = iArr;
                            } catch (Exception e2) {
                                e = e2;
                                cursor = query;
                                z = false;
                                try {
                                    e.printStackTrace();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    b(false);
                                    if (z) {
                                        b(true);
                                    }
                                    return iArr;
                                } catch (Throwable th) {
                                    th = th;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    b(false);
                                    if (z) {
                                        b(true);
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        iArr = iArr2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    z = false;
                    if (cursor != null) {
                    }
                    b(false);
                    if (z) {
                    }
                    throw th;
                }
            }
            if (a(true)) {
                try {
                    getWritableDatabase().execSQL("delete from t_localnotification");
                    z2 = true;
                } catch (Exception e4) {
                    e = e4;
                    iArr = iArr2;
                    cursor = query;
                    z = true;
                    e.printStackTrace();
                    if (cursor != null) {
                    }
                    b(false);
                    if (z) {
                    }
                    return iArr;
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    z = true;
                    if (cursor != null) {
                    }
                    b(false);
                    if (z) {
                    }
                    throw th;
                }
            } else {
                z2 = false;
            }
            if (query != null) {
                query.close();
            }
            b(false);
            if (z2) {
                b(true);
                return iArr2;
            }
            return iArr2;
        } catch (Exception e5) {
            e = e5;
            iArr = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public long b(long j, int i, int i2, int i3, String str, long j2, long j3) {
        if (a(true)) {
            try {
                String str2 = "ln_id=" + j;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(i));
                contentValues.put("ln_remove", Integer.valueOf(i2));
                contentValues.put("ln_type", Integer.valueOf(i3));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                return getWritableDatabase().update("t_localnotification", contentValues, str2, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            } finally {
                b(true);
            }
        }
        return 0L;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception unused) {
            Logger.v("LocalNotificationDb", "表已经存在");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }
}
