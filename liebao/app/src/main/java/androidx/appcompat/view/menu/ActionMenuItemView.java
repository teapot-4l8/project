package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.ay;
import androidx.appcompat.widget.z;

/* loaded from: classes.dex */
public class ActionMenuItemView extends z implements View.OnClickListener, n.a, ActionMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    i f733a;

    /* renamed from: b  reason: collision with root package name */
    g.b f734b;

    /* renamed from: c  reason: collision with root package name */
    b f735c;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f736e;
    private Drawable f;
    private ah g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract p a();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.h = d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = d();
        e();
    }

    private boolean d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.k = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f733a;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void initialize(i iVar, int i) {
        this.f733a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.a((n.a) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.g == null) {
            this.g = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ah ahVar;
        if (this.f733a.hasSubMenu() && (ahVar = this.g) != null && ahVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f734b;
        if (bVar != null) {
            bVar.a(this.f733a);
        }
    }

    public void setItemInvoker(g.b bVar) {
        this.f734b = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.f735c = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.i != z) {
            this.i = z;
            i iVar = this.f733a;
            if (iVar != null) {
                iVar.h();
            }
        }
    }

    private void e() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f736e);
        if (this.f != null && (!this.f733a.m() || (!this.h && !this.i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f736e : null);
        CharSequence contentDescription = this.f733a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f733a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f733a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            ay.a(this, z3 ? null : this.f733a.getTitle());
        } else {
            ay.a(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.l;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            int i2 = this.l;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        e();
    }

    public boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f736e = charSequence;
        e();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return a() && this.f733a.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.z, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean a2 = a();
        if (a2 && (i4 = this.k) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(size, this.j);
        } else {
            i3 = this.j;
        }
        if (mode != 1073741824 && this.j > 0 && measuredWidth < i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
        if (a2 || this.f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* loaded from: classes.dex */
    private class a extends ah {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ah
        public p a() {
            if (ActionMenuItemView.this.f735c != null) {
                return ActionMenuItemView.this.f735c.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ah
        protected boolean b() {
            p a2;
            return ActionMenuItemView.this.f734b != null && ActionMenuItemView.this.f734b.a(ActionMenuItemView.this.f733a) && (a2 = a()) != null && a2.c();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
