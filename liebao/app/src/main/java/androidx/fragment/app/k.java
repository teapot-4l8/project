package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.d;
import androidx.fragment.app.j;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.h;
import com.umeng.analytics.pro.o;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManagerImpl.java */
/* loaded from: classes.dex */
public final class k extends j implements LayoutInflater.Factory2 {
    static final Interpolator D = new DecelerateInterpolator(2.5f);
    static final Interpolator E = new DecelerateInterpolator(1.5f);

    /* renamed from: b  reason: collision with root package name */
    static boolean f1866b = false;
    ArrayList<g> B;
    private OnBackPressedDispatcher F;
    private m I;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<e> f1867c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1868d;
    ArrayList<androidx.fragment.app.a> h;
    ArrayList<androidx.fragment.app.d> i;
    ArrayList<androidx.fragment.app.a> j;
    ArrayList<Integer> k;
    ArrayList<j.b> l;
    i n;
    androidx.fragment.app.f o;
    androidx.fragment.app.d p;

    /* renamed from: q  reason: collision with root package name */
    androidx.fragment.app.d f1870q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    ArrayList<androidx.fragment.app.a> w;
    ArrayList<Boolean> x;
    ArrayList<androidx.fragment.app.d> y;

    /* renamed from: e  reason: collision with root package name */
    int f1869e = 0;
    final ArrayList<androidx.fragment.app.d> f = new ArrayList<>();
    final HashMap<String, androidx.fragment.app.d> g = new HashMap<>();
    private final androidx.activity.c G = new androidx.activity.c(false) { // from class: androidx.fragment.app.k.1
        @Override // androidx.activity.c
        public void c() {
            k.this.h();
        }
    };
    private final CopyOnWriteArrayList<c> H = new CopyOnWriteArrayList<>();
    int m = 0;
    Bundle z = null;
    SparseArray<Parcelable> A = null;
    Runnable C = new Runnable() { // from class: androidx.fragment.app.k.2
        @Override // java.lang.Runnable
        public void run() {
            k.this.l();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManagerImpl.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f1895a = {16842755, 16842960, 16842961};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManagerImpl.java */
    /* loaded from: classes.dex */
    public interface e {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public static int b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        } else if (i == 4099) {
            return z ? 5 : 6;
        } else if (i != 8194) {
            return -1;
        } else {
            return z ? 3 : 4;
        }
    }

    public static int d(int i) {
        if (i != 4097) {
            if (i != 4099) {
                if (i != 8194) {
                    return 0;
                }
                return o.a.f6596a;
            }
            return o.a.f6598c;
        }
        return o.a.f6601q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 C() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManagerImpl.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final j.a f1893a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f1894b;

        c(j.a aVar, boolean z) {
            this.f1893a = aVar;
            this.f1894b = z;
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
        i iVar = this.n;
        if (iVar != null) {
            try {
                iVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    @Override // androidx.fragment.app.j
    public p a() {
        return new androidx.fragment.app.a(this);
    }

    @Override // androidx.fragment.app.j
    public boolean b() {
        boolean l = l();
        G();
        return l;
    }

    private void D() {
        ArrayList<e> arrayList = this.f1867c;
        boolean z = true;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.G.a(true);
        } else {
            this.G.a((i() <= 0 || !b(this.p)) ? false : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(androidx.fragment.app.d dVar) {
        if (dVar == null) {
            return true;
        }
        k kVar = dVar.mFragmentManager;
        return dVar == kVar.A() && b(kVar.p);
    }

    void h() {
        l();
        if (this.G.a()) {
            c();
        } else {
            this.F.a();
        }
    }

    @Override // androidx.fragment.app.j
    public boolean c() {
        E();
        return a((String) null, -1, 0);
    }

    @Override // androidx.fragment.app.j
    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a((e) new f(null, i, i2), false);
    }

    private boolean a(String str, int i, int i2) {
        l();
        c(true);
        androidx.fragment.app.d dVar = this.f1870q;
        if (dVar == null || i >= 0 || str != null || !dVar.getChildFragmentManager().c()) {
            boolean a2 = a(this.w, this.x, str, i, i2);
            if (a2) {
                this.f1868d = true;
                try {
                    b(this.w, this.x);
                } finally {
                    F();
                }
            }
            D();
            m();
            I();
            return a2;
        }
        return true;
    }

    public int i() {
        ArrayList<androidx.fragment.app.a> arrayList = this.h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.j
    public void a(Bundle bundle, String str, androidx.fragment.app.d dVar) {
        if (dVar.mFragmentManager != this) {
            a(new IllegalStateException("Fragment " + dVar + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, dVar.mWho);
    }

    @Override // androidx.fragment.app.j
    public androidx.fragment.app.d a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        androidx.fragment.app.d dVar = this.g.get(string);
        if (dVar == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return dVar;
    }

    @Override // androidx.fragment.app.j
    public List<androidx.fragment.app.d> d() {
        List<androidx.fragment.app.d> list;
        if (this.f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f) {
            list = (List) this.f.clone();
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa c(androidx.fragment.app.d dVar) {
        return this.I.e(dVar);
    }

    m d(androidx.fragment.app.d dVar) {
        return this.I.d(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(androidx.fragment.app.d dVar) {
        if (g()) {
            if (f1866b) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.I.a(dVar) && f1866b) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(androidx.fragment.app.d dVar) {
        if (g()) {
            if (f1866b) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.I.c(dVar) && f1866b) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + dVar);
        }
    }

    @Override // androidx.fragment.app.j
    public d.C0045d a(androidx.fragment.app.d dVar) {
        Bundle t;
        if (dVar.mFragmentManager != this) {
            a(new IllegalStateException("Fragment " + dVar + " is not currently in the FragmentManager"));
        }
        if (dVar.mState <= 0 || (t = t(dVar)) == null) {
            return null;
        }
        return new d.C0045d(t);
    }

    @Override // androidx.fragment.app.j
    public boolean e() {
        return this.u;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.fragment.app.d dVar = this.p;
        if (dVar != null) {
            androidx.core.g.a.a(dVar, sb);
        } else {
            androidx.core.g.a.a(this.n, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.j
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (androidx.fragment.app.d dVar : this.g.values()) {
                printWriter.print(str);
                printWriter.println(dVar);
                if (dVar != null) {
                    dVar.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.f.get(i).toString());
            }
        }
        ArrayList<androidx.fragment.app.d> arrayList = this.i;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.i.get(i2).toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.h;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                androidx.fragment.app.a aVar = this.h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.j != null && (size2 = this.j.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println((androidx.fragment.app.a) this.j.get(i4));
                }
            }
            if (this.k != null && this.k.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.k.toArray()));
            }
        }
        ArrayList<e> arrayList3 = this.f1867c;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println((e) this.f1867c.get(i5));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.o);
        if (this.p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mStopped=");
        printWriter.print(this.t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.u);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
    }

    static a a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(D);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(E);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new a(animationSet);
    }

    static a a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(E);
        alphaAnimation.setDuration(220L);
        return new a(alphaAnimation);
    }

    a a(androidx.fragment.app.d dVar, int i, boolean z, int i2) {
        int b2;
        int nextAnim = dVar.getNextAnim();
        boolean z2 = false;
        dVar.setNextAnim(0);
        if (dVar.mContainer == null || dVar.mContainer.getLayoutTransition() == null) {
            Animation onCreateAnimation = dVar.onCreateAnimation(i, z, nextAnim);
            if (onCreateAnimation != null) {
                return new a(onCreateAnimation);
            }
            Animator onCreateAnimator = dVar.onCreateAnimator(i, z, nextAnim);
            if (onCreateAnimator != null) {
                return new a(onCreateAnimator);
            }
            if (nextAnim != 0) {
                boolean equals = "anim".equals(this.n.j().getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.n.j(), nextAnim);
                        if (loadAnimation != null) {
                            return new a(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(this.n.j(), nextAnim);
                        if (loadAnimator != null) {
                            return new a(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (equals) {
                            throw e3;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.n.j(), nextAnim);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    }
                }
            }
            if (i != 0 && (b2 = b(i, z)) >= 0) {
                switch (b2) {
                    case 1:
                        return a(1.125f, 1.0f, 0.0f, 1.0f);
                    case 2:
                        return a(1.0f, 0.975f, 1.0f, 0.0f);
                    case 3:
                        return a(0.975f, 1.0f, 0.0f, 1.0f);
                    case 4:
                        return a(1.0f, 1.075f, 1.0f, 0.0f);
                    case 5:
                        return a(0.0f, 1.0f);
                    case 6:
                        return a(1.0f, 0.0f);
                    default:
                        if (i2 == 0 && this.n.f()) {
                            i2 = this.n.g();
                        }
                        if (i2 == 0) {
                        }
                        return null;
                }
            }
            return null;
        }
        return null;
    }

    public void g(androidx.fragment.app.d dVar) {
        if (dVar.mDeferStart) {
            if (this.f1868d) {
                this.v = true;
                return;
            }
            dVar.mDeferStart = false;
            a(dVar, this.m, 0, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return this.m >= i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0088, code lost:
        if (r0 != 3) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:275:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(androidx.fragment.app.d dVar, int i, int i2, int i3, boolean z) {
        int i4;
        int min;
        androidx.fragment.app.d dVar2;
        String str;
        String str2;
        ViewGroup viewGroup;
        String str3;
        int i5 = 1;
        boolean z2 = true;
        boolean isChangingConfigurations = true;
        if (!dVar.mAdded || dVar.mDetached) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (dVar.mRemoving && i4 > dVar.mState) {
            i4 = (dVar.mState == 0 && dVar.isInBackStack()) ? 1 : dVar.mState;
        }
        if (dVar.mDeferStart && dVar.mState < 3 && i4 > 2) {
            i4 = 2;
        }
        if (dVar.mMaxState == h.b.CREATED) {
            min = Math.min(i4, 1);
        } else {
            min = Math.min(i4, dVar.mMaxState.ordinal());
        }
        int i6 = min;
        if (dVar.mState <= i6) {
            if (dVar.mFromLayout && !dVar.mInLayout) {
                return;
            }
            if (dVar.getAnimatingAway() != null || dVar.getAnimator() != null) {
                dVar.setAnimatingAway(null);
                dVar.setAnimator(null);
                a(dVar, dVar.getStateAfterAnimating(), 0, 0, true);
            }
            int i7 = dVar.mState;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                    }
                    if (i6 > 2) {
                        if (f1866b) {
                            Log.v("FragmentManager", "moveto STARTED: " + dVar);
                        }
                        dVar.performStart();
                        b(dVar, false);
                    }
                    if (i6 > 3) {
                        if (f1866b) {
                            Log.v("FragmentManager", "moveto RESUMED: " + dVar);
                        }
                        dVar.performResume();
                        c(dVar, false);
                        dVar.mSavedFragmentState = null;
                        dVar.mSavedViewState = null;
                    }
                }
            } else if (i6 > 0) {
                if (f1866b) {
                    Log.v("FragmentManager", "moveto CREATED: " + dVar);
                }
                if (dVar.mSavedFragmentState != null) {
                    dVar.mSavedFragmentState.setClassLoader(this.n.j().getClassLoader());
                    dVar.mSavedViewState = dVar.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    androidx.fragment.app.d a2 = a(dVar.mSavedFragmentState, "android:target_state");
                    dVar.mTargetWho = a2 != null ? a2.mWho : null;
                    if (dVar.mTargetWho != null) {
                        dVar.mTargetRequestCode = dVar.mSavedFragmentState.getInt("android:target_req_state", 0);
                    }
                    if (dVar.mSavedUserVisibleHint != null) {
                        dVar.mUserVisibleHint = dVar.mSavedUserVisibleHint.booleanValue();
                        dVar.mSavedUserVisibleHint = null;
                    } else {
                        dVar.mUserVisibleHint = dVar.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                    }
                    if (!dVar.mUserVisibleHint) {
                        dVar.mDeferStart = true;
                        if (i6 > 2) {
                            i6 = 2;
                        }
                    }
                }
                dVar.mHost = this.n;
                dVar.mParentFragment = this.p;
                androidx.fragment.app.d dVar3 = this.p;
                dVar.mFragmentManager = dVar3 != null ? dVar3.mChildFragmentManager : this.n.f1860b;
                if (dVar.mTarget == null) {
                    str = "Fragment ";
                    str2 = " declared target fragment ";
                } else if (this.g.get(dVar.mTarget.mWho) != dVar.mTarget) {
                    throw new IllegalStateException("Fragment " + dVar + " declared target fragment " + dVar.mTarget + " that does not belong to this FragmentManager!");
                } else {
                    if (dVar.mTarget.mState < 1) {
                        str = "Fragment ";
                        str2 = " declared target fragment ";
                        a(dVar.mTarget, 1, 0, 0, true);
                    } else {
                        str = "Fragment ";
                        str2 = " declared target fragment ";
                    }
                    dVar.mTargetWho = dVar.mTarget.mWho;
                    dVar.mTarget = null;
                }
                if (dVar.mTargetWho != null) {
                    androidx.fragment.app.d dVar4 = this.g.get(dVar.mTargetWho);
                    if (dVar4 == null) {
                        throw new IllegalStateException(str + dVar + str2 + dVar.mTargetWho + " that does not belong to this FragmentManager!");
                    } else if (dVar4.mState < 1) {
                        a(dVar4, 1, 0, 0, true);
                    }
                }
                a(dVar, this.n.j(), false);
                dVar.performAttach();
                if (dVar.mParentFragment == null) {
                    this.n.b(dVar);
                } else {
                    dVar.mParentFragment.onAttachFragment(dVar);
                }
                b(dVar, this.n.j(), false);
                if (!dVar.mIsCreated) {
                    a(dVar, dVar.mSavedFragmentState, false);
                    dVar.performCreate(dVar.mSavedFragmentState);
                    b(dVar, dVar.mSavedFragmentState, false);
                } else {
                    dVar.restoreChildFragmentState(dVar.mSavedFragmentState);
                    dVar.mState = 1;
                }
            }
            if (i6 > 0) {
                i(dVar);
            }
            if (i6 > 1) {
                if (f1866b) {
                    Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + dVar);
                }
                if (!dVar.mFromLayout) {
                    if (dVar.mContainerId != 0) {
                        if (dVar.mContainerId == -1) {
                            a(new IllegalArgumentException("Cannot create fragment " + dVar + " for a container view with no id"));
                        }
                        viewGroup = (ViewGroup) this.o.a(dVar.mContainerId);
                        if (viewGroup == null && !dVar.mRestored) {
                            try {
                                str3 = dVar.getResources().getResourceName(dVar.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str3 = "unknown";
                            }
                            a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(dVar.mContainerId) + " (" + str3 + ") for fragment " + dVar));
                        }
                    } else {
                        viewGroup = null;
                    }
                    dVar.mContainer = viewGroup;
                    dVar.performCreateView(dVar.performGetLayoutInflater(dVar.mSavedFragmentState), viewGroup, dVar.mSavedFragmentState);
                    if (dVar.mView != null) {
                        dVar.mInnerView = dVar.mView;
                        dVar.mView.setSaveFromParentEnabled(false);
                        if (viewGroup != null) {
                            viewGroup.addView(dVar.mView);
                        }
                        if (dVar.mHidden) {
                            dVar.mView.setVisibility(8);
                        }
                        dVar.onViewCreated(dVar.mView, dVar.mSavedFragmentState);
                        a(dVar, dVar.mView, dVar.mSavedFragmentState, false);
                        dVar.mIsNewlyAdded = (dVar.mView.getVisibility() != 0 || dVar.mContainer == null) ? false : false;
                    } else {
                        dVar.mInnerView = null;
                    }
                }
                dVar.performActivityCreated(dVar.mSavedFragmentState);
                c(dVar, dVar.mSavedFragmentState, false);
                if (dVar.mView != null) {
                    dVar.restoreViewState(dVar.mSavedFragmentState);
                }
                dVar.mSavedFragmentState = null;
            }
            if (i6 > 2) {
            }
            if (i6 > 3) {
            }
        } else if (dVar.mState > i6) {
            int i8 = dVar.mState;
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        if (i8 == 4) {
                            if (i6 < 4) {
                                if (f1866b) {
                                    Log.v("FragmentManager", "movefrom RESUMED: " + dVar);
                                }
                                dVar.performPause();
                                d(dVar, false);
                            }
                        }
                    }
                    if (i6 < 3) {
                        if (f1866b) {
                            Log.v("FragmentManager", "movefrom STARTED: " + dVar);
                        }
                        dVar.performStop();
                        e(dVar, false);
                    }
                }
                if (i6 < 2) {
                    if (f1866b) {
                        Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + dVar);
                    }
                    if (dVar.mView != null && this.n.a(dVar) && dVar.mSavedViewState == null) {
                        s(dVar);
                    }
                    dVar.performDestroyView();
                    f(dVar, false);
                    if (dVar.mView != null && dVar.mContainer != null) {
                        dVar.mContainer.endViewTransition(dVar.mView);
                        dVar.mView.clearAnimation();
                        if (dVar.getParentFragment() == null || !dVar.getParentFragment().mRemoving) {
                            a a3 = (this.m <= 0 || this.u || dVar.mView.getVisibility() != 0 || dVar.mPostponedAlpha < 0.0f) ? null : a(dVar, i2, false, i3);
                            dVar.mPostponedAlpha = 0.0f;
                            if (a3 != null) {
                                a(dVar, a3, i6);
                            }
                            dVar.mContainer.removeView(dVar.mView);
                        }
                    }
                    dVar.mContainer = null;
                    dVar.mView = null;
                    dVar.mViewLifecycleOwner = null;
                    dVar.mViewLifecycleOwnerLiveData.b((androidx.lifecycle.r<androidx.lifecycle.l>) null);
                    dVar.mInnerView = null;
                    dVar.mInLayout = false;
                }
            }
            if (i6 < 1) {
                if (this.u) {
                    if (dVar.getAnimatingAway() != null) {
                        View animatingAway = dVar.getAnimatingAway();
                        dVar.setAnimatingAway(null);
                        animatingAway.clearAnimation();
                    } else if (dVar.getAnimator() != null) {
                        Animator animator = dVar.getAnimator();
                        dVar.setAnimator(null);
                        animator.cancel();
                    }
                }
                if (dVar.getAnimatingAway() != null || dVar.getAnimator() != null) {
                    dVar.setStateAfterAnimating(i6);
                    if (dVar.mState == i5) {
                        Log.w("FragmentManager", "moveToState: Fragment state for " + dVar + " not updated inline; expected state " + i5 + " found " + dVar.mState);
                        dVar.mState = i5;
                        return;
                    }
                    return;
                }
                if (f1866b) {
                    Log.v("FragmentManager", "movefrom CREATED: " + dVar);
                }
                boolean z3 = dVar.mRemoving && !dVar.isInBackStack();
                if (z3 || this.I.b(dVar)) {
                    i iVar = this.n;
                    if (iVar instanceof ab) {
                        isChangingConfigurations = this.I.b();
                    } else if (iVar.j() instanceof Activity) {
                        isChangingConfigurations = true ^ ((Activity) this.n.j()).isChangingConfigurations();
                    }
                    if (z3 || isChangingConfigurations) {
                        this.I.f(dVar);
                    }
                    dVar.performDestroy();
                    g(dVar, false);
                } else {
                    dVar.mState = 0;
                }
                dVar.performDetach();
                h(dVar, false);
                if (!z) {
                    if (z3 || this.I.b(dVar)) {
                        m(dVar);
                    } else {
                        dVar.mHost = null;
                        dVar.mParentFragment = null;
                        dVar.mFragmentManager = null;
                        if (dVar.mTargetWho != null && (dVar2 = this.g.get(dVar.mTargetWho)) != null && dVar2.getRetainInstance()) {
                            dVar.mTarget = dVar2;
                        }
                    }
                }
            }
        }
        i5 = i6;
        if (dVar.mState == i5) {
        }
    }

    private void a(final androidx.fragment.app.d dVar, a aVar, int i) {
        final View view = dVar.mView;
        final ViewGroup viewGroup = dVar.mContainer;
        viewGroup.startViewTransition(view);
        dVar.setStateAfterAnimating(i);
        if (aVar.f1886a != null) {
            b bVar = new b(aVar.f1886a, viewGroup, view);
            dVar.setAnimatingAway(dVar.mView);
            bVar.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.k.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.k.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (dVar.getAnimatingAway() != null) {
                                dVar.setAnimatingAway(null);
                                k.this.a(dVar, dVar.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            dVar.mView.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.f1887b;
        dVar.setAnimator(aVar.f1887b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.k.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animator3 = dVar.getAnimator();
                dVar.setAnimator(null);
                if (animator3 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                k kVar = k.this;
                androidx.fragment.app.d dVar2 = dVar;
                kVar.a(dVar2, dVar2.getStateAfterAnimating(), 0, 0, false);
            }
        });
        animator.setTarget(dVar.mView);
        animator.start();
    }

    void h(androidx.fragment.app.d dVar) {
        a(dVar, this.m, 0, 0, false);
    }

    void i(androidx.fragment.app.d dVar) {
        if (!dVar.mFromLayout || dVar.mPerformedCreateView) {
            return;
        }
        dVar.performCreateView(dVar.performGetLayoutInflater(dVar.mSavedFragmentState), null, dVar.mSavedFragmentState);
        if (dVar.mView != null) {
            dVar.mInnerView = dVar.mView;
            dVar.mView.setSaveFromParentEnabled(false);
            if (dVar.mHidden) {
                dVar.mView.setVisibility(8);
            }
            dVar.onViewCreated(dVar.mView, dVar.mSavedFragmentState);
            a(dVar, dVar.mView, dVar.mSavedFragmentState, false);
            return;
        }
        dVar.mInnerView = null;
    }

    void j(final androidx.fragment.app.d dVar) {
        if (dVar.mView != null) {
            a a2 = a(dVar, dVar.getNextTransition(), !dVar.mHidden, dVar.getNextTransitionStyle());
            if (a2 != null && a2.f1887b != null) {
                a2.f1887b.setTarget(dVar.mView);
                if (dVar.mHidden) {
                    if (dVar.isHideReplaced()) {
                        dVar.setHideReplaced(false);
                    } else {
                        final ViewGroup viewGroup = dVar.mContainer;
                        final View view = dVar.mView;
                        viewGroup.startViewTransition(view);
                        a2.f1887b.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.k.5
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (dVar.mView == null || !dVar.mHidden) {
                                    return;
                                }
                                dVar.mView.setVisibility(8);
                            }
                        });
                    }
                } else {
                    dVar.mView.setVisibility(0);
                }
                a2.f1887b.start();
            } else {
                if (a2 != null) {
                    dVar.mView.startAnimation(a2.f1886a);
                    a2.f1886a.start();
                }
                dVar.mView.setVisibility((!dVar.mHidden || dVar.isHideReplaced()) ? 0 : 8);
                if (dVar.isHideReplaced()) {
                    dVar.setHideReplaced(false);
                }
            }
        }
        if (dVar.mAdded && x(dVar)) {
            this.r = true;
        }
        dVar.mHiddenChanged = false;
        dVar.onHiddenChanged(dVar.mHidden);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(androidx.fragment.app.d dVar) {
        if (dVar == null) {
            return;
        }
        if (!this.g.containsKey(dVar.mWho)) {
            if (f1866b) {
                Log.v("FragmentManager", "Ignoring moving " + dVar + " to state " + this.m + "since it is not added to " + this);
                return;
            }
            return;
        }
        int i = this.m;
        if (dVar.mRemoving) {
            if (dVar.isInBackStack()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, 0);
            }
        }
        a(dVar, i, dVar.getNextTransition(), dVar.getNextTransitionStyle(), false);
        if (dVar.mView != null) {
            androidx.fragment.app.d v = v(dVar);
            if (v != null) {
                View view = v.mView;
                ViewGroup viewGroup = dVar.mContainer;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(dVar.mView);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(dVar.mView, indexOfChild);
                }
            }
            if (dVar.mIsNewlyAdded && dVar.mContainer != null) {
                if (dVar.mPostponedAlpha > 0.0f) {
                    dVar.mView.setAlpha(dVar.mPostponedAlpha);
                }
                dVar.mPostponedAlpha = 0.0f;
                dVar.mIsNewlyAdded = false;
                a a2 = a(dVar, dVar.getNextTransition(), true, dVar.getNextTransitionStyle());
                if (a2 != null) {
                    if (a2.f1886a != null) {
                        dVar.mView.startAnimation(a2.f1886a);
                    } else {
                        a2.f1887b.setTarget(dVar.mView);
                        a2.f1887b.start();
                    }
                }
            }
        }
        if (dVar.mHiddenChanged) {
            j(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        i iVar;
        if (this.n == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.m) {
            this.m = i;
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                k(this.f.get(i2));
            }
            for (androidx.fragment.app.d dVar : this.g.values()) {
                if (dVar != null && (dVar.mRemoving || dVar.mDetached)) {
                    if (!dVar.mIsNewlyAdded) {
                        k(dVar);
                    }
                }
            }
            j();
            if (this.r && (iVar = this.n) != null && this.m == 4) {
                iVar.e();
                this.r = false;
            }
        }
    }

    void j() {
        for (androidx.fragment.app.d dVar : this.g.values()) {
            if (dVar != null) {
                g(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(androidx.fragment.app.d dVar) {
        if (this.g.get(dVar.mWho) != null) {
            return;
        }
        this.g.put(dVar.mWho, dVar);
        if (dVar.mRetainInstanceChangedWhileDetached) {
            if (dVar.mRetainInstance) {
                e(dVar);
            } else {
                f(dVar);
            }
            dVar.mRetainInstanceChangedWhileDetached = false;
        }
        if (f1866b) {
            Log.v("FragmentManager", "Added fragment to active set " + dVar);
        }
    }

    void m(androidx.fragment.app.d dVar) {
        if (this.g.get(dVar.mWho) == null) {
            return;
        }
        if (f1866b) {
            Log.v("FragmentManager", "Removed fragment from active set " + dVar);
        }
        for (androidx.fragment.app.d dVar2 : this.g.values()) {
            if (dVar2 != null && dVar.mWho.equals(dVar2.mTargetWho)) {
                dVar2.mTarget = dVar;
                dVar2.mTargetWho = null;
            }
        }
        this.g.put(dVar.mWho, null);
        f(dVar);
        if (dVar.mTargetWho != null) {
            dVar.mTarget = this.g.get(dVar.mTargetWho);
        }
        dVar.initState();
    }

    public void a(androidx.fragment.app.d dVar, boolean z) {
        if (f1866b) {
            Log.v("FragmentManager", "add: " + dVar);
        }
        l(dVar);
        if (dVar.mDetached) {
            return;
        }
        if (this.f.contains(dVar)) {
            throw new IllegalStateException("Fragment already added: " + dVar);
        }
        synchronized (this.f) {
            this.f.add(dVar);
        }
        dVar.mAdded = true;
        dVar.mRemoving = false;
        if (dVar.mView == null) {
            dVar.mHiddenChanged = false;
        }
        if (x(dVar)) {
            this.r = true;
        }
        if (z) {
            h(dVar);
        }
    }

    public void n(androidx.fragment.app.d dVar) {
        if (f1866b) {
            Log.v("FragmentManager", "remove: " + dVar + " nesting=" + dVar.mBackStackNesting);
        }
        boolean z = !dVar.isInBackStack();
        if (!dVar.mDetached || z) {
            synchronized (this.f) {
                this.f.remove(dVar);
            }
            if (x(dVar)) {
                this.r = true;
            }
            dVar.mAdded = false;
            dVar.mRemoving = true;
        }
    }

    public void o(androidx.fragment.app.d dVar) {
        if (f1866b) {
            Log.v("FragmentManager", "hide: " + dVar);
        }
        if (dVar.mHidden) {
            return;
        }
        dVar.mHidden = true;
        dVar.mHiddenChanged = true ^ dVar.mHiddenChanged;
    }

    public void p(androidx.fragment.app.d dVar) {
        if (f1866b) {
            Log.v("FragmentManager", "show: " + dVar);
        }
        if (dVar.mHidden) {
            dVar.mHidden = false;
            dVar.mHiddenChanged = !dVar.mHiddenChanged;
        }
    }

    public void q(androidx.fragment.app.d dVar) {
        if (f1866b) {
            Log.v("FragmentManager", "detach: " + dVar);
        }
        if (dVar.mDetached) {
            return;
        }
        dVar.mDetached = true;
        if (dVar.mAdded) {
            if (f1866b) {
                Log.v("FragmentManager", "remove from detach: " + dVar);
            }
            synchronized (this.f) {
                this.f.remove(dVar);
            }
            if (x(dVar)) {
                this.r = true;
            }
            dVar.mAdded = false;
        }
    }

    public void r(androidx.fragment.app.d dVar) {
        if (f1866b) {
            Log.v("FragmentManager", "attach: " + dVar);
        }
        if (dVar.mDetached) {
            dVar.mDetached = false;
            if (dVar.mAdded) {
                return;
            }
            if (this.f.contains(dVar)) {
                throw new IllegalStateException("Fragment already added: " + dVar);
            }
            if (f1866b) {
                Log.v("FragmentManager", "add from attach: " + dVar);
            }
            synchronized (this.f) {
                this.f.add(dVar);
            }
            dVar.mAdded = true;
            if (x(dVar)) {
                this.r = true;
            }
        }
    }

    public androidx.fragment.app.d b(int i) {
        for (int size = this.f.size() - 1; size >= 0; size--) {
            androidx.fragment.app.d dVar = this.f.get(size);
            if (dVar != null && dVar.mFragmentId == i) {
                return dVar;
            }
        }
        for (androidx.fragment.app.d dVar2 : this.g.values()) {
            if (dVar2 != null && dVar2.mFragmentId == i) {
                return dVar2;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.j
    public androidx.fragment.app.d a(String str) {
        if (str != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                androidx.fragment.app.d dVar = this.f.get(size);
                if (dVar != null && str.equals(dVar.mTag)) {
                    return dVar;
                }
            }
        }
        if (str != null) {
            for (androidx.fragment.app.d dVar2 : this.g.values()) {
                if (dVar2 != null && str.equals(dVar2.mTag)) {
                    return dVar2;
                }
            }
            return null;
        }
        return null;
    }

    public androidx.fragment.app.d b(String str) {
        androidx.fragment.app.d findFragmentByWho;
        for (androidx.fragment.app.d dVar : this.g.values()) {
            if (dVar != null && (findFragmentByWho = dVar.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    private void E() {
        if (g()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    @Override // androidx.fragment.app.j
    public boolean g() {
        return this.s || this.t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(e eVar, boolean z) {
        if (!z) {
            E();
        }
        synchronized (this) {
            if (!this.u && this.n != null) {
                if (this.f1867c == null) {
                    this.f1867c = new ArrayList<>();
                }
                this.f1867c.add(eVar);
                k();
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    void k() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.B == null || this.B.isEmpty()) ? false : true;
            if (this.f1867c != null && this.f1867c.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.n.k().removeCallbacks(this.C);
                this.n.k().post(this.C);
                D();
            }
        }
    }

    public int a(androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.k != null && this.k.size() > 0) {
                int intValue = this.k.remove(this.k.size() - 1).intValue();
                if (f1866b) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                }
                this.j.set(intValue, aVar);
                return intValue;
            }
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            int size = this.j.size();
            if (f1866b) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.j.add(aVar);
            return size;
        }
    }

    public void a(int i, androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            int size = this.j.size();
            if (i < size) {
                if (f1866b) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + aVar);
                }
                this.j.set(i, aVar);
            } else {
                while (size < i) {
                    this.j.add(null);
                    if (this.k == null) {
                        this.k = new ArrayList<>();
                    }
                    if (f1866b) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.k.add(Integer.valueOf(size));
                    size++;
                }
                if (f1866b) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + aVar);
                }
                this.j.add(aVar);
            }
        }
    }

    public void c(int i) {
        synchronized (this) {
            this.j.set(i, null);
            if (this.k == null) {
                this.k = new ArrayList<>();
            }
            if (f1866b) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.k.add(Integer.valueOf(i));
        }
    }

    private void c(boolean z) {
        if (this.f1868d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.n == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.n.k().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            E();
        }
        if (this.w == null) {
            this.w = new ArrayList<>();
            this.x = new ArrayList<>();
        }
        this.f1868d = true;
        try {
            a((ArrayList<androidx.fragment.app.a>) null, (ArrayList<Boolean>) null);
        } finally {
            this.f1868d = false;
        }
    }

    public void b(e eVar, boolean z) {
        if (z && (this.n == null || this.u)) {
            return;
        }
        c(z);
        if (eVar.a(this.w, this.x)) {
            this.f1868d = true;
            try {
                b(this.w, this.x);
            } finally {
                F();
            }
        }
        D();
        m();
        I();
    }

    private void F() {
        this.f1868d = false;
        this.x.clear();
        this.w.clear();
    }

    public boolean l() {
        c(true);
        boolean z = false;
        while (c(this.w, this.x)) {
            this.f1868d = true;
            try {
                b(this.w, this.x);
                F();
                z = true;
            } catch (Throwable th) {
                F();
                throw th;
            }
        }
        D();
        m();
        I();
        return z;
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<g> arrayList3 = this.B;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            g gVar = this.B.get(i);
            if (arrayList != null && !gVar.f1900a && (indexOf2 = arrayList.indexOf(gVar.f1901b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                this.B.remove(i);
                i--;
                size--;
                gVar.e();
            } else if (gVar.c() || (arrayList != null && gVar.f1901b.a(arrayList, 0, arrayList.size()))) {
                this.B.remove(i);
                i--;
                size--;
                if (arrayList != null && !gVar.f1900a && (indexOf = arrayList.indexOf(gVar.f1901b)) != -1 && arrayList2.get(indexOf).booleanValue()) {
                    gVar.e();
                } else {
                    gVar.d();
                }
            }
            i++;
        }
    }

    private void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).t) {
                if (i2 != i) {
                    a(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).t) {
                        i2++;
                    }
                }
                a(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            a(arrayList, arrayList2, i2, size);
        }
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4 = i;
        boolean z = arrayList.get(i4).t;
        ArrayList<androidx.fragment.app.d> arrayList3 = this.y;
        if (arrayList3 == null) {
            this.y = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.y.addAll(this.f);
        androidx.fragment.app.d A = A();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            if (!arrayList2.get(i5).booleanValue()) {
                A = aVar.a(this.y, A);
            } else {
                A = aVar.b(this.y, A);
            }
            z2 = z2 || aVar.k;
        }
        this.y.clear();
        if (!z) {
            q.a(this, arrayList, arrayList2, i, i2, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            androidx.b.b<androidx.fragment.app.d> bVar = new androidx.b.b<>();
            b(bVar);
            int a2 = a(arrayList, arrayList2, i, i2, bVar);
            a(bVar);
            i3 = a2;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            q.a(this, arrayList, arrayList2, i, i3, true);
            a(this.m, true);
        }
        while (i4 < i2) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && aVar2.f1834c >= 0) {
                c(aVar2.f1834c);
                aVar2.f1834c = -1;
            }
            aVar2.a();
            i4++;
        }
        if (z2) {
            n();
        }
    }

    private void a(androidx.b.b<androidx.fragment.app.d> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.d b2 = bVar.b(i);
            if (!b2.mAdded) {
                View requireView = b2.requireView();
                b2.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    private int a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, androidx.b.b<androidx.fragment.app.d> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.g() && !aVar.a(arrayList, i4 + 1, i2)) {
                if (this.B == null) {
                    this.B = new ArrayList<>();
                }
                g gVar = new g(aVar, booleanValue);
                this.B.add(gVar);
                aVar.a(gVar);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                b(bVar);
            }
        }
        return i3;
    }

    void a(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.b(z3);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            q.a(this, (ArrayList<androidx.fragment.app.a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.m, true);
        }
        for (androidx.fragment.app.d dVar : this.g.values()) {
            if (dVar != null && dVar.mView != null && dVar.mIsNewlyAdded && aVar.b(dVar.mContainerId)) {
                if (dVar.mPostponedAlpha > 0.0f) {
                    dVar.mView.setAlpha(dVar.mPostponedAlpha);
                }
                if (z3) {
                    dVar.mPostponedAlpha = 0.0f;
                } else {
                    dVar.mPostponedAlpha = -1.0f;
                    dVar.mIsNewlyAdded = false;
                }
            }
        }
    }

    private androidx.fragment.app.d v(androidx.fragment.app.d dVar) {
        ViewGroup viewGroup = dVar.mContainer;
        View view = dVar.mView;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.f.indexOf(dVar) - 1; indexOf >= 0; indexOf--) {
                androidx.fragment.app.d dVar2 = this.f.get(indexOf);
                if (dVar2.mContainer == viewGroup && dVar2.mView != null) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    private static void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            androidx.fragment.app.a aVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                aVar.a(-1);
                aVar.b(i == i2 + (-1));
            } else {
                aVar.a(1);
                aVar.f();
            }
            i++;
        }
    }

    private void b(androidx.b.b<androidx.fragment.app.d> bVar) {
        int i = this.m;
        if (i < 1) {
            return;
        }
        int min = Math.min(i, 3);
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            androidx.fragment.app.d dVar = this.f.get(i2);
            if (dVar.mState < min) {
                a(dVar, min, dVar.getNextAnim(), dVar.getNextTransition(), false);
                if (dVar.mView != null && !dVar.mHidden && dVar.mIsNewlyAdded) {
                    bVar.add(dVar);
                }
            }
        }
    }

    private void G() {
        if (this.B != null) {
            while (!this.B.isEmpty()) {
                this.B.remove(0).d();
            }
        }
    }

    private void H() {
        for (androidx.fragment.app.d dVar : this.g.values()) {
            if (dVar != null) {
                if (dVar.getAnimatingAway() != null) {
                    int stateAfterAnimating = dVar.getStateAfterAnimating();
                    View animatingAway = dVar.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    dVar.setAnimatingAway(null);
                    a(dVar, stateAfterAnimating, 0, 0, false);
                } else if (dVar.getAnimator() != null) {
                    dVar.getAnimator().end();
                }
            }
        }
    }

    private boolean c(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f1867c != null && this.f1867c.size() != 0) {
                int size = this.f1867c.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.f1867c.get(i).a(arrayList, arrayList2);
                }
                this.f1867c.clear();
                this.n.k().removeCallbacks(this.C);
                return z;
            }
            return false;
        }
    }

    void m() {
        if (this.v) {
            this.v = false;
            j();
        }
    }

    void n() {
        if (this.l != null) {
            for (int i = 0; i < this.l.size(); i++) {
                this.l.get(i).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(androidx.fragment.app.a aVar) {
        if (this.h == null) {
            this.h = new ArrayList<>();
        }
        this.h.add(aVar);
    }

    boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.h.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                int size2 = this.h.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.h.get(size2);
                    if ((str != null && str.equals(aVar.h())) || (i >= 0 && i == aVar.f1834c)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.h.get(size2);
                        if (str == null || !str.equals(aVar2.h())) {
                            if (i < 0 || i != aVar2.f1834c) {
                                break;
                            }
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.h.size() - 1) {
                return false;
            }
            for (int size3 = this.h.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.h.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    void s(androidx.fragment.app.d dVar) {
        if (dVar.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.A;
        if (sparseArray == null) {
            this.A = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        dVar.mInnerView.saveHierarchyState(this.A);
        if (this.A.size() > 0) {
            dVar.mSavedViewState = this.A;
            this.A = null;
        }
    }

    Bundle t(androidx.fragment.app.d dVar) {
        if (this.z == null) {
            this.z = new Bundle();
        }
        dVar.performSaveInstanceState(this.z);
        d(dVar, this.z, false);
        Bundle bundle = null;
        if (!this.z.isEmpty()) {
            Bundle bundle2 = this.z;
            this.z = null;
            bundle = bundle2;
        }
        if (dVar.mView != null) {
            s(dVar);
        }
        if (dVar.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", dVar.mSavedViewState);
        }
        if (!dVar.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", dVar.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable o() {
        ArrayList<String> arrayList;
        int size;
        G();
        H();
        l();
        this.s = true;
        androidx.fragment.app.b[] bVarArr = null;
        if (this.g.isEmpty()) {
            return null;
        }
        ArrayList<o> arrayList2 = new ArrayList<>(this.g.size());
        boolean z = false;
        for (androidx.fragment.app.d dVar : this.g.values()) {
            if (dVar != null) {
                if (dVar.mFragmentManager != this) {
                    a(new IllegalStateException("Failure saving state: active " + dVar + " was removed from the FragmentManager"));
                }
                o oVar = new o(dVar);
                arrayList2.add(oVar);
                if (dVar.mState > 0 && oVar.m == null) {
                    oVar.m = t(dVar);
                    if (dVar.mTargetWho != null) {
                        androidx.fragment.app.d dVar2 = this.g.get(dVar.mTargetWho);
                        if (dVar2 == null) {
                            a(new IllegalStateException("Failure saving state: " + dVar + " has target not in fragment manager: " + dVar.mTargetWho));
                        }
                        if (oVar.m == null) {
                            oVar.m = new Bundle();
                        }
                        a(oVar.m, "android:target_state", dVar2);
                        if (dVar.mTargetRequestCode != 0) {
                            oVar.m.putInt("android:target_req_state", dVar.mTargetRequestCode);
                        }
                    }
                } else {
                    oVar.m = dVar.mSavedFragmentState;
                }
                if (f1866b) {
                    Log.v("FragmentManager", "Saved state of " + dVar + ": " + oVar.m);
                }
                z = true;
            }
        }
        if (!z) {
            if (f1866b) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<androidx.fragment.app.d> it = this.f.iterator();
            while (it.hasNext()) {
                androidx.fragment.app.d next = it.next();
                arrayList.add(next.mWho);
                if (next.mFragmentManager != this) {
                    a(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                if (f1866b) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<androidx.fragment.app.a> arrayList3 = this.h;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i = 0; i < size; i++) {
                bVarArr[i] = new androidx.fragment.app.b(this.h.get(i));
                if (f1866b) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.h.get(i));
                }
            }
        }
        l lVar = new l();
        lVar.f1903a = arrayList2;
        lVar.f1904b = arrayList;
        lVar.f1905c = bVarArr;
        androidx.fragment.app.d dVar3 = this.f1870q;
        if (dVar3 != null) {
            lVar.f1906d = dVar3.mWho;
        }
        lVar.f1907e = this.f1869e;
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable) {
        o oVar;
        if (parcelable == null) {
            return;
        }
        l lVar = (l) parcelable;
        if (lVar.f1903a == null) {
            return;
        }
        for (androidx.fragment.app.d dVar : this.I.c()) {
            if (f1866b) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + dVar);
            }
            Iterator<o> it = lVar.f1903a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    oVar = null;
                    break;
                }
                oVar = it.next();
                if (oVar.f1918b.equals(dVar.mWho)) {
                    break;
                }
            }
            if (oVar == null) {
                if (f1866b) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + dVar + " that was not found in the set of active Fragments " + lVar.f1903a);
                }
                a(dVar, 1, 0, 0, false);
                dVar.mRemoving = true;
                a(dVar, 0, 0, 0, false);
            } else {
                oVar.n = dVar;
                dVar.mSavedViewState = null;
                dVar.mBackStackNesting = 0;
                dVar.mInLayout = false;
                dVar.mAdded = false;
                dVar.mTargetWho = dVar.mTarget != null ? dVar.mTarget.mWho : null;
                dVar.mTarget = null;
                if (oVar.m != null) {
                    oVar.m.setClassLoader(this.n.j().getClassLoader());
                    dVar.mSavedViewState = oVar.m.getSparseParcelableArray("android:view_state");
                    dVar.mSavedFragmentState = oVar.m;
                }
            }
        }
        this.g.clear();
        Iterator<o> it2 = lVar.f1903a.iterator();
        while (it2.hasNext()) {
            o next = it2.next();
            if (next != null) {
                androidx.fragment.app.d a2 = next.a(this.n.j().getClassLoader(), f());
                a2.mFragmentManager = this;
                if (f1866b) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + a2.mWho + "): " + a2);
                }
                this.g.put(a2.mWho, a2);
                next.n = null;
            }
        }
        this.f.clear();
        if (lVar.f1904b != null) {
            Iterator<String> it3 = lVar.f1904b.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                androidx.fragment.app.d dVar2 = this.g.get(next2);
                if (dVar2 == null) {
                    a(new IllegalStateException("No instantiated fragment for (" + next2 + ")"));
                }
                dVar2.mAdded = true;
                if (f1866b) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + next2 + "): " + dVar2);
                }
                if (this.f.contains(dVar2)) {
                    throw new IllegalStateException("Already added " + dVar2);
                }
                synchronized (this.f) {
                    this.f.add(dVar2);
                }
            }
        }
        if (lVar.f1905c != null) {
            this.h = new ArrayList<>(lVar.f1905c.length);
            for (int i = 0; i < lVar.f1905c.length; i++) {
                androidx.fragment.app.a a3 = lVar.f1905c[i].a(this);
                if (f1866b) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + a3.f1834c + "): " + a3);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
                    a3.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.h.add(a3);
                if (a3.f1834c >= 0) {
                    a(a3.f1834c, a3);
                }
            }
        } else {
            this.h = null;
        }
        if (lVar.f1906d != null) {
            androidx.fragment.app.d dVar3 = this.g.get(lVar.f1906d);
            this.f1870q = dVar3;
            w(dVar3);
        }
        this.f1869e = lVar.f1907e;
    }

    private void I() {
        this.g.values().removeAll(Collections.singleton(null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(i iVar, androidx.fragment.app.f fVar, androidx.fragment.app.d dVar) {
        if (this.n != null) {
            throw new IllegalStateException("Already attached");
        }
        this.n = iVar;
        this.o = fVar;
        this.p = dVar;
        if (dVar != null) {
            D();
        }
        if (iVar instanceof androidx.activity.d) {
            androidx.activity.d dVar2 = (androidx.activity.d) iVar;
            this.F = dVar2.b();
            androidx.fragment.app.d dVar3 = dVar2;
            if (dVar != null) {
                dVar3 = dVar;
            }
            this.F.a(dVar3, this.G);
        }
        if (dVar != null) {
            this.I = dVar.mFragmentManager.d(dVar);
        } else if (iVar instanceof ab) {
            this.I = m.a(((ab) iVar).getViewModelStore());
        } else {
            this.I = new m(false);
        }
    }

    public void p() {
        this.s = false;
        this.t = false;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null) {
                dVar.noteStateNotSaved();
            }
        }
    }

    public void q() {
        this.s = false;
        this.t = false;
        e(1);
    }

    public void r() {
        this.s = false;
        this.t = false;
        e(2);
    }

    public void s() {
        this.s = false;
        this.t = false;
        e(3);
    }

    public void t() {
        this.s = false;
        this.t = false;
        e(4);
    }

    public void u() {
        e(3);
    }

    public void v() {
        this.t = true;
        e(2);
    }

    public void w() {
        e(1);
    }

    public void x() {
        this.u = true;
        l();
        e(0);
        this.n = null;
        this.o = null;
        this.p = null;
        if (this.F != null) {
            this.G.b();
            this.F = null;
        }
    }

    private void e(int i) {
        try {
            this.f1868d = true;
            a(i, false);
            this.f1868d = false;
            l();
        } catch (Throwable th) {
            this.f1868d = false;
            throw th;
        }
    }

    public void a(boolean z) {
        for (int size = this.f.size() - 1; size >= 0; size--) {
            androidx.fragment.app.d dVar = this.f.get(size);
            if (dVar != null) {
                dVar.performMultiWindowModeChanged(z);
            }
        }
    }

    public void b(boolean z) {
        for (int size = this.f.size() - 1; size >= 0; size--) {
            androidx.fragment.app.d dVar = this.f.get(size);
            if (dVar != null) {
                dVar.performPictureInPictureModeChanged(z);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i = 0; i < this.f.size(); i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null) {
                dVar.performConfigurationChanged(configuration);
            }
        }
    }

    public void y() {
        for (int i = 0; i < this.f.size(); i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null) {
                dVar.performLowMemory();
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.m < 1) {
            return false;
        }
        ArrayList<androidx.fragment.app.d> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f.size(); i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null && dVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(dVar);
                z = true;
            }
        }
        if (this.i != null) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                androidx.fragment.app.d dVar2 = this.i.get(i2);
                if (arrayList == null || !arrayList.contains(dVar2)) {
                    dVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.i = arrayList;
        return z;
    }

    public boolean a(Menu menu) {
        if (this.m < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f.size(); i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null && dVar.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null && dVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.m < 1) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null && dVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.m < 1) {
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            androidx.fragment.app.d dVar = this.f.get(i);
            if (dVar != null) {
                dVar.performOptionsMenuClosed(menu);
            }
        }
    }

    public void u(androidx.fragment.app.d dVar) {
        if (dVar != null && (this.g.get(dVar.mWho) != dVar || (dVar.mHost != null && dVar.getFragmentManager() != this))) {
            throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
        }
        androidx.fragment.app.d dVar2 = this.f1870q;
        this.f1870q = dVar;
        w(dVar2);
        w(this.f1870q);
    }

    private void w(androidx.fragment.app.d dVar) {
        if (dVar == null || this.g.get(dVar.mWho) != dVar) {
            return;
        }
        dVar.performPrimaryNavigationFragmentChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        D();
        w(this.f1870q);
    }

    public androidx.fragment.app.d A() {
        return this.f1870q;
    }

    public void a(androidx.fragment.app.d dVar, h.b bVar) {
        if (this.g.get(dVar.mWho) != dVar || (dVar.mHost != null && dVar.getFragmentManager() != this)) {
            throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
        }
        dVar.mMaxState = bVar;
    }

    @Override // androidx.fragment.app.j
    public h f() {
        if (super.f() == f1864a) {
            androidx.fragment.app.d dVar = this.p;
            if (dVar != null) {
                return dVar.mFragmentManager.f();
            }
            a(new h() { // from class: androidx.fragment.app.k.6
                @Override // androidx.fragment.app.h
                public androidx.fragment.app.d c(ClassLoader classLoader, String str) {
                    return k.this.n.a(k.this.n.j(), str, (Bundle) null);
                }
            });
        }
        return super.f();
    }

    @Override // androidx.fragment.app.j
    public void a(j.a aVar, boolean z) {
        this.H.add(new c(aVar, z));
    }

    @Override // androidx.fragment.app.j
    public void a(j.a aVar) {
        synchronized (this.H) {
            int i = 0;
            int size = this.H.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.H.get(i).f1893a == aVar) {
                    this.H.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    void a(androidx.fragment.app.d dVar, Context context, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).a(dVar, context, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentPreAttached(this, dVar, context);
            }
        }
    }

    void b(androidx.fragment.app.d dVar, Context context, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).b(dVar, context, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentAttached(this, dVar, context);
            }
        }
    }

    void a(androidx.fragment.app.d dVar, Bundle bundle, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).a(dVar, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentPreCreated(this, dVar, bundle);
            }
        }
    }

    void b(androidx.fragment.app.d dVar, Bundle bundle, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).b(dVar, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentCreated(this, dVar, bundle);
            }
        }
    }

    void c(androidx.fragment.app.d dVar, Bundle bundle, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).c(dVar, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentActivityCreated(this, dVar, bundle);
            }
        }
    }

    void a(androidx.fragment.app.d dVar, View view, Bundle bundle, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).a(dVar, view, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentViewCreated(this, dVar, view, bundle);
            }
        }
    }

    void b(androidx.fragment.app.d dVar, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).b(dVar, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentStarted(this, dVar);
            }
        }
    }

    void c(androidx.fragment.app.d dVar, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).c(dVar, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentResumed(this, dVar);
            }
        }
    }

    void d(androidx.fragment.app.d dVar, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).d(dVar, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentPaused(this, dVar);
            }
        }
    }

    void e(androidx.fragment.app.d dVar, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).e(dVar, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentStopped(this, dVar);
            }
        }
    }

    void d(androidx.fragment.app.d dVar, Bundle bundle, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).d(dVar, bundle, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentSaveInstanceState(this, dVar, bundle);
            }
        }
    }

    void f(androidx.fragment.app.d dVar, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).f(dVar, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentViewDestroyed(this, dVar);
            }
        }
    }

    void g(androidx.fragment.app.d dVar, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).g(dVar, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentDestroyed(this, dVar);
            }
        }
    }

    void h(androidx.fragment.app.d dVar, boolean z) {
        androidx.fragment.app.d dVar2 = this.p;
        if (dVar2 != null) {
            j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof k) {
                ((k) fragmentManager).h(dVar, true);
            }
        }
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (!z || next.f1894b) {
                next.f1893a.onFragmentDetached(this, dVar);
            }
        }
    }

    boolean B() {
        boolean z = false;
        for (androidx.fragment.app.d dVar : this.g.values()) {
            if (dVar != null) {
                z = x(dVar);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private boolean x(androidx.fragment.app.d dVar) {
        return (dVar.mHasMenu && dVar.mMenuVisible) || dVar.mChildFragmentManager.B();
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f1895a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (str2 == null || !h.a(context.getClassLoader(), str2)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
            }
            androidx.fragment.app.d b2 = resourceId != -1 ? b(resourceId) : null;
            if (b2 == null && string != null) {
                b2 = a(string);
            }
            if (b2 == null && id != -1) {
                b2 = b(id);
            }
            if (f1866b) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + b2);
            }
            if (b2 == null) {
                b2 = f().c(context.getClassLoader(), str2);
                b2.mFromLayout = true;
                b2.mFragmentId = resourceId != 0 ? resourceId : id;
                b2.mContainerId = id;
                b2.mTag = string;
                b2.mInLayout = true;
                b2.mFragmentManager = this;
                b2.mHost = this.n;
                b2.onInflate(this.n.j(), attributeSet, b2.mSavedFragmentState);
                a(b2, true);
            } else if (b2.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            } else {
                b2.mInLayout = true;
                b2.mHost = this.n;
                b2.onInflate(this.n.j(), attributeSet, b2.mSavedFragmentState);
            }
            androidx.fragment.app.d dVar = b2;
            if (this.m < 1 && dVar.mFromLayout) {
                a(dVar, 1, 0, 0, false);
            } else {
                h(dVar);
            }
            if (dVar.mView == null) {
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            if (resourceId != 0) {
                dVar.mView.setId(resourceId);
            }
            if (dVar.mView.getTag() == null) {
                dVar.mView.setTag(string);
            }
            return dVar.mView;
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* compiled from: FragmentManagerImpl.java */
    /* loaded from: classes.dex */
    private class f implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f1896a;

        /* renamed from: b  reason: collision with root package name */
        final int f1897b;

        /* renamed from: c  reason: collision with root package name */
        final int f1898c;

        f(String str, int i, int i2) {
            this.f1896a = str;
            this.f1897b = i;
            this.f1898c = i2;
        }

        @Override // androidx.fragment.app.k.e
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            if (k.this.f1870q == null || this.f1897b >= 0 || this.f1896a != null || !k.this.f1870q.getChildFragmentManager().c()) {
                return k.this.a(arrayList, arrayList2, this.f1896a, this.f1897b, this.f1898c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManagerImpl.java */
    /* loaded from: classes.dex */
    public static class g implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f1900a;

        /* renamed from: b  reason: collision with root package name */
        final androidx.fragment.app.a f1901b;

        /* renamed from: c  reason: collision with root package name */
        private int f1902c;

        g(androidx.fragment.app.a aVar, boolean z) {
            this.f1900a = z;
            this.f1901b = aVar;
        }

        @Override // androidx.fragment.app.d.c
        public void a() {
            int i = this.f1902c - 1;
            this.f1902c = i;
            if (i != 0) {
                return;
            }
            this.f1901b.f1832a.k();
        }

        @Override // androidx.fragment.app.d.c
        public void b() {
            this.f1902c++;
        }

        public boolean c() {
            return this.f1902c == 0;
        }

        public void d() {
            boolean z = this.f1902c > 0;
            k kVar = this.f1901b.f1832a;
            int size = kVar.f.size();
            for (int i = 0; i < size; i++) {
                androidx.fragment.app.d dVar = kVar.f.get(i);
                dVar.setOnStartEnterTransitionListener(null);
                if (z && dVar.isPostponed()) {
                    dVar.startPostponedEnterTransition();
                }
            }
            this.f1901b.f1832a.a(this.f1901b, this.f1900a, !z, true);
        }

        public void e() {
            this.f1901b.f1832a.a(this.f1901b, this.f1900a, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManagerImpl.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f1886a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f1887b;

        a(Animation animation) {
            this.f1886a = animation;
            this.f1887b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f1886a = null;
            this.f1887b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManagerImpl.java */
    /* loaded from: classes.dex */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f1888a;

        /* renamed from: b  reason: collision with root package name */
        private final View f1889b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1890c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1891d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1892e;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1892e = true;
            this.f1888a = viewGroup;
            this.f1889b = view;
            addAnimation(animation);
            this.f1888a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f1892e = true;
            if (this.f1890c) {
                return !this.f1891d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f1890c = true;
                androidx.core.h.t.a(this.f1888a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f1892e = true;
            if (this.f1890c) {
                return !this.f1891d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f1890c = true;
                androidx.core.h.t.a(this.f1888a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f1890c && this.f1892e) {
                this.f1892e = false;
                this.f1888a.post(this);
                return;
            }
            this.f1888a.endViewTransition(this.f1889b);
            this.f1891d = true;
        }
    }
}
