package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.recyclerview.widget.l;
import com.just.agentweb.WebIndicator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzkr {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzjo zzahr;
    public int zzahv;
    public byte[] zzahw;
    public int zzahy;
    public int zzahz;
    private String zzaif;
    public String zzarv;
    public int zzarw;
    public boolean zzarx;
    public byte[] zzary;
    public zzkk zzarz;
    public byte[] zzasa;
    public int zzasb;
    public int zzasc;
    public int zzasd;
    public boolean zzase;
    public int zzasf;
    public int zzasg;
    public int zzash;
    public int zzasi;
    public int zzasj;
    public float zzask;
    public float zzasl;
    public float zzasm;
    public float zzasn;
    public float zzaso;
    public float zzasp;
    public float zzasq;
    public float zzasr;
    public float zzass;
    public float zzast;
    public int zzasu;
    public long zzasv;
    public long zzasw;
    public boolean zzasx;
    public boolean zzasy;
    public zzkh zzasz;
    public int zzata;

    private zzkr() {
        this.width = -1;
        this.height = -1;
        this.zzasb = -1;
        this.zzasc = -1;
        this.zzasd = 0;
        this.zzahw = null;
        this.zzahv = -1;
        this.zzase = false;
        this.zzasf = -1;
        this.zzasg = -1;
        this.zzash = -1;
        this.zzasi = 1000;
        this.zzasj = l.a.DEFAULT_DRAG_ANIMATION_DURATION;
        this.zzask = -1.0f;
        this.zzasl = -1.0f;
        this.zzasm = -1.0f;
        this.zzasn = -1.0f;
        this.zzaso = -1.0f;
        this.zzasp = -1.0f;
        this.zzasq = -1.0f;
        this.zzasr = -1.0f;
        this.zzass = -1.0f;
        this.zzast = -1.0f;
        this.zzahy = 1;
        this.zzasu = -1;
        this.zzahz = WebIndicator.MAX_UNIFORM_SPEED_DURATION;
        this.zzasv = 0L;
        this.zzasw = 0L;
        this.zzasy = true;
        this.zzaif = "eng";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:364:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x034f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzkc zzkcVar, int i) {
        char c2;
        String str;
        List<byte[]> singletonList;
        String str2;
        List<byte[]> list;
        int i2;
        int i3;
        List<byte[]> singletonList2;
        String str3;
        String str4;
        String str5;
        int zzbr;
        zzht zza;
        int i4;
        int i5;
        zzpy zzpyVar;
        byte[] bArr;
        int i6;
        String str6 = this.zzarv;
        switch (str6.hashCode()) {
            case -2095576542:
                if (str6.equals("V_MPEG4/ISO/AP")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -2095575984:
                if (str6.equals("V_MPEG4/ISO/SP")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1985379776:
                if (str6.equals("A_MS/ACM")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case -1784763192:
                if (str6.equals("A_TRUEHD")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case -1730367663:
                if (str6.equals("A_VORBIS")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -1482641358:
                if (str6.equals("A_MPEG/L2")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case -1482641357:
                if (str6.equals("A_MPEG/L3")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case -1373388978:
                if (str6.equals("V_MS/VFW/FOURCC")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -933872740:
                if (str6.equals("S_DVBSUB")) {
                    c2 = 27;
                    break;
                }
                c2 = 65535;
                break;
            case -538363189:
                if (str6.equals("V_MPEG4/ISO/ASP")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -538363109:
                if (str6.equals("V_MPEG4/ISO/AVC")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -425012669:
                if (str6.equals("S_VOBSUB")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            case -356037306:
                if (str6.equals("A_DTS/LOSSLESS")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 62923557:
                if (str6.equals("A_AAC")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 62923603:
                if (str6.equals("A_AC3")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 62927045:
                if (str6.equals("A_DTS")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 82338133:
                if (str6.equals("V_VP8")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 82338134:
                if (str6.equals("V_VP9")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 99146302:
                if (str6.equals("S_HDMV/PGS")) {
                    c2 = 26;
                    break;
                }
                c2 = 65535;
                break;
            case 444813526:
                if (str6.equals("V_THEORA")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 542569478:
                if (str6.equals("A_DTS/EXPRESS")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 725957860:
                if (str6.equals("A_PCM/INT/LIT")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case 855502857:
                if (str6.equals("V_MPEGH/ISO/HEVC")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1422270023:
                if (str6.equals("S_TEXT/UTF8")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case 1809237540:
                if (str6.equals("V_MPEG2")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1950749482:
                if (str6.equals("A_EAC3")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case 1950789798:
                if (str6.equals("A_FLAC")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 1951062397:
                if (str6.equals("A_OPUS")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                str = "video/x-vnd.on2.vp8";
                list = null;
                i2 = -1;
                i3 = -1;
                int i7 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                    zza = zzht.zza(Integer.toString(i), str, null, -1, i3, this.zzahy, this.zzahz, i2, list, this.zzahr, i7, this.zzaif);
                    i4 = 1;
                } else if (zzpj.zzbd(str)) {
                    if (this.zzasd == 0) {
                        int i8 = this.zzasb;
                        if (i8 == -1) {
                            i8 = this.width;
                        }
                        this.zzasb = i8;
                        int i9 = this.zzasc;
                        if (i9 == -1) {
                            i9 = this.height;
                        }
                        this.zzasc = i9;
                    }
                    float f = (this.zzasb == -1 || (i6 = this.zzasc) == -1) ? -1.0f : (this.height * i5) / (this.width * i6);
                    if (this.zzase) {
                        if (this.zzask == -1.0f || this.zzasl == -1.0f || this.zzasm == -1.0f || this.zzasn == -1.0f || this.zzaso == -1.0f || this.zzasp == -1.0f || this.zzasq == -1.0f || this.zzasr == -1.0f || this.zzass == -1.0f || this.zzast == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer wrap = ByteBuffer.wrap(bArr);
                            wrap.put((byte) 0);
                            wrap.putShort((short) ((this.zzask * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.zzasl * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.zzasm * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.zzasn * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.zzaso * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.zzasp * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.zzasq * 50000.0f) + 0.5f));
                            wrap.putShort((short) ((this.zzasr * 50000.0f) + 0.5f));
                            wrap.putShort((short) (this.zzass + 0.5f));
                            wrap.putShort((short) (this.zzast + 0.5f));
                            wrap.putShort((short) this.zzasi);
                            wrap.putShort((short) this.zzasj);
                        }
                        zzpyVar = new zzpy(this.zzasf, this.zzash, this.zzasg, bArr);
                    } else {
                        zzpyVar = null;
                    }
                    zza = zzht.zza(Integer.toString(i), str, null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.zzahw, this.zzahv, zzpyVar, this.zzahr);
                    i4 = 2;
                } else {
                    if ("application/x-subrip".equals(str)) {
                        zza = zzht.zza(Integer.toString(i), str, (String) null, -1, i7, this.zzaif, this.zzahr);
                    } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
                        zza = zzht.zza(Integer.toString(i), str, (String) null, -1, list, this.zzaif, this.zzahr);
                    } else {
                        throw new zzhw("Unexpected MIME type.");
                    }
                    i4 = 3;
                }
                zzkh zze = zzkcVar.zze(this.number, i4);
                this.zzasz = zze;
                zze.zze(zza);
                return;
            case 1:
                str = "video/x-vnd.on2.vp9";
                list = null;
                i2 = -1;
                i3 = -1;
                int i72 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2;
                zze2.zze(zza);
                return;
            case 2:
                str = "video/mpeg2";
                list = null;
                i2 = -1;
                i3 = -1;
                int i722 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22;
                zze22.zze(zza);
                return;
            case 3:
            case 4:
            case 5:
                byte[] bArr2 = this.zzasa;
                singletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str2 = "video/mp4v-es";
                i2 = -1;
                i3 = -1;
                String str7 = str2;
                list = singletonList;
                str = str7;
                int i7222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222;
                zze222.zze(zza);
                return;
            case 6:
                zzpv zzg = zzpv.zzg(new zzpn(this.zzasa));
                list = zzg.zzahq;
                this.zzata = zzg.zzata;
                str = "video/avc";
                i2 = -1;
                i3 = -1;
                int i72222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2222;
                zze2222.zze(zza);
                return;
            case 7:
                zzqb zzi = zzqb.zzi(new zzpn(this.zzasa));
                list = zzi.zzahq;
                this.zzata = zzi.zzata;
                str = "video/hevc";
                i2 = -1;
                i3 = -1;
                int i722222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22222;
                zze22222.zze(zza);
                return;
            case '\b':
                singletonList = zza(new zzpn(this.zzasa));
                if (singletonList == null) {
                    Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    list = singletonList;
                    str = "video/x-unknown";
                    i2 = -1;
                    i3 = -1;
                    int i7222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                    if (!zzpj.zzbc(str)) {
                    }
                    zzkh zze222222 = zzkcVar.zze(this.number, i4);
                    this.zzasz = zze222222;
                    zze222222.zze(zza);
                    return;
                }
                str2 = "video/wvc1";
                i2 = -1;
                i3 = -1;
                String str72 = str2;
                list = singletonList;
                str = str72;
                int i72222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2222222;
                zze2222222.zze(zza);
                return;
            case '\t':
                str = "video/x-unknown";
                list = null;
                i2 = -1;
                i3 = -1;
                int i722222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22222222;
                zze22222222.zze(zza);
                return;
            case '\n':
                singletonList = zzd(this.zzasa);
                str2 = "audio/vorbis";
                i2 = -1;
                i3 = 8192;
                String str722 = str2;
                list = singletonList;
                str = str722;
                int i7222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222222222;
                zze222222222.zze(zza);
                return;
            case 11:
                singletonList = new ArrayList<>(3);
                singletonList.add(this.zzasa);
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzasv).array());
                singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzasw).array());
                str2 = "audio/opus";
                i2 = -1;
                i3 = 5760;
                String str7222 = str2;
                list = singletonList;
                str = str7222;
                int i72222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2222222222;
                zze2222222222.zze(zza);
                return;
            case '\f':
                singletonList2 = Collections.singletonList(this.zzasa);
                str3 = "audio/mp4a-latm";
                list = singletonList2;
                str = str3;
                i2 = -1;
                i3 = -1;
                int i722222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22222222222;
                zze22222222222.zze(zza);
                return;
            case '\r':
                str4 = "audio/mpeg-L2";
                str = str4;
                list = null;
                i2 = -1;
                i3 = 4096;
                int i7222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222222222222;
                zze222222222222.zze(zza);
                return;
            case 14:
                str4 = "audio/mpeg";
                str = str4;
                list = null;
                i2 = -1;
                i3 = 4096;
                int i72222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2222222222222;
                zze2222222222222.zze(zza);
                return;
            case 15:
                str5 = "audio/ac3";
                str = str5;
                list = null;
                i2 = -1;
                i3 = -1;
                int i722222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22222222222222;
                zze22222222222222.zze(zza);
                return;
            case 16:
                str5 = "audio/eac3";
                str = str5;
                list = null;
                i2 = -1;
                i3 = -1;
                int i7222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222222222222222;
                zze222222222222222.zze(zza);
                return;
            case 17:
                str5 = "audio/true-hd";
                str = str5;
                list = null;
                i2 = -1;
                i3 = -1;
                int i72222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2222222222222222;
                zze2222222222222222.zze(zza);
                return;
            case 18:
            case 19:
                str5 = "audio/vnd.dts";
                str = str5;
                list = null;
                i2 = -1;
                i3 = -1;
                int i722222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22222222222222222;
                zze22222222222222222.zze(zza);
                return;
            case 20:
                str5 = "audio/vnd.dts.hd";
                str = str5;
                list = null;
                i2 = -1;
                i3 = -1;
                int i7222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222222222222222222;
                zze222222222222222222.zze(zza);
                return;
            case 21:
                singletonList2 = Collections.singletonList(this.zzasa);
                str3 = "audio/x-flac";
                list = singletonList2;
                str = str3;
                i2 = -1;
                i3 = -1;
                int i72222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2222222222222222222;
                zze2222222222222222222.zze(zza);
                return;
            case 22:
                if (zzb(new zzpn(this.zzasa))) {
                    zzbr = zzpt.zzbr(this.zzasu);
                    if (zzbr == 0) {
                        int i10 = this.zzasu;
                        StringBuilder sb = new StringBuilder("audio/x-unknown".length() + 60);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i10);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb.toString());
                    }
                    i2 = zzbr;
                    str = "audio/raw";
                    list = null;
                    i3 = -1;
                    int i722222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                    if (!zzpj.zzbc(str)) {
                    }
                    zzkh zze22222222222222222222 = zzkcVar.zze(this.number, i4);
                    this.zzasz = zze22222222222222222222;
                    zze22222222222222222222.zze(zza);
                    return;
                }
                Log.w("MatroskaExtractor", "audio/x-unknown".length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown") : new String("Non-PCM MS/ACM is unsupported. Setting mimeType to "));
                str = "audio/x-unknown";
                list = null;
                i2 = -1;
                i3 = -1;
                int i7222222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222222222222222222222;
                zze222222222222222222222.zze(zza);
                return;
            case 23:
                zzbr = zzpt.zzbr(this.zzasu);
                if (zzbr == 0) {
                    int i11 = this.zzasu;
                    StringBuilder sb2 = new StringBuilder("audio/x-unknown".length() + 60);
                    sb2.append("Unsupported PCM bit depth: ");
                    sb2.append(i11);
                    sb2.append(". Setting mimeType to ");
                    sb2.append("audio/x-unknown");
                    Log.w("MatroskaExtractor", sb2.toString());
                    str = "audio/x-unknown";
                    list = null;
                    i2 = -1;
                    i3 = -1;
                    int i72222222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                    if (!zzpj.zzbc(str)) {
                    }
                    zzkh zze2222222222222222222222 = zzkcVar.zze(this.number, i4);
                    this.zzasz = zze2222222222222222222222;
                    zze2222222222222222222222.zze(zza);
                    return;
                }
                i2 = zzbr;
                str = "audio/raw";
                list = null;
                i3 = -1;
                int i722222222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22222222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22222222222222222222222;
                zze22222222222222222222222.zze(zza);
                return;
            case 24:
                str = "application/x-subrip";
                list = null;
                i2 = -1;
                i3 = -1;
                int i7222222222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222222222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222222222222222222222222;
                zze222222222222222222222222.zze(zza);
                return;
            case 25:
                list = Collections.singletonList(this.zzasa);
                str = "application/vobsub";
                i2 = -1;
                i3 = -1;
                int i72222222222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze2222222222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze2222222222222222222222222;
                zze2222222222222222222222222.zze(zza);
                return;
            case 26:
                str = "application/pgs";
                list = null;
                i2 = -1;
                i3 = -1;
                int i722222222222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze22222222222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze22222222222222222222222222;
                zze22222222222222222222222222.zze(zza);
                return;
            case 27:
                byte[] bArr3 = this.zzasa;
                list = Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                str = "application/dvbsubs";
                i2 = -1;
                i3 = -1;
                int i7222222222222222222222222222 = (this.zzasy ? 1 : 0) | 0 | (!this.zzasx ? 2 : 0);
                if (!zzpj.zzbc(str)) {
                }
                zzkh zze222222222222222222222222222 = zzkcVar.zze(this.number, i4);
                this.zzasz = zze222222222222222222222222222;
                zze222222222222222222222222222.zze(zza);
                return;
            default:
                throw new zzhw("Unrecognized codec identifier.");
        }
    }

    private static List<byte[]> zza(zzpn zzpnVar) {
        try {
            zzpnVar.zzbm(16);
            if (zzpnVar.zzjc() != 826496599) {
                return null;
            }
            byte[] bArr = zzpnVar.data;
            for (int position = zzpnVar.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhw("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) {
        try {
            if (bArr[0] != 2) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            int i = 1;
            int i2 = 0;
            while (bArr[i] == -1) {
                i2 += 255;
                i++;
            }
            int i3 = i + 1;
            int i4 = i2 + bArr[i];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing vorbis codec private");
        }
    }

    private static boolean zzb(zzpn zzpnVar) {
        UUID uuid;
        UUID uuid2;
        try {
            int zzja = zzpnVar.zzja();
            if (zzja == 1) {
                return true;
            }
            if (zzja == 65534) {
                zzpnVar.zzbl(24);
                long readLong = zzpnVar.readLong();
                uuid = zzkq.zzapx;
                if (readLong == uuid.getMostSignificantBits()) {
                    long readLong2 = zzpnVar.readLong();
                    uuid2 = zzkq.zzapx;
                    if (readLong2 == uuid2.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing MS/ACM codec private");
        }
    }

    public /* synthetic */ zzkr(zzkp zzkpVar) {
        this();
    }

    public static /* synthetic */ String zza(zzkr zzkrVar, String str) {
        zzkrVar.zzaif = str;
        return str;
    }
}
