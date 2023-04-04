package com.speed.speed_library.debug;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.fragment.app.e;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import java.util.HashMap;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: AppFragment.kt */
/* loaded from: classes2.dex */
public final class a extends com.speed.speed_library.a.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final C0142a f5666b = new C0142a(null);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f5667c;

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i) {
        if (this.f5667c == null) {
            this.f5667c = new HashMap();
        }
        View view = (View) this.f5667c.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.f5667c.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.f5667c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    /* compiled from: AppFragment.kt */
    /* renamed from: com.speed.speed_library.debug.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0142a {
        private C0142a() {
        }

        public /* synthetic */ C0142a(g gVar) {
            this();
        }

        public final a a() {
            Bundle bundle = new Bundle();
            a aVar = new a();
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_app, viewGroup, false);
        i.a((Object) inflate, "inflater.inflate(R.layou…nt_app, container, false)");
        a(inflate);
        e();
        return a();
    }

    public final void e() {
        a aVar = this;
        ((RelativeLayout) a().findViewById(R.id.debug_rl_api_history)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.debug_rl_revise)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.debug_rl_speed_log)).setOnClickListener(aVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (RelativeLayout) a().findViewById(R.id.debug_rl_api_history))) {
            if (!f()) {
                f.a("请输入正确的调试秘钥", 0, 2, null);
            } else {
                startActivity(leavesc.hello.monitor.a.a(getActivity()));
            }
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.debug_rl_revise))) {
            if (!f()) {
                f.a("请输入正确的调试秘钥", 0, 2, null);
                return;
            }
            e activity = getActivity();
            if (activity == null) {
                i.a();
            }
            activity.startActivity(new Intent(getActivity(), DebugReviseActivity.class));
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.debug_rl_speed_log))) {
            if (!f()) {
                f.a("请输入正确的调试秘钥", 0, 2, null);
                return;
            }
            e activity2 = getActivity();
            if (activity2 == null) {
                i.a();
            }
            activity2.startActivity(new Intent(getActivity(), DebugSpeedLogActivity.class));
        }
    }

    public final boolean f() {
        EditText editText = (EditText) a().findViewById(R.id.debug_et_debug_key);
        i.a((Object) editText, "mRootView.debug_et_debug_key");
        if (TextUtils.isEmpty(editText.getText().toString())) {
            return false;
        }
        EditText editText2 = (EditText) a().findViewById(R.id.debug_et_debug_key);
        i.a((Object) editText2, "mRootView.debug_et_debug_key");
        return editText2.getText().toString().equals("kebi");
    }
}
