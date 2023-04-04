package com.speed.speed_library.debug;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import com.speed.speed_library.debug.netinfo.NetInfoActivity;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: DebugTypeActivity.kt */
/* loaded from: classes2.dex */
public final class DebugTypeActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
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
        setContentView(R.layout.activity_debug_type);
        l();
        m();
    }

    public final void l() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("调试类别");
    }

    public final void m() {
        DebugTypeActivity debugTypeActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(debugTypeActivity);
        ((RelativeLayout) d(R.id.rl_api_history)).setOnClickListener(debugTypeActivity);
        ((RelativeLayout) d(R.id.rl_other)).setOnClickListener(debugTypeActivity);
        ((RelativeLayout) d(R.id.rl_revise)).setOnClickListener(debugTypeActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_api_history))) {
            if (!n()) {
                f.a("请输入正确的调试秘钥", 0, 2, null);
            } else {
                startActivity(leavesc.hello.monitor.a.a(this));
            }
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_other))) {
            startActivity(new Intent(this, NetInfoActivity.class));
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_revise))) {
            if (!n()) {
                f.a("请输入正确的调试秘钥", 0, 2, null);
            } else {
                startActivity(new Intent(this, DebugReviseActivity.class));
            }
        }
    }

    public final boolean n() {
        EditText editText = (EditText) d(R.id.et_debug_key);
        i.a((Object) editText, "et_debug_key");
        if (TextUtils.isEmpty(editText.getText().toString())) {
            return false;
        }
        EditText editText2 = (EditText) d(R.id.et_debug_key);
        i.a((Object) editText2, "et_debug_key");
        return editText2.getText().toString().equals("kebi");
    }
}
