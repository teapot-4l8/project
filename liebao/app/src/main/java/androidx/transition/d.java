package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.ab;
import java.util.Map;

/* compiled from: ChangeImageTransform.java */
/* loaded from: classes.dex */
public class d extends w {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2591a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: b  reason: collision with root package name */
    private static final TypeEvaluator<Matrix> f2592b = new TypeEvaluator<Matrix>() { // from class: androidx.transition.d.1
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final Property<ImageView, Matrix> f2593c = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: androidx.transition.d.2
        @Override // android.util.Property
        /* renamed from: a */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(ImageView imageView, Matrix matrix) {
            m.a(imageView, matrix);
        }
    };

    private void a(ac acVar) {
        View view = acVar.f2510b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = acVar.f2509a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", b(imageView));
        }
    }

    @Override // androidx.transition.w
    public void captureStartValues(ac acVar) {
        a(acVar);
    }

    @Override // androidx.transition.w
    public void captureEndValues(ac acVar) {
        a(acVar);
    }

    @Override // androidx.transition.w
    public String[] getTransitionProperties() {
        return f2591a;
    }

    @Override // androidx.transition.w
    public Animator createAnimator(ViewGroup viewGroup, ac acVar, ac acVar2) {
        ObjectAnimator a2;
        if (acVar != null && acVar2 != null) {
            Rect rect = (Rect) acVar.f2509a.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) acVar2.f2509a.get("android:changeImageTransform:bounds");
            if (rect != null && rect2 != null) {
                Matrix matrix = (Matrix) acVar.f2509a.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) acVar2.f2509a.get("android:changeImageTransform:matrix");
                boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
                if (rect.equals(rect2) && z) {
                    return null;
                }
                ImageView imageView = (ImageView) acVar2.f2510b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                m.a(imageView);
                if (intrinsicWidth == 0 || intrinsicHeight == 0) {
                    a2 = a(imageView);
                } else {
                    if (matrix == null) {
                        matrix = n.f2648a;
                    }
                    if (matrix2 == null) {
                        matrix2 = n.f2648a;
                    }
                    f2593c.set(imageView, matrix);
                    a2 = a(imageView, matrix, matrix2);
                }
                m.a(imageView, a2);
                return a2;
            }
        }
        return null;
    }

    private ObjectAnimator a(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f2593c, (TypeEvaluator) f2592b, (Object[]) new Matrix[]{null, null});
    }

    private ObjectAnimator a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f2593c, (TypeEvaluator) new ab.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChangeImageTransform.java */
    /* renamed from: androidx.transition.d$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2594a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f2594a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2594a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static Matrix b(ImageView imageView) {
        int i = AnonymousClass3.f2594a[imageView.getScaleType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return d(imageView);
            }
            return new Matrix(imageView.getImageMatrix());
        }
        return c(imageView);
    }

    private static Matrix c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    private static Matrix d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f2 = intrinsicHeight;
        float max = Math.max(width / f, height / f2);
        int round = Math.round((width - (f * max)) / 2.0f);
        int round2 = Math.round((height - (f2 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate(round, round2);
        return matrix;
    }
}
