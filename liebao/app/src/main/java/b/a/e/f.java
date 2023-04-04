package b.a.e;

import b.a.f.q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f3148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f3148a = eVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0006 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        LinkedBlockingQueue linkedBlockingQueue;
        q qVar;
        while (z) {
            try {
                linkedBlockingQueue = this.f3148a.f3143a;
                linkedBlockingQueue.poll(10L, TimeUnit.SECONDS);
                qVar = this.f3148a.g;
                qVar.e();
            } catch (InterruptedException unused) {
            }
        }
    }
}
