package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgb implements zzdhe<zzdgc> {
    private String zzdvx;
    private final String zzhfn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgb(String str, String str2) {
        this.zzdvx = str;
        this.zzhfn = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdgc> zzatu() {
        return zzebh.zzag(new zzdgc(this.zzdvx, this.zzhfn));
    }
}
