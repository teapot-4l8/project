package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzla {
    public int index;
    public final int length;
    public int zzaxe;
    public long zzaxf;
    private final boolean zzaxg;
    private final zzpn zzaxh;
    private final zzpn zzaxi;
    private int zzaxj;
    private int zzaxk;

    public zzla(zzpn zzpnVar, zzpn zzpnVar2, boolean z) {
        this.zzaxi = zzpnVar;
        this.zzaxh = zzpnVar2;
        this.zzaxg = z;
        zzpnVar2.zzbl(12);
        this.length = zzpnVar2.zzje();
        zzpnVar.zzbl(12);
        this.zzaxk = zzpnVar.zzje();
        zzpg.checkState(zzpnVar.readInt() == 1, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzhe() {
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        this.zzaxf = this.zzaxg ? this.zzaxh.zzjf() : this.zzaxh.zzjb();
        if (this.index == this.zzaxj) {
            this.zzaxe = this.zzaxi.zzje();
            this.zzaxi.zzbm(4);
            int i2 = this.zzaxk - 1;
            this.zzaxk = i2;
            this.zzaxj = i2 > 0 ? this.zzaxi.zzje() - 1 : -1;
        }
        return true;
    }
}
