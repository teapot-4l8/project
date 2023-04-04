package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdpm {
    public final zzvt zzbpy;
    public final zzaei zzdpr;
    public final zzajy zzdxd;
    public final int zzhby;
    public final boolean zzhdn;
    public final zzye zzhnv;
    public final zzaaz zzhnw;
    public final zzvq zzhnx;
    public final String zzhny;
    public final ArrayList<String> zzhnz;
    public final ArrayList<String> zzhoa;
    public final zzwc zzhob;
    public final AdManagerAdViewOptions zzhoc;
    public final PublisherAdViewOptions zzhod;
    public final zzxy zzhoe;
    public final zzdoz zzhof;

    private zzdpm(zzdpo zzdpoVar) {
        zzaaz zzaazVar;
        zzaei zzq;
        this.zzbpy = zzdpo.zza(zzdpoVar);
        this.zzhny = zzdpo.zzb(zzdpoVar);
        this.zzhnv = zzdpo.zzc(zzdpoVar);
        this.zzhnx = new zzvq(zzdpo.zzn(zzdpoVar).versionCode, zzdpo.zzn(zzdpoVar).zzcia, zzdpo.zzn(zzdpoVar).extras, zzdpo.zzn(zzdpoVar).zzcib, zzdpo.zzn(zzdpoVar).zzcic, zzdpo.zzn(zzdpoVar).zzcid, zzdpo.zzn(zzdpoVar).zzadv, zzdpo.zzn(zzdpoVar).zzbns || zzdpo.zzo(zzdpoVar), zzdpo.zzn(zzdpoVar).zzcie, zzdpo.zzn(zzdpoVar).zzcif, zzdpo.zzn(zzdpoVar).zzng, zzdpo.zzn(zzdpoVar).zzcig, zzdpo.zzn(zzdpoVar).zzcih, zzdpo.zzn(zzdpoVar).zzcii, zzdpo.zzn(zzdpoVar).zzcij, zzdpo.zzn(zzdpoVar).zzcik, zzdpo.zzn(zzdpoVar).zzcil, zzdpo.zzn(zzdpoVar).zzcim, zzdpo.zzn(zzdpoVar).zzcip, zzdpo.zzn(zzdpoVar).zzadw, zzdpo.zzn(zzdpoVar).zzadx, zzdpo.zzn(zzdpoVar).zzcin, com.google.android.gms.ads.internal.util.zzj.zzdl(zzdpo.zzn(zzdpoVar).zzcio));
        if (zzdpo.zzp(zzdpoVar) != null) {
            zzaazVar = zzdpo.zzp(zzdpoVar);
        } else {
            zzaazVar = zzdpo.zzq(zzdpoVar) != null ? zzdpo.zzq(zzdpoVar).zzdgy : null;
        }
        this.zzhnw = zzaazVar;
        this.zzhnz = zzdpo.zzd(zzdpoVar);
        this.zzhoa = zzdpo.zze(zzdpoVar);
        if (zzdpo.zzd(zzdpoVar) == null) {
            zzq = null;
        } else if (zzdpo.zzq(zzdpoVar) == null) {
            zzq = new zzaei(new NativeAdOptions.Builder().build());
        } else {
            zzq = zzdpo.zzq(zzdpoVar);
        }
        this.zzdpr = zzq;
        this.zzhob = zzdpo.zzf(zzdpoVar);
        this.zzhby = zzdpo.zzg(zzdpoVar);
        this.zzhoc = zzdpo.zzh(zzdpoVar);
        this.zzhod = zzdpo.zzi(zzdpoVar);
        this.zzhoe = zzdpo.zzj(zzdpoVar);
        this.zzdxd = zzdpo.zzk(zzdpoVar);
        this.zzhof = new zzdoz(zzdpo.zzl(zzdpoVar));
        this.zzhdn = zzdpo.zzm(zzdpoVar);
    }

    public final zzagm zzawb() {
        if (this.zzhod == null && this.zzhoc == null) {
            return null;
        }
        PublisherAdViewOptions publisherAdViewOptions = this.zzhod;
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzjv();
        }
        return this.zzhoc.zzjv();
    }
}
