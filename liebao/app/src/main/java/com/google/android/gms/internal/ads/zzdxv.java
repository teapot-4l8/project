package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzdxv extends zzdxs {
    static final zzdxv zzhyv = new zzdxv();

    private zzdxv() {
        super("CharMatcher.none()");
    }

    @Override // com.google.android.gms.internal.ads.zzdxr
    public final boolean zzc(char c2) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdxr
    public final int zza(CharSequence charSequence, int i) {
        zzdyi.zzb(i, charSequence.length(), "index");
        return -1;
    }
}
