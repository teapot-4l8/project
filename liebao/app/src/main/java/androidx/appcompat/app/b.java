package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class b extends g implements DialogInterface {

    /* renamed from: a  reason: collision with root package name */
    final AlertController f576a;

    protected b(Context context, int i) {
        super(context, a(context, i));
        this.f576a = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.f576a.b();
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f576a.a(charSequence);
    }

    public void a(CharSequence charSequence) {
        this.f576a.b(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f576a.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f576a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f576a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* compiled from: AlertDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.a f577a;

        /* renamed from: b  reason: collision with root package name */
        private final int f578b;

        public a(Context context) {
            this(context, b.a(context, 0));
        }

        public a(Context context, int i) {
            this.f577a = new AlertController.a(new ContextThemeWrapper(context, b.a(context, i)));
            this.f578b = i;
        }

        public Context a() {
            return this.f577a.f556a;
        }

        public a a(CharSequence charSequence) {
            this.f577a.f = charSequence;
            return this;
        }

        public a a(View view) {
            this.f577a.g = view;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f577a.h = charSequence;
            return this;
        }

        public a a(Drawable drawable) {
            this.f577a.f559d = drawable;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f577a;
            aVar.i = aVar.f556a.getText(i);
            this.f577a.k = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f577a.i = charSequence;
            this.f577a.k = onClickListener;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f577a;
            aVar.l = aVar.f556a.getText(i);
            this.f577a.n = onClickListener;
            return this;
        }

        public a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f577a.l = charSequence;
            this.f577a.n = onClickListener;
            return this;
        }

        public a a(boolean z) {
            this.f577a.r = z;
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.f577a.s = onCancelListener;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f577a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f577a.w = listAdapter;
            this.f577a.x = onClickListener;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f577a.v = charSequenceArr;
            this.f577a.x = onClickListener;
            this.f577a.I = i;
            this.f577a.H = true;
            return this;
        }

        public a a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            this.f577a.w = listAdapter;
            this.f577a.x = onClickListener;
            this.f577a.I = i;
            this.f577a.H = true;
            return this;
        }

        public a b(View view) {
            this.f577a.z = view;
            this.f577a.y = 0;
            this.f577a.E = false;
            return this;
        }

        public b b() {
            b bVar = new b(this.f577a.f556a, this.f578b);
            this.f577a.a(bVar.f576a);
            bVar.setCancelable(this.f577a.r);
            if (this.f577a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f577a.s);
            bVar.setOnDismissListener(this.f577a.t);
            if (this.f577a.u != null) {
                bVar.setOnKeyListener(this.f577a.u);
            }
            return bVar;
        }

        public b c() {
            b b2 = b();
            b2.show();
            return b2;
        }
    }
}
