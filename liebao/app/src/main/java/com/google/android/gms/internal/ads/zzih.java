package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzih {
    private static final int[] zzajg = {1, 2, 3, 6};
    private static final int[] zzajh = {48000, 44100, 32000};
    private static final int[] zzaji = {24000, 22050, 16000};
    private static final int[] zzajj = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzajk = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, AdRequest.MAX_CONTENT_URL_LENGTH, 576, 640};
    private static final int[] zzajl = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzht zza(zzpn zzpnVar, String str, String str2, zzjo zzjoVar) {
        int i = zzajh[(zzpnVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        int i2 = zzajj[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzht.zza(str, "audio/ac3", null, -1, -1, i2, i, null, zzjoVar, 0, str2);
    }

    public static int zzfm() {
        return 1536;
    }

    public static zzht zzb(zzpn zzpnVar, String str, String str2, zzjo zzjoVar) {
        zzpnVar.zzbm(2);
        int i = zzajh[(zzpnVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzpnVar.readUnsignedByte();
        int i2 = zzajj[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzht.zza(str, "audio/eac3", null, -1, -1, i2, i, null, zzjoVar, 0, str2);
    }

    public static int zzm(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? zzajg[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}
