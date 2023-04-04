package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzbai;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaz extends com.google.android.gms.internal.ads.zzbk {
    private final /* synthetic */ byte[] zzeih;
    private final /* synthetic */ Map zzeii;
    private final /* synthetic */ zzbai zzeij;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaz(zzay zzayVar, int i, String str, com.google.android.gms.internal.ads.zzai zzaiVar, com.google.android.gms.internal.ads.zzaj zzajVar, byte[] bArr, Map map, zzbai zzbaiVar) {
        super(i, str, zzaiVar, zzajVar);
        this.zzeih = bArr;
        this.zzeii = map;
        this.zzeij = zzbaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final byte[] zzg() {
        byte[] bArr = this.zzeih;
        return bArr == null ? super.zzg() : bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzab
    public final Map<String, String> getHeaders() {
        Map<String, String> map = this.zzeii;
        return map == null ? super.getHeaders() : map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbk
    public final void zzi(String str) {
        this.zzeij.zzeu(str);
        super.zza(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbk, com.google.android.gms.internal.ads.zzab
    public final /* synthetic */ void zza(String str) {
        zza(str);
    }
}
