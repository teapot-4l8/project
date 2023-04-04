package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.b;

/* compiled from: ActionBar.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: ActionBar.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();
    }

    public abstract int a();

    public androidx.appcompat.view.b a(b.a aVar) {
        return null;
    }

    public void a(Configuration configuration) {
    }

    public void a(CharSequence charSequence) {
    }

    public abstract void a(boolean z);

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public Context b() {
        return null;
    }

    public void b(boolean z) {
    }

    public boolean c() {
        return false;
    }

    public void d(boolean z) {
    }

    public boolean d() {
        return false;
    }

    public void e(boolean z) {
    }

    public boolean e() {
        return false;
    }

    public void f(boolean z) {
    }

    public boolean f() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
    }

    public void c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* compiled from: ActionBar.java */
    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0020a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f575a;

        public C0020a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f575a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f575a = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0020a(int i, int i2) {
            super(i, i2);
            this.f575a = 0;
            this.f575a = 8388627;
        }

        public C0020a(C0020a c0020a) {
            super((ViewGroup.MarginLayoutParams) c0020a);
            this.f575a = 0;
            this.f575a = c0020a.f575a;
        }

        public C0020a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f575a = 0;
        }
    }
}
