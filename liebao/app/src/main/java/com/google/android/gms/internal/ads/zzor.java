package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzor implements zzol {
    private final boolean zzbin;
    private final int zzbio;
    private final byte[] zzbip;
    private final zzom[] zzbiq;
    private int zzbir;
    private int zzbis;
    private int zzbit;
    private zzom[] zzbiu;

    public zzor(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzor(boolean z, int i, int i2) {
        zzpg.checkArgument(true);
        zzpg.checkArgument(true);
        this.zzbin = true;
        this.zzbio = 65536;
        this.zzbit = 0;
        this.zzbiu = new zzom[100];
        this.zzbip = null;
        this.zzbiq = new zzom[1];
    }

    public final synchronized void reset() {
        if (this.zzbin) {
            zzbi(0);
        }
    }

    public final synchronized void zzbi(int i) {
        boolean z = i < this.zzbir;
        this.zzbir = i;
        if (z) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized zzom zzir() {
        zzom zzomVar;
        this.zzbis++;
        if (this.zzbit > 0) {
            zzom[] zzomVarArr = this.zzbiu;
            int i = this.zzbit - 1;
            this.zzbit = i;
            zzomVar = zzomVarArr[i];
            this.zzbiu[i] = null;
        } else {
            zzomVar = new zzom(new byte[this.zzbio], 0);
        }
        return zzomVar;
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void zza(zzom zzomVar) {
        this.zzbiq[0] = zzomVar;
        zza(this.zzbiq);
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void zza(zzom[] zzomVarArr) {
        boolean z;
        if (this.zzbit + zzomVarArr.length >= this.zzbiu.length) {
            this.zzbiu = (zzom[]) Arrays.copyOf(this.zzbiu, Math.max(this.zzbiu.length << 1, this.zzbit + zzomVarArr.length));
        }
        for (zzom zzomVar : zzomVarArr) {
            if (zzomVar.data != null && zzomVar.data.length != this.zzbio) {
                z = false;
                zzpg.checkArgument(z);
                zzom[] zzomVarArr2 = this.zzbiu;
                int i = this.zzbit;
                this.zzbit = i + 1;
                zzomVarArr2[i] = zzomVar;
            }
            z = true;
            zzpg.checkArgument(z);
            zzom[] zzomVarArr22 = this.zzbiu;
            int i2 = this.zzbit;
            this.zzbit = i2 + 1;
            zzomVarArr22[i2] = zzomVar;
        }
        this.zzbis -= zzomVarArr.length;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final synchronized void zzn() {
        int max = Math.max(0, zzpt.zzh(this.zzbir, this.zzbio) - this.zzbis);
        if (max >= this.zzbit) {
            return;
        }
        Arrays.fill(this.zzbiu, max, this.zzbit, (Object) null);
        this.zzbit = max;
    }

    public final synchronized int zziu() {
        return this.zzbis * this.zzbio;
    }

    @Override // com.google.android.gms.internal.ads.zzol
    public final int zzis() {
        return this.zzbio;
    }
}
