package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgf extends zzgn {
    private final StackTraceElement[] zzabl;

    public zzgf(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzfcVar, str, str2, zzbVar, i, 45);
        this.zzabl = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        zzcq zzcqVar;
        if (this.zzabl != null) {
            zzey zzeyVar = new zzey((String) this.zzabq.invoke(null, this.zzabl));
            synchronized (this.zzabg) {
                this.zzabg.zzbi(zzeyVar.zzyv.longValue());
                if (zzeyVar.zzyw.booleanValue()) {
                    zzcf.zza.zzb zzbVar = this.zzabg;
                    if (zzeyVar.zzyx.booleanValue()) {
                        zzcqVar = zzcq.ENUM_FALSE;
                    } else {
                        zzcqVar = zzcq.ENUM_TRUE;
                    }
                    zzbVar.zzh(zzcqVar);
                } else {
                    this.zzabg.zzh(zzcq.ENUM_FAILURE);
                }
            }
        }
    }
}
