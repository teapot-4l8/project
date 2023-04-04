package cn.jiguang.ar;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.DatagramSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3839a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f3840b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, h hVar) {
        this.f3840b = lVar;
        this.f3839a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DatagramSocket datagramSocket;
        Object th;
        StringBuilder sb;
        boolean a2;
        try {
            datagramSocket = new DatagramSocket();
        } catch (Throwable th2) {
            datagramSocket = null;
            th = th2;
        }
        try {
            String str = (String) cn.jiguang.g.b.a(this.f3840b.f3835a, cn.jiguang.g.a.F());
            if (TextUtils.isEmpty(str)) {
                cn.jiguang.an.d.b("SisConnContext", "reportInfo is Empty, quit report");
                try {
                    datagramSocket.close();
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    sb = new StringBuilder("sisReport ,close udpsocket error:");
                }
            } else {
                byte[] a3 = c.a("DG", str);
                cn.jiguang.an.d.b("SisConnContext", "sis report data(" + a3.length + ") at " + this.f3839a.f3822c + ":" + this.f3839a.f3821b);
                l lVar = this.f3840b;
                a2 = l.a(this.f3839a.f3822c, this.f3839a.f3821b, datagramSocket, a3);
                if (a2) {
                    cn.jiguang.an.d.b("SisConnContext", "report succeed : " + str);
                    cn.jiguang.g.b.a(this.f3840b.f3835a, cn.jiguang.g.a.M().a((cn.jiguang.g.a<Long>) Long.valueOf(SystemClock.elapsedRealtime())));
                    cn.jiguang.g.b.a(this.f3840b.f3835a, cn.jiguang.g.a.F().a((cn.jiguang.g.a<String>) null));
                } else {
                    cn.jiguang.an.d.f("SisConnContext", "report failed" + str);
                }
                try {
                    datagramSocket.close();
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    sb = new StringBuilder("sisReport ,close udpsocket error:");
                }
            }
        } catch (Throwable th5) {
            th = th5;
            try {
                cn.jiguang.an.d.f("SisConnContext", "sisReport failed, error:" + th);
                if (datagramSocket == null) {
                    return;
                }
                try {
                    datagramSocket.close();
                    return;
                } catch (Throwable th6) {
                    th = th6;
                    sb = new StringBuilder("sisReport ,close udpsocket error:");
                }
            } catch (Throwable th7) {
                if (datagramSocket != null) {
                    try {
                        datagramSocket.close();
                    } catch (Throwable th8) {
                        cn.jiguang.an.d.f("SisConnContext", "sisReport ,close udpsocket error:" + th8.getMessage());
                    }
                }
                throw th7;
            }
        }
        sb.append(th.getMessage());
        cn.jiguang.an.d.f("SisConnContext", sb.toString());
    }
}
