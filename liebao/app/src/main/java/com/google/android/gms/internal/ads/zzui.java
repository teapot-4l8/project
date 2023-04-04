package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzui {
    private final byte[] zzbyv;
    private int zzbyw;
    private int zzbyx;
    private final /* synthetic */ zzue zzbyy;

    private zzui(zzue zzueVar, byte[] bArr) {
        this.zzbyy = zzueVar;
        this.zzbyv = bArr;
    }

    public final synchronized void log() {
        try {
            if (this.zzbyy.zzbyu) {
                this.zzbyy.zzbyt.zzc(this.zzbyv);
                this.zzbyy.zzbyt.zzt(this.zzbyw);
                this.zzbyy.zzbyt.zzu(this.zzbyx);
                this.zzbyy.zzbyt.zza(null);
                this.zzbyy.zzbyt.log();
            }
        } catch (RemoteException e2) {
            zzbao.zzb("Clearcut log failed", e2);
        }
    }

    public final zzui zzbx(int i) {
        this.zzbyw = i;
        return this;
    }

    public final zzui zzby(int i) {
        this.zzbyx = i;
        return this;
    }
}
