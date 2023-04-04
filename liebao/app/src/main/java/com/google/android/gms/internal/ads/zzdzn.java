package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzn<K, V> extends zzdze<K, V> {
    private static final zzdze<Object, Object> zzibh = new zzdzn(null, new Object[0], 0);
    private final transient int size;
    private final transient Object zzibi;
    private final transient Object[] zzibj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cc, code lost:
        r2[r7] = r3;
        r1 = r1 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <K, V> zzdzn<K, V> zzc(int i, Object[] objArr) {
        byte[] bArr;
        if (i == 0) {
            return (zzdzn) zzibh;
        }
        Object obj = null;
        int i2 = 0;
        if (i == 1) {
            zzdyu.zzb(objArr[0], objArr[1]);
            return new zzdzn<>(null, objArr, 1);
        }
        zzdyi.zzw(i, objArr.length >> 1);
        int zzez = zzdzd.zzez(i);
        if (i == 1) {
            zzdyu.zzb(objArr[0], objArr[1]);
        } else {
            int i3 = zzez - 1;
            if (zzez <= 128) {
                bArr = new byte[zzez];
                Arrays.fill(bArr, (byte) -1);
                while (i2 < i) {
                    int i4 = i2 * 2;
                    Object obj2 = objArr[i4];
                    Object obj3 = objArr[i4 ^ 1];
                    zzdyu.zzb(obj2, obj3);
                    int zzex = zzdyw.zzex(obj2.hashCode());
                    while (true) {
                        int i5 = zzex & i3;
                        int i6 = bArr[i5] & 255;
                        if (i6 == 255) {
                            break;
                        } else if (objArr[i6].equals(obj2)) {
                            throw zza(obj2, obj3, objArr, i6);
                        } else {
                            zzex = i5 + 1;
                        }
                    }
                }
            } else if (zzez <= 32768) {
                bArr = new short[zzez];
                Arrays.fill(bArr, (short) -1);
                while (i2 < i) {
                    int i7 = i2 * 2;
                    Object obj4 = objArr[i7];
                    Object obj5 = objArr[i7 ^ 1];
                    zzdyu.zzb(obj4, obj5);
                    int zzex2 = zzdyw.zzex(obj4.hashCode());
                    while (true) {
                        int i8 = zzex2 & i3;
                        int i9 = bArr[i8] & 65535;
                        if (i9 == 65535) {
                            break;
                        } else if (objArr[i9].equals(obj4)) {
                            throw zza(obj4, obj5, objArr, i9);
                        } else {
                            zzex2 = i8 + 1;
                        }
                    }
                }
            } else {
                bArr = new int[zzez];
                Arrays.fill((int[]) bArr, -1);
                while (i2 < i) {
                    int i10 = i2 * 2;
                    Object obj6 = objArr[i10];
                    Object obj7 = objArr[i10 ^ 1];
                    zzdyu.zzb(obj6, obj7);
                    int zzex3 = zzdyw.zzex(obj6.hashCode());
                    while (true) {
                        int i11 = zzex3 & i3;
                        ?? r8 = bArr[i11];
                        if (r8 == -1) {
                            break;
                        } else if (objArr[r8].equals(obj6)) {
                            throw zza(obj6, obj7, objArr, r8);
                        } else {
                            zzex3 = i11 + 1;
                        }
                    }
                }
            }
            obj = bArr;
        }
        return new zzdzn<>(obj, objArr, i);
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzdzn(Object obj, Object[] objArr, int i) {
        this.zzibi = obj;
        this.zzibj = objArr;
        this.size = i;
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdze, java.util.Map
    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzibi;
        Object[] objArr = this.zzibj;
        int i = this.size;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[0].equals(obj)) {
                return (V) objArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zzex = zzdyw.zzex(obj.hashCode());
                while (true) {
                    int i2 = zzex & length;
                    int i3 = bArr[i2] & 255;
                    if (i3 == 255) {
                        return null;
                    }
                    if (objArr[i3].equals(obj)) {
                        return (V) objArr[i3 ^ 1];
                    }
                    zzex = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zzex2 = zzdyw.zzex(obj.hashCode());
                while (true) {
                    int i4 = zzex2 & length2;
                    int i5 = sArr[i4] & 65535;
                    if (i5 == 65535) {
                        return null;
                    }
                    if (objArr[i5].equals(obj)) {
                        return (V) objArr[i5 ^ 1];
                    }
                    zzex2 = i4 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zzex3 = zzdyw.zzex(obj.hashCode());
                while (true) {
                    int i6 = zzex3 & length3;
                    int i7 = iArr[i6];
                    if (i7 == -1) {
                        return null;
                    }
                    if (objArr[i7].equals(obj)) {
                        return (V) objArr[i7 ^ 1];
                    }
                    zzex3 = i6 + 1;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdze
    final zzdzd<Map.Entry<K, V>> zzbao() {
        return new zzdzq(this, this.zzibj, 0, this.size);
    }

    @Override // com.google.android.gms.internal.ads.zzdze
    final zzdzd<K> zzbap() {
        return new zzdzs(this, new zzdzr(this.zzibj, 0, this.size));
    }

    @Override // com.google.android.gms.internal.ads.zzdze
    final zzdyv<V> zzbaq() {
        return new zzdzr(this.zzibj, 1, this.size);
    }
}
