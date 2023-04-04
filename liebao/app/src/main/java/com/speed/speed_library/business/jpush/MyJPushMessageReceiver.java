package com.speed.speed_library.business.jpush;

import android.content.Context;
import android.content.Intent;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import com.speed.speed_library.module.main.MainActivity;

/* loaded from: classes2.dex */
public class MyJPushMessageReceiver extends JPushMessageReceiver {
    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onTagOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onCheckTagOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onCheckTagOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onAliasOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onMobileNumberOperatorResult(Context context, JPushMessage jPushMessage) {
        super.onMobileNumberOperatorResult(context, jPushMessage);
    }

    @Override // cn.jpush.android.service.JPushMessageReceiver
    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageOpened(context, notificationMessage);
        try {
            Intent intent = new Intent(context, MainActivity.class);
            intent.setFlags(335544320);
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
