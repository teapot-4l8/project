package com.lxj.xpopup.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.lxj.xpopup.a.g;
import com.lxj.xpopup.b.d;
import com.lxj.xpopup.g.c;

/* compiled from: FullScreenPopupView.java */
/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    Paint f5481b;

    /* renamed from: c  reason: collision with root package name */
    Rect f5482c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.d, com.lxj.xpopup.b.b
    public int getMaxWidth() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.d, com.lxj.xpopup.b.b
    public void a() {
        super.a();
        this.k.f5446e = false;
    }

    @Override // com.lxj.xpopup.b.b, com.lxj.xpopup.g.a.c
    public void a(boolean z) {
        if (!z) {
            e();
            getPopupContentView().setPadding(0, 0, 0, 0);
            return;
        }
        b(true);
    }

    @Override // com.lxj.xpopup.b.b
    protected void b(boolean z) {
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        View popupContentView = getPopupContentView();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) popupContentView.getLayoutParams();
        layoutParams.gravity = 48;
        popupContentView.setLayoutParams(layoutParams);
        int b2 = (z || c.c(getContext())) ? c.b() : 0;
        if (rotation == 0) {
            popupContentView.setPadding(popupContentView.getPaddingLeft(), popupContentView.getPaddingTop(), popupContentView.getPaddingRight(), b2);
        } else if (rotation == 1 || rotation == 3) {
            popupContentView.setPadding(popupContentView.getPaddingLeft(), popupContentView.getPaddingTop(), popupContentView.getPaddingRight(), 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.k.r.booleanValue()) {
            this.f5481b.setColor(com.lxj.xpopup.a.f5367a);
            Rect rect = new Rect(0, 0, c.a(getContext()), c.a());
            this.f5482c = rect;
            canvas.drawRect(rect, this.f5481b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.d, com.lxj.xpopup.b.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5481b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.d, com.lxj.xpopup.b.b
    public com.lxj.xpopup.a.b getPopupAnimator() {
        return new g(getPopupContentView(), com.lxj.xpopup.c.c.TranslateFromBottom);
    }
}
