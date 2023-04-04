package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.recyclerview.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ItemTouchUIUtilImpl.java */
/* loaded from: classes.dex */
public class n implements m {

    /* renamed from: a  reason: collision with root package name */
    static final m f2353a = new n();

    @Override // androidx.recyclerview.widget.m
    public void b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
    }

    @Override // androidx.recyclerview.widget.m
    public void b(View view) {
    }

    n() {
    }

    @Override // androidx.recyclerview.widget.m
    public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(androidx.core.h.w.n(view));
            androidx.core.h.w.a(view, a(recyclerView, view) + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    private static float a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float n = androidx.core.h.w.n(childAt);
                if (n > f) {
                    f = n;
                }
            }
        }
        return f;
    }

    @Override // androidx.recyclerview.widget.m
    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                androidx.core.h.w.a(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.item_touch_helper_previous_elevation, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }
}
