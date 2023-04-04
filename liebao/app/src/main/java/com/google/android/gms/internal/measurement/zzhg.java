package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public final class zzhg implements zzjy {
    private final zzhb zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public static zzhg zza(zzhb zzhbVar) {
        if (zzhbVar.zzc != null) {
            return zzhbVar.zzc;
        }
        return new zzhg(zzhbVar);
    }

    private zzhg(zzhb zzhbVar) {
        zzhb zzhbVar2 = (zzhb) zzia.zza(zzhbVar, "input");
        this.zza = zzhbVar2;
        zzhbVar2.zzc = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zza() {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zza();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final boolean zzc() {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzb(i);
    }

    private final void zza(int i) {
        if ((this.zzb & 7) != i) {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final double zzd() {
        zza(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final float zze() {
        zza(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final long zzf() {
        zza(0);
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final long zzg() {
        zza(0);
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zzh() {
        zza(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final long zzi() {
        zza(1);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zzj() {
        zza(5);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final boolean zzk() {
        zza(0);
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final String zzl() {
        zza(2);
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final String zzm() {
        zza(2);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final <T> T zza(zzkb<T> zzkbVar, zzhl zzhlVar) {
        zza(2);
        return (T) zzc(zzkbVar, zzhlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final <T> T zzb(zzkb<T> zzkbVar, zzhl zzhlVar) {
        zza(3);
        return (T) zzd(zzkbVar, zzhlVar);
    }

    private final <T> T zzc(zzkb<T> zzkbVar, zzhl zzhlVar) {
        int zzm = this.zza.zzm();
        if (this.zza.zza >= this.zza.zzb) {
            throw new zzij("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzc = this.zza.zzc(zzm);
        T zza = zzkbVar.zza();
        this.zza.zza++;
        zzkbVar.zza(zza, this, zzhlVar);
        zzkbVar.zzc(zza);
        this.zza.zza(0);
        zzhb zzhbVar = this.zza;
        zzhbVar.zza--;
        this.zza.zzd(zzc);
        return zza;
    }

    private final <T> T zzd(zzkb<T> zzkbVar, zzhl zzhlVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza = zzkbVar.zza();
            zzkbVar.zza(zza, this, zzhlVar);
            zzkbVar.zzc(zza);
            if (this.zzb == this.zzc) {
                return zza;
            }
            throw zzij.zzg();
        } finally {
            this.zzc = i;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final zzgp zzn() {
        zza(2);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zzo() {
        zza(0);
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zzp() {
        zza(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zzq() {
        zza(5);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final long zzr() {
        zza(1);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final int zzs() {
        zza(0);
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final long zzt() {
        zza(0);
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zza(List<Double> list) {
        int zza;
        int zza2;
        if (list instanceof zzhj) {
            zzhj zzhjVar = (zzhj) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzhjVar.zza(this.zza.zzb());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzhjVar.zza(this.zza.zzb());
                } while (this.zza.zzu() < zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzm2 = this.zza.zzm();
            zzb(zzm2);
            int zzu2 = this.zza.zzu() + zzm2;
            do {
                list.add(Double.valueOf(this.zza.zzb()));
            } while (this.zza.zzu() < zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzb(List<Float> list) {
        int zza;
        int zza2;
        if (list instanceof zzhx) {
            zzhx zzhxVar = (zzhx) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzhxVar.zza(this.zza.zzc());
                } while (this.zza.zzu() < zzu);
                return;
            } else if (i == 5) {
                do {
                    zzhxVar.zza(this.zza.zzc());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzm2 = this.zza.zzm();
            zzc(zzm2);
            int zzu2 = this.zza.zzu() + zzm2;
            do {
                list.add(Float.valueOf(this.zza.zzc()));
            } while (this.zza.zzu() < zzu2);
        } else if (i2 == 5) {
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzc(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzixVar.zza(this.zza.zzd());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzixVar.zza(this.zza.zzd());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzd()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Long.valueOf(this.zza.zzd()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzd(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzixVar.zza(this.zza.zze());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzixVar.zza(this.zza.zze());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zze()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Long.valueOf(this.zza.zze()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zze(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzibVar.zzd(this.zza.zzf());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzibVar.zzd(this.zza.zzf());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzf(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzixVar.zza(this.zza.zzg());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzixVar.zza(this.zza.zzg());
                } while (this.zza.zzu() < zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzg()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzm2 = this.zza.zzm();
            zzb(zzm2);
            int zzu2 = this.zza.zzu() + zzm2;
            do {
                list.add(Long.valueOf(this.zza.zzg()));
            } while (this.zza.zzu() < zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzg(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzibVar.zzd(this.zza.zzh());
                } while (this.zza.zzu() < zzu);
                return;
            } else if (i == 5) {
                do {
                    zzibVar.zzd(this.zza.zzh());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzm2 = this.zza.zzm();
            zzc(zzm2);
            int zzu2 = this.zza.zzu() + zzm2;
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
            } while (this.zza.zzu() < zzu2);
        } else if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzh(List<Boolean> list) {
        int zza;
        int zza2;
        if (list instanceof zzgn) {
            zzgn zzgnVar = (zzgn) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgnVar.zza(this.zza.zzi());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgnVar.zza(this.zza.zzi());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Boolean.valueOf(this.zza.zzi()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Boolean.valueOf(this.zza.zzi()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzi(List<String> list) {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzj(List<String> list) {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) {
        int zza;
        int zza2;
        if ((this.zzb & 7) != 2) {
            throw zzij.zzf();
        }
        if ((list instanceof zziq) && !z) {
            zziq zziqVar = (zziq) list;
            do {
                zziqVar.zza(zzn());
                if (this.zza.zzt()) {
                    return;
                }
                zza2 = this.zza.zza();
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        do {
            list.add(z ? zzm() : zzl());
            if (this.zza.zzt()) {
                return;
            }
            zza = this.zza.zza();
        } while (zza == this.zzb);
        this.zzd = zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzjy
    public final <T> void zza(List<T> list, zzkb<T> zzkbVar, zzhl zzhlVar) {
        int zza;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzij.zzf();
        }
        do {
            list.add(zzc(zzkbVar, zzhlVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            }
            zza = this.zza.zza();
        } while (zza == i);
        this.zzd = zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzjy
    public final <T> void zzb(List<T> list, zzkb<T> zzkbVar, zzhl zzhlVar) {
        int zza;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzij.zzf();
        }
        do {
            list.add(zzd(zzkbVar, zzhlVar));
            if (this.zza.zzt() || this.zzd != 0) {
                return;
            }
            zza = this.zza.zza();
        } while (zza == i);
        this.zzd = zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzk(List<zzgp> list) {
        int zza;
        if ((this.zzb & 7) != 2) {
            throw zzij.zzf();
        }
        do {
            list.add(zzn());
            if (this.zza.zzt()) {
                return;
            }
            zza = this.zza.zza();
        } while (zza == this.zzb);
        this.zzd = zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzl(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzibVar.zzd(this.zza.zzm());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzibVar.zzd(this.zza.zzm());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzm()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzm()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzm(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzibVar.zzd(this.zza.zzn());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzibVar.zzd(this.zza.zzn());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzn(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzibVar.zzd(this.zza.zzo());
                } while (this.zza.zzu() < zzu);
                return;
            } else if (i == 5) {
                do {
                    zzibVar.zzd(this.zza.zzo());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 2) {
            int zzm2 = this.zza.zzm();
            zzc(zzm2);
            int zzu2 = this.zza.zzu() + zzm2;
            do {
                list.add(Integer.valueOf(this.zza.zzo()));
            } while (this.zza.zzu() < zzu2);
        } else if (i2 == 5) {
            do {
                list.add(Integer.valueOf(this.zza.zzo()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzo(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzixVar.zza(this.zza.zzp());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzm = this.zza.zzm();
                zzb(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzixVar.zza(this.zza.zzp());
                } while (this.zza.zzu() < zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 1) {
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzm2 = this.zza.zzm();
            zzb(zzm2);
            int zzu2 = this.zza.zzu() + zzm2;
            do {
                list.add(Long.valueOf(this.zza.zzp()));
            } while (this.zza.zzu() < zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzp(List<Integer> list) {
        int zza;
        int zza2;
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzibVar.zzd(this.zza.zzq());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzibVar.zzd(this.zza.zzq());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Integer.valueOf(this.zza.zzq()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Integer.valueOf(this.zza.zzq()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjy
    public final void zzq(List<Long> list) {
        int zza;
        int zza2;
        if (list instanceof zzix) {
            zzix zzixVar = (zzix) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzixVar.zza(this.zza.zzr());
                    if (this.zza.zzt()) {
                        return;
                    }
                    zza2 = this.zza.zza();
                } while (zza2 == this.zzb);
                this.zzd = zza2;
                return;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzixVar.zza(this.zza.zzr());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
                return;
            } else {
                throw zzij.zzf();
            }
        }
        int i2 = this.zzb & 7;
        if (i2 == 0) {
            do {
                list.add(Long.valueOf(this.zza.zzr()));
                if (this.zza.zzt()) {
                    return;
                }
                zza = this.zza.zza();
            } while (zza == this.zzb);
            this.zzd = zza;
        } else if (i2 == 2) {
            int zzu2 = this.zza.zzu() + this.zza.zzm();
            do {
                list.add(Long.valueOf(this.zza.zzr()));
            } while (this.zza.zzu() < zzu2);
            zzd(zzu2);
        } else {
            throw zzij.zzf();
        }
    }

    private static void zzb(int i) {
        if ((i & 7) != 0) {
            throw zzij.zzg();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzjy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <K, V> void zza(Map<K, V> map, zzja<K, V> zzjaVar, zzhl zzhlVar) {
        zza(2);
        int zzc = this.zza.zzc(this.zza.zzm());
        Object obj = zzjaVar.zzb;
        Object obj2 = zzjaVar.zzd;
        while (true) {
            try {
                int zza = zza();
                if (zza == Integer.MAX_VALUE || this.zza.zzt()) {
                    break;
                } else if (zza == 1) {
                    obj = zza(zzjaVar.zza, (Class<?>) null, (zzhl) null);
                } else if (zza == 2) {
                    obj2 = zza(zzjaVar.zzc, zzjaVar.zzd.getClass(), zzhlVar);
                } else {
                    try {
                        if (!zzc()) {
                            throw new zzij("Unable to parse map entry.");
                            break;
                        }
                    } catch (zzii unused) {
                        if (!zzc()) {
                            throw new zzij("Unable to parse map entry.");
                        }
                    }
                }
            } finally {
                this.zza.zzd(zzc);
            }
        }
    }

    private final Object zza(zzlg zzlgVar, Class<?> cls, zzhl zzhlVar) {
        switch (zzhf.zza[zzlgVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                zza(2);
                return zzc(zzjx.zza().zza((Class) cls), zzhlVar);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zzm();
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzc(int i) {
        if ((i & 3) != 0) {
            throw zzij.zzg();
        }
    }

    private final void zzd(int i) {
        if (this.zza.zzu() != i) {
            throw zzij.zza();
        }
    }
}
