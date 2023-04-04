package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcx extends zzcw<Integer, Object> {
    public String zzns;
    public long zznt;
    public String zznu;
    public String zznv;
    public String zznw;

    public zzcx(String str) {
        this();
        zzam(str);
    }

    public zzcx() {
        this.zzns = "E";
        this.zznt = -1L;
        this.zznu = "E";
        this.zznv = "E";
        this.zznw = "E";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcw
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzns = zzan.get(0) == null ? "E" : (String) zzan.get(0);
            this.zznt = zzan.get(1) == null ? -1L : ((Long) zzan.get(1)).longValue();
            this.zznu = zzan.get(2) == null ? "E" : (String) zzan.get(2);
            this.zznv = zzan.get(3) == null ? "E" : (String) zzan.get(3);
            this.zznw = zzan.get(4) != null ? (String) zzan.get(4) : "E";
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    protected final HashMap<Integer, Object> zzbo() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzns);
        hashMap.put(4, this.zznw);
        hashMap.put(3, this.zznv);
        hashMap.put(2, this.zznu);
        hashMap.put(1, Long.valueOf(this.zznt));
        return hashMap;
    }
}
