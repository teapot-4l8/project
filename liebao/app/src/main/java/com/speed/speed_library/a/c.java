package com.speed.speed_library.a;

import android.content.Context;
import android.text.TextUtils;
import b.b.h;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.speed.speed_library.R;
import com.speed.speed_library.model.CommonModel;
import com.speed.speed_library.widget.a.c;
import kotlin.d.b.i;

/* compiled from: BaseObserver.kt */
/* loaded from: classes2.dex */
public abstract class c<T extends CommonModel> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    private String f5547a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5548b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5549c;

    /* renamed from: d  reason: collision with root package name */
    private com.speed.speed_library.widget.a.c f5550d;

    public abstract void b(T t);

    public abstract void b(Throwable th);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.h
    public /* synthetic */ void a_(Object obj) {
        a((c<T>) ((CommonModel) obj));
    }

    public final boolean a() {
        return this.f5550d != null;
    }

    public c(Context context) {
        i.b(context, com.umeng.analytics.pro.d.R);
        this.f5547a = "正在加载...";
        this.f5548b = context;
        this.f5549c = true;
    }

    public c() {
        this.f5547a = "正在加载...";
    }

    @Override // b.b.h
    public void a(b.b.b.b bVar) {
        i.b(bVar, "d");
        c();
    }

    public void a(T t) {
        i.b(t, "response");
        d();
        b((c<T>) t);
    }

    @Override // b.b.h
    public void a(Throwable th) {
        i.b(th, "e");
        d();
        b(th);
    }

    @Override // b.b.h
    public void b() {
        d();
    }

    public final void c() {
        if (this.f5549c) {
            if (TextUtils.isEmpty(this.f5547a)) {
                Context context = this.f5548b;
                if (context == null) {
                    i.b("mContext");
                }
                a(context);
                return;
            }
            Context context2 = this.f5548b;
            if (context2 == null) {
                i.b("mContext");
            }
            a(context2, this.f5547a);
        }
    }

    public final void d() {
        e();
    }

    public final void a(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, JThirdPlatFormInterface.KEY_MSG);
        if (!a()) {
            com.speed.speed_library.widget.a.c a2 = new c.a(context).a(R.style.LoadingDialogStyle).a(str).a();
            i.a((Object) a2, "CustomLoadingDialog.Buil…\n                .build()");
            this.f5550d = a2;
        }
        com.speed.speed_library.widget.a.c cVar = this.f5550d;
        if (cVar == null) {
            i.b("mCustomLoadingDialog");
        }
        if (cVar.isShowing()) {
            return;
        }
        com.speed.speed_library.widget.a.c cVar2 = this.f5550d;
        if (cVar2 == null) {
            i.b("mCustomLoadingDialog");
        }
        cVar2.show();
    }

    public final void a(Context context) {
        i.b(context, com.umeng.analytics.pro.d.R);
        if (!a()) {
            com.speed.speed_library.widget.a.c a2 = new c.a(context).a(R.style.LoadingDialogStyle).a();
            i.a((Object) a2, "CustomLoadingDialog.Buil…\n                .build()");
            this.f5550d = a2;
        }
        com.speed.speed_library.widget.a.c cVar = this.f5550d;
        if (cVar == null) {
            i.b("mCustomLoadingDialog");
        }
        if (cVar.isShowing()) {
            return;
        }
        com.speed.speed_library.widget.a.c cVar2 = this.f5550d;
        if (cVar2 == null) {
            i.b("mCustomLoadingDialog");
        }
        cVar2.show();
    }

    public final void e() {
        if (a()) {
            com.speed.speed_library.widget.a.c cVar = this.f5550d;
            if (cVar == null) {
                i.b("mCustomLoadingDialog");
            }
            if (cVar.isShowing()) {
                com.speed.speed_library.widget.a.c cVar2 = this.f5550d;
                if (cVar2 == null) {
                    i.b("mCustomLoadingDialog");
                }
                cVar2.dismiss();
            }
        }
    }
}
