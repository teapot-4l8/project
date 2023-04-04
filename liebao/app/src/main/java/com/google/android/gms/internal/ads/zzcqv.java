package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqv implements zzbtc, zzbtq, zzbxb, zzve {
    private final Context context;
    private final zzdtw zzdjf;
    private final zzcsh zzdji;
    private final String zzdvx;
    private final zzdpi zzfbh;
    private final zzdot zzftr;
    private final zzdpz zzgnx;
    private Boolean zzgny;
    private final boolean zzgnz = ((Boolean) zzww.zzra().zzd(zzabq.zzczu)).booleanValue();

    public zzcqv(Context context, zzdpz zzdpzVar, zzdpi zzdpiVar, zzdot zzdotVar, zzcsh zzcshVar, zzdtw zzdtwVar, String str) {
        this.context = context;
        this.zzgnx = zzdpzVar;
        this.zzfbh = zzdpiVar;
        this.zzftr = zzdotVar;
        this.zzdji = zzcshVar;
        this.zzdjf = zzdtwVar;
        this.zzdvx = str;
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        if (this.zzftr.zzhmz) {
            zza(zzgl("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        if (zzari() || this.zzftr.zzhmz) {
            zza(zzgl("impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzaly() {
        if (zzari()) {
            this.zzdjf.zzb(zzgl("adapter_impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzama() {
        if (zzari()) {
            this.zzdjf.zzb(zzgl("adapter_shown"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzl(zzvh zzvhVar) {
        if (this.zzgnz) {
            int i = zzvhVar.errorCode;
            String str = zzvhVar.zzchs;
            if (zzvhVar.zzcht.equals(MobileAds.ERROR_DOMAIN) && zzvhVar.zzchu != null && !zzvhVar.zzchu.zzcht.equals(MobileAds.ERROR_DOMAIN)) {
                i = zzvhVar.zzchu.errorCode;
                str = zzvhVar.zzchu.zzchs;
            }
            String zzgu = this.zzgnx.zzgu(str);
            zzdtx zzw = zzgl("ifts").zzw("reason", "adapter");
            if (i >= 0) {
                zzw.zzw("arec", String.valueOf(i));
            }
            if (zzgu != null) {
                zzw.zzw("areec", zzgu);
            }
            this.zzdjf.zzb(zzw);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zza(zzcbq zzcbqVar) {
        if (this.zzgnz) {
            zzdtx zzw = zzgl("ifts").zzw("reason", "exception");
            if (!TextUtils.isEmpty(zzcbqVar.getMessage())) {
                zzw.zzw(JThirdPlatFormInterface.KEY_MSG, zzcbqVar.getMessage());
            }
            this.zzdjf.zzb(zzw);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzamj() {
        if (this.zzgnz) {
            this.zzdjf.zzb(zzgl("ifts").zzw("reason", "blocked"));
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

    private final zzdtx zzgl(String str) {
        zzdtx zzw = zzdtx.zzgy(str).zza(this.zzfbh, null).zzg(this.zzftr).zzw("request_id", this.zzdvx);
        if (!this.zzftr.zzhmi.isEmpty()) {
            zzw.zzw("ancn", this.zzftr.zzhmi.get(0));
        }
        if (this.zzftr.zzhmz) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            zzw.zzw("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzbd(this.context) ? "online" : "offline");
            zzw.zzw("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()));
            zzw.zzw("offline_ad", "1");
        }
        return zzw;
    }

    private final void zza(zzdtx zzdtxVar) {
        if (this.zzftr.zzhmz) {
            this.zzdji.zza(new zzcso(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis(), this.zzfbh.zzhnt.zzeuy.zzbwe, this.zzdjf.zzc(zzdtxVar), zzcse.zzgui));
            return;
        }
        this.zzdjf.zzb(zzdtxVar);
    }
}
