package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.zzuh;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbx implements zzbsy, zzbza {
    private final Context context;
    private final View view;
    private final zzayd zzbrf;
    private final zzaya zzfyl;
    private final zzuh.zza.EnumC0120zza zzgdw;
    private String zzgdy;

    public zzcbx(zzaya zzayaVar, Context context, zzayd zzaydVar, View view, zzuh.zza.EnumC0120zza enumC0120zza) {
        this.zzfyl = zzayaVar;
        this.context = context;
        this.zzbrf = zzaydVar;
        this.view = view;
        this.zzgdw = enumC0120zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzalx() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
        View view = this.view;
        if (view != null && this.zzgdy != null) {
            this.zzbrf.zzf(view.getContext(), this.zzgdy);
        }
        this.zzfyl.zzaq(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
        this.zzfyl.zzaq(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzalz() {
        String zzac = this.zzbrf.zzac(this.context);
        this.zzgdy = zzac;
        String valueOf = String.valueOf(zzac);
        String str = this.zzgdw == zzuh.zza.EnumC0120zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zzgdy = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    @ParametersAreNonnullByDefault
    public final void zzb(zzavd zzavdVar, String str, String str2) {
        if (this.zzbrf.zzaa(this.context)) {
            try {
                this.zzbrf.zza(this.context, this.zzbrf.zzaf(this.context), this.zzfyl.getAdUnitId(), zzavdVar.getType(), zzavdVar.getAmount());
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Remote Exception to get reward item.", e2);
            }
        }
    }
}
