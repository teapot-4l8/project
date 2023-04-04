package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* compiled from: TransitionUtils.java */
/* loaded from: classes.dex */
class ab {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2503a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f2504b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f2505c;

    static {
        f2503a = Build.VERSION.SDK_INT >= 19;
        f2504b = Build.VERSION.SDK_INT >= 18;
        f2505c = Build.VERSION.SDK_INT >= 28;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        an.a(view, matrix);
        an.b(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap a2 = a(view, matrix, rectF, viewGroup);
        if (a2 != null) {
            imageView.setImageBitmap(a2);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap a(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        ViewGroup viewGroup2;
        int i;
        int round;
        int round2;
        if (f2503a) {
            z = !view.isAttachedToWindow();
            if (viewGroup != null) {
                z2 = viewGroup.isAttachedToWindow();
                Bitmap bitmap = null;
                if (f2504b || !z) {
                    viewGroup2 = null;
                    i = 0;
                } else if (!z2) {
                    return null;
                } else {
                    viewGroup2 = (ViewGroup) view.getParent();
                    i = viewGroup2.indexOfChild(view);
                    viewGroup.getOverlay().add(view);
                }
                round = Math.round(rectF.width());
                round2 = Math.round(rectF.height());
                if (round > 0 && round2 > 0) {
                    float min = Math.min(1.0f, 1048576.0f / (round * round2));
                    int round3 = Math.round(round * min);
                    int round4 = Math.round(round2 * min);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    matrix.postScale(min, min);
                    if (!f2505c) {
                        Picture picture = new Picture();
                        Canvas beginRecording = picture.beginRecording(round3, round4);
                        beginRecording.concat(matrix);
                        view.draw(beginRecording);
                        picture.endRecording();
                        bitmap = Bitmap.createBitmap(picture);
                    } else {
                        bitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.concat(matrix);
                        view.draw(canvas);
                    }
                }
                if (f2504b && z) {
                    viewGroup.getOverlay().remove(view);
                    viewGroup2.addView(view, i);
                }
                return bitmap;
            }
        } else {
            z = false;
        }
        z2 = false;
        Bitmap bitmap2 = null;
        if (f2504b) {
        }
        viewGroup2 = null;
        i = 0;
        round = Math.round(rectF.width());
        round2 = Math.round(rectF.height());
        if (round > 0) {
            float min2 = Math.min(1.0f, 1048576.0f / (round * round2));
            int round32 = Math.round(round * min2);
            int round42 = Math.round(round2 * min2);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(min2, min2);
            if (!f2505c) {
            }
        }
        if (f2504b) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, i);
        }
        return bitmap2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Animator a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }

    /* compiled from: TransitionUtils.java */
    /* loaded from: classes.dex */
    static class a implements TypeEvaluator<Matrix> {

        /* renamed from: a  reason: collision with root package name */
        final float[] f2506a = new float[9];

        /* renamed from: b  reason: collision with root package name */
        final float[] f2507b = new float[9];

        /* renamed from: c  reason: collision with root package name */
        final Matrix f2508c = new Matrix();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f2506a);
            matrix2.getValues(this.f2507b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f2507b;
                float f2 = fArr[i];
                float[] fArr2 = this.f2506a;
                fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
            }
            this.f2508c.setValues(this.f2507b);
            return this.f2508c;
        }
    }
}
