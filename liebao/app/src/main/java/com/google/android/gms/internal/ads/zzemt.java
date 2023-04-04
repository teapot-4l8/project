package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzemv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzemt<T extends zzemv<T>> {
    private static final zzemt zziqv = new zzemt(true);
    final zzepn<T, Object> zziqs;
    private boolean zziqt;
    private boolean zziqu;

    private zzemt() {
        this.zziqs = zzepn.zzib(16);
    }

    private zzemt(boolean z) {
        this(zzepn.zzib(0));
        zzbhe();
    }

    private zzemt(zzepn<T, Object> zzepnVar) {
        this.zziqs = zzepnVar;
        zzbhe();
    }

    public static <T extends zzemv<T>> zzemt<T> zzbja() {
        return zziqv;
    }

    public final void zzbhe() {
        if (this.zziqt) {
            return;
        }
        this.zziqs.zzbhe();
        this.zziqt = true;
    }

    public final boolean isImmutable() {
        return this.zziqt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzemt) {
            return this.zziqs.equals(((zzemt) obj).zziqs);
        }
        return false;
    }

    public final int hashCode() {
        return this.zziqs.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        if (this.zziqu) {
            return new zzent(this.zziqs.entrySet().iterator());
        }
        return this.zziqs.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.zziqu) {
            return new zzent(this.zziqs.zzblr().iterator());
        }
        return this.zziqs.zzblr().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zziqs.get(t);
        if (obj instanceof zzeno) {
            zzeno zzenoVar = (zzeno) obj;
            return zzeno.zzbki();
        }
        return obj;
    }

    private final void zza(T t, Object obj) {
        if (t.zzbje()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zzb(t, obj2);
            }
            obj = arrayList;
        } else {
            zzb(t, obj);
        }
        if (obj instanceof zzeno) {
            this.zziqu = true;
        }
        this.zziqs.zza((zzepn<T, Object>) t, (T) obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r6 instanceof com.google.android.gms.internal.ads.zzenf) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if ((r6 instanceof byte[]) == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if ((r6 instanceof com.google.android.gms.internal.ads.zzeno) == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzb(T t, Object obj) {
        boolean z;
        zzeqr zzbjc = t.zzbjc();
        zzenc.checkNotNull(obj);
        switch (zzems.zziqr[zzbjc.zzbmh().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzelq)) {
                    break;
                }
                z = true;
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z = true;
                break;
            case 9:
                if (!(obj instanceof zzeon)) {
                    break;
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t.zzv()), t.zzbjc().zzbmh(), obj.getClass().getName()));
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zziqs.zzblp(); i++) {
            if (!zzb(this.zziqs.zzic(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zziqs.zzblq()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzemv<T>> boolean zzb(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzbjd() == zzequ.MESSAGE) {
            if (key.zzbje()) {
                for (zzeon zzeonVar : (List) entry.getValue()) {
                    if (!zzeonVar.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzeon) {
                    if (!((zzeon) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzeno) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzemt<T> zzemtVar) {
        for (int i = 0; i < zzemtVar.zziqs.zzblp(); i++) {
            zzc(zzemtVar.zziqs.zzic(i));
        }
        for (Map.Entry<T, Object> entry : zzemtVar.zziqs.zzblq()) {
            zzc(entry);
        }
    }

    private static Object zzal(Object obj) {
        if (obj instanceof zzeos) {
            return ((zzeos) obj).zzbha();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        zzeon zzbjv;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzeno) {
            zzeno zzenoVar = (zzeno) value;
            value = zzeno.zzbki();
        }
        if (key.zzbje()) {
            Object zza = zza((zzemt<T>) key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzal(obj));
            }
            this.zziqs.zza((zzepn<T, Object>) key, (T) zza);
        } else if (key.zzbjd() == zzequ.MESSAGE) {
            Object zza2 = zza((zzemt<T>) key);
            if (zza2 == null) {
                this.zziqs.zza((zzepn<T, Object>) key, (T) zzal(value));
                return;
            }
            if (zza2 instanceof zzeos) {
                zzbjv = key.zza((zzeos) zza2, (zzeos) value);
            } else {
                zzbjv = key.zza(((zzeon) zza2).zzbjn(), (zzeon) value).zzbjv();
            }
            this.zziqs.zza((zzepn<T, Object>) key, (T) zzbjv);
        } else {
            this.zziqs.zza((zzepn<T, Object>) key, (T) zzal(value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzemk zzemkVar, zzeqr zzeqrVar, int i, Object obj) {
        if (zzeqrVar == zzeqr.zzizo) {
            zzeon zzeonVar = (zzeon) obj;
            zzenc.zzk(zzeonVar);
            zzemkVar.writeTag(i, 3);
            zzeonVar.zzb(zzemkVar);
            zzemkVar.writeTag(i, 4);
            return;
        }
        zzemkVar.writeTag(i, zzeqrVar.zzbmi());
        switch (zzems.zziqb[zzeqrVar.ordinal()]) {
            case 1:
                zzemkVar.zzc(((Double) obj).doubleValue());
                return;
            case 2:
                zzemkVar.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzemkVar.zzfi(((Long) obj).longValue());
                return;
            case 4:
                zzemkVar.zzfi(((Long) obj).longValue());
                return;
            case 5:
                zzemkVar.zzgz(((Integer) obj).intValue());
                return;
            case 6:
                zzemkVar.zzfk(((Long) obj).longValue());
                return;
            case 7:
                zzemkVar.zzhc(((Integer) obj).intValue());
                return;
            case 8:
                zzemkVar.zzbw(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzeon) obj).zzb(zzemkVar);
                return;
            case 10:
                zzemkVar.zzg((zzeon) obj);
                return;
            case 11:
                if (obj instanceof zzelq) {
                    zzemkVar.zzai((zzelq) obj);
                    return;
                } else {
                    zzemkVar.zzia((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzelq) {
                    zzemkVar.zzai((zzelq) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzemkVar.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzemkVar.zzha(((Integer) obj).intValue());
                return;
            case 14:
                zzemkVar.zzhc(((Integer) obj).intValue());
                return;
            case 15:
                zzemkVar.zzfk(((Long) obj).longValue());
                return;
            case 16:
                zzemkVar.zzhb(((Integer) obj).intValue());
                return;
            case 17:
                zzemkVar.zzfj(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzenf) {
                    zzemkVar.zzgz(((zzenf) obj).zzv());
                    return;
                } else {
                    zzemkVar.zzgz(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzbjb() {
        int i = 0;
        for (int i2 = 0; i2 < this.zziqs.zzblp(); i2++) {
            i += zzd(this.zziqs.zzic(i2));
        }
        for (Map.Entry<T, Object> entry : this.zziqs.zzblq()) {
            i += zzd(entry);
        }
        return i;
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzbjd() == zzequ.MESSAGE && !key.zzbje() && !key.zzbjf()) {
            if (value instanceof zzeno) {
                return zzemk.zzb(entry.getKey().zzv(), (zzeno) value);
            }
            return zzemk.zzb(entry.getKey().zzv(), (zzeon) value);
        }
        return zzc(key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzeqr zzeqrVar, int i, Object obj) {
        int zzhd = zzemk.zzhd(i);
        if (zzeqrVar == zzeqr.zzizo) {
            zzenc.zzk((zzeon) obj);
            zzhd <<= 1;
        }
        return zzhd + zza(zzeqrVar, obj);
    }

    private static int zza(zzeqr zzeqrVar, Object obj) {
        switch (zzems.zziqb[zzeqrVar.ordinal()]) {
            case 1:
                return zzemk.zzd(((Double) obj).doubleValue());
            case 2:
                return zzemk.zzg(((Float) obj).floatValue());
            case 3:
                return zzemk.zzfl(((Long) obj).longValue());
            case 4:
                return zzemk.zzfm(((Long) obj).longValue());
            case 5:
                return zzemk.zzhe(((Integer) obj).intValue());
            case 6:
                return zzemk.zzfo(((Long) obj).longValue());
            case 7:
                return zzemk.zzhh(((Integer) obj).intValue());
            case 8:
                return zzemk.zzbx(((Boolean) obj).booleanValue());
            case 9:
                return zzemk.zzi((zzeon) obj);
            case 10:
                if (obj instanceof zzeno) {
                    return zzemk.zza((zzeno) obj);
                }
                return zzemk.zzh((zzeon) obj);
            case 11:
                if (obj instanceof zzelq) {
                    return zzemk.zzaj((zzelq) obj);
                }
                return zzemk.zzib((String) obj);
            case 12:
                if (obj instanceof zzelq) {
                    return zzemk.zzaj((zzelq) obj);
                }
                return zzemk.zzw((byte[]) obj);
            case 13:
                return zzemk.zzhf(((Integer) obj).intValue());
            case 14:
                return zzemk.zzhi(((Integer) obj).intValue());
            case 15:
                return zzemk.zzfp(((Long) obj).longValue());
            case 16:
                return zzemk.zzhg(((Integer) obj).intValue());
            case 17:
                return zzemk.zzfn(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzenf) {
                    return zzemk.zzhj(((zzenf) obj).zzv());
                }
                return zzemk.zzhj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzc(zzemv<?> zzemvVar, Object obj) {
        zzeqr zzbjc = zzemvVar.zzbjc();
        int zzv = zzemvVar.zzv();
        if (zzemvVar.zzbje()) {
            int i = 0;
            if (zzemvVar.zzbjf()) {
                for (Object obj2 : (List) obj) {
                    i += zza(zzbjc, obj2);
                }
                return zzemk.zzhd(zzv) + i + zzemk.zzhl(i);
            }
            for (Object obj3 : (List) obj) {
                i += zza(zzbjc, zzv, obj3);
            }
            return i;
        }
        return zza(zzbjc, zzv, obj);
    }

    public final /* synthetic */ Object clone() {
        zzemt zzemtVar = new zzemt();
        for (int i = 0; i < this.zziqs.zzblp(); i++) {
            Map.Entry<T, Object> zzic = this.zziqs.zzic(i);
            zzemtVar.zza((zzemt) zzic.getKey(), zzic.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zziqs.zzblq()) {
            zzemtVar.zza((zzemt) entry.getKey(), entry.getValue());
        }
        zzemtVar.zziqu = this.zziqu;
        return zzemtVar;
    }
}
