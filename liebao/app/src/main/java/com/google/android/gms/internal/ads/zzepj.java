package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzepj extends InputStream {
    private int mark;
    private final /* synthetic */ zzepf zziww;
    private zzepg zzixg;
    private zzelx zzixh;
    private int zzixi;
    private int zzixj;
    private int zzixk;

    public zzepj(zzepf zzepfVar) {
        this.zziww = zzepfVar;
        initialize();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw null;
        }
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int zzl = zzl(bArr, i, i2);
        if (zzl == 0) {
            if (i2 > 0 || zzblj() == 0) {
                return -1;
            }
            return zzl;
        }
        return zzl;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return zzl(null, 0, (int) j);
    }

    private final int zzl(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            zzbli();
            if (this.zzixh == null) {
                break;
            }
            int min = Math.min(this.zzixi - this.zzixj, i3);
            if (bArr != null) {
                this.zzixh.zza(bArr, this.zzixj, i, min);
                i += min;
            }
            this.zzixj += min;
            i3 -= min;
        }
        return i2 - i3;
    }

    @Override // java.io.InputStream
    public final int read() {
        zzbli();
        zzelx zzelxVar = this.zzixh;
        if (zzelxVar == null) {
            return -1;
        }
        int i = this.zzixj;
        this.zzixj = i + 1;
        return zzelxVar.zzgh(i) & 255;
    }

    @Override // java.io.InputStream
    public final int available() {
        return zzblj();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.mark = this.zzixk + this.zzixj;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        initialize();
        zzl(null, 0, this.mark);
    }

    private final void initialize() {
        zzepg zzepgVar = new zzepg(this.zziww, null);
        this.zzixg = zzepgVar;
        zzelx zzelxVar = (zzelx) zzepgVar.next();
        this.zzixh = zzelxVar;
        this.zzixi = zzelxVar.size();
        this.zzixj = 0;
        this.zzixk = 0;
    }

    private final void zzbli() {
        if (this.zzixh != null) {
            int i = this.zzixj;
            int i2 = this.zzixi;
            if (i == i2) {
                this.zzixk += i2;
                this.zzixj = 0;
                if (this.zzixg.hasNext()) {
                    zzelx zzelxVar = (zzelx) this.zzixg.next();
                    this.zzixh = zzelxVar;
                    this.zzixi = zzelxVar.size();
                    return;
                }
                this.zzixh = null;
                this.zzixi = 0;
            }
        }
    }

    private final int zzblj() {
        return this.zziww.size() - (this.zzixk + this.zzixj);
    }
}
