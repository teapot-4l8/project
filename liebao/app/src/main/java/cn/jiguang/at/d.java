package cn.jiguang.at;

import android.content.Context;

/* loaded from: classes.dex */
public final class d {
    public static Object a(Context context, String str, Object obj) {
        try {
            return cn.jiguang.h.a.a(context, str, obj);
        } catch (Throwable th) {
            cn.jiguang.an.d.g("JCommonPresenter", "jcommon call failed:" + th.getMessage());
            return null;
        }
    }
}
