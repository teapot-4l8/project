package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import cn.jpush.android.service.WakedResultReceiver;
import com.google.android.gms.ads.AdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzlz {
    private static final SparseIntArray zzbdl;
    private static final SparseIntArray zzbdm;
    private static final Map<String, Integer> zzbdn;
    private static final zzlw zzbdi = zzlw.zzay("OMX.google.raw.decoder");
    private static final Pattern zzbdj = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzlw>> zzbdk = new HashMap<>();
    private static int zzbdo = -1;

    public static zzlw zzhn() {
        return zzbdi;
    }

    public static zzlw zzc(String str, boolean z) {
        List<zzlw> zzd = zzd(str, z);
        if (zzd.isEmpty()) {
            return null;
        }
        return zzd.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza {
        public final String mimeType;
        public final boolean zzbdc;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzbdc = z;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzbdc ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zzaVar = (zza) obj;
                if (TextUtils.equals(this.mimeType, zzaVar.mimeType) && this.zzbdc == zzaVar.zzbdc) {
                    return true;
                }
            }
            return false;
        }
    }

    private static synchronized List<zzlw> zzd(String str, boolean z) {
        synchronized (zzlz.class) {
            zza zzaVar = new zza(str, z);
            List<zzlw> list = zzbdk.get(zzaVar);
            if (list != null) {
                return list;
            }
            List<zzlw> zza2 = zza(zzaVar, zzpt.SDK_INT >= 21 ? new zzme(z) : new zzmf());
            if (z && zza2.isEmpty() && 21 <= zzpt.SDK_INT && zzpt.SDK_INT <= 23) {
                zza2 = zza(zzaVar, new zzmf());
                if (!zza2.isEmpty()) {
                    String str2 = zza2.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzlw> unmodifiableList = Collections.unmodifiableList(zza2);
            zzbdk.put(zzaVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int zzho() {
        if (zzbdo == -1) {
            int i = 0;
            zzlw zzc = zzc("video/avc", false);
            if (zzc != null) {
                MediaCodecInfo.CodecProfileLevel[] zzhm = zzc.zzhm();
                int length = zzhm.length;
                int i2 = 0;
                while (i < length) {
                    int i3 = zzhm[i].level;
                    int i4 = 9437184;
                    if (i3 == 1 || i3 == 2) {
                        i4 = 25344;
                    } else {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i4 = 101376;
                                continue;
                            case 64:
                                i4 = 202752;
                                continue;
                            case 128:
                            case 256:
                                i4 = 414720;
                                continue;
                            case AdRequest.MAX_CONTENT_URL_LENGTH /* 512 */:
                                i4 = 921600;
                                continue;
                            case 1024:
                                i4 = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i4 = 2097152;
                                continue;
                            case 8192:
                                i4 = 2228224;
                                continue;
                            case 16384:
                                i4 = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i4 = -1;
                                continue;
                        }
                    }
                    i2 = Math.max(i4, i2);
                    i++;
                }
                i = Math.max(i2, zzpt.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzbdo = i;
        }
        return zzbdo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r3.equals("hev1") != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> zzbb(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        char c2 = 0;
        String str2 = split[0];
        int i = 2;
        switch (str2.hashCode()) {
            case 3006243:
                if (str2.equals("avc1")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3006244:
                if (str2.equals("avc2")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3199032:
                break;
            case 3214780:
                if (str2.equals("hvc1")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0 && c2 != 1) {
            if (c2 == 2 || c2 == 3) {
                return zza(str, split);
            }
            return null;
        } else if (split.length < 4) {
            String valueOf = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf) : new String("Ignoring malformed HEVC codec string: "));
            return null;
        } else {
            Matcher matcher = zzbdj.matcher(split[1]);
            if (!matcher.matches()) {
                String valueOf2 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(valueOf2) : new String("Ignoring malformed HEVC codec string: "));
                return null;
            }
            String group = matcher.group(1);
            if ("1".equals(group)) {
                i = 1;
            } else if (!WakedResultReceiver.WAKE_TYPE_KEY.equals(group)) {
                String valueOf3 = String.valueOf(group);
                Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Unknown HEVC profile string: ".concat(valueOf3) : new String("Unknown HEVC profile string: "));
                return null;
            }
            Integer num = zzbdn.get(split[3]);
            if (num == null) {
                String valueOf4 = String.valueOf(matcher.group(1));
                Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Unknown HEVC level string: ".concat(valueOf4) : new String("Unknown HEVC level string: "));
                return null;
            }
            return new Pair<>(Integer.valueOf(i), num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01b2 A[Catch: Exception -> 0x02ae, TryCatch #1 {Exception -> 0x02ae, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x0030, B:14:0x0036, B:16:0x003e, B:18:0x0046, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:27:0x0068, B:29:0x006e, B:32:0x0078, B:34:0x007c, B:36:0x0084, B:39:0x0090, B:41:0x0096, B:43:0x009e, B:45:0x00a8, B:47:0x00b2, B:49:0x00bc, B:51:0x00c6, B:53:0x00d0, B:55:0x00da, B:57:0x00e4, B:59:0x00ee, B:61:0x00f8, B:63:0x0102, B:65:0x010c, B:68:0x0118, B:70:0x011c, B:72:0x0124, B:74:0x012e, B:76:0x0138, B:78:0x0142, B:81:0x014d, B:84:0x0155, B:86:0x015d, B:88:0x0167, B:90:0x0171, B:92:0x017b, B:94:0x0183, B:96:0x018d, B:99:0x0198, B:101:0x019c, B:103:0x01a4, B:109:0x01b2, B:111:0x01ba, B:151:0x0232, B:154:0x023a, B:156:0x0240, B:157:0x0264, B:158:0x0298), top: B:169:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01fd A[Catch: Exception -> 0x01f8, TryCatch #3 {Exception -> 0x01f8, blocks: (B:116:0x01d2, B:118:0x01dc, B:120:0x01e6, B:122:0x01ee, B:129:0x01fd, B:137:0x020b, B:134:0x0206, B:141:0x0219), top: B:173:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<zzlw> zza(zza zzaVar, zzmc zzmcVar) {
        boolean z;
        int i;
        boolean z2;
        zzmc zzmcVar2 = zzmcVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str = zzaVar.mimeType;
            int codecCount = zzmcVar.getCodecCount();
            boolean zzhp = zzmcVar.zzhp();
            int i2 = 0;
            while (i2 < codecCount) {
                MediaCodecInfo codecInfoAt = zzmcVar2.getCodecInfoAt(i2);
                String name = codecInfoAt.getName();
                if (!codecInfoAt.isEncoder() && ((zzhp || !name.endsWith(".secure")) && ((zzpt.SDK_INT >= 21 || (!"CIPAACDecoder".equals(name) && !"CIPMP3Decoder".equals(name) && !"CIPVorbisDecoder".equals(name) && !"CIPAMRNBDecoder".equals(name) && !"AACDecoder".equals(name) && !"MP3Decoder".equals(name))) && ((zzpt.SDK_INT >= 18 || !"OMX.SEC.MP3.Decoder".equals(name)) && ((zzpt.SDK_INT >= 18 || !"OMX.MTK.AUDIO.DECODER.AAC".equals(name) || !"a70".equals(zzpt.DEVICE)) && ((zzpt.SDK_INT != 16 || !"OMX.qcom.audio.decoder.mp3".equals(name) || (!"dlxu".equals(zzpt.DEVICE) && !"protou".equals(zzpt.DEVICE) && !"ville".equals(zzpt.DEVICE) && !"villeplus".equals(zzpt.DEVICE) && !"villec2".equals(zzpt.DEVICE) && !zzpt.DEVICE.startsWith("gee") && !"C6602".equals(zzpt.DEVICE) && !"C6603".equals(zzpt.DEVICE) && !"C6606".equals(zzpt.DEVICE) && !"C6616".equals(zzpt.DEVICE) && !"L36h".equals(zzpt.DEVICE) && !"SO-02E".equals(zzpt.DEVICE))) && ((zzpt.SDK_INT != 16 || !"OMX.qcom.audio.decoder.aac".equals(name) || (!"C1504".equals(zzpt.DEVICE) && !"C1505".equals(zzpt.DEVICE) && !"C1604".equals(zzpt.DEVICE) && !"C1605".equals(zzpt.DEVICE))) && ((zzpt.SDK_INT > 19 || !"OMX.SEC.vp8.dec".equals(name) || !"samsung".equals(zzpt.MANUFACTURER) || (!zzpt.DEVICE.startsWith("d2") && !zzpt.DEVICE.startsWith("serrano") && !zzpt.DEVICE.startsWith("jflte") && !zzpt.DEVICE.startsWith("santos") && !zzpt.DEVICE.startsWith("t0"))) && (zzpt.SDK_INT > 19 || !zzpt.DEVICE.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(name)))))))))) {
                    z = true;
                    if (!z) {
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i3 = 0;
                        while (i3 < length) {
                            String str2 = supportedTypes[i3];
                            if (str2.equalsIgnoreCase(str)) {
                                try {
                                    MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                                    boolean zza2 = zzmcVar2.zza(str, capabilitiesForType);
                                    i = codecCount;
                                    if (zzpt.SDK_INT <= 22) {
                                        try {
                                            if ((zzpt.MODEL.equals("ODROID-XU3") || zzpt.MODEL.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                                                z2 = true;
                                                if (zzhp) {
                                                    if (zzaVar.zzbdc == zza2) {
                                                    }
                                                    arrayList.add(zzlw.zza(name, str, capabilitiesForType, z2, false));
                                                }
                                                if (zzhp && !zzaVar.zzbdc) {
                                                    arrayList.add(zzlw.zza(name, str, capabilitiesForType, z2, false));
                                                } else if (zzhp && zza2) {
                                                    try {
                                                        arrayList.add(zzlw.zza(String.valueOf(name).concat(".secure"), str, capabilitiesForType, z2, true));
                                                        return arrayList;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        if (zzpt.SDK_INT > 23 && !arrayList.isEmpty()) {
                                                            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 46);
                                                            sb.append("Skipping codec ");
                                                            sb.append(name);
                                                            sb.append(" (failed to query capabilities)");
                                                            Log.e("MediaCodecUtil", sb.toString());
                                                            i3++;
                                                            zzmcVar2 = zzmcVar;
                                                            codecCount = i;
                                                        } else {
                                                            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 25 + String.valueOf(str2).length());
                                                            sb2.append("Failed to query codec ");
                                                            sb2.append(name);
                                                            sb2.append(" (");
                                                            sb2.append(str2);
                                                            sb2.append(")");
                                                            Log.e("MediaCodecUtil", sb2.toString());
                                                            throw e;
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            if (zzpt.SDK_INT > 23) {
                                            }
                                            StringBuilder sb22 = new StringBuilder(String.valueOf(name).length() + 25 + String.valueOf(str2).length());
                                            sb22.append("Failed to query codec ");
                                            sb22.append(name);
                                            sb22.append(" (");
                                            sb22.append(str2);
                                            sb22.append(")");
                                            Log.e("MediaCodecUtil", sb22.toString());
                                            throw e;
                                        }
                                    }
                                    z2 = false;
                                    if (zzhp) {
                                    }
                                    if (zzhp) {
                                    }
                                    if (zzhp) {
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    i = codecCount;
                                }
                            } else {
                                i = codecCount;
                            }
                            i3++;
                            zzmcVar2 = zzmcVar;
                            codecCount = i;
                        }
                        continue;
                    }
                    i2++;
                    zzmcVar2 = zzmcVar;
                    codecCount = codecCount;
                }
                z = false;
                if (!z) {
                }
                i2++;
                zzmcVar2 = zzmcVar;
                codecCount = codecCount;
            }
            return arrayList;
        } catch (Exception e5) {
            throw new zzmd(e5);
        }
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer valueOf;
        Integer num;
        if (strArr.length < 2) {
            String valueOf2 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf2) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length >= 3) {
                Integer valueOf3 = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                num = valueOf3;
            } else {
                String valueOf4 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf4.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf4) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf5 = Integer.valueOf(zzbdl.get(num.intValue()));
            if (valueOf5 == null) {
                String valueOf6 = String.valueOf(num);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf6).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf6);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf7 = Integer.valueOf(zzbdm.get(valueOf.intValue()));
            if (valueOf7 == null) {
                String valueOf8 = String.valueOf(valueOf);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf8).length() + 19);
                sb2.append("Unknown AVC level: ");
                sb2.append(valueOf8);
                Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            return new Pair<>(valueOf5, valueOf7);
        } catch (NumberFormatException unused) {
            String valueOf9 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf9) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzbdl = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzbdl.put(77, 2);
        zzbdl.put(88, 4);
        zzbdl.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzbdm = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zzbdm.put(11, 4);
        zzbdm.put(12, 8);
        zzbdm.put(13, 16);
        zzbdm.put(20, 32);
        zzbdm.put(21, 64);
        zzbdm.put(22, 128);
        zzbdm.put(30, 256);
        zzbdm.put(31, AdRequest.MAX_CONTENT_URL_LENGTH);
        zzbdm.put(32, 1024);
        zzbdm.put(40, 2048);
        zzbdm.put(41, 4096);
        zzbdm.put(42, 8192);
        zzbdm.put(50, 16384);
        zzbdm.put(51, 32768);
        zzbdm.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzbdn = hashMap;
        hashMap.put("L30", 1);
        zzbdn.put("L60", 4);
        zzbdn.put("L63", 16);
        zzbdn.put("L90", 64);
        zzbdn.put("L93", 256);
        zzbdn.put("L120", 1024);
        zzbdn.put("L123", 4096);
        zzbdn.put("L150", 16384);
        zzbdn.put("L153", 65536);
        zzbdn.put("L156", 262144);
        zzbdn.put("L180", 1048576);
        zzbdn.put("L183", 4194304);
        zzbdn.put("L186", 16777216);
        zzbdn.put("H30", 2);
        zzbdn.put("H60", 8);
        zzbdn.put("H63", 32);
        zzbdn.put("H90", 128);
        zzbdn.put("H93", Integer.valueOf((int) AdRequest.MAX_CONTENT_URL_LENGTH));
        zzbdn.put("H120", 2048);
        zzbdn.put("H123", 8192);
        zzbdn.put("H150", 32768);
        zzbdn.put("H153", 131072);
        zzbdn.put("H156", 524288);
        zzbdn.put("H180", 2097152);
        zzbdn.put("H183", 8388608);
        zzbdn.put("H186", 33554432);
    }
}
