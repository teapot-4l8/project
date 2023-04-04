package cn.jiguang.ap;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.an.d;
import cn.jiguang.android.BuildConfig;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.at.f;
import cn.jiguang.at.h;
import cn.jiguang.f.i;
import cn.jiguang.internal.JConstants;
import com.umeng.analytics.pro.ak;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3800a;

    private static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f3800a) {
                return;
            }
            if (context == null) {
                return;
            }
            d.b("JCoreActionImpl", "init jcore impl ,version:" + cn.jiguang.a.a.f3640b + ",local version:" + JConstants.SDK_VERSION_INT);
            f3800a = true;
            d.b("JCoreActionImpl", "hb:" + JConstants.DEFAULT_HEARTBEAT_INTERVAL + ",google:false,internal:" + JConstants.INTERNAL_USE);
            int i = !TextUtils.isEmpty(JConstants.SDK_NAME) ? 2 : 0;
            int i2 = cn.jiguang.a.a.f3641c != JConstants.SDK_VERSION_INT ? 2 : 1;
            d.b("JCoreActionImpl", "custom:" + i + ",dynamic:" + i2);
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 72, true, null, null, "core", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(cn.jiguang.a.a.f3641c));
            String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.v());
            if (TextUtils.isEmpty(str) || str.startsWith("1.")) {
                b.d(context);
            }
            if (TextUtils.isEmpty(str) || !BuildConfig.VERSION_NAME.equals(str)) {
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.v().a((cn.jiguang.g.a<String>) BuildConfig.VERSION_NAME));
            }
            String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.B());
            String a2 = cn.jiguang.am.a.a(context);
            d.b("InitHelper", "appkey=" + a2 + " last=" + str2);
            if (i.a(str2) || "null".equals(str2) || !str2.equalsIgnoreCase(a2)) {
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.B().a((cn.jiguang.g.a<String>) a2));
                d.c("InitHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
                b.a(context);
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        String string;
        a(context);
        if (TextUtils.isEmpty(str)) {
            d.g("JCoreActionImpl", "handleAction Failed,action is empty");
            return;
        }
        d.b("JCoreActionImpl", "handleAction action:" + str);
        String string2 = bundle != null ? bundle.getString(ak.u) : "";
        if (str.equals("a1")) {
            if (bundle != null) {
                try {
                    string = bundle.getString("report_data");
                } catch (Throwable th) {
                    d.f("JCoreActionImpl", "report failed:" + th.getMessage());
                    return;
                }
            } else {
                string = null;
            }
            b.a(context, (Object) string);
        } else if (str.startsWith("tcp_")) {
            h.a().a(context, str, bundle);
        } else if (str.equals("a2")) {
            f.a().a(context, true);
        } else if (str.equals("a3")) {
            cn.jiguang.at.b.a();
            cn.jiguang.at.b.a(context, string2, bundle);
        } else if (str.equals("a4")) {
            b.a(context, bundle);
        }
    }
}
