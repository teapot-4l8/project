package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqe extends zzlv {
    private static final int[] zzbln = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private final Context context;
    private int zzaip;
    private boolean zzama;
    private final zzqi zzblo;
    private final zzqj zzblp;
    private final long zzblq;
    private final int zzblr;
    private final boolean zzbls;
    private final long[] zzblt;
    private zzht[] zzblu;
    private zzqg zzblv;
    private Surface zzblw;
    private Surface zzblx;
    private int zzbly;
    private boolean zzblz;
    private long zzbma;
    private long zzbmb;
    private int zzbmc;
    private int zzbmd;
    private int zzbme;
    private float zzbmf;
    private int zzbmg;
    private int zzbmh;
    private int zzbmi;
    private float zzbmj;
    private int zzbmk;
    private int zzbml;
    private int zzbmm;
    private float zzbmn;
    zzqf zzbmo;
    private long zzbmp;
    private int zzbmq;

    public zzqe(Context context, zzlx zzlxVar, long j, Handler handler, zzqk zzqkVar, int i) {
        this(context, zzlxVar, 0L, null, false, handler, zzqkVar, -1);
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzqe(Context context, zzlx zzlxVar, long j, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzqk zzqkVar, int i) {
        super(2, zzlxVar, null, false);
        boolean z2 = false;
        this.zzblq = 0L;
        this.zzblr = -1;
        this.context = context.getApplicationContext();
        this.zzblo = new zzqi(context);
        this.zzblp = new zzqj(handler, zzqkVar);
        if (zzpt.SDK_INT <= 22 && "foster".equals(zzpt.DEVICE) && "NVIDIA".equals(zzpt.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbls = z2;
        this.zzblt = new long[10];
        this.zzbmp = -9223372036854775807L;
        this.zzbma = -9223372036854775807L;
        this.zzbmg = -1;
        this.zzbmh = -1;
        this.zzbmj = -1.0f;
        this.zzbmf = -1.0f;
        this.zzbly = 1;
        zzjp();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final int zza(zzlx zzlxVar, zzht zzhtVar) {
        boolean z;
        String str = zzhtVar.zzaho;
        if (zzpj.zzbd(str)) {
            zzjo zzjoVar = zzhtVar.zzahr;
            if (zzjoVar != null) {
                z = false;
                for (int i = 0; i < zzjoVar.zzaot; i++) {
                    z |= zzjoVar.zzaf(i).zzaox;
                }
            } else {
                z = false;
            }
            zzlw zzc = zzlxVar.zzc(str, z);
            if (zzc == null) {
                return 1;
            }
            boolean zzaz = zzc.zzaz(zzhtVar.zzahl);
            if (zzaz && zzhtVar.width > 0 && zzhtVar.height > 0) {
                if (zzpt.SDK_INT >= 21) {
                    zzaz = zzc.zza(zzhtVar.width, zzhtVar.height, zzhtVar.zzahs);
                } else {
                    boolean z2 = zzhtVar.width * zzhtVar.height <= zzlz.zzho();
                    if (!z2) {
                        int i2 = zzhtVar.width;
                        int i3 = zzhtVar.height;
                        String str2 = zzpt.zzbkx;
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("FalseCheck [legacyFrameSize, ");
                        sb.append(i2);
                        sb.append("x");
                        sb.append(i3);
                        sb.append("] [");
                        sb.append(str2);
                        sb.append("]");
                        Log.d("MediaCodecVideoRenderer", sb.toString());
                    }
                    zzaz = z2;
                }
            }
            return (zzaz ? 3 : 2) | (zzc.zzbdb ? 8 : 4) | (zzc.zzama ? 16 : 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zzf(boolean z) {
        super.zzf(z);
        int i = zzel().zzaip;
        this.zzaip = i;
        this.zzama = i != 0;
        this.zzblp.zza(this.zzbda);
        this.zzblo.enable();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public final void zza(zzht[] zzhtVarArr, long j) {
        this.zzblu = zzhtVarArr;
        if (this.zzbmp == -9223372036854775807L) {
            this.zzbmp = j;
        } else {
            int i = this.zzbmq;
            long[] jArr = this.zzblt;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbmq = i + 1;
            }
            this.zzblt[this.zzbmq - 1] = j;
        }
        super.zza(zzhtVarArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zza(long j, boolean z) {
        super.zza(j, z);
        zzjn();
        this.zzbmd = 0;
        int i = this.zzbmq;
        if (i != 0) {
            this.zzbmp = this.zzblt[i - 1];
            this.zzbmq = 0;
        }
        if (z) {
            zzjm();
        } else {
            this.zzbma = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzblz || (((surface = this.zzblx) != null && this.zzblw == surface) || zzhh() == null))) {
            this.zzbma = -9223372036854775807L;
            return true;
        } else if (this.zzbma == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzbma) {
                return true;
            }
            this.zzbma = -9223372036854775807L;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStarted() {
        super.onStarted();
        this.zzbmc = 0;
        this.zzbmb = SystemClock.elapsedRealtime();
        this.zzbma = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStopped() {
        zzjs();
        super.onStopped();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zzek() {
        this.zzbmg = -1;
        this.zzbmh = -1;
        this.zzbmj = -1.0f;
        this.zzbmf = -1.0f;
        this.zzbmp = -9223372036854775807L;
        this.zzbmq = 0;
        zzjp();
        zzjn();
        this.zzblo.disable();
        this.zzbmo = null;
        this.zzama = false;
        try {
            super.zzek();
        } finally {
            this.zzbda.zzgr();
            this.zzblp.zzb(this.zzbda);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzhj
    public final void zza(int i, Object obj) {
        if (i != 1) {
            if (i == 4) {
                this.zzbly = ((Integer) obj).intValue();
                MediaCodec zzhh = zzhh();
                if (zzhh != null) {
                    zzhh.setVideoScalingMode(this.zzbly);
                    return;
                }
                return;
            }
            super.zza(i, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.zzblx;
            if (surface2 != null) {
                surface = surface2;
            } else {
                zzlw zzhi = zzhi();
                if (zzhi != null && zzo(zzhi.zzbdc)) {
                    surface = zzqa.zzc(this.context, zzhi.zzbdc);
                    this.zzblx = surface;
                }
            }
        }
        if (this.zzblw != surface) {
            this.zzblw = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec zzhh2 = zzhh();
                if (zzpt.SDK_INT >= 23 && zzhh2 != null && surface != null) {
                    zzhh2.setOutputSurface(surface);
                } else {
                    zzhj();
                    zzhg();
                }
            }
            if (surface != null && surface != this.zzblx) {
                zzjr();
                zzjn();
                if (state == 2) {
                    zzjm();
                    return;
                }
                return;
            }
            zzjp();
            zzjn();
        } else if (surface == null || surface == this.zzblx) {
        } else {
            zzjr();
            if (this.zzblz) {
                this.zzblp.zza(this.zzblw);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(zzlw zzlwVar) {
        return this.zzblw != null || zzo(zzlwVar.zzbdc);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zza(zzlw zzlwVar, MediaCodec mediaCodec, zzht zzhtVar, MediaCrypto mediaCrypto) {
        zzqg zzqgVar;
        Point point;
        zzht[] zzhtVarArr = this.zzblu;
        int i = zzhtVar.width;
        int i2 = zzhtVar.height;
        int zzi = zzi(zzhtVar);
        if (zzhtVarArr.length == 1) {
            zzqgVar = new zzqg(i, i2, zzi);
        } else {
            boolean z = false;
            for (zzht zzhtVar2 : zzhtVarArr) {
                if (zza(zzlwVar.zzbdb, zzhtVar, zzhtVar2)) {
                    z |= zzhtVar2.width == -1 || zzhtVar2.height == -1;
                    i = Math.max(i, zzhtVar2.width);
                    i2 = Math.max(i2, zzhtVar2.height);
                    zzi = Math.max(zzi, zzi(zzhtVar2));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzhtVar.height > zzhtVar.width;
                int i3 = z2 ? zzhtVar.height : zzhtVar.width;
                int i4 = z2 ? zzhtVar.width : zzhtVar.height;
                float f = i4 / i3;
                int[] iArr = zzbln;
                int length = iArr.length;
                int i5 = 0;
                while (i5 < length) {
                    int i6 = length;
                    int i7 = iArr[i5];
                    int[] iArr2 = iArr;
                    int i8 = (int) (i7 * f);
                    if (i7 <= i3 || i8 <= i4) {
                        break;
                    }
                    int i9 = i3;
                    int i10 = i4;
                    if (zzpt.SDK_INT >= 21) {
                        int i11 = z2 ? i8 : i7;
                        if (!z2) {
                            i7 = i8;
                        }
                        Point zzf = zzlwVar.zzf(i11, i7);
                        if (zzlwVar.zza(zzf.x, zzf.y, zzhtVar.zzahs)) {
                            point = zzf;
                            break;
                        }
                        i5++;
                        length = i6;
                        iArr = iArr2;
                        i3 = i9;
                        i4 = i10;
                    } else {
                        int zzh = zzpt.zzh(i7, 16) << 4;
                        int zzh2 = zzpt.zzh(i8, 16) << 4;
                        if (zzh * zzh2 <= zzlz.zzho()) {
                            int i12 = z2 ? zzh2 : zzh;
                            if (!z2) {
                                zzh = zzh2;
                            }
                            point = new Point(i12, zzh);
                        } else {
                            i5++;
                            length = i6;
                            iArr = iArr2;
                            i3 = i9;
                            i4 = i10;
                        }
                    }
                }
                point = null;
                if (point != null) {
                    i = Math.max(i, point.x);
                    i2 = Math.max(i2, point.y);
                    zzi = Math.max(zzi, zza(zzhtVar.zzaho, i, i2));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i);
                    sb2.append("x");
                    sb2.append(i2);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzqgVar = new zzqg(i, i2, zzi);
        }
        this.zzblv = zzqgVar;
        boolean z3 = this.zzbls;
        int i13 = this.zzaip;
        MediaFormat zzfe = zzhtVar.zzfe();
        zzfe.setInteger("max-width", zzqgVar.width);
        zzfe.setInteger("max-height", zzqgVar.height);
        if (zzqgVar.zzbms != -1) {
            zzfe.setInteger("max-input-size", zzqgVar.zzbms);
        }
        if (z3) {
            zzfe.setInteger("auto-frc", 0);
        }
        if (i13 != 0) {
            zzfe.setFeatureEnabled("tunneled-playback", true);
            zzfe.setInteger("audio-session-id", i13);
        }
        if (this.zzblw == null) {
            zzpg.checkState(zzo(zzlwVar.zzbdc));
            if (this.zzblx == null) {
                this.zzblx = zzqa.zzc(this.context, zzlwVar.zzbdc);
            }
            this.zzblw = this.zzblx;
        }
        mediaCodec.configure(zzfe, this.zzblw, (MediaCrypto) null, 0);
        if (zzpt.SDK_INT < 23 || !this.zzama) {
            return;
        }
        this.zzbmo = new zzqf(this, mediaCodec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzhj() {
        try {
            super.zzhj();
        } finally {
            Surface surface = this.zzblx;
            if (surface != null) {
                if (this.zzblw == surface) {
                    this.zzblw = null;
                }
                this.zzblx.release();
                this.zzblx = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zzc(String str, long j, long j2) {
        this.zzblp.zza(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzd(zzht zzhtVar) {
        super.zzd(zzhtVar);
        this.zzblp.zzb(zzhtVar);
        this.zzbmf = zzhtVar.zzahu == -1.0f ? 1.0f : zzhtVar.zzahu;
        this.zzbme = zzj(zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zza(zzjp zzjpVar) {
        if (zzpt.SDK_INT >= 23 || !this.zzama) {
            return;
        }
        zzjo();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.zzbmg = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.zzbmh = integer2;
        this.zzbmj = this.zzbmf;
        if (zzpt.SDK_INT >= 21) {
            int i = this.zzbme;
            if (i == 90 || i == 270) {
                int i2 = this.zzbmg;
                this.zzbmg = this.zzbmh;
                this.zzbmh = i2;
                this.zzbmj = 1.0f / this.zzbmj;
            }
        } else {
            this.zzbmi = this.zzbme;
        }
        mediaCodec.setVideoScalingMode(this.zzbly);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(MediaCodec mediaCodec, boolean z, zzht zzhtVar, zzht zzhtVar2) {
        return zza(z, zzhtVar, zzhtVar2) && zzhtVar2.width <= this.zzblv.width && zzhtVar2.height <= this.zzblv.height && zzhtVar2.zzahp <= this.zzblv.zzbms;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.zzbmq;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.zzblt;
            if (j3 < jArr[0]) {
                break;
            }
            this.zzbmp = jArr[0];
            int i4 = i3 - 1;
            this.zzbmq = i4;
            System.arraycopy(jArr, 1, jArr, 0, i4);
        }
        long j4 = j3 - this.zzbmp;
        if (z) {
            zza(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.zzblw == this.zzblx) {
            if (zzem(j5)) {
                zza(mediaCodec, i, j4);
                return true;
            }
            return false;
        } else if (!this.zzblz) {
            if (zzpt.SDK_INT >= 21) {
                zza(mediaCodec, i, j4, System.nanoTime());
            } else {
                zzb(mediaCodec, i, j4);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzblo.zzf(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (zzf - nanoTime) / 1000;
            if (zzem(j6)) {
                zzpu.beginSection("dropVideoBuffer");
                mediaCodec.releaseOutputBuffer(i, false);
                zzpu.endSection();
                this.zzbda.zzaop++;
                this.zzbmc++;
                this.zzbmd++;
                this.zzbda.zzaoq = Math.max(this.zzbmd, this.zzbda.zzaoq);
                if (this.zzbmc == this.zzblr) {
                    zzjs();
                }
                return true;
            }
            if (zzpt.SDK_INT >= 21) {
                if (j6 < 50000) {
                    zza(mediaCodec, i, j4, zzf);
                    return true;
                }
            } else if (j6 < 30000) {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec, i, j4);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzpu.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpu.endSection();
        this.zzbda.zzaoo++;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjq();
        zzpu.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpu.endSection();
        this.zzbda.zzaon++;
        this.zzbmd = 0;
        zzjo();
    }

    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjq();
        zzpu.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpu.endSection();
        this.zzbda.zzaon++;
        this.zzbmd = 0;
        zzjo();
    }

    private final boolean zzo(boolean z) {
        if (zzpt.SDK_INT < 23 || this.zzama) {
            return false;
        }
        return !z || zzqa.zzc(this.context);
    }

    private final void zzjm() {
        this.zzbma = -9223372036854775807L;
    }

    private final void zzjn() {
        MediaCodec zzhh;
        this.zzblz = false;
        if (zzpt.SDK_INT < 23 || !this.zzama || (zzhh = zzhh()) == null) {
            return;
        }
        this.zzbmo = new zzqf(this, zzhh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzjo() {
        if (this.zzblz) {
            return;
        }
        this.zzblz = true;
        this.zzblp.zza(this.zzblw);
    }

    private final void zzjp() {
        this.zzbmk = -1;
        this.zzbml = -1;
        this.zzbmn = -1.0f;
        this.zzbmm = -1;
    }

    private final void zzjq() {
        if (this.zzbmk == this.zzbmg && this.zzbml == this.zzbmh && this.zzbmm == this.zzbmi && this.zzbmn == this.zzbmj) {
            return;
        }
        this.zzblp.zza(this.zzbmg, this.zzbmh, this.zzbmi, this.zzbmj);
        this.zzbmk = this.zzbmg;
        this.zzbml = this.zzbmh;
        this.zzbmm = this.zzbmi;
        this.zzbmn = this.zzbmj;
    }

    private final void zzjr() {
        if (this.zzbmk == -1 && this.zzbml == -1) {
            return;
        }
        this.zzblp.zza(this.zzbmg, this.zzbmh, this.zzbmi, this.zzbmj);
    }

    private final void zzjs() {
        if (this.zzbmc > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzblp.zzf(this.zzbmc, elapsedRealtime - this.zzbmb);
            this.zzbmc = 0;
            this.zzbmb = elapsedRealtime;
        }
    }

    private static int zzi(zzht zzhtVar) {
        if (zzhtVar.zzahp != -1) {
            return zzhtVar.zzahp;
        }
        return zza(zzhtVar.zzaho, zzhtVar.width, zzhtVar.height);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zza(String str, int i, int i2) {
        char c2;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0 && c2 != 1) {
            if (c2 == 2) {
                if ("BRAVIA 4K 2015".equals(zzpt.MODEL)) {
                    return -1;
                }
                i3 = ((zzpt.zzh(i, 16) * zzpt.zzh(i2, 16)) << 4) << 4;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            } else if (c2 != 3) {
                if (c2 == 4 || c2 == 5) {
                    i3 = i * i2;
                    return (i3 * 3) / (i4 * 2);
                }
                return -1;
            }
        }
        i3 = i * i2;
        i4 = 2;
        return (i3 * 3) / (i4 * 2);
    }

    private static boolean zza(boolean z, zzht zzhtVar, zzht zzhtVar2) {
        if (zzhtVar.zzaho.equals(zzhtVar2.zzaho) && zzj(zzhtVar) == zzj(zzhtVar2)) {
            if (z) {
                return true;
            }
            return zzhtVar.width == zzhtVar2.width && zzhtVar.height == zzhtVar2.height;
        }
        return false;
    }

    private static int zzj(zzht zzhtVar) {
        if (zzhtVar.zzaht == -1) {
            return 0;
        }
        return zzhtVar.zzaht;
    }
}
