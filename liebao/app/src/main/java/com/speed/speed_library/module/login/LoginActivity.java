package com.speed.speed_library.module.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.c;
import com.speed.speed_library.b.d;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.h;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.module.main.MainActivity;
import java.util.HashMap;
import kotlin.d.b.i;
import kotlin.h.g;

/* compiled from: LoginActivity.kt */
/* loaded from: classes2.dex */
public final class LoginActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        l();
        m();
    }

    public final void l() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("登录");
        if (c.f5594a.e()) {
            ((ImageView) d(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_logo));
        } else {
            ((ImageView) d(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_logo_haiou));
        }
        if (getIntent() != null) {
            if (getIntent().getStringExtra(d.f5595a.S()) != null) {
                String stringExtra = getIntent().getStringExtra(d.f5595a.S());
                i.a((Object) stringExtra, "intent.getStringExtra(Constant.LOGIN_EXTRA_TYPE)");
                this.k = stringExtra;
                if (stringExtra.equals("okBack")) {
                    LinearLayout linearLayout = (LinearLayout) d(R.id.ll_back);
                    i.a((Object) linearLayout, "ll_back");
                    linearLayout.setVisibility(0);
                    return;
                }
                LinearLayout linearLayout2 = (LinearLayout) d(R.id.ll_back);
                i.a((Object) linearLayout2, "ll_back");
                linearLayout2.setVisibility(8);
                return;
            }
            LinearLayout linearLayout3 = (LinearLayout) d(R.id.ll_back);
            i.a((Object) linearLayout3, "ll_back");
            linearLayout3.setVisibility(8);
        }
    }

    public final void m() {
        LoginActivity loginActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(loginActivity);
        ((TextView) d(R.id.tv_device_login)).setOnClickListener(loginActivity);
        ((Button) d(R.id.btn_login)).setOnClickListener(loginActivity);
        ((TextView) d(R.id.tv_forget_pwd)).setOnClickListener(loginActivity);
        ((LinearLayout) d(R.id.ll_pwd_hide)).setOnClickListener(loginActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        } else if (i.a(view, (TextView) d(R.id.tv_device_login))) {
            a("", "");
        } else if (i.a(view, (TextView) d(R.id.tv_forget_pwd))) {
            startActivity(new Intent(this, ForgetPwdActivity.class));
        } else if (i.a(view, (Button) d(R.id.btn_login))) {
            if (n()) {
                EditText editText = (EditText) d(R.id.et_phone);
                i.a((Object) editText, "et_phone");
                String obj = editText.getText().toString();
                if (obj == null) {
                    throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj2 = g.a(obj).toString();
                EditText editText2 = (EditText) d(R.id.et_pwd);
                i.a((Object) editText2, "et_pwd");
                String obj3 = editText2.getText().toString();
                if (obj3 == null) {
                    throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
                }
                a(obj2, g.a(obj3).toString());
            }
        } else if (i.a(view, (LinearLayout) d(R.id.ll_pwd_hide))) {
            EditText editText3 = (EditText) d(R.id.et_pwd);
            i.a((Object) editText3, "et_pwd");
            if (editText3.getInputType() == 128) {
                EditText editText4 = (EditText) d(R.id.et_pwd);
                i.a((Object) editText4, "et_pwd");
                editText4.setInputType(129);
                ((ImageView) d(R.id.iv_pwd_hide)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_pwd_hide_or_show));
                return;
            }
            EditText editText5 = (EditText) d(R.id.et_pwd);
            i.a((Object) editText5, "et_pwd");
            editText5.setInputType(128);
            ((ImageView) d(R.id.iv_pwd_hide)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_pwd_hide_or_show));
        }
    }

    public final boolean n() {
        c cVar = c.f5594a;
        EditText editText = (EditText) d(R.id.et_phone);
        i.a((Object) editText, "et_phone");
        String obj = editText.getText().toString();
        if (obj == null) {
            throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
        }
        if (cVar.a(g.a(obj).toString())) {
            EditText editText2 = (EditText) d(R.id.et_phone);
            i.a((Object) editText2, "et_phone");
            String obj2 = editText2.getText().toString();
            if (obj2 != null) {
                if (g.a(obj2).toString().length() == 11) {
                    c cVar2 = c.f5594a;
                    EditText editText3 = (EditText) d(R.id.et_pwd);
                    i.a((Object) editText3, "et_pwd");
                    if (cVar2.b(editText3.getText().toString())) {
                        return true;
                    }
                    f.a("密码至少为6个字符", 0, 2, null);
                    return false;
                }
            } else {
                throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        f.a("手机号不合法", 0, 2, null);
        return false;
    }

    public final void a(String str, String str2) {
        i.b(str, "phone");
        i.b(str2, "password");
        k();
        d.a.a.a.a.c.f6985a.a().a(str, str2).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(s()).a(new a(this));
    }

    /* compiled from: LoginActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.speed.speed_library.a.c<BaseModel<UserModel>> {
        a(Context context) {
            super(context);
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<UserModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, true)) {
                com.speed.speed_library.b.g.f5610b.a(baseModel.getData());
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                f.a("登录成功", 0, 2, null);
                LoginActivity.this.finish();
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            h.f5614a.a(th);
        }
    }
}
