package com.speed.speed_library.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.speed.speed_library.R;

/* compiled from: CustomLoadingDialog.java */
/* loaded from: classes2.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private View f5893a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5894b;

    public c(a aVar) {
        super(aVar.f5895a);
        this.f5893a = aVar.f5897c;
        this.f5894b = aVar.f5898d;
    }

    private c(a aVar, int i) {
        super(aVar.f5895a, i);
        this.f5893a = aVar.f5897c;
        this.f5894b = aVar.f5898d;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f5893a);
        setCanceledOnTouchOutside(this.f5894b);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        if (this.f5893a == null) {
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* compiled from: CustomLoadingDialog.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        Context f5895a;

        /* renamed from: b  reason: collision with root package name */
        private int f5896b = -1;

        /* renamed from: c  reason: collision with root package name */
        private View f5897c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5898d;

        public a(Context context) {
            this.f5895a = context;
            this.f5897c = LayoutInflater.from(context).inflate(R.layout.widget_dialog_loading, (ViewGroup) null);
        }

        public a a(int i) {
            this.f5896b = i;
            return this;
        }

        public a a(String str) {
            TextView textView = (TextView) this.f5897c.findViewById(R.id.tv_loading_msg);
            if (textView != null) {
                textView.setText(str);
            }
            return this;
        }

        public c a() {
            if (this.f5896b != -1) {
                return new c(this, this.f5896b);
            }
            return new c(this);
        }
    }
}
