package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchv implements zzaig<Object> {
    private final zzeru<zzcho> zzgfv;
    private final zzchu zzgio;
    private final zzafy zzglj;

    public zzchv(zzcdy zzcdyVar, zzcdr zzcdrVar, zzchu zzchuVar, zzeru<zzcho> zzeruVar) {
        this.zzglj = zzcdyVar.zzgc(zzcdrVar.getCustomTemplateId());
        this.zzgio = zzchuVar;
        this.zzgfv = zzeruVar;
    }

    public final void zzaqi() {
        if (this.zzglj == null) {
            return;
        }
        this.zzgio.zza("/nativeAdCustomClick", this);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zzglj.zza(this.zzgfv.get(), str);
        } catch (RemoteException e2) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            com.google.android.gms.ads.internal.util.zzd.zzd(sb.toString(), e2);
        }
    }
}
