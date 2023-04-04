package com.lxj.xpopup.f;

import android.widget.ImageView;

/* compiled from: Util.java */
/* loaded from: classes.dex */
class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        return (i & 65280) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f2 >= f3) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* compiled from: Util.java */
    /* renamed from: com.lxj.xpopup.f.m$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5510a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f5510a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(ImageView.ScaleType scaleType) {
        return (scaleType == null || AnonymousClass1.f5510a[scaleType.ordinal()] == 1) ? false : true;
    }
}
