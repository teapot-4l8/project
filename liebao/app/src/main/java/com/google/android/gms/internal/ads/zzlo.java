package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzlo implements zzka, zzkf {
    private static final zzkb zzapu = new zzln();
    private static final int zzbaj = zzpt.zzbh("qt  ");
    private long zzaiz;
    private int zzarq;
    private int zzarr;
    private zzkc zzaru;
    private int zzayf;
    private int zzayg;
    private long zzayh;
    private int zzayi;
    private zzpn zzayj;
    private zzlq[] zzbak;
    private boolean zzbal;
    private final zzpn zzayb = new zzpn(16);
    private final Stack<zzkv> zzayd = new Stack<>();
    private final zzpn zzaqb = new zzpn(zzpm.zzbkd);
    private final zzpn zzaqc = new zzpn(4);

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final boolean zza(zzjz zzjzVar) {
        return zzlp.zze(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar) {
        this.zzaru = zzkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zzc(long j, long j2) {
        this.zzayd.clear();
        this.zzayi = 0;
        this.zzarr = 0;
        this.zzarq = 0;
        if (j == 0) {
            zzhf();
            return;
        }
        zzlq[] zzlqVarArr = this.zzbak;
        if (zzlqVarArr != null) {
            for (zzlq zzlqVar : zzlqVarArr) {
                zzlt zzltVar = zzlqVar.zzban;
                int zzec = zzltVar.zzec(j2);
                if (zzec == -1) {
                    zzec = zzltVar.zzed(j2);
                }
                zzlqVar.zzaxq = zzec;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(zzjz zzjzVar, zzkg zzkgVar) {
        zzlq[] zzlqVarArr;
        boolean z;
        boolean z2;
        boolean z3;
        while (true) {
            int i = this.zzayf;
            if (i == 0) {
                if (this.zzayi == 0) {
                    if (zzjzVar.zza(this.zzayb.data, 0, 8, true)) {
                        this.zzayi = 8;
                        this.zzayb.zzbl(0);
                        this.zzayh = this.zzayb.zzjb();
                        this.zzayg = this.zzayb.readInt();
                    } else {
                        z3 = false;
                        if (z3) {
                            return -1;
                        }
                    }
                }
                if (this.zzayh == 1) {
                    zzjzVar.readFully(this.zzayb.data, 8, 8);
                    this.zzayi += 8;
                    this.zzayh = this.zzayb.zzjf();
                }
                int i2 = this.zzayg;
                if (i2 == zzkw.zzaui || i2 == zzkw.zzauk || i2 == zzkw.zzaul || i2 == zzkw.zzaum || i2 == zzkw.zzaun || i2 == zzkw.zzauw) {
                    long position = (zzjzVar.getPosition() + this.zzayh) - this.zzayi;
                    this.zzayd.add(new zzkv(this.zzayg, position));
                    if (this.zzayh == this.zzayi) {
                        zzeb(position);
                    } else {
                        zzhf();
                    }
                } else {
                    int i3 = this.zzayg;
                    if (i3 == zzkw.zzauy || i3 == zzkw.zzauj || i3 == zzkw.zzauz || i3 == zzkw.zzava || i3 == zzkw.zzavt || i3 == zzkw.zzavu || i3 == zzkw.zzavv || i3 == zzkw.zzaux || i3 == zzkw.zzavw || i3 == zzkw.zzavx || i3 == zzkw.zzavy || i3 == zzkw.zzavz || i3 == zzkw.zzawa || i3 == zzkw.zzauv || i3 == zzkw.zzath || i3 == zzkw.zzawh) {
                        zzpg.checkState(this.zzayi == 8);
                        zzpg.checkState(this.zzayh <= 2147483647L);
                        this.zzayj = new zzpn((int) this.zzayh);
                        System.arraycopy(this.zzayb.data, 0, this.zzayj.data, 0, 8);
                        this.zzayf = 1;
                    } else {
                        this.zzayj = null;
                        this.zzayf = 1;
                    }
                }
                z3 = true;
                if (z3) {
                }
            } else if (i != 1) {
                if (i == 2) {
                    long j = Long.MAX_VALUE;
                    int i4 = 0;
                    int i5 = -1;
                    while (true) {
                        zzlqVarArr = this.zzbak;
                        if (i4 >= zzlqVarArr.length) {
                            break;
                        }
                        zzlq zzlqVar = zzlqVarArr[i4];
                        int i6 = zzlqVar.zzaxq;
                        if (i6 != zzlqVar.zzban.zzaxm) {
                            long j2 = zzlqVar.zzban.zzapf[i6];
                            if (j2 < j) {
                                i5 = i4;
                                j = j2;
                            }
                        }
                        i4++;
                    }
                    if (i5 == -1) {
                        return -1;
                    }
                    zzlq zzlqVar2 = zzlqVarArr[i5];
                    zzkh zzkhVar = zzlqVar2.zzbao;
                    int i7 = zzlqVar2.zzaxq;
                    long j3 = zzlqVar2.zzban.zzapf[i7];
                    int i8 = zzlqVar2.zzban.zzape[i7];
                    if (zzlqVar2.zzbac.zzbat == 1) {
                        j3 += 8;
                        i8 -= 8;
                    }
                    long position2 = (j3 - zzjzVar.getPosition()) + this.zzarr;
                    if (position2 < 0 || position2 >= 262144) {
                        zzkgVar.position = j3;
                        return 1;
                    }
                    zzjzVar.zzaj((int) position2);
                    if (zzlqVar2.zzbac.zzata == 0) {
                        while (true) {
                            int i9 = this.zzarr;
                            if (i9 >= i8) {
                                break;
                            }
                            int zza = zzkhVar.zza(zzjzVar, i8 - i9, false);
                            this.zzarr += zza;
                            this.zzarq -= zza;
                        }
                    } else {
                        byte[] bArr = this.zzaqc.data;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        int i10 = zzlqVar2.zzbac.zzata;
                        int i11 = 4 - zzlqVar2.zzbac.zzata;
                        while (this.zzarr < i8) {
                            int i12 = this.zzarq;
                            if (i12 == 0) {
                                zzjzVar.readFully(this.zzaqc.data, i11, i10);
                                this.zzaqc.zzbl(0);
                                this.zzarq = this.zzaqc.zzje();
                                this.zzaqb.zzbl(0);
                                zzkhVar.zza(this.zzaqb, 4);
                                this.zzarr += 4;
                                i8 += i11;
                            } else {
                                int zza2 = zzkhVar.zza(zzjzVar, i12, false);
                                this.zzarr += zza2;
                                this.zzarq -= zza2;
                            }
                        }
                    }
                    zzkhVar.zza(zzlqVar2.zzban.zzbax[i7], zzlqVar2.zzban.zzayv[i7], i8, 0, null);
                    zzlqVar2.zzaxq++;
                    this.zzarr = 0;
                    this.zzarq = 0;
                    return 0;
                }
                throw new IllegalStateException();
            } else {
                long j4 = this.zzayh - this.zzayi;
                long position3 = zzjzVar.getPosition() + j4;
                zzpn zzpnVar = this.zzayj;
                if (zzpnVar != null) {
                    zzjzVar.readFully(zzpnVar.data, this.zzayi, (int) j4);
                    if (this.zzayg == zzkw.zzath) {
                        zzpn zzpnVar2 = this.zzayj;
                        zzpnVar2.zzbl(8);
                        if (zzpnVar2.readInt() == zzbaj) {
                            z2 = true;
                            break;
                        }
                        zzpnVar2.zzbm(4);
                        while (zzpnVar2.zziz() > 0) {
                            if (zzpnVar2.readInt() == zzbaj) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        this.zzbal = z2;
                    } else if (!this.zzayd.isEmpty()) {
                        this.zzayd.peek().zza(new zzky(this.zzayg, this.zzayj));
                    }
                } else if (j4 < 262144) {
                    zzjzVar.zzaj((int) j4);
                } else {
                    zzkgVar.position = zzjzVar.getPosition() + j4;
                    z = true;
                    zzeb(position3);
                    if (!((z || this.zzayf == 2) ? false : true)) {
                        return 1;
                    }
                }
                z = false;
                zzeb(position3);
                if (!((z || this.zzayf == 2) ? false : true)) {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long getDurationUs() {
        return this.zzaiz;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long zzdz(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzlq zzlqVar : this.zzbak) {
            zzlt zzltVar = zzlqVar.zzban;
            int zzec = zzltVar.zzec(j);
            if (zzec == -1) {
                zzec = zzltVar.zzed(j);
            }
            long j3 = zzltVar.zzapf[zzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void zzhf() {
        this.zzayf = 0;
        this.zzayi = 0;
    }

    private final void zzeb(long j) {
        zzmh zzmhVar;
        zzke zzkeVar;
        zzls zza;
        while (!this.zzayd.isEmpty() && this.zzayd.peek().zzate == j) {
            zzkv pop = this.zzayd.pop();
            if (pop.type == zzkw.zzaui) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                long j3 = Long.MAX_VALUE;
                zzmh zzmhVar2 = null;
                zzke zzkeVar2 = new zzke();
                zzky zzas = pop.zzas(zzkw.zzawh);
                if (zzas != null && (zzmhVar2 = zzkx.zza(zzas, this.zzbal)) != null) {
                    zzkeVar2.zzb(zzmhVar2);
                }
                int i = 0;
                while (i < pop.zzatg.size()) {
                    zzkv zzkvVar = pop.zzatg.get(i);
                    if (zzkvVar.type == zzkw.zzauk && (zza = zzkx.zza(zzkvVar, pop.zzas(zzkw.zzauj), -9223372036854775807L, (zzjo) null, this.zzbal)) != null) {
                        zzlt zza2 = zzkx.zza(zza, zzkvVar.zzat(zzkw.zzaul).zzat(zzkw.zzaum).zzat(zzkw.zzaun), zzkeVar2);
                        if (zza2.zzaxm != 0) {
                            zzlq zzlqVar = new zzlq(zza, zza2, this.zzaru.zze(i, zza.type));
                            zzht zzy = zza.zzaij.zzy(zza2.zzayt + 30);
                            if (zza.type == 1) {
                                if (zzkeVar2.zzgx()) {
                                    zzy = zzy.zzd(zzkeVar2.zzaib, zzkeVar2.zzaic);
                                }
                                if (zzmhVar2 != null) {
                                    zzy = zzy.zza(zzmhVar2);
                                }
                            }
                            zzlqVar.zzbao.zze(zzy);
                            zzmhVar = zzmhVar2;
                            zzkeVar = zzkeVar2;
                            j2 = Math.max(j2, zza.zzaiz);
                            arrayList.add(zzlqVar);
                            long j4 = zza2.zzapf[0];
                            if (j4 < j3) {
                                j3 = j4;
                            }
                            i++;
                            zzkeVar2 = zzkeVar;
                            zzmhVar2 = zzmhVar;
                        }
                    }
                    zzmhVar = zzmhVar2;
                    zzkeVar = zzkeVar2;
                    i++;
                    zzkeVar2 = zzkeVar;
                    zzmhVar2 = zzmhVar;
                }
                this.zzaiz = j2;
                this.zzbak = (zzlq[]) arrayList.toArray(new zzlq[arrayList.size()]);
                this.zzaru.zzgw();
                this.zzaru.zza(this);
                this.zzayd.clear();
                this.zzayf = 2;
            } else if (!this.zzayd.isEmpty()) {
                this.zzayd.peek().zza(pop);
            }
        }
        if (this.zzayf != 2) {
            zzhf();
        }
    }
}
