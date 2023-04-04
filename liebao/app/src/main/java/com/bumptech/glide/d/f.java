package com.bumptech.glide.d;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.d.c;

/* compiled from: DefaultConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class f implements d {
    @Override // com.bumptech.glide.d.d
    public c a(Context context, c.a aVar) {
        boolean z = androidx.core.content.b.b(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new e(context, aVar) : new j();
    }
}
