package androidx.core.h;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public final class j {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
