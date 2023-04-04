package com.lxj.xpopup.f;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.o;

/* compiled from: PhotoView.java */
/* loaded from: classes.dex */
public class k extends o {

    /* renamed from: a  reason: collision with root package name */
    public l f5489a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f5490b;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f5489a = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f5490b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f5490b = null;
        }
    }

    public l getAttacher() {
        return this.f5489a;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f5489a.f();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f5489a.h();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f5489a.a(onLongClickListener);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5489a.a(onClickListener);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        l lVar = this.f5489a;
        if (lVar == null) {
            this.f5490b = scaleType;
        } else {
            lVar.a(scaleType);
        }
    }

    @Override // androidx.appcompat.widget.o, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.f5489a;
        if (lVar != null) {
            lVar.g();
        }
    }

    @Override // androidx.appcompat.widget.o, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        l lVar = this.f5489a;
        if (lVar != null) {
            lVar.g();
        }
    }

    @Override // androidx.appcompat.widget.o, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.f5489a;
        if (lVar != null) {
            lVar.g();
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f5489a.g();
        }
        return frame;
    }

    public void setRotationTo(float f) {
        this.f5489a.a(f);
    }

    public void setRotationBy(float f) {
        this.f5489a.b(f);
    }

    public void setZoomable(boolean z) {
        this.f5489a.b(z);
    }

    public RectF getDisplayRect() {
        return this.f5489a.a();
    }

    public void a(Matrix matrix) {
        this.f5489a.b(matrix);
    }

    public boolean b(Matrix matrix) {
        return this.f5489a.a(matrix);
    }

    public float getMinimumScale() {
        return this.f5489a.b();
    }

    public float getMediumScale() {
        return this.f5489a.c();
    }

    public float getMaximumScale() {
        return this.f5489a.d();
    }

    public float getScale() {
        return this.f5489a.e();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f5489a.a(z);
    }

    public void setMinimumScale(float f) {
        this.f5489a.c(f);
    }

    public void setMediumScale(float f) {
        this.f5489a.d(f);
    }

    public void setMaximumScale(float f) {
        this.f5489a.e(f);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f5489a.a(dVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f5489a.a(fVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f5489a.a(eVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f5489a.a(jVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f5489a.a(iVar);
    }

    public void setScale(float f) {
        this.f5489a.f(f);
    }

    public void setZoomTransitionDuration(int i) {
        this.f5489a.a(i);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f5489a.a(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f5489a.a(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f5489a.a(hVar);
    }
}
