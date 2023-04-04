package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbik extends zzdhw {
    private zzesn<String> zzfbr;
    private zzesn<zzcln> zzfbt;
    private zzesn<Map<zzdth, zzcln>> zzfbv;
    private zzesn<Set<zzbzl<zzdtm>>> zzfbx;
    private zzesn<Set<zzbzl<zzdtm>>> zzfcl;
    private zzesn zzfcm;
    private zzesn<zzdtg> zzfcn;
    private final /* synthetic */ zzbie zzfhy;
    private final zzdjb zzfmc;
    private zzesn<Integer> zzfmd;
    private zzesn<zzdhs> zzfme;
    private zzesn<String> zzfmf;
    private zzesn<zzdic> zzfmg;
    private zzesn<zzdig> zzfmh;
    private zzesn<zzdim> zzfmi;
    private zzesn<zzdir> zzfmj;
    private zzesn<zzdja> zzfmk;
    private zzesn<zzdjm> zzfml;
    private zzesn<zzcln> zzfmm;
    private zzesn<zzcln> zzfmn;
    private zzesn<zzcln> zzfmo;

    private zzbik(zzbie zzbieVar, zzdjb zzdjbVar) {
        zzbkh zzbkhVar;
        zzesn zzesnVar;
        zzesn zzesnVar2;
        zzbhw zzbhwVar;
        zzesn zzesnVar3;
        zzbkh zzbkhVar2;
        zzesn zzesnVar4;
        zzesn zzesnVar5;
        zzesn zzesnVar6;
        zzbkb zzbkbVar;
        zzesn zzesnVar7;
        zzbkd zzbkdVar;
        zzbkf zzbkfVar;
        zzesn zzesnVar8;
        zzesn zzesnVar9;
        zzesn zzesnVar10;
        zzesn zzesnVar11;
        this.zzfhy = zzbieVar;
        this.zzfmc = zzdjbVar;
        this.zzfmd = new zzdjd(zzdjbVar);
        zzbkhVar = zzbkg.zzfte;
        zzesnVar = this.zzfhy.zzeyx;
        zzesnVar2 = this.zzfhy.zzezd;
        this.zzfme = new zzdht(zzbkhVar, zzesnVar, zzesnVar2, zzdsg.zzaxv(), this.zzfmd);
        this.zzfmf = new zzdje(zzdjbVar);
        zzbhwVar = zzbhv.zzeyo;
        zzesnVar3 = this.zzfhy.zzeyx;
        this.zzfmg = new zzdie(zzbhwVar, zzesnVar3, this.zzfmf, zzdsg.zzaxv());
        zzbkhVar2 = zzbkg.zzfte;
        zzesn<Integer> zzesnVar12 = this.zzfmd;
        zzesnVar4 = this.zzfhy.zzeyx;
        zzesnVar5 = this.zzfhy.zzfah;
        zzesnVar6 = this.zzfhy.zzezd;
        this.zzfmh = new zzdik(zzbkhVar2, zzesnVar12, zzesnVar4, zzesnVar5, zzesnVar6, zzdsg.zzaxv());
        zzbkbVar = zzbka.zzftb;
        zzdsg zzaxv = zzdsg.zzaxv();
        zzesnVar7 = this.zzfhy.zzeyx;
        this.zzfmi = new zzdio(zzbkbVar, zzaxv, zzesnVar7);
        zzbkdVar = zzbkc.zzftc;
        this.zzfmj = new zzdit(zzbkdVar, zzdsg.zzaxv(), this.zzfmf);
        zzbkfVar = zzbke.zzftd;
        zzesnVar8 = this.zzfhy.zzezd;
        zzesnVar9 = this.zzfhy.zzeyx;
        this.zzfmk = new zzdjc(zzbkfVar, zzesnVar8, zzesnVar9);
        this.zzfml = new zzdjo(zzdsg.zzaxv());
        this.zzfbr = new zzdjg(zzdjbVar);
        this.zzfbt = zzesb.zzas(zzclc.zzarb());
        this.zzfmm = zzesb.zzas(zzcla.zzara());
        this.zzfmn = zzesb.zzas(zzcle.zzard());
        this.zzfmo = zzesb.zzas(zzclg.zzarf());
        this.zzfbv = ((zzese) ((zzese) ((zzese) ((zzese) zzesc.zzip(4).zza(zzdth.GMS_SIGNALS, this.zzfbt)).zza(zzdth.BUILD_URL, this.zzfmm)).zza(zzdth.HTTP, this.zzfmn)).zza(zzdth.PRE_PROCESS, this.zzfmo)).zzbnm();
        zzesn<String> zzesnVar13 = this.zzfbr;
        zzesnVar10 = this.zzfhy.zzeyx;
        this.zzfbx = zzesb.zzas(new zzcli(zzesnVar13, zzesnVar10, zzdsg.zzaxv(), this.zzfbv));
        zzesj zzbnn = zzesj.zzau(0, 1).zzav(this.zzfbx).zzbnn();
        this.zzfcl = zzbnn;
        this.zzfcm = zzdto.zzar(zzbnn);
        zzdsg zzaxv2 = zzdsg.zzaxv();
        zzesnVar11 = this.zzfhy.zzezd;
        this.zzfcn = zzesb.zzas(zzdtp.zzad(zzaxv2, zzesnVar11, this.zzfcm));
    }

    private final zzdiv zzahs() {
        return new zzdiv((zzabd) zzesg.zzbd(new zzabd()), zzdsg.zzaxw(), (List) zzesg.zzbd(this.zzfmc.zzaux()));
    }

    private final zzdhy zzaht() {
        return new zzdhy(zzbkh.zzajq(), zzdsg.zzaxw(), (String) zzesg.zzbd(this.zzfmc.zzauv()), this.zzfmc.zzauw(), this.zzfmc.zzauz());
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final zzdhd<JSONObject> zzahu() {
        zzesn zzesnVar;
        zzesn zzesnVar2;
        zzbhg zzbhgVar;
        zzesn zzesnVar3;
        zzbhg zzbhgVar2;
        zzesn zzesnVar4;
        zzesn zzesnVar5;
        zzesn zzesnVar6;
        zzbhg zzbhgVar3;
        zzbhg zzbhgVar4;
        zzbhg zzbhgVar5;
        zzesn zzesnVar7;
        zzesn zzesnVar8;
        zzesn zzesnVar9;
        zzebs zzaxw = zzdsg.zzaxw();
        zzdir zzdirVar = new zzdir(zzbkd.zzajm(), zzdsg.zzaxw(), zzdje.zzb(this.zzfmc));
        zzesnVar = this.zzfhy.zzezd;
        zzdhe zzdheVar = (zzdhe) zzesg.zzbd(new zzdfu(zzdirVar, 0L, (ScheduledExecutorService) zzesnVar.get()));
        zzask zzajo = zzbkf.zzajo();
        zzesnVar2 = this.zzfhy.zzezd;
        zzbhgVar = this.zzfhy.zzeys;
        zzdja zzdjaVar = new zzdja(zzajo, (ScheduledExecutorService) zzesnVar2.get(), zzbhj.zza(zzbhgVar));
        zzesnVar3 = this.zzfhy.zzezd;
        zzdhe zzdheVar2 = (zzdhe) zzesg.zzbd(new zzdfu(zzdjaVar, ((Long) zzww.zzra().zzd(zzabq.zzcuq)).longValue(), (ScheduledExecutorService) zzesnVar3.get()));
        zzazo zzajq = zzbkh.zzajq();
        zzbhgVar2 = this.zzfhy.zzeys;
        Context zza = zzbhj.zza(zzbhgVar2);
        zzesnVar4 = this.zzfhy.zzezd;
        zzdhs zzdhsVar = new zzdhs(zzajq, zza, (ScheduledExecutorService) zzesnVar4.get(), zzdsg.zzaxw(), this.zzfmc.zzauz());
        zzesnVar5 = this.zzfhy.zzezd;
        zzdhe zzdheVar3 = (zzdhe) zzesg.zzbd(new zzdfu(zzdhsVar, 0L, (ScheduledExecutorService) zzesnVar5.get()));
        zzdjm zzdjmVar = new zzdjm(zzdsg.zzaxw());
        zzesnVar6 = this.zzfhy.zzezd;
        zzdhe zzdheVar4 = (zzdhe) zzesg.zzbd(new zzdfu(zzdjmVar, 0L, (ScheduledExecutorService) zzesnVar6.get()));
        zzdhe zzdheVar5 = (zzdhe) zzesg.zzbd(zzdjf.zzava());
        zzbhgVar3 = this.zzfhy.zzeys;
        zzdic zzdicVar = new zzdic(null, zzbhj.zza(zzbhgVar3), zzdje.zzb(this.zzfmc), zzdsg.zzaxw());
        zztp zzajk = zzbkb.zzajk();
        zzebs zzaxw2 = zzdsg.zzaxw();
        zzbhgVar4 = this.zzfhy.zzeys;
        zzazo zzajq2 = zzbkh.zzajq();
        int zzauz = this.zzfmc.zzauz();
        zzbhgVar5 = this.zzfhy.zzeys;
        Context zza2 = zzbhj.zza(zzbhgVar5);
        zzesnVar7 = this.zzfhy.zzfah;
        zzazs zzazsVar = (zzazs) zzesnVar7.get();
        zzesnVar8 = this.zzfhy.zzezd;
        zzesnVar9 = this.zzfhy.zzfbe;
        return zzdhi.zza(zzaxw, zzdzd.zza(zzdheVar, zzdheVar2, zzdheVar3, zzdheVar4, zzdheVar5, zzdicVar, new zzdim(zzajk, zzaxw2, zzbhj.zza(zzbhgVar4)), zzahs(), zzaht(), new zzdig(zzajq2, zzauz, zza2, zzazsVar, (ScheduledExecutorService) zzesnVar8.get(), zzdsg.zzaxw()), (zzdhe) zzesnVar9.get()));
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final zzdhd<JSONObject> zzahv() {
        zzesn zzesnVar;
        zzesn zzesnVar2;
        zzazn zzajm = zzbkd.zzajm();
        zzesnVar = this.zzfhy.zzfbe;
        Object obj = zzesnVar.get();
        zzdhy zzaht = zzaht();
        zzdiv zzahs = zzahs();
        zzeru zzat = zzesb.zzat(this.zzfme);
        zzeru zzat2 = zzesb.zzat(this.zzfmg);
        zzeru zzat3 = zzesb.zzat(this.zzfmh);
        zzeru zzat4 = zzesb.zzat(this.zzfmi);
        zzeru zzat5 = zzesb.zzat(this.zzfmj);
        zzeru zzat6 = zzesb.zzat(this.zzfmk);
        zzeru zzat7 = zzesb.zzat(this.zzfml);
        zzebs zzaxw = zzdsg.zzaxw();
        zzesnVar2 = this.zzfhy.zzezd;
        return zzdjk.zza(zzajm, obj, zzaht, zzahs, zzat, zzat2, zzat3, zzat4, zzat5, zzat6, zzat7, zzaxw, (ScheduledExecutorService) zzesnVar2.get());
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final zzdtg zzahw() {
        return this.zzfcn.get();
    }
}
