package b.a;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Application f3130a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f3131b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Application application) {
        this.f3131b = dVar;
        this.f3130a = application;
    }

    @Override // b.a.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.f3130a.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // b.a.a, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        b.a.f.a aVar;
        aVar = this.f3131b.f3122b;
        aVar.a(activity);
    }
}
