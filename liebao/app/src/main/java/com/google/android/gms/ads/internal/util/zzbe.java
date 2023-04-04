package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbbe;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbe extends com.google.android.gms.internal.ads.zzab<com.google.android.gms.internal.ads.zzz> {
    private final Map<String, String> zzaj;
    private final zzbbe<com.google.android.gms.internal.ads.zzz> zzein;
    private final zzbai zzeio;

    public zzbe(String str, zzbbe<com.google.android.gms.internal.ads.zzz> zzbbeVar) {
        this(str, null, zzbbeVar);
    }

    private zzbe(String str, Map<String, String> map, zzbbe<com.google.android.gms.internal.ads.zzz> zzbbeVar) {
        super(0, str, new zzbd(zzbbeVar));
        this.zzaj = null;
        this.zzein = zzbbeVar;
        zzbai zzbaiVar = new zzbai();
        this.zzeio = zzbaiVar;
        zzbaiVar.zza(str, "GET", null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzab
    public final com.google.android.gms.internal.ads.zzag<com.google.android.gms.internal.ads.zzz> zza(com.google.android.gms.internal.ads.zzz zzzVar) {
        return com.google.android.gms.internal.ads.zzag.zza(zzzVar, com.google.android.gms.internal.ads.zzbc.zzb(zzzVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzab
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzz zzzVar) {
        com.google.android.gms.internal.ads.zzz zzzVar2 = zzzVar;
        this.zzeio.zza(zzzVar2.zzaj, zzzVar2.statusCode);
        zzbai zzbaiVar = this.zzeio;
        byte[] bArr = zzzVar2.data;
        if (zzbai.isEnabled() && bArr != null) {
            zzbaiVar.zzi(bArr);
        }
        this.zzein.set(zzzVar2);
    }
}
