package com.speed.speed_library.debug.netinfo;

import a.a.a.e.m;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.speed.speed_library.R;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: RoutesActivity.kt */
/* loaded from: classes2.dex */
public final class RoutesActivity extends com.speed.speed_library.a.a {
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
        setContentView(R.layout.activity_routes);
        l();
    }

    public final void l() {
        String b2 = m.b();
        TextView textView = (TextView) d(R.id.tv_route);
        i.a((Object) textView, "tv_route");
        textView.setText(b2);
    }
}
