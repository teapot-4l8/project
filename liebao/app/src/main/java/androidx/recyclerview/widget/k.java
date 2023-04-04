package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<k> f2321a = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    static Comparator<b> f2322e = new Comparator<b>() { // from class: androidx.recyclerview.widget.k.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            if ((bVar.f2333d == null) != (bVar2.f2333d == null)) {
                return bVar.f2333d == null ? 1 : -1;
            } else if (bVar.f2330a != bVar2.f2330a) {
                return bVar.f2330a ? -1 : 1;
            } else {
                int i = bVar2.f2331b - bVar.f2331b;
                if (i != 0) {
                    return i;
                }
                int i2 = bVar.f2332c - bVar2.f2332c;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    long f2324c;

    /* renamed from: d  reason: collision with root package name */
    long f2325d;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f2323b = new ArrayList<>();
    private ArrayList<b> f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2330a;

        /* renamed from: b  reason: collision with root package name */
        public int f2331b;

        /* renamed from: c  reason: collision with root package name */
        public int f2332c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f2333d;

        /* renamed from: e  reason: collision with root package name */
        public int f2334e;

        b() {
        }

        public void a() {
            this.f2330a = false;
            this.f2331b = 0;
            this.f2332c = 0;
            this.f2333d = null;
            this.f2334e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GapWorker.java */
    /* loaded from: classes.dex */
    public static class a implements RecyclerView.i.a {

        /* renamed from: a  reason: collision with root package name */
        int f2326a;

        /* renamed from: b  reason: collision with root package name */
        int f2327b;

        /* renamed from: c  reason: collision with root package name */
        int[] f2328c;

        /* renamed from: d  reason: collision with root package name */
        int f2329d;

        void a(int i, int i2) {
            this.f2326a = i;
            this.f2327b = i2;
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.f2329d = 0;
            int[] iArr = this.f2328c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || iVar == null || !iVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.d()) {
                    iVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                iVar.collectAdjacentPrefetchPositions(this.f2326a, this.f2327b, recyclerView.mState, this);
            }
            if (this.f2329d > iVar.mPrefetchMaxCountObserved) {
                iVar.mPrefetchMaxCountObserved = this.f2329d;
                iVar.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i.a
        public void b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f2329d * 2;
            int[] iArr = this.f2328c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f2328c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.f2328c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f2328c;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.f2329d++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.f2328c != null) {
                int i2 = this.f2329d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f2328c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f2328c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2329d = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f2323b.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f2323b.remove(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2324c == 0) {
            this.f2324c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.a(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.f2323b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f2323b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f2329d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f2323b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(aVar.f2326a) + Math.abs(aVar.f2327b);
                for (int i5 = 0; i5 < aVar.f2329d * 2; i5 += 2) {
                    if (i3 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i3);
                    }
                    int i6 = aVar.f2328c[i5 + 1];
                    bVar.f2330a = i6 <= abs;
                    bVar.f2331b = abs;
                    bVar.f2332c = i6;
                    bVar.f2333d = recyclerView2;
                    bVar.f2334e = aVar.f2328c[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f, f2322e);
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int c2 = recyclerView.mChildHelper.c();
        for (int i2 = 0; i2 < c2; i2++) {
            RecyclerView.x childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.x a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.p pVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.x a2 = pVar.a(i, false, j);
            if (a2 != null) {
                if (a2.isBound() && !a2.isInvalid()) {
                    pVar.a(a2.itemView);
                } else {
                    pVar.a(a2, false);
                }
            }
            return a2;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.c() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        a aVar = recyclerView.mPrefetchRegistry;
        aVar.a(recyclerView, true);
        if (aVar.f2329d != 0) {
            try {
                androidx.core.d.d.a("RV Nested Prefetch");
                recyclerView.mState.a(recyclerView.mAdapter);
                for (int i = 0; i < aVar.f2329d * 2; i += 2) {
                    a(recyclerView, aVar.f2328c[i], j);
                }
            } finally {
                androidx.core.d.d.a();
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.x a2 = a(bVar.f2333d, bVar.f2334e, bVar.f2330a ? Long.MAX_VALUE : j);
        if (a2 == null || a2.mNestedRecyclerView == null || !a2.isBound() || a2.isInvalid()) {
            return;
        }
        a(a2.mNestedRecyclerView.get(), j);
    }

    private void b(long j) {
        for (int i = 0; i < this.f.size(); i++) {
            b bVar = this.f.get(i);
            if (bVar.f2333d == null) {
                return;
            }
            a(bVar, j);
            bVar.a();
        }
    }

    void a(long j) {
        a();
        b(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.d.d.a("RV Prefetch");
            if (!this.f2323b.isEmpty()) {
                int size = this.f2323b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f2323b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.f2325d);
                }
            }
        } finally {
            this.f2324c = 0L;
            androidx.core.d.d.a();
        }
    }
}
