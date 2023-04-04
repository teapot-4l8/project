package com.speed.speed_library.module.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.e;
import com.speed.speed_library.R;
import com.speed.speed_library.b.d;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.h;
import com.speed.speed_library.event.UserInfoEvent;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.CaptchaModel;
import com.speed.speed_library.model.UserModel;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.d.b.i;
import kotlin.h.g;

/* compiled from: BindAccountActivity.kt */
/* loaded from: classes2.dex */
public final class BindAccountActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
    private b.b.b.a k = new b.b.b.a();
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

    public final b.b.b.a l() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bind_account);
        m();
        n();
    }

    public final void m() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("绑定手机");
        if (com.speed.speed_library.b.c.f5594a.e()) {
            ((ImageView) d(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_logo));
        } else {
            ((ImageView) d(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_login_logo_haiou));
        }
    }

    public final void n() {
        BindAccountActivity bindAccountActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(bindAccountActivity);
        ((TextView) d(R.id.tv_send_captcha)).setOnClickListener(bindAccountActivity);
        ((Button) d(R.id.btn_bind)).setOnClickListener(bindAccountActivity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            onBackPressed();
        } else if (i.a(view, (TextView) d(R.id.tv_send_captcha))) {
            com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
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
                if (obj2 == null) {
                    throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
                }
                if (g.a(obj2).toString().length() == 11) {
                    EditText editText3 = (EditText) d(R.id.et_phone);
                    i.a((Object) editText3, "et_phone");
                    String obj3 = editText3.getText().toString();
                    if (obj3 == null) {
                        throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    a(g.a(obj3).toString(), 2);
                    return;
                }
            }
            f.a("手机号不合法", 0, 2, null);
        } else if (i.a(view, (Button) d(R.id.btn_bind)) && p()) {
            o();
        }
    }

    public final void o() {
        d.a.a.a.a.a a2 = d.a.a.a.a.c.f6985a.a();
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
        String obj4 = g.a(obj3).toString();
        EditText editText3 = (EditText) d(R.id.et_captcha);
        i.a((Object) editText3, "et_captcha");
        String obj5 = editText3.getText().toString();
        if (obj5 == null) {
            throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
        }
        a2.a(obj2, obj4, g.a(obj5).toString()).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(s()).a(new b(this));
    }

    /* compiled from: BindAccountActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.speed.speed_library.a.c<BaseModel<UserModel>> {
        b(Context context) {
            super(context);
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<UserModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, true)) {
                com.speed.speed_library.b.g.f5610b.a(baseModel.getData());
                org.greenrobot.eventbus.c.a().d(new UserInfoEvent());
                f.a("绑定成功", 0, 2, null);
                BindAccountActivity.this.finish();
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            h.f5614a.a(th);
        }
    }

    public final void a(String str, int i) {
        i.b(str, "phone");
        d.a.a.a.a.c.f6985a.a().a(str, i).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(s()).a(new c(this));
    }

    /* compiled from: BindAccountActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.speed.speed_library.a.c<BaseModel<CaptchaModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        c(Context context) {
            super(context);
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CaptchaModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, true)) {
                BindAccountActivity.this.r();
            }
        }
    }

    public final boolean p() {
        com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
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
            if (obj2 == null) {
                throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
            }
            if (g.a(obj2).toString().length() == 11) {
                com.speed.speed_library.b.c cVar2 = com.speed.speed_library.b.c.f5594a;
                EditText editText3 = (EditText) d(R.id.et_pwd);
                i.a((Object) editText3, "et_pwd");
                if (!cVar2.b(editText3.getText().toString())) {
                    f.a("密码至少为6个字符", 0, 2, null);
                    return false;
                }
                EditText editText4 = (EditText) d(R.id.et_captcha);
                i.a((Object) editText4, "et_captcha");
                String obj3 = editText4.getText().toString();
                if (obj3 != null) {
                    if (TextUtils.isEmpty(g.a(obj3).toString())) {
                        f.a("请输入验证码", 0, 2, null);
                        return false;
                    }
                    return true;
                }
                throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        f.a("手机号不合法", 0, 2, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        e.a(0L, 1L, TimeUnit.SECONDS).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new a());
    }

    /* compiled from: BindAccountActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements b.b.h<Long> {
        @Override // b.b.h
        public void a(Throwable th) {
            i.b(th, "e");
        }

        @Override // b.b.h
        public void b() {
        }

        a() {
        }

        @Override // b.b.h
        public /* synthetic */ void a_(Long l) {
            a(l.longValue());
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            i.b(bVar, "d");
            BindAccountActivity.this.l().a(bVar);
        }

        public void a(long j) {
            if (j > d.f5595a.b()) {
                BindAccountActivity.this.q();
            } else {
                BindAccountActivity.this.a(d.f5595a.b() - j);
            }
        }
    }

    public final void a(long j) {
        TextView textView = (TextView) d(R.id.tv_send_captcha);
        i.a((Object) textView, "tv_send_captcha");
        textView.setEnabled(false);
        TextView textView2 = (TextView) d(R.id.tv_send_captcha);
        i.a((Object) textView2, "tv_send_captcha");
        textView2.setText(String.valueOf(j) + "S后获取");
        ((TextView) d(R.id.tv_send_captcha)).setTextColor(getResources().getColor(R.color.text_color_hint));
    }

    public final void q() {
        b.b.b.a aVar = this.k;
        if (aVar != null) {
            if (aVar == null) {
                i.a();
            }
            if (!aVar.b()) {
                b.b.b.a aVar2 = this.k;
                if (aVar2 == null) {
                    i.a();
                }
                aVar2.c();
            }
        }
        TextView textView = (TextView) d(R.id.tv_send_captcha);
        i.a((Object) textView, "tv_send_captcha");
        textView.setEnabled(true);
        TextView textView2 = (TextView) d(R.id.tv_send_captcha);
        i.a((Object) textView2, "tv_send_captcha");
        textView2.setText("重新发送");
        ((TextView) d(R.id.tv_send_captcha)).setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b.b.b.a aVar = this.k;
        if (aVar == null || aVar.b()) {
            return;
        }
        this.k.c();
    }
}
