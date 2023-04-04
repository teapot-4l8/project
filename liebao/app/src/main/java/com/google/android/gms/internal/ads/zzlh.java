package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzjo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzlh implements zzka {
    private static final zzkb zzapu = new zzlk();
    private static final int zzaxt = zzpt.zzbh("seig");
    private static final byte[] zzaxu = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long zzaiz;
    private final zzpn zzaqb;
    private int zzarq;
    private int zzarr;
    private zzkc zzaru;
    private final zzls zzaxv;
    private final SparseArray<zzlm> zzaxw;
    private final zzpn zzaxx;
    private final zzpn zzaxy;
    private final zzpn zzaxz;
    private final zzpr zzaya;
    private final zzpn zzayb;
    private final byte[] zzayc;
    private final Stack<zzkv> zzayd;
    private final LinkedList<zzlj> zzaye;
    private int zzayf;
    private int zzayg;
    private long zzayh;
    private int zzayi;
    private zzpn zzayj;
    private long zzayk;
    private int zzayl;
    private long zzaym;
    private zzlm zzayn;
    private int zzayo;
    private boolean zzayp;
    private zzkh zzayq;
    private zzkh[] zzayr;
    private boolean zzays;

    public zzlh() {
        this(0);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void release() {
    }

    private zzlh(int i) {
        this(0, null);
    }

    private zzlh(int i, zzpr zzprVar) {
        this(0, null, null);
    }

    private zzlh(int i, zzpr zzprVar, zzls zzlsVar) {
        this.flags = 0;
        this.zzaya = null;
        this.zzaxv = null;
        this.zzayb = new zzpn(16);
        this.zzaqb = new zzpn(zzpm.zzbkd);
        this.zzaxx = new zzpn(5);
        this.zzaxy = new zzpn();
        this.zzaxz = new zzpn(1);
        this.zzayc = new byte[16];
        this.zzayd = new Stack<>();
        this.zzaye = new LinkedList<>();
        this.zzaxw = new SparseArray<>();
        this.zzaiz = -9223372036854775807L;
        this.zzaym = -9223372036854775807L;
        zzhf();
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final boolean zza(zzjz zzjzVar) {
        return zzlp.zzd(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar) {
        this.zzaru = zzkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zzc(long j, long j2) {
        int size = this.zzaxw.size();
        for (int i = 0; i < size; i++) {
            this.zzaxw.valueAt(i).reset();
        }
        this.zzaye.clear();
        this.zzayl = 0;
        this.zzayd.clear();
        zzhf();
    }

    /* JADX WARN: Removed duplicated region for block: B:261:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x05de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0004 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(zzjz zzjzVar, zzkg zzkgVar) {
        zzlr zzlrVar;
        zzkk zzkkVar;
        int i;
        boolean z;
        zzkk zzkkVar2;
        int zza;
        zzlr zzlrVar2;
        int i2;
        long zzjf;
        long zzjf2;
        int[] iArr;
        boolean z2;
        zzjz zzjzVar2 = zzjzVar;
        while (true) {
            int i3 = this.zzayf;
            int i4 = 1;
            int i5 = 0;
            if (i3 != 0) {
                int i6 = 4;
                if (i3 != 1) {
                    long j = Long.MAX_VALUE;
                    if (i3 == 2) {
                        int size = this.zzaxw.size();
                        zzlm zzlmVar = null;
                        for (int i7 = 0; i7 < size; i7++) {
                            zzlu zzluVar = this.zzaxw.valueAt(i7).zzbab;
                            if (zzluVar.zzbbo && zzluVar.zzbbb < j) {
                                j = zzluVar.zzbbb;
                                zzlmVar = this.zzaxw.valueAt(i7);
                            }
                        }
                        if (zzlmVar == null) {
                            this.zzayf = 3;
                        } else {
                            int position = (int) (j - zzjzVar.getPosition());
                            if (position < 0) {
                                throw new zzhw("Offset to encryption data was negative.");
                            }
                            zzjzVar2.zzaj(position);
                            zzlu zzluVar2 = zzlmVar.zzbab;
                            zzjzVar2.readFully(zzluVar2.zzbbn.data, 0, zzluVar2.zzbbm);
                            zzluVar2.zzbbn.zzbl(0);
                            zzluVar2.zzbbo = false;
                        }
                    } else {
                        if (i3 == 3) {
                            if (this.zzayn == null) {
                                SparseArray<zzlm> sparseArray = this.zzaxw;
                                int size2 = sparseArray.size();
                                zzlm zzlmVar2 = null;
                                for (int i8 = 0; i8 < size2; i8++) {
                                    zzlm valueAt = sparseArray.valueAt(i8);
                                    if (valueAt.zzbag != valueAt.zzbab.zzbbc) {
                                        long j2 = valueAt.zzbab.zzbbd[valueAt.zzbag];
                                        if (j2 < j) {
                                            zzlmVar2 = valueAt;
                                            j = j2;
                                        }
                                    }
                                }
                                if (zzlmVar2 == null) {
                                    int position2 = (int) (this.zzayk - zzjzVar.getPosition());
                                    if (position2 < 0) {
                                        throw new zzhw("Offset to end of mdat was negative.");
                                    }
                                    zzjzVar2.zzaj(position2);
                                    zzhf();
                                    i = 0;
                                    z = false;
                                    if (!z) {
                                        return i;
                                    }
                                } else {
                                    int position3 = (int) (zzlmVar2.zzbab.zzbbd[zzlmVar2.zzbag] - zzjzVar.getPosition());
                                    if (position3 < 0) {
                                        Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                        position3 = 0;
                                    }
                                    zzjzVar2.zzaj(position3);
                                    this.zzayn = zzlmVar2;
                                }
                            }
                            this.zzayo = this.zzayn.zzbab.zzbbf[this.zzayn.zzbae];
                            if (this.zzayn.zzbab.zzbbj) {
                                zzlm zzlmVar3 = this.zzayn;
                                zzlu zzluVar3 = zzlmVar3.zzbab;
                                zzpn zzpnVar = zzluVar3.zzbbn;
                                int i9 = zzluVar3.zzbay.zzaxs;
                                if (zzluVar3.zzbbl != null) {
                                    zzlrVar2 = zzluVar3.zzbbl;
                                } else {
                                    zzlrVar2 = zzlmVar3.zzbac.zzbau[i9];
                                }
                                int i10 = zzlrVar2.zzbaq;
                                boolean z3 = zzluVar3.zzbbk[zzlmVar3.zzbae];
                                this.zzaxz.data[0] = (byte) ((z3 ? 128 : 0) | i10);
                                this.zzaxz.zzbl(0);
                                zzkh zzkhVar = zzlmVar3.zzasz;
                                zzkhVar.zza(this.zzaxz, 1);
                                zzkhVar.zza(zzpnVar, i10);
                                if (z3) {
                                    int readUnsignedShort = zzpnVar.readUnsignedShort();
                                    zzpnVar.zzbm(-2);
                                    int i11 = (readUnsignedShort * 6) + 2;
                                    zzkhVar.zza(zzpnVar, i11);
                                    i2 = i10 + 1 + i11;
                                } else {
                                    i2 = i10 + 1;
                                }
                                this.zzarr = i2;
                                this.zzayo += i2;
                            } else {
                                this.zzarr = 0;
                            }
                            if (this.zzayn.zzbac.zzbat == 1) {
                                this.zzayo -= 8;
                                zzjzVar2.zzaj(8);
                            }
                            this.zzayf = 4;
                            this.zzarq = 0;
                        }
                        zzlu zzluVar4 = this.zzayn.zzbab;
                        zzls zzlsVar = this.zzayn.zzbac;
                        zzkh zzkhVar2 = this.zzayn.zzasz;
                        int i12 = this.zzayn.zzbae;
                        if (zzlsVar.zzata == 0) {
                            while (true) {
                                int i13 = this.zzarr;
                                int i14 = this.zzayo;
                                if (i13 >= i14) {
                                    break;
                                }
                                this.zzarr += zzkhVar2.zza(zzjzVar2, i14 - i13, false);
                            }
                        } else {
                            byte[] bArr = this.zzaxx.data;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            int i15 = zzlsVar.zzata + 1;
                            int i16 = 4 - zzlsVar.zzata;
                            while (this.zzarr < this.zzayo) {
                                int i17 = this.zzarq;
                                if (i17 == 0) {
                                    zzjzVar2.readFully(bArr, i16, i15);
                                    this.zzaxx.zzbl(i5);
                                    this.zzarq = this.zzaxx.zzje() - i4;
                                    this.zzaqb.zzbl(i5);
                                    zzkhVar2.zza(this.zzaqb, i6);
                                    zzkhVar2.zza(this.zzaxx, i4);
                                    this.zzayp = this.zzayr != null && zzpm.zza(zzlsVar.zzaij.zzaho, bArr[i6]);
                                    this.zzarr += 5;
                                    this.zzayo += i16;
                                } else {
                                    if (this.zzayp) {
                                        this.zzaxy.reset(i17);
                                        zzjzVar2.readFully(this.zzaxy.data, i5, this.zzarq);
                                        zzkhVar2.zza(this.zzaxy, this.zzarq);
                                        zza = this.zzarq;
                                        int zzb = zzpm.zzb(this.zzaxy.data, this.zzaxy.limit());
                                        this.zzaxy.zzbl("video/hevc".equals(zzlsVar.zzaij.zzaho) ? 1 : 0);
                                        this.zzaxy.zzbk(zzb);
                                        zznw.zza(zzluVar4.zzay(i12) * 1000, this.zzaxy, this.zzayr);
                                    } else {
                                        zza = zzkhVar2.zza(zzjzVar2, i17, false);
                                    }
                                    this.zzarr += zza;
                                    this.zzarq -= zza;
                                    i4 = 1;
                                    i5 = 0;
                                    i6 = 4;
                                }
                            }
                        }
                        long zzay = zzluVar4.zzay(i12) * 1000;
                        int i18 = (zzluVar4.zzbbj ? 1073741824 : 0) | (zzluVar4.zzbbi[i12] ? 1 : 0);
                        if (zzluVar4.zzbbj) {
                            if (zzluVar4.zzbbl != null) {
                                zzlrVar = zzluVar4.zzbbl;
                            } else {
                                zzlrVar = zzlsVar.zzbau[zzluVar4.zzbay.zzaxs];
                            }
                            if (zzlrVar != this.zzayn.zzbai) {
                                zzkkVar2 = new zzkk(1, zzlrVar.zzbar);
                            } else {
                                zzkkVar2 = this.zzayn.zzbah;
                            }
                            zzkkVar = zzkkVar2;
                        } else {
                            zzlrVar = null;
                            zzkkVar = null;
                        }
                        this.zzayn.zzbah = zzkkVar;
                        this.zzayn.zzbai = zzlrVar;
                        zzkhVar2.zza(zzay, i18, this.zzayo, 0, zzkkVar);
                        while (!this.zzaye.isEmpty()) {
                            zzlj removeFirst = this.zzaye.removeFirst();
                            this.zzayl -= removeFirst.size;
                            this.zzayq.zza(zzay + removeFirst.zzayw, 1, removeFirst.size, this.zzayl, null);
                        }
                        this.zzayn.zzbae++;
                        this.zzayn.zzbaf++;
                        if (this.zzayn.zzbaf == zzluVar4.zzbbe[this.zzayn.zzbag]) {
                            this.zzayn.zzbag++;
                            i = 0;
                            this.zzayn.zzbaf = 0;
                            this.zzayn = null;
                        } else {
                            i = 0;
                        }
                        this.zzayf = 3;
                        z = true;
                        if (!z) {
                        }
                    }
                } else {
                    int i19 = ((int) this.zzayh) - this.zzayi;
                    zzpn zzpnVar2 = this.zzayj;
                    if (zzpnVar2 != null) {
                        zzjzVar2.readFully(zzpnVar2.data, 8, i19);
                        zzky zzkyVar = new zzky(this.zzayg, this.zzayj);
                        long position4 = zzjzVar.getPosition();
                        if (!this.zzayd.isEmpty()) {
                            this.zzayd.peek().zza(zzkyVar);
                        } else {
                            if (zzkyVar.type == zzkw.zzauh) {
                                zzpn zzpnVar3 = zzkyVar.zzaxd;
                                zzpnVar3.zzbl(8);
                                int zzau = zzkw.zzau(zzpnVar3.readInt());
                                zzpnVar3.zzbm(4);
                                long zzjb = zzpnVar3.zzjb();
                                if (zzau == 0) {
                                    zzjf = zzpnVar3.zzjb();
                                    zzjf2 = zzpnVar3.zzjb();
                                } else {
                                    zzjf = zzpnVar3.zzjf();
                                    zzjf2 = zzpnVar3.zzjf();
                                }
                                long j3 = position4 + zzjf2;
                                long zza2 = zzpt.zza(zzjf, 1000000L, zzjb);
                                zzpnVar3.zzbm(2);
                                int readUnsignedShort2 = zzpnVar3.readUnsignedShort();
                                int[] iArr2 = new int[readUnsignedShort2];
                                long[] jArr = new long[readUnsignedShort2];
                                long[] jArr2 = new long[readUnsignedShort2];
                                long[] jArr3 = new long[readUnsignedShort2];
                                long j4 = zza2;
                                int i20 = 0;
                                while (i20 < readUnsignedShort2) {
                                    int readInt = zzpnVar3.readInt();
                                    if ((readInt & Integer.MIN_VALUE) != 0) {
                                        throw new zzhw("Unhandled indirect reference");
                                    }
                                    long zzjb2 = zzpnVar3.zzjb();
                                    iArr2[i20] = readInt & Integer.MAX_VALUE;
                                    jArr[i20] = j3;
                                    jArr3[i20] = j4;
                                    long j5 = zzjf + zzjb2;
                                    int i21 = i20;
                                    int i22 = readUnsignedShort2;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    j4 = zzpt.zza(j5, 1000000L, zzjb);
                                    jArr4[i21] = j4 - jArr5[i21];
                                    zzpnVar3.zzbm(4);
                                    j3 += iArr[i21];
                                    jArr = jArr;
                                    jArr2 = jArr4;
                                    jArr3 = jArr5;
                                    iArr2 = iArr2;
                                    i20 = i21 + 1;
                                    zzjf = j5;
                                    readUnsignedShort2 = i22;
                                }
                                Pair create = Pair.create(Long.valueOf(zza2), new zzjy(iArr2, jArr, jArr2, jArr3));
                                this.zzaym = ((Long) create.first).longValue();
                                this.zzaru.zza((zzkf) create.second);
                                this.zzays = true;
                            } else if (zzkyVar.type == zzkw.zzawn) {
                                zzpn zzpnVar4 = zzkyVar.zzaxd;
                                if (this.zzayq != null) {
                                    zzpnVar4.zzbl(12);
                                    zzpnVar4.zzjg();
                                    zzpnVar4.zzjg();
                                    long zza3 = zzpt.zza(zzpnVar4.zzjb(), 1000000L, zzpnVar4.zzjb());
                                    zzpnVar4.zzbl(12);
                                    int zziz = zzpnVar4.zziz();
                                    this.zzayq.zza(zzpnVar4, zziz);
                                    long j6 = this.zzaym;
                                    if (j6 != -9223372036854775807L) {
                                        this.zzayq.zza(j6 + zza3, 1, zziz, 0, null);
                                    } else {
                                        this.zzaye.addLast(new zzlj(zza3, zziz));
                                        this.zzayl += zziz;
                                    }
                                }
                            }
                            zzjzVar2 = zzjzVar;
                        }
                    } else {
                        zzjzVar2.zzaj(i19);
                    }
                    zzeb(zzjzVar.getPosition());
                }
            } else {
                if (this.zzayi == 0) {
                    z2 = false;
                    if (zzjzVar2.zza(this.zzayb.data, 0, 8, true)) {
                        this.zzayi = 8;
                        this.zzayb.zzbl(0);
                        this.zzayh = this.zzayb.zzjb();
                        this.zzayg = this.zzayb.readInt();
                    }
                    if (!z2) {
                        return -1;
                    }
                }
                if (this.zzayh == 1) {
                    zzjzVar2.readFully(this.zzayb.data, 8, 8);
                    this.zzayi += 8;
                    this.zzayh = this.zzayb.zzjf();
                }
                if (this.zzayh < this.zzayi) {
                    throw new zzhw("Atom size less than header length (unsupported).");
                }
                long position5 = zzjzVar.getPosition() - this.zzayi;
                if (this.zzayg == zzkw.zzaur) {
                    int size3 = this.zzaxw.size();
                    for (int i23 = 0; i23 < size3; i23++) {
                        zzlu zzluVar5 = this.zzaxw.valueAt(i23).zzbab;
                        zzluVar5.zzbaz = position5;
                        zzluVar5.zzbbb = position5;
                        zzluVar5.zzbba = position5;
                    }
                }
                if (this.zzayg == zzkw.zzato) {
                    this.zzayn = null;
                    this.zzayk = position5 + this.zzayh;
                    if (!this.zzays) {
                        this.zzaru.zza(new zzki(this.zzaiz));
                        this.zzays = true;
                    }
                    this.zzayf = 2;
                } else {
                    int i24 = this.zzayg;
                    if (i24 == zzkw.zzaui || i24 == zzkw.zzauk || i24 == zzkw.zzaul || i24 == zzkw.zzaum || i24 == zzkw.zzaun || i24 == zzkw.zzaur || i24 == zzkw.zzaus || i24 == zzkw.zzaut || i24 == zzkw.zzauw) {
                        long position6 = (zzjzVar.getPosition() + this.zzayh) - 8;
                        this.zzayd.add(new zzkv(this.zzayg, position6));
                        if (this.zzayh == this.zzayi) {
                            zzeb(position6);
                        } else {
                            zzhf();
                        }
                    } else {
                        int i25 = this.zzayg;
                        if (i25 == zzkw.zzauz || i25 == zzkw.zzauy || i25 == zzkw.zzauj || i25 == zzkw.zzauh || i25 == zzkw.zzava || i25 == zzkw.zzaud || i25 == zzkw.zzaue || i25 == zzkw.zzauv || i25 == zzkw.zzauf || i25 == zzkw.zzaug || i25 == zzkw.zzavb || i25 == zzkw.zzavj || i25 == zzkw.zzavk || i25 == zzkw.zzavo || i25 == zzkw.zzavn || i25 == zzkw.zzavl || i25 == zzkw.zzavm || i25 == zzkw.zzaux || i25 == zzkw.zzauu || i25 == zzkw.zzawn) {
                            if (this.zzayi != 8) {
                                throw new zzhw("Leaf atom defines extended atom size (unsupported).");
                            }
                            long j7 = this.zzayh;
                            if (j7 > 2147483647L) {
                                throw new zzhw("Leaf atom with length > 2147483647 (unsupported).");
                            }
                            this.zzayj = new zzpn((int) j7);
                            System.arraycopy(this.zzayb.data, 0, this.zzayj.data, 0, 8);
                            this.zzayf = 1;
                        } else if (this.zzayh > 2147483647L) {
                            throw new zzhw("Skipping atom with length > 2147483647 (unsupported).");
                        } else {
                            this.zzayj = null;
                            this.zzayf = 1;
                        }
                        z2 = true;
                        if (!z2) {
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                }
            }
        }
    }

    private final void zzhf() {
        this.zzayf = 0;
        this.zzayi = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0656  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzeb(long j) {
        SparseArray sparseArray;
        zzlh zzlhVar;
        zzkv zzkvVar;
        SparseArray<zzlm> sparseArray2;
        int i;
        int i2;
        int i3;
        byte[] bArr;
        zzlu zzluVar;
        int size;
        int i4;
        byte[] bArr2;
        int i5;
        int i6;
        zzkv zzkvVar2;
        int i7;
        int i8;
        zzlu zzluVar2;
        byte[] bArr3;
        int i9;
        zzkv zzkvVar3;
        zzlm zzlmVar;
        List<zzky> list;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z;
        int i15;
        boolean z2;
        int i16;
        boolean z3;
        int i17;
        boolean z4;
        boolean z5;
        zzlh zzlhVar2 = this;
        while (!zzlhVar2.zzayd.isEmpty() && zzlhVar2.zzayd.peek().zzate == j) {
            zzkv pop = zzlhVar2.zzayd.pop();
            zzlm zzlmVar2 = null;
            int i18 = 12;
            int i19 = 1;
            if (pop.type == zzkw.zzaui) {
                zzpg.checkState(true, "Unexpected moov box.");
                zzjo zzb = zzb(pop.zzatf);
                zzkv zzat = pop.zzat(zzkw.zzaut);
                SparseArray sparseArray3 = new SparseArray();
                int size2 = zzat.zzatf.size();
                long j2 = -9223372036854775807L;
                int i20 = 0;
                while (i20 < size2) {
                    zzky zzkyVar = zzat.zzatf.get(i20);
                    if (zzkyVar.type == zzkw.zzauf) {
                        zzpn zzpnVar = zzkyVar.zzaxd;
                        zzpnVar.zzbl(i18);
                        Pair create = Pair.create(Integer.valueOf(zzpnVar.readInt()), new zzlg(zzpnVar.zzje() - i19, zzpnVar.zzje(), zzpnVar.zzje(), zzpnVar.readInt()));
                        sparseArray3.put(((Integer) create.first).intValue(), (zzlg) create.second);
                    } else if (zzkyVar.type == zzkw.zzauu) {
                        zzpn zzpnVar2 = zzkyVar.zzaxd;
                        zzpnVar2.zzbl(8);
                        j2 = zzkw.zzau(zzpnVar2.readInt()) == 0 ? zzpnVar2.zzjb() : zzpnVar2.zzjf();
                    }
                    i20++;
                    i18 = 12;
                    i19 = 1;
                }
                SparseArray sparseArray4 = new SparseArray();
                int size3 = pop.zzatg.size();
                int i21 = 0;
                while (i21 < size3) {
                    zzkv zzkvVar4 = pop.zzatg.get(i21);
                    if (zzkvVar4.type == zzkw.zzauk) {
                        sparseArray = sparseArray3;
                        zzls zza = zzkx.zza(zzkvVar4, pop.zzas(zzkw.zzauj), j2, zzb, false);
                        if (zza != null) {
                            sparseArray4.put(zza.id, zza);
                        }
                    } else {
                        sparseArray = sparseArray3;
                    }
                    i21++;
                    sparseArray3 = sparseArray;
                }
                SparseArray sparseArray5 = sparseArray3;
                int size4 = sparseArray4.size();
                if (zzlhVar2.zzaxw.size() == 0) {
                    for (int i22 = 0; i22 < size4; i22++) {
                        zzls zzlsVar = (zzls) sparseArray4.valueAt(i22);
                        zzlm zzlmVar3 = new zzlm(zzlhVar2.zzaru.zze(i22, zzlsVar.type));
                        zzlmVar3.zza(zzlsVar, (zzlg) sparseArray5.get(zzlsVar.id));
                        zzlhVar2.zzaxw.put(zzlsVar.id, zzlmVar3);
                        zzlhVar2.zzaiz = Math.max(zzlhVar2.zzaiz, zzlsVar.zzaiz);
                    }
                    if ((zzlhVar2.flags & 4) != 0 && zzlhVar2.zzayq == null) {
                        zzkh zze = zzlhVar2.zzaru.zze(zzlhVar2.zzaxw.size(), 4);
                        zzlhVar2.zzayq = zze;
                        zze.zze(zzht.zza((String) null, "application/x-emsg", Long.MAX_VALUE));
                    }
                    if ((zzlhVar2.flags & 8) != 0 && zzlhVar2.zzayr == null) {
                        zzkh zze2 = zzlhVar2.zzaru.zze(zzlhVar2.zzaxw.size() + 1, 3);
                        zze2.zze(zzht.zza((String) null, "application/cea-608", (String) null, -1, 0, (String) null, (zzjo) null));
                        zzlhVar2.zzayr = new zzkh[]{zze2};
                    }
                    zzlhVar2.zzaru.zzgw();
                } else {
                    zzpg.checkState(zzlhVar2.zzaxw.size() == size4);
                    for (int i23 = 0; i23 < size4; i23++) {
                        zzls zzlsVar2 = (zzls) sparseArray4.valueAt(i23);
                        zzlhVar2.zzaxw.get(zzlsVar2.id).zza(zzlsVar2, (zzlg) sparseArray5.get(zzlsVar2.id));
                    }
                }
            } else {
                if (pop.type == zzkw.zzaur) {
                    SparseArray<zzlm> sparseArray6 = zzlhVar2.zzaxw;
                    int i24 = zzlhVar2.flags;
                    byte[] bArr4 = zzlhVar2.zzayc;
                    int size5 = pop.zzatg.size();
                    int i25 = 0;
                    while (i25 < size5) {
                        zzkv zzkvVar5 = pop.zzatg.get(i25);
                        if (zzkvVar5.type == zzkw.zzaus) {
                            zzpn zzpnVar3 = zzkvVar5.zzas(zzkw.zzaue).zzaxd;
                            zzpnVar3.zzbl(8);
                            int zzav = zzkw.zzav(zzpnVar3.readInt());
                            int readInt = zzpnVar3.readInt();
                            if ((i24 & 16) != 0) {
                                readInt = 0;
                            }
                            zzlm zzlmVar4 = sparseArray6.get(readInt);
                            if (zzlmVar4 == null) {
                                zzlmVar4 = zzlmVar2;
                            } else {
                                if ((zzav & 1) != 0) {
                                    long zzjf = zzpnVar3.zzjf();
                                    zzlmVar4.zzbab.zzbba = zzjf;
                                    zzlmVar4.zzbab.zzbbb = zzjf;
                                }
                                zzlg zzlgVar = zzlmVar4.zzbad;
                                zzlmVar4.zzbab.zzbay = new zzlg((zzav & 2) != 0 ? zzpnVar3.zzje() - 1 : zzlgVar.zzaxs, (zzav & 8) != 0 ? zzpnVar3.zzje() : zzlgVar.duration, (zzav & 16) != 0 ? zzpnVar3.zzje() : zzlgVar.size, (zzav & 32) != 0 ? zzpnVar3.zzje() : zzlgVar.flags);
                            }
                            if (zzlmVar4 != null) {
                                zzlu zzluVar3 = zzlmVar4.zzbab;
                                long j3 = zzluVar3.zzbbp;
                                zzlmVar4.reset();
                                if (zzkvVar5.zzas(zzkw.zzaud) != null && (i24 & 2) == 0) {
                                    zzpn zzpnVar4 = zzkvVar5.zzas(zzkw.zzaud).zzaxd;
                                    zzpnVar4.zzbl(8);
                                    j3 = zzkw.zzau(zzpnVar4.readInt()) == 1 ? zzpnVar4.zzjf() : zzpnVar4.zzjb();
                                }
                                List<zzky> list2 = zzkvVar5.zzatf;
                                int size6 = list2.size();
                                sparseArray2 = sparseArray6;
                                int i26 = 0;
                                int i27 = 0;
                                int i28 = 0;
                                while (i28 < size6) {
                                    int i29 = size5;
                                    zzky zzkyVar2 = list2.get(i28);
                                    long j4 = j3;
                                    if (zzkyVar2.type == zzkw.zzaug) {
                                        zzpn zzpnVar5 = zzkyVar2.zzaxd;
                                        zzpnVar5.zzbl(12);
                                        int zzje = zzpnVar5.zzje();
                                        if (zzje > 0) {
                                            i26 += zzje;
                                            i27++;
                                        }
                                    }
                                    i28++;
                                    size5 = i29;
                                    j3 = j4;
                                }
                                i2 = size5;
                                long j5 = j3;
                                zzlmVar4.zzbag = 0;
                                zzlmVar4.zzbaf = 0;
                                zzlmVar4.zzbae = 0;
                                zzlu zzluVar4 = zzlmVar4.zzbab;
                                zzluVar4.zzbbc = i27;
                                zzluVar4.zzaxm = i26;
                                if (zzluVar4.zzbbe == null || zzluVar4.zzbbe.length < i27) {
                                    zzluVar4.zzbbd = new long[i27];
                                    zzluVar4.zzbbe = new int[i27];
                                }
                                if (zzluVar4.zzbbf == null || zzluVar4.zzbbf.length < i26) {
                                    int i30 = (i26 * 125) / 100;
                                    zzluVar4.zzbbf = new int[i30];
                                    zzluVar4.zzbbg = new int[i30];
                                    zzluVar4.zzbbh = new long[i30];
                                    zzluVar4.zzbbi = new boolean[i30];
                                    zzluVar4.zzbbk = new boolean[i30];
                                }
                                int i31 = 0;
                                int i32 = 0;
                                int i33 = 0;
                                while (true) {
                                    long j6 = 0;
                                    if (i31 >= size6) {
                                        break;
                                    }
                                    zzky zzkyVar3 = list2.get(i31);
                                    if (zzkyVar3.type == zzkw.zzaug) {
                                        int i34 = i32 + 1;
                                        zzpn zzpnVar6 = zzkyVar3.zzaxd;
                                        zzpnVar6.zzbl(8);
                                        int zzav2 = zzkw.zzav(zzpnVar6.readInt());
                                        zzls zzlsVar3 = zzlmVar4.zzbac;
                                        list = list2;
                                        zzlu zzluVar5 = zzlmVar4.zzbab;
                                        i10 = size6;
                                        zzlg zzlgVar2 = zzluVar5.zzbay;
                                        zzluVar5.zzbbe[i32] = zzpnVar6.zzje();
                                        zzluVar2 = zzluVar3;
                                        bArr3 = bArr4;
                                        zzluVar5.zzbbd[i32] = zzluVar5.zzbba;
                                        if ((zzav2 & 1) != 0) {
                                            long[] jArr = zzluVar5.zzbbd;
                                            zzkvVar2 = pop;
                                            i9 = i25;
                                            zzkvVar3 = zzkvVar5;
                                            jArr[i32] = jArr[i32] + zzpnVar6.readInt();
                                        } else {
                                            zzkvVar2 = pop;
                                            i9 = i25;
                                            zzkvVar3 = zzkvVar5;
                                        }
                                        boolean z6 = (zzav2 & 4) != 0;
                                        int i35 = zzlgVar2.flags;
                                        if (z6) {
                                            i35 = zzpnVar6.zzje();
                                        }
                                        boolean z7 = (zzav2 & 256) != 0;
                                        boolean z8 = (zzav2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0;
                                        boolean z9 = (zzav2 & 1024) != 0;
                                        boolean z10 = (zzav2 & 2048) != 0;
                                        if (zzlsVar3.zzbav != null) {
                                            i11 = i35;
                                            if (zzlsVar3.zzbav.length == 1 && zzlsVar3.zzbav[0] == 0) {
                                                i12 = i31;
                                                j6 = zzpt.zza(zzlsVar3.zzbaw[0], 1000L, zzlsVar3.zzdf);
                                                int[] iArr = zzluVar5.zzbbf;
                                                int[] iArr2 = zzluVar5.zzbbg;
                                                zzlmVar = zzlmVar4;
                                                long[] jArr2 = zzluVar5.zzbbh;
                                                i7 = i12;
                                                boolean[] zArr = zzluVar5.zzbbi;
                                                boolean z11 = (zzlsVar3.type == 2 || (i24 & 1) == 0) ? false : true;
                                                i13 = zzluVar5.zzbbe[i32] + i33;
                                                long j7 = zzlsVar3.zzdf;
                                                int i36 = i33;
                                                long j8 = i32 <= 0 ? zzluVar5.zzbbp : j5;
                                                i8 = i24;
                                                i14 = i36;
                                                while (i14 < i13) {
                                                    if (z7) {
                                                        z = z7;
                                                        i15 = zzpnVar6.zzje();
                                                    } else {
                                                        z = z7;
                                                        i15 = zzlgVar2.duration;
                                                    }
                                                    if (z8) {
                                                        z2 = z8;
                                                        i16 = zzpnVar6.zzje();
                                                    } else {
                                                        z2 = z8;
                                                        i16 = zzlgVar2.size;
                                                    }
                                                    if (i14 == 0 && z6) {
                                                        z3 = z6;
                                                        i17 = i11;
                                                    } else if (z9) {
                                                        z3 = z6;
                                                        i17 = zzpnVar6.readInt();
                                                    } else {
                                                        z3 = z6;
                                                        i17 = zzlgVar2.flags;
                                                    }
                                                    if (z10) {
                                                        z4 = z9;
                                                        z5 = z10;
                                                        iArr2[i14] = (int) ((zzpnVar6.readInt() * 1000) / j7);
                                                    } else {
                                                        z4 = z9;
                                                        z5 = z10;
                                                        iArr2[i14] = 0;
                                                    }
                                                    jArr2[i14] = zzpt.zza(j8, 1000L, j7) - j6;
                                                    iArr[i14] = i16;
                                                    zArr[i14] = ((i17 >> 16) & 1) == 0 && (!z11 || i14 == 0);
                                                    j8 += i15;
                                                    i14++;
                                                    z7 = z;
                                                    z8 = z2;
                                                    z6 = z3;
                                                    z9 = z4;
                                                    z10 = z5;
                                                }
                                                zzluVar5.zzbbp = j8;
                                                i33 = i13;
                                                i32 = i34;
                                            }
                                        } else {
                                            i11 = i35;
                                        }
                                        i12 = i31;
                                        int[] iArr3 = zzluVar5.zzbbf;
                                        int[] iArr22 = zzluVar5.zzbbg;
                                        zzlmVar = zzlmVar4;
                                        long[] jArr22 = zzluVar5.zzbbh;
                                        i7 = i12;
                                        boolean[] zArr2 = zzluVar5.zzbbi;
                                        if (zzlsVar3.type == 2) {
                                        }
                                        i13 = zzluVar5.zzbbe[i32] + i33;
                                        long j72 = zzlsVar3.zzdf;
                                        int i362 = i33;
                                        if (i32 <= 0) {
                                        }
                                        i8 = i24;
                                        i14 = i362;
                                        while (i14 < i13) {
                                        }
                                        zzluVar5.zzbbp = j8;
                                        i33 = i13;
                                        i32 = i34;
                                    } else {
                                        zzkvVar2 = pop;
                                        i7 = i31;
                                        i8 = i24;
                                        zzluVar2 = zzluVar3;
                                        bArr3 = bArr4;
                                        i9 = i25;
                                        zzkvVar3 = zzkvVar5;
                                        zzlmVar = zzlmVar4;
                                        list = list2;
                                        i10 = size6;
                                    }
                                    i31 = i7 + 1;
                                    list2 = list;
                                    size6 = i10;
                                    bArr4 = bArr3;
                                    zzluVar3 = zzluVar2;
                                    pop = zzkvVar2;
                                    i25 = i9;
                                    zzkvVar5 = zzkvVar3;
                                    zzlmVar4 = zzlmVar;
                                    i24 = i8;
                                }
                                zzkvVar = pop;
                                i = i24;
                                zzlu zzluVar6 = zzluVar3;
                                byte[] bArr5 = bArr4;
                                i3 = i25;
                                zzlm zzlmVar5 = zzlmVar4;
                                zzky zzas = zzkvVar5.zzas(zzkw.zzavj);
                                if (zzas != null) {
                                    zzluVar = zzluVar6;
                                    zzlr zzlrVar = zzlmVar5.zzbac.zzbau[zzluVar.zzbay.zzaxs];
                                    zzpn zzpnVar7 = zzas.zzaxd;
                                    int i37 = zzlrVar.zzbaq;
                                    zzpnVar7.zzbl(8);
                                    if ((zzkw.zzav(zzpnVar7.readInt()) & 1) == 1) {
                                        zzpnVar7.zzbm(8);
                                    }
                                    int readUnsignedByte = zzpnVar7.readUnsignedByte();
                                    int zzje2 = zzpnVar7.zzje();
                                    if (zzje2 != zzluVar.zzaxm) {
                                        int i38 = zzluVar.zzaxm;
                                        StringBuilder sb = new StringBuilder(41);
                                        sb.append("Length mismatch: ");
                                        sb.append(zzje2);
                                        sb.append(", ");
                                        sb.append(i38);
                                        throw new zzhw(sb.toString());
                                    }
                                    if (readUnsignedByte == 0) {
                                        boolean[] zArr3 = zzluVar.zzbbk;
                                        i6 = 0;
                                        for (int i39 = 0; i39 < zzje2; i39++) {
                                            int readUnsignedByte2 = zzpnVar7.readUnsignedByte();
                                            i6 += readUnsignedByte2;
                                            zArr3[i39] = readUnsignedByte2 > i37;
                                        }
                                    } else {
                                        i6 = (readUnsignedByte * zzje2) + 0;
                                        Arrays.fill(zzluVar.zzbbk, 0, zzje2, readUnsignedByte > i37);
                                    }
                                    zzluVar.zzax(i6);
                                } else {
                                    zzluVar = zzluVar6;
                                }
                                zzky zzas2 = zzkvVar5.zzas(zzkw.zzavk);
                                if (zzas2 != null) {
                                    zzpn zzpnVar8 = zzas2.zzaxd;
                                    zzpnVar8.zzbl(8);
                                    int readInt2 = zzpnVar8.readInt();
                                    if ((zzkw.zzav(readInt2) & 1) == 1) {
                                        zzpnVar8.zzbm(8);
                                    }
                                    int zzje3 = zzpnVar8.zzje();
                                    if (zzje3 != 1) {
                                        StringBuilder sb2 = new StringBuilder(40);
                                        sb2.append("Unexpected saio entry count: ");
                                        sb2.append(zzje3);
                                        throw new zzhw(sb2.toString());
                                    }
                                    zzluVar.zzbbb += zzkw.zzau(readInt2) == 0 ? zzpnVar8.zzjb() : zzpnVar8.zzjf();
                                }
                                zzky zzas3 = zzkvVar5.zzas(zzkw.zzavo);
                                if (zzas3 != null) {
                                    zza(zzas3.zzaxd, 0, zzluVar);
                                }
                                zzky zzas4 = zzkvVar5.zzas(zzkw.zzavl);
                                zzky zzas5 = zzkvVar5.zzas(zzkw.zzavm);
                                if (zzas4 != null && zzas5 != null) {
                                    zzpn zzpnVar9 = zzas4.zzaxd;
                                    zzpn zzpnVar10 = zzas5.zzaxd;
                                    zzpnVar9.zzbl(8);
                                    int readInt3 = zzpnVar9.readInt();
                                    if (zzpnVar9.readInt() == zzaxt) {
                                        if (zzkw.zzau(readInt3) == 1) {
                                            zzpnVar9.zzbm(4);
                                        }
                                        if (zzpnVar9.readInt() != 1) {
                                            throw new zzhw("Entry count in sbgp != 1 (unsupported).");
                                        }
                                        zzpnVar10.zzbl(8);
                                        int readInt4 = zzpnVar10.readInt();
                                        if (zzpnVar10.readInt() == zzaxt) {
                                            int zzau = zzkw.zzau(readInt4);
                                            if (zzau != 1) {
                                                i5 = 2;
                                                if (zzau >= 2) {
                                                    zzpnVar10.zzbm(4);
                                                }
                                            } else if (zzpnVar10.zzjb() == 0) {
                                                throw new zzhw("Variable length decription in sgpd found (unsupported)");
                                            } else {
                                                i5 = 2;
                                            }
                                            if (zzpnVar10.zzjb() != 1) {
                                                throw new zzhw("Entry count in sgpd != 1 (unsupported).");
                                            }
                                            zzpnVar10.zzbm(i5);
                                            if (zzpnVar10.readUnsignedByte() == 1) {
                                                int readUnsignedByte3 = zzpnVar10.readUnsignedByte();
                                                byte[] bArr6 = new byte[16];
                                                zzpnVar10.zze(bArr6, 0, 16);
                                                zzluVar.zzbbj = true;
                                                zzluVar.zzbbl = new zzlr(true, readUnsignedByte3, bArr6);
                                            }
                                        }
                                        size = zzkvVar5.zzatf.size();
                                        i4 = 0;
                                        while (i4 < size) {
                                            zzky zzkyVar4 = zzkvVar5.zzatf.get(i4);
                                            if (zzkyVar4.type == zzkw.zzavn) {
                                                zzpn zzpnVar11 = zzkyVar4.zzaxd;
                                                zzpnVar11.zzbl(8);
                                                bArr2 = bArr5;
                                                zzpnVar11.zze(bArr2, 0, 16);
                                                if (Arrays.equals(bArr2, zzaxu)) {
                                                    zza(zzpnVar11, 16, zzluVar);
                                                }
                                            } else {
                                                bArr2 = bArr5;
                                            }
                                            i4++;
                                            bArr5 = bArr2;
                                        }
                                        bArr = bArr5;
                                        i25 = i3 + 1;
                                        bArr4 = bArr;
                                        sparseArray6 = sparseArray2;
                                        size5 = i2;
                                        pop = zzkvVar;
                                        i24 = i;
                                        zzlmVar2 = null;
                                    }
                                }
                                size = zzkvVar5.zzatf.size();
                                i4 = 0;
                                while (i4 < size) {
                                }
                                bArr = bArr5;
                                i25 = i3 + 1;
                                bArr4 = bArr;
                                sparseArray6 = sparseArray2;
                                size5 = i2;
                                pop = zzkvVar;
                                i24 = i;
                                zzlmVar2 = null;
                            }
                        }
                        zzkvVar = pop;
                        sparseArray2 = sparseArray6;
                        i = i24;
                        i2 = size5;
                        i3 = i25;
                        bArr = bArr4;
                        i25 = i3 + 1;
                        bArr4 = bArr;
                        sparseArray6 = sparseArray2;
                        size5 = i2;
                        pop = zzkvVar;
                        i24 = i;
                        zzlmVar2 = null;
                    }
                    zzjo zzb2 = zzb(pop.zzatf);
                    zzlhVar = this;
                    if (zzb2 != null) {
                        int size7 = zzlhVar.zzaxw.size();
                        for (int i40 = 0; i40 < size7; i40++) {
                            zzlm valueAt = zzlhVar.zzaxw.valueAt(i40);
                            valueAt.zzasz.zze(valueAt.zzbac.zzaij.zza(zzb2));
                        }
                    }
                } else {
                    zzlhVar = zzlhVar2;
                    if (!zzlhVar.zzayd.isEmpty()) {
                        zzlhVar.zzayd.peek().zza(pop);
                    }
                }
                zzlhVar2 = zzlhVar;
            }
        }
        zzhf();
    }

    private static void zza(zzpn zzpnVar, int i, zzlu zzluVar) {
        zzpnVar.zzbl(i + 8);
        int zzav = zzkw.zzav(zzpnVar.readInt());
        if ((zzav & 1) != 0) {
            throw new zzhw("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (zzav & 2) != 0;
        int zzje = zzpnVar.zzje();
        if (zzje != zzluVar.zzaxm) {
            int i2 = zzluVar.zzaxm;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzje);
            sb.append(", ");
            sb.append(i2);
            throw new zzhw(sb.toString());
        }
        Arrays.fill(zzluVar.zzbbk, 0, zzje, z);
        zzluVar.zzax(zzpnVar.zziz());
        zzpnVar.zze(zzluVar.zzbbn.data, 0, zzluVar.zzbbm);
        zzluVar.zzbbn.zzbl(0);
        zzluVar.zzbbo = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzjo zzb(List<zzky> list) {
        Pair create;
        UUID uuid;
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            zzky zzkyVar = list.get(i);
            if (zzkyVar.type == zzkw.zzavb) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = zzkyVar.zzaxd.data;
                zzpn zzpnVar = new zzpn(bArr);
                if (zzpnVar.limit() >= 32) {
                    zzpnVar.zzbl(0);
                    if (zzpnVar.readInt() == zzpnVar.zziz() + 4 && zzpnVar.readInt() == zzkw.zzavb) {
                        int zzau = zzkw.zzau(zzpnVar.readInt());
                        if (zzau > 1) {
                            StringBuilder sb = new StringBuilder(37);
                            sb.append("Unsupported pssh version: ");
                            sb.append(zzau);
                            Log.w("PsshAtomUtil", sb.toString());
                        } else {
                            UUID uuid2 = new UUID(zzpnVar.readLong(), zzpnVar.readLong());
                            if (zzau == 1) {
                                zzpnVar.zzbm(zzpnVar.zzje() << 4);
                            }
                            int zzje = zzpnVar.zzje();
                            if (zzje == zzpnVar.zziz()) {
                                byte[] bArr2 = new byte[zzje];
                                zzpnVar.zze(bArr2, 0, zzje);
                                create = Pair.create(uuid2, bArr2);
                                uuid = create != null ? null : (UUID) create.first;
                                if (uuid != null) {
                                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                                } else {
                                    arrayList.add(new zzjo.zza(uuid, "video/mp4", bArr));
                                }
                            }
                        }
                    }
                }
                create = null;
                if (create != null) {
                }
                if (uuid != null) {
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzjo(arrayList);
    }
}
