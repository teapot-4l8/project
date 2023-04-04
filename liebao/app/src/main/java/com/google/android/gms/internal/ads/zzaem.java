package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaem extends zzgw implements zzaek {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaem(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzaek
    public final String getText() {
        Parcel zza = zza(2, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaek
    public final List<zzaes> zztj() {
        Parcel zza = zza(3, zzdp());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }
}
