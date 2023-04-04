package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.h;

/* compiled from: FragmentPagerAdapter.java */
/* loaded from: classes.dex */
public abstract class n extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    private final j f1913a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1914b;

    /* renamed from: c  reason: collision with root package name */
    private p f1915c;

    /* renamed from: d  reason: collision with root package name */
    private d f1916d;

    @Override // androidx.viewpager.widget.a
    public Parcelable a() {
        return null;
    }

    public abstract d a(int i);

    @Override // androidx.viewpager.widget.a
    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long b(int i) {
        return i;
    }

    @Deprecated
    public n(j jVar) {
        this(jVar, 0);
    }

    public n(j jVar, int i) {
        this.f1915c = null;
        this.f1916d = null;
        this.f1913a = jVar;
        this.f1914b = i;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // androidx.viewpager.widget.a
    public Object a(ViewGroup viewGroup, int i) {
        if (this.f1915c == null) {
            this.f1915c = this.f1913a.a();
        }
        long b2 = b(i);
        d a2 = this.f1913a.a(a(viewGroup.getId(), b2));
        if (a2 != null) {
            this.f1915c.e(a2);
        } else {
            a2 = a(i);
            this.f1915c.a(viewGroup.getId(), a2, a(viewGroup.getId(), b2));
        }
        if (a2 != this.f1916d) {
            a2.setMenuVisibility(false);
            if (this.f1914b == 1) {
                this.f1915c.a(a2, h.b.STARTED);
            } else {
                a2.setUserVisibleHint(false);
            }
        }
        return a2;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object obj) {
        d dVar = (d) obj;
        if (this.f1915c == null) {
            this.f1915c = this.f1913a.a();
        }
        this.f1915c.d(dVar);
        if (dVar == this.f1916d) {
            this.f1916d = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup, int i, Object obj) {
        d dVar = (d) obj;
        d dVar2 = this.f1916d;
        if (dVar != dVar2) {
            if (dVar2 != null) {
                dVar2.setMenuVisibility(false);
                if (this.f1914b == 1) {
                    if (this.f1915c == null) {
                        this.f1915c = this.f1913a.a();
                    }
                    this.f1915c.a(this.f1916d, h.b.STARTED);
                } else {
                    this.f1916d.setUserVisibleHint(false);
                }
            }
            dVar.setMenuVisibility(true);
            if (this.f1914b == 1) {
                if (this.f1915c == null) {
                    this.f1915c = this.f1913a.a();
                }
                this.f1915c.a(dVar, h.b.RESUMED);
            } else {
                dVar.setUserVisibleHint(true);
            }
            this.f1916d = dVar;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup) {
        p pVar = this.f1915c;
        if (pVar != null) {
            pVar.e();
            this.f1915c = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public boolean a(View view, Object obj) {
        return ((d) obj).getView() == view;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
