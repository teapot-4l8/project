package com.speed.speed_library.b;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.gson.JsonParseException;
import com.speed.speed_library.event.LogoutEvent;
import com.speed.speed_library.model.CommonModel;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;
import org.json.JSONException;

/* compiled from: NetReponseDataCheck.kt */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f5614a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final String f5615b = f5615b;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5615b = f5615b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5616c = f5616c;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5616c = f5616c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f5617d = f5617d;

    /* renamed from: d  reason: collision with root package name */
    private static final String f5617d = f5617d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f5618e = f5618e;

    /* renamed from: e  reason: collision with root package name */
    private static final String f5618e = f5618e;
    private static final String f = f;
    private static final String f = f;
    private static final String g = g;
    private static final String g = g;

    private h() {
    }

    public final boolean a(CommonModel commonModel, boolean z) {
        kotlin.d.b.i.b(commonModel, JThirdPlatFormInterface.KEY_DATA);
        if (d.f5595a.k() == commonModel.getCode()) {
            return true;
        }
        if (d.f5595a.l() != commonModel.getCode()) {
            if (z) {
                String msg = commonModel.getMsg();
                f.a(msg != null ? msg : "出错了，请稍后再试", 0, 2, null);
            }
            return false;
        }
        g.f5610b.k();
        org.greenrobot.eventbus.c.a().d(new LogoutEvent());
        String msg2 = commonModel.getMsg();
        f.a(msg2 != null ? msg2 : "出错了，请稍后再试", 0, 2, null);
        return false;
    }

    public final void a(Throwable th) {
        kotlin.d.b.i.b(th, "e");
        if (th instanceof e.i) {
            f.a(f5615b, 0, 2, null);
        } else if ((th instanceof ConnectException) || (th instanceof UnknownHostException)) {
            f.a(f5616c, 0, 2, null);
        } else if (th instanceof InterruptedIOException) {
            f.a(f5617d, 0, 2, null);
        } else if ((th instanceof JsonParseException) || (th instanceof JSONException) || (th instanceof ParseException)) {
            f.a(f5618e, 0, 2, null);
        } else {
            f.a(f, 0, 2, null);
        }
    }
}
