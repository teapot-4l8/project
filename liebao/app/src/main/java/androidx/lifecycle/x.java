package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ViewModel.java */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f2047a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f2048b = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        this.f2048b = true;
        Map<String, Object> map = this.f2047a;
        if (map != null) {
            synchronized (map) {
                for (Object obj : this.f2047a.values()) {
                    a(obj);
                }
            }
        }
        a();
    }

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
