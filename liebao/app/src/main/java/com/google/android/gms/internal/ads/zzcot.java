package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcot implements zzebi<zzdpi> {
    private final /* synthetic */ zzcoo zzgqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcot(zzcoo zzcooVar) {
        this.zzgqx = zzcooVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        Pattern pattern;
        zzcrr zzcrrVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue()) {
            pattern = zzcoo.zzgqv;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzcrrVar = this.zzgqx.zzgqu;
                zzcrrVar.zzei(Integer.parseInt(group));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzdpi zzdpiVar) {
        zzcrr zzcrrVar;
        zzcrr zzcrrVar2;
        zzdpi zzdpiVar2 = zzdpiVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue()) {
            zzcrrVar = this.zzgqx.zzgqu;
            zzcrrVar.zzei(zzdpiVar2.zzhnt.zzeuy.responseCode);
            zzcrrVar2 = this.zzgqx.zzgqu;
            zzcrrVar2.zzeo(zzdpiVar2.zzhnt.zzeuy.zzgss);
        }
    }
}
