package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f2748a = new DataSetObservable();

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f2749b;

    public int a(Object obj) {
        return -1;
    }

    public Parcelable a() {
        return null;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void a(View view) {
    }

    public abstract boolean a(View view, Object obj);

    public abstract int b();

    @Deprecated
    public void b(View view) {
    }

    @Deprecated
    public void b(View view, int i, Object obj) {
    }

    public CharSequence c(int i) {
        return null;
    }

    public float d(int i) {
        return 1.0f;
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public Object a(ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        b((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    @Deprecated
    public Object a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void a(DataSetObserver dataSetObserver) {
        this.f2748a.registerObserver(dataSetObserver);
    }

    public void b(DataSetObserver dataSetObserver) {
        this.f2748a.unregisterObserver(dataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f2749b = dataSetObserver;
        }
    }
}
