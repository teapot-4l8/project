package androidx.activity;

import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<c> f512a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f513b;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f512a = new ArrayDeque<>();
        this.f513b = runnable;
    }

    androidx.activity.a a(c cVar) {
        this.f512a.add(cVar);
        a aVar = new a(cVar);
        cVar.a(aVar);
        return aVar;
    }

    public void a(l lVar, c cVar) {
        h lifecycle = lVar.getLifecycle();
        if (lifecycle.a() == h.b.DESTROYED) {
            return;
        }
        cVar.a(new LifecycleOnBackPressedCancellable(lifecycle, cVar));
    }

    public void a() {
        Iterator<c> descendingIterator = this.f512a.descendingIterator();
        while (descendingIterator.hasNext()) {
            c next = descendingIterator.next();
            if (next.a()) {
                next.c();
                return;
            }
        }
        Runnable runnable = this.f513b;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {

        /* renamed from: b  reason: collision with root package name */
        private final c f519b;

        a(c cVar) {
            this.f519b = cVar;
        }

        @Override // androidx.activity.a
        public void a() {
            OnBackPressedDispatcher.this.f512a.remove(this.f519b);
            this.f519b.b(this);
        }
    }

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements androidx.activity.a, j {

        /* renamed from: b  reason: collision with root package name */
        private final h f515b;

        /* renamed from: c  reason: collision with root package name */
        private final c f516c;

        /* renamed from: d  reason: collision with root package name */
        private androidx.activity.a f517d;

        LifecycleOnBackPressedCancellable(h hVar, c cVar) {
            this.f515b = hVar;
            this.f516c = cVar;
            hVar.a(this);
        }

        @Override // androidx.lifecycle.j
        public void onStateChanged(l lVar, h.a aVar) {
            if (aVar == h.a.ON_START) {
                this.f517d = OnBackPressedDispatcher.this.a(this.f516c);
            } else if (aVar == h.a.ON_STOP) {
                androidx.activity.a aVar2 = this.f517d;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else if (aVar == h.a.ON_DESTROY) {
                a();
            }
        }

        @Override // androidx.activity.a
        public void a() {
            this.f515b.b(this);
            this.f516c.b(this);
            androidx.activity.a aVar = this.f517d;
            if (aVar != null) {
                aVar.a();
                this.f517d = null;
            }
        }
    }
}
