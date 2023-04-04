package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
class ah {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static ag a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new af(viewGroup);
        }
        return ae.a(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            aj.a(viewGroup, z);
        } else {
            ai.a(viewGroup, z);
        }
    }
}
