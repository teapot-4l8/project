package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static p f6221a = null;

    /* renamed from: b  reason: collision with root package name */
    private static q f6222b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6223c = false;

    private p(Context context, List<com.tencent.bugly.a> list) {
        f6222b = new q(context, list);
    }

    public static synchronized p a(Context context, List<com.tencent.bugly.a> list) {
        p pVar;
        synchronized (p.class) {
            if (f6221a == null) {
                f6221a = new p(context, list);
            }
            pVar = f6221a;
        }
        return pVar;
    }

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            pVar = f6221a;
        }
        return pVar;
    }

    public final long a(String str, ContentValues contentValues, o oVar, boolean z) {
        return a(str, contentValues, (o) null);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, o oVar, boolean z) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    public final int a(String str, String str2, String[] strArr, o oVar, boolean z) {
        return a(str, str2, (String[]) null, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long a(String str, ContentValues contentValues, o oVar) {
        long j;
        j = 0;
        SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
        if (writableDatabase != null && contentValues != null) {
            long replace = writableDatabase.replace(str, com.umeng.analytics.pro.ao.f6395d, contentValues);
            if (replace >= 0) {
                x.c("[Database] insert %s success.", str);
            } else {
                x.d("[Database] replace %s error.", str);
            }
            j = replace;
        }
        if (oVar != null) {
            Long.valueOf(j);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, o oVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, o oVar) {
        int delete;
        SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
        delete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        if (oVar != null) {
            Integer.valueOf(delete);
        }
        return delete;
    }

    public final boolean a(int i, String str, byte[] bArr, o oVar, boolean z) {
        if (!z) {
            a aVar = new a(4, null);
            aVar.a(i, str, bArr);
            w.a().a(aVar);
            return true;
        }
        return a(i, str, bArr, (o) null);
    }

    public final Map<String, byte[]> a(int i, o oVar, boolean z) {
        return a(i, (o) null);
    }

    public final boolean a(int i, String str, o oVar, boolean z) {
        return a(555, str, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r8 != null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(int i, String str, byte[] bArr, o oVar) {
        boolean z = false;
        try {
            r rVar = new r();
            rVar.f6234a = i;
            rVar.f = str;
            rVar.f6238e = System.currentTimeMillis();
            rVar.g = bArr;
            z = b(rVar);
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } finally {
                if (oVar != null) {
                    Boolean.valueOf(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, byte[]> a(int i, o oVar) {
        HashMap hashMap = null;
        try {
            List<r> c2 = c(i);
            if (c2 != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (r rVar : c2) {
                        byte[] bArr = rVar.g;
                        if (bArr != null) {
                            hashMap2.put(rVar.f, bArr);
                        }
                    }
                    return hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    if (x.a(th)) {
                        return hashMap;
                    }
                    th.printStackTrace();
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(r rVar) {
        ContentValues c2;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
            if (writableDatabase == null || (c2 = c(rVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", com.umeng.analytics.pro.ao.f6395d, c2);
            if (replace >= 0) {
                x.c("[Database] insert %s success.", "t_lr");
                rVar.f6234a = replace;
                return true;
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    private synchronized boolean b(r rVar) {
        ContentValues d2;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
            if (writableDatabase == null || (d2 = d(rVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", com.umeng.analytics.pro.ao.f6395d, d2);
            if (replace >= 0) {
                x.c("[Database] insert %s success.", "t_pf");
                rVar.f6234a = replace;
                return true;
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x0031, B:31:0x009b, B:40:0x00af, B:36:0x00a4, B:38:0x00aa), top: B:54:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af A[Catch: all -> 0x00bc, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x0031, B:31:0x009b, B:40:0x00af, B:36:0x00a4, B:38:0x00aa), top: B:54:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List<r> a(int i) {
        String str;
        Cursor cursor;
        SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } else {
                str = null;
            }
            Cursor query = writableDatabase.query("t_lr", null, str, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (query.moveToNext()) {
                    r a2 = a(query);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        long j = query.getLong(query.getColumnIndex(com.umeng.analytics.pro.ao.f6395d));
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    x.d("[Database] deleted %s illegal data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2.substring(4), null)));
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                cursor = query;
                th = th2;
                if (!x.a(th)) {
                }
                if (cursor != null) {
                }
                return null;
            }
        }
        return null;
    }

    public final synchronized void a(List<r> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (r rVar : list) {
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(rVar.f6234a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                }
            }
        }
    }

    public final synchronized void b(int i) {
        String str;
        SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                str = "_tp = " + i;
            } else {
                str = null;
            }
            x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    private static ContentValues c(r rVar) {
        if (rVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (rVar.f6234a > 0) {
                contentValues.put(com.umeng.analytics.pro.ao.f6395d, Long.valueOf(rVar.f6234a));
            }
            contentValues.put(com.umeng.analytics.pro.ao.f6396e, Integer.valueOf(rVar.f6235b));
            contentValues.put("_pc", rVar.f6236c);
            contentValues.put("_th", rVar.f6237d);
            contentValues.put("_tm", Long.valueOf(rVar.f6238e));
            if (rVar.g != null) {
                contentValues.put("_dt", rVar.g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static r a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f6234a = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6395d));
            rVar.f6235b = cursor.getInt(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6396e));
            rVar.f6236c = cursor.getString(cursor.getColumnIndex("_pc"));
            rVar.f6237d = cursor.getString(cursor.getColumnIndex("_th"));
            rVar.f6238e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private synchronized List<r> c(int i) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i;
                cursor = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        r b2 = b(cursor);
                        if (b2 != null) {
                            arrayList.add(b2);
                        } else {
                            String string = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6396e));
                            sb.append(" or _tp");
                            sb.append(" = ");
                            sb.append(string);
                        }
                    }
                    if (sb.length() > 0) {
                        sb.append(" and _id");
                        sb.append(" = ");
                        sb.append(i);
                        x.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i, String str, o oVar) {
        boolean z;
        String str2;
        z = false;
        SQLiteDatabase writableDatabase = f6222b.getWritableDatabase();
        if (writableDatabase != null) {
            if (z.a(str)) {
                str2 = "_id = " + i;
            } else {
                str2 = "_id = " + i + " and _tp = \"" + str + "\"";
            }
            int delete = writableDatabase.delete("t_pf", str2, null);
            x.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
            if (delete > 0) {
                z = true;
            }
        }
        if (oVar != null) {
            Boolean.valueOf(z);
        }
        return z;
    }

    private static ContentValues d(r rVar) {
        if (rVar != null && !z.a(rVar.f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (rVar.f6234a > 0) {
                    contentValues.put(com.umeng.analytics.pro.ao.f6395d, Long.valueOf(rVar.f6234a));
                }
                contentValues.put(com.umeng.analytics.pro.ao.f6396e, rVar.f);
                contentValues.put("_tm", Long.valueOf(rVar.f6238e));
                if (rVar.g != null) {
                    contentValues.put("_dt", rVar.g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static r b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f6234a = cursor.getLong(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6395d));
            rVar.f6238e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f = cursor.getString(cursor.getColumnIndex(com.umeng.analytics.pro.ao.f6396e));
            rVar.g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private int f6224a;

        /* renamed from: b  reason: collision with root package name */
        private o f6225b;

        /* renamed from: c  reason: collision with root package name */
        private String f6226c;

        /* renamed from: d  reason: collision with root package name */
        private ContentValues f6227d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6228e;
        private String[] f;
        private String g;
        private String[] h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String[] n;
        private int o;
        private String p;

        /* renamed from: q  reason: collision with root package name */
        private byte[] f6229q;

        public a(int i, o oVar) {
            this.f6224a = i;
            this.f6225b = oVar;
        }

        public final void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f6228e = z;
            this.f6226c = str;
            this.f = strArr;
            this.g = str2;
            this.h = strArr2;
            this.i = str3;
            this.j = str4;
            this.k = str5;
            this.l = str6;
        }

        public final void a(int i, String str, byte[] bArr) {
            this.o = i;
            this.p = str;
            this.f6229q = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f6224a) {
                case 1:
                    p.this.a(this.f6226c, this.f6227d, this.f6225b);
                    return;
                case 2:
                    p.this.a(this.f6226c, this.m, this.n, this.f6225b);
                    return;
                case 3:
                    Cursor a2 = p.this.a(this.f6228e, this.f6226c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.f6225b);
                    if (a2 != null) {
                        a2.close();
                        return;
                    }
                    return;
                case 4:
                    p.this.a(this.o, this.p, this.f6229q, this.f6225b);
                    return;
                case 5:
                    p.this.a(this.o, this.f6225b);
                    return;
                case 6:
                    p.this.a(this.o, this.p, this.f6225b);
                    return;
                default:
                    return;
            }
        }
    }
}
