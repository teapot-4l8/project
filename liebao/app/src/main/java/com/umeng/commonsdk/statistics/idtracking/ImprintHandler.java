package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6844a = "ImprintHandler";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6846c = ".imprint";
    private static Context k = null;
    private static FileLockUtil l = null;
    private static final int m = 0;
    private static final int n = 1;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f6848e;
    private a h = new a();
    private com.umeng.commonsdk.statistics.proto.d i = null;

    /* renamed from: b  reason: collision with root package name */
    private static Object f6845b = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f6847d = "pbl0".getBytes();
    private static Map<String, ArrayList<UMImprintChangeCallback>> f = new HashMap();
    private static Object g = new Object();
    private static ImprintHandler j = null;
    private static Map<String, UMImprintPreProcessCallback> o = new HashMap();
    private static Object p = new Object();

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            j.e();
        } else if (i == 1) {
            j.a(file);
        }
        return true;
    }

    private ImprintHandler(Context context) {
        k = context.getApplicationContext();
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (j == null) {
                j = new ImprintHandler(context);
                FileLockUtil fileLockUtil = new FileLockUtil();
                l = fileLockUtil;
                if (fileLockUtil != null) {
                    l.doFileOperateion(new File(k.getFilesDir(), f6846c), j, 0);
                }
            }
            imprintHandler = j;
        }
        return imprintHandler;
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (g) {
            int i = 0;
            if (f.containsKey(str)) {
                ArrayList<UMImprintChangeCallback> arrayList = f.get(str);
                int size = arrayList.size();
                ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                while (i < size) {
                    if (uMImprintChangeCallback == arrayList.get(i)) {
                        ULog.i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i++;
                }
                arrayList.add(uMImprintChangeCallback);
                ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
            } else {
                ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                int size2 = arrayList2.size();
                ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                while (i < size2) {
                    if (uMImprintChangeCallback == arrayList2.get(i)) {
                        ULog.i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i++;
                }
                arrayList2.add(uMImprintChangeCallback);
                ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                f.put(str, arrayList2);
            }
        }
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (g) {
            try {
                if (f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f.get(str);
                    if (uMImprintChangeCallback != null && arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            } else if (uMImprintChangeCallback == arrayList.get(i)) {
                                ULog.i("--->>> removeCallback: remove index " + i);
                                arrayList.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                        ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f.remove(str);
                        }
                    }
                }
            }
        }
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (p) {
            try {
                if (!o.containsKey(str)) {
                    o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            }
        }
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f6848e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
            sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).e());
            sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).h());
        }
        sb.append(dVar.f6931b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (dVar.i().equals(a(dVar))) {
            for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
                byte[] reverseHexString = DataHelper.reverseHexString(eVar.h());
                byte[] a2 = a(eVar);
                for (int i = 0; i < 4; i++) {
                    if (reverseHexString[i] != a2[i]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = f6847d;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                if (this.i == null) {
                    return null;
                }
                if (this.i.b() <= 0) {
                    return null;
                }
                return new bc().a(this.i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(k, th);
            return null;
        }
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        if (c2.containsKey(ak.f)) {
            c2.remove(ak.f);
            this.h.a(ak.f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d a2;
        boolean z;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
            }
        } else if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
            }
        } else {
            boolean z2 = AnalyticsConstants.UM_DEBUG;
            HashMap hashMap = new HashMap();
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.i;
                com.umeng.commonsdk.statistics.proto.d d2 = d(dVar);
                String str = null;
                String i = dVar2 == null ? null : dVar2.i();
                if (dVar2 == null) {
                    a2 = e(d2);
                } else {
                    a2 = a(dVar2, d2, hashMap);
                }
                this.i = a2;
                if (a2 != null) {
                    str = a2.i();
                }
                z = !a(i, str);
            }
            if (this.i != null) {
                boolean z3 = AnalyticsConstants.UM_DEBUG;
                if (z) {
                    this.h.a(this.i);
                    com.umeng.commonsdk.statistics.internal.d dVar3 = this.f6848e;
                    if (dVar3 != null) {
                        dVar3.onImprintChanged(this.h);
                    }
                }
            }
            if (hashMap.size() > 0) {
                synchronized (g) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f.containsKey(key)) {
                            ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f.get(key);
                            if (arrayList != null) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    arrayList.get(i2).onImprintValueChanged(key, value);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f6940a;
                synchronized (p) {
                    if (!TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    c2.put(entry.getKey(), entry.getValue());
                    synchronized (g) {
                        if (!TextUtils.isEmpty(key) && f.containsKey(key) && f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (g) {
                    if (!TextUtils.isEmpty(key2) && f.containsKey(key2) && (arrayList = f.get(key2)) != null) {
                        while (i < arrayList.size()) {
                            arrayList.get(i).onImprintValueChanged(key2, null);
                            i++;
                        }
                    }
                }
                c2.remove(key2);
                this.h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c2.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = c2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (!next.getValue().d()) {
                arrayList3.add(next.getKey());
            } else {
                String key = next.getKey();
                String str = next.getValue().f6940a;
                synchronized (p) {
                    z = !TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (g) {
                    if (!TextUtils.isEmpty(key) && f.containsKey(key) && (arrayList2 = f.get(key)) != null) {
                        for (int i = 0; i < arrayList2.size(); i++) {
                            arrayList2.get(i).onImprintValueChanged(key, str);
                        }
                    }
                }
            }
        }
        for (String str2 : arrayList3) {
            synchronized (g) {
                if (!TextUtils.isEmpty(str2) && f.containsKey(str2) && (arrayList = f.get(str2)) != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList.get(i2).onImprintValueChanged(str2, null);
                    }
                }
            }
            c2.remove(str2);
        }
        return dVar;
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.i;
    }

    public a c() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(k.getFilesDir(), f6846c);
        synchronized (f6845b) {
            if (file.exists()) {
                byte[] bArr = null;
                try {
                    fileInputStream = k.openFileInput(f6846c);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    fileInputStream = null;
                    th = th2;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                try {
                    try {
                        bArr = HelperUtils.readStreamToByteArray(fileInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        HelperUtils.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    HelperUtils.safeClose(fileInputStream);
                    if (bArr != null) {
                    }
                }
                HelperUtils.safeClose(fileInputStream);
                if (bArr != null) {
                    try {
                        com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                        new aw().a(dVar, bArr);
                        this.i = dVar;
                        this.h.a(dVar);
                        this.i = d(this.i);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    private void a(File file) {
        if (this.i == null) {
            return;
        }
        try {
            synchronized (f6845b) {
                byte[] a2 = new bc().a(this.i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(a2);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d() {
        if (this.i == null || l == null) {
            return;
        }
        File file = new File(k.getFilesDir(), f6846c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e2) {
                UMCrashManager.reportCrash(k, e2);
            }
        }
        l.doFileOperateion(file, j, 1);
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f6849a = new HashMap();

        a() {
        }

        public synchronized void a(String str) {
            if (this.f6849a != null && this.f6849a.size() > 0 && !TextUtils.isEmpty(str) && this.f6849a.containsKey(str)) {
                this.f6849a.remove(str);
            }
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
                    for (String str : c2.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = c2.get(str)) != null) {
                            String b2 = eVar.b();
                            if (!TextUtils.isEmpty(b2)) {
                                this.f6849a.put(str, b2);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    Log.i(ImprintHandler.f6844a, "imKey is " + str + ", imValue is " + b2);
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f6849a.size() > 0) {
                String str3 = this.f6849a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }
}
