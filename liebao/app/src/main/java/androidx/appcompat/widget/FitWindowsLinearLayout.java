package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.ag;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements ag {

    /* renamed from: a  reason: collision with root package name */
    private ag.a f877a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.ag
    public void setOnFitSystemWindowsListener(ag.a aVar) {
        this.f877a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        ag.a aVar = this.f877a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
