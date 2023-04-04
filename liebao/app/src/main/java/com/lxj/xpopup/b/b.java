package com.lxj.xpopup.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.lxj.xpopup.g.b;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: BasePopupView.java */
/* loaded from: classes.dex */
public abstract class b extends FrameLayout implements com.lxj.xpopup.g.a.c {

    /* renamed from: a  reason: collision with root package name */
    private static Stack<b> f5406a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    private int f5407b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5408c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5409d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f5410e;
    private RunnableC0126b f;
    private Runnable g;
    private float h;
    private float i;
    public g k;
    protected com.lxj.xpopup.a.b l;
    protected com.lxj.xpopup.a.e m;
    public com.lxj.xpopup.c.e n;
    Runnable o;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    protected int getImplLayoutId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxWidth() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.lxj.xpopup.a.b getPopupAnimator() {
        return null;
    }

    protected int getPopupHeight() {
        return 0;
    }

    protected abstract int getPopupLayoutId();

    protected int getPopupWidth() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
    }

    protected void q() {
    }

    public b(Context context) {
        super(context);
        this.n = com.lxj.xpopup.c.e.Dismiss;
        this.f5408c = false;
        this.f5409d = false;
        this.f5410e = new Runnable() { // from class: com.lxj.xpopup.b.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.n = com.lxj.xpopup.c.e.Show;
                b.this.q();
                b bVar = b.this;
                if (bVar instanceof com.lxj.xpopup.d.a) {
                    bVar.h();
                }
                if (b.this.k != null && b.this.k.n != null) {
                    b.this.k.n.c();
                }
                if (com.lxj.xpopup.g.c.a((Activity) b.this.getContext()) <= 0 || b.this.f5409d) {
                    return;
                }
                com.lxj.xpopup.g.c.a(com.lxj.xpopup.g.c.a((Activity) b.this.getContext()), b.this);
            }
        };
        this.g = new Runnable() { // from class: com.lxj.xpopup.b.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.p();
                if (b.this.k != null && b.this.k.n != null) {
                    b.this.k.n.d();
                }
                if (b.this.o != null) {
                    b.this.o.run();
                    b.this.o = null;
                }
                b.this.n = com.lxj.xpopup.c.e.Dismiss;
                com.lxj.xpopup.g.a.a.a().b(b.this);
                if (!b.f5406a.isEmpty()) {
                    b.f5406a.pop();
                }
                if (b.this.k != null && b.this.k.w) {
                    if (!b.f5406a.isEmpty()) {
                        ((b) b.f5406a.get(b.f5406a.size() - 1)).h();
                    } else {
                        View findViewById = ((Activity) b.this.getContext()).findViewById(16908290);
                        findViewById.setFocusable(true);
                        findViewById.setFocusableInTouchMode(true);
                    }
                }
                if (b.this.k.o != null) {
                    b.this.k.o.removeView(b.this);
                    com.lxj.xpopup.g.b.a(b.this.k.o, b.this);
                }
            }
        };
        this.f5407b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.m = new com.lxj.xpopup.a.e(this);
        View inflate = LayoutInflater.from(context).inflate(getPopupLayoutId(), (ViewGroup) this, false);
        inflate.setAlpha(0.0f);
        addView(inflate);
    }

    protected void d() {
        if (this.n == com.lxj.xpopup.c.e.Showing) {
            return;
        }
        this.n = com.lxj.xpopup.c.e.Showing;
        com.lxj.xpopup.g.a.a.a().a(getContext());
        com.lxj.xpopup.g.a.a.a().a(this);
        if (!this.f5408c) {
            a();
        }
        if (!(this instanceof com.lxj.xpopup.d.a) && !(this instanceof f)) {
            com.lxj.xpopup.g.c.a(getTargetSizeView(), (getMaxWidth() == 0 || getPopupWidth() <= getMaxWidth()) ? getPopupWidth() : getMaxWidth(), (getMaxHeight() == 0 || getPopupHeight() <= getMaxHeight()) ? getPopupHeight() : getMaxHeight());
        }
        if (!this.f5408c) {
            this.f5408c = true;
            k();
            if (this.k.n != null) {
                this.k.n.a();
            }
        }
        postDelayed(new Runnable() { // from class: com.lxj.xpopup.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(false);
                b.this.getPopupContentView().setAlpha(1.0f);
                b.this.b();
                if (b.this.k.n != null) {
                    b.this.k.n.b();
                }
                b.this.l();
                b.this.g();
                b bVar = b.this;
                if (bVar instanceof com.lxj.xpopup.d.a) {
                    return;
                }
                bVar.h();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.l == null) {
            if (this.k.i != null) {
                com.lxj.xpopup.a.b bVar = this.k.i;
                this.l = bVar;
                bVar.f5373a = getPopupContentView();
            } else {
                com.lxj.xpopup.a.b j = j();
                this.l = j;
                if (j == null) {
                    this.l = getPopupAnimator();
                }
            }
            this.m.a();
            com.lxj.xpopup.a.b bVar2 = this.l;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }

    @Override // com.lxj.xpopup.g.a.c
    public void a(boolean z) {
        if (!z) {
            e();
        } else {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.rightMargin = 0;
        setLayoutParams(layoutParams);
    }

    protected void b(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        boolean z2 = z || com.lxj.xpopup.g.c.c(getContext());
        if (rotation == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = z2 ? com.lxj.xpopup.g.c.b() : 0;
        } else if (rotation == 1) {
            layoutParams.bottomMargin = 0;
            layoutParams.rightMargin = z2 ? com.lxj.xpopup.g.c.b() : 0;
            layoutParams.leftMargin = 0;
        } else if (rotation == 3) {
            layoutParams.bottomMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = z2 ? com.lxj.xpopup.g.c.b() : 0;
        }
        setLayoutParams(layoutParams);
    }

    public b f() {
        if (getParent() != null) {
            return this;
        }
        Activity activity = (Activity) getContext();
        this.k.o = (ViewGroup) activity.getWindow().getDecorView();
        com.lxj.xpopup.g.b.a(activity, this, new b.a() { // from class: com.lxj.xpopup.b.b.2
            @Override // com.lxj.xpopup.g.b.a
            public void a(int i) {
                if (i == 0) {
                    com.lxj.xpopup.g.c.a(b.this);
                    b.this.f5409d = false;
                    return;
                }
                com.lxj.xpopup.g.c.a(i, b.this);
                b.this.f5409d = true;
            }
        });
        this.k.o.post(new Runnable() { // from class: com.lxj.xpopup.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.getParent() != null) {
                    ((ViewGroup) b.this.getParent()).removeView(b.this);
                }
                b.this.k.o.addView(b.this, new FrameLayout.LayoutParams(-1, -1));
                b.this.d();
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        removeCallbacks(this.f5410e);
        postDelayed(this.f5410e, getAnimationDuration());
    }

    public void h() {
        if (this.k.w) {
            setFocusableInTouchMode(true);
            requestFocus();
            if (!f5406a.contains(this)) {
                f5406a.push(this);
            }
        }
        setOnKeyListener(new a());
        if (!this.k.x) {
            a((View) this);
        }
        ArrayList arrayList = new ArrayList();
        com.lxj.xpopup.g.c.a(arrayList, (ViewGroup) getPopupContentView());
        for (int i = 0; i < arrayList.size(); i++) {
            EditText editText = (EditText) arrayList.get(i);
            editText.setOnKeyListener(new a());
            if (i == 0 && this.k.x) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                a(editText);
            }
        }
    }

    protected void a(View view) {
        if (this.k.m.booleanValue()) {
            RunnableC0126b runnableC0126b = this.f;
            if (runnableC0126b == null) {
                this.f = new RunnableC0126b(view);
            } else {
                removeCallbacks(runnableC0126b);
            }
            postDelayed(this.f, 10L);
        }
    }

    protected void i() {
        if (com.lxj.xpopup.g.b.f5516a == 0) {
            n();
        } else {
            com.lxj.xpopup.g.b.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePopupView.java */
    /* renamed from: com.lxj.xpopup.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0126b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        View f5418a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5419b = false;

        public RunnableC0126b(View view) {
            this.f5418a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f5418a;
            if (view == null || this.f5419b) {
                return;
            }
            this.f5419b = true;
            com.lxj.xpopup.g.b.a(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePopupView.java */
    /* loaded from: classes.dex */
    public class a implements View.OnKeyListener {
        a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                if (b.this.k.f5443b.booleanValue() && (b.this.k.n == null || !b.this.k.n.e())) {
                    b.this.i();
                }
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePopupView.java */
    /* renamed from: com.lxj.xpopup.b.b$6  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5416a;

        static {
            int[] iArr = new int[com.lxj.xpopup.c.c.values().length];
            f5416a = iArr;
            try {
                iArr[com.lxj.xpopup.c.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateAlphaFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateAlphaFromTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateAlphaFromRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateAlphaFromBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateFromLeft.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateFromTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateFromRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.TranslateFromBottom.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromLeft.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromLeftTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromRightTop.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromRight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromRightBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromBottom.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.ScrollAlphaFromLeftBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f5416a[com.lxj.xpopup.c.c.NoAnimation.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    protected com.lxj.xpopup.a.b j() {
        g gVar = this.k;
        if (gVar == null || gVar.h == null) {
            return null;
        }
        switch (AnonymousClass6.f5416a[this.k.h.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new com.lxj.xpopup.a.c(getPopupContentView(), this.k.h);
            case 6:
            case 7:
            case 8:
            case 9:
                return new com.lxj.xpopup.a.f(getPopupContentView(), this.k.h);
            case 10:
            case 11:
            case 12:
            case 13:
                return new com.lxj.xpopup.a.g(getPopupContentView(), this.k.h);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return new com.lxj.xpopup.a.d(getPopupContentView(), this.k.h);
            case 22:
                return new com.lxj.xpopup.a.a();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (this.k.f5446e.booleanValue()) {
            this.m.f5386e = this.k.h == com.lxj.xpopup.c.c.NoAnimation;
            this.m.b();
        }
        com.lxj.xpopup.a.b bVar = this.l;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.k.f5446e.booleanValue()) {
            this.m.c();
        }
        com.lxj.xpopup.a.b bVar = this.l;
        if (bVar != null) {
            bVar.c();
        }
    }

    public View getPopupContentView() {
        return getChildAt(0);
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    public int getAnimationDuration() {
        if (this.k.h == com.lxj.xpopup.c.c.NoAnimation) {
            return 10;
        }
        return com.lxj.xpopup.a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getMaxHeight() {
        return this.k.l;
    }

    protected View getTargetSizeView() {
        return getPopupContentView();
    }

    public void n() {
        if (this.n == com.lxj.xpopup.c.e.Dismissing) {
            return;
        }
        this.n = com.lxj.xpopup.c.e.Dismissing;
        if (this.k.m.booleanValue()) {
            com.lxj.xpopup.g.b.b(this);
        }
        clearFocus();
        m();
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        if (this.k.m.booleanValue()) {
            com.lxj.xpopup.g.b.b(this);
        }
        removeCallbacks(this.g);
        postDelayed(this.g, getAnimationDuration());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f5406a.clear();
        removeCallbacks(this.f5410e);
        removeCallbacks(this.g);
        com.lxj.xpopup.g.b.a(this.k.o, this);
        RunnableC0126b runnableC0126b = this.f;
        if (runnableC0126b != null) {
            removeCallbacks(runnableC0126b);
        }
        this.n = com.lxj.xpopup.c.e.Dismiss;
        this.f = null;
        this.f5409d = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getPopupContentView().getGlobalVisibleRect(rect);
        if (!com.lxj.xpopup.g.c.a(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.h = motionEvent.getX();
                this.i = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.h, 2.0d) + Math.pow(motionEvent.getY() - this.i, 2.0d))) < this.f5407b && this.k.f5444c.booleanValue()) {
                    n();
                }
                this.h = 0.0f;
                this.i = 0.0f;
            }
        }
        return true;
    }
}
