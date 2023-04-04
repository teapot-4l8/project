package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzzk extends zzgw implements zzzi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoStart() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoPlay() {
        zzb(2, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoPause() {
        zzb(3, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoEnd() {
        zzb(4, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzzi
    public final void onVideoMute(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(5, zzdp);
    }
}
