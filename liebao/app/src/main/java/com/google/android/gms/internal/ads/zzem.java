package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzem extends zzcw<Integer, Long> {
    public long zzyl;
    public long zzym;

    public zzem() {
        this.zzyl = -1L;
        this.zzym = -1L;
    }

    public zzem(String str) {
        this();
        zzam(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    protected final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzyl));
        hashMap.put(1, Long.valueOf(this.zzym));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcw
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzyl = ((Long) zzan.get(0)).longValue();
            this.zzym = ((Long) zzan.get(1)).longValue();
        }
    }
}
