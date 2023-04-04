package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.just.agentweb.DefaultWebClient;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.au;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.umeng.analytics.pro.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f5981a;

    /* renamed from: b  reason: collision with root package name */
    private long f5982b;

    /* renamed from: c  reason: collision with root package name */
    private int f5983c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5984d;

    static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean != null) {
            if (!z && userInfoBean.f5976b != 1 && (a2 = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.f5981a).f6008d)) != null && a2.size() >= 20) {
                x.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
                return;
            }
            long a3 = p.a().a("t_ui", a(userInfoBean), (o) null, true);
            if (a3 >= 0) {
                x.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
                userInfoBean.f5975a = a3;
            }
        }
    }

    public a(Context context, boolean z) {
        this.f5984d = true;
        this.f5981a = context;
        this.f5984d = z;
    }

    public final void a(int i, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null && !a2.c().h && i != 1 && i != 3) {
            x.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.f5983c++;
        }
        com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(this.f5981a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f5976b = i;
        userInfoBean.f5977c = a3.f6008d;
        userInfoBean.f5978d = a3.g();
        userInfoBean.f5979e = System.currentTimeMillis();
        userInfoBean.f = -1L;
        userInfoBean.n = a3.k;
        userInfoBean.o = i == 1 ? 1 : 0;
        userInfoBean.l = a3.a();
        userInfoBean.m = a3.f6010q;
        userInfoBean.g = a3.r;
        userInfoBean.h = a3.s;
        userInfoBean.i = a3.t;
        userInfoBean.k = a3.u;
        userInfoBean.r = a3.B();
        userInfoBean.s = a3.G();
        userInfoBean.p = a3.H();
        userInfoBean.f5980q = a3.I();
        w.a().a(new RunnableC0159a(userInfoBean, z), 0L);
    }

    public final void a() {
        this.f5982b = z.b() + 86400000;
        w.a().a(new b(), (this.f5982b - System.currentTimeMillis()) + 5000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0159a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f5988a;

        /* renamed from: b  reason: collision with root package name */
        private UserInfoBean f5989b;

        public RunnableC0159a(UserInfoBean userInfoBean, boolean z) {
            this.f5989b = userInfoBean;
            this.f5988a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a b2;
            try {
                if (this.f5989b != null) {
                    UserInfoBean userInfoBean = this.f5989b;
                    if (userInfoBean != null && (b2 = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
                        userInfoBean.j = b2.e();
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.f5989b, false);
                }
                if (this.f5988a) {
                    a aVar = a.this;
                    w a2 = w.a();
                    if (a2 != null) {
                        a2.a(new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f2 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:114:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011d A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:114:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0126 A[Catch: all -> 0x018b, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:11:0x000f, B:15:0x0017, B:17:0x001d, B:21:0x0027, B:23:0x003c, B:26:0x0045, B:28:0x004c, B:29:0x004f, B:31:0x0055, B:33:0x0069, B:34:0x0079, B:38:0x0081, B:39:0x008b, B:40:0x0090, B:42:0x0096, B:44:0x00a4, B:46:0x00b1, B:47:0x00b4, B:49:0x00c2, B:51:0x00c6, B:53:0x00cb, B:55:0x00d0, B:58:0x00d7, B:61:0x00ec, B:63:0x00f2, B:65:0x00f7, B:68:0x00ff, B:72:0x0117, B:74:0x011d, B:77:0x0126, B:79:0x012c, B:82:0x0135, B:86:0x013e, B:88:0x0146, B:91:0x014f, B:93:0x0160, B:95:0x0165, B:97:0x016a, B:99:0x016f, B:103:0x017d, B:98:0x016d, B:94:0x0163, B:106:0x0182, B:59:0x00e6), top: B:114:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void c() {
        boolean z;
        au a2;
        if (this.f5984d) {
            u a3 = u.a();
            if (a3 == null) {
                return;
            }
            com.tencent.bugly.crashreport.common.strategy.a a4 = com.tencent.bugly.crashreport.common.strategy.a.a();
            if (a4 == null) {
                return;
            }
            if (!a4.b() || a3.b(DefaultWebClient.DERECT_OPEN_OTHER_PAGE)) {
                String str = com.tencent.bugly.crashreport.common.info.a.a(this.f5981a).f6008d;
                ArrayList arrayList = new ArrayList();
                final List<UserInfoBean> a5 = a(str);
                if (a5 != null) {
                    int size = a5.size() - 20;
                    if (size > 0) {
                        int i = 0;
                        while (i < a5.size() - 1) {
                            int i2 = i + 1;
                            for (int i3 = i2; i3 < a5.size(); i3++) {
                                if (a5.get(i).f5979e > a5.get(i3).f5979e) {
                                    a5.set(i, a5.get(i3));
                                    a5.set(i3, a5.get(i));
                                }
                            }
                            i = i2;
                        }
                        for (int i4 = 0; i4 < size; i4++) {
                            arrayList.add(a5.get(i4));
                        }
                    }
                    Iterator<UserInfoBean> it = a5.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        UserInfoBean next = it.next();
                        if (next.f != -1) {
                            it.remove();
                            if (next.f5979e < z.b()) {
                                arrayList.add(next);
                            }
                        }
                        if (next.f5979e > System.currentTimeMillis() - 600000 && (next.f5976b == 1 || next.f5976b == 4 || next.f5976b == 3)) {
                            i5++;
                        }
                    }
                    if (i5 > 15) {
                        x.d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i5));
                        z = false;
                        if (arrayList.size() > 0) {
                            a(arrayList);
                        }
                        if (z && a5.size() != 0) {
                            x.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(a5.size()));
                            a2 = com.tencent.bugly.proguard.a.a(a5, this.f5983c != 1 ? 1 : 2);
                            if (a2 != null) {
                                x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                                return;
                            }
                            byte[] a6 = com.tencent.bugly.proguard.a.a((k) a2);
                            if (a6 == null) {
                                x.d("[UserInfo] Failed to encode data.", new Object[0]);
                                return;
                            }
                            ap a7 = com.tencent.bugly.proguard.a.a(this.f5981a, a3.f6243a ? 840 : 640, a6);
                            if (a7 == null) {
                                x.d("[UserInfo] Request package is null.", new Object[0]);
                                return;
                            }
                            t tVar = new t() { // from class: com.tencent.bugly.crashreport.biz.a.1
                                @Override // com.tencent.bugly.proguard.t
                                public final void a(boolean z2) {
                                    if (z2) {
                                        x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        for (UserInfoBean userInfoBean : a5) {
                                            userInfoBean.f = currentTimeMillis;
                                            a.a(a.this, userInfoBean, true);
                                        }
                                    }
                                }
                            };
                            StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
                            u.a().a(DefaultWebClient.DERECT_OPEN_OTHER_PAGE, a7, a3.f6243a ? c2.r : c2.t, a3.f6243a ? StrategyBean.f6017b : StrategyBean.f6016a, tVar, this.f5983c == 1);
                            return;
                        }
                        x.c("[UserInfo] There is no user info in local database.", new Object[0]);
                    }
                } else {
                    a5 = new ArrayList<>();
                }
                z = true;
                if (arrayList.size() > 0) {
                }
                if (z) {
                    x.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(a5.size()));
                    a2 = com.tencent.bugly.proguard.a.a(a5, this.f5983c != 1 ? 1 : 2);
                    if (a2 != null) {
                    }
                }
                x.c("[UserInfo] There is no user info in local database.", new Object[0]);
            }
        }
    }

    public final void b() {
        w a2 = w.a();
        if (a2 != null) {
            a2.a(new AnonymousClass2());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final class AnonymousClass2 implements Runnable {
        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.f5982b) {
                w.a().a(new b(), (a.this.f5982b - currentTimeMillis) + 5000);
                return;
            }
            a.this.a(3, false, 0L);
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private long f5992a;

        public c(long j) {
            this.f5992a = 21600000L;
            this.f5992a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            w a2 = w.a();
            if (a2 != null) {
                a2.a(new AnonymousClass2());
            }
            a aVar2 = a.this;
            long j = this.f5992a;
            w.a().a(new c(j), j);
        }
    }

    public final List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = p.a().a("t_ui", null, str2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex(ao.f6395d));
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    x.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", sb2.substring(4), (String[]) null, (o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(list.get(i).f5975a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", str, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f5975a > 0) {
                contentValues.put(ao.f6395d, Long.valueOf(userInfoBean.f5975a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f5979e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put(ao.f6396e, Integer.valueOf(userInfoBean.f5976b));
            contentValues.put("_pc", userInfoBean.f5977c);
            contentValues.put("_dt", z.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex(ao.f6395d));
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f5975a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
