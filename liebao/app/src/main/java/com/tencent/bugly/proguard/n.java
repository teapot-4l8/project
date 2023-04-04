package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final long f6211a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    private static n f6212b;

    /* renamed from: c  reason: collision with root package name */
    private Context f6213c;
    private SharedPreferences f;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, Map<String, m>> f6215e = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f6214d = com.tencent.bugly.crashreport.common.info.a.b().f6008d;

    private n(Context context) {
        this.f6213c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (f6212b == null) {
                f6212b = new n(context);
            }
            nVar = f6212b;
        }
        return nVar;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = f6212b;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean b(int i) {
        try {
            List<m> c2 = c(i);
            if (c2 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (m mVar : c2) {
                if (mVar.f6207b != null && mVar.f6207b.equalsIgnoreCase(this.f6214d) && mVar.f6209d > 0) {
                    arrayList.add(mVar);
                }
                if (mVar.f6208c + 86400000 < currentTimeMillis) {
                    arrayList2.add(mVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((m) arrayList.get(arrayList.size() - 1)).f6208c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                c2.clear();
                a(i, (int) c2);
                return false;
            }
            c2.removeAll(arrayList2);
            a(i, (int) c2);
            return false;
        } catch (Exception unused) {
            x.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final void a(int i, final int i2) {
        w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                m mVar;
                try {
                    if (TextUtils.isEmpty(n.this.f6214d)) {
                        return;
                    }
                    List<m> c2 = n.this.c(r2);
                    if (c2 == null) {
                        c2 = new ArrayList();
                    }
                    if (n.this.f6215e.get(Integer.valueOf(r2)) == null) {
                        n.this.f6215e.put(Integer.valueOf(r2), new HashMap());
                    }
                    if (((Map) n.this.f6215e.get(Integer.valueOf(r2))).get(n.this.f6214d) != null) {
                        mVar = (m) ((Map) n.this.f6215e.get(Integer.valueOf(r2))).get(n.this.f6214d);
                        mVar.f6209d = i2;
                    } else {
                        mVar = new m();
                        mVar.f6206a = r2;
                        mVar.g = n.f6211a;
                        mVar.f6207b = n.this.f6214d;
                        mVar.f = com.tencent.bugly.crashreport.common.info.a.b().k;
                        mVar.f6210e = com.tencent.bugly.crashreport.common.info.a.b().f;
                        mVar.f6208c = System.currentTimeMillis();
                        mVar.f6209d = i2;
                        ((Map) n.this.f6215e.get(Integer.valueOf(r2))).put(n.this.f6214d, mVar);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (m mVar2 : c2) {
                        if (mVar2.g == mVar.g && mVar2.f6207b != null && mVar2.f6207b.equalsIgnoreCase(mVar.f6207b)) {
                            z = true;
                            mVar2.f6209d = mVar.f6209d;
                        }
                        if ((mVar2.f6210e != null && !mVar2.f6210e.equalsIgnoreCase(mVar.f6210e)) || ((mVar2.f != null && !mVar2.f.equalsIgnoreCase(mVar.f)) || mVar2.f6209d <= 0)) {
                            arrayList.add(mVar2);
                        }
                    }
                    c2.removeAll(arrayList);
                    if (!z) {
                        c2.add(mVar);
                    }
                    n.this.a(r2, (int) c2);
                } catch (Exception unused) {
                    x.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends List<?>> T c(int i) {
        ObjectInputStream objectInputStream;
        try {
            File dir = this.f6213c.getDir("crashrecord", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            File file = new File(dir, sb.toString());
            ObjectInputStream exists = file.exists();
            try {
                if (exists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                } catch (IOException unused) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused2) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    exists = 0;
                    if (exists != 0) {
                        exists.close();
                    }
                    throw th;
                }
                try {
                    T t = (T) objectInputStream.readObject();
                    objectInputStream.close();
                    return t;
                } catch (IOException unused3) {
                    x.a("open record file error", new Object[0]);
                } catch (ClassNotFoundException unused4) {
                    x.a("get object error", new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            x.e("readCrashRecord error", new Object[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f A[Catch: all -> 0x0053, Exception -> 0x0055, TRY_ENTER, TryCatch #4 {Exception -> 0x0055, blocks: (B:7:0x0006, B:11:0x002d, B:21:0x0046, B:27:0x004f, B:28:0x0052), top: B:36:0x0006, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized <T extends List<?>> void a(int i, T t) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        IOException e2;
        if (t == null) {
            return;
        }
        try {
            File dir = this.f6213c.getDir("crashrecord", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(dir, sb.toString())));
            } catch (IOException e3) {
                objectOutputStream = null;
                e2 = e3;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                if (objectOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused) {
            x.e("writeCrashRecord error", new Object[0]);
        }
        try {
            try {
                objectOutputStream.writeObject(t);
                objectOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e4) {
            e2 = e4;
            e2.printStackTrace();
            x.a("open record file error", new Object[0]);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
    }

    public final synchronized boolean a(final int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f;
            z = sharedPreferences.getBoolean(i + "_" + this.f6214d, true);
            w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean b2 = n.this.b(i);
                    SharedPreferences.Editor edit = n.this.f.edit();
                    edit.putBoolean(i + "_" + n.this.f6214d, !b2).commit();
                }
            });
        } catch (Exception unused) {
            x.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
