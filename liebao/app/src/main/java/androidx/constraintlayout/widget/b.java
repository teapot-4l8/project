package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;

/* compiled from: ConstraintHelper.java */
/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f1368a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1369b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f1370c;

    /* renamed from: d  reason: collision with root package name */
    protected j f1371d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f1372e;
    private String f;

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public b(Context context) {
        super(context);
        this.f1368a = new int[32];
        this.f1372e = false;
        this.f1370c = context;
        a((AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f = string;
                    setIds(string);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1368a, this.f1369b);
    }

    public void setReferencedIds(int[] iArr) {
        this.f1369b = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        int i2 = this.f1369b + 1;
        int[] iArr = this.f1368a;
        if (i2 > iArr.length) {
            this.f1368a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1368a;
        int i3 = this.f1369b;
        iArr2[i3] = i;
        this.f1369b = i3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f1372e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void a() {
        if (this.f1371d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).al = this.f1371d;
        }
    }

    private void a(String str) {
        int i;
        Object a2;
        if (str == null || this.f1370c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i = R.id.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            i = this.f1370c.getResources().getIdentifier(trim, "id", this.f1370c.getPackageName());
        }
        if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
            i = ((Integer) a2).intValue();
        }
        if (i != 0) {
            setTag(i, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f);
        }
        j jVar = this.f1371d;
        if (jVar == null) {
            return;
        }
        jVar.J();
        for (int i = 0; i < this.f1369b; i++) {
            View a2 = constraintLayout.a(this.f1368a[i]);
            if (a2 != null) {
                this.f1371d.b(constraintLayout.a(a2));
            }
        }
    }
}
