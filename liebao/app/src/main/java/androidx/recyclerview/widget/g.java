package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class g extends w {
    private static TimeInterpolator i;
    private ArrayList<RecyclerView.x> j = new ArrayList<>();
    private ArrayList<RecyclerView.x> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();
    private ArrayList<a> m = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.x>> f2246a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ArrayList<b>> f2247b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<ArrayList<a>> f2248c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<RecyclerView.x> f2249d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<RecyclerView.x> f2250e = new ArrayList<>();
    ArrayList<RecyclerView.x> f = new ArrayList<>();
    ArrayList<RecyclerView.x> g = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.x f2283a;

        /* renamed from: b  reason: collision with root package name */
        public int f2284b;

        /* renamed from: c  reason: collision with root package name */
        public int f2285c;

        /* renamed from: d  reason: collision with root package name */
        public int f2286d;

        /* renamed from: e  reason: collision with root package name */
        public int f2287e;

        b(RecyclerView.x xVar, int i, int i2, int i3, int i4) {
            this.f2283a = xVar;
            this.f2284b = i;
            this.f2285c = i2;
            this.f2286d = i3;
            this.f2287e = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.x f2278a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.x f2279b;

        /* renamed from: c  reason: collision with root package name */
        public int f2280c;

        /* renamed from: d  reason: collision with root package name */
        public int f2281d;

        /* renamed from: e  reason: collision with root package name */
        public int f2282e;
        public int f;

        private a(RecyclerView.x xVar, RecyclerView.x xVar2) {
            this.f2278a = xVar;
            this.f2279b = xVar2;
        }

        a(RecyclerView.x xVar, RecyclerView.x xVar2, int i, int i2, int i3, int i4) {
            this(xVar, xVar2);
            this.f2280c = i;
            this.f2281d = i2;
            this.f2282e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2278a + ", newHolder=" + this.f2279b + ", fromX=" + this.f2280c + ", fromY=" + this.f2281d + ", toX=" + this.f2282e + ", toY=" + this.f + '}';
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void a() {
        boolean z = !this.j.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.x> it = this.j.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.j.clear();
            if (z2) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.l);
                this.f2247b.add(arrayList);
                this.l.clear();
                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            g.this.b(bVar.f2283a, bVar.f2284b, bVar.f2285c, bVar.f2286d, bVar.f2287e);
                        }
                        arrayList.clear();
                        g.this.f2247b.remove(arrayList);
                    }
                };
                if (z) {
                    androidx.core.h.w.a(arrayList.get(0).f2283a.itemView, runnable, g());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.m);
                this.f2248c.add(arrayList2);
                this.m.clear();
                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.g.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            g.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        g.this.f2248c.remove(arrayList2);
                    }
                };
                if (z) {
                    androidx.core.h.w.a(arrayList2.get(0).f2278a.itemView, runnable2, g());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.x> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.k);
                this.f2246a.add(arrayList3);
                this.k.clear();
                Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.g.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            g.this.c((RecyclerView.x) it2.next());
                        }
                        arrayList3.clear();
                        g.this.f2246a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    androidx.core.h.w.a(arrayList3.get(0).itemView, runnable3, (z ? g() : 0L) + Math.max(z2 ? e() : 0L, z3 ? h() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.w
    public boolean a(RecyclerView.x xVar) {
        v(xVar);
        this.j.add(xVar);
        return true;
    }

    private void u(final RecyclerView.x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f.add(xVar);
        animate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.g.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                g.this.l(xVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                g.this.i(xVar);
                g.this.f.remove(xVar);
                g.this.c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.w
    public boolean b(RecyclerView.x xVar) {
        v(xVar);
        xVar.itemView.setAlpha(0.0f);
        this.k.add(xVar);
        return true;
    }

    void c(final RecyclerView.x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f2249d.add(xVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.g.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                g.this.n(xVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                g.this.k(xVar);
                g.this.f2249d.remove(xVar);
                g.this.c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.w
    public boolean a(RecyclerView.x xVar, int i2, int i3, int i4, int i5) {
        View view = xVar.itemView;
        int translationX = i2 + ((int) xVar.itemView.getTranslationX());
        int translationY = i3 + ((int) xVar.itemView.getTranslationY());
        v(xVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(xVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.l.add(new b(xVar, translationX, translationY, i4, i5));
        return true;
    }

    void b(final RecyclerView.x xVar, int i2, int i3, int i4, int i5) {
        final View view = xVar.itemView;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f2250e.add(xVar);
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.g.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                g.this.m(xVar);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                g.this.j(xVar);
                g.this.f2250e.remove(xVar);
                g.this.c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.w
    public boolean a(RecyclerView.x xVar, RecyclerView.x xVar2, int i2, int i3, int i4, int i5) {
        if (xVar == xVar2) {
            return a(xVar, i2, i3, i4, i5);
        }
        float translationX = xVar.itemView.getTranslationX();
        float translationY = xVar.itemView.getTranslationY();
        float alpha = xVar.itemView.getAlpha();
        v(xVar);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        xVar.itemView.setTranslationX(translationX);
        xVar.itemView.setTranslationY(translationY);
        xVar.itemView.setAlpha(alpha);
        if (xVar2 != null) {
            v(xVar2);
            xVar2.itemView.setTranslationX(-i6);
            xVar2.itemView.setTranslationY(-i7);
            xVar2.itemView.setAlpha(0.0f);
        }
        this.m.add(new a(xVar, xVar2, i2, i3, i4, i5));
        return true;
    }

    void a(final a aVar) {
        RecyclerView.x xVar = aVar.f2278a;
        final View view = xVar == null ? null : xVar.itemView;
        RecyclerView.x xVar2 = aVar.f2279b;
        final View view2 = xVar2 != null ? xVar2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(h());
            this.g.add(aVar.f2278a);
            duration.translationX(aVar.f2282e - aVar.f2280c);
            duration.translationY(aVar.f - aVar.f2281d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.g.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    g.this.b(aVar.f2278a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    g.this.a(aVar.f2278a, true);
                    g.this.g.remove(aVar.f2278a);
                    g.this.c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.g.add(aVar.f2279b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.g.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    g.this.b(aVar.f2279b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    g.this.a(aVar.f2279b, false);
                    g.this.g.remove(aVar.f2279b);
                    g.this.c();
                }
            }).start();
        }
    }

    private void a(List<a> list, RecyclerView.x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, xVar) && aVar.f2278a == null && aVar.f2279b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.f2278a != null) {
            a(aVar, aVar.f2278a);
        }
        if (aVar.f2279b != null) {
            a(aVar, aVar.f2279b);
        }
    }

    private boolean a(a aVar, RecyclerView.x xVar) {
        boolean z = false;
        if (aVar.f2279b == xVar) {
            aVar.f2279b = null;
        } else if (aVar.f2278a != xVar) {
            return false;
        } else {
            aVar.f2278a = null;
            z = true;
        }
        xVar.itemView.setAlpha(1.0f);
        xVar.itemView.setTranslationX(0.0f);
        xVar.itemView.setTranslationY(0.0f);
        a(xVar, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d(RecyclerView.x xVar) {
        View view = xVar.itemView;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.l.get(size).f2283a == xVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(xVar);
                this.l.remove(size);
            }
        }
        a(this.m, xVar);
        if (this.j.remove(xVar)) {
            view.setAlpha(1.0f);
            i(xVar);
        }
        if (this.k.remove(xVar)) {
            view.setAlpha(1.0f);
            k(xVar);
        }
        for (int size2 = this.f2248c.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.f2248c.get(size2);
            a(arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.f2248c.remove(size2);
            }
        }
        for (int size3 = this.f2247b.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.f2247b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f2283a == xVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f2247b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f2246a.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.x> arrayList3 = this.f2246a.get(size5);
            if (arrayList3.remove(xVar)) {
                view.setAlpha(1.0f);
                k(xVar);
                if (arrayList3.isEmpty()) {
                    this.f2246a.remove(size5);
                }
            }
        }
        this.f.remove(xVar);
        this.f2249d.remove(xVar);
        this.g.remove(xVar);
        this.f2250e.remove(xVar);
        c();
    }

    private void v(RecyclerView.x xVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        xVar.itemView.animate().setInterpolator(i);
        d(xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean b() {
        return (this.k.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.f2250e.isEmpty() && this.f.isEmpty() && this.f2249d.isEmpty() && this.g.isEmpty() && this.f2247b.isEmpty() && this.f2246a.isEmpty() && this.f2248c.isEmpty()) ? false : true;
    }

    void c() {
        if (b()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public void d() {
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.l.get(size);
            View view = bVar.f2283a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.f2283a);
            this.l.remove(size);
        }
        for (int size2 = this.j.size() - 1; size2 >= 0; size2--) {
            i(this.j.get(size2));
            this.j.remove(size2);
        }
        int size3 = this.k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.x xVar = this.k.get(size3);
            xVar.itemView.setAlpha(1.0f);
            k(xVar);
            this.k.remove(size3);
        }
        for (int size4 = this.m.size() - 1; size4 >= 0; size4--) {
            b(this.m.get(size4));
        }
        this.m.clear();
        if (b()) {
            for (int size5 = this.f2247b.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.f2247b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f2283a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.f2283a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f2247b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f2246a.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.x> arrayList2 = this.f2246a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.x xVar2 = arrayList2.get(size8);
                    xVar2.itemView.setAlpha(1.0f);
                    k(xVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f2246a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f2248c.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.f2248c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f2248c.remove(arrayList3);
                    }
                }
            }
            a(this.f);
            a(this.f2250e);
            a(this.f2249d);
            a(this.g);
            i();
        }
    }

    void a(List<RecyclerView.x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.f
    public boolean a(RecyclerView.x xVar, List<Object> list) {
        return !list.isEmpty() || super.a(xVar, list);
    }
}
