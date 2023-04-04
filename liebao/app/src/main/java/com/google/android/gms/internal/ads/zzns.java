package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzns extends zzid {
    private static final Object zzbha = new Object();
    private final boolean zzaiu;
    private final boolean zzaiv;
    private final long zzbhb;
    private final long zzbhc;
    private final long zzbhd;
    private final long zzbhe;

    public zzns(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zzfj() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zzfk() {
        return 1;
    }

    private zzns(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbhb = j;
        this.zzbhc = j2;
        this.zzbhd = 0L;
        this.zzbhe = 0L;
        this.zzaiu = z;
        this.zzaiv = false;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final zzie zza(int i, zzie zzieVar, boolean z, long j) {
        zzpg.zzc(i, 0, 1);
        boolean z2 = this.zzaiu;
        long j2 = this.zzbhc;
        zzieVar.zzair = null;
        zzieVar.zzais = -9223372036854775807L;
        zzieVar.zzait = -9223372036854775807L;
        zzieVar.zzaiu = z2;
        zzieVar.zzaiv = false;
        zzieVar.zzaiy = 0L;
        zzieVar.zzaiz = j2;
        zzieVar.zzaiw = 0;
        zzieVar.zzaix = 0;
        zzieVar.zzaja = 0L;
        return zzieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final zzif zza(int i, zzif zzifVar, boolean z) {
        zzpg.zzc(i, 0, 1);
        Object obj = z ? zzbha : null;
        return zzifVar.zza(obj, obj, 0, this.zzbhb, 0L, false);
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int zzc(Object obj) {
        return zzbha.equals(obj) ? 0 : -1;
    }
}
