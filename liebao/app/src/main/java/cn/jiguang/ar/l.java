package cn.jiguang.ar;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.internal.JConstants;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class l {

    /* renamed from: c  reason: collision with root package name */
    private static l f3834c;

    /* renamed from: a  reason: collision with root package name */
    Context f3835a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<o> f3836b;

    /* renamed from: d  reason: collision with root package name */
    private int f3837d = 0;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f3838e;
    private int f;

    private l(Context context) {
        this.f3835a = context;
        this.f3836b = o.a((String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.F()));
    }

    public static l a(Context context) {
        if (f3834c == null) {
            synchronized (l.class) {
                if (f3834c == null) {
                    f3834c = new l(context);
                }
            }
        }
        return f3834c;
    }

    private p a(int i) {
        double d2;
        long j;
        Bundle bundle;
        double d3;
        String a2 = cn.jiguang.am.a.a(this.f3835a);
        long d4 = cn.jiguang.d.a.d(this.f3835a);
        String b2 = cn.jiguang.f.j.b(this.f3835a);
        long currentTimeMillis = System.currentTimeMillis();
        Object a3 = cn.jiguang.at.d.a(this.f3835a, "get_loc_info", null);
        double d5 = 200.0d;
        if (a3 instanceof Bundle) {
            try {
                bundle = (Bundle) a3;
                d3 = bundle.getDouble(com.umeng.analytics.pro.d.C);
            } catch (Throwable unused) {
                d2 = 200.0d;
            }
            try {
                d5 = bundle.getDouble("lot");
                j = bundle.getLong("time");
                d5 = d3;
                d2 = d5;
            } catch (Throwable unused2) {
                double d6 = d5;
                d5 = d3;
                d2 = d6;
                j = currentTimeMillis;
                return new p(i, a2, cn.jiguang.a.a.f3640b, d4, b2, d5, d2, j);
            }
        } else {
            j = currentTimeMillis;
            d2 = 200.0d;
        }
        return new p(i, a2, cn.jiguang.a.a.f3640b, d4, b2, d5, d2, j);
    }

    private synchronized void a(o oVar) {
        this.f3836b.add(oVar);
        cn.jiguang.an.d.b("SisConnContext", "addSisReportInfo:" + oVar.a().toString());
        while (this.f3836b.size() > 30) {
            this.f3836b.removeFirst();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<o> it = this.f3836b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        cn.jiguang.g.b.a(this.f3835a, cn.jiguang.g.a.F().a((cn.jiguang.g.a<String>) jSONArray.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(InetAddress inetAddress, int i, DatagramSocket datagramSocket, byte[] bArr) {
        try {
            byte[] a2 = c.a(c.a(datagramSocket, new DatagramPacket(bArr, bArr.length, inetAddress, i)));
            if (a2 == null || a2.length == 0) {
                throw new Exception("byte could not be empty");
            }
            return ((short) (a2.length == 1 ? a2[0] : ((short) (a2[1] & 255)) | ((short) ((a2[0] & 255) << 8)))) == 0;
        } catch (Throwable th) {
            cn.jiguang.an.d.h("SisConnContext", "report failed : " + th);
            return false;
        }
    }

    public final int a() {
        if (this.f3837d == 0) {
            this.f3837d = cn.jiguang.au.c.a().a(this.f3835a);
        }
        cn.jiguang.au.c.a();
        int b2 = cn.jiguang.au.c.b(this.f3837d);
        cn.jiguang.an.d.b("SisConnContext", "ipvsupport=" + this.f3837d + ", prefer=" + b2);
        return b2;
    }

    public final n a(long j) {
        FutureTask futureTask = new FutureTask(new j(this));
        this.f3837d = 0;
        cn.jiguang.ap.b.a(futureTask);
        try {
            return (n) futureTask.get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public final void a(int i, String str, int i2, long j, long j2, int i3) {
        if (h.a(str, i2)) {
            o oVar = new o();
            oVar.f3846a = cn.jiguang.am.a.a(this.f3835a);
            oVar.f3847b = i;
            oVar.f3848c = new h(str, i2);
            oVar.f3850e = j;
            oVar.f = j2;
            oVar.k = i3;
            oVar.g = cn.jiguang.f.j.a(this.f3835a);
            oVar.f3849d = cn.jiguang.d.a.d(this.f3835a);
            oVar.h = 200.0d;
            oVar.i = 200.0d;
            oVar.j = System.currentTimeMillis();
            Object a2 = cn.jiguang.at.d.a(this.f3835a, "get_loc_info", null);
            if (a2 instanceof Bundle) {
                try {
                    Bundle bundle = (Bundle) a2;
                    oVar.h = bundle.getDouble(com.umeng.analytics.pro.d.C);
                    oVar.i = bundle.getDouble("lot");
                    oVar.j = bundle.getLong("time");
                } catch (Throwable unused) {
                }
            }
            a(oVar);
        }
    }

    public final void a(h hVar) {
        if (((Boolean) cn.jiguang.g.b.a(this.f3835a, cn.jiguang.g.a.K())).booleanValue()) {
            if (cn.jiguang.f.k.a(((Long) cn.jiguang.g.b.a(this.f3835a, cn.jiguang.g.a.M())).longValue(), JConstants.HOUR)) {
                cn.jiguang.ap.b.a(new m(this, hVar));
            } else {
                cn.jiguang.an.d.b("SisConnContext", "sis report: not yet");
            }
        }
    }

    public final void a(boolean z) {
        this.f3837d = (z ? 1 : 2) | this.f3837d;
        cn.jiguang.au.c.a().a(this.f3835a, this.f3837d);
    }

    public final byte[] a(Set<String> set) {
        int a2 = cn.jiguang.f.j.a(this.f3835a);
        if (this.f3838e == null || a2 != this.f) {
            this.f = a2;
            try {
                this.f3838e = c.a("UG", a(a2).a(set).toString());
            } catch (Exception e2) {
                throw new cn.jiguang.at.e(2, "Failed to package data - " + e2);
            }
        }
        return this.f3838e;
    }
}
