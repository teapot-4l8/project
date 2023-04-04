package com.speed.speed_library.module.setting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.a.a;
import com.speed.speed_library.b.b;
import com.speed.speed_library.b.c;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.g;
import com.speed.speed_library.business.e;
import com.speed.speed_library.debug.DebugActivity;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.UserModel;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: AboutActivity.kt */
/* loaded from: classes2.dex */
public final class AboutActivity extends a implements View.OnClickListener {
    private final int k = 5;
    private final long l = 1000;
    private long[] m = new long[5];
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
        setContentView(R.layout.activity_about);
        l();
        m();
    }

    public final void l() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("关于我们");
        if (c.f5594a.e()) {
            ((ImageView) d(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_logo));
        } else {
            ((ImageView) d(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_logo_haiou));
        }
    }

    public final void m() {
        AboutActivity aboutActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(aboutActivity);
        ((RelativeLayout) d(R.id.rl_menu_email)).setOnClickListener(aboutActivity);
        ((RelativeLayout) d(R.id.rl_service_terms)).setOnClickListener(aboutActivity);
        ((TextView) d(R.id.headerbar_title)).setOnClickListener(aboutActivity);
        ((RelativeLayout) d(R.id.rl_privacy_policy)).setOnClickListener(aboutActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ConfigModel t;
        String official_website;
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        } else if (i.a(view, (TextView) d(R.id.headerbar_title))) {
            n();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_menu_email))) {
            String str = "";
            if (g.f5610b.t() != null) {
                ConfigModel t2 = g.f5610b.t();
                if (!TextUtils.isEmpty(t2 != null ? t2.getOfficial_website() : null) && (t = g.f5610b.t()) != null && (official_website = t.getOfficial_website()) != null) {
                    str = official_website;
                }
            }
            String str2 = str;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Object systemService = getSystemService("clipboard");
            if (systemService == null) {
                throw new kotlin.i("null cannot be cast to non-null type android.content.ClipboardManager");
            }
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Label", str2));
            f.a("已复制官网地址", 0, 2, null);
            com.speed.speed_library.utils.f.f5870a.a(this, str);
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_service_terms))) {
            c.f5594a.a(this, b.f5592a.h(), "服务条款");
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_privacy_policy))) {
            c.f5594a.a(this, b.f5592a.h(), "隐私协议");
        }
    }

    public final void n() {
        UserModel j;
        long[] jArr = this.m;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.m;
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        if (this.m[0] >= SystemClock.uptimeMillis() - this.l) {
            this.m = new long[this.k];
            if (e.f5632a.b() && (j = g.f5610b.j()) != null && j.getWhitelist() == 1) {
                startActivity(new Intent(this, DebugActivity.class));
            }
        }
    }
}
