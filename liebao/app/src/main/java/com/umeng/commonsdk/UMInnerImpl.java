package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.d;
import com.umeng.commonsdk.internal.utils.b;
import com.umeng.commonsdk.internal.utils.j;

/* loaded from: classes2.dex */
public class UMInnerImpl {
    private static boolean isInternal = false;

    private static synchronized void sendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                String packageName = context.getPackageName();
                                if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                    return;
                                }
                                d.b(context);
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        }
                    }).start();
                    isInternal = true;
                } finally {
                }
            }
        }
    }

    public static synchronized void initAndSendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                        return;
                                    }
                                    if (!b.a(context).a()) {
                                        b.a(context).b();
                                    }
                                    j.b(context);
                                } catch (Throwable th) {
                                    UMCrashManager.reportCrash(context, th);
                                }
                            }
                        }).start();
                        isInternal = true;
                        sendInternal(context);
                    }
                } finally {
                }
            }
        }
    }
}
