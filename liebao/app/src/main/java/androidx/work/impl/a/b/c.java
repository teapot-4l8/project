package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.h;

/* compiled from: BroadcastReceiverConstraintTracker.java */
/* loaded from: classes.dex */
public abstract class c<T> extends d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2820d = h.a("BrdcstRcvrCnstrntTrckr");

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f2821e;

    public abstract void a(Context context, Intent intent);

    public abstract IntentFilter b();

    public c(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
        this.f2821e = new BroadcastReceiver() { // from class: androidx.work.impl.a.b.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent != null) {
                    c.this.a(context2, intent);
                }
            }
        };
    }

    @Override // androidx.work.impl.a.b.d
    public void d() {
        h.a().b(f2820d, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f2825b.registerReceiver(this.f2821e, b());
    }

    @Override // androidx.work.impl.a.b.d
    public void e() {
        h.a().b(f2820d, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f2825b.unregisterReceiver(this.f2821e);
    }
}
