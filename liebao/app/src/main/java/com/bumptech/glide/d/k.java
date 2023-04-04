package com.bumptech.glide.d;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RequestManagerFragment.java */
@Deprecated
/* loaded from: classes.dex */
public class k extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.d.a f5123a;

    /* renamed from: b  reason: collision with root package name */
    private final m f5124b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<k> f5125c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.j f5126d;

    /* renamed from: e  reason: collision with root package name */
    private k f5127e;
    private Fragment f;

    public k() {
        this(new com.bumptech.glide.d.a());
    }

    k(com.bumptech.glide.d.a aVar) {
        this.f5124b = new a();
        this.f5125c = new HashSet();
        this.f5123a = aVar;
    }

    public void a(com.bumptech.glide.j jVar) {
        this.f5126d = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.d.a a() {
        return this.f5123a;
    }

    public com.bumptech.glide.j b() {
        return this.f5126d;
    }

    public m c() {
        return this.f5124b;
    }

    private void a(k kVar) {
        this.f5125c.add(kVar);
    }

    private void b(k kVar) {
        this.f5125c.remove(kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        this.f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f;
    }

    private void a(Activity activity) {
        e();
        k b2 = com.bumptech.glide.c.a(activity).g().b(activity);
        this.f5127e = b2;
        if (equals(b2)) {
            return;
        }
        this.f5127e.a(this);
    }

    private void e() {
        k kVar = this.f5127e;
        if (kVar != null) {
            kVar.b(this);
            this.f5127e = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        e();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f5123a.a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f5123a.b();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f5123a.c();
        e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    /* compiled from: RequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }
}
