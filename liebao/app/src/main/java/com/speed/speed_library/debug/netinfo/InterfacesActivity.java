package com.speed.speed_library.debug.netinfo;

import android.os.Bundle;
import android.view.View;
import com.speed.speed_library.R;
import java.util.HashMap;

/* compiled from: InterfacesActivity.kt */
/* loaded from: classes2.dex */
public final class InterfacesActivity extends com.speed.speed_library.a.a {
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

    public final void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_interfaces);
        l();
    }
}
