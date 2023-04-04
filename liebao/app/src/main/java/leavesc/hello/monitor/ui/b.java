package leavesc.hello.monitor.ui;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.d;
import androidx.lifecycle.s;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.l;
import leavesc.hello.monitor.R;

/* compiled from: MonitorPayloadFragment.java */
/* loaded from: classes2.dex */
public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f7279a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f7280b;

    /* renamed from: c  reason: collision with root package name */
    private int f7281c;

    private static b a(int i) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putInt("keyType", i);
        bVar.setArguments(bundle);
        return bVar;
    }

    public static b a() {
        return a(100);
    }

    public static b b() {
        return a((int) l.a.DEFAULT_DRAG_ANIMATION_DURATION);
    }

    @Override // androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f7281c = arguments.getInt("keyType");
        }
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_monitor_payload, viewGroup, false);
        this.f7279a = (TextView) inflate.findViewById(R.id.tvHeaders);
        this.f7280b = (TextView) inflate.findViewById(R.id.tvBody);
        return inflate;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        c();
    }

    private void c() {
        ((leavesc.hello.monitor.c.a) z.a(getActivity()).a(leavesc.hello.monitor.c.a.class)).f().a(this, new s<leavesc.hello.monitor.db.a.b>() { // from class: leavesc.hello.monitor.ui.b.1
            @Override // androidx.lifecycle.s
            public void a(leavesc.hello.monitor.db.a.b bVar) {
                if (bVar != null) {
                    int i = b.this.f7281c;
                    if (i == 100) {
                        b.this.a(bVar.a(true), bVar.d(), bVar.w());
                    } else if (i != 200) {
                    } else {
                        b.this.a(bVar.b(true), bVar.e(), bVar.D());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f7279a.setVisibility(8);
        } else {
            this.f7279a.setVisibility(0);
            this.f7279a.setText(Html.fromHtml(str));
        }
        if (!z) {
            this.f7280b.setText("(encoded or binary body omitted)");
            return;
        }
        String str3 = null;
        try {
            str3 = leavesc.hello.monitor.b.b.a(str2, "vsegvdwefdee", "F1nesqYjfPQEnnwo");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f7280b.setText(str3);
    }
}
