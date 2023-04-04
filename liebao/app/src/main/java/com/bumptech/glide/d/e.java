package com.bumptech.glide.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.d.c;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    final c.a f5117a;

    /* renamed from: b  reason: collision with root package name */
    boolean f5118b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5119c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5120d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f5121e = new BroadcastReceiver() { // from class: com.bumptech.glide.d.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = e.this.f5118b;
            e eVar = e.this;
            eVar.f5118b = eVar.a(context);
            if (z != e.this.f5118b) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f5118b);
                }
                e.this.f5117a.a(e.this.f5118b);
            }
        }
    };

    @Override // com.bumptech.glide.d.i
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, c.a aVar) {
        this.f5119c = context.getApplicationContext();
        this.f5117a = aVar;
    }

    private void a() {
        if (this.f5120d) {
            return;
        }
        this.f5118b = a(this.f5119c);
        try {
            this.f5119c.registerReceiver(this.f5121e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f5120d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    private void b() {
        if (this.f5120d) {
            this.f5119c.unregisterReceiver(this.f5121e);
            this.f5120d = false;
        }
    }

    boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.bumptech.glide.i.i.a((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.d.i
    public void c() {
        a();
    }

    @Override // com.bumptech.glide.d.i
    public void d() {
        b();
    }
}
