package cn.jiguang.ar;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3823a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3824b;

    /* renamed from: c  reason: collision with root package name */
    private cn.jiguang.aw.a f3825c = new cn.jiguang.aw.b(8128, 20);

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f3826d;

    static {
        cn.jiguang.ap.b.a("NetworkingClient");
    }

    public i(Context context) {
        this.f3824b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i) {
        boolean z;
        while (!this.f3823a) {
            if (i <= 0) {
                cn.jiguang.an.d.c("NetworkingClient", "login error,retry login too many times");
                e();
                d();
                return false;
            }
            cn.jiguang.an.d.b("NetworkingClient", "loginTimes:" + i);
            if (!cn.jiguang.d.b.a(this.f3824b) || TextUtils.isEmpty(cn.jiguang.d.a.f(this.f3824b))) {
                int b2 = c.b(this.f3824b, this.f3825c);
                if (b2 != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("resCode", b2);
                    cn.jiguang.at.h.a().a(this.f3824b, "tcp_a13", bundle);
                    e();
                    d();
                    z = false;
                    if (z) {
                        return false;
                    }
                    int a2 = c.a(this.f3824b, this.f3825c);
                    if (a2 < 0) {
                        d();
                        return false;
                    } else if (a2 <= 0) {
                        cn.jiguang.at.h.a().a(this.f3824b, "tcp_a10", null);
                        return true;
                    } else {
                        e();
                        if (a2 != 108) {
                            cn.jiguang.an.d.a("NetworkingClient", "Action - onLoginFailed - respCode:" + a2);
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("resCode", a2);
                            cn.jiguang.at.h.a().a(this.f3824b, "tcp_a12", bundle2);
                            return false;
                        }
                        cn.jiguang.ap.b.a(this.f3824b);
                        i--;
                    }
                } else {
                    cn.jiguang.at.h.a().a(this.f3824b, "tcp_a11", null);
                }
            }
            z = true;
            if (z) {
            }
        }
        return false;
    }

    private boolean a(Context context) {
        String str;
        cn.jiguang.an.d.b("NetworkingClient", "google:false");
        cn.jiguang.ay.a.a(context);
        try {
            this.f3825c = new k(l.a(context)).a(this);
        } catch (Exception e2) {
            d();
            str = "sis and connect failed:" + e2;
        }
        if (a(2)) {
            return true;
        }
        str = "login failed";
        cn.jiguang.an.d.f("NetworkingClient", str);
        return false;
    }

    private void d() {
        cn.jiguang.an.d.c("NetworkingClient", "Action - closeConnection");
        cn.jiguang.f.k.a(this.f3825c);
        cn.jiguang.at.h.a().a(this.f3824b, "tcp_a19", null);
    }

    private void e() {
        cn.jiguang.g.b.a(this.f3824b, cn.jiguang.g.a.c(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(false).a((cn.jiguang.g.a<String>) null));
    }

    public final synchronized void a() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f3826d = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(this);
    }

    public final synchronized void b() {
        cn.jiguang.an.d.c("NetworkingClient", "Action - stop");
        cn.jiguang.f.k.a(this.f3825c);
        this.f3823a = true;
        ExecutorService executorService = this.f3826d;
        if (executorService != null) {
            try {
                executorService.shutdown();
                if (!executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                    if (!executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                        cn.jiguang.an.d.a("NetworkingClient", "executor did not terminate");
                    }
                }
            } catch (InterruptedException unused) {
                executorService.shutdownNow();
                cn.jiguang.an.d.a("NetworkingClient", "current thread is interrupted by self");
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                cn.jiguang.an.d.f("NetworkingClient", "shutDown e:" + th);
            }
        }
    }

    public final cn.jiguang.aw.a c() {
        return this.f3825c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cn.jiguang.an.d.e("NetworkingClient", "Begin to run in ConnectingThread - id:" + Thread.currentThread().getId());
        try {
        } catch (Throwable th) {
            cn.jiguang.an.d.d("NetworkingClient", "run exception", th);
        }
        if (!a(this.f3824b)) {
            cn.jiguang.an.d.c("NetworkingClient", "prepare Push Channel failed , returned");
            return;
        }
        while (!this.f3823a) {
            cn.jiguang.an.d.c("NetworkingClient", "Network listening...");
            try {
                ByteBuffer a2 = this.f3825c.a(0);
                cn.jiguang.ap.b.a("NetworkingClient", new v(this.f3824b, a2.array()));
                cn.jiguang.an.d.c("NetworkingClient", "Received bytes - len:" + a2.array().length + ", pkg:" + cn.jiguang.f.a.b(this.f3824b));
            } catch (cn.jiguang.at.e e2) {
                cn.jiguang.an.d.f("NetworkingClient", " recv failed with error:" + e2 + " ,No Break!!");
            }
        }
        if (this.f3823a) {
            cn.jiguang.an.d.c("NetworkingClient", "Break receiving by wantStop");
        }
        d();
    }
}
