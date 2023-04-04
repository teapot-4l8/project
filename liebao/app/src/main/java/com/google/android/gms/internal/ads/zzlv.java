package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzlv extends zzhd {
    private static final byte[] zzbbq = zzpt.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzht zzaij;
    private ByteBuffer[] zzalr;
    private final zzlx zzbbr;
    private final zzjt<zzjv> zzbbs;
    private final boolean zzbbt;
    private final zzjp zzbbu;
    private final zzjp zzbbv;
    private final zzhv zzbbw;
    private final List<Long> zzbbx;
    private final MediaCodec.BufferInfo zzbby;
    private zzjr<zzjv> zzbbz;
    private zzjr<zzjv> zzbca;
    private MediaCodec zzbcb;
    private zzlw zzbcc;
    private boolean zzbcd;
    private boolean zzbce;
    private boolean zzbcf;
    private boolean zzbcg;
    private boolean zzbch;
    private boolean zzbci;
    private boolean zzbcj;
    private boolean zzbck;
    private boolean zzbcl;
    private ByteBuffer[] zzbcm;
    private long zzbcn;
    private int zzbco;
    private int zzbcp;
    private boolean zzbcq;
    private boolean zzbcr;
    private int zzbcs;
    private int zzbct;
    private boolean zzbcu;
    private boolean zzbcv;
    private boolean zzbcw;
    private boolean zzbcx;
    private boolean zzbcy;
    private boolean zzbcz;
    protected zzjm zzbda;

    public zzlv(int i, zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z) {
        super(i);
        zzpg.checkState(zzpt.SDK_INT >= 16);
        this.zzbbr = (zzlx) zzpg.checkNotNull(zzlxVar);
        this.zzbbs = null;
        this.zzbbt = z;
        this.zzbbu = new zzjp(0);
        this.zzbbv = new zzjp(0);
        this.zzbbw = new zzhv();
        this.zzbbx = new ArrayList();
        this.zzbby = new MediaCodec.BufferInfo();
        this.zzbcs = 0;
        this.zzbct = 0;
    }

    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void onStarted() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void onStopped() {
    }

    protected abstract int zza(zzlx zzlxVar, zzht zzhtVar);

    protected void zza(zzjp zzjpVar) {
    }

    protected abstract void zza(zzlw zzlwVar, MediaCodec mediaCodec, zzht zzhtVar, MediaCrypto mediaCrypto);

    protected abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    protected boolean zza(MediaCodec mediaCodec, boolean z, zzht zzhtVar, zzht zzhtVar2) {
        return false;
    }

    protected boolean zza(zzlw zzlwVar) {
        return true;
    }

    protected void zzc(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzib
    public final int zzej() {
        return 4;
    }

    protected void zzgi() {
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final int zza(zzht zzhtVar) {
        try {
            return zza(this.zzbbr, zzhtVar);
        } catch (zzmd e2) {
            throw zzhe.zza(e2, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlw zza(zzlx zzlxVar, zzht zzhtVar, boolean z) {
        return zzlxVar.zzc(zzhtVar.zzaho, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzhg() {
        zzht zzhtVar;
        if (this.zzbcb != null || (zzhtVar = this.zzaij) == null) {
            return;
        }
        this.zzbbz = this.zzbca;
        String str = zzhtVar.zzaho;
        zzjr<zzjv> zzjrVar = this.zzbbz;
        if (zzjrVar != null) {
            int state = zzjrVar.getState();
            if (state == 0) {
                throw zzhe.zza(this.zzbbz.zzgt(), getIndex());
            }
            if (state == 3 || state == 4) {
                this.zzbbz.zzgs();
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.zzbcc == null) {
            try {
                this.zzbcc = zza(this.zzbbr, this.zzaij, false);
            } catch (zzmd e2) {
                zza(new zzly(this.zzaij, (Throwable) e2, false, -49998));
            }
            if (this.zzbcc == null) {
                zza(new zzly(this.zzaij, (Throwable) null, false, -49999));
            }
        }
        if (zza(this.zzbcc)) {
            String str2 = this.zzbcc.name;
            this.zzbcd = zzpt.SDK_INT < 21 && this.zzaij.zzahq.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            this.zzbce = zzpt.SDK_INT < 18 || (zzpt.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzpt.SDK_INT == 19 && zzpt.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            this.zzbcf = zzpt.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzpt.DEVICE) || "flounder_lte".equals(zzpt.DEVICE) || "grouper".equals(zzpt.DEVICE) || "tilapia".equals(zzpt.DEVICE));
            this.zzbcg = zzpt.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.zzbch = (zzpt.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzpt.SDK_INT <= 19 && "hb2000".equals(zzpt.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.zzbci = zzpt.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
            this.zzbcj = zzpt.SDK_INT <= 18 && this.zzaij.zzahy == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String valueOf = String.valueOf(str2);
                zzpu.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                this.zzbcb = MediaCodec.createByCodecName(str2);
                zzpu.endSection();
                zzpu.beginSection("configureCodec");
                zza(this.zzbcc, this.zzbcb, this.zzaij, (MediaCrypto) null);
                zzpu.endSection();
                zzpu.beginSection("startCodec");
                this.zzbcb.start();
                zzpu.endSection();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                zzc(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.zzbcm = this.zzbcb.getInputBuffers();
                this.zzalr = this.zzbcb.getOutputBuffers();
            } catch (Exception e3) {
                zza(new zzly(this.zzaij, (Throwable) e3, false, str2));
            }
            this.zzbcn = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            this.zzbco = -1;
            this.zzbcp = -1;
            this.zzbcz = true;
            this.zzbda.zzaok++;
        }
    }

    private final void zza(zzly zzlyVar) {
        throw zzhe.zza(zzlyVar, getIndex());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec zzhh() {
        return this.zzbcb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlw zzhi() {
        return this.zzbcc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void zzf(boolean z) {
        this.zzbda = new zzjm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void zza(long j, boolean z) {
        this.zzbcw = false;
        this.zzbcx = false;
        if (this.zzbcb != null) {
            this.zzbcn = -9223372036854775807L;
            this.zzbco = -1;
            this.zzbcp = -1;
            this.zzbcz = true;
            this.zzbcy = false;
            this.zzbcq = false;
            this.zzbbx.clear();
            this.zzbck = false;
            this.zzbcl = false;
            if (this.zzbce || (this.zzbch && this.zzbcv)) {
                zzhj();
                zzhg();
            } else if (this.zzbct != 0) {
                zzhj();
                zzhg();
            } else {
                this.zzbcb.flush();
                this.zzbcu = false;
            }
            if (!this.zzbcr || this.zzaij == null) {
                return;
            }
            this.zzbcs = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhd
    public void zzek() {
        this.zzaij = null;
        try {
            zzhj();
            try {
                if (this.zzbbz != null) {
                    this.zzbbs.zza(this.zzbbz);
                }
                try {
                    if (this.zzbca != null && this.zzbca != this.zzbbz) {
                        this.zzbbs.zza(this.zzbca);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.zzbca != null && this.zzbca != this.zzbbz) {
                        this.zzbbs.zza(this.zzbca);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.zzbbz != null) {
                    this.zzbbs.zza(this.zzbbz);
                }
                try {
                    if (this.zzbca != null && this.zzbca != this.zzbbz) {
                        this.zzbbs.zza(this.zzbca);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.zzbca != null && this.zzbca != this.zzbbz) {
                        this.zzbbs.zza(this.zzbca);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzhj() {
        this.zzbcn = -9223372036854775807L;
        this.zzbco = -1;
        this.zzbcp = -1;
        this.zzbcy = false;
        this.zzbcq = false;
        this.zzbbx.clear();
        this.zzbcm = null;
        this.zzalr = null;
        this.zzbcc = null;
        this.zzbcr = false;
        this.zzbcu = false;
        this.zzbcd = false;
        this.zzbce = false;
        this.zzbcf = false;
        this.zzbcg = false;
        this.zzbch = false;
        this.zzbcj = false;
        this.zzbck = false;
        this.zzbcl = false;
        this.zzbcv = false;
        this.zzbcs = 0;
        this.zzbct = 0;
        this.zzbbu.zzdr = null;
        if (this.zzbcb != null) {
            this.zzbda.zzaol++;
            try {
                this.zzbcb.stop();
                try {
                    this.zzbcb.release();
                    this.zzbcb = null;
                    zzjr<zzjv> zzjrVar = this.zzbbz;
                    if (zzjrVar == null || this.zzbca == zzjrVar) {
                        return;
                    }
                    try {
                        this.zzbbs.zza(zzjrVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.zzbcb = null;
                    zzjr<zzjv> zzjrVar2 = this.zzbbz;
                    if (zzjrVar2 != null && this.zzbca != zzjrVar2) {
                        try {
                            this.zzbbs.zza(zzjrVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.zzbcb.release();
                    this.zzbcb = null;
                    zzjr<zzjv> zzjrVar3 = this.zzbbz;
                    if (zzjrVar3 != null && this.zzbca != zzjrVar3) {
                        try {
                            this.zzbbs.zza(zzjrVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.zzbcb = null;
                    zzjr<zzjv> zzjrVar4 = this.zzbbz;
                    if (zzjrVar4 != null && this.zzbca != zzjrVar4) {
                        try {
                            this.zzbbs.zza(zzjrVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzb(long j, long j2) {
        if (this.zzbcx) {
            zzgi();
            return;
        }
        if (this.zzaij == null) {
            this.zzbbv.clear();
            int zza = zza(this.zzbbw, this.zzbbv, true);
            if (zza != -5) {
                if (zza == -4) {
                    zzpg.checkState(this.zzbbv.zzgm());
                    this.zzbcw = true;
                    zzhl();
                    return;
                }
                return;
            }
            zzd(this.zzbbw.zzaij);
        }
        zzhg();
        if (this.zzbcb != null) {
            zzpu.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzhk());
            zzpu.endSection();
        } else {
            zzdn(j);
            this.zzbbv.clear();
            int zza2 = zza(this.zzbbw, this.zzbbv, false);
            if (zza2 == -5) {
                zzd(this.zzbbw.zzaij);
            } else if (zza2 == -4) {
                zzpg.checkState(this.zzbbv.zzgm());
                this.zzbcw = true;
                zzhl();
            }
        }
        this.zzbda.zzgr();
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0149 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzhk() {
        int position;
        int zza;
        boolean z;
        MediaCodec mediaCodec = this.zzbcb;
        if (mediaCodec == null || this.zzbct == 2 || this.zzbcw) {
            return false;
        }
        if (this.zzbco < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.zzbco = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.zzbbu.zzdr = this.zzbcm[dequeueInputBuffer];
            this.zzbbu.clear();
        }
        if (this.zzbct == 1) {
            if (!this.zzbcg) {
                this.zzbcv = true;
                this.zzbcb.queueInputBuffer(this.zzbco, 0, 0, 0L, 4);
                this.zzbco = -1;
            }
            this.zzbct = 2;
            return false;
        } else if (this.zzbck) {
            this.zzbck = false;
            this.zzbbu.zzdr.put(zzbbq);
            this.zzbcb.queueInputBuffer(this.zzbco, 0, zzbbq.length, 0L, 0);
            this.zzbco = -1;
            this.zzbcu = true;
            return true;
        } else {
            if (this.zzbcy) {
                zza = -4;
                position = 0;
            } else {
                if (this.zzbcs == 1) {
                    for (int i = 0; i < this.zzaij.zzahq.size(); i++) {
                        this.zzbbu.zzdr.put(this.zzaij.zzahq.get(i));
                    }
                    this.zzbcs = 2;
                }
                position = this.zzbbu.zzdr.position();
                zza = zza(this.zzbbw, this.zzbbu, false);
            }
            if (zza == -3) {
                return false;
            }
            if (zza == -5) {
                if (this.zzbcs == 2) {
                    this.zzbbu.clear();
                    this.zzbcs = 1;
                }
                zzd(this.zzbbw.zzaij);
                return true;
            } else if (this.zzbbu.zzgm()) {
                if (this.zzbcs == 2) {
                    this.zzbbu.clear();
                    this.zzbcs = 1;
                }
                this.zzbcw = true;
                if (!this.zzbcu) {
                    zzhl();
                    return false;
                }
                try {
                    if (!this.zzbcg) {
                        this.zzbcv = true;
                        this.zzbcb.queueInputBuffer(this.zzbco, 0, 0, 0L, 4);
                        this.zzbco = -1;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw zzhe.zza(e2, getIndex());
                }
            } else if (this.zzbcz && !this.zzbbu.zzgn()) {
                this.zzbbu.clear();
                if (this.zzbcs == 2) {
                    this.zzbcs = 1;
                }
                return true;
            } else {
                this.zzbcz = false;
                boolean isEncrypted = this.zzbbu.isEncrypted();
                zzjr<zzjv> zzjrVar = this.zzbbz;
                if (zzjrVar != null) {
                    int state = zzjrVar.getState();
                    if (state == 0) {
                        throw zzhe.zza(this.zzbbz.zzgt(), getIndex());
                    }
                    if (state != 4 && (isEncrypted || !this.zzbbt)) {
                        z = true;
                        this.zzbcy = z;
                        if (z) {
                            if (this.zzbcd && !isEncrypted) {
                                zzpm.zzp(this.zzbbu.zzdr);
                                if (this.zzbbu.zzdr.position() == 0) {
                                    return true;
                                }
                                this.zzbcd = false;
                            }
                            try {
                                long j = this.zzbbu.zzaov;
                                if (this.zzbbu.zzgl()) {
                                    this.zzbbx.add(Long.valueOf(j));
                                }
                                this.zzbbu.zzdr.flip();
                                zza(this.zzbbu);
                                if (isEncrypted) {
                                    MediaCodec.CryptoInfo zzgq = this.zzbbu.zzaou.zzgq();
                                    if (position != 0) {
                                        if (zzgq.numBytesOfClearData == null) {
                                            zzgq.numBytesOfClearData = new int[1];
                                        }
                                        int[] iArr = zzgq.numBytesOfClearData;
                                        iArr[0] = iArr[0] + position;
                                    }
                                    this.zzbcb.queueSecureInputBuffer(this.zzbco, 0, zzgq, j, 0);
                                } else {
                                    this.zzbcb.queueInputBuffer(this.zzbco, 0, this.zzbbu.zzdr.limit(), j, 0);
                                }
                                this.zzbco = -1;
                                this.zzbcu = true;
                                this.zzbcs = 0;
                                this.zzbda.zzaom++;
                                return true;
                            } catch (MediaCodec.CryptoException e3) {
                                throw zzhe.zza(e3, getIndex());
                            }
                        }
                        return false;
                    }
                }
                z = false;
                this.zzbcy = z;
                if (z) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzd(zzht zzhtVar) {
        MediaCodec mediaCodec;
        zzht zzhtVar2 = this.zzaij;
        this.zzaij = zzhtVar;
        boolean z = true;
        if (!zzpt.zza(zzhtVar.zzahr, zzhtVar2 == null ? null : zzhtVar2.zzahr)) {
            if (this.zzaij.zzahr != null) {
                zzjt<zzjv> zzjtVar = this.zzbbs;
                if (zzjtVar == null) {
                    throw zzhe.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
                zzjr<zzjv> zza = zzjtVar.zza(Looper.myLooper(), this.zzaij.zzahr);
                this.zzbca = zza;
                if (zza == this.zzbbz) {
                    this.zzbbs.zza(zza);
                }
            } else {
                this.zzbca = null;
            }
        }
        if (this.zzbca == this.zzbbz && (mediaCodec = this.zzbcb) != null && zza(mediaCodec, this.zzbcc.zzbdb, zzhtVar2, this.zzaij)) {
            this.zzbcr = true;
            this.zzbcs = 1;
            this.zzbck = (this.zzbcf && this.zzaij.width == zzhtVar2.width && this.zzaij.height == zzhtVar2.height) ? false : false;
        } else if (this.zzbcu) {
            this.zzbct = 1;
        } else {
            zzhj();
            zzhg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public boolean zzfi() {
        return this.zzbcx;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public boolean isReady() {
        if (this.zzaij == null || this.zzbcy) {
            return false;
        }
        if (zzem() || this.zzbcp >= 0) {
            return true;
        }
        return this.zzbcn != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzbcn;
    }

    private final boolean zzd(long j, long j2) {
        boolean zza;
        boolean z;
        if (this.zzbcp < 0) {
            if (this.zzbci && this.zzbcv) {
                try {
                    this.zzbcp = this.zzbcb.dequeueOutputBuffer(this.zzbby, 0L);
                } catch (IllegalStateException unused) {
                    zzhl();
                    if (this.zzbcx) {
                        zzhj();
                    }
                    return false;
                }
            } else {
                this.zzbcp = this.zzbcb.dequeueOutputBuffer(this.zzbby, 0L);
            }
            int i = this.zzbcp;
            if (i < 0) {
                if (i != -2) {
                    if (i == -3) {
                        this.zzalr = this.zzbcb.getOutputBuffers();
                        return true;
                    }
                    if (this.zzbcg && (this.zzbcw || this.zzbct == 2)) {
                        zzhl();
                    }
                    return false;
                }
                MediaFormat outputFormat = this.zzbcb.getOutputFormat();
                if (this.zzbcf && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzbcl = true;
                } else {
                    if (this.zzbcj) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzbcb, outputFormat);
                }
                return true;
            } else if (this.zzbcl) {
                this.zzbcl = false;
                this.zzbcb.releaseOutputBuffer(i, false);
                this.zzbcp = -1;
                return true;
            } else if ((this.zzbby.flags & 4) != 0) {
                zzhl();
                this.zzbcp = -1;
                return false;
            } else {
                ByteBuffer byteBuffer = this.zzalr[this.zzbcp];
                if (byteBuffer != null) {
                    byteBuffer.position(this.zzbby.offset);
                    byteBuffer.limit(this.zzbby.offset + this.zzbby.size);
                }
                long j3 = this.zzbby.presentationTimeUs;
                int size = this.zzbbx.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    } else if (this.zzbbx.get(i2).longValue() == j3) {
                        this.zzbbx.remove(i2);
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                this.zzbcq = z;
            }
        }
        if (this.zzbci && this.zzbcv) {
            try {
                zza = zza(j, j2, this.zzbcb, this.zzalr[this.zzbcp], this.zzbcp, this.zzbby.flags, this.zzbby.presentationTimeUs, this.zzbcq);
            } catch (IllegalStateException unused2) {
                zzhl();
                if (this.zzbcx) {
                    zzhj();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec = this.zzbcb;
            ByteBuffer[] byteBufferArr = this.zzalr;
            int i3 = this.zzbcp;
            zza = zza(j, j2, mediaCodec, byteBufferArr[i3], i3, this.zzbby.flags, this.zzbby.presentationTimeUs, this.zzbcq);
        }
        if (zza) {
            long j4 = this.zzbby.presentationTimeUs;
            this.zzbcp = -1;
            return true;
        }
        return false;
    }

    private final void zzhl() {
        if (this.zzbct == 2) {
            zzhj();
            zzhg();
            return;
        }
        this.zzbcx = true;
        zzgi();
    }
}
