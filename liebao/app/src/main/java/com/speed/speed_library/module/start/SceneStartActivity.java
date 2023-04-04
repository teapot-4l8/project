package com.speed.speed_library.module.start;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.speed.speed_library.module.main.MainActivity;
import com.speed.speed_library.widget.a.d;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: SceneStartActivity.kt */
/* loaded from: classes2.dex */
public final class SceneStartActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
    private String k = "";
    private HashMap l;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.l.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public final String l() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scene_start);
        m();
    }

    public final void m() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("选择场景模式");
        LinearLayout linearLayout = (LinearLayout) d(R.id.ll_back);
        i.a((Object) linearLayout, "ll_back");
        linearLayout.setVisibility(8);
        SceneStartActivity sceneStartActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(sceneStartActivity);
        ((RelativeLayout) d(R.id.rl_abord)).setOnClickListener(sceneStartActivity);
        ((RelativeLayout) d(R.id.rl_china)).setOnClickListener(sceneStartActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_abord))) {
            this.k = "出海模式";
            n();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_china))) {
            this.k = "中国模式";
            n();
        }
    }

    private final void n() {
        d dVar = new d(this);
        dVar.setCanceledOnTouchOutside(true);
        dVar.a("温馨提示");
        dVar.b("确认选择" + this.k + "吗?");
        dVar.c("确认");
        dVar.a(new a(dVar));
        dVar.setOnCancelListener(new b(dVar));
        dVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SceneStartActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f5806b;

        a(d dVar) {
            this.f5806b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (SceneStartActivity.this.l().equals("中国模式")) {
                g.f5610b.g(com.speed.speed_library.b.d.f5595a.j());
            } else {
                g.f5610b.g(com.speed.speed_library.b.d.f5595a.i());
            }
            SceneStartActivity.this.startActivity(new Intent(SceneStartActivity.this, MainActivity.class));
            d dVar = this.f5806b;
            if (dVar != null) {
                dVar.dismiss();
            }
            SceneStartActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SceneStartActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f5807a;

        b(d dVar) {
            this.f5807a = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f5807a.cancel();
        }
    }
}
