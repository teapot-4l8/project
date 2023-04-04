package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: GhostViewUtils.java */
/* loaded from: classes.dex */
class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 21) {
            return j.a(view, viewGroup, matrix);
        }
        return i.a(view, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            j.a(view);
        } else {
            i.a(view);
        }
    }
}
