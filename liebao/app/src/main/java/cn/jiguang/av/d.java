package cn.jiguang.av;

import cn.jiguang.api.JCoreManager;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f3988a;

    /* renamed from: b  reason: collision with root package name */
    public int f3989b;

    /* renamed from: c  reason: collision with root package name */
    public int f3990c;

    /* renamed from: d  reason: collision with root package name */
    public int f3991d;

    /* renamed from: e  reason: collision with root package name */
    private final c f3992e;
    private ByteBuffer f;
    private int g;
    private String h;
    private String i;

    public d(c cVar, ByteBuffer byteBuffer) {
        String str;
        this.f3992e = cVar;
        if (byteBuffer != null) {
            this.f = byteBuffer;
            try {
                this.f3988a = byteBuffer.getShort();
            } catch (Throwable unused) {
                this.f3988a = 10000;
            }
            if (this.f3988a > 0) {
                cn.jiguang.an.d.h("LoginResponse", "Response error - code:" + this.f3988a);
            }
            ByteBuffer byteBuffer2 = this.f;
            this.f3991d = -1;
            int i = this.f3988a;
            if (i != 0) {
                if (i == 1012) {
                    try {
                        this.i = b.a(byteBuffer2);
                    } catch (Throwable unused2) {
                        this.f3988a = 10000;
                    }
                    cn.jiguang.aq.a.a(JCoreManager.getAppContext(null), this.i);
                    return;
                }
                return;
            }
            try {
                this.f3989b = byteBuffer2.getInt();
                this.g = byteBuffer2.getShort();
                this.h = b.a(byteBuffer2);
                this.f3990c = byteBuffer2.getInt();
            } catch (Throwable unused3) {
                this.f3988a = 10000;
            }
            try {
                this.f3991d = byteBuffer2.get();
                cn.jiguang.an.d.b("LoginResponse", "idc parse success, value:" + this.f3991d);
                return;
            } catch (Throwable th) {
                str = "parse idc failed, error:" + th;
            }
        } else {
            str = "No body to parse.";
        }
        cn.jiguang.an.d.f("LoginResponse", str);
    }

    public final String toString() {
        return "[LoginResponse] - code:" + this.f3988a + ",sid:" + this.f3989b + ", serverVersion:" + this.g + ", sessionKey:" + this.h + ", serverTime:" + this.f3990c + ", idc:" + this.f3991d + ", connectInfo:" + this.i;
    }
}
