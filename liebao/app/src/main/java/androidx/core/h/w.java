package androidx.core.h;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.h.a;
import androidx.core.h.a.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: b  reason: collision with root package name */
    private static Field f1736b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1737c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f1738d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f1739e;
    private static WeakHashMap<View, String> f;
    private static Field h;
    private static ThreadLocal<Rect> j;

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f1735a = new AtomicInteger(1);
    private static WeakHashMap<View, aa> g = null;
    private static boolean i = false;
    private static final int[] k = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    private static a l = new a();

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public interface f {
        boolean a(View view, KeyEvent keyEvent);
    }

    private static Rect b() {
        if (j == null) {
            j = new ThreadLocal<>();
        }
        Rect rect = j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void a(View view, androidx.core.h.a.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.a());
    }

    public static void a(View view, androidx.core.h.a aVar) {
        if (aVar == null && (J(view) instanceof a.C0038a)) {
            aVar = new androidx.core.h.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
    }

    public static int a(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    public static androidx.core.h.a b(View view) {
        View.AccessibilityDelegate J = J(view);
        if (J == null) {
            return null;
        }
        if (J instanceof a.C0038a) {
            return ((a.C0038a) J).f1655a;
        }
        return new androidx.core.h.a(J);
    }

    static androidx.core.h.a c(View view) {
        androidx.core.h.a b2 = b(view);
        if (b2 == null) {
            b2 = new androidx.core.h.a();
        }
        a(view, b2);
        return b2;
    }

    private static View.AccessibilityDelegate J(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return K(view);
    }

    private static View.AccessibilityDelegate K(View view) {
        if (i) {
            return null;
        }
        if (h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return null;
            }
        }
        try {
            Object obj = h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            i = true;
            return null;
        }
    }

    public static boolean d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void e(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static int f(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void b(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void a(View view, d.a aVar, CharSequence charSequence, androidx.core.h.a.g gVar) {
        if (gVar == null && charSequence == null) {
            c(view, aVar.a());
        } else {
            a(view, aVar.a(charSequence, gVar));
        }
    }

    private static void a(View view, d.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            c(view);
            a(aVar.a(), view);
            L(view).add(aVar);
            h(view, 0);
        }
    }

    public static void c(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i2, view);
            h(view, 0);
        }
    }

    private static void a(int i2, View view) {
        List<d.a> L = L(view);
        for (int i3 = 0; i3 < L.size(); i3++) {
            if (L.get(i3).a() == i2) {
                L.remove(i3);
                return;
            }
        }
    }

    private static List<d.a> L(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static int g(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int h(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static int i(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    public static int k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f1737c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f1736b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1737c = true;
        }
        Field field = f1736b;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static int l(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f1739e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f1738d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f1739e = true;
        }
        Field field = f1738d;
        if (field != null) {
            try {
                return ((Integer) field.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
        return 0;
    }

    public static aa m(View view) {
        if (g == null) {
            g = new WeakHashMap<>();
        }
        aa aaVar = g.get(view);
        if (aaVar == null) {
            aa aaVar2 = new aa(view);
            g.put(view, aaVar2);
            return aaVar2;
        }
        return aaVar;
    }

    public static void a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static float n(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void b(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static float o(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap<>();
        }
        f.put(view, str);
    }

    public static String p(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void r(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean s(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, final s sVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (sVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.h.w.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return s.this.onApplyWindowInsets(view2, ae.a(windowInsets)).k();
                    }
                });
            }
        }
    }

    public static ae a(View view, ae aeVar) {
        WindowInsets k2;
        if (Build.VERSION.SDK_INT >= 21 && (k2 = aeVar.k()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(k2);
            if (!onApplyWindowInsets.equals(k2)) {
                return ae.a(onApplyWindowInsets);
            }
        }
        return aeVar;
    }

    public static ae b(View view, ae aeVar) {
        WindowInsets k2;
        return (Build.VERSION.SDK_INT < 21 || (k2 = aeVar.k()) == null || view.dispatchApplyWindowInsets(k2).equals(k2)) ? aeVar : ae.a(k2);
    }

    public static ae t(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ae.a(d.a(view));
        }
        return null;
    }

    public static ae a(View view, ae aeVar, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(view, aeVar, rect) : aeVar;
    }

    public static boolean u(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean v(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static ColorStateList w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof v) {
            return ((v) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof v) {
            ((v) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode x(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof v) {
            return ((v) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        } else if (view instanceof v) {
            ((v) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static boolean y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof k) {
            return ((k) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void z(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof k) {
            ((k) view).stopNestedScroll();
        }
    }

    public static void e(View view, int i2) {
        if (view instanceof l) {
            ((l) view).stopNestedScroll(i2);
        } else if (i2 == 0) {
            z(view);
        }
    }

    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float B(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void f(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b2 = b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            i(view, i2);
            if (z && b2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b2);
            }
        } else {
            i(view, i2);
        }
    }

    private static void i(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            M(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                M((View) parent);
            }
        }
    }

    public static void g(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b2 = b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            j(view, i2);
            if (z && b2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b2);
            }
        } else {
            j(view, i2);
        }
    }

    private static void j(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            M(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                M((View) parent);
            }
        }
    }

    private static void M(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static Rect C(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean D(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean E(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void a(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void a(View view, u uVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (uVar != null ? uVar.a() : null));
        }
    }

    public static Display F(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (D(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static int a() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = f1735a.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f1735a.compareAndSet(i2, i3));
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.a(view).a(view, keyEvent);
    }

    public static boolean G(View view) {
        Boolean c2 = c().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    private static b<Boolean> c() {
        return new b<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.h.w.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h.w.b
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }
        };
    }

    public static CharSequence H(View view) {
        return d().c(view);
    }

    private static b<CharSequence> d() {
        return new b<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.h.w.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h.w.b
            /* renamed from: a */
            public CharSequence b(View view) {
                return view.getAccessibilityPaneTitle();
            }
        };
    }

    public static boolean I(View view) {
        Boolean c2 = e().c(view);
        if (c2 == null) {
            return false;
        }
        return c2.booleanValue();
    }

    private static b<Boolean> e() {
        return new b<Boolean>(R.id.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.h.w.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.h.w.b
            /* renamed from: a */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static abstract class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f1742a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f1743b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1744c;

        abstract T b(View view);

        b(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        b(int i, Class<T> cls, int i2, int i3) {
            this.f1742a = i;
            this.f1743b = cls;
            this.f1744c = i3;
        }

        T c(View view) {
            if (a()) {
                return b(view);
            }
            if (b()) {
                T t = (T) view.getTag(this.f1742a);
                if (this.f1743b.isInstance(t)) {
                    return t;
                }
                return null;
            }
            return null;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= this.f1744c;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }
    }

    static void h(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = H(view) != null;
            if (h(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1741a = new WeakHashMap<>();

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.f1741a.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a(view);
        }

        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    w.h(view, 16);
                }
                this.f1741a.put(view, Boolean.valueOf(z2));
            }
        }

        private void a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class g {

        /* renamed from: a  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f1745a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f1746b = null;

        /* renamed from: c  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f1747c = null;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<KeyEvent> f1748d = null;

        g() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.f1747c == null) {
                this.f1747c = new SparseArray<>();
            }
            return this.f1747c;
        }

        static g a(View view) {
            g gVar = (g) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (gVar == null) {
                g gVar2 = new g();
                view.setTag(R.id.tag_unhandled_key_event_manager, gVar2);
                return gVar2;
            }
            return gVar;
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View b2 = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b2 != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(b2));
                }
            }
            return b2 != null;
        }

        private View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1746b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b2 = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b2 != null) {
                            return b2;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        boolean a(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f1748d;
            if (weakReference == null || weakReference.get() != keyEvent) {
                this.f1748d = new WeakReference<>(keyEvent);
                WeakReference<View> weakReference2 = null;
                SparseArray<WeakReference<View>> a2 = a();
                if (keyEvent.getAction() == 1 && (indexOfKey = a2.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference2 = a2.valueAt(indexOfKey);
                    a2.removeAt(indexOfKey);
                }
                if (weakReference2 == null) {
                    weakReference2 = a2.get(keyEvent.getKeyCode());
                }
                if (weakReference2 != null) {
                    View view = weakReference2.get();
                    if (view != null && w.D(view)) {
                        c(view, keyEvent);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((f) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void b() {
            WeakHashMap<View, Boolean> weakHashMap = this.f1746b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (f1745a.isEmpty()) {
                return;
            }
            synchronized (f1745a) {
                if (this.f1746b == null) {
                    this.f1746b = new WeakHashMap<>();
                }
                for (int size = f1745a.size() - 1; size >= 0; size--) {
                    View view = f1745a.get(size).get();
                    if (view == null) {
                        f1745a.remove(size);
                    } else {
                        this.f1746b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f1746b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class c {
        static ae a(View view, ae aeVar, Rect rect) {
            WindowInsets k = aeVar.k();
            if (k != null) {
                return ae.a(view.computeSystemWindowInsets(k, rect));
            }
            rect.setEmpty();
            return aeVar;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class d {
        public static WindowInsets a(View view) {
            return view.getRootWindowInsets();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class e {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }
}
