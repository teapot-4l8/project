package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzmh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzkx {
    private static final int zzaww = zzpt.zzbh("vide");
    private static final int zzawx = zzpt.zzbh("soun");
    private static final int zzawy = zzpt.zzbh("text");
    private static final int zzawz = zzpt.zzbh("sbtl");
    private static final int zzaxa = zzpt.zzbh("subt");
    private static final int zzaxb = zzpt.zzbh("clcp");
    private static final int zzaxc = zzpt.zzbh("cenc");
    private static final int zzawi = zzpt.zzbh("meta");

    /* JADX WARN: Removed duplicated region for block: B:200:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0820 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzls zza(zzkv zzkvVar, zzky zzkyVar, long j, zzjo zzjoVar, boolean z) {
        int i;
        boolean z2;
        long j2;
        zzky zzkyVar2;
        long j3;
        int i2;
        int i3;
        int readInt;
        int i4;
        zzlc zzlcVar;
        zzkv zzat;
        zzls zzlsVar;
        Pair create;
        int i5;
        zzky zzas;
        int i6;
        int i7;
        zzld zzldVar;
        String str;
        Pair pair;
        int i8;
        int i9;
        zzpn zzpnVar;
        int i10;
        zzlc zzlcVar2;
        int i11;
        Object obj;
        byte[] bArr;
        List<byte[]> list;
        String str2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int position;
        int i17;
        String str3;
        zzlc zzlcVar3;
        Pair pair2;
        zzpn zzpnVar2;
        int i18;
        int i19;
        String str4;
        int i20;
        zzlc zzlcVar4;
        int position2;
        String str5;
        String str6;
        int i21;
        int i22;
        String str7;
        List list2;
        long j4;
        zzjo zzjoVar2 = zzjoVar;
        zzkv zzat2 = zzkvVar.zzat(zzkw.zzaul);
        zzpn zzpnVar3 = zzat2.zzas(zzkw.zzauz).zzaxd;
        zzpnVar3.zzbl(16);
        int readInt2 = zzpnVar3.readInt();
        if (readInt2 == zzawx) {
            i = 1;
        } else if (readInt2 == zzaww) {
            i = 2;
        } else if (readInt2 == zzawy || readInt2 == zzawz || readInt2 == zzaxa || readInt2 == zzaxb) {
            i = 3;
        } else {
            i = readInt2 == zzawi ? 4 : -1;
        }
        if (i == -1) {
            return null;
        }
        zzpn zzpnVar4 = zzkvVar.zzas(zzkw.zzauv).zzaxd;
        zzpnVar4.zzbl(8);
        int zzau = zzkw.zzau(zzpnVar4.readInt());
        zzpnVar4.zzbm(zzau == 0 ? 8 : 16);
        int readInt3 = zzpnVar4.readInt();
        zzpnVar4.zzbm(4);
        int position3 = zzpnVar4.getPosition();
        int i23 = zzau == 0 ? 4 : 8;
        int i24 = 0;
        while (true) {
            if (i24 >= i23) {
                z2 = true;
                break;
            } else if (zzpnVar4.data[position3 + i24] != -1) {
                z2 = false;
                break;
            } else {
                i24++;
            }
        }
        if (z2) {
            zzpnVar4.zzbm(i23);
        } else {
            long zzjb = zzau == 0 ? zzpnVar4.zzjb() : zzpnVar4.zzjf();
            if (zzjb != 0) {
                j2 = zzjb;
                zzpnVar4.zzbm(16);
                int readInt4 = zzpnVar4.readInt();
                int readInt5 = zzpnVar4.readInt();
                zzpnVar4.zzbm(4);
                int readInt6 = zzpnVar4.readInt();
                int readInt7 = zzpnVar4.readInt();
                zzld zzldVar2 = new zzld(readInt3, j2, (readInt4 != 0 && readInt5 == 65536 && readInt6 == -65536 && readInt7 == 0) ? 90 : (readInt4 != 0 && readInt5 == -65536 && readInt6 == 65536 && readInt7 == 0) ? 270 : (readInt4 != -65536 && readInt5 == 0 && readInt6 == 0 && readInt7 == -65536) ? 180 : 0);
                if (j != -9223372036854775807L) {
                    j4 = zzldVar2.zzdg;
                    j3 = j4;
                    zzkyVar2 = zzkyVar;
                } else {
                    zzkyVar2 = zzkyVar;
                    j3 = j;
                }
                zzpn zzpnVar5 = zzkyVar2.zzaxd;
                zzpnVar5.zzbl(8);
                zzpnVar5.zzbm(zzkw.zzau(zzpnVar5.readInt()) != 0 ? 8 : 16);
                long zzjb2 = zzpnVar5.zzjb();
                long zza = j3 != -9223372036854775807L ? -9223372036854775807L : zzpt.zza(j3, 1000000L, zzjb2);
                zzkv zzat3 = zzat2.zzat(zzkw.zzaum).zzat(zzkw.zzaun);
                zzpn zzpnVar6 = zzat2.zzas(zzkw.zzauy).zzaxd;
                zzpnVar6.zzbl(8);
                int zzau2 = zzkw.zzau(zzpnVar6.readInt());
                zzpnVar6.zzbm(zzau2 != 0 ? 8 : 16);
                long zzjb3 = zzpnVar6.zzjb();
                zzpnVar6.zzbm(zzau2 != 0 ? 4 : 8);
                int readUnsignedShort = zzpnVar6.readUnsignedShort();
                StringBuilder sb = new StringBuilder(3);
                sb.append((char) (((readUnsignedShort >> 10) & 31) + 96));
                sb.append((char) (((readUnsignedShort >> 5) & 31) + 96));
                sb.append((char) ((readUnsignedShort & 31) + 96));
                Pair create2 = Pair.create(Long.valueOf(zzjb3), sb.toString());
                zzpn zzpnVar7 = zzat3.zzas(zzkw.zzava).zzaxd;
                i2 = zzldVar2.id;
                i3 = zzldVar2.zzaht;
                String str8 = (String) create2.second;
                zzpnVar7.zzbl(12);
                readInt = zzpnVar7.readInt();
                zzlc zzlcVar5 = new zzlc(readInt);
                i4 = 0;
                while (i4 < readInt) {
                    int position4 = zzpnVar7.getPosition();
                    int readInt8 = zzpnVar7.readInt();
                    String str9 = "childAtomSize should be positive";
                    zzpg.checkArgument(readInt8 > 0, "childAtomSize should be positive");
                    int readInt9 = zzpnVar7.readInt();
                    if (readInt9 == zzkw.zzati || readInt9 == zzkw.zzatj || readInt9 == zzkw.zzavg || readInt9 == zzkw.zzavs || readInt9 == zzkw.zzatk || readInt9 == zzkw.zzatl || readInt9 == zzkw.zzatm || readInt9 == zzkw.zzawr || readInt9 == zzkw.zzaws) {
                        int i25 = i4;
                        zzlc zzlcVar6 = zzlcVar5;
                        i6 = readInt;
                        i7 = i;
                        String str10 = str8;
                        Pair pair3 = create2;
                        zzldVar = zzldVar2;
                        zzpn zzpnVar8 = zzpnVar7;
                        Object obj2 = "childAtomSize should be positive";
                        zzpnVar8.zzbl(position4 + 8 + 8);
                        zzpnVar8.zzbm(16);
                        int readUnsignedShort2 = zzpnVar8.readUnsignedShort();
                        int readUnsignedShort3 = zzpnVar8.readUnsignedShort();
                        zzpnVar8.zzbm(50);
                        int position5 = zzpnVar8.getPosition();
                        if (readInt9 == zzkw.zzavg) {
                            readInt9 = zza(zzpnVar8, position4, readInt8, zzlcVar6, i25);
                            zzpnVar8.zzbl(position5);
                        }
                        String str11 = null;
                        boolean z3 = false;
                        List<byte[]> list3 = null;
                        float f = 1.0f;
                        byte[] bArr2 = null;
                        int i26 = -1;
                        while (position5 - position4 < readInt8) {
                            zzpnVar8.zzbl(position5);
                            int position6 = zzpnVar8.getPosition();
                            int readInt10 = zzpnVar8.readInt();
                            if (readInt10 == 0 && zzpnVar8.getPosition() - position4 == readInt8) {
                                break;
                            }
                            zzpg.checkArgument(readInt10 > 0, obj2);
                            int readInt11 = zzpnVar8.readInt();
                            String str12 = str10;
                            if (readInt11 == zzkw.zzauo) {
                                zzpg.checkState(str11 == null);
                                zzpnVar8.zzbl(position6 + 8);
                                zzpv zzg = zzpv.zzg(zzpnVar8);
                                list = zzg.zzahq;
                                zzlcVar6.zzata = zzg.zzata;
                                if (!z3) {
                                    f = zzg.zzbki;
                                }
                                str2 = "video/avc";
                            } else if (readInt11 == zzkw.zzaup) {
                                zzpg.checkState(str11 == null);
                                zzpnVar8.zzbl(position6 + 8);
                                zzqb zzi = zzqb.zzi(zzpnVar8);
                                list = zzi.zzahq;
                                zzlcVar6.zzata = zzi.zzata;
                                str2 = "video/hevc";
                            } else {
                                if (readInt11 == zzkw.zzawt) {
                                    zzpg.checkState(str11 == null);
                                    str11 = readInt9 == zzkw.zzawr ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                } else if (readInt11 == zzkw.zzatn) {
                                    zzpg.checkState(str11 == null);
                                    str11 = "video/3gpp";
                                } else if (readInt11 == zzkw.zzauq) {
                                    zzpg.checkState(str11 == null);
                                    Pair<String, byte[]> zzb = zzb(zzpnVar8, position6);
                                    str11 = (String) zzb.first;
                                    list3 = Collections.singletonList((byte[]) zzb.second);
                                } else if (readInt11 == zzkw.zzavp) {
                                    zzpnVar8.zzbl(position6 + 8);
                                    f = zzpnVar8.zzje() / zzpnVar8.zzje();
                                    i11 = readInt9;
                                    obj = obj2;
                                    z3 = true;
                                    position5 += readInt10;
                                    str10 = str12;
                                    readInt9 = i11;
                                    obj2 = obj;
                                } else {
                                    if (readInt11 == zzkw.zzawp) {
                                        int i27 = position6 + 8;
                                        while (true) {
                                            if (i27 - position6 >= readInt10) {
                                                i11 = readInt9;
                                                obj = obj2;
                                                bArr = null;
                                                break;
                                            }
                                            zzpnVar8.zzbl(i27);
                                            int readInt12 = zzpnVar8.readInt();
                                            i11 = readInt9;
                                            obj = obj2;
                                            if (zzpnVar8.readInt() == zzkw.zzawq) {
                                                bArr = Arrays.copyOfRange(zzpnVar8.data, i27, readInt12 + i27);
                                                break;
                                            }
                                            i27 += readInt12;
                                            readInt9 = i11;
                                            obj2 = obj;
                                        }
                                        bArr2 = bArr;
                                    } else {
                                        i11 = readInt9;
                                        obj = obj2;
                                        if (readInt11 == zzkw.zzawo) {
                                            int readUnsignedByte = zzpnVar8.readUnsignedByte();
                                            zzpnVar8.zzbm(3);
                                            if (readUnsignedByte == 0) {
                                                int readUnsignedByte2 = zzpnVar8.readUnsignedByte();
                                                if (readUnsignedByte2 == 0) {
                                                    i26 = 0;
                                                } else if (readUnsignedByte2 == 1) {
                                                    i26 = 1;
                                                } else if (readUnsignedByte2 == 2) {
                                                    i26 = 2;
                                                } else if (readUnsignedByte2 == 3) {
                                                    i26 = 3;
                                                }
                                            }
                                            position5 += readInt10;
                                            str10 = str12;
                                            readInt9 = i11;
                                            obj2 = obj;
                                        }
                                    }
                                    position5 += readInt10;
                                    str10 = str12;
                                    readInt9 = i11;
                                    obj2 = obj;
                                }
                                i11 = readInt9;
                                obj = obj2;
                                position5 += readInt10;
                                str10 = str12;
                                readInt9 = i11;
                                obj2 = obj;
                            }
                            i11 = readInt9;
                            list3 = list;
                            obj = obj2;
                            str11 = str2;
                            position5 += readInt10;
                            str10 = str12;
                            readInt9 = i11;
                            obj2 = obj;
                        }
                        str = str10;
                        if (str11 != null) {
                            i8 = i25;
                            float f2 = f;
                            i9 = position4;
                            pair = pair3;
                            i10 = readInt8;
                            zzpnVar = zzpnVar8;
                            zzlcVar2 = zzlcVar6;
                            zzlcVar2.zzaij = zzht.zza(Integer.toString(i2), str11, null, -1, -1, readUnsignedShort2, readUnsignedShort3, -1.0f, list3, i3, f2, bArr2, i26, null, zzjoVar);
                            zzpn zzpnVar9 = zzpnVar;
                            zzpnVar9.zzbl(i9 + i10);
                            i4 = i8 + 1;
                            zzjoVar2 = zzjoVar;
                            zzlcVar5 = zzlcVar2;
                            zzpnVar7 = zzpnVar9;
                            zzldVar2 = zzldVar;
                            i = i7;
                            readInt = i6;
                            str8 = str;
                            create2 = pair;
                        } else {
                            pair = pair3;
                            i8 = i25;
                            i9 = position4;
                            zzpnVar = zzpnVar8;
                            i10 = readInt8;
                            zzlcVar2 = zzlcVar6;
                        }
                    } else {
                        if (readInt9 == zzkw.zzatp || readInt9 == zzkw.zzavh || readInt9 == zzkw.zzatu || readInt9 == zzkw.zzatw || readInt9 == zzkw.zzaty || readInt9 == zzkw.zzaub || readInt9 == zzkw.zzatz || readInt9 == zzkw.zzaua || readInt9 == zzkw.zzawf || readInt9 == zzkw.zzawg || readInt9 == zzkw.zzats || readInt9 == zzkw.zzatt || readInt9 == zzkw.zzatq || readInt9 == zzkw.zzawv) {
                            i12 = i4;
                            i6 = readInt;
                            i7 = i;
                            String str13 = str8;
                            zzldVar = zzldVar2;
                            zzlc zzlcVar7 = zzlcVar5;
                            int i28 = position4;
                            zzpnVar7.zzbl(i28 + 8 + 8);
                            if (z) {
                                i13 = zzpnVar7.readUnsignedShort();
                                zzpnVar7.zzbm(6);
                            } else {
                                zzpnVar7.zzbm(8);
                                i13 = 0;
                            }
                            if (i13 != 0) {
                                i14 = 1;
                                if (i13 != 1) {
                                    if (i13 == 2) {
                                        zzpnVar7.zzbm(16);
                                        i16 = (int) Math.round(Double.longBitsToDouble(zzpnVar7.readLong()));
                                        i15 = zzpnVar7.zzje();
                                        zzpnVar7.zzbm(20);
                                        position = zzpnVar7.getPosition();
                                        if (readInt9 != zzkw.zzavh) {
                                            i17 = i12;
                                            readInt9 = zza(zzpnVar7, i28, readInt8, zzlcVar7, i17);
                                            zzpnVar7.zzbl(position);
                                        } else {
                                            i17 = i12;
                                        }
                                        String str14 = "audio/raw";
                                        if (readInt9 != zzkw.zzatu) {
                                            str3 = "audio/ac3";
                                        } else if (readInt9 == zzkw.zzatw) {
                                            str3 = "audio/eac3";
                                        } else if (readInt9 == zzkw.zzaty) {
                                            str3 = "audio/vnd.dts";
                                        } else if (readInt9 == zzkw.zzatz || readInt9 == zzkw.zzaua) {
                                            str3 = "audio/vnd.dts.hd";
                                        } else if (readInt9 == zzkw.zzaub) {
                                            str3 = "audio/vnd.dts.hd;profile=lbr";
                                        } else if (readInt9 == zzkw.zzawf) {
                                            str3 = "audio/3gpp";
                                        } else if (readInt9 == zzkw.zzawg) {
                                            str3 = "audio/amr-wb";
                                        } else if (readInt9 == zzkw.zzats || readInt9 == zzkw.zzatt) {
                                            str3 = "audio/raw";
                                        } else if (readInt9 == zzkw.zzatq) {
                                            str3 = "audio/mpeg";
                                        } else {
                                            str3 = readInt9 == zzkw.zzawv ? "audio/alac" : null;
                                        }
                                        String str15 = str3;
                                        int i29 = i16;
                                        int i30 = i15;
                                        byte[] bArr3 = null;
                                        while (position - i28 < readInt8) {
                                            zzpnVar7.zzbl(position);
                                            int readInt13 = zzpnVar7.readInt();
                                            zzpg.checkArgument(readInt13 > 0, str9);
                                            int readInt14 = zzpnVar7.readInt();
                                            if (readInt14 == zzkw.zzauq || (z && readInt14 == zzkw.zzatr)) {
                                                String str16 = str9;
                                                i18 = readInt13;
                                                i19 = i17;
                                                String str17 = str15;
                                                str4 = str14;
                                                i20 = i28;
                                                zzlcVar4 = zzlcVar7;
                                                if (readInt14 != zzkw.zzauq) {
                                                    position2 = zzpnVar7.getPosition();
                                                    while (true) {
                                                        if (position2 - position >= i18) {
                                                            str5 = str16;
                                                            position2 = -1;
                                                            break;
                                                        }
                                                        zzpnVar7.zzbl(position2);
                                                        int readInt15 = zzpnVar7.readInt();
                                                        str5 = str16;
                                                        zzpg.checkArgument(readInt15 > 0, str5);
                                                        if (zzpnVar7.readInt() == zzkw.zzauq) {
                                                            break;
                                                        }
                                                        position2 += readInt15;
                                                        str16 = str5;
                                                    }
                                                } else {
                                                    position2 = position;
                                                    str5 = str16;
                                                }
                                                if (position2 != -1) {
                                                    Pair<String, byte[]> zzb2 = zzb(zzpnVar7, position2);
                                                    String str18 = (String) zzb2.first;
                                                    bArr3 = (byte[]) zzb2.second;
                                                    if ("audio/mp4a-latm".equals(str18)) {
                                                        Pair<Integer, Integer> zze = zzpf.zze(bArr3);
                                                        int intValue = ((Integer) zze.first).intValue();
                                                        i30 = ((Integer) zze.second).intValue();
                                                        str15 = str18;
                                                        i29 = intValue;
                                                    } else {
                                                        str15 = str18;
                                                    }
                                                } else {
                                                    str15 = str17;
                                                }
                                            } else {
                                                if (readInt14 == zzkw.zzatv) {
                                                    zzpnVar7.zzbl(position + 8);
                                                    zzlcVar7.zzaij = zzih.zza(zzpnVar7, Integer.toString(i2), str13, zzjoVar2);
                                                } else if (readInt14 == zzkw.zzatx) {
                                                    zzpnVar7.zzbl(position + 8);
                                                    zzlcVar7.zzaij = zzih.zzb(zzpnVar7, Integer.toString(i2), str13, zzjoVar2);
                                                } else {
                                                    if (readInt14 == zzkw.zzauc) {
                                                        str6 = str9;
                                                        i21 = readInt13;
                                                        i22 = position;
                                                        i19 = i17;
                                                        str7 = str15;
                                                        str4 = str14;
                                                        i20 = i28;
                                                        zzlcVar4 = zzlcVar7;
                                                        zzlcVar4.zzaij = zzht.zza(Integer.toString(i2), str15, null, -1, -1, i30, i29, null, zzjoVar, 0, str13);
                                                    } else {
                                                        str6 = str9;
                                                        i21 = readInt13;
                                                        i22 = position;
                                                        i19 = i17;
                                                        str7 = str15;
                                                        str4 = str14;
                                                        i20 = i28;
                                                        zzlcVar4 = zzlcVar7;
                                                        if (readInt14 == zzkw.zzawv) {
                                                            i18 = i21;
                                                            byte[] bArr4 = new byte[i18];
                                                            position = i22;
                                                            zzpnVar7.zzbl(position);
                                                            zzpnVar7.zze(bArr4, 0, i18);
                                                            bArr3 = bArr4;
                                                            str5 = str6;
                                                            str15 = str7;
                                                        }
                                                    }
                                                    i18 = i21;
                                                    position = i22;
                                                    str5 = str6;
                                                    str15 = str7;
                                                }
                                                str6 = str9;
                                                i18 = readInt13;
                                                i19 = i17;
                                                str7 = str15;
                                                str4 = str14;
                                                i20 = i28;
                                                zzlcVar4 = zzlcVar7;
                                                str5 = str6;
                                                str15 = str7;
                                            }
                                            position += i18;
                                            str9 = str5;
                                            zzlcVar7 = zzlcVar4;
                                            i17 = i19;
                                            str14 = str4;
                                            i28 = i20;
                                            zzjoVar2 = zzjoVar;
                                        }
                                        int i31 = i17;
                                        String str19 = str15;
                                        String str20 = str14;
                                        int i32 = i28;
                                        zzlcVar3 = zzlcVar7;
                                        if (zzlcVar3.zzaij == null || str19 == null) {
                                            pair2 = create2;
                                            zzpnVar2 = zzpnVar7;
                                        } else {
                                            pair2 = create2;
                                            zzpnVar2 = zzpnVar7;
                                            zzlcVar3.zzaij = zzht.zza(Integer.toString(i2), str19, null, -1, -1, i30, i29, str20.equals(str19) ? 2 : -1, bArr3 == null ? null : Collections.singletonList(bArr3), zzjoVar, 0, str13);
                                        }
                                        pair = pair2;
                                        str = str13;
                                        zzpnVar = zzpnVar2;
                                        i10 = readInt8;
                                        zzlcVar2 = zzlcVar3;
                                        i8 = i31;
                                        i9 = i32;
                                    } else {
                                        str = str13;
                                        i9 = i28;
                                        zzlcVar2 = zzlcVar7;
                                        zzpnVar = zzpnVar7;
                                        pair = create2;
                                        i10 = readInt8;
                                    }
                                }
                            } else {
                                i14 = 1;
                            }
                            int readUnsignedShort4 = zzpnVar7.readUnsignedShort();
                            zzpnVar7.zzbm(6);
                            i16 = zzpnVar7.zzjd();
                            if (i13 == i14) {
                                zzpnVar7.zzbm(16);
                            }
                            i15 = readUnsignedShort4;
                            position = zzpnVar7.getPosition();
                            if (readInt9 != zzkw.zzavh) {
                            }
                            String str142 = "audio/raw";
                            if (readInt9 != zzkw.zzatu) {
                            }
                            String str152 = str3;
                            int i292 = i16;
                            int i302 = i15;
                            byte[] bArr32 = null;
                            while (position - i28 < readInt8) {
                            }
                            int i312 = i17;
                            String str192 = str152;
                            String str202 = str142;
                            int i322 = i28;
                            zzlcVar3 = zzlcVar7;
                            if (zzlcVar3.zzaij == null) {
                            }
                            pair2 = create2;
                            zzpnVar2 = zzpnVar7;
                            pair = pair2;
                            str = str13;
                            zzpnVar = zzpnVar2;
                            i10 = readInt8;
                            zzlcVar2 = zzlcVar3;
                            i8 = i312;
                            i9 = i322;
                        } else if (readInt9 == zzkw.zzavq || readInt9 == zzkw.zzawb || readInt9 == zzkw.zzawc || readInt9 == zzkw.zzawd || readInt9 == zzkw.zzawe) {
                            zzpnVar7.zzbl(position4 + 8 + 8);
                            long j5 = Long.MAX_VALUE;
                            String str21 = "application/ttml+xml";
                            if (readInt9 == zzkw.zzavq) {
                                list2 = null;
                            } else if (readInt9 == zzkw.zzawb) {
                                int i33 = (readInt8 - 8) - 8;
                                byte[] bArr5 = new byte[i33];
                                zzpnVar7.zze(bArr5, 0, i33);
                                list2 = Collections.singletonList(bArr5);
                                str21 = "application/x-quicktime-tx3g";
                            } else {
                                if (readInt9 == zzkw.zzawc) {
                                    str21 = "application/x-mp4-vtt";
                                } else if (readInt9 == zzkw.zzawd) {
                                    j5 = 0;
                                } else if (readInt9 == zzkw.zzawe) {
                                    zzlcVar5.zzaxo = 1;
                                    str21 = "application/x-mp4-cea-608";
                                    list2 = null;
                                } else {
                                    throw new IllegalStateException();
                                }
                                list2 = null;
                            }
                            zzldVar = zzldVar2;
                            i12 = i4;
                            zzlc zzlcVar8 = zzlcVar5;
                            i6 = readInt;
                            i7 = i;
                            zzlcVar8.zzaij = zzht.zza(Integer.toString(i2), str21, null, -1, 0, str8, -1, zzjoVar, j5, list2);
                            str = str8;
                            zzlcVar2 = zzlcVar8;
                            zzpnVar = zzpnVar7;
                            pair = create2;
                            i10 = readInt8;
                            i9 = position4;
                        } else {
                            if (readInt9 == zzkw.zzawu) {
                                zzlcVar5.zzaij = zzht.zza(Integer.toString(i2), "application/x-camera-motion", null, -1, zzjoVar2);
                            }
                            i10 = readInt8;
                            i9 = position4;
                            i8 = i4;
                            zzlcVar2 = zzlcVar5;
                            i6 = readInt;
                            i7 = i;
                            str = str8;
                            zzpnVar = zzpnVar7;
                            pair = create2;
                            zzldVar = zzldVar2;
                            zzpn zzpnVar92 = zzpnVar;
                            zzpnVar92.zzbl(i9 + i10);
                            i4 = i8 + 1;
                            zzjoVar2 = zzjoVar;
                            zzlcVar5 = zzlcVar2;
                            zzpnVar7 = zzpnVar92;
                            zzldVar2 = zzldVar;
                            i = i7;
                            readInt = i6;
                            str8 = str;
                            create2 = pair;
                        }
                        i8 = i12;
                        zzpn zzpnVar922 = zzpnVar;
                        zzpnVar922.zzbl(i9 + i10);
                        i4 = i8 + 1;
                        zzjoVar2 = zzjoVar;
                        zzlcVar5 = zzlcVar2;
                        zzpnVar7 = zzpnVar922;
                        zzldVar2 = zzldVar;
                        i = i7;
                        readInt = i6;
                        str8 = str;
                        create2 = pair;
                    }
                    zzpn zzpnVar9222 = zzpnVar;
                    zzpnVar9222.zzbl(i9 + i10);
                    i4 = i8 + 1;
                    zzjoVar2 = zzjoVar;
                    zzlcVar5 = zzlcVar2;
                    zzpnVar7 = zzpnVar9222;
                    zzldVar2 = zzldVar;
                    i = i7;
                    readInt = i6;
                    str8 = str;
                    create2 = pair;
                }
                zzlcVar = zzlcVar5;
                int i34 = i;
                Pair pair4 = create2;
                zzld zzldVar3 = zzldVar2;
                zzat = zzkvVar.zzat(zzkw.zzauw);
                if (zzat != null || (zzas = zzat.zzas(zzkw.zzaux)) == null) {
                    zzlsVar = null;
                    create = Pair.create(null, null);
                } else {
                    zzpn zzpnVar10 = zzas.zzaxd;
                    zzpnVar10.zzbl(8);
                    int zzau3 = zzkw.zzau(zzpnVar10.readInt());
                    int zzje = zzpnVar10.zzje();
                    long[] jArr = new long[zzje];
                    long[] jArr2 = new long[zzje];
                    for (int i35 = 0; i35 < zzje; i35++) {
                        jArr[i35] = zzau3 == 1 ? zzpnVar10.zzjf() : zzpnVar10.zzjb();
                        jArr2[i35] = zzau3 == 1 ? zzpnVar10.readLong() : zzpnVar10.readInt();
                        if (zzpnVar10.readShort() != 1) {
                            throw new IllegalArgumentException("Unsupported media rate.");
                        }
                        zzpnVar10.zzbm(2);
                    }
                    create = Pair.create(jArr, jArr2);
                    zzlsVar = null;
                }
                if (zzlcVar.zzaij != null) {
                    return zzlsVar;
                }
                i5 = zzldVar3.id;
                return new zzls(i5, i34, ((Long) pair4.first).longValue(), zzjb2, zza, zzlcVar.zzaij, zzlcVar.zzaxo, zzlcVar.zzaxn, zzlcVar.zzata, (long[]) create.first, (long[]) create.second);
            }
        }
        j2 = -9223372036854775807L;
        zzpnVar4.zzbm(16);
        int readInt42 = zzpnVar4.readInt();
        int readInt52 = zzpnVar4.readInt();
        zzpnVar4.zzbm(4);
        int readInt62 = zzpnVar4.readInt();
        int readInt72 = zzpnVar4.readInt();
        zzld zzldVar22 = new zzld(readInt3, j2, (readInt42 != 0 && readInt52 == 65536 && readInt62 == -65536 && readInt72 == 0) ? 90 : (readInt42 != 0 && readInt52 == -65536 && readInt62 == 65536 && readInt72 == 0) ? 270 : (readInt42 != -65536 && readInt52 == 0 && readInt62 == 0 && readInt72 == -65536) ? 180 : 0);
        if (j != -9223372036854775807L) {
        }
        zzpn zzpnVar52 = zzkyVar2.zzaxd;
        zzpnVar52.zzbl(8);
        zzpnVar52.zzbm(zzkw.zzau(zzpnVar52.readInt()) != 0 ? 8 : 16);
        long zzjb22 = zzpnVar52.zzjb();
        if (j3 != -9223372036854775807L) {
        }
        zzkv zzat32 = zzat2.zzat(zzkw.zzaum).zzat(zzkw.zzaun);
        zzpn zzpnVar62 = zzat2.zzas(zzkw.zzauy).zzaxd;
        zzpnVar62.zzbl(8);
        int zzau22 = zzkw.zzau(zzpnVar62.readInt());
        zzpnVar62.zzbm(zzau22 != 0 ? 8 : 16);
        long zzjb32 = zzpnVar62.zzjb();
        zzpnVar62.zzbm(zzau22 != 0 ? 4 : 8);
        int readUnsignedShort5 = zzpnVar62.readUnsignedShort();
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append((char) (((readUnsignedShort5 >> 10) & 31) + 96));
        sb2.append((char) (((readUnsignedShort5 >> 5) & 31) + 96));
        sb2.append((char) ((readUnsignedShort5 & 31) + 96));
        Pair create22 = Pair.create(Long.valueOf(zzjb32), sb2.toString());
        zzpn zzpnVar72 = zzat32.zzas(zzkw.zzava).zzaxd;
        i2 = zzldVar22.id;
        i3 = zzldVar22.zzaht;
        String str82 = (String) create22.second;
        zzpnVar72.zzbl(12);
        readInt = zzpnVar72.readInt();
        zzlc zzlcVar52 = new zzlc(readInt);
        i4 = 0;
        while (i4 < readInt) {
        }
        zzlcVar = zzlcVar52;
        int i342 = i;
        Pair pair42 = create22;
        zzld zzldVar32 = zzldVar22;
        zzat = zzkvVar.zzat(zzkw.zzauw);
        if (zzat != null) {
        }
        zzlsVar = null;
        create = Pair.create(null, null);
        if (zzlcVar.zzaij != null) {
        }
    }

    public static zzlt zza(zzls zzlsVar, zzkv zzkvVar, zzke zzkeVar) {
        zzkz zzleVar;
        boolean z;
        int i;
        int i2;
        zzls zzlsVar2;
        int i3;
        long[] jArr;
        int[] iArr;
        int i4;
        long[] jArr2;
        int[] iArr2;
        long j;
        boolean z2;
        long[] jArr3;
        int[] iArr3;
        int i5;
        long[] jArr4;
        int[] iArr4;
        int i6;
        int i7;
        int i8;
        int i9;
        zzky zzas = zzkvVar.zzas(zzkw.zzavx);
        if (zzas != null) {
            zzleVar = new zzlb(zzas);
        } else {
            zzky zzas2 = zzkvVar.zzas(zzkw.zzavy);
            if (zzas2 == null) {
                throw new zzhw("Track has no sample table size information");
            }
            zzleVar = new zzle(zzas2);
        }
        int zzhb = zzleVar.zzhb();
        if (zzhb == 0) {
            return new zzlt(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzky zzas3 = zzkvVar.zzas(zzkw.zzavz);
        if (zzas3 == null) {
            zzas3 = zzkvVar.zzas(zzkw.zzawa);
            z = true;
        } else {
            z = false;
        }
        zzpn zzpnVar = zzas3.zzaxd;
        zzpn zzpnVar2 = zzkvVar.zzas(zzkw.zzavw).zzaxd;
        zzpn zzpnVar3 = zzkvVar.zzas(zzkw.zzavt).zzaxd;
        zzky zzas4 = zzkvVar.zzas(zzkw.zzavu);
        zzpn zzpnVar4 = null;
        zzpn zzpnVar5 = zzas4 != null ? zzas4.zzaxd : null;
        zzky zzas5 = zzkvVar.zzas(zzkw.zzavv);
        zzpn zzpnVar6 = zzas5 != null ? zzas5.zzaxd : null;
        zzla zzlaVar = new zzla(zzpnVar2, zzpnVar, z);
        zzpnVar3.zzbl(12);
        int zzje = zzpnVar3.zzje() - 1;
        int zzje2 = zzpnVar3.zzje();
        int zzje3 = zzpnVar3.zzje();
        if (zzpnVar6 != null) {
            zzpnVar6.zzbl(12);
            i = zzpnVar6.zzje();
        } else {
            i = 0;
        }
        int i10 = -1;
        if (zzpnVar5 != null) {
            zzpnVar5.zzbl(12);
            i2 = zzpnVar5.zzje();
            if (i2 > 0) {
                i10 = zzpnVar5.zzje() - 1;
                zzpnVar4 = zzpnVar5;
            }
        } else {
            zzpnVar4 = zzpnVar5;
            i2 = 0;
        }
        long j2 = 0;
        if (!(zzleVar.zzhd() && "audio/raw".equals(zzlsVar.zzaij.zzaho) && zzje == 0 && i == 0 && i2 == 0)) {
            long[] jArr5 = new long[zzhb];
            iArr = new int[zzhb];
            jArr2 = new long[zzhb];
            int i11 = i2;
            iArr2 = new int[zzhb];
            int i12 = i10;
            long j3 = 0;
            j = 0;
            int i13 = 0;
            i4 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = i;
            int i18 = zzje3;
            int i19 = zzje2;
            int i20 = zzje;
            int i21 = i11;
            while (i13 < zzhb) {
                while (i15 == 0) {
                    zzpg.checkState(zzlaVar.zzhe());
                    j3 = zzlaVar.zzaxf;
                    i15 = zzlaVar.zzaxe;
                    i18 = i18;
                    i19 = i19;
                }
                int i22 = i19;
                int i23 = i18;
                if (zzpnVar6 != null) {
                    while (i14 == 0 && i17 > 0) {
                        i14 = zzpnVar6.zzje();
                        i16 = zzpnVar6.readInt();
                        i17--;
                    }
                    i14--;
                }
                int i24 = i16;
                jArr5[i13] = j3;
                iArr[i13] = zzleVar.zzhc();
                if (iArr[i13] > i4) {
                    i4 = iArr[i13];
                }
                int i25 = zzhb;
                zzkz zzkzVar = zzleVar;
                jArr2[i13] = j + i24;
                iArr2[i13] = zzpnVar4 == null ? 1 : 0;
                if (i13 == i12) {
                    iArr2[i13] = 1;
                    i21--;
                    if (i21 > 0) {
                        i12 = zzpnVar4.zzje() - 1;
                    }
                }
                long[] jArr6 = jArr5;
                j += i23;
                int i26 = i22 - 1;
                if (i26 != 0 || i20 <= 0) {
                    i8 = i23;
                    i9 = i26;
                } else {
                    i9 = zzpnVar3.zzje();
                    i8 = zzpnVar3.zzje();
                    i20--;
                }
                int i27 = i9;
                j3 += iArr[i13];
                i15--;
                i13++;
                zzhb = i25;
                jArr5 = jArr6;
                i12 = i12;
                i16 = i24;
                i19 = i27;
                i18 = i8;
                zzleVar = zzkzVar;
            }
            i3 = zzhb;
            long[] jArr7 = jArr5;
            int i28 = i19;
            zzpg.checkArgument(i14 == 0);
            while (i17 > 0) {
                zzpg.checkArgument(zzpnVar6.zzje() == 0);
                zzpnVar6.readInt();
                i17--;
            }
            if (i21 == 0 && i28 == 0) {
                i7 = i15;
                if (i7 == 0 && i20 == 0) {
                    zzlsVar2 = zzlsVar;
                    jArr = jArr7;
                }
            } else {
                i7 = i15;
            }
            zzlsVar2 = zzlsVar;
            int i29 = zzlsVar2.id;
            StringBuilder sb = new StringBuilder(215);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i29);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i21);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i28);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i7);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i20);
            Log.w("AtomParsers", sb.toString());
            jArr = jArr7;
        } else {
            zzlsVar2 = zzlsVar;
            i3 = zzhb;
            zzkz zzkzVar2 = zzleVar;
            long[] jArr8 = new long[zzlaVar.length];
            int i30 = zzlaVar.length;
            int[] iArr5 = new int[i30];
            while (zzlaVar.zzhe()) {
                jArr8[zzlaVar.index] = zzlaVar.zzaxf;
                iArr5[zzlaVar.index] = zzlaVar.zzaxe;
            }
            int zzhc = zzkzVar2.zzhc();
            long j4 = zzje3;
            int i31 = 8192 / zzhc;
            int i32 = 0;
            for (int i33 = 0; i33 < i30; i33++) {
                i32 += zzpt.zzh(iArr5[i33], i31);
            }
            long[] jArr9 = new long[i32];
            int[] iArr6 = new int[i32];
            long[] jArr10 = new long[i32];
            int[] iArr7 = new int[i32];
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i34 < i30) {
                int i38 = iArr5[i34];
                long j5 = jArr8[i34];
                long[] jArr11 = jArr8;
                int i39 = i38;
                while (i39 > 0) {
                    int min = Math.min(i31, i39);
                    jArr9[i36] = j5;
                    iArr6[i36] = zzhc * min;
                    i37 = Math.max(i37, iArr6[i36]);
                    jArr10[i36] = i35 * j4;
                    iArr7[i36] = 1;
                    j5 += iArr6[i36];
                    i35 += min;
                    i39 -= min;
                    i36++;
                    i30 = i30;
                    iArr5 = iArr5;
                }
                i34++;
                jArr8 = jArr11;
            }
            zzli zzliVar = new zzli(jArr9, iArr6, i37, jArr10, iArr7);
            jArr = zzliVar.zzapf;
            iArr = zzliVar.zzape;
            i4 = zzliVar.zzayt;
            jArr2 = zzliVar.zzayu;
            iArr2 = zzliVar.zzayv;
            j = 0;
        }
        if (zzlsVar2.zzbav == null || zzkeVar.zzgx()) {
            zzpt.zza(jArr2, 1000000L, zzlsVar2.zzdf);
            return new zzlt(jArr, iArr, i4, jArr2, iArr2);
        }
        if (zzlsVar2.zzbav.length == 1 && zzlsVar2.type == 1 && jArr2.length >= 2) {
            long j6 = zzlsVar2.zzbaw[0];
            long zza = zzpt.zza(zzlsVar2.zzbav[0], zzlsVar2.zzdf, zzlsVar2.zzbas) + j6;
            if (jArr2[0] <= j6 && j6 < jArr2[1] && jArr2[jArr2.length - 1] < zza && zza <= j) {
                long j7 = j - zza;
                long zza2 = zzpt.zza(j6 - jArr2[0], zzlsVar2.zzaij.zzahz, zzlsVar2.zzdf);
                long zza3 = zzpt.zza(j7, zzlsVar2.zzaij.zzahz, zzlsVar2.zzdf);
                if ((zza2 != 0 || zza3 != 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    zzkeVar.zzaib = (int) zza2;
                    zzkeVar.zzaic = (int) zza3;
                    zzpt.zza(jArr2, 1000000L, zzlsVar2.zzdf);
                    return new zzlt(jArr, iArr, i4, jArr2, iArr2);
                }
            }
        }
        if (zzlsVar2.zzbav.length == 1) {
            char c2 = 0;
            if (zzlsVar2.zzbav[0] == 0) {
                int i40 = 0;
                while (i40 < jArr2.length) {
                    jArr2[i40] = zzpt.zza(jArr2[i40] - zzlsVar2.zzbaw[c2], 1000000L, zzlsVar2.zzdf);
                    i40++;
                    c2 = 0;
                }
                return new zzlt(jArr, iArr, i4, jArr2, iArr2);
            }
        }
        boolean z3 = zzlsVar2.type == 1;
        boolean z4 = false;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        while (i42 < zzlsVar2.zzbav.length) {
            long j8 = zzlsVar2.zzbaw[i42];
            if (j8 != -1) {
                i6 = i4;
                long zza4 = zzpt.zza(zzlsVar2.zzbav[i42], zzlsVar2.zzdf, zzlsVar2.zzbas);
                int zzb = zzpt.zzb(jArr2, j8, true, true);
                int zzb2 = zzpt.zzb(jArr2, j8 + zza4, z3, false);
                i41 += zzb2 - zzb;
                z4 |= i43 != zzb;
                i43 = zzb2;
            } else {
                i6 = i4;
            }
            i42++;
            i4 = i6;
        }
        int i44 = i4;
        boolean z5 = z4 | (i41 != i3);
        long[] jArr12 = z5 ? new long[i41] : jArr;
        int[] iArr8 = z5 ? new int[i41] : iArr;
        int i45 = z5 ? 0 : i44;
        int[] iArr9 = z5 ? new int[i41] : iArr2;
        long[] jArr13 = new long[i41];
        int i46 = i45;
        int i47 = 0;
        int i48 = 0;
        while (i47 < zzlsVar2.zzbav.length) {
            long j9 = zzlsVar2.zzbaw[i47];
            long j10 = zzlsVar2.zzbav[i47];
            if (j9 != -1) {
                int[] iArr10 = iArr9;
                i5 = i47;
                long[] jArr14 = jArr12;
                long[] jArr15 = jArr;
                int zzb3 = zzpt.zzb(jArr2, j9, true, true);
                int zzb4 = zzpt.zzb(jArr2, zzpt.zza(j10, zzlsVar2.zzdf, zzlsVar2.zzbas) + j9, z3, false);
                if (z5) {
                    int i49 = zzb4 - zzb3;
                    jArr3 = jArr14;
                    jArr4 = jArr15;
                    System.arraycopy(jArr4, zzb3, jArr3, i48, i49);
                    System.arraycopy(iArr, zzb3, iArr8, i48, i49);
                    z2 = z3;
                    iArr4 = iArr10;
                    System.arraycopy(iArr2, zzb3, iArr4, i48, i49);
                } else {
                    jArr3 = jArr14;
                    z2 = z3;
                    iArr4 = iArr10;
                    jArr4 = jArr15;
                }
                int i50 = i46;
                while (zzb3 < zzb4) {
                    int[] iArr11 = iArr4;
                    int i51 = zzb4;
                    long j11 = j9;
                    jArr13[i48] = zzpt.zza(j2, 1000000L, zzlsVar2.zzbas) + zzpt.zza(jArr2[zzb3] - j9, 1000000L, zzlsVar2.zzdf);
                    if (z5 && iArr8[i48] > i50) {
                        i50 = iArr[zzb3];
                    }
                    i48++;
                    zzb3++;
                    j9 = j11;
                    zzb4 = i51;
                    iArr4 = iArr11;
                }
                iArr3 = iArr4;
                i46 = i50;
            } else {
                z2 = z3;
                jArr3 = jArr12;
                iArr3 = iArr9;
                i5 = i47;
                jArr4 = jArr;
            }
            j2 += j10;
            i47 = i5 + 1;
            jArr = jArr4;
            jArr12 = jArr3;
            z3 = z2;
            iArr9 = iArr3;
        }
        long[] jArr16 = jArr12;
        int[] iArr12 = iArr9;
        boolean z6 = false;
        for (int i52 = 0; i52 < iArr12.length && !z6; i52++) {
            z6 |= (iArr12[i52] & 1) != 0;
        }
        if (!z6) {
            throw new zzhw("The edited sample sequence does not contain a sync sample.");
        }
        return new zzlt(jArr16, iArr8, i46, jArr13, iArr12);
    }

    public static zzmh zza(zzky zzkyVar, boolean z) {
        if (z) {
            return null;
        }
        zzpn zzpnVar = zzkyVar.zzaxd;
        zzpnVar.zzbl(8);
        while (zzpnVar.zziz() >= 8) {
            int position = zzpnVar.getPosition();
            int readInt = zzpnVar.readInt();
            if (zzpnVar.readInt() == zzkw.zzawi) {
                zzpnVar.zzbl(position);
                int i = position + readInt;
                zzpnVar.zzbm(12);
                while (true) {
                    if (zzpnVar.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzpnVar.getPosition();
                    int readInt2 = zzpnVar.readInt();
                    if (zzpnVar.readInt() == zzkw.zzawj) {
                        zzpnVar.zzbl(position2);
                        int i2 = position2 + readInt2;
                        zzpnVar.zzbm(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpnVar.getPosition() < i2) {
                            zzmh.zza zzd = zzll.zzd(zzpnVar);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzmh(arrayList);
                        }
                    } else {
                        zzpnVar.zzbm(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpnVar.zzbm(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzpn zzpnVar, int i) {
        zzpnVar.zzbl(i + 8 + 4);
        zzpnVar.zzbm(1);
        zzc(zzpnVar);
        zzpnVar.zzbm(2);
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpnVar.zzbm(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpnVar.zzbm(zzpnVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpnVar.zzbm(2);
        }
        zzpnVar.zzbm(1);
        zzc(zzpnVar);
        int readUnsignedByte2 = zzpnVar.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzpnVar.zzbm(12);
        zzpnVar.zzbm(1);
        int zzc = zzc(zzpnVar);
        byte[] bArr = new byte[zzc];
        zzpnVar.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zza(zzpn zzpnVar, int i, int i2, zzlc zzlcVar, int i3) {
        int position = zzpnVar.getPosition();
        while (true) {
            if (position - i >= i2) {
                return 0;
            }
            zzpnVar.zzbl(position);
            int readInt = zzpnVar.readInt();
            zzpg.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpnVar.readInt() == zzkw.zzavc) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzlr zzlrVar = null;
                boolean z = false;
                while (i4 - position < readInt) {
                    zzpnVar.zzbl(i4);
                    int readInt2 = zzpnVar.readInt();
                    int readInt3 = zzpnVar.readInt();
                    if (readInt3 == zzkw.zzavi) {
                        num = Integer.valueOf(zzpnVar.readInt());
                    } else if (readInt3 == zzkw.zzavd) {
                        zzpnVar.zzbm(4);
                        z = zzpnVar.readInt() == zzaxc;
                    } else if (readInt3 == zzkw.zzave) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzlrVar = null;
                                break;
                            }
                            zzpnVar.zzbl(i5);
                            int readInt4 = zzpnVar.readInt();
                            if (zzpnVar.readInt() == zzkw.zzavf) {
                                zzpnVar.zzbm(6);
                                boolean z2 = zzpnVar.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpnVar.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpnVar.zze(bArr, 0, 16);
                                zzlrVar = new zzlr(z2, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                    }
                    i4 += readInt2;
                }
                if (z) {
                    zzpg.checkArgument(num != null, "frma atom is mandatory");
                    zzpg.checkArgument(zzlrVar != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzlrVar);
                }
                if (pair != null) {
                    zzlcVar.zzaxn[i3] = (zzlr) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }

    private static int zzc(zzpn zzpnVar) {
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpnVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
