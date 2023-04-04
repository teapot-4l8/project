package cn.jpush.android.r;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class e extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    int f4447a;

    /* renamed from: b  reason: collision with root package name */
    String f4448b;

    public e(int i, long j, long j2, ByteBuffer byteBuffer) {
        super(i, j, j2, byteBuffer);
        parseBody();
    }

    public e(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public String a() {
        return this.f4448b;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            if (this.cmd == 10) {
                this.f4447a = this.body.getShort();
            }
            if (this.f4447a <= 0) {
                byte[] bArr = new byte[this.body.getShort()];
                this.body.get(bArr);
                this.f4448b = new String(bArr, "UTF-8");
                return;
            }
            Logger.e("TagaliasResponse", "Response error - code:" + this.f4447a);
        } catch (Throwable th) {
            Logger.ww("TagaliasResponse", "parse failed:" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[TagaliasResponse] - action:" + this.f4448b + " - " + super.toString();
    }
}
