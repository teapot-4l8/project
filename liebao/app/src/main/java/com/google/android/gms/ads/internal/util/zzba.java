package com.google.android.gms.ads.internal.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzba implements com.google.android.gms.internal.ads.zzaj {
    private final /* synthetic */ String zzeik;
    private final /* synthetic */ zzbb zzeil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzay zzayVar, String str, zzbb zzbbVar) {
        this.zzeik = str;
        this.zzeil = zzbbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaj
    public final void zzd(com.google.android.gms.internal.ads.zzap zzapVar) {
        String str = this.zzeik;
        String zzapVar2 = zzapVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzapVar2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzapVar2);
        zzd.zzez(sb.toString());
        this.zzeil.zzb(null);
    }
}
