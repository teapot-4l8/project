package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbiw implements zzbop {
    private zzesn<zzdot> zzfia;
    private zzesn<Set<zzbzl<zzbtp>>> zzfid;
    private zzesn<zzbts> zzfie;
    private zzesn<zzbvl> zzfif;
    private zzesn<zzdpi> zzfih;
    private zzesn<Set<zzbzl<zzbuj>>> zzfjm;
    private zzesn<zzbui> zzfjn;
    private zzesn<String> zzfkh;
    private zzesn<zzbsp> zzfki;
    private zzesn<zzbpf> zzfkj;
    private final /* synthetic */ zzbiu zzfpm;
    private final zzboo zzfqe;
    private zzesn<zzagm> zzfqf;
    private zzesn<Runnable> zzfqg;
    private zzesn<zzbok> zzfqh;

    private zzbiw(zzbiu zzbiuVar, zzbps zzbpsVar, zzboo zzbooVar) {
        zzesn zzesnVar;
        this.zzfpm = zzbiuVar;
        this.zzfqe = zzbooVar;
        this.zzfih = zzbpw.zze(zzbpsVar);
        this.zzfia = zzbpv.zzc(zzbpsVar);
        zzesj zzbnn = zzesj.zzau(0, 2).zzav(zzbiu.zzm(this.zzfpm)).zzav(zzbiu.zzl(this.zzfpm)).zzbnn();
        this.zzfid = zzbnn;
        this.zzfie = zzesb.zzas(zzbtv.zzj(zzbnn));
        zzesj zzbnn2 = zzesj.zzau(4, 3).zzau(zzbiu.zzh(this.zzfpm)).zzau(zzbiu.zzg(this.zzfpm)).zzau(zzbiu.zzf(this.zzfpm)).zzav(zzbiu.zzak(this.zzfpm)).zzav(zzbiu.zzaj(this.zzfpm)).zzav(zzbiu.zzai(this.zzfpm)).zzau(zzbiu.zzc(this.zzfpm)).zzbnn();
        this.zzfjm = zzbnn2;
        this.zzfjn = zzesb.zzas(zzbuk.zzl(zzbnn2));
        zzbpu zza = zzbpu.zza(zzbpsVar);
        this.zzfkh = zza;
        this.zzfki = zzbss.zzm(this.zzfia, zza, zzbiu.zzi(this.zzfpm));
        this.zzfif = zzesb.zzas(zzbwr.zzamp());
        this.zzfkj = zzbqz.zza(this.zzfih, this.zzfia, this.zzfie, this.zzfjn, zzbiu.zzal(this.zzfpm), this.zzfki, this.zzfif);
        this.zzfqf = new zzboq(zzbooVar);
        zzbor zzborVar = new zzbor(zzbooVar);
        this.zzfqg = zzborVar;
        zzesn<zzbpf> zzesnVar2 = this.zzfkj;
        zzesn<zzagm> zzesnVar3 = this.zzfqf;
        zzesnVar = this.zzfpm.zzfhy.zzezf;
        this.zzfqh = zzesb.zzas(new zzbot(zzesnVar2, zzesnVar3, zzborVar, zzesnVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbne zzaio() {
        return (zzbne) zzesg.zzbd(this.zzfqh.get());
    }
}
