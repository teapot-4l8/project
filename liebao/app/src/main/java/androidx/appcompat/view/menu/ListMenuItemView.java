package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.aw;
import androidx.core.h.w;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, n.a {

    /* renamed from: a  reason: collision with root package name */
    private i f741a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f742b;

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f743c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f744d;

    /* renamed from: e  reason: collision with root package name */
    private CheckBox f745e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private LayoutInflater p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f746q;

    @Override // androidx.appcompat.view.menu.n.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        aw a2 = aw.a(getContext(), attributeSet, R.styleable.MenuView, i, 0);
        this.j = a2.a(R.styleable.MenuView_android_itemBackground);
        this.k = a2.g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.m = a2.a(R.styleable.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = a2.a(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a2.b();
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        w.a(this, this.j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f744d = textView;
        int i = this.k;
        if (i != -1) {
            textView.setTextAppearance(this.l, i);
        }
        this.f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.h = (ImageView) findViewById(R.id.group_divider);
        this.i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void initialize(i iVar, int i) {
        this.f741a = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.a((n.a) this));
        setCheckable(iVar.isCheckable());
        a(iVar.f(), iVar.d());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i) {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.f746q = z;
        this.m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f744d.setText(charSequence);
            if (this.f744d.getVisibility() != 0) {
                this.f744d.setVisibility(0);
            }
        } else if (this.f744d.getVisibility() != 8) {
            this.f744d.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f741a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f743c == null && this.f745e == null) {
            return;
        }
        if (this.f741a.g()) {
            if (this.f743c == null) {
                b();
            }
            compoundButton = this.f743c;
            compoundButton2 = this.f745e;
        } else {
            if (this.f745e == null) {
                c();
            }
            compoundButton = this.f745e;
            compoundButton2 = this.f743c;
        }
        if (z) {
            compoundButton.setChecked(this.f741a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f745e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f743c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f741a.g()) {
            if (this.f743c == null) {
                b();
            }
            compoundButton = this.f743c;
        } else {
            if (this.f745e == null) {
                c();
            }
            compoundButton = this.f745e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z, char c2) {
        int i = (z && this.f741a.f()) ? 0 : 8;
        if (i == 0) {
            this.f.setText(this.f741a.e());
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f741a.i() || this.f746q;
        if (z || this.m) {
            if (this.f742b == null && drawable == null && !this.m) {
                return;
            }
            if (this.f742b == null) {
                a();
            }
            if (drawable != null || this.m) {
                ImageView imageView = this.f742b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f742b.getVisibility() != 0) {
                    this.f742b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f742b.setVisibility(8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f742b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f742b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void a() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f742b = imageView;
        a(imageView, 0);
    }

    private void b() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f743c = radioButton;
        a(radioButton);
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f745e = checkBox;
        a(checkBox);
    }

    private LayoutInflater getInflater() {
        if (this.p == null) {
            this.p = LayoutInflater.from(getContext());
        }
        return this.p;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
        rect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }
}
