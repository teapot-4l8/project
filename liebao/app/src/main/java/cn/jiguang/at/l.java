package cn.jiguang.at;

import android.content.Context;
import android.os.Message;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends cn.jiguang.ax.a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f3954a;

    /* renamed from: d  reason: collision with root package name */
    private int f3955d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f3956e;
    private int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, int i, Object obj) {
        this.f3954a = context;
        this.f3955d = i;
        this.f3956e = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, Object obj) {
        this.f3954a = context;
        this.f3956e = obj;
    }

    @Override // cn.jiguang.ax.a
    public final void a(Message message) {
        if (message.what >= 60000) {
            if (this.f3956e instanceof cn.jiguang.ar.h) {
                cn.jiguang.an.d.b("TcpReporter", "time to idle=" + this.f3956e);
                k.a(k.a(), this.f3954a, (cn.jiguang.ar.h) this.f3956e, 0);
            }
        } else if (message.what >= 50000) {
            Object obj = this.f3956e;
            if (obj instanceof m) {
                m mVar = (m) obj;
                cn.jiguang.an.d.b("TcpReporter", "onTimeout=" + mVar);
                k.a(k.a(), mVar.g, mVar.f);
                k.a().a(this.f3954a, mVar);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i = this.f3955d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && (this.f3956e instanceof m)) {
                        m mVar = (m) this.f3956e;
                        cn.jiguang.an.d.b("TcpReporter", "onResult, data=" + mVar + " code=" + this.f);
                        JCoreManager.onEvent(this.f3954a, JConstants.SDK_TYPE, 61, "", null, Integer.valueOf(this.f), mVar.f3958b, mVar.f3959c, Integer.valueOf(mVar.f3957a), mVar.f3960d, mVar.f3961e, mVar.j);
                    }
                } else if (this.f3956e instanceof cn.jiguang.ar.h) {
                    k.b(k.a(), this.f3954a, (cn.jiguang.ar.h) this.f3956e);
                }
            } else if (this.f3956e instanceof cn.jiguang.ar.h) {
                k.a(k.a(), this.f3954a, (cn.jiguang.ar.h) this.f3956e);
            }
        } catch (Throwable unused) {
        }
    }
}
