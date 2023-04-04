package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
class au implements av {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f2564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(View view) {
        this.f2564a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof au) && ((au) obj).f2564a.equals(this.f2564a);
    }

    public int hashCode() {
        return this.f2564a.hashCode();
    }
}
