package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
final class e implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f4342a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f4343b;

    private e(d dVar) {
        this.f4343b = dVar;
        this.f4342a = new LinkedBlockingQueue<>(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(d dVar, byte b2) {
        this(dVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            a.f4340a.set(false);
            cn.jpush.android.i.b.b("ServiceConnection", "onServiceConnected:" + componentName);
            if (iBinder != null) {
                this.f4342a.put(iBinder);
            } else {
                cn.jpush.android.i.b.g("ServiceConnection", "onServiceConnected, but IBinder is null.");
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a.f4340a.set(false);
        d.a(this.f4343b, (cn.a.a.d) null);
        cn.jpush.android.i.b.g("ServiceConnection", "onServiceDisconnected:" + componentName);
    }
}
