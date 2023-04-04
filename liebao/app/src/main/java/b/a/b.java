package b.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private volatile c f3098a = null;

    /* renamed from: b  reason: collision with root package name */
    private CountDownLatch f3099b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    private LinkedBlockingQueue f3100c = new LinkedBlockingQueue(1);

    /* renamed from: d  reason: collision with root package name */
    private Object f3101d = new Object();

    public void a(c cVar) {
        this.f3098a = cVar;
    }

    public boolean a() {
        return a(10L);
    }

    public boolean a(long j) {
        if (this.f3098a == null || this.f3098a == c.f3111a || this.f3098a == c.f3112b) {
            this.f3100c.offer(this.f3101d);
            try {
                this.f3099b.await(j + 1, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
        }
        return this.f3098a == c.f3113c;
    }

    public c b() {
        return this.f3098a;
    }

    public Object b(long j) {
        return this.f3100c.poll(j, TimeUnit.SECONDS);
    }

    public void c() {
        this.f3099b.countDown();
    }
}
