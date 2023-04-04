package com.speed.speed_library.debug;

import a.a.a.e.m;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.speed.speed_library.R;
import java.util.HashMap;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: RoutesFragment.kt */
/* loaded from: classes2.dex */
public final class d extends com.speed.speed_library.a.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f5677b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f5678c;

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i) {
        if (this.f5678c == null) {
            this.f5678c = new HashMap();
        }
        View view = (View) this.f5678c.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.f5678c.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.f5678c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    /* compiled from: RoutesFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final d a() {
            Bundle bundle = new Bundle();
            d dVar = new d();
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.activity_routes, viewGroup, false);
        i.a((Object) inflate, "inflater.inflate(R.layou…routes, container, false)");
        a(inflate);
        e();
        return a();
    }

    public final void e() {
        String b2 = m.b();
        TextView textView = (TextView) a().findViewById(R.id.tv_route);
        i.a((Object) textView, "mRootView.tv_route");
        textView.setText(b2);
    }
}
