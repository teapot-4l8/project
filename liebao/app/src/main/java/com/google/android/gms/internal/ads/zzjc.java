package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzjc extends zzlv implements zzpk {
    private int zzahy;
    private int zzaia;
    private final zzik zzamw;
    private final zzit zzamx;
    private boolean zzamy;
    private boolean zzamz;
    private MediaFormat zzana;
    private long zzanb;
    private boolean zzanc;

    public zzjc(zzlx zzlxVar, Handler handler, zzil zzilVar) {
        this(zzlxVar, null, true, handler, zzilVar);
    }

    public static void zzaa(int i) {
    }

    private final boolean zzax(String str) {
        return false;
    }

    public static void zzb(int i, long j, long j2) {
    }

    public static void zzgh() {
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzhy
    public final zzpk zzed() {
        return this;
    }

    private zzjc(zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzil zzilVar) {
        this(zzlxVar, null, true, handler, zzilVar, null, new zzij[0]);
    }

    private zzjc(zzlx zzlxVar, zzjt<zzjv> zzjtVar, boolean z, Handler handler, zzil zzilVar, zzig zzigVar, zzij... zzijVarArr) {
        super(1, zzlxVar, null, true);
        this.zzamx = new zzit(null, zzijVarArr, new zzje(this));
        this.zzamw = new zzik(handler, zzilVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final int zza(zzlx zzlxVar, zzht zzhtVar) {
        String str = zzhtVar.zzaho;
        boolean z = false;
        if (zzpj.zzbc(str)) {
            int i = zzpt.SDK_INT >= 21 ? 16 : 0;
            if (!zzax(str) || zzlxVar.zzhn() == null) {
                zzlw zzc = zzlxVar.zzc(str, false);
                if (zzc == null) {
                    return 1;
                }
                if (zzpt.SDK_INT < 21 || ((zzhtVar.zzahz == -1 || zzc.zzaz(zzhtVar.zzahz)) && (zzhtVar.zzahy == -1 || zzc.zzba(zzhtVar.zzahy)))) {
                    z = true;
                }
                return i | 4 | (z ? 3 : 2);
            }
            return i | 4 | 3;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final zzlw zza(zzlx zzlxVar, zzht zzhtVar, boolean z) {
        zzlw zzhn;
        if (zzax(zzhtVar.zzaho) && (zzhn = zzlxVar.zzhn()) != null) {
            this.zzamy = true;
            return zzhn;
        }
        this.zzamy = false;
        return super.zza(zzlxVar, zzhtVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zza(zzlw zzlwVar, MediaCodec mediaCodec, zzht zzhtVar, MediaCrypto mediaCrypto) {
        this.zzamz = zzpt.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzlwVar.name) && "samsung".equals(zzpt.MANUFACTURER) && (zzpt.DEVICE.startsWith("zeroflte") || zzpt.DEVICE.startsWith("herolte") || zzpt.DEVICE.startsWith("heroqlte"));
        if (this.zzamy) {
            MediaFormat zzfe = zzhtVar.zzfe();
            this.zzana = zzfe;
            zzfe.setString("mime", "audio/raw");
            mediaCodec.configure(this.zzana, (Surface) null, (MediaCrypto) null, 0);
            this.zzana.setString("mime", zzhtVar.zzaho);
            return;
        }
        mediaCodec.configure(zzhtVar.zzfe(), (Surface) null, (MediaCrypto) null, 0);
        this.zzana = null;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zzc(String str, long j, long j2) {
        this.zzamw.zza(str, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzd(zzht zzhtVar) {
        super.zzd(zzhtVar);
        this.zzamw.zzb(zzhtVar);
        this.zzaia = "audio/raw".equals(zzhtVar.zzaho) ? zzhtVar.zzaia : 2;
        this.zzahy = zzhtVar.zzahy;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int[] iArr;
        int i;
        boolean z = this.zzana != null;
        String string = z ? this.zzana.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzana;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.zzamz && integer == 6 && (i = this.zzahy) < 6) {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzahy; i2++) {
                iArr[i2] = i2;
            }
        } else {
            iArr = null;
        }
        try {
            this.zzamx.zza(string, integer, integer2, this.zzaia, 0, iArr);
        } catch (zzix e2) {
            throw zzhe.zza(e2, getIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zzf(boolean z) {
        super.zzf(z);
        this.zzamw.zza(this.zzbda);
        int i = zzel().zzaip;
        this.zzamx.zzfx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zza(long j, boolean z) {
        super.zza(j, z);
        this.zzamx.reset();
        this.zzanb = j;
        this.zzanc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStarted() {
        super.onStarted();
        this.zzamx.play();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void onStopped() {
        this.zzamx.pause();
        super.onStopped();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhd
    public final void zzek() {
        try {
            this.zzamx.release();
            try {
                super.zzek();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.zzek();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean zzfi() {
        return super.zzfi() && this.zzamx.zzfi();
    }

    @Override // com.google.android.gms.internal.ads.zzlv, com.google.android.gms.internal.ads.zzhy
    public final boolean isReady() {
        return this.zzamx.zzfv() || super.isReady();
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final long zzgg() {
        long zzk = this.zzamx.zzk(zzfi());
        if (zzk != Long.MIN_VALUE) {
            if (!this.zzanc) {
                zzk = Math.max(this.zzanb, zzk);
            }
            this.zzanb = zzk;
            this.zzanc = false;
        }
        return this.zzanb;
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzb(zzhz zzhzVar) {
        return this.zzamx.zzb(zzhzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzfw() {
        return this.zzamx.zzfw();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.zzamy && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbda.zzaoo++;
            this.zzamx.zzfs();
            return true;
        } else {
            try {
                if (this.zzamx.zzb(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.zzbda.zzaon++;
                    return true;
                }
                return false;
            } catch (zziw | zzjb e2) {
                throw zzhe.zza(e2, getIndex());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    protected final void zzgi() {
        try {
            this.zzamx.zzft();
        } catch (zzjb e2) {
            throw zzhe.zza(e2, getIndex());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzhj
    public final void zza(int i, Object obj) {
        if (i == 2) {
            this.zzamx.setVolume(((Float) obj).floatValue());
        } else if (i == 3) {
            this.zzamx.setStreamType(((Integer) obj).intValue());
        } else {
            super.zza(i, obj);
        }
    }
}
