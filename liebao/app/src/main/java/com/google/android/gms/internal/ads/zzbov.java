package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.b.a;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbov implements zzbtq, zzbuj {
    private final Context context;
    private final zzbar zzbpx;
    private final zzbfi zzdkm;
    private final zzdot zzeux;
    private IObjectWrapper zzfya;
    private boolean zzfyb;

    public zzbov(Context context, zzbfi zzbfiVar, zzdot zzdotVar, zzbar zzbarVar) {
        this.context = context;
        this.zzdkm = zzbfiVar;
        this.zzeux = zzdotVar;
        this.zzbpx = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        if (this.zzfyb) {
            return;
        }
        zzalh();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final synchronized void onAdImpression() {
        if (!this.zzfyb) {
            zzalh();
        }
        if (this.zzeux.zzdyg && this.zzfya != null && this.zzdkm != null) {
            this.zzdkm.zza("onSdkImpression", new a());
        }
    }

    private final synchronized void zzalh() {
        zzasc zzascVar;
        zzase zzaseVar;
        if (this.zzeux.zzdyg) {
            if (this.zzdkm == null) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzr.zzlk().zzm(this.context)) {
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
                        zzaseVar = zzase.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzascVar = zzasc.HTML_DISPLAY;
                        if (this.zzeux.zzhma == 1) {
                            zzaseVar = zzase.ONE_PIXEL;
                        } else {
                            zzaseVar = zzase.BEGIN_TO_RENDER;
                        }
                    }
                    this.zzfya = com.google.android.gms.ads.internal.zzr.zzlk().zza(sb2, this.zzdkm.getWebView(), "", "javascript", videoEventsOwner, zzaseVar, zzascVar, this.zzeux.zzcig);
                } else {
                    this.zzfya = com.google.android.gms.ads.internal.zzr.zzlk().zza(sb2, this.zzdkm.getWebView(), "", "javascript", videoEventsOwner);
                }
                View view = this.zzdkm.getView();
                if (this.zzfya != null && view != null) {
                    com.google.android.gms.ads.internal.zzr.zzlk().zza(this.zzfya, view);
                    this.zzdkm.zzar(this.zzfya);
                    com.google.android.gms.ads.internal.zzr.zzlk().zzac(this.zzfya);
                    this.zzfyb = true;
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcwn)).booleanValue()) {
                        this.zzdkm.zza("onSdkLoaded", new a());
                    }
                }
            }
        }
    }
}
