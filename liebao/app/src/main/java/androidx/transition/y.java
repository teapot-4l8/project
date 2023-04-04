package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: b  reason: collision with root package name */
    private static w f2671b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static ThreadLocal<WeakReference<androidx.b.a<ViewGroup, ArrayList<w>>>> f2672c = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<ViewGroup> f2670a = new ArrayList<>();

    static androidx.b.a<ViewGroup, ArrayList<w>> a() {
        androidx.b.a<ViewGroup, ArrayList<w>> aVar;
        WeakReference<androidx.b.a<ViewGroup, ArrayList<w>>> weakReference = f2672c.get();
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            androidx.b.a<ViewGroup, ArrayList<w>> aVar2 = new androidx.b.a<>();
            f2672c.set(new WeakReference<>(aVar2));
            return aVar2;
        }
        return aVar;
    }

    private static void b(ViewGroup viewGroup, w wVar) {
        if (wVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(wVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransitionManager.java */
    /* loaded from: classes.dex */
    public static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        w f2673a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f2674b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        a(w wVar, ViewGroup viewGroup) {
            this.f2673a = wVar;
            this.f2674b = viewGroup;
        }

        private void a() {
            this.f2674b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2674b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            y.f2670a.remove(this.f2674b);
            ArrayList<w> arrayList = y.a().get(this.f2674b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<w> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f2674b);
                }
            }
            this.f2673a.clearValues(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (y.f2670a.remove(this.f2674b)) {
                final androidx.b.a<ViewGroup, ArrayList<w>> a2 = y.a();
                ArrayList<w> arrayList = a2.get(this.f2674b);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    a2.put(this.f2674b, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f2673a);
                this.f2673a.addListener(new x() { // from class: androidx.transition.y.a.1
                    @Override // androidx.transition.x, androidx.transition.w.d
                    public void b(w wVar) {
                        ((ArrayList) a2.get(a.this.f2674b)).remove(wVar);
                    }
                });
                this.f2673a.captureValues(this.f2674b, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((w) it.next()).resume(this.f2674b);
                    }
                }
                this.f2673a.playTransition(this.f2674b);
                return true;
            }
            return true;
        }
    }

    private static void c(ViewGroup viewGroup, w wVar) {
        ArrayList<w> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<w> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (wVar != null) {
            wVar.captureValues(viewGroup, true);
        }
        u a2 = u.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, w wVar) {
        if (f2670a.contains(viewGroup) || !androidx.core.h.w.A(viewGroup)) {
            return;
        }
        f2670a.add(viewGroup);
        if (wVar == null) {
            wVar = f2671b;
        }
        w m0clone = wVar.m0clone();
        c(viewGroup, m0clone);
        u.a(viewGroup, null);
        b(viewGroup, m0clone);
    }
}
