package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.g;
import org.greenrobot.eventbus.h;

/* compiled from: EventBusBuilder.java */
/* loaded from: classes2.dex */
public class d {
    private static final ExecutorService m = Executors.newCachedThreadPool();

    /* renamed from: e  reason: collision with root package name */
    boolean f7807e;
    boolean g;
    boolean h;
    List<org.greenrobot.eventbus.a.b> j;
    g k;
    h l;

    /* renamed from: a  reason: collision with root package name */
    boolean f7803a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f7804b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f7805c = true;

    /* renamed from: d  reason: collision with root package name */
    boolean f7806d = true;
    boolean f = true;
    ExecutorService i = m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a() {
        g gVar = this.k;
        return gVar != null ? gVar : (!g.a.a() || c() == null) ? new g.b() : new g.a("EventBus");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b() {
        Object c2;
        h hVar = this.l;
        if (hVar != null) {
            return hVar;
        }
        if (!g.a.a() || (c2 = c()) == null) {
            return null;
        }
        return new h.a((Looper) c2);
    }

    Object c() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
