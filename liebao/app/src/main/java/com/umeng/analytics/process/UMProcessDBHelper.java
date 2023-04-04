package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    private int getDataSource() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class InsertEventCallback implements FileLockCallback {
        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f6661c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f6661c, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f6662d, ""), (JSONArray) obj);
            return true;
        }
    }

    private UMProcessDBHelper() {
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject readMainEvents(long j, List<Integer> list) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        Cursor cursor2 = null;
        cursor2 = null;
        cursor2 = null;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor2 = sQLiteDatabase.query(a.InterfaceC0165a.f6664a, null, null, null, null, null, null);
                    if (cursor2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        String str = "";
                        while (cursor2.moveToNext()) {
                            int i = cursor2.getInt(cursor2.getColumnIndex("id"));
                            int i2 = cursor2.getInt(cursor2.getColumnIndex("__t"));
                            String string = cursor2.getString(cursor2.getColumnIndex("__i"));
                            String string2 = cursor2.getString(cursor2.getColumnIndex("__s"));
                            String string3 = cursor2.getString(cursor2.getColumnIndex(a.InterfaceC0165a.f));
                            String string4 = cursor2.getString(cursor2.getColumnIndex("__av"));
                            if (!TextUtils.isEmpty(string)) {
                                if (TextUtils.isEmpty(str)) {
                                    str = string4;
                                }
                                if (!TextUtils.isEmpty(string2) && i2 == 2049) {
                                    JSONObject jSONObject3 = new JSONObject(com.umeng.common.a.a().b(string2));
                                    String optString = jSONObject3.optString("pn");
                                    if (TextUtils.isEmpty(optString) || "unknown".equals(optString)) {
                                        jSONObject3.put("pn", this.mContext.getPackageName() + ":" + string3);
                                    }
                                    if (jSONObject2.has(string)) {
                                        jSONArray = jSONObject2.optJSONArray(string);
                                    } else {
                                        jSONArray = new JSONArray();
                                    }
                                    if (q.a(jSONObject3) + q.a(jSONArray) <= j && str.equalsIgnoreCase(string4)) {
                                        list.add(Integer.valueOf(i));
                                        jSONArray.put(jSONObject3);
                                        jSONObject2.put(string, jSONArray);
                                    }
                                }
                            }
                        }
                        if (jSONObject2.length() > 0) {
                            JSONArray jSONArray2 = new JSONArray();
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                JSONObject jSONObject4 = new JSONObject();
                                String next = keys.next();
                                jSONObject4.put(next, new JSONArray(jSONObject2.optString(next)));
                                if (jSONObject4.length() > 0) {
                                    jSONArray2.put(jSONObject4);
                                }
                            }
                            if (jSONArray2.length() > 0) {
                                jSONObject.put("ekv", jSONArray2);
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Exception unused) {
                    cursor = cursor2;
                    sQLiteDatabase2 = sQLiteDatabase;
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建子进程事件数据异常，清除数据库数据。");
                        sQLiteDatabase2.execSQL("delete from __et_p");
                        sQLiteDatabase2.setTransactionSuccessful();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                        return jSONObject;
                    } catch (Throwable th) {
                        th = th;
                        Cursor cursor3 = cursor;
                        sQLiteDatabase = sQLiteDatabase2;
                        cursor2 = cursor3;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    throw th;
                }
            } catch (Exception unused3) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable unused4) {
        }
        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        com.umeng.analytics.process.c.a(r7.mContext).b(com.umeng.analytics.process.a.h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void deleteMainProcessEventDatasByIds(List<Integer> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            sQLiteDatabase.beginTransaction();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.delete(a.InterfaceC0165a.f6664a, "id=?", new String[]{String.valueOf(it.next())});
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(com.umeng.analytics.process.a.h);
            throw th;
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (list == null || size <= 0) {
                sQLiteDatabase.delete(a.InterfaceC0165a.f6664a, null, null);
            } else {
                for (int i = 0; i < size; i++) {
                    sQLiteDatabase.execSQL("delete from __et_p where rowid=" + list.get(i).f6654a);
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            c.a(this.mContext).b(str);
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        c.a(this.mContext).b(str);
    }

    private boolean insertEvents_(String str, List<a> list) {
        SQLiteDatabase a2;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            a2 = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                a2.beginTransaction();
                for (a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("__i", aVar.f6655b);
                        contentValues.put("__e", aVar.f6656c);
                        contentValues.put("__t", Integer.valueOf(aVar.f6658e));
                        contentValues.put(a.InterfaceC0165a.f, aVar.f);
                        contentValues.put("__av", aVar.g);
                        contentValues.put("__vc", aVar.h);
                        contentValues.put("__s", aVar.f6657d);
                        a2.insert(a.InterfaceC0165a.f6664a, null, contentValues);
                    } catch (Exception unused2) {
                    }
                }
                a2.setTransactionSuccessful();
                if (a2 != null) {
                    try {
                        a2.endTransaction();
                    } catch (Throwable unused3) {
                    }
                }
                c.a(this.mContext).b(str);
                return true;
            } catch (Exception unused4) {
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = a2;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused6) {
                }
            }
            c.a(this.mContext).b(str);
            throw th;
        }
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.f6656c = jSONObject.optString("id");
                aVar.g = UMUtils.getAppVersionName(this.mContext);
                aVar.h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f6655b = jSONObject.optString("__i");
                aVar.f6658e = jSONObject.optInt("__t");
                aVar.f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f6657d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(a.InterfaceC0165a.f6664a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e2) {
                                        e = e2;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                jSONObject = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                    throw th;
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                            throw th;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = null;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
            jSONObject = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0093, code lost:
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ac, code lost:
        if (r2 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ae, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4 A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #4 {Exception -> 0x00c7, blocks: (B:34:0x00bf, B:36:0x00c4), top: B:44:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<a> readEventByProcess(String str) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Exception e2;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                sQLiteDatabase = c.a(this.mContext).a(str);
                try {
                    sQLiteDatabase.beginTransaction();
                    cursor = sQLiteDatabase.query(a.InterfaceC0165a.f6664a, null, null, null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                try {
                                    a aVar = new a();
                                    aVar.f6654a = cursor.getInt(0);
                                    aVar.f6655b = cursor.getString(cursor.getColumnIndex("__i"));
                                    aVar.f6656c = cursor.getString(cursor.getColumnIndex("__e"));
                                    aVar.f6657d = cursor.getString(cursor.getColumnIndex("__s"));
                                    aVar.f6658e = cursor.getInt(cursor.getColumnIndex("__t"));
                                    aVar.f = cursor.getString(cursor.getColumnIndex(a.InterfaceC0165a.f));
                                    aVar.g = cursor.getString(cursor.getColumnIndex("__av"));
                                    aVar.h = cursor.getString(cursor.getColumnIndex("__vc"));
                                    arrayList.add(aVar);
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        try {
                                            cursor2.close();
                                        } catch (Exception unused) {
                                            c.a(this.mContext).b(str);
                                            throw th;
                                        }
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                    c.a(this.mContext).b(str);
                                    throw th;
                                }
                            } catch (Exception e3) {
                                e2 = e3;
                                e2.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e4) {
                    cursor = null;
                    e2 = e4;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    c.a(this.mContext).b(str);
                    throw th;
                }
            } catch (Exception e5) {
                cursor = null;
                e2 = e5;
                sQLiteDatabase = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
        } catch (Exception unused2) {
        }
        c.a(this.mContext).b(str);
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        int f6654a;

        /* renamed from: b  reason: collision with root package name */
        String f6655b;

        /* renamed from: c  reason: collision with root package name */
        String f6656c;

        /* renamed from: d  reason: collision with root package name */
        String f6657d;

        /* renamed from: e  reason: collision with root package name */
        int f6658e;
        String f;
        String g;
        String h;

        private a() {
        }
    }

    /* loaded from: classes2.dex */
    private class ProcessToMainCallback implements FileLockCallback {
        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(com.umeng.analytics.process.a.f6661c)) {
                str = str.replaceFirst(com.umeng.analytics.process.a.f6661c, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f6662d, ""));
            return true;
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }
}
