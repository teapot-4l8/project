package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzhc extends zzgw implements zzhb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zza(IObjectWrapper iObjectWrapper, String str) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void log() {
        zzb(3, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zza(int[] iArr) {
        Parcel zzdp = zzdp();
        zzdp.writeIntArray(null);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzc(byte[] bArr) {
        Parcel zzdp = zzdp();
        zzdp.writeByteArray(bArr);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzt(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzu(int i) {
        Parcel zzdp = zzdp();
        zzdp.writeInt(i);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzdp.writeString(null);
        zzb(8, zzdp);
    }
}
