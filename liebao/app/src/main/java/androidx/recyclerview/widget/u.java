package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class u extends androidx.core.h.a {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f2364a;

    /* renamed from: b  reason: collision with root package name */
    private final a f2365b;

    public u(RecyclerView recyclerView) {
        this.f2364a = recyclerView;
        androidx.core.h.a b2 = b();
        if (b2 != null && (b2 instanceof a)) {
            this.f2365b = (a) b2;
        } else {
            this.f2365b = new a(this);
        }
    }

    boolean a() {
        return this.f2364a.hasPendingAdapterUpdates();
    }

    @Override // androidx.core.h.a
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (a() || this.f2364a.getLayoutManager() == null) {
            return false;
        }
        return this.f2364a.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    @Override // androidx.core.h.a
    public void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        if (a() || this.f2364a.getLayoutManager() == null) {
            return;
        }
        this.f2364a.getLayoutManager().onInitializeAccessibilityNodeInfo(dVar);
    }

    @Override // androidx.core.h.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || a()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public androidx.core.h.a b() {
        return this.f2365b;
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public static class a extends androidx.core.h.a {

        /* renamed from: a  reason: collision with root package name */
        final u f2366a;

        /* renamed from: b  reason: collision with root package name */
        private Map<View, androidx.core.h.a> f2367b = new WeakHashMap();

        public a(u uVar) {
            this.f2366a = uVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view) {
            androidx.core.h.a b2 = androidx.core.h.w.b(view);
            if (b2 == null || b2 == this) {
                return;
            }
            this.f2367b.put(view, b2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public androidx.core.h.a b(View view) {
            return this.f2367b.remove(view);
        }

        @Override // androidx.core.h.a
        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.h.a.d dVar) {
            if (!this.f2366a.a() && this.f2366a.f2364a.getLayoutManager() != null) {
                this.f2366a.f2364a.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, dVar);
                androidx.core.h.a aVar = this.f2367b.get(view);
                if (aVar != null) {
                    aVar.onInitializeAccessibilityNodeInfo(view, dVar);
                    return;
                } else {
                    super.onInitializeAccessibilityNodeInfo(view, dVar);
                    return;
                }
            }
            super.onInitializeAccessibilityNodeInfo(view, dVar);
        }

        @Override // androidx.core.h.a
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (!this.f2366a.a() && this.f2366a.f2364a.getLayoutManager() != null) {
                androidx.core.h.a aVar = this.f2367b.get(view);
                if (aVar != null) {
                    if (aVar.performAccessibilityAction(view, i, bundle)) {
                        return true;
                    }
                } else if (super.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
                return this.f2366a.f2364a.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
            }
            return super.performAccessibilityAction(view, i, bundle);
        }

        @Override // androidx.core.h.a
        public void sendAccessibilityEvent(View view, int i) {
            androidx.core.h.a aVar = this.f2367b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        @Override // androidx.core.h.a
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f2367b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.h.a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f2367b.get(view);
            if (aVar != null) {
                return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.h.a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f2367b.get(view);
            if (aVar != null) {
                aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.h.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f2367b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.h.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a aVar = this.f2367b.get(viewGroup);
            if (aVar != null) {
                return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.h.a
        public androidx.core.h.a.e getAccessibilityNodeProvider(View view) {
            androidx.core.h.a aVar = this.f2367b.get(view);
            if (aVar != null) {
                return aVar.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
    }
}
