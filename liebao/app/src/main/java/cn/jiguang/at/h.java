package cn.jiguang.at;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import cn.jiguang.internal.JConstants;
import com.tencent.bugly.CrashModule;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class h {
    private static volatile h i;
    private static final Object j = new Object();

    /* renamed from: a  reason: collision with root package name */
    private cn.jiguang.ar.i f3939a;

    /* renamed from: b  reason: collision with root package name */
    private int f3940b;

    /* renamed from: c  reason: collision with root package name */
    private int f3941c;
    private long f;
    private boolean g;
    private Context k;

    /* renamed from: d  reason: collision with root package name */
    private int f3942d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f3943e = 0;
    private boolean l = false;
    private final AtomicBoolean m = new AtomicBoolean(false);
    private cn.jiguang.ax.a n = new i(this);
    private boolean h = true;

    private h() {
    }

    public static h a() {
        if (i == null) {
            synchronized (j) {
                if (i == null) {
                    i = new h();
                }
            }
        }
        return i;
    }

    private synchronized void a(Context context) {
        if (this.l) {
            return;
        }
        if (context == null) {
            cn.jiguang.an.d.b("JCoreTCPManager", "init context is null");
            return;
        }
        cn.jiguang.an.d.b("JCoreTCPManager", "init tcp manager...");
        this.k = context.getApplicationContext();
        cn.jiguang.ap.b.a("JCoreTCPManager");
        cn.jiguang.ax.b.a().a(this.k);
        f.a().a(context, true);
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(h hVar, Context context) {
        String str;
        cn.jiguang.an.d.b("JCoreTCPManager", "handleResume...");
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.z().a((cn.jiguang.g.a<Boolean>) false));
        if (hVar.g) {
            str = "[handleResume] is loggedin";
        } else if (hVar.f3939a == null) {
            hVar.h();
            return;
        } else {
            str = "[handleResume] tcp is connecting...";
        }
        cn.jiguang.an.d.b("JCoreTCPManager", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(h hVar, int i2) {
        hVar.f3940b = i2;
        if (i2 == 1012) {
            cn.jiguang.ar.c.a(hVar.k);
        }
        hVar.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(h hVar, Context context) {
        cn.jiguang.an.d.b("JCoreTCPManager", "handleStop...");
        if (((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.z())).booleanValue()) {
            cn.jiguang.an.d.c("JCoreTCPManager", "tcp already stoped");
            return;
        }
        b.a();
        if (!b.a(0)) {
            cn.jiguang.an.d.b("JCoreTCPManager", "Action: handleStopPush - can't stop tcp");
            return;
        }
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.z().a((cn.jiguang.g.a<Boolean>) true));
        hVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bundle bundle) {
        if (this.m.get()) {
            cn.jiguang.an.d.b("JCoreTCPManager", "isBeating, skip this time");
            return;
        }
        if (!(bundle != null ? bundle.getBoolean("force", false) : false)) {
            if (System.currentTimeMillis() - this.f < 18000) {
                cn.jiguang.an.d.b("JCoreTCPManager", "No need to rtc, Because it have succeed recently");
                return;
            }
        }
        cn.jiguang.an.d.c("JCoreTCPManager", "Send heart beat");
        cn.jiguang.ax.b.a().b(1005);
        if (!this.g) {
            cn.jiguang.an.d.b("JCoreTCPManager", "socket is closed or push isn't login");
            return;
        }
        this.m.set(true);
        cn.jiguang.ax.b.a().b(1022);
        Long valueOf = Long.valueOf(cn.jiguang.ar.c.b(this.k));
        long d2 = cn.jiguang.d.a.d(this.k);
        cn.jiguang.an.d.b("JCoreTCPManager", "heartbeat - juid:" + d2 + ", flag:1");
        byte[] a2 = cn.jiguang.av.b.a(this.k, cn.jiguang.av.b.a(valueOf.longValue(), JConstants.tcpSessionId, d2, (short) 1));
        if (a2 != null) {
            this.f3939a.c().a(a2);
        } else {
            cn.jiguang.an.d.g("JCoreTCPManager", "send hb failed:sendData is null");
        }
        cn.jiguang.ax.b.a().b(1022, 10000L, this.n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(h hVar) {
        cn.jiguang.an.d.c("JCoreTCPManager", "Action - onDisconnected");
        if (hVar.g) {
            hVar.g = false;
            b.a().a(hVar.k, -1, -1, "push connect break");
        }
        if (hVar.f3939a == null && ((Boolean) cn.jiguang.g.b.a(hVar.k, cn.jiguang.g.a.z())).booleanValue()) {
            cn.jiguang.an.d.b("JCoreTCPManager", "push already stopped!!!");
            return;
        }
        hVar.f3943e = 0;
        hVar.f();
        hVar.g();
        hVar.f3942d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(h hVar) {
        cn.jiguang.an.d.c("JCoreTCPManager", "Action - onLoggedIn");
        if (!hVar.g) {
            hVar.g = true;
            b.a().a(hVar.k, 1, 0, "success");
        }
        hVar.b();
        hVar.f3942d = 0;
        hVar.f3943e = 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("login", true);
        d.a(hVar.k, "periodtask", bundle);
        if (hVar.e()) {
            cn.jiguang.ax.b.a().b(2000, 2000L, hVar.n);
            cn.jiguang.e.a.a().a(hVar.k);
            n.a().a(hVar.k);
            f.a().a(hVar.k, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        if (cn.jiguang.am.b.a().d() || p.a().b(this.k)) {
            return true;
        }
        cn.jiguang.an.d.b("JCoreTCPManager", "not keep tcp");
        this.h = false;
        f();
        return false;
    }

    private void f() {
        cn.jiguang.ar.i iVar = this.f3939a;
        if (iVar == null) {
            cn.jiguang.an.d.b("JCoreTCPManager", "tcp has stopeed");
            return;
        }
        iVar.b();
        this.f3939a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(h hVar) {
        hVar.m.set(false);
        hVar.f3943e++;
        cn.jiguang.an.d.c("JCoreTCPManager", "Action - onHeartbeatTimeout - timeoutTimes:" + hVar.f3943e);
        cn.jiguang.an.a.a(JConstants.SDK_TYPE, "JCoreTCPManager", false, 2, "============================================================");
        if (hVar.f3939a != null && !hVar.g) {
            cn.jiguang.an.d.c("JCoreTCPManager", "Is connecting now. Give up to retry.");
        } else if (!hVar.g || hVar.f3943e > 1) {
            hVar.f();
            hVar.g();
        } else {
            cn.jiguang.an.d.c("JCoreTCPManager", "Already logged in. Give up to retry.");
            cn.jiguang.ax.b.a().b(1005, 5000L, hVar.n);
        }
    }

    private void g() {
        cn.jiguang.an.d.c("JCoreTCPManager", "Action - retryConnect - disconnectedTimes:" + this.f3942d);
        if (!cn.jiguang.f.a.d(this.k.getApplicationContext())) {
            cn.jiguang.an.d.b("JCoreTCPManager", "[retryConnect] network is not connect");
        } else if (this.f3941c > 0) {
            cn.jiguang.an.d.b("JCoreTCPManager", "[retryConnect] registerErrCode >0,registerErrCode:" + this.f3941c);
        } else {
            int c2 = cn.jiguang.f.a.c(this.k.getApplicationContext());
            int pow = (int) (Math.pow(2.0d, this.f3942d) * 3.0d * 1000.0d);
            int i2 = JConstants.DEFAULT_HEARTBEAT_INTERVAL;
            int i3 = (i2 * 1000) / 2;
            if (pow > i3) {
                pow = i3;
            }
            cn.jiguang.an.d.b("JCoreTCPManager", "[retryConnect] mDisconnectedTimes:" + this.f3942d + ",chargedLever:" + c2 + ",heartbeatInterval:" + i2 + ",delayTime:" + pow);
            if (c2 != 1 ? this.f3942d >= 5 : this.f3942d >= 30) {
                cn.jiguang.an.d.b("JCoreTCPManager", "Give up to retry connect.");
            } else if (cn.jiguang.ax.b.a().a(1011)) {
                cn.jiguang.an.d.b("JCoreTCPManager", "Already has MSG_RESTART_CONN");
            } else {
                cn.jiguang.ax.b.a().b(1011, pow, this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(h hVar) {
        cn.jiguang.an.d.c("JCoreTCPManager", "Action - onHeartbeatSucceed");
        b.a().a(hVar.k, 19, 0, "ack success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        cn.jiguang.an.d.c("JCoreTCPManager", "Action - restartNetworkingClient, pid:" + Process.myPid());
        if (!this.h) {
            cn.jiguang.an.d.e("JCoreTCPManager", "need not keep tcp,next start app will re login");
        } else if (!cn.jiguang.f.a.d(this.k.getApplicationContext())) {
            cn.jiguang.an.d.e("JCoreTCPManager", "No network connection. Give up to start connection thread.");
        } else if (((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.z())).booleanValue()) {
            cn.jiguang.an.d.c("JCoreTCPManager", "[restartNetworkingClient] tcp has close by active");
        } else {
            if (this.f3941c != 1005 && this.f3941c != 1006 && this.f3941c != 1008 && this.f3941c != 1009) {
                if (this.f3940b == 102) {
                    cn.jiguang.an.d.g("JCoreTCPManager", "login failed:102,give up start connection thread.reset from next app start");
                    return;
                } else if (this.f3939a != null) {
                    cn.jiguang.an.d.c("JCoreTCPManager", "NetworkingClient is running");
                    return;
                } else {
                    cn.jiguang.ar.i iVar = new cn.jiguang.ar.i(this.k.getApplicationContext());
                    this.f3939a = iVar;
                    iVar.a();
                    return;
                }
            }
            cn.jiguang.an.d.b("JCoreTCPManager", "[restartNetworkingClient] registerErrCode >0,registerErrCode:" + this.f3941c);
        }
    }

    public final void a(Context context, String str, Bundle bundle) {
        a(context);
        cn.jiguang.ap.b.a("JCoreTCPManager", new j(this, context, str, bundle));
    }

    public final void a(Bundle bundle) {
        long j2;
        if (((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.z())).booleanValue()) {
            cn.jiguang.an.d.c("JCoreTCPManager", "[rtc] tcp has close by active");
            return;
        }
        boolean z = true;
        if (bundle != null) {
            z = bundle.getBoolean("force", true);
            j2 = bundle.getLong("delay_time", 0L);
        } else {
            j2 = 0;
        }
        if (this.f3939a == null) {
            h();
            return;
        }
        if (j2 <= 0) {
            c(bundle);
        } else {
            int i2 = CrashModule.MODULE_ID;
            if (z) {
                cn.jiguang.ax.b.a().b(1005);
                cn.jiguang.ax.b.a().b(CrashModule.MODULE_ID);
            }
            cn.jiguang.ax.b a2 = cn.jiguang.ax.b.a();
            if (!z) {
                i2 = 1005;
            }
            a2.b(i2, j2, this.n);
        }
        cn.jiguang.an.d.d("JCoreTCPManager", "send rtc force=" + z + " delay=" + j2);
    }

    public final void b() {
        cn.jiguang.ax.b.a().b(1022);
        this.f = System.currentTimeMillis();
        this.f3943e = 0;
        this.m.set(false);
        cn.jiguang.an.d.d("JCoreTCPManager", "update rtc state");
    }

    public final void b(Bundle bundle) {
        if (((Boolean) cn.jiguang.g.b.a(this.k, cn.jiguang.g.a.z())).booleanValue()) {
            cn.jiguang.an.d.f("JCoreTCPManager", "[netWorkChanged] tcp has close by active");
            return;
        }
        cn.jiguang.ax.b.a().b(1006);
        cn.jiguang.ax.b.a().b(1007);
        if (!bundle.getBoolean("connected", false)) {
            cn.jiguang.an.d.b("JCoreTCPManager", "Handle disconnected state.");
            cn.jiguang.ax.b.a().b(1007, 3000L, this.n);
            return;
        }
        cn.jiguang.an.d.b("JCoreTCPManager", "Handle connected state.");
        if (this.f3939a == null) {
            h();
        } else {
            cn.jiguang.ax.b.a().b(1006, 3000L, this.n);
        }
    }

    public final cn.jiguang.ar.i c() {
        return this.f3939a;
    }

    public final boolean d() {
        return this.g;
    }
}
