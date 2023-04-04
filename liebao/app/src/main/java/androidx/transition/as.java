package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.a;
import androidx.transition.w;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class as extends w {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f2548a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: b  reason: collision with root package name */
    private int f2549b = 3;

    public Animator a(ViewGroup viewGroup, View view, ac acVar, ac acVar2) {
        return null;
    }

    public Animator b(ViewGroup viewGroup, View view, ac acVar, ac acVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f2558a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2559b;

        /* renamed from: c  reason: collision with root package name */
        int f2560c;

        /* renamed from: d  reason: collision with root package name */
        int f2561d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f2562e;
        ViewGroup f;

        b() {
        }
    }

    public void a(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f2549b = i;
    }

    @Override // androidx.transition.w
    public String[] getTransitionProperties() {
        return f2548a;
    }

    private void a(ac acVar) {
        acVar.f2509a.put("android:visibility:visibility", Integer.valueOf(acVar.f2510b.getVisibility()));
        acVar.f2509a.put("android:visibility:parent", acVar.f2510b.getParent());
        int[] iArr = new int[2];
        acVar.f2510b.getLocationOnScreen(iArr);
        acVar.f2509a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.transition.w
    public void captureStartValues(ac acVar) {
        a(acVar);
    }

    @Override // androidx.transition.w
    public void captureEndValues(ac acVar) {
        a(acVar);
    }

    private b a(ac acVar, ac acVar2) {
        b bVar = new b();
        bVar.f2558a = false;
        bVar.f2559b = false;
        if (acVar != null && acVar.f2509a.containsKey("android:visibility:visibility")) {
            bVar.f2560c = ((Integer) acVar.f2509a.get("android:visibility:visibility")).intValue();
            bVar.f2562e = (ViewGroup) acVar.f2509a.get("android:visibility:parent");
        } else {
            bVar.f2560c = -1;
            bVar.f2562e = null;
        }
        if (acVar2 != null && acVar2.f2509a.containsKey("android:visibility:visibility")) {
            bVar.f2561d = ((Integer) acVar2.f2509a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) acVar2.f2509a.get("android:visibility:parent");
        } else {
            bVar.f2561d = -1;
            bVar.f = null;
        }
        if (acVar != null && acVar2 != null) {
            if (bVar.f2560c == bVar.f2561d && bVar.f2562e == bVar.f) {
                return bVar;
            }
            if (bVar.f2560c != bVar.f2561d) {
                if (bVar.f2560c == 0) {
                    bVar.f2559b = false;
                    bVar.f2558a = true;
                } else if (bVar.f2561d == 0) {
                    bVar.f2559b = true;
                    bVar.f2558a = true;
                }
            } else if (bVar.f == null) {
                bVar.f2559b = false;
                bVar.f2558a = true;
            } else if (bVar.f2562e == null) {
                bVar.f2559b = true;
                bVar.f2558a = true;
            }
        } else if (acVar == null && bVar.f2561d == 0) {
            bVar.f2559b = true;
            bVar.f2558a = true;
        } else if (acVar2 == null && bVar.f2560c == 0) {
            bVar.f2559b = false;
            bVar.f2558a = true;
        }
        return bVar;
    }

    @Override // androidx.transition.w
    public Animator createAnimator(ViewGroup viewGroup, ac acVar, ac acVar2) {
        b a2 = a(acVar, acVar2);
        if (a2.f2558a) {
            if (a2.f2562e == null && a2.f == null) {
                return null;
            }
            if (a2.f2559b) {
                return a(viewGroup, acVar, a2.f2560c, acVar2, a2.f2561d);
            }
            return b(viewGroup, acVar, a2.f2560c, acVar2, a2.f2561d);
        }
        return null;
    }

    public Animator a(ViewGroup viewGroup, ac acVar, int i, ac acVar2, int i2) {
        if ((this.f2549b & 1) != 1 || acVar2 == null) {
            return null;
        }
        if (acVar == null) {
            View view = (View) acVar2.f2510b.getParent();
            if (a(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f2558a) {
                return null;
            }
        }
        return a(viewGroup, acVar2.f2510b, acVar, acVar2);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator b(ViewGroup viewGroup, ac acVar, int i, ac acVar2, int i2) {
        int id;
        if ((this.f2549b & 2) != 2) {
            return null;
        }
        final View view = acVar != null ? acVar.f2510b : null;
        View view2 = acVar2 != null ? acVar2.f2510b : null;
        if (view2 == null || view2.getParent() == null) {
            if (view2 == null) {
                if (view != null) {
                    if (view.getParent() != null) {
                        if (view.getParent() instanceof View) {
                            View view3 = (View) view.getParent();
                            if (!a(getTransitionValues(view3, true), getMatchedTransitionValues(view3, true)).f2558a) {
                                view = ab.a(viewGroup, view, view3);
                            } else if (view3.getParent() != null || (id = view3.getId()) == -1 || viewGroup.findViewById(id) == null || !this.mCanRemoveViews) {
                                view = null;
                            }
                        }
                    }
                }
                view = null;
                view2 = null;
                if (view != null || acVar == null) {
                    if (view2 == null) {
                        int visibility = view2.getVisibility();
                        an.a(view2, 0);
                        Animator b2 = b(viewGroup, view2, acVar, acVar2);
                        if (b2 != null) {
                            a aVar = new a(view2, i2, true);
                            b2.addListener(aVar);
                            androidx.transition.a.a(b2, aVar);
                            addListener(aVar);
                        } else {
                            an.a(view2, visibility);
                        }
                        return b2;
                    }
                    return null;
                }
                int[] iArr = (int[]) acVar.f2509a.get("android:visibility:screenLocation");
                int i3 = iArr[0];
                int i4 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view.offsetLeftAndRight((i3 - iArr2[0]) - view.getLeft());
                view.offsetTopAndBottom((i4 - iArr2[1]) - view.getTop());
                final ag a2 = ah.a(viewGroup);
                a2.a(view);
                Animator b3 = b(viewGroup, view, acVar, acVar2);
                if (b3 == null) {
                    a2.b(view);
                } else {
                    b3.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.as.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            a2.b(view);
                        }
                    });
                }
                return b3;
            }
            view = view2;
            view2 = null;
            if (view != null) {
            }
            if (view2 == null) {
            }
        } else if (i2 == 4 || view == view2) {
            view = null;
            if (view != null) {
            }
            if (view2 == null) {
            }
        } else {
            if (!this.mCanRemoveViews) {
                view = ab.a(viewGroup, view, (View) view.getParent());
            }
            view2 = null;
            if (view != null) {
            }
            if (view2 == null) {
            }
        }
    }

    @Override // androidx.transition.w
    public boolean isTransitionRequired(ac acVar, ac acVar2) {
        if (acVar == null && acVar2 == null) {
            return false;
        }
        if (acVar == null || acVar2 == null || acVar2.f2509a.containsKey("android:visibility:visibility") == acVar.f2509a.containsKey("android:visibility:visibility")) {
            b a2 = a(acVar, acVar2);
            if (a2.f2558a) {
                return a2.f2560c == 0 || a2.f2561d == 0;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements a.InterfaceC0059a, w.d {

        /* renamed from: a  reason: collision with root package name */
        boolean f2553a = false;

        /* renamed from: b  reason: collision with root package name */
        private final View f2554b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2555c;

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f2556d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f2557e;
        private boolean f;

        @Override // androidx.transition.w.d
        public void a(w wVar) {
        }

        @Override // androidx.transition.w.d
        public void e(w wVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        a(View view, int i, boolean z) {
            this.f2554b = view;
            this.f2555c = i;
            this.f2556d = (ViewGroup) view.getParent();
            this.f2557e = z;
            a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0059a
        public void onAnimationPause(Animator animator) {
            if (this.f2553a) {
                return;
            }
            an.a(this.f2554b, this.f2555c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0059a
        public void onAnimationResume(Animator animator) {
            if (this.f2553a) {
                return;
            }
            an.a(this.f2554b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2553a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // androidx.transition.w.d
        public void b(w wVar) {
            a();
            wVar.removeListener(this);
        }

        @Override // androidx.transition.w.d
        public void c(w wVar) {
            a(false);
        }

        @Override // androidx.transition.w.d
        public void d(w wVar) {
            a(true);
        }

        private void a() {
            if (!this.f2553a) {
                an.a(this.f2554b, this.f2555c);
                ViewGroup viewGroup = this.f2556d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f2557e || this.f == z || (viewGroup = this.f2556d) == null) {
                return;
            }
            this.f = z;
            ah.a(viewGroup, z);
        }
    }
}
