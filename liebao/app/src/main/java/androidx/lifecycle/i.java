package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LifecycleDispatcher.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f2019a = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        if (f2019a.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    }

    /* compiled from: LifecycleDispatcher.java */
    /* loaded from: classes.dex */
    static class a extends d {
        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        a() {
        }

        @Override // androidx.lifecycle.d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            v.a(activity);
        }
    }
}
