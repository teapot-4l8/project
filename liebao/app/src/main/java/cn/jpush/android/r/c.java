package cn.jpush.android.r;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    int f4440a;

    /* renamed from: b  reason: collision with root package name */
    long f4441b;

    /* renamed from: c  reason: collision with root package name */
    String f4442c;

    public c(int i, long j, long j2, ByteBuffer byteBuffer) {
        super(i, j, j2, byteBuffer);
        parseBody();
    }

    public c(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f4440a;
    }

    public long b() {
        return this.f4441b;
    }

    public String c() {
        return this.f4442c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            this.f4440a = this.body.get();
            this.f4441b = this.body.getLong();
            byte[] bArr = new byte[this.body.getShort()];
            this.body.get(bArr);
            this.f4442c = new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            Logger.ww("MessagePush", "parse msg content failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[MessagePush] - msgType:" + this.f4440a + ", msgId:" + this.f4441b + ", msgContent:" + this.f4442c + " - " + super.toString();
    }
}
