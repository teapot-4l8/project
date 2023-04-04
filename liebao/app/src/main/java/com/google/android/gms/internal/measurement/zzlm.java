package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
interface zzlm {
    int zza();

    @Deprecated
    void zza(int i);

    void zza(int i, double d2);

    void zza(int i, float f);

    void zza(int i, int i2);

    void zza(int i, long j);

    void zza(int i, zzgp zzgpVar);

    <K, V> void zza(int i, zzja<K, V> zzjaVar, Map<K, V> map);

    void zza(int i, Object obj);

    void zza(int i, Object obj, zzkb zzkbVar);

    void zza(int i, String str);

    void zza(int i, List<String> list);

    void zza(int i, List<?> list, zzkb zzkbVar);

    void zza(int i, List<Integer> list, boolean z);

    void zza(int i, boolean z);

    @Deprecated
    void zzb(int i);

    void zzb(int i, int i2);

    void zzb(int i, long j);

    @Deprecated
    void zzb(int i, Object obj, zzkb zzkbVar);

    void zzb(int i, List<zzgp> list);

    @Deprecated
    void zzb(int i, List<?> list, zzkb zzkbVar);

    void zzb(int i, List<Integer> list, boolean z);

    void zzc(int i, int i2);

    void zzc(int i, long j);

    void zzc(int i, List<Long> list, boolean z);

    void zzd(int i, int i2);

    void zzd(int i, long j);

    void zzd(int i, List<Long> list, boolean z);

    void zze(int i, int i2);

    void zze(int i, long j);

    void zze(int i, List<Long> list, boolean z);

    void zzf(int i, int i2);

    void zzf(int i, List<Float> list, boolean z);

    void zzg(int i, List<Double> list, boolean z);

    void zzh(int i, List<Integer> list, boolean z);

    void zzi(int i, List<Boolean> list, boolean z);

    void zzj(int i, List<Integer> list, boolean z);

    void zzk(int i, List<Integer> list, boolean z);

    void zzl(int i, List<Long> list, boolean z);

    void zzm(int i, List<Integer> list, boolean z);

    void zzn(int i, List<Long> list, boolean z);
}
