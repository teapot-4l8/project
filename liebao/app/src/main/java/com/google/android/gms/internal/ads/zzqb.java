package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqb {
    public final List<byte[]> zzahq;
    public final int zzata;

    public static zzqb zzi(zzpn zzpnVar) {
        try {
            zzpnVar.zzbm(21);
            int readUnsignedByte = zzpnVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzpnVar.readUnsignedByte();
            int position = zzpnVar.getPosition();
            int i = 0;
            for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                zzpnVar.zzbm(1);
                int readUnsignedShort = zzpnVar.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                    int readUnsignedShort2 = zzpnVar.readUnsignedShort();
                    i += readUnsignedShort2 + 4;
                    zzpnVar.zzbm(readUnsignedShort2);
                }
            }
            zzpnVar.zzbl(position);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                zzpnVar.zzbm(1);
                int readUnsignedShort3 = zzpnVar.readUnsignedShort();
                for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
                    int readUnsignedShort4 = zzpnVar.readUnsignedShort();
                    System.arraycopy(zzpm.zzbkd, 0, bArr, i4, zzpm.zzbkd.length);
                    int length = i4 + zzpm.zzbkd.length;
                    System.arraycopy(zzpnVar.data, zzpnVar.getPosition(), bArr, length, readUnsignedShort4);
                    i4 = length + readUnsignedShort4;
                    zzpnVar.zzbm(readUnsignedShort4);
                }
            }
            return new zzqb(i == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzhw("Error parsing HEVC config", e2);
        }
    }

    private zzqb(List<byte[]> list, int i) {
        this.zzahq = list;
        this.zzata = i;
    }
}
