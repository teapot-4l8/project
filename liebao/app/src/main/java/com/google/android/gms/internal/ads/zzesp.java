package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.a.b;
import androidx.browser.a.d;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzesp extends d {
    private WeakReference<zzeso> zzjfj;

    public zzesp(zzeso zzesoVar) {
        this.zzjfj = new WeakReference<>(zzesoVar);
    }

    @Override // androidx.browser.a.d
    public final void onCustomTabsServiceConnected(ComponentName componentName, b bVar) {
        zzeso zzesoVar = this.zzjfj.get();
        if (zzesoVar != null) {
            zzesoVar.zza(bVar);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzeso zzesoVar = this.zzjfj.get();
        if (zzesoVar != null) {
            zzesoVar.zzta();
        }
    }
}
