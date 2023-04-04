package androidx.customview.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.b.h;
import androidx.core.h.a.d;
import androidx.core.h.a.e;
import androidx.core.h.a.f;
import androidx.core.h.w;
import androidx.core.h.z;
import androidx.customview.b.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class a extends androidx.core.h.a {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<d> NODE_ADAPTER = new b.a<d>() { // from class: androidx.customview.b.a.1
        @Override // androidx.customview.b.b.a
        public void a(d dVar, Rect rect) {
            dVar.a(rect);
        }
    };
    private static final b.InterfaceC0043b<h<d>, d> SPARSE_VALUES_ADAPTER = new b.InterfaceC0043b<h<d>, d>() { // from class: androidx.customview.b.a.2
        @Override // androidx.customview.b.b.InterfaceC0043b
        public d a(h<d> hVar, int i) {
            return hVar.d(i);
        }

        @Override // androidx.customview.b.b.InterfaceC0043b
        public int a(h<d> hVar) {
            return hVar.b();
        }
    };
    private final View mHost;
    private final AccessibilityManager mManager;
    private C0042a mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    private static int keyToDirection(int i) {
        if (i != 19) {
            if (i != 21) {
                return i != 22 ? 130 : 66;
            }
            return 17;
        }
        return 33;
    }

    protected abstract int getVirtualViewAt(float f, float f2);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    protected abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    protected void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(d dVar) {
    }

    protected abstract void onPopulateNodeForVirtualView(int i, d dVar);

    protected void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (w.f(view) == 0) {
            w.b(view, 1);
        }
    }

    @Override // androidx.core.h.a
    public e getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new C0042a();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                return virtualViewAt != Integer.MIN_VALUE;
            } else if (action == 10 && this.mHoveredVirtualViewId != Integer.MIN_VALUE) {
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int keyToDirection = keyToDirection(keyCode);
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z = false;
                                while (i < repeatCount && moveFocus(keyToDirection, null)) {
                                    i++;
                                    z = true;
                                }
                                return z;
                            }
                            return false;
                        case 23:
                            break;
                        default:
                            return false;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    clickKeyboardFocusedVirtualView();
                    return true;
                }
                return false;
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(2, null);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return moveFocus(1, null);
                }
                return false;
            }
        }
        return false;
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).a(rect);
    }

    private boolean moveFocus(int i, Rect rect) {
        d dVar;
        h<d> allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        d a2 = i2 == Integer.MIN_VALUE ? null : allNodes.a(i2);
        if (i == 1 || i == 2) {
            dVar = (d) b.a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, a2, i, w.g(this.mHost) == 1, false);
        } else if (i == 17 || i == 33 || i == 66 || i == 130) {
            Rect rect2 = new Rect();
            int i3 = this.mKeyboardFocusedVirtualViewId;
            if (i3 != Integer.MIN_VALUE) {
                getBoundsInParent(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i, rect2);
            }
            dVar = (d) b.a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, a2, rect2, i);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return requestKeyboardFocusForVirtualView(dVar != null ? allNodes.c(allNodes.a((h<d>) dVar)) : Integer.MIN_VALUE);
    }

    private h<d> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        h<d> hVar = new h<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.b(i, createNodeForChild(i));
        }
        return hVar;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i = this.mKeyboardFocusedVirtualViewId;
        return i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, null);
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return z.a(parent, this.mHost, createEvent(i, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i, 2048);
        androidx.core.h.a.b.a(createEvent, i2);
        z.a(parent, this.mHost, createEvent);
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.mHoveredVirtualViewId = i;
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(i2, 256);
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i == -1) {
            return createEventForHost(i2);
        }
        return createEventForChild(i, i2);
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @Override // androidx.core.h.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        d obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.q());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.r());
        obtain.setScrollable(obtainAccessibilityNodeInfo.n());
        obtain.setPassword(obtainAccessibilityNodeInfo.m());
        obtain.setEnabled(obtainAccessibilityNodeInfo.l());
        obtain.setChecked(obtainAccessibilityNodeInfo.f());
        onPopulateEventForVirtualView(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.p());
        f.a(obtain, this.mHost, i);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    d obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    private d createNodeForHost() {
        d a2 = d.a(this.mHost);
        w.a(this.mHost, a2);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (a2.c() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a2.b(this.mHost, ((Integer) arrayList.get(i)).intValue());
        }
        return a2;
    }

    @Override // androidx.core.h.a
    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        onPopulateNodeForHost(dVar);
    }

    private d createNodeForChild(int i) {
        d b2 = d.b();
        b2.g(true);
        b2.c(true);
        b2.b(DEFAULT_CLASS_NAME);
        b2.b(INVALID_PARENT_BOUNDS);
        b2.d(INVALID_PARENT_BOUNDS);
        b2.b(this.mHost);
        onPopulateNodeForVirtualView(i, b2);
        if (b2.q() == null && b2.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        b2.a(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int d2 = b2.d();
        if ((d2 & 64) == 0) {
            if ((d2 & 128) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            b2.a((CharSequence) this.mHost.getContext().getPackageName());
            b2.a(this.mHost, i);
            if (this.mAccessibilityFocusedVirtualViewId == i) {
                b2.f(true);
                b2.a(128);
            } else {
                b2.f(false);
                b2.a(64);
            }
            boolean z = this.mKeyboardFocusedVirtualViewId == i;
            if (z) {
                b2.a(2);
            } else if (b2.g()) {
                b2.a(1);
            }
            b2.d(z);
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            b2.c(this.mTempScreenRect);
            if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                b2.a(this.mTempScreenRect);
                if (b2.f1661a != -1) {
                    d b3 = d.b();
                    for (int i2 = b2.f1661a; i2 != -1; i2 = b3.f1661a) {
                        b3.c(this.mHost, -1);
                        b3.b(INVALID_PARENT_BOUNDS);
                        onPopulateNodeForVirtualView(i2, b3);
                        b3.a(this.mTempParentRect);
                        this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                    }
                    b3.s();
                }
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            }
            if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                    b2.d(this.mTempScreenRect);
                    if (isVisibleToUser(this.mTempScreenRect)) {
                        b2.e(true);
                    }
                }
            }
            return b2;
        }
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }

    boolean performAction(int i, int i2, Bundle bundle) {
        if (i == -1) {
            return performActionForHost(i2, bundle);
        }
        return performActionForChild(i, i2, bundle);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return w.a(this.mHost, i, bundle);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 64) {
                    if (i2 == 128) {
                        return clearAccessibilityFocus(i);
                    }
                    return onPerformActionForVirtualView(i, i2, bundle);
                }
                return requestAccessibilityFocus(i);
            }
            return clearKeyboardFocusForVirtualView(i);
        }
        return requestKeyboardFocusForVirtualView(i);
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled() && (i2 = this.mAccessibilityFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearAccessibilityFocus(i2);
            }
            this.mAccessibilityFocusedVirtualViewId = i;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 32768);
            return true;
        }
        return false;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 65536);
            return true;
        }
        return false;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((this.mHost.isFocused() || this.mHost.requestFocus()) && (i2 = this.mKeyboardFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(i2);
            }
            this.mKeyboardFocusedVirtualViewId = i;
            onVirtualViewKeyboardFocusChanged(i, true);
            sendEventForVirtualView(i, 8);
            return true;
        }
        return false;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    /* compiled from: ExploreByTouchHelper.java */
    /* renamed from: androidx.customview.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0042a extends e {
        C0042a() {
        }

        @Override // androidx.core.h.a.e
        public d a(int i) {
            return d.a(a.this.obtainAccessibilityNodeInfo(i));
        }

        @Override // androidx.core.h.a.e
        public boolean a(int i, int i2, Bundle bundle) {
            return a.this.performAction(i, i2, bundle);
        }

        @Override // androidx.core.h.a.e
        public d b(int i) {
            int i2 = i == 2 ? a.this.mAccessibilityFocusedVirtualViewId : a.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }
    }
}
