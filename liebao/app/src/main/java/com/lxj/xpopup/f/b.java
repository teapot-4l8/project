package com.lxj.xpopup.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomGestureDetector.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f5483a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f5484b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final ScaleGestureDetector f5485c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f5486d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5487e;
    private float f;
    private float g;
    private final float h;
    private final float i;
    private c j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = viewConfiguration.getScaledTouchSlop();
        this.j = cVar;
        this.f5485c = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.lxj.xpopup.f.b.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                if (scaleFactor >= 0.0f) {
                    b.this.j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    return true;
                }
                return true;
            }
        });
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f5484b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f5484b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean a() {
        return this.f5485c.isInProgress();
    }

    public boolean b() {
        return this.f5487e;
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            if (motionEvent.getPointerCount() > 1) {
                this.f5485c.onTouchEvent(motionEvent);
            }
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f5483a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f5486d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f = b(motionEvent);
            this.g = c(motionEvent);
            this.f5487e = false;
        } else if (action == 1) {
            this.f5483a = -1;
            if (this.f5487e && this.f5486d != null) {
                this.f = b(motionEvent);
                this.g = c(motionEvent);
                this.f5486d.addMovement(motionEvent);
                this.f5486d.computeCurrentVelocity(1000);
                float xVelocity = this.f5486d.getXVelocity();
                float yVelocity = this.f5486d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i) {
                    this.j.a(this.f, this.g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f5486d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f5486d = null;
            }
        } else if (action == 2) {
            float b2 = b(motionEvent);
            float c2 = c(motionEvent);
            float f = b2 - this.f;
            float f2 = c2 - this.g;
            if (!this.f5487e) {
                this.f5487e = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.h);
            }
            if (this.f5487e) {
                this.j.a(f, f2);
                this.f = b2;
                this.g = c2;
                VelocityTracker velocityTracker2 = this.f5486d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f5483a = -1;
            VelocityTracker velocityTracker3 = this.f5486d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f5486d = null;
            }
        } else if (action == 6) {
            int a2 = m.a(motionEvent.getAction());
            if (motionEvent.getPointerId(a2) == this.f5483a) {
                int i = a2 == 0 ? 1 : 0;
                this.f5483a = motionEvent.getPointerId(i);
                this.f = motionEvent.getX(i);
                this.g = motionEvent.getY(i);
            }
        }
        int i2 = this.f5483a;
        this.f5484b = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return true;
    }
}
