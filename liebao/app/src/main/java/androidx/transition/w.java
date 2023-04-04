package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class w implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<ac> mEndValuesList;
    private c mEpicenterCallback;
    private androidx.b.a<String, String> mNameOverrides;
    z mPropagation;
    private ArrayList<ac> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final p STRAIGHT_PATH_MOTION = new p() { // from class: androidx.transition.w.1
        @Override // androidx.transition.p
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    };
    private static ThreadLocal<androidx.b.a<Animator, a>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class> mTargetTypeChildExcludes = null;
    private ad mStartValues = new ad();
    private ad mEndValues = new ad();
    aa mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<d> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private p mPathMotion = STRAIGHT_PATH_MOTION;

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract Rect a(w wVar);
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(w wVar);

        void b(w wVar);

        void c(w wVar);

        void d(w wVar);

        void e(w wVar);
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    public abstract void captureEndValues(ac acVar);

    public abstract void captureStartValues(ac acVar);

    public Animator createAnimator(ViewGroup viewGroup, ac acVar, ac acVar2) {
        return null;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public w() {
    }

    public w(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.f2659c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a2 = androidx.core.content.b.g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (a2 >= 0) {
            setDuration(a2);
        }
        long a3 = androidx.core.content.b.g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a3 > 0) {
            setStartDelay(a3);
        }
        int c2 = androidx.core.content.b.g.c(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (c2 > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, c2));
        }
        String a4 = androidx.core.content.b.g.a(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (a4 != null) {
            setMatchOrder(parseMatchOrder(a4));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i++;
        }
        return iArr;
    }

    public w setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public w setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public w setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (alreadyContains(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void matchInstances(androidx.b.a<View, ac> aVar, androidx.b.a<View, ac> aVar2) {
        ac remove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View b2 = aVar.b(size);
            if (b2 != null && isValidTarget(b2) && (remove = aVar2.remove(b2)) != null && remove.f2510b != null && isValidTarget(remove.f2510b)) {
                this.mStartValuesList.add(aVar.d(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(androidx.b.a<View, ac> aVar, androidx.b.a<View, ac> aVar2, androidx.b.d<View> dVar, androidx.b.d<View> dVar2) {
        View a2;
        int b2 = dVar.b();
        for (int i = 0; i < b2; i++) {
            View c2 = dVar.c(i);
            if (c2 != null && isValidTarget(c2) && (a2 = dVar2.a(dVar.b(i))) != null && isValidTarget(a2)) {
                ac acVar = aVar.get(c2);
                ac acVar2 = aVar2.get(a2);
                if (acVar != null && acVar2 != null) {
                    this.mStartValuesList.add(acVar);
                    this.mEndValuesList.add(acVar2);
                    aVar.remove(c2);
                    aVar2.remove(a2);
                }
            }
        }
    }

    private void matchIds(androidx.b.a<View, ac> aVar, androidx.b.a<View, ac> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                ac acVar = aVar.get(valueAt);
                ac acVar2 = aVar2.get(view);
                if (acVar != null && acVar2 != null) {
                    this.mStartValuesList.add(acVar);
                    this.mEndValuesList.add(acVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void matchNames(androidx.b.a<View, ac> aVar, androidx.b.a<View, ac> aVar2, androidx.b.a<String, View> aVar3, androidx.b.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View c2 = aVar3.c(i);
            if (c2 != null && isValidTarget(c2) && (view = aVar4.get(aVar3.b(i))) != null && isValidTarget(view)) {
                ac acVar = aVar.get(c2);
                ac acVar2 = aVar2.get(view);
                if (acVar != null && acVar2 != null) {
                    this.mStartValuesList.add(acVar);
                    this.mEndValuesList.add(acVar2);
                    aVar.remove(c2);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void addUnmatched(androidx.b.a<View, ac> aVar, androidx.b.a<View, ac> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            ac c2 = aVar.c(i);
            if (isValidTarget(c2.f2510b)) {
                this.mStartValuesList.add(c2);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            ac c3 = aVar2.c(i2);
            if (isValidTarget(c3.f2510b)) {
                this.mEndValuesList.add(c3);
                this.mStartValuesList.add(null);
            }
        }
    }

    private void matchStartAndEnd(ad adVar, ad adVar2) {
        androidx.b.a<View, ac> aVar = new androidx.b.a<>(adVar.f2512a);
        androidx.b.a<View, ac> aVar2 = new androidx.b.a<>(adVar2.f2512a);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    matchInstances(aVar, aVar2);
                } else if (i2 == 2) {
                    matchNames(aVar, aVar2, adVar.f2515d, adVar2.f2515d);
                } else if (i2 == 3) {
                    matchIds(aVar, aVar2, adVar.f2513b, adVar2.f2513b);
                } else if (i2 == 4) {
                    matchItemIds(aVar, aVar2, adVar.f2514c, adVar2.f2514c);
                }
                i++;
            } else {
                addUnmatched(aVar, aVar2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, ad adVar, ad adVar2, ArrayList<ac> arrayList, ArrayList<ac> arrayList2) {
        Animator createAnimator;
        int i;
        int i2;
        View view;
        Animator animator;
        ac acVar;
        Animator animator2;
        ac acVar2;
        androidx.b.a<Animator, a> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            ac acVar3 = arrayList.get(i3);
            ac acVar4 = arrayList2.get(i3);
            if (acVar3 != null && !acVar3.f2511c.contains(this)) {
                acVar3 = null;
            }
            if (acVar4 != null && !acVar4.f2511c.contains(this)) {
                acVar4 = null;
            }
            if (acVar3 != null || acVar4 != null) {
                if ((acVar3 == null || acVar4 == null || isTransitionRequired(acVar3, acVar4)) && (createAnimator = createAnimator(viewGroup, acVar3, acVar4)) != null) {
                    if (acVar4 != null) {
                        view = acVar4.f2510b;
                        String[] transitionProperties = getTransitionProperties();
                        if (view == null || transitionProperties == null || transitionProperties.length <= 0) {
                            i = size;
                            i2 = i3;
                            animator2 = createAnimator;
                            acVar2 = null;
                        } else {
                            acVar2 = new ac();
                            acVar2.f2510b = view;
                            i = size;
                            ac acVar5 = adVar2.f2512a.get(view);
                            if (acVar5 != null) {
                                int i4 = 0;
                                while (i4 < transitionProperties.length) {
                                    acVar2.f2509a.put(transitionProperties[i4], acVar5.f2509a.get(transitionProperties[i4]));
                                    i4++;
                                    i3 = i3;
                                    acVar5 = acVar5;
                                }
                            }
                            i2 = i3;
                            int size2 = runningAnimators.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = createAnimator;
                                    break;
                                }
                                a aVar = runningAnimators.get(runningAnimators.b(i5));
                                if (aVar.f2667c != null && aVar.f2665a == view && aVar.f2666b.equals(getName()) && aVar.f2667c.equals(acVar2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        }
                        animator = animator2;
                        acVar = acVar2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = acVar3.f2510b;
                        animator = createAnimator;
                        acVar = null;
                    }
                    if (animator != null) {
                        z zVar = this.mPropagation;
                        if (zVar != null) {
                            long a2 = zVar.a(viewGroup, this, acVar3, acVar4);
                            sparseIntArray.put(this.mAnimators.size(), (int) a2);
                            j = Math.min(a2, j);
                        }
                        runningAnimators.put(animator, new a(view, getName(), this, an.b(viewGroup), acVar));
                        this.mAnimators.add(animator);
                        j = j;
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (j != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((sparseIntArray.valueAt(i6) - j) + animator3.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.mTargetExcludes;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class> arrayList5 = this.mTargetTypeExcludes;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.mTargetNameExcludes == null || androidx.core.h.w.p(view) == null || !this.mTargetNameExcludes.contains(androidx.core.h.w.p(view))) {
                    if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
                        return true;
                    }
                    ArrayList<String> arrayList6 = this.mTargetNames;
                    if (arrayList6 == null || !arrayList6.contains(androidx.core.h.w.p(view))) {
                        if (this.mTargetTypes != null) {
                            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                                if (this.mTargetTypes.get(i2).isInstance(view)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static androidx.b.a<Animator, a> getRunningAnimators() {
        androidx.b.a<Animator, a> aVar = sRunningAnimators.get();
        if (aVar == null) {
            androidx.b.a<Animator, a> aVar2 = new androidx.b.a<>();
            sRunningAnimators.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runAnimators() {
        start();
        androidx.b.a<Animator, a> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    private void runAnimator(Animator animator, final androidx.b.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.w.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    w.this.mCurrentAnimators.add(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    aVar.remove(animator2);
                    w.this.mCurrentAnimators.remove(animator2);
                }
            });
            animate(animator);
        }
    }

    public w addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public w addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public w addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public w addTarget(Class cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public w removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public w removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public w removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public w removeTarget(Class cls) {
        ArrayList<Class> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t != null) {
            if (z) {
                return b.a(arrayList, t);
            }
            return b.b(arrayList, t);
        }
        return arrayList;
    }

    public w excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public w excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public w excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public w excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public w excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i > 0) {
            if (z) {
                return b.a(arrayList, Integer.valueOf(i));
            }
            return b.b(arrayList, Integer.valueOf(i));
        }
        return arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            if (z) {
                return b.a(arrayList, view);
            }
            return b.b(arrayList, view);
        }
        return arrayList;
    }

    public w excludeTarget(Class cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public w excludeChildren(Class cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    private ArrayList<Class> excludeType(ArrayList<Class> arrayList, Class cls, boolean z) {
        if (cls != null) {
            if (z) {
                return b.a(arrayList, cls);
            }
            return b.b(arrayList, cls);
        }
        return arrayList;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class> getTargetTypes() {
        return this.mTargetTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        androidx.b.a<String, String> aVar;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    ac acVar = new ac();
                    acVar.f2510b = findViewById;
                    if (z) {
                        captureStartValues(acVar);
                    } else {
                        captureEndValues(acVar);
                    }
                    acVar.f2511c.add(this);
                    capturePropagationValues(acVar);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, acVar);
                    } else {
                        addViewValues(this.mEndValues, findViewById, acVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                ac acVar2 = new ac();
                acVar2.f2510b = view;
                if (z) {
                    captureStartValues(acVar2);
                } else {
                    captureEndValues(acVar2);
                }
                acVar2.f2511c.add(this);
                capturePropagationValues(acVar2);
                if (z) {
                    addViewValues(this.mStartValues, view, acVar2);
                } else {
                    addViewValues(this.mEndValues, view, acVar2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (z || (aVar = this.mNameOverrides) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.mStartValues.f2515d.remove(this.mNameOverrides.b(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.mStartValues.f2515d.put(this.mNameOverrides.c(i4), view2);
            }
        }
    }

    private static void addViewValues(ad adVar, View view, ac acVar) {
        adVar.f2512a.put(view, acVar);
        int id = view.getId();
        if (id >= 0) {
            if (adVar.f2513b.indexOfKey(id) >= 0) {
                adVar.f2513b.put(id, null);
            } else {
                adVar.f2513b.put(id, view);
            }
        }
        String p = androidx.core.h.w.p(view);
        if (p != null) {
            if (adVar.f2515d.containsKey(p)) {
                adVar.f2515d.put(p, null);
            } else {
                adVar.f2515d.put(p, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (adVar.f2514c.c(itemIdAtPosition) >= 0) {
                    View a2 = adVar.f2514c.a(itemIdAtPosition);
                    if (a2 != null) {
                        androidx.core.h.w.a(a2, false);
                        adVar.f2514c.b(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                androidx.core.h.w.a(view, true);
                adVar.f2514c.b(itemIdAtPosition, view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f2512a.clear();
            this.mStartValues.f2513b.clear();
            this.mStartValues.f2514c.d();
            return;
        }
        this.mEndValues.f2512a.clear();
        this.mEndValues.f2513b.clear();
        this.mEndValues.f2514c.d();
    }

    private void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    ac acVar = new ac();
                    acVar.f2510b = view;
                    if (z) {
                        captureStartValues(acVar);
                    } else {
                        captureEndValues(acVar);
                    }
                    acVar.f2511c.add(this);
                    capturePropagationValues(acVar);
                    if (z) {
                        addViewValues(this.mStartValues, view, acVar);
                    } else {
                        addViewValues(this.mEndValues, view, acVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                captureHierarchy(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public ac getTransitionValues(View view, boolean z) {
        aa aaVar = this.mParent;
        if (aaVar != null) {
            return aaVar.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f2512a.get(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac getMatchedTransitionValues(View view, boolean z) {
        aa aaVar = this.mParent;
        if (aaVar != null) {
            return aaVar.getMatchedTransitionValues(view, z);
        }
        ArrayList<ac> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            ac acVar = arrayList.get(i2);
            if (acVar == null) {
                return null;
            }
            if (acVar.f2510b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return null;
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        androidx.b.a<Animator, a> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        av b2 = an.b(view);
        for (int i = size - 1; i >= 0; i--) {
            a c2 = runningAnimators.c(i);
            if (c2.f2665a != null && b2.equals(c2.f2668d)) {
                androidx.transition.a.a(runningAnimators.b(i));
            }
        }
        ArrayList<d> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((d) arrayList2.get(i2)).c(this);
            }
        }
        this.mPaused = true;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                androidx.b.a<Animator, a> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                av b2 = an.b(view);
                for (int i = size - 1; i >= 0; i--) {
                    a c2 = runningAnimators.c(i);
                    if (c2.f2665a != null && b2.equals(c2.f2668d)) {
                        androidx.transition.a.b(runningAnimators.b(i));
                    }
                }
                ArrayList<d> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((d) arrayList2.get(i2)).d(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void playTransition(ViewGroup viewGroup) {
        a aVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        androidx.b.a<Animator, a> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        av b2 = an.b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator b3 = runningAnimators.b(i);
            if (b3 != null && (aVar = runningAnimators.get(b3)) != null && aVar.f2665a != null && b2.equals(aVar.f2668d)) {
                ac acVar = aVar.f2667c;
                View view = aVar.f2665a;
                ac transitionValues = getTransitionValues(view, true);
                ac matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (!(transitionValues == null && matchedTransitionValues == null) && aVar.f2669e.isTransitionRequired(acVar, matchedTransitionValues)) {
                    if (b3.isRunning() || b3.isStarted()) {
                        b3.cancel();
                    } else {
                        runningAnimators.remove(b3);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public boolean isTransitionRequired(ac acVar, ac acVar2) {
        if (acVar == null || acVar2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(acVar, acVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : acVar.f2509a.keySet()) {
            if (isValueChanged(acVar, acVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    private static boolean isValueChanged(ac acVar, ac acVar2, String str) {
        Object obj = acVar.f2509a.get(str);
        Object obj2 = acVar2.f2509a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.w.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                w.this.end();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((d) arrayList2.get(i)).e(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i == 0) {
            ArrayList<d> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).b(this);
                }
            }
            for (int i3 = 0; i3 < this.mStartValues.f2514c.b(); i3++) {
                View c2 = this.mStartValues.f2514c.c(i3);
                if (c2 != null) {
                    androidx.core.h.w.a(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.mEndValues.f2514c.b(); i4++) {
                View c3 = this.mEndValues.f2514c.c(i4);
                if (c3 != null) {
                    androidx.core.h.w.a(c3, false);
                }
            }
            this.mEnded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        androidx.b.a<Animator, a> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null) {
            av b2 = an.b(viewGroup);
            for (int i = size - 1; i >= 0; i--) {
                a c2 = runningAnimators.c(i);
                if (c2.f2665a != null && b2 != null && b2.equals(c2.f2668d)) {
                    runningAnimators.b(i).end();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<d> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((d) arrayList2.get(i)).a(this);
        }
    }

    public w addListener(d dVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(dVar);
        return this;
    }

    public w removeListener(d dVar) {
        ArrayList<d> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public void setPathMotion(p pVar) {
        if (pVar == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pVar;
        }
    }

    public p getPathMotion() {
        return this.mPathMotion;
    }

    public void setEpicenterCallback(c cVar) {
        this.mEpicenterCallback = cVar;
    }

    public c getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public Rect getEpicenter() {
        c cVar = this.mEpicenterCallback;
        if (cVar == null) {
            return null;
        }
        return cVar.a(this);
    }

    public void setPropagation(z zVar) {
        this.mPropagation = zVar;
    }

    public z getPropagation() {
        return this.mPropagation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void capturePropagationValues(ac acVar) {
        String[] a2;
        if (this.mPropagation == null || acVar.f2509a.isEmpty() || (a2 = this.mPropagation.a()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= a2.length) {
                z = true;
                break;
            } else if (!acVar.f2509a.containsKey(a2[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.mPropagation.a(acVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public String toString() {
        return toString("");
    }

    /* renamed from: clone */
    public w m0clone() {
        try {
            w wVar = (w) super.clone();
            wVar.mAnimators = new ArrayList<>();
            wVar.mStartValues = new ad();
            wVar.mEndValues = new ad();
            wVar.mStartValuesList = null;
            wVar.mEndValuesList = null;
            return wVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            String str3 = str2 + "tgts(";
            if (this.mTargetIds.size() > 0) {
                for (int i = 0; i < this.mTargetIds.size(); i++) {
                    if (i > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.mTargetIds.get(i);
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                    if (i2 > 0) {
                        str3 = str3 + ", ";
                    }
                    str3 = str3 + this.mTargets.get(i2);
                }
            }
            return str3 + ")";
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        View f2665a;

        /* renamed from: b  reason: collision with root package name */
        String f2666b;

        /* renamed from: c  reason: collision with root package name */
        ac f2667c;

        /* renamed from: d  reason: collision with root package name */
        av f2668d;

        /* renamed from: e  reason: collision with root package name */
        w f2669e;

        a(View view, String str, w wVar, av avVar, ac acVar) {
            this.f2665a = view;
            this.f2666b = str;
            this.f2667c = acVar;
            this.f2668d = avVar;
            this.f2669e = wVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class b {
        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList != null) {
                arrayList.remove(t);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }
    }
}
