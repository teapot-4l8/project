package com.google.android.gms.internal.ads;

import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzkj implements zzko {
    private final byte[] zzapk = new byte[8];
    private final Stack<zzkl> zzapl = new Stack<>();
    private final zzkt zzapm = new zzkt();
    private zzkn zzapn;
    private int zzapo;
    private int zzapp;
    private long zzapq;

    @Override // com.google.android.gms.internal.ads.zzko
    public final void zza(zzkn zzknVar) {
        this.zzapn = zzknVar;
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final void reset() {
        this.zzapo = 0;
        this.zzapl.clear();
        this.zzapm.reset();
    }

    @Override // com.google.android.gms.internal.ads.zzko
    public final boolean zzb(zzjz zzjzVar) {
        String str;
        double longBitsToDouble;
        int zzar;
        int zza;
        long j;
        int i;
        zzpg.checkState(this.zzapn != null);
        while (true) {
            if (!this.zzapl.isEmpty()) {
                long position = zzjzVar.getPosition();
                j = this.zzapl.peek().zzapt;
                if (position >= j) {
                    zzkn zzknVar = this.zzapn;
                    i = this.zzapl.pop().zzapp;
                    zzknVar.zzaq(i);
                    return true;
                }
            }
            if (this.zzapo == 0) {
                long zza2 = this.zzapm.zza(zzjzVar, true, false, 4);
                if (zza2 == -2) {
                    zzjzVar.zzgu();
                    while (true) {
                        zzjzVar.zza(this.zzapk, 0, 4);
                        zzar = zzkt.zzar(this.zzapk[0]);
                        if (zzar != -1 && zzar <= 4) {
                            zza = (int) zzkt.zza(this.zzapk, zzar, false);
                            if (this.zzapn.zzap(zza)) {
                                break;
                            }
                        }
                        zzjzVar.zzaj(1);
                    }
                    zzjzVar.zzaj(zzar);
                    zza2 = zza;
                }
                if (zza2 == -1) {
                    return false;
                }
                this.zzapp = (int) zza2;
                this.zzapo = 1;
            }
            if (this.zzapo == 1) {
                this.zzapq = this.zzapm.zza(zzjzVar, false, true, 8);
                this.zzapo = 2;
            }
            int zzao = this.zzapn.zzao(this.zzapp);
            if (zzao != 0) {
                if (zzao == 1) {
                    long position2 = zzjzVar.getPosition();
                    this.zzapl.add(new zzkl(this.zzapp, this.zzapq + position2));
                    this.zzapn.zzd(this.zzapp, position2, this.zzapq);
                    this.zzapo = 0;
                    return true;
                } else if (zzao == 2) {
                    long j2 = this.zzapq;
                    if (j2 > 8) {
                        long j3 = this.zzapq;
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j3);
                        throw new zzhw(sb.toString());
                    }
                    this.zzapn.zzd(this.zzapp, zza(zzjzVar, (int) j2));
                    this.zzapo = 0;
                    return true;
                } else if (zzao == 3) {
                    long j4 = this.zzapq;
                    if (j4 > 2147483647L) {
                        long j5 = this.zzapq;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j5);
                        throw new zzhw(sb2.toString());
                    }
                    zzkn zzknVar2 = this.zzapn;
                    int i2 = this.zzapp;
                    int i3 = (int) j4;
                    if (i3 == 0) {
                        str = "";
                    } else {
                        byte[] bArr = new byte[i3];
                        zzjzVar.readFully(bArr, 0, i3);
                        str = new String(bArr);
                    }
                    zzknVar2.zza(i2, str);
                    this.zzapo = 0;
                    return true;
                } else if (zzao == 4) {
                    this.zzapn.zza(this.zzapp, (int) this.zzapq, zzjzVar);
                    this.zzapo = 0;
                    return true;
                } else if (zzao == 5) {
                    long j6 = this.zzapq;
                    if (j6 != 4 && j6 != 8) {
                        long j7 = this.zzapq;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j7);
                        throw new zzhw(sb3.toString());
                    }
                    zzkn zzknVar3 = this.zzapn;
                    int i4 = this.zzapp;
                    int i5 = (int) this.zzapq;
                    long zza3 = zza(zzjzVar, i5);
                    if (i5 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) zza3);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(zza3);
                    }
                    zzknVar3.zza(i4, longBitsToDouble);
                    this.zzapo = 0;
                    return true;
                } else {
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(zzao);
                    throw new zzhw(sb4.toString());
                }
            }
            zzjzVar.zzaj((int) this.zzapq);
            this.zzapo = 0;
        }
    }

    private final long zza(zzjz zzjzVar, int i) {
        zzjzVar.readFully(this.zzapk, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.zzapk[i2] & 255);
        }
        return j;
    }
}
