package androidx.core.h.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1672a;

    public d a(int i) {
        return null;
    }

    public List<d> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public d b(int i) {
        return null;
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* loaded from: classes.dex */
    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final e f1673a;

        a(e eVar) {
            this.f1673a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            d a2 = this.f1673a.a(i);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<d> a2 = this.f1673a.a(str, i);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(a2.get(i2).a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f1673a.a(i, i2, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* loaded from: classes.dex */
    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            d b2 = this.f1673a.b(i);
            if (b2 == null) {
                return null;
            }
            return b2.a();
        }
    }

    public e() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1672a = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f1672a = new a(this);
        } else {
            this.f1672a = null;
        }
    }

    public e(Object obj) {
        this.f1672a = obj;
    }

    public Object a() {
        return this.f1672a;
    }
}
