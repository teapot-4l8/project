package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzit {
    private static boolean zzakb = false;
    private static boolean zzakc = false;
    private int streamType;
    private zzhz zzafp;
    private int zzahz;
    private final zzja zzake;
    private final zzjj zzakf;
    private final zzij[] zzakg;
    private final zziz zzakh;
    private final long[] zzakj;
    private final zziv zzakk;
    private final LinkedList<zziy> zzakl;
    private AudioTrack zzakm;
    private int zzakn;
    private int zzako;
    private int zzakp;
    private boolean zzakq;
    private int zzakr;
    private long zzaks;
    private zzhz zzakt;
    private long zzaku;
    private long zzakv;
    private ByteBuffer zzakw;
    private int zzakx;
    private int zzaky;
    private int zzakz;
    private long zzala;
    private long zzalb;
    private boolean zzalc;
    private long zzald;
    private Method zzale;
    private int zzalf;
    private long zzalg;
    private long zzalh;
    private int zzali;
    private long zzalj;
    private long zzalk;
    private int zzall;
    private int zzalm;
    private long zzaln;
    private long zzalo;
    private long zzalp;
    private zzij[] zzalq;
    private ByteBuffer[] zzalr;
    private ByteBuffer zzals;
    private ByteBuffer zzalt;
    private byte[] zzalu;
    private int zzalv;
    private int zzalw;
    private boolean zzalx;
    private boolean zzaly;
    private int zzalz;
    private boolean zzama;
    private boolean zzamb;
    private long zzamc;
    private float zzdi;
    private final zzig zzakd = null;
    private final ConditionVariable zzaki = new ConditionVariable(true);

    public zzit(zzig zzigVar, zzij[] zzijVarArr, zziz zzizVar) {
        this.zzakh = zzizVar;
        if (zzpt.SDK_INT >= 18) {
            try {
                this.zzale = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpt.SDK_INT >= 19) {
            this.zzakk = new zziu();
        } else {
            this.zzakk = new zziv(null);
        }
        this.zzake = new zzja();
        this.zzakf = new zzjj();
        zzij[] zzijVarArr2 = new zzij[zzijVarArr.length + 3];
        this.zzakg = zzijVarArr2;
        zzijVarArr2[0] = new zzjh();
        zzij[] zzijVarArr3 = this.zzakg;
        zzijVarArr3[1] = this.zzake;
        System.arraycopy(zzijVarArr, 0, zzijVarArr3, 2, zzijVarArr.length);
        this.zzakg[zzijVarArr.length + 2] = this.zzakf;
        this.zzakj = new long[10];
        this.zzdi = 1.0f;
        this.zzalm = 0;
        this.streamType = 3;
        this.zzalz = 0;
        this.zzafp = zzhz.zzaik;
        this.zzalw = -1;
        this.zzalq = new zzij[0];
        this.zzalr = new ByteBuffer[0];
        this.zzakl = new LinkedList<>();
    }

    public final long zzk(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        Method method;
        if (isInitialized() && this.zzalm != 0) {
            if (this.zzakm.getPlayState() == 3) {
                long zzgg = this.zzakk.zzgg();
                if (zzgg != 0) {
                    long nanoTime = System.nanoTime() / 1000;
                    if (nanoTime - this.zzalb >= 30000) {
                        long[] jArr = this.zzakj;
                        int i = this.zzaky;
                        jArr[i] = zzgg - nanoTime;
                        this.zzaky = (i + 1) % 10;
                        int i2 = this.zzakz;
                        if (i2 < 10) {
                            this.zzakz = i2 + 1;
                        }
                        this.zzalb = nanoTime;
                        this.zzala = 0L;
                        int i3 = 0;
                        while (true) {
                            int i4 = this.zzakz;
                            if (i3 >= i4) {
                                break;
                            }
                            this.zzala += this.zzakj[i3] / i4;
                            i3++;
                        }
                    }
                    if (!zzgb() && nanoTime - this.zzald >= 500000) {
                        boolean zzgc = this.zzakk.zzgc();
                        this.zzalc = zzgc;
                        if (zzgc) {
                            long zzgd = this.zzakk.zzgd() / 1000;
                            long zzge = this.zzakk.zzge();
                            if (zzgd < this.zzalo) {
                                this.zzalc = false;
                            } else if (Math.abs(zzgd - nanoTime) > 5000000) {
                                StringBuilder sb = new StringBuilder(136);
                                sb.append("Spurious audio timestamp (system clock mismatch): ");
                                sb.append(zzge);
                                sb.append(", ");
                                sb.append(zzgd);
                                sb.append(", ");
                                sb.append(nanoTime);
                                sb.append(", ");
                                sb.append(zzgg);
                                Log.w("AudioTrack", sb.toString());
                                this.zzalc = false;
                            } else if (Math.abs(zzdw(zzge) - zzgg) > 5000000) {
                                StringBuilder sb2 = new StringBuilder(138);
                                sb2.append("Spurious audio timestamp (frame position mismatch): ");
                                sb2.append(zzge);
                                sb2.append(", ");
                                sb2.append(zzgd);
                                sb2.append(", ");
                                sb2.append(nanoTime);
                                sb2.append(", ");
                                sb2.append(zzgg);
                                Log.w("AudioTrack", sb2.toString());
                                this.zzalc = false;
                            }
                        }
                        if (this.zzale != null && !this.zzakq) {
                            try {
                                long intValue = (((Integer) method.invoke(this.zzakm, null)).intValue() * 1000) - this.zzaks;
                                this.zzalp = intValue;
                                long max = Math.max(intValue, 0L);
                                this.zzalp = max;
                                if (max > 5000000) {
                                    StringBuilder sb3 = new StringBuilder(61);
                                    sb3.append("Ignoring impossibly large audio latency: ");
                                    sb3.append(max);
                                    Log.w("AudioTrack", sb3.toString());
                                    this.zzalp = 0L;
                                }
                            } catch (Exception unused) {
                                this.zzale = null;
                            }
                        }
                        this.zzald = nanoTime;
                    }
                }
            }
            long nanoTime2 = System.nanoTime() / 1000;
            if (this.zzalc) {
                j = zzdw(this.zzakk.zzge() + zzdx(nanoTime2 - (this.zzakk.zzgd() / 1000)));
            } else {
                if (this.zzakz == 0) {
                    j = this.zzakk.zzgg();
                } else {
                    j = nanoTime2 + this.zzala;
                }
                if (!z) {
                    j -= this.zzalp;
                }
            }
            long j5 = this.zzaln;
            while (!this.zzakl.isEmpty() && j >= zziy.zzb(this.zzakl.getFirst())) {
                zziy remove = this.zzakl.remove();
                this.zzafp = zziy.zza(remove);
                this.zzakv = zziy.zzb(remove);
                this.zzaku = zziy.zzc(remove) - this.zzaln;
            }
            if (this.zzafp.zzail == 1.0f) {
                j4 = (j + this.zzaku) - this.zzakv;
            } else {
                if (this.zzakl.isEmpty() && this.zzakf.zzgp() >= 1024) {
                    j2 = this.zzaku;
                    j3 = zzpt.zza(j - this.zzakv, this.zzakf.zzgo(), this.zzakf.zzgp());
                } else {
                    j2 = this.zzaku;
                    double d2 = this.zzafp.zzail;
                    double d3 = j - this.zzakv;
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    j3 = (long) (d2 * d3);
                }
                j4 = j3 + j2;
            }
            return j5 + j4;
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(String str, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        boolean z;
        int i6;
        int i7;
        int max;
        zzij[] zzijVarArr;
        boolean z2 = !"audio/raw".equals(str);
        if (z2) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1095064472:
                    if (str.equals("audio/vnd.dts")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 187078296:
                    if (str.equals("audio/ac3")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1504578661:
                    if (str.equals("audio/eac3")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1505942594:
                    if (str.equals("audio/vnd.dts.hd")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            i5 = c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? 0 : 8 : 7 : 6 : 5;
        } else {
            i5 = i3;
        }
        int i8 = i;
        if (z2) {
            z = false;
        } else {
            this.zzalf = zzpt.zzi(i3, i8);
            this.zzake.zzb(iArr);
            z = false;
            for (zzij zzijVar : this.zzakg) {
                try {
                    z |= zzijVar.zzb(i2, i8, i5);
                    if (zzijVar.isActive()) {
                        i8 = zzijVar.zzfn();
                        i5 = zzijVar.zzfo();
                    }
                } catch (zzii e2) {
                    throw new zzix(e2);
                }
            }
            if (z) {
                zzfr();
            }
        }
        int i9 = 12;
        switch (i8) {
            case 1:
                i6 = 4;
                break;
            case 2:
                i6 = 12;
                break;
            case 3:
                i6 = 28;
                break;
            case 4:
                i6 = 204;
                break;
            case 5:
                i6 = 220;
                break;
            case 6:
                i6 = 252;
                break;
            case 7:
                i6 = 1276;
                break;
            case 8:
                i6 = zzhf.CHANNEL_OUT_7POINT1_SURROUND;
                break;
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unsupported channel count: ");
                sb.append(i8);
                throw new zzix(sb.toString());
        }
        if (zzpt.SDK_INT <= 23 && "foster".equals(zzpt.DEVICE) && "NVIDIA".equals(zzpt.MANUFACTURER)) {
            if (i8 == 3 || i8 == 5) {
                i7 = 252;
            } else if (i8 == 7) {
                i7 = zzhf.CHANNEL_OUT_7POINT1_SURROUND;
            }
            if (zzpt.SDK_INT <= 25 || !"fugu".equals(zzpt.DEVICE) || !z2 || i8 != 1) {
                i9 = i7;
            }
            if (z && isInitialized() && this.zzako == i5 && this.zzahz == i2 && this.zzakn == i9) {
                return;
            }
            reset();
            this.zzako = i5;
            this.zzakq = z2;
            this.zzahz = i2;
            this.zzakn = i9;
            if (!z2) {
                i5 = 2;
            }
            this.zzakp = i5;
            this.zzali = zzpt.zzi(2, i8);
            if (!z2) {
                int i10 = this.zzakp;
                max = (i10 == 5 || i10 == 6) ? 20480 : 49152;
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i9, this.zzakp);
                zzpg.checkState(minBufferSize != -2);
                int i11 = minBufferSize << 2;
                int zzdx = this.zzali * ((int) zzdx(250000L));
                max = (int) Math.max(minBufferSize, zzdx(750000L) * this.zzali);
                if (i11 < zzdx) {
                    max = zzdx;
                } else if (i11 <= max) {
                    max = i11;
                }
            }
            this.zzakr = max;
            this.zzaks = !z2 ? -9223372036854775807L : zzdw(max / this.zzali);
            zzb(this.zzafp);
        }
        i7 = i6;
        if (zzpt.SDK_INT <= 25) {
        }
        i9 = i7;
        if (z) {
        }
        reset();
        this.zzako = i5;
        this.zzakq = z2;
        this.zzahz = i2;
        this.zzakn = i9;
        if (!z2) {
        }
        this.zzakp = i5;
        this.zzali = zzpt.zzi(2, i8);
        if (!z2) {
        }
        this.zzakr = max;
        this.zzaks = !z2 ? -9223372036854775807L : zzdw(max / this.zzali);
        zzb(this.zzafp);
    }

    private final void zzfr() {
        zzij[] zzijVarArr;
        ArrayList arrayList = new ArrayList();
        for (zzij zzijVar : this.zzakg) {
            if (zzijVar.isActive()) {
                arrayList.add(zzijVar);
            } else {
                zzijVar.flush();
            }
        }
        int size = arrayList.size();
        this.zzalq = (zzij[]) arrayList.toArray(new zzij[size]);
        this.zzalr = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzij zzijVar2 = this.zzalq[i];
            zzijVar2.flush();
            this.zzalr[i] = zzijVar2.zzfq();
        }
    }

    public final void play() {
        this.zzaly = true;
        if (isInitialized()) {
            this.zzalo = System.nanoTime() / 1000;
            this.zzakm.play();
        }
    }

    public final void zzfs() {
        if (this.zzalm == 1) {
            this.zzalm = 2;
        }
    }

    public final boolean zzb(ByteBuffer byteBuffer, long j) {
        int i;
        int zzo;
        ByteBuffer byteBuffer2 = this.zzals;
        zzpg.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            this.zzaki.block();
            if (this.zzama) {
                this.zzakm = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzakn).setEncoding(this.zzakp).setSampleRate(this.zzahz).build(), this.zzakr, 1, this.zzalz);
            } else if (this.zzalz == 0) {
                this.zzakm = new AudioTrack(this.streamType, this.zzahz, this.zzakn, this.zzakp, this.zzakr, 1);
            } else {
                this.zzakm = new AudioTrack(this.streamType, this.zzahz, this.zzakn, this.zzakp, this.zzakr, 1, this.zzalz);
            }
            int state = this.zzakm.getState();
            if (state != 1) {
                try {
                    this.zzakm.release();
                } catch (Exception unused) {
                } finally {
                    this.zzakm = null;
                }
                throw new zziw(state, this.zzahz, this.zzakn, this.zzakr);
            }
            int audioSessionId = this.zzakm.getAudioSessionId();
            if (this.zzalz != audioSessionId) {
                this.zzalz = audioSessionId;
                this.zzakh.zzaa(audioSessionId);
            }
            this.zzakk.zza(this.zzakm, zzgb());
            zzfy();
            this.zzamb = false;
            if (this.zzaly) {
                play();
            }
        }
        if (zzgb()) {
            if (this.zzakm.getPlayState() == 2) {
                this.zzamb = false;
                return false;
            } else if (this.zzakm.getPlayState() == 1 && this.zzakk.zzgf() != 0) {
                return false;
            }
        }
        boolean z = this.zzamb;
        boolean zzfv = zzfv();
        this.zzamb = zzfv;
        if (z && !zzfv && this.zzakm.getPlayState() != 1) {
            this.zzakh.zzc(this.zzakr, zzhf.zzdo(this.zzaks), SystemClock.elapsedRealtime() - this.zzamc);
        }
        if (this.zzals == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzakq && this.zzall == 0) {
                int i2 = this.zzakp;
                if (i2 == 7 || i2 == 8) {
                    zzo = zzjd.zzo(byteBuffer);
                } else if (i2 == 5) {
                    zzo = zzih.zzfm();
                } else if (i2 == 6) {
                    zzo = zzih.zzm(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i2);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzall = zzo;
            }
            if (this.zzakt != null) {
                if (!zzfu()) {
                    return false;
                }
                this.zzakl.add(new zziy(this.zzakt, Math.max(0L, j), zzdw(zzfz()), null));
                this.zzakt = null;
                zzfr();
            }
            if (this.zzalm == 0) {
                this.zzaln = Math.max(0L, j);
                this.zzalm = 1;
            } else {
                long zzdw = this.zzaln + zzdw(this.zzakq ? this.zzalh : this.zzalg / this.zzalf);
                if (this.zzalm != 1 || Math.abs(zzdw - j) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzdw);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzalm = 2;
                }
                if (this.zzalm == i) {
                    this.zzaln += j - zzdw;
                    this.zzalm = 1;
                    this.zzakh.zzen();
                }
            }
            if (this.zzakq) {
                this.zzalh += this.zzall;
            } else {
                this.zzalg += byteBuffer.remaining();
            }
            this.zzals = byteBuffer;
        }
        if (this.zzakq) {
            zzc(this.zzals, j);
        } else {
            zzdv(j);
        }
        if (this.zzals.hasRemaining()) {
            return false;
        }
        this.zzals = null;
        return true;
    }

    private final void zzdv(long j) {
        ByteBuffer byteBuffer;
        int length = this.zzalq.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzalr[i - 1];
            } else {
                byteBuffer = this.zzals;
                if (byteBuffer == null) {
                    byteBuffer = zzij.zzajm;
                }
            }
            if (i == length) {
                zzc(byteBuffer, j);
            } else {
                zzij zzijVar = this.zzalq[i];
                zzijVar.zzn(byteBuffer);
                ByteBuffer zzfq = zzijVar.zzfq();
                this.zzalr[i] = zzfq;
                if (zzfq.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i--;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d7, code lost:
        if (r11 < r10) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzc(ByteBuffer byteBuffer, long j) {
        int write;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzalt;
            if (byteBuffer2 != null) {
                zzpg.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.zzalt = byteBuffer;
                if (zzpt.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.zzalu;
                    if (bArr == null || bArr.length < remaining) {
                        this.zzalu = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.zzalu, 0, remaining);
                    byteBuffer.position(position);
                    this.zzalv = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (zzpt.SDK_INT < 21) {
                int zzgf = this.zzakr - ((int) (this.zzalj - (this.zzakk.zzgf() * this.zzali)));
                if (zzgf > 0) {
                    write = this.zzakm.write(this.zzalu, this.zzalv, Math.min(remaining2, zzgf));
                    if (write > 0) {
                        this.zzalv += write;
                        byteBuffer.position(byteBuffer.position() + write);
                    }
                }
                write = 0;
            } else if (this.zzama) {
                zzpg.checkState(j != -9223372036854775807L);
                AudioTrack audioTrack = this.zzakm;
                if (this.zzakw == null) {
                    ByteBuffer allocate = ByteBuffer.allocate(16);
                    this.zzakw = allocate;
                    allocate.order(ByteOrder.BIG_ENDIAN);
                    this.zzakw.putInt(1431633921);
                }
                if (this.zzakx == 0) {
                    this.zzakw.putInt(4, remaining2);
                    this.zzakw.putLong(8, j * 1000);
                    this.zzakw.position(0);
                    this.zzakx = remaining2;
                }
                int remaining3 = this.zzakw.remaining();
                if (remaining3 > 0) {
                    int write2 = audioTrack.write(this.zzakw, remaining3, 1);
                    if (write2 < 0) {
                        this.zzakx = 0;
                        write = write2;
                    }
                }
                int write3 = audioTrack.write(byteBuffer, remaining2, 1);
                if (write3 < 0) {
                    this.zzakx = 0;
                } else {
                    this.zzakx -= write3;
                }
                write = write3;
            } else {
                write = this.zzakm.write(byteBuffer, remaining2, 1);
            }
            this.zzamc = SystemClock.elapsedRealtime();
            if (write < 0) {
                throw new zzjb(write);
            }
            if (!this.zzakq) {
                this.zzalj += write;
            }
            if (write == remaining2) {
                if (this.zzakq) {
                    this.zzalk += this.zzall;
                }
                this.zzalt = null;
                return true;
            }
            return false;
        }
        return true;
    }

    public final void zzft() {
        if (!this.zzalx && isInitialized() && zzfu()) {
            this.zzakk.zzdy(zzfz());
            this.zzakx = 0;
            this.zzalx = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzfu() {
        boolean z;
        int i;
        zzij[] zzijVarArr;
        if (this.zzalw == -1) {
            this.zzalw = this.zzakq ? this.zzalq.length : 0;
            z = true;
            i = this.zzalw;
            zzijVarArr = this.zzalq;
            if (i < zzijVarArr.length) {
                zzij zzijVar = zzijVarArr[i];
                if (z) {
                    zzijVar.zzfp();
                }
                zzdv(-9223372036854775807L);
                if (!zzijVar.zzfi()) {
                    return false;
                }
                this.zzalw++;
                z = true;
                i = this.zzalw;
                zzijVarArr = this.zzalq;
                if (i < zzijVarArr.length) {
                    ByteBuffer byteBuffer = this.zzalt;
                    if (byteBuffer != null) {
                        zzc(byteBuffer, -9223372036854775807L);
                        if (this.zzalt != null) {
                            return false;
                        }
                    }
                    this.zzalw = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i = this.zzalw;
            zzijVarArr = this.zzalq;
            if (i < zzijVarArr.length) {
            }
        }
    }

    public final boolean zzfi() {
        if (isInitialized()) {
            return this.zzalx && !zzfv();
        }
        return true;
    }

    public final boolean zzfv() {
        if (isInitialized()) {
            if (zzfz() <= this.zzakk.zzgf()) {
                if (zzgb() && this.zzakm.getPlayState() == 2 && this.zzakm.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzhz zzb(zzhz zzhzVar) {
        if (this.zzakq) {
            zzhz zzhzVar2 = zzhz.zzaik;
            this.zzafp = zzhzVar2;
            return zzhzVar2;
        }
        zzhz zzhzVar3 = new zzhz(this.zzakf.zzb(zzhzVar.zzail), this.zzakf.zzc(zzhzVar.zzaim));
        zzhz zzhzVar4 = this.zzakt;
        if (zzhzVar4 == null) {
            if (!this.zzakl.isEmpty()) {
                zzhzVar4 = zziy.zza(this.zzakl.getLast());
            } else {
                zzhzVar4 = this.zzafp;
            }
        }
        if (!zzhzVar3.equals(zzhzVar4)) {
            if (isInitialized()) {
                this.zzakt = zzhzVar3;
            } else {
                this.zzafp = zzhzVar3;
            }
        }
        return this.zzafp;
    }

    public final zzhz zzfw() {
        return this.zzafp;
    }

    public final void setStreamType(int i) {
        if (this.streamType == i) {
            return;
        }
        this.streamType = i;
        if (this.zzama) {
            return;
        }
        reset();
        this.zzalz = 0;
    }

    public final void zzfx() {
        if (this.zzama) {
            this.zzama = false;
            this.zzalz = 0;
            reset();
        }
    }

    public final void setVolume(float f) {
        if (this.zzdi != f) {
            this.zzdi = f;
            zzfy();
        }
    }

    private final void zzfy() {
        if (isInitialized()) {
            if (zzpt.SDK_INT >= 21) {
                this.zzakm.setVolume(this.zzdi);
                return;
            }
            AudioTrack audioTrack = this.zzakm;
            float f = this.zzdi;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final void pause() {
        this.zzaly = false;
        if (isInitialized()) {
            zzga();
            this.zzakk.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzalg = 0L;
            this.zzalh = 0L;
            this.zzalj = 0L;
            this.zzalk = 0L;
            this.zzall = 0;
            zzhz zzhzVar = this.zzakt;
            if (zzhzVar != null) {
                this.zzafp = zzhzVar;
                this.zzakt = null;
            } else if (!this.zzakl.isEmpty()) {
                this.zzafp = zziy.zza(this.zzakl.getLast());
            }
            this.zzakl.clear();
            this.zzaku = 0L;
            this.zzakv = 0L;
            this.zzals = null;
            this.zzalt = null;
            int i = 0;
            while (true) {
                zzij[] zzijVarArr = this.zzalq;
                if (i >= zzijVarArr.length) {
                    break;
                }
                zzij zzijVar = zzijVarArr[i];
                zzijVar.flush();
                this.zzalr[i] = zzijVar.zzfq();
                i++;
            }
            this.zzalx = false;
            this.zzalw = -1;
            this.zzakw = null;
            this.zzakx = 0;
            this.zzalm = 0;
            this.zzalp = 0L;
            zzga();
            if (this.zzakm.getPlayState() == 3) {
                this.zzakm.pause();
            }
            AudioTrack audioTrack = this.zzakm;
            this.zzakm = null;
            this.zzakk.zza(null, false);
            this.zzaki.close();
            new zzis(this, audioTrack).start();
        }
    }

    public final void release() {
        reset();
        for (zzij zzijVar : this.zzakg) {
            zzijVar.reset();
        }
        this.zzalz = 0;
        this.zzaly = false;
    }

    private final boolean isInitialized() {
        return this.zzakm != null;
    }

    private final long zzdw(long j) {
        return (j * 1000000) / this.zzahz;
    }

    private final long zzdx(long j) {
        return (j * this.zzahz) / 1000000;
    }

    private final long zzfz() {
        return this.zzakq ? this.zzalk : this.zzalj / this.zzali;
    }

    private final void zzga() {
        this.zzala = 0L;
        this.zzakz = 0;
        this.zzaky = 0;
        this.zzalb = 0L;
        this.zzalc = false;
        this.zzald = 0L;
    }

    private final boolean zzgb() {
        if (zzpt.SDK_INT < 23) {
            int i = this.zzakp;
            return i == 5 || i == 6;
        }
        return false;
    }
}
