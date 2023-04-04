package com.speed.speed_library.module.login;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bingoogolapple.qrcode.core.f;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.h;
import com.speed.speed_library.business.e;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.CommonModel;
import com.speed.speed_library.model.UserModel;
import java.util.HashMap;
import kotlin.d.b.i;
import kotlin.h.g;
import utils.AppLog;

/* compiled from: QrLoginActivity.kt */
/* loaded from: classes2.dex */
public final class QrLoginActivity extends com.speed.speed_library.a.a implements f.a {
    private String k = "";
    private String l = "liebao-qr://login-";
    private String m = "qr://pay-";
    private HashMap n;

    @Override // cn.bingoogolapple.qrcode.core.f.a
    public void a(boolean z) {
    }

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

    public final String l() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qr_login);
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("扫描二维码/条码");
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onStart() {
        super.onStart();
        ((ZXingView) d(R.id.zxingview)).setDelegate(this);
        ((ZXingView) d(R.id.zxingview)).d();
        ((ZXingView) d(R.id.zxingview)).i();
    }

    @Override // cn.bingoogolapple.qrcode.core.f.a
    public void a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            com.speed.speed_library.b.f.a("扫描结果不能为空", 0, 2, null);
            finish();
            return;
        }
        if (str == null) {
            i.a();
        }
        if (g.a((CharSequence) str2, (CharSequence) "http", false, 2, (Object) null)) {
            if (g.b(str, "qr://pay-", false, 2, (Object) null)) {
                String substring = str.substring(g.a((CharSequence) str2, "pay-", 0, false, 6, (Object) null) + 4, str.length());
                i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt((String) g.b((CharSequence) substring, new String[]{";"}, false, 0, 6, (Object) null).get(0));
                if (com.speed.speed_library.b.g.f5610b.j() == null) {
                    com.speed.speed_library.b.f.a("需先登录才能支付", 0, 2, null);
                } else {
                    UserModel j = com.speed.speed_library.b.g.f5610b.j();
                    if (j == null) {
                        i.a();
                    }
                    if (j.getUid() == parseInt) {
                        com.speed.speed_library.b.c.f5594a.a(this, com.speed.speed_library.b.b.f5592a.a("vip"), "购买");
                    } else {
                        com.speed.speed_library.b.f.a("当前TV端账号和手机端账号不一致，请先切换至同一账号", 0, 2, null);
                    }
                }
            } else {
                com.speed.speed_library.b.c.f5594a.a(this, str, "");
            }
            finish();
        } else if (!g.b(str, this.l, false, 2, (Object) null)) {
            com.speed.speed_library.b.f.a("扫描结果格式不对", 0, 2, null);
            finish();
        } else {
            String substring2 = str.substring(g.a((CharSequence) str2, "login-", 0, false, 6, (Object) null) + 6, str.length());
            i.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            this.k = substring2;
            AppLog.INSTANCE.d(this.k);
            p();
        }
    }

    @Override // cn.bingoogolapple.qrcode.core.f.a
    public void e_() {
        com.speed.speed_library.b.f.a("打开相机出错", 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onStop() {
        ((ZXingView) d(R.id.zxingview)).e();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        ((ZXingView) d(R.id.zxingview)).j();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QrLoginActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QrLoginActivity.this.finish();
        }
    }

    public final void m() {
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(new a());
        ((TextView) d(R.id.btn_login_qr_cancel)).setOnClickListener(new b());
        ((Button) d(R.id.btn_login_qr)).setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QrLoginActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QrLoginActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QrLoginActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!e.f5632a.b()) {
                com.speed.speed_library.b.f.a("当前账号暂未登录，请先登录", 0, 2, null);
                QrLoginActivity.this.finish();
                return;
            }
            d.a.a.a.a.c.f6985a.a().b(QrLoginActivity.this.l(), "confirm", "login").b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new com.speed.speed_library.a.c<BaseModel<CommonModel>>(QrLoginActivity.this) { // from class: com.speed.speed_library.module.login.QrLoginActivity.c.1
                @Override // com.speed.speed_library.a.c
                /* renamed from: a */
                public void b(BaseModel<CommonModel> baseModel) {
                    i.b(baseModel, "response");
                    if (h.f5614a.a(baseModel, true)) {
                        com.speed.speed_library.b.f.a("扫码成功，电脑端即将登录", 0, 2, null);
                        QrLoginActivity.this.finish();
                        return;
                    }
                    QrLoginActivity.this.o();
                }

                @Override // com.speed.speed_library.a.c
                public void b(Throwable th) {
                    i.b(th, "e");
                    h.f5614a.a(th);
                    QrLoginActivity.this.finish();
                }
            });
        }
    }

    public final void n() {
        LinearLayout linearLayout = (LinearLayout) d(R.id.ll_login);
        i.a((Object) linearLayout, "ll_login");
        linearLayout.setVisibility(0);
        ZXingView zXingView = (ZXingView) d(R.id.zxingview);
        i.a((Object) zXingView, "zxingview");
        zXingView.setVisibility(8);
    }

    public final void o() {
        ZXingView zXingView = (ZXingView) d(R.id.zxingview);
        i.a((Object) zXingView, "zxingview");
        zXingView.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) d(R.id.ll_login);
        i.a((Object) linearLayout, "ll_login");
        linearLayout.setVisibility(8);
        ((ZXingView) d(R.id.zxingview)).i();
    }

    public final void p() {
        if (!e.f5632a.b()) {
            com.speed.speed_library.b.f.a("当前账号暂未登录，请先登录", 0, 2, null);
            finish();
            return;
        }
        d.a.a.a.a.c.f6985a.a().b(this.k, "lock", "login").b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new d(this));
    }

    /* compiled from: QrLoginActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d extends com.speed.speed_library.a.c<BaseModel<CommonModel>> {
        d(Context context) {
            super(context);
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CommonModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, true)) {
                QrLoginActivity.this.n();
            } else {
                QrLoginActivity.this.finish();
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            h.f5614a.a(th);
            QrLoginActivity.this.finish();
        }
    }
}
