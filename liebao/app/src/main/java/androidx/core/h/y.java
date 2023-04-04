package androidx.core.h;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.R;

/* compiled from: ViewGroupCompat.java */
/* loaded from: classes.dex */
public final class y {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(R.id.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && w.p(viewGroup) == null) ? false : true;
    }
}
