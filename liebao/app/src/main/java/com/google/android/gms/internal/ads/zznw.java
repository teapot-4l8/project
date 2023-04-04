package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zznw {
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void zza(long j, zzpn zzpnVar, zzkh[] zzkhVarArr) {
        boolean z;
        while (zzpnVar.zziz() > 1) {
            int zzf = zzf(zzpnVar);
            int zzf2 = zzf(zzpnVar);
            if (zzf2 == -1 || zzf2 > zzpnVar.zziz()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                zzpnVar.zzbl(zzpnVar.limit());
            } else {
                if (zzf == 4 && zzf2 >= 8) {
                    int position = zzpnVar.getPosition();
                    int readUnsignedByte = zzpnVar.readUnsignedByte();
                    int readUnsignedShort = zzpnVar.readUnsignedShort();
                    int readInt = zzpnVar.readInt();
                    int readUnsignedByte2 = zzpnVar.readUnsignedByte();
                    zzpnVar.zzbl(position);
                    if (readUnsignedByte == 181 && readUnsignedShort == 49 && readInt == 1195456820 && readUnsignedByte2 == 3) {
                        z = true;
                        if (!z) {
                            zzpnVar.zzbm(8);
                            zzpnVar.zzbm(1);
                            int readUnsignedByte3 = (zzpnVar.readUnsignedByte() & 31) * 3;
                            int position2 = zzpnVar.getPosition();
                            for (zzkh zzkhVar : zzkhVarArr) {
                                zzpnVar.zzbl(position2);
                                zzkhVar.zza(zzpnVar, readUnsignedByte3);
                                zzkhVar.zza(j, 1, readUnsignedByte3, 0, null);
                            }
                            zzpnVar.zzbm(zzf2 - (readUnsignedByte3 + 10));
                        } else {
                            zzpnVar.zzbm(zzf2);
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
        }
    }

    private static int zzf(zzpn zzpnVar) {
        int i = 0;
        while (zzpnVar.zziz() != 0) {
            int readUnsignedByte = zzpnVar.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i;
            }
        }
        return -1;
    }
}
