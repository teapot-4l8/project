package com.speed.speed_library.a;

import android.view.View;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: BaseFragment.kt */
/* loaded from: classes.dex */
public abstract class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public View f5544a;

    /* renamed from: b  reason: collision with root package name */
    private b.b.b.a f5545b = new b.b.b.a();

    /* renamed from: c  reason: collision with root package name */
    private HashMap f5546c;

    @Override // com.speed.speed_library.a.d
    public View a(int i) {
        if (this.f5546c == null) {
            this.f5546c = new HashMap();
        }
        View view = (View) this.f5546c.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.f5546c.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.f5546c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public final View a() {
        View view = this.f5544a;
        if (view == null) {
            i.b("mRootView");
        }
        return view;
    }

    public final void a(View view) {
        i.b(view, "<set-?>");
        this.f5544a = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b.b.b.a b() {
        return this.f5545b;
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        if (!this.f5545b.b()) {
            this.f5545b.c();
        }
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }
}
