package com.speed.speed_library.module.line;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.speed.speed_library.R;
import com.speed.speed_library.adapter.RouteAdapter;
import com.speed.speed_library.b.h;
import com.speed.speed_library.event.RouteEvent;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.RouteAreaModel;
import com.speed.speed_library.model.RouteModel;
import d.a.a.a.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.d.b.i;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

/* compiled from: LineSelectActivity.kt */
/* loaded from: classes.dex */
public final class LineSelectActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
    private RecyclerView k;
    private RouteAdapter l;
    private ArrayList<RouteAreaModel.Route> m = new ArrayList<>();
    private HashMap n;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.n.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.bottom_in, R.anim.bottom_silent);
        setContentView(R.layout.activity_line_select);
        l();
        m();
        n();
    }

    public final void l() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("选择服务器");
        this.l = new RouteAdapter(this.m);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.k = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        RecyclerView recyclerView2 = this.k;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.l);
        }
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            onBackPressed();
        }
    }

    @m(a = ThreadMode.MAIN)
    public final void routeEvent(RouteEvent routeEvent) {
        i.b(routeEvent, "event");
        if (isFinishing()) {
            return;
        }
        finish();
    }

    public final void m() {
        ArrayList<RouteAreaModel.Route> arrayList = this.m;
        if (arrayList != null) {
            arrayList.clear();
        }
        RouteAdapter routeAdapter = this.l;
        if (routeAdapter != null) {
            ArrayList<RouteAreaModel.Route> arrayList2 = this.m;
            if (arrayList2 == null) {
                i.a();
            }
            routeAdapter.a(arrayList2);
        }
    }

    public final void n() {
        c.f6985a.a().e().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new a());
    }

    /* compiled from: LineSelectActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.speed.speed_library.a.c<BaseModel<RouteModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        a() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<RouteModel> baseModel) {
            i.b(baseModel, "response");
            h.f5614a.a(baseModel, true);
        }
    }

    @Override // com.speed.speed_library.a.a, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.bottom_silent, R.anim.bottom_out);
    }

    @Override // androidx.activity.b, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
