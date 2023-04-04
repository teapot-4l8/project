package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzasj extends zzgw implements zzash {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onCreate(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        zzb(1, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onRestart() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onStart() {
        zzb(3, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onResume() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onPause() {
        zzb(5, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onSaveInstanceState(Bundle bundle) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, bundle);
        Parcel zza = zza(6, zzdp);
        if (zza.readInt() != 0) {
            bundle.readFromParcel(zza);
        }
        zza.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onStop() {
        zzb(7, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onDestroy() {
        zzb(8, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void zzdq() {
        zzb(9, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onBackPressed() {
        zzb(10, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final boolean zzwh() {
        Parcel zza = zza(11, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onActivityResult(int i, int i2, Intent intent) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzdp.writeInt(i2);
        zzgx.zza(zzdp, intent);
        zzb(12, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void zzae(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(13, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onUserLeaveHint() {
        zzb(14, zzdp());
    }
}
