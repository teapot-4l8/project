package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Recreator implements g {

    /* renamed from: a  reason: collision with root package name */
    private final c f2487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Recreator(c cVar) {
        this.f2487a = cVar;
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, h.a aVar) {
        if (aVar != h.a.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        lVar.getLifecycle().b(this);
        Bundle a2 = this.f2487a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (a2 == null) {
            return;
        }
        ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    private void a(String str) {
        Class cls;
        try {
            try {
                Constructor declaredConstructor = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.InterfaceC0058a.class).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((a.InterfaceC0058a) declaredConstructor.newInstance(new Object[0])).a(this.f2487a);
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to instantiate " + str, e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Class " + str + " wasn't found", e4);
        }
    }
}
