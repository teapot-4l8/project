package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdus extends zzgw implements zzduq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdus(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final boolean zzaw(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(2, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final void zzac(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(4, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final String getVersion() {
        Parcel zza = zza(6, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final void zzad(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(7, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final void zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzgx.zza(zzdp, iObjectWrapper2);
        zzb(8, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str2);
        zzdp.writeString(str3);
        zzdp.writeString(str4);
        zzdp.writeString(str5);
        Parcel zza = zza(9, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str2);
        zzdp.writeString(str3);
        zzdp.writeString(str4);
        zzdp.writeString(str5);
        zzdp.writeString(str6);
        zzdp.writeString(str7);
        zzdp.writeString(str8);
        Parcel zza = zza(10, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzduq
    public final IObjectWrapper zzb(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzgx.zza(zzdp, iObjectWrapper);
        zzdp.writeString(str2);
        zzdp.writeString(str3);
        zzdp.writeString(str4);
        zzdp.writeString(str5);
        zzdp.writeString(str6);
        zzdp.writeString(str7);
        zzdp.writeString(str8);
        Parcel zza = zza(11, zzdp);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}
