package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.a.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcuk implements zzcsz<zzcaj> {
    private final Context context;
    private final zzdor zzfti;
    private final Executor zzfur;
    private final zzcbj zzgwq;

    public zzcuk(Context context, Executor executor, zzcbj zzcbjVar, zzdor zzdorVar) {
        this.context = context;
        this.zzgwq = zzcbjVar;
        this.zzfur = executor;
        this.zzfti = zzdorVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return (this.context instanceof Activity) && PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacq.zzj(this.context) && !TextUtils.isEmpty(zzf(zzdotVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<zzcaj> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        String zzf = zzf(zzdotVar);
        return zzebh.zzb(zzebh.zzag(null), new zzear(this, zzf != null ? Uri.parse(zzf) : null, zzdpiVar, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcun
            private final zzdpi zzgvu;
            private final zzcuk zzgwr;
            private final Uri zzgws;
            private final zzdot zzgwt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwr = this;
                this.zzgws = r2;
                this.zzgvu = zzdpiVar;
                this.zzgwt = zzdotVar;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgwr.zza(this.zzgws, this.zzgvu, this.zzgwt, obj);
            }
        }, this.zzfur);
    }

    private static String zzf(zzdot zzdotVar) {
        try {
            return zzdotVar.zzhmk.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(Uri uri, zzdpi zzdpiVar, zzdot zzdotVar, Object obj) {
        try {
            c a2 = new c.a().a();
            a2.f1220a.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzb zzbVar = new com.google.android.gms.ads.internal.overlay.zzb(a2.f1220a, null);
            final zzbbe zzbbeVar = new zzbbe();
            zzcal zza = this.zzgwq.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzcak(new zzcbr(zzbbeVar) { // from class: com.google.android.gms.internal.ads.zzcum
                private final zzbbe zzbwk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbwk = zzbbeVar;
                }

                @Override // com.google.android.gms.internal.ads.zzcbr
                public final void zza(boolean z, Context context) {
                    zzbbe zzbbeVar2 = this.zzbwk;
                    try {
                        com.google.android.gms.ads.internal.zzr.zzku();
                        com.google.android.gms.ads.internal.overlay.zzo.zza(context, (AdOverlayInfoParcel) zzbbeVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzbbeVar.set(new AdOverlayInfoParcel(zzbVar, null, zza.zzaiu(), null, new zzbar(0, 0, false), null));
            this.zzfti.zzyh();
            return zzebh.zzag(zza.zzait());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
