package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdpo {
    private boolean zzbns;
    private zzvt zzbpy;
    private zzaei zzdpr;
    private zzajy zzdxd;
    private zzye zzhnv;
    private zzaaz zzhnw;
    private zzvq zzhnx;
    private String zzhny;
    private ArrayList<String> zzhnz;
    private ArrayList<String> zzhoa;
    private zzwc zzhob;
    private AdManagerAdViewOptions zzhoc;
    private PublisherAdViewOptions zzhod;
    private zzxy zzhoe;
    private int zzhby = 1;
    private zzdpb zzhog = new zzdpb();
    private boolean zzhdn = false;

    public final zzdpo zzh(zzvq zzvqVar) {
        this.zzhnx = zzvqVar;
        return this;
    }

    public final zzvq zzawd() {
        return this.zzhnx;
    }

    public final zzdpo zzg(zzvt zzvtVar) {
        this.zzbpy = zzvtVar;
        return this;
    }

    public final zzdpo zzbr(boolean z) {
        this.zzhdn = z;
        return this;
    }

    public final zzvt zzkk() {
        return this.zzbpy;
    }

    public final zzdpo zzc(zzye zzyeVar) {
        this.zzhnv = zzyeVar;
        return this;
    }

    public final zzdpo zzgt(String str) {
        this.zzhny = str;
        return this;
    }

    public final String zzawe() {
        return this.zzhny;
    }

    public final zzdpo zzc(zzaaz zzaazVar) {
        this.zzhnw = zzaazVar;
        return this;
    }

    public final zzdpb zzawf() {
        return this.zzhog;
    }

    public final zzdpo zzbs(boolean z) {
        this.zzbns = z;
        return this;
    }

    public final zzdpo zzem(int i) {
        this.zzhby = i;
        return this;
    }

    public final zzdpo zzc(ArrayList<String> arrayList) {
        this.zzhnz = arrayList;
        return this;
    }

    public final zzdpo zzd(ArrayList<String> arrayList) {
        this.zzhoa = arrayList;
        return this;
    }

    public final zzdpo zzd(zzaei zzaeiVar) {
        this.zzdpr = zzaeiVar;
        return this;
    }

    public final zzdpo zzb(zzwc zzwcVar) {
        this.zzhob = zzwcVar;
        return this;
    }

    public final zzdpo zzb(zzajy zzajyVar) {
        this.zzdxd = zzajyVar;
        this.zzhnw = new zzaaz(false, true, false);
        return this;
    }

    public final zzdpo zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhod = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbns = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzhoe = publisherAdViewOptions.zzjz();
        }
        return this;
    }

    public final zzdpo zzb(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzhoc = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zzbns = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzdpo zzc(zzdpm zzdpmVar) {
        this.zzhog.zza(zzdpmVar.zzhof);
        this.zzhnx = zzdpmVar.zzhnx;
        this.zzbpy = zzdpmVar.zzbpy;
        this.zzhnv = zzdpmVar.zzhnv;
        this.zzhny = zzdpmVar.zzhny;
        this.zzhnw = zzdpmVar.zzhnw;
        this.zzhnz = zzdpmVar.zzhnz;
        this.zzhoa = zzdpmVar.zzhoa;
        this.zzdpr = zzdpmVar.zzdpr;
        this.zzhob = zzdpmVar.zzhob;
        zzdpo zzb = zzb(zzdpmVar.zzhoc).zzb(zzdpmVar.zzhod);
        zzb.zzhdn = zzdpmVar.zzhdn;
        return zzb;
    }

    public final zzdpm zzawg() {
        Preconditions.checkNotNull(this.zzhny, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzbpy, "ad size must not be null");
        Preconditions.checkNotNull(this.zzhnx, "ad request must not be null");
        return new zzdpm(this);
    }

    public final boolean zzawh() {
        return this.zzhdn;
    }

    public static /* synthetic */ zzvt zza(zzdpo zzdpoVar) {
        return zzdpoVar.zzbpy;
    }

    public static /* synthetic */ String zzb(zzdpo zzdpoVar) {
        return zzdpoVar.zzhny;
    }

    public static /* synthetic */ zzye zzc(zzdpo zzdpoVar) {
        return zzdpoVar.zzhnv;
    }

    public static /* synthetic */ ArrayList zzd(zzdpo zzdpoVar) {
        return zzdpoVar.zzhnz;
    }

    public static /* synthetic */ ArrayList zze(zzdpo zzdpoVar) {
        return zzdpoVar.zzhoa;
    }

    public static /* synthetic */ zzwc zzf(zzdpo zzdpoVar) {
        return zzdpoVar.zzhob;
    }

    public static /* synthetic */ int zzg(zzdpo zzdpoVar) {
        return zzdpoVar.zzhby;
    }

    public static /* synthetic */ AdManagerAdViewOptions zzh(zzdpo zzdpoVar) {
        return zzdpoVar.zzhoc;
    }

    public static /* synthetic */ PublisherAdViewOptions zzi(zzdpo zzdpoVar) {
        return zzdpoVar.zzhod;
    }

    public static /* synthetic */ zzxy zzj(zzdpo zzdpoVar) {
        return zzdpoVar.zzhoe;
    }

    public static /* synthetic */ zzajy zzk(zzdpo zzdpoVar) {
        return zzdpoVar.zzdxd;
    }

    public static /* synthetic */ zzdpb zzl(zzdpo zzdpoVar) {
        return zzdpoVar.zzhog;
    }

    public static /* synthetic */ boolean zzm(zzdpo zzdpoVar) {
        return zzdpoVar.zzhdn;
    }

    public static /* synthetic */ zzvq zzn(zzdpo zzdpoVar) {
        return zzdpoVar.zzhnx;
    }

    public static /* synthetic */ boolean zzo(zzdpo zzdpoVar) {
        return zzdpoVar.zzbns;
    }

    public static /* synthetic */ zzaaz zzp(zzdpo zzdpoVar) {
        return zzdpoVar.zzhnw;
    }

    public static /* synthetic */ zzaei zzq(zzdpo zzdpoVar) {
        return zzdpoVar.zzdpr;
    }
}
