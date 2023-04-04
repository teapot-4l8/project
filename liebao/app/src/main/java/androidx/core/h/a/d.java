package androidx.core.h.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R;
import androidx.core.h.a.g;
import com.google.android.gms.ads.AdRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    private static int f1660d;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfo f1662b;

    /* renamed from: a  reason: collision with root package name */
    public int f1661a = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f1663c = -1;

    private static String b(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case AdRequest.MAX_CONTENT_URL_LENGTH /* 512 */:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    default:
                        switch (i) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;

        /* renamed from: a  reason: collision with root package name */
        public static final a f1664a = new a(1, null);

        /* renamed from: b  reason: collision with root package name */
        public static final a f1665b = new a(2, null);

        /* renamed from: c  reason: collision with root package name */
        public static final a f1666c = new a(4, null);

        /* renamed from: d  reason: collision with root package name */
        public static final a f1667d = new a(8, null);

        /* renamed from: e  reason: collision with root package name */
        public static final a f1668e = new a(16, null);
        public static final a f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(256, null, g.b.class);
        public static final a j = new a(AdRequest.MAX_CONTENT_URL_LENGTH, null, g.b.class);
        public static final a k = new a(1024, null, g.c.class);
        public static final a l = new a(2048, null, g.c.class);
        public static final a m = new a(4096, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);

        /* renamed from: q  reason: collision with root package name */
        public static final a f1669q = new a(65536, null);
        public static final a r = new a(131072, null, g.C0039g.class);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null, g.h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object L;
        protected final g M;
        private final int N;
        private final Class<? extends g.a> O;

        static {
            w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, g.e.class);
            y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, g.f.class);
            I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, g.d.class);
            J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.N = i2;
            this.M = gVar;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.L = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.L = obj;
            }
            this.O = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getLabel();
            }
            return null;
        }

        public boolean a(View view, Bundle bundle) {
            if (this.M != null) {
                g.a aVar = null;
                Class<? extends g.a> cls = this.O;
                if (cls != null) {
                    try {
                        g.a newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        try {
                            newInstance.a(bundle);
                            aVar = newInstance;
                        } catch (Exception e2) {
                            e = e2;
                            aVar = newInstance;
                            Class<? extends g.a> cls2 = this.O;
                            String name = cls2 == null ? "null" : cls2.getName();
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                            return this.M.perform(view, aVar);
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                return this.M.perform(view, aVar);
            }
            return false;
        }

        public a a(CharSequence charSequence, g gVar) {
            return new a(null, this.N, charSequence, gVar, this.O);
        }

        public int hashCode() {
            Object obj = this.L;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                Object obj2 = this.L;
                return obj2 == null ? aVar.L == null : obj2.equals(aVar.L);
            }
            return false;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f1670a;

        public static b a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b(null);
        }

        b(Object obj) {
            this.f1670a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final Object f1671a;

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c(null);
        }

        c(Object obj) {
            this.f1671a = obj;
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1662b = accessibilityNodeInfo;
    }

    public static d a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.f1662b;
    }

    public static d a(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    public static d b() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public static d a(d dVar) {
        return a(AccessibilityNodeInfo.obtain(dVar.f1662b));
    }

    public void a(View view, int i) {
        this.f1663c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1662b.setSource(view, i);
        }
    }

    public int c() {
        return this.f1662b.getChildCount();
    }

    public void b(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1662b.addChild(view, i);
        }
    }

    public int d() {
        return this.f1662b.getActions();
    }

    public void a(int i) {
        this.f1662b.addAction(i);
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f1662b.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f1662b.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1662b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f1662b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
        return false;
    }

    public boolean a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f1662b.performAction(i, bundle);
        }
        return false;
    }

    public void b(View view) {
        this.f1661a = -1;
        this.f1662b.setParent(view);
    }

    public void c(View view, int i) {
        this.f1661a = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1662b.setParent(view, i);
        }
    }

    @Deprecated
    public void a(Rect rect) {
        this.f1662b.getBoundsInParent(rect);
    }

    @Deprecated
    public void b(Rect rect) {
        this.f1662b.setBoundsInParent(rect);
    }

    public void c(Rect rect) {
        this.f1662b.getBoundsInScreen(rect);
    }

    public void d(Rect rect) {
        this.f1662b.setBoundsInScreen(rect);
    }

    public boolean e() {
        return this.f1662b.isCheckable();
    }

    public void a(boolean z) {
        this.f1662b.setCheckable(z);
    }

    public boolean f() {
        return this.f1662b.isChecked();
    }

    public void b(boolean z) {
        this.f1662b.setChecked(z);
    }

    public boolean g() {
        return this.f1662b.isFocusable();
    }

    public void c(boolean z) {
        this.f1662b.setFocusable(z);
    }

    public boolean h() {
        return this.f1662b.isFocused();
    }

    public void d(boolean z) {
        this.f1662b.setFocused(z);
    }

    public void e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1662b.setVisibleToUser(z);
        }
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1662b.setAccessibilityFocused(z);
        }
    }

    public boolean i() {
        return this.f1662b.isSelected();
    }

    public boolean j() {
        return this.f1662b.isClickable();
    }

    public boolean k() {
        return this.f1662b.isLongClickable();
    }

    public boolean l() {
        return this.f1662b.isEnabled();
    }

    public void g(boolean z) {
        this.f1662b.setEnabled(z);
    }

    public boolean m() {
        return this.f1662b.isPassword();
    }

    public boolean n() {
        return this.f1662b.isScrollable();
    }

    public void h(boolean z) {
        this.f1662b.setScrollable(z);
    }

    public CharSequence o() {
        return this.f1662b.getPackageName();
    }

    public void a(CharSequence charSequence) {
        this.f1662b.setPackageName(charSequence);
    }

    public CharSequence p() {
        return this.f1662b.getClassName();
    }

    public void b(CharSequence charSequence) {
        this.f1662b.setClassName(charSequence);
    }

    public CharSequence q() {
        if (w()) {
            List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1662b.getText(), 0, this.f1662b.getText().length()));
            for (int i = 0; i < a2.size(); i++) {
                spannableString.setSpan(new androidx.core.h.a.a(a5.get(i).intValue(), this, v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i).intValue(), a3.get(i).intValue(), a4.get(i).intValue());
            }
            return spannableString;
        }
        return this.f1662b.getText();
    }

    public void c(CharSequence charSequence) {
        this.f1662b.setText(charSequence);
    }

    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        x();
        e(view);
        ClickableSpan[] d2 = d(charSequence);
        if (d2 == null || d2.length <= 0) {
            return;
        }
        v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
        for (int i = 0; d2 != null && i < d2.length; i++) {
            int a2 = a(d2[i], c2);
            c2.put(a2, new WeakReference<>(d2[i]));
            a(d2[i], (Spanned) charSequence, a2);
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> c(View view) {
        SparseArray<WeakReference<ClickableSpan>> d2 = d(view);
        if (d2 == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray);
            return sparseArray;
        }
        return d2;
    }

    private SparseArray<WeakReference<ClickableSpan>> d(View view) {
        return (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = f1660d;
        f1660d = i2 + 1;
        return i2;
    }

    private boolean w() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void x() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1662b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f1662b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f1662b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f1662b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void e(View view) {
        SparseArray<WeakReference<ClickableSpan>> d2 = d(view);
        if (d2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < d2.size(); i++) {
                if (d2.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d2.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public CharSequence r() {
        return this.f1662b.getContentDescription();
    }

    public void e(CharSequence charSequence) {
        this.f1662b.setContentDescription(charSequence);
    }

    public void s() {
        this.f1662b.recycle();
    }

    public String t() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f1662b.getViewIdResourceName();
        }
        return null;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1662b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f1670a);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1662b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f1671a);
        }
    }

    public List<a> u() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f1662b.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new a(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void i(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1662b.setContentInvalid(z);
        }
    }

    public void f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1662b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f1662b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1662b.setError(charSequence);
        }
    }

    public Bundle v() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f1662b.getExtras();
        }
        return new Bundle();
    }

    public void j(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1662b.setDismissable(z);
        }
    }

    public void h(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1662b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f1662b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void k(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1662b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public void l(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1662b.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1662b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1662b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f1662b;
            if (accessibilityNodeInfo == null) {
                if (dVar.f1662b != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(dVar.f1662b)) {
                return false;
            }
            return this.f1663c == dVar.f1663c && this.f1661a == dVar.f1661a;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(o());
        sb.append("; className: ");
        sb.append(p());
        sb.append("; text: ");
        sb.append(q());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; viewId: ");
        sb.append(t());
        sb.append("; checkable: ");
        sb.append(e());
        sb.append("; checked: ");
        sb.append(f());
        sb.append("; focusable: ");
        sb.append(g());
        sb.append("; focused: ");
        sb.append(h());
        sb.append("; selected: ");
        sb.append(i());
        sb.append("; clickable: ");
        sb.append(j());
        sb.append("; longClickable: ");
        sb.append(k());
        sb.append("; enabled: ");
        sb.append(l());
        sb.append("; password: ");
        sb.append(m());
        sb.append("; scrollable: " + n());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> u = u();
            for (int i = 0; i < u.size(); i++) {
                a aVar = u.get(i);
                String b2 = b(aVar.a());
                if (b2.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    b2 = aVar.b().toString();
                }
                sb.append(b2);
                if (i != u.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int d2 = d();
            while (d2 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(d2);
                d2 &= numberOfTrailingZeros ^ (-1);
                sb.append(b(numberOfTrailingZeros));
                if (d2 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void a(int i, boolean z) {
        Bundle v = v();
        if (v != null) {
            int i2 = v.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ (-1));
            if (!z) {
                i = 0;
            }
            v.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
