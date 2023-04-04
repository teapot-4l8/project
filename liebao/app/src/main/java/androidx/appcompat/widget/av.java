package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
class av extends an {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f1017a;

    public av(Context context, Resources resources) {
        super(resources);
        this.f1017a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.an, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f1017a.get();
        if (drawable != null && context != null) {
            am.a().a(context, i, drawable);
        }
        return drawable;
    }
}
