package cn.jiguang.ag;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes.dex */
final class e implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3695a;

    private e(a aVar) {
        this.f3695a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, byte b2) {
        this(aVar);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            cn.jiguang.ad.a.a("JWake", "unbind wake ServiceConnection");
            a.a(this.f3695a).getApplicationContext().unbindService(this);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWake", "onServiceConnected throwable" + th.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
