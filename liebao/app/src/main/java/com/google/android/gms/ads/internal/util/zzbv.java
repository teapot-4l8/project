package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzww;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbv {
    private Context zzaai;
    private boolean zzejc;
    private boolean zzzq = false;
    private final Map<BroadcastReceiver, IntentFilter> zzejb = new WeakHashMap();
    private final BroadcastReceiver zzeja = new zzby(this);

    public final synchronized void initialize(Context context) {
        if (this.zzzq) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.zzaai = applicationContext;
        if (applicationContext == null) {
            this.zzaai = context;
        }
        zzabq.initialize(this.zzaai);
        this.zzejc = ((Boolean) zzww.zzra().zzd(zzabq.zzcua)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zzaai.registerReceiver(this.zzeja, intentFilter);
        this.zzzq = true;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzejc) {
            this.zzejb.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzejc) {
            this.zzejb.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzc(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzejb.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                arrayList.add(entry.getKey());
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }
}
