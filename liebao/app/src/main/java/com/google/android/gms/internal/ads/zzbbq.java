package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.umeng.analytics.pro.ak;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbbq extends zzbbz implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeky = new HashMap();
    private final zzbcs zzekz;
    private final zzbcr zzela;
    private final boolean zzelb;
    private int zzelc;
    private int zzeld;
    private MediaPlayer zzele;
    private Uri zzelf;
    private int zzelg;
    private int zzelh;
    private int zzeli;
    private int zzelj;
    private int zzelk;
    private zzbcq zzell;
    private boolean zzelm;
    private int zzeln;
    private zzbca zzelo;
    private Integer zzelp;

    public zzbbq(Context context, zzbcs zzbcsVar, boolean z, boolean z2, zzbcp zzbcpVar, zzbcr zzbcrVar) {
        super(context);
        this.zzelc = 0;
        this.zzeld = 0;
        this.zzelp = null;
        setSurfaceTextureListener(this);
        this.zzekz = zzbcsVar;
        this.zzela = zzbcrVar;
        this.zzelm = z;
        this.zzelb = z2;
        zzbcrVar.zzb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final long zznh() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final String zzaaw() {
        String str = this.zzelm ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zza(zzbca zzbcaVar) {
        this.zzelo = zzbcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzti zzd = zzti.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzelf = parse;
            this.zzeln = 0;
            zzaax();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void stop() {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzele.release();
            this.zzele = null;
            zzdo(0);
            this.zzeld = 0;
        }
        this.zzela.onStop();
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        this.zzelg = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzelh = videoHeight;
        if (this.zzelg == 0 || videoHeight == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView prepared");
        zzdo(2);
        this.zzela.zzff();
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbbs(this, mediaPlayer));
        this.zzelg = mediaPlayer.getVideoWidth();
        this.zzelh = mediaPlayer.getVideoHeight();
        int i = this.zzeln;
        if (i != 0) {
            seekTo(i);
        }
        zzaay();
        int i2 = this.zzelg;
        int i3 = this.zzelh;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zzd.zzey(sb.toString());
        if (this.zzeld == 3) {
            play();
        }
        zzabc();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView completion");
        zzdo(5);
        this.zzeld = 5;
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbbr(this));
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeky.get(Integer.valueOf(i));
        String str2 = zzeky.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        return true;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeky.get(Integer.valueOf(i));
        String str2 = zzeky.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
        zzdo(-1);
        this.zzeld = -1;
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbbu(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzeli = i;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView surface created");
        zzaax();
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbbt(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzeld == 3;
        z = (this.zzelg == i && this.zzelh == i2) ? false : false;
        if (this.zzele != null && z2 && z) {
            int i3 = this.zzeln;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzo(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbbw(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null && this.zzeln == 0) {
            this.zzeln = mediaPlayer.getCurrentPosition();
        }
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzabp();
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbbv(this));
        zzax(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzela.zzc(this);
        this.zzelw.zza(surfaceTexture, this.zzelo);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzbbp
            private final int zzehh;
            private final zzbbq zzekx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzekx = this;
                this.zzehh = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzekx.zzdp(this.zzehh);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(this.zzelg, i);
        int defaultSize2 = getDefaultSize(this.zzelh, i2);
        if (this.zzelg > 0 && this.zzelh > 0 && this.zzell == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.zzelg;
                int i5 = i4 * size2;
                int i6 = this.zzelh;
                if (i5 < size * i6) {
                    defaultSize = (i4 * size2) / i6;
                    defaultSize2 = size2;
                } else {
                    if (i4 * size2 > size * i6) {
                        defaultSize2 = (i6 * size) / i4;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i7 = (this.zzelh * size) / this.zzelg;
                if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                    defaultSize2 = i7;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i8 = (this.zzelg * size2) / this.zzelh;
                if (mode != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize = i8;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i9 = this.zzelg;
                int i10 = this.zzelh;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    defaultSize2 = i10;
                } else {
                    i9 = (i9 * size2) / i10;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                } else {
                    defaultSize2 = (this.zzelh * size) / this.zzelg;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzo(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i11 = this.zzelj;
            if ((i11 > 0 && i11 != defaultSize) || ((i3 = this.zzelk) > 0 && i3 != defaultSize2)) {
                zzaay();
            }
            this.zzelj = defaultSize;
            this.zzelk = defaultSize2;
        }
    }

    @Override // android.view.View
    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void zzaax() {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzelf == null || surfaceTexture == null) {
            return;
        }
        zzax(false);
        try {
            com.google.android.gms.ads.internal.zzr.zzll();
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.zzele = mediaPlayer;
            mediaPlayer.setOnBufferingUpdateListener(this);
            this.zzele.setOnCompletionListener(this);
            this.zzele.setOnErrorListener(this);
            this.zzele.setOnInfoListener(this);
            this.zzele.setOnPreparedListener(this);
            this.zzele.setOnVideoSizeChangedListener(this);
            this.zzeli = 0;
            if (this.zzelm) {
                zzbcq zzbcqVar = new zzbcq(getContext());
                this.zzell = zzbcqVar;
                zzbcqVar.zza(surfaceTexture, getWidth(), getHeight());
                this.zzell.start();
                SurfaceTexture zzabq = this.zzell.zzabq();
                if (zzabq != null) {
                    surfaceTexture = zzabq;
                } else {
                    this.zzell.zzabp();
                    this.zzell = null;
                }
            }
            this.zzele.setDataSource(getContext(), this.zzelf);
            com.google.android.gms.ads.internal.zzr.zzlm();
            this.zzele.setSurface(new Surface(surfaceTexture));
            this.zzele.setAudioStreamType(3);
            this.zzele.setScreenOnWhilePlaying(true);
            this.zzele.prepareAsync();
            zzdo(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e2) {
            String valueOf = String.valueOf(this.zzelf);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(valueOf);
            com.google.android.gms.ads.internal.util.zzd.zzd(sb.toString(), e2);
            onError(this.zzele, 1, 0);
        }
    }

    private final void zzaay() {
        if (this.zzelb && zzaaz() && this.zzele.getCurrentPosition() > 0 && this.zzeld != 3) {
            com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView nudging MediaPlayer");
            zzd(0.0f);
            this.zzele.start();
            int currentPosition = this.zzele.getCurrentPosition();
            long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
            while (zzaaz() && this.zzele.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis() - currentTimeMillis <= 250) {
            }
            this.zzele.pause();
            zzabc();
        }
    }

    private final void zzax(boolean z) {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView release");
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzabp();
            this.zzell = null;
        }
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzele.release();
            this.zzele = null;
            zzdo(0);
            if (z) {
                this.zzeld = 0;
                this.zzeld = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void play() {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView play");
        if (zzaaz()) {
            this.zzele.start();
            zzdo(3);
            this.zzelw.zzabe();
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbby(this));
        }
        this.zzeld = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void pause() {
        com.google.android.gms.ads.internal.util.zzd.zzed("AdMediaPlayerView pause");
        if (zzaaz() && this.zzele.isPlaying()) {
            this.zzele.pause();
            zzdo(4);
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbbx(this));
        }
        this.zzeld = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getDuration() {
        if (zzaaz()) {
            return this.zzele.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getCurrentPosition() {
        if (zzaaz()) {
            return this.zzele.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        if (zzaaz()) {
            this.zzele.seekTo(i);
            this.zzeln = 0;
            return;
        }
        this.zzeln = i;
    }

    private final boolean zzaaz() {
        int i;
        return (this.zzele == null || (i = this.zzelc) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zza(float f, float f2) {
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final long zzaba() {
        if (this.zzelp != null) {
            return (getTotalBytes() * this.zzeli) / 100;
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final long getTotalBytes() {
        if (this.zzelp != null) {
            return getDuration() * this.zzelp.intValue();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int zzabb() {
        if (Build.VERSION.SDK_INT < 26 || !zzaaz()) {
            return -1;
        }
        return this.zzele.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    @Override // com.google.android.gms.internal.ads.zzbbz, com.google.android.gms.internal.ads.zzbcw
    public final void zzabc() {
        zzd(this.zzelx.getVolume());
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzele;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
                return;
            } catch (IllegalStateException unused) {
                return;
            }
        }
        com.google.android.gms.ads.internal.util.zzd.zzez("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() || this.zzekz == null || mediaPlayer == null || Build.VERSION.SDK_INT < 19 || (trackInfo = mediaPlayer.getTrackInfo()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
            if (trackInfo2 != null) {
                int trackType = trackInfo2.getTrackType();
                if (trackType == 1) {
                    MediaFormat format2 = trackInfo2.getFormat();
                    if (format2 != null) {
                        if (format2.containsKey("frame-rate")) {
                            try {
                                hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                            } catch (ClassCastException unused) {
                                hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                            }
                        }
                        if (format2.containsKey("bitrate")) {
                            Integer valueOf = Integer.valueOf(format2.getInteger("bitrate"));
                            this.zzelp = valueOf;
                            hashMap.put("bitRate", String.valueOf(valueOf));
                        }
                        if (format2.containsKey("width") && format2.containsKey("height")) {
                            int integer = format2.getInteger("width");
                            int integer2 = format2.getInteger("height");
                            StringBuilder sb = new StringBuilder(23);
                            sb.append(integer);
                            sb.append("x");
                            sb.append(integer2);
                            hashMap.put(ak.z, sb.toString());
                        }
                        if (format2.containsKey("mime")) {
                            hashMap.put("videoMime", format2.getString("mime"));
                        }
                        if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                            hashMap.put("videoCodec", format2.getString("codecs-string"));
                        }
                    }
                } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                    if (format.containsKey("mime")) {
                        hashMap.put("audioMime", format.getString("mime"));
                    }
                    if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                        hashMap.put("audioCodec", format.getString("codecs-string"));
                    }
                }
            }
        }
        if (hashMap.isEmpty()) {
            return;
        }
        this.zzekz.zza("onMetadataEvent", hashMap);
    }

    private final void zzdo(int i) {
        if (i == 3) {
            this.zzela.zzabs();
            this.zzelx.zzabs();
        } else if (this.zzelc == 3) {
            this.zzela.zzabt();
            this.zzelx.zzabt();
        }
        this.zzelc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdp(int i) {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzeky.put(-1004, "MEDIA_ERROR_IO");
            zzeky.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzeky.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzeky.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzeky.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzeky.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzeky.put(1, "MEDIA_ERROR_UNKNOWN");
        zzeky.put(1, "MEDIA_INFO_UNKNOWN");
        zzeky.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzeky.put(701, "MEDIA_INFO_BUFFERING_START");
        zzeky.put(702, "MEDIA_INFO_BUFFERING_END");
        zzeky.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzeky.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzeky.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzeky.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzeky.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
