package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.local.ActionHelper;

/* loaded from: classes.dex */
public class JNotifyActivity extends Activity {
    private static final String TAG = "JNotifyActivity";

    private void handleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            ActionHelper.getInstance().handleNotificationIntent(getApplicationContext(), intent);
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            handleIntent(getIntent());
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            handleIntent(intent);
        } catch (Throwable unused) {
        }
    }
}
