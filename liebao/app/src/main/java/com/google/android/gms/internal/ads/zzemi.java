package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzemi implements zzepc {
    private int tag;
    private final zzemb zziqc;
    private int zziqd;
    private int zziqe = 0;

    public static zzemi zza(zzemb zzembVar) {
        if (zzembVar.zzipr != null) {
            return zzembVar.zzipr;
        }
        return new zzemi(zzembVar);
    }

    private zzemi(zzemb zzembVar) {
        zzemb zzembVar2 = (zzemb) zzenc.zza(zzembVar, "input");
        this.zziqc = zzembVar2;
        zzembVar2.zzipr = this;
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int zzbip() {
        int i = this.zziqe;
        if (i != 0) {
            this.tag = i;
            this.zziqe = 0;
        } else {
            this.tag = this.zziqc.zzbhr();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zziqd) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final boolean zzbiq() {
        int i;
        if (this.zziqc.zzbih() || (i = this.tag) == this.zziqd) {
            return false;
        }
        return this.zziqc.zzgm(i);
    }

    private final void zzgv(int i) {
        if ((this.tag & 7) != i) {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final double readDouble() {
        zzgv(1);
        return this.zziqc.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final float readFloat() {
        zzgv(5);
        return this.zziqc.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final long zzbhs() {
        zzgv(0);
        return this.zziqc.zzbhs();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final long zzbht() {
        zzgv(0);
        return this.zziqc.zzbht();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int zzbhu() {
        zzgv(0);
        return this.zziqc.zzbhu();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final long zzbhv() {
        zzgv(1);
        return this.zziqc.zzbhv();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int zzbhw() {
        zzgv(5);
        return this.zziqc.zzbhw();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final boolean zzbhx() {
        zzgv(0);
        return this.zziqc.zzbhx();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final String readString() {
        zzgv(2);
        return this.zziqc.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final String zzbhy() {
        zzgv(2);
        return this.zziqc.zzbhy();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final <T> T zza(zzepi<T> zzepiVar, zzemn zzemnVar) {
        zzgv(2);
        return (T) zzc(zzepiVar, zzemnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final <T> T zzb(zzepi<T> zzepiVar, zzemn zzemnVar) {
        zzgv(3);
        return (T) zzd(zzepiVar, zzemnVar);
    }

    private final <T> T zzc(zzepi<T> zzepiVar, zzemn zzemnVar) {
        int zzbia = this.zziqc.zzbia();
        if (this.zziqc.zzipo >= this.zziqc.zzipp) {
            throw new zzenn("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzgn = this.zziqc.zzgn(zzbia);
        T newInstance = zzepiVar.newInstance();
        this.zziqc.zzipo++;
        zzepiVar.zza(newInstance, this, zzemnVar);
        zzepiVar.zzak(newInstance);
        this.zziqc.zzgl(0);
        zzemb zzembVar = this.zziqc;
        zzembVar.zzipo--;
        this.zziqc.zzgo(zzgn);
        return newInstance;
    }

    private final <T> T zzd(zzepi<T> zzepiVar, zzemn zzemnVar) {
        int i = this.zziqd;
        this.zziqd = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzepiVar.newInstance();
            zzepiVar.zza(newInstance, this, zzemnVar);
            zzepiVar.zzak(newInstance);
            if (this.tag == this.zziqd) {
                return newInstance;
            }
            throw zzenn.zzbkg();
        } finally {
            this.zziqd = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final zzelq zzbhz() {
        zzgv(2);
        return this.zziqc.zzbhz();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int zzbia() {
        zzgv(0);
        return this.zziqc.zzbia();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int zzbib() {
        zzgv(0);
        return this.zziqc.zzbib();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int zzbic() {
        zzgv(5);
        return this.zziqc.zzbic();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final long zzbid() {
        zzgv(1);
        return this.zziqc.zzbid();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final int zzbie() {
        zzgv(0);
        return this.zziqc.zzbie();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final long zzbif() {
        zzgv(0);
        return this.zziqc.zzbif();
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzm(List<Double> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeml) {
            zzeml zzemlVar = (zzeml) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzemlVar.zze(this.zziqc.readDouble());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgw(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzemlVar.zze(this.zziqc.readDouble());
                } while (this.zziqc.zzbii() < zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(this.zziqc.readDouble()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbia2 = this.zziqc.zzbia();
            zzgw(zzbia2);
            int zzbii2 = this.zziqc.zzbii() + zzbia2;
            do {
                list.add(Double.valueOf(this.zziqc.readDouble()));
            } while (this.zziqc.zzbii() < zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzn(List<Float> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzemz) {
            zzemz zzemzVar = (zzemz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgx(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzemzVar.zzh(this.zziqc.readFloat());
                } while (this.zziqc.zzbii() < zzbii);
                return;
            } else if (i == 5) {
                do {
                    zzemzVar.zzh(this.zziqc.readFloat());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int zzbia2 = this.zziqc.zzbia();
            zzgx(zzbia2);
            int zzbii2 = this.zziqc.zzbii() + zzbia2;
            do {
                list.add(Float.valueOf(this.zziqc.readFloat()));
            } while (this.zziqc.zzbii() < zzbii2);
        } else if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.zziqc.readFloat()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzo(List<Long> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeobVar.zzfs(this.zziqc.zzbhs());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzeobVar.zzfs(this.zziqc.zzbhs());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zziqc.zzbhs()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Long.valueOf(this.zziqc.zzbhs()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzp(List<Long> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeobVar.zzfs(this.zziqc.zzbht());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzeobVar.zzfs(this.zziqc.zzbht());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zziqc.zzbht()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Long.valueOf(this.zziqc.zzbht()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzq(List<Integer> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzendVar.zzhp(this.zziqc.zzbhu());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzendVar.zzhp(this.zziqc.zzbhu());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zziqc.zzbhu()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Integer.valueOf(this.zziqc.zzbhu()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzr(List<Long> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzeobVar.zzfs(this.zziqc.zzbhv());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgw(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzeobVar.zzfs(this.zziqc.zzbhv());
                } while (this.zziqc.zzbii() < zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zziqc.zzbhv()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbia2 = this.zziqc.zzbia();
            zzgw(zzbia2);
            int zzbii2 = this.zziqc.zzbii() + zzbia2;
            do {
                list.add(Long.valueOf(this.zziqc.zzbhv()));
            } while (this.zziqc.zzbii() < zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzs(List<Integer> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgx(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzendVar.zzhp(this.zziqc.zzbhw());
                } while (this.zziqc.zzbii() < zzbii);
                return;
            } else if (i == 5) {
                do {
                    zzendVar.zzhp(this.zziqc.zzbhw());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int zzbia2 = this.zziqc.zzbia();
            zzgx(zzbia2);
            int zzbii2 = this.zziqc.zzbii() + zzbia2;
            do {
                list.add(Integer.valueOf(this.zziqc.zzbhw()));
            } while (this.zziqc.zzbii() < zzbii2);
        } else if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zziqc.zzbhw()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzt(List<Boolean> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzelo) {
            zzelo zzeloVar = (zzelo) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeloVar.addBoolean(this.zziqc.zzbhx());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzeloVar.addBoolean(this.zziqc.zzbhx());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.zziqc.zzbhx()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Boolean.valueOf(this.zziqc.zzbhx()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void readStringList(List<String> list) {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzu(List<String> list) {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) {
        int zzbhr;
        int zzbhr2;
        if ((this.tag & 7) != 2) {
            throw zzenn.zzbke();
        }
        if ((list instanceof zzenu) && !z) {
            zzenu zzenuVar = (zzenu) list;
            do {
                zzenuVar.zzak(zzbhz());
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr2 = this.zziqc.zzbhr();
            } while (zzbhr2 == this.tag);
            this.zziqe = zzbhr2;
            return;
        }
        do {
            list.add(z ? zzbhy() : readString());
            if (this.zziqc.zzbih()) {
                return;
            }
            zzbhr = this.zziqc.zzbhr();
        } while (zzbhr == this.tag);
        this.zziqe = zzbhr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzepc
    public final <T> void zza(List<T> list, zzepi<T> zzepiVar, zzemn zzemnVar) {
        int zzbhr;
        int i = this.tag;
        if ((i & 7) != 2) {
            throw zzenn.zzbke();
        }
        do {
            list.add(zzc(zzepiVar, zzemnVar));
            if (this.zziqc.zzbih() || this.zziqe != 0) {
                return;
            }
            zzbhr = this.zziqc.zzbhr();
        } while (zzbhr == i);
        this.zziqe = zzbhr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzepc
    public final <T> void zzb(List<T> list, zzepi<T> zzepiVar, zzemn zzemnVar) {
        int zzbhr;
        int i = this.tag;
        if ((i & 7) != 3) {
            throw zzenn.zzbke();
        }
        do {
            list.add(zzd(zzepiVar, zzemnVar));
            if (this.zziqc.zzbih() || this.zziqe != 0) {
                return;
            }
            zzbhr = this.zziqc.zzbhr();
        } while (zzbhr == i);
        this.zziqe = zzbhr;
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzv(List<zzelq> list) {
        int zzbhr;
        if ((this.tag & 7) != 2) {
            throw zzenn.zzbke();
        }
        do {
            list.add(zzbhz());
            if (this.zziqc.zzbih()) {
                return;
            }
            zzbhr = this.zziqc.zzbhr();
        } while (zzbhr == this.tag);
        this.zziqe = zzbhr;
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzw(List<Integer> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzendVar.zzhp(this.zziqc.zzbia());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzendVar.zzhp(this.zziqc.zzbia());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zziqc.zzbia()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Integer.valueOf(this.zziqc.zzbia()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzx(List<Integer> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzendVar.zzhp(this.zziqc.zzbib());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzendVar.zzhp(this.zziqc.zzbib());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zziqc.zzbib()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Integer.valueOf(this.zziqc.zzbib()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzy(List<Integer> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgx(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzendVar.zzhp(this.zziqc.zzbic());
                } while (this.zziqc.zzbii() < zzbii);
                return;
            } else if (i == 5) {
                do {
                    zzendVar.zzhp(this.zziqc.zzbic());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 2) {
            int zzbia2 = this.zziqc.zzbia();
            zzgx(zzbia2);
            int zzbii2 = this.zziqc.zzbii() + zzbia2;
            do {
                list.add(Integer.valueOf(this.zziqc.zzbic()));
            } while (this.zziqc.zzbii() < zzbii2);
        } else if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zziqc.zzbic()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzz(List<Long> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzeobVar.zzfs(this.zziqc.zzbid());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgw(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzeobVar.zzfs(this.zziqc.zzbid());
                } while (this.zziqc.zzbii() < zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zziqc.zzbid()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbia2 = this.zziqc.zzbia();
            zzgw(zzbia2);
            int zzbii2 = this.zziqc.zzbii() + zzbia2;
            do {
                list.add(Long.valueOf(this.zziqc.zzbid()));
            } while (this.zziqc.zzbii() < zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzaa(List<Integer> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzendVar.zzhp(this.zziqc.zzbie());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzendVar.zzhp(this.zziqc.zzbie());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zziqc.zzbie()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Integer.valueOf(this.zziqc.zzbie()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepc
    public final void zzab(List<Long> list) {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeobVar.zzfs(this.zziqc.zzbif());
                    if (this.zziqc.zzbih()) {
                        return;
                    }
                    zzbhr2 = this.zziqc.zzbhr();
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
                return;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzeobVar.zzfs(this.zziqc.zzbif());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
                return;
            } else {
                throw zzenn.zzbke();
            }
        }
        int i2 = this.tag & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zziqc.zzbif()));
                if (this.zziqc.zzbih()) {
                    return;
                }
                zzbhr = this.zziqc.zzbhr();
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else if (i2 == 2) {
            int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
            do {
                list.add(Long.valueOf(this.zziqc.zzbif()));
            } while (this.zziqc.zzbii() < zzbii2);
            zzgy(zzbii2);
        } else {
            throw zzenn.zzbke();
        }
    }

    private static void zzgw(int i) {
        if ((i & 7) != 0) {
            throw zzenn.zzbkg();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzepc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <K, V> void zza(Map<K, V> map, zzeoe<K, V> zzeoeVar, zzemn zzemnVar) {
        zzgv(2);
        int zzgn = this.zziqc.zzgn(this.zziqc.zzbia());
        Object obj = zzeoeVar.zzivo;
        Object obj2 = zzeoeVar.zzcmg;
        while (true) {
            try {
                int zzbip = zzbip();
                if (zzbip == Integer.MAX_VALUE || this.zziqc.zzbih()) {
                    break;
                } else if (zzbip == 1) {
                    obj = zza(zzeoeVar.zzivn, (Class<?>) null, (zzemn) null);
                } else if (zzbip == 2) {
                    obj2 = zza(zzeoeVar.zzivp, zzeoeVar.zzcmg.getClass(), zzemnVar);
                } else {
                    try {
                        if (!zzbiq()) {
                            throw new zzenn("Unable to parse map entry.");
                            break;
                        }
                    } catch (zzenm unused) {
                        if (!zzbiq()) {
                            throw new zzenn("Unable to parse map entry.");
                        }
                    }
                }
            } finally {
                this.zziqc.zzgo(zzgn);
            }
        }
    }

    private final Object zza(zzeqr zzeqrVar, Class<?> cls, zzemn zzemnVar) {
        switch (zzemh.zziqb[zzeqrVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbhx());
            case 2:
                return zzbhz();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbib());
            case 5:
                return Integer.valueOf(zzbhw());
            case 6:
                return Long.valueOf(zzbhv());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbhu());
            case 9:
                return Long.valueOf(zzbht());
            case 10:
                zzgv(2);
                return zzc(zzepb.zzble().zzj(cls), zzemnVar);
            case 11:
                return Integer.valueOf(zzbic());
            case 12:
                return Long.valueOf(zzbid());
            case 13:
                return Integer.valueOf(zzbie());
            case 14:
                return Long.valueOf(zzbif());
            case 15:
                return zzbhy();
            case 16:
                return Integer.valueOf(zzbia());
            case 17:
                return Long.valueOf(zzbhs());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzgx(int i) {
        if ((i & 3) != 0) {
            throw zzenn.zzbkg();
        }
    }

    private final void zzgy(int i) {
        if (this.zziqc.zzbii() != i) {
            throw zzenn.zzbjz();
        }
    }
}
