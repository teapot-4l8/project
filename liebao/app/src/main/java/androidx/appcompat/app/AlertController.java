package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.ai;
import androidx.core.h.w;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    private int A;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;

    /* renamed from: a  reason: collision with root package name */
    final g f535a;

    /* renamed from: b  reason: collision with root package name */
    ListView f536b;

    /* renamed from: c  reason: collision with root package name */
    Button f537c;

    /* renamed from: d  reason: collision with root package name */
    Message f538d;

    /* renamed from: e  reason: collision with root package name */
    Button f539e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int l;
    int m;
    int n;
    int o;
    Handler p;

    /* renamed from: q  reason: collision with root package name */
    private final Context f540q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;
    private boolean B = false;
    private int I = 0;
    int k = -1;
    private int R = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            if (view == AlertController.this.f537c && AlertController.this.f538d != null) {
                obtain = Message.obtain(AlertController.this.f538d);
            } else if (view == AlertController.this.f539e && AlertController.this.f != null) {
                obtain = Message.obtain(AlertController.this.f);
            } else {
                obtain = (view != AlertController.this.g || AlertController.this.h == null) ? null : Message.obtain(AlertController.this.h);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController.this.p.obtainMessage(1, AlertController.this.f535a).sendToTarget();
        }
    };

    /* loaded from: classes.dex */
    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f574a;

        public b(DialogInterface dialogInterface) {
            this.f574a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f574a.get(), message.what);
            } else if (i != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public AlertController(Context context, g gVar, Window window) {
        this.f540q = context;
        this.f535a = gVar;
        this.r = window;
        this.p = new b(gVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.P = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.n = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.o = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.Q = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        gVar.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void a() {
        this.f535a.setContentView(c());
        d();
    }

    private int c() {
        int i = this.P;
        if (i == 0) {
            return this.O;
        }
        return this.R == 1 ? i : this.O;
    }

    public void a(CharSequence charSequence) {
        this.t = charSequence;
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.u = charSequence;
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a(int i) {
        this.v = null;
        this.w = i;
        this.B = false;
    }

    public void c(View view) {
        this.v = view;
        this.w = 0;
        this.B = false;
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.v = view;
        this.w = 0;
        this.B = true;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.p.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.G = charSequence;
            this.h = message;
            this.H = drawable;
        } else if (i == -2) {
            this.E = charSequence;
            this.f = message;
            this.F = drawable;
        } else if (i == -1) {
            this.C = charSequence;
            this.f538d = message;
            this.D = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void b(int i) {
        this.J = null;
        this.I = i;
        ImageView imageView = this.K;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.K.setImageResource(this.I);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public void a(Drawable drawable) {
        this.J = drawable;
        this.I = 0;
        ImageView imageView = this.K;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.K.setImageDrawable(drawable);
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f540q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView b() {
        return this.f536b;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public boolean b(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.i;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.r.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        a(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        c(a3);
        d(a4);
        b(a2);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a2 == null || a2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z3 && a3 != null && (findViewById2 = a3.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.i;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (this.u != null || this.f536b != null) {
                view = a2.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (a3 != null && (findViewById = a3.findViewById(R.id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f536b;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view2 = this.f536b;
            if (view2 == null) {
                view2 = this.i;
            }
            if (view2 != null) {
                a(a3, view2, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f536b;
        if (listView2 == null || (listAdapter = this.j) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i = this.k;
        if (i > -1) {
            listView2.setItemChecked(i, true);
            listView2.setSelection(i);
        }
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.r.findViewById(R.id.scrollIndicatorUp);
        final View findViewById2 = this.r.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            w.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById == null && findViewById2 == null) {
            return;
        }
        if (this.u != null) {
            this.i.setOnScrollChangeListener(new NestedScrollView.b() { // from class: androidx.appcompat.app.AlertController.2
                @Override // androidx.core.widget.NestedScrollView.b
                public void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    AlertController.a(nestedScrollView, findViewById, findViewById2);
                }
            });
            this.i.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.i, findViewById, findViewById2);
                }
            });
            return;
        }
        ListView listView = this.f536b;
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.appcompat.app.AlertController.4
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i3) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                    AlertController.a(absListView, findViewById, findViewById2);
                }
            });
            this.f536b.post(new Runnable() { // from class: androidx.appcompat.app.AlertController.5
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.a(AlertController.this.f536b, findViewById, findViewById2);
                }
            });
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void a(ViewGroup viewGroup) {
        View view = this.v;
        if (view == null) {
            view = this.w != 0 ? LayoutInflater.from(this.f540q).inflate(this.w, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !a(view)) {
            this.r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.r.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.B) {
                frameLayout.setPadding(this.x, this.y, this.z, this.A);
            }
            if (this.f536b != null) {
                ((ai.a) viewGroup.getLayoutParams()).g = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            viewGroup.addView(this.N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.r.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView) this.r.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.t)) && this.Q) {
            TextView textView = (TextView) this.r.findViewById(R.id.alertTitle);
            this.L = textView;
            textView.setText(this.t);
            int i = this.I;
            if (i != 0) {
                this.K.setImageResource(i);
                return;
            }
            Drawable drawable = this.J;
            if (drawable != null) {
                this.K.setImageDrawable(drawable);
                return;
            }
            this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
            this.K.setVisibility(8);
            return;
        }
        this.r.findViewById(R.id.title_template).setVisibility(8);
        this.K.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void c(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.r.findViewById(R.id.scrollView);
        this.i = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.M = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.u;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.i.removeView(this.M);
        if (this.f536b != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.i);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f536b, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private void d(ViewGroup viewGroup) {
        boolean z;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f537c = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.C) && this.D == null) {
            this.f537c.setVisibility(8);
            z = false;
        } else {
            this.f537c.setText(this.C);
            Drawable drawable = this.D;
            if (drawable != null) {
                int i = this.s;
                drawable.setBounds(0, 0, i, i);
                this.f537c.setCompoundDrawables(this.D, null, null, null);
            }
            this.f537c.setVisibility(0);
            z = true;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f539e = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.E) && this.F == null) {
            this.f539e.setVisibility(8);
        } else {
            this.f539e.setText(this.E);
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                int i2 = this.s;
                drawable2.setBounds(0, 0, i2, i2);
                this.f539e.setCompoundDrawables(this.F, null, null, null);
            }
            this.f539e.setVisibility(0);
            z |= true;
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.g = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.G) && this.H == null) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(this.G);
            Drawable drawable3 = this.H;
            if (drawable3 != null) {
                int i3 = this.s;
                drawable3.setBounds(0, 0, i3, i3);
                this.g.setCompoundDrawables(this.H, null, null, null);
            }
            this.g.setVisibility(0);
            z |= true;
        }
        if (a(this.f540q)) {
            if (z) {
                a(this.f537c);
            } else if (z) {
                a(this.f539e);
            } else if (z) {
                a(this.g);
            }
        }
        if (z) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f554a;

        /* renamed from: b  reason: collision with root package name */
        private final int f555b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f555b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f554a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f554a, getPaddingRight(), z2 ? getPaddingBottom() : this.f555b);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public InterfaceC0019a O;

        /* renamed from: a  reason: collision with root package name */
        public final Context f556a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f557b;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f559d;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f561q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* renamed from: c  reason: collision with root package name */
        public int f558c = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f560e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;
        public boolean r = true;

        /* renamed from: androidx.appcompat.app.AlertController$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0019a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.f556a = context;
            this.f557b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.g;
            if (view != null) {
                alertController.b(view);
            } else {
                CharSequence charSequence = this.f;
                if (charSequence != null) {
                    alertController.a(charSequence);
                }
                Drawable drawable = this.f559d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i = this.f558c;
                if (i != 0) {
                    alertController.b(i);
                }
                int i2 = this.f560e;
                if (i2 != 0) {
                    alertController.b(alertController.c(i2));
                }
            }
            CharSequence charSequence2 = this.h;
            if (charSequence2 != null) {
                alertController.b(charSequence2);
            }
            if (this.i != null || this.j != null) {
                alertController.a(-1, this.i, this.k, (Message) null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.f561q, (Message) null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.a(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.c(view2);
                    return;
                }
            }
            int i3 = this.y;
            if (i3 != 0) {
                alertController.a(i3);
            }
        }

        private void b(final AlertController alertController) {
            int i;
            ListAdapter listAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.f557b.inflate(alertController.l, (ViewGroup) null);
            if (this.G) {
                if (this.K == null) {
                    listAdapter = new ArrayAdapter<CharSequence>(this.f556a, alertController.m, 16908308, this.v) { // from class: androidx.appcompat.app.AlertController.a.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i2, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i2, view, viewGroup);
                            if (a.this.F != null && a.this.F[i2]) {
                                recycleListView.setItemChecked(i2, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    listAdapter = new CursorAdapter(this.f556a, this.K, false) { // from class: androidx.appcompat.app.AlertController.a.2

                        /* renamed from: d  reason: collision with root package name */
                        private final int f567d;

                        /* renamed from: e  reason: collision with root package name */
                        private final int f568e;

                        {
                            Cursor cursor = getCursor();
                            this.f567d = cursor.getColumnIndexOrThrow(a.this.L);
                            this.f568e = cursor.getColumnIndexOrThrow(a.this.M);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f567d));
                            recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f568e) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return a.this.f557b.inflate(alertController.m, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.H) {
                    i = alertController.n;
                } else {
                    i = alertController.o;
                }
                int i2 = i;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f556a, i2, this.K, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.w;
                    if (listAdapter == null) {
                        listAdapter = new c(this.f556a, i2, 16908308, this.v);
                    }
                }
            }
            InterfaceC0019a interfaceC0019a = this.O;
            if (interfaceC0019a != null) {
                interfaceC0019a.a(recycleListView);
            }
            alertController.j = listAdapter;
            alertController.k = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        a.this.x.onClick(alertController.f535a, i3);
                        if (a.this.H) {
                            return;
                        }
                        alertController.f535a.dismiss();
                    }
                });
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.a.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                        if (a.this.F != null) {
                            a.this.F[i3] = recycleListView.isItemChecked(i3);
                        }
                        a.this.J.onClick(alertController.f535a, i3, recycleListView.isItemChecked(i3));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f536b = recycleListView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }
}
