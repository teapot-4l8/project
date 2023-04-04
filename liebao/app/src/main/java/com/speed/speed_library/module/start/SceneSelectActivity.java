package com.speed.speed_library.module.start;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.a.a;
import com.speed.speed_library.b.d;
import com.speed.speed_library.b.g;
import com.speed.speed_library.event.SceneSelectsEvent;
import java.util.HashMap;
import kotlin.d.b.i;
import org.greenrobot.eventbus.c;

/* compiled from: SceneSelectActivity.kt */
/* loaded from: classes2.dex */
public final class SceneSelectActivity extends a implements View.OnClickListener {
    private HashMap k;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.k.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scene_select);
        l();
        m();
    }

    public final void l() {
        if (g.f5610b.H().equals(d.f5595a.j())) {
            o();
        } else {
            n();
        }
    }

    public final void m() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("选择场景模式");
        SceneSelectActivity sceneSelectActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(sceneSelectActivity);
        ((LinearLayout) d(R.id.ll_abord)).setOnClickListener(sceneSelectActivity);
        ((LinearLayout) d(R.id.ll_china)).setOnClickListener(sceneSelectActivity);
    }

    public final void n() {
        ((ImageView) d(R.id.iv_route_select_abord)).setBackgroundResource(R.mipmap.ic_route_select);
        ((ImageView) d(R.id.iv_route_select_china)).setBackgroundResource(R.mipmap.ic_route_unselect);
    }

    public final void o() {
        ((ImageView) d(R.id.iv_route_select_abord)).setBackgroundResource(R.mipmap.ic_route_unselect);
        ((ImageView) d(R.id.iv_route_select_china)).setBackgroundResource(R.mipmap.ic_route_select);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        } else if (i.a(view, (LinearLayout) d(R.id.ll_abord))) {
            n();
            SceneSelectsEvent sceneSelectsEvent = new SceneSelectsEvent();
            sceneSelectsEvent.setType(d.f5595a.i());
            c.a().d(sceneSelectsEvent);
            finish();
        } else if (i.a(view, (LinearLayout) d(R.id.ll_china))) {
            o();
            SceneSelectsEvent sceneSelectsEvent2 = new SceneSelectsEvent();
            sceneSelectsEvent2.setType(d.f5595a.j());
            c.a().d(sceneSelectsEvent2);
            finish();
        }
    }
}
