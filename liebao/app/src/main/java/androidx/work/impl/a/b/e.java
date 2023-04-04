package androidx.work.impl.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.h;

/* compiled from: NetworkStateTracker.java */
/* loaded from: classes.dex */
public class e extends d<androidx.work.impl.a.b> {

    /* renamed from: d  reason: collision with root package name */
    static final String f2830d = h.a("NetworkStateTracker");

    /* renamed from: e  reason: collision with root package name */
    private final ConnectivityManager f2831e;
    private b f;
    private a g;

    public e(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
        this.f2831e = (ConnectivityManager) this.f2825b.getSystemService("connectivity");
        if (f()) {
            this.f = new b();
        } else {
            this.g = new a();
        }
    }

    @Override // androidx.work.impl.a.b.d
    /* renamed from: a */
    public androidx.work.impl.a.b c() {
        return b();
    }

    @Override // androidx.work.impl.a.b.d
    public void d() {
        if (f()) {
            h.a().b(f2830d, "Registering network callback", new Throwable[0]);
            this.f2831e.registerDefaultNetworkCallback(this.f);
            return;
        }
        h.a().b(f2830d, "Registering broadcast receiver", new Throwable[0]);
        this.f2825b.registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // androidx.work.impl.a.b.d
    public void e() {
        if (f()) {
            try {
                h.a().b(f2830d, "Unregistering network callback", new Throwable[0]);
                this.f2831e.unregisterNetworkCallback(this.f);
                return;
            } catch (IllegalArgumentException e2) {
                h.a().e(f2830d, "Received exception while unregistering network callback", e2);
                return;
            }
        }
        h.a().b(f2830d, "Unregistering broadcast receiver", new Throwable[0]);
        this.f2825b.unregisterReceiver(this.g);
    }

    private static boolean f() {
        return Build.VERSION.SDK_INT >= 24;
    }

    androidx.work.impl.a.b b() {
        NetworkInfo activeNetworkInfo = this.f2831e.getActiveNetworkInfo();
        boolean z = true;
        return new androidx.work.impl.a.b(activeNetworkInfo != null && activeNetworkInfo.isConnected(), g(), androidx.core.c.a.a(this.f2831e), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : false);
    }

    private boolean g() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        NetworkCapabilities networkCapabilities = this.f2831e.getNetworkCapabilities(this.f2831e.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(16);
    }

    /* compiled from: NetworkStateTracker.java */
    /* loaded from: classes.dex */
    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            h.a().b(e.f2830d, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            e eVar = e.this;
            eVar.a((e) eVar.b());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            h.a().b(e.f2830d, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.a((e) eVar.b());
        }
    }

    /* compiled from: NetworkStateTracker.java */
    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            h.a().b(e.f2830d, "Network broadcast received", new Throwable[0]);
            e eVar = e.this;
            eVar.a((e) eVar.b());
        }
    }
}
