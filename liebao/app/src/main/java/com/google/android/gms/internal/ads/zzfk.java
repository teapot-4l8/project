package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfk extends zzcw<Integer, Long> {
    public Long zzaas;
    public Long zzaat;
    public Long zzaau;
    public Long zzaav;

    public zzfk() {
    }

    public zzfk(String str) {
        zzam(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcw
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzaas = (Long) zzan.get(0);
            this.zzaat = (Long) zzan.get(1);
            this.zzaau = (Long) zzan.get(2);
            this.zzaav = (Long) zzan.get(3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    protected final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaas);
        hashMap.put(1, this.zzaat);
        hashMap.put(2, this.zzaau);
        hashMap.put(3, this.zzaav);
        return hashMap;
    }
}
