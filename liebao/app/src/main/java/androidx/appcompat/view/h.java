package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.h.aa;
import androidx.core.h.ab;
import androidx.core.h.ac;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    ab f725b;

    /* renamed from: d  reason: collision with root package name */
    private Interpolator f727d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f728e;

    /* renamed from: c  reason: collision with root package name */
    private long f726c = -1;
    private final ac f = new ac() { // from class: androidx.appcompat.view.h.1

        /* renamed from: b  reason: collision with root package name */
        private boolean f730b = false;

        /* renamed from: c  reason: collision with root package name */
        private int f731c = 0;

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void a(View view) {
            if (this.f730b) {
                return;
            }
            this.f730b = true;
            if (h.this.f725b != null) {
                h.this.f725b.a(null);
            }
        }

        void a() {
            this.f731c = 0;
            this.f730b = false;
            h.this.b();
        }

        @Override // androidx.core.h.ac, androidx.core.h.ab
        public void b(View view) {
            int i = this.f731c + 1;
            this.f731c = i;
            if (i == h.this.f724a.size()) {
                if (h.this.f725b != null) {
                    h.this.f725b.b(null);
                }
                a();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<aa> f724a = new ArrayList<>();

    public h a(aa aaVar) {
        if (!this.f728e) {
            this.f724a.add(aaVar);
        }
        return this;
    }

    public h a(aa aaVar, aa aaVar2) {
        this.f724a.add(aaVar);
        aaVar2.b(aaVar.a());
        this.f724a.add(aaVar2);
        return this;
    }

    public void a() {
        if (this.f728e) {
            return;
        }
        Iterator<aa> it = this.f724a.iterator();
        while (it.hasNext()) {
            aa next = it.next();
            long j = this.f726c;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.f727d;
            if (interpolator != null) {
                next.a(interpolator);
            }
            if (this.f725b != null) {
                next.a(this.f);
            }
            next.c();
        }
        this.f728e = true;
    }

    void b() {
        this.f728e = false;
    }

    public void c() {
        if (this.f728e) {
            Iterator<aa> it = this.f724a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f728e = false;
        }
    }

    public h a(long j) {
        if (!this.f728e) {
            this.f726c = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.f728e) {
            this.f727d = interpolator;
        }
        return this;
    }

    public h a(ab abVar) {
        if (!this.f728e) {
            this.f725b = abVar;
        }
        return this;
    }
}
