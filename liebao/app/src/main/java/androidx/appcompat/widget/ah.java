package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class ah implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f947a;

    /* renamed from: b  reason: collision with root package name */
    private final int f948b;

    /* renamed from: c  reason: collision with root package name */
    final View f949c;

    /* renamed from: d  reason: collision with root package name */
    private final int f950d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f951e;
    private Runnable f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    public abstract androidx.appcompat.view.menu.p a();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public ah(View view) {
        this.f949c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f947a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f948b = tapTimeout;
        this.f950d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = b(motionEvent) || !c();
        } else {
            z = a(motionEvent) && b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f949c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        Runnable runnable = this.f951e;
        if (runnable != null) {
            this.f949c.removeCallbacks(runnable);
        }
    }

    protected boolean b() {
        androidx.appcompat.view.menu.p a2 = a();
        if (a2 == null || a2.c()) {
            return true;
        }
        a2.b_();
        return true;
    }

    protected boolean c() {
        androidx.appcompat.view.menu.p a2 = a();
        if (a2 == null || !a2.c()) {
            return true;
        }
        a2.b();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(MotionEvent motionEvent) {
        View view = this.f949c;
        if (view.isEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.h = motionEvent.getPointerId(0);
                if (this.f951e == null) {
                    this.f951e = new a();
                }
                view.postDelayed(this.f951e, this.f948b);
                if (this.f == null) {
                    this.f = new b();
                }
                view.postDelayed(this.f, this.f950d);
            } else {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.h);
                        if (findPointerIndex >= 0 && !a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f947a)) {
                            e();
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return true;
                        }
                    }
                }
                e();
            }
            return false;
        }
        return false;
    }

    private void e() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.f949c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f951e;
        if (runnable2 != null) {
            this.f949c.removeCallbacks(runnable2);
        }
    }

    void d() {
        e();
        View view = this.f949c;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.g = true;
        }
    }

    private boolean b(MotionEvent motionEvent) {
        af afVar;
        View view = this.f949c;
        androidx.appcompat.view.menu.p a2 = a();
        if (a2 == null || !a2.c() || (afVar = (af) a2.c_()) == null || !afVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        b(view, obtainNoHistory);
        a(afVar, obtainNoHistory);
        boolean a3 = afVar.a(obtainNoHistory, this.h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a3 && (actionMasked != 1 && actionMasked != 3);
    }

    private static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] iArr = this.i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ah.this.f949c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ah.this.d();
        }
    }
}
