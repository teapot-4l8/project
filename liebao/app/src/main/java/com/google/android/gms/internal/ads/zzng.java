package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzng implements zznb, zznc {
    private zznu zzafn;
    private zznb zzbei;
    public final zznc[] zzbfp;
    private final IdentityHashMap<zznn, Integer> zzbfq = new IdentityHashMap<>();
    private int zzbfr;
    private zznc[] zzbfs;
    private zznq zzbft;

    public zzng(zznc... zzncVarArr) {
        this.zzbfp = zzncVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zza(zznb zznbVar, long j) {
        this.zzbei = zznbVar;
        zznc[] zzncVarArr = this.zzbfp;
        this.zzbfr = zzncVarArr.length;
        for (zznc zzncVar : zzncVarArr) {
            zzncVar.zza(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzhs() {
        for (zznc zzncVar : this.zzbfp) {
            zzncVar.zzhs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final zznu zzht() {
        return this.zzafn;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zza(zzog[] zzogVarArr, boolean[] zArr, zznn[] zznnVarArr, boolean[] zArr2, long j) {
        zznn[] zznnVarArr2 = zznnVarArr;
        int[] iArr = new int[zzogVarArr.length];
        int[] iArr2 = new int[zzogVarArr.length];
        for (int i = 0; i < zzogVarArr.length; i++) {
            iArr[i] = zznnVarArr2[i] == null ? -1 : this.zzbfq.get(zznnVarArr2[i]).intValue();
            iArr2[i] = -1;
            if (zzogVarArr[i] != null) {
                zznr zzip = zzogVarArr[i].zzip();
                int i2 = 0;
                while (true) {
                    zznc[] zzncVarArr = this.zzbfp;
                    if (i2 >= zzncVarArr.length) {
                        break;
                    } else if (zzncVarArr[i2].zzht().zza(zzip) != -1) {
                        iArr2[i] = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        this.zzbfq.clear();
        int length = zzogVarArr.length;
        zznn[] zznnVarArr3 = new zznn[length];
        zznn[] zznnVarArr4 = new zznn[zzogVarArr.length];
        zzog[] zzogVarArr2 = new zzog[zzogVarArr.length];
        ArrayList arrayList = new ArrayList(this.zzbfp.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.zzbfp.length) {
            for (int i4 = 0; i4 < zzogVarArr.length; i4++) {
                zzog zzogVar = null;
                zznnVarArr4[i4] = iArr[i4] == i3 ? zznnVarArr2[i4] : null;
                if (iArr2[i4] == i3) {
                    zzogVar = zzogVarArr[i4];
                }
                zzogVarArr2[i4] = zzogVar;
            }
            int i5 = i3;
            zzog[] zzogVarArr3 = zzogVarArr2;
            ArrayList arrayList2 = arrayList;
            long zza = this.zzbfp[i3].zza(zzogVarArr2, zArr, zznnVarArr4, zArr2, j2);
            if (i5 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzogVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzpg.checkState(zznnVarArr4[i6] != null);
                    zznnVarArr3[i6] = zznnVarArr4[i6];
                    this.zzbfq.put(zznnVarArr4[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzpg.checkState(zznnVarArr4[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.zzbfp[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzogVarArr2 = zzogVarArr3;
            zznnVarArr2 = zznnVarArr;
        }
        zznn[] zznnVarArr5 = zznnVarArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zznnVarArr3, 0, zznnVarArr5, 0, length);
        zznc[] zzncVarArr2 = new zznc[arrayList3.size()];
        this.zzbfs = zzncVarArr2;
        arrayList3.toArray(zzncVarArr2);
        this.zzbft = new zzmp(this.zzbfs);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzef(long j) {
        for (zznc zzncVar : this.zzbfs) {
            zzncVar.zzef(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final boolean zzee(long j) {
        return this.zzbft.zzee(j);
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final long zzhr() {
        return this.zzbft.zzhr();
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhu() {
        zznc[] zzncVarArr;
        long zzhu = this.zzbfp[0].zzhu();
        int i = 1;
        while (true) {
            zznc[] zzncVarArr2 = this.zzbfp;
            if (i >= zzncVarArr2.length) {
                if (zzhu != -9223372036854775807L) {
                    for (zznc zzncVar : this.zzbfs) {
                        if (zzncVar != this.zzbfp[0] && zzncVar.zzeg(zzhu) != zzhu) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhu;
            } else if (zzncVarArr2[i].zzhu() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            } else {
                i++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhv() {
        long j = Long.MAX_VALUE;
        for (zznc zzncVar : this.zzbfs) {
            long zzhv = zzncVar.zzhv();
            if (zzhv != Long.MIN_VALUE) {
                j = Math.min(j, zzhv);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzeg(long j) {
        long zzeg = this.zzbfs[0].zzeg(j);
        int i = 1;
        while (true) {
            zznc[] zzncVarArr = this.zzbfs;
            if (i >= zzncVarArr.length) {
                return zzeg;
            }
            if (zzncVarArr[i].zzeg(zzeg) != zzeg) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i++;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zznc zzncVar) {
        int i = this.zzbfr - 1;
        this.zzbfr = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (zznc zzncVar2 : this.zzbfp) {
            i2 += zzncVar2.zzht().length;
        }
        zznr[] zznrVarArr = new zznr[i2];
        int i3 = 0;
        for (zznc zzncVar3 : this.zzbfp) {
            zznu zzht = zzncVar3.zzht();
            int i4 = zzht.length;
            int i5 = 0;
            while (i5 < i4) {
                zznrVarArr[i3] = zzht.zzbf(i5);
                i5++;
                i3++;
            }
        }
        this.zzafn = new zznu(zznrVarArr);
        this.zzbei.zza((zznc) this);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final /* synthetic */ void zza(zznc zzncVar) {
        if (this.zzafn != null) {
            this.zzbei.zza((zznb) this);
        }
    }
}
