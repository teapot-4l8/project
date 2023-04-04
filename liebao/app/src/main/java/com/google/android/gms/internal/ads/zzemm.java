package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzemm implements zzeqx {
    private final zzemk zziph;

    public static zzemm zza(zzemk zzemkVar) {
        if (zzemkVar.zziqg != null) {
            return zzemkVar.zziqg;
        }
        return new zzemm(zzemkVar);
    }

    private zzemm(zzemk zzemkVar) {
        zzemk zzemkVar2 = (zzemk) zzenc.zza(zzemkVar, "output");
        this.zziph = zzemkVar2;
        zzemkVar2.zziqg = this;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final int zzbiu() {
        return zzeqw.zzjak;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzao(int i, int i2) {
        this.zziph.zzah(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzq(int i, long j) {
        this.zziph.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzr(int i, long j) {
        this.zziph.zzk(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zza(int i, float f) {
        this.zziph.zza(i, f);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzb(int i, double d2) {
        this.zziph.zzb(i, d2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzap(int i, int i2) {
        this.zziph.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzi(int i, long j) {
        this.zziph.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzae(int i, int i2) {
        this.zziph.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzk(int i, long j) {
        this.zziph.zzk(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzah(int i, int i2) {
        this.zziph.zzah(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzh(int i, boolean z) {
        this.zziph.zzh(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzi(int i, String str) {
        this.zziph.zzi(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zza(int i, zzelq zzelqVar) {
        this.zziph.zza(i, zzelqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzaf(int i, int i2) {
        this.zziph.zzaf(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzag(int i, int i2) {
        this.zziph.zzag(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzj(int i, long j) {
        this.zziph.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zza(int i, Object obj, zzepi zzepiVar) {
        this.zziph.zza(i, (zzeon) obj, zzepiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzb(int i, Object obj, zzepi zzepiVar) {
        zzemk zzemkVar = this.zziph;
        zzemkVar.writeTag(i, 3);
        zzepiVar.zza((zzeon) obj, zzemkVar.zziqg);
        zzemkVar.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzhm(int i) {
        this.zziph.writeTag(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzhn(int i) {
        this.zziph.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzc(int i, Object obj) {
        if (obj instanceof zzelq) {
            this.zziph.zzb(i, (zzelq) obj);
        } else {
            this.zziph.zza(i, (zzeon) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zza(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhe(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzgz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzb(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhh(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzhc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzah(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzc(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfl(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzd(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfm(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zze(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfo(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzf(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzg(list.get(i4).floatValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzg(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzd(list.get(i4).doubleValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzc(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzh(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhj(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzgz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzi(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzbx(list.get(i4).booleanValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzbw(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzh(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zza(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzenu) {
            zzenu zzenuVar = (zzenu) list;
            while (i2 < list.size()) {
                Object zzhr = zzenuVar.zzhr(i2);
                if (zzhr instanceof String) {
                    this.zziph.zzi(i, (String) zzhr);
                } else {
                    this.zziph.zza(i, (zzelq) zzhr);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzi(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzb(int i, List<zzelq> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zziph.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzj(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhf(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzha(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzaf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzk(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhi(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzhc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzah(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzl(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfp(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfk(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzm(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzhg(list.get(i4).intValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzhb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzag(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzn(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zziph.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzemk.zzfn(list.get(i4).longValue());
            }
            this.zziph.zzha(i3);
            while (i2 < list.size()) {
                this.zziph.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziph.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zza(int i, List<?> list, zzepi zzepiVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzepiVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final void zzb(int i, List<?> list, zzepi zzepiVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzepiVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final <K, V> void zza(int i, zzeoe<K, V> zzeoeVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zziph.writeTag(i, 2);
            this.zziph.zzha(zzeof.zza(zzeoeVar, entry.getKey(), entry.getValue()));
            zzeof.zza(this.zziph, zzeoeVar, entry.getKey(), entry.getValue());
        }
    }
}
