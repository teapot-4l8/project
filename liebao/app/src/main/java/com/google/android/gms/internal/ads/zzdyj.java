package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzdyj extends zzdyl {
    private final /* synthetic */ zzdyk zzhze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdyj(zzdyk zzdykVar, zzdyh zzdyhVar, CharSequence charSequence) {
        super(zzdyhVar, charSequence);
        this.zzhze = zzdykVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyl
    final int zzew(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdyl
    final int zzev(int i) {
        return this.zzhze.zzhzf.zza(this.zzhzg, i);
    }
}
