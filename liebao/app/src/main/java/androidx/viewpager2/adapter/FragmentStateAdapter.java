package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.b.b;
import androidx.b.d;
import androidx.core.g.f;
import androidx.core.h.w;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.a<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final j mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final d<androidx.fragment.app.d> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final d<Integer> mItemIdToViewHolder;
    final h mLifecycle;
    private final d<d.C0045d> mSavedStates;

    public abstract androidx.fragment.app.d createFragment(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public FragmentStateAdapter(e eVar) {
        this(eVar.j(), eVar.getLifecycle());
    }

    public FragmentStateAdapter(androidx.fragment.app.d dVar) {
        this(dVar.getChildFragmentManager(), dVar.getLifecycle());
    }

    public FragmentStateAdapter(j jVar, h hVar) {
        this.mFragments = new androidx.b.d<>();
        this.mSavedStates = new androidx.b.d<>();
        this.mItemIdToViewHolder = new androidx.b.d<>();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = jVar;
        this.mLifecycle = hVar;
        super.setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        f.a(this.mFragmentMaxLifecycleEnforcer == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return FragmentViewHolder.create(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void onBindViewHolder(final FragmentViewHolder fragmentViewHolder, int i) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id);
        if (itemForViewHolder != null && itemForViewHolder.longValue() != itemId) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.b(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.b(itemId, Integer.valueOf(id));
        ensureFragment(i);
        final FrameLayout container = fragmentViewHolder.getContainer();
        if (w.D(container)) {
            if (container.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            container.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (container.getParent() != null) {
                        container.removeOnLayoutChangeListener(this);
                        FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                    }
                }
            });
        }
        gcFragments();
    }

    void gcFragments() {
        if (!this.mHasStaleFragments || shouldDelayFragmentTransactions()) {
            return;
        }
        b<Long> bVar = new b();
        for (int i = 0; i < this.mFragments.b(); i++) {
            long b2 = this.mFragments.b(i);
            if (!containsItem(b2)) {
                bVar.add(Long.valueOf(b2));
                this.mItemIdToViewHolder.b(b2);
            }
        }
        if (!this.mIsInGracePeriod) {
            this.mHasStaleFragments = false;
            for (int i2 = 0; i2 < this.mFragments.b(); i2++) {
                long b3 = this.mFragments.b(i2);
                if (!isFragmentViewBound(b3)) {
                    bVar.add(Long.valueOf(b3));
                }
            }
        }
        for (Long l : bVar) {
            removeFragment(l.longValue());
        }
    }

    private boolean isFragmentViewBound(long j) {
        View view;
        if (this.mItemIdToViewHolder.d(j)) {
            return true;
        }
        androidx.fragment.app.d a2 = this.mFragments.a(j);
        return (a2 == null || (view = a2.getView()) == null || view.getParent() == null) ? false : true;
    }

    private Long itemForViewHolder(int i) {
        Long l = null;
        for (int i2 = 0; i2 < this.mItemIdToViewHolder.b(); i2++) {
            if (this.mItemIdToViewHolder.c(i2).intValue() == i) {
                if (l != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                l = Long.valueOf(this.mItemIdToViewHolder.b(i2));
            }
        }
        return l;
    }

    private void ensureFragment(int i) {
        long itemId = getItemId(i);
        if (this.mFragments.d(itemId)) {
            return;
        }
        androidx.fragment.app.d createFragment = createFragment(i);
        createFragment.setInitialSavedState(this.mSavedStates.a(itemId));
        this.mFragments.b(itemId, createFragment);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    void placeFragmentInViewHolder(final FragmentViewHolder fragmentViewHolder) {
        androidx.fragment.app.d a2 = this.mFragments.a(fragmentViewHolder.getItemId());
        if (a2 == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout container = fragmentViewHolder.getContainer();
        View view = a2.getView();
        if (!a2.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (a2.isAdded() && view == null) {
            scheduleViewAttach(a2, container);
        } else if (a2.isAdded() && view.getParent() != null) {
            if (view.getParent() != container) {
                addViewToContainer(view, container);
            }
        } else if (a2.isAdded()) {
            addViewToContainer(view, container);
        } else if (!shouldDelayFragmentTransactions()) {
            scheduleViewAttach(a2, container);
            p a3 = this.mFragmentManager.a();
            a3.a(a2, "f" + fragmentViewHolder.getItemId()).a(a2, h.b.STARTED).d();
            this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
        } else if (this.mFragmentManager.e()) {
        } else {
            this.mLifecycle.a(new androidx.lifecycle.j() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                @Override // androidx.lifecycle.j
                public void onStateChanged(l lVar, h.a aVar) {
                    if (FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                        return;
                    }
                    lVar.getLifecycle().b(this);
                    if (w.D(fragmentViewHolder.getContainer())) {
                        FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                    }
                }
            });
        }
    }

    private void scheduleViewAttach(final androidx.fragment.app.d dVar, final FrameLayout frameLayout) {
        this.mFragmentManager.a(new j.a() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
            @Override // androidx.fragment.app.j.a
            public void onFragmentViewCreated(j jVar, androidx.fragment.app.d dVar2, View view, Bundle bundle) {
                if (dVar2 == dVar) {
                    jVar.a(this);
                    FragmentStateAdapter.this.addViewToContainer(view, frameLayout);
                }
            }
        }, false);
    }

    void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.b(itemForViewHolder.longValue());
        }
    }

    private void removeFragment(long j) {
        ViewParent parent;
        androidx.fragment.app.d a2 = this.mFragments.a(j);
        if (a2 == null) {
            return;
        }
        if (a2.getView() != null && (parent = a2.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j)) {
            this.mSavedStates.b(j);
        }
        if (!a2.isAdded()) {
            this.mFragments.b(j);
        } else if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
        } else {
            if (a2.isAdded() && containsItem(j)) {
                this.mSavedStates.b(j, this.mFragmentManager.a(a2));
            }
            this.mFragmentManager.a().a(a2).d();
            this.mFragments.b(j);
        }
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.g();
    }

    public boolean containsItem(long j) {
        return j >= 0 && j < ((long) getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.b() + this.mSavedStates.b());
        for (int i = 0; i < this.mFragments.b(); i++) {
            long b2 = this.mFragments.b(i);
            androidx.fragment.app.d a2 = this.mFragments.a(b2);
            if (a2 != null && a2.isAdded()) {
                this.mFragmentManager.a(bundle, createKey(KEY_PREFIX_FRAGMENT, b2), a2);
            }
        }
        for (int i2 = 0; i2 < this.mSavedStates.b(); i2++) {
            long b3 = this.mSavedStates.b(i2);
            if (containsItem(b3)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, b3), this.mSavedStates.a(b3));
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(Parcelable parcelable) {
        if (!this.mSavedStates.c() || !this.mFragments.c()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.b(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.a(bundle, str));
            } else if (isValidKey(str, KEY_PREFIX_STATE)) {
                long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                d.C0045d c0045d = (d.C0045d) bundle.getParcelable(str);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.b(parseIdFromKey, c0045d);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + str);
            }
        }
        if (this.mFragments.c()) {
            return;
        }
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter.this.mIsInGracePeriod = false;
                FragmentStateAdapter.this.gcFragments();
            }
        };
        this.mLifecycle.a(new androidx.lifecycle.j() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            @Override // androidx.lifecycle.j
            public void onStateChanged(l lVar, h.a aVar) {
                if (aVar == h.a.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    lVar.getLifecycle().b(this);
                }
            }
        });
        handler.postDelayed(runnable, GRACE_WINDOW_TIME_MS);
    }

    private static String createKey(String str, long j) {
        return str + j;
    }

    private static boolean isValidKey(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private static long parseIdFromKey(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class FragmentMaxLifecycleEnforcer {
        private RecyclerView.c mDataObserver;
        private androidx.lifecycle.j mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        FragmentMaxLifecycleEnforcer() {
        }

        void register(RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = onPageChangeCallback;
            this.mViewPager.registerOnPageChangeCallback(onPageChangeCallback);
            DataSetChangeObserver dataSetChangeObserver = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.c
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = dataSetChangeObserver;
            FragmentStateAdapter.this.registerAdapterDataObserver(dataSetChangeObserver);
            this.mLifecycleObserver = new androidx.lifecycle.j() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                @Override // androidx.lifecycle.j
                public void onStateChanged(l lVar, h.a aVar) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            FragmentStateAdapter.this.mLifecycle.a(this.mLifecycleObserver);
        }

        void unregister(RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.b(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        void updateFragmentMaxLifecycle(boolean z) {
            int currentItem;
            androidx.fragment.app.d a2;
            if (FragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || FragmentStateAdapter.this.mFragments.c() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.mPrimaryItemId || z) && (a2 = FragmentStateAdapter.this.mFragments.a(itemId)) != null && a2.isAdded()) {
                this.mPrimaryItemId = itemId;
                p a3 = FragmentStateAdapter.this.mFragmentManager.a();
                androidx.fragment.app.d dVar = null;
                for (int i = 0; i < FragmentStateAdapter.this.mFragments.b(); i++) {
                    long b2 = FragmentStateAdapter.this.mFragments.b(i);
                    androidx.fragment.app.d c2 = FragmentStateAdapter.this.mFragments.c(i);
                    if (c2.isAdded()) {
                        if (b2 != this.mPrimaryItemId) {
                            a3.a(c2, h.b.STARTED);
                        } else {
                            dVar = c2;
                        }
                        c2.setMenuVisibility(b2 == this.mPrimaryItemId);
                    }
                }
                if (dVar != null) {
                    a3.a(dVar, h.b.RESUMED);
                }
                if (a3.i()) {
                    return;
                }
                a3.d();
            }
        }

        private ViewPager2 inferViewPager(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }
    }

    /* loaded from: classes.dex */
    private static abstract class DataSetChangeObserver extends RecyclerView.c {
        @Override // androidx.recyclerview.widget.RecyclerView.c
        public abstract void onChanged();

        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }
}
