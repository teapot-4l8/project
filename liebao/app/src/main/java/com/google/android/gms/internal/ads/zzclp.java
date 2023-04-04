package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclp implements zzbtc, zzbtq, zzbxb, zzve {
    private final Context context;
    private final zzcmb zzdje;
    private final zzcsh zzdji;
    private final zzdpi zzfbh;
    private final zzdot zzftr;
    private final zzdpz zzgnx;
    private Boolean zzgny;
    private final boolean zzgnz = ((Boolean) zzww.zzra().zzd(zzabq.zzczu)).booleanValue();

    public zzclp(Context context, zzdpz zzdpzVar, zzcmb zzcmbVar, zzdpi zzdpiVar, zzdot zzdotVar, zzcsh zzcshVar) {
        this.context = context;
        this.zzgnx = zzdpzVar;
        this.zzdje = zzcmbVar;
        this.zzfbh = zzdpiVar;
        this.zzftr = zzdotVar;
        this.zzdji = zzcshVar;
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        if (this.zzftr.zzhmz) {
            zza(zzgf("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        if (zzari() || this.zzftr.zzhmz) {
            zza(zzgf("impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzaly() {
        if (zzari()) {
            zzgf("adapter_impression").zzarm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzama() {
        if (zzari()) {
            zzgf("adapter_shown").zzarm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzl(zzvh zzvhVar) {
        if (this.zzgnz) {
            zzcma zzgf = zzgf("ifts");
            zzgf.zzs("reason", "adapter");
            int i = zzvhVar.errorCode;
            String str = zzvhVar.zzchs;
            if (zzvhVar.zzcht.equals(MobileAds.ERROR_DOMAIN) && zzvhVar.zzchu != null && !zzvhVar.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
                i = zzvhVar.zzchu.errorCode;
                str = zzvhVar.zzchu.zzchs;
            }
            if (i >= 0) {
                zzgf.zzs("arec", String.valueOf(i));
            }
            String zzgu = this.zzgnx.zzgu(str);
            if (zzgu != null) {
                zzgf.zzs("areec", zzgu);
            }
            zzgf.zzarm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zza(zzcbq zzcbqVar) {
        if (this.zzgnz) {
            zzcma zzgf = zzgf("ifts");
            zzgf.zzs("reason", "exception");
            if (!TextUtils.isEmpty(zzcbqVar.getMessage())) {
                zzgf.zzs(JThirdPlatFormInterface.KEY_MSG, zzcbqVar.getMessage());
            }
            zzgf.zzarm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzamj() {
        if (this.zzgnz) {
            zzcma zzgf = zzgf("ifts");
            zzgf.zzs("reason", "blocked");
            zzgf.zzarm();
        }
    }

    private final boolean zzari() {
        if (this.zzgny == null) {
            synchronized (this) {
                if (this.zzgny == null) {
                    zzabf<String> zzabfVar = zzabq.zzcrr;
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    this.zzgny = Boolean.valueOf(zze((String) zzww.zzra().zzd(zzabfVar), com.google.android.gms.ads.internal.util.zzj.zzbb(this.context)));
                }
            }
        }
        return this.zzgny.booleanValue();
    }

    private static boolean zze(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    private final zzcma zzgf(String str) {
        zzcma zzc = this.zzdje.zzarp().zza(this.zzfbh.zzhnt.zzeuy).zzc(this.zzftr);
        zzc.zzs("action", str);
        if (!this.zzftr.zzhmi.isEmpty()) {
            zzc.zzs("ancn", this.zzftr.zzhmi.get(0));
        }
        if (this.zzftr.zzhmz) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            zzc.zzs("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzbd(this.context) ? "online" : "offline");
            zzc.zzs("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()));
            zzc.zzs("offline_ad", "1");
        }
        return zzc;
    }

    private final void zza(zzcma zzcmaVar) {
        if (this.zzftr.zzhmz) {
            this.zzdji.zza(new zzcso(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis(), this.zzfbh.zzhnt.zzeuy.zzbwe, zzcmaVar.zzarn(), zzcse.zzgui));
            return;
        }
        zzcmaVar.zzarm();
    }
}
