package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.an.d;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.at.a;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d.b(TAG, "onReceive");
        if (!JConstants.AT_I && !JConstants.isCallInit.get()) {
            d.c(TAG, "please call init");
            return;
        }
        a.a(context);
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 10, "a2", null, new Object[0]);
    }
}
