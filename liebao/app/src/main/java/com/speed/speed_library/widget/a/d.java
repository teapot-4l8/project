package com.speed.speed_library.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.speed.speed_library.R;
import kotlin.d.b.i;
import kotlin.d.b.j;
import kotlin.d.b.m;
import kotlin.d.b.o;
import kotlin.reflect.KProperty;

/* compiled from: NormalDialog.kt */
/* loaded from: classes2.dex */
public class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty[] f5899a = {o.a(new m(o.a(d.class), "buttonDividerView", "getButtonDividerView()Landroid/view/View;"))};

    /* renamed from: b  reason: collision with root package name */
    public TextView f5900b;

    /* renamed from: c  reason: collision with root package name */
    public Button f5901c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f5902d;

    /* renamed from: e  reason: collision with root package name */
    public Button f5903e;
    private final kotlin.b f;

    private final View c() {
        kotlin.b bVar = this.f;
        KProperty kProperty = f5899a[0];
        return (View) bVar.a();
    }

    /* compiled from: NormalDialog.kt */
    /* loaded from: classes2.dex */
    static final class a extends j implements kotlin.d.a.a<View> {
        a() {
            super(0);
        }

        @Override // kotlin.d.a.a
        /* renamed from: b */
        public final View a() {
            return d.this.findViewById(R.id.button_divider);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        i.b(context, com.umeng.analytics.pro.d.R);
        this.f = kotlin.c.a(new a());
        a();
    }

    public void a() {
        requestWindowFeature(1);
        setContentView(R.layout.widget_dialog_normal);
        setCanceledOnTouchOutside(true);
        TextView textView = (TextView) findViewById(R.id.title);
        i.a((Object) textView, "title");
        this.f5900b = textView;
        Button button = (Button) findViewById(R.id.confirm);
        i.a((Object) button, "confirm");
        this.f5901c = button;
        Button button2 = (Button) findViewById(R.id.cancel);
        i.a((Object) button2, "cancel");
        this.f5903e = button2;
        TextView textView2 = (TextView) findViewById(R.id.content);
        i.a((Object) textView2, "content");
        this.f5902d = textView2;
        Button button3 = this.f5903e;
        if (button3 == null) {
            i.b("cancelButton");
        }
        button3.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NormalDialog.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.dismiss();
        }
    }

    public void a(String str) {
        i.b(str, "title");
        TextView textView = this.f5900b;
        if (textView == null) {
            i.b("titleView");
        }
        textView.setText(str);
    }

    public void b(String str) {
        i.b(str, "content");
        TextView textView = this.f5902d;
        if (textView == null) {
            i.b("contentView");
        }
        textView.setText(str);
    }

    public void c(String str) {
        i.b(str, "text");
        Button button = this.f5901c;
        if (button == null) {
            i.b("confirmButton");
        }
        button.setText(str);
    }

    public final void a(View.OnClickListener onClickListener) {
        Button button = this.f5901c;
        if (button == null) {
            i.b("confirmButton");
        }
        if (button == null || onClickListener == null) {
            return;
        }
        Button button2 = this.f5901c;
        if (button2 == null) {
            i.b("confirmButton");
        }
        button2.setOnClickListener(onClickListener);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            i.a((Object) window, "it");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public final void b() {
        Button button = this.f5903e;
        if (button == null) {
            i.b("cancelButton");
        }
        button.setVisibility(8);
        View c2 = c();
        i.a((Object) c2, "buttonDividerView");
        c2.setVisibility(8);
    }
}
