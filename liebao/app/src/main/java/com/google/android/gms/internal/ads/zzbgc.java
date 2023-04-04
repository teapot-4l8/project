package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbgc extends zzzg {
    private boolean zzaef;
    private boolean zzaeg;
    private int zzafh;
    private zzzi zzdor;
    private final zzbcs zzekz;
    private final boolean zzewf;
    private final boolean zzewg;
    private boolean zzewh;
    private float zzewj;
    private float zzewk;
    private float zzewl;
    private zzage zzewm;
    private final Object lock = new Object();
    private boolean zzewi = true;

    public zzbgc(zzbcs zzbcsVar, float f, boolean z, boolean z2) {
        this.zzekz = zzbcsVar;
        this.zzewj = f;
        this.zzewf = z;
        this.zzewg = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void play() {
        zze("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void pause() {
        zze("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void stop() {
        zze("stop", null);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void mute(boolean z) {
        zze(z ? "mute" : "unmute", null);
    }

    public final void zzb(zzaaz zzaazVar) {
        boolean z = zzaazVar.zzaee;
        boolean z2 = zzaazVar.zzaef;
        boolean z3 = zzaazVar.zzaeg;
        synchronized (this.lock) {
            this.zzaef = z2;
            this.zzaeg = z3;
        }
        zze("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    private final void zze(String str, Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbat.zzeki.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.zzbgb
            private final Map zzeds;
            private final zzbgc zzewe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzewe = this;
                this.zzeds = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzewe.zzl(this.zzeds);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzewi;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzafh;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzewl;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getDuration() {
        float f;
        synchronized (this.lock) {
            f = this.zzewj;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final float getCurrentTime() {
        float f;
        synchronized (this.lock) {
            f = this.zzewk;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zza(zzzi zzziVar) {
        synchronized (this.lock) {
            this.zzdor = zzziVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzzi zzrm() {
        zzzi zzziVar;
        synchronized (this.lock) {
            zzziVar = this.zzdor;
        }
        return zzziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzewf && this.zzaef;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    z = (this.zzaeg && this.zzewg) ? true : true;
                } finally {
                }
            }
            z = false;
        }
        return z;
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzewk = f;
        }
    }

    public final void zzafe() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzewi;
            i = this.zzafh;
            this.zzafh = 3;
        }
        zza(i, 3, z, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f A[Catch: all -> 0x004f, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:11:0x0013, B:13:0x002f, B:14:0x0038), top: B:29:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        float f4;
        synchronized (this.lock) {
            if (f2 == this.zzewj && f3 == this.zzewl) {
                z2 = false;
                this.zzewj = f2;
                this.zzewk = f;
                z3 = this.zzewi;
                this.zzewi = z;
                i2 = this.zzafh;
                this.zzafh = i;
                f4 = this.zzewl;
                this.zzewl = f3;
                if (Math.abs(f3 - f4) > 1.0E-4f) {
                    this.zzekz.getView().invalidate();
                }
            }
            z2 = true;
            this.zzewj = f2;
            this.zzewk = f;
            z3 = this.zzewi;
            this.zzewi = z;
            i2 = this.zzafh;
            this.zzafh = i;
            f4 = this.zzewl;
            this.zzewl = f3;
            if (Math.abs(f3 - f4) > 1.0E-4f) {
            }
        }
        if (z2) {
            try {
                if (this.zzewm != null) {
                    this.zzewm.zzuc();
                }
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
        zza(i2, i, z3, z);
    }

    public final void zza(zzage zzageVar) {
        synchronized (this.lock) {
            this.zzewm = zzageVar;
        }
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzbat.zzeki.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.zzbge
            private final int zzehh;
            private final int zzehi;
            private final boolean zzeua;
            private final boolean zzeub;
            private final zzbgc zzewe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzewe = this;
                this.zzehh = i;
                this.zzehi = i2;
                this.zzeua = z;
                this.zzeub = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzewe.zzb(this.zzehh, this.zzehi, this.zzeua, this.zzeub);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.zzewh && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            this.zzewh = (this.zzewh || z5) ? true : true;
            if (z5) {
                try {
                    if (this.zzdor != null) {
                        this.zzdor.onVideoStart();
                    }
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
            if (z6 && this.zzdor != null) {
                this.zzdor.onVideoPlay();
            }
            if (z7 && this.zzdor != null) {
                this.zzdor.onVideoPause();
            }
            if (z8) {
                if (this.zzdor != null) {
                    this.zzdor.onVideoEnd();
                }
                this.zzekz.zzacf();
            }
            if (z9 && this.zzdor != null) {
                this.zzdor.onVideoMute(z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(Map map) {
        this.zzekz.zza("pubVideoCmd", map);
    }
}
