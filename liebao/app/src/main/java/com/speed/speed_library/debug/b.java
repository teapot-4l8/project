package com.speed.speed_library.debug;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.e;
import com.speed.speed_library.R;
import com.speed.speed_library.debug.netinfo.ResultActivity;
import java.util.HashMap;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: GeneralFragment.kt */
/* loaded from: classes2.dex */
public final class b extends com.speed.speed_library.a.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f5668b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private final String f5669c = "http";

    /* renamed from: d  reason: collision with root package name */
    private HashMap f5670d;

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i) {
        if (this.f5670d == null) {
            this.f5670d = new HashMap();
        }
        View view = (View) this.f5670d.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.f5670d.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.f5670d;
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

    /* compiled from: GeneralFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final b a() {
            Bundle bundle = new Bundle();
            b bVar = new b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public final String e() {
        return this.f5669c;
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_general, viewGroup, false);
        i.a((Object) inflate, "inflater.inflate(R.layou…eneral, container, false)");
        a(inflate);
        f();
        return a();
    }

    public final void f() {
        ((EditText) a().findViewById(R.id.debug_et_input)).setText("127.0.0.1");
        e activity = getActivity();
        if (activity == null) {
            i.a();
        }
        if (androidx.core.content.b.b(activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            e activity2 = getActivity();
            if (activity2 == null) {
                i.a();
            }
            androidx.core.app.a.a(activity2, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
        }
        ((Button) a().findViewById(R.id.debug_start_btn)).setOnClickListener(new View$OnClickListenerC0143b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeneralFragment.kt */
    /* renamed from: com.speed.speed_library.debug.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class View$OnClickListenerC0143b implements View.OnClickListener {
        View$OnClickListenerC0143b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e activity = b.this.getActivity();
            if (activity == null) {
                i.a();
            }
            Intent intent = new Intent(activity, ResultActivity.class);
            intent.putExtra(b.this.e(), ((EditText) b.this.a().findViewById(R.id.debug_et_input)).getText().toString());
            b.this.startActivity(intent);
        }
    }
}
