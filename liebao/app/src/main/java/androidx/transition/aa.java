package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.w;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class aa extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2495a;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<w> f2497c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f2498d = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f2496b = false;

    /* renamed from: e  reason: collision with root package name */
    private int f2499e = 0;

    public aa a(int i) {
        if (i == 0) {
            this.f2498d = true;
        } else if (i == 1) {
            this.f2498d = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public aa a(w wVar) {
        this.f2497c.add(wVar);
        wVar.mParent = this;
        if (this.mDuration >= 0) {
            wVar.setDuration(this.mDuration);
        }
        if ((this.f2499e & 1) != 0) {
            wVar.setInterpolator(getInterpolator());
        }
        if ((this.f2499e & 2) != 0) {
            wVar.setPropagation(getPropagation());
        }
        if ((this.f2499e & 4) != 0) {
            wVar.setPathMotion(getPathMotion());
        }
        if ((this.f2499e & 8) != 0) {
            wVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    public int a() {
        return this.f2497c.size();
    }

    public w b(int i) {
        if (i < 0 || i >= this.f2497c.size()) {
            return null;
        }
        return this.f2497c.get(i);
    }

    @Override // androidx.transition.w
    /* renamed from: a */
    public aa setDuration(long j) {
        super.setDuration(j);
        if (this.mDuration >= 0) {
            int size = this.f2497c.size();
            for (int i = 0; i < size; i++) {
                this.f2497c.get(i).setDuration(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.w
    /* renamed from: b */
    public aa setStartDelay(long j) {
        return (aa) super.setStartDelay(j);
    }

    @Override // androidx.transition.w
    /* renamed from: a */
    public aa setInterpolator(TimeInterpolator timeInterpolator) {
        this.f2499e |= 1;
        ArrayList<w> arrayList = this.f2497c;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2497c.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (aa) super.setInterpolator(timeInterpolator);
    }

    @Override // androidx.transition.w
    /* renamed from: a */
    public aa addTarget(View view) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).addTarget(view);
        }
        return (aa) super.addTarget(view);
    }

    @Override // androidx.transition.w
    /* renamed from: c */
    public aa addTarget(int i) {
        for (int i2 = 0; i2 < this.f2497c.size(); i2++) {
            this.f2497c.get(i2).addTarget(i);
        }
        return (aa) super.addTarget(i);
    }

    @Override // androidx.transition.w
    /* renamed from: a */
    public aa addTarget(String str) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).addTarget(str);
        }
        return (aa) super.addTarget(str);
    }

    @Override // androidx.transition.w
    /* renamed from: a */
    public aa addTarget(Class cls) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).addTarget(cls);
        }
        return (aa) super.addTarget(cls);
    }

    @Override // androidx.transition.w
    /* renamed from: a */
    public aa addListener(w.d dVar) {
        return (aa) super.addListener(dVar);
    }

    @Override // androidx.transition.w
    /* renamed from: d */
    public aa removeTarget(int i) {
        for (int i2 = 0; i2 < this.f2497c.size(); i2++) {
            this.f2497c.get(i2).removeTarget(i);
        }
        return (aa) super.removeTarget(i);
    }

    @Override // androidx.transition.w
    /* renamed from: b */
    public aa removeTarget(View view) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).removeTarget(view);
        }
        return (aa) super.removeTarget(view);
    }

    @Override // androidx.transition.w
    /* renamed from: b */
    public aa removeTarget(Class cls) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).removeTarget(cls);
        }
        return (aa) super.removeTarget(cls);
    }

    @Override // androidx.transition.w
    /* renamed from: b */
    public aa removeTarget(String str) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).removeTarget(str);
        }
        return (aa) super.removeTarget(str);
    }

    @Override // androidx.transition.w
    public w excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.w
    public w excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.w
    public w excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.f2497c.size(); i2++) {
            this.f2497c.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @Override // androidx.transition.w
    public w excludeTarget(Class cls, boolean z) {
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.w
    /* renamed from: b */
    public aa removeListener(w.d dVar) {
        return (aa) super.removeListener(dVar);
    }

    @Override // androidx.transition.w
    public void setPathMotion(p pVar) {
        super.setPathMotion(pVar);
        this.f2499e |= 4;
        for (int i = 0; i < this.f2497c.size(); i++) {
            this.f2497c.get(i).setPathMotion(pVar);
        }
    }

    private void b() {
        a aVar = new a(this);
        Iterator<w> it = this.f2497c.iterator();
        while (it.hasNext()) {
            it.next().addListener(aVar);
        }
        this.f2495a = this.f2497c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TransitionSet.java */
    /* loaded from: classes.dex */
    public static class a extends x {

        /* renamed from: a  reason: collision with root package name */
        aa f2502a;

        a(aa aaVar) {
            this.f2502a = aaVar;
        }

        @Override // androidx.transition.x, androidx.transition.w.d
        public void e(w wVar) {
            if (this.f2502a.f2496b) {
                return;
            }
            this.f2502a.start();
            this.f2502a.f2496b = true;
        }

        @Override // androidx.transition.x, androidx.transition.w.d
        public void b(w wVar) {
            aa aaVar = this.f2502a;
            aaVar.f2495a--;
            if (this.f2502a.f2495a == 0) {
                this.f2502a.f2496b = false;
                this.f2502a.end();
            }
            wVar.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.w
    public void createAnimators(ViewGroup viewGroup, ad adVar, ad adVar2, ArrayList<ac> arrayList, ArrayList<ac> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            w wVar = this.f2497c.get(i);
            if (startDelay > 0 && (this.f2498d || i == 0)) {
                long startDelay2 = wVar.getStartDelay();
                if (startDelay2 > 0) {
                    wVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    wVar.setStartDelay(startDelay);
                }
            }
            wVar.createAnimators(viewGroup, adVar, adVar2, arrayList, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.w
    public void runAnimators() {
        if (this.f2497c.isEmpty()) {
            start();
            end();
            return;
        }
        b();
        if (!this.f2498d) {
            for (int i = 1; i < this.f2497c.size(); i++) {
                final w wVar = this.f2497c.get(i);
                this.f2497c.get(i - 1).addListener(new x() { // from class: androidx.transition.aa.1
                    @Override // androidx.transition.x, androidx.transition.w.d
                    public void b(w wVar2) {
                        wVar.runAnimators();
                        wVar2.removeListener(this);
                    }
                });
            }
            w wVar2 = this.f2497c.get(0);
            if (wVar2 != null) {
                wVar2.runAnimators();
                return;
            }
            return;
        }
        Iterator<w> it = this.f2497c.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    @Override // androidx.transition.w
    public void captureStartValues(ac acVar) {
        if (isValidTarget(acVar.f2510b)) {
            Iterator<w> it = this.f2497c.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.isValidTarget(acVar.f2510b)) {
                    next.captureStartValues(acVar);
                    acVar.f2511c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.w
    public void captureEndValues(ac acVar) {
        if (isValidTarget(acVar.f2510b)) {
            Iterator<w> it = this.f2497c.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.isValidTarget(acVar.f2510b)) {
                    next.captureEndValues(acVar);
                    acVar.f2511c.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.w
    public void capturePropagationValues(ac acVar) {
        super.capturePropagationValues(acVar);
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).capturePropagationValues(acVar);
        }
    }

    @Override // androidx.transition.w
    public void pause(View view) {
        super.pause(view);
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).pause(view);
        }
    }

    @Override // androidx.transition.w
    public void resume(View view) {
        super.resume(view);
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).resume(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.transition.w
    public void cancel() {
        super.cancel();
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.w
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).forceToEnd(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.w
    /* renamed from: a */
    public aa setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.w
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).setCanRemoveViews(z);
        }
    }

    @Override // androidx.transition.w
    public void setPropagation(z zVar) {
        super.setPropagation(zVar);
        this.f2499e |= 2;
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).setPropagation(zVar);
        }
    }

    @Override // androidx.transition.w
    public void setEpicenterCallback(w.c cVar) {
        super.setEpicenterCallback(cVar);
        this.f2499e |= 8;
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            this.f2497c.get(i).setEpicenterCallback(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.w
    public String toString(String str) {
        String wVar = super.toString(str);
        for (int i = 0; i < this.f2497c.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(wVar);
            sb.append("\n");
            sb.append(this.f2497c.get(i).toString(str + "  "));
            wVar = sb.toString();
        }
        return wVar;
    }

    @Override // androidx.transition.w
    public w clone() {
        aa aaVar = (aa) super.m0clone();
        aaVar.f2497c = new ArrayList<>();
        int size = this.f2497c.size();
        for (int i = 0; i < size; i++) {
            aaVar.a(this.f2497c.get(i).m0clone());
        }
        return aaVar;
    }
}
