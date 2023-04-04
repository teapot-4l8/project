package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.y;

/* compiled from: ViewModelProviders.java */
/* loaded from: classes.dex */
public class z {
    private static Application a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static y a(androidx.fragment.app.e eVar) {
        return a(eVar, null);
    }

    public static y a(androidx.fragment.app.e eVar, y.b bVar) {
        Application a2 = a((Activity) eVar);
        if (bVar == null) {
            bVar = y.a.a(a2);
        }
        return new y(eVar.getViewModelStore(), bVar);
    }
}
