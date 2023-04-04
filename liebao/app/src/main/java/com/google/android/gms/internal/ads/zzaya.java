package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaya implements zzqw {
    private final Object lock;
    private String zzbvf;
    private final Context zzcmo;
    private boolean zzect;

    public zzaya(Context context, String str) {
        this.zzcmo = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbvf = str;
        this.zzect = false;
        this.lock = new Object();
    }

    public final void zzaq(boolean z) {
        if (com.google.android.gms.ads.internal.zzr.zzlt().zzaa(this.zzcmo)) {
            synchronized (this.lock) {
                if (this.zzect == z) {
                    return;
                }
                this.zzect = z;
                if (TextUtils.isEmpty(this.zzbvf)) {
                    return;
                }
                if (this.zzect) {
                    com.google.android.gms.ads.internal.zzr.zzlt().zzd(this.zzcmo, this.zzbvf);
                } else {
                    com.google.android.gms.ads.internal.zzr.zzlt().zze(this.zzcmo, this.zzbvf);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        zzaq(zzqxVar.zzbrt);
    }

    public final String getAdUnitId() {
        return this.zzbvf;
    }
}
