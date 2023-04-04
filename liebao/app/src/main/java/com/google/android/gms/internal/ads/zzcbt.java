package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.b.a;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbt implements com.google.android.gms.ads.internal.overlay.zzp, zzbuj {
    private final Context context;
    private final zzbar zzbpx;
    private final zzbfi zzdkm;
    private final zzdot zzeux;
    private IObjectWrapper zzfya;
    private final zzuh.zza.EnumC0120zza zzgdw;

    public zzcbt(Context context, zzbfi zzbfiVar, zzdot zzdotVar, zzbar zzbarVar, zzuh.zza.EnumC0120zza enumC0120zza) {
        this.context = context;
        this.zzdkm = zzbfiVar;
        this.zzeux = zzdotVar;
        this.zzbpx = zzbarVar;
        this.zzgdw = enumC0120zza;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        zzase zzaseVar;
        zzase zzaseVar2;
        zzasc zzascVar;
        if ((this.zzgdw == zzuh.zza.EnumC0120zza.REWARD_BASED_VIDEO_AD || this.zzgdw == zzuh.zza.EnumC0120zza.INTERSTITIAL || this.zzgdw == zzuh.zza.EnumC0120zza.APP_OPEN) && this.zzeux.zzdyg && this.zzdkm != null && com.google.android.gms.ads.internal.zzr.zzlk().zzm(this.context)) {
            int i = this.zzbpx.zzeka;
            int i2 = this.zzbpx.zzekb;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            String sb2 = sb.toString();
            String videoEventsOwner = this.zzeux.zzhms.getVideoEventsOwner();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwk)).booleanValue()) {
                if (this.zzeux.zzhms.getMediaType() == OmidMediaType.VIDEO) {
                    zzascVar = zzasc.VIDEO;
                    zzaseVar2 = zzase.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.zzeux.zzhmt == 2) {
                        zzaseVar = zzase.UNSPECIFIED;
                    } else {
                        zzaseVar = zzase.BEGIN_TO_RENDER;
                    }
                    zzaseVar2 = zzaseVar;
                    zzascVar = zzasc.HTML_DISPLAY;
                }
                this.zzfya = com.google.android.gms.ads.internal.zzr.zzlk().zza(sb2, this.zzdkm.getWebView(), "", "javascript", videoEventsOwner, zzaseVar2, zzascVar, this.zzeux.zzcig);
            } else {
                this.zzfya = com.google.android.gms.ads.internal.zzr.zzlk().zza(sb2, this.zzdkm.getWebView(), "", "javascript", videoEventsOwner);
            }
            if (this.zzfya == null || this.zzdkm.getView() == null) {
                return;
            }
            com.google.android.gms.ads.internal.zzr.zzlk().zza(this.zzfya, this.zzdkm.getView());
            this.zzdkm.zzar(this.zzfya);
            com.google.android.gms.ads.internal.zzr.zzlk().zzac(this.zzfya);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwn)).booleanValue()) {
                this.zzdkm.zza("onSdkLoaded", new a());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzfya = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
        zzbfi zzbfiVar;
        if (this.zzfya == null || (zzbfiVar = this.zzdkm) == null) {
            return;
        }
        zzbfiVar.zza("onSdkImpression", new a());
    }
}
