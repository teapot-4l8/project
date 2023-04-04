package cn.jiguang.ar;

import android.os.Handler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f3866a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(i, i2, 0L, timeUnit, blockingQueue);
        this.f3866a = rVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r3.hasMessages(233) == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // java.util.concurrent.ThreadPoolExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void afterExecute(Runnable runnable, Throwable th) {
        boolean z;
        AtomicBoolean atomicBoolean;
        CountDownLatch countDownLatch;
        Handler handler;
        try {
            if (getActiveCount() <= 1 && getQueue().isEmpty()) {
                handler = this.f3866a.f3863c;
            }
            z = false;
        } catch (Throwable unused) {
        }
        if (z) {
            return;
        }
        try {
            atomicBoolean = this.f3866a.f3864d;
            atomicBoolean.set(true);
            countDownLatch = this.f3866a.h;
            countDownLatch.countDown();
            return;
        } catch (Throwable unused2) {
            return;
        }
        z = true;
        if (z) {
        }
    }
}
