package androidx.transition;

import android.os.IBinder;

/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
class at implements av {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f2563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(IBinder iBinder) {
        this.f2563a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof at) && ((at) obj).f2563a.equals(this.f2563a);
    }

    public int hashCode() {
        return this.f2563a.hashCode();
    }
}
