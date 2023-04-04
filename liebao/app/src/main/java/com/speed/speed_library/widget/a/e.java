package com.speed.speed_library.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.widget.bar.NumberProgressBar;
import kotlin.d.b.i;

/* compiled from: UpdateDialog.kt */
/* loaded from: classes2.dex */
public class e extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5906a;

    /* renamed from: b  reason: collision with root package name */
    public Button f5907b;

    /* renamed from: c  reason: collision with root package name */
    public NumberProgressBar f5908c;

    public final Button a() {
        Button button = this.f5907b;
        if (button == null) {
            i.b("udpateButton");
        }
        return button;
    }

    public final NumberProgressBar b() {
        NumberProgressBar numberProgressBar = this.f5908c;
        if (numberProgressBar == null) {
            i.b("progressBarView");
        }
        return numberProgressBar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        i.b(context, com.umeng.analytics.pro.d.R);
        c();
    }

    public void c() {
        requestWindowFeature(1);
        setContentView(R.layout.widget_dialog_update);
        TextView textView = (TextView) findViewById(R.id.content);
        i.a((Object) textView, "content");
        this.f5906a = textView;
        Button button = (Button) findViewById(R.id.confirm);
        i.a((Object) button, "confirm");
        this.f5907b = button;
        NumberProgressBar numberProgressBar = (NumberProgressBar) findViewById(R.id.progressbar_numbar);
        if (numberProgressBar == null) {
            throw new kotlin.i("null cannot be cast to non-null type com.speed.speed_library.widget.bar.NumberProgressBar");
        }
        this.f5908c = numberProgressBar;
    }

    public final void a(View.OnClickListener onClickListener) {
        Button button = this.f5907b;
        if (button == null) {
            i.b("udpateButton");
        }
        if (button == null || onClickListener == null) {
            return;
        }
        Button button2 = this.f5907b;
        if (button2 == null) {
            i.b("udpateButton");
        }
        button2.setOnClickListener(onClickListener);
    }

    public final void a(String str) {
        i.b(str, "content");
        TextView textView = this.f5906a;
        if (textView == null) {
            i.b("contentView");
        }
        textView.setText(str);
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
}
