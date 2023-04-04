package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbcv extends zzbbz implements TextureView.SurfaceTextureListener, zzbdx {
    private Surface zzblw;
    private final zzbcs zzekz;
    private final zzbcr zzela;
    private final boolean zzelb;
    private int zzelg;
    private int zzelh;
    private int zzelj;
    private int zzelk;
    private zzbcq zzell;
    private final boolean zzelm;
    private zzbca zzelo;
    private String[] zzemk;
    private final zzbcp zzepi;
    private zzbdn zzepj;
    private String zzepk;
    private boolean zzepl;
    private int zzepm;
    private boolean zzepn;
    private boolean zzepo;
    private float zzepp;

    public zzbcv(Context context, zzbcr zzbcrVar, zzbcs zzbcsVar, boolean z, boolean z2, zzbcp zzbcpVar) {
        super(context);
        this.zzepm = 1;
        this.zzelb = z2;
        this.zzekz = zzbcsVar;
        this.zzela = zzbcrVar;
        this.zzelm = z;
        this.zzepi = zzbcpVar;
        setSurfaceTextureListener(this);
        this.zzela.zzb(this);
    }

    private final zzbdn zzack() {
        return new zzbdn(this.zzekz.getContext(), this.zzepi, this.zzekz);
    }

    private final String zzacl() {
        return com.google.android.gms.ads.internal.zzr.zzkv().zzq(this.zzekz.getContext(), this.zzekz.zzacc().zzbrz);
    }

    private final boolean zzacm() {
        zzbdn zzbdnVar = this.zzepj;
        return (zzbdnVar == null || zzbdnVar.zzadd() == null || this.zzepl) ? false : true;
    }

    private final boolean zzacn() {
        return zzacm() && this.zzepm != 1;
    }

    private final void zzaco() {
        String str;
        if (this.zzepj != null || (str = this.zzepk) == null || this.zzblw == null) {
            return;
        }
        if (str.startsWith("cache:")) {
            zzbek zzfe = this.zzekz.zzfe(this.zzepk);
            if (zzfe instanceof zzbev) {
                zzbdn zzadi = ((zzbev) zzfe).zzadi();
                this.zzepj = zzadi;
                if (zzadi.zzadd() == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("Precached video player has been released.");
                    return;
                }
            } else if (zzfe instanceof zzbew) {
                zzbew zzbewVar = (zzbew) zzfe;
                String zzacl = zzacl();
                ByteBuffer byteBuffer = zzbewVar.getByteBuffer();
                boolean zzadj = zzbewVar.zzadj();
                String url = zzbewVar.getUrl();
                if (url == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzez("Stream cache URL is null.");
                    return;
                }
                zzbdn zzack = zzack();
                this.zzepj = zzack;
                zzack.zza(new Uri[]{Uri.parse(url)}, zzacl, byteBuffer, zzadj);
            } else {
                String valueOf = String.valueOf(this.zzepk);
                com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                return;
            }
        } else {
            this.zzepj = zzack();
            String zzacl2 = zzacl();
            Uri[] uriArr = new Uri[this.zzemk.length];
            int i = 0;
            while (true) {
                String[] strArr = this.zzemk;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.zzepj.zza(uriArr, zzacl2);
        }
        this.zzepj.zza(this);
        zza(this.zzblw, false);
        if (this.zzepj.zzadd() != null) {
            int playbackState = this.zzepj.zzadd().getPlaybackState();
            this.zzepm = playbackState;
            if (playbackState == 3) {
                zzacp();
            }
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zza(surface, z);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("Trying to set surface before player is initalized.");
        }
    }

    private final void zza(float f, boolean z) {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzb(f, z);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz, com.google.android.gms.internal.ads.zzbcw
    public final void zzabc() {
        zza(this.zzelx.getVolume(), false);
    }

    private final void zzacp() {
        if (this.zzepn) {
            return;
        }
        this.zzepn = true;
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbcy
            private final zzbcv zzepq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepq.zzacy();
            }
        });
        zzabc();
        this.zzela.zzff();
        if (this.zzepo) {
            play();
        }
    }

    private static String zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final String zzaaw() {
        String str = this.zzelm ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zza(zzbca zzbcaVar) {
        this.zzelo = zzbcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzepk = str;
            this.zzemk = new String[]{str};
            zzaco();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzepk = str;
            this.zzemk = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzaco();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void play() {
        if (zzacn()) {
            if (this.zzepi.zzenh) {
                zzacr();
            }
            this.zzepj.zzadd().zzh(true);
            this.zzela.zzabs();
            this.zzelx.zzabs();
            this.zzelw.zzabe();
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdc
                private final zzbcv zzepq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzepq = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzepq.zzacw();
                }
            });
            return;
        }
        this.zzepo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void stop() {
        if (zzacm()) {
            this.zzepj.zzadd().stop();
            if (this.zzepj != null) {
                zza((Surface) null, true);
                zzbdn zzbdnVar = this.zzepj;
                if (zzbdnVar != null) {
                    zzbdnVar.zza((zzbdx) null);
                    this.zzepj.release();
                    this.zzepj = null;
                }
                this.zzepm = 1;
                this.zzepl = false;
                this.zzepn = false;
                this.zzepo = false;
            }
        }
        this.zzela.zzabt();
        this.zzelx.zzabt();
        this.zzela.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void pause() {
        if (zzacn()) {
            if (this.zzepi.zzenh) {
                zzacs();
            }
            this.zzepj.zzadd().zzh(false);
            this.zzela.zzabt();
            this.zzelx.zzabt();
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdb
                private final zzbcv zzepq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzepq = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzepq.zzacv();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void seekTo(int i) {
        if (zzacn()) {
            this.zzepj.zzadd().seekTo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zzdq(int i) {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzadg().zzea(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zzdr(int i) {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzadg().zzeb(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zzds(int i) {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzadg().zzds(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zzdt(int i) {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzadg().zzdt(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zzdu(int i) {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzdu(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final void zza(float f, float f2) {
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getCurrentPosition() {
        if (zzacn()) {
            return (int) this.zzepj.zzadd().zzeq();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getDuration() {
        if (zzacn()) {
            return (int) this.zzepj.zzadd().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getVideoWidth() {
        return this.zzelg;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int getVideoHeight() {
        return this.zzelh;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final long zzaba() {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            return zzbdnVar.zzaba();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final long zznh() {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            return zzbdnVar.zznh();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final long getTotalBytes() {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            return zzbdnVar.getTotalBytes();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbbz
    public final int zzabb() {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            return zzbdnVar.zzabb();
        }
        return -1;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzepp;
        if (f != 0.0f && this.zzell == null) {
            float f2 = measuredWidth;
            float f3 = f2 / measuredHeight;
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            float f4 = this.zzepp;
            if (f4 < f3) {
                measuredWidth = (int) (measuredHeight * f4);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzo(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i4 = this.zzelj;
            if (((i4 > 0 && i4 != measuredWidth) || ((i3 = this.zzelk) > 0 && i3 != measuredHeight)) && this.zzelb && zzacm()) {
                zzhh zzadd = this.zzepj.zzadd();
                if (zzadd.zzeq() > 0 && !zzadd.zzeo()) {
                    zza(0.0f, true);
                    zzadd.zzh(true);
                    long zzeq = zzadd.zzeq();
                    long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
                    while (zzacm() && zzadd.zzeq() == zzeq && com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis() - currentTimeMillis <= 250) {
                    }
                    zzadd.zzh(false);
                    zzabc();
                }
            }
            this.zzelj = measuredWidth;
            this.zzelk = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzelm) {
            zzbcq zzbcqVar = new zzbcq(getContext());
            this.zzell = zzbcqVar;
            zzbcqVar.zza(surfaceTexture, i, i2);
            this.zzell.start();
            SurfaceTexture zzabq = this.zzell.zzabq();
            if (zzabq != null) {
                surfaceTexture = zzabq;
            } else {
                this.zzell.zzabp();
                this.zzell = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzblw = surface;
        if (this.zzepj == null) {
            zzaco();
        } else {
            zza(surface, true);
            if (!this.zzepi.zzenh) {
                zzacr();
            }
        }
        if (this.zzelg == 0 || this.zzelh == 0) {
            zzq(i, i2);
        } else {
            zzacq();
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbde
            private final zzbcv zzepq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepq.zzacu();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzo(i, i2);
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.zzbdd
            private final int zzehh;
            private final int zzehi;
            private final zzbcv zzepq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepq = this;
                this.zzehh = i;
                this.zzehi = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepq.zzr(this.zzehh, this.zzehi);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzela.zzc(this);
        this.zzelw.zza(surfaceTexture, this.zzelo);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbcq zzbcqVar = this.zzell;
        if (zzbcqVar != null) {
            zzbcqVar.zzabp();
            this.zzell = null;
        }
        if (this.zzepj != null) {
            zzacs();
            Surface surface = this.zzblw;
            if (surface != null) {
                surface.release();
            }
            this.zzblw = null;
            zza((Surface) null, true);
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdg
            private final zzbcv zzepq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepq.zzact();
            }
        });
        return true;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzbdf
            private final int zzehh;
            private final zzbcv zzepq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepq = this;
                this.zzehh = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepq.zzdz(this.zzehh);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzb(boolean z, long j) {
        if (this.zzekz != null) {
            zzbat.zzeki.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.zzbdi
                private final boolean zzemp;
                private final zzbcv zzepq;
                private final long zzepu;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzepq = this;
                    this.zzemp = z;
                    this.zzepu = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzepq.zzc(this.zzemp, this.zzepu);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzdy(int i) {
        if (this.zzepm != i) {
            this.zzepm = i;
            if (i == 3) {
                zzacp();
            } else if (i != 4) {
            } else {
                if (this.zzepi.zzenh) {
                    zzacs();
                }
                this.zzela.zzabt();
                this.zzelx.zzabt();
                com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbcx
                    private final zzbcv zzepq;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzepq = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzepq.zzacx();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzp(int i, int i2) {
        this.zzelg = i;
        this.zzelh = i2;
        zzacq();
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzb(String str, Exception exc) {
        String zza = zza(str, exc);
        String valueOf = String.valueOf(zza);
        com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzepl = true;
        if (this.zzepi.zzenh) {
            zzacs();
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, zza) { // from class: com.google.android.gms.internal.ads.zzbcz
            private final String zzdkl;
            private final zzbcv zzepq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepq = this;
                this.zzdkl = zza;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepq.zzfg(this.zzdkl);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzc(String str, Exception exc) {
        String zza = zza(str, exc);
        String valueOf = String.valueOf(zza);
        com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "ExoPlayerAdapter exception: ".concat(valueOf) : new String("ExoPlayerAdapter exception: "));
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, zza) { // from class: com.google.android.gms.internal.ads.zzbda
            private final String zzdkl;
            private final zzbcv zzepq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepq = this;
                this.zzdkl = zza;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepq.zzff(this.zzdkl);
            }
        });
    }

    private final void zzacq() {
        zzq(this.zzelg, this.zzelh);
    }

    private final void zzq(int i, int i2) {
        float f = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzepp != f) {
            this.zzepp = f;
            requestLayout();
        }
    }

    private final void zzacr() {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzba(true);
        }
    }

    private final void zzacs() {
        zzbdn zzbdnVar = this.zzepj;
        if (zzbdnVar != null) {
            zzbdnVar.zzba(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzff(String str) {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzm("ExoPlayerAdapter exception", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzekz.zza(z, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdz(int i) {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.onWindowVisibilityChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzact() {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzabg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(int i, int i2) {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzm(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacu() {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzabd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacv() {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.onPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacw() {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzabe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzfg(String str) {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzl("ExoPlayerAdapter error", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacx() {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzabf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacy() {
        zzbca zzbcaVar = this.zzelo;
        if (zzbcaVar != null) {
            zzbcaVar.zzff();
        }
    }
}
