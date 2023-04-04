package q.rorbin.badgeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

/* compiled from: BadgeAnimator.java */
/* loaded from: classes2.dex */
public class b extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    private a[][] f7845a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<e> f7846b;

    public b(Bitmap bitmap, PointF pointF, e eVar) {
        this.f7846b = new WeakReference<>(eVar);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.f7845a = a(bitmap, pointF);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: q.rorbin.badgeview.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e eVar2 = (e) b.this.f7846b.get();
                if (eVar2 == null || !eVar2.isShown()) {
                    b.this.cancel();
                } else {
                    eVar2.invalidate();
                }
            }
        });
        addListener(new AnimatorListenerAdapter() { // from class: q.rorbin.badgeview.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e eVar2 = (e) b.this.f7846b.get();
                if (eVar2 != null) {
                    eVar2.b();
                }
            }
        });
    }

    public void a(Canvas canvas) {
        for (int i = 0; i < this.f7845a.length; i++) {
            int i2 = 0;
            while (true) {
                a[][] aVarArr = this.f7845a;
                if (i2 < aVarArr[i].length) {
                    aVarArr[i][i2].a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i2++;
                }
            }
        }
    }

    private a[][] a(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(width, height) / 6.0f;
        float width2 = pointF.x - (bitmap.getWidth() / 2.0f);
        float height2 = pointF.y - (bitmap.getHeight() / 2.0f);
        a[][] aVarArr = (a[][]) Array.newInstance(a.class, (int) (height / min), (int) (width / min));
        for (int i = 0; i < aVarArr.length; i++) {
            for (int i2 = 0; i2 < aVarArr[i].length; i2++) {
                a aVar = new a();
                float f = i2 * min;
                float f2 = i * min;
                aVar.f7853e = bitmap.getPixel((int) f, (int) f2);
                aVar.f7850b = f + width2;
                aVar.f7851c = f2 + height2;
                aVar.f7852d = min;
                aVar.f = Math.max(width, height);
                aVarArr[i][i2] = aVar;
            }
        }
        bitmap.recycle();
        return aVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BadgeAnimator.java */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        Random f7849a;

        /* renamed from: b  reason: collision with root package name */
        float f7850b;

        /* renamed from: c  reason: collision with root package name */
        float f7851c;

        /* renamed from: d  reason: collision with root package name */
        float f7852d;

        /* renamed from: e  reason: collision with root package name */
        int f7853e;
        int f;
        Paint g;

        public a() {
            Paint paint = new Paint();
            this.g = paint;
            paint.setAntiAlias(true);
            this.g.setStyle(Paint.Style.FILL);
            this.f7849a = new Random();
        }

        public void a(float f, Canvas canvas) {
            this.g.setColor(this.f7853e);
            this.f7850b += this.f7849a.nextInt(this.f) * 0.1f * (this.f7849a.nextFloat() - 0.5f);
            float nextInt = this.f7851c + (this.f7849a.nextInt(this.f) * 0.1f * (this.f7849a.nextFloat() - 0.5f));
            this.f7851c = nextInt;
            float f2 = this.f7850b;
            float f3 = this.f7852d;
            canvas.drawCircle(f2, nextInt, f3 - (f * f3), this.g);
        }
    }
}
