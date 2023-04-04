package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfv implements Callable {
    private final zzcf.zza.zzb zzabg;
    private final zzfc zzwh;

    public zzfv(zzfc zzfcVar, zzcf.zza.zzb zzbVar) {
        this.zzwh = zzfcVar;
        this.zzabg = zzbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzcz */
    public final Void call() {
        if (this.zzwh.zzcq() != null) {
            this.zzwh.zzcq().get();
        }
        zzcf.zza zzcp = this.zzwh.zzcp();
        if (zzcp != null) {
            try {
                synchronized (this.zzabg) {
                    zzcf.zza.zzb zzbVar = this.zzabg;
                    byte[] byteArray = zzcp.toByteArray();
                    zzbVar.zza(byteArray, 0, byteArray.length, zzemn.zzbiv());
                }
            } catch (zzenn | NullPointerException unused) {
            }
        }
        return null;
    }
}
