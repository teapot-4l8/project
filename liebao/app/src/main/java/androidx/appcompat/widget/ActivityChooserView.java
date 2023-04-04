package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    final a f856a;

    /* renamed from: b  reason: collision with root package name */
    final FrameLayout f857b;

    /* renamed from: c  reason: collision with root package name */
    final FrameLayout f858c;

    /* renamed from: d  reason: collision with root package name */
    androidx.core.h.b f859d;

    /* renamed from: e  reason: collision with root package name */
    final DataSetObserver f860e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private aj n;
    private boolean o;
    private int p;

    public void setActivityChooserModel(d dVar) {
        this.f856a.a(dVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.k.setContentDescription(getContext().getString(i));
    }

    public void setProvider(androidx.core.h.b bVar) {
        this.f859d = bVar;
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    void a(int i) {
        if (this.f856a.d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        ?? r0 = this.f858c.getVisibility() == 0 ? 1 : 0;
        int c2 = this.f856a.c();
        if (i != Integer.MAX_VALUE && c2 > i + r0) {
            this.f856a.a(true);
            this.f856a.a(i - 1);
        } else {
            this.f856a.a(false);
            this.f856a.a(i);
        }
        aj listPopupWindow = getListPopupWindow();
        if (listPopupWindow.c()) {
            return;
        }
        if (this.g || r0 == 0) {
            this.f856a.a(true, r0);
        } else {
            this.f856a.a(false, false);
        }
        listPopupWindow.h(Math.min(this.f856a.a(), this.l));
        listPopupWindow.b_();
        androidx.core.h.b bVar = this.f859d;
        if (bVar != null) {
            bVar.a(true);
        }
        listPopupWindow.c_().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
        listPopupWindow.c_().setSelector(new ColorDrawable(0));
    }

    public boolean b() {
        if (c()) {
            getListPopupWindow().b();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.m);
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean c() {
        return getListPopupWindow().c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d d2 = this.f856a.d();
        if (d2 != null) {
            d2.registerObserver(this.f860e);
        }
        this.o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d d2 = this.f856a.d();
        if (d2 != null) {
            d2.unregisterObserver(this.f860e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.f858c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (c()) {
            return;
        }
        b();
    }

    public d getDataModel() {
        return this.f856a.d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.p = i;
    }

    aj getListPopupWindow() {
        if (this.n == null) {
            aj ajVar = new aj(getContext());
            this.n = ajVar;
            ajVar.a(this.f856a);
            this.n.b(this);
            this.n.a(true);
            this.n.a((AdapterView.OnItemClickListener) this.i);
            this.n.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f867a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    this.f867a.a(Integer.MAX_VALUE);
                    return;
                }
                throw new IllegalArgumentException();
            }
            this.f867a.b();
            if (this.f867a.g) {
                if (i > 0) {
                    this.f867a.f856a.d().c(i);
                    return;
                }
                return;
            }
            if (!this.f867a.f856a.e()) {
                i++;
            }
            Intent b2 = this.f867a.f856a.d().b(i);
            if (b2 != null) {
                b2.addFlags(524288);
                this.f867a.getContext().startActivity(b2);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.f867a.f858c) {
                this.f867a.b();
                Intent b2 = this.f867a.f856a.d().b(this.f867a.f856a.d().a(this.f867a.f856a.b()));
                if (b2 != null) {
                    b2.addFlags(524288);
                    this.f867a.getContext().startActivity(b2);
                }
            } else if (view == this.f867a.f857b) {
                this.f867a.g = false;
                ActivityChooserView activityChooserView = this.f867a;
                activityChooserView.a(activityChooserView.h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == this.f867a.f858c) {
                if (this.f867a.f856a.getCount() > 0) {
                    this.f867a.g = true;
                    ActivityChooserView activityChooserView = this.f867a;
                    activityChooserView.a(activityChooserView.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (this.f867a.f859d != null) {
                this.f867a.f859d.a(false);
            }
        }

        private void a() {
            if (this.f867a.f != null) {
                this.f867a.f.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f862a;

        /* renamed from: b  reason: collision with root package name */
        private d f863b;

        /* renamed from: c  reason: collision with root package name */
        private int f864c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f865d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f866e;
        private boolean f;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void a(d dVar) {
            d d2 = this.f862a.f856a.d();
            if (d2 != null && this.f862a.isShown()) {
                d2.unregisterObserver(this.f862a.f860e);
            }
            this.f863b = dVar;
            if (dVar != null && this.f862a.isShown()) {
                dVar.registerObserver(this.f862a.f860e);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int a2 = this.f863b.a();
            if (!this.f865d && this.f863b.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.f864c);
            return this.f ? min + 1 : min;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f865d && this.f863b.b() != null) {
                i++;
            }
            return this.f863b.a(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(this.f862a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(R.id.title)).setText(this.f862a.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                        return inflate;
                    }
                    return view;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != R.id.list_item) {
                view = LayoutInflater.from(this.f862a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = this.f862a.getContext().getPackageManager();
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f865d && i == 0 && this.f866e) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        public int a() {
            int i = this.f864c;
            this.f864c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f864c = i;
            return i2;
        }

        public void a(int i) {
            if (this.f864c != i) {
                this.f864c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.f863b.b();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public int c() {
            return this.f863b.a();
        }

        public d d() {
            return this.f863b;
        }

        public void a(boolean z, boolean z2) {
            if (this.f865d == z && this.f866e == z2) {
                return;
            }
            this.f865d = z;
            this.f866e = z2;
            notifyDataSetChanged();
        }

        public boolean e() {
            return this.f865d;
        }
    }

    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f861a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            aw a2 = aw.a(context, attributeSet, f861a);
            setBackgroundDrawable(a2.a(0));
            a2.b();
        }
    }
}
