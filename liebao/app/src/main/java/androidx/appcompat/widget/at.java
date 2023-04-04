package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class at extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1009a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<at>> f1010b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f1011c;

    /* renamed from: d  reason: collision with root package name */
    private final Resources.Theme f1012d;

    public static Context a(Context context) {
        if (b(context)) {
            synchronized (f1009a) {
                if (f1010b == null) {
                    f1010b = new ArrayList<>();
                } else {
                    for (int size = f1010b.size() - 1; size >= 0; size--) {
                        WeakReference<at> weakReference = f1010b.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f1010b.remove(size);
                        }
                    }
                    for (int size2 = f1010b.size() - 1; size2 >= 0; size2--) {
                        WeakReference<at> weakReference2 = f1010b.get(size2);
                        at atVar = weakReference2 != null ? weakReference2.get() : null;
                        if (atVar != null && atVar.getBaseContext() == context) {
                            return atVar;
                        }
                    }
                }
                at atVar2 = new at(context);
                f1010b.add(new WeakReference<>(atVar2));
                return atVar2;
            }
        }
        return context;
    }

    private static boolean b(Context context) {
        if ((context instanceof at) || (context.getResources() instanceof av) || (context.getResources() instanceof bb)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || bb.a();
    }

    private at(Context context) {
        super(context);
        if (bb.a()) {
            bb bbVar = new bb(this, context.getResources());
            this.f1011c = bbVar;
            Resources.Theme newTheme = bbVar.newTheme();
            this.f1012d = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f1011c = new av(this, context.getResources());
        this.f1012d = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1012d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.f1012d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1011c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1011c.getAssets();
    }
}
