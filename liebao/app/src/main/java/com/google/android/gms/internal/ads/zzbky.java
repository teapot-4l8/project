package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbky implements zzebi<String> {
    private final /* synthetic */ zzbkz zzftp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbky(zzbkz zzbkzVar) {
        this.zzftp = zzbkzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzdpu zzdpuVar;
        zzdun zzdunVar;
        zzdpi zzdpiVar;
        zzdot zzdotVar;
        zzdot zzdotVar2;
        Context context;
        int i;
        zzdpuVar = this.zzftp.zzfts;
        zzdunVar = this.zzftp.zzftm;
        zzdpiVar = this.zzftp.zzftl;
        zzdotVar = this.zzftp.zzftr;
        zzdotVar2 = this.zzftp.zzftr;
        List<String> zza = zzdunVar.zza(zzdpiVar, zzdotVar, false, "", "failure_click_attok", zzdotVar2.zzdna);
        com.google.android.gms.ads.internal.zzr.zzkv();
        context = this.zzftp.context;
        if (com.google.android.gms.ads.internal.util.zzj.zzbd(context)) {
            i = zzcse.zzgui;
        } else {
            i = zzcse.zzguh;
        }
        zzdpuVar.zza(zza, i);
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(String str) {
        zzdpu zzdpuVar;
        zzdun zzdunVar;
        zzdpi zzdpiVar;
        zzdot zzdotVar;
        zzdot zzdotVar2;
        Context context;
        int i;
        String str2 = str;
        zzdpuVar = this.zzftp.zzfts;
        zzdunVar = this.zzftp.zzftm;
        zzdpiVar = this.zzftp.zzftl;
        zzdotVar = this.zzftp.zzftr;
        zzdotVar2 = this.zzftp.zzftr;
        List<String> zza = zzdunVar.zza(zzdpiVar, zzdotVar, false, "", str2, zzdotVar2.zzdna);
        com.google.android.gms.ads.internal.zzr.zzkv();
        context = this.zzftp.context;
        if (com.google.android.gms.ads.internal.util.zzj.zzbd(context)) {
            i = zzcse.zzgui;
        } else {
            i = zzcse.zzguh;
        }
        zzdpuVar.zza(zza, i);
    }
}
