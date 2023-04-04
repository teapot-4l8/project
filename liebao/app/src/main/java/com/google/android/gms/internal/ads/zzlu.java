package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzlu {
    public int zzaxm;
    public zzlg zzbay;
    public long zzbaz;
    public long zzbba;
    public long zzbbb;
    public int zzbbc;
    public long[] zzbbd;
    public int[] zzbbe;
    public int[] zzbbf;
    public int[] zzbbg;
    public long[] zzbbh;
    public boolean[] zzbbi;
    public boolean zzbbj;
    public boolean[] zzbbk;
    public zzlr zzbbl;
    public int zzbbm;
    public zzpn zzbbn;
    public boolean zzbbo;
    public long zzbbp;

    public final void zzax(int i) {
        zzpn zzpnVar = this.zzbbn;
        if (zzpnVar == null || zzpnVar.limit() < i) {
            this.zzbbn = new zzpn(i);
        }
        this.zzbbm = i;
        this.zzbbj = true;
        this.zzbbo = true;
    }

    public final long zzay(int i) {
        return this.zzbbh[i] + this.zzbbg[i];
    }
}
