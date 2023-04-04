package com.speed.speed_library.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: RxFragment.kt */
/* loaded from: classes.dex */
public abstract class d extends androidx.fragment.app.d {

    /* renamed from: a  reason: collision with root package name */
    private final b.b.i.a<com.trello.rxlifecycle3.a.b> f5551a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f5552b;

    public View a(int i) {
        if (this.f5552b == null) {
            this.f5552b = new HashMap();
        }
        View view = (View) this.f5552b.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.f5552b.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public void c() {
        HashMap hashMap = this.f5552b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public d() {
        b.b.i.a<com.trello.rxlifecycle3.a.b> i = b.b.i.a.i();
        i.a((Object) i, "BehaviorSubject.create<FragmentEvent>()");
        this.f5551a = i;
    }

    public <T> com.trello.rxlifecycle3.b<T> d() {
        com.trello.rxlifecycle3.b<T> b2 = com.trello.rxlifecycle3.a.c.b(this.f5551a);
        i.a((Object) b2, "RxLifecycleAndroid.bindFragment(lifecycleSubject)");
        return b2;
    }

    @Override // androidx.fragment.app.d
    public void onAttach(Activity activity) {
        i.b(activity, "activity");
        super.onAttach(activity);
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.ATTACH);
    }

    @Override // androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.CREATE);
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        i.b(view, "view");
        super.onViewCreated(view, bundle);
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.CREATE_VIEW);
    }

    @Override // androidx.fragment.app.d
    public void onStart() {
        super.onStart();
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.START);
    }

    @Override // androidx.fragment.app.d
    public void onResume() {
        super.onResume();
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.RESUME);
    }

    @Override // androidx.fragment.app.d
    public void onPause() {
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.d
    public void onStop() {
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.d
    public void onDestroyView() {
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.DESTROY_VIEW);
        super.onDestroyView();
        c();
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.d
    public void onDetach() {
        this.f5551a.a_(com.trello.rxlifecycle3.a.b.DETACH);
        super.onDetach();
    }
}
