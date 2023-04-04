package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.w;
import androidx.fragment.app.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1930a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final s f1931b;

    /* renamed from: c  reason: collision with root package name */
    private static final s f1932c;

    static {
        f1931b = Build.VERSION.SDK_INT >= 21 ? new r() : null;
        f1932c = a();
    }

    private static s a() {
        try {
            return (s) Class.forName("androidx.transition.h").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(k kVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (kVar.m < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(aVar, sparseArray, z);
            } else {
                a(aVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(kVar.n.j());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                androidx.b.a<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                a aVar2 = (a) sparseArray.valueAt(i4);
                if (z) {
                    a(kVar, keyAt, aVar2, view, a2);
                } else {
                    b(kVar, keyAt, aVar2, view, a2);
                }
            }
        }
    }

    private static androidx.b.a<String, String> a(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.b.a<String, String> aVar = new androidx.b.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.r != null) {
                    int size = aVar2.r.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.r;
                        arrayList4 = aVar2.s;
                    } else {
                        ArrayList<String> arrayList5 = aVar2.r;
                        arrayList3 = aVar2.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = aVar.remove(str2);
                        if (remove != null) {
                            aVar.put(str, remove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static void a(k kVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        d dVar;
        d dVar2;
        s a2;
        Object obj;
        ViewGroup viewGroup = kVar.o.a() ? (ViewGroup) kVar.o.a(i) : null;
        if (viewGroup == null || (a2 = a((dVar2 = aVar.f1952d), (dVar = aVar.f1949a))) == null) {
            return;
        }
        boolean z = aVar.f1950b;
        boolean z2 = aVar.f1953e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, dVar, z);
        Object b2 = b(a2, dVar2, z2);
        Object a4 = a(a2, viewGroup, view, aVar2, aVar, arrayList2, arrayList, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a5 = a(a2, obj, dVar2, arrayList2, view);
        ArrayList<View> a6 = a(a2, a3, dVar, arrayList, view);
        a(a6, 4);
        Object a7 = a(a2, a3, obj, a4, dVar, z);
        if (a7 != null) {
            a(a2, obj, dVar2, a5);
            ArrayList<String> a8 = a2.a(arrayList);
            a2.a(a7, a3, a6, obj, a5, a4, arrayList);
            a2.a(viewGroup, a7);
            a2.a(viewGroup, arrayList2, arrayList, a8, aVar2);
            a(a6, 0);
            a2.a(a4, arrayList2, arrayList);
        }
    }

    private static void a(s sVar, Object obj, d dVar, final ArrayList<View> arrayList) {
        if (dVar != null && obj != null && dVar.mAdded && dVar.mHidden && dVar.mHiddenChanged) {
            dVar.setHideReplaced(true);
            sVar.b(obj, dVar.getView(), arrayList);
            androidx.core.h.t.a(dVar.mContainer, new Runnable() { // from class: androidx.fragment.app.q.1
                @Override // java.lang.Runnable
                public void run() {
                    q.a(arrayList, 4);
                }
            });
        }
    }

    private static void b(k kVar, int i, a aVar, View view, androidx.b.a<String, String> aVar2) {
        d dVar;
        d dVar2;
        s a2;
        Object obj;
        ViewGroup viewGroup = kVar.o.a() ? (ViewGroup) kVar.o.a(i) : null;
        if (viewGroup == null || (a2 = a((dVar2 = aVar.f1952d), (dVar = aVar.f1949a))) == null) {
            return;
        }
        boolean z = aVar.f1950b;
        boolean z2 = aVar.f1953e;
        Object a3 = a(a2, dVar, z);
        Object b2 = b(a2, dVar2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object b3 = b(a2, viewGroup, view, aVar2, aVar, arrayList, arrayList2, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> a4 = a(a2, obj, dVar2, arrayList, view);
        Object obj2 = (a4 == null || a4.isEmpty()) ? null : obj;
        a2.b(a3, view);
        Object a5 = a(a2, a3, obj2, b3, dVar, aVar.f1950b);
        if (a5 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.a(a5, a3, arrayList3, obj2, a4, b3, arrayList2);
            a(a2, viewGroup, dVar, view, arrayList2, a3, arrayList3, obj2, a4);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) aVar2);
            a2.a(viewGroup, a5);
            a2.a(viewGroup, arrayList2, (Map<String, String>) aVar2);
        }
    }

    private static void a(final s sVar, ViewGroup viewGroup, final d dVar, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        androidx.core.h.t.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.q.2
            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    sVar.c(obj3, view);
                    arrayList2.addAll(q.a(sVar, obj, dVar, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        sVar.b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static s a(d dVar, d dVar2) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            Object exitTransition = dVar.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = dVar.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = dVar.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (dVar2 != null) {
            Object enterTransition = dVar2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = dVar2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = dVar2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        s sVar = f1931b;
        if (sVar != null && a(sVar, arrayList)) {
            return f1931b;
        }
        s sVar2 = f1932c;
        if (sVar2 != null && a(sVar2, arrayList)) {
            return f1932c;
        }
        if (f1931b == null && f1932c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(s sVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!sVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(s sVar, d dVar, d dVar2, boolean z) {
        Object sharedElementEnterTransition;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = dVar2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = dVar.getSharedElementEnterTransition();
        }
        return sVar.c(sVar.b(sharedElementEnterTransition));
    }

    private static Object a(s sVar, d dVar, boolean z) {
        Object enterTransition;
        if (dVar == null) {
            return null;
        }
        if (z) {
            enterTransition = dVar.getReenterTransition();
        } else {
            enterTransition = dVar.getEnterTransition();
        }
        return sVar.b(enterTransition);
    }

    private static Object b(s sVar, d dVar, boolean z) {
        Object exitTransition;
        if (dVar == null) {
            return null;
        }
        if (z) {
            exitTransition = dVar.getReturnTransition();
        } else {
            exitTransition = dVar.getExitTransition();
        }
        return sVar.b(exitTransition);
    }

    private static Object a(final s sVar, ViewGroup viewGroup, View view, androidx.b.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final d dVar = aVar2.f1949a;
        final d dVar2 = aVar2.f1952d;
        if (dVar != null) {
            dVar.requireView().setVisibility(0);
        }
        if (dVar == null || dVar2 == null) {
            return null;
        }
        final boolean z = aVar2.f1950b;
        Object a2 = aVar.isEmpty() ? null : a(sVar, dVar, dVar2, z);
        androidx.b.a<String, View> b2 = b(sVar, aVar, a2, aVar2);
        final androidx.b.a<String, View> a3 = a(sVar, aVar, a2, aVar2);
        if (aVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a3 != null) {
                a3.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, b2, aVar.keySet());
            a(arrayList2, a3, aVar.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(dVar, dVar2, z, b2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            sVar.a(obj3, view, arrayList);
            a(sVar, obj3, obj2, b2, aVar2.f1953e, aVar2.f);
            Rect rect2 = new Rect();
            View a4 = a(a3, aVar2, obj, z);
            if (a4 != null) {
                sVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = a4;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.h.t.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.q.3
            @Override // java.lang.Runnable
            public void run() {
                q.a(d.this, dVar2, z, (androidx.b.a<String, View>) a3, false);
                View view3 = view2;
                if (view3 != null) {
                    sVar.a(view3, rect);
                }
            }
        });
        return obj3;
    }

    private static void a(ArrayList<View> arrayList, androidx.b.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View c2 = aVar.c(size);
            if (collection.contains(w.p(c2))) {
                arrayList.add(c2);
            }
        }
    }

    private static Object b(final s sVar, ViewGroup viewGroup, final View view, final androidx.b.a<String, String> aVar, final a aVar2, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object a2;
        androidx.b.a<String, String> aVar3;
        Object obj3;
        Rect rect;
        final d dVar = aVar2.f1949a;
        final d dVar2 = aVar2.f1952d;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        final boolean z = aVar2.f1950b;
        if (aVar.isEmpty()) {
            aVar3 = aVar;
            a2 = null;
        } else {
            a2 = a(sVar, dVar, dVar2, z);
            aVar3 = aVar;
        }
        androidx.b.a<String, View> b2 = b(sVar, aVar3, a2, aVar2);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(b2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(dVar, dVar2, z, b2, true);
        if (obj3 != null) {
            rect = new Rect();
            sVar.a(obj3, view, arrayList);
            a(sVar, obj3, obj2, b2, aVar2.f1953e, aVar2.f);
            if (obj != null) {
                sVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        androidx.core.h.t.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.q.4
            @Override // java.lang.Runnable
            public void run() {
                androidx.b.a<String, View> a3 = q.a(s.this, aVar, obj4, aVar2);
                if (a3 != null) {
                    arrayList2.addAll(a3.values());
                    arrayList2.add(view);
                }
                q.a(dVar, dVar2, z, a3, false);
                Object obj5 = obj4;
                if (obj5 != null) {
                    s.this.a(obj5, arrayList, arrayList2);
                    View a4 = q.a(a3, aVar2, obj, z);
                    if (a4 != null) {
                        s.this.a(a4, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    private static androidx.b.a<String, View> b(s sVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        androidx.core.app.n exitTransitionCallback;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        d dVar = aVar2.f1952d;
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        sVar.a((Map<String, View>) aVar3, dVar.requireView());
        androidx.fragment.app.a aVar4 = aVar2.f;
        if (aVar2.f1953e) {
            exitTransitionCallback = dVar.getEnterTransitionCallback();
            arrayList = aVar4.s;
        } else {
            exitTransitionCallback = dVar.getExitTransitionCallback();
            arrayList = aVar4.r;
        }
        aVar3.a((Collection<?>) arrayList);
        if (exitTransitionCallback != null) {
            exitTransitionCallback.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(w.p(view))) {
                    aVar.put(w.p(view), aVar.remove(str));
                }
            }
        } else {
            aVar.a((Collection<?>) aVar3.keySet());
        }
        return aVar3;
    }

    static androidx.b.a<String, View> a(s sVar, androidx.b.a<String, String> aVar, Object obj, a aVar2) {
        androidx.core.app.n enterTransitionCallback;
        ArrayList<String> arrayList;
        String a2;
        d dVar = aVar2.f1949a;
        View view = dVar.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.b.a<String, View> aVar3 = new androidx.b.a<>();
        sVar.a((Map<String, View>) aVar3, view);
        androidx.fragment.app.a aVar4 = aVar2.f1951c;
        if (aVar2.f1950b) {
            enterTransitionCallback = dVar.getExitTransitionCallback();
            arrayList = aVar4.r;
        } else {
            enterTransitionCallback = dVar.getEnterTransitionCallback();
            arrayList = aVar4.s;
        }
        if (arrayList != null) {
            aVar3.a((Collection<?>) arrayList);
            aVar3.a((Collection<?>) aVar.values());
        }
        if (enterTransitionCallback != null) {
            enterTransitionCallback.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = aVar3.get(str);
                if (view2 == null) {
                    String a3 = a(aVar, str);
                    if (a3 != null) {
                        aVar.remove(a3);
                    }
                } else if (!str.equals(w.p(view2)) && (a2 = a(aVar, str)) != null) {
                    aVar.put(a2, w.p(view2));
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }

    private static String a(androidx.b.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static View a(androidx.b.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        String str;
        androidx.fragment.app.a aVar3 = aVar2.f1951c;
        if (obj == null || aVar == null || aVar3.r == null || aVar3.r.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar3.r.get(0);
        } else {
            str = aVar3.s.get(0);
        }
        return aVar.get(str);
    }

    private static void a(s sVar, Object obj, Object obj2, androidx.b.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        String str;
        if (aVar2.r == null || aVar2.r.isEmpty()) {
            return;
        }
        if (z) {
            str = aVar2.s.get(0);
        } else {
            str = aVar2.r.get(0);
        }
        View view = aVar.get(str);
        sVar.a(obj, view);
        if (obj2 != null) {
            sVar.a(obj2, view);
        }
    }

    private static void a(androidx.b.a<String, String> aVar, androidx.b.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    static void a(d dVar, d dVar2, boolean z, androidx.b.a<String, View> aVar, boolean z2) {
        androidx.core.app.n enterTransitionCallback;
        if (z) {
            enterTransitionCallback = dVar2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = dVar.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                enterTransitionCallback.a(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.b(arrayList2, arrayList, null);
            }
        }
    }

    static ArrayList<View> a(s sVar, Object obj, d dVar, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View view2 = dVar.getView();
            if (view2 != null) {
                sVar.a(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            sVar.a(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static Object a(s sVar, Object obj, Object obj2, Object obj3, d dVar, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || dVar == null) {
            z2 = true;
        } else if (z) {
            z2 = dVar.getAllowReturnTransitionOverlap();
        } else {
            z2 = dVar.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return sVar.a(obj2, obj, obj3);
        }
        return sVar.b(obj2, obj, obj3);
    }

    public static void a(androidx.fragment.app.a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.f1922d.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.f1922d.get(i), sparseArray, false, z);
        }
    }

    public static void b(androidx.fragment.app.a aVar, SparseArray<a> sparseArray, boolean z) {
        if (aVar.f1832a.o.a()) {
            for (int size = aVar.f1922d.size() - 1; size >= 0; size--) {
                a(aVar, aVar.f1922d.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0041, code lost:
        if (r10.mAdded != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0078, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0094, code lost:
        if (r10.mHidden == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0096, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e9 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(androidx.fragment.app.a aVar, p.a aVar2, SparseArray<a> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        a aVar3;
        k kVar;
        d dVar = aVar2.f1926b;
        if (dVar == null || (i = dVar.mContainerId) == 0) {
            return;
        }
        int i2 = z ? f1930a[aVar2.f1925a] : aVar2.f1925a;
        boolean z7 = false;
        if (i2 != 1) {
            if (i2 != 3) {
                if (i2 == 4) {
                    boolean z8 = !z2 ? false : false;
                    z5 = z8;
                    z4 = false;
                    z6 = true;
                    a aVar4 = sparseArray.get(i);
                    if (z7) {
                    }
                    aVar3 = aVar4;
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                } else if (i2 != 5) {
                    if (i2 != 6) {
                        if (i2 != 7) {
                            z4 = false;
                            z6 = false;
                            z5 = false;
                            a aVar42 = sparseArray.get(i);
                            if (z7) {
                                aVar42 = a(aVar42, sparseArray, i);
                                aVar42.f1949a = dVar;
                                aVar42.f1950b = z;
                                aVar42.f1951c = aVar;
                            }
                            aVar3 = aVar42;
                            if (!z2 && z4) {
                                if (aVar3 != null && aVar3.f1952d == dVar) {
                                    aVar3.f1952d = null;
                                }
                                kVar = aVar.f1832a;
                                if (dVar.mState < 1 && kVar.m >= 1 && !aVar.t) {
                                    kVar.l(dVar);
                                    kVar.a(dVar, 1, 0, 0, false);
                                }
                            }
                            if (z5 && (aVar3 == null || aVar3.f1952d == null)) {
                                aVar3 = a(aVar3, sparseArray, i);
                                aVar3.f1952d = dVar;
                                aVar3.f1953e = z;
                                aVar3.f = aVar;
                            }
                            if (z2 || !z6 || aVar3 == null || aVar3.f1949a != dVar) {
                                return;
                            }
                            aVar3.f1949a = null;
                            return;
                        }
                    }
                } else if (z2) {
                    if (dVar.mHiddenChanged) {
                        if (!dVar.mHidden) {
                        }
                    }
                    z3 = false;
                    z7 = z3;
                    z4 = true;
                    z6 = false;
                    z5 = false;
                    a aVar422 = sparseArray.get(i);
                    if (z7) {
                    }
                    aVar3 = aVar422;
                    if (!z2) {
                        if (aVar3 != null) {
                            aVar3.f1952d = null;
                        }
                        kVar = aVar.f1832a;
                        if (dVar.mState < 1) {
                            kVar.l(dVar);
                            kVar.a(dVar, 1, 0, 0, false);
                        }
                    }
                    if (z5) {
                        aVar3 = a(aVar3, sparseArray, i);
                        aVar3.f1952d = dVar;
                        aVar3.f1953e = z;
                        aVar3.f = aVar;
                    }
                    if (z2) {
                        return;
                    }
                    return;
                } else {
                    z3 = dVar.mHidden;
                    z7 = z3;
                    z4 = true;
                    z6 = false;
                    z5 = false;
                    a aVar4222 = sparseArray.get(i);
                    if (z7) {
                    }
                    aVar3 = aVar4222;
                    if (!z2) {
                    }
                    if (z5) {
                    }
                    if (z2) {
                    }
                }
            }
            if (!z2) {
            }
            z5 = z8;
            z4 = false;
            z6 = true;
            a aVar42222 = sparseArray.get(i);
            if (z7) {
            }
            aVar3 = aVar42222;
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
        if (z2) {
            z3 = dVar.mIsNewlyAdded;
            z7 = z3;
            z4 = true;
            z6 = false;
            z5 = false;
            a aVar422222 = sparseArray.get(i);
            if (z7) {
            }
            aVar3 = aVar422222;
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        } else {
            if (!dVar.mAdded) {
            }
            z3 = false;
            z7 = z3;
            z4 = true;
            z6 = false;
            z5 = false;
            a aVar4222222 = sparseArray.get(i);
            if (z7) {
            }
            aVar3 = aVar4222222;
            if (!z2) {
            }
            if (z5) {
            }
            if (z2) {
            }
        }
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar == null) {
            a aVar2 = new a();
            sparseArray.put(i, aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransition.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public d f1949a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1950b;

        /* renamed from: c  reason: collision with root package name */
        public androidx.fragment.app.a f1951c;

        /* renamed from: d  reason: collision with root package name */
        public d f1952d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1953e;
        public androidx.fragment.app.a f;

        a() {
        }
    }
}
