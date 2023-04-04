package cn.jiguang.ar;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class q implements Callable<n> {

    /* renamed from: a  reason: collision with root package name */
    private final l f3856a;

    /* renamed from: b  reason: collision with root package name */
    private final r f3857b;

    /* renamed from: c  reason: collision with root package name */
    private final g f3858c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f3859d;

    /* renamed from: e  reason: collision with root package name */
    private h f3860e;

    public q(l lVar, h hVar, Set<String> set) {
        this.f3856a = lVar;
        this.f3857b = null;
        this.f3858c = null;
        this.f3860e = hVar;
        this.f3859d = set;
    }

    public q(l lVar, r rVar, g gVar) {
        this.f3856a = lVar;
        this.f3857b = rVar;
        this.f3858c = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public n call() {
        try {
            if (this.f3858c != null) {
                return a(this.f3858c.a(this.f3856a.a()));
            }
            return a(this.f3860e);
        } catch (Throwable th) {
            cn.jiguang.an.d.f("SisTask", "run e:" + th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f0, code lost:
        if (r5 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private n a(h hVar) {
        DatagramSocket datagramSocket;
        Object[] a2;
        if (hVar == null || hVar.f3822c == null) {
            return null;
        }
        try {
            datagramSocket = new DatagramSocket();
        } catch (Throwable th) {
            th = th;
            datagramSocket = null;
        }
        try {
            if (!TextUtils.isEmpty(cn.jiguang.aq.a.f3802a)) {
                hVar.f3822c = InetAddress.getByName(cn.jiguang.aq.a.f3802a);
            }
            if (cn.jiguang.aq.a.f3803b > 0) {
                hVar.f3821b = cn.jiguang.aq.a.f3803b;
            }
            cn.jiguang.an.d.b("SisTask", "send sis:" + hVar.f3822c + " port:" + hVar.f3821b);
            a2 = a(datagramSocket, hVar.f3822c, hVar.f3821b);
        } catch (Throwable th2) {
            th = th2;
            try {
                cn.jiguang.an.d.f("SisTask", "sis e:" + th);
            } catch (Throwable th3) {
                if (datagramSocket != null) {
                    try {
                        datagramSocket.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th3;
            }
        }
        if (a2[0] instanceof n) {
            boolean z = hVar.f3822c instanceof Inet4Address;
            this.f3856a.a(z);
            cn.jiguang.g.b.a(this.f3856a.f3835a, cn.jiguang.g.a.b(z).a((cn.jiguang.g.a<String>) hVar.toString()));
            if (this.f3857b != null) {
                this.f3857b.a(a2[0]);
            }
            n nVar = (n) a2[0];
            try {
                datagramSocket.close();
            } catch (Throwable unused2) {
            }
            return nVar;
        }
        int intValue = ((Integer) a2[0]).intValue();
        long longValue = ((Long) a2[1]).longValue();
        cn.jiguang.an.d.f("SisTask", "sis failed(" + intValue + "):" + hVar.f3822c + " port:" + hVar.f3821b);
        this.f3856a.a(1, hVar.f3822c.getHostAddress(), hVar.f3821b, cn.jiguang.d.b.b(this.f3856a.f3835a), longValue, intValue);
        try {
            datagramSocket.close();
        } catch (Throwable unused3) {
            return null;
        }
    }

    private Object[] a(DatagramSocket datagramSocket, InetAddress inetAddress, int i) {
        Object[] objArr = new Object[2];
        objArr[1] = 0;
        try {
            byte[] a2 = this.f3856a.a(this.f3859d);
            DatagramPacket datagramPacket = new DatagramPacket(a2, a2.length, inetAddress, i);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                byte[] a3 = c.a(datagramSocket, datagramPacket);
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                try {
                    n nVar = new n(new String(c.a(a3)));
                    if (nVar.a()) {
                        objArr[0] = 6;
                        return objArr;
                    }
                    Context context = this.f3856a.f3835a;
                    if (!nVar.a()) {
                        String a4 = h.a(nVar.f3841a);
                        String a5 = h.a(nVar.f3842b);
                        String c2 = cn.jiguang.f.j.c(context);
                        cn.jiguang.an.d.b("SisTask", "updateSisInfo ips=" + a4 + " sslIps=" + a5 + " net=" + c2);
                        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[8];
                        aVarArr[0] = cn.jiguang.g.a.I().a((cn.jiguang.g.a<String>) a4);
                        aVarArr[1] = cn.jiguang.g.a.J().a((cn.jiguang.g.a<String>) a5);
                        aVarArr[2] = cn.jiguang.g.a.d(false).a((cn.jiguang.g.a<String>) h.a(nVar.f3843c));
                        aVarArr[3] = cn.jiguang.g.a.d(true).a((cn.jiguang.g.a<String>) h.a(nVar.f3844d));
                        aVarArr[4] = cn.jiguang.g.a.N().a((cn.jiguang.g.a<String>) h.a(nVar.f3845e));
                        aVarArr[5] = cn.jiguang.g.a.Q().a((cn.jiguang.g.a<String>) (nVar.f != null ? nVar.f.toString() : null));
                        aVarArr[6] = cn.jiguang.g.a.K().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(nVar.h));
                        aVarArr[7] = cn.jiguang.g.a.L().a((cn.jiguang.g.a<Long>) Long.valueOf(SystemClock.elapsedRealtime()));
                        cn.jiguang.g.b.a(context, aVarArr);
                        cn.jiguang.g.b.a(context, cn.jiguang.g.a.E().a((cn.jiguang.g.a<String>) c2));
                    }
                    nVar.g = new h(inetAddress, i);
                    objArr[0] = nVar;
                    return objArr;
                } catch (cn.jiguang.at.e e2) {
                    objArr[0] = Integer.valueOf(e2.f3932a);
                    return objArr;
                }
            } catch (Exception unused) {
                objArr[0] = 3;
                objArr[1] = Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis);
                return objArr;
            }
        } catch (cn.jiguang.at.e e3) {
            objArr[0] = Integer.valueOf(e3.f3932a);
            return objArr;
        }
    }
}
