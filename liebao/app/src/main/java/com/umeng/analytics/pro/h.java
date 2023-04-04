package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: UMDBUtils.java */
/* loaded from: classes2.dex */
public class h {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r1 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, SQLiteDatabase sQLiteDatabase) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("sqlite_master", new String[]{"count(*)"}, "type=? and name=?", new String[]{"table", str.trim()}, null, null, null, null);
            if (cursor.moveToNext()) {
                if (cursor.getInt(0) > 0) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            File databasePath = context.getDatabasePath(e.f6503b);
            if (databasePath != null && databasePath.exists()) {
                databasePath.delete();
            }
            f.a(context).a();
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        File databasePath = context.getDatabasePath(e.f6503b);
        return databasePath.getParent() + File.separator;
    }

    public static String c(Context context) {
        return b(context) + "subprocess/";
    }

    public static String a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    public static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r9.isClosed() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r9.isClosed() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(str, null, null, null, null, null, "LIMIT 0");
            if (cursor != null) {
                if (cursor.getColumnIndex(str2) != -1) {
                    z = true;
                }
            }
            if (cursor != null) {
            }
        } catch (Exception unused) {
            if (cursor != null) {
            }
        } catch (Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        return z;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("alter table " + str + " add " + str2 + " " + str3);
    }
}
