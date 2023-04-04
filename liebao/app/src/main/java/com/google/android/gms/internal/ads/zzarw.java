package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarw extends zzgw implements zzaru {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final void zzc(Intent intent) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, intent);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final void zzc(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzdp.writeString(str2);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final void zzwe() {
        zzb(3, zzdp());
    }
}
