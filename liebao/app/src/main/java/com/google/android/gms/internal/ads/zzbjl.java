package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbjl {
    private zza zzfsn;

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static abstract class zza {
        public abstract zzbes zzags();

        public abstract zzbcc zzagt();

        public abstract zzue zzagu();

        public abstract zzaxq zzagv();

        public abstract zzaso zzagw();

        public abstract zzacw zzagx();
    }

    public zzbjl(zza zzaVar) {
        this.zzfsn = zzaVar;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzaxl, com.google.android.gms.internal.ads.zzaxr] */
    public final com.google.android.gms.ads.internal.zzb zzajh() {
        zza zzaVar = this.zzfsn;
        return new com.google.android.gms.ads.internal.zzb(zzaVar.zzags(), zzaVar.zzagt(), new zzaxl(zzaVar.zzagv()), zzaVar.zzagu(), zzaVar.zzagw(), zzaVar.zzagx());
    }

    public final zzaxq zzagv() {
        return this.zzfsn.zzagv();
    }

    public final zzaso zzagw() {
        return this.zzfsn.zzagw();
    }

    public final zzacw zzagx() {
        return this.zzfsn.zzagx();
    }
}
