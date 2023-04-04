package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzblb implements zzebi<String> {
    private final /* synthetic */ zzbkz zzftp;
    private final /* synthetic */ String zzfue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblb(zzbkz zzbkzVar, String str) {
        this.zzftp = zzbkzVar;
        this.zzfue = str;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzdpu zzdpuVar;
        zzdun zzdunVar;
        zzdpi zzdpiVar;
        zzdot zzdotVar;
        zzdot zzdotVar2;
        zzdpuVar = this.zzftp.zzfts;
        zzdunVar = this.zzftp.zzftm;
        zzdpiVar = this.zzftp.zzftl;
        zzdotVar = this.zzftp.zzftr;
        String str = this.zzfue;
        zzdotVar2 = this.zzftp.zzftr;
        zzdpuVar.zzj(zzdunVar.zza(zzdpiVar, zzdotVar, false, str, null, zzdotVar2.zzdnb));
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(String str) {
        zzdpu zzdpuVar;
        zzdun zzdunVar;
        zzdpi zzdpiVar;
        zzdot zzdotVar;
        zzdot zzdotVar2;
        String str2 = str;
        zzdpuVar = this.zzftp.zzfts;
        zzdunVar = this.zzftp.zzftm;
        zzdpiVar = this.zzftp.zzftl;
        zzdotVar = this.zzftp.zzftr;
        String str3 = this.zzfue;
        zzdotVar2 = this.zzftp.zzftr;
        zzdpuVar.zzj(zzdunVar.zza(zzdpiVar, zzdotVar, false, str3, str2, zzdotVar2.zzdnb));
    }
}
