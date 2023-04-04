package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zznk {
    private int length;
    private int zzbgc;
    private int zzbgd;
    private int zzbge;
    private zzht zzbgj;
    private int zzbfy = 1000;
    private int[] zzbfz = new int[1000];
    private long[] zzapf = new long[1000];
    private long[] zzaph = new long[1000];
    private int[] zzayv = new int[1000];
    private int[] zzape = new int[1000];
    private zzkk[] zzbga = new zzkk[1000];
    private zzht[] zzbgb = new zzht[1000];
    private long zzbgf = Long.MIN_VALUE;
    private long zzbgg = Long.MIN_VALUE;
    private boolean zzbgi = true;
    private boolean zzbgh = true;

    public final void zzif() {
        this.zzbgc = 0;
        this.zzbgd = 0;
        this.zzbge = 0;
        this.length = 0;
        this.zzbgh = true;
    }

    public final void zzig() {
        this.zzbgf = Long.MIN_VALUE;
        this.zzbgg = Long.MIN_VALUE;
    }

    public final int zzih() {
        return this.zzbgc + this.length;
    }

    public final synchronized boolean zzii() {
        return this.length != 0;
    }

    public final synchronized zzht zzij() {
        if (this.zzbgi) {
            return null;
        }
        return this.zzbgj;
    }

    public final synchronized long zzhz() {
        return Math.max(this.zzbgf, this.zzbgg);
    }

    public final synchronized int zza(zzhv zzhvVar, zzjp zzjpVar, boolean z, boolean z2, zzht zzhtVar, zznj zznjVar) {
        if (!zzii()) {
            if (z2) {
                zzjpVar.setFlags(4);
                return -4;
            } else if (this.zzbgj == null || (!z && this.zzbgj == zzhtVar)) {
                return -3;
            } else {
                zzhvVar.zzaij = this.zzbgj;
                return -5;
            }
        }
        if (!z && this.zzbgb[this.zzbgd] == zzhtVar) {
            if (zzjpVar.zzdr == null) {
                return -3;
            }
            zzjpVar.zzaov = this.zzaph[this.zzbgd];
            zzjpVar.setFlags(this.zzayv[this.zzbgd]);
            zznjVar.size = this.zzape[this.zzbgd];
            zznjVar.zzaxf = this.zzapf[this.zzbgd];
            zznjVar.zzarz = this.zzbga[this.zzbgd];
            this.zzbgf = Math.max(this.zzbgf, zzjpVar.zzaov);
            this.length--;
            int i = this.zzbgd + 1;
            this.zzbgd = i;
            this.zzbgc++;
            if (i == this.zzbfy) {
                this.zzbgd = 0;
            }
            zznjVar.zzbfx = this.length > 0 ? this.zzapf[this.zzbgd] : zznjVar.zzaxf + zznjVar.size;
            return -4;
        }
        zzhvVar.zzaij = this.zzbgb[this.zzbgd];
        return -5;
    }

    public final synchronized long zzik() {
        if (zzii()) {
            int i = ((this.zzbgd + this.length) - 1) % this.zzbfy;
            this.zzbgd = (this.zzbgd + this.length) % this.zzbfy;
            this.zzbgc += this.length;
            this.length = 0;
            return this.zzapf[i] + this.zzape[i];
        }
        return -1L;
    }

    public final synchronized long zzd(long j, boolean z) {
        if (zzii() && j >= this.zzaph[this.zzbgd]) {
            if (j <= this.zzbgg || z) {
                int i = 0;
                int i2 = this.zzbgd;
                int i3 = -1;
                while (i2 != this.zzbge && this.zzaph[i2] <= j) {
                    if ((this.zzayv[i2] & 1) != 0) {
                        i3 = i;
                    }
                    i2 = (i2 + 1) % this.zzbfy;
                    i++;
                }
                if (i3 == -1) {
                    return -1L;
                }
                int i4 = (this.zzbgd + i3) % this.zzbfy;
                this.zzbgd = i4;
                this.zzbgc += i3;
                this.length -= i3;
                return this.zzapf[i4];
            }
            return -1L;
        }
        return -1L;
    }

    public final synchronized boolean zzg(zzht zzhtVar) {
        if (zzhtVar == null) {
            this.zzbgi = true;
            return false;
        }
        this.zzbgi = false;
        if (zzpt.zza(zzhtVar, this.zzbgj)) {
            return false;
        }
        this.zzbgj = zzhtVar;
        return true;
    }

    public final synchronized void zza(long j, int i, long j2, int i2, zzkk zzkkVar) {
        if (this.zzbgh) {
            if ((i & 1) == 0) {
                return;
            }
            this.zzbgh = false;
        }
        zzpg.checkState(!this.zzbgi);
        zzei(j);
        this.zzaph[this.zzbge] = j;
        this.zzapf[this.zzbge] = j2;
        this.zzape[this.zzbge] = i2;
        this.zzayv[this.zzbge] = i;
        this.zzbga[this.zzbge] = zzkkVar;
        this.zzbgb[this.zzbge] = this.zzbgj;
        this.zzbfz[this.zzbge] = 0;
        int i3 = this.length + 1;
        this.length = i3;
        if (i3 == this.zzbfy) {
            int i4 = this.zzbfy + 1000;
            int[] iArr = new int[i4];
            long[] jArr = new long[i4];
            long[] jArr2 = new long[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            zzkk[] zzkkVarArr = new zzkk[i4];
            zzht[] zzhtVarArr = new zzht[i4];
            int i5 = this.zzbfy - this.zzbgd;
            System.arraycopy(this.zzapf, this.zzbgd, jArr, 0, i5);
            System.arraycopy(this.zzaph, this.zzbgd, jArr2, 0, i5);
            System.arraycopy(this.zzayv, this.zzbgd, iArr2, 0, i5);
            System.arraycopy(this.zzape, this.zzbgd, iArr3, 0, i5);
            System.arraycopy(this.zzbga, this.zzbgd, zzkkVarArr, 0, i5);
            System.arraycopy(this.zzbgb, this.zzbgd, zzhtVarArr, 0, i5);
            System.arraycopy(this.zzbfz, this.zzbgd, iArr, 0, i5);
            int i6 = this.zzbgd;
            System.arraycopy(this.zzapf, 0, jArr, i5, i6);
            System.arraycopy(this.zzaph, 0, jArr2, i5, i6);
            System.arraycopy(this.zzayv, 0, iArr2, i5, i6);
            System.arraycopy(this.zzape, 0, iArr3, i5, i6);
            System.arraycopy(this.zzbga, 0, zzkkVarArr, i5, i6);
            System.arraycopy(this.zzbgb, 0, zzhtVarArr, i5, i6);
            System.arraycopy(this.zzbfz, 0, iArr, i5, i6);
            this.zzapf = jArr;
            this.zzaph = jArr2;
            this.zzayv = iArr2;
            this.zzape = iArr3;
            this.zzbga = zzkkVarArr;
            this.zzbgb = zzhtVarArr;
            this.zzbfz = iArr;
            this.zzbgd = 0;
            this.zzbge = this.zzbfy;
            this.length = this.zzbfy;
            this.zzbfy = i4;
            return;
        }
        int i7 = this.zzbge + 1;
        this.zzbge = i7;
        if (i7 == this.zzbfy) {
            this.zzbge = 0;
        }
    }

    public final synchronized void zzei(long j) {
        this.zzbgg = Math.max(this.zzbgg, j);
    }
}
