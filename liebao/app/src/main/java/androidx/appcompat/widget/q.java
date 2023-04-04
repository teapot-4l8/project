package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;

/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
class q extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1102a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1103b;

    static {
        f1102a = Build.VERSION.SDK_INT < 21;
    }

    public q(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        aw a2 = aw.a(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (a2.g(R.styleable.PopupWindow_overlapAnchor)) {
            a(a2.a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.a(R.styleable.PopupWindow_android_popupBackground));
        a2.b();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f1102a && this.f1103b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1102a && this.f1103b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f1102a && this.f1103b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    private void a(boolean z) {
        if (f1102a) {
            this.f1103b = z;
        } else {
            androidx.core.widget.h.a(this, z);
        }
    }
}
