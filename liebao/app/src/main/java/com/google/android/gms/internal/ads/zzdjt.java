package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdjt implements zzdav<zzbmp> {
    private final /* synthetic */ zzdjp zzhii;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdjt(zzdjp zzdjpVar) {
        this.zzhii = zzdjpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdav
    public final void zzatg() {
        this.zzhii.zzhid = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r0.zzekb < ((java.lang.Integer) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcwr)).intValue()) goto L11;
     */
    @Override // com.google.android.gms.internal.ads.zzdav
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void onSuccess(zzbmp zzbmpVar) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        com.google.android.gms.ads.internal.overlay.zzr zza;
        RelativeLayout.LayoutParams zzb;
        ViewGroup viewGroup3;
        ViewGroup viewGroup4;
        zzvt zzavb;
        ViewGroup viewGroup5;
        zzvt zzavb2;
        zzdkd zzdkdVar;
        zzbar zzbarVar;
        zzbmp zzbmpVar2 = zzbmpVar;
        if (this.zzhii.zzhid != null) {
            this.zzhii.zzhid.destroy();
        }
        this.zzhii.zzhid = zzbmpVar2;
        viewGroup = this.zzhii.zzfwu;
        viewGroup.removeAllViews();
        viewGroup2 = this.zzhii.zzfwu;
        viewGroup2.addView(zzbmpVar2.zzakl(), com.google.android.gms.ads.internal.zzr.zzkx().zzzw());
        if (!zzbmpVar2.zzakc()) {
            zzbarVar = this.zzhii.zzbpj;
        }
        zza = this.zzhii.zza(zzbmpVar2);
        zzb = zzdjp.zzb(zzbmpVar2);
        zza.zzap(zzbmpVar2.zzakm() && !zzbmpVar2.zzakd());
        viewGroup3 = this.zzhii.zzfwu;
        viewGroup3.addView(zza, zzb);
        this.zzhii.zzc(zzbmpVar2);
        viewGroup4 = this.zzhii.zzfwu;
        zzavb = this.zzhii.zzavb();
        viewGroup4.setMinimumHeight(zzavb.heightPixels);
        viewGroup5 = this.zzhii.zzfwu;
        zzavb2 = this.zzhii.zzavb();
        viewGroup5.setMinimumWidth(zzavb2.widthPixels);
        zzdkdVar = this.zzhii.zzhia;
        zzdkdVar.zzb(new zzbna(zzbmpVar2, this.zzhii));
        zzbmpVar2.zzakv();
    }
}
