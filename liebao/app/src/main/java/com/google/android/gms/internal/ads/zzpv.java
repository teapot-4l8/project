package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzpv {
    private final int height;
    private final int width;
    public final List<byte[]> zzahq;
    public final int zzata;
    public final float zzbki;

    public static zzpv zzg(zzpn zzpnVar) {
        int i;
        int i2;
        float f;
        try {
            zzpnVar.zzbm(4);
            int readUnsignedByte = (zzpnVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = zzpnVar.readUnsignedByte() & 31;
            for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                arrayList.add(zzh(zzpnVar));
            }
            int readUnsignedByte3 = zzpnVar.readUnsignedByte();
            for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                arrayList.add(zzh(zzpnVar));
            }
            if (readUnsignedByte2 > 0) {
                zzpl zzd = zzpm.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                int i5 = zzd.width;
                int i6 = zzd.height;
                f = zzd.zzbki;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new zzpv(arrayList, readUnsignedByte, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzhw("Error parsing AVC config", e2);
        }
    }

    private zzpv(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzahq = list;
        this.zzata = i;
        this.width = i2;
        this.height = i3;
        this.zzbki = f;
    }

    private static byte[] zzh(zzpn zzpnVar) {
        int readUnsignedShort = zzpnVar.readUnsignedShort();
        int position = zzpnVar.getPosition();
        zzpnVar.zzbm(readUnsignedShort);
        return zzpf.zzc(zzpnVar.data, position, readUnsignedShort);
    }
}
