package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzena;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeor<T> implements zzepi<T> {
    private final int[] zzivu;
    private final Object[] zzivv;
    private final int zzivw;
    private final int zzivx;
    private final zzeon zzivy;
    private final boolean zzivz;
    private final boolean zziwa;
    private final boolean zziwb;
    private final boolean zziwc;
    private final int[] zziwd;
    private final int zziwe;
    private final int zziwf;
    private final zzeov zziwg;
    private final zzenx zziwh;
    private final zzeqa<?, ?> zziwi;
    private final zzemp<?> zziwj;
    private final zzeog zziwk;
    private static final int[] zzivt = new int[0];
    private static final Unsafe zzicl = zzeqg.zzbmd();

    private zzeor(int[] iArr, Object[] objArr, int i, int i2, zzeon zzeonVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzeov zzeovVar, zzenx zzenxVar, zzeqa<?, ?> zzeqaVar, zzemp<?> zzempVar, zzeog zzeogVar) {
        this.zzivu = iArr;
        this.zzivv = objArr;
        this.zzivw = i;
        this.zzivx = i2;
        this.zziwa = zzeonVar instanceof zzena;
        this.zziwb = z;
        this.zzivz = zzempVar != null && zzempVar.zzj(zzeonVar);
        this.zziwc = false;
        this.zziwd = iArr2;
        this.zziwe = i3;
        this.zziwf = i4;
        this.zziwg = zzeovVar;
        this.zziwh = zzenxVar;
        this.zziwi = zzeqaVar;
        this.zziwj = zzempVar;
        this.zzivy = zzeonVar;
        this.zziwk = zzeogVar;
    }

    private static boolean zzhx(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> zzeor<T> zza(Class<T> cls, zzeol zzeolVar, zzeov zzeovVar, zzenx zzenxVar, zzeqa<?, ?> zzeqaVar, zzemp<?> zzempVar, zzeog zzeogVar) {
        int i;
        int charAt;
        int charAt2;
        int charAt3;
        int charAt4;
        int charAt5;
        int i2;
        int[] iArr;
        int i3;
        char charAt6;
        int i4;
        char charAt7;
        int i5;
        char charAt8;
        int i6;
        char charAt9;
        int i7;
        char charAt10;
        int i8;
        char charAt11;
        int i9;
        char charAt12;
        int i10;
        char charAt13;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int objectFieldOffset;
        String str;
        boolean z;
        Object[] objArr;
        int i16;
        int i17;
        int i18;
        Field zza;
        int i19;
        char charAt14;
        int i20;
        int i21;
        Field zza2;
        Field zza3;
        int i22;
        char charAt15;
        int i23;
        char charAt16;
        int i24;
        char charAt17;
        int i25;
        char charAt18;
        if (zzeolVar instanceof zzepd) {
            zzepd zzepdVar = (zzepd) zzeolVar;
            int i26 = 0;
            boolean z2 = zzepdVar.zzbkx() == zzeoy.zziwo;
            String zzblf = zzepdVar.zzblf();
            int length = zzblf.length();
            if (zzblf.charAt(0) >= 55296) {
                int i27 = 1;
                while (true) {
                    i = i27 + 1;
                    if (zzblf.charAt(i27) < 55296) {
                        break;
                    }
                    i27 = i;
                }
            } else {
                i = 1;
            }
            int i28 = i + 1;
            int charAt19 = zzblf.charAt(i);
            if (charAt19 >= 55296) {
                int i29 = charAt19 & 8191;
                int i30 = 13;
                while (true) {
                    i25 = i28 + 1;
                    charAt18 = zzblf.charAt(i28);
                    if (charAt18 < 55296) {
                        break;
                    }
                    i29 |= (charAt18 & 8191) << i30;
                    i30 += 13;
                    i28 = i25;
                }
                charAt19 = i29 | (charAt18 << i30);
                i28 = i25;
            }
            if (charAt19 == 0) {
                iArr = zzivt;
                i2 = 0;
                charAt = 0;
                charAt2 = 0;
                charAt3 = 0;
                charAt4 = 0;
                charAt5 = 0;
            } else {
                int i31 = i28 + 1;
                int charAt20 = zzblf.charAt(i28);
                if (charAt20 >= 55296) {
                    int i32 = charAt20 & 8191;
                    int i33 = 13;
                    while (true) {
                        i10 = i31 + 1;
                        charAt13 = zzblf.charAt(i31);
                        if (charAt13 < 55296) {
                            break;
                        }
                        i32 |= (charAt13 & 8191) << i33;
                        i33 += 13;
                        i31 = i10;
                    }
                    charAt20 = i32 | (charAt13 << i33);
                    i31 = i10;
                }
                int i34 = i31 + 1;
                int charAt21 = zzblf.charAt(i31);
                if (charAt21 >= 55296) {
                    int i35 = charAt21 & 8191;
                    int i36 = 13;
                    while (true) {
                        i9 = i34 + 1;
                        charAt12 = zzblf.charAt(i34);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i35 |= (charAt12 & 8191) << i36;
                        i36 += 13;
                        i34 = i9;
                    }
                    charAt21 = i35 | (charAt12 << i36);
                    i34 = i9;
                }
                int i37 = i34 + 1;
                charAt = zzblf.charAt(i34);
                if (charAt >= 55296) {
                    int i38 = charAt & 8191;
                    int i39 = 13;
                    while (true) {
                        i8 = i37 + 1;
                        charAt11 = zzblf.charAt(i37);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i38 |= (charAt11 & 8191) << i39;
                        i39 += 13;
                        i37 = i8;
                    }
                    charAt = i38 | (charAt11 << i39);
                    i37 = i8;
                }
                int i40 = i37 + 1;
                charAt2 = zzblf.charAt(i37);
                if (charAt2 >= 55296) {
                    int i41 = charAt2 & 8191;
                    int i42 = 13;
                    while (true) {
                        i7 = i40 + 1;
                        charAt10 = zzblf.charAt(i40);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i41 |= (charAt10 & 8191) << i42;
                        i42 += 13;
                        i40 = i7;
                    }
                    charAt2 = i41 | (charAt10 << i42);
                    i40 = i7;
                }
                int i43 = i40 + 1;
                charAt3 = zzblf.charAt(i40);
                if (charAt3 >= 55296) {
                    int i44 = charAt3 & 8191;
                    int i45 = 13;
                    while (true) {
                        i6 = i43 + 1;
                        charAt9 = zzblf.charAt(i43);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i44 |= (charAt9 & 8191) << i45;
                        i45 += 13;
                        i43 = i6;
                    }
                    charAt3 = i44 | (charAt9 << i45);
                    i43 = i6;
                }
                int i46 = i43 + 1;
                charAt4 = zzblf.charAt(i43);
                if (charAt4 >= 55296) {
                    int i47 = charAt4 & 8191;
                    int i48 = 13;
                    while (true) {
                        i5 = i46 + 1;
                        charAt8 = zzblf.charAt(i46);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i47 |= (charAt8 & 8191) << i48;
                        i48 += 13;
                        i46 = i5;
                    }
                    charAt4 = i47 | (charAt8 << i48);
                    i46 = i5;
                }
                int i49 = i46 + 1;
                int charAt22 = zzblf.charAt(i46);
                if (charAt22 >= 55296) {
                    int i50 = charAt22 & 8191;
                    int i51 = 13;
                    while (true) {
                        i4 = i49 + 1;
                        charAt7 = zzblf.charAt(i49);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i50 |= (charAt7 & 8191) << i51;
                        i51 += 13;
                        i49 = i4;
                    }
                    charAt22 = i50 | (charAt7 << i51);
                    i49 = i4;
                }
                int i52 = i49 + 1;
                charAt5 = zzblf.charAt(i49);
                if (charAt5 >= 55296) {
                    int i53 = charAt5 & 8191;
                    int i54 = i52;
                    int i55 = 13;
                    while (true) {
                        i3 = i54 + 1;
                        charAt6 = zzblf.charAt(i54);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i53 |= (charAt6 & 8191) << i55;
                        i55 += 13;
                        i54 = i3;
                    }
                    charAt5 = i53 | (charAt6 << i55);
                    i52 = i3;
                }
                i2 = (charAt20 << 1) + charAt21;
                iArr = new int[charAt5 + charAt4 + charAt22];
                i26 = charAt20;
                i28 = i52;
            }
            Unsafe unsafe = zzicl;
            Object[] zzblg = zzepdVar.zzblg();
            Class<?> cls2 = zzepdVar.zzbkz().getClass();
            int i56 = i28;
            int[] iArr2 = new int[charAt3 * 3];
            Object[] objArr2 = new Object[charAt3 << 1];
            int i57 = charAt5 + charAt4;
            int i58 = i2;
            int i59 = charAt5;
            int i60 = i56;
            int i61 = i57;
            int i62 = 0;
            int i63 = 0;
            while (i60 < length) {
                int i64 = i60 + 1;
                int charAt23 = zzblf.charAt(i60);
                if (charAt23 >= 55296) {
                    int i65 = charAt23 & 8191;
                    int i66 = i64;
                    int i67 = 13;
                    while (true) {
                        i24 = i66 + 1;
                        charAt17 = zzblf.charAt(i66);
                        i11 = length;
                        if (charAt17 < 55296) {
                            break;
                        }
                        i65 |= (charAt17 & 8191) << i67;
                        i67 += 13;
                        i66 = i24;
                        length = i11;
                    }
                    charAt23 = i65 | (charAt17 << i67);
                    i12 = i24;
                } else {
                    i11 = length;
                    i12 = i64;
                }
                int i68 = i12 + 1;
                int charAt24 = zzblf.charAt(i12);
                if (charAt24 >= 55296) {
                    int i69 = charAt24 & 8191;
                    int i70 = i68;
                    int i71 = 13;
                    while (true) {
                        i23 = i70 + 1;
                        charAt16 = zzblf.charAt(i70);
                        i13 = charAt5;
                        if (charAt16 < 55296) {
                            break;
                        }
                        i69 |= (charAt16 & 8191) << i71;
                        i71 += 13;
                        i70 = i23;
                        charAt5 = i13;
                    }
                    charAt24 = i69 | (charAt16 << i71);
                    i14 = i23;
                } else {
                    i13 = charAt5;
                    i14 = i68;
                }
                int i72 = charAt24 & 255;
                int i73 = charAt2;
                if ((charAt24 & 1024) != 0) {
                    iArr[i62] = i63;
                    i62++;
                }
                int i74 = charAt;
                if (i72 >= 51) {
                    int i75 = i14 + 1;
                    int charAt25 = zzblf.charAt(i14);
                    char c2 = 55296;
                    if (charAt25 >= 55296) {
                        int i76 = charAt25 & 8191;
                        int i77 = 13;
                        while (true) {
                            i22 = i75 + 1;
                            charAt15 = zzblf.charAt(i75);
                            if (charAt15 < c2) {
                                break;
                            }
                            i76 |= (charAt15 & 8191) << i77;
                            i77 += 13;
                            i75 = i22;
                            c2 = 55296;
                        }
                        charAt25 = i76 | (charAt15 << i77);
                        i75 = i22;
                    }
                    int i78 = i72 - 51;
                    int i79 = i75;
                    if (i78 == 9 || i78 == 17) {
                        i21 = 1;
                        objArr2[((i63 / 3) << 1) + 1] = zzblg[i58];
                        i58++;
                    } else {
                        if (i78 == 12 && !z2) {
                            objArr2[((i63 / 3) << 1) + 1] = zzblg[i58];
                            i58++;
                        }
                        i21 = 1;
                    }
                    int i80 = charAt25 << i21;
                    Object obj = zzblg[i80];
                    if (obj instanceof Field) {
                        zza2 = (Field) obj;
                    } else {
                        zza2 = zza(cls2, (String) obj);
                        zzblg[i80] = zza2;
                    }
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(zza2);
                    int i81 = i80 + 1;
                    Object obj2 = zzblg[i81];
                    if (obj2 instanceof Field) {
                        zza3 = (Field) obj2;
                    } else {
                        zza3 = zza(cls2, (String) obj2);
                        zzblg[i81] = zza3;
                    }
                    str = zzblf;
                    i16 = (int) unsafe.objectFieldOffset(zza3);
                    z = z2;
                    objArr = objArr2;
                    objectFieldOffset = objectFieldOffset2;
                    i17 = i79;
                    i18 = 0;
                } else {
                    int i82 = i58 + 1;
                    Field zza4 = zza(cls2, (String) zzblg[i58]);
                    if (i72 == 9 || i72 == 17) {
                        objArr2[((i63 / 3) << 1) + 1] = zza4.getType();
                    } else {
                        if (i72 == 27 || i72 == 49) {
                            i20 = i82 + 1;
                            objArr2[((i63 / 3) << 1) + 1] = zzblg[i82];
                        } else {
                            if (i72 == 12 || i72 == 30 || i72 == 44) {
                                if (!z2) {
                                    i20 = i82 + 1;
                                    objArr2[((i63 / 3) << 1) + 1] = zzblg[i82];
                                }
                            } else if (i72 == 50) {
                                int i83 = i59 + 1;
                                iArr[i59] = i63;
                                int i84 = (i63 / 3) << 1;
                                i20 = i82 + 1;
                                objArr2[i84] = zzblg[i82];
                                if ((charAt24 & 2048) != 0) {
                                    i82 = i20 + 1;
                                    objArr2[i84 + 1] = zzblg[i20];
                                    i59 = i83;
                                } else {
                                    i59 = i83;
                                }
                            }
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zza4);
                            int i85 = i15;
                            if ((charAt24 & 4096) == 4096 || i72 > 17) {
                                str = zzblf;
                                z = z2;
                                objArr = objArr2;
                                i16 = 1048575;
                                i17 = i14;
                                i18 = 0;
                            } else {
                                int i86 = i14 + 1;
                                int charAt26 = zzblf.charAt(i14);
                                if (charAt26 >= 55296) {
                                    int i87 = charAt26 & 8191;
                                    int i88 = 13;
                                    while (true) {
                                        i19 = i86 + 1;
                                        charAt14 = zzblf.charAt(i86);
                                        if (charAt14 < 55296) {
                                            break;
                                        }
                                        i87 |= (charAt14 & 8191) << i88;
                                        i88 += 13;
                                        i86 = i19;
                                    }
                                    charAt26 = i87 | (charAt14 << i88);
                                    i86 = i19;
                                }
                                int i89 = (i26 << 1) + (charAt26 / 32);
                                Object obj3 = zzblg[i89];
                                str = zzblf;
                                if (obj3 instanceof Field) {
                                    zza = (Field) obj3;
                                } else {
                                    zza = zza(cls2, (String) obj3);
                                    zzblg[i89] = zza;
                                }
                                z = z2;
                                objArr = objArr2;
                                i18 = charAt26 % 32;
                                i17 = i86;
                                i16 = (int) unsafe.objectFieldOffset(zza);
                            }
                            if (i72 >= 18 && i72 <= 49) {
                                iArr[i61] = objectFieldOffset;
                                i61++;
                            }
                            i58 = i85;
                        }
                        i15 = i20;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zza4);
                        int i852 = i15;
                        if ((charAt24 & 4096) == 4096) {
                        }
                        str = zzblf;
                        z = z2;
                        objArr = objArr2;
                        i16 = 1048575;
                        i17 = i14;
                        i18 = 0;
                        if (i72 >= 18) {
                            iArr[i61] = objectFieldOffset;
                            i61++;
                        }
                        i58 = i852;
                    }
                    i15 = i82;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zza4);
                    int i8522 = i15;
                    if ((charAt24 & 4096) == 4096) {
                    }
                    str = zzblf;
                    z = z2;
                    objArr = objArr2;
                    i16 = 1048575;
                    i17 = i14;
                    i18 = 0;
                    if (i72 >= 18) {
                    }
                    i58 = i8522;
                }
                int i90 = i63 + 1;
                iArr2[i63] = charAt23;
                int i91 = i90 + 1;
                int i92 = i26;
                iArr2[i90] = ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 536870912 : 0) | (i72 << 20) | objectFieldOffset;
                int i93 = i91 + 1;
                iArr2[i91] = (i18 << 20) | i16;
                i60 = i17;
                i26 = i92;
                charAt2 = i73;
                objArr2 = objArr;
                charAt5 = i13;
                charAt = i74;
                z2 = z;
                i63 = i93;
                length = i11;
                zzblf = str;
            }
            return new zzeor<>(iArr2, objArr2, charAt, charAt2, zzepdVar.zzbkz(), z2, false, iArr, charAt5, i57, zzeovVar, zzenxVar, zzeqaVar, zzempVar, zzeogVar);
        }
        ((zzepx) zzeolVar).zzbkx();
        int i94 = zzeoy.zziwo;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final T newInstance() {
        return (T) this.zziwg.newInstance(this.zzivy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzeqg.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzeqg.zzo(r11, r6))) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.google.android.gms.internal.ads.zzepk.zzh(com.google.android.gms.internal.ads.zzeqg.zzp(r10, r6), com.google.android.gms.internal.ads.zzeqg.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (com.google.android.gms.internal.ads.zzepk.zzh(com.google.android.gms.internal.ads.zzeqg.zzp(r10, r6), com.google.android.gms.internal.ads.zzeqg.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
        if (com.google.android.gms.internal.ads.zzepk.zzh(com.google.android.gms.internal.ads.zzeqg.zzp(r10, r6), com.google.android.gms.internal.ads.zzeqg.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (com.google.android.gms.internal.ads.zzepk.zzh(com.google.android.gms.internal.ads.zzeqg.zzp(r10, r6), com.google.android.gms.internal.ads.zzeqg.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011c, code lost:
        if (com.google.android.gms.internal.ads.zzepk.zzh(com.google.android.gms.internal.ads.zzeqg.zzp(r10, r6), com.google.android.gms.internal.ads.zzeqg.zzp(r11, r6)) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzm(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzm(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0140, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0165, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzk(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzk(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0178, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018b, code lost:
        if (com.google.android.gms.internal.ads.zzeqg.zzl(r10, r6) == com.google.android.gms.internal.ads.zzeqg.zzl(r11, r6)) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzeqg.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzeqg.zzn(r11, r6))) goto L85;
     */
    @Override // com.google.android.gms.internal.ads.zzepi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(T t, T t2) {
        int length = this.zzivu.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzhv = zzhv(i);
                long j = zzhv & 1048575;
                switch ((zzhv & 267386880) >>> 20) {
                    case 0:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 1:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 2:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 3:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 4:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 5:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 6:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 7:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 8:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 9:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 11:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 12:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 13:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 14:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 15:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 16:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 17:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzepk.zzh(zzeqg.zzp(t, j), zzeqg.zzp(t2, j));
                        break;
                    case 50:
                        z = zzepk.zzh(zzeqg.zzp(t, j), zzeqg.zzp(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zzhw = zzhw(i) & 1048575;
                        if (zzeqg.zzk(t, zzhw) == zzeqg.zzk(t2, zzhw)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (this.zziwi.zzay(t).equals(this.zziwi.zzay(t2))) {
                if (this.zzivz) {
                    return this.zziwj.zzai(t).equals(this.zziwj.zzai(t2));
                }
                return true;
            } else {
                return false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final int hashCode(T t) {
        int i;
        int zzfr;
        int length = this.zzivu.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int zzhv = zzhv(i3);
            int i4 = this.zzivu[i3];
            long j = 1048575 & zzhv;
            int i5 = 37;
            switch ((zzhv & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    zzfr = zzenc.zzfr(Double.doubleToLongBits(zzeqg.zzo(t, j)));
                    i2 = i + zzfr;
                    break;
                case 1:
                    i = i2 * 53;
                    zzfr = Float.floatToIntBits(zzeqg.zzn(t, j));
                    i2 = i + zzfr;
                    break;
                case 2:
                    i = i2 * 53;
                    zzfr = zzenc.zzfr(zzeqg.zzl(t, j));
                    i2 = i + zzfr;
                    break;
                case 3:
                    i = i2 * 53;
                    zzfr = zzenc.zzfr(zzeqg.zzl(t, j));
                    i2 = i + zzfr;
                    break;
                case 4:
                    i = i2 * 53;
                    zzfr = zzeqg.zzk(t, j);
                    i2 = i + zzfr;
                    break;
                case 5:
                    i = i2 * 53;
                    zzfr = zzenc.zzfr(zzeqg.zzl(t, j));
                    i2 = i + zzfr;
                    break;
                case 6:
                    i = i2 * 53;
                    zzfr = zzeqg.zzk(t, j);
                    i2 = i + zzfr;
                    break;
                case 7:
                    i = i2 * 53;
                    zzfr = zzenc.zzby(zzeqg.zzm(t, j));
                    i2 = i + zzfr;
                    break;
                case 8:
                    i = i2 * 53;
                    zzfr = ((String) zzeqg.zzp(t, j)).hashCode();
                    i2 = i + zzfr;
                    break;
                case 9:
                    Object zzp = zzeqg.zzp(t, j);
                    if (zzp != null) {
                        i5 = zzp.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    zzfr = zzeqg.zzp(t, j).hashCode();
                    i2 = i + zzfr;
                    break;
                case 11:
                    i = i2 * 53;
                    zzfr = zzeqg.zzk(t, j);
                    i2 = i + zzfr;
                    break;
                case 12:
                    i = i2 * 53;
                    zzfr = zzeqg.zzk(t, j);
                    i2 = i + zzfr;
                    break;
                case 13:
                    i = i2 * 53;
                    zzfr = zzeqg.zzk(t, j);
                    i2 = i + zzfr;
                    break;
                case 14:
                    i = i2 * 53;
                    zzfr = zzenc.zzfr(zzeqg.zzl(t, j));
                    i2 = i + zzfr;
                    break;
                case 15:
                    i = i2 * 53;
                    zzfr = zzeqg.zzk(t, j);
                    i2 = i + zzfr;
                    break;
                case 16:
                    i = i2 * 53;
                    zzfr = zzenc.zzfr(zzeqg.zzl(t, j));
                    i2 = i + zzfr;
                    break;
                case 17:
                    Object zzp2 = zzeqg.zzp(t, j);
                    if (zzp2 != null) {
                        i5 = zzp2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    zzfr = zzeqg.zzp(t, j).hashCode();
                    i2 = i + zzfr;
                    break;
                case 50:
                    i = i2 * 53;
                    zzfr = zzeqg.zzp(t, j).hashCode();
                    i2 = i + zzfr;
                    break;
                case 51:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzenc.zzfr(Double.doubleToLongBits(zzf(t, j)));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = Float.floatToIntBits(zzg(t, j));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzenc.zzfr(zzi(t, j));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzenc.zzfr(zzi(t, j));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzh(t, j);
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzenc.zzfr(zzi(t, j));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzh(t, j);
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzenc.zzby(zzj(t, j));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = ((String) zzeqg.zzp(t, j)).hashCode();
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzeqg.zzp(t, j).hashCode();
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzeqg.zzp(t, j).hashCode();
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzh(t, j);
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzh(t, j);
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzh(t, j);
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzenc.zzfr(zzi(t, j));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzh(t, j);
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzenc.zzfr(zzi(t, j));
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzeor<T>) t, i4, i3)) {
                        i = i2 * 53;
                        zzfr = zzeqg.zzp(t, j).hashCode();
                        i2 = i + zzfr;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.zziwi.zzay(t).hashCode();
        return this.zzivz ? (hashCode * 53) + this.zziwj.zzai(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zzg(T t, T t2) {
        if (t2 == null) {
            throw null;
        }
        for (int i = 0; i < this.zzivu.length; i += 3) {
            int zzhv = zzhv(i);
            long j = 1048575 & zzhv;
            int i2 = this.zzivu[i];
            switch ((zzhv & 267386880) >>> 20) {
                case 0:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza(t, j, zzeqg.zzo(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza((Object) t, j, zzeqg.zzn(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza((Object) t, j, zzeqg.zzl(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza((Object) t, j, zzeqg.zzl(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zzb(t, j, zzeqg.zzk(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza((Object) t, j, zzeqg.zzl(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zzb(t, j, zzeqg.zzk(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza(t, j, zzeqg.zzm(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza(t, j, zzeqg.zzp(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza(t, j, zzeqg.zzp(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zzb(t, j, zzeqg.zzk(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zzb(t, j, zzeqg.zzk(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zzb(t, j, zzeqg.zzk(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza((Object) t, j, zzeqg.zzl(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zzb(t, j, zzeqg.zzk(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zze((zzeor<T>) t2, i)) {
                        zzeqg.zza((Object) t, j, zzeqg.zzl(t2, j));
                        zzf((zzeor<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zziwh.zza(t, t2, j);
                    break;
                case 50:
                    zzepk.zza(this.zziwk, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza((zzeor<T>) t2, i2, i)) {
                        zzeqg.zza(t, j, zzeqg.zzp(t2, j));
                        zzb((zzeor<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza((zzeor<T>) t2, i2, i)) {
                        zzeqg.zza(t, j, zzeqg.zzp(t2, j));
                        zzb((zzeor<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzepk.zza(this.zziwi, t, t2);
        if (this.zzivz) {
            zzepk.zza(this.zziwj, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzhv = zzhv(i) & 1048575;
        if (zze((zzeor<T>) t2, i)) {
            Object zzp = zzeqg.zzp(t, zzhv);
            Object zzp2 = zzeqg.zzp(t2, zzhv);
            if (zzp != null && zzp2 != null) {
                zzeqg.zza(t, zzhv, zzenc.zze(zzp, zzp2));
                zzf((zzeor<T>) t, i);
            } else if (zzp2 != null) {
                zzeqg.zza(t, zzhv, zzp2);
                zzf((zzeor<T>) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzhv = zzhv(i);
        int i2 = this.zzivu[i];
        long j = zzhv & 1048575;
        if (zza((zzeor<T>) t2, i2, i)) {
            Object zzp = zza((zzeor<T>) t, i2, i) ? zzeqg.zzp(t, j) : null;
            Object zzp2 = zzeqg.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzeqg.zza(t, j, zzenc.zze(zzp, zzp2));
                zzb((zzeor<T>) t, i2, i);
            } else if (zzp2 != null) {
                zzeqg.zza(t, j, zzp2);
                zzb((zzeor<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzepi
    public final int zzau(T t) {
        int i;
        long j;
        int zzl;
        int zzj;
        int zzam;
        int zzv;
        int zzak;
        int zzhd;
        int zzhf;
        int zzc;
        int zzak2;
        int zzhd2;
        int zzhf2;
        int i2 = 267386880;
        int i3 = 1048575;
        int i4 = 1;
        if (this.zziwb) {
            Unsafe unsafe = zzicl;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.zzivu.length) {
                int zzhv = zzhv(i5);
                int i7 = (zzhv & i2) >>> 20;
                int i8 = this.zzivu[i5];
                long j2 = zzhv & 1048575;
                if (i7 >= zzemu.DOUBLE_LIST_PACKED.id() && i7 <= zzemu.SINT64_LIST_PACKED.id()) {
                    int i9 = this.zzivu[i5 + 2];
                }
                switch (i7) {
                    case 0:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzc(i8, 0.0d);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 1:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzb(i8, 0.0f);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 2:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzl(i8, zzeqg.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 3:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzm(i8, zzeqg.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 4:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzai(i8, zzeqg.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 5:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzo(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 6:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzal(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 7:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzi(i8, true);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 8:
                        if (zze((zzeor<T>) t, i5)) {
                            Object zzp = zzeqg.zzp(t, j2);
                            if (zzp instanceof zzelq) {
                                zzc = zzemk.zzc(i8, (zzelq) zzp);
                                break;
                            } else {
                                zzc = zzemk.zzj(i8, (String) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 9:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzepk.zzc(i8, zzeqg.zzp(t, j2), zzhs(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 10:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzc(i8, (zzelq) zzeqg.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 11:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzaj(i8, zzeqg.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 12:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzan(i8, zzeqg.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 13:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzam(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 14:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzp(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 15:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzak(i8, zzeqg.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 16:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzn(i8, zzeqg.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 17:
                        if (zze((zzeor<T>) t, i5)) {
                            zzc = zzemk.zzc(i8, (zzeon) zzeqg.zzp(t, j2), zzhs(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 18:
                        zzc = zzepk.zzw(i8, zze(t, j2), false);
                        break;
                    case 19:
                        zzc = zzepk.zzv(i8, zze(t, j2), false);
                        break;
                    case 20:
                        zzc = zzepk.zzo(i8, zze(t, j2), false);
                        break;
                    case 21:
                        zzc = zzepk.zzp(i8, zze(t, j2), false);
                        break;
                    case 22:
                        zzc = zzepk.zzs(i8, zze(t, j2), false);
                        break;
                    case 23:
                        zzc = zzepk.zzw(i8, zze(t, j2), false);
                        break;
                    case 24:
                        zzc = zzepk.zzv(i8, zze(t, j2), false);
                        break;
                    case 25:
                        zzc = zzepk.zzx(i8, zze(t, j2), false);
                        break;
                    case 26:
                        zzc = zzepk.zzc(i8, zze(t, j2));
                        break;
                    case 27:
                        zzc = zzepk.zzc(i8, zze(t, j2), zzhs(i5));
                        break;
                    case 28:
                        zzc = zzepk.zzd(i8, zze(t, j2));
                        break;
                    case 29:
                        zzc = zzepk.zzt(i8, zze(t, j2), false);
                        break;
                    case 30:
                        zzc = zzepk.zzr(i8, zze(t, j2), false);
                        break;
                    case 31:
                        zzc = zzepk.zzv(i8, zze(t, j2), false);
                        break;
                    case 32:
                        zzc = zzepk.zzw(i8, zze(t, j2), false);
                        break;
                    case 33:
                        zzc = zzepk.zzu(i8, zze(t, j2), false);
                        break;
                    case 34:
                        zzc = zzepk.zzq(i8, zze(t, j2), false);
                        break;
                    case 35:
                        zzak2 = zzepk.zzak((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 36:
                        zzak2 = zzepk.zzaj((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 37:
                        zzak2 = zzepk.zzac((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 38:
                        zzak2 = zzepk.zzad((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 39:
                        zzak2 = zzepk.zzag((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 40:
                        zzak2 = zzepk.zzak((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 41:
                        zzak2 = zzepk.zzaj((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 42:
                        zzak2 = zzepk.zzal((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 43:
                        zzak2 = zzepk.zzah((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 44:
                        zzak2 = zzepk.zzaf((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 45:
                        zzak2 = zzepk.zzaj((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 46:
                        zzak2 = zzepk.zzak((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 47:
                        zzak2 = zzepk.zzai((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 48:
                        zzak2 = zzepk.zzae((List) unsafe.getObject(t, j2));
                        if (zzak2 > 0) {
                            zzhd2 = zzemk.zzhd(i8);
                            zzhf2 = zzemk.zzhf(zzak2);
                            zzc = zzhd2 + zzhf2 + zzak2;
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 49:
                        zzc = zzepk.zzd(i8, zze(t, j2), zzhs(i5));
                        break;
                    case 50:
                        zzc = this.zziwk.zzb(i8, zzeqg.zzp(t, j2), zzht(i5));
                        break;
                    case 51:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzc(i8, 0.0d);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 52:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzb(i8, 0.0f);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 53:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzl(i8, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 54:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzm(i8, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 55:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzai(i8, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 56:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzo(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 57:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzal(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 58:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzi(i8, true);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 59:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            Object zzp2 = zzeqg.zzp(t, j2);
                            if (zzp2 instanceof zzelq) {
                                zzc = zzemk.zzc(i8, (zzelq) zzp2);
                                break;
                            } else {
                                zzc = zzemk.zzj(i8, (String) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 60:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzepk.zzc(i8, zzeqg.zzp(t, j2), zzhs(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 61:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzc(i8, (zzelq) zzeqg.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 62:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzaj(i8, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 63:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzan(i8, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 64:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzam(i8, 0);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 65:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzp(i8, 0L);
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 66:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzak(i8, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 67:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzn(i8, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    case 68:
                        if (zza((zzeor<T>) t, i8, i5)) {
                            zzc = zzemk.zzc(i8, (zzeon) zzeqg.zzp(t, j2), zzhs(i5));
                            break;
                        } else {
                            continue;
                            i5 += 3;
                            i2 = 267386880;
                        }
                    default:
                        i5 += 3;
                        i2 = 267386880;
                }
                i6 += zzc;
                i5 += 3;
                i2 = 267386880;
            }
            return i6 + zza(this.zziwi, t);
        }
        Unsafe unsafe2 = zzicl;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1048575;
        int i13 = 0;
        while (i10 < this.zzivu.length) {
            int zzhv2 = zzhv(i10);
            int[] iArr = this.zzivu;
            int i14 = iArr[i10];
            int i15 = (zzhv2 & 267386880) >>> 20;
            if (i15 <= 17) {
                int i16 = iArr[i10 + 2];
                int i17 = i16 & i3;
                i = i4 << (i16 >>> 20);
                if (i17 != i12) {
                    i13 = unsafe2.getInt(t, i17);
                    i12 = i17;
                }
            } else {
                i = 0;
            }
            long j3 = zzhv2 & i3;
            switch (i15) {
                case 0:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i11 += zzemk.zzc(i14, 0.0d);
                        continue;
                        i10 += 3;
                        i3 = 1048575;
                        i4 = 1;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i13 & i) != 0) {
                        i11 += zzemk.zzb(i14, 0.0f);
                        break;
                    }
                    break;
                case 2:
                    j = 0;
                    if ((i & i13) != 0) {
                        zzl = zzemk.zzl(i14, unsafe2.getLong(t, j3));
                        i11 += zzl;
                        break;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i & i13) != 0) {
                        zzl = zzemk.zzm(i14, unsafe2.getLong(t, j3));
                        i11 += zzl;
                        break;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i & i13) != 0) {
                        zzl = zzemk.zzai(i14, unsafe2.getInt(t, j3));
                        i11 += zzl;
                        break;
                    }
                    break;
                case 5:
                    j = 0;
                    if ((i13 & i) != 0) {
                        zzl = zzemk.zzo(i14, 0L);
                        i11 += zzl;
                        break;
                    }
                    break;
                case 6:
                    if ((i13 & i) != 0) {
                        i11 += zzemk.zzal(i14, 0);
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 7:
                    if ((i13 & i) != 0) {
                        i11 += zzemk.zzi(i14, true);
                        j = 0;
                        i10 += 3;
                        i3 = 1048575;
                        i4 = 1;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 8:
                    if ((i13 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzelq) {
                            zzj = zzemk.zzc(i14, (zzelq) object);
                        } else {
                            zzj = zzemk.zzj(i14, (String) object);
                        }
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 9:
                    if ((i13 & i) != 0) {
                        zzj = zzepk.zzc(i14, unsafe2.getObject(t, j3), zzhs(i10));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 10:
                    if ((i13 & i) != 0) {
                        zzj = zzemk.zzc(i14, (zzelq) unsafe2.getObject(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 11:
                    if ((i13 & i) != 0) {
                        zzj = zzemk.zzaj(i14, unsafe2.getInt(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 12:
                    if ((i13 & i) != 0) {
                        zzj = zzemk.zzan(i14, unsafe2.getInt(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 13:
                    if ((i13 & i) != 0) {
                        zzam = zzemk.zzam(i14, 0);
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 14:
                    if ((i13 & i) != 0) {
                        zzj = zzemk.zzp(i14, 0L);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 15:
                    if ((i13 & i) != 0) {
                        zzj = zzemk.zzak(i14, unsafe2.getInt(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 16:
                    if ((i13 & i) != 0) {
                        zzj = zzemk.zzn(i14, unsafe2.getLong(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 17:
                    if ((i13 & i) != 0) {
                        zzj = zzemk.zzc(i14, (zzeon) unsafe2.getObject(t, j3), zzhs(i10));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 18:
                    zzj = zzepk.zzw(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzj;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 19:
                    zzv = zzepk.zzv(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 20:
                    zzv = zzepk.zzo(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 21:
                    zzv = zzepk.zzp(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 22:
                    zzv = zzepk.zzs(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 23:
                    zzv = zzepk.zzw(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 24:
                    zzv = zzepk.zzv(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 25:
                    zzv = zzepk.zzx(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 26:
                    zzj = zzepk.zzc(i14, (List) unsafe2.getObject(t, j3));
                    i11 += zzj;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 27:
                    zzj = zzepk.zzc(i14, (List<?>) unsafe2.getObject(t, j3), zzhs(i10));
                    i11 += zzj;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 28:
                    zzj = zzepk.zzd(i14, (List) unsafe2.getObject(t, j3));
                    i11 += zzj;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 29:
                    zzj = zzepk.zzt(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzj;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 30:
                    zzv = zzepk.zzr(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 31:
                    zzv = zzepk.zzv(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 32:
                    zzv = zzepk.zzw(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 33:
                    zzv = zzepk.zzu(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 34:
                    zzv = zzepk.zzq(i14, (List) unsafe2.getObject(t, j3), false);
                    i11 += zzv;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 35:
                    zzak = zzepk.zzak((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 36:
                    zzak = zzepk.zzaj((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 37:
                    zzak = zzepk.zzac((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 38:
                    zzak = zzepk.zzad((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 39:
                    zzak = zzepk.zzag((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 40:
                    zzak = zzepk.zzak((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 41:
                    zzak = zzepk.zzaj((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 42:
                    zzak = zzepk.zzal((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 43:
                    zzak = zzepk.zzah((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 44:
                    zzak = zzepk.zzaf((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 45:
                    zzak = zzepk.zzaj((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 46:
                    zzak = zzepk.zzak((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 47:
                    zzak = zzepk.zzai((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 48:
                    zzak = zzepk.zzae((List) unsafe2.getObject(t, j3));
                    if (zzak > 0) {
                        zzhd = zzemk.zzhd(i14);
                        zzhf = zzemk.zzhf(zzak);
                        zzam = zzhd + zzhf + zzak;
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 49:
                    zzj = zzepk.zzd(i14, (List) unsafe2.getObject(t, j3), zzhs(i10));
                    i11 += zzj;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 50:
                    zzj = this.zziwk.zzb(i14, unsafe2.getObject(t, j3), zzht(i10));
                    i11 += zzj;
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 51:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzc(i14, 0.0d);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 52:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzam = zzemk.zzb(i14, 0.0f);
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 53:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzl(i14, zzi(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 54:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzm(i14, zzi(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 55:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzai(i14, zzh(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 56:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzo(i14, 0L);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 57:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzam = zzemk.zzal(i14, 0);
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 58:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzam = zzemk.zzi(i14, true);
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 59:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzelq) {
                            zzj = zzemk.zzc(i14, (zzelq) object2);
                        } else {
                            zzj = zzemk.zzj(i14, (String) object2);
                        }
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 60:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzepk.zzc(i14, unsafe2.getObject(t, j3), zzhs(i10));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 61:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzc(i14, (zzelq) unsafe2.getObject(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 62:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzaj(i14, zzh(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 63:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzan(i14, zzh(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 64:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzam = zzemk.zzam(i14, 0);
                        i11 += zzam;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 65:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzp(i14, 0L);
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 66:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzak(i14, zzh(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 67:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzn(i14, zzi(t, j3));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                case 68:
                    if (zza((zzeor<T>) t, i14, i10)) {
                        zzj = zzemk.zzc(i14, (zzeon) unsafe2.getObject(t, j3), zzhs(i10));
                        i11 += zzj;
                    }
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
                default:
                    j = 0;
                    i10 += 3;
                    i3 = 1048575;
                    i4 = 1;
            }
            i10 += 3;
            i3 = 1048575;
            i4 = 1;
        }
        int i18 = 0;
        int zza = i11 + zza(this.zziwi, t);
        if (this.zzivz) {
            zzemt<?> zzai = this.zziwj.zzai(t);
            for (int i19 = 0; i19 < zzai.zziqs.zzblp(); i19++) {
                Map.Entry<?, Object> zzic = zzai.zziqs.zzic(i19);
                i18 += zzemt.zzc((zzemv) zzic.getKey(), zzic.getValue());
            }
            for (Map.Entry<?, Object> entry : zzai.zziqs.zzblq()) {
                i18 += zzemt.zzc((zzemv) entry.getKey(), entry.getValue());
            }
            return zza + i18;
        }
        return zza;
    }

    private static <UT, UB> int zza(zzeqa<UT, UB> zzeqaVar, T t) {
        return zzeqaVar.zzau(zzeqaVar.zzay(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzeqg.zzp(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0a2a  */
    @Override // com.google.android.gms.internal.ads.zzepi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, zzeqx zzeqxVar) {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, Object> entry;
        int length;
        int i;
        Iterator<Map.Entry<?, Object>> it2;
        Map.Entry<?, Object> entry2;
        int length2;
        if (zzeqxVar.zzbiu() == zzeqw.zzjal) {
            zza(this.zziwi, t, zzeqxVar);
            if (this.zzivz) {
                zzemt<?> zzai = this.zziwj.zzai(t);
                if (!zzai.zziqs.isEmpty()) {
                    it2 = zzai.descendingIterator();
                    entry2 = it2.next();
                    for (length2 = this.zzivu.length - 3; length2 >= 0; length2 -= 3) {
                        int zzhv = zzhv(length2);
                        int i2 = this.zzivu[length2];
                        while (entry2 != null && this.zziwj.zza(entry2) > i2) {
                            this.zziwj.zza(zzeqxVar, entry2);
                            entry2 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((zzhv & 267386880) >>> 20) {
                            case 0:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzb(i2, zzeqg.zzo(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zza(i2, zzeqg.zzn(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzq(i2, zzeqg.zzl(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzi(i2, zzeqg.zzl(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzae(i2, zzeqg.zzk(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzk(i2, zzeqg.zzl(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzah(i2, zzeqg.zzk(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzh(i2, zzeqg.zzm(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zze((zzeor<T>) t, length2)) {
                                    zza(i2, zzeqg.zzp(t, zzhv & 1048575), zzeqxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zza(i2, zzeqg.zzp(t, zzhv & 1048575), zzhs(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zza(i2, (zzelq) zzeqg.zzp(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzaf(i2, zzeqg.zzk(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzap(i2, zzeqg.zzk(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzao(i2, zzeqg.zzk(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzr(i2, zzeqg.zzl(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzag(i2, zzeqg.zzk(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzj(i2, zzeqg.zzl(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zze((zzeor<T>) t, length2)) {
                                    zzeqxVar.zzb(i2, zzeqg.zzp(t, zzhv & 1048575), zzhs(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzepk.zza(this.zzivu[length2], (List<Double>) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 19:
                                zzepk.zzb(this.zzivu[length2], (List<Float>) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 20:
                                zzepk.zzc(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 21:
                                zzepk.zzd(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 22:
                                zzepk.zzh(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 23:
                                zzepk.zzf(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 24:
                                zzepk.zzk(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 25:
                                zzepk.zzn(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 26:
                                zzepk.zza(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar);
                                break;
                            case 27:
                                zzepk.zza(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, zzhs(length2));
                                break;
                            case 28:
                                zzepk.zzb(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar);
                                break;
                            case 29:
                                zzepk.zzi(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 30:
                                zzepk.zzm(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 31:
                                zzepk.zzl(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 32:
                                zzepk.zzg(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 33:
                                zzepk.zzj(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 34:
                                zzepk.zze(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, false);
                                break;
                            case 35:
                                zzepk.zza(this.zzivu[length2], (List<Double>) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 36:
                                zzepk.zzb(this.zzivu[length2], (List<Float>) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 37:
                                zzepk.zzc(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 38:
                                zzepk.zzd(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 39:
                                zzepk.zzh(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 40:
                                zzepk.zzf(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 41:
                                zzepk.zzk(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 42:
                                zzepk.zzn(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 43:
                                zzepk.zzi(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 44:
                                zzepk.zzm(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 45:
                                zzepk.zzl(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 46:
                                zzepk.zzg(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 47:
                                zzepk.zzj(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 48:
                                zzepk.zze(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, true);
                                break;
                            case 49:
                                zzepk.zzb(this.zzivu[length2], (List) zzeqg.zzp(t, zzhv & 1048575), zzeqxVar, zzhs(length2));
                                break;
                            case 50:
                                zza(zzeqxVar, i2, zzeqg.zzp(t, zzhv & 1048575), length2);
                                break;
                            case 51:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzb(i2, zzf(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zza(i2, zzg(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzq(i2, zzi(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzi(i2, zzi(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzae(i2, zzh(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzk(i2, zzi(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzah(i2, zzh(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzh(i2, zzj(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zza(i2, zzeqg.zzp(t, zzhv & 1048575), zzeqxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zza(i2, zzeqg.zzp(t, zzhv & 1048575), zzhs(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zza(i2, (zzelq) zzeqg.zzp(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzaf(i2, zzh(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzap(i2, zzh(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzao(i2, zzh(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzr(i2, zzi(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzag(i2, zzh(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzj(i2, zzi(t, zzhv & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza((zzeor<T>) t, i2, length2)) {
                                    zzeqxVar.zzb(i2, zzeqg.zzp(t, zzhv & 1048575), zzhs(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.zziwj.zza(zzeqxVar, entry2);
                        entry2 = it2.hasNext() ? it2.next() : null;
                    }
                }
            }
            it2 = null;
            entry2 = null;
            while (length2 >= 0) {
            }
            while (entry2 != null) {
            }
        } else if (this.zziwb) {
            if (this.zzivz) {
                zzemt<?> zzai2 = this.zziwj.zzai(t);
                if (!zzai2.zziqs.isEmpty()) {
                    it = zzai2.iterator();
                    entry = it.next();
                    length = this.zzivu.length;
                    for (i = 0; i < length; i += 3) {
                        int zzhv2 = zzhv(i);
                        int i3 = this.zzivu[i];
                        while (entry != null && this.zziwj.zza(entry) <= i3) {
                            this.zziwj.zza(zzeqxVar, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch ((zzhv2 & 267386880) >>> 20) {
                            case 0:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzb(i3, zzeqg.zzo(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zza(i3, zzeqg.zzn(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzq(i3, zzeqg.zzl(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzi(i3, zzeqg.zzl(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzae(i3, zzeqg.zzk(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzk(i3, zzeqg.zzl(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzah(i3, zzeqg.zzk(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzh(i3, zzeqg.zzm(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zze((zzeor<T>) t, i)) {
                                    zza(i3, zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zza(i3, zzeqg.zzp(t, zzhv2 & 1048575), zzhs(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zza(i3, (zzelq) zzeqg.zzp(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzaf(i3, zzeqg.zzk(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzap(i3, zzeqg.zzk(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzao(i3, zzeqg.zzk(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzr(i3, zzeqg.zzl(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzag(i3, zzeqg.zzk(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzj(i3, zzeqg.zzl(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zze((zzeor<T>) t, i)) {
                                    zzeqxVar.zzb(i3, zzeqg.zzp(t, zzhv2 & 1048575), zzhs(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzepk.zza(this.zzivu[i], (List<Double>) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 19:
                                zzepk.zzb(this.zzivu[i], (List<Float>) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 20:
                                zzepk.zzc(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 21:
                                zzepk.zzd(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 22:
                                zzepk.zzh(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 23:
                                zzepk.zzf(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 24:
                                zzepk.zzk(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 25:
                                zzepk.zzn(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 26:
                                zzepk.zza(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar);
                                break;
                            case 27:
                                zzepk.zza(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, zzhs(i));
                                break;
                            case 28:
                                zzepk.zzb(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar);
                                break;
                            case 29:
                                zzepk.zzi(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 30:
                                zzepk.zzm(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 31:
                                zzepk.zzl(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 32:
                                zzepk.zzg(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 33:
                                zzepk.zzj(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 34:
                                zzepk.zze(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, false);
                                break;
                            case 35:
                                zzepk.zza(this.zzivu[i], (List<Double>) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 36:
                                zzepk.zzb(this.zzivu[i], (List<Float>) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 37:
                                zzepk.zzc(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 38:
                                zzepk.zzd(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 39:
                                zzepk.zzh(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 40:
                                zzepk.zzf(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 41:
                                zzepk.zzk(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 42:
                                zzepk.zzn(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 43:
                                zzepk.zzi(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 44:
                                zzepk.zzm(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 45:
                                zzepk.zzl(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 46:
                                zzepk.zzg(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 47:
                                zzepk.zzj(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 48:
                                zzepk.zze(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, true);
                                break;
                            case 49:
                                zzepk.zzb(this.zzivu[i], (List) zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar, zzhs(i));
                                break;
                            case 50:
                                zza(zzeqxVar, i3, zzeqg.zzp(t, zzhv2 & 1048575), i);
                                break;
                            case 51:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzb(i3, zzf(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zza(i3, zzg(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzq(i3, zzi(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzi(i3, zzi(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzae(i3, zzh(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzk(i3, zzi(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzah(i3, zzh(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzh(i3, zzj(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zza(i3, zzeqg.zzp(t, zzhv2 & 1048575), zzeqxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zza(i3, zzeqg.zzp(t, zzhv2 & 1048575), zzhs(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zza(i3, (zzelq) zzeqg.zzp(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzaf(i3, zzh(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzap(i3, zzh(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzao(i3, zzh(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzr(i3, zzi(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzag(i3, zzh(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzj(i3, zzi(t, zzhv2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza((zzeor<T>) t, i3, i)) {
                                    zzeqxVar.zzb(i3, zzeqg.zzp(t, zzhv2 & 1048575), zzhs(i));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.zziwj.zza(zzeqxVar, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    zza(this.zziwi, t, zzeqxVar);
                }
            }
            it = null;
            entry = null;
            length = this.zzivu.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zziwi, t, zzeqxVar);
        } else {
            zzb(t, zzeqxVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0491  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzb(T t, zzeqx zzeqxVar) {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, Object> entry;
        int length;
        int i;
        int i2;
        if (this.zzivz) {
            zzemt<?> zzai = this.zziwj.zzai(t);
            if (!zzai.zziqs.isEmpty()) {
                it = zzai.iterator();
                entry = it.next();
                length = this.zzivu.length;
                Unsafe unsafe = zzicl;
                int i3 = 1048575;
                int i4 = 0;
                for (i = 0; i < length; i += 3) {
                    int zzhv = zzhv(i);
                    int[] iArr = this.zzivu;
                    int i5 = iArr[i];
                    int i6 = (zzhv & 267386880) >>> 20;
                    if (i6 <= 17) {
                        int i7 = iArr[i + 2];
                        int i8 = i7 & 1048575;
                        if (i8 != i3) {
                            i4 = unsafe.getInt(t, i8);
                            i3 = i8;
                        }
                        i2 = 1 << (i7 >>> 20);
                    } else {
                        i2 = 0;
                    }
                    while (entry != null && this.zziwj.zza(entry) <= i5) {
                        this.zziwj.zza(zzeqxVar, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = zzhv & 1048575;
                    switch (i6) {
                        case 0:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzb(i5, zzeqg.zzo(t, j));
                                continue;
                            }
                        case 1:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zza(i5, zzeqg.zzn(t, j));
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzq(i5, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzi(i5, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzae(i5, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzk(i5, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzah(i5, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzh(i5, zzeqg.zzm(t, j));
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i2 & i4) != 0) {
                                zza(i5, unsafe.getObject(t, j), zzeqxVar);
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zza(i5, unsafe.getObject(t, j), zzhs(i));
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zza(i5, (zzelq) unsafe.getObject(t, j));
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzaf(i5, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzap(i5, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzao(i5, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzr(i5, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzag(i5, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzj(i5, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i2 & i4) != 0) {
                                zzeqxVar.zzb(i5, unsafe.getObject(t, j), zzhs(i));
                            } else {
                                continue;
                            }
                        case 18:
                            zzepk.zza(this.zzivu[i], (List<Double>) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 19:
                            zzepk.zzb(this.zzivu[i], (List<Float>) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 20:
                            zzepk.zzc(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 21:
                            zzepk.zzd(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 22:
                            zzepk.zzh(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 23:
                            zzepk.zzf(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 24:
                            zzepk.zzk(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 25:
                            zzepk.zzn(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 26:
                            zzepk.zza(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar);
                            break;
                        case 27:
                            zzepk.zza(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, zzhs(i));
                            break;
                        case 28:
                            zzepk.zzb(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar);
                            break;
                        case 29:
                            zzepk.zzi(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 30:
                            zzepk.zzm(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 31:
                            zzepk.zzl(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 32:
                            zzepk.zzg(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 33:
                            zzepk.zzj(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 34:
                            zzepk.zze(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, false);
                            break;
                        case 35:
                            zzepk.zza(this.zzivu[i], (List<Double>) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 36:
                            zzepk.zzb(this.zzivu[i], (List<Float>) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 37:
                            zzepk.zzc(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 38:
                            zzepk.zzd(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 39:
                            zzepk.zzh(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 40:
                            zzepk.zzf(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 41:
                            zzepk.zzk(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 42:
                            zzepk.zzn(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 43:
                            zzepk.zzi(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 44:
                            zzepk.zzm(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 45:
                            zzepk.zzl(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 46:
                            zzepk.zzg(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 47:
                            zzepk.zzj(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 48:
                            zzepk.zze(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, true);
                            break;
                        case 49:
                            zzepk.zzb(this.zzivu[i], (List) unsafe.getObject(t, j), zzeqxVar, zzhs(i));
                            break;
                        case 50:
                            zza(zzeqxVar, i5, unsafe.getObject(t, j), i);
                            break;
                        case 51:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzb(i5, zzf(t, j));
                                break;
                            }
                            break;
                        case 52:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zza(i5, zzg(t, j));
                                break;
                            }
                            break;
                        case 53:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzq(i5, zzi(t, j));
                                break;
                            }
                            break;
                        case 54:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzi(i5, zzi(t, j));
                                break;
                            }
                            break;
                        case 55:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzae(i5, zzh(t, j));
                                break;
                            }
                            break;
                        case 56:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzk(i5, zzi(t, j));
                                break;
                            }
                            break;
                        case 57:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzah(i5, zzh(t, j));
                                break;
                            }
                            break;
                        case 58:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzh(i5, zzj(t, j));
                                break;
                            }
                            break;
                        case 59:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zza(i5, unsafe.getObject(t, j), zzeqxVar);
                                break;
                            }
                            break;
                        case 60:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zza(i5, unsafe.getObject(t, j), zzhs(i));
                                break;
                            }
                            break;
                        case 61:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zza(i5, (zzelq) unsafe.getObject(t, j));
                                break;
                            }
                            break;
                        case 62:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzaf(i5, zzh(t, j));
                                break;
                            }
                            break;
                        case 63:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzap(i5, zzh(t, j));
                                break;
                            }
                            break;
                        case 64:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzao(i5, zzh(t, j));
                                break;
                            }
                            break;
                        case 65:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzr(i5, zzi(t, j));
                                break;
                            }
                            break;
                        case 66:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzag(i5, zzh(t, j));
                                break;
                            }
                            break;
                        case 67:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzj(i5, zzi(t, j));
                                break;
                            }
                            break;
                        case 68:
                            if (zza((zzeor<T>) t, i5, i)) {
                                zzeqxVar.zzb(i5, unsafe.getObject(t, j), zzhs(i));
                                break;
                            }
                            break;
                    }
                }
                while (entry != null) {
                    this.zziwj.zza(zzeqxVar, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zziwi, t, zzeqxVar);
            }
        }
        it = null;
        entry = null;
        length = this.zzivu.length;
        Unsafe unsafe2 = zzicl;
        int i32 = 1048575;
        int i42 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        zza(this.zziwi, t, zzeqxVar);
    }

    private final <K, V> void zza(zzeqx zzeqxVar, int i, Object obj, int i2) {
        if (obj != null) {
            zzeqxVar.zza(i, this.zziwk.zzas(zzht(i2)), this.zziwk.zzao(obj));
        }
    }

    private static <UT, UB> void zza(zzeqa<UT, UB> zzeqaVar, T t, zzeqx zzeqxVar) {
        zzeqaVar.zza((zzeqa<UT, UB>) zzeqaVar.zzay(t), zzeqxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza(T t, zzepc zzepcVar, zzemn zzemnVar) {
        if (zzemnVar == null) {
            throw null;
        }
        zzeqa zzeqaVar = this.zziwi;
        zzemp<?> zzempVar = this.zziwj;
        zzemt<?> zzemtVar = null;
        Object obj = null;
        while (true) {
            try {
                int zzbip = zzepcVar.zzbip();
                int zzhy = zzhy(zzbip);
                if (zzhy >= 0) {
                    int zzhv = zzhv(zzhy);
                    switch ((267386880 & zzhv) >>> 20) {
                        case 0:
                            zzeqg.zza(t, zzhv & 1048575, zzepcVar.readDouble());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 1:
                            zzeqg.zza((Object) t, zzhv & 1048575, zzepcVar.readFloat());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 2:
                            zzeqg.zza((Object) t, zzhv & 1048575, zzepcVar.zzbht());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 3:
                            zzeqg.zza((Object) t, zzhv & 1048575, zzepcVar.zzbhs());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 4:
                            zzeqg.zzb(t, zzhv & 1048575, zzepcVar.zzbhu());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 5:
                            zzeqg.zza((Object) t, zzhv & 1048575, zzepcVar.zzbhv());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 6:
                            zzeqg.zzb(t, zzhv & 1048575, zzepcVar.zzbhw());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 7:
                            zzeqg.zza(t, zzhv & 1048575, zzepcVar.zzbhx());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 8:
                            zza(t, zzhv, zzepcVar);
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 9:
                            if (zze((zzeor<T>) t, zzhy)) {
                                long j = zzhv & 1048575;
                                zzeqg.zza(t, j, zzenc.zze(zzeqg.zzp(t, j), zzepcVar.zza(zzhs(zzhy), zzemnVar)));
                                break;
                            } else {
                                zzeqg.zza(t, zzhv & 1048575, zzepcVar.zza(zzhs(zzhy), zzemnVar));
                                zzf((zzeor<T>) t, zzhy);
                                continue;
                            }
                        case 10:
                            zzeqg.zza(t, zzhv & 1048575, zzepcVar.zzbhz());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 11:
                            zzeqg.zzb(t, zzhv & 1048575, zzepcVar.zzbia());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 12:
                            int zzbib = zzepcVar.zzbib();
                            zzenh zzhu = zzhu(zzhy);
                            if (zzhu != null && !zzhu.zzi(zzbib)) {
                                obj = zzepk.zza(zzbip, zzbib, obj, zzeqaVar);
                                break;
                            }
                            zzeqg.zzb(t, zzhv & 1048575, zzbib);
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 13:
                            zzeqg.zzb(t, zzhv & 1048575, zzepcVar.zzbic());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 14:
                            zzeqg.zza((Object) t, zzhv & 1048575, zzepcVar.zzbid());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 15:
                            zzeqg.zzb(t, zzhv & 1048575, zzepcVar.zzbie());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 16:
                            zzeqg.zza((Object) t, zzhv & 1048575, zzepcVar.zzbif());
                            zzf((zzeor<T>) t, zzhy);
                            continue;
                        case 17:
                            if (zze((zzeor<T>) t, zzhy)) {
                                long j2 = zzhv & 1048575;
                                zzeqg.zza(t, j2, zzenc.zze(zzeqg.zzp(t, j2), zzepcVar.zzb(zzhs(zzhy), zzemnVar)));
                                break;
                            } else {
                                zzeqg.zza(t, zzhv & 1048575, zzepcVar.zzb(zzhs(zzhy), zzemnVar));
                                zzf((zzeor<T>) t, zzhy);
                                continue;
                            }
                        case 18:
                            zzepcVar.zzm(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 19:
                            zzepcVar.zzn(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 20:
                            zzepcVar.zzp(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 21:
                            zzepcVar.zzo(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 22:
                            zzepcVar.zzq(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 23:
                            zzepcVar.zzr(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 24:
                            zzepcVar.zzs(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 25:
                            zzepcVar.zzt(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 26:
                            if (zzhx(zzhv)) {
                                zzepcVar.zzu(this.zziwh.zza(t, zzhv & 1048575));
                                break;
                            } else {
                                zzepcVar.readStringList(this.zziwh.zza(t, zzhv & 1048575));
                                continue;
                            }
                        case 27:
                            zzepcVar.zza(this.zziwh.zza(t, zzhv & 1048575), zzhs(zzhy), zzemnVar);
                            continue;
                        case 28:
                            zzepcVar.zzv(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 29:
                            zzepcVar.zzw(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 30:
                            List<Integer> zza = this.zziwh.zza(t, zzhv & 1048575);
                            zzepcVar.zzx(zza);
                            obj = zzepk.zza(zzbip, zza, zzhu(zzhy), obj, zzeqaVar);
                            continue;
                        case 31:
                            zzepcVar.zzy(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 32:
                            zzepcVar.zzz(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 33:
                            zzepcVar.zzaa(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 34:
                            zzepcVar.zzab(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 35:
                            zzepcVar.zzm(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 36:
                            zzepcVar.zzn(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 37:
                            zzepcVar.zzp(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 38:
                            zzepcVar.zzo(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 39:
                            zzepcVar.zzq(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 40:
                            zzepcVar.zzr(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 41:
                            zzepcVar.zzs(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 42:
                            zzepcVar.zzt(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 43:
                            zzepcVar.zzw(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 44:
                            List<Integer> zza2 = this.zziwh.zza(t, zzhv & 1048575);
                            zzepcVar.zzx(zza2);
                            obj = zzepk.zza(zzbip, zza2, zzhu(zzhy), obj, zzeqaVar);
                            continue;
                        case 45:
                            zzepcVar.zzy(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 46:
                            zzepcVar.zzz(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 47:
                            zzepcVar.zzaa(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 48:
                            zzepcVar.zzab(this.zziwh.zza(t, zzhv & 1048575));
                            continue;
                        case 49:
                            zzepcVar.zzb(this.zziwh.zza(t, zzhv & 1048575), zzhs(zzhy), zzemnVar);
                            continue;
                        case 50:
                            Object zzht = zzht(zzhy);
                            long zzhv2 = zzhv(zzhy) & 1048575;
                            Object zzp = zzeqg.zzp(t, zzhv2);
                            if (zzp == null) {
                                zzp = this.zziwk.zzar(zzht);
                                zzeqg.zza(t, zzhv2, zzp);
                            } else if (this.zziwk.zzap(zzp)) {
                                Object zzar = this.zziwk.zzar(zzht);
                                this.zziwk.zzf(zzar, zzp);
                                zzeqg.zza(t, zzhv2, zzar);
                                zzp = zzar;
                            }
                            zzepcVar.zza(this.zziwk.zzan(zzp), this.zziwk.zzas(zzht), zzemnVar);
                            continue;
                        case 51:
                            zzeqg.zza(t, zzhv & 1048575, Double.valueOf(zzepcVar.readDouble()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 52:
                            zzeqg.zza(t, zzhv & 1048575, Float.valueOf(zzepcVar.readFloat()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 53:
                            zzeqg.zza(t, zzhv & 1048575, Long.valueOf(zzepcVar.zzbht()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 54:
                            zzeqg.zza(t, zzhv & 1048575, Long.valueOf(zzepcVar.zzbhs()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 55:
                            zzeqg.zza(t, zzhv & 1048575, Integer.valueOf(zzepcVar.zzbhu()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 56:
                            zzeqg.zza(t, zzhv & 1048575, Long.valueOf(zzepcVar.zzbhv()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 57:
                            zzeqg.zza(t, zzhv & 1048575, Integer.valueOf(zzepcVar.zzbhw()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 58:
                            zzeqg.zza(t, zzhv & 1048575, Boolean.valueOf(zzepcVar.zzbhx()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 59:
                            zza(t, zzhv, zzepcVar);
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 60:
                            if (zza((zzeor<T>) t, zzbip, zzhy)) {
                                long j3 = zzhv & 1048575;
                                zzeqg.zza(t, j3, zzenc.zze(zzeqg.zzp(t, j3), zzepcVar.zza(zzhs(zzhy), zzemnVar)));
                            } else {
                                zzeqg.zza(t, zzhv & 1048575, zzepcVar.zza(zzhs(zzhy), zzemnVar));
                                zzf((zzeor<T>) t, zzhy);
                            }
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 61:
                            zzeqg.zza(t, zzhv & 1048575, zzepcVar.zzbhz());
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 62:
                            zzeqg.zza(t, zzhv & 1048575, Integer.valueOf(zzepcVar.zzbia()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 63:
                            int zzbib2 = zzepcVar.zzbib();
                            zzenh zzhu2 = zzhu(zzhy);
                            if (zzhu2 != null && !zzhu2.zzi(zzbib2)) {
                                obj = zzepk.zza(zzbip, zzbib2, obj, zzeqaVar);
                                break;
                            }
                            zzeqg.zza(t, zzhv & 1048575, Integer.valueOf(zzbib2));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 64:
                            zzeqg.zza(t, zzhv & 1048575, Integer.valueOf(zzepcVar.zzbic()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 65:
                            zzeqg.zza(t, zzhv & 1048575, Long.valueOf(zzepcVar.zzbid()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 66:
                            zzeqg.zza(t, zzhv & 1048575, Integer.valueOf(zzepcVar.zzbie()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 67:
                            zzeqg.zza(t, zzhv & 1048575, Long.valueOf(zzepcVar.zzbif()));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        case 68:
                            zzeqg.zza(t, zzhv & 1048575, zzepcVar.zzb(zzhs(zzhy), zzemnVar));
                            zzb((zzeor<T>) t, zzbip, zzhy);
                            continue;
                        default:
                            if (obj == null) {
                                try {
                                    obj = zzeqaVar.zzblx();
                                } catch (zzenm unused) {
                                    zzeqaVar.zza(zzepcVar);
                                    if (obj == null) {
                                        obj = zzeqaVar.zzaz(t);
                                    }
                                    if (!zzeqaVar.zza((zzeqa) obj, zzepcVar)) {
                                        for (int i = this.zziwe; i < this.zziwf; i++) {
                                            obj = zza((Object) t, this.zziwd[i], (int) obj, (zzeqa<UT, int>) zzeqaVar);
                                        }
                                        if (obj != null) {
                                            zzeqaVar.zzj(t, obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!zzeqaVar.zza((zzeqa) obj, zzepcVar)) {
                                for (int i2 = this.zziwe; i2 < this.zziwf; i2++) {
                                    obj = zza((Object) t, this.zziwd[i2], (int) obj, (zzeqa<UT, int>) zzeqaVar);
                                }
                                if (obj != null) {
                                    zzeqaVar.zzj(t, obj);
                                    return;
                                }
                                return;
                            }
                            continue;
                    }
                } else if (zzbip == Integer.MAX_VALUE) {
                    for (int i3 = this.zziwe; i3 < this.zziwf; i3++) {
                        obj = zza((Object) t, this.zziwd[i3], (int) obj, (zzeqa<UT, int>) zzeqaVar);
                    }
                    if (obj != null) {
                        zzeqaVar.zzj(t, obj);
                        return;
                    }
                    return;
                } else {
                    Object zza3 = !this.zzivz ? null : zzempVar.zza(zzemnVar, this.zzivy, zzbip);
                    if (zza3 != null) {
                        if (zzemtVar == null) {
                            zzemtVar = zzempVar.zzaj(t);
                        }
                        zzemt<?> zzemtVar2 = zzemtVar;
                        obj = zzempVar.zza(zzepcVar, zza3, zzemnVar, zzemtVar2, obj, zzeqaVar);
                        zzemtVar = zzemtVar2;
                    } else {
                        zzeqaVar.zza(zzepcVar);
                        if (obj == null) {
                            obj = zzeqaVar.zzaz(t);
                        }
                        if (!zzeqaVar.zza((zzeqa) obj, zzepcVar)) {
                            for (int i4 = this.zziwe; i4 < this.zziwf; i4++) {
                                obj = zza((Object) t, this.zziwd[i4], (int) obj, (zzeqa<UT, int>) zzeqaVar);
                            }
                            if (obj != null) {
                                zzeqaVar.zzj(t, obj);
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.zziwe; i5 < this.zziwf; i5++) {
                    obj = zza((Object) t, this.zziwd[i5], (int) obj, (zzeqa<UT, int>) zzeqaVar);
                }
                if (obj != null) {
                    zzeqaVar.zzj(t, obj);
                }
                throw th;
            }
        }
    }

    private static zzeqd zzav(Object obj) {
        zzena zzenaVar = (zzena) obj;
        zzeqd zzeqdVar = zzenaVar.zzitn;
        if (zzeqdVar == zzeqd.zzbly()) {
            zzeqd zzblz = zzeqd.zzblz();
            zzenaVar.zzitn = zzblz;
            return zzblz;
        }
        return zzeqdVar;
    }

    private static int zza(byte[] bArr, int i, int i2, zzeqr zzeqrVar, Class<?> cls, zzell zzellVar) {
        switch (zzeoq.zziqb[zzeqrVar.ordinal()]) {
            case 1:
                int zzb = zzelm.zzb(bArr, i, zzellVar);
                zzellVar.zziox = Boolean.valueOf(zzellVar.zziow != 0);
                return zzb;
            case 2:
                return zzelm.zze(bArr, i, zzellVar);
            case 3:
                zzellVar.zziox = Double.valueOf(zzelm.zzj(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzellVar.zziox = Integer.valueOf(zzelm.zzh(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzellVar.zziox = Long.valueOf(zzelm.zzi(bArr, i));
                return i + 8;
            case 8:
                zzellVar.zziox = Float.valueOf(zzelm.zzk(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzelm.zza(bArr, i, zzellVar);
                zzellVar.zziox = Integer.valueOf(zzellVar.zziov);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzelm.zzb(bArr, i, zzellVar);
                zzellVar.zziox = Long.valueOf(zzellVar.zziow);
                return zzb2;
            case 14:
                return zzelm.zza(zzepb.zzble().zzj(cls), bArr, i, i2, zzellVar);
            case 15:
                int zza2 = zzelm.zza(bArr, i, zzellVar);
                zzellVar.zziox = Integer.valueOf(zzemb.zzgp(zzellVar.zziov));
                return zza2;
            case 16:
                int zzb3 = zzelm.zzb(bArr, i, zzellVar);
                zzellVar.zziox = Long.valueOf(zzemb.zzfh(zzellVar.zziow));
                return zzb3;
            case 17:
                return zzelm.zzd(bArr, i, zzellVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01eb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0236 -> B:116:0x0237). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x016e -> B:67:0x016f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x01e8 -> B:96:0x01e9). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzell zzellVar) {
        int zza;
        int i8;
        int i9 = i;
        zzenk zzenkVar = (zzenk) zzicl.getObject(t, j2);
        if (!zzenkVar.zzbhd()) {
            int size = zzenkVar.size();
            zzenkVar = zzenkVar.zzgg(size == 0 ? 10 : size << 1);
            zzicl.putObject(t, j2, zzenkVar);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzeml zzemlVar = (zzeml) zzenkVar;
                    int zza2 = zzelm.zza(bArr, i9, zzellVar);
                    int i10 = zzellVar.zziov + zza2;
                    while (zza2 < i10) {
                        zzemlVar.zze(zzelm.zzj(bArr, zza2));
                        zza2 += 8;
                    }
                    if (zza2 == i10) {
                        return zza2;
                    }
                    throw zzenn.zzbjz();
                }
                if (i5 == 1) {
                    zzeml zzemlVar2 = (zzeml) zzenkVar;
                    zzemlVar2.zze(zzelm.zzj(bArr, i));
                    while (true) {
                        int i11 = i9 + 8;
                        if (i11 >= i2) {
                            return i11;
                        }
                        i9 = zzelm.zza(bArr, i11, zzellVar);
                        if (i3 != zzellVar.zziov) {
                            return i11;
                        }
                        zzemlVar2.zze(zzelm.zzj(bArr, i9));
                    }
                }
                return i9;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzemz zzemzVar = (zzemz) zzenkVar;
                    int zza3 = zzelm.zza(bArr, i9, zzellVar);
                    int i12 = zzellVar.zziov + zza3;
                    while (zza3 < i12) {
                        zzemzVar.zzh(zzelm.zzk(bArr, zza3));
                        zza3 += 4;
                    }
                    if (zza3 == i12) {
                        return zza3;
                    }
                    throw zzenn.zzbjz();
                }
                if (i5 == 5) {
                    zzemz zzemzVar2 = (zzemz) zzenkVar;
                    zzemzVar2.zzh(zzelm.zzk(bArr, i));
                    while (true) {
                        int i13 = i9 + 4;
                        if (i13 >= i2) {
                            return i13;
                        }
                        i9 = zzelm.zza(bArr, i13, zzellVar);
                        if (i3 != zzellVar.zziov) {
                            return i13;
                        }
                        zzemzVar2.zzh(zzelm.zzk(bArr, i9));
                    }
                }
                return i9;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzeob zzeobVar = (zzeob) zzenkVar;
                    int zza4 = zzelm.zza(bArr, i9, zzellVar);
                    int i14 = zzellVar.zziov + zza4;
                    while (zza4 < i14) {
                        zza4 = zzelm.zzb(bArr, zza4, zzellVar);
                        zzeobVar.zzfs(zzellVar.zziow);
                    }
                    if (zza4 == i14) {
                        return zza4;
                    }
                    throw zzenn.zzbjz();
                }
                if (i5 == 0) {
                    zzeob zzeobVar2 = (zzeob) zzenkVar;
                    int zzb = zzelm.zzb(bArr, i9, zzellVar);
                    zzeobVar2.zzfs(zzellVar.zziow);
                    while (zzb < i2) {
                        int zza5 = zzelm.zza(bArr, zzb, zzellVar);
                        if (i3 != zzellVar.zziov) {
                            return zzb;
                        }
                        zzb = zzelm.zzb(bArr, zza5, zzellVar);
                        zzeobVar2.zzfs(zzellVar.zziow);
                    }
                    return zzb;
                }
                return i9;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzelm.zza(bArr, i9, zzenkVar, zzellVar);
                }
                if (i5 == 0) {
                    return zzelm.zza(i3, bArr, i, i2, zzenkVar, zzellVar);
                }
                return i9;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzeob zzeobVar3 = (zzeob) zzenkVar;
                    int zza6 = zzelm.zza(bArr, i9, zzellVar);
                    int i15 = zzellVar.zziov + zza6;
                    while (zza6 < i15) {
                        zzeobVar3.zzfs(zzelm.zzi(bArr, zza6));
                        zza6 += 8;
                    }
                    if (zza6 == i15) {
                        return zza6;
                    }
                    throw zzenn.zzbjz();
                }
                if (i5 == 1) {
                    zzeob zzeobVar4 = (zzeob) zzenkVar;
                    zzeobVar4.zzfs(zzelm.zzi(bArr, i));
                    while (true) {
                        int i16 = i9 + 8;
                        if (i16 >= i2) {
                            return i16;
                        }
                        i9 = zzelm.zza(bArr, i16, zzellVar);
                        if (i3 != zzellVar.zziov) {
                            return i16;
                        }
                        zzeobVar4.zzfs(zzelm.zzi(bArr, i9));
                    }
                }
                return i9;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzend zzendVar = (zzend) zzenkVar;
                    int zza7 = zzelm.zza(bArr, i9, zzellVar);
                    int i17 = zzellVar.zziov + zza7;
                    while (zza7 < i17) {
                        zzendVar.zzhp(zzelm.zzh(bArr, zza7));
                        zza7 += 4;
                    }
                    if (zza7 == i17) {
                        return zza7;
                    }
                    throw zzenn.zzbjz();
                }
                if (i5 == 5) {
                    zzend zzendVar2 = (zzend) zzenkVar;
                    zzendVar2.zzhp(zzelm.zzh(bArr, i));
                    while (true) {
                        int i18 = i9 + 4;
                        if (i18 >= i2) {
                            return i18;
                        }
                        i9 = zzelm.zza(bArr, i18, zzellVar);
                        if (i3 != zzellVar.zziov) {
                            return i18;
                        }
                        zzendVar2.zzhp(zzelm.zzh(bArr, i9));
                    }
                }
                return i9;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzelo zzeloVar = (zzelo) zzenkVar;
                    zza = zzelm.zza(bArr, i9, zzellVar);
                    int i19 = zzellVar.zziov + zza;
                    while (zza < i19) {
                        zza = zzelm.zzb(bArr, zza, zzellVar);
                        zzeloVar.addBoolean(zzellVar.zziow != 0);
                    }
                    if (zza != i19) {
                        throw zzenn.zzbjz();
                    }
                    return zza;
                }
                if (i5 == 0) {
                    zzelo zzeloVar2 = (zzelo) zzenkVar;
                    i9 = zzelm.zzb(bArr, i9, zzellVar);
                    zzeloVar2.addBoolean(zzellVar.zziow != 0);
                    while (i9 < i2) {
                        int zza8 = zzelm.zza(bArr, i9, zzellVar);
                        if (i3 == zzellVar.zziov) {
                            i9 = zzelm.zzb(bArr, zza8, zzellVar);
                            zzeloVar2.addBoolean(zzellVar.zziow != 0);
                        }
                    }
                }
                return i9;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        i9 = zzelm.zza(bArr, i9, zzellVar);
                        int i20 = zzellVar.zziov;
                        if (i20 < 0) {
                            throw zzenn.zzbka();
                        }
                        if (i20 == 0) {
                            zzenkVar.add("");
                            while (i9 < i2) {
                                int zza9 = zzelm.zza(bArr, i9, zzellVar);
                                if (i3 == zzellVar.zziov) {
                                    i9 = zzelm.zza(bArr, zza9, zzellVar);
                                    i20 = zzellVar.zziov;
                                    if (i20 < 0) {
                                        throw zzenn.zzbka();
                                    }
                                    if (i20 == 0) {
                                        zzenkVar.add("");
                                    } else {
                                        zzenkVar.add(new String(bArr, i9, i20, zzenc.UTF_8));
                                        i9 += i20;
                                        while (i9 < i2) {
                                        }
                                    }
                                }
                            }
                        } else {
                            zzenkVar.add(new String(bArr, i9, i20, zzenc.UTF_8));
                            i9 += i20;
                            while (i9 < i2) {
                            }
                        }
                    } else {
                        i9 = zzelm.zza(bArr, i9, zzellVar);
                        int i21 = zzellVar.zziov;
                        if (i21 < 0) {
                            throw zzenn.zzbka();
                        }
                        if (i21 == 0) {
                            zzenkVar.add("");
                            while (i9 < i2) {
                                int zza10 = zzelm.zza(bArr, i9, zzellVar);
                                if (i3 == zzellVar.zziov) {
                                    i9 = zzelm.zza(bArr, zza10, zzellVar);
                                    int i22 = zzellVar.zziov;
                                    if (i22 < 0) {
                                        throw zzenn.zzbka();
                                    }
                                    if (i22 == 0) {
                                        zzenkVar.add("");
                                    } else {
                                        i8 = i9 + i22;
                                        if (!zzeqj.zzm(bArr, i9, i8)) {
                                            throw zzenn.zzbkh();
                                        }
                                        zzenkVar.add(new String(bArr, i9, i22, zzenc.UTF_8));
                                        i9 = i8;
                                        while (i9 < i2) {
                                        }
                                    }
                                }
                            }
                        } else {
                            i8 = i9 + i21;
                            if (!zzeqj.zzm(bArr, i9, i8)) {
                                throw zzenn.zzbkh();
                            }
                            zzenkVar.add(new String(bArr, i9, i21, zzenc.UTF_8));
                            i9 = i8;
                            while (i9 < i2) {
                            }
                        }
                    }
                }
                return i9;
            case 27:
                if (i5 == 2) {
                    return zzelm.zza(zzhs(i6), i3, bArr, i, i2, zzenkVar, zzellVar);
                }
                return i9;
            case 28:
                if (i5 == 2) {
                    int zza11 = zzelm.zza(bArr, i9, zzellVar);
                    int i23 = zzellVar.zziov;
                    if (i23 < 0) {
                        throw zzenn.zzbka();
                    }
                    if (i23 <= bArr.length - zza11) {
                        if (i23 == 0) {
                            zzenkVar.add(zzelq.zzipc);
                            while (zza11 < i2) {
                                int zza12 = zzelm.zza(bArr, zza11, zzellVar);
                                if (i3 != zzellVar.zziov) {
                                    return zza11;
                                }
                                zza11 = zzelm.zza(bArr, zza12, zzellVar);
                                i23 = zzellVar.zziov;
                                if (i23 < 0) {
                                    throw zzenn.zzbka();
                                }
                                if (i23 > bArr.length - zza11) {
                                    throw zzenn.zzbjz();
                                }
                                if (i23 == 0) {
                                    zzenkVar.add(zzelq.zzipc);
                                } else {
                                    zzenkVar.add(zzelq.zzi(bArr, zza11, i23));
                                    zza11 += i23;
                                    while (zza11 < i2) {
                                    }
                                }
                            }
                            return zza11;
                        }
                        zzenkVar.add(zzelq.zzi(bArr, zza11, i23));
                        zza11 += i23;
                        while (zza11 < i2) {
                        }
                        return zza11;
                    }
                    throw zzenn.zzbjz();
                }
                return i9;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        zza = zzelm.zza(i3, bArr, i, i2, zzenkVar, zzellVar);
                    }
                    return i9;
                }
                zza = zzelm.zza(bArr, i9, zzenkVar, zzellVar);
                zzena zzenaVar = (zzena) t;
                zzeqd zzeqdVar = zzenaVar.zzitn;
                if (zzeqdVar == zzeqd.zzbly()) {
                    zzeqdVar = null;
                }
                zzeqd zzeqdVar2 = (zzeqd) zzepk.zza(i4, zzenkVar, zzhu(i6), zzeqdVar, this.zziwi);
                if (zzeqdVar2 != null) {
                    zzenaVar.zzitn = zzeqdVar2;
                }
                return zza;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzend zzendVar3 = (zzend) zzenkVar;
                    int zza13 = zzelm.zza(bArr, i9, zzellVar);
                    int i24 = zzellVar.zziov + zza13;
                    while (zza13 < i24) {
                        zza13 = zzelm.zza(bArr, zza13, zzellVar);
                        zzendVar3.zzhp(zzemb.zzgp(zzellVar.zziov));
                    }
                    if (zza13 == i24) {
                        return zza13;
                    }
                    throw zzenn.zzbjz();
                }
                if (i5 == 0) {
                    zzend zzendVar4 = (zzend) zzenkVar;
                    int zza14 = zzelm.zza(bArr, i9, zzellVar);
                    zzendVar4.zzhp(zzemb.zzgp(zzellVar.zziov));
                    while (zza14 < i2) {
                        int zza15 = zzelm.zza(bArr, zza14, zzellVar);
                        if (i3 != zzellVar.zziov) {
                            return zza14;
                        }
                        zza14 = zzelm.zza(bArr, zza15, zzellVar);
                        zzendVar4.zzhp(zzemb.zzgp(zzellVar.zziov));
                    }
                    return zza14;
                }
                return i9;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzeob zzeobVar5 = (zzeob) zzenkVar;
                    int zza16 = zzelm.zza(bArr, i9, zzellVar);
                    int i25 = zzellVar.zziov + zza16;
                    while (zza16 < i25) {
                        zza16 = zzelm.zzb(bArr, zza16, zzellVar);
                        zzeobVar5.zzfs(zzemb.zzfh(zzellVar.zziow));
                    }
                    if (zza16 == i25) {
                        return zza16;
                    }
                    throw zzenn.zzbjz();
                }
                if (i5 == 0) {
                    zzeob zzeobVar6 = (zzeob) zzenkVar;
                    int zzb2 = zzelm.zzb(bArr, i9, zzellVar);
                    zzeobVar6.zzfs(zzemb.zzfh(zzellVar.zziow));
                    while (zzb2 < i2) {
                        int zza17 = zzelm.zza(bArr, zzb2, zzellVar);
                        if (i3 != zzellVar.zziov) {
                            return zzb2;
                        }
                        zzb2 = zzelm.zzb(bArr, zza17, zzellVar);
                        zzeobVar6.zzfs(zzemb.zzfh(zzellVar.zziow));
                    }
                    return zzb2;
                }
                return i9;
            case 49:
                if (i5 == 3) {
                    zzepi zzhs = zzhs(i6);
                    int i26 = (i3 & (-8)) | 4;
                    i9 = zzelm.zza(zzhs, bArr, i, i2, i26, zzellVar);
                    zzenkVar.add(zzellVar.zziox);
                    while (i9 < i2) {
                        int zza18 = zzelm.zza(bArr, i9, zzellVar);
                        if (i3 == zzellVar.zziov) {
                            i9 = zzelm.zza(zzhs, bArr, zza18, i2, i26, zzellVar);
                            zzenkVar.add(zzellVar.zziox);
                        }
                    }
                }
                return i9;
            default:
                return i9;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzell zzellVar) {
        Unsafe unsafe = zzicl;
        Object zzht = zzht(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zziwk.zzap(object)) {
            Object zzar = this.zziwk.zzar(zzht);
            this.zziwk.zzf(zzar, object);
            unsafe.putObject(t, j, zzar);
            object = zzar;
        }
        zzeoe<?, ?> zzas = this.zziwk.zzas(zzht);
        Map<?, ?> zzan = this.zziwk.zzan(object);
        int zza = zzelm.zza(bArr, i, zzellVar);
        int i4 = zzellVar.zziov;
        if (i4 < 0 || i4 > i2 - zza) {
            throw zzenn.zzbjz();
        }
        int i5 = i4 + zza;
        Object obj = (K) zzas.zzivo;
        Object obj2 = (V) zzas.zzcmg;
        while (zza < i5) {
            int i6 = zza + 1;
            int i7 = bArr[zza];
            if (i7 < 0) {
                i6 = zzelm.zza(i7, bArr, i6, zzellVar);
                i7 = zzellVar.zziov;
            }
            int i8 = i6;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 == 1) {
                if (i10 == zzas.zzivn.zzbmi()) {
                    zza = zza(bArr, i8, i2, zzas.zzivn, (Class<?>) null, zzellVar);
                    obj = (K) zzellVar.zziox;
                } else {
                    zza = zzelm.zza(i7, bArr, i8, i2, zzellVar);
                }
            } else {
                if (i9 == 2 && i10 == zzas.zzivp.zzbmi()) {
                    zza = zza(bArr, i8, i2, zzas.zzivp, zzas.zzcmg.getClass(), zzellVar);
                    obj2 = zzellVar.zziox;
                }
                zza = zzelm.zza(i7, bArr, i8, i2, zzellVar);
            }
        }
        if (zza != i5) {
            throw zzenn.zzbkg();
        }
        zzan.put(obj, obj2);
        return i5;
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzell zzellVar) {
        int zzb;
        Unsafe unsafe = zzicl;
        long j2 = this.zzivu[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzelm.zzj(bArr, i)));
                    zzb = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzelm.zzk(bArr, i)));
                    zzb = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    zzb = zzelm.zzb(bArr, i, zzellVar);
                    unsafe.putObject(t, j, Long.valueOf(zzellVar.zziow));
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    zzb = zzelm.zza(bArr, i, zzellVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzellVar.zziov));
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzelm.zzi(bArr, i)));
                    zzb = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzelm.zzh(bArr, i)));
                    zzb = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    zzb = zzelm.zzb(bArr, i, zzellVar);
                    unsafe.putObject(t, j, Boolean.valueOf(zzellVar.zziow != 0));
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza = zzelm.zza(bArr, i, zzellVar);
                    int i9 = zzellVar.zziov;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) != 0 && !zzeqj.zzm(bArr, zza, zza + i9)) {
                        throw zzenn.zzbkh();
                    } else {
                        unsafe.putObject(t, j, new String(bArr, zza, i9, zzenc.UTF_8));
                        zza += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza2 = zzelm.zza(zzhs(i8), bArr, i, i2, zzellVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzellVar.zziox);
                    } else {
                        unsafe.putObject(t, j, zzenc.zze(object, zzellVar.zziox));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    zzb = zzelm.zze(bArr, i, zzellVar);
                    unsafe.putObject(t, j, zzellVar.zziox);
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza3 = zzelm.zza(bArr, i, zzellVar);
                    int i10 = zzellVar.zziov;
                    zzenh zzhu = zzhu(i8);
                    if (zzhu == null || zzhu.zzi(i10)) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        zzb = zza3;
                        unsafe.putInt(t, j2, i4);
                        return zzb;
                    }
                    zzav(t).zzd(i3, Long.valueOf(i10));
                    return zza3;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    zzb = zzelm.zza(bArr, i, zzellVar);
                    unsafe.putObject(t, j, Integer.valueOf(zzemb.zzgp(zzellVar.zziov)));
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    zzb = zzelm.zzb(bArr, i, zzellVar);
                    unsafe.putObject(t, j, Long.valueOf(zzemb.zzfh(zzellVar.zziow)));
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    zzb = zzelm.zza(zzhs(i8), bArr, i, i2, (i3 & (-8)) | 4, zzellVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzellVar.zziox);
                    } else {
                        unsafe.putObject(t, j, zzenc.zze(object2, zzellVar.zziox));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zzb;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzepi zzhs(int i) {
        int i2 = (i / 3) << 1;
        zzepi zzepiVar = (zzepi) this.zzivv[i2];
        if (zzepiVar != null) {
            return zzepiVar;
        }
        zzepi<T> zzj = zzepb.zzble().zzj((Class) this.zzivv[i2 + 1]);
        this.zzivv[i2] = zzj;
        return zzj;
    }

    private final Object zzht(int i) {
        return this.zzivv[(i / 3) << 1];
    }

    private final zzenh zzhu(int i) {
        return (zzenh) this.zzivv[((i / 3) << 1) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04da, code lost:
        if (r6 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x04dc, code lost:
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04e2, code lost:
        r1 = null;
        r2 = r9.zziwe;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x04e7, code lost:
        if (r2 >= r9.zziwf) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x04e9, code lost:
        r1 = (com.google.android.gms.internal.ads.zzeqd) r9.zza((java.lang.Object) r12, r9.zziwd[r2], (int) r1, (com.google.android.gms.internal.ads.zzeqa<UT, int>) r9.zziwi);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04f8, code lost:
        if (r1 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04fa, code lost:
        r9.zziwi.zzj(r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04ff, code lost:
        if (r7 != 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0503, code lost:
        if (r0 != r31) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x050a, code lost:
        throw com.google.android.gms.internal.ads.zzenn.zzbkg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x050d, code lost:
        if (r0 > r31) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x050f, code lost:
        if (r3 != r7) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0511, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0517, code lost:
        throw com.google.android.gms.internal.ads.zzenn.zzbkg();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzell zzellVar) {
        Unsafe unsafe;
        int i4;
        T t2;
        zzeor<T> zzeorVar;
        int i5;
        byte b2;
        int zzhy;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        T t3;
        int i11;
        zzell zzellVar2;
        int i12;
        int i13;
        int i14;
        int i15;
        zzell zzellVar3;
        zzell zzellVar4;
        int zzb;
        int i16;
        zzell zzellVar5;
        int i17;
        int i18;
        int i19;
        zzeor<T> zzeorVar2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i20 = i2;
        int i21 = i3;
        zzell zzellVar6 = zzellVar;
        Unsafe unsafe2 = zzicl;
        int i22 = i;
        int i23 = -1;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 1048575;
        while (true) {
            if (i22 < i20) {
                int i28 = i22 + 1;
                byte b3 = bArr2[i22];
                if (b3 < 0) {
                    int zza = zzelm.zza(b3, bArr2, i28, zzellVar6);
                    b2 = zzellVar6.zziov;
                    i28 = zza;
                } else {
                    b2 = b3;
                }
                int i29 = b2 >>> 3;
                int i30 = b2 & 7;
                if (i29 > i23) {
                    zzhy = zzeorVar2.zzaq(i29, i24 / 3);
                } else {
                    zzhy = zzeorVar2.zzhy(i29);
                }
                int i31 = zzhy;
                if (i31 == -1) {
                    i6 = i29;
                    i7 = i28;
                    i8 = b2;
                    i9 = i26;
                    unsafe = unsafe2;
                    i4 = i21;
                    i10 = 0;
                } else {
                    int[] iArr = zzeorVar2.zzivu;
                    int i32 = iArr[i31 + 1];
                    int i33 = (i32 & 267386880) >>> 20;
                    int i34 = b2;
                    long j = i32 & 1048575;
                    if (i33 <= 17) {
                        int i35 = iArr[i31 + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = i35 & 1048575;
                        if (i37 != i27) {
                            if (i27 != 1048575) {
                                unsafe2.putInt(t4, i27, i26);
                            }
                            i26 = unsafe2.getInt(t4, i37);
                            i12 = i37;
                        } else {
                            i12 = i27;
                        }
                        int i38 = i26;
                        switch (i33) {
                            case 0:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 1) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    zzeqg.zza(t4, j, zzelm.zzj(bArr2, i28));
                                    i22 = i28 + 8;
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 1:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 5) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    zzeqg.zza((Object) t4, j, zzelm.zzk(bArr2, i28));
                                    i22 = i28 + 4;
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 2:
                            case 3:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    zzb = zzelm.zzb(bArr2, i28, zzellVar4);
                                    unsafe2.putLong(t, j, zzellVar4.zziow);
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i22 = zzb;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 4:
                            case 11:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    i22 = zzelm.zza(bArr2, i28, zzellVar4);
                                    unsafe2.putInt(t4, j, zzellVar4.zziov);
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 5:
                            case 14:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 1) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    unsafe2.putLong(t, j, zzelm.zzi(bArr2, i28));
                                    i22 = i28 + 8;
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 6:
                            case 13:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                i16 = i2;
                                zzellVar5 = zzellVar;
                                if (i30 != 5) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    unsafe2.putInt(t4, j, zzelm.zzh(bArr2, i28));
                                    i22 = i28 + 4;
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzellVar6 = zzellVar5;
                                    i20 = i16;
                                    i24 = i14;
                                    i21 = i3;
                                    break;
                                }
                            case 7:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                i16 = i2;
                                zzellVar5 = zzellVar;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    int zzb2 = zzelm.zzb(bArr2, i28, zzellVar5);
                                    zzeqg.zza(t4, j, zzellVar5.zziow != 0);
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i22 = zzb2;
                                    i25 = i8;
                                    i23 = i13;
                                    zzellVar6 = zzellVar5;
                                    i20 = i16;
                                    i24 = i14;
                                    i21 = i3;
                                    break;
                                }
                            case 8:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                i16 = i2;
                                zzellVar5 = zzellVar;
                                if (i30 != 2) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    if ((i32 & 536870912) == 0) {
                                        i22 = zzelm.zzc(bArr2, i28, zzellVar5);
                                    } else {
                                        i22 = zzelm.zzd(bArr2, i28, zzellVar5);
                                    }
                                    unsafe2.putObject(t4, j, zzellVar5.zziox);
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzellVar6 = zzellVar5;
                                    i20 = i16;
                                    i24 = i14;
                                    i21 = i3;
                                    break;
                                }
                            case 9:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar5 = zzellVar;
                                if (i30 != 2) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    i16 = i2;
                                    i22 = zzelm.zza(zzeorVar2.zzhs(i14), bArr2, i28, i16, zzellVar5);
                                    if ((i38 & i36) == 0) {
                                        unsafe2.putObject(t4, j, zzellVar5.zziox);
                                    } else {
                                        unsafe2.putObject(t4, j, zzenc.zze(unsafe2.getObject(t4, j), zzellVar5.zziox));
                                    }
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzellVar6 = zzellVar5;
                                    i20 = i16;
                                    i24 = i14;
                                    i21 = i3;
                                    break;
                                }
                            case 10:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 2) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    i22 = zzelm.zze(bArr2, i28, zzellVar4);
                                    unsafe2.putObject(t4, j, zzellVar4.zziox);
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 12:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    i22 = zzelm.zza(bArr2, i28, zzellVar4);
                                    int i39 = zzellVar4.zziov;
                                    zzenh zzhu = zzeorVar2.zzhu(i14);
                                    if (zzhu == null || zzhu.zzi(i39)) {
                                        unsafe2.putInt(t4, j, i39);
                                        i26 = i38 | i36;
                                        i27 = i15;
                                        i25 = i8;
                                        i23 = i13;
                                        i24 = i14;
                                        zzellVar6 = zzellVar4;
                                        i20 = i2;
                                        i21 = i3;
                                        break;
                                    } else {
                                        zzav(t).zzd(i8, Long.valueOf(i39));
                                        i26 = i38;
                                        i25 = i8;
                                        i23 = i13;
                                        i24 = i14;
                                        zzellVar6 = zzellVar4;
                                        i27 = i15;
                                        i20 = i2;
                                        i21 = i3;
                                    }
                                }
                                break;
                            case 15:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                bArr2 = bArr;
                                zzellVar4 = zzellVar;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    i22 = zzelm.zza(bArr2, i28, zzellVar4);
                                    unsafe2.putInt(t4, j, zzemb.zzgp(zzellVar4.zziov));
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 16:
                                i13 = i29;
                                i14 = i31;
                                if (i30 != 0) {
                                    i15 = i12;
                                    i8 = i34;
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    bArr2 = bArr;
                                    zzb = zzelm.zzb(bArr2, i28, zzellVar);
                                    zzellVar4 = zzellVar;
                                    i15 = i12;
                                    i8 = i34;
                                    unsafe2.putLong(t, j, zzemb.zzfh(zzellVar.zziow));
                                    i26 = i38 | i36;
                                    i27 = i15;
                                    i22 = zzb;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzellVar6 = zzellVar4;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                            case 17:
                                if (i30 != 3) {
                                    i13 = i29;
                                    i14 = i31;
                                    i15 = i12;
                                    i8 = i34;
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i38;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    i22 = zzelm.zza(zzeorVar2.zzhs(i31), bArr, i28, i2, (i29 << 3) | 4, zzellVar);
                                    if ((i38 & i36) == 0) {
                                        zzellVar3 = zzellVar;
                                        unsafe2.putObject(t4, j, zzellVar3.zziox);
                                    } else {
                                        zzellVar3 = zzellVar;
                                        unsafe2.putObject(t4, j, zzenc.zze(unsafe2.getObject(t4, j), zzellVar3.zziox));
                                    }
                                    i26 = i38 | i36;
                                    bArr2 = bArr;
                                    i20 = i2;
                                    i25 = i34;
                                    i27 = i12;
                                    i23 = i29;
                                    i24 = i31;
                                    i21 = i3;
                                    zzellVar6 = zzellVar3;
                                    break;
                                }
                            default:
                                i13 = i29;
                                i14 = i31;
                                i15 = i12;
                                i8 = i34;
                                i4 = i3;
                                i7 = i28;
                                i9 = i38;
                                unsafe = unsafe2;
                                i10 = i14;
                                i27 = i15;
                                i6 = i13;
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        zzell zzellVar7 = zzellVar6;
                        if (i33 != 27) {
                            i10 = i31;
                            i9 = i26;
                            i17 = i27;
                            if (i33 <= 49) {
                                int i40 = i28;
                                i18 = i34;
                                i6 = i29;
                                unsafe = unsafe2;
                                i22 = zza((zzeor<T>) t, bArr, i28, i2, i34, i29, i30, i10, i32, i33, j, zzellVar);
                                if (i22 == i40) {
                                    i4 = i3;
                                    i7 = i22;
                                } else {
                                    zzeorVar2 = this;
                                    t4 = t;
                                    bArr2 = bArr;
                                    i23 = i6;
                                    i20 = i2;
                                    i21 = i3;
                                    zzellVar6 = zzellVar;
                                    i24 = i10;
                                    i25 = i18;
                                    i26 = i9;
                                    i27 = i17;
                                    unsafe2 = unsafe;
                                }
                            } else {
                                i19 = i28;
                                i18 = i34;
                                i6 = i29;
                                unsafe = unsafe2;
                                if (i33 != 50) {
                                    i22 = zza((zzeor<T>) t, bArr, i19, i2, i18, i6, i30, i32, i33, j, i10, zzellVar);
                                    if (i22 != i19) {
                                        zzeorVar2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i20 = i2;
                                        zzellVar6 = zzellVar;
                                        i25 = i18;
                                        i23 = i6;
                                        i24 = i10;
                                        i26 = i9;
                                        i27 = i17;
                                        unsafe2 = unsafe;
                                        i21 = i3;
                                    }
                                } else if (i30 == 2) {
                                    i22 = zza((zzeor<T>) t, bArr, i19, i2, i10, j, zzellVar);
                                    if (i22 != i19) {
                                        zzeorVar2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i23 = i6;
                                        i20 = i2;
                                        i21 = i3;
                                        zzellVar6 = zzellVar;
                                        i24 = i10;
                                        i25 = i18;
                                        i26 = i9;
                                        i27 = i17;
                                        unsafe2 = unsafe;
                                    }
                                } else {
                                    i4 = i3;
                                    i7 = i19;
                                }
                                i4 = i3;
                                i7 = i22;
                            }
                        } else if (i30 == 2) {
                            zzenk zzenkVar = (zzenk) unsafe2.getObject(t4, j);
                            if (!zzenkVar.zzbhd()) {
                                int size = zzenkVar.size();
                                zzenkVar = zzenkVar.zzgg(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j, zzenkVar);
                            }
                            i22 = zzelm.zza(zzeorVar2.zzhs(i31), i34, bArr, i28, i2, zzenkVar, zzellVar);
                            i21 = i3;
                            i25 = i34;
                            i23 = i29;
                            zzellVar6 = zzellVar7;
                            i24 = i31;
                            i26 = i26;
                            i27 = i27;
                            i20 = i2;
                        } else {
                            i10 = i31;
                            i9 = i26;
                            i17 = i27;
                            i19 = i28;
                            i18 = i34;
                            i6 = i29;
                            unsafe = unsafe2;
                            i4 = i3;
                            i7 = i19;
                        }
                        i8 = i18;
                        i27 = i17;
                    }
                }
                if (i8 != i4 || i4 == 0) {
                    if (this.zzivz) {
                        zzellVar2 = zzellVar;
                        if (zzellVar2.zzioy != zzemn.zzbiv()) {
                            int i41 = i6;
                            if (zzellVar2.zzioy.zza(this.zzivy, i41) == null) {
                                i22 = zzelm.zza(i8, bArr, i7, i2, zzav(t), zzellVar);
                                t4 = t;
                                bArr2 = bArr;
                                i20 = i2;
                                i25 = i8;
                                zzeorVar2 = this;
                                zzellVar6 = zzellVar2;
                                i23 = i41;
                                i24 = i10;
                                i26 = i9;
                                unsafe2 = unsafe;
                                i21 = i4;
                            } else {
                                zzena.zzd zzdVar = (zzena.zzd) t;
                                zzdVar.zzbjw();
                                zzemt<zzena.zzc> zzemtVar = zzdVar.zzitu;
                                throw new NoSuchMethodError();
                            }
                        } else {
                            t3 = t;
                            i11 = i6;
                        }
                    } else {
                        t3 = t;
                        i11 = i6;
                        zzellVar2 = zzellVar;
                    }
                    i22 = zzelm.zza(i8, bArr, i7, i2, zzav(t), zzellVar);
                    i20 = i2;
                    i25 = i8;
                    zzeorVar2 = this;
                    zzellVar6 = zzellVar2;
                    i23 = i11;
                    t4 = t3;
                    i24 = i10;
                    i26 = i9;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i21 = i4;
                } else {
                    i5 = 1048575;
                    zzeorVar = this;
                    t2 = t;
                    i22 = i7;
                    i25 = i8;
                    i26 = i9;
                }
            } else {
                unsafe = unsafe2;
                i4 = i21;
                t2 = t4;
                zzeorVar = zzeorVar2;
                i5 = 1048575;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02dc, code lost:
        if (r0 == r5) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02e0, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0323, code lost:
        if (r0 == r15) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0346, code lost:
        if (r0 == r15) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0348, code lost:
        r2 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzepi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zzell zzellVar) {
        byte b2;
        int i3;
        int zzhy;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Unsafe unsafe;
        int i9;
        int i10;
        Unsafe unsafe2;
        int i11;
        int i12;
        Unsafe unsafe3;
        Unsafe unsafe4;
        zzeor<T> zzeorVar = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i13 = i2;
        zzell zzellVar2 = zzellVar;
        if (zzeorVar.zziwb) {
            Unsafe unsafe5 = zzicl;
            int i14 = -1;
            int i15 = 1048575;
            int i16 = i;
            int i17 = -1;
            int i18 = 0;
            int i19 = 0;
            int i20 = 1048575;
            while (i16 < i13) {
                int i21 = i16 + 1;
                byte b3 = bArr2[i16];
                if (b3 < 0) {
                    i3 = zzelm.zza(b3, bArr2, i21, zzellVar2);
                    b2 = zzellVar2.zziov;
                } else {
                    b2 = b3;
                    i3 = i21;
                }
                int i22 = b2 >>> 3;
                int i23 = b2 & 7;
                if (i22 > i17) {
                    zzhy = zzeorVar.zzaq(i22, i18 / 3);
                } else {
                    zzhy = zzeorVar.zzhy(i22);
                }
                int i24 = zzhy;
                if (i24 == i14) {
                    i10 = i3;
                    i4 = i22;
                    unsafe = unsafe5;
                    i6 = 0;
                } else {
                    int[] iArr = zzeorVar.zzivu;
                    int i25 = iArr[i24 + 1];
                    int i26 = (i25 & 267386880) >>> 20;
                    Unsafe unsafe6 = unsafe5;
                    long j = i25 & i15;
                    if (i26 <= 17) {
                        int i27 = iArr[i24 + 2];
                        int i28 = 1 << (i27 >>> 20);
                        int i29 = i27 & 1048575;
                        if (i29 != i20) {
                            if (i20 != 1048575) {
                                long j2 = i20;
                                unsafe4 = unsafe6;
                                unsafe4.putInt(t2, j2, i19);
                            } else {
                                unsafe4 = unsafe6;
                            }
                            if (i29 != 1048575) {
                                i19 = unsafe4.getInt(t2, i29);
                            }
                            unsafe2 = unsafe4;
                            i20 = i29;
                        } else {
                            unsafe2 = unsafe6;
                        }
                        switch (i26) {
                            case 0:
                                i4 = i22;
                                i11 = i3;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 1) {
                                    zzeqg.zza(t2, j, zzelm.zzj(bArr2, i11));
                                    i16 = i11 + 8;
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 1:
                                i4 = i22;
                                i11 = i3;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 5) {
                                    zzeqg.zza((Object) t2, j, zzelm.zzk(bArr2, i11));
                                    i16 = i11 + 4;
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 2:
                            case 3:
                                i4 = i22;
                                i11 = i3;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 0) {
                                    int zzb = zzelm.zzb(bArr2, i11, zzellVar2);
                                    unsafe3.putLong(t, j, zzellVar2.zziow);
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    i16 = zzb;
                                    break;
                                }
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 4:
                            case 11:
                                i4 = i22;
                                i11 = i3;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 0) {
                                    i16 = zzelm.zza(bArr2, i11, zzellVar2);
                                    unsafe3.putInt(t2, j, zzellVar2.zziov);
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 5:
                            case 14:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 1) {
                                    unsafe3.putLong(t, j, zzelm.zzi(bArr2, i3));
                                    i16 = i3 + 8;
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 6:
                            case 13:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 5) {
                                    unsafe3.putInt(t2, j, zzelm.zzh(bArr2, i3));
                                    i16 = i3 + 4;
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 7:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 0) {
                                    i16 = zzelm.zzb(bArr2, i3, zzellVar2);
                                    zzeqg.zza(t2, j, zzellVar2.zziow != 0);
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 8:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 2) {
                                    if ((i25 & 536870912) == 0) {
                                        i16 = zzelm.zzc(bArr2, i3, zzellVar2);
                                    } else {
                                        i16 = zzelm.zzd(bArr2, i3, zzellVar2);
                                    }
                                    unsafe3.putObject(t2, j, zzellVar2.zziox);
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 9:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 2) {
                                    i16 = zzelm.zza(zzeorVar.zzhs(i12), bArr2, i3, i13, zzellVar2);
                                    Object object = unsafe3.getObject(t2, j);
                                    if (object == null) {
                                        unsafe3.putObject(t2, j, zzellVar2.zziox);
                                    } else {
                                        unsafe3.putObject(t2, j, zzenc.zze(object, zzellVar2.zziox));
                                    }
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 10:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 2) {
                                    i16 = zzelm.zze(bArr2, i3, zzellVar2);
                                    unsafe3.putObject(t2, j, zzellVar2.zziox);
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 12:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 0) {
                                    i16 = zzelm.zza(bArr2, i3, zzellVar2);
                                    unsafe3.putInt(t2, j, zzellVar2.zziov);
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 15:
                                i4 = i22;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                if (i23 == 0) {
                                    i16 = zzelm.zza(bArr2, i3, zzellVar2);
                                    unsafe3.putInt(t2, j, zzemb.zzgp(zzellVar2.zziov));
                                    i19 |= i28;
                                    unsafe5 = unsafe3;
                                    i18 = i12;
                                    break;
                                }
                                i11 = i3;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                            case 16:
                                if (i23 != 0) {
                                    i4 = i22;
                                    i5 = i20;
                                    unsafe3 = unsafe2;
                                    i11 = i3;
                                    i12 = i24;
                                    i10 = i11;
                                    unsafe = unsafe3;
                                    i6 = i12;
                                    i20 = i5;
                                    break;
                                } else {
                                    int zzb2 = zzelm.zzb(bArr2, i3, zzellVar2);
                                    i5 = i20;
                                    i4 = i22;
                                    unsafe2.putLong(t, j, zzemb.zzfh(zzellVar2.zziow));
                                    i19 |= i28;
                                    unsafe5 = unsafe2;
                                    i18 = i24;
                                    i16 = zzb2;
                                    break;
                                }
                            default:
                                i4 = i22;
                                i11 = i3;
                                i12 = i24;
                                i5 = i20;
                                unsafe3 = unsafe2;
                                i10 = i11;
                                unsafe = unsafe3;
                                i6 = i12;
                                i20 = i5;
                                break;
                        }
                    } else {
                        i4 = i22;
                        int i30 = i3;
                        i5 = i20;
                        if (i26 != 27) {
                            i6 = i24;
                            if (i26 <= 49) {
                                i8 = i19;
                                i9 = i5;
                                unsafe = unsafe6;
                                i16 = zza((zzeor<T>) t, bArr, i30, i2, b2, i4, i23, i6, i25, i26, j, zzellVar);
                            } else {
                                i7 = i30;
                                i8 = i19;
                                unsafe = unsafe6;
                                i9 = i5;
                                if (i26 != 50) {
                                    i16 = zza((zzeor<T>) t, bArr, i7, i2, b2, i4, i23, i25, i26, j, i6, zzellVar);
                                } else if (i23 == 2) {
                                    i16 = zza((zzeor<T>) t, bArr, i7, i2, i6, j, zzellVar);
                                }
                            }
                            unsafe5 = unsafe;
                            i15 = 1048575;
                            i14 = -1;
                        } else if (i23 == 2) {
                            zzenk zzenkVar = (zzenk) unsafe6.getObject(t2, j);
                            if (!zzenkVar.zzbhd()) {
                                int size = zzenkVar.size();
                                zzenkVar = zzenkVar.zzgg(size == 0 ? 10 : size << 1);
                                unsafe6.putObject(t2, j, zzenkVar);
                            }
                            i16 = zzelm.zza(zzeorVar.zzhs(i24), b2, bArr, i30, i2, zzenkVar, zzellVar);
                            unsafe5 = unsafe6;
                            i19 = i19;
                            i18 = i24;
                        } else {
                            i6 = i24;
                            i7 = i30;
                            i8 = i19;
                            unsafe = unsafe6;
                            i9 = i5;
                        }
                        i10 = i7;
                        i19 = i8;
                        i20 = i9;
                        i16 = zzelm.zza(b2, bArr, i10, i2, zzav(t), zzellVar);
                        zzeorVar = this;
                        t2 = t;
                        bArr2 = bArr;
                        i13 = i2;
                        zzellVar2 = zzellVar;
                        i18 = i6;
                        i17 = i4;
                        unsafe5 = unsafe;
                        i15 = 1048575;
                        i14 = -1;
                    }
                    i20 = i5;
                    i17 = i4;
                    i15 = 1048575;
                    i14 = -1;
                }
                i16 = zzelm.zza(b2, bArr, i10, i2, zzav(t), zzellVar);
                zzeorVar = this;
                t2 = t;
                bArr2 = bArr;
                i13 = i2;
                zzellVar2 = zzellVar;
                i18 = i6;
                i17 = i4;
                unsafe5 = unsafe;
                i15 = 1048575;
                i14 = -1;
            }
            int i31 = i19;
            Unsafe unsafe7 = unsafe5;
            if (i20 != 1048575) {
                unsafe7.putInt(t, i20, i31);
            }
            if (i16 != i2) {
                throw zzenn.zzbkg();
            }
            return;
        }
        zza((zzeor<T>) t, bArr, i, i2, 0, zzellVar);
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zzak(T t) {
        int i;
        int i2 = this.zziwe;
        while (true) {
            i = this.zziwf;
            if (i2 >= i) {
                break;
            }
            long zzhv = zzhv(this.zziwd[i2]) & 1048575;
            Object zzp = zzeqg.zzp(t, zzhv);
            if (zzp != null) {
                zzeqg.zza(t, zzhv, this.zziwk.zzaq(zzp));
            }
            i2++;
        }
        int length = this.zziwd.length;
        while (i < length) {
            this.zziwh.zzb(t, this.zziwd[i]);
            i++;
        }
        this.zziwi.zzak(t);
        if (this.zzivz) {
            this.zziwj.zzak(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzeqa<UT, UB> zzeqaVar) {
        zzenh zzhu;
        int i2 = this.zzivu[i];
        Object zzp = zzeqg.zzp(obj, zzhv(i) & 1048575);
        return (zzp == null || (zzhu = zzhu(i)) == null) ? ub : (UB) zza(i, i2, this.zziwk.zzan(zzp), zzhu, (zzenh) ub, (zzeqa<UT, zzenh>) zzeqaVar);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzenh zzenhVar, UB ub, zzeqa<UT, UB> zzeqaVar) {
        zzeoe<?, ?> zzas = this.zziwk.zzas(zzht(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzenhVar.zzi(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzeqaVar.zzblx();
                }
                zzely zzgj = zzelq.zzgj(zzeof.zza(zzas, next.getKey(), next.getValue()));
                try {
                    zzeof.zza(zzgj.zzbhq(), zzas, next.getKey(), next.getValue());
                    zzeqaVar.zza((zzeqa<UT, UB>) ub, i2, zzgj.zzbhp());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.ads.zzepi] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzepi] */
    @Override // com.google.android.gms.internal.ads.zzepi
    public final boolean zzaw(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zziwe) {
                return !this.zzivz || this.zziwj.zzai(t).isInitialized();
            }
            int i6 = this.zziwd[i5];
            int i7 = this.zzivu[i6];
            int zzhv = zzhv(i6);
            int i8 = this.zzivu[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzicl.getInt(t, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if (((268435456 & zzhv) != 0) && !zza((zzeor<T>) t, i6, i, i2, i10)) {
                return false;
            }
            int i11 = (267386880 & zzhv) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zza((zzeor<T>) t, i6, i, i2, i10) && !zza(t, zzhv, zzhs(i6))) {
                    return false;
                }
            } else {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza((zzeor<T>) t, i7, i6) && !zza(t, zzhv, zzhs(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzao = this.zziwk.zzao(zzeqg.zzp(t, zzhv & 1048575));
                            if (!zzao.isEmpty()) {
                                if (this.zziwk.zzas(zzht(i6)).zzivp.zzbmh() == zzequ.MESSAGE) {
                                    zzepi<T> zzepiVar = 0;
                                    Iterator<?> it = zzao.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzepiVar == null) {
                                            zzepiVar = zzepb.zzble().zzj(next.getClass());
                                        }
                                        boolean zzaw = zzepiVar.zzaw(next);
                                        zzepiVar = zzepiVar;
                                        if (!zzaw) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzeqg.zzp(t, zzhv & 1048575);
                if (!list.isEmpty()) {
                    ?? zzhs = zzhs(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zzhs.zzaw(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzepi zzepiVar) {
        return zzepiVar.zzaw(zzeqg.zzp(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzeqx zzeqxVar) {
        if (obj instanceof String) {
            zzeqxVar.zzi(i, (String) obj);
        } else {
            zzeqxVar.zza(i, (zzelq) obj);
        }
    }

    private final void zza(Object obj, int i, zzepc zzepcVar) {
        if (zzhx(i)) {
            zzeqg.zza(obj, i & 1048575, zzepcVar.zzbhy());
        } else if (this.zziwa) {
            zzeqg.zza(obj, i & 1048575, zzepcVar.readString());
        } else {
            zzeqg.zza(obj, i & 1048575, zzepcVar.zzbhz());
        }
    }

    private final int zzhv(int i) {
        return this.zzivu[i + 1];
    }

    private final int zzhw(int i) {
        return this.zzivu[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzeqg.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzeqg.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzeqg.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzeqg.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzeqg.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zze((zzeor<T>) t, i) == zze((zzeor<T>) t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zze((zzeor<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zze(T t, int i) {
        int zzhw = zzhw(i);
        long j = zzhw & 1048575;
        if (j != 1048575) {
            return (zzeqg.zzk(t, j) & (1 << (zzhw >>> 20))) != 0;
        }
        int zzhv = zzhv(i);
        long j2 = zzhv & 1048575;
        switch ((zzhv & 267386880) >>> 20) {
            case 0:
                return zzeqg.zzo(t, j2) != 0.0d;
            case 1:
                return zzeqg.zzn(t, j2) != 0.0f;
            case 2:
                return zzeqg.zzl(t, j2) != 0;
            case 3:
                return zzeqg.zzl(t, j2) != 0;
            case 4:
                return zzeqg.zzk(t, j2) != 0;
            case 5:
                return zzeqg.zzl(t, j2) != 0;
            case 6:
                return zzeqg.zzk(t, j2) != 0;
            case 7:
                return zzeqg.zzm(t, j2);
            case 8:
                Object zzp = zzeqg.zzp(t, j2);
                if (zzp instanceof String) {
                    return !((String) zzp).isEmpty();
                } else if (zzp instanceof zzelq) {
                    return !zzelq.zzipc.equals(zzp);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzeqg.zzp(t, j2) != null;
            case 10:
                return !zzelq.zzipc.equals(zzeqg.zzp(t, j2));
            case 11:
                return zzeqg.zzk(t, j2) != 0;
            case 12:
                return zzeqg.zzk(t, j2) != 0;
            case 13:
                return zzeqg.zzk(t, j2) != 0;
            case 14:
                return zzeqg.zzl(t, j2) != 0;
            case 15:
                return zzeqg.zzk(t, j2) != 0;
            case 16:
                return zzeqg.zzl(t, j2) != 0;
            case 17:
                return zzeqg.zzp(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzf(T t, int i) {
        int zzhw = zzhw(i);
        long j = 1048575 & zzhw;
        if (j == 1048575) {
            return;
        }
        zzeqg.zzb(t, j, (1 << (zzhw >>> 20)) | zzeqg.zzk(t, j));
    }

    private final boolean zza(T t, int i, int i2) {
        return zzeqg.zzk(t, (long) (zzhw(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzeqg.zzb(t, zzhw(i2) & 1048575, i);
    }

    private final int zzhy(int i) {
        if (i < this.zzivw || i > this.zzivx) {
            return -1;
        }
        return zzar(i, 0);
    }

    private final int zzaq(int i, int i2) {
        if (i < this.zzivw || i > this.zzivx) {
            return -1;
        }
        return zzar(i, i2);
    }

    private final int zzar(int i, int i2) {
        int length = (this.zzivu.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzivu[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
