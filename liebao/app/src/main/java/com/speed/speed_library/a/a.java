package com.speed.speed_library.a;

import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.speed.speed_library.R;
import com.speed.speed_library.event.NetworkChangeEvent;
import com.speed.speed_library.utils.h;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import kotlin.d.b.i;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

/* compiled from: BaseActivity.kt */
/* loaded from: classes.dex */
public abstract class a extends com.trello.rxlifecycle3.components.a.a {
    private HashMap k;

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

    @m(a = ThreadMode.MAIN)
    public final void onNetworkChangeEvent(NetworkChangeEvent networkChangeEvent) {
        i.b(networkChangeEvent, "event");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(32);
        h.f5876a.a(this, getResources().getColor(R.color.colorWhite), true);
        org.greenrobot.eventbus.c.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.trello.rxlifecycle3.components.a.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.trello.rxlifecycle3.components.a.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public final void k() {
        try {
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                Object systemService = getSystemService("input_method");
                if (systemService == null) {
                    throw new kotlin.i("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
                ((InputMethodManager) systemService).hideSoftInputFromWindow(windowToken, 2);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }
}
