package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f2655a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f2656b;

    public void a() {
        Runnable runnable;
        if (a(this.f2655a) != this || (runnable = this.f2656b) == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, u uVar) {
        view.setTag(R.id.transition_current_scene, uVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u a(View view) {
        return (u) view.getTag(R.id.transition_current_scene);
    }
}
