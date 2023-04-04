package androidx.browser.a;

import android.content.ComponentName;
import android.os.IBinder;

/* compiled from: CustomTabsSession.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1228a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final android.support.a.b f1229b;

    /* renamed from: c  reason: collision with root package name */
    private final android.support.a.a f1230c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentName f1231d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(android.support.a.b bVar, android.support.a.a aVar, ComponentName componentName) {
        this.f1229b = bVar;
        this.f1230c = aVar;
        this.f1231d = componentName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        return this.f1230c.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComponentName b() {
        return this.f1231d;
    }
}
