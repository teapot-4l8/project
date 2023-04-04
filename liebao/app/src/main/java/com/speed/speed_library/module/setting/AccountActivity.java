package com.speed.speed_library.module.setting;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.a.a;
import com.speed.speed_library.b.g;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.module.login.UpdatePwdActivity;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: AccountActivity.kt */
/* loaded from: classes2.dex */
public final class AccountActivity extends a implements View.OnClickListener {
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
        setContentView(R.layout.activity_account);
        l();
        m();
    }

    public final void l() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("我的账号");
        TextView textView2 = (TextView) d(R.id.tv_id);
        i.a((Object) textView2, "tv_id");
        UserModel j = g.f5610b.j();
        textView2.setText(String.valueOf(j != null ? Integer.valueOf(j.getUid()) : null));
        UserModel j2 = g.f5610b.j();
        if (!TextUtils.isEmpty(j2 != null ? j2.getPhone() : null)) {
            TextView textView3 = (TextView) d(R.id.tv_phone);
            i.a((Object) textView3, "tv_phone");
            UserModel j3 = g.f5610b.j();
            textView3.setText(String.valueOf(j3 != null ? j3.getPhone() : null));
            ImageView imageView = (ImageView) d(R.id.iv_phone_arrow);
            i.a((Object) imageView, "iv_phone_arrow");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = (ImageView) d(R.id.iv_phone_arrow);
        i.a((Object) imageView2, "iv_phone_arrow");
        imageView2.setVisibility(0);
    }

    public final void m() {
        AccountActivity accountActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(accountActivity);
        ((RelativeLayout) d(R.id.rl_bind)).setOnClickListener(accountActivity);
        ((RelativeLayout) d(R.id.rl_menu_update_pwd)).setOnClickListener(accountActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            onBackPressed();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_bind))) {
            UserModel j = g.f5610b.j();
            if (TextUtils.isEmpty(j != null ? j.getPhone() : null)) {
                startActivity(new Intent(this, BindAccountActivity.class));
            }
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_menu_update_pwd))) {
            startActivity(new Intent(this, UpdatePwdActivity.class));
        }
    }
}
