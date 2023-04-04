package cn.jiguang.p;

import android.content.Context;
import android.os.Message;
import cn.jiguang.o.f;
import cn.jiguang.v.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends cn.jiguang.ax.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f4193a;

    public e(Context context) {
        this.f4193a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:6:0x000f, B:8:0x0017, B:10:0x001d, B:12:0x0021, B:14:0x0032, B:15:0x003d, B:20:0x0067, B:22:0x006b, B:24:0x007c, B:25:0x008b, B:16:0x0041, B:17:0x0057, B:19:0x005b), top: B:32:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // cn.jiguang.ax.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Message message) {
        c g;
        Context context;
        switch (message.what) {
            case 2003:
                b.e(this.f4193a);
                return;
            case 2004:
                try {
                    g = b.g(this.f4193a);
                    if (g == null) {
                        cn.jiguang.ad.a.a("CopyManager", "collect disabled");
                        return;
                    } else if (g.f4186a > 0) {
                        long i = f.i(this.f4193a);
                        if (g.a(i, g.f4186a * 1000)) {
                            f.a(this.f4193a, System.currentTimeMillis());
                            context = this.f4193a;
                            b.b(context);
                            if (g.f4187b > 0) {
                                long j = f.j(this.f4193a);
                                if (g.a(j, g.f4187b * 1000)) {
                                    f.b(this.f4193a, System.currentTimeMillis());
                                    b.d(this.f4193a);
                                    return;
                                }
                                cn.jiguang.ad.a.a("CopyManager", "won't report, last at " + g.a(j));
                                return;
                            }
                            return;
                        }
                        cn.jiguang.ad.a.a("CopyManager", "won't collect, last at " + g.a(i));
                        if (g.f4187b > 0) {
                        }
                    } else {
                        if (g.f4186a == 0) {
                            f.a(this.f4193a, System.currentTimeMillis());
                            context = this.f4193a;
                            b.b(context);
                        }
                        if (g.f4187b > 0) {
                        }
                    }
                } catch (Throwable th) {
                    cn.jiguang.ad.a.d("CopyManager", "onHeartbeat e:" + th);
                    return;
                }
            case 2005:
                b.b(null);
                return;
            default:
                return;
        }
    }
}
