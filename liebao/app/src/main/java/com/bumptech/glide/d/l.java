package com.bumptech.glide.d;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class l implements Handler.Callback {
    private static final a i = new a() { // from class: com.bumptech.glide.d.l.1
        @Override // com.bumptech.glide.d.l.a
        public com.bumptech.glide.j a(com.bumptech.glide.c cVar, h hVar, m mVar, Context context) {
            return new com.bumptech.glide.j(cVar, hVar, mVar, context);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private volatile com.bumptech.glide.j f5131c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f5132d;

    /* renamed from: e  reason: collision with root package name */
    private final a f5133e;

    /* renamed from: a  reason: collision with root package name */
    final Map<FragmentManager, k> f5129a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Map<androidx.fragment.app.j, o> f5130b = new HashMap();
    private final androidx.b.a<View, androidx.fragment.app.d> f = new androidx.b.a<>();
    private final androidx.b.a<View, Fragment> g = new androidx.b.a<>();
    private final Bundle h = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: classes.dex */
    public interface a {
        com.bumptech.glide.j a(com.bumptech.glide.c cVar, h hVar, m mVar, Context context);
    }

    public l(a aVar) {
        this.f5133e = aVar == null ? i : aVar;
        this.f5132d = new Handler(Looper.getMainLooper(), this);
    }

    private com.bumptech.glide.j b(Context context) {
        if (this.f5131c == null) {
            synchronized (this) {
                if (this.f5131c == null) {
                    this.f5131c = this.f5133e.a(com.bumptech.glide.c.a(context.getApplicationContext()), new b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f5131c;
    }

    public com.bumptech.glide.j a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.i.j.b() && !(context instanceof Application)) {
            if (context instanceof androidx.fragment.app.e) {
                return a((androidx.fragment.app.e) context);
            }
            if (context instanceof Activity) {
                return a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return a(((ContextWrapper) context).getBaseContext());
            }
        }
        return b(context);
    }

    public com.bumptech.glide.j a(androidx.fragment.app.e eVar) {
        if (com.bumptech.glide.i.j.c()) {
            return a(eVar.getApplicationContext());
        }
        c(eVar);
        return a(eVar, eVar.j(), (androidx.fragment.app.d) null, d(eVar));
    }

    public com.bumptech.glide.j a(androidx.fragment.app.d dVar) {
        com.bumptech.glide.i.i.a(dVar.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.i.j.c()) {
            return a(dVar.getActivity().getApplicationContext());
        }
        return a(dVar.getActivity(), dVar.getChildFragmentManager(), dVar, dVar.isVisible());
    }

    public com.bumptech.glide.j a(Activity activity) {
        if (com.bumptech.glide.i.j.c()) {
            return a(activity.getApplicationContext());
        }
        c(activity);
        return a(activity, activity.getFragmentManager(), (Fragment) null, d(activity));
    }

    private static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public k b(Activity activity) {
        return a(activity.getFragmentManager(), (Fragment) null, d(activity));
    }

    private k a(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f5129a.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.a(fragment);
            if (z) {
                kVar.a().a();
            }
            this.f5129a.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f5132d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    @Deprecated
    private com.bumptech.glide.j a(Context context, FragmentManager fragmentManager, Fragment fragment, boolean z) {
        k a2 = a(fragmentManager, fragment, z);
        com.bumptech.glide.j b2 = a2.b();
        if (b2 == null) {
            com.bumptech.glide.j a3 = this.f5133e.a(com.bumptech.glide.c.a(context), a2.a(), a2.c(), context);
            a2.a(a3);
            return a3;
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o b(androidx.fragment.app.e eVar) {
        return a(eVar.j(), (androidx.fragment.app.d) null, d(eVar));
    }

    private static boolean d(Activity activity) {
        return !activity.isFinishing();
    }

    private o a(androidx.fragment.app.j jVar, androidx.fragment.app.d dVar, boolean z) {
        o oVar = (o) jVar.a("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f5130b.get(jVar)) == null) {
            oVar = new o();
            oVar.a(dVar);
            if (z) {
                oVar.a().a();
            }
            this.f5130b.put(jVar, oVar);
            jVar.a().a(oVar, "com.bumptech.glide.manager").c();
            this.f5132d.obtainMessage(2, jVar).sendToTarget();
        }
        return oVar;
    }

    private com.bumptech.glide.j a(Context context, androidx.fragment.app.j jVar, androidx.fragment.app.d dVar, boolean z) {
        o a2 = a(jVar, dVar, z);
        com.bumptech.glide.j b2 = a2.b();
        if (b2 == null) {
            com.bumptech.glide.j a3 = this.f5133e.a(com.bumptech.glide.c.a(context), a2.a(), a2.c(), context);
            a2.a(a3);
            return a3;
        }
        return b2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f5129a.remove(obj);
        } else if (i2 == 2) {
            obj = (androidx.fragment.app.j) message.obj;
            remove = this.f5130b.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }
}
