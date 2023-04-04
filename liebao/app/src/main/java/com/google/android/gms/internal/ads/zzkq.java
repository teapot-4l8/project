package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjo;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzkq implements zzka {
    private static final zzkb zzapu = new zzkp();
    private static final byte[] zzapv = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzapw = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzapx = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaiz;
    private final zzkt zzapm;
    private final zzko zzapy;
    private final SparseArray<zzkr> zzapz;
    private final boolean zzaqa;
    private final zzpn zzaqb;
    private final zzpn zzaqc;
    private final zzpn zzaqd;
    private final zzpn zzaqe;
    private final zzpn zzaqf;
    private final zzpn zzaqg;
    private final zzpn zzaqh;
    private final zzpn zzaqi;
    private final zzpn zzaqj;
    private ByteBuffer zzaqk;
    private long zzaql;
    private long zzaqm;
    private long zzaqn;
    private long zzaqo;
    private zzkr zzaqp;
    private boolean zzaqq;
    private int zzaqr;
    private long zzaqs;
    private boolean zzaqt;
    private long zzaqu;
    private long zzaqv;
    private long zzaqw;
    private zzph zzaqx;
    private zzph zzaqy;
    private boolean zzaqz;
    private int zzara;
    private long zzarb;
    private long zzarc;
    private int zzard;
    private int zzare;
    private int[] zzarf;
    private int zzarg;
    private int zzarh;
    private int zzari;
    private int zzarj;
    private boolean zzark;
    private boolean zzarl;
    private boolean zzarm;
    private boolean zzarn;
    private byte zzaro;
    private int zzarp;
    private int zzarq;
    private int zzarr;
    private boolean zzars;
    private boolean zzart;
    private zzkc zzaru;

    public zzkq() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzao(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzap(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void release() {
    }

    private zzkq(int i) {
        this(new zzkj(), 0);
    }

    private zzkq(zzko zzkoVar, int i) {
        this.zzaqm = -1L;
        this.zzaqn = -9223372036854775807L;
        this.zzaqo = -9223372036854775807L;
        this.zzaiz = -9223372036854775807L;
        this.zzaqu = -1L;
        this.zzaqv = -1L;
        this.zzaqw = -9223372036854775807L;
        this.zzapy = zzkoVar;
        zzkoVar.zza(new zzks(this, null));
        this.zzaqa = true;
        this.zzapm = new zzkt();
        this.zzapz = new SparseArray<>();
        this.zzaqd = new zzpn(4);
        this.zzaqe = new zzpn(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzaqf = new zzpn(4);
        this.zzaqb = new zzpn(zzpm.zzbkd);
        this.zzaqc = new zzpn(4);
        this.zzaqg = new zzpn();
        this.zzaqh = new zzpn();
        this.zzaqi = new zzpn(8);
        this.zzaqj = new zzpn();
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final boolean zza(zzjz zzjzVar) {
        return new zzku().zza(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar) {
        this.zzaru = zzkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zzc(long j, long j2) {
        this.zzaqw = -9223372036854775807L;
        this.zzara = 0;
        this.zzapy.reset();
        this.zzapm.reset();
        zzgy();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(zzjz zzjzVar, zzkg zzkgVar) {
        boolean z;
        this.zzars = false;
        boolean z2 = true;
        while (z2 && !this.zzars) {
            z2 = this.zzapy.zzb(zzjzVar);
            if (z2) {
                long position = zzjzVar.getPosition();
                if (this.zzaqt) {
                    this.zzaqv = position;
                    zzkgVar.position = this.zzaqu;
                    this.zzaqt = false;
                } else {
                    if (this.zzaqq) {
                        long j = this.zzaqv;
                        if (j != -1) {
                            zzkgVar.position = j;
                            this.zzaqv = -1L;
                        }
                    }
                    z = false;
                    if (!z) {
                        return 1;
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
        return z2 ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i, long j, long j2) {
        if (i == 160) {
            this.zzart = false;
        } else if (i == 174) {
            this.zzaqp = new zzkr(null);
        } else if (i == 187) {
            this.zzaqz = false;
        } else if (i == 19899) {
            this.zzaqr = -1;
            this.zzaqs = -1L;
        } else if (i == 20533) {
            this.zzaqp.zzarx = true;
        } else if (i == 21968) {
            this.zzaqp.zzase = true;
        } else if (i == 408125543) {
            long j3 = this.zzaqm;
            if (j3 != -1 && j3 != j) {
                throw new zzhw("Multiple Segment elements not supported");
            }
            this.zzaqm = j;
            this.zzaql = j2;
        } else if (i == 475249515) {
            this.zzaqx = new zzph();
            this.zzaqy = new zzph();
        } else if (i == 524531317 && !this.zzaqq) {
            if (this.zzaqa && this.zzaqu != -1) {
                this.zzaqt = true;
                return;
            }
            this.zzaru.zza(new zzki(this.zzaiz));
            this.zzaqq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaq(int i) {
        zzkf zzkiVar;
        zzph zzphVar;
        zzph zzphVar2;
        int i2;
        int i3 = 0;
        if (i == 160) {
            if (this.zzara != 2) {
                return;
            }
            if (!this.zzart) {
                this.zzari |= 1;
            }
            zza(this.zzapz.get(this.zzarg), this.zzarb);
            this.zzara = 0;
        } else if (i == 174) {
            String str = this.zzaqp.zzarv;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 1) != 0) {
                zzkr zzkrVar = this.zzaqp;
                zzkrVar.zza(this.zzaru, zzkrVar.number);
                this.zzapz.put(this.zzaqp.number, this.zzaqp);
            }
            this.zzaqp = null;
        } else if (i == 19899) {
            int i4 = this.zzaqr;
            if (i4 != -1) {
                long j = this.zzaqs;
                if (j != -1) {
                    if (i4 == 475249515) {
                        this.zzaqu = j;
                        return;
                    }
                    return;
                }
            }
            throw new zzhw("Mandatory element SeekID or SeekPosition not found");
        } else if (i == 25152) {
            if (this.zzaqp.zzarx) {
                if (this.zzaqp.zzarz == null) {
                    throw new zzhw("Encrypted Track found but ContentEncKeyID was not found");
                }
                this.zzaqp.zzahr = new zzjo(new zzjo.zza(zzhf.UUID_NIL, "video/webm", this.zzaqp.zzarz.zzaps));
            }
        } else if (i == 28032) {
            if (this.zzaqp.zzarx && this.zzaqp.zzary != null) {
                throw new zzhw("Combining encryption and compression is not supported");
            }
        } else if (i == 357149030) {
            if (this.zzaqn == -9223372036854775807L) {
                this.zzaqn = 1000000L;
            }
            long j2 = this.zzaqo;
            if (j2 != -9223372036854775807L) {
                this.zzaiz = zzea(j2);
            }
        } else if (i != 374648427) {
            if (i == 475249515 && !this.zzaqq) {
                zzkc zzkcVar = this.zzaru;
                if (this.zzaqm == -1 || this.zzaiz == -9223372036854775807L || (zzphVar = this.zzaqx) == null || zzphVar.size() == 0 || (zzphVar2 = this.zzaqy) == null || zzphVar2.size() != this.zzaqx.size()) {
                    this.zzaqx = null;
                    this.zzaqy = null;
                    zzkiVar = new zzki(this.zzaiz);
                } else {
                    int size = this.zzaqx.size();
                    int[] iArr = new int[size];
                    long[] jArr = new long[size];
                    long[] jArr2 = new long[size];
                    long[] jArr3 = new long[size];
                    for (int i5 = 0; i5 < size; i5++) {
                        jArr3[i5] = this.zzaqx.get(i5);
                        jArr[i5] = this.zzaqm + this.zzaqy.get(i5);
                    }
                    while (true) {
                        i2 = size - 1;
                        if (i3 >= i2) {
                            break;
                        }
                        int i6 = i3 + 1;
                        iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                        jArr2[i3] = jArr3[i6] - jArr3[i3];
                        i3 = i6;
                    }
                    iArr[i2] = (int) ((this.zzaqm + this.zzaql) - jArr[i2]);
                    jArr2[i2] = this.zzaiz - jArr3[i2];
                    this.zzaqx = null;
                    this.zzaqy = null;
                    zzkiVar = new zzjy(iArr, jArr, jArr2, jArr3);
                }
                zzkcVar.zza(zzkiVar);
                this.zzaqq = true;
            }
        } else if (this.zzapz.size() == 0) {
            throw new zzhw("No valid tracks were found");
        } else {
            this.zzaru.zzgw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i, long j) {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        } else if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw new zzhw(sb2.toString());
        } else {
            switch (i) {
                case 131:
                    this.zzaqp.type = (int) j;
                    return;
                case 136:
                    this.zzaqp.zzasx = j == 1;
                    return;
                case 155:
                    this.zzarc = zzea(j);
                    return;
                case 159:
                    this.zzaqp.zzahy = (int) j;
                    return;
                case 176:
                    this.zzaqp.width = (int) j;
                    return;
                case 179:
                    this.zzaqx.add(zzea(j));
                    return;
                case 186:
                    this.zzaqp.height = (int) j;
                    return;
                case 215:
                    this.zzaqp.number = (int) j;
                    return;
                case 231:
                    this.zzaqw = zzea(j);
                    return;
                case 241:
                    if (this.zzaqz) {
                        return;
                    }
                    this.zzaqy.add(j);
                    this.zzaqz = true;
                    return;
                case 251:
                    this.zzart = true;
                    return;
                case 16980:
                    if (j == 3) {
                        return;
                    }
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("ContentCompAlgo ");
                    sb3.append(j);
                    sb3.append(" not supported");
                    throw new zzhw(sb3.toString());
                case 17029:
                    if (j < 1 || j > 2) {
                        StringBuilder sb4 = new StringBuilder(53);
                        sb4.append("DocTypeReadVersion ");
                        sb4.append(j);
                        sb4.append(" not supported");
                        throw new zzhw(sb4.toString());
                    }
                    return;
                case 17143:
                    if (j == 1) {
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder(50);
                    sb5.append("EBMLReadVersion ");
                    sb5.append(j);
                    sb5.append(" not supported");
                    throw new zzhw(sb5.toString());
                case 18401:
                    if (j == 5) {
                        return;
                    }
                    StringBuilder sb6 = new StringBuilder(49);
                    sb6.append("ContentEncAlgo ");
                    sb6.append(j);
                    sb6.append(" not supported");
                    throw new zzhw(sb6.toString());
                case 18408:
                    if (j == 1) {
                        return;
                    }
                    StringBuilder sb7 = new StringBuilder(56);
                    sb7.append("AESSettingsCipherMode ");
                    sb7.append(j);
                    sb7.append(" not supported");
                    throw new zzhw(sb7.toString());
                case 21420:
                    this.zzaqs = j + this.zzaqm;
                    return;
                case 21432:
                    int i2 = (int) j;
                    if (i2 == 0) {
                        this.zzaqp.zzahv = 0;
                        return;
                    } else if (i2 == 1) {
                        this.zzaqp.zzahv = 2;
                        return;
                    } else if (i2 == 3) {
                        this.zzaqp.zzahv = 1;
                        return;
                    } else if (i2 != 15) {
                        return;
                    } else {
                        this.zzaqp.zzahv = 3;
                        return;
                    }
                case 21680:
                    this.zzaqp.zzasb = (int) j;
                    return;
                case 21682:
                    this.zzaqp.zzasd = (int) j;
                    return;
                case 21690:
                    this.zzaqp.zzasc = (int) j;
                    return;
                case 21930:
                    this.zzaqp.zzasy = j == 1;
                    return;
                case 22186:
                    this.zzaqp.zzasv = j;
                    return;
                case 22203:
                    this.zzaqp.zzasw = j;
                    return;
                case 25188:
                    this.zzaqp.zzasu = (int) j;
                    return;
                case 2352003:
                    this.zzaqp.zzarw = (int) j;
                    return;
                case 2807729:
                    this.zzaqn = j;
                    return;
                default:
                    switch (i) {
                        case 21945:
                            int i3 = (int) j;
                            if (i3 == 1) {
                                this.zzaqp.zzash = 2;
                                return;
                            } else if (i3 != 2) {
                                return;
                            } else {
                                this.zzaqp.zzash = 1;
                                return;
                            }
                        case 21946:
                            int i4 = (int) j;
                            if (i4 != 1) {
                                if (i4 == 16) {
                                    this.zzaqp.zzasg = 6;
                                    return;
                                } else if (i4 == 18) {
                                    this.zzaqp.zzasg = 7;
                                    return;
                                } else if (i4 != 6 && i4 != 7) {
                                    return;
                                }
                            }
                            this.zzaqp.zzasg = 3;
                            return;
                        case 21947:
                            this.zzaqp.zzase = true;
                            int i5 = (int) j;
                            if (i5 == 1) {
                                this.zzaqp.zzasf = 1;
                                return;
                            } else if (i5 == 9) {
                                this.zzaqp.zzasf = 6;
                                return;
                            } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                this.zzaqp.zzasf = 2;
                                return;
                            } else {
                                return;
                            }
                        case 21948:
                            this.zzaqp.zzasi = (int) j;
                            return;
                        case 21949:
                            this.zzaqp.zzasj = (int) j;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, double d2) {
        if (i == 181) {
            this.zzaqp.zzahz = (int) d2;
        } else if (i == 17545) {
            this.zzaqo = (long) d2;
        } else {
            switch (i) {
                case 21969:
                    this.zzaqp.zzask = (float) d2;
                    return;
                case 21970:
                    this.zzaqp.zzasl = (float) d2;
                    return;
                case 21971:
                    this.zzaqp.zzasm = (float) d2;
                    return;
                case 21972:
                    this.zzaqp.zzasn = (float) d2;
                    return;
                case 21973:
                    this.zzaqp.zzaso = (float) d2;
                    return;
                case 21974:
                    this.zzaqp.zzasp = (float) d2;
                    return;
                case 21975:
                    this.zzaqp.zzasq = (float) d2;
                    return;
                case 21976:
                    this.zzaqp.zzasr = (float) d2;
                    return;
                case 21977:
                    this.zzaqp.zzass = (float) d2;
                    return;
                case 21978:
                    this.zzaqp.zzast = (float) d2;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, String str) {
        if (i == 134) {
            this.zzaqp.zzarv = str;
        } else if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            zzkr.zza(this.zzaqp, str);
        } else if ("webm".equals(str) || "matroska".equals(str)) {
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01fc, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(int i, int i2, zzjz zzjzVar) {
        int i3;
        int i4;
        int[] iArr;
        int i5 = 4;
        int i6 = 0;
        int i7 = 1;
        if (i != 161 && i != 163) {
            if (i == 16981) {
                this.zzaqp.zzary = new byte[i2];
                zzjzVar.readFully(this.zzaqp.zzary, 0, i2);
                return;
            } else if (i == 18402) {
                byte[] bArr = new byte[i2];
                zzjzVar.readFully(bArr, 0, i2);
                this.zzaqp.zzarz = new zzkk(1, bArr);
                return;
            } else if (i == 21419) {
                Arrays.fill(this.zzaqf.data, (byte) 0);
                zzjzVar.readFully(this.zzaqf.data, 4 - i2, i2);
                this.zzaqf.zzbl(0);
                this.zzaqr = (int) this.zzaqf.zzjb();
                return;
            } else if (i == 25506) {
                this.zzaqp.zzasa = new byte[i2];
                zzjzVar.readFully(this.zzaqp.zzasa, 0, i2);
                return;
            } else if (i == 30322) {
                this.zzaqp.zzahw = new byte[i2];
                zzjzVar.readFully(this.zzaqp.zzahw, 0, i2);
                return;
            } else {
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unexpected id: ");
                sb.append(i);
                throw new zzhw(sb.toString());
            }
        }
        if (this.zzara == 0) {
            this.zzarg = (int) this.zzapm.zza(zzjzVar, false, true, 8);
            this.zzarh = this.zzapm.zzha();
            this.zzarc = -9223372036854775807L;
            this.zzara = 1;
            this.zzaqd.reset();
        }
        zzkr zzkrVar = this.zzapz.get(this.zzarg);
        if (zzkrVar == null) {
            zzjzVar.zzaj(i2 - this.zzarh);
            this.zzara = 0;
            return;
        }
        if (this.zzara == 1) {
            zzb(zzjzVar, 3);
            int i8 = (this.zzaqd.data[2] & 6) >> 1;
            byte b2 = 255;
            if (i8 == 0) {
                this.zzare = 1;
                int[] zza = zza(this.zzarf, 1);
                this.zzarf = zza;
                zza[0] = (i2 - this.zzarh) - 3;
            } else if (i != 163) {
                throw new zzhw("Lacing only supported in SimpleBlocks.");
            } else {
                zzb(zzjzVar, 4);
                int i9 = (this.zzaqd.data[3] & 255) + 1;
                this.zzare = i9;
                int[] zza2 = zza(this.zzarf, i9);
                this.zzarf = zza2;
                if (i8 == 2) {
                    int i10 = this.zzare;
                    Arrays.fill(zza2, 0, i10, ((i2 - this.zzarh) - 4) / i10);
                } else if (i8 == 1) {
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        i3 = this.zzare;
                        if (i11 >= i3 - 1) {
                            break;
                        }
                        this.zzarf[i11] = 0;
                        do {
                            i5++;
                            zzb(zzjzVar, i5);
                            i4 = this.zzaqd.data[i5 - 1] & 255;
                            iArr = this.zzarf;
                            iArr[i11] = iArr[i11] + i4;
                        } while (i4 == 255);
                        i12 += iArr[i11];
                        i11++;
                    }
                    this.zzarf[i3 - 1] = ((i2 - this.zzarh) - i5) - i12;
                } else if (i8 != 3) {
                    StringBuilder sb2 = new StringBuilder(36);
                    sb2.append("Unexpected lacing value: ");
                    sb2.append(i8);
                    throw new zzhw(sb2.toString());
                } else {
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        int i15 = this.zzare;
                        if (i13 < i15 - 1) {
                            this.zzarf[i13] = i6;
                            i5++;
                            zzb(zzjzVar, i5);
                            int i16 = i5 - 1;
                            if (this.zzaqd.data[i16] == 0) {
                                throw new zzhw("No valid varint length mask found");
                            }
                            long j = 0;
                            int i17 = 0;
                            while (true) {
                                if (i17 >= 8) {
                                    break;
                                }
                                int i18 = i7 << (7 - i17);
                                if ((this.zzaqd.data[i16] & i18) != 0) {
                                    i5 += i17;
                                    zzb(zzjzVar, i5);
                                    long j2 = this.zzaqd.data[i16] & b2 & (i18 ^ (-1));
                                    int i19 = i16 + 1;
                                    while (true) {
                                        j = j2;
                                        if (i19 >= i5) {
                                            break;
                                        }
                                        j2 = (j << 8) | (this.zzaqd.data[i19] & b2);
                                        i19++;
                                        b2 = 255;
                                    }
                                    if (i13 > 0) {
                                        j -= (1 << ((i17 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i17++;
                                    i7 = 1;
                                    b2 = 255;
                                }
                            }
                            long j3 = j;
                            if (j3 < -2147483648L || j3 > 2147483647L) {
                                break;
                            }
                            int i20 = (int) j3;
                            int[] iArr2 = this.zzarf;
                            if (i13 != 0) {
                                i20 += iArr2[i13 - 1];
                            }
                            iArr2[i13] = i20;
                            i14 += this.zzarf[i13];
                            i13++;
                            i6 = 0;
                            i7 = 1;
                            b2 = 255;
                        } else {
                            this.zzarf[i15 - 1] = ((i2 - this.zzarh) - i5) - i14;
                            break;
                        }
                    }
                }
            }
            this.zzarb = this.zzaqw + zzea((this.zzaqd.data[0] << 8) | (this.zzaqd.data[1] & 255));
            this.zzari = ((this.zzaqd.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0) | ((zzkrVar.type == 2 || (i == 163 && (this.zzaqd.data[2] & 128) == 128)) ? 1 : 0);
            this.zzara = 2;
            this.zzard = 0;
        }
        if (i != 163) {
            zza(zzjzVar, zzkrVar, this.zzarf[0]);
            return;
        }
        while (true) {
            int i21 = this.zzard;
            if (i21 < this.zzare) {
                zza(zzjzVar, zzkrVar, this.zzarf[i21]);
                zza(zzkrVar, this.zzarb + ((this.zzard * zzkrVar.zzarw) / 1000));
                this.zzard++;
            } else {
                this.zzara = 0;
                return;
            }
        }
    }

    private final void zza(zzkr zzkrVar, long j) {
        int i;
        byte[] zzbg;
        if ("S_TEXT/UTF8".equals(zzkrVar.zzarv)) {
            byte[] bArr = this.zzaqh.data;
            long j2 = this.zzarc;
            if (j2 == -9223372036854775807L) {
                zzbg = zzapw;
            } else {
                int i2 = (int) (j2 / 3600000000L);
                long j3 = j2 - (i2 * 3600000000L);
                int i3 = (int) (j3 / 60000000);
                long j4 = j3 - (60000000 * i3);
                zzbg = zzpt.zzbg(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) (j4 / 1000000)), Integer.valueOf((int) ((j4 - (1000000 * i)) / 1000))));
            }
            System.arraycopy(zzbg, 0, bArr, 19, 12);
            zzkh zzkhVar = zzkrVar.zzasz;
            zzpn zzpnVar = this.zzaqh;
            zzkhVar.zza(zzpnVar, zzpnVar.limit());
            this.zzarr += this.zzaqh.limit();
        }
        zzkrVar.zzasz.zza(j, this.zzari, this.zzarr, 0, zzkrVar.zzarz);
        this.zzars = true;
        zzgy();
    }

    private final void zzgy() {
        this.zzarj = 0;
        this.zzarr = 0;
        this.zzarq = 0;
        this.zzark = false;
        this.zzarl = false;
        this.zzarn = false;
        this.zzarp = 0;
        this.zzaro = (byte) 0;
        this.zzarm = false;
        this.zzaqg.reset();
    }

    private final void zzb(zzjz zzjzVar, int i) {
        if (this.zzaqd.limit() >= i) {
            return;
        }
        if (this.zzaqd.capacity() < i) {
            zzpn zzpnVar = this.zzaqd;
            zzpnVar.zzc(Arrays.copyOf(zzpnVar.data, Math.max(this.zzaqd.data.length << 1, i)), this.zzaqd.limit());
        }
        zzjzVar.readFully(this.zzaqd.data, this.zzaqd.limit(), i - this.zzaqd.limit());
        this.zzaqd.zzbk(i);
    }

    private final void zza(zzjz zzjzVar, zzkr zzkrVar, int i) {
        int i2;
        if ("S_TEXT/UTF8".equals(zzkrVar.zzarv)) {
            int length = zzapv.length + i;
            if (this.zzaqh.capacity() < length) {
                this.zzaqh.data = Arrays.copyOf(zzapv, length + i);
            }
            zzjzVar.readFully(this.zzaqh.data, zzapv.length, i);
            this.zzaqh.zzbl(0);
            this.zzaqh.zzbk(length);
            return;
        }
        zzkh zzkhVar = zzkrVar.zzasz;
        if (!this.zzark) {
            if (zzkrVar.zzarx) {
                this.zzari &= -1073741825;
                if (!this.zzarl) {
                    zzjzVar.readFully(this.zzaqd.data, 0, 1);
                    this.zzarj++;
                    if ((this.zzaqd.data[0] & 128) == 128) {
                        throw new zzhw("Extension bit is set in signal byte");
                    }
                    this.zzaro = this.zzaqd.data[0];
                    this.zzarl = true;
                }
                byte b2 = this.zzaro;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.zzari |= 1073741824;
                    if (!this.zzarm) {
                        zzjzVar.readFully(this.zzaqi.data, 0, 8);
                        this.zzarj += 8;
                        this.zzarm = true;
                        this.zzaqd.data[0] = (byte) ((z ? 128 : 0) | 8);
                        this.zzaqd.zzbl(0);
                        zzkhVar.zza(this.zzaqd, 1);
                        this.zzarr++;
                        this.zzaqi.zzbl(0);
                        zzkhVar.zza(this.zzaqi, 8);
                        this.zzarr += 8;
                    }
                    if (z) {
                        if (!this.zzarn) {
                            zzjzVar.readFully(this.zzaqd.data, 0, 1);
                            this.zzarj++;
                            this.zzaqd.zzbl(0);
                            this.zzarp = this.zzaqd.readUnsignedByte();
                            this.zzarn = true;
                        }
                        int i3 = this.zzarp << 2;
                        this.zzaqd.reset(i3);
                        zzjzVar.readFully(this.zzaqd.data, 0, i3);
                        this.zzarj += i3;
                        short s = (short) ((this.zzarp / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzaqk;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.zzaqk = ByteBuffer.allocate(i4);
                        }
                        this.zzaqk.position(0);
                        this.zzaqk.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.zzarp;
                            if (i5 >= i2) {
                                break;
                            }
                            int zzje = this.zzaqd.zzje();
                            if (i5 % 2 == 0) {
                                this.zzaqk.putShort((short) (zzje - i6));
                            } else {
                                this.zzaqk.putInt(zzje - i6);
                            }
                            i5++;
                            i6 = zzje;
                        }
                        int i7 = (i - this.zzarj) - i6;
                        if (i2 % 2 == 1) {
                            this.zzaqk.putInt(i7);
                        } else {
                            this.zzaqk.putShort((short) i7);
                            this.zzaqk.putInt(0);
                        }
                        this.zzaqj.zzc(this.zzaqk.array(), i4);
                        zzkhVar.zza(this.zzaqj, i4);
                        this.zzarr += i4;
                    }
                }
            } else if (zzkrVar.zzary != null) {
                this.zzaqg.zzc(zzkrVar.zzary, zzkrVar.zzary.length);
            }
            this.zzark = true;
        }
        int limit = i + this.zzaqg.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzkrVar.zzarv) && !"V_MPEGH/ISO/HEVC".equals(zzkrVar.zzarv)) {
            while (true) {
                int i8 = this.zzarj;
                if (i8 >= limit) {
                    break;
                }
                zza(zzjzVar, zzkhVar, limit - i8);
            }
        } else {
            byte[] bArr = this.zzaqc.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i9 = zzkrVar.zzata;
            int i10 = 4 - zzkrVar.zzata;
            while (this.zzarj < limit) {
                int i11 = this.zzarq;
                if (i11 == 0) {
                    int min = Math.min(i9, this.zzaqg.zziz());
                    zzjzVar.readFully(bArr, i10 + min, i9 - min);
                    if (min > 0) {
                        this.zzaqg.zze(bArr, i10, min);
                    }
                    this.zzarj += i9;
                    this.zzaqc.zzbl(0);
                    this.zzarq = this.zzaqc.zzje();
                    this.zzaqb.zzbl(0);
                    zzkhVar.zza(this.zzaqb, 4);
                    this.zzarr += 4;
                } else {
                    this.zzarq = i11 - zza(zzjzVar, zzkhVar, i11);
                }
            }
        }
        if ("A_VORBIS".equals(zzkrVar.zzarv)) {
            this.zzaqe.zzbl(0);
            zzkhVar.zza(this.zzaqe, 4);
            this.zzarr += 4;
        }
    }

    private final int zza(zzjz zzjzVar, zzkh zzkhVar, int i) {
        int zza;
        int zziz = this.zzaqg.zziz();
        if (zziz > 0) {
            zza = Math.min(i, zziz);
            zzkhVar.zza(this.zzaqg, zza);
        } else {
            zza = zzkhVar.zza(zzjzVar, i, false);
        }
        this.zzarj += zza;
        this.zzarr += zza;
        return zza;
    }

    private final long zzea(long j) {
        long j2 = this.zzaqn;
        if (j2 == -9223372036854775807L) {
            throw new zzhw("Can't scale timecode prior to timecodeScale being set.");
        }
        return zzpt.zza(j, j2, 1000L);
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }
}
