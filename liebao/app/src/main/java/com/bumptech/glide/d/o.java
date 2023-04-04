package com.bumptech.glide.d;

import android.content.Context;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class o extends androidx.fragment.app.d {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.d.a f5137a;

    /* renamed from: b  reason: collision with root package name */
    private final m f5138b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<o> f5139c;

    /* renamed from: d  reason: collision with root package name */
    private o f5140d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.j f5141e;
    private androidx.fragment.app.d f;

    public o() {
        this(new com.bumptech.glide.d.a());
    }

    public o(com.bumptech.glide.d.a aVar) {
        this.f5138b = new a();
        this.f5139c = new HashSet();
        this.f5137a = aVar;
    }

    public void a(com.bumptech.glide.j jVar) {
        this.f5141e = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.d.a a() {
        return this.f5137a;
    }

    public com.bumptech.glide.j b() {
        return this.f5141e;
    }

    public m c() {
        return this.f5138b;
    }

    private void a(o oVar) {
        this.f5139c.add(oVar);
    }

    private void b(o oVar) {
        this.f5139c.remove(oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(androidx.fragment.app.d dVar) {
        this.f = dVar;
        if (dVar == null || dVar.getActivity() == null) {
            return;
        }
        a(dVar.getActivity());
    }

    private androidx.fragment.app.d d() {
        androidx.fragment.app.d parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    private void a(androidx.fragment.app.e eVar) {
        e();
        o b2 = com.bumptech.glide.c.a((Context) eVar).g().b(eVar);
        this.f5140d = b2;
        if (equals(b2)) {
            return;
        }
        this.f5140d.a(this);
    }

    private void e() {
        o oVar = this.f5140d;
        if (oVar != null) {
            oVar.b(this);
            this.f5140d = null;
        }
    }

    @Override // androidx.fragment.app.d
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            a(getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onDetach() {
        super.onDetach();
        this.f = null;
        e();
    }

    @Override // androidx.fragment.app.d
    public void onStart() {
        super.onStart();
        this.f5137a.a();
    }

    @Override // androidx.fragment.app.d
    public void onStop() {
        super.onStop();
        this.f5137a.b();
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        this.f5137a.c();
        e();
    }

    @Override // androidx.fragment.app.d
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    /* compiled from: SupportRequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }
}
