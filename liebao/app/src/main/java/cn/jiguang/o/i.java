package cn.jiguang.o;

import android.content.Context;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class i {
    public static String a(int i) {
        cn.jiguang.at.b.a();
        return cn.jiguang.at.b.b(i);
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, "JCOMMON", 39, null, null, obj);
    }

    public static void a(Context context, Object obj, Object obj2) {
        JCoreManager.onEvent(context, "JCOMMON", 15, null, null, obj, obj2);
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            cn.jiguang.ad.a.a("JCommonPresenter", "jsonContent:" + jSONObject2);
            int optInt = jSONObject2.optInt("state", -1);
            if (optInt == -1) {
                cn.jiguang.ad.a.d("JCommonPresenter", "unknow state");
            } else if (optInt == 0) {
                cn.jiguang.ad.a.a("JCommonPresenter", "turn on share process");
                cn.jiguang.ap.b.a(context, optInt);
            } else if (optInt != 1) {
                cn.jiguang.ad.a.d("JCommonPresenter", "#exception - unsupport state:" + optInt);
            } else {
                cn.jiguang.ad.a.a("JCommonPresenter", "turn off share process");
                cn.jiguang.ap.b.a(context, optInt);
                cn.jiguang.e.a.a().a(context, cn.jiguang.d.a.d(context));
                cn.jiguang.e.a.a(context, context.getPackageName());
            }
        } catch (Exception e2) {
            cn.jiguang.ad.a.d("JCommonPresenter", "configReportRunningApp exception:" + e2.getMessage());
        }
    }

    public static boolean a(Context context) {
        if (!JConstants.isAndroidQ(context, true, "canGetLbsInBackGround") || cn.jiguang.ap.b.f3801a || cn.jiguang.f.a.c(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return true;
        }
        cn.jiguang.ad.a.e("JCommonPresenter", "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION");
        return false;
    }
}
