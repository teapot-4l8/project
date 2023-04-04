package androidx.core.h.a;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* compiled from: AccessibilityManagerCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: AccessibilityManagerCompat.java */
    /* loaded from: classes.dex */
    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }

    /* compiled from: AccessibilityManagerCompat.java */
    /* loaded from: classes.dex */
    private static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final a f1659a;

        b(a aVar) {
            this.f1659a = aVar;
        }

        public int hashCode() {
            return this.f1659a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f1659a.equals(((b) obj).f1659a);
            }
            return false;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f1659a.onTouchExplorationStateChanged(z);
        }
    }
}
