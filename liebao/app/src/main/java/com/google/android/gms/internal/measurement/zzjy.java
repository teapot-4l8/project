package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public interface zzjy {
    int zza();

    <T> T zza(zzkb<T> zzkbVar, zzhl zzhlVar);

    void zza(List<Double> list);

    <T> void zza(List<T> list, zzkb<T> zzkbVar, zzhl zzhlVar);

    <K, V> void zza(Map<K, V> map, zzja<K, V> zzjaVar, zzhl zzhlVar);

    int zzb();

    @Deprecated
    <T> T zzb(zzkb<T> zzkbVar, zzhl zzhlVar);

    void zzb(List<Float> list);

    @Deprecated
    <T> void zzb(List<T> list, zzkb<T> zzkbVar, zzhl zzhlVar);

    void zzc(List<Long> list);

    boolean zzc();

    double zzd();

    void zzd(List<Long> list);

    float zze();

    void zze(List<Integer> list);

    long zzf();

    void zzf(List<Long> list);

    long zzg();

    void zzg(List<Integer> list);

    int zzh();

    void zzh(List<Boolean> list);

    long zzi();

    void zzi(List<String> list);

    int zzj();

    void zzj(List<String> list);

    void zzk(List<zzgp> list);

    boolean zzk();

    String zzl();

    void zzl(List<Integer> list);

    String zzm();

    void zzm(List<Integer> list);

    zzgp zzn();

    void zzn(List<Integer> list);

    int zzo();

    void zzo(List<Long> list);

    int zzp();

    void zzp(List<Integer> list);

    int zzq();

    void zzq(List<Long> list);

    long zzr();

    int zzs();

    long zzt();
}
