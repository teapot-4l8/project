package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeqc extends zzeqa<zzeqd, zzeqd> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final boolean zza(zzepc zzepcVar) {
        return false;
    }

    private static void zza(Object obj, zzeqd zzeqdVar) {
        ((zzena) obj).zzitn = zzeqdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final void zzak(Object obj) {
        ((zzena) obj).zzitn.zzbhe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ int zzau(zzeqd zzeqdVar) {
        return zzeqdVar.zzbjj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ int zzba(zzeqd zzeqdVar) {
        return zzeqdVar.zzbma();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ zzeqd zzk(zzeqd zzeqdVar, zzeqd zzeqdVar2) {
        zzeqd zzeqdVar3 = zzeqdVar;
        zzeqd zzeqdVar4 = zzeqdVar2;
        return zzeqdVar4.equals(zzeqd.zzbly()) ? zzeqdVar3 : zzeqd.zza(zzeqdVar3, zzeqdVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ void zzc(zzeqd zzeqdVar, zzeqx zzeqxVar) {
        zzeqdVar.zza(zzeqxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ void zza(zzeqd zzeqdVar, zzeqx zzeqxVar) {
        zzeqdVar.zzb(zzeqxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ void zzj(Object obj, zzeqd zzeqdVar) {
        zza(obj, zzeqdVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ zzeqd zzaz(Object obj) {
        zzeqd zzeqdVar = ((zzena) obj).zzitn;
        if (zzeqdVar == zzeqd.zzbly()) {
            zzeqd zzblz = zzeqd.zzblz();
            zza(obj, zzblz);
            return zzblz;
        }
        return zzeqdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ zzeqd zzay(Object obj) {
        return ((zzena) obj).zzitn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ void zzi(Object obj, zzeqd zzeqdVar) {
        zza(obj, zzeqdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqa
    final /* synthetic */ zzeqd zzaq(zzeqd zzeqdVar) {
        zzeqd zzeqdVar2 = zzeqdVar;
        zzeqdVar2.zzbhe();
        return zzeqdVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ zzeqd zzblx() {
        return zzeqd.zzblz();
    }

    @Override // com.google.android.gms.internal.ads.zzeqa
    final /* synthetic */ void zza(zzeqd zzeqdVar, int i, zzeqd zzeqdVar2) {
        zzeqdVar.zzd((i << 3) | 3, zzeqdVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ void zza(zzeqd zzeqdVar, int i, zzelq zzelqVar) {
        zzeqdVar.zzd((i << 3) | 2, zzelqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqa
    final /* synthetic */ void zzb(zzeqd zzeqdVar, int i, long j) {
        zzeqdVar.zzd((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzeqa
    final /* synthetic */ void zzc(zzeqd zzeqdVar, int i, int i2) {
        zzeqdVar.zzd((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzeqa
    public final /* synthetic */ void zza(zzeqd zzeqdVar, int i, long j) {
        zzeqdVar.zzd(i << 3, Long.valueOf(j));
    }
}
