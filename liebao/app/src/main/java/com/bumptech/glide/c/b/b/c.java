package com.bumptech.glide.c.b.b;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f4720a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f4721b = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f4720a.get(str);
            if (aVar == null) {
                aVar = this.f4721b.a();
                this.f4720a.put(str, aVar);
            }
            aVar.f4723b++;
        }
        aVar.f4722a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.bumptech.glide.i.i.a(this.f4720a.get(str));
            if (aVar.f4723b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f4723b);
            }
            aVar.f4723b--;
            if (aVar.f4723b == 0) {
                a remove = this.f4720a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.f4721b.a(remove);
            }
        }
        aVar.f4722a.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f4722a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f4723b;

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f4724a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.f4724a) {
                poll = this.f4724a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f4724a) {
                if (this.f4724a.size() < 10) {
                    this.f4724a.offer(aVar);
                }
            }
        }
    }
}
