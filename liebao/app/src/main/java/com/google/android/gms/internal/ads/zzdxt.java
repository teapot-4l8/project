package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdxt extends zzdxq {
    private final char zzhyu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxt(char c2) {
        this.zzhyu = c2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxr
    public final boolean zzc(char c2) {
        return c2 == this.zzhyu;
    }

    public final String toString() {
        String zzd;
        zzd = zzdxr.zzd(this.zzhyu);
        StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(zzd);
        sb.append("')");
        return sb.toString();
    }
}
