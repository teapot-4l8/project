package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdoh extends zzawe {
    private final String zzbvf;
    private final zzdph zzgbf;
    private final Context zzham;
    private boolean zzhbk = ((Boolean) zzww.zzra().zzd(zzabq.zzcpl)).booleanValue();
    private final zzdnz zzhlq;
    private final zzdnb zzhlr;
    private zzcip zzhls;

    public zzdoh(String str, zzdnz zzdnzVar, Context context, zzdnb zzdnbVar, zzdph zzdphVar) {
        this.zzbvf = str;
        this.zzhlq = zzdnzVar;
        this.zzhlr = zzdnbVar;
        this.zzgbf = zzdphVar;
        this.zzham = context;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final synchronized void zza(zzvq zzvqVar, zzawn zzawnVar) {
        zza(zzvqVar, zzawnVar, zzdpe.zzhnm);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final synchronized void zzb(zzvq zzvqVar, zzawn zzawnVar) {
        zza(zzvqVar, zzawnVar, zzdpe.zzhnn);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        zza(iObjectWrapper, this.zzhbk);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzhls == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Rewarded can not be shown before loaded");
            this.zzhlr.zzk(zzdqh.zza(zzdqj.NOT_READY, null, null));
            return;
        }
        this.zzhls.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzhls == null || this.zzhls.zzall() == null) {
            return null;
        }
        return this.zzhls.zzall().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final boolean isLoaded() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcip zzcipVar = this.zzhls;
        return (zzcipVar == null || zzcipVar.isUsed()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzawg zzawgVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhlr.zzb(zzawgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzawo zzawoVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhlr.zzb(zzawoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzyw zzywVar) {
        if (zzywVar == null) {
            this.zzhlr.zza(null);
        } else {
            this.zzhlr.zza(new zzdok(this, zzywVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcip zzcipVar = this.zzhls;
        return zzcipVar != null ? zzcipVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final zzawa zzsb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcip zzcipVar = this.zzhls;
        if (zzcipVar != null) {
            return zzcipVar.zzsb();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final synchronized void zza(zzaww zzawwVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdph zzdphVar = this.zzgbf;
        zzdphVar.zzear = zzawwVar.zzear;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpz)).booleanValue()) {
            zzdphVar.zzeas = zzawwVar.zzeas;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final zzzc zzkm() {
        zzcip zzcipVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue() && (zzcipVar = this.zzhls) != null) {
            return zzcipVar.zzall();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzyx zzyxVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzhlr.zzd(zzyxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzhbk = z;
    }

    private final synchronized void zza(zzvq zzvqVar, zzawn zzawnVar, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhlr.zzb(zzawnVar);
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzbc(this.zzham) && zzvqVar.zzcip == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Failed to load the ad because app ID is missing.");
            this.zzhlr.zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, null, null));
        } else if (this.zzhls != null) {
        } else {
            zzdoa zzdoaVar = new zzdoa(null);
            this.zzhlq.zzek(i);
            this.zzhlq.zza(zzvqVar, this.zzbvf, zzdoaVar, new zzdoj(this));
        }
    }
}
