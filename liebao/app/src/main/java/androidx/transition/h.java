package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.w;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport.java */
/* loaded from: classes.dex */
public class h extends androidx.fragment.app.s {
    @Override // androidx.fragment.app.s
    public boolean a(Object obj) {
        return obj instanceof w;
    }

    @Override // androidx.fragment.app.s
    public Object b(Object obj) {
        if (obj != null) {
            return ((w) obj).m0clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.s
    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        aa aaVar = new aa();
        aaVar.a((w) obj);
        return aaVar;
    }

    @Override // androidx.fragment.app.s
    public void a(Object obj, View view, ArrayList<View> arrayList) {
        aa aaVar = (aa) obj;
        List<View> targets = aaVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        a(aaVar, arrayList);
    }

    @Override // androidx.fragment.app.s
    public void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((w) obj).setEpicenterCallback(new w.c() { // from class: androidx.transition.h.1
                @Override // androidx.transition.w.c
                public Rect a(w wVar) {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.s
    public void a(Object obj, ArrayList<View> arrayList) {
        w wVar = (w) obj;
        if (wVar == null) {
            return;
        }
        int i = 0;
        if (wVar instanceof aa) {
            aa aaVar = (aa) wVar;
            int a2 = aaVar.a();
            while (i < a2) {
                a(aaVar.b(i), arrayList);
                i++;
            }
        } else if (a(wVar) || !a((List) wVar.getTargets())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                wVar.addTarget(arrayList.get(i));
                i++;
            }
        }
    }

    private static boolean a(w wVar) {
        return (a((List) wVar.getTargetIds()) && a((List) wVar.getTargetNames()) && a((List) wVar.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.s
    public Object a(Object obj, Object obj2, Object obj3) {
        aa aaVar = new aa();
        if (obj != null) {
            aaVar.a((w) obj);
        }
        if (obj2 != null) {
            aaVar.a((w) obj2);
        }
        if (obj3 != null) {
            aaVar.a((w) obj3);
        }
        return aaVar;
    }

    @Override // androidx.fragment.app.s
    public void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((w) obj).addListener(new w.d() { // from class: androidx.transition.h.2
            @Override // androidx.transition.w.d
            public void a(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void c(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void d(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void e(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void b(w wVar) {
                wVar.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.s
    public Object b(Object obj, Object obj2, Object obj3) {
        w wVar = (w) obj;
        w wVar2 = (w) obj2;
        w wVar3 = (w) obj3;
        if (wVar != null && wVar2 != null) {
            wVar = new aa().a(wVar).a(wVar2).a(1);
        } else if (wVar == null) {
            wVar = wVar2 != null ? wVar2 : null;
        }
        if (wVar3 != null) {
            aa aaVar = new aa();
            if (wVar != null) {
                aaVar.a(wVar);
            }
            aaVar.a(wVar3);
            return aaVar;
        }
        return wVar;
    }

    @Override // androidx.fragment.app.s
    public void a(ViewGroup viewGroup, Object obj) {
        y.a(viewGroup, (w) obj);
    }

    @Override // androidx.fragment.app.s
    public void a(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((w) obj).addListener(new w.d() { // from class: androidx.transition.h.3
            @Override // androidx.transition.w.d
            public void a(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void b(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void c(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void d(w wVar) {
            }

            @Override // androidx.transition.w.d
            public void e(w wVar) {
                Object obj5 = obj2;
                if (obj5 != null) {
                    h.this.b(obj5, arrayList, (ArrayList<View>) null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    h.this.b(obj6, arrayList2, (ArrayList<View>) null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    h.this.b(obj7, arrayList3, (ArrayList<View>) null);
                }
            }
        });
    }

    @Override // androidx.fragment.app.s
    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        aa aaVar = (aa) obj;
        if (aaVar != null) {
            aaVar.getTargets().clear();
            aaVar.getTargets().addAll(arrayList2);
            b((Object) aaVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.s
    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        w wVar = (w) obj;
        int i = 0;
        if (wVar instanceof aa) {
            aa aaVar = (aa) wVar;
            int a2 = aaVar.a();
            while (i < a2) {
                b((Object) aaVar.b(i), arrayList, arrayList2);
                i++;
            }
        } else if (!a(wVar)) {
            List<View> targets = wVar.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    wVar.addTarget(arrayList2.get(i));
                    i++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    wVar.removeTarget(arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.s
    public void b(Object obj, View view) {
        if (obj != null) {
            ((w) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.s
    public void c(Object obj, View view) {
        if (obj != null) {
            ((w) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.s
    public void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((w) obj).setEpicenterCallback(new w.c() { // from class: androidx.transition.h.4
                @Override // androidx.transition.w.c
                public Rect a(w wVar) {
                    Rect rect2 = rect;
                    if (rect2 == null || rect2.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
