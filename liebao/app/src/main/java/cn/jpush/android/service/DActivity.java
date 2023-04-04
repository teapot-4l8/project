package cn.jpush.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.ag.a;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class DActivity extends Activity {
    private static final String TAG = "DActivity";

    private void handleStart() {
        try {
            if (JConstants.AT_I) {
                JCoreManager.init(getApplicationContext());
            }
            a.a(getApplicationContext(), 8);
        } catch (Throwable th) {
            cn.jiguang.ad.a.a(TAG, "handle start error#" + th);
        }
        try {
            finish();
        } catch (Throwable th2) {
            cn.jiguang.ad.a.a(TAG, "finish error#" + th2);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cn.jiguang.ad.a.a(TAG, "DActivity oncreate");
        handleStart();
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        cn.jiguang.ad.a.a(TAG, "DActivity onNewIntent");
        handleStart();
    }
}
