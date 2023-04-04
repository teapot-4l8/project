package cn.jiguang.ar;

import android.content.Context;

/* loaded from: classes.dex */
final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3868a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3869b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Context context, byte[] bArr) {
        this.f3869b = context;
        this.f3868a = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            cn.jiguang.at.h.a().a(this.f3869b, "tcp_a22", null);
            cn.jiguang.av.a.a(this.f3869b, this.f3868a);
        } catch (Throwable th) {
            cn.jiguang.an.d.f("TcpRecvAction", "TcpRecvAction failed:" + th.getMessage());
        }
    }
}
