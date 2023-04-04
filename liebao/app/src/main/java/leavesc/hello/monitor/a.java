package leavesc.hello.monitor;

import android.content.Context;
import android.content.Intent;
import leavesc.hello.monitor.holder.ContextHolder;
import leavesc.hello.monitor.ui.MonitorActivity;

/* compiled from: Monitor.java */
/* loaded from: classes2.dex */
public class a {
    public static Intent a(Context context) {
        Intent intent = new Intent(context, MonitorActivity.class);
        intent.setFlags(268435456);
        return intent;
    }

    public static void a(boolean z) {
        leavesc.hello.monitor.holder.a.a(ContextHolder.getContext()).a(z);
    }
}
