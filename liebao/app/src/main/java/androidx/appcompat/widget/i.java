package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* compiled from: AppCompatCheckedTextView.java */
/* loaded from: classes.dex */
public class i extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1078a = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final y f1079b;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(at.a(context), attributeSet, i);
        ar.a(this, getContext());
        y yVar = new y(this);
        this.f1079b = yVar;
        yVar.a(attributeSet, i);
        this.f1079b.b();
        aw a2 = aw.a(getContext(), attributeSet, f1078a, i, 0);
        setCheckMarkDrawable(a2.a(0));
        a2.b();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.f1079b;
        if (yVar != null) {
            yVar.a(context, i);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        y yVar = this.f1079b;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }
}
