package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqi {
    private final zzqh zzbmy;
    private final boolean zzbmz;
    private final long zzbna;
    private final long zzbnb;
    private long zzbnc;
    private long zzbnd;
    private long zzbne;
    private boolean zzbnf;
    private long zzbng;
    private long zzbnh;
    private long zzbni;

    public zzqi() {
        this(-1.0d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzqi(Context context) {
        this(r3.getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
    }

    private zzqi(double d2) {
        boolean z = d2 != -1.0d;
        this.zzbmz = z;
        if (z) {
            this.zzbmy = zzqh.zzjt();
            long j = (long) (1.0E9d / d2);
            this.zzbna = j;
            this.zzbnb = (j * 80) / 100;
            return;
        }
        this.zzbmy = null;
        this.zzbna = -1L;
        this.zzbnb = -1L;
    }

    public final void enable() {
        this.zzbnf = false;
        if (this.zzbmz) {
            this.zzbmy.zzju();
        }
    }

    public final void disable() {
        if (this.zzbmz) {
            this.zzbmy.removeObserver();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzf(long j, long j2) {
        long j3;
        long j4;
        zzqh zzqhVar;
        long j5;
        long j6 = 1000 * j;
        if (this.zzbnf) {
            if (j != this.zzbnc) {
                this.zzbni++;
                this.zzbnd = this.zzbne;
            }
            long j7 = this.zzbni;
            if (j7 >= 6) {
                j4 = this.zzbnd + ((j6 - this.zzbnh) / j7);
                if (zzg(j4, j2)) {
                    this.zzbnf = false;
                } else {
                    j3 = (this.zzbng + j4) - this.zzbnh;
                    if (!this.zzbnf) {
                        this.zzbnh = j6;
                        this.zzbng = j2;
                        this.zzbni = 0L;
                        this.zzbnf = true;
                    }
                    this.zzbnc = j;
                    this.zzbne = j4;
                    zzqhVar = this.zzbmy;
                    if (zzqhVar != null || zzqhVar.zzbmt == 0) {
                        return j3;
                    }
                    long j8 = this.zzbmy.zzbmt;
                    long j9 = this.zzbna;
                    long j10 = j8 + (((j3 - j8) / j9) * j9);
                    if (j3 <= j10) {
                        j5 = j10 - j9;
                    } else {
                        j10 = j9 + j10;
                        j5 = j10;
                    }
                    if (j10 - j3 >= j3 - j5) {
                        j10 = j5;
                    }
                    return j10 - this.zzbnb;
                }
            } else if (zzg(j6, j2)) {
                this.zzbnf = false;
            }
        }
        j3 = j2;
        j4 = j6;
        if (!this.zzbnf) {
        }
        this.zzbnc = j;
        this.zzbne = j4;
        zzqhVar = this.zzbmy;
        if (zzqhVar != null) {
        }
        return j3;
    }

    private final boolean zzg(long j, long j2) {
        return Math.abs((j2 - this.zzbng) - (j - this.zzbnh)) > 20000000;
    }
}
