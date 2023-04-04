package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzms implements zzkc, zznc, zzno, zzoz<zzmv> {
    private final Uri uri;
    private final Handler zzafa;
    private boolean zzagd;
    private boolean zzahc;
    private long zzaiz;
    private final zzon zzaoz;
    private final int zzbdw;
    private final zzmz zzbdx;
    private final zznd zzbdy;
    private final zzol zzbdz;
    private final long zzbeb;
    private final zzmy zzbed;
    private zznb zzbei;
    private zzkf zzbej;
    private boolean zzbek;
    private boolean zzbel;
    private boolean zzbem;
    private int zzben;
    private zznu zzbeo;
    private boolean[] zzbep;
    private boolean[] zzbeq;
    private boolean zzber;
    private long zzbes;
    private int zzbeu;
    private boolean zzbev;
    private final String zzbea = null;
    private final zzpa zzbec = new zzpa("Loader:ExtractorMediaPeriod");
    private final zzpi zzbee = new zzpi();
    private final Runnable zzbef = new zzmr(this);
    private final Runnable zzbeg = new zzmu(this);
    private final Handler handler = new Handler();
    private long zzbet = -9223372036854775807L;
    private final SparseArray<zznm> zzbeh = new SparseArray<>();
    private long zzco = -1;

    public zzms(Uri uri, zzon zzonVar, zzka[] zzkaVarArr, int i, Handler handler, zzmz zzmzVar, zznd zzndVar, zzol zzolVar, String str, int i2) {
        this.uri = uri;
        this.zzaoz = zzonVar;
        this.zzbdw = i;
        this.zzafa = handler;
        this.zzbdx = zzmzVar;
        this.zzbdy = zzndVar;
        this.zzbdz = zzolVar;
        this.zzbeb = i2;
        this.zzbed = new zzmy(zzkaVarArr, this);
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzef(long j) {
    }

    public final void release() {
        this.zzbec.zza(new zzmt(this, this.zzbed));
        this.handler.removeCallbacksAndMessages(null);
        this.zzagd = true;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zza(zznb zznbVar, long j) {
        this.zzbei = zznbVar;
        this.zzbee.open();
        startLoading();
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzhs() {
        this.zzbec.zzbj(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final zznu zzht() {
        return this.zzbeo;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zza(zzog[] zzogVarArr, boolean[] zArr, zznn[] zznnVarArr, boolean[] zArr2, long j) {
        int i;
        zzpg.checkState(this.zzahc);
        for (int i2 = 0; i2 < zzogVarArr.length; i2++) {
            if (zznnVarArr[i2] != null && (zzogVarArr[i2] == null || !zArr[i2])) {
                i = ((zzmx) zznnVarArr[i2]).track;
                zzpg.checkState(this.zzbep[i]);
                this.zzben--;
                this.zzbep[i] = false;
                this.zzbeh.valueAt(i).disable();
                zznnVarArr[i2] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzogVarArr.length; i3++) {
            if (zznnVarArr[i3] == null && zzogVarArr[i3] != null) {
                zzog zzogVar = zzogVarArr[i3];
                zzpg.checkState(zzogVar.length() == 1);
                zzpg.checkState(zzogVar.zzbg(0) == 0);
                int zza = this.zzbeo.zza(zzogVar.zzip());
                zzpg.checkState(!this.zzbep[zza]);
                this.zzben++;
                this.zzbep[zza] = true;
                zznnVarArr[i3] = new zzmx(this, zza);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.zzbel) {
            int size = this.zzbeh.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.zzbep[i4]) {
                    this.zzbeh.valueAt(i4).disable();
                }
            }
        }
        if (this.zzben == 0) {
            this.zzbem = false;
            if (this.zzbec.isLoading()) {
                this.zzbec.zzix();
            }
        } else if (!this.zzbel ? j != 0 : z) {
            j = zzeg(j);
            for (int i5 = 0; i5 < zznnVarArr.length; i5++) {
                if (zznnVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.zzbel = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final boolean zzee(long j) {
        if (this.zzbev) {
            return false;
        }
        if (this.zzahc && this.zzben == 0) {
            return false;
        }
        boolean open = this.zzbee.open();
        if (this.zzbec.isLoading()) {
            return open;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final long zzhr() {
        if (this.zzben == 0) {
            return Long.MIN_VALUE;
        }
        return zzhv();
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhu() {
        if (this.zzbem) {
            this.zzbem = false;
            return this.zzbes;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhv() {
        long zzhz;
        if (this.zzbev) {
            return Long.MIN_VALUE;
        }
        if (zzia()) {
            return this.zzbet;
        }
        if (this.zzber) {
            zzhz = Long.MAX_VALUE;
            int size = this.zzbeh.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbeq[i]) {
                    zzhz = Math.min(zzhz, this.zzbeh.valueAt(i).zzhz());
                }
            }
        } else {
            zzhz = zzhz();
        }
        return zzhz == Long.MIN_VALUE ? this.zzbes : zzhz;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzeg(long j) {
        if (!this.zzbej.isSeekable()) {
            j = 0;
        }
        this.zzbes = j;
        int size = this.zzbeh.size();
        boolean z = !zzia();
        for (int i = 0; z && i < size; i++) {
            if (this.zzbep[i]) {
                z = this.zzbeh.valueAt(i).zze(j, false);
            }
        }
        if (!z) {
            this.zzbet = j;
            this.zzbev = false;
            if (this.zzbec.isLoading()) {
                this.zzbec.zzix();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbeh.valueAt(i2).zzl(this.zzbep[i2]);
                }
            }
        }
        this.zzbem = false;
        return j;
    }

    public final boolean zzbc(int i) {
        if (this.zzbev) {
            return true;
        }
        return !zzia() && this.zzbeh.valueAt(i).zzii();
    }

    public final void zzhw() {
        this.zzbec.zzbj(Integer.MIN_VALUE);
    }

    public final int zza(int i, zzhv zzhvVar, zzjp zzjpVar, boolean z) {
        if (this.zzbem || zzia()) {
            return -3;
        }
        return this.zzbeh.valueAt(i).zza(zzhvVar, zzjpVar, z, this.zzbev, this.zzbes);
    }

    public final void zze(int i, long j) {
        zznm valueAt = this.zzbeh.valueAt(i);
        if (this.zzbev && j > valueAt.zzhz()) {
            valueAt.zzim();
        } else {
            valueAt.zze(j, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final zzkh zze(int i, int i2) {
        zznm zznmVar = this.zzbeh.get(i);
        if (zznmVar == null) {
            zznm zznmVar2 = new zznm(this.zzbdz);
            zznmVar2.zza(this);
            this.zzbeh.put(i, zznmVar2);
            return zznmVar2;
        }
        return zznmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void zzgw() {
        this.zzbek = true;
        this.handler.post(this.zzbef);
    }

    @Override // com.google.android.gms.internal.ads.zzkc
    public final void zza(zzkf zzkfVar) {
        this.zzbej = zzkfVar;
        this.handler.post(this.zzbef);
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final void zzf(zzht zzhtVar) {
        this.handler.post(this.zzbef);
    }

    public final void zzhx() {
        if (this.zzagd || this.zzahc || this.zzbej == null || !this.zzbek) {
            return;
        }
        int size = this.zzbeh.size();
        for (int i = 0; i < size; i++) {
            if (this.zzbeh.valueAt(i).zzij() == null) {
                return;
            }
        }
        this.zzbee.zziy();
        zznr[] zznrVarArr = new zznr[size];
        this.zzbeq = new boolean[size];
        this.zzbep = new boolean[size];
        this.zzaiz = this.zzbej.getDurationUs();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < size) {
                zzht zzij = this.zzbeh.valueAt(i2).zzij();
                zznrVarArr[i2] = new zznr(zzij);
                String str = zzij.zzaho;
                if (!zzpj.zzbd(str) && !zzpj.zzbc(str)) {
                    z = false;
                }
                this.zzbeq[i2] = z;
                this.zzber = z | this.zzber;
                i2++;
            } else {
                this.zzbeo = new zznu(zznrVarArr);
                this.zzahc = true;
                this.zzbdy.zzb(new zzns(this.zzaiz, this.zzbej.isSeekable()), null);
                this.zzbei.zza((zznc) this);
                return;
            }
        }
    }

    private final void zza(zzmv zzmvVar) {
        long j;
        if (this.zzco == -1) {
            j = zzmvVar.zzco;
            this.zzco = j;
        }
    }

    private final void startLoading() {
        zzkf zzkfVar;
        zzmv zzmvVar = new zzmv(this, this.uri, this.zzaoz, this.zzbed, this.zzbee);
        if (this.zzahc) {
            zzpg.checkState(zzia());
            long j = this.zzaiz;
            if (j != -9223372036854775807L && this.zzbet >= j) {
                this.zzbev = true;
                this.zzbet = -9223372036854775807L;
                return;
            }
            zzmvVar.zze(this.zzbej.zzdz(this.zzbet), this.zzbet);
            this.zzbet = -9223372036854775807L;
        }
        this.zzbeu = zzhy();
        int i = this.zzbdw;
        if (i == -1) {
            i = (this.zzahc && this.zzco == -1 && ((zzkfVar = this.zzbej) == null || zzkfVar.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.zzbec.zza(zzmvVar, this, i);
    }

    private final int zzhy() {
        int size = this.zzbeh.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzbeh.valueAt(i2).zzih();
        }
        return i;
    }

    private final long zzhz() {
        int size = this.zzbeh.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzbeh.valueAt(i).zzhz());
        }
        return j;
    }

    private final boolean zzia() {
        return this.zzbet != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ int zza(zzmv zzmvVar, long j, long j2, IOException iOException) {
        zzkf zzkfVar;
        zzmv zzmvVar2 = zzmvVar;
        zza(zzmvVar2);
        Handler handler = this.zzafa;
        if (handler != null && this.zzbdx != null) {
            handler.post(new zzmw(this, iOException));
        }
        if (iOException instanceof zznt) {
            return 3;
        }
        boolean z = zzhy() > this.zzbeu;
        if (this.zzco == -1 && ((zzkfVar = this.zzbej) == null || zzkfVar.getDurationUs() == -9223372036854775807L)) {
            this.zzbes = 0L;
            this.zzbem = this.zzahc;
            int size = this.zzbeh.size();
            for (int i = 0; i < size; i++) {
                this.zzbeh.valueAt(i).zzl(!this.zzahc || this.zzbep[i]);
            }
            zzmvVar2.zze(0L, 0L);
        }
        this.zzbeu = zzhy();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ void zza(zzmv zzmvVar, long j, long j2, boolean z) {
        zza(zzmvVar);
        if (z || this.zzben <= 0) {
            return;
        }
        int size = this.zzbeh.size();
        for (int i = 0; i < size; i++) {
            this.zzbeh.valueAt(i).zzl(this.zzbep[i]);
        }
        this.zzbei.zza((zznb) this);
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final /* synthetic */ void zza(zzmv zzmvVar, long j, long j2) {
        zza(zzmvVar);
        this.zzbev = true;
        if (this.zzaiz == -9223372036854775807L) {
            long zzhz = zzhz();
            long j3 = zzhz == Long.MIN_VALUE ? 0L : zzhz + 10000;
            this.zzaiz = j3;
            this.zzbdy.zzb(new zzns(j3, this.zzbej.isSeekable()), null);
        }
        this.zzbei.zza((zznb) this);
    }
}
