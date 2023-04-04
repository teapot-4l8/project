package cn.jiguang.av;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public int f3993a;

    /* renamed from: b  reason: collision with root package name */
    public long f3994b;

    /* renamed from: c  reason: collision with root package name */
    public String f3995c;

    /* renamed from: d  reason: collision with root package name */
    public String f3996d;

    /* renamed from: e  reason: collision with root package name */
    public String f3997e;
    private final c f;
    private ByteBuffer g;
    private String h;
    private String i;

    public e(c cVar, ByteBuffer byteBuffer) {
        this.f = cVar;
        if (byteBuffer == null) {
            cn.jiguang.an.d.f("RegisterResponse", "No body to parse.");
            return;
        }
        this.g = byteBuffer;
        try {
            this.f3993a = byteBuffer.getShort();
        } catch (Throwable unused) {
            this.f3993a = 10000;
        }
        if (this.f3993a > 0) {
            cn.jiguang.an.d.h("RegisterResponse", "Response error - code:" + this.f3993a);
        }
        ByteBuffer byteBuffer2 = this.g;
        int i = this.f3993a;
        try {
            if (i == 0) {
                this.f3994b = byteBuffer2.getLong();
                this.f3995c = b.a(byteBuffer2);
                this.f3996d = b.a(byteBuffer2);
            } else if (i != 1007) {
                if (i == 1012) {
                    try {
                        this.i = b.a(byteBuffer2);
                    } catch (Throwable unused2) {
                        this.f3993a = 10000;
                    }
                    cn.jiguang.aq.a.a(JCoreManager.getAppContext(null), this.i);
                }
            } else {
                this.h = b.a(byteBuffer2);
            }
        } catch (Throwable unused3) {
            this.f3993a = 10000;
        }
    }

    public final String toString() {
        return "[RegisterResponse] - code:" + this.f3993a + ", juid:" + this.f3994b + ", password:" + this.f3995c + ", regId:" + this.f3996d + ", deviceId:" + this.f3997e + ", connectInfo:" + this.i;
    }
}
