package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public class al extends aj implements ak {

    /* renamed from: a  reason: collision with root package name */
    private static Method f967a;

    /* renamed from: b  reason: collision with root package name */
    private ak f968b;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f967a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public al(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.appcompat.widget.aj
    af a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void a(ak akVar) {
        this.f968b = akVar;
    }

    public void c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f967a;
            if (method != null) {
                try {
                    method.invoke(this.g, Boolean.valueOf(z));
                    return;
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.g.setTouchModal(z);
    }

    @Override // androidx.appcompat.widget.ak
    public void b(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        ak akVar = this.f968b;
        if (akVar != null) {
            akVar.b(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.ak
    public void a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        ak akVar = this.f968b;
        if (akVar != null) {
            akVar.a(gVar, menuItem);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    /* loaded from: classes.dex */
    public static class a extends af {

        /* renamed from: b  reason: collision with root package name */
        final int f969b;

        /* renamed from: c  reason: collision with root package name */
        final int f970c;

        /* renamed from: d  reason: collision with root package name */
        private ak f971d;

        /* renamed from: e  reason: collision with root package name */
        private MenuItem f972e;

        @Override // androidx.appcompat.widget.af
        public /* bridge */ /* synthetic */ int a(int i, int i2, int i3, int i4, int i5) {
            return super.a(i, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.af
        public /* bridge */ /* synthetic */ boolean a(MotionEvent motionEvent, int i) {
            return super.a(motionEvent, i);
        }

        @Override // androidx.appcompat.widget.af, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.af, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.af, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.af, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.af, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.af, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f969b = 21;
                this.f970c = 22;
                return;
            }
            this.f969b = 22;
            this.f970c = 21;
        }

        public void setHoverListener(ak akVar) {
            this.f971d = akVar;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f969b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.f970c) {
                setSelection(-1);
                ((androidx.appcompat.view.menu.f) getAdapter()).a().close(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        @Override // androidx.appcompat.widget.af, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            androidx.appcompat.view.menu.f fVar;
            int pointToPosition;
            int i2;
            if (this.f971d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    fVar = (androidx.appcompat.view.menu.f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    fVar = (androidx.appcompat.view.menu.f) adapter;
                }
                androidx.appcompat.view.menu.i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < fVar.getCount()) {
                    iVar = fVar.getItem(i2);
                }
                MenuItem menuItem = this.f972e;
                if (menuItem != iVar) {
                    androidx.appcompat.view.menu.g a2 = fVar.a();
                    if (menuItem != null) {
                        this.f971d.a(a2, menuItem);
                    }
                    this.f972e = iVar;
                    if (iVar != null) {
                        this.f971d.b(a2, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
