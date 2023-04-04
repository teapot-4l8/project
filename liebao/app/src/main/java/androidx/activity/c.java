package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f528a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f529b = new CopyOnWriteArrayList<>();

    public abstract void c();

    public c(boolean z) {
        this.f528a = z;
    }

    public final void a(boolean z) {
        this.f528a = z;
    }

    public final boolean a() {
        return this.f528a;
    }

    public final void b() {
        Iterator<a> it = this.f529b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f529b.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f529b.remove(aVar);
    }
}
