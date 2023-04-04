package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
class az implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static az j;
    private static az k;

    /* renamed from: a  reason: collision with root package name */
    private final View f1032a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1033b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1034c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f1035d = new Runnable() { // from class: androidx.appcompat.widget.az.1
        @Override // java.lang.Runnable
        public void run() {
            az.this.a(false);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1036e = new Runnable() { // from class: androidx.appcompat.widget.az.2
        @Override // java.lang.Runnable
        public void run() {
            az.this.a();
        }
    };
    private int f;
    private int g;
    private ba h;
    private boolean i;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public static void a(View view, CharSequence charSequence) {
        az azVar = j;
        if (azVar != null && azVar.f1032a == view) {
            a((az) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            az azVar2 = k;
            if (azVar2 != null && azVar2.f1032a == view) {
                azVar2.a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new az(view, charSequence);
    }

    private az(View view, CharSequence charSequence) {
        this.f1032a = view;
        this.f1033b = charSequence;
        this.f1034c = androidx.core.h.x.a(ViewConfiguration.get(view.getContext()));
        d();
        this.f1032a.setOnLongClickListener(this);
        this.f1032a.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h == null || !this.i) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1032a.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    d();
                    a();
                }
            } else if (this.f1032a.isEnabled() && this.h == null && a(motionEvent)) {
                a(this);
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    void a(boolean z) {
        long j2;
        int longPressTimeout;
        long j3;
        if (androidx.core.h.w.D(this.f1032a)) {
            a((az) null);
            az azVar = k;
            if (azVar != null) {
                azVar.a();
            }
            k = this;
            this.i = z;
            ba baVar = new ba(this.f1032a.getContext());
            this.h = baVar;
            baVar.a(this.f1032a, this.f, this.g, this.i, this.f1033b);
            this.f1032a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j3 = 2500;
            } else {
                if ((androidx.core.h.w.q(this.f1032a) & 1) == 1) {
                    j2 = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j2 = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j3 = j2 - longPressTimeout;
            }
            this.f1032a.removeCallbacks(this.f1036e);
            this.f1032a.postDelayed(this.f1036e, j3);
        }
    }

    void a() {
        if (k == this) {
            k = null;
            ba baVar = this.h;
            if (baVar != null) {
                baVar.a();
                this.h = null;
                d();
                this.f1032a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((az) null);
        }
        this.f1032a.removeCallbacks(this.f1036e);
    }

    private static void a(az azVar) {
        az azVar2 = j;
        if (azVar2 != null) {
            azVar2.c();
        }
        j = azVar;
        if (azVar != null) {
            azVar.b();
        }
    }

    private void b() {
        this.f1032a.postDelayed(this.f1035d, ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f1032a.removeCallbacks(this.f1035d);
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f) > this.f1034c || Math.abs(y - this.g) > this.f1034c) {
            this.f = x;
            this.g = y;
            return true;
        }
        return false;
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }
}
