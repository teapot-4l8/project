package leavesc.hello.monitor.holder;

import android.content.Context;

/* loaded from: classes2.dex */
public class ContextHolder {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context2) {
        context = context2;
    }
}
