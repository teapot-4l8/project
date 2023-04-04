package leavesc.hello.monitor.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.d;
import androidx.lifecycle.s;
import androidx.lifecycle.z;
import leavesc.hello.monitor.R;

/* compiled from: MonitorOverviewFragment.java */
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f7273a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f7274b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f7275c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f7276d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f7277e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;

    public static a a() {
        return new a();
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_monitor_overview, viewGroup, false);
        this.f7273a = (TextView) inflate.findViewById(R.id.tv_url);
        this.f7274b = (TextView) inflate.findViewById(R.id.tv_method);
        this.f7275c = (TextView) inflate.findViewById(R.id.tv_protocol);
        this.f7276d = (TextView) inflate.findViewById(R.id.tv_status);
        this.f7277e = (TextView) inflate.findViewById(R.id.tv_response);
        this.f = (TextView) inflate.findViewById(R.id.tv_ssl);
        this.g = (TextView) inflate.findViewById(R.id.tv_request_time);
        this.h = (TextView) inflate.findViewById(R.id.tv_response_time);
        this.i = (TextView) inflate.findViewById(R.id.tv_duration);
        this.j = (TextView) inflate.findViewById(R.id.tv_request_size);
        this.k = (TextView) inflate.findViewById(R.id.tv_response_size);
        this.l = (TextView) inflate.findViewById(R.id.tv_total_size);
        return inflate;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((leavesc.hello.monitor.c.a) z.a(getActivity()).a(leavesc.hello.monitor.c.a.class)).f().a(this, new s<leavesc.hello.monitor.db.a.b>() { // from class: leavesc.hello.monitor.ui.a.1
            @Override // androidx.lifecycle.s
            public void a(leavesc.hello.monitor.db.a.b bVar) {
                if (bVar != null) {
                    a.this.f7273a.setText(bVar.n());
                    a.this.f7274b.setText(bVar.m());
                    a.this.f7275c.setText(bVar.r());
                    a.this.f7276d.setText(bVar.a().toString());
                    a.this.f7277e.setText(bVar.c());
                    a.this.f.setText(bVar.g() ? "Yes" : "No");
                    a.this.g.setText(leavesc.hello.monitor.b.b.b(bVar.j()));
                    a.this.h.setText(leavesc.hello.monitor.b.b.b(bVar.k()));
                    a.this.i.setText(bVar.f());
                    a.this.j.setText(leavesc.hello.monitor.b.b.a(bVar.v()));
                    a.this.k.setText(leavesc.hello.monitor.b.b.a(bVar.C()));
                    a.this.l.setText(bVar.h());
                }
            }
        });
    }
}
