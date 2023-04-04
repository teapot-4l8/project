package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ImageViewUtils.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2645a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2646b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView) {
        if (Build.VERSION.SDK_INT < 21) {
            ImageView.ScaleType scaleType = imageView.getScaleType();
            imageView.setTag(R.id.save_scale_type, scaleType);
            if (scaleType == ImageView.ScaleType.MATRIX) {
                imageView.setTag(R.id.save_image_matrix, imageView.getImageMatrix());
            } else {
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
            }
            imageView.setImageMatrix(n.f2648a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT < 21) {
            imageView.setImageMatrix(matrix);
            return;
        }
        a();
        Method method = f2645a;
        if (method != null) {
            try {
                method.invoke(imageView, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private static void a() {
        if (f2646b) {
            return;
        }
        try {
            Method declaredMethod = ImageView.class.getDeclaredMethod("animateTransform", Matrix.class);
            f2645a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ImageViewUtils", "Failed to retrieve animateTransform method", e2);
        }
        f2646b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final ImageView imageView, Animator animator) {
        if (Build.VERSION.SDK_INT < 21) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.m.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    ImageView.ScaleType scaleType = (ImageView.ScaleType) imageView.getTag(R.id.save_scale_type);
                    imageView.setScaleType(scaleType);
                    imageView.setTag(R.id.save_scale_type, null);
                    if (scaleType == ImageView.ScaleType.MATRIX) {
                        ImageView imageView2 = imageView;
                        imageView2.setImageMatrix((Matrix) imageView2.getTag(R.id.save_image_matrix));
                        imageView.setTag(R.id.save_image_matrix, null);
                    }
                    animator2.removeListener(this);
                }
            });
        }
    }
}
