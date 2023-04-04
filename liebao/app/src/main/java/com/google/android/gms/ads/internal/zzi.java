package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzduv;
import com.google.android.gms.internal.ads.zzdwd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzi implements zzdwd {
    private final /* synthetic */ zzf zzbpn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(zzf zzfVar) {
        this.zzbpn = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwd
    public final void zza(int i, long j) {
        zzduv zzduvVar;
        zzduvVar = this.zzbpn.zzxh;
        zzduvVar.zzh(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzdwd
    public final void zza(int i, long j, String str) {
        zzduv zzduvVar;
        zzduvVar = this.zzbpn.zzxh;
        zzduvVar.zzb(i, System.currentTimeMillis() - j, str);
    }
}
