package com.speed.speed_library.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.h;
import com.speed.speed_library.event.UserInfoEvent;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.widget.checkin.CheckInView;
import java.util.ArrayList;
import kotlin.d.b.i;

/* compiled from: CheckInDialog.kt */
/* loaded from: classes2.dex */
public class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f5888a;

    /* renamed from: b  reason: collision with root package name */
    private String f5889b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        i.b(context, com.umeng.analytics.pro.d.R);
        this.f5889b = "";
        a();
    }

    public void a() {
        requestWindowFeature(1);
        setContentView(R.layout.widget_dialog_checkin);
        setCanceledOnTouchOutside(true);
        ImageView imageView = (ImageView) findViewById(R.id.cancel);
        i.a((Object) imageView, "cancel");
        this.f5888a = imageView;
        if (imageView == null) {
            i.b("cancelButton");
        }
        imageView.setOnClickListener(new View$OnClickListenerC0157b());
        this.f5889b = "";
        ((Button) findViewById(R.id.btn_checkin)).setOnClickListener(new c());
        String a2 = com.speed.speed_library.utils.c.f5860a.a(System.currentTimeMillis() / 1000);
        if (g.f5610b.h(a2) != null) {
            ArrayList<Integer> h = g.f5610b.h(a2);
            if (h == null) {
                i.a();
            }
            if (h.size() > 0) {
                CheckInView checkInView = (CheckInView) findViewById(R.id.checkInView);
                ArrayList<Integer> h2 = g.f5610b.h(a2);
                if (h2 == null) {
                    i.a();
                }
                checkInView.a(h2);
                ArrayList<Integer> h3 = g.f5610b.h(a2);
                if (h3 == null) {
                    i.a();
                }
                if (h3.contains(Integer.valueOf(com.speed.speed_library.widget.checkin.c.f5937a.d()))) {
                    Button button = (Button) findViewById(R.id.btn_checkin);
                    i.a((Object) button, "btn_checkin");
                    button.setEnabled(false);
                    Button button2 = (Button) findViewById(R.id.btn_checkin);
                    i.a((Object) button2, "btn_checkin");
                    button2.setText("今日已签到");
                }
            }
        }
        if (g.f5610b.t() != null) {
            ConfigModel t = g.f5610b.t();
            Integer valueOf = t != null ? Integer.valueOf(t.getGive_check_in_time()) : null;
            if (valueOf == null) {
                i.a();
            }
            if (valueOf.intValue() > 0) {
                TextView textView = (TextView) findViewById(R.id.tv_check_in_get_time);
                i.a((Object) textView, "tv_check_in_get_time");
                StringBuilder sb = new StringBuilder();
                sb.append("签到免费领取VIP服务");
                ConfigModel t2 = g.f5610b.t();
                sb.append(t2 != null ? Integer.valueOf(t2.getGive_check_in_time()) : null);
                sb.append("分钟");
                textView.setText(sb.toString());
                return;
            }
        }
        TextView textView2 = (TextView) findViewById(R.id.tv_check_in_get_time);
        i.a((Object) textView2, "tv_check_in_get_time");
        textView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CheckInDialog.kt */
    /* renamed from: com.speed.speed_library.widget.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class View$OnClickListenerC0157b implements View.OnClickListener {
        View$OnClickListenerC0157b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CheckInDialog.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.this.b();
        }
    }

    public final void b() {
        if (!com.speed.speed_library.business.e.f5632a.b()) {
            f.a("登录异常，请稍后再试", 0, 2, null);
            com.speed.speed_library.business.a.f5623a.f();
            return;
        }
        b.b.e<BaseModel<UserModel>> a2 = d.a.a.a.a.c.f6985a.a().b().b(b.b.h.a.d()).a(b.b.a.b.a.a());
        Context context = getContext();
        if (context == null) {
            i.a();
        }
        i.a((Object) context, "this.context!!");
        a2.a(new a(context));
    }

    /* compiled from: CheckInDialog.kt */
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
                try {
                    if (com.speed.speed_library.business.e.f5632a.b()) {
                        UserModel data = baseModel.getData();
                        UserModel j = g.f5610b.j();
                        String token = j != null ? j.getToken() : null;
                        if (token == null) {
                            i.a();
                        }
                        data.setToken(token);
                    }
                    g.f5610b.a(baseModel.getData());
                    org.greenrobot.eventbus.c.a().d(new UserInfoEvent());
                    Button button = (Button) b.this.findViewById(R.id.btn_checkin);
                    i.a((Object) button, "btn_checkin");
                    button.setEnabled(false);
                    Button button2 = (Button) b.this.findViewById(R.id.btn_checkin);
                    i.a((Object) button2, "btn_checkin");
                    button2.setText("今日已签到");
                    ((CheckInView) b.this.findViewById(R.id.checkInView)).a();
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    String a2 = com.speed.speed_library.utils.c.f5860a.a(System.currentTimeMillis() / 1000);
                    if (g.f5610b.h(a2) != null) {
                        ArrayList<Integer> h = g.f5610b.h(a2);
                        Integer valueOf = h != null ? Integer.valueOf(h.size()) : null;
                        if (valueOf == null) {
                            i.a();
                        }
                        if (valueOf.intValue() > 0 && (arrayList = g.f5610b.h(a2)) == null) {
                            i.a();
                        }
                    }
                    if (arrayList != null) {
                        arrayList.add(Integer.valueOf(com.speed.speed_library.widget.checkin.c.f5937a.d()));
                    }
                    g gVar = g.f5610b;
                    if (arrayList == null) {
                        i.a();
                    }
                    gVar.a(a2, arrayList);
                    b.this.dismiss();
                    if (!TextUtils.isEmpty(baseModel.getMsg())) {
                        String msg = baseModel.getMsg();
                        if (msg == null) {
                            i.a();
                        }
                        f.a(msg, 0, 2, null);
                        return;
                    }
                    f.a("签到成功", 0, 2, null);
                } catch (Exception unused) {
                }
            } else if (baseModel.getCode() == com.speed.speed_library.b.d.f5595a.n()) {
                ((CheckInView) b.this.findViewById(R.id.checkInView)).a();
                Button button3 = (Button) b.this.findViewById(R.id.btn_checkin);
                i.a((Object) button3, "btn_checkin");
                button3.setEnabled(false);
                Button button4 = (Button) b.this.findViewById(R.id.btn_checkin);
                i.a((Object) button4, "btn_checkin");
                button4.setText("今日已签到");
                b.this.dismiss();
            } else {
                Button button5 = (Button) b.this.findViewById(R.id.btn_checkin);
                i.a((Object) button5, "btn_checkin");
                button5.setEnabled(true);
                Button button6 = (Button) b.this.findViewById(R.id.btn_checkin);
                i.a((Object) button6, "btn_checkin");
                button6.setText("立即签到");
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            h.f5614a.a(th);
            Button button = (Button) b.this.findViewById(R.id.btn_checkin);
            i.a((Object) button, "btn_checkin");
            button.setEnabled(true);
            Button button2 = (Button) b.this.findViewById(R.id.btn_checkin);
            i.a((Object) button2, "btn_checkin");
            button2.setText("立即签到");
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.DialogAnimations);
            window.setBackgroundDrawableResource(17170445);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }
}
