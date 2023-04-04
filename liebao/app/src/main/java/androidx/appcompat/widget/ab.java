package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* compiled from: AppCompatToggleButton.java */
/* loaded from: classes.dex */
public class ab extends ToggleButton {

    /* renamed from: a  reason: collision with root package name */
    private final y f935a;

    public ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ar.a(this, getContext());
        y yVar = new y(this);
        this.f935a = yVar;
        yVar.a(attributeSet, i);
    }
}
