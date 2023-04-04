package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.b;

/* compiled from: AppCompatSpinner.java */
/* loaded from: classes.dex */
public class w extends Spinner implements androidx.core.h.v {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1117c = {16843505};

    /* renamed from: a  reason: collision with root package name */
    int f1118a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f1119b;

    /* renamed from: d  reason: collision with root package name */
    private final f f1120d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f1121e;
    private ah f;
    private SpinnerAdapter g;
    private final boolean h;
    private e i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public interface e {
        CharSequence a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        void b();

        void b(int i);

        void c(int i);

        boolean c();

        Drawable d();

        int e();

        int f();
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public w(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r11 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
        r11.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (r11 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        this.f1119b = new Rect();
        ar.a(this, getContext());
        aw a2 = aw.a(context, attributeSet, R.styleable.Spinner, i, 0);
        this.f1120d = new f(this);
        if (theme != null) {
            this.f1121e = new androidx.appcompat.view.d(context, theme);
        } else {
            int g = a2.g(R.styleable.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f1121e = new androidx.appcompat.view.d(context, g);
            } else {
                this.f1121e = context;
            }
        }
        TypedArray typedArray2 = null;
        try {
            if (i2 == -1) {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, f1117c, i, 0);
                } catch (Exception e2) {
                    e = e2;
                    typedArray = null;
                } catch (Throwable th) {
                    th = th;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
                try {
                    i2 = typedArray.hasValue(0) ? typedArray.getInt(0, 0) : i2;
                } catch (Exception e3) {
                    e = e3;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                }
            }
            if (i2 == 0) {
                a aVar = new a();
                this.i = aVar;
                aVar.a(a2.d(R.styleable.Spinner_android_prompt));
            } else if (i2 == 1) {
                final c cVar = new c(this.f1121e, attributeSet, i);
                aw a3 = aw.a(this.f1121e, attributeSet, R.styleable.Spinner, i, 0);
                this.f1118a = a3.f(R.styleable.Spinner_android_dropDownWidth, -2);
                cVar.a(a3.a(R.styleable.Spinner_android_popupBackground));
                cVar.a(a2.d(R.styleable.Spinner_android_prompt));
                a3.b();
                this.i = cVar;
                this.f = new ah(this) { // from class: androidx.appcompat.widget.w.1
                    @Override // androidx.appcompat.widget.ah
                    public androidx.appcompat.view.menu.p a() {
                        return cVar;
                    }

                    @Override // androidx.appcompat.widget.ah
                    public boolean b() {
                        if (w.this.getInternalPopup().c()) {
                            return true;
                        }
                        w.this.a();
                        return true;
                    }
                };
            }
            CharSequence[] f = a2.f(R.styleable.Spinner_android_entries);
            if (f != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, f);
                arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                setAdapter((SpinnerAdapter) arrayAdapter);
            }
            a2.b();
            this.h = true;
            SpinnerAdapter spinnerAdapter = this.g;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.g = null;
            }
            this.f1120d.a(attributeSet, i);
        } catch (Throwable th2) {
            th = th2;
            typedArray2 = -1;
        }
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1121e;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        e eVar = this.i;
        if (eVar != null) {
            eVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        e eVar = this.i;
        if (eVar != null) {
            return eVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        e eVar = this.i;
        if (eVar != null) {
            eVar.a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        e eVar = this.i;
        if (eVar != null) {
            return eVar.e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        e eVar = this.i;
        if (eVar != null) {
            eVar.c(i);
            this.i.b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        e eVar = this.i;
        if (eVar != null) {
            return eVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.i != null) {
            this.f1118a = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.i != null) {
            return this.f1118a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.h) {
            this.g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.i != null) {
            Context context = this.f1121e;
            if (context == null) {
                context = getContext();
            }
            this.i.a(new b(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.i;
        if (eVar == null || !eVar.c()) {
            return;
        }
        this.i.b();
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ah ahVar = this.f;
        if (ahVar == null || !ahVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.i == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        e eVar = this.i;
        if (eVar != null) {
            if (eVar.c()) {
                return true;
            }
            a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        e eVar = this.i;
        if (eVar != null) {
            eVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        e eVar = this.i;
        return eVar != null ? eVar.a() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        f fVar = this.f1120d;
        if (fVar != null) {
            fVar.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1120d;
        if (fVar != null) {
            fVar.a(drawable);
        }
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1120d;
        if (fVar != null) {
            fVar.a(colorStateList);
        }
    }

    @Override // androidx.core.h.v
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1120d;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    @Override // androidx.core.h.v
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1120d;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // androidx.core.h.v
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1120d;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1120d;
        if (fVar != null) {
            fVar.c();
        }
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f1119b);
            return i2 + this.f1119b.left + this.f1119b.right;
        }
        return i2;
    }

    final e getInternalPopup() {
        return this.i;
    }

    void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.i.a(getTextDirection(), getTextAlignment());
        } else {
            this.i.a(-1, -1);
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        e eVar = this.i;
        dVar.f1138a = eVar != null && eVar.c();
        return dVar;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        if (!dVar.f1138a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.w.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!w.this.getInternalPopup().c()) {
                    w.this.a();
                }
                ViewTreeObserver viewTreeObserver2 = w.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver2.removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.appcompat.widget.w.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f1138a;

        d(Parcelable parcelable) {
            super(parcelable);
        }

        d(Parcel parcel) {
            super(parcel);
            this.f1138a = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f1138a ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    public static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f1129a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f1130b;

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1129a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1130b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof as) {
                    as asVar = (as) spinnerAdapter;
                    if (asVar.a() == null) {
                        asVar.a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1129a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f1129a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f1129a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1129a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1129a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1129a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1129a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1130b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1130b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener, e {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.app.b f1125a;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1127c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f1128d;

        @Override // androidx.appcompat.widget.w.e
        public Drawable d() {
            return null;
        }

        @Override // androidx.appcompat.widget.w.e
        public int e() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.e
        public int f() {
            return 0;
        }

        a() {
        }

        @Override // androidx.appcompat.widget.w.e
        public void b() {
            androidx.appcompat.app.b bVar = this.f1125a;
            if (bVar != null) {
                bVar.dismiss();
                this.f1125a = null;
            }
        }

        @Override // androidx.appcompat.widget.w.e
        public boolean c() {
            androidx.appcompat.app.b bVar = this.f1125a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.w.e
        public void a(ListAdapter listAdapter) {
            this.f1127c = listAdapter;
        }

        @Override // androidx.appcompat.widget.w.e
        public void a(CharSequence charSequence) {
            this.f1128d = charSequence;
        }

        @Override // androidx.appcompat.widget.w.e
        public CharSequence a() {
            return this.f1128d;
        }

        @Override // androidx.appcompat.widget.w.e
        public void a(int i, int i2) {
            if (this.f1127c == null) {
                return;
            }
            b.a aVar = new b.a(w.this.getPopupContext());
            CharSequence charSequence = this.f1128d;
            if (charSequence != null) {
                aVar.a(charSequence);
            }
            androidx.appcompat.app.b b2 = aVar.a(this.f1127c, w.this.getSelectedItemPosition(), this).b();
            this.f1125a = b2;
            ListView a2 = b2.a();
            if (Build.VERSION.SDK_INT >= 17) {
                a2.setTextDirection(i);
                a2.setTextAlignment(i2);
            }
            this.f1125a.show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            w.this.setSelection(i);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i, this.f1127c.getItemId(i));
            }
            b();
        }

        @Override // androidx.appcompat.widget.w.e
        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.e
        public void a(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.e
        public void b(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.e
        public void c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* loaded from: classes.dex */
    class c extends aj implements e {

        /* renamed from: a  reason: collision with root package name */
        ListAdapter f1131a;
        private CharSequence h;
        private final Rect i;
        private int j;

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.i = new Rect();
            b(w.this);
            a(true);
            d(0);
            a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.w.c.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    w.this.setSelection(i2);
                    if (w.this.getOnItemClickListener() != null) {
                        w.this.performItemClick(view, i2, c.this.f1131a.getItemId(i2));
                    }
                    c.this.b();
                }
            });
        }

        @Override // androidx.appcompat.widget.aj, androidx.appcompat.widget.w.e
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f1131a = listAdapter;
        }

        @Override // androidx.appcompat.widget.w.e
        public CharSequence a() {
            return this.h;
        }

        @Override // androidx.appcompat.widget.w.e
        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        void g() {
            int h;
            Drawable d2 = d();
            int i = 0;
            if (d2 != null) {
                d2.getPadding(w.this.f1119b);
                i = bc.a(w.this) ? w.this.f1119b.right : -w.this.f1119b.left;
            } else {
                Rect rect = w.this.f1119b;
                w.this.f1119b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = w.this.getPaddingLeft();
            int paddingRight = w.this.getPaddingRight();
            int width = w.this.getWidth();
            if (w.this.f1118a == -2) {
                int a2 = w.this.a((SpinnerAdapter) this.f1131a, d());
                int i2 = (w.this.getContext().getResources().getDisplayMetrics().widthPixels - w.this.f1119b.left) - w.this.f1119b.right;
                if (a2 > i2) {
                    a2 = i2;
                }
                h(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (w.this.f1118a == -1) {
                h((width - paddingLeft) - paddingRight);
            } else {
                h(w.this.f1118a);
            }
            if (bc.a(w.this)) {
                h = i + (((width - paddingRight) - k()) - h());
            } else {
                h = i + paddingLeft + h();
            }
            b(h);
        }

        @Override // androidx.appcompat.widget.w.e
        public void a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean c2 = c();
            g();
            i(2);
            super.b_();
            ListView c_ = c_();
            c_.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                c_.setTextDirection(i);
                c_.setTextAlignment(i2);
            }
            j(w.this.getSelectedItemPosition());
            if (c2 || (viewTreeObserver = w.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.w.c.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    c cVar = c.this;
                    if (!cVar.a(w.this)) {
                        c.this.b();
                        return;
                    }
                    c.this.g();
                    c.super.b_();
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.w.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = w.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        boolean a(View view) {
            return androidx.core.h.w.D(view) && view.getGlobalVisibleRect(this.i);
        }

        @Override // androidx.appcompat.widget.w.e
        public void c(int i) {
            this.j = i;
        }

        public int h() {
            return this.j;
        }
    }
}
