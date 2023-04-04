package com.speed.speed_library.debug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import java.util.HashMap;
import kotlin.d.b.i;
import utils.AppLog;

/* compiled from: DebugReviseActivity.kt */
/* loaded from: classes2.dex */
public final class DebugReviseActivity extends com.speed.speed_library.a.a {
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
        setContentView(R.layout.activity_debug_revise);
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugReviseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EditText editText = (EditText) DebugReviseActivity.this.d(R.id.et_default_qt);
            i.a((Object) editText, "et_default_qt");
            String obj = editText.getText().toString();
            EditText editText2 = (EditText) DebugReviseActivity.this.d(R.id.et_default_domain);
            i.a((Object) editText2, "et_default_domain");
            String obj2 = editText2.getText().toString();
            AppLog appLog = AppLog.INSTANCE;
            appLog.d("qt_new:::" + obj);
            AppLog appLog2 = AppLog.INSTANCE;
            appLog2.d("default_domain_new:::" + obj2);
            g.f5610b.i(obj);
            g.f5610b.j(obj2);
            DebugReviseActivity.this.m();
        }
    }

    public final void l() {
        ((Button) d(R.id.btn_confirm)).setOnClickListener(new a());
        ((Button) d(R.id.btn_clear)).setOnClickListener(new b());
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugReviseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g.f5610b.R();
            g.f5610b.T();
            DebugReviseActivity.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugReviseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugReviseActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            i.a();
        }
        launchIntentForPackage.addFlags(67108864);
        startActivity(launchIntentForPackage);
    }
}
