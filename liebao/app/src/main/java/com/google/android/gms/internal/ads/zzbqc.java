package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzbqc implements zzear {
    private final zzcpk zzfze;

    private zzbqc(zzcpk zzcpkVar) {
        this.zzfze = zzcpkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzear zza(zzcpk zzcpkVar) {
        return new zzbqc(zzcpkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final zzebt zzf(Object obj) {
        return this.zzfze.zzh((zzauj) obj);
    }
}
