package com.speed.speed_library.debug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.e;
import com.speed.speed_library.R;
import java.util.HashMap;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: InterfacesFragment.kt */
/* loaded from: classes2.dex */
public final class c extends com.speed.speed_library.a.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final a f5672b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private HashMap f5673c;

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i) {
        if (this.f5673c == null) {
            this.f5673c = new HashMap();
        }
        View view = (View) this.f5673c.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.f5673c.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.f5673c;
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

    /* compiled from: InterfacesFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final c a() {
            Bundle bundle = new Bundle();
            c cVar = new c();
            cVar.setArguments(bundle);
            return cVar;
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.activity_interfaces, viewGroup, false);
        i.a((Object) inflate, "inflater.inflate(R.layou…rfaces, container, false)");
        a(inflate);
        e();
        return a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InterfacesFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            String[] a2 = a.a.a.e.g.a();
            StringBuffer stringBuffer = new StringBuffer();
            int length = a2.length;
            for (int i = 0; i < length; i++) {
                stringBuffer.append(a2[i] + "\n\n");
            }
            final String stringBuffer2 = stringBuffer.toString();
            i.a((Object) stringBuffer2, "sb.toString()");
            e activity = c.this.getActivity();
            if (activity == null) {
                i.a();
            }
            activity.runOnUiThread(new Runnable() { // from class: com.speed.speed_library.debug.c.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    TextView textView = (TextView) c.this.a().findViewById(R.id.tv_dns);
                    i.a((Object) textView, "mRootView.tv_dns");
                    textView.setText(stringBuffer2);
                }
            });
        }
    }

    public final void e() {
        new Thread(new b()).start();
    }
}
