package cn.jpush.android.r;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a extends JPushResponse {

    /* renamed from: a  reason: collision with root package name */
    private int f4439a;

    public a(int i, long j, long j2, ByteBuffer byteBuffer) {
        super(i, j, j2, byteBuffer);
        parseBody();
    }

    public a(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f4439a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            this.f4439a = this.body.getShort();
        } catch (Throwable th) {
            Logger.ww("CommonResponse", "parse code failed :" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[CommonResponse] - " + this.f4439a;
    }
}
