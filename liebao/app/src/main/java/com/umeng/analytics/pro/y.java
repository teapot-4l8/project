package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SessionIdManager.java */
/* loaded from: classes2.dex */
public class y {

    /* renamed from: c  reason: collision with root package name */
    private static volatile y f6638c;

    /* renamed from: a  reason: collision with root package name */
    private w f6639a = new x();

    /* renamed from: b  reason: collision with root package name */
    private String f6640b;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f6641d;

    /* renamed from: e  reason: collision with root package name */
    private String f6642e;

    /* compiled from: SessionIdManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, long j, long j2, long j3);

        void a(String str, String str2, long j, long j2, long j3);
    }

    private y() {
    }

    public static y a() {
        if (f6638c == null) {
            synchronized (y.class) {
                if (f6638c == null) {
                    f6638c = new y();
                }
            }
        }
        return f6638c;
    }

    public void a(long j) {
        this.f6639a.a(j);
    }

    public long b() {
        return this.f6639a.a();
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (y.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(u.f6629d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f6640b = d(appContext);
        if (e(appContext)) {
            try {
                this.f6640b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f6640b;
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f6640b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f6640b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f6640b)) {
            try {
                this.f6640b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f6640b;
    }

    public String a(Context context, long j) {
        if (TextUtils.isEmpty(this.f6642e)) {
            String str = "SUB" + j;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f6642e = sb.toString();
        }
        return this.f6642e;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f6640b)) {
            this.f6640b = d(context);
        }
        return TextUtils.isEmpty(this.f6640b) || j(context) || g(context);
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(u.f6629d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h = h(context);
        long i = i(context);
        String str = this.f6640b;
        long a2 = u.a(context);
        long j = a2 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a2);
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.E)) {
            if (UMWorkDispatch.eventHasExist()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
                UMWorkDispatch.removeEvent();
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
            }
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        }
        a(i, h, j, str, false);
        this.f6640b = this.f6639a.a(context);
        a(i, h, j, str, true);
        this.f6639a.a(context, this.f6640b);
        return this.f6640b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f6640b) && i.a(context).a(this.f6640b) > 0;
    }

    private long a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    private long h(Context context) {
        return a(context, u.f);
    }

    private long i(Context context) {
        return a(context, u.f6626a);
    }

    private void a(long j, long j2, long j3, String str, boolean z) {
        List<a> list = this.f6641d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.f6640b, j, j2, j3);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f6640b, j, j2, j3);
                }
            }
        }
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(u.f6630e, 0L);
            long j2 = sharedPreferences.getLong(u.f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.E) && j > 0 && j2 == 0) {
                long a2 = u.a(appContext);
                if (a2 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j2 = j + (a2 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.f6639a.a(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f6641d == null) {
            this.f6641d = new ArrayList();
        }
        if (this.f6641d.contains(aVar)) {
            return;
        }
        this.f6641d.add(aVar);
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f6641d) == null || list.size() == 0) {
            return;
        }
        this.f6641d.remove(aVar);
    }
}
