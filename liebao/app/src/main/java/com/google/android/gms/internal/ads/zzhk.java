package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzhk implements zzhh {
    private int repeatMode;
    private final zzhy[] zzaex;
    private final zzoh zzaey;
    private final zzoi zzaez;
    private final Handler zzafa;
    private final zzhm zzafb;
    private final CopyOnWriteArraySet<zzhg> zzafc;
    private final zzie zzafd;
    private final zzif zzafe;
    private boolean zzaff;
    private boolean zzafg;
    private int zzafh;
    private int zzafi;
    private int zzafj;
    private boolean zzafk;
    private zzid zzafl;
    private Object zzafm;
    private zznu zzafn;
    private zzoi zzafo;
    private zzhz zzafp;
    private zzho zzafq;
    private int zzafr;
    private int zzafs;
    private long zzaft;

    public zzhk(zzhy[] zzhyVarArr, zzoh zzohVar, zzhx zzhxVar) {
        String str = zzpt.zzbkx;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzpg.checkState(zzhyVarArr.length > 0);
        this.zzaex = (zzhy[]) zzpg.checkNotNull(zzhyVarArr);
        this.zzaey = (zzoh) zzpg.checkNotNull(zzohVar);
        this.zzafg = false;
        this.repeatMode = 0;
        this.zzafh = 1;
        this.zzafc = new CopyOnWriteArraySet<>();
        this.zzaez = new zzoi(new zzog[zzhyVarArr.length]);
        this.zzafl = zzid.zzaiq;
        this.zzafd = new zzie();
        this.zzafe = new zzif();
        this.zzafn = zznu.zzbhf;
        this.zzafo = this.zzaez;
        this.zzafp = zzhz.zzaik;
        this.zzafa = new zzhn(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        zzho zzhoVar = new zzho(0, 0L);
        this.zzafq = zzhoVar;
        this.zzafb = new zzhm(zzhyVarArr, zzohVar, zzhxVar, this.zzafg, 0, this.zzafa, zzhoVar, this);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(zzhg zzhgVar) {
        this.zzafc.add(zzhgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzb(zzhg zzhgVar) {
        this.zzafc.remove(zzhgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final int getPlaybackState() {
        return this.zzafh;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(zzne zzneVar) {
        if (!this.zzafl.isEmpty() || this.zzafm != null) {
            this.zzafl = zzid.zzaiq;
            this.zzafm = null;
            Iterator<zzhg> it = this.zzafc.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzafl, this.zzafm);
            }
        }
        if (this.zzaff) {
            this.zzaff = false;
            this.zzafn = zznu.zzbhf;
            this.zzafo = this.zzaez;
            this.zzaey.zzd(null);
            Iterator<zzhg> it2 = this.zzafc.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzafn, this.zzafo);
            }
        }
        this.zzafj++;
        this.zzafb.zza(zzneVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzh(boolean z) {
        if (this.zzafg != z) {
            this.zzafg = z;
            this.zzafb.zzh(z);
            Iterator<zzhg> it = this.zzafc.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzafh);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final boolean zzeo() {
        return this.zzafg;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void seekTo(long j) {
        int zzes = zzes();
        if (zzes < 0 || (!this.zzafl.isEmpty() && zzes >= this.zzafl.zzfj())) {
            throw new zzhu(this.zzafl, zzes, j);
        }
        this.zzafi++;
        this.zzafr = zzes;
        if (!this.zzafl.isEmpty()) {
            this.zzafl.zza(zzes, this.zzafd, false);
            long zzdp = (j == -9223372036854775807L ? 0L : zzhf.zzdp(j)) + 0;
            long j2 = this.zzafl.zza(0, this.zzafe, false).zzaiz;
            if (j2 != -9223372036854775807L) {
                int i = (zzdp > j2 ? 1 : (zzdp == j2 ? 0 : -1));
            }
        }
        this.zzafs = 0;
        if (j == -9223372036854775807L) {
            this.zzaft = 0L;
            this.zzafb.zza(this.zzafl, zzes, -9223372036854775807L);
            return;
        }
        this.zzaft = j;
        this.zzafb.zza(this.zzafl, zzes, zzhf.zzdp(j));
        Iterator<zzhg> it = this.zzafc.iterator();
        while (it.hasNext()) {
            it.next().zzen();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void stop() {
        this.zzafb.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void release() {
        this.zzafb.release();
        this.zzafa.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zza(zzhi... zzhiVarArr) {
        this.zzafb.zza(zzhiVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzb(zzhi... zzhiVarArr) {
        this.zzafb.zzb(zzhiVarArr);
    }

    private final int zzes() {
        if (this.zzafl.isEmpty() || this.zzafi > 0) {
            return this.zzafr;
        }
        this.zzafl.zza(this.zzafq.zzags, this.zzafe, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final long getDuration() {
        if (this.zzafl.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzhf.zzdo(this.zzafl.zza(zzes(), this.zzafd, false).zzaiz);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final long zzeq() {
        if (this.zzafl.isEmpty() || this.zzafi > 0) {
            return this.zzaft;
        }
        this.zzafl.zza(this.zzafq.zzags, this.zzafe, false);
        return this.zzafe.zzfl() + zzhf.zzdo(this.zzafq.zzagu);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final long getBufferedPosition() {
        if (this.zzafl.isEmpty() || this.zzafi > 0) {
            return this.zzaft;
        }
        this.zzafl.zza(this.zzafq.zzags, this.zzafe, false);
        return this.zzafe.zzfl() + zzhf.zzdo(this.zzafq.zzagv);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final int zzep() {
        return this.zzaex.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzer() {
        this.zzafb.zzer();
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzv(int i) {
        this.zzafb.zzv(i);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void zzw(int i) {
        this.zzafb.zzw(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Message message) {
        switch (message.what) {
            case 0:
                this.zzafj--;
                return;
            case 1:
                this.zzafh = message.arg1;
                Iterator<zzhg> it = this.zzafc.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzafg, this.zzafh);
                }
                return;
            case 2:
                this.zzafk = message.arg1 != 0;
                Iterator<zzhg> it2 = this.zzafc.iterator();
                while (it2.hasNext()) {
                    it2.next().zzg(this.zzafk);
                }
                return;
            case 3:
                if (this.zzafj == 0) {
                    zzoj zzojVar = (zzoj) message.obj;
                    this.zzaff = true;
                    this.zzafn = zzojVar.zzbih;
                    this.zzafo = zzojVar.zzbii;
                    this.zzaey.zzd(zzojVar.zzbij);
                    Iterator<zzhg> it3 = this.zzafc.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzafn, this.zzafo);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzafi - 1;
                this.zzafi = i;
                if (i == 0) {
                    this.zzafq = (zzho) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhg> it4 = this.zzafc.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzen();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzafi == 0) {
                    this.zzafq = (zzho) message.obj;
                    Iterator<zzhg> it5 = this.zzafc.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzen();
                    }
                    return;
                }
                return;
            case 6:
                zzhq zzhqVar = (zzhq) message.obj;
                this.zzafi -= zzhqVar.zzahh;
                if (this.zzafj == 0) {
                    this.zzafl = zzhqVar.zzafl;
                    this.zzafm = zzhqVar.zzafm;
                    this.zzafq = zzhqVar.zzafq;
                    Iterator<zzhg> it6 = this.zzafc.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzafl, this.zzafm);
                    }
                    return;
                }
                return;
            case 7:
                zzhz zzhzVar = (zzhz) message.obj;
                if (this.zzafp.equals(zzhzVar)) {
                    return;
                }
                this.zzafp = zzhzVar;
                Iterator<zzhg> it7 = this.zzafc.iterator();
                while (it7.hasNext()) {
                    it7.next().zza(zzhzVar);
                }
                return;
            case 8:
                zzhe zzheVar = (zzhe) message.obj;
                Iterator<zzhg> it8 = this.zzafc.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzheVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
