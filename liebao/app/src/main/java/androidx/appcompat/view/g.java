package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ae;
import androidx.appcompat.widget.aw;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SupportMenuInflater.java */
/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?>[] f710a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f711b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f712c;

    /* renamed from: d  reason: collision with root package name */
    final Object[] f713d;

    /* renamed from: e  reason: collision with root package name */
    Context f714e;
    private Object f;

    static {
        Class<?>[] clsArr = {Context.class};
        f710a = clsArr;
        f711b = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f714e = context;
        Object[] objArr = {context};
        this.f712c = objArr;
        this.f713d = objArr;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof androidx.core.a.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f714e.getResources().getLayout(i);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r6 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r15 == 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r15 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r15 == 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        if (r7 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r15.equals(r8) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r15.equals("group") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r0.d() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r0.f718a == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
        if (r0.f718a.c() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
        r0.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0084, code lost:
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        if (r15.equals("menu") == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008e, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
        if (r15.equals("group") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009d, code lost:
        r0.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
        if (r15.equals("item") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a7, code lost:
        r0.b(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
        if (r15.equals("menu") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b1, code lost:
        a(r13, r14, r0.c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b9, code lost:
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bb, code lost:
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c7, code lost:
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c8, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.f714e);
        }
        return this.f;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f715a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f716b;

        /* renamed from: c  reason: collision with root package name */
        private Method f717c;

        public a(Object obj, String str) {
            this.f716b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f717c = cls.getMethod(str, f715a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f717c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f717c.invoke(this.f716b, menuItem)).booleanValue();
                }
                this.f717c.invoke(this.f716b, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SupportMenuInflater.java */
    /* loaded from: classes.dex */
    public class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;

        /* renamed from: a  reason: collision with root package name */
        androidx.core.h.b f718a;

        /* renamed from: c  reason: collision with root package name */
        private Menu f720c;

        /* renamed from: d  reason: collision with root package name */
        private int f721d;

        /* renamed from: e  reason: collision with root package name */
        private int f722e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;

        /* renamed from: q  reason: collision with root package name */
        private int f723q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.f720c = menu;
            a();
        }

        public void a() {
            this.f721d = 0;
            this.f722e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f714e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f721d = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f722e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.g = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b(AttributeSet attributeSet) {
            aw a2 = aw.a(g.this.f714e, attributeSet, R.styleable.MenuItem);
            this.k = a2.g(R.styleable.MenuItem_android_id, 0);
            this.l = (a2.a(R.styleable.MenuItem_android_menuCategory, this.f722e) & (-65536)) | (a2.a(R.styleable.MenuItem_android_orderInCategory, this.f) & 65535);
            this.m = a2.c(R.styleable.MenuItem_android_title);
            this.n = a2.c(R.styleable.MenuItem_android_titleCondensed);
            this.o = a2.g(R.styleable.MenuItem_android_icon, 0);
            this.p = a(a2.d(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f723q = a2.a(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.r = a(a2.d(R.styleable.MenuItem_android_numericShortcut));
            this.s = a2.a(R.styleable.MenuItem_numericModifiers, 4096);
            if (a2.g(R.styleable.MenuItem_android_checkable)) {
                this.t = a2.a(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.g;
            }
            this.u = a2.a(R.styleable.MenuItem_android_checked, false);
            this.v = a2.a(R.styleable.MenuItem_android_visible, this.h);
            this.w = a2.a(R.styleable.MenuItem_android_enabled, this.i);
            this.x = a2.a(R.styleable.MenuItem_showAsAction, -1);
            this.B = a2.d(R.styleable.MenuItem_android_onClick);
            this.y = a2.g(R.styleable.MenuItem_actionLayout, 0);
            this.z = a2.d(R.styleable.MenuItem_actionViewClass);
            String d2 = a2.d(R.styleable.MenuItem_actionProviderClass);
            this.A = d2;
            boolean z = d2 != null;
            if (z && this.y == 0 && this.z == null) {
                this.f718a = (androidx.core.h.b) a(this.A, g.f711b, g.this.f713d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f718a = null;
            }
            this.C = a2.c(R.styleable.MenuItem_contentDescription);
            this.D = a2.c(R.styleable.MenuItem_tooltipText);
            if (a2.g(R.styleable.MenuItem_iconTintMode)) {
                this.F = ae.a(a2.a(R.styleable.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (a2.g(R.styleable.MenuItem_iconTint)) {
                this.E = a2.e(R.styleable.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            a2.b();
            this.j = false;
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            int i = this.x;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.B != null) {
                if (g.this.f714e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.B));
            }
            if (this.t >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).a(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                }
            }
            String str = this.z;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f710a, g.this.f712c));
                z = true;
            }
            int i2 = this.y;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.h.b bVar = this.f718a;
            if (bVar != null) {
                androidx.core.h.i.a(menuItem, bVar);
            }
            androidx.core.h.i.a(menuItem, this.C);
            androidx.core.h.i.b(menuItem, this.D);
            androidx.core.h.i.b(menuItem, this.p, this.f723q);
            androidx.core.h.i.a(menuItem, this.r, this.s);
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                androidx.core.h.i.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                androidx.core.h.i.a(menuItem, colorStateList);
            }
        }

        public void b() {
            this.j = true;
            a(this.f720c.add(this.f721d, this.k, this.l, this.m));
        }

        public SubMenu c() {
            this.j = true;
            SubMenu addSubMenu = this.f720c.addSubMenu(this.f721d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.j;
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f714e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }
    }
}
