package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.m;

/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, m.a {

    /* renamed from: a  reason: collision with root package name */
    e f789a;

    /* renamed from: b  reason: collision with root package name */
    private g f790b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.appcompat.app.b f791c;

    /* renamed from: d  reason: collision with root package name */
    private m.a f792d;

    public h(g gVar) {
        this.f790b = gVar;
    }

    public void a(IBinder iBinder) {
        g gVar = this.f790b;
        b.a aVar = new b.a(gVar.getContext());
        e eVar = new e(aVar.a(), R.layout.abc_list_menu_item_layout);
        this.f789a = eVar;
        eVar.setCallback(this);
        this.f790b.addMenuPresenter(this.f789a);
        aVar.a(this.f789a.a(), this);
        View headerView = gVar.getHeaderView();
        if (headerView != null) {
            aVar.a(headerView);
        } else {
            aVar.a(gVar.getHeaderIcon()).a(gVar.getHeaderTitle());
        }
        aVar.a(this);
        androidx.appcompat.app.b b2 = aVar.b();
        this.f791c = b2;
        b2.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f791c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f791c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f791c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f791c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f790b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f790b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        androidx.appcompat.app.b bVar = this.f791c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f789a.onCloseMenu(this.f790b, true);
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void a(g gVar, boolean z) {
        if (z || gVar == this.f790b) {
            a();
        }
        m.a aVar = this.f792d;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean a(g gVar) {
        m.a aVar = this.f792d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f790b.performItemAction((i) this.f789a.a().getItem(i), 0);
    }
}
