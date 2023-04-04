package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public interface zzepc {
    int getTag();

    double readDouble();

    float readFloat();

    String readString();

    void readStringList(List<String> list);

    <T> T zza(zzepi<T> zzepiVar, zzemn zzemnVar);

    <T> void zza(List<T> list, zzepi<T> zzepiVar, zzemn zzemnVar);

    <K, V> void zza(Map<K, V> map, zzeoe<K, V> zzeoeVar, zzemn zzemnVar);

    void zzaa(List<Integer> list);

    void zzab(List<Long> list);

    @Deprecated
    <T> T zzb(zzepi<T> zzepiVar, zzemn zzemnVar);

    @Deprecated
    <T> void zzb(List<T> list, zzepi<T> zzepiVar, zzemn zzemnVar);

    long zzbhs();

    long zzbht();

    int zzbhu();

    long zzbhv();

    int zzbhw();

    boolean zzbhx();

    String zzbhy();

    zzelq zzbhz();

    int zzbia();

    int zzbib();

    int zzbic();

    long zzbid();

    int zzbie();

    long zzbif();

    int zzbip();

    boolean zzbiq();

    void zzm(List<Double> list);

    void zzn(List<Float> list);

    void zzo(List<Long> list);

    void zzp(List<Long> list);

    void zzq(List<Integer> list);

    void zzr(List<Long> list);

    void zzs(List<Integer> list);

    void zzt(List<Boolean> list);

    void zzu(List<String> list);

    void zzv(List<zzelq> list);

    void zzw(List<Integer> list);

    void zzx(List<Integer> list);

    void zzy(List<Integer> list);

    void zzz(List<Long> list);
}
