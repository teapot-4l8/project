package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewGroupOverlayApi14.java */
/* loaded from: classes.dex */
public class ae extends ak implements ag {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ae a(ViewGroup viewGroup) {
        return (ae) ak.d(viewGroup);
    }

    @Override // androidx.transition.ag
    public void a(View view) {
        this.f2524a.a(view);
    }

    @Override // androidx.transition.ag
    public void b(View view) {
        this.f2524a.b(view);
    }
}
