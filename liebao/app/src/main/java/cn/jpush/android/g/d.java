package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: b */
    private cn.a.a.d f4341b = null;

    @Override // cn.jpush.android.g.a
    public final void a(String str, String str2) {
        String str3;
        if (this.f4341b != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("JPUSH_CONTENT", str2);
                this.f4341b.a(new cn.a.a.a(str, bundle), new b());
                return;
            } catch (Throwable th) {
                str3 = "send data fail:" + th;
            }
        } else {
            str3 = "send data fail, please init first.";
        }
        cn.jpush.android.i.b.g("ServiceConnection", str3);
    }

    @Override // cn.jpush.android.g.a
    public final boolean a() {
        if (f4340a.get()) {
            cn.jpush.android.i.b.b("ServiceConnection", "already connecting.");
            return false;
        }
        f4340a.set(true);
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(cn.jpush.android.f.c.f4331e, "cn.jpush.android.service.PushManagerService"));
            e eVar = new e(this, (byte) 0);
            boolean bindService = cn.jpush.android.f.c.f4327a.bindService(intent, eVar, 1);
            cn.jpush.android.i.b.b("ServiceConnection", "connect--" + bindService);
            if (bindService) {
                this.f4341b = cn.a.a.e.a(eVar.f4342a.take());
            } else {
                f4340a.set(false);
            }
            return bindService;
        } catch (Throwable th) {
            cn.jpush.android.i.b.g("ServiceConnection", "init fail:" + th);
            f4340a.set(false);
            return false;
        }
    }

    @Override // cn.jpush.android.g.a
    public final boolean b() {
        cn.a.a.d dVar = this.f4341b;
        if (dVar == null) {
            return false;
        }
        return dVar.asBinder().isBinderAlive();
    }
}
