package com.speed.speed_library.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.speed.speed_library.R;
import kotlin.d.b.i;

/* compiled from: ActivityImageDialog.kt */
/* loaded from: classes2.dex */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f5886a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        i.b(context, com.umeng.analytics.pro.d.R);
        a();
    }

    public void a() {
        requestWindowFeature(1);
        setContentView(R.layout.widget_dialog_activity);
        setCanceledOnTouchOutside(true);
        ImageView imageView = (ImageView) findViewById(R.id.cancel);
        i.a((Object) imageView, "cancel");
        this.f5886a = imageView;
        if (imageView == null) {
            i.b("cancelButton");
        }
        imageView.setOnClickListener(new View$OnClickListenerC0156a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityImageDialog.kt */
    /* renamed from: com.speed.speed_library.widget.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class View$OnClickListenerC0156a implements View.OnClickListener {
        View$OnClickListenerC0156a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.dismiss();
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        if (((ImageView) findViewById(R.id.iv_popup)) == null || onClickListener == null) {
            return;
        }
        ((ImageView) findViewById(R.id.iv_popup)).setOnClickListener(onClickListener);
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

    public final void a(Drawable drawable) {
        i.b(drawable, "bitmap");
        ((ImageView) findViewById(R.id.iv_popup)).setImageDrawable(drawable);
    }
}
