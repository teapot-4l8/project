package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ChangeTransform.java */
/* loaded from: classes.dex */
public class e extends w {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f2595b = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: c  reason: collision with root package name */
    private static final Property<b, float[]> f2596c = new Property<b, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.e.1
        @Override // android.util.Property
        /* renamed from: a */
        public float[] get(b bVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(b bVar, float[] fArr) {
            bVar.a(fArr);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Property<b, PointF> f2597d = new Property<b, PointF>(PointF.class, "translations") { // from class: androidx.transition.e.2
        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(b bVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(b bVar, PointF pointF) {
            bVar.a(pointF);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f2598e;

    /* renamed from: a  reason: collision with root package name */
    boolean f2599a = true;
    private boolean f = true;
    private Matrix g = new Matrix();

    static {
        f2598e = Build.VERSION.SDK_INT >= 21;
    }

    @Override // androidx.transition.w
    public String[] getTransitionProperties() {
        return f2595b;
    }

    private void a(ac acVar) {
        View view = acVar.f2510b;
        if (view.getVisibility() == 8) {
            return;
        }
        acVar.f2509a.put("android:changeTransform:parent", view.getParent());
        acVar.f2509a.put("android:changeTransform:transforms", new c(view));
        Matrix matrix = view.getMatrix();
        acVar.f2509a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            an.a(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            acVar.f2509a.put("android:changeTransform:parentMatrix", matrix2);
            acVar.f2509a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
            acVar.f2509a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
        }
    }

    @Override // androidx.transition.w
    public void captureStartValues(ac acVar) {
        a(acVar);
        if (f2598e) {
            return;
        }
        ((ViewGroup) acVar.f2510b.getParent()).startViewTransition(acVar.f2510b);
    }

    @Override // androidx.transition.w
    public void captureEndValues(ac acVar) {
        a(acVar);
    }

    @Override // androidx.transition.w
    public Animator createAnimator(ViewGroup viewGroup, ac acVar, ac acVar2) {
        if (acVar == null || acVar2 == null || !acVar.f2509a.containsKey("android:changeTransform:parent") || !acVar2.f2509a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) acVar.f2509a.get("android:changeTransform:parent");
        boolean z = this.f && !a(viewGroup2, (ViewGroup) acVar2.f2509a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) acVar.f2509a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            acVar.f2509a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) acVar.f2509a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            acVar.f2509a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            a(acVar, acVar2);
        }
        ObjectAnimator a2 = a(acVar, acVar2, z);
        if (z && a2 != null && this.f2599a) {
            a(viewGroup, acVar, acVar2);
        } else if (!f2598e) {
            viewGroup2.endViewTransition(acVar.f2510b);
        }
        return a2;
    }

    private ObjectAnimator a(ac acVar, ac acVar2, final boolean z) {
        Matrix matrix = (Matrix) acVar.f2509a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) acVar2.f2509a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = n.f2648a;
        }
        if (matrix2 == null) {
            matrix2 = n.f2648a;
        }
        final Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final c cVar = (c) acVar2.f2509a.get("android:changeTransform:transforms");
        final View view = acVar2.f2510b;
        a(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        final b bVar = new b(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bVar, PropertyValuesHolder.ofObject(f2596c, new g(new float[9]), fArr, fArr2), s.a(f2597d, getPathMotion().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: androidx.transition.e.3
            private boolean g;
            private Matrix h = new Matrix();

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.g = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.g) {
                    if (z && e.this.f2599a) {
                        a(matrix3);
                    } else {
                        view.setTag(R.id.transition_transform, null);
                        view.setTag(R.id.parent_matrix, null);
                    }
                }
                an.c(view, null);
                cVar.a(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                a(bVar.a());
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                e.a(view);
            }

            private void a(Matrix matrix4) {
                this.h.set(matrix4);
                view.setTag(R.id.transition_transform, this.h);
                cVar.a(view);
            }
        };
        ofPropertyValuesHolder.addListener(animatorListenerAdapter);
        androidx.transition.a.a(ofPropertyValuesHolder, animatorListenerAdapter);
        return ofPropertyValuesHolder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r5 == r4.f2510b) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r4 == r5) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        boolean z = true;
        if (isValidTarget(viewGroup) && isValidTarget(viewGroup2)) {
            ac matchedTransitionValues = getMatchedTransitionValues(viewGroup, true);
            if (matchedTransitionValues == null) {
                return false;
            }
        }
    }

    private void a(ViewGroup viewGroup, ac acVar, ac acVar2) {
        View view = acVar2.f2510b;
        Matrix matrix = new Matrix((Matrix) acVar2.f2509a.get("android:changeTransform:parentMatrix"));
        an.b(viewGroup, matrix);
        k a2 = l.a(view, viewGroup, matrix);
        if (a2 == null) {
            return;
        }
        a2.a((ViewGroup) acVar.f2509a.get("android:changeTransform:parent"), acVar.f2510b);
        w wVar = this;
        while (wVar.mParent != null) {
            wVar = wVar.mParent;
        }
        wVar.addListener(new a(view, a2));
        if (f2598e) {
            if (acVar.f2510b != acVar2.f2510b) {
                an.a(acVar.f2510b, 0.0f);
            }
            an.a(view, 1.0f);
        }
    }

    private void a(ac acVar, ac acVar2) {
        Matrix matrix = (Matrix) acVar2.f2509a.get("android:changeTransform:parentMatrix");
        acVar2.f2510b.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.g;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) acVar.f2509a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            acVar.f2509a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) acVar.f2509a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    static void a(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        androidx.core.h.w.b(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final float f2612a;

        /* renamed from: b  reason: collision with root package name */
        final float f2613b;

        /* renamed from: c  reason: collision with root package name */
        final float f2614c;

        /* renamed from: d  reason: collision with root package name */
        final float f2615d;

        /* renamed from: e  reason: collision with root package name */
        final float f2616e;
        final float f;
        final float g;
        final float h;

        c(View view) {
            this.f2612a = view.getTranslationX();
            this.f2613b = view.getTranslationY();
            this.f2614c = androidx.core.h.w.o(view);
            this.f2615d = view.getScaleX();
            this.f2616e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            e.a(view, this.f2612a, this.f2613b, this.f2614c, this.f2615d, this.f2616e, this.f, this.g, this.h);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.f2612a == this.f2612a && cVar.f2613b == this.f2613b && cVar.f2614c == this.f2614c && cVar.f2615d == this.f2615d && cVar.f2616e == this.f2616e && cVar.f == this.f && cVar.g == this.g && cVar.h == this.h;
            }
            return false;
        }

        public int hashCode() {
            float f = this.f2612a;
            int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.f2613b;
            int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.f2614c;
            int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f2615d;
            int floatToIntBits4 = (floatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f2616e;
            int floatToIntBits5 = (floatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f;
            int floatToIntBits6 = (floatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.g;
            int floatToIntBits7 = (floatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.h;
            return floatToIntBits7 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    public static class a extends x {

        /* renamed from: a  reason: collision with root package name */
        private View f2605a;

        /* renamed from: b  reason: collision with root package name */
        private k f2606b;

        a(View view, k kVar) {
            this.f2605a = view;
            this.f2606b = kVar;
        }

        @Override // androidx.transition.x, androidx.transition.w.d
        public void b(w wVar) {
            wVar.removeListener(this);
            l.a(this.f2605a);
            this.f2605a.setTag(R.id.transition_transform, null);
            this.f2605a.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.x, androidx.transition.w.d
        public void c(w wVar) {
            this.f2606b.setVisibility(4);
        }

        @Override // androidx.transition.x, androidx.transition.w.d
        public void d(w wVar) {
            this.f2606b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChangeTransform.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Matrix f2607a = new Matrix();

        /* renamed from: b  reason: collision with root package name */
        private final View f2608b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f2609c;

        /* renamed from: d  reason: collision with root package name */
        private float f2610d;

        /* renamed from: e  reason: collision with root package name */
        private float f2611e;

        b(View view, float[] fArr) {
            this.f2608b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f2609c = fArr2;
            this.f2610d = fArr2[2];
            this.f2611e = fArr2[5];
            b();
        }

        void a(float[] fArr) {
            System.arraycopy(fArr, 0, this.f2609c, 0, fArr.length);
            b();
        }

        void a(PointF pointF) {
            this.f2610d = pointF.x;
            this.f2611e = pointF.y;
            b();
        }

        private void b() {
            float[] fArr = this.f2609c;
            fArr[2] = this.f2610d;
            fArr[5] = this.f2611e;
            this.f2607a.setValues(fArr);
            an.c(this.f2608b, this.f2607a);
        }

        Matrix a() {
            return this.f2607a;
        }
    }
}
