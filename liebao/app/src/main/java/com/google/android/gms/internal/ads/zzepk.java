package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzepk {
    private static final Class<?> zzixl = zzbln();
    private static final zzeqa<?, ?> zzixm = zzbz(false);
    private static final zzeqa<?, ?> zzixn = zzbz(true);
    private static final zzeqa<?, ?> zzixo = new zzeqc();

    public static void zzk(Class<?> cls) {
        Class<?> cls2;
        if (!zzena.class.isAssignableFrom(cls) && (cls2 = zzixl) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzeqx zzeqxVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzeqx zzeqxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zza(i, list);
    }

    public static void zzb(int i, List<zzelq> list, zzeqx zzeqxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzeqx zzeqxVar, zzepi zzepiVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zza(i, list, zzepiVar);
    }

    public static void zzb(int i, List<?> list, zzeqx zzeqxVar, zzepi zzepiVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzeqxVar.zzb(i, list, zzepiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzac(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfl(zzeobVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfl(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzac(list) + (list.size() * zzemk.zzhd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzad(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfm(zzeobVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfm(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzemk.zzhd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzae(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeob) {
            zzeob zzeobVar = (zzeob) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfn(zzeobVar.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzemk.zzfn(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzemk.zzhd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzaf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhj(zzendVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaf(list) + (size * zzemk.zzhd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhe(zzendVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzag(list) + (size * zzemk.zzhd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzah(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhf(zzendVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzah(list) + (size * zzemk.zzhd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzai(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzend) {
            zzend zzendVar = (zzend) list;
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhg(zzendVar.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzemk.zzhg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzai(list) + (size * zzemk.zzhd(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzaj(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzemk.zzal(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzak(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzemk.zzo(i, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzal(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzemk.zzi(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<?> list) {
        int zzib;
        int zzib2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzhd = zzemk.zzhd(i) * size;
        if (list instanceof zzenu) {
            zzenu zzenuVar = (zzenu) list;
            while (i2 < size) {
                Object zzhr = zzenuVar.zzhr(i2);
                if (zzhr instanceof zzelq) {
                    zzib2 = zzemk.zzaj((zzelq) zzhr);
                } else {
                    zzib2 = zzemk.zzib((String) zzhr);
                }
                zzhd += zzib2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzelq) {
                    zzib = zzemk.zzaj((zzelq) obj);
                } else {
                    zzib = zzemk.zzib((String) obj);
                }
                zzhd += zzib;
                i2++;
            }
        }
        return zzhd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, Object obj, zzepi zzepiVar) {
        if (obj instanceof zzens) {
            return zzemk.zza(i, (zzens) obj);
        }
        return zzemk.zzb(i, (zzeon) obj, zzepiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List<?> list, zzepi zzepiVar) {
        int zza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzhd = zzemk.zzhd(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzens) {
                zza = zzemk.zza((zzens) obj);
            } else {
                zza = zzemk.zza((zzeon) obj, zzepiVar);
            }
            zzhd += zza;
        }
        return zzhd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<zzelq> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzhd = size * zzemk.zzhd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzhd += zzemk.zzaj(list.get(i2));
        }
        return zzhd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(int i, List<zzeon> list, zzepi zzepiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzemk.zzc(i, list.get(i3), zzepiVar);
        }
        return i2;
    }

    public static zzeqa<?, ?> zzblk() {
        return zzixm;
    }

    public static zzeqa<?, ?> zzbll() {
        return zzixn;
    }

    public static zzeqa<?, ?> zzblm() {
        return zzixo;
    }

    private static zzeqa<?, ?> zzbz(boolean z) {
        try {
            Class<?> zzblo = zzblo();
            if (zzblo == null) {
                return null;
            }
            return (zzeqa) zzblo.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbln() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzblo() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void zza(zzeog zzeogVar, T t, T t2, long j) {
        zzeqg.zza(t, j, zzeogVar.zzf(zzeqg.zzp(t, j), zzeqg.zzp(t2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzemv<FT>> void zza(zzemp<FT> zzempVar, T t, T t2) {
        zzemt<FT> zzai = zzempVar.zzai(t2);
        if (zzai.zziqs.isEmpty()) {
            return;
        }
        zzempVar.zzaj(t).zza(zzai);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void zza(zzeqa<UT, UB> zzeqaVar, T t, T t2) {
        zzeqaVar.zzi(t, zzeqaVar.zzk(zzeqaVar.zzay(t), zzeqaVar.zzay(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, List<Integer> list, zzenh zzenhVar, UB ub, zzeqa<UT, UB> zzeqaVar) {
        if (zzenhVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzenhVar.zzi(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzeqaVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzenhVar.zzi(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zzeqaVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB zza(int i, int i2, UB ub, zzeqa<UT, UB> zzeqaVar) {
        if (ub == null) {
            ub = zzeqaVar.zzblx();
        }
        zzeqaVar.zza((zzeqa<UT, UB>) ub, i, i2);
        return ub;
    }
}
