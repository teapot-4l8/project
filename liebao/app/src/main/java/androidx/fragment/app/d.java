package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: Fragment.java */
/* loaded from: classes.dex */
public class d implements ComponentCallbacks, View.OnCreateContextMenuListener, ab, androidx.lifecycle.l, androidx.savedstate.c {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    boolean mAdded;
    a mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    k mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    k mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    i mHost;
    boolean mInLayout;
    View mInnerView;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.m mLifecycleRegistry;
    h.b mMaxState;
    boolean mMenuVisible;
    d mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    androidx.savedstate.b mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    d mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    t mViewLifecycleOwner;
    androidx.lifecycle.r<androidx.lifecycle.l> mViewLifecycleOwnerLiveData;
    String mWho;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fragment.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttachFragment(d dVar) {
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onDestroyOptionsMenu() {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    @Override // androidx.lifecycle.l
    public androidx.lifecycle.h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public androidx.lifecycle.l getViewLifecycleOwner() {
        t tVar = this.mViewLifecycleOwner;
        if (tVar != null) {
            return tVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<androidx.lifecycle.l> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ab
    public aa getViewModelStore() {
        k kVar = this.mFragmentManager;
        if (kVar == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        return kVar.c(this);
    }

    @Override // androidx.savedstate.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.a();
    }

    /* compiled from: Fragment.java */
    /* renamed from: androidx.fragment.app.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0045d implements Parcelable {
        public static final Parcelable.Creator<C0045d> CREATOR = new Parcelable.ClassLoaderCreator<C0045d>() { // from class: androidx.fragment.app.d.d.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public C0045d createFromParcel(Parcel parcel) {
                return new C0045d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public C0045d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0045d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public C0045d[] newArray(int i) {
                return new C0045d[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        final Bundle f1850a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0045d(Bundle bundle) {
            this.f1850a = bundle;
        }

        C0045d(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f1850a = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f1850a);
        }
    }

    /* compiled from: Fragment.java */
    /* loaded from: classes.dex */
    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    public d() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new k();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable() { // from class: androidx.fragment.app.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.startPostponedEnterTransition();
            }
        };
        this.mMaxState = h.b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.r<>();
        initLifecycle();
    }

    public d(int i) {
        this();
        this.mContentLayoutId = i;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new androidx.lifecycle.m(this);
        this.mSavedStateRegistryController = androidx.savedstate.b.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mLifecycleRegistry.a(new androidx.lifecycle.j() { // from class: androidx.fragment.app.Fragment$2
                @Override // androidx.lifecycle.j
                public void onStateChanged(androidx.lifecycle.l lVar, h.a aVar) {
                    if (aVar != h.a.ON_STOP || d.this.mView == null) {
                        return;
                    }
                    d.this.mView.cancelPendingInputEvents();
                }
            });
        }
    }

    @Deprecated
    public static d instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    @Deprecated
    public static d instantiate(Context context, String str, Bundle bundle) {
        try {
            d newInstance = h.b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new u("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.a(h.a.ON_CREATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        androidx.core.g.a.a(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final String getTag() {
        return this.mTag;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean isStateSaved() {
        k kVar = this.mFragmentManager;
        if (kVar == null) {
            return false;
        }
        return kVar.g();
    }

    public void setInitialSavedState(C0045d c0045d) {
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        this.mSavedFragmentState = (c0045d == null || c0045d.f1850a == null) ? null : c0045d.f1850a;
    }

    public void setTargetFragment(d dVar, int i) {
        j fragmentManager = getFragmentManager();
        j fragmentManager2 = dVar != null ? dVar.getFragmentManager() : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + dVar + " must share the same FragmentManager to be set as a target fragment");
        }
        for (d dVar2 = dVar; dVar2 != null; dVar2 = dVar2.getTargetFragment()) {
            if (dVar2 == this) {
                throw new IllegalArgumentException("Setting " + dVar + " as the target of " + this + " would create a target cycle");
            }
        }
        if (dVar == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && dVar.mFragmentManager != null) {
            this.mTargetWho = dVar.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = dVar;
        }
        this.mTargetRequestCode = i;
    }

    public final d getTargetFragment() {
        d dVar = this.mTarget;
        if (dVar != null) {
            return dVar;
        }
        k kVar = this.mFragmentManager;
        if (kVar == null || this.mTargetWho == null) {
            return null;
        }
        return kVar.g.get(this.mTargetWho);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public Context getContext() {
        i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.j();
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final e getActivity() {
        i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return (e) iVar.i();
    }

    public final e requireActivity() {
        e activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Object getHost() {
        i iVar = this.mHost;
        if (iVar == null) {
            return null;
        }
        return iVar.h();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final j getFragmentManager() {
        return this.mFragmentManager;
    }

    public final j requireFragmentManager() {
        j fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final j getChildFragmentManager() {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.mChildFragmentManager;
    }

    public final d getParentFragment() {
        return this.mParentFragment;
    }

    public final d requireParentFragment() {
        d parentFragment = getParentFragment();
        if (parentFragment == null) {
            if (getContext() == null) {
                throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
            }
            throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
        }
        return parentFragment;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        k kVar = this.mFragmentManager;
        if (kVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            kVar.e(this);
        } else {
            kVar.f(this);
        }
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.e();
        }
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.e();
            }
        }
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.g(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @Deprecated
    public androidx.loader.a.a getLoaderManager() {
        return androidx.loader.a.a.a(this);
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        i iVar = this.mHost;
        if (iVar == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        iVar.a(this, intent, -1, bundle);
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        i iVar = this.mHost;
        if (iVar == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        iVar.a(this, intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        i iVar = this.mHost;
        if (iVar == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        iVar.a(this, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public final void requestPermissions(String[] strArr, int i) {
        i iVar = this.mHost;
        if (iVar == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        iVar.a(this, strArr, i);
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        i iVar = this.mHost;
        if (iVar != null) {
            return iVar.a(str);
        }
        return false;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        i iVar = this.mHost;
        if (iVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater c2 = iVar.c();
        androidx.core.h.g.a(c2, this.mChildFragmentManager.C());
        return c2;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        i iVar = this.mHost;
        Activity i = iVar == null ? null : iVar.i();
        if (i != null) {
            this.mCalled = false;
            onInflate(i, attributeSet, bundle);
        }
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        i iVar = this.mHost;
        Activity i = iVar == null ? null : iVar.i();
        if (i != null) {
            this.mCalled = false;
            onAttach(i);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.a(1)) {
            return;
        }
        this.mChildFragmentManager.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.a(parcelable);
        this.mChildFragmentManager.q();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public View getView() {
        return this.mView;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new k();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void setEnterSharedElementCallback(androidx.core.app.n nVar) {
        ensureAnimationInfo().o = nVar;
    }

    public void setExitSharedElementCallback(androidx.core.app.n nVar) {
        ensureAnimationInfo().p = nVar;
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().g = obj;
    }

    public Object getEnterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.g;
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().h = obj;
    }

    public Object getReturnTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.h == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mAnimationInfo.h;
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().i = obj;
    }

    public Object getExitTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.i;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().j = obj;
    }

    public Object getReenterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.j == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mAnimationInfo.j;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().k = obj;
    }

    public Object getSharedElementEnterTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.k;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().l = obj;
    }

    public Object getSharedElementReturnTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.l == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mAnimationInfo.l;
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().n = Boolean.valueOf(z);
    }

    public boolean getAllowEnterTransitionOverlap() {
        a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.n == null) {
            return true;
        }
        return this.mAnimationInfo.n.booleanValue();
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().m = Boolean.valueOf(z);
    }

    public boolean getAllowReturnTransitionOverlap() {
        a aVar = this.mAnimationInfo;
        if (aVar == null || aVar.m == null) {
            return true;
        }
        return this.mAnimationInfo.m.booleanValue();
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f1849q = true;
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().f1849q = true;
        k kVar = this.mFragmentManager;
        if (kVar != null) {
            handler = kVar.n.k();
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public void startPostponedEnterTransition() {
        k kVar = this.mFragmentManager;
        if (kVar == null || kVar.n == null) {
            ensureAnimationInfo().f1849q = false;
        } else if (Looper.myLooper() != this.mFragmentManager.n.k().getLooper()) {
            this.mFragmentManager.n.k().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.callStartTransitionListener();
                }
            });
        } else {
            callStartTransitionListener();
        }
    }

    void callStartTransitionListener() {
        a aVar = this.mAnimationInfo;
        c cVar = null;
        if (aVar != null) {
            aVar.f1849q = false;
            c cVar2 = this.mAnimationInfo.r;
            this.mAnimationInfo.r = null;
            cVar = cVar2;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        d targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            androidx.loader.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        k kVar = this.mChildFragmentManager;
        kVar.a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performAttach() {
        this.mChildFragmentManager.a(this.mHost, new f() { // from class: androidx.fragment.app.d.3
            @Override // androidx.fragment.app.f
            public View a(int i) {
                if (d.this.mView == null) {
                    throw new IllegalStateException("Fragment " + this + " does not have a view");
                }
                return d.this.mView.findViewById(i);
            }

            @Override // androidx.fragment.app.f
            public boolean a() {
                return d.this.mView != null;
            }
        }, this);
        this.mCalled = false;
        onAttach(this.mHost.j());
        if (this.mCalled) {
            return;
        }
        throw new u("Fragment " + this + " did not call through to super.onAttach()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.p();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new u("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.mLifecycleRegistry.a(h.a.ON_CREATE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.p();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new t();
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.a();
            this.mViewLifecycleOwnerLiveData.b((androidx.lifecycle.r<androidx.lifecycle.l>) this.mViewLifecycleOwner);
        } else if (this.mViewLifecycleOwner.b()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        } else {
            this.mViewLifecycleOwner = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.p();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new u("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        this.mChildFragmentManager.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStart() {
        this.mChildFragmentManager.p();
        this.mChildFragmentManager.l();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new u("Fragment " + this + " did not call through to super.onStart()");
        }
        this.mLifecycleRegistry.a(h.a.ON_START);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(h.a.ON_START);
        }
        this.mChildFragmentManager.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performResume() {
        this.mChildFragmentManager.p();
        this.mChildFragmentManager.l();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new u("Fragment " + this + " did not call through to super.onResume()");
        }
        this.mLifecycleRegistry.a(h.a.ON_RESUME);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(h.a.ON_RESUME);
        }
        this.mChildFragmentManager.t();
        this.mChildFragmentManager.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPrimaryNavigationFragmentChanged() {
        boolean b2 = this.mFragmentManager.b(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != b2) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(b2);
            onPrimaryNavigationFragmentChanged(b2);
            this.mChildFragmentManager.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.a(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.b(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.a(menu, menuInflater);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.a(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.a(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return onContextItemSelected(menuItem) || this.mChildFragmentManager.b(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.b(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        Parcelable o = this.mChildFragmentManager.o();
        if (o != null) {
            bundle.putParcelable("android:support:fragments", o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPause() {
        this.mChildFragmentManager.u();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(h.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.a(h.a.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new u("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStop() {
        this.mChildFragmentManager.v();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(h.a.ON_STOP);
        }
        this.mLifecycleRegistry.a(h.a.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new u("Fragment " + this + " did not call through to super.onStop()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroyView() {
        this.mChildFragmentManager.w();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(h.a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new u("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        androidx.loader.a.a.a(this).a();
        this.mPerformedCreateView = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroy() {
        this.mChildFragmentManager.x();
        this.mLifecycleRegistry.a(h.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new u("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new u("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.mChildFragmentManager.e()) {
        } else {
            this.mChildFragmentManager.x();
            this.mChildFragmentManager = new k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnStartEnterTransitionListener(c cVar) {
        ensureAnimationInfo();
        if (cVar == this.mAnimationInfo.r) {
            return;
        }
        if (cVar != null && this.mAnimationInfo.r != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.mAnimationInfo.f1849q) {
            this.mAnimationInfo.r = cVar;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    private a ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new a();
        }
        return this.mAnimationInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextAnim() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1847d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNextAnim(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo().f1847d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextTransition() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1848e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.f1848e = i;
        this.mAnimationInfo.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextTransitionStyle() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.n getEnterTransitionCallback() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.n getExitTransitionCallback() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getAnimatingAway() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1844a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f1844a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f1845b = animator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Animator getAnimator() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return null;
        }
        return aVar.f1845b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStateAfterAnimating() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return 0;
        }
        return aVar.f1846c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStateAfterAnimating(int i) {
        ensureAnimationInfo().f1846c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPostponed() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.f1849q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHideReplaced() {
        a aVar = this.mAnimationInfo;
        if (aVar == null) {
            return false;
        }
        return aVar.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().s = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fragment.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        View f1844a;

        /* renamed from: b  reason: collision with root package name */
        Animator f1845b;

        /* renamed from: c  reason: collision with root package name */
        int f1846c;

        /* renamed from: d  reason: collision with root package name */
        int f1847d;

        /* renamed from: e  reason: collision with root package name */
        int f1848e;
        int f;
        Boolean m;
        Boolean n;

        /* renamed from: q  reason: collision with root package name */
        boolean f1849q;
        c r;
        boolean s;
        Object g = null;
        Object h = d.USE_DEFAULT_TRANSITION;
        Object i = null;
        Object j = d.USE_DEFAULT_TRANSITION;
        Object k = null;
        Object l = d.USE_DEFAULT_TRANSITION;
        androidx.core.app.n o = null;
        androidx.core.app.n p = null;

        a() {
        }
    }
}
