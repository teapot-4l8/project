package cn.jiguang.n;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.jiguang.v.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    HandlerThread f4140a;

    /* renamed from: b  reason: collision with root package name */
    Handler f4141b;

    /* renamed from: c  reason: collision with root package name */
    private int f4142c = 300;

    /* renamed from: d  reason: collision with root package name */
    private String f4143d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, int i) {
        this.f4143d = str;
        HandlerThread handlerThread = new HandlerThread("ping timer");
        this.f4140a = handlerThread;
        handlerThread.start();
        this.f4141b = new Handler(this.f4140a.getLooper(), new c(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = {bArr[0], bArr[1], bArr[2], 0};
        Thread currentThread = Thread.currentThread();
        for (int i3 = 0; i3 < 255; i3++) {
            bArr2[3] = (byte) i3;
            if (bArr2[3] != bArr[3]) {
                String a2 = a.a(bArr2);
                if (!a2.equalsIgnoreCase(this.f4143d)) {
                    this.f4141b.removeCallbacksAndMessages(null);
                    Message obtainMessage = this.f4141b.obtainMessage(1);
                    obtainMessage.obj = currentThread;
                    Bundle bundle = new Bundle();
                    bundle.putString("ip", a2);
                    obtainMessage.setData(bundle);
                    this.f4141b.sendMessageDelayed(obtainMessage, this.f4142c);
                    f.a(new String[]{"ping -c 1 -w 1 " + a2}, 0);
                }
            }
        }
        this.f4140a.quit();
    }
}
