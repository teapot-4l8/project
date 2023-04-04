package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMStoreManager.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6559a = 2049;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6560b = 2050;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6561c = 1000;

    /* renamed from: d  reason: collision with root package name */
    private static Context f6562d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f6563e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* compiled from: UMStoreManager.java */
    /* loaded from: classes2.dex */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMStoreManager.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final i f6569a = new i();

        private b() {
        }
    }

    private i() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    public static i a(Context context) {
        i iVar = b.f6569a;
        if (f6562d == null && context != null) {
            f6562d = context.getApplicationContext();
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public void a() {
        this.i.clear();
    }

    public void b() {
        this.l.clear();
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
        if (r2 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
        if (r2 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(JSONArray jSONArray) {
        SQLiteDatabase a2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                a2 = g.a(f6562d).a();
            } catch (SQLiteDatabaseCorruptException unused) {
            } catch (Throwable unused2) {
            }
            try {
                try {
                    a2.beginTransaction();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            ContentValues contentValues = new ContentValues();
                            String optString = jSONObject.optString("__i");
                            if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                                optString = u.a().b();
                                if (TextUtils.isEmpty(optString)) {
                                    optString = "-1";
                                }
                            }
                            contentValues.put("__i", optString);
                            contentValues.put("__e", jSONObject.optString("id"));
                            contentValues.put("__t", Integer.valueOf(jSONObject.optInt("__t")));
                            contentValues.put("__av", UMUtils.getAppVersionName(f6562d));
                            contentValues.put("__vc", UMUtils.getAppVersionCode(f6562d));
                            jSONObject.remove("__i");
                            jSONObject.remove("__t");
                            contentValues.put("__s", c(jSONObject.toString()));
                            a2.insert(e.b.f6518a, null, contentValues);
                        } catch (Exception unused3) {
                        }
                    }
                    a2.setTransactionSuccessful();
                } catch (Throwable unused4) {
                    sQLiteDatabase = a2;
                }
            } catch (SQLiteDatabaseCorruptException unused5) {
                sQLiteDatabase = a2;
                try {
                    h.a(f6562d);
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused6) {
                        }
                    }
                    g.a(f6562d).b();
                    throw th;
                }
            }
            if (a2 != null) {
                a2.endTransaction();
            }
        } catch (Throwable unused7) {
        }
        g.a(f6562d).b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i) {
        SQLiteDatabase a2;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                a2 = g.a(f6562d).a();
                try {
                    a2.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("__i", str);
                    String c2 = c(str2);
                    if (!TextUtils.isEmpty(c2)) {
                        contentValues.put("__a", c2);
                        contentValues.put("__t", Integer.valueOf(i));
                        contentValues.put("__av", UMUtils.getAppVersionName(f6562d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(f6562d));
                        a2.insert(e.a.f6507a, null, contentValues);
                    }
                    a2.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = a2;
                    try {
                        h.a(f6562d);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        g.a(f6562d).b();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = a2;
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
            } catch (Throwable unused5) {
            }
            if (a2 != null) {
                a2.endTransaction();
            }
        } catch (Throwable unused6) {
        }
        g.a(f6562d).b();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                sQLiteDatabase.beginTransaction();
                String c2 = u.a().c();
                if (TextUtils.isEmpty(c2)) {
                    return;
                }
                String[] strArr = {"", "-1"};
                for (int i = 0; i < 2; i++) {
                    sQLiteDatabase.execSQL("update __et set __i=\"" + c2 + "\" where __i=\"" + strArr[i] + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f6562d);
            } catch (Throwable unused2) {
            }
            g.a(f6562d).b();
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f6562d).b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
        if (r2 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
        if (r2 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, JSONObject jSONObject, a aVar) {
        SQLiteDatabase a2;
        if (jSONObject == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                a2 = g.a(f6562d).a();
                try {
                    a2.beginTransaction();
                    if (aVar == a.BEGIN) {
                        long longValue = ((Long) jSONObject.opt("__e")).longValue();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__ii", str);
                        contentValues.put("__e", String.valueOf(longValue));
                        contentValues.put("__av", UMUtils.getAppVersionName(f6562d));
                        contentValues.put("__vc", UMUtils.getAppVersionCode(f6562d));
                        a2.insert(e.d.f6540a, null, contentValues);
                    } else if (aVar == a.INSTANTSESSIONBEGIN) {
                        b(str, jSONObject, a2);
                    } else if (aVar == a.END) {
                        a(str, jSONObject, a2);
                    } else if (aVar == a.PAGE) {
                        a(str, jSONObject, a2, "__a");
                    } else if (aVar == a.AUTOPAGE) {
                        a(str, jSONObject, a2, e.d.a.f6543c);
                    } else if (aVar == a.NEWSESSION) {
                        c(str, jSONObject, a2);
                    }
                    a2.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    sQLiteDatabase = a2;
                    try {
                        h.a(f6562d);
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        g.a(f6562d).b();
                        throw th;
                    }
                } catch (Throwable unused3) {
                    sQLiteDatabase = a2;
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
            } catch (Throwable unused5) {
            }
            if (a2 != null) {
                a2.endTransaction();
            }
        } catch (Throwable unused6) {
        }
        g.a(f6562d).b();
        return false;
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(e.d.a.g)).longValue();
            long j = 0;
            Object opt = jSONObject.opt(e.d.a.h);
            if (opt != null && (opt instanceof Long)) {
                j = ((Long) opt).longValue();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", " + e.d.a.h + "=\"" + j + "\", __sp=\"" + c2 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c2);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(f6562d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f6562d));
            sQLiteDatabase.insert(e.c.f6529a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r4 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
        r4.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
        if (r4 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        long j = 0;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
            } catch (Exception unused) {
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = null;
            }
            try {
                sQLiteDatabase.beginTransaction();
                cursor = a(e.d.f6540a, sQLiteDatabase, new String[]{e.d.a.g}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    j = cursor.getLong(cursor.getColumnIndex(e.d.a.g));
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception unused2) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                        g.a(f6562d).b();
                        throw th;
                    }
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                g.a(f6562d).b();
                throw th;
            }
        } catch (Exception unused4) {
        }
        g.a(f6562d).b();
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        JSONObject jSONObject2;
        String str2;
        Cursor cursor2;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(e.d.a.f6545e);
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject;
                Cursor a2 = a(e.d.f6540a, sQLiteDatabase, new String[]{e.d.a.f6545e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (a2 != null) {
                    String str3 = null;
                    while (a2.moveToNext()) {
                        try {
                            str3 = d(a2.getString(a2.getColumnIndex(e.d.a.f6545e)));
                        } catch (Throwable unused) {
                            cursor = a2;
                            if (cursor == null) {
                            }
                        }
                    }
                    String str4 = str3;
                    cursor2 = a2;
                    str2 = str4;
                } else {
                    cursor2 = a2;
                    str2 = null;
                }
            } else {
                jSONObject2 = optJSONObject;
                str2 = null;
                cursor2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray = new JSONArray(str2);
                    }
                    jSONArray.put(jSONObject2);
                    String c2 = c(jSONArray.toString());
                    if (!TextUtils.isEmpty(c2)) {
                        sQLiteDatabase.execSQL("update  __sd set __d=\"" + c2 + "\" where __ii=\"" + str + "\"");
                    }
                } catch (Throwable unused2) {
                    cursor = cursor2;
                    if (cursor == null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(e.d.a.f6544d);
            if (optJSONObject2 != null) {
                String c3 = c(optJSONObject2.toString());
                if (!TextUtils.isEmpty(c3)) {
                    sQLiteDatabase.execSQL("update  __sd set __c=\"" + c3 + "\" where __ii=\"" + str + "\"");
                }
            }
            long optLong = jSONObject.optLong(e.d.a.g);
            sQLiteDatabase.execSQL("update  __sd set __f=\"" + String.valueOf(optLong) + "\" where __ii=\"" + str + "\"");
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[Catch: all -> 0x0069, TryCatch #2 {all -> 0x0069, blocks: (B:22:0x0056, B:24:0x005c, B:26:0x006c, B:28:0x0077, B:29:0x007c, B:36:0x008b, B:38:0x0091, B:40:0x0097, B:42:0x009d, B:44:0x00ab, B:41:0x009a), top: B:56:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:56:0x0056->B:24:0x005c, LOOP_START, PHI: r14 
      PHI: (r14v2 java.lang.String) = (r14v7 java.lang.String), (r14v3 java.lang.String) binds: [B:21:0x0054, B:24:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) {
        JSONArray jSONArray;
        JSONArray optJSONArray;
        Cursor a2;
        JSONArray jSONArray2;
        Cursor cursor = null;
        r14 = null;
        String str3 = null;
        try {
            if ("__a".equals(str2)) {
                optJSONArray = jSONObject.optJSONArray("__a");
                if (optJSONArray == null) {
                    return;
                }
                if (optJSONArray.length() <= 0) {
                    return;
                }
            } else if (e.d.a.f6543c.equals(str2)) {
                optJSONArray = jSONObject.optJSONArray(e.d.a.f6543c);
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    return;
                }
            } else {
                jSONArray = null;
                a2 = a(e.d.f6540a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (a2 != null) {
                    while (a2.moveToNext()) {
                        try {
                            str3 = d(a2.getString(a2.getColumnIndex(str2)));
                        } catch (Throwable unused) {
                            cursor = a2;
                            if (cursor != null) {
                                cursor.close();
                                return;
                            }
                            return;
                        }
                    }
                }
                jSONArray2 = new JSONArray();
                if (!TextUtils.isEmpty(str3)) {
                    jSONArray2 = new JSONArray(str3);
                }
                if (jSONArray2.length() <= f6561c) {
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            jSONArray2.put(jSONObject2);
                        }
                    } catch (JSONException unused2) {
                    }
                }
                String c2 = c(jSONArray2.toString());
                if (!TextUtils.isEmpty(c2)) {
                    sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + c2 + "\" where __ii=\"" + str + "\"");
                }
                if (a2 != null) {
                    a2.close();
                    return;
                }
                return;
            }
            jSONArray = optJSONArray;
            a2 = a(e.d.f6540a, sQLiteDatabase, new String[]{str2}, "__ii=? ", new String[]{str}, null, null, null, null);
            if (a2 != null) {
            }
            jSONArray2 = new JSONArray();
            if (!TextUtils.isEmpty(str3)) {
            }
            if (jSONArray2.length() <= f6561c) {
            }
        } catch (Throwable unused3) {
        }
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String a2 = a(jSONObject, z);
            if (!TextUtils.isEmpty(a2)) {
                b(jSONObject, a2);
                a(jSONObject, a2);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f() {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.l.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = g.a(f6562d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor a2 = a(e.c.f6529a, sQLiteDatabase, null, "__ii=? ", new String[]{this.l.get(0)}, null, null, null, null);
                if (a2 != null) {
                    try {
                        if (a2.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = a2.getString(a2.getColumnIndex("__av"));
                                String string2 = a2.getString(a2.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = a2;
                                try {
                                    h.a(f6562d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    g.a(f6562d).b();
                                    throw th;
                                }
                            } catch (Throwable unused3) {
                                cursor = a2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (a2 != null) {
                    a2.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                g.a(f6562d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        g.a(f6562d).b();
        return jSONObject;
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0174, code lost:
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0182, code lost:
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0190, code lost:
        if (r1 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0192, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0195, code lost:
        com.umeng.analytics.pro.g.a(com.umeng.analytics.pro.i.f6562d).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019e, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
            } catch (SQLiteDatabaseCorruptException unused) {
                sQLiteDatabase = null;
            } catch (Throwable unused2) {
                sQLiteDatabase = null;
            }
            try {
                sQLiteDatabase.beginTransaction();
                cursor = !TextUtils.isEmpty(str) ? a(e.b.f6518a, sQLiteDatabase, null, "__i=? ", new String[]{str}, null, null, null, null) : a(e.b.f6518a, sQLiteDatabase, null, null, null, null, null, null, null);
                if (cursor != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    String b2 = u.a().b();
                    while (cursor.moveToNext()) {
                        int i = cursor.getInt(cursor.getColumnIndex("__t"));
                        String string = cursor.getString(cursor.getColumnIndex("__i"));
                        String string2 = cursor.getString(cursor.getColumnIndex("__s"));
                        if (TextUtils.isEmpty(string) || "-1".equals(string)) {
                            if (!TextUtils.isEmpty(b2)) {
                                string = b2;
                            }
                        }
                        this.j.add(Integer.valueOf(cursor.getInt(0)));
                        if (i != 2049) {
                            if (i == 2050 && !TextUtils.isEmpty(string2)) {
                                JSONObject jSONObject4 = new JSONObject(d(string2));
                                JSONArray optJSONArray = jSONObject3.has(string) ? jSONObject3.optJSONArray(string) : new JSONArray();
                                optJSONArray.put(jSONObject4);
                                jSONObject3.put(string, optJSONArray);
                            }
                        } else if (!TextUtils.isEmpty(string2)) {
                            JSONObject jSONObject5 = new JSONObject(d(string2));
                            JSONArray optJSONArray2 = jSONObject2.has(string) ? jSONObject2.optJSONArray(string) : new JSONArray();
                            optJSONArray2.put(jSONObject5);
                            jSONObject2.put(string, optJSONArray2);
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            JSONObject jSONObject6 = new JSONObject();
                            String next = keys.next();
                            jSONObject6.put(next, new JSONArray(jSONObject2.optString(next)));
                            if (jSONObject6.length() > 0) {
                                jSONArray.put(jSONObject6);
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put("ekv", jSONArray);
                        }
                    }
                    if (jSONObject3.length() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator<String> keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            JSONObject jSONObject7 = new JSONObject();
                            String next2 = keys2.next();
                            jSONObject7.put(next2, new JSONArray(jSONObject3.optString(next2)));
                            if (jSONObject7.length() > 0) {
                                jSONArray2.put(jSONObject7);
                            }
                        }
                        if (jSONArray2.length() > 0) {
                            jSONObject.put(d.T, jSONArray2);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteDatabaseCorruptException unused3) {
                h.a(f6562d);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable unused4) {
                h.a(f6562d);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused5) {
                }
            }
            g.a(f6562d).b();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
        if (r1 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        if (r1 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0093, code lost:
        if (r1 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0095, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
        com.umeng.analytics.pro.g.a(com.umeng.analytics.pro.i.f6562d).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a1, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(JSONObject jSONObject, String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = !TextUtils.isEmpty(str) ? a(e.a.f6507a, sQLiteDatabase, null, "__i=? ", new String[]{str}, null, null, null, null) : a(e.a.f6507a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (cursor != null) {
                        JSONArray jSONArray = new JSONArray();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("__a"));
                            if (!TextUtils.isEmpty(string)) {
                                jSONArray.put(new JSONObject(d(string)));
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put(d.O, jSONArray);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused) {
                    h.a(f6562d);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable unused2) {
                    h.a(f6562d);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (SQLiteDatabaseCorruptException unused3) {
                sQLiteDatabase = null;
            } catch (Throwable unused4) {
                sQLiteDatabase = null;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused5) {
                }
            }
            g.a(f6562d).b();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0087, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject g() {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        r3 = null;
        cursor = null;
        Cursor cursor2 = null;
        if (this.i.isEmpty()) {
            return null;
        }
        try {
            sQLiteDatabase = g.a(f6562d).a();
            try {
                sQLiteDatabase.beginTransaction();
                Cursor a2 = a(e.d.f6540a, sQLiteDatabase, null, "__ii=? ", new String[]{this.i.get(0)}, null, null, null, null);
                if (a2 != null) {
                    try {
                        if (a2.moveToNext()) {
                            jSONObject = new JSONObject();
                            try {
                                String string = a2.getString(a2.getColumnIndex("__av"));
                                String string2 = a2.getString(a2.getColumnIndex("__vc"));
                                jSONObject.put("__av", string);
                                jSONObject.put("__vc", string2);
                                jSONObject2 = jSONObject;
                            } catch (SQLiteDatabaseCorruptException unused) {
                                cursor2 = a2;
                                try {
                                    h.a(f6562d);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } catch (Throwable th) {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        try {
                                            sQLiteDatabase.endTransaction();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    g.a(f6562d).b();
                                    throw th;
                                }
                            } catch (Throwable unused3) {
                                cursor = a2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    } catch (SQLiteDatabaseCorruptException unused4) {
                        jSONObject = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject = jSONObject2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (a2 != null) {
                    a2.close();
                }
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused6) {
                    }
                }
                g.a(f6562d).b();
                return jSONObject2;
            } catch (SQLiteDatabaseCorruptException unused7) {
                jSONObject = null;
            } catch (Throwable unused8) {
                jSONObject = null;
            }
        } catch (SQLiteDatabaseCorruptException unused9) {
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable unused10) {
            sQLiteDatabase = null;
            jSONObject = null;
        }
        g.a(f6562d).b();
        return jSONObject;
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0233, code lost:
        if (r12 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0235, code lost:
        r12.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0238, code lost:
        com.umeng.analytics.pro.g.a(com.umeng.analytics.pro.i.f6562d).b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0241, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0211, code lost:
        if (r12 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0224, code lost:
        if (r12 == null) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(JSONObject jSONObject, boolean z) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        JSONArray jSONArray;
        String str;
        JSONArray jSONArray2;
        String str2 = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor a2 = a(e.d.f6540a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (a2 != null) {
                        try {
                            JSONArray jSONArray3 = new JSONArray();
                            while (true) {
                                if (!a2.moveToNext()) {
                                    cursor = a2;
                                    jSONArray = jSONArray3;
                                    break;
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                String string = a2.getString(a2.getColumnIndex(e.d.a.g));
                                String string2 = a2.getString(a2.getColumnIndex("__e"));
                                String string3 = a2.getString(a2.getColumnIndex(e.d.a.h));
                                str2 = a2.getString(a2.getColumnIndex("__ii"));
                                try {
                                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                                        str = str2;
                                        cursor = a2;
                                        jSONArray = jSONArray3;
                                    } else {
                                        if (Long.parseLong(string) - Long.parseLong(string2) > 0) {
                                            String string4 = a2.getString(a2.getColumnIndex("__a"));
                                            String string5 = a2.getString(a2.getColumnIndex(e.d.a.f6543c));
                                            String string6 = a2.getString(a2.getColumnIndex(e.d.a.f6544d));
                                            String string7 = a2.getString(a2.getColumnIndex(e.d.a.f6545e));
                                            this.i.add(str2);
                                            String string8 = a2.getString(a2.getColumnIndex("__sp"));
                                            String string9 = a2.getString(a2.getColumnIndex("__pp"));
                                            jSONObject2.put("id", str2);
                                            jSONObject2.put(d.p, string2);
                                            jSONObject2.put(d.f6501q, string);
                                            str = str2;
                                            if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
                                                try {
                                                    if (Long.parseLong(string3) <= 0) {
                                                        jSONObject2.put("duration", Long.parseLong(string) - Long.parseLong(string2));
                                                        cursor = a2;
                                                        jSONArray2 = jSONArray3;
                                                    } else {
                                                        cursor = a2;
                                                        jSONArray2 = jSONArray3;
                                                        jSONObject2.put("duration", Long.parseLong(string3));
                                                        jSONObject2.put(d.s, Long.parseLong(string) - Long.parseLong(string2));
                                                    }
                                                } catch (SQLiteDatabaseCorruptException unused) {
                                                    cursor = a2;
                                                    str2 = str;
                                                    h.a(f6562d);
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                } catch (Throwable unused2) {
                                                    cursor = a2;
                                                    str2 = str;
                                                    h.a(f6562d);
                                                    if (cursor != null) {
                                                        cursor.close();
                                                    }
                                                }
                                            } else {
                                                cursor = a2;
                                                jSONArray2 = jSONArray3;
                                                jSONObject2.put("duration", Long.parseLong(string) - Long.parseLong(string2));
                                            }
                                            if (!TextUtils.isEmpty(string4)) {
                                                try {
                                                    jSONObject2.put(d.t, new JSONArray(d(string4)));
                                                } catch (SQLiteDatabaseCorruptException unused3) {
                                                    str2 = str;
                                                    h.a(f6562d);
                                                    if (cursor != null) {
                                                    }
                                                } catch (Throwable unused4) {
                                                    str2 = str;
                                                    h.a(f6562d);
                                                    if (cursor != null) {
                                                    }
                                                }
                                            }
                                            boolean z2 = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO;
                                            if (!TextUtils.isEmpty(string5) && z2) {
                                                JSONArray jSONArray4 = new JSONArray(d(string5));
                                                JSONArray jSONArray5 = new JSONArray();
                                                if (jSONArray4.length() > 0) {
                                                    jSONArray5 = b(jSONArray4);
                                                }
                                                jSONObject2.put(d.u, jSONArray5);
                                            }
                                            if (!TextUtils.isEmpty(string6)) {
                                                jSONObject2.put(d.F, new JSONObject(d(string6)));
                                            }
                                            if (!TextUtils.isEmpty(string7)) {
                                                jSONObject2.put(d.B, new JSONArray(d(string7)));
                                            }
                                            if (!TextUtils.isEmpty(string8)) {
                                                jSONObject2.put(d.au, new JSONObject(d(string8)));
                                            }
                                            if (!TextUtils.isEmpty(string9)) {
                                                jSONObject2.put(d.av, new JSONObject(d(string9)));
                                            }
                                            if (jSONObject2.length() > 0) {
                                                jSONArray = jSONArray2;
                                                jSONArray.put(jSONObject2);
                                            } else {
                                                jSONArray = jSONArray2;
                                            }
                                        } else {
                                            str = str2;
                                            cursor = a2;
                                            jSONArray = jSONArray3;
                                        }
                                        if (z) {
                                            str2 = str;
                                            break;
                                        }
                                    }
                                    jSONArray3 = jSONArray;
                                    a2 = cursor;
                                    str2 = str;
                                } catch (SQLiteDatabaseCorruptException unused5) {
                                    cursor = a2;
                                    h.a(f6562d);
                                    if (cursor != null) {
                                    }
                                } catch (Throwable unused6) {
                                    cursor = a2;
                                    h.a(f6562d);
                                    if (cursor != null) {
                                    }
                                }
                            }
                            try {
                                if (this.i.size() < 1) {
                                    return str2;
                                }
                                if (jSONArray.length() > 0) {
                                    jSONObject.put(d.n, jSONArray);
                                }
                            } catch (SQLiteDatabaseCorruptException unused7) {
                                h.a(f6562d);
                                if (cursor != null) {
                                }
                            } catch (Throwable unused8) {
                                h.a(f6562d);
                                if (cursor != null) {
                                }
                            }
                        } catch (SQLiteDatabaseCorruptException unused9) {
                        } catch (Throwable unused10) {
                        }
                    } else {
                        cursor = a2;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (SQLiteDatabaseCorruptException unused11) {
                    cursor = null;
                } catch (Throwable unused12) {
                    cursor = null;
                }
            } catch (SQLiteDatabaseCorruptException unused13) {
                sQLiteDatabase = null;
                cursor = null;
            } catch (Throwable unused14) {
                sQLiteDatabase = null;
                cursor = null;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused15) {
                }
            }
            g.a(f6562d).b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e6, code lost:
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e8, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(JSONObject jSONObject, boolean z) {
        Object obj;
        SQLiteDatabase sQLiteDatabase;
        ?? r0 = 0;
        String str = null;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = null;
        r0 = null;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor a2 = a(e.c.f6529a, sQLiteDatabase, null, null, null, null, null, null, null);
                    if (a2 != null) {
                        try {
                            JSONArray jSONArray = new JSONArray();
                            while (a2.moveToNext()) {
                                JSONObject jSONObject2 = new JSONObject();
                                String string = a2.getString(a2.getColumnIndex("__e"));
                                str = a2.getString(a2.getColumnIndex("__ii"));
                                this.l.add(str);
                                String string2 = a2.getString(a2.getColumnIndex("__sp"));
                                String string3 = a2.getString(a2.getColumnIndex("__pp"));
                                if (!TextUtils.isEmpty(string2)) {
                                    jSONObject2.put(d.au, new JSONObject(d(string2)));
                                }
                                if (!TextUtils.isEmpty(string3)) {
                                    jSONObject2.put(d.av, new JSONObject(d(string3)));
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    jSONObject2.put("id", str);
                                    jSONObject2.put(d.p, string);
                                    if (jSONObject2.length() > 0) {
                                        jSONArray.put(jSONObject2);
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            r0 = str;
                            if (jSONArray.length() > 0) {
                                jSONObject.put(d.n, jSONArray);
                                r0 = str;
                            }
                        } catch (SQLiteDatabaseCorruptException unused) {
                            obj = r0;
                            cursor = a2;
                            h.a(f6562d);
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable unused2) {
                            obj = r0;
                            cursor2 = a2;
                            h.a(f6562d);
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (a2 != null) {
                        a2.close();
                    }
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                    g.a(f6562d).b();
                } catch (SQLiteDatabaseCorruptException unused4) {
                    obj = null;
                } catch (Throwable unused5) {
                    obj = null;
                }
            } catch (SQLiteDatabaseCorruptException unused6) {
                obj = null;
                sQLiteDatabase = null;
            } catch (Throwable unused7) {
                obj = null;
                sQLiteDatabase = null;
            }
            return r0;
            g.a(f6562d).b();
            r0 = obj;
            return r0;
        } catch (Throwable th) {
            if (r0 != 0) {
                r0.close();
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused8) {
                }
            }
            g.a(f6562d).b();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                sQLiteDatabase.beginTransaction();
                if (!z2) {
                    int size = this.l.size();
                    int i = 0;
                    if (size > 0) {
                        int i2 = 0;
                        while (i < size) {
                            String str = this.l.get(i);
                            if (str == null) {
                                i2 = 1;
                            }
                            sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                            i++;
                        }
                        i = i2;
                    }
                    if (i != 0) {
                        sQLiteDatabase.execSQL("delete from __is where __ii is null");
                    }
                } else if (z) {
                    sQLiteDatabase.execSQL("delete from __is");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                g.a(f6562d).b();
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            h.a(f6562d);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                sQLiteDatabase.beginTransaction();
                if (z2) {
                    if (z) {
                        sQLiteDatabase.execSQL("delete from __sd");
                    }
                } else if (this.i.size() > 0) {
                    for (int i = 0; i < this.i.size(); i++) {
                        sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + this.i.get(i) + "\"");
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f6562d);
            } catch (Throwable unused2) {
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f6562d).b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                sQLiteDatabase.beginTransaction();
                if (this.j.size() > 0) {
                    for (int i = 0; i < this.j.size(); i++) {
                        sQLiteDatabase.execSQL("delete from __et where rowid=" + this.j.get(i));
                    }
                }
                this.j.clear();
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f6562d);
            } catch (Throwable unused2) {
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f6562d).b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        if (r0 == null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r0 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("delete from __er");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f6562d);
            } catch (Throwable unused2) {
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f6562d).b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0051, code lost:
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        SQLiteDatabase sQLiteDatabase;
        if (!TextUtils.isEmpty(this.k)) {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + this.k + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + this.k + "\"");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        h.a(f6562d);
                    } finally {
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        g.a(f6562d).b();
                    }
                } catch (Throwable unused3) {
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabase = null;
            } catch (Throwable unused5) {
                sQLiteDatabase = null;
            }
        }
        this.k = null;
        this.k = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x007a, code lost:
        if (r0 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0066, code lost:
        if (r0 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z, String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __er where __i=\"" + str + "\"");
                    sQLiteDatabase.execSQL("delete from __et where __i=\"" + str + "\"");
                    this.j.clear();
                    sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f6562d);
            } catch (Throwable unused2) {
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f6562d).b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r0 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (r0 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = g.a(f6562d).a();
                sQLiteDatabase.beginTransaction();
                if (!TextUtils.isEmpty(str)) {
                    sQLiteDatabase.execSQL("delete from __is where __ii=\"" + str + "\"");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                h.a(f6562d);
            } catch (Throwable unused2) {
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
            g.a(f6562d).b();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f6563e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f6562d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f6562d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f6562d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (Character.isDigit(charAt)) {
                            if (Integer.parseInt(Character.toString(charAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                            }
                        } else {
                            sb.append(charAt);
                        }
                    }
                    f6563e = sb.toString();
                }
                if (TextUtils.isEmpty(f6563e)) {
                    return;
                }
                f6563e += new StringBuilder(f6563e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f6562d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f6562d, h, c(f));
                } else if (!f.equals(d(multiProcessSP2))) {
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f6563e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f6563e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f6563e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f6563e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }
}
