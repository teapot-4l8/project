package androidx.core.h;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: GestureDetectorCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f1709a;

    /* compiled from: GestureDetectorCompat.java */
    /* loaded from: classes.dex */
    interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* compiled from: GestureDetectorCompat.java */
    /* loaded from: classes.dex */
    static class b implements a {
        private static final int j = ViewConfiguration.getLongPressTimeout();
        private static final int k = ViewConfiguration.getTapTimeout();
        private static final int l = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        final GestureDetector.OnGestureListener f1710a;

        /* renamed from: b  reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f1711b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1712c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1713d;

        /* renamed from: e  reason: collision with root package name */
        MotionEvent f1714e;
        private int f;
        private int g;
        private int h;
        private int i;
        private final Handler m;
        private boolean n;
        private boolean o;
        private boolean p;

        /* renamed from: q  reason: collision with root package name */
        private MotionEvent f1715q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        /* compiled from: GestureDetectorCompat.java */
        /* loaded from: classes.dex */
        private class a extends Handler {
            a() {
            }

            a(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    b.this.f1710a.onShowPress(b.this.f1714e);
                } else if (i == 2) {
                    b.this.a();
                } else if (i == 3) {
                    if (b.this.f1711b != null) {
                        if (!b.this.f1712c) {
                            b.this.f1711b.onSingleTapConfirmed(b.this.f1714e);
                        } else {
                            b.this.f1713d = true;
                        }
                    }
                } else {
                    throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.m = new a(handler);
            } else {
                this.m = new a();
            }
            this.f1710a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f1710a == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.h = viewConfiguration.getScaledMinimumFlingVelocity();
            this.i = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f = scaledTouchSlop * scaledTouchSlop;
            this.g = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f1711b = onDoubleTapListener;
        }

        /* JADX WARN: Removed duplicated region for block: B:107:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x021f  */
        @Override // androidx.core.h.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(MotionEvent motionEvent) {
            boolean z;
            MotionEvent motionEvent2;
            MotionEvent motionEvent3;
            boolean onFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(motionEvent);
            int i = action & 255;
            boolean z2 = i == 6;
            int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    f += motionEvent.getX(i2);
                    f2 += motionEvent.getY(i2);
                }
            }
            float f3 = z2 ? pointerCount - 1 : pointerCount;
            float f4 = f / f3;
            float f5 = f2 / f3;
            if (i == 0) {
                if (this.f1711b != null) {
                    boolean hasMessages = this.m.hasMessages(3);
                    if (hasMessages) {
                        this.m.removeMessages(3);
                    }
                    MotionEvent motionEvent4 = this.f1714e;
                    if (motionEvent4 != null && (motionEvent3 = this.f1715q) != null && hasMessages && a(motionEvent4, motionEvent3, motionEvent)) {
                        this.r = true;
                        z = this.f1711b.onDoubleTap(this.f1714e) | false | this.f1711b.onDoubleTapEvent(motionEvent);
                        this.s = f4;
                        this.u = f4;
                        this.t = f5;
                        this.v = f5;
                        motionEvent2 = this.f1714e;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.f1714e = MotionEvent.obtain(motionEvent);
                        this.o = true;
                        this.p = true;
                        this.f1712c = true;
                        this.n = false;
                        this.f1713d = false;
                        if (this.w) {
                            this.m.removeMessages(2);
                            this.m.sendEmptyMessageAtTime(2, this.f1714e.getDownTime() + k + j);
                        }
                        this.m.sendEmptyMessageAtTime(1, this.f1714e.getDownTime() + k);
                        return z | this.f1710a.onDown(motionEvent);
                    }
                    this.m.sendEmptyMessageDelayed(3, l);
                }
                z = false;
                this.s = f4;
                this.u = f4;
                this.t = f5;
                this.v = f5;
                motionEvent2 = this.f1714e;
                if (motionEvent2 != null) {
                }
                this.f1714e = MotionEvent.obtain(motionEvent);
                this.o = true;
                this.p = true;
                this.f1712c = true;
                this.n = false;
                this.f1713d = false;
                if (this.w) {
                }
                this.m.sendEmptyMessageAtTime(1, this.f1714e.getDownTime() + k);
                return z | this.f1710a.onDown(motionEvent);
            }
            if (i == 1) {
                this.f1712c = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.r) {
                    onFling = this.f1711b.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.n) {
                        this.m.removeMessages(3);
                        this.n = false;
                    } else if (this.o) {
                        boolean onSingleTapUp = this.f1710a.onSingleTapUp(motionEvent);
                        if (this.f1713d && (onDoubleTapListener = this.f1711b) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        onFling = onSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.x;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.i);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.h || Math.abs(xVelocity) > this.h) {
                            onFling = this.f1710a.onFling(this.f1714e, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    onFling = false;
                }
                MotionEvent motionEvent5 = this.f1715q;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.f1715q = obtain;
                VelocityTracker velocityTracker2 = this.x;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.x = null;
                }
                this.r = false;
                this.f1713d = false;
                this.m.removeMessages(1);
                this.m.removeMessages(2);
            } else if (i != 2) {
                if (i == 3) {
                    b();
                    return false;
                } else if (i == 5) {
                    this.s = f4;
                    this.u = f4;
                    this.t = f5;
                    this.v = f5;
                    c();
                    return false;
                } else if (i != 6) {
                    return false;
                } else {
                    this.s = f4;
                    this.u = f4;
                    this.t = f5;
                    this.v = f5;
                    this.x.computeCurrentVelocity(1000, this.i);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.x.getXVelocity(pointerId2);
                    float yVelocity2 = this.x.getYVelocity(pointerId2);
                    for (int i3 = 0; i3 < pointerCount; i3++) {
                        if (i3 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i3);
                            if ((this.x.getXVelocity(pointerId3) * xVelocity2) + (this.x.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                this.x.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
            } else if (this.n) {
                return false;
            } else {
                float f6 = this.s - f4;
                float f7 = this.t - f5;
                if (this.r) {
                    return false | this.f1711b.onDoubleTapEvent(motionEvent);
                }
                if (this.o) {
                    int i4 = (int) (f4 - this.u);
                    int i5 = (int) (f5 - this.v);
                    int i6 = (i4 * i4) + (i5 * i5);
                    if (i6 > this.f) {
                        onFling = this.f1710a.onScroll(this.f1714e, motionEvent, f6, f7);
                        this.s = f4;
                        this.t = f5;
                        this.o = false;
                        this.m.removeMessages(3);
                        this.m.removeMessages(1);
                        this.m.removeMessages(2);
                    } else {
                        onFling = false;
                    }
                    if (i6 > this.f) {
                        this.p = false;
                    }
                } else if (Math.abs(f6) >= 1.0f || Math.abs(f7) >= 1.0f) {
                    boolean onScroll = this.f1710a.onScroll(this.f1714e, motionEvent, f6, f7);
                    this.s = f4;
                    this.t = f5;
                    return onScroll;
                } else {
                    return false;
                }
            }
            return onFling;
        }

        private void b() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.f1712c = false;
            this.o = false;
            this.p = false;
            this.f1713d = false;
            if (this.n) {
                this.n = false;
            }
        }

        private void c() {
            this.m.removeMessages(1);
            this.m.removeMessages(2);
            this.m.removeMessages(3);
            this.r = false;
            this.o = false;
            this.p = false;
            this.f1713d = false;
            if (this.n) {
                this.n = false;
            }
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (this.p && motionEvent3.getEventTime() - motionEvent2.getEventTime() <= l) {
                int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
                int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
                return (x * x) + (y * y) < this.g;
            }
            return false;
        }

        void a() {
            this.m.removeMessages(3);
            this.f1713d = false;
            this.n = true;
            this.f1710a.onLongPress(this.f1714e);
        }
    }

    /* compiled from: GestureDetectorCompat.java */
    /* loaded from: classes.dex */
    static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f1717a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f1717a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.h.d.a
        public boolean a(MotionEvent motionEvent) {
            return this.f1717a.onTouchEvent(motionEvent);
        }
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f1709a = new c(context, onGestureListener, handler);
        } else {
            this.f1709a = new b(context, onGestureListener, handler);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f1709a.a(motionEvent);
    }
}
