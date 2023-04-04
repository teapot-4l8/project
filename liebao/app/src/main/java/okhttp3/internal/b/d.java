package okhttp3.internal.b;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ae;

/* compiled from: RouteDatabase.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ae> f7448a = new LinkedHashSet();

    public synchronized void a(ae aeVar) {
        this.f7448a.add(aeVar);
    }

    public synchronized void b(ae aeVar) {
        this.f7448a.remove(aeVar);
    }

    public synchronized boolean c(ae aeVar) {
        return this.f7448a.contains(aeVar);
    }
}
