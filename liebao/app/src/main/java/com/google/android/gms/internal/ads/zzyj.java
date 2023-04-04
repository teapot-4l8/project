package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzyj extends zzgw implements zzyh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void initialize() {
        zzb(1, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void setAppVolume(float f) {
        Parcel zzdp = zzdp();
        zzdp.writeFloat(f);
        zzb(2, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzcd(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(3, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void setAppMuted(boolean z) {
        Parcel zzdp = zzdp();
        zzgx.writeBoolean(zzdp, z);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(6, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final float zzrg() {
        Parcel zza = zza(7, zzdp());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final boolean zzrh() {
        Parcel zza = zza(8, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final String getVersionString() {
        Parcel zza = zza(9, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzce(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(10, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzann zzannVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzannVar);
        zzb(11, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzajt zzajtVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzajtVar);
        zzb(12, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final List<zzajm> zzri() {
        Parcel zza = zza(13, zzdp());
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzajm.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzaat zzaatVar) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, zzaatVar);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzrj() {
        zzb(15, zzdp());
    }
}
