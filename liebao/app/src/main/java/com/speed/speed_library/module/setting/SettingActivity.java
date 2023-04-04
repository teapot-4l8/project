package com.speed.speed_library.module.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.a.a;
import com.speed.speed_library.widget.checkin.CheckInView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: SettingActivity.kt */
/* loaded from: classes2.dex */
public final class SettingActivity extends a implements View.OnClickListener {
    private ArrayList<Integer> k = new ArrayList<>();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting);
        l();
        m();
    }

    public final void l() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("更多设置");
        this.k.add(2);
        this.k.add(5);
        ((CheckInView) d(R.id.checkInView)).a(this.k);
    }

    public final void m() {
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        }
    }
}
