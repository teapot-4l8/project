package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zznm implements zzkh {
    private final zzol zzbdz;
    private final int zzbgo;
    private zznl zzbgs;
    private zznl zzbgt;
    private zzht zzbgu;
    private boolean zzbgv;
    private zzht zzbgw;
    private long zzbgx;
    private int zzbgy;
    private zzno zzbgz;
    private final zznk zzbgp = new zznk();
    private final zznj zzbgq = new zznj();
    private final zzpn zzaqd = new zzpn(32);
    private final AtomicInteger zzbgr = new AtomicInteger();

    public zznm(zzol zzolVar) {
        this.zzbdz = zzolVar;
        this.zzbgo = zzolVar.zzis();
        int i = this.zzbgo;
        this.zzbgy = i;
        zznl zznlVar = new zznl(0L, i);
        this.zzbgs = zznlVar;
        this.zzbgt = zznlVar;
    }

    public final void zzl(boolean z) {
        int andSet = this.zzbgr.getAndSet(z ? 0 : 2);
        zzif();
        this.zzbgp.zzig();
        if (andSet == 2) {
            this.zzbgu = null;
        }
    }

    public final int zzih() {
        return this.zzbgp.zzih();
    }

    public final void disable() {
        if (this.zzbgr.getAndSet(2) == 0) {
            zzif();
        }
    }

    public final boolean zzii() {
        return this.zzbgp.zzii();
    }

    public final zzht zzij() {
        return this.zzbgp.zzij();
    }

    public final long zzhz() {
        return this.zzbgp.zzhz();
    }

    public final void zzim() {
        long zzik = this.zzbgp.zzik();
        if (zzik != -1) {
            zzej(zzik);
        }
    }

    public final boolean zze(long j, boolean z) {
        long zzd = this.zzbgp.zzd(j, z);
        if (zzd == -1) {
            return false;
        }
        zzej(zzd);
        return true;
    }

    public final int zza(zzhv zzhvVar, zzjp zzjpVar, boolean z, boolean z2, long j) {
        int i;
        int zza = this.zzbgp.zza(zzhvVar, zzjpVar, z, z2, this.zzbgu, this.zzbgq);
        if (zza == -5) {
            this.zzbgu = zzhvVar.zzaij;
            return -5;
        } else if (zza == -4) {
            if (!zzjpVar.zzgm()) {
                if (zzjpVar.zzaov < j) {
                    zzjpVar.zzad(Integer.MIN_VALUE);
                }
                if (zzjpVar.isEncrypted()) {
                    zznj zznjVar = this.zzbgq;
                    long j2 = zznjVar.zzaxf;
                    this.zzaqd.reset(1);
                    zza(j2, this.zzaqd.data, 1);
                    long j3 = j2 + 1;
                    byte b2 = this.zzaqd.data[0];
                    boolean z3 = (b2 & 128) != 0;
                    int i2 = b2 & Byte.MAX_VALUE;
                    if (zzjpVar.zzaou.iv == null) {
                        zzjpVar.zzaou.iv = new byte[16];
                    }
                    zza(j3, zzjpVar.zzaou.iv, i2);
                    long j4 = j3 + i2;
                    if (z3) {
                        this.zzaqd.reset(2);
                        zza(j4, this.zzaqd.data, 2);
                        j4 += 2;
                        i = this.zzaqd.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    int[] iArr = zzjpVar.zzaou.numBytesOfClearData;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzjpVar.zzaou.numBytesOfEncryptedData;
                    if (iArr3 == null || iArr3.length < i) {
                        iArr3 = new int[i];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i3 = i * 6;
                        this.zzaqd.reset(i3);
                        zza(j4, this.zzaqd.data, i3);
                        j4 += i3;
                        this.zzaqd.zzbl(0);
                        for (int i4 = 0; i4 < i; i4++) {
                            iArr2[i4] = this.zzaqd.readUnsignedShort();
                            iArr4[i4] = this.zzaqd.zzje();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zznjVar.size - ((int) (j4 - zznjVar.zzaxf));
                    }
                    zzkk zzkkVar = zznjVar.zzarz;
                    zzjpVar.zzaou.set(i, iArr2, iArr4, zzkkVar.zzaps, zzjpVar.zzaou.iv, zzkkVar.zzapr);
                    int i5 = (int) (j4 - zznjVar.zzaxf);
                    zznjVar.zzaxf += i5;
                    zznjVar.size -= i5;
                }
                zzjpVar.zzag(this.zzbgq.size);
                long j5 = this.zzbgq.zzaxf;
                ByteBuffer byteBuffer = zzjpVar.zzdr;
                int i6 = this.zzbgq.size;
                zzej(j5);
                while (i6 > 0) {
                    int i7 = (int) (j5 - this.zzbgs.zzbgk);
                    int min = Math.min(i6, this.zzbgo - i7);
                    zzom zzomVar = this.zzbgs.zzbgm;
                    byteBuffer.put(zzomVar.data, i7 + 0, min);
                    j5 += min;
                    i6 -= min;
                    if (j5 == this.zzbgs.zzate) {
                        this.zzbdz.zza(zzomVar);
                        this.zzbgs = this.zzbgs.zzil();
                    }
                }
                zzej(this.zzbgq.zzbfx);
            }
            return -4;
        } else {
            if (zza == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzej(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzbgs.zzbgk);
            int min = Math.min(i - i2, this.zzbgo - i3);
            zzom zzomVar = this.zzbgs.zzbgm;
            System.arraycopy(zzomVar.data, i3 + 0, bArr, i2, min);
            j += min;
            i2 += min;
            if (j == this.zzbgs.zzate) {
                this.zzbdz.zza(zzomVar);
                this.zzbgs = this.zzbgs.zzil();
            }
        }
    }

    private final void zzej(long j) {
        while (j >= this.zzbgs.zzate) {
            this.zzbdz.zza(this.zzbgs.zzbgm);
            this.zzbgs = this.zzbgs.zzil();
        }
    }

    public final void zza(zzno zznoVar) {
        this.zzbgz = zznoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void zze(zzht zzhtVar) {
        zzht zzhtVar2 = zzhtVar == null ? null : zzhtVar;
        boolean zzg = this.zzbgp.zzg(zzhtVar2);
        this.zzbgw = zzhtVar;
        this.zzbgv = false;
        zzno zznoVar = this.zzbgz;
        if (zznoVar == null || !zzg) {
            return;
        }
        zznoVar.zzf(zzhtVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final int zza(zzjz zzjzVar, int i, boolean z) {
        if (!zzin()) {
            int zzai = zzjzVar.zzai(i);
            if (zzai != -1) {
                return zzai;
            }
            throw new EOFException();
        }
        try {
            int read = zzjzVar.read(this.zzbgt.zzbgm.data, this.zzbgy + 0, zzbd(i));
            if (read == -1) {
                throw new EOFException();
            }
            this.zzbgy += read;
            this.zzbgx += read;
            return read;
        } finally {
            zzio();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void zza(zzpn zzpnVar, int i) {
        if (!zzin()) {
            zzpnVar.zzbm(i);
            return;
        }
        while (i > 0) {
            int zzbd = zzbd(i);
            zzpnVar.zze(this.zzbgt.zzbgm.data, this.zzbgy + 0, zzbd);
            this.zzbgy += zzbd;
            this.zzbgx += zzbd;
            i -= zzbd;
        }
        zzio();
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void zza(long j, int i, int i2, int i3, zzkk zzkkVar) {
        if (!zzin()) {
            this.zzbgp.zzei(j);
            return;
        }
        try {
            this.zzbgp.zza(j, i, (this.zzbgx - i2) - i3, i2, zzkkVar);
        } finally {
            zzio();
        }
    }

    private final boolean zzin() {
        return this.zzbgr.compareAndSet(0, 1);
    }

    private final void zzio() {
        if (this.zzbgr.compareAndSet(1, 0)) {
            return;
        }
        zzif();
    }

    private final void zzif() {
        this.zzbgp.zzif();
        zznl zznlVar = this.zzbgs;
        if (zznlVar.zzbgl) {
            int i = (this.zzbgt.zzbgl ? 1 : 0) + (((int) (this.zzbgt.zzbgk - zznlVar.zzbgk)) / this.zzbgo);
            zzom[] zzomVarArr = new zzom[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzomVarArr[i2] = zznlVar.zzbgm;
                zznlVar = zznlVar.zzil();
            }
            this.zzbdz.zza(zzomVarArr);
        }
        zznl zznlVar2 = new zznl(0L, this.zzbgo);
        this.zzbgs = zznlVar2;
        this.zzbgt = zznlVar2;
        this.zzbgx = 0L;
        this.zzbgy = this.zzbgo;
        this.zzbdz.zzn();
    }

    private final int zzbd(int i) {
        if (this.zzbgy == this.zzbgo) {
            this.zzbgy = 0;
            if (this.zzbgt.zzbgl) {
                this.zzbgt = this.zzbgt.zzbgn;
            }
            zznl zznlVar = this.zzbgt;
            zzom zzir = this.zzbdz.zzir();
            zznl zznlVar2 = new zznl(this.zzbgt.zzate, this.zzbgo);
            zznlVar.zzbgm = zzir;
            zznlVar.zzbgn = zznlVar2;
            zznlVar.zzbgl = true;
        }
        return Math.min(i, this.zzbgo - this.zzbgy);
    }
}
