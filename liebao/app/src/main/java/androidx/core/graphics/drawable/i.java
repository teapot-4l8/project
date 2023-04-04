package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WrappedDrawableState.java */
/* loaded from: classes.dex */
public final class i extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f1634a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f1635b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f1636c;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f1637d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(i iVar) {
        this.f1636c = null;
        this.f1637d = g.f1628a;
        if (iVar != null) {
            this.f1634a = iVar.f1634a;
            this.f1635b = iVar.f1635b;
            this.f1636c = iVar.f1636c;
            this.f1637d = iVar.f1637d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new h(this, resources);
        }
        return new g(this, resources);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f1634a;
        Drawable.ConstantState constantState = this.f1635b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f1635b != null;
    }
}
