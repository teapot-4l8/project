package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ag;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements ag {

    /* renamed from: a  reason: collision with root package name */
    private ag.a f876a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.ag
    public void setOnFitSystemWindowsListener(ag.a aVar) {
        this.f876a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        ag.a aVar = this.f876a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
