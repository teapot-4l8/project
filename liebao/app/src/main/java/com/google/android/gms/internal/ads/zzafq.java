package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzafq extends zzgw implements zzafo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final String zzct(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        Parcel zza = zza(1, zzdp);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final zzaes zzcu(String str) {
        zzaes zzaeuVar;
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        Parcel zza = zza(2, zzdp);
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaeuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaes) {
                zzaeuVar = (zzaes) queryLocalInterface;
            } else {
                zzaeuVar = new zzaeu(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final List<String> getAvailableAssetNames() {
        Parcel zza = zza(3, zzdp());
        ArrayList<String> createStringArrayList = zza.createStringArrayList();
        zza.recycle();
        return createStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final String getCustomTemplateId() {
        Parcel zza = zza(4, zzdp());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void performClick(String str) {
        Parcel zzdp = zzdp();
        zzdp.writeString(str);
        zzb(5, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void recordImpression() {
        zzb(6, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final zzzd getVideoController() {
        Parcel zza = zza(7, zzdp());
        zzzd zzk = zzzg.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void destroy() {
        zzb(8, zzdp());
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final IObjectWrapper zztx() {
        Parcel zza = zza(9, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        Parcel zza = zza(10, zzdp);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final IObjectWrapper zzts() {
        Parcel zza = zza(11, zzdp());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final boolean zzty() {
        Parcel zza = zza(12, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final boolean zztz() {
        Parcel zza = zza(13, zzdp());
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void zzq(IObjectWrapper iObjectWrapper) {
        Parcel zzdp = zzdp();
        zzgx.zza(zzdp, iObjectWrapper);
        zzb(14, zzdp);
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void zzua() {
        zzb(15, zzdp());
    }
}
