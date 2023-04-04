package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ag;
import androidx.appcompat.widget.aw;
import androidx.appcompat.widget.bb;
import androidx.appcompat.widget.bc;
import androidx.core.content.b.f;
import androidx.core.h.aa;
import androidx.core.h.ab;
import androidx.core.h.ae;
import androidx.core.h.f;
import androidx.core.h.s;
import androidx.core.h.w;
import androidx.lifecycle.h;
import com.google.android.gms.ads.AdRequest;
import java.lang.Thread;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public class f extends androidx.appcompat.app.e implements LayoutInflater.Factory2, g.a {
    private static final androidx.b.g<String, Integer> u = new androidx.b.g<>();
    private static final boolean v;
    private static final int[] w;
    private static final boolean x;
    private static final boolean y;
    private static boolean z;
    private c A;
    private CharSequence B;
    private ac C;
    private a D;
    private m E;
    private boolean F;
    private boolean G;
    private TextView H;
    private View I;
    private boolean J;
    private boolean K;
    private boolean L;
    private l[] M;
    private l N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private e W;
    private e X;
    private final Runnable Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    final Object f582a;
    private Rect aa;
    private Rect ab;
    private androidx.appcompat.app.i ac;

    /* renamed from: b  reason: collision with root package name */
    final Context f583b;

    /* renamed from: c  reason: collision with root package name */
    Window f584c;

    /* renamed from: d  reason: collision with root package name */
    final androidx.appcompat.app.d f585d;

    /* renamed from: e  reason: collision with root package name */
    androidx.appcompat.app.a f586e;
    MenuInflater f;
    androidx.appcompat.view.b g;
    ActionBarContextView h;
    PopupWindow i;
    Runnable j;
    aa k;
    ViewGroup l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;

    /* renamed from: q  reason: collision with root package name */
    boolean f587q;
    boolean r;
    boolean s;
    int t;

    void a(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public void c(Bundle bundle) {
    }

    static {
        v = Build.VERSION.SDK_INT < 21;
        w = new int[]{16842836};
        x = !"robolectric".equals(Build.FINGERPRINT);
        y = Build.VERSION.SDK_INT >= 17;
        if (!v || z) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.f.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (a(th)) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                    return;
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }

            private boolean a(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }
        });
        z = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    private f(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        Integer num;
        androidx.appcompat.app.c A;
        this.k = null;
        this.F = true;
        this.S = -100;
        this.Y = new Runnable() { // from class: androidx.appcompat.app.f.2
            @Override // java.lang.Runnable
            public void run() {
                if ((f.this.t & 1) != 0) {
                    f.this.h(0);
                }
                if ((f.this.t & 4096) != 0) {
                    f.this.h(108);
                }
                f.this.s = false;
                f.this.t = 0;
            }
        };
        this.f583b = context;
        this.f585d = dVar;
        this.f582a = obj;
        if (this.S == -100 && (obj instanceof Dialog) && (A = A()) != null) {
            this.S = A.h().i();
        }
        if (this.S == -100 && (num = u.get(this.f582a.getClass().getName())) != null) {
            this.S = num.intValue();
            u.remove(this.f582a.getClass().getName());
        }
        if (window != null) {
            a(window);
        }
        androidx.appcompat.widget.k.a();
    }

    @Override // androidx.appcompat.app.e
    public Context b(Context context) {
        this.P = true;
        int a2 = a(context, C());
        if (y && (context instanceof ContextThemeWrapper)) {
            try {
                j.a((ContextThemeWrapper) context, a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!x) {
            return super.b(context);
        }
        try {
            Configuration configuration = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
            Configuration configuration2 = context.getResources().getConfiguration();
            Configuration a3 = a(context, a2, configuration.equals(configuration2) ? null : a(configuration, configuration2));
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, R.style.Theme_AppCompat_Empty);
            dVar.a(a3);
            boolean z2 = false;
            try {
                z2 = context.getTheme() != null;
            } catch (NullPointerException unused3) {
            }
            if (z2) {
                f.b.a(dVar.getTheme());
            }
            return super.b(dVar);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Application failed to obtain resources from itself", e2);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    private static class j {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(Bundle bundle) {
        this.P = true;
        b(false);
        w();
        Object obj = this.f582a;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.g.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                androidx.appcompat.app.a k2 = k();
                if (k2 == null) {
                    this.Z = true;
                } else {
                    k2.d(true);
                }
            }
            a(this);
        }
        this.Q = true;
    }

    @Override // androidx.appcompat.app.e
    public void b(Bundle bundle) {
        x();
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a a() {
        u();
        return this.f586e;
    }

    final androidx.appcompat.app.a k() {
        return this.f586e;
    }

    final Window.Callback l() {
        return this.f584c.getCallback();
    }

    private void u() {
        x();
        if (this.m && this.f586e == null) {
            Object obj = this.f582a;
            if (obj instanceof Activity) {
                this.f586e = new n((Activity) this.f582a, this.n);
            } else if (obj instanceof Dialog) {
                this.f586e = new n((Dialog) this.f582a);
            }
            androidx.appcompat.app.a aVar = this.f586e;
            if (aVar != null) {
                aVar.d(this.Z);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(Toolbar toolbar) {
        if (this.f582a instanceof Activity) {
            androidx.appcompat.app.a a2 = a();
            if (a2 instanceof n) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f = null;
            if (a2 != null) {
                a2.g();
            }
            if (toolbar != null) {
                androidx.appcompat.app.k kVar = new androidx.appcompat.app.k(toolbar, n(), this.A);
                this.f586e = kVar;
                this.f584c.setCallback(kVar.h());
            } else {
                this.f586e = null;
                this.f584c.setCallback(this.A);
            }
            f();
        }
    }

    final Context m() {
        androidx.appcompat.app.a a2 = a();
        Context b2 = a2 != null ? a2.b() : null;
        return b2 == null ? this.f583b : b2;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater b() {
        if (this.f == null) {
            u();
            androidx.appcompat.app.a aVar = this.f586e;
            this.f = new androidx.appcompat.view.g(aVar != null ? aVar.b() : this.f583b);
        }
        return this.f;
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T b(int i2) {
        x();
        return (T) this.f584c.findViewById(i2);
    }

    @Override // androidx.appcompat.app.e
    public void a(Configuration configuration) {
        androidx.appcompat.app.a a2;
        if (this.m && this.G && (a2 = a()) != null) {
            a2.a(configuration);
        }
        androidx.appcompat.widget.k.b().a(this.f583b);
        b(false);
    }

    @Override // androidx.appcompat.app.e
    public void c() {
        this.R = true;
        t();
    }

    @Override // androidx.appcompat.app.e
    public void d() {
        this.R = false;
        androidx.appcompat.app.a a2 = a();
        if (a2 != null) {
            a2.e(false);
        }
    }

    @Override // androidx.appcompat.app.e
    public void e() {
        androidx.appcompat.app.a a2 = a();
        if (a2 != null) {
            a2.e(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(View view) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.A.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void c(int i2) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f583b).inflate(i2, viewGroup);
        this.A.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ViewGroup viewGroup = (ViewGroup) this.l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.A.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        x();
        ((ViewGroup) this.l.findViewById(16908290)).addView(view, layoutParams);
        this.A.a().onContentChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    @Override // androidx.appcompat.app.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        androidx.appcompat.app.a aVar;
        if (this.f582a instanceof Activity) {
            b(this);
        }
        if (this.s) {
            this.f584c.getDecorView().removeCallbacks(this.Y);
        }
        this.R = false;
        this.r = true;
        if (this.S != -100) {
            Object obj = this.f582a;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                u.put(this.f582a.getClass().getName(), Integer.valueOf(this.S));
                aVar = this.f586e;
                if (aVar != null) {
                    aVar.g();
                }
                v();
            }
        }
        u.remove(this.f582a.getClass().getName());
        aVar = this.f586e;
        if (aVar != null) {
        }
        v();
    }

    private void v() {
        e eVar = this.W;
        if (eVar != null) {
            eVar.e();
        }
        e eVar2 = this.X;
        if (eVar2 != null) {
            eVar2.e();
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(int i2) {
        this.T = i2;
    }

    private void w() {
        if (this.f584c == null) {
            Object obj = this.f582a;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.f584c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void a(Window window) {
        if (this.f584c != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        c cVar = new c(callback);
        this.A = cVar;
        window.setCallback(cVar);
        aw a2 = aw.a(this.f583b, (AttributeSet) null, w);
        Drawable b2 = a2.b(0);
        if (b2 != null) {
            window.setBackgroundDrawable(b2);
        }
        a2.b();
        this.f584c = window;
    }

    private void x() {
        if (this.G) {
            return;
        }
        this.l = y();
        CharSequence n = n();
        if (!TextUtils.isEmpty(n)) {
            ac acVar = this.C;
            if (acVar != null) {
                acVar.setWindowTitle(n);
            } else if (k() != null) {
                k().a(n);
            } else {
                TextView textView = this.H;
                if (textView != null) {
                    textView.setText(n);
                }
            }
        }
        z();
        a(this.l);
        this.G = true;
        l a2 = a(0, false);
        if (this.r) {
            return;
        }
        if (a2 == null || a2.j == null) {
            i(108);
        }
    }

    private ViewGroup y() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f583b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
            d(1);
        } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
            d(108);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            d(109);
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            d(10);
        }
        this.p = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        obtainStyledAttributes.recycle();
        w();
        this.f584c.getDecorView();
        LayoutInflater from = LayoutInflater.from(this.f583b);
        if (!this.f587q) {
            if (this.p) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.n = false;
                this.m = false;
            } else if (this.m) {
                TypedValue typedValue = new TypedValue();
                this.f583b.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new androidx.appcompat.view.d(this.f583b, typedValue.resourceId);
                } else {
                    context = this.f583b;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                ac acVar = (ac) viewGroup.findViewById(R.id.decor_content_parent);
                this.C = acVar;
                acVar.setWindowCallback(l());
                if (this.n) {
                    this.C.a(109);
                }
                if (this.J) {
                    this.C.a(2);
                }
                if (this.K) {
                    this.C.a(5);
                }
            } else {
                viewGroup = null;
            }
        } else {
            viewGroup = this.o ? (ViewGroup) from.inflate(R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(R.layout.abc_screen_simple, (ViewGroup) null);
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.m + ", windowActionBarOverlay: " + this.n + ", android:windowIsFloating: " + this.p + ", windowActionModeOverlay: " + this.o + ", windowNoTitle: " + this.f587q + " }");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            w.a(viewGroup, new s() { // from class: androidx.appcompat.app.f.3
                @Override // androidx.core.h.s
                public ae onApplyWindowInsets(View view, ae aeVar) {
                    int b2 = aeVar.b();
                    int a2 = f.this.a(aeVar, (Rect) null);
                    if (b2 != a2) {
                        aeVar = aeVar.a(aeVar.a(), a2, aeVar.c(), aeVar.d());
                    }
                    return w.a(view, aeVar);
                }
            });
        } else if (viewGroup instanceof ag) {
            ((ag) viewGroup).setOnFitSystemWindowsListener(new ag.a() { // from class: androidx.appcompat.app.f.4
                @Override // androidx.appcompat.widget.ag.a
                public void a(Rect rect) {
                    rect.top = f.this.a((ae) null, rect);
                }
            });
        }
        if (this.C == null) {
            this.H = (TextView) viewGroup.findViewById(R.id.title);
        }
        bc.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f584c.findViewById(16908290);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(16908290);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f584c.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() { // from class: androidx.appcompat.app.f.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void a() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void b() {
                f.this.s();
            }
        });
        return viewGroup;
    }

    private void z() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.l.findViewById(16908290);
        View decorView = this.f584c.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f583b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // androidx.appcompat.app.e
    public boolean d(int i2) {
        int j2 = j(i2);
        if (this.f587q && j2 == 108) {
            return false;
        }
        if (this.m && j2 == 1) {
            this.m = false;
        }
        if (j2 == 1) {
            B();
            this.f587q = true;
            return true;
        } else if (j2 == 2) {
            B();
            this.J = true;
            return true;
        } else if (j2 == 5) {
            B();
            this.K = true;
            return true;
        } else if (j2 == 10) {
            B();
            this.o = true;
            return true;
        } else if (j2 == 108) {
            B();
            this.m = true;
            return true;
        } else if (j2 == 109) {
            B();
            this.n = true;
            return true;
        } else {
            return this.f584c.requestFeature(j2);
        }
    }

    @Override // androidx.appcompat.app.e
    public final void a(CharSequence charSequence) {
        this.B = charSequence;
        ac acVar = this.C;
        if (acVar != null) {
            acVar.setWindowTitle(charSequence);
        } else if (k() != null) {
            k().a(charSequence);
        } else {
            TextView textView = this.H;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    final CharSequence n() {
        Object obj = this.f582a;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.B;
    }

    void e(int i2) {
        if (i2 == 108) {
            androidx.appcompat.app.a a2 = a();
            if (a2 != null) {
                a2.f(false);
            }
        } else if (i2 == 0) {
            l a3 = a(i2, true);
            if (a3.o) {
                a(a3, false);
            }
        }
    }

    void f(int i2) {
        androidx.appcompat.app.a a2;
        if (i2 != 108 || (a2 = a()) == null) {
            return;
        }
        a2.f(true);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        l a2;
        Window.Callback l2 = l();
        if (l2 == null || this.r || (a2 = a((Menu) gVar.getRootMenu())) == null) {
            return false;
        }
        return l2.onMenuItemSelected(a2.f609a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
        a(true);
    }

    public androidx.appcompat.view.b a(b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.g;
        if (bVar != null) {
            bVar.c();
        }
        b bVar2 = new b(aVar);
        androidx.appcompat.app.a a2 = a();
        if (a2 != null) {
            androidx.appcompat.view.b a3 = a2.a(bVar2);
            this.g = a3;
            if (a3 != null && (dVar = this.f585d) != null) {
                dVar.onSupportActionModeStarted(a3);
            }
        }
        if (this.g == null) {
            this.g = b(bVar2);
        }
        return this.g;
    }

    @Override // androidx.appcompat.app.e
    public void f() {
        androidx.appcompat.app.a a2 = a();
        if (a2 == null || !a2.e()) {
            i(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    androidx.appcompat.view.b b(b.a aVar) {
        androidx.appcompat.view.b bVar;
        Context context;
        androidx.appcompat.view.b bVar2;
        androidx.appcompat.app.d dVar;
        q();
        androidx.appcompat.view.b bVar3 = this.g;
        if (bVar3 != null) {
            bVar3.c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(aVar);
        }
        androidx.appcompat.app.d dVar2 = this.f585d;
        if (dVar2 != null && !this.r) {
            try {
                bVar = dVar2.onWindowStartingSupportActionMode(aVar);
            } catch (AbstractMethodError unused) {
            }
            if (bVar == null) {
                this.g = bVar;
            } else {
                if (this.h == null) {
                    if (this.p) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = this.f583b.getTheme();
                        theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme newTheme = this.f583b.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            context = new androidx.appcompat.view.d(this.f583b, 0);
                            context.getTheme().setTo(newTheme);
                        } else {
                            context = this.f583b;
                        }
                        this.h = new ActionBarContextView(context);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                        this.i = popupWindow;
                        androidx.core.widget.h.a(popupWindow, 2);
                        this.i.setContentView(this.h);
                        this.i.setWidth(-1);
                        context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                        this.h.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.i.setHeight(-2);
                        this.j = new Runnable() { // from class: androidx.appcompat.app.f.6
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.i.showAtLocation(f.this.h, 55, 0, 0);
                                f.this.q();
                                if (f.this.o()) {
                                    f.this.h.setAlpha(0.0f);
                                    f fVar = f.this;
                                    fVar.k = w.m(fVar.h).a(1.0f);
                                    f.this.k.a(new androidx.core.h.ac() { // from class: androidx.appcompat.app.f.6.1
                                        @Override // androidx.core.h.ac, androidx.core.h.ab
                                        public void a(View view) {
                                            f.this.h.setVisibility(0);
                                        }

                                        @Override // androidx.core.h.ac, androidx.core.h.ab
                                        public void b(View view) {
                                            f.this.h.setAlpha(1.0f);
                                            f.this.k.a((ab) null);
                                            f.this.k = null;
                                        }
                                    });
                                    return;
                                }
                                f.this.h.setAlpha(1.0f);
                                f.this.h.setVisibility(0);
                            }
                        };
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.l.findViewById(R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(m()));
                            this.h = (ActionBarContextView) viewStubCompat.a();
                        }
                    }
                }
                if (this.h != null) {
                    q();
                    this.h.c();
                    androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(this.h.getContext(), this.h, aVar, this.i == null);
                    if (aVar.a(eVar, eVar.b())) {
                        eVar.d();
                        this.h.a(eVar);
                        this.g = eVar;
                        if (o()) {
                            this.h.setAlpha(0.0f);
                            aa a2 = w.m(this.h).a(1.0f);
                            this.k = a2;
                            a2.a(new androidx.core.h.ac() { // from class: androidx.appcompat.app.f.7
                                @Override // androidx.core.h.ac, androidx.core.h.ab
                                public void a(View view) {
                                    f.this.h.setVisibility(0);
                                    f.this.h.sendAccessibilityEvent(32);
                                    if (f.this.h.getParent() instanceof View) {
                                        w.r((View) f.this.h.getParent());
                                    }
                                }

                                @Override // androidx.core.h.ac, androidx.core.h.ab
                                public void b(View view) {
                                    f.this.h.setAlpha(1.0f);
                                    f.this.k.a((ab) null);
                                    f.this.k = null;
                                }
                            });
                        } else {
                            this.h.setAlpha(1.0f);
                            this.h.setVisibility(0);
                            this.h.sendAccessibilityEvent(32);
                            if (this.h.getParent() instanceof View) {
                                w.r((View) this.h.getParent());
                            }
                        }
                        if (this.i != null) {
                            this.f584c.getDecorView().post(this.j);
                        }
                    } else {
                        this.g = null;
                    }
                }
            }
            bVar2 = this.g;
            if (bVar2 != null && (dVar = this.f585d) != null) {
                dVar.onSupportActionModeStarted(bVar2);
            }
            return this.g;
        }
        bVar = null;
        if (bVar == null) {
        }
        bVar2 = this.g;
        if (bVar2 != null) {
            dVar.onSupportActionModeStarted(bVar2);
        }
        return this.g;
    }

    final boolean o() {
        ViewGroup viewGroup;
        return this.G && (viewGroup = this.l) != null && w.A(viewGroup);
    }

    public boolean p() {
        return this.F;
    }

    void q() {
        aa aaVar = this.k;
        if (aaVar != null) {
            aaVar.b();
        }
    }

    boolean r() {
        androidx.appcompat.view.b bVar = this.g;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        androidx.appcompat.app.a a2 = a();
        return a2 != null && a2.f();
    }

    boolean a(int i2, KeyEvent keyEvent) {
        androidx.appcompat.app.a a2 = a();
        if (a2 == null || !a2.a(i2, keyEvent)) {
            l lVar = this.N;
            if (lVar != null && a(lVar, keyEvent.getKeyCode(), keyEvent, 1)) {
                l lVar2 = this.N;
                if (lVar2 != null) {
                    lVar2.n = true;
                }
                return true;
            }
            if (this.N == null) {
                l a3 = a(0, true);
                b(a3, keyEvent);
                boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
                a3.m = false;
                if (a4) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f582a;
        if (((obj instanceof f.a) || (obj instanceof androidx.appcompat.app.g)) && (decorView = this.f584c.getDecorView()) != null && androidx.core.h.f.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.A.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    boolean b(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.O;
            this.O = false;
            l a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (r()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.O = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.ac == null) {
            String string = this.f583b.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.ac = new androidx.appcompat.app.i();
            } else {
                try {
                    this.ac = (androidx.appcompat.app.i) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.ac = new androidx.appcompat.app.i();
                }
            }
        }
        if (v) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z3 = true;
                }
            } else {
                z3 = a((ViewParent) view);
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.ac.createView(view, str, context, attributeSet, z2, v, true, bb.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f584c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || w.D((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void h() {
        LayoutInflater from = LayoutInflater.from(this.f583b);
        if (from.getFactory() == null) {
            androidx.core.h.g.a(from, this);
        } else if (from.getFactory2() instanceof f) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private androidx.appcompat.app.c A() {
        for (Context context = this.f583b; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof androidx.appcompat.app.c) {
                return (androidx.appcompat.app.c) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void a(l lVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (lVar.o || this.r) {
            return;
        }
        if (lVar.f609a == 0) {
            if ((this.f583b.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback l2 = l();
        if (l2 != null && !l2.onMenuOpened(lVar.f609a, lVar.j)) {
            a(lVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f583b.getSystemService("window");
        if (windowManager != null && b(lVar, keyEvent)) {
            if (lVar.g == null || lVar.f614q) {
                if (lVar.g == null) {
                    if (!a(lVar) || lVar.g == null) {
                        return;
                    }
                } else if (lVar.f614q && lVar.g.getChildCount() > 0) {
                    lVar.g.removeAllViews();
                }
                if (!c(lVar) || !lVar.a()) {
                    lVar.f614q = true;
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = lVar.h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                lVar.g.setBackgroundResource(lVar.f610b);
                ViewParent parent = lVar.h.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(lVar.h);
                }
                lVar.g.addView(lVar.h, layoutParams2);
                if (!lVar.h.hasFocus()) {
                    lVar.h.requestFocus();
                }
            } else if (lVar.i != null && (layoutParams = lVar.i.getLayoutParams()) != null && layoutParams.width == -1) {
                i2 = -1;
                lVar.n = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, lVar.f612d, lVar.f613e, 1002, 8519680, -3);
                layoutParams3.gravity = lVar.f611c;
                layoutParams3.windowAnimations = lVar.f;
                windowManager.addView(lVar.g, layoutParams3);
                lVar.o = true;
            }
            i2 = -2;
            lVar.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, lVar.f612d, lVar.f613e, 1002, 8519680, -3);
            layoutParams32.gravity = lVar.f611c;
            layoutParams32.windowAnimations = lVar.f;
            windowManager.addView(lVar.g, layoutParams32);
            lVar.o = true;
        }
    }

    private boolean a(l lVar) {
        lVar.a(m());
        lVar.g = new k(lVar.l);
        lVar.f611c = 81;
        return true;
    }

    private void a(boolean z2) {
        ac acVar = this.C;
        if (acVar != null && acVar.e() && (!ViewConfiguration.get(this.f583b).hasPermanentMenuKey() || this.C.g())) {
            Window.Callback l2 = l();
            if (!this.C.f() || !z2) {
                if (l2 == null || this.r) {
                    return;
                }
                if (this.s && (this.t & 1) != 0) {
                    this.f584c.getDecorView().removeCallbacks(this.Y);
                    this.Y.run();
                }
                l a2 = a(0, true);
                if (a2.j == null || a2.r || !l2.onPreparePanel(0, a2.i, a2.j)) {
                    return;
                }
                l2.onMenuOpened(108, a2.j);
                this.C.h();
                return;
            }
            this.C.i();
            if (this.r) {
                return;
            }
            l2.onPanelClosed(108, a(0, true).j);
            return;
        }
        l a3 = a(0, true);
        a3.f614q = true;
        a(a3, false);
        a(a3, (KeyEvent) null);
    }

    private boolean b(l lVar) {
        Context context = this.f583b;
        if ((lVar.f609a == 0 || lVar.f609a == 108) && this.C != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.setCallback(this);
        lVar.a(gVar);
        return true;
    }

    private boolean c(l lVar) {
        if (lVar.i != null) {
            lVar.h = lVar.i;
            return true;
        } else if (lVar.j == null) {
            return false;
        } else {
            if (this.E == null) {
                this.E = new m();
            }
            lVar.h = (View) lVar.a(this.E);
            return lVar.h != null;
        }
    }

    private boolean b(l lVar, KeyEvent keyEvent) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        if (this.r) {
            return false;
        }
        if (lVar.m) {
            return true;
        }
        l lVar2 = this.N;
        if (lVar2 != null && lVar2 != lVar) {
            a(lVar2, false);
        }
        Window.Callback l2 = l();
        if (l2 != null) {
            lVar.i = l2.onCreatePanelView(lVar.f609a);
        }
        boolean z2 = lVar.f609a == 0 || lVar.f609a == 108;
        if (z2 && (acVar3 = this.C) != null) {
            acVar3.j();
        }
        if (lVar.i == null && (!z2 || !(k() instanceof androidx.appcompat.app.k))) {
            if (lVar.j == null || lVar.r) {
                if (lVar.j == null && (!b(lVar) || lVar.j == null)) {
                    return false;
                }
                if (z2 && this.C != null) {
                    if (this.D == null) {
                        this.D = new a();
                    }
                    this.C.a(lVar.j, this.D);
                }
                lVar.j.stopDispatchingItemsChanged();
                if (!l2.onCreatePanelMenu(lVar.f609a, lVar.j)) {
                    lVar.a((androidx.appcompat.view.menu.g) null);
                    if (z2 && (acVar = this.C) != null) {
                        acVar.a(null, this.D);
                    }
                    return false;
                }
                lVar.r = false;
            }
            lVar.j.stopDispatchingItemsChanged();
            if (lVar.s != null) {
                lVar.j.restoreActionViewStates(lVar.s);
                lVar.s = null;
            }
            if (!l2.onPreparePanel(0, lVar.i, lVar.j)) {
                if (z2 && (acVar2 = this.C) != null) {
                    acVar2.a(null, this.D);
                }
                lVar.j.startDispatchingItemsChanged();
                return false;
            }
            lVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            lVar.j.setQwertyMode(lVar.p);
            lVar.j.startDispatchingItemsChanged();
        }
        lVar.m = true;
        lVar.n = false;
        this.N = lVar;
        return true;
    }

    void a(androidx.appcompat.view.menu.g gVar) {
        if (this.L) {
            return;
        }
        this.L = true;
        this.C.k();
        Window.Callback l2 = l();
        if (l2 != null && !this.r) {
            l2.onPanelClosed(108, gVar);
        }
        this.L = false;
    }

    void g(int i2) {
        a(a(i2, true), true);
    }

    void a(l lVar, boolean z2) {
        ac acVar;
        if (z2 && lVar.f609a == 0 && (acVar = this.C) != null && acVar.f()) {
            a(lVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f583b.getSystemService("window");
        if (windowManager != null && lVar.o && lVar.g != null) {
            windowManager.removeView(lVar.g);
            if (z2) {
                a(lVar.f609a, lVar, (Menu) null);
            }
        }
        lVar.m = false;
        lVar.n = false;
        lVar.o = false;
        lVar.h = null;
        lVar.f614q = true;
        if (this.N == lVar) {
            this.N = null;
        }
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            l a2 = a(i2, true);
            if (a2.o) {
                return false;
            }
            return b(a2, keyEvent);
        }
        return false;
    }

    private boolean e(int i2, KeyEvent keyEvent) {
        boolean z2;
        ac acVar;
        if (this.g != null) {
            return false;
        }
        boolean z3 = true;
        l a2 = a(i2, true);
        if (i2 == 0 && (acVar = this.C) != null && acVar.e() && !ViewConfiguration.get(this.f583b).hasPermanentMenuKey()) {
            if (!this.C.f()) {
                if (!this.r && b(a2, keyEvent)) {
                    z3 = this.C.h();
                }
                z3 = false;
            } else {
                z3 = this.C.i();
            }
        } else if (a2.o || a2.n) {
            boolean z4 = a2.o;
            a(a2, true);
            z3 = z4;
        } else {
            if (a2.m) {
                if (a2.r) {
                    a2.m = false;
                    z2 = b(a2, keyEvent);
                } else {
                    z2 = true;
                }
                if (z2) {
                    a(a2, keyEvent);
                }
            }
            z3 = false;
        }
        if (z3) {
            AudioManager audioManager = (AudioManager) this.f583b.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z3;
    }

    void a(int i2, l lVar, Menu menu) {
        if (menu == null) {
            if (lVar == null && i2 >= 0) {
                l[] lVarArr = this.M;
                if (i2 < lVarArr.length) {
                    lVar = lVarArr[i2];
                }
            }
            if (lVar != null) {
                menu = lVar.j;
            }
        }
        if ((lVar == null || lVar.o) && !this.r) {
            this.A.a().onPanelClosed(i2, menu);
        }
    }

    l a(Menu menu) {
        l[] lVarArr = this.M;
        int length = lVarArr != null ? lVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            l lVar = lVarArr[i2];
            if (lVar != null && lVar.j == menu) {
                return lVar;
            }
        }
        return null;
    }

    protected l a(int i2, boolean z2) {
        l[] lVarArr = this.M;
        if (lVarArr == null || lVarArr.length <= i2) {
            l[] lVarArr2 = new l[i2 + 1];
            if (lVarArr != null) {
                System.arraycopy(lVarArr, 0, lVarArr2, 0, lVarArr.length);
            }
            this.M = lVarArr2;
            lVarArr = lVarArr2;
        }
        l lVar = lVarArr[i2];
        if (lVar == null) {
            l lVar2 = new l(i2);
            lVarArr[i2] = lVar2;
            return lVar2;
        }
        return lVar;
    }

    private boolean a(l lVar, int i2, KeyEvent keyEvent, int i3) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((lVar.m || b(lVar, keyEvent)) && lVar.j != null) {
            z2 = lVar.j.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.C == null) {
            a(lVar, true);
        }
        return z2;
    }

    private void i(int i2) {
        this.t = (1 << i2) | this.t;
        if (this.s) {
            return;
        }
        w.a(this.f584c.getDecorView(), this.Y);
        this.s = true;
    }

    void h(int i2) {
        l a2;
        l a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.stopDispatchingItemsChanged();
            a3.j.clear();
        }
        a3.r = true;
        a3.f614q = true;
        if ((i2 != 108 && i2 != 0) || this.C == null || (a2 = a(0, false)) == null) {
            return;
        }
        a2.m = false;
        b(a2, (KeyEvent) null);
    }

    final int a(ae aeVar, Rect rect) {
        int i2;
        boolean z2;
        boolean z3;
        if (aeVar != null) {
            i2 = aeVar.b();
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.h;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h.getLayoutParams();
            if (this.h.isShown()) {
                if (this.aa == null) {
                    this.aa = new Rect();
                    this.ab = new Rect();
                }
                Rect rect2 = this.aa;
                Rect rect3 = this.ab;
                if (aeVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(aeVar.a(), aeVar.b(), aeVar.c(), aeVar.d());
                }
                bc.a(this.l, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                ae t = w.t(this.l);
                int a2 = t == null ? 0 : t.a();
                int c2 = t == null ? 0 : t.c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z3 = true;
                }
                if (i3 > 0 && this.I == null) {
                    View view = new View(this.f583b);
                    this.I = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = a2;
                    layoutParams.rightMargin = c2;
                    this.l.addView(this.I, -1, layoutParams);
                } else {
                    View view2 = this.I;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != a2 || marginLayoutParams2.rightMargin != c2) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = a2;
                            marginLayoutParams2.rightMargin = c2;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                r5 = this.I != null;
                if (r5 && this.I.getVisibility() != 0) {
                    b(this.I);
                }
                if (!this.o && r5) {
                    i2 = 0;
                }
                z2 = r5;
                r5 = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                r5 = false;
            }
            if (r5) {
                this.h.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.I;
        if (view3 != null) {
            view3.setVisibility(z2 ? 0 : 8);
        }
        return i2;
    }

    private void b(View view) {
        int c2;
        if ((w.q(view) & 8192) != 0) {
            c2 = androidx.core.content.b.c(this.f583b, R.color.abc_decor_view_status_guard_light);
        } else {
            c2 = androidx.core.content.b.c(this.f583b, R.color.abc_decor_view_status_guard);
        }
        view.setBackgroundColor(c2);
    }

    private void B() {
        if (this.G) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int j(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        } else {
            return i2;
        }
    }

    void s() {
        ac acVar = this.C;
        if (acVar != null) {
            acVar.k();
        }
        if (this.i != null) {
            this.f584c.getDecorView().removeCallbacks(this.j);
            if (this.i.isShowing()) {
                try {
                    this.i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.i = null;
        }
        q();
        l a2 = a(0, false);
        if (a2 == null || a2.j == null) {
            return;
        }
        a2.j.close();
    }

    public boolean t() {
        return b(true);
    }

    private boolean b(boolean z2) {
        if (this.r) {
            return false;
        }
        int C = C();
        boolean b2 = b(a(this.f583b, C), z2);
        if (C == 0) {
            c(this.f583b).d();
        } else {
            e eVar = this.W;
            if (eVar != null) {
                eVar.e();
            }
        }
        if (C == 3) {
            d(this.f583b).d();
        } else {
            e eVar2 = this.X;
            if (eVar2 != null) {
                eVar2.e();
            }
        }
        return b2;
    }

    @Override // androidx.appcompat.app.e
    public int i() {
        return this.S;
    }

    int a(Context context, int i2) {
        if (i2 != -100) {
            if (i2 != -1) {
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                        return c(context).a();
                    }
                    return -1;
                } else if (i2 != 1 && i2 != 2) {
                    if (i2 == 3) {
                        return d(context).a();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            }
            return i2;
        }
        return -1;
    }

    private int C() {
        int i2 = this.S;
        return i2 != -100 ? i2 : j();
    }

    private Configuration a(Context context, int i2, Configuration configuration) {
        int i3;
        if (i2 != 1) {
            i3 = i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i3 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(int i2, boolean z2) {
        boolean z3;
        Configuration a2 = a(this.f583b, i2, (Configuration) null);
        boolean D = D();
        int i3 = this.f583b.getResources().getConfiguration().uiMode & 48;
        int i4 = a2.uiMode & 48;
        boolean z4 = true;
        if (i3 != i4 && z2 && !D && this.P && (x || this.Q)) {
            Object obj = this.f582a;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                androidx.core.app.a.b((Activity) this.f582a);
                z3 = true;
                if (!z3 || i3 == i4) {
                    z4 = z3;
                } else {
                    a(i4, D, (Configuration) null);
                }
                if (z4) {
                    Object obj2 = this.f582a;
                    if (obj2 instanceof androidx.appcompat.app.c) {
                        ((androidx.appcompat.app.c) obj2).a(i2);
                    }
                }
                return z4;
            }
        }
        z3 = false;
        if (z3) {
        }
        z4 = z3;
        if (z4) {
        }
        return z4;
    }

    private void a(int i2, boolean z2, Configuration configuration) {
        Resources resources = this.f583b.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.j.a(resources);
        }
        int i3 = this.T;
        if (i3 != 0) {
            this.f583b.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f583b.getTheme().applyStyle(this.T, true);
            }
        }
        if (z2) {
            Object obj = this.f582a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.l) {
                    if (((androidx.lifecycle.l) activity).getLifecycle().a().a(h.b.STARTED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else if (this.R) {
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private e c(Context context) {
        if (this.W == null) {
            this.W = new C0021f(androidx.appcompat.app.m.a(context));
        }
        return this.W;
    }

    private e d(Context context) {
        if (this.X == null) {
            this.X = new d(context);
        }
        return this.X;
    }

    private boolean D() {
        int i2;
        if (!this.V && (this.f582a instanceof Activity)) {
            PackageManager packageManager = this.f583b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    i2 = 269221888;
                } else {
                    i2 = Build.VERSION.SDK_INT >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f583b, this.f582a.getClass()), i2);
                this.U = (activityInfo == null || (activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.U = false;
            }
        }
        this.V = true;
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class b implements b.a {

        /* renamed from: b  reason: collision with root package name */
        private b.a f598b;

        public b(b.a aVar) {
            this.f598b = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f598b.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            w.r(f.this.l);
            return this.f598b.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f598b.a(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.f598b.a(bVar);
            if (f.this.i != null) {
                f.this.f584c.getDecorView().removeCallbacks(f.this.j);
            }
            if (f.this.h != null) {
                f.this.q();
                f fVar = f.this;
                fVar.k = w.m(fVar.h).a(0.0f);
                f.this.k.a(new androidx.core.h.ac() { // from class: androidx.appcompat.app.f.b.1
                    @Override // androidx.core.h.ac, androidx.core.h.ab
                    public void b(View view) {
                        f.this.h.setVisibility(8);
                        if (f.this.i != null) {
                            f.this.i.dismiss();
                        } else if (f.this.h.getParent() instanceof View) {
                            w.r((View) f.this.h.getParent());
                        }
                        f.this.h.removeAllViews();
                        f.this.k.a((ab) null);
                        f.this.k = null;
                        w.r(f.this.l);
                    }
                });
            }
            if (f.this.f585d != null) {
                f.this.f585d.onSupportActionModeFinished(f.this.g);
            }
            f.this.g = null;
            w.r(f.this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public final class m implements m.a {
        m() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            androidx.appcompat.view.menu.g rootMenu = gVar.getRootMenu();
            boolean z2 = rootMenu != gVar;
            f fVar = f.this;
            if (z2) {
                gVar = rootMenu;
            }
            l a2 = fVar.a((Menu) gVar);
            if (a2 != null) {
                if (z2) {
                    f.this.a(a2.f609a, a2, rootMenu);
                    f.this.a(a2, true);
                    return;
                }
                f.this.a(a2, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback l;
            if (gVar != gVar.getRootMenu() || !f.this.m || (l = f.this.l()) == null || f.this.r) {
                return true;
            }
            l.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public final class a implements m.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback l = f.this.l();
            if (l != null) {
                l.onMenuOpened(108, gVar);
                return true;
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            f.this.a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static final class l {

        /* renamed from: a  reason: collision with root package name */
        int f609a;

        /* renamed from: b  reason: collision with root package name */
        int f610b;

        /* renamed from: c  reason: collision with root package name */
        int f611c;

        /* renamed from: d  reason: collision with root package name */
        int f612d;

        /* renamed from: e  reason: collision with root package name */
        int f613e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.g j;
        androidx.appcompat.view.menu.e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;

        /* renamed from: q  reason: collision with root package name */
        boolean f614q = false;
        boolean r;
        Bundle s;

        l(int i) {
            this.f609a = i;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f610b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void a(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.removeMenuPresenter(this.k);
            }
            this.j = gVar;
            if (gVar == null || (eVar = this.k) == null) {
                return;
            }
            gVar.addMenuPresenter(eVar);
        }

        androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.l, R.layout.abc_list_menu_item_layout);
                this.k = eVar;
                eVar.setCallback(aVar);
                this.j.addMenuPresenter(this.k);
            }
            return this.k.a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class k extends ContentFrameLayout {
        public k(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                f.this.g(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class c extends androidx.appcompat.view.i {
        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (gVar != null) {
                gVar.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.f(i);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.e(i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (f.this.p()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(f.this.f583b, callback);
            androidx.appcompat.view.b a2 = f.this.a(aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (f.this.p() && i == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            l a2 = f.this.a(0, true);
            if (a2 != null && a2.j != null) {
                super.onProvideKeyboardShortcuts(list, a2.j, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public abstract class e {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f603a;

        abstract int a();

        abstract void b();

        abstract IntentFilter c();

        e() {
        }

        void d() {
            e();
            IntentFilter c2 = c();
            if (c2 == null || c2.countActions() == 0) {
                return;
            }
            if (this.f603a == null) {
                this.f603a = new BroadcastReceiver() { // from class: androidx.appcompat.app.f.e.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        e.this.b();
                    }
                };
            }
            f.this.f583b.registerReceiver(this.f603a, c2);
        }

        void e() {
            if (this.f603a != null) {
                try {
                    f.this.f583b.unregisterReceiver(this.f603a);
                } catch (IllegalArgumentException unused) {
                }
                this.f603a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0021f extends e {

        /* renamed from: c  reason: collision with root package name */
        private final androidx.appcompat.app.m f607c;

        C0021f(androidx.appcompat.app.m mVar) {
            super();
            this.f607c = mVar;
        }

        @Override // androidx.appcompat.app.f.e
        public int a() {
            return this.f607c.a() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.f.e
        public void b() {
            f.this.t();
        }

        @Override // androidx.appcompat.app.f.e
        IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public class d extends e {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f602c;

        d(Context context) {
            super();
            this.f602c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.f.e
        public int a() {
            return (Build.VERSION.SDK_INT < 21 || !this.f602c.isPowerSaveMode()) ? 1 : 2;
        }

        @Override // androidx.appcompat.app.f.e
        public void b() {
            f.this.t();
        }

        @Override // androidx.appcompat.app.f.e
        IntentFilter c() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            }
            return null;
        }
    }

    private static Configuration a(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            if (configuration.fontScale != configuration2.fontScale) {
                configuration3.fontScale = configuration2.fontScale;
            }
            if (configuration.mcc != configuration2.mcc) {
                configuration3.mcc = configuration2.mcc;
            }
            if (configuration.mnc != configuration2.mnc) {
                configuration3.mnc = configuration2.mnc;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                h.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.g.c.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            if (configuration.touchscreen != configuration2.touchscreen) {
                configuration3.touchscreen = configuration2.touchscreen;
            }
            if (configuration.keyboard != configuration2.keyboard) {
                configuration3.keyboard = configuration2.keyboard;
            }
            if (configuration.keyboardHidden != configuration2.keyboardHidden) {
                configuration3.keyboardHidden = configuration2.keyboardHidden;
            }
            if (configuration.navigation != configuration2.navigation) {
                configuration3.navigation = configuration2.navigation;
            }
            if (configuration.navigationHidden != configuration2.navigationHidden) {
                configuration3.navigationHidden = configuration2.navigationHidden;
            }
            if (configuration.orientation != configuration2.orientation) {
                configuration3.orientation = configuration2.orientation;
            }
            if ((configuration.screenLayout & 15) != (configuration2.screenLayout & 15)) {
                configuration3.screenLayout |= configuration2.screenLayout & 15;
            }
            if ((configuration.screenLayout & 192) != (configuration2.screenLayout & 192)) {
                configuration3.screenLayout |= configuration2.screenLayout & 192;
            }
            if ((configuration.screenLayout & 48) != (configuration2.screenLayout & 48)) {
                configuration3.screenLayout |= configuration2.screenLayout & 48;
            }
            if ((configuration.screenLayout & 768) != (configuration2.screenLayout & 768)) {
                configuration3.screenLayout |= configuration2.screenLayout & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                i.a(configuration, configuration2, configuration3);
            }
            if ((configuration.uiMode & 15) != (configuration2.uiMode & 15)) {
                configuration3.uiMode |= configuration2.uiMode & 15;
            }
            if ((configuration.uiMode & 48) != (configuration2.uiMode & 48)) {
                configuration3.uiMode |= configuration2.uiMode & 48;
            }
            if (configuration.screenWidthDp != configuration2.screenWidthDp) {
                configuration3.screenWidthDp = configuration2.screenWidthDp;
            }
            if (configuration.screenHeightDp != configuration2.screenHeightDp) {
                configuration3.screenHeightDp = configuration2.screenHeightDp;
            }
            if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
                configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                g.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static class g {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration3.densityDpi = configuration2.densityDpi;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static class h {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDelegateImpl.java */
    /* loaded from: classes.dex */
    public static class i {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }
}
